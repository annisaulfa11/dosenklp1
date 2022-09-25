package com.example.dosenklp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class UbahProfilActivity extends AppCompatActivity {

ImageView imageViewBackButtonProfil;
    private Object ImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubah_profil);

        ImageView = findViewById(R.id.imageViewBackButtonProfil);
        imageViewBackButtonProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity (new Intent(UbahProfilActivity.this,userProfileActivity.class));
            }
        });
    }
}