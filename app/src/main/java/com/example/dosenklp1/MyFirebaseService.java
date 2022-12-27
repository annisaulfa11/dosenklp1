package com.example.dosenklp1;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseService extends FirebaseMessagingService {

    private NotificationManagerCompat notificationManager;
    private static final String CHANNEL_ID = "test_channel";


    public MyFirebaseService() {
    }

    @Override
    public  void  onNewToken(@NonNull String token){
        Log.d("newtoken", "Refreshed token" + token);
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        displayNotification(remoteMessage.getNotification());
    }

    private void displayNotification(RemoteMessage.Notification notification) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Bimbingan masuk";
            String description = "Channel untuk notifikasi bimbingan";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            NotificationManagerCompat.from(this).createNotificationChannel(channel);
        }

        Intent resultIntent = new Intent(this, MainActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addNextIntentWithParentStack(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(0,
                        PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_baseline_notifications_none_24)
                .setContentTitle(notification.getTitle())
                .setContentText(notification.getBody())
                .setContentIntent(resultPendingIntent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat.from(this).notify(101, builder.build());

    }

}