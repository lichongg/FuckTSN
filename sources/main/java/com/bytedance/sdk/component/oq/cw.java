package com.bytedance.sdk.component.oq;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw {

    protected static class j extends AbstractExecutorService {

        /* renamed from: j, reason: collision with root package name */
        private final ExecutorService f26614j;

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
            return this.f26614j.invokeAll(collection);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
            return (T) this.f26614j.invokeAny(collection);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public Future<?> submit(Runnable runnable) {
            return this.f26614j.submit(runnable);
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean awaitTermination(long j6, TimeUnit timeUnit) throws InterruptedException {
            return this.f26614j.awaitTermination(j6, timeUnit);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f26614j.execute(runnable);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j6, TimeUnit timeUnit) throws InterruptedException {
            return this.f26614j.invokeAll(collection, j6, timeUnit);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j6, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            return (T) this.f26614j.invokeAny(collection, j6, timeUnit);
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isShutdown() {
            return this.f26614j.isShutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isTerminated() {
            return this.f26614j.isTerminated();
        }

        @Override // java.util.concurrent.ExecutorService
        public void shutdown() {
            this.f26614j.shutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public List<Runnable> shutdownNow() {
            return this.f26614j.shutdownNow();
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> Future<T> submit(Callable<T> callable) {
            return this.f26614j.submit(callable);
        }

        j(ExecutorService executorService) {
            this.f26614j = executorService;
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> Future<T> submit(Runnable runnable, T t5) {
            return this.f26614j.submit(runnable, t5);
        }
    }

    protected static class xt extends j implements ScheduledExecutorService {

        /* renamed from: j, reason: collision with root package name */
        private final ScheduledExecutorService f26616j;

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture<?> schedule(Runnable runnable, long j6, TimeUnit timeUnit) {
            return this.f26616j.schedule(runnable, j6, timeUnit);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public <V> ScheduledFuture<V> schedule(Callable<V> callable, long j6, TimeUnit timeUnit) {
            return this.f26616j.schedule(callable, j6, timeUnit);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j6, long j7, TimeUnit timeUnit) {
            return this.f26616j.scheduleAtFixedRate(runnable, j6, j7, timeUnit);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j6, long j7, TimeUnit timeUnit) {
            return this.f26616j.scheduleWithFixedDelay(runnable, j6, j7, timeUnit);
        }

        xt(ScheduledExecutorService scheduledExecutorService) {
            super(scheduledExecutorService);
            this.f26616j = scheduledExecutorService;
        }
    }

    public static ExecutorService j(ThreadFactory threadFactory) {
        return new C0414cw(new com.bytedance.sdk.component.oq.r.r(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), threadFactory));
    }

    /* renamed from: com.bytedance.sdk.component.oq.cw$cw, reason: collision with other inner class name */
    protected static class C0414cw extends j {
        C0414cw(ExecutorService executorService) {
            super(executorService);
        }

        protected void finalize() {
            super.shutdown();
        }
    }

    public static ScheduledExecutorService cw(ThreadFactory threadFactory) {
        return new xt(new ScheduledThreadPoolExecutor(1, threadFactory));
    }

    public static ScheduledExecutorService j(int i6, ThreadFactory threadFactory) {
        return new com.bytedance.sdk.component.oq.r.up(i6, threadFactory);
    }

    public static ExecutorService xt(ThreadFactory threadFactory) {
        return new com.bytedance.sdk.component.oq.r.r(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory);
    }
}
