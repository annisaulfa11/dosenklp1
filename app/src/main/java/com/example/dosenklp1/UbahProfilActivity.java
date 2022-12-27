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

import com.example.dosenklp1.models.LoginResponse;
import com.example.dosenklp1.models.UpdateProfileResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UbahProfilActivity extends AppCompatActivity {

    public ImageView imageView ;
    private Object ImageView;
    String email, name, token, gettoken;
    EditText editEmail, editName;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubah_profil);

        sharedPreferences = getApplicationContext().getSharedPreferences("com.example.dosenklp1.SHARED_KEY", MODE_PRIVATE);

        editEmail = findViewById(R.id.email);
        editName = findViewById(R.id.name);

    }

    public void toUserProfile(View view) {

        email = editEmail.getText().toString();
        name = editName.getText().toString();

        if(validation(name, email).equals(1)) {

            gettoken = sharedPreferences.getString("token", "");
            token = "Bearer " + gettoken;
            Log.d("token1", token);
            Config config = new Config();
            Call<UpdateProfileResponse> call = config.configRetrofit().updateProfile(token, email, name);
            call.enqueue(new Callback<UpdateProfileResponse>() {
                @Override
                public void onResponse(Call<UpdateProfileResponse> call, Response<UpdateProfileResponse> response) {
                    UpdateProfileResponse updateProfileResponse = response.body();
                    String message;
                    JSONObject jsonObject = null;
                    Log.d("status", updateProfileResponse.getMessage());
                    if (response.code() == 200){
                        if (response.isSuccessful()) {
                            message = response.body().getMessage();
                            Intent intent = new Intent(UbahProfilActivity.this, MainActivity.class);
                            intent.putExtra("name", name);
                            setResult(RESULT_OK, intent);
                            startActivity(intent);
                            finish();
                        }
                    }
                    else if(response.code() == 403){
                        if(!response.isSuccessful()){
                            try {
                                jsonObject = new JSONObject(response.errorBody().string());
                                message = jsonObject.getString("message");
                            } catch (JSONException | IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    else{
                        message = updateProfileResponse.getMessage();
                        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<UpdateProfileResponse> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public Integer validation(String name, String email) {
        Integer valid = 1;

        // validasi nama
        if(name.isEmpty()){
            editName.getBackground().setColorFilter(getResources().getColor(R.color.lightGray), PorterDuff.Mode.SRC_ATOP);
            editName.setError("Masukkan nama!");
            valid = 0;
        }
        else{
            editName.getBackground().setColorFilter(getResources().getColor(R.color.lightGray), PorterDuff.Mode.SRC_ATOP);
        }

        if(email.isEmpty()){
            editEmail.getBackground().setColorFilter(getResources().getColor(R.color.lightGray), PorterDuff.Mode.SRC_ATOP);
            editEmail.setError("Masukkan email!");
            valid = 0;
        }
        else{
            editName.getBackground().setColorFilter(getResources().getColor(R.color.lightGray), PorterDuff.Mode.SRC_ATOP);
        }

        return valid;
    }
}