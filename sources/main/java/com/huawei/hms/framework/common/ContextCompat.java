package com.huawei.hms.framework.common;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Process;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class ContextCompat {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33273a = "ContextCompat";

    public static Object getSystemService(Context context, String str) {
        if (context == null) {
            Logger.w(f33273a, "context is null");
            return null;
        }
        try {
            return context.getSystemService(str);
        } catch (RuntimeException e6) {
            Logger.e(f33273a, "SystemServer error:", e6);
            return null;
        }
    }

    public static Intent registerReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (context == null) {
            Logger.w(f33273a, "context is null");
            return null;
        }
        try {
            return context.registerReceiver(broadcastReceiver, intentFilter);
        } catch (RuntimeException e6) {
            Logger.e(f33273a, "dealType rethrowFromSystemServer:", e6);
            return null;
        }
    }

    public static ComponentName startService(Context context, Intent intent) {
        if (context == null) {
            Logger.w(f33273a, "context is null");
            return null;
        }
        try {
            return context.startService(intent);
        } catch (RuntimeException e6) {
            Logger.e(f33273a, "SystemServer error:", e6);
            return null;
        }
    }

    public static boolean checkSelfPermission(Context context, String str) {
        if (context == null || str == null) {
            Logger.w(f33273a, "param is null");
            return false;
        }
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
        } catch (RuntimeException e6) {
            Logger.e(f33273a, "dealType rethrowFromSystemServer:", e6);
            return false;
        }
    }

    public static Context getProtectedStorageContext(Context context) {
        Context createDeviceProtectedStorageContext;
        if (context == null) {
            Logger.w(f33273a, "context is null");
            return null;
        }
        if (Build.VERSION.SDK_INT < 24) {
            return context;
        }
        createDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
        return createDeviceProtectedStorageContext;
    }

    public static void unregisterReceiver(Context context, BroadcastReceiver broadcastReceiver) {
        if (context == null) {
            Logger.w(f33273a, "context is null");
            return;
        }
        try {
            context.unregisterReceiver(broadcastReceiver);
        } catch (RuntimeException e6) {
            Logger.e(f33273a, "SystemServer error:", e6);
        }
    }

    public static Intent registerReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler) {
        if (context == null) {
            Logger.w(f33273a, "context is null");
            return null;
        }
        try {
            return context.registerReceiver(broadcastReceiver, intentFilter, str, handler);
        } catch (RuntimeException e6) {
            Logger.e(f33273a, "dealType rethrowFromSystemServer:", e6);
            return null;
        }
    }
}
