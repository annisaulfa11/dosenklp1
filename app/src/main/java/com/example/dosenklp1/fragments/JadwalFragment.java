package com.example.dosenklp1.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dosenklp1.R;
import com.example.dosenklp1.adapter.ListAdapterJadwal;
import com.example.dosenklp1.models.Data;


public class JadwalFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_jadwal, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.jadwalData);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(new ListAdapterJadwal(Data.names));

        return view;
    }
}