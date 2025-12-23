package com.baidu.mobads.sdk.internal;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class bf {

    /* renamed from: a, reason: collision with root package name */
    private static final String f10712a = "ThreadPoolFactory";

    /* renamed from: b, reason: collision with root package name */
    private static final int f10713b = 2;

    /* renamed from: c, reason: collision with root package name */
    private static final int f10714c = 60;

    /* renamed from: d, reason: collision with root package name */
    private static ThreadPoolExecutor f10715d;

    /* renamed from: e, reason: collision with root package name */
    private static LinkedBlockingQueue<Runnable> f10716e;

    /* renamed from: f, reason: collision with root package name */
    private static final ThreadFactory f10717f = new bg();

    /* renamed from: g, reason: collision with root package name */
    private static final RejectedExecutionHandler f10718g = new bi();

    public static ThreadPoolExecutor a(int i6, int i7) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i6, i7, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), f10717f);
        threadPoolExecutor.setRejectedExecutionHandler(f10718g);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static ScheduledThreadPoolExecutor a(int i6) {
        return new ScheduledThreadPoolExecutor(i6, f10717f);
    }
}
