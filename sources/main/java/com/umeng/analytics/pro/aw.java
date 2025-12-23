package com.umeng.analytics.pro;

import android.content.Context;
import android.os.Looper;
import com.umeng.commonsdk.debug.UMRTLog;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class aw {

    /* renamed from: a, reason: collision with root package name */
    private static av f40923a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f40924b;

    public static synchronized String a(Context context) {
        synchronized (aw.class) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** real call OpenDeviceId.getOaid()");
            if (context == null) {
                throw new RuntimeException("Context is null");
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                throw new IllegalStateException("Cannot be called from the main thread");
            }
            b(context);
            av avVar = f40923a;
            if (avVar != null) {
                try {
                    return avVar.a(context);
                } catch (Exception unused) {
                }
            }
            return null;
        }
    }

    private static void b(Context context) {
        if (f40923a != null || f40924b) {
            return;
        }
        synchronized (aw.class) {
            try {
                if (f40923a == null && !f40924b) {
                    f40923a = ay.a(context);
                    f40924b = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
