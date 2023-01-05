package com.example.dosenklp1.fragments;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.dosenklp1.Config;
import com.example.dosenklp1.MainActivity;
import com.example.dosenklp1.R;
import com.example.dosenklp1.adapter.ListAdapterBimbingan;
import com.example.dosenklp1.models.Bimbingan;
import com.example.dosenklp1.models.MahasiswaBimbinganResponse;
import com.example.dosenklp1.models.Student;
import com.example.dosenklp1.models.ThesesItem;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class BimbinganFragment extends Fragment implements ListAdapterBimbingan.ItemPermintaanClickListener{

    private NotificationManagerCompat notificationManager;
    private static final String CHANNEL_ID = "test_channel";

    String nama, username, email, getToken, token;
    ImageView img;
    private RecyclerView recyclerView;
    Config config;
    SharedPreferences sharedPreferences;
    public BimbinganFragment(){

    }
    ListAdapterBimbingan listAdapterBimbingan;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_bimbingan, container, false);

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


        recyclerView = view.findViewById(R.id.bimbinganData);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        loadDataMahasiswa2(token);

        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                            Log.w("notifikasi", "Fetching FCM registration token failed", task.getException());
                            return;
                        }

                        // Get new FCM registration token
                        String token = task.getResult();

                        // Log and toast
                        Log.d("pesan", token);
                    }
                });

        notificationManager = NotificationManagerCompat.from(this.getContext());
        createNotificationChannel();


        return view;
    }

//    private ArrayList<Bimbingan> getPermintaan() {
//        return
//    }

    public void loadDataMahasiswa2(String token){
        Config config = new Config();
        Call<MahasiswaBimbinganResponse> call = config.configRetrofit().mahasiswa(token);
        Log.d("token123", token);
        return call.enqueue(new Callback<Bimbingan>() {
            @Override
            public void onResponse(Call<Bimbingan> call, Response<Bimbingan> response) {
                Bimbingan mahasiswaBimbinganResponse = response.body();
                if (response.code() == 200) {
                    List<ThesesItem> listData = mahasiswaBimbinganResponse.getTheses();
                    ArrayList<Student> mahasiswaArrayList = new ArrayList<>();
                    ListAdapterBimbingan listAdapter = new ListAdapterBimbingan(mahasiswaArrayList);

                    for (ThesesItem thesesItem : listData) {
                        Student student = new Student(
                                thesesItem.getId(),
                                thesesItem.getStudent().getName()
                        );
                        mahasiswaArrayList.add(student);
                        LinearLayoutManager manager = new LinearLayoutManager(getContext());
                        recyclerView.setLayoutManager(manager);
                        recyclerView.setAdapter(listAdapterBimbingan);
                    }
                    Log.d("data", String.valueOf(mahasiswaArrayList));

                }
            }

            @Override
            public void onFailure(Call<Bimbingan> call, Throwable t) {

            }
        }
                ;
    }



    @Override
    public void onItemPermintaanClick(Bimbingan bimbingan) {
        Intent resultIntent = new Intent(this.getApplicationContext(), MainActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this.getApplicationContext());
        stackBuilder.addNextIntentWithParentStack(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(0,
                        PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this.getApplicationContext(), CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_baseline_notifications_none_24)
                .setContentTitle("Bimbingan masuk")
                .setContentText("Permintaan Bimbingan Tugas Akhir")
                .setContentIntent(resultPendingIntent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        notificationManager.notify(101, builder.build());
    }

            private Context getApplicationContext() {
                return null;
            }

            private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Bimbingan masuk";
            String description = "Channel untuk notifikasi bimbingan";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            notificationManager.createNotificationChannel(channel);
        }
    }
}