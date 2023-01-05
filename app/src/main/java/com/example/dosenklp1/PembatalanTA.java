package com.example.dosenklp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.dosenklp1.models.InputNilaiResponse;
import com.example.dosenklp1.models.PembatalanTAResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PembatalanTA extends AppCompatActivity {

    int idThesis;
    SharedPreferences sharedPreferences;
    String getToken, token, status;

    public String getStatus() {

        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembatalan);
    }

    public void batal(View view) {
        Intent batal = new Intent(this, ProfileTaActivity.class);
        startActivity(batal);

        public void pembatalanTA(View view) {
            status = getStatus();
            sharedPreferences = getSharedPreferences("com.example.dosenklp1.SHARED_KEY", Context.MODE_PRIVATE);
            getToken = sharedPreferences.getString("token", "");
            token = "Bearer " + getToken;

            Config config = new Config();
            Call<PembatalanTAResponse> call = config.configRetrofit().status(idThesis, token, status);
            Log.d("idthes", idThesis + token );
            call.enqueue(new Callback<PembatalanTAResponse>() {
                @Override
                public void onResponse(retrofit2.Call<InputNilaiResponse> call, Response<PembatalanTAResponse> response) {
                    PembatalanTAResponse PembatalanTAResponse = response.body();
                    PembatalanTAResponse pembatalanTAResponse;
                    if(pembatalanTAResponse.getStatus().equals("success")) {
                        Intent intent = new Intent(getApplication(), ProfileTaActivity.class);
                        intent.putExtra("id", idThesis);
                        startActivity(intent);
                    }
                }

                @Override
                public void onFailure(Call<PembatalanTAResponse> call, Throwable t) {

                }
            });

        }
}

