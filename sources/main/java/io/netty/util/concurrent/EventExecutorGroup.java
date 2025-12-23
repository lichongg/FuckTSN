package io.netty.util.concurrent;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface EventExecutorGroup extends ScheduledExecutorService, Iterable<EventExecutor> {
    boolean isShuttingDown();

    Iterator<EventExecutor> iterator();

    EventExecutor next();

    @Override // java.util.concurrent.ScheduledExecutorService
    ScheduledFuture<?> schedule(Runnable runnable, long j6, TimeUnit timeUnit);

    @Override // java.util.concurrent.ScheduledExecutorService
    <V> ScheduledFuture<V> schedule(Callable<V> callable, long j6, TimeUnit timeUnit);

    @Override // java.util.concurrent.ScheduledExecutorService
    ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j6, long j7, TimeUnit timeUnit);

    @Override // java.util.concurrent.ScheduledExecutorService
    ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j6, long j7, TimeUnit timeUnit);

    @Override // java.util.concurrent.ExecutorService
    @Deprecated
    void shutdown();

    Future<?> shutdownGracefully();

    Future<?> shutdownGracefully(long j6, long j7, TimeUnit timeUnit);

    @Deprecated
    List<Runnable> shutdownNow();

    Future<?> submit(Runnable runnable);

    <T> Future<T> submit(Runnable runnable, T t5);

    <T> Future<T> submit(Callable<T> callable);

    Future<?> terminationFuture();
}
