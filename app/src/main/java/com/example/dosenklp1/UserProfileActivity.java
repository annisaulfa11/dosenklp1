package com.example.dosenklp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dosenklp1.models.LogoutResponse;
import com.example.dosenklp1.models.ProfileResponse;
import com.example.dosenklp1.models.UpdateProfileResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserProfileActivity extends AppCompatActivity {

    TextView textNama, textNip, textUname, textEmail;
    String nama, nip, email, token, gettoken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        textNama = findViewById(R.id.nama_fill);
        textUname = findViewById(R.id.username_fill);
        textNip = findViewById(R.id.nip_fill);
        textEmail = findViewById(R.id.email_fill);

        textNama.setText(nama);
        textUname.setText(nama);
        textNip.setText(nip);
        textEmail.setText(email);

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.example.dosenklp1.SHARED_KEY", MODE_PRIVATE);
        gettoken = sharedPreferences.getString("token", "");
        token = "Bearer " + gettoken;

        Config config = new Config();
        Call<ProfileResponse> call = config.configRetrofit().profile(token);
        call.enqueue(new Callback<ProfileResponse>() {
            @Override
            public void onResponse(Call<ProfileResponse> call, Response<ProfileResponse> response) {
                ProfileResponse profileResponse = response.body();
                textNama.setText(profileResponse.getName());
                textUname.setText(profileResponse.getName());
                textNip.setText(profileResponse.getUsername());
                textEmail.setText(profileResponse.getEmail());
            }

            @Override
            public void onFailure(Call<ProfileResponse> call, Throwable t) {

            }
        });

    }

    public void ubahProfile(View view) {
        Intent ubahprofile = new Intent(this, UbahProfilActivity.class);
        startActivity(ubahprofile);
    }

    public void ubahPassword(View view) {
        Intent ubahpassword = new Intent(this, UbahPasswordActivity.class);
        startActivity(ubahpassword);
    }

    public void main(View view) {
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);

    }

    public void logout(View view) {
        Config config = new Config();
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.example.dosenklp1.SHARED_KEY", MODE_PRIVATE);
        gettoken = sharedPreferences.getString("token", "");
        token = "Bearer " + gettoken;

        Call<LogoutResponse> call = config.configRetrofit().logout(token);
        call.enqueue(new Callback<LogoutResponse>() {
            @Override
            public void onResponse(Call<LogoutResponse> call, Response<LogoutResponse> response) {

                if (response.code() == 200){
                    if (response.isSuccessful()){
                        Log.d("tokenout", token);
                        Intent intent = new Intent(UserProfileActivity.this, LoginActivity.class);
                        Toast.makeText(UserProfileActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        sharedPreferences.edit().clear().apply();
                        startActivity(intent);
                    }
                }
            }

            @Override
            public void onFailure(Call<LogoutResponse> call, Throwable t) {
                Toast.makeText(UserProfileActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

}