
package com.example.dosenklp1.home;

import android.content.Intent;
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

import com.example.dosenklp1.ProfileTaActivity;
import com.example.dosenklp1.R;
import com.example.dosenklp1.UserProfileActivity;

import java.util.ArrayList;


public class HomeFragment extends Fragment implements ListAdapter.ItemMahasiswaClickListener{


    TextView textNama;
    String nama;
    ImageView img;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_home, container, false);

        //Get Name
        textNama = view.findViewById(R.id.lectureName);
        Bundle bundle = getArguments();

        if(bundle != null){
            nama = bundle.getString("email");
        }
        Log.d("isi", "onCreateView: "+ nama);
        textNama.setText(nama);

        //To profile
        img = view.findViewById(R.id.profilpicture);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profile = new Intent(getActivity(), UserProfileActivity.class);
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
