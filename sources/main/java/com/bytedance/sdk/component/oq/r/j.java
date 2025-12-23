package com.bytedance.sdk.component.oq.r;

import com.bytedance.sdk.component.oq.j.m;
import com.bytedance.sdk.component.oq.qv;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j extends ThreadPoolExecutor implements com.bytedance.sdk.component.oq.xt {

    /* renamed from: j, reason: collision with root package name */
    public static final RejectedExecutionHandler f26656j = new RejectedExecutionHandler() { // from class: com.bytedance.sdk.component.oq.r.j.1
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            if (threadPoolExecutor != null && (threadPoolExecutor instanceof ScheduledThreadPoolExecutor) && threadPoolExecutor.getCorePoolSize() == 1) {
                qv qvVar = qv.xt;
                ScheduledExecutorService vl = qvVar.vl();
                if (vl.isShutdown() || vl.isTerminated()) {
                    qvVar.g().execute(runnable);
                } else {
                    vl.execute(runnable);
                }
            } else {
                qv.xt.g().execute(runnable);
            }
            qv.xt.ae();
        }
    };
    private com.bytedance.sdk.component.oq.xt xt;

    public j(int i6, int i7, long j6, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        this(i6, i7, j6, timeUnit, blockingQueue, threadFactory, f26656j);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.oq.xt
    public Future<?> submit(Runnable runnable) {
        return this.xt.submit(runnable);
    }

    public j(int i6, int i7, long j6, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i6, i7, j6, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
        this.xt = new m(i6, i7, j6, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler, this);
        qv.xt.ae();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.oq.xt
    public void allowCoreThreadTimeOut(boolean z5) {
        this.xt.allowCoreThreadTimeOut(z5);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.oq.xt
    public boolean allowsCoreThreadTimeOut() {
        return this.xt.allowsCoreThreadTimeOut();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.oq.xt
    public boolean awaitTermination(long j6, TimeUnit timeUnit) throws InterruptedException {
        return this.xt.awaitTermination(j6, timeUnit);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor, com.bytedance.sdk.component.oq.xt
    public void execute(Runnable runnable) {
        this.xt.execute(runnable);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.oq.xt
    public int getActiveCount() {
        return this.xt.getActiveCount();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.oq.xt
    public long getCompletedTaskCount() {
        return this.xt.getCompletedTaskCount();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.oq.xt
    public int getCorePoolSize() {
        return this.xt.getCorePoolSize();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.oq.xt
    public long getKeepAliveTime(TimeUnit timeUnit) {
        return this.xt.getKeepAliveTime(timeUnit);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.oq.xt
    public int getLargestPoolSize() {
        return this.xt.getLargestPoolSize();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.oq.xt
    public int getMaximumPoolSize() {
        return this.xt.getMaximumPoolSize();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.oq.xt
    public int getPoolSize() {
        return this.xt.getPoolSize();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.oq.xt
    public BlockingQueue<Runnable> getQueue() {
        return this.xt.getQueue();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.oq.xt
    public RejectedExecutionHandler getRejectedExecutionHandler() {
        return this.xt.getRejectedExecutionHandler();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.oq.xt
    public long getTaskCount() {
        return this.xt.getTaskCount();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.oq.xt
    public ThreadFactory getThreadFactory() {
        return this.xt.getThreadFactory();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.oq.xt
    public boolean isShutdown() {
        return this.xt.isShutdown();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.oq.xt
    public boolean isTerminated() {
        return this.xt.isTerminated();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.oq.xt
    public boolean isTerminating() {
        return this.xt.isTerminating();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.oq.xt
    public int prestartAllCoreThreads() {
        return this.xt.prestartAllCoreThreads();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.oq.xt
    public boolean prestartCoreThread() {
        return this.xt.prestartCoreThread();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.oq.xt
    public void purge() {
        this.xt.purge();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.oq.xt
    public boolean remove(Runnable runnable) {
        return this.xt.remove(runnable);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.oq.xt
    public void setCorePoolSize(int i6) {
        this.xt.setCorePoolSize(i6);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.oq.xt
    public void setKeepAliveTime(long j6, TimeUnit timeUnit) {
        this.xt.setKeepAliveTime(j6, timeUnit);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.oq.xt
    public void setMaximumPoolSize(int i6) {
        this.xt.setMaximumPoolSize(i6);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.oq.xt
    public void setRejectedExecutionHandler(RejectedExecutionHandler rejectedExecutionHandler) {
        this.xt.setRejectedExecutionHandler(rejectedExecutionHandler);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.oq.xt
    public void shutdown() {
        this.xt.shutdown();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.oq.xt
    public List<Runnable> shutdownNow() {
        return this.xt.shutdownNow();
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.oq.xt
    public <T> Future<T> submit(Callable<T> callable) {
        return this.xt.submit(callable);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.oq.xt
    public String toString() {
        com.bytedance.sdk.component.oq.xt xtVar = this.xt;
        return xtVar != null ? xtVar.toString() : super.toString();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.oq.xt
    public void setThreadFactory(ThreadFactory threadFactory) {
        threadFactory.getClass();
        this.xt.setThreadFactory(threadFactory);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.oq.xt
    public <T> Future<T> submit(Runnable runnable, T t5) {
        return this.xt.submit(runnable, t5);
    }
}
