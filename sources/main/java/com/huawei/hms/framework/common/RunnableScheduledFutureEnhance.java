package com.huawei.hms.framework.common;

import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class RunnableScheduledFutureEnhance<T> implements RunnableScheduledFuture<T> {

    /* renamed from: a, reason: collision with root package name */
    private RunnableScheduledFuture<T> f33345a;

    /* renamed from: b, reason: collision with root package name */
    private String f33346b = Thread.currentThread().getName();

    @Override // java.util.concurrent.Future
    public T get() throws ExecutionException, InterruptedException {
        return this.f33345a.get();
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z5) {
        return this.f33345a.cancel(z5);
    }

    @Override // java.lang.Comparable
    public int compareTo(Delayed delayed) {
        return this.f33345a.compareTo(delayed);
    }

    public boolean equals(Object obj) {
        return this.f33345a.equals(obj);
    }

    @Override // java.util.concurrent.Future
    public T get(long j6, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return this.f33345a.get(j6, timeUnit);
    }

    @Override // java.util.concurrent.Delayed
    public long getDelay(TimeUnit timeUnit) {
        return this.f33345a.getDelay(timeUnit);
    }

    public String getParentName() {
        return this.f33346b;
    }

    public int hashCode() {
        return this.f33345a.hashCode();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.f33345a.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.f33345a.isDone();
    }

    @Override // java.util.concurrent.RunnableScheduledFuture
    public boolean isPeriodic() {
        return this.f33345a.isPeriodic();
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        this.f33345a.run();
    }

    public RunnableScheduledFutureEnhance(RunnableScheduledFuture<T> runnableScheduledFuture) {
        this.f33345a = runnableScheduledFuture;
    }
}
