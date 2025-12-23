package com.bytedance.sdk.component.oq.r;

import com.bytedance.sdk.component.oq.qv;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r extends j {
    public r(int i6, int i7, long j6, TimeUnit timeUnit, BlockingQueue blockingQueue, ThreadFactory threadFactory) {
        super(i6, i7, j6, timeUnit, new com.bytedance.sdk.component.oq.j.j(blockingQueue), new com.bytedance.sdk.component.oq.j.r(threadFactory, 2));
        j();
    }

    private void j() {
        if (qv.xt.up()) {
            if (!allowsCoreThreadTimeOut()) {
                setKeepAliveTime(j(20L), TimeUnit.SECONDS);
                try {
                    super.allowCoreThreadTimeOut(true);
                } catch (Throwable unused) {
                }
            }
            com.bytedance.sdk.component.oq.r.f26648j.j(this);
        }
    }

    @Override // com.bytedance.sdk.component.oq.r.j, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.oq.xt
    public <T> Future<T> submit(Callable<T> callable) {
        if (!qv.xt.up()) {
            return super.submit(callable);
        }
        try {
            return super.submit(callable);
        } catch (OutOfMemoryError e6) {
            ExecutorService xt = xt();
            if (xt != null) {
                return xt.submit(callable);
            }
            throw e6;
        }
    }

    private ExecutorService xt() {
        com.bytedance.sdk.component.oq.r rVar = com.bytedance.sdk.component.oq.r.f26648j;
        return rVar.j("PThreadPoolExecutor", rVar.j(getQueue()));
    }

    @Override // com.bytedance.sdk.component.oq.r.j, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor, com.bytedance.sdk.component.oq.xt
    public void execute(Runnable runnable) {
        if (!qv.xt.up()) {
            super.execute(runnable);
            return;
        }
        try {
            super.execute(runnable);
        } catch (OutOfMemoryError e6) {
            ExecutorService xt = xt();
            if (xt == null) {
                throw e6;
            }
            xt.execute(runnable);
        }
    }

    @Override // com.bytedance.sdk.component.oq.r.j, java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.oq.xt
    public void setThreadFactory(ThreadFactory threadFactory) {
        super.setThreadFactory(new com.bytedance.sdk.component.oq.j.r(threadFactory, 2));
    }

    @Override // com.bytedance.sdk.component.oq.r.j, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.oq.xt
    public List shutdownNow() {
        com.bytedance.sdk.component.oq.r.f26648j.xt(this);
        return super.shutdownNow();
    }

    public r(int i6, int i7, long j6, TimeUnit timeUnit, BlockingQueue blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i6, i7, j6, timeUnit, new com.bytedance.sdk.component.oq.j.j(blockingQueue), new com.bytedance.sdk.component.oq.j.r(threadFactory, 2), rejectedExecutionHandler);
        j();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void finalize() {
        super.finalize();
        shutdown();
        com.bytedance.sdk.component.oq.r.f26648j.xt(this);
    }

    @Override // com.bytedance.sdk.component.oq.r.j, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.oq.xt
    public void shutdown() {
        super.shutdown();
        com.bytedance.sdk.component.oq.r.f26648j.xt(this);
    }

    private long j(long j6) {
        long min = Math.min(j6, getKeepAliveTime(TimeUnit.SECONDS));
        if (min > 1) {
            return min;
        }
        return 1L;
    }

    @Override // com.bytedance.sdk.component.oq.r.j, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.oq.xt
    public <T> Future<T> submit(Runnable runnable, T t5) {
        if (qv.xt.up()) {
            try {
                return super.submit(runnable, t5);
            } catch (OutOfMemoryError e6) {
                ExecutorService xt = xt();
                if (xt != null) {
                    return xt.submit(runnable, t5);
                }
                throw e6;
            }
        }
        return super.submit(runnable, t5);
    }

    @Override // com.bytedance.sdk.component.oq.r.j, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.oq.xt
    public Future submit(Runnable runnable) {
        if (qv.xt.up()) {
            try {
                return super.submit(runnable);
            } catch (OutOfMemoryError e6) {
                ExecutorService xt = xt();
                if (xt != null) {
                    return xt.submit(runnable);
                }
                throw e6;
            }
        }
        return super.submit(runnable);
    }

    @Override // com.bytedance.sdk.component.oq.r.j, java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.oq.xt
    public void allowCoreThreadTimeOut(boolean z5) {
    }
}
