package com.example.dosenklp1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.dosenklp1.bimbingan.BimbinganFragment;
import com.example.dosenklp1.home.HomeFragment;
import com.example.dosenklp1.jadwal.JadwalFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    HomeFragment homeFragment = new HomeFragment();
    JadwalFragment jadwalFragment = new JadwalFragment();
    BimbinganFragment bimbinganFragment = new BimbinganFragment();

    public TextView email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        String name = getIntent().getStringExtra("email");
        Log.d("nama", "onCreate: " +name);
        Bundle bundle = new Bundle();
        bundle.putString("email", name);
        homeFragment.setArguments(bundle);
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