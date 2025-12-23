package com.umeng.analytics.pro;

import com.umeng.commonsdk.debug.UMRTLog;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class as {

    /* renamed from: a, reason: collision with root package name */
    private static final String f40892a = "UMExecutor";

    /* renamed from: b, reason: collision with root package name */
    private static volatile ScheduledThreadPoolExecutor f40893b;

    /* renamed from: c, reason: collision with root package name */
    private static final ThreadFactory f40894c = new ThreadFactory() { // from class: com.umeng.analytics.pro.as.1

        /* renamed from: a, reason: collision with root package name */
        private final AtomicInteger f40895a = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ccg-" + this.f40895a.incrementAndGet());
        }
    };

    private static ScheduledThreadPoolExecutor a() {
        if (f40893b == null) {
            synchronized (as.class) {
                try {
                    if (f40893b == null) {
                        f40893b = new ScheduledThreadPoolExecutor(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors(), 4)), f40894c);
                        f40893b.setKeepAliveTime(3L, TimeUnit.SECONDS);
                        f40893b.allowCoreThreadTimeOut(true);
                    }
                } finally {
                }
            }
        }
        return f40893b;
    }

    public static void a(Runnable runnable, long j6, TimeUnit timeUnit) {
        try {
            a().schedule(runnable, j6, timeUnit);
        } catch (Throwable th) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "schedule error:" + th.getMessage());
        }
    }
}
