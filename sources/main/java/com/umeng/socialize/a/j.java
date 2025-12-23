package com.umeng.socialize.a;

import android.os.AsyncTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private static final String f42234a = "UMExecutor";

    /* renamed from: b, reason: collision with root package name */
    private static volatile ScheduledThreadPoolExecutor f42235b;

    /* renamed from: c, reason: collision with root package name */
    private static volatile ExecutorService f42236c;

    /* renamed from: d, reason: collision with root package name */
    private static final ThreadFactory f42237d = new ThreadFactory() { // from class: com.umeng.socialize.a.j.1

        /* renamed from: a, reason: collision with root package name */
        private final AtomicInteger f42238a = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "Azx-" + this.f42238a.incrementAndGet());
        }
    };

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final Runnable f42239a;

        @Override // java.lang.Runnable
        public final void run() {
            try {
                Runnable runnable = this.f42239a;
                if (runnable != null) {
                    runnable.run();
                }
            } catch (Throwable th) {
                m.d(j.f42234a, "error:", th.getMessage());
            }
        }

        public a(Runnable runnable) {
            this.f42239a = runnable;
        }
    }

    private static ScheduledThreadPoolExecutor a() {
        if (f42235b == null) {
            synchronized (j.class) {
                try {
                    if (f42235b == null) {
                        f42235b = new ScheduledThreadPoolExecutor(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors(), 4)), f42237d);
                        f42235b.setKeepAliveTime(3L, TimeUnit.SECONDS);
                        f42235b.allowCoreThreadTimeOut(true);
                    }
                } finally {
                }
            }
        }
        return f42235b;
    }

    private static ExecutorService b() {
        if (f42236c == null) {
            synchronized (j.class) {
                try {
                    if (f42236c == null) {
                        f42236c = Executors.newSingleThreadExecutor(f42237d);
                    }
                } finally {
                }
            }
        }
        return f42236c;
    }

    private static Runnable d(Runnable runnable) {
        return new a(runnable);
    }

    public static Future<?> c(Runnable runnable) {
        try {
            return a().submit(d(runnable));
        } catch (Throwable th) {
            m.d(f42234a, "submit error:", th.getMessage());
            return null;
        }
    }

    public static void b(Runnable runnable) {
        try {
            a().execute(d(runnable));
        } catch (Throwable th) {
            m.d(f42234a, "execute error:", th.getMessage());
        }
    }

    @SafeVarargs
    public static <Params, Progress, Result> void a(AsyncTask<Params, Progress, Result> asyncTask, Params... paramsArr) {
        if (asyncTask == null) {
            return;
        }
        try {
            asyncTask.executeOnExecutor(a(), paramsArr);
        } catch (Throwable th) {
            m.d(f42234a, "executeOnExecutor error:", th.getMessage());
        }
    }

    public static Future<?> a(Runnable runnable) {
        try {
            return b().submit(d(runnable));
        } catch (Throwable th) {
            m.d(f42234a, "submitSingleTask error:", th.getMessage());
            return null;
        }
    }

    public static void a(Runnable runnable, long j6, TimeUnit timeUnit) {
        try {
            a().schedule(runnable, j6, timeUnit);
        } catch (Throwable th) {
            m.d(f42234a, "schedule error:", th.getMessage());
        }
    }
}
