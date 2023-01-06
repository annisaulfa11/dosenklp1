package com.example.dosenklp1.fragments;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dosenklp1.MainActivity;
import com.example.dosenklp1.R;
import com.example.dosenklp1.adapter.ListAdapterJadwal;
import com.example.dosenklp1.models.Bimbingan;
import com.example.dosenklp1.models.Jadwal;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.ArrayList;
import java.util.List;


public class JadwalFragment extends Fragment implements ListAdapterJadwal.ItemJadwalClickListener{

    private NotificationManagerCompat notificationManager;
    private static final String CHANNEL_ID;

    static {
        CHANNEL_ID = "test";
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_jadwal, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.jadwalData);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        ListAdapterJadwal adapterJadwal = new ListAdapterJadwal(getJadwal());
        recyclerView.setAdapter(adapterJadwal);

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

    private ArrayList<Jadwal> getJadwal() {
        ArrayList<Jadwal> ListJadwal = new ArrayList<>();
        ListJadwal.add(new Jadwal(
                null,
                "Ranti Agustin",
                "1911522028",
                "Senin/2-01-2023",
                "Ruang Seminar JSI",
                "10.00 WIB",
                "Senin/8-01-2023",
                "Ruang Sidang SI",
                "10.00 WIB"
        ));

        ListJadwal.add(new Jadwal(
                null,
                "Annisa Ulfa",
                "2011522015",
                "Selasa/3-01-2023",
                "Ruang Seminar JSI",
                "10.00 WIB",
                "Selasa/9-01-2023",
                "Ruang Sidang SI",
                "10.00 WIB"
        ));
        ListJadwal.add(new Jadwal(
                null,
                "Muhammad Afif",
                "2011522030",
                "Rabu/4-01-2023",
                "Ruang Seminar JSI",
                "10.00 WIB",
                "Rabu/10-01-2023",
                "Ruang Sidang SI",
                "10.00 WIB"
        ));
        return ListJadwal;
    }


    @Override
    public void onItemJadwalClick(Jadwal jadwal) {
        Intent resultIntent = new Intent(this.getContext(), MainActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this.getContext());
        stackBuilder.addNextIntentWithParentStack(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(0,
                        PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this.getContext(), CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_baseline_notifications_none_24)
                .setContentTitle("Jadwal masuk")
                .setContentText("Contoh Notifikasi")
                .setContentIntent(resultPendingIntent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        notificationManager.notify(101, builder.build());
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Jadwal masuk";
            String description = "Channel untuk notifikasi jadwal";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            notificationManager.createNotificationChannel(channel);
        }
    }
}