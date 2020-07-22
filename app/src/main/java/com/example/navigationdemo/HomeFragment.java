package com.example.navigationdemo;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDeepLinkBuilder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class HomeFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        new MainActivity().showBottomNav();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.createNotification).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "Goto a fragment in nav component";
//                NotificationCompat.Builder builder = new NotificationCompat.Builder(getContext())
//                        .setContentTitle("New Notification")
//                        .setContentText(message)
//                        .setAutoCancel(true)
//                        .setSmallIcon(R.drawable.ic_baseline_home_24);
//
//                Intent intent = new Intent(getActivity(), MainActivity.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                intent.putExtra("data", "notdetails");

//                PendingIntent pendingIntent = PendingIntent.getActivity(getActivity(), 0,intent, PendingIntent.FLAG_UPDATE_CURRENT);
//                builder.setContentIntent(pendingIntent);
//                NotificationManager manager = (NotificationManager) getContext().getSystemService(Context.NOTIFICATION_SERVICE);
//                manager.notify(0, builder.build());


//
//                NotificationManagerCompat compat = NotificationManagerCompat.from(getContext());
//                compat.notify(0, builder.build());

                NotificationCompat.Builder builder = new NotificationCompat.Builder(getContext())
                        .setContentIntent(new NavDeepLinkBuilder(getContext()).setGraph(R.navigation.nav_graph)
                        .setDestination(R.id.notificationsFragment)
                        .createPendingIntent())
                        .setContentTitle("New Notification")
                        .setContentText(message)
                        .setAutoCancel(true)
                        .setSmallIcon(R.drawable.ic_baseline_home_24);
                NotificationManager manager = (NotificationManager) getContext().getSystemService(Context.NOTIFICATION_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                {
                    String channelId = "Your_channel_id";
                    NotificationChannel channel = new NotificationChannel(
                            channelId,
                            "Channel human readable title",
                            NotificationManager.IMPORTANCE_HIGH);
                    manager.createNotificationChannel(channel);
                    builder.setChannelId(channelId);
                }

                manager.notify(0, builder.build());


            }
        });
    }
}