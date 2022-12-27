
package com.example.dosenklp1.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dosenklp1.Config;
import com.example.dosenklp1.ProfileTaActivity;
import com.example.dosenklp1.R;
import com.example.dosenklp1.UserProfileActivity;
import com.example.dosenklp1.adapter.ListAdapter;
import com.example.dosenklp1.models.Mahasiswa;
import com.example.dosenklp1.models.ProfileResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment implements ListAdapter.ItemMahasiswaClickListener{


    TextView textNama, textNip;
    String nama, username, email, gettoken, token;
    ImageView img;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_home, container, false);

        //Get Name
        textNama = view.findViewById(R.id.lectureName);
        textNip = view.findViewById(R.id.nip);
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("com.example.dosenklp1.SHARED_KEY", Context.MODE_PRIVATE);
        gettoken = sharedPreferences.getString("token", "");
        token = "Bearer " + gettoken;

        Config config = new Config();
        Call<ProfileResponse> call = config.configRetrofit().profile(token);
        call.enqueue(new Callback<ProfileResponse>() {
            @Override
            public void onResponse(Call<ProfileResponse> call, Response<ProfileResponse> response) {
                ProfileResponse profileResponse = response.body();
                textNama.setText(profileResponse.getName());
                textNip.setText(profileResponse.getUsername());
            }

            @Override
            public void onFailure(Call<ProfileResponse> call, Throwable t) {

            }
        });


        //To profile
        img = view.findViewById(R.id.profilpicture);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profile = new Intent(getActivity(), UserProfileActivity.class);
                profile.putExtra("nama", nama);
                profile.putExtra("nip", username);
                profile.putExtra("email", email);
                startActivity(profile);
            }
        });

        RecyclerView recyclerView = view.findViewById(R.id.mahasiswaData);
        ListAdapter listAdapter = new ListAdapter(getData());
        listAdapter.setMahasiswaClickListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(listAdapter);

        return view;
    }

    public ArrayList<Mahasiswa> getData(){
        ArrayList<Mahasiswa> listData = new ArrayList<>();
        listData.add(new Mahasiswa(
                "Annisa Ulfa",
                null

        ));
        listData.add(new Mahasiswa(
                "Muhammad Afif",
                null

        ));
        listData.add(new Mahasiswa(
                "Ranti Agustin",
                null

        ));
        listData.add(new Mahasiswa(
                "Annisa Ulfa",
                null

        ));
        listData.add(new Mahasiswa(
                "Annisa Ulfa",
                null

        ));
        listData.add(new Mahasiswa(
                "Annisa Ulfa",
                null

        ));

        return listData;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }



    public void profileTA(View view) {
        Intent myIntent = new Intent(getActivity().getApplicationContext(), ProfileTaActivity.class);
        getActivity().startActivity(myIntent);
    }

    @Override
    public void onItemMahasiswaClick(Mahasiswa mahasiswa) {
        Intent detailTa = new Intent(getActivity().getApplicationContext(), ProfileTaActivity.class);
        detailTa.putExtra("nama", mahasiswa.getNama());
        getActivity().startActivity(detailTa);
    }
}
