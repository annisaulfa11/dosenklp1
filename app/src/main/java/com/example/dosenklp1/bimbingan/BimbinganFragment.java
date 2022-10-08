package com.example.dosenklp1.bimbingan;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dosenklp1.DetailLogbookActivity;
import com.example.dosenklp1.R;
import com.example.dosenklp1.bimbingan.Bimbingan;

import java.util.ArrayList;


public class BimbinganFragment extends Fragment implements ListAdapterBimbingan.ItemPermintaanClickListener{


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_bimbingan, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.bimbinganData);
        ListAdapterBimbingan adapterBimbingan = new ListAdapterBimbingan(getPermintaan());
        adapterBimbingan.setPermintaanClickListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(adapterBimbingan);

        return view;
    }

    public ArrayList<Bimbingan> getPermintaan(){
        ArrayList<Bimbingan> listPermintaan = new ArrayList<>();
        listPermintaan.add(new Bimbingan(
                "Annisa Ulfa",
                "2011522015",
                "Pembangunan Sistem Informasi Monitoring Harga Barang Kebutuhan Pokok Berbasis Barang Web",
                null
        ));
        listPermintaan.add(new Bimbingan(
                "Muhammad Afif",
                "2011522030",
                "Pembangunan Sistem Informasi Monitoring Harga Barang Kebutuhan Pokok Berbasis Barang Web",
                null
        ));        listPermintaan.add(new Bimbingan(
                "Ranti Agustin",
                "2011522015",
                "Pembangunan Sistem Informasi Monitoring Harga Barang Kebutuhan Pokok Berbasis Barang Web",
                null
        ));        listPermintaan.add(new Bimbingan(
                "Annisa Ulfa",
                "2011522015",
                "Pembangunan Sistem Informasi Monitoring Harga Barang Kebutuhan Pokok Berbasis Barang Web",
                null
        ));        listPermintaan.add(new Bimbingan(
                "Annisa Ulfa",
                "2011522015",
                "Pembangunan Sistem Informasi Monitoring Harga Barang Kebutuhan Pokok Berbasis Barang Web",
                null
        ));

        return listPermintaan;
    }

    @Override
    public void onItemPermintaanClick(Bimbingan bimbingan) {

    }
}