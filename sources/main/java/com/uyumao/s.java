package com.uyumao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    public static volatile ScheduledThreadPoolExecutor f42628a;

    /* renamed from: b, reason: collision with root package name */
    public static volatile ExecutorService f42629b;

    /* renamed from: c, reason: collision with root package name */
    public static final ThreadFactory f42630c = new a();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        public final AtomicInteger f42631a = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "Azx-" + this.f42631a.incrementAndGet());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final Runnable f42632a;

        @Override // java.lang.Runnable
        public final void run() {
            try {
                Runnable runnable = this.f42632a;
                if (runnable != null) {
                    runnable.run();
                }
            } catch (Throwable th) {
                th.getMessage();
            }
        }

        public b(Runnable runnable) {
            this.f42632a = runnable;
        }
    }

    public static ScheduledThreadPoolExecutor a() {
        if (f42628a == null) {
            synchronized (s.class) {
                try {
                    if (f42628a == null) {
                        f42628a = new ScheduledThreadPoolExecutor(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors(), 4)), f42630c);
                        f42628a.setKeepAliveTime(3L, TimeUnit.SECONDS);
                        f42628a.allowCoreThreadTimeOut(true);
                    }
                } finally {
                }
            }
        }
        return f42628a;
    }

    public static Future<?> a(Runnable runnable) {
        try {
            if (f42629b == null) {
                synchronized (s.class) {
                    try {
                        if (f42629b == null) {
                            f42629b = Executors.newSingleThreadExecutor(f42630c);
                        }
                    } finally {
                    }
                }
            }
            return f42629b.submit(new b(runnable));
        } catch (Throwable th) {
            th.getMessage();
            return null;
        }
    }

    public static void a(Runnable runnable, long j6, TimeUnit timeUnit) {
        try {
            a().schedule(runnable, j6, timeUnit);
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
