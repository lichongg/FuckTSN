package com.beizi.fusion.tool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private static final int f13711a;

    /* renamed from: b, reason: collision with root package name */
    private static final int f13712b;

    /* renamed from: c, reason: collision with root package name */
    private static final LinkedBlockingQueue<Runnable> f13713c;

    /* renamed from: d, reason: collision with root package name */
    private static final LinkedBlockingQueue<Runnable> f13714d;

    /* renamed from: e, reason: collision with root package name */
    private static final LinkedBlockingQueue<Runnable> f13715e;

    /* renamed from: f, reason: collision with root package name */
    private static final ArrayBlockingQueue<Runnable> f13716f;

    public static ThreadPoolExecutor a() {
        return new ThreadPoolExecutor(2, f13712b, 5L, TimeUnit.SECONDS, f13713c, new h(5, "afAd-"), e());
    }

    public static ThreadPoolExecutor b() {
        return new ThreadPoolExecutor(2, f13712b, 5L, TimeUnit.SECONDS, f13714d, new h(5, "afHb-"), e());
    }

    public static ThreadPoolExecutor c() {
        return new ThreadPoolExecutor(2, 20, 20L, TimeUnit.SECONDS, f13716f, new h(5, "afFu-"), e());
    }

    public static ThreadPoolExecutor d() {
        return new ThreadPoolExecutor(2, f13712b, 20L, TimeUnit.SECONDS, f13715e, new h(5, "afIt-"), e());
    }

    public static RejectedExecutionHandler e() {
        return new RejectedExecutionHandler() { // from class: com.beizi.fusion.tool.i.1
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            }
        };
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f13711a = availableProcessors;
        f13712b = Math.max((availableProcessors / 2) + 1, 4);
        f13713c = new LinkedBlockingQueue<>();
        f13714d = new LinkedBlockingQueue<>();
        f13715e = new LinkedBlockingQueue<>();
        f13716f = new ArrayBlockingQueue<>(200);
    }
}
