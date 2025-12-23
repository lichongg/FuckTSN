package com.bytedance.sdk.component.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ch {

    /* renamed from: j, reason: collision with root package name */
    private static final Object f26854j = new Object();
    private static final Map<j, Object> xt = new ConcurrentHashMap();
    private static AtomicBoolean cw = new AtomicBoolean(false);

    /* renamed from: r, reason: collision with root package name */
    private static volatile int f26856r = -1;
    private static volatile long up = 0;

    /* renamed from: m, reason: collision with root package name */
    private static volatile int f26855m = 60000;
    private static az ae = null;
    private static final AtomicBoolean tl = new AtomicBoolean(false);

    public interface j {
        void j(Context context, Intent intent, boolean z5, int i6);
    }

    private static class xt extends BroadcastReceiver {
        private xt() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean z5 = false;
            boolean booleanExtra = intent.getBooleanExtra("noConnectivity", false);
            if (ch.xt != null && ch.xt.size() > 0) {
                z5 = true;
            }
            ch.xt(context, intent, z5, booleanExtra);
        }
    }

    private static int cw(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (type != 0) {
                    return type != 1 ? 1 : 4;
                }
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                switch (activeNetworkInfo.getSubtype()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                    case 16:
                        return 2;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                    case 17:
                        return 3;
                    case 13:
                    case 18:
                    case 19:
                        az azVar = ae;
                        return (azVar == null || !azVar.j(context, telephonyManager)) ? 5 : 6;
                    case 20:
                        return 6;
                    default:
                        String subtypeName = activeNetworkInfo.getSubtypeName();
                        return (TextUtils.isEmpty(subtypeName) || !(subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000"))) ? 1 : 3;
                }
            }
            return 0;
        } catch (Throwable unused) {
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xt(final Context context, final Intent intent, final boolean z5, final boolean z6) {
        if (!z5 && z6) {
            f26856r = 0;
        } else if (tl.compareAndSet(false, true)) {
            com.bytedance.sdk.component.oq.ae.xt(new com.bytedance.sdk.component.oq.g("getNetworkType") { // from class: com.bytedance.sdk.component.utils.ch.1
                @Override // java.lang.Runnable
                public void run() {
                    int unused = ch.f26856r = z6 ? 0 : ch.xt(context);
                    if (z5) {
                        ch.xt(context, intent, ch.f26856r, z6);
                    }
                    ch.tl.set(false);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xt(Context context, Intent intent, int i6, boolean z5) {
        Map<j, Object> map = xt;
        if (map == null || map.size() <= 0) {
            return;
        }
        for (j jVar : map.keySet()) {
            if (jVar != null) {
                jVar.j(context, intent, !z5, i6);
            }
        }
    }

    public static void j(az azVar) {
        ae = azVar;
    }

    public static int j(Context context, long j6) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (up + j6 <= elapsedRealtime) {
            return xt(context);
        }
        if (f26856r == -1) {
            return xt(context);
        }
        if (elapsedRealtime - up >= f26855m) {
            xt(context, (Intent) null, false, false);
        }
        return f26856r;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int xt(Context context) {
        f26856r = cw(context);
        up = SystemClock.elapsedRealtime();
        return f26856r;
    }

    public static void j(j jVar, Context context) {
        if (jVar == null) {
            return;
        }
        if (!cw.get()) {
            try {
                context.registerReceiver(new xt(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                cw.set(true);
            } catch (Throwable unused) {
            }
        }
        xt.put(jVar, f26854j);
    }

    public static void j(j jVar) {
        if (jVar == null) {
            return;
        }
        xt.remove(jVar);
    }
}
