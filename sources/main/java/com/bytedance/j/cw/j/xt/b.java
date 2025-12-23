package com.bytedance.j.cw.j.xt;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: D:\Downloads\app\classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static volatile b f24117a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile ThreadPoolExecutor f24118b;

    /* renamed from: c, reason: collision with root package name */
    private static volatile ThreadPoolExecutor f24119c;

    /* renamed from: d, reason: collision with root package name */
    private static volatile ScheduledExecutorService f24120d;

    /* renamed from: e, reason: collision with root package name */
    private static final ConcurrentHashMap<String, a> f24121e = new ConcurrentHashMap<>();

    /* renamed from: f, reason: collision with root package name */
    private static final ConcurrentHashMap<String, a> f24122f = new ConcurrentHashMap<>();

    public static b a() {
        if (f24117a == null) {
            synchronized (b.class) {
                try {
                    if (f24117a == null) {
                        f24117a = new b();
                    }
                } finally {
                }
            }
        }
        return f24117a;
    }

    public void b(a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("param is not be null");
        }
        if (f24118b != null) {
            f24118b.execute(aVar);
        }
    }

    private b() {
        f24118b = d.b();
        f24119c = d.c();
        f24120d = d.a();
    }
}
