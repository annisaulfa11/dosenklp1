package com.example.dosenklp1;



import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.dosenklp1.home.HomeFragment;


public class LoginActivity extends AppCompatActivity {

    TextView editEmail, editPassword;
    String email, password;
    Button login;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


    }


    public void login(View view) {
        editEmail = (EditText) findViewById(R.id.email);
        editPassword = (EditText) findViewById(R.id.password);

        email = editEmail.getText().toString();
        password = editPassword.getText().toString();



        Log.d("salah", "login: " +password + "/" +email);

        if(password.equals("1")){

            Intent login = new Intent(this, MainActivity.class);
            login.putExtra("email", email);
            startActivity(login);
        } else {
            Toast.makeText(LoginActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
        }
    }


}

