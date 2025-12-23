package com.bytedance.sdk.component.oq.cw;

import com.bytedance.sdk.component.oq.qv;
import com.bytedance.sdk.component.utils.vl;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt extends j {

    /* renamed from: j, reason: collision with root package name */
    private AtomicInteger f26617j;

    @Override // com.bytedance.sdk.component.oq.cw.j
    protected void j(Runnable runnable, OutOfMemoryError outOfMemoryError) {
        super.j(runnable, outOfMemoryError);
        if (runnable != null) {
            if (runnable instanceof com.bytedance.sdk.component.oq.j.cw) {
                ((com.bytedance.sdk.component.oq.j.cw) runnable).j(false);
            } else {
                runnable = new cw(runnable);
            }
            qv.xt.g().execute(runnable);
        }
        try {
            allowCoreThreadTimeOut(false);
        } catch (Exception e6) {
            vl.cw("BigThreadPool", e6);
        }
    }

    @Override // com.bytedance.sdk.component.oq.cw.j
    protected int xt() {
        return 1;
    }

    public xt(int i6, int i7, long j6, TimeUnit timeUnit, ThreadFactory threadFactory) {
        super(i6, i7, j6, timeUnit, new SynchronousQueue(), threadFactory);
        this.f26617j = new AtomicInteger(0);
    }

    @Override // com.bytedance.sdk.component.oq.cw.j, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (runnable instanceof cw) {
            super.execute(runnable);
            return;
        }
        if (j(runnable)) {
            return;
        }
        if (!j()) {
            super.execute(runnable);
            return;
        }
        if (runnable instanceof com.bytedance.sdk.component.oq.j.cw) {
            ((com.bytedance.sdk.component.oq.j.cw) runnable).j(false);
        } else {
            runnable = new cw(runnable);
        }
        qv.xt.g().execute(runnable);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable runnable, Throwable th) {
        Runnable poll;
        super.afterExecute(runnable, th);
        BlockingQueue<Runnable> queue = qv.xt.g().getQueue();
        if (queue.size() != 0) {
            int maximumPoolSize = getMaximumPoolSize();
            if (this.f26617j.get() >= Math.max(getCorePoolSize(), maximumPoolSize / 4)) {
                return;
            }
            try {
                this.f26617j.getAndIncrement();
                int activeCount = getActiveCount();
                while (activeCount < maximumPoolSize / 2 && !isShutdown() && !isTerminated() && !isTerminating() && (poll = queue.poll()) != null) {
                    if (poll instanceof com.bytedance.sdk.component.oq.j.cw) {
                        com.bytedance.sdk.component.oq.j.cw cwVar = (com.bytedance.sdk.component.oq.j.cw) poll;
                        cwVar.j(xt());
                        cwVar.xt();
                    }
                    poll.run();
                    activeCount = getActiveCount();
                }
            } finally {
                this.f26617j.getAndDecrement();
            }
        }
    }

    @Override // com.bytedance.sdk.component.oq.cw.j
    public boolean j() {
        return getActiveCount() >= getMaximumPoolSize();
    }

    private boolean j(Runnable runnable) {
        com.bytedance.sdk.component.oq.j.cw cwVar;
        if (!r.r()) {
            return false;
        }
        if (runnable instanceof com.bytedance.sdk.component.oq.j.cw) {
            cwVar = (com.bytedance.sdk.component.oq.j.cw) runnable;
            if (!cwVar.cw()) {
                return false;
            }
        } else {
            cwVar = new cw(runnable);
        }
        com.bytedance.sdk.component.oq.j.cw.f26620j.incrementAndGet();
        cwVar.j(false);
        qv.xt.g().execute(cwVar);
        return true;
    }
}
