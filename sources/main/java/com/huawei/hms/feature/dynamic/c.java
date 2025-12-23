package com.huawei.hms.feature.dynamic;

import com.huawei.hms.common.util.Logger;
import java.lang.Thread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static final String f33228a = "ExecutorsManager";

    /* renamed from: b, reason: collision with root package name */
    public static final long f33229b = 60;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        public final AtomicInteger f33230a = new AtomicInteger(1);

        /* renamed from: b, reason: collision with root package name */
        public final String f33231b;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.huawei.hms.feature.dynamic.c$a$a, reason: collision with other inner class name */
        public class C0542a implements Thread.UncaughtExceptionHandler {
            public C0542a() {
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                Logger.e(c.f33228a, thread.getName() + " : " + th.getMessage());
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f33231b + this.f33230a.getAndIncrement());
            thread.setUncaughtExceptionHandler(new C0542a());
            return thread;
        }

        public a(String str) {
            this.f33231b = str + "-thread-";
        }
    }

    public static ExecutorService a(int i6, String str) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i6, i6, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a(str));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }
}
