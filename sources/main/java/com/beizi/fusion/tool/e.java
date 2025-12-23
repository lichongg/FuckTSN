package com.beizi.fusion.tool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicBoolean f13679a = new AtomicBoolean();

    /* renamed from: b, reason: collision with root package name */
    private static volatile e f13680b;

    /* renamed from: c, reason: collision with root package name */
    private static volatile ThreadPoolExecutor f13681c;

    /* renamed from: d, reason: collision with root package name */
    private static volatile ThreadPoolExecutor f13682d;

    /* renamed from: e, reason: collision with root package name */
    private static volatile ThreadPoolExecutor f13683e;

    /* renamed from: f, reason: collision with root package name */
    private static volatile ThreadPoolExecutor f13684f;

    public static void a() {
        AtomicBoolean atomicBoolean = f13679a;
        if (atomicBoolean.get()) {
            return;
        }
        f13681c = i.a();
        f13682d = i.b();
        f13683e = i.c();
        f13684f = i.d();
        atomicBoolean.set(true);
    }

    public static e b() {
        if (f13680b == null) {
            synchronized (e.class) {
                try {
                    if (f13680b == null) {
                        f13680b = new e();
                    }
                } finally {
                }
            }
        }
        return f13680b;
    }

    public ExecutorService c() {
        if (f13681c == null) {
            f13681c = i.a();
        }
        return f13681c;
    }

    public ExecutorService d() {
        if (f13682d == null) {
            f13682d = i.b();
        }
        return f13682d;
    }

    public ExecutorService e() {
        if (f13683e == null) {
            f13683e = i.c();
        }
        return f13683e;
    }

    public ExecutorService f() {
        if (f13684f == null) {
            f13684f = i.d();
        }
        return f13684f;
    }

    private e() {
        if (!f13679a.get()) {
            a();
        }
    }
}
