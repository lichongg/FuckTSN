package com.bytedance.sdk.component.oq.cw;

import com.bytedance.sdk.component.oq.ae;
import com.bytedance.sdk.component.oq.qv;
import com.bytedance.sdk.component.utils.vl;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class j extends ThreadPoolExecutor {
    public j(int i6, int i7, long j6, TimeUnit timeUnit, BlockingQueue blockingQueue, ThreadFactory threadFactory) {
        this(i6, i7, j6, timeUnit, blockingQueue, threadFactory, com.bytedance.sdk.component.oq.r.j.f26656j);
    }

    public boolean j() {
        return false;
    }

    protected int xt() {
        return 0;
    }

    public j(int i6, int i7, long j6, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i6, i7, j6, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
    }

    private void j(Runnable runnable) {
        try {
            com.bytedance.sdk.component.oq.j.cw cwVar = runnable instanceof com.bytedance.sdk.component.oq.j.cw ? (com.bytedance.sdk.component.oq.j.cw) runnable : new com.bytedance.sdk.component.oq.j.cw(runnable);
            cwVar.xt();
            qv qvVar = qv.xt;
            if (qvVar.ws() && (getCorePoolSize() <= getActiveCount() || getQueue().size() > 0)) {
                vl.xt("BaseThreadPool", "crashing drop task :".concat(String.valueOf(runnable)));
                cwVar.j(3);
                qvVar.vl().submit(cwVar);
                return;
            }
            cwVar.j(xt());
            super.execute(cwVar);
        } catch (OutOfMemoryError e6) {
            if (qv.xt.xt()) {
                ae.j(false);
            }
            j(runnable, e6);
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        j(runnable);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void setCorePoolSize(int i6) {
        try {
            super.setCorePoolSize(i6);
        } catch (Exception e6) {
            vl.j("BaseThreadPool", e6.getMessage());
        } catch (OutOfMemoryError e7) {
            j(null, e7);
        }
    }

    protected void j(Runnable runnable, OutOfMemoryError outOfMemoryError) {
        com.bytedance.sdk.component.oq.j.cw.xt = true;
    }
}
