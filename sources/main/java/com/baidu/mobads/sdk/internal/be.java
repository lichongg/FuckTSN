package com.baidu.mobads.sdk.internal;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class be {

    /* renamed from: a, reason: collision with root package name */
    private static final String f10708a = "TaskScheduler";

    /* renamed from: d, reason: collision with root package name */
    private static volatile be f10709d;

    /* renamed from: b, reason: collision with root package name */
    private ThreadPoolExecutor f10710b;

    /* renamed from: c, reason: collision with root package name */
    private ScheduledThreadPoolExecutor f10711c;

    public static be a() {
        if (f10709d == null) {
            synchronized (be.class) {
                try {
                    if (f10709d == null) {
                        f10709d = new be();
                    }
                } finally {
                }
            }
        }
        return f10709d;
    }

    private void b() {
        this.f10710b = bf.a(1, 1);
        this.f10711c = bf.a(1);
    }

    private be() {
        b();
    }

    public void a(Runnable runnable) {
        ThreadPoolExecutor threadPoolExecutor;
        if (runnable == null || (threadPoolExecutor = this.f10710b) == null || threadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            this.f10710b.submit(runnable);
        } catch (Throwable unused) {
        }
    }

    public void a(j jVar) {
        ThreadPoolExecutor threadPoolExecutor;
        if (jVar == null || (threadPoolExecutor = this.f10710b) == null || threadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            jVar.a(System.currentTimeMillis());
            ThreadPoolExecutor threadPoolExecutor2 = this.f10710b;
            jVar.a((Future) ((threadPoolExecutor2 == null || threadPoolExecutor2.isShutdown()) ? null : (FutureTask) this.f10710b.submit(jVar)));
        } catch (Throwable unused) {
        }
    }

    public void a(j jVar, long j6, TimeUnit timeUnit) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        if (jVar == null || (scheduledThreadPoolExecutor = this.f10711c) == null || scheduledThreadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            jVar.a(System.currentTimeMillis());
            jVar.a((Future) this.f10711c.schedule(jVar, j6, timeUnit));
        } catch (Throwable unused) {
        }
    }

    public void a(j jVar, long j6, long j7, TimeUnit timeUnit) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        if (jVar == null || (scheduledThreadPoolExecutor = this.f10711c) == null || scheduledThreadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            jVar.a(System.currentTimeMillis());
            jVar.a((Future) this.f10711c.scheduleAtFixedRate(jVar, j6, j7, timeUnit));
        } catch (Throwable unused) {
        }
    }
}
