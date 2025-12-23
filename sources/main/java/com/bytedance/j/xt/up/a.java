package com.bytedance.j.xt.up;

import android.os.Handler;
import android.os.HandlerThread;

/* loaded from: D:\Downloads\app\classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile HandlerThread f24243a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile Handler f24244b;

    /* renamed from: c, reason: collision with root package name */
    private static volatile Handler f24245c;

    public static HandlerThread a() {
        if (f24243a == null) {
            synchronized (a.class) {
                try {
                    if (f24243a == null) {
                        HandlerThread handlerThread = new HandlerThread("default_npth_thread");
                        f24243a = handlerThread;
                        handlerThread.start();
                        f24244b = new Handler(f24243a.getLooper());
                    }
                } finally {
                }
            }
        }
        return f24243a;
    }

    public static Handler b() {
        if (f24244b == null) {
            a();
        }
        return f24244b;
    }
}
