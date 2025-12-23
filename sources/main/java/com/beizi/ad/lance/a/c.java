package com.beizi.ad.lance.a;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicBoolean f12733a = new AtomicBoolean();

    /* renamed from: b, reason: collision with root package name */
    private static volatile c f12734b;

    /* renamed from: c, reason: collision with root package name */
    private static volatile ThreadPoolExecutor f12735c;

    /* renamed from: d, reason: collision with root package name */
    private static volatile ThreadPoolExecutor f12736d;

    /* renamed from: e, reason: collision with root package name */
    private static volatile ThreadPoolExecutor f12737e;

    /* renamed from: f, reason: collision with root package name */
    private static volatile ThreadPoolExecutor f12738f;

    /* renamed from: g, reason: collision with root package name */
    private static volatile ScheduledThreadPoolExecutor f12739g;

    public static void a() {
        AtomicBoolean atomicBoolean = f12733a;
        if (atomicBoolean.get()) {
            return;
        }
        f12735c = e.a();
        f12737e = e.c();
        f12738f = e.d();
        atomicBoolean.set(true);
    }

    public static c b() {
        if (f12734b == null) {
            synchronized (c.class) {
                try {
                    if (f12734b == null) {
                        f12734b = new c();
                    }
                } finally {
                }
            }
        }
        return f12734b;
    }

    public ExecutorService c() {
        if (f12735c == null) {
            f12735c = e.a();
        }
        return f12735c;
    }

    public ExecutorService d() {
        if (f12736d == null) {
            f12736d = e.b();
        }
        return f12736d;
    }

    public ExecutorService e() {
        if (f12737e == null) {
            f12737e = e.c();
        }
        return f12737e;
    }

    public ExecutorService f() {
        if (f12738f == null) {
            f12738f = e.d();
        }
        return f12738f;
    }

    public ScheduledThreadPoolExecutor g() {
        if (f12739g == null) {
            f12739g = e.e();
        }
        return f12739g;
    }

    private c() {
        if (!f12733a.get()) {
            a();
        }
    }
}
