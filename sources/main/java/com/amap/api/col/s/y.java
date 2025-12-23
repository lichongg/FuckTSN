package com.amap.api.col.s;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class y {

    /* renamed from: c, reason: collision with root package name */
    private static volatile y f8704c;

    /* renamed from: a, reason: collision with root package name */
    private BlockingQueue<Runnable> f8705a = new LinkedBlockingQueue();

    /* renamed from: b, reason: collision with root package name */
    private ExecutorService f8706b;

    public static y a() {
        if (f8704c == null) {
            synchronized (y.class) {
                try {
                    if (f8704c == null) {
                        f8704c = new y();
                    }
                } finally {
                }
            }
        }
        return f8704c;
    }

    public static void c() {
        if (f8704c != null) {
            synchronized (y.class) {
                try {
                    if (f8704c != null) {
                        f8704c.f8706b.shutdownNow();
                        f8704c.f8706b = null;
                        f8704c = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final void b(Runnable runnable) {
        ExecutorService executorService = this.f8706b;
        if (executorService != null) {
            executorService.execute(runnable);
        }
    }

    private y() {
        this.f8706b = null;
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        this.f8706b = new ThreadPoolExecutor(availableProcessors, availableProcessors * 2, 1L, TimeUnit.SECONDS, this.f8705a, new ThreadPoolExecutor.AbortPolicy());
    }
}
