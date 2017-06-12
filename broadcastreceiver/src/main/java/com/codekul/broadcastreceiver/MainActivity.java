package com.codekul.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        /// receives the events when app is running ...
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "Custom Broadcast", Toast.LENGTH_SHORT).show();
            if (intent.getAction().equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)) {

                Toast.makeText(context, "Flight mode changed", Toast.LENGTH_SHORT).show();

                if (intent.getBooleanExtra("state", false))
                    ((ImageView) findViewById(R.id.imgPlane)).setImageResource(R.drawable.ic_airplanemode_active_black_24dp);
                else
                    ((ImageView) findViewById(R.id.imgPlane)).setImageResource(R.drawable.ic_airplanemode_inactive_black_24dp);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.imgPlane).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.codekul.broadcast.CUSTOM");
                sendBroadcast(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        filter.addAction("com.codekul.broadcast.CUSTOM");

        registerReceiver(receiver, filter);
    }

    @Override
    protected void onStop() {
        unregisterReceiver(receiver);
        super.onStop();
    }
}
