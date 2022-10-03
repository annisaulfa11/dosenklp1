package com.example.dosenklp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class UserProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
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
}