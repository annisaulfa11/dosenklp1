package com.example.dosenklp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class DetailLogbookActivity<intentdetaillb> extends AppCompatActivity {

    TextView textViewTanggalLogbook, editTextKegiatanLogbook;
    String tanggallb, progresslb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_logbook);
    }

    Intent intentdetaillb = getIntent();
        if(intentdetaillb != null){
        tanggallb = intentdetaillb.getStringExtra("tanggallb");
        progresslb = intentdetaillb.getStringExtra("progreslb");

        textViewTanggalLogbook = findViewById(R.id.textViewTanggalLogbook);
        textViewTanggalLogbook.setText((tanggallb));
        editTextKegiatanLogbook = findViewById(R.id.editTextKegiatanLogbook);
        editTextKegiatanLogbook.setText(progresslb);



        public void main(View view) {
            Intent main = new Intent(this, ListLogbookActivity.class);
            startActivity(main);
        }
    }