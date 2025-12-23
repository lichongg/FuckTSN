package com.bytedance.sdk.component.oq.cw;

import com.bytedance.sdk.component.oq.ae;
import com.bytedance.sdk.component.oq.qv;
import com.bytedance.sdk.component.utils.vl;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r extends j {

    /* renamed from: j, reason: collision with root package name */
    private ScheduledFuture<?> f26615j;

    /* JADX WARN: Removed duplicated region for block: B:11:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0021 A[RETURN] */
    @Override // com.bytedance.sdk.component.oq.cw.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void j(java.lang.Runnable r3, java.lang.OutOfMemoryError r4) {
        /*
            r2 = this;
            super.j(r3, r4)
            r0 = 0
            if (r3 == 0) goto L11
            java.util.concurrent.BlockingQueue r1 = r2.getQueue()     // Catch: java.lang.Throwable -> Lf
            boolean r3 = r1.offer(r3)     // Catch: java.lang.Throwable -> Lf
            goto L15
        Lf:
            goto L1e
        L11:
            r3 = 1
            com.bytedance.sdk.component.oq.ae.j(r0)     // Catch: java.lang.Throwable -> L1c
        L15:
            r2.allowCoreThreadTimeOut(r0)     // Catch: java.lang.Throwable -> L19
            goto L1f
        L19:
            r0 = r3
            goto L1e
        L1c:
            r0 = 1
        L1e:
            r3 = r0
        L1f:
            if (r3 == 0) goto L22
            return
        L22:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.oq.cw.r.j(java.lang.Runnable, java.lang.OutOfMemoryError):void");
    }

    @Override // com.bytedance.sdk.component.oq.cw.j
    protected int xt() {
        return 2;
    }

    public static boolean r() {
        ThreadPoolExecutor g6 = qv.xt.g();
        if (g6.getQueue().size() != 0 || g6.isShutdown() || g6.isTerminated()) {
            return false;
        }
        int activeCount = g6.getActiveCount();
        int corePoolSize = g6.getCorePoolSize();
        return activeCount < corePoolSize + (-1) && com.bytedance.sdk.component.oq.j.cw.f26620j.get() < corePoolSize / 2;
    }

    public void cw() {
        ScheduledFuture<?> scheduledFuture = this.f26615j;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
    }

    public r(int i6, int i7, long j6, TimeUnit timeUnit, BlockingQueue blockingQueue, ThreadFactory threadFactory) {
        super(i6, i7, j6, timeUnit, blockingQueue, threadFactory);
    }

    private boolean m() {
        BlockingQueue<Runnable> queue = getQueue();
        int corePoolSize = getCorePoolSize();
        int i6 = corePoolSize * 2;
        int min = Math.min(corePoolSize + 4, ae.f26611j);
        if (corePoolSize < min && queue != null && queue.size() >= i6) {
            try {
                setCorePoolSize(min);
                return true;
            } catch (Exception e6) {
                vl.j("BizCoreThreadPool", e6.getMessage());
                return false;
            }
        }
        return false;
    }

    private void up() {
        BlockingQueue<Runnable> queue = getQueue();
        int tl = qv.xt.tl();
        if (getCorePoolSize() != tl && queue != null && queue.size() == 0) {
            setCorePoolSize(tl);
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        if (ae.up()) {
            up();
        }
    }

    @Override // com.bytedance.sdk.component.oq.cw.j, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (ae.up()) {
            m();
        }
        super.execute(runnable);
    }

    @Override // com.bytedance.sdk.component.oq.cw.j
    public boolean j() {
        BlockingQueue<Runnable> queue = getQueue();
        return queue != null && queue.size() > getCorePoolSize() * 2;
    }
}
