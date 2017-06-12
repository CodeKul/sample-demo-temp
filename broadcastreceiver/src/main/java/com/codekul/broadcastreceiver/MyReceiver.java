package com.codekul.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getBooleanExtra("state", false)) {
            Toast.makeText(context, "Enabled", Toast.LENGTH_SHORT).show();
        } else Toast.makeText(context, "Disabled", Toast.LENGTH_SHORT).show();
    }
}
