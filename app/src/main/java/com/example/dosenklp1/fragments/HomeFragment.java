
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
import com.example.dosenklp1.models.DetailTaResponse;
import com.example.dosenklp1.models.Mahasiswa;
import com.example.dosenklp1.models.MahasiswaBimbinganResponse;
import com.example.dosenklp1.models.Student;
import com.example.dosenklp1.models.ThesesItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment implements ListAdapter.ItemMahasiswaClickListener{


    TextView textNama, textNip;
    Integer idTheses;
    String nama, username, email, getToken, token;
    ImageView img;
    private RecyclerView recyclerView;
    Config config;
    SharedPreferences sharedPreferences;
    public HomeFragment(){

    }
    ListAdapter listAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_home, container, false);


        textNama = view.findViewById(R.id.lectureName);
        textNip = view.findViewById(R.id.nip);

        sharedPreferences = getActivity().getSharedPreferences("com.example.dosenklp1.SHARED_KEY", Context.MODE_PRIVATE);
        getToken = sharedPreferences.getString("token", "");
        token = "Bearer " + getToken;

//        Config config = new Config();
//        Call<ProfileResponse> call = config.configRetrofit().profile(token);
//        call.enqueue(new Callback<ProfileResponse>() {
//            @Override
//            public void onResponse(Call<ProfileResponse> call, Response<ProfileResponse> response) {
//                ProfileResponse profileResponse = response.body();
//                textNama.setText(profileResponse.getName());
//                textNip.setText(profileResponse.getUsername());
//            }
//
//            @Override
//            public void onFailure(Call<ProfileResponse> call, Throwable t) {
//
//            }
//        });

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

        recyclerView = view.findViewById(R.id.mahasiswaData);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        loadDataMahasiswa(token);

        return view;
    }

    public void loadDataMahasiswa(String token){
        Config config = new Config();
        Call<MahasiswaBimbinganResponse> call = config.configRetrofit().mahasiswa(token);
        Log.d("token123", token);
        call.enqueue(new Callback<MahasiswaBimbinganResponse>() {
            @Override
            public void onResponse(Call<MahasiswaBimbinganResponse> call, Response<MahasiswaBimbinganResponse> response) {
                MahasiswaBimbinganResponse mahasiswaBimbinganResponse = response.body();
                if(response.code() == 200){
                    List<ThesesItem> listData = mahasiswaBimbinganResponse.getTheses();
                    ArrayList<Student> mahasiswaArrayList = new ArrayList<>();
                    listAdapter = new ListAdapter(mahasiswaArrayList);

                    for(ThesesItem thesesItem: listData){
                        Student student = new Student(
                                thesesItem.getId(),
                                thesesItem.getStudent().getName(),
                                thesesItem.getStudent().getPhoto()
                        );
                        mahasiswaArrayList.add(student);
                        LinearLayoutManager manager = new LinearLayoutManager(getContext());
                        recyclerView.setLayoutManager(manager);
                        recyclerView.setAdapter(listAdapter);
                    }
                    Log.d("data", String.valueOf(mahasiswaArrayList));

                    listAdapter.setMahasiswaClickListener(HomeFragment.this);
                }
            }

            @Override
            public void onFailure(Call<MahasiswaBimbinganResponse> call, Throwable t) {

            }
        });
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
    public void onItemMahasiswaClick(Student student) {
        Intent detailTa = new Intent(getActivity().getApplicationContext(), ProfileTaActivity.class);
        detailTa.putExtra("id", student.getIdThesis());
        getActivity().startActivity(detailTa);


    }
}
