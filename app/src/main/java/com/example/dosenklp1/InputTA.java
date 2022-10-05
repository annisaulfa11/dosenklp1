package com.example.dosenklp1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class InputTA extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nilai);
    }

    public void batal(View view) {
        Intent batal = new Intent(this, ProfileTaActivity.class);
        startActivity(batal);
    }
}