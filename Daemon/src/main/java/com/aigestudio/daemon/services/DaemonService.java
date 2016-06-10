package com.aigestudio.daemon.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;

import com.aigestudio.daemon.core.Daemon;

/**
 * @author AigeStudio
 * @since 2016-05-05
 */
public class DaemonService extends Service {
    private static boolean sPower = true, isRunning;

    @Override
    public void onCreate() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
//            Notification.Builder builder = new Notification.Builder(this);
//            builder.setSmallIcon(R.mipmap.ic_launcher);
//            startForeground(250, builder.build());
//            startService(new Intent(this, CancelService.class));
//        } else {
//            startForeground(250, new Notification());
//        }
    }

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
                        Log.d("AigeStudio", "DaemonService");
                        Daemon.start(DaemonService.this);
//                        startService(new Intent(DaemonService.this, ProtectService.class));
                        SystemClock.sleep(3000);
                    }
                }
            }).start();
        }
        return super.onStartCommand(intent, flags, startId);
    }
}