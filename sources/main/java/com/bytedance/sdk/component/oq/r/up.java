package com.bytedance.sdk.component.oq.r;

import com.bytedance.sdk.component.oq.qv;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up extends ScheduledThreadPoolExecutor {

    /* renamed from: j, reason: collision with root package name */
    private final ConcurrentHashMap f26657j;

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor
    protected RunnableScheduledFuture decorateTask(Runnable runnable, RunnableScheduledFuture runnableScheduledFuture) {
        if (!qv.xt.up()) {
            return super.decorateTask(runnable, runnableScheduledFuture);
        }
        RunnableScheduledFuture runnableScheduledFuture2 = (RunnableScheduledFuture) this.f26657j.get(runnable);
        if (runnableScheduledFuture2 != null) {
            return runnableScheduledFuture2;
        }
        RunnableScheduledFuture decorateTask = super.decorateTask(runnable, runnableScheduledFuture);
        this.f26657j.put(runnable, decorateTask);
        return decorateTask;
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture schedule(final Runnable runnable, final long j6, final TimeUnit timeUnit) {
        if (!qv.xt.up()) {
            return super.schedule(runnable, j6, timeUnit);
        }
        try {
            ScheduledFuture<?> schedule = super.schedule(runnable, j6, timeUnit);
            this.f26657j.remove(runnable);
            return schedule;
        } catch (OutOfMemoryError unused) {
            com.bytedance.sdk.component.oq.r.f26648j.j("PThreadScheduledThreadPoolExecutor");
            qv qvVar = qv.xt;
            qvVar.vl().schedule(new Runnable() { // from class: com.bytedance.sdk.component.oq.r.up.1
                @Override // java.lang.Runnable
                public void run() {
                    up.super.schedule(runnable, j6, timeUnit);
                    up.this.f26657j.remove(runnable);
                }
            }, qvVar.r(), TimeUnit.MILLISECONDS);
            return (ScheduledFuture) this.f26657j.get(runnable);
        }
    }

    public up(int i6, ThreadFactory threadFactory) {
        super(i6, new com.bytedance.sdk.component.oq.j.r(threadFactory, 8));
        this.f26657j = new ConcurrentHashMap();
        j();
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture scheduleAtFixedRate(final Runnable runnable, final long j6, final long j7, final TimeUnit timeUnit) {
        if (!qv.xt.up()) {
            return super.scheduleAtFixedRate(runnable, j6, j7, timeUnit);
        }
        try {
            ScheduledFuture<?> scheduleAtFixedRate = super.scheduleAtFixedRate(runnable, j6, j7, timeUnit);
            this.f26657j.remove(runnable);
            return scheduleAtFixedRate;
        } catch (OutOfMemoryError unused) {
            com.bytedance.sdk.component.oq.r.f26648j.j("PThreadScheduledThreadPoolExecutor");
            qv qvVar = qv.xt;
            qvVar.vl().schedule(new Runnable() { // from class: com.bytedance.sdk.component.oq.r.up.2
                @Override // java.lang.Runnable
                public void run() {
                    up.super.scheduleAtFixedRate(runnable, j6, j7, timeUnit);
                    up.this.f26657j.remove(runnable);
                }
            }, qvVar.r(), TimeUnit.MILLISECONDS);
            return (ScheduledFuture) this.f26657j.get(runnable);
        }
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture scheduleWithFixedDelay(final Runnable runnable, final long j6, final long j7, final TimeUnit timeUnit) {
        if (!qv.xt.up()) {
            return super.scheduleWithFixedDelay(runnable, j6, j7, timeUnit);
        }
        try {
            ScheduledFuture<?> scheduleWithFixedDelay = super.scheduleWithFixedDelay(runnable, j6, j7, timeUnit);
            this.f26657j.remove(runnable);
            return scheduleWithFixedDelay;
        } catch (OutOfMemoryError unused) {
            com.bytedance.sdk.component.oq.r.f26648j.j("PThreadScheduledThreadPoolExecutor");
            qv qvVar = qv.xt;
            qvVar.vl().schedule(new Runnable() { // from class: com.bytedance.sdk.component.oq.r.up.3
                @Override // java.lang.Runnable
                public void run() {
                    up.super.scheduleWithFixedDelay(runnable, j6, j7, timeUnit);
                    up.this.f26657j.remove(runnable);
                }
            }, qvVar.r(), TimeUnit.MILLISECONDS);
            return (ScheduledFuture) this.f26657j.get(runnable);
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void setThreadFactory(ThreadFactory threadFactory) {
        super.setThreadFactory(new com.bytedance.sdk.component.oq.j.r(threadFactory, 8));
    }

    private void j() {
        if (!qv.xt.up() || allowsCoreThreadTimeOut()) {
            return;
        }
        TimeUnit timeUnit = TimeUnit.SECONDS;
        super.setKeepAliveTime(Math.max(10L, getKeepAliveTime(timeUnit)), timeUnit);
        super.allowCoreThreadTimeOut(true);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor
    protected RunnableScheduledFuture decorateTask(Callable callable, RunnableScheduledFuture runnableScheduledFuture) {
        if (qv.xt.up()) {
            RunnableScheduledFuture runnableScheduledFuture2 = (RunnableScheduledFuture) this.f26657j.get(callable);
            if (runnableScheduledFuture2 != null) {
                return runnableScheduledFuture2;
            }
            RunnableScheduledFuture decorateTask = super.decorateTask(callable, runnableScheduledFuture);
            this.f26657j.put(callable, decorateTask);
            return decorateTask;
        }
        return super.decorateTask(callable, runnableScheduledFuture);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture schedule(final Callable callable, final long j6, final TimeUnit timeUnit) {
        if (qv.xt.up()) {
            try {
                ScheduledFuture schedule = super.schedule(callable, j6, timeUnit);
                this.f26657j.remove(callable);
                return schedule;
            } catch (OutOfMemoryError unused) {
                com.bytedance.sdk.component.oq.r.f26648j.j("PThreadScheduledThreadPoolExecutor");
                qv qvVar = qv.xt;
                qvVar.vl().schedule(new Runnable() { // from class: com.bytedance.sdk.component.oq.r.up.4
                    @Override // java.lang.Runnable
                    public void run() {
                        up.super.schedule(callable, j6, timeUnit);
                        up.this.f26657j.remove(callable);
                    }
                }, qvVar.r(), TimeUnit.MILLISECONDS);
                return (ScheduledFuture) this.f26657j.get(callable);
            }
        }
        return super.schedule(callable, j6, timeUnit);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void allowCoreThreadTimeOut(boolean z5) {
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void setKeepAliveTime(long j6, TimeUnit timeUnit) {
    }
}
