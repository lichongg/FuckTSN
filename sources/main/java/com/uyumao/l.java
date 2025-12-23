package com.uyumao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    public static l f42599a;

    /* renamed from: b, reason: collision with root package name */
    public ExecutorService f42600b;

    public static l a() {
        if (f42599a == null) {
            synchronized (l.class) {
                try {
                    if (f42599a == null) {
                        f42599a = new l();
                    }
                } finally {
                }
            }
        }
        return f42599a;
    }

    public ExecutorService b() {
        if (this.f42600b == null) {
            synchronized (l.class) {
                try {
                    if (this.f42600b == null) {
                        this.f42600b = Executors.newSingleThreadExecutor();
                    }
                } finally {
                }
            }
        }
        return this.f42600b;
    }
}
