package com.example.dosenklp1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.dosenklp1.adapter.ListAdapter;
import com.example.dosenklp1.fragments.HomeFragment;
import com.example.dosenklp1.models.DetailTaResponse;
import com.example.dosenklp1.models.MahasiswaBimbinganResponse;
import com.example.dosenklp1.models.SeminarsItem;
import com.example.dosenklp1.models.Student;
import com.example.dosenklp1.models.SupervisorsItem;
import com.example.dosenklp1.models.ThesesItem;
import com.example.dosenklp1.models.TrialsItem;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileTaActivity extends AppCompatActivity {

    public static final String ITEM_EXTRA = "item_extra";
    String getToken, token;
    TextView textNama, textNim, textMulai, textSeminar, textSidang,textJudul, textDosen, textNilai;
    int idThesis;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_ta);

        TextView textView = findViewById(R.id.name);

        HomeFragment homeFragment = getIntent().getParcelableExtra(ITEM_EXTRA);

        textNama = findViewById(R.id.name);
        textNim = findViewById(R.id.nip);
        textMulai = findViewById(R.id.txt4_1);
        textSeminar = findViewById(R.id.keterangan);
        textSidang = findViewById(R.id.txt2_1);
        textJudul = findViewById(R.id.judul);
        textDosen = findViewById(R.id.txt5_1);
        textNilai = findViewById(R.id.txt7_1);


        Intent detailTa = getIntent();
        if(detailTa != null){
            idThesis = detailTa.getIntExtra("id", 0);
        }

        sharedPreferences = getSharedPreferences("com.example.dosenklp1.SHARED_KEY", Context.MODE_PRIVATE);
        getToken = sharedPreferences.getString("token", "");
        token = "Bearer " + getToken;

        Config config = new Config();
        Call<DetailTaResponse> call = config.configRetrofit().theses(idThesis, token);
        Log.d("idthes", idThesis + token );
        call.enqueue(new Callback<DetailTaResponse>() {
            @Override
            public void onResponse(retrofit2.Call<DetailTaResponse> call, Response<DetailTaResponse> response) {
                DetailTaResponse detailTaResponse = response.body();
                if(response.code() == 200) {
                    textNama.setText(detailTaResponse.getStudent().getName());
                    textNim.setText(detailTaResponse.getStudent().getNim());
                    textMulai.setText(detailTaResponse.getStartAt().substring(0, 10));
                    textJudul.setText(detailTaResponse.getTitle());

                    if (detailTaResponse.getGrade() != null && detailTaResponse.getGrade() != "") {
                        textNilai.setText(detailTaResponse.getGrade().toString());
                    } else {
                        textNilai.setText("Belum ada");
                    }
                    List<SeminarsItem> listSeminar = detailTaResponse.getSeminars();
                    for (SeminarsItem seminarsItem : listSeminar) {
                        if (seminarsItem.getSeminarAt() != null && seminarsItem.getSeminarAt() != "") {
                            textSeminar.setText(seminarsItem.getSeminarAt().substring(0, 10) + ", Jam : " + seminarsItem.getSeminarAt().substring(11, 16));
                        } else {
                            textSeminar.setText("Belum ada");
                        }
                    }
                    List<TrialsItem> listTrials = detailTaResponse.getTrials();
                    for (TrialsItem trialsItem : listTrials) {
                        if (trialsItem.getTrialAt() != null && trialsItem.getTrialAt() != "") {
                            textSidang.setText(trialsItem.getTrialAt().toString().substring(0, 10) + ", Jam : " + trialsItem.getTrialAt().toString().substring(11,16));
                        } else {
                            textSidang.setText("Belum ada");
                        }
                    }
                    List<SupervisorsItem> listSupervisor = detailTaResponse.getSupervisors();
                    for (SupervisorsItem supervisorsItem : listSupervisor) {
                        if (supervisorsItem.getName() != null) {
                            textDosen.setText(supervisorsItem.getName());
                        } else {
                            textDosen.setText("Belum ada");
                        }

                    }
                }
            }

            @Override
            public void onFailure(Call<DetailTaResponse> call, Throwable t) {

            }
        });


    }

    public void profileTA(View view) {
        Intent photoIntent = new Intent(this, MahasiswaActivity.class);
        startActivity(photoIntent);

    }

    public void pembatalan(View view) {
        Intent batal = new Intent(this, PembatalanTA.class);
        startActivity(batal);
    }

    public void nilai(View view) {
        Intent nilai = new Intent(this, InputNilaiActivity.class);
        nilai.putExtra("idThesis", idThesis);
        startActivity(nilai);
    }

    public void main(View view) {
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
    }

    public void logbook(View view) {
        Intent logbook = new Intent(this, ListLogbookActivity.class);
        startActivity(logbook);
    }

    public void sidang(View view) {
        Intent sidang = new Intent(this, DetailSidangActivity.class);
        startActivity(sidang);
    }

    public void seminar(View view) {
        Intent seminar = new Intent(this, DetailSeminarActivity.class);
        startActivity(seminar);
    }
}