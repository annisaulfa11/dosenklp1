package com.example.dosenklp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.dosenklp1.models.ChangePasswordResponse;
import com.example.dosenklp1.models.UpdateProfileResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UbahPasswordActivity extends AppCompatActivity {
    public ImageView imageView;
    String oldPass, newPass, confPass,token, gettoken;
    EditText editOldPass, editNewPass, editConfPass;
    private SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubah_password);

        sharedPreferences = getApplicationContext().getSharedPreferences("com.example.dosenklp1.SHARED_KEY", MODE_PRIVATE);


        editOldPass = findViewById(R.id.password1);
        editNewPass = findViewById(R.id.password2);
        editConfPass = findViewById(R.id.password3);

    }

    public void toUserProfile(View view) {
        oldPass = editOldPass.getText().toString();
        newPass = editNewPass.getText().toString();
        confPass = editConfPass.getText().toString();

        if(validation(newPass, confPass).equals(1)) {

            gettoken = sharedPreferences.getString("token", "");
            token = "Bearer " + gettoken;
            Log.d("token1", token);
            Config config = new Config();
            Call<ChangePasswordResponse> call = config.configRetrofit().changePassword(token, oldPass, newPass, confPass);
            call.enqueue(new Callback<ChangePasswordResponse>() {
                @Override
                public void onResponse(Call<ChangePasswordResponse> call, Response<ChangePasswordResponse> response) {
                    ChangePasswordResponse changePasswordResponse = response.body();
                    String message;
                    JSONObject jsonObject = null;
                    Log.d("status", changePasswordResponse.getMessage());
                    if (response.code() == 200){
                        if (changePasswordResponse.getStatus().equals("success")) {
                            message = response.body().getMessage();
                            Intent intent = new Intent(UbahPasswordActivity.this, UserProfileActivity.class);
                            setResult(RESULT_OK, intent);
                            startActivity(intent);
                            finish();
                        }
                    }


                    else{
                        message = changePasswordResponse.getMessage();
                        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ChangePasswordResponse> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "Password lama salah!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent();
                    startActivity(intent);
                    finish();
                }
            });
        }

    }

    public Integer validation(String password, String confirm_password){
        Integer valid = 1;

        // validasi password
        if(password.isEmpty()){
            editNewPass.getBackground().setColorFilter(getResources().getColor(R.color.lightGray), PorterDuff.Mode.SRC_ATOP);
            editNewPass.setError("Masukkan Password!");
            valid = 0;
        }
        else{
            editNewPass.getBackground().setColorFilter(getResources().getColor(R.color.lightGray), PorterDuff.Mode.SRC_ATOP);
        }

        // validasi confirm password
        if(confirm_password.isEmpty()){
            editConfPass.getBackground().setColorFilter(getResources().getColor(R.color.lightGray), PorterDuff.Mode.SRC_ATOP);
            editConfPass.setError("Masukkan Konfirmasi Password!");
            valid = 0;
        }
        else{
            editConfPass.getBackground().setColorFilter(getResources().getColor(R.color.lightGray), PorterDuff.Mode.SRC_ATOP);
        }

        // validasi password sama dengan confirmasi password
        if(!password.isEmpty() && !confirm_password.isEmpty()){
            if(!password.equals(confirm_password)){
                editNewPass.getBackground().setColorFilter(getResources().getColor(R.color.lightGray), PorterDuff.Mode.SRC_ATOP);
                editNewPass.setError("Password tidak sesuai!");
                editConfPass.getBackground().setColorFilter(getResources().getColor(R.color.lightGray), PorterDuff.Mode.SRC_ATOP);
                editConfPass.setError("Password tidak sesuai!");
                valid = 0;
            }
            else{
                editNewPass.getBackground().setColorFilter(getResources().getColor(R.color.lightGray), PorterDuff.Mode.SRC_ATOP);
                editNewPass.getBackground().setColorFilter(getResources().getColor(R.color.lightGray), PorterDuff.Mode.SRC_ATOP);
                editConfPass.setError(null);
                editConfPass.setError(null);
            }
        }
        return valid;
    }
}