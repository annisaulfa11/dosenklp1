
package com.example.dosenklp1.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dosenklp1.MainActivity;
import com.example.dosenklp1.ProfileTaActivity;
import com.example.dosenklp1.R;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment{


    TextView textNama;
    String nama;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_home, container, false);

        textNama = view.findViewById(R.id.lectureName);
        Bundle bundle = getArguments();

        if(bundle != null){
            nama = bundle.getString("email");
        }
        Log.d("isi", "onCreateView: "+ nama);
        textNama.setText(nama);


        RecyclerView recyclerView = view.findViewById(R.id.mahasiswaData);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(new ListAdapter(Data.names));

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    public void profileTA(View view) {
        Intent myIntent = new Intent(getActivity().getApplicationContext(), ProfileTaActivity.class);
        getActivity().startActivity(myIntent);
    }

}
