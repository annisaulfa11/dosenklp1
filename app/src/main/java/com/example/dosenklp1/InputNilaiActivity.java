package com.example.dosenklp1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dosenklp1.models.DetailTaResponse;
import com.example.dosenklp1.models.InputNilaiResponse;
import com.example.dosenklp1.models.SeminarsItem;
import com.example.dosenklp1.models.SupervisorsItem;
import com.example.dosenklp1.models.TrialsItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InputNilaiActivity extends AppCompatActivity {

    int idThesis;
    SharedPreferences sharedPreferences;
    String getToken, token, grade;
    EditText editGrade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nilai);

        Intent intent = getIntent();
        if(intent != null){
            idThesis = intent.getIntExtra("idThesis", 0);
        }

        editGrade = findViewById(R.id.input1);
    }

    public void batal(View view) {
        Intent batal = new Intent(this, ProfileTaActivity.class);
        batal.putExtra("id", idThesis);
        startActivity(batal);
    }

    public void inputNilai(View view) {
        grade = editGrade.getText().toString();
        sharedPreferences = getSharedPreferences("com.example.dosenklp1.SHARED_KEY", Context.MODE_PRIVATE);
        getToken = sharedPreferences.getString("token", "");
        token = "Bearer " + getToken;

        Config config = new Config();
        Call<InputNilaiResponse> call = config.configRetrofit().grade(idThesis, token, grade);
        Log.d("idthes", idThesis + token );
        call.enqueue(new Callback<InputNilaiResponse>() {
            @Override
            public void onResponse(retrofit2.Call<InputNilaiResponse> call, Response<InputNilaiResponse> response) {
                InputNilaiResponse inputNilaiResponse = response.body();
                if(inputNilaiResponse.getStatus().equals("success")) {
                    Intent intent = new Intent(getApplication(), ProfileTaActivity.class);
                    intent.putExtra("id", idThesis);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<InputNilaiResponse> call, Throwable t) {

            }
        });
    }
}