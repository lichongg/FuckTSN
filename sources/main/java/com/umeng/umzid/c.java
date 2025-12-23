package com.umeng.umzid;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static volatile ScheduledThreadPoolExecutor f42556a;

    /* renamed from: b, reason: collision with root package name */
    public static ThreadFactory f42557b = new a();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        public AtomicInteger f42558a = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("ZIDThreadPoolExecutor" + this.f42558a.addAndGet(1));
            return thread;
        }
    }

    public static ScheduledThreadPoolExecutor a() {
        if (f42556a == null) {
            synchronized (c.class) {
                try {
                    if (f42556a == null) {
                        f42556a = new ScheduledThreadPoolExecutor(Runtime.getRuntime().availableProcessors() * 4, f42557b);
                    }
                } finally {
                }
            }
        }
        return f42556a;
    }

    public static void a(Runnable runnable) {
        try {
            a().execute(runnable);
        } catch (Throwable unused) {
        }
    }
}
