package com.beizi.ad.lance.a;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final int f12745a;

    /* renamed from: b, reason: collision with root package name */
    private static final int f12746b;

    /* renamed from: c, reason: collision with root package name */
    private static final LinkedBlockingQueue<Runnable> f12747c;

    /* renamed from: d, reason: collision with root package name */
    private static final LinkedBlockingQueue<Runnable> f12748d;

    /* renamed from: e, reason: collision with root package name */
    private static final ArrayBlockingQueue<Runnable> f12749e;

    public static ScheduledThreadPoolExecutor e() {
        return (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(4);
    }

    public static ThreadPoolExecutor a() {
        return new ThreadPoolExecutor(2, f12746b, 5L, TimeUnit.SECONDS, f12747c, new d(5, "BeiZi-adsdk-adrequest-thread-"), f());
    }

    public static ThreadPoolExecutor b() {
        return new ThreadPoolExecutor(2, f12746b, 5L, TimeUnit.SECONDS, f12747c, new d(5, "BeiZi-adsdk-adrequest-thread-"), f());
    }

    public static ThreadPoolExecutor c() {
        return new ThreadPoolExecutor(0, 2, 5L, TimeUnit.SECONDS, f12748d, new d(5, "BeiZi-adsdk-heartbeat-thread-"), f());
    }

    public static ThreadPoolExecutor d() {
        return new ThreadPoolExecutor(2, 6, 20L, TimeUnit.SECONDS, f12749e, new d(5, "BeiZi-adsdk-file-log-upload-thread-"), f());
    }

    public static RejectedExecutionHandler f() {
        return new RejectedExecutionHandler() { // from class: com.beizi.ad.lance.a.e.1
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            }
        };
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f12745a = availableProcessors;
        f12746b = Math.max((availableProcessors / 2) + 1, 4);
        f12747c = new LinkedBlockingQueue<>();
        f12748d = new LinkedBlockingQueue<>();
        f12749e = new ArrayBlockingQueue<>(50);
    }
}
