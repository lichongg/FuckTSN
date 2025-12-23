package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@CanIgnoreReturnValue
@GwtIncompatible
/* loaded from: D:\Downloads\app\classes5.dex */
abstract class WrappingScheduledExecutorService extends WrappingExecutorService implements ScheduledExecutorService {
    final ScheduledExecutorService delegate;

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture<?> schedule(Runnable runnable, long j6, TimeUnit timeUnit) {
        return this.delegate.schedule(wrapTask(runnable), j6, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final <V> ScheduledFuture<V> schedule(Callable<V> callable, long j6, TimeUnit timeUnit) {
        return this.delegate.schedule(wrapTask(callable), j6, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j6, long j7, TimeUnit timeUnit) {
        return this.delegate.scheduleAtFixedRate(wrapTask(runnable), j6, j7, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j6, long j7, TimeUnit timeUnit) {
        return this.delegate.scheduleWithFixedDelay(wrapTask(runnable), j6, j7, timeUnit);
    }

    protected WrappingScheduledExecutorService(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        this.delegate = scheduledExecutorService;
    }
}
