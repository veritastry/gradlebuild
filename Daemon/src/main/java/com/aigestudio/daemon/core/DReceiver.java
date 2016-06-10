package com.aigestudio.daemon.core;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * @author AigeStudio
 * @since 2016-05-05
 */
public class DReceiver extends BroadcastReceiver {
    private PendingIntent mPendingIntent;
    private AlarmManager am;

    @Override
    public void onReceive(Context context, Intent intent) {
        if (null == intent) return;
        if (null == mPendingIntent) {
            Intent i = new Intent(context, DReceiver.class);
            i.putExtra("time", System.currentTimeMillis() + 3000);
            mPendingIntent = PendingIntent.getService(context, 0x123, i,
                    PendingIntent.FLAG_UPDATE_CURRENT);
        }
        if (null == am)
            am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        long time = intent.getLongExtra("time", System.currentTimeMillis());
        am.setExact(AlarmManager.ELAPSED_REALTIME_WAKEUP, time, mPendingIntent);
    }
}