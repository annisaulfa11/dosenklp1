package com.example.dosenklp1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dosenklp1.databinding.ActivityLoginBinding;
import com.example.dosenklp1.models.LoginResponse;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    String email, password;
    EditText editEmail, editPassword;
    Button login;
    Config config;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        editEmail = findViewById(R.id.email);
        editPassword = findViewById(R.id.password);
    }

    public void login(View view) {
        email = binding.email.getText().toString();
        password = editPassword.getText().toString();

        if(validation(email, password).equals(1)){
            Config config = new Config();
            Call<LoginResponse> call = config.configRetrofit().login(email, password);
            call.enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                    String message = null;
                    JSONObject jsonObject = null;
                    LoginResponse loginResponse = response.body();
                    if (loginResponse.getStatus() != ""){
                        String token = loginResponse.getAuthorisation().getToken();
                        String name = loginResponse.getUser().getName();
                        String username = loginResponse.getUser().getUsername();
                        String eml = loginResponse.getUser().getEmail();

                        Log.i("success", token);
                        SharedPreferences sharedPreferences = getSharedPreferences("com.example.dosenklp1.SHARED_KEY", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("token", token);
                        editor.putString("name", name);
                        editor.putString("email", eml);
                        editor.putString("username", username);

                        Log.d("email", eml);
                        editor.apply();
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.putExtra("logx", true);
                        startActivity(intent);
                    } else{
                        message = loginResponse.getStatus();
                        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                    }
                }
                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public Integer validation(String email, String password){
        Integer valid = 1;
        if(email.isEmpty()){
            editEmail.getBackground().setColorFilter(getResources().getColor(R.color.red), PorterDuff.Mode.SRC_IN);
            editEmail.setError("Masukkan email!");
            valid = 0;
        }
        else{
            editEmail.getBackground().setColorFilter(getResources().getColor(R.color.lightGray), PorterDuff.Mode.SRC_ATOP);
        }

        if(password.isEmpty()){
            editPassword.getBackground().setColorFilter(getResources().getColor(R.color.red), PorterDuff.Mode.SRC_ATOP);
            editPassword.setError("Masukkan password");
            valid = 0;
        }
        else{
            editPassword.getBackground().setColorFilter(getResources().getColor(R.color.lightGray), PorterDuff.Mode.SRC_ATOP);
        }

        return valid;
    }
}

