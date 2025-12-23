package com.huawei.hms.hatool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class e {

    /* renamed from: b, reason: collision with root package name */
    private static e f33541b;

    /* renamed from: c, reason: collision with root package name */
    private static e f33542c;

    /* renamed from: d, reason: collision with root package name */
    private static e f33543d;

    /* renamed from: a, reason: collision with root package name */
    private ThreadPoolExecutor f33544a = new ThreadPoolExecutor(0, 1, 60000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(5000), new b());

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private Runnable f33545a;

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = this.f33545a;
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Exception unused) {
                    j1.l("hmsSdk", "InnerTask : Exception has happened,From internal operations!");
                }
            }
        }

        public a(Runnable runnable) {
            this.f33545a = runnable;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b implements ThreadFactory {

        /* renamed from: d, reason: collision with root package name */
        private static final AtomicInteger f33546d = new AtomicInteger(1);

        /* renamed from: a, reason: collision with root package name */
        private final ThreadGroup f33547a;

        /* renamed from: b, reason: collision with root package name */
        private final AtomicInteger f33548b = new AtomicInteger(1);

        /* renamed from: c, reason: collision with root package name */
        private final String f33549c;

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(this.f33547a, runnable, this.f33549c + this.f33548b.getAndIncrement(), 0L);
        }

        b() {
            ThreadGroup threadGroup;
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                threadGroup = securityManager.getThreadGroup();
            } else {
                threadGroup = Thread.currentThread().getThreadGroup();
            }
            this.f33547a = threadGroup;
            this.f33549c = "FormalHASDK-base-" + f33546d.getAndIncrement();
        }
    }

    static {
        new e();
        new e();
        f33541b = new e();
        f33542c = new e();
        f33543d = new e();
    }

    public static e a() {
        return f33543d;
    }

    public static e c() {
        return f33542c;
    }

    public static e d() {
        return f33541b;
    }

    public void b(v vVar) {
        try {
            this.f33544a.execute(new a(vVar));
        } catch (RejectedExecutionException unused) {
            j1.l("hmsSdk", "addToQueue() Exception has happened!Form rejected execution");
        }
    }

    private e() {
    }
}
