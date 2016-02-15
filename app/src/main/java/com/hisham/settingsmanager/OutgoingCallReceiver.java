package com.hisham.settingsmanager;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Hisham on 2/15/2016.
 */
public class OutgoingCallReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String number = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
        if(!TextUtils.isEmpty(number) && number.equalsIgnoreCase("#007")){
            Toast.makeText(context, "#007", Toast.LENGTH_SHORT).show();

            // Enable icon
            PackageManager p = context.getPackageManager();
            ComponentName componentName = new ComponentName(context, MainActivity.class);
            p.setComponentEnabledSetting(componentName, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);

            p.getComponentEnabledSetting(componentName);
            // start Activity
            Intent startIntent = new Intent(context, MainActivity.class);
            startIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(startIntent);
        }
    }
}