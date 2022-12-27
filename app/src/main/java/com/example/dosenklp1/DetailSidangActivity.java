package com.example.dosenklp1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class DetailSidangActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_seminar);
    }

    public void main(View view) {
        Intent main = new Intent(this, ProfileTaActivity.class);
        startActivity(main);
    }
}