package com.example.dosenklp1.fragments;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
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
import android.widget.Toast;

import com.example.dosenklp1.MainActivity;
import com.example.dosenklp1.R;
import com.example.dosenklp1.adapter.ListAdapterBimbingan;
import com.example.dosenklp1.models.Bimbingan;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.ArrayList;


public class BimbinganFragment extends Fragment implements ListAdapterBimbingan.ItemPermintaanClickListener{

    private NotificationManagerCompat notificationManager;
    private static final String CHANNEL_ID = "test_channel";

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
        Intent resultIntent = new Intent(this.getContext(), MainActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this.getContext());
        stackBuilder.addNextIntentWithParentStack(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(0,
                        PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this.getContext(), CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_baseline_notifications_none_24)
                .setContentTitle("Bimbingan masuk")
                .setContentText("Contoh notifikasi")
                .setContentIntent(resultPendingIntent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        notificationManager.notify(101, builder.build());
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