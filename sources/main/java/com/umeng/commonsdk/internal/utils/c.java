package com.umeng.commonsdk.internal.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.app.NotificationCompat;
import com.stub.StubApp;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final String f41805a = "BatteryUtils";

    /* renamed from: b, reason: collision with root package name */
    private static boolean f41806b;

    /* renamed from: c, reason: collision with root package name */
    private static Context f41807c;

    /* renamed from: d, reason: collision with root package name */
    private BroadcastReceiver f41808d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final c f41810a = new c();

        private a() {
        }
    }

    public static c a(Context context) {
        if (f41807c == null && context != null) {
            f41807c = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        return a.f41810a;
    }

    public synchronized void b() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            f41807c.registerReceiver(this.f41808d, intentFilter);
            f41806b = true;
        } finally {
        }
    }

    public synchronized void c() {
        try {
            f41807c.unregisterReceiver(this.f41808d);
            f41806b = false;
        } finally {
        }
    }

    private c() {
        this.f41808d = new BroadcastReceiver() { // from class: com.umeng.commonsdk.internal.utils.c.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                try {
                    if (intent.getAction().equals("android.intent.action.BATTERY_CHANGED")) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "ACTION_BATTERY_CHANGED：battery info cc.");
                        int i6 = 0;
                        int intExtra = intent.getIntExtra("level", 0);
                        int intExtra2 = intent.getIntExtra("voltage", 0);
                        int intExtra3 = intent.getIntExtra("temperature", 0);
                        int intExtra4 = intent.getIntExtra(NotificationCompat.CATEGORY_STATUS, 0);
                        int i7 = -1;
                        if (intExtra4 != 1) {
                            if (intExtra4 != 2) {
                                if (intExtra4 != 4) {
                                    if (intExtra4 == 5) {
                                        i7 = 2;
                                    }
                                } else {
                                    i7 = 0;
                                }
                            } else {
                                i7 = 1;
                            }
                        }
                        int intExtra5 = intent.getIntExtra("plugged", 0);
                        if (intExtra5 != 1) {
                            if (intExtra5 == 2) {
                                i6 = 2;
                            }
                        } else {
                            i6 = 1;
                        }
                        b bVar = new b();
                        bVar.f41799a = intExtra;
                        bVar.f41800b = intExtra2;
                        bVar.f41802d = i7;
                        bVar.f41801c = intExtra3;
                        bVar.f41803e = i6;
                        bVar.f41804f = System.currentTimeMillis();
                        UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.f41754h, com.umeng.commonsdk.internal.b.a(c.f41807c).a(), bVar);
                        c.this.c();
                    }
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(c.f41807c, th);
                }
            }
        };
    }

    public synchronized boolean a() {
        return f41806b;
    }
}
