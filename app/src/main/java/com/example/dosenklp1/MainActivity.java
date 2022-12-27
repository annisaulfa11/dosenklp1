package com.example.dosenklp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.dosenklp1.databinding.ActivityMainBinding;
import com.example.dosenklp1.fragments.BimbinganFragment;
import com.example.dosenklp1.fragments.HomeFragment;
import com.example.dosenklp1.fragments.JadwalFragment;
import com.example.dosenklp1.network.StoryEndPoint;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    HomeFragment homeFragment = new HomeFragment();
    JadwalFragment jadwalFragment = new JadwalFragment();
    BimbinganFragment bimbinganFragment = new BimbinganFragment();

    Boolean isLoggedIn;
    String nama, token, username, email;
    ActivityMainBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        SharedPreferences sharedPreferences = getSharedPreferences(
                "com.example.dosenklp1.SHARED_KEY",
                MODE_PRIVATE
        );

        nama = sharedPreferences.getString("name", "Dosen");
        username = sharedPreferences.getString("username", "123");
        email = sharedPreferences.getString("email", "email");


        token = sharedPreferences.getString("token","");
        Log.d("token", token);
        if (token.equals("")){
            Log.i("token", token);
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
            finish();
        }
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

    public void requestData(){
//        String BASE_URL = "https://story-api.dicoding.dev/v1/";
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .client(new OkHttpClient.Builder().build())
//                .build();
//
//        StoryEndPoint client = retrofit.create(StoryEndPoint.class);
//        Call<GetStoryResponse> call = client.getStories(token);
    }
}