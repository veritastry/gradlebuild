package com.aigestudio.daemon.utils;

import android.util.Log;

import java.util.Locale;

/**
 * Log util for whole project
 *
 * @author AigeStudio
 * @since 2011-11-09
 */
public final class LogUtil {
    private final static String TAG = "AigeStudio";
    private final static String MATCH = "%s->%s->%d";
    private final static String CONNECTOR = ":<--->:";

    private static boolean SWITCH = true;

    private static String buildHeader() {
        StackTraceElement stack = Thread.currentThread().getStackTrace()[4];
        return stack == null ? "UNKNOWN" : String.format(Locale.getDefault(),
                MATCH, stack.getClassName(), stack.getMethodName(), stack.getLineNumber()) + CONNECTOR;
    }

    public static void v(Object msg) {
        if (SWITCH) Log.v(TAG, buildHeader() + msg.toString());
    }

    public static void d(Object msg) {
        if (SWITCH) Log.d(TAG, buildHeader() + msg.toString());
    }

    public static void i(Object msg) {
        if (SWITCH) Log.i(TAG, buildHeader() + msg.toString());
    }

    public static void w(Object msg) {
        if (SWITCH) Log.w(TAG, buildHeader() + msg.toString());
    }

    public static void e(Object msg) {
        if (SWITCH) Log.e(TAG, buildHeader() + msg.toString());
    }
}