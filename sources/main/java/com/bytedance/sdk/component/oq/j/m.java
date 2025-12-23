package com.bytedance.sdk.component.oq.j;

import com.bytedance.sdk.component.oq.qv;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m implements com.bytedance.sdk.component.oq.xt {
    private volatile RejectedExecutionHandler ae;
    private final ReentrantLock cw;

    /* renamed from: g, reason: collision with root package name */
    private volatile int f26625g;

    /* renamed from: j, reason: collision with root package name */
    private final AtomicInteger f26626j = new AtomicInteger(j(-536870912, 0));
    private ThreadPoolExecutor jy;

    /* renamed from: m, reason: collision with root package name */
    private volatile ThreadFactory f26627m;
    private final ThreadPoolExecutor oq;
    private boolean qv;

    /* renamed from: r, reason: collision with root package name */
    private final Condition f26628r;
    private volatile long tl;
    private int up;
    private volatile int vl;
    private final BlockingQueue<Runnable> xt;

    private boolean ae(int i6) {
        if (i6 == 1) {
            return true;
        }
        if (i6 == 2) {
            return com.bytedance.sdk.component.oq.cw.r.r();
        }
        return false;
    }

    private static boolean cw(int i6) {
        return i6 < 0;
    }

    private static int j(int i6) {
        return i6 & (-536870912);
    }

    private boolean r(int i6) {
        return this.f26626j.compareAndSet(i6, i6 + 1);
    }

    private boolean up(int i6) {
        return this.f26626j.compareAndSet(i6, i6 - 1);
    }

    private static int xt(int i6) {
        return i6 & 536870911;
    }

    @Override // com.bytedance.sdk.component.oq.xt
    public void allowCoreThreadTimeOut(boolean z5) {
        this.qv = true;
    }

    @Override // com.bytedance.sdk.component.oq.xt
    public int getLargestPoolSize() {
        return 0;
    }

    @Override // com.bytedance.sdk.component.oq.xt
    public int prestartAllCoreThreads() {
        return 0;
    }

    @Override // com.bytedance.sdk.component.oq.xt
    public boolean prestartCoreThread() {
        return false;
    }

    @Override // com.bytedance.sdk.component.oq.xt
    public Future<?> submit(Runnable runnable) {
        if (runnable == null) {
            return null;
        }
        FutureTask futureTask = new FutureTask(runnable, null);
        execute(futureTask);
        return futureTask;
    }

    private static boolean cw(int i6, int i7) {
        return i6 >= i7;
    }

    private static int j(int i6, int i7) {
        return i6 | i7;
    }

    private void m(int i6) {
        int i7;
        do {
            i7 = this.f26626j.get();
            if (cw(i7, i6)) {
                return;
            }
        } while (!this.f26626j.compareAndSet(i7, j(i6, xt(i7))));
    }

    private List<Runnable> r() {
        BlockingQueue<Runnable> blockingQueue = this.xt;
        ArrayList arrayList = new ArrayList();
        blockingQueue.drainTo(arrayList);
        if (!blockingQueue.isEmpty()) {
            for (Runnable runnable : (Runnable[]) blockingQueue.toArray(new Runnable[0])) {
                if (blockingQueue.remove(runnable)) {
                    if (runnable instanceof cw) {
                        arrayList.add(((cw) runnable).cw);
                    } else {
                        arrayList.add(runnable);
                    }
                }
            }
        }
        return arrayList;
    }

    private void up() {
        ReentrantLock reentrantLock = this.cw;
        reentrantLock.lock();
        try {
            cw();
            xt();
        } finally {
            reentrantLock.unlock();
        }
    }

    private static boolean xt(int i6, int i7) {
        return i6 < i7;
    }

    @Override // com.bytedance.sdk.component.oq.xt
    public boolean allowsCoreThreadTimeOut() {
        return this.qv;
    }

    @Override // com.bytedance.sdk.component.oq.xt
    public void execute(Runnable runnable) {
        cw cwVar;
        if (runnable == null) {
            return;
        }
        if (runnable instanceof cw) {
            cwVar = (cw) runnable;
            cwVar.j(this);
        } else {
            cwVar = new cw(runnable, this);
        }
        j(cwVar);
    }

    @Override // com.bytedance.sdk.component.oq.xt
    public int getActiveCount() {
        return xt(this.f26626j.get());
    }

    @Override // com.bytedance.sdk.component.oq.xt
    public long getCompletedTaskCount() {
        return 0L;
    }

    @Override // com.bytedance.sdk.component.oq.xt
    public int getCorePoolSize() {
        return this.f26625g;
    }

    @Override // com.bytedance.sdk.component.oq.xt
    public long getKeepAliveTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.tl, TimeUnit.NANOSECONDS);
    }

    @Override // com.bytedance.sdk.component.oq.xt
    public int getMaximumPoolSize() {
        return this.vl;
    }

    @Override // com.bytedance.sdk.component.oq.xt
    public int getPoolSize() {
        if (cw(this.f26626j.get(), 1073741824)) {
            return 0;
        }
        return xt(this.f26626j.get());
    }

    @Override // com.bytedance.sdk.component.oq.xt
    public BlockingQueue<Runnable> getQueue() {
        return this.xt;
    }

    @Override // com.bytedance.sdk.component.oq.xt
    public RejectedExecutionHandler getRejectedExecutionHandler() {
        return this.ae;
    }

    @Override // com.bytedance.sdk.component.oq.xt
    public long getTaskCount() {
        return 0L;
    }

    @Override // com.bytedance.sdk.component.oq.xt
    public ThreadFactory getThreadFactory() {
        return this.f26627m;
    }

    @Override // com.bytedance.sdk.component.oq.xt
    public boolean isShutdown() {
        return !cw(this.f26626j.get());
    }

    @Override // com.bytedance.sdk.component.oq.xt
    public boolean isTerminated() {
        return cw(this.f26626j.get(), 1610612736);
    }

    @Override // com.bytedance.sdk.component.oq.xt
    public boolean isTerminating() {
        int i6 = this.f26626j.get();
        return !cw(i6) && xt(i6, 1610612736);
    }

    @Override // com.bytedance.sdk.component.oq.xt
    public void purge() {
        BlockingQueue<Runnable> blockingQueue = this.xt;
        try {
            Iterator<Runnable> it = blockingQueue.iterator();
            while (it.hasNext()) {
                Runnable next = it.next();
                if ((next instanceof Future) && ((Future) next).isCancelled()) {
                    it.remove();
                }
            }
        } catch (ConcurrentModificationException unused) {
            for (Object obj : blockingQueue.toArray()) {
                if ((obj instanceof Future) && ((Future) obj).isCancelled()) {
                    blockingQueue.remove(obj);
                }
            }
        }
        xt();
    }

    @Override // com.bytedance.sdk.component.oq.xt
    public boolean remove(Runnable runnable) {
        boolean remove = this.xt.remove(runnable);
        xt();
        return remove;
    }

    @Override // com.bytedance.sdk.component.oq.xt
    public void setKeepAliveTime(long j6, TimeUnit timeUnit) {
        if (j6 < 0) {
            throw new IllegalArgumentException();
        }
        if (j6 == 0 && allowsCoreThreadTimeOut()) {
            throw new IllegalArgumentException("Core threads must have nonzero keep alive times");
        }
        this.tl = timeUnit.toNanos(j6);
    }

    @Override // com.bytedance.sdk.component.oq.xt
    public void setMaximumPoolSize(int i6) {
        if (i6 <= 0 || i6 < this.f26625g) {
            throw new IllegalArgumentException();
        }
        this.vl = i6;
        this.f26626j.get();
    }

    @Override // com.bytedance.sdk.component.oq.xt
    public void shutdown() {
        ReentrantLock reentrantLock = this.cw;
        reentrantLock.lock();
        try {
            m(0);
            reentrantLock.unlock();
            xt();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // com.bytedance.sdk.component.oq.xt
    public List<Runnable> shutdownNow() {
        ReentrantLock reentrantLock = this.cw;
        reentrantLock.lock();
        try {
            m(536870912);
            List<Runnable> r5 = r();
            reentrantLock.unlock();
            xt();
            return r5;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // com.bytedance.sdk.component.oq.xt
    public String toString() {
        int i6 = this.f26626j.get();
        return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + "[" + (xt(i6, 0) ? "Running" : cw(i6, 1610612736) ? "Terminated" : "Shutting down") + ", runnable name = , core size = " + this.f26625g + ", max size = " + this.vl + ", worker count = " + xt(i6) + ", queued tasks = " + this.xt.size() + "]";
    }

    public m(int i6, int i7, long j6, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler, ThreadPoolExecutor threadPoolExecutor) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.cw = reentrantLock;
        this.f26628r = reentrantLock.newCondition();
        if (i6 >= 0 && i7 > 0 && i7 >= i6 && j6 >= 0) {
            if (blockingQueue != null && threadFactory != null && rejectedExecutionHandler != null) {
                this.f26625g = i6;
                this.vl = i7;
                this.xt = blockingQueue;
                this.tl = timeUnit.toNanos(j6);
                this.f26627m = threadFactory;
                this.ae = rejectedExecutionHandler;
                this.oq = threadPoolExecutor;
                return;
            }
            throw null;
        }
        throw new IllegalArgumentException();
    }

    private void cw() {
        while (!up(this.f26626j.get())) {
        }
    }

    @Override // com.bytedance.sdk.component.oq.xt
    public boolean awaitTermination(long j6, TimeUnit timeUnit) throws InterruptedException {
        long nanos = timeUnit.toNanos(j6);
        ReentrantLock reentrantLock = this.cw;
        reentrantLock.lock();
        while (!cw(this.f26626j.get(), 1610612736)) {
            try {
                if (nanos <= 0) {
                    reentrantLock.unlock();
                    return false;
                }
                nanos = this.f26628r.awaitNanos(nanos);
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        reentrantLock.unlock();
        return true;
    }

    protected void finalize() {
        shutdown();
    }

    public ThreadPoolExecutor j() {
        if (this.jy == null) {
            this.jy = qv.xt.oq();
        }
        return this.jy;
    }

    @Override // com.bytedance.sdk.component.oq.xt
    public void setRejectedExecutionHandler(RejectedExecutionHandler rejectedExecutionHandler) {
        rejectedExecutionHandler.getClass();
        this.ae = rejectedExecutionHandler;
    }

    @Override // com.bytedance.sdk.component.oq.xt
    public void setThreadFactory(ThreadFactory threadFactory) {
        threadFactory.getClass();
        this.f26627m = threadFactory;
    }

    @Override // com.bytedance.sdk.component.oq.xt
    public <T> Future<T> submit(Callable<T> callable) {
        if (callable == null) {
            return null;
        }
        FutureTask futureTask = new FutureTask(callable);
        execute(futureTask);
        return futureTask;
    }

    final void xt() {
        while (true) {
            int i6 = this.f26626j.get();
            if (cw(i6) || cw(i6, 1073741824)) {
                return;
            }
            if ((j(i6) == 0 && !this.xt.isEmpty()) || xt(i6) != 0) {
                return;
            }
            ReentrantLock reentrantLock = this.cw;
            reentrantLock.lock();
            try {
                if (this.f26626j.compareAndSet(i6, j(1073741824, 0))) {
                    this.f26626j.set(j(1610612736, 0));
                    this.f26628r.signalAll();
                    return;
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Override // com.bytedance.sdk.component.oq.xt
    public <T> Future<T> submit(Runnable runnable, T t5) {
        if (runnable == null) {
            return null;
        }
        FutureTask futureTask = new FutureTask(runnable, t5);
        execute(futureTask);
        return futureTask;
    }

    final void j(Runnable runnable) {
        this.ae.rejectedExecution(runnable, this.oq);
    }

    private void j(cw cwVar) {
        int i6 = this.f26626j.get();
        if (xt(i6) < this.f26625g) {
            if (xt((Runnable) cwVar, true)) {
                qv.xt.ae();
                return;
            }
            i6 = this.f26626j.get();
        }
        if (xt(i6) == 0) {
            if (xt((Runnable) cwVar, false)) {
                qv.xt.ae();
                return;
            }
            i6 = this.f26626j.get();
        }
        if (cw(i6) && this.xt.offer(cwVar)) {
            if (!cw(this.f26626j.get()) && remove(cwVar)) {
                j(cwVar.j());
                qv.xt.ae();
                return;
            } else {
                qv.xt.ae();
                return;
            }
        }
        if (xt(i6) < this.vl && xt((Runnable) cwVar, false)) {
            qv.xt.ae();
        } else {
            j(cwVar.j());
            qv.xt.ae();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0083, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean xt(java.lang.Runnable r6, boolean r7) {
        /*
            r5 = this;
        L0:
            java.util.concurrent.atomic.AtomicInteger r0 = r5.f26626j
            int r0 = r0.get()
            int r1 = j(r0)
            r2 = 0
            if (r1 < 0) goto L1a
            if (r1 != 0) goto L19
            if (r6 != 0) goto L19
            java.util.concurrent.BlockingQueue<java.lang.Runnable> r3 = r5.xt
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L1a
        L19:
            return r2
        L1a:
            int r3 = xt(r0)
            r4 = 536870911(0x1fffffff, float:1.0842021E-19)
            if (r3 >= r4) goto L83
            if (r7 == 0) goto L28
            int r4 = r5.f26625g
            goto L2a
        L28:
            int r4 = r5.vl
        L2a:
            if (r3 < r4) goto L2d
            goto L83
        L2d:
            boolean r0 = r5.r(r0)
            if (r0 != 0) goto L40
            java.util.concurrent.atomic.AtomicInteger r0 = r5.f26626j
            int r0 = r0.get()
            int r3 = j(r0)
            if (r3 != r1) goto L0
            goto L1a
        L40:
            java.util.concurrent.locks.ReentrantLock r7 = r5.cw     // Catch: java.lang.Throwable -> L79
            r7.lock()     // Catch: java.lang.Throwable -> L79
            java.util.concurrent.atomic.AtomicInteger r0 = r5.f26626j     // Catch: java.lang.Throwable -> L6d
            int r0 = r0.get()     // Catch: java.lang.Throwable -> L6d
            int r0 = j(r0)     // Catch: java.lang.Throwable -> L6d
            if (r0 < 0) goto L55
            if (r0 != 0) goto L70
            if (r6 != 0) goto L70
        L55:
            java.util.concurrent.ThreadPoolExecutor r0 = r5.j()     // Catch: java.lang.Throwable -> L6d
            r0.execute(r6)     // Catch: java.lang.Throwable -> L6d
            java.util.concurrent.atomic.AtomicInteger r6 = r5.f26626j     // Catch: java.lang.Throwable -> L6d
            int r6 = r6.get()     // Catch: java.lang.Throwable -> L6d
            int r6 = xt(r6)     // Catch: java.lang.Throwable -> L6d
            int r0 = r5.up     // Catch: java.lang.Throwable -> L6d
            if (r6 <= r0) goto L6f
            r5.up = r6     // Catch: java.lang.Throwable -> L6d
            goto L6f
        L6d:
            r6 = move-exception
            goto L7b
        L6f:
            r2 = 1
        L70:
            r7.unlock()     // Catch: java.lang.Throwable -> L79
            if (r2 != 0) goto L78
            r5.up()
        L78:
            return r2
        L79:
            r6 = move-exception
            goto L7f
        L7b:
            r7.unlock()     // Catch: java.lang.Throwable -> L79
            throw r6     // Catch: java.lang.Throwable -> L79
        L7f:
            r5.up()
            throw r6
        L83:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.oq.j.m.xt(java.lang.Runnable, boolean):boolean");
    }

    public void j(Runnable runnable, boolean z5) {
        int i6 = this.f26626j.get();
        int xt = xt(runnable);
        if (xt(i6, 536870912)) {
            do {
                Runnable poll = this.xt.poll();
                if (poll != null) {
                    if (ae(xt) && (poll instanceof cw)) {
                        cw cwVar = (cw) poll;
                        cwVar.xt();
                        cwVar.j(xt);
                        cwVar.j((m) null);
                        poll.run();
                    } else {
                        j().execute(poll);
                        return;
                    }
                } else {
                    cw();
                    return;
                }
            } while (xt(i6, 536870912));
            xt();
            return;
        }
        xt();
    }

    @Override // com.bytedance.sdk.component.oq.xt
    public void setCorePoolSize(int i6) {
    }

    private int xt(Runnable runnable) {
        if (runnable instanceof cw) {
            return ((cw) runnable).r();
        }
        return 0;
    }
}
