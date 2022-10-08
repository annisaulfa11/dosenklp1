package com.example.dosenklp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.dosenklp1.home.HomeFragment;

public class ProfileTaActivity extends AppCompatActivity {

    public static final String ITEM_EXTRA = "item_extra";
    String nama;
    TextView textNama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_ta);

        TextView textView = findViewById(R.id.name);

        HomeFragment homeFragment = getIntent().getParcelableExtra(ITEM_EXTRA);

        Intent detailTa = getIntent();
        if(detailTa != null){
            nama = detailTa.getStringExtra("nama");
            textNama = findViewById(R.id.name);
            textNama.setText(nama);
        }


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
        Intent nilai = new Intent(this, InputTA.class);
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