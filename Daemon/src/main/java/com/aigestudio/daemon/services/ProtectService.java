package com.aigestudio.daemon.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;

/**
 * @author AigeStudio
 * @since 2016-05-05
 */
public class ProtectService extends Service {
    private static boolean sPower = true, isRunning;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (!isRunning) {
            isRunning = true;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (sPower) {
                        if (System.currentTimeMillis() >= 123456789000000L) {
                            sPower = false;
                        }
                        SystemClock.sleep(1500);
                        Log.d("AigeStudio", "ProtectService");
                        startService(new Intent(ProtectService.this, DaemonService.class));
                    }
                }
            }).start();
        }
        return super.onStartCommand(intent, flags, startId);
    }
}