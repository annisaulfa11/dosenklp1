package com.example.dosenklp1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.dosenklp1.bimbingan.BimbinganFragment;
import com.example.dosenklp1.home.HomeFragment;
import com.example.dosenklp1.jadwal.JadwalFragment;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    HomeFragment homeFragment = new HomeFragment();
    JadwalFragment jadwalFragment = new JadwalFragment();
    BimbinganFragment bimbinganFragment = new BimbinganFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
                        return true;
                    case R.id.jadwal:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, jadwalFragment).commit();
                        return true;
                    case R.id.bimbingan:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, bimbinganFragment).commit();
                        return true;
                }
                return false;
            }
        });
    }
}