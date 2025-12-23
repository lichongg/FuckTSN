package com.huawei.hms.framework.common;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class ExecutorsUtils {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33307a = "NetworkKit_";

    public static ThreadFactory createThreadFactory(final String str) {
        if (str == null || str.trim().isEmpty()) {
            throw new NullPointerException("ThreadName is empty");
        }
        return new ThreadFactory() { // from class: com.huawei.hms.framework.common.ExecutorsUtils.1

            /* renamed from: a, reason: collision with root package name */
            private final AtomicInteger f33308a = new AtomicInteger(0);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return ExecutorsUtils.newThread(runnable, str + "_" + this.f33308a.getAndIncrement());
            }
        };
    }

    public static Thread newThread(Runnable runnable, String str) {
        return new Thread(runnable, f33307a + str);
    }

    public static ExecutorService newCachedThreadPool(String str) {
        ThreadPoolExcutorEnhance threadPoolExcutorEnhance = new ThreadPoolExcutorEnhance(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), createThreadFactory(str));
        threadPoolExcutorEnhance.allowCoreThreadTimeOut(true);
        return threadPoolExcutorEnhance;
    }

    public static ExecutorService newFixedThreadPool(int i6, String str) {
        ThreadPoolExcutorEnhance threadPoolExcutorEnhance = new ThreadPoolExcutorEnhance(i6, i6, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), createThreadFactory(str));
        threadPoolExcutorEnhance.allowCoreThreadTimeOut(true);
        return threadPoolExcutorEnhance;
    }

    public static ScheduledExecutorService newScheduledThreadPool(int i6, String str) {
        return new ScheduledThreadPoolExecutorEnhance(i6, createThreadFactory(str));
    }

    public static ExecutorService newSingleThreadExecutor(String str) {
        return ExecutorsEnhance.newSingleThreadExecutor(createThreadFactory(str));
    }
}
