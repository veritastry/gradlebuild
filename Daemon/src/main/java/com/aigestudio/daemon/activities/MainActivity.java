package com.aigestudio.daemon.activities;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobScheduler;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.aigestudio.daemon.R;
import com.aigestudio.daemon.core.Daemon;
import com.aigestudio.daemon.services.DaemonService;

import java.io.File;
import java.io.IOException;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_main);
//        startService(new Intent(this, DaemonService.class));
//
//        PendingIntent intent = PendingIntent.getService(this, 0x123,
//                new Intent(this, DaemonService.class), PendingIntent.FLAG_UPDATE_CURRENT);
//        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
//        am.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, AlarmManager.INTERVAL_HALF_HOUR,
//                AlarmManager.INTERVAL_HALF_HOUR, intent);
    }
}