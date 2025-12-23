package com.huawei.hmf.tasks.a;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes5.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    private static final a f33027b = new a();

    /* renamed from: c, reason: collision with root package name */
    private static final int f33028c;

    /* renamed from: d, reason: collision with root package name */
    private static final int f33029d;

    /* renamed from: e, reason: collision with root package name */
    private static final int f33030e;

    /* renamed from: a, reason: collision with root package name */
    private final Executor f33031a = new ExecutorC0540a(0);

    /* renamed from: com.huawei.hmf.tasks.a.a$a, reason: collision with other inner class name */
    static class ExecutorC0540a implements Executor {
        private ExecutorC0540a() {
        }

        /* synthetic */ ExecutorC0540a(byte b6) {
            this();
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f33028c = availableProcessors;
        f33029d = availableProcessors + 1;
        f33030e = (availableProcessors * 2) + 1;
    }

    public static ExecutorService a() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f33029d, f33030e, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static Executor b() {
        return f33027b.f33031a;
    }
}
