package com.bytedance.sdk.component.xt.j.j.xt;

import com.bytedance.sdk.component.xt.j.j.xt.j;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r extends com.bytedance.sdk.component.xt.j.r {

    /* renamed from: j, reason: collision with root package name */
    private ExecutorService f27289j;
    private final Deque<j.C0425j> xt = new ArrayDeque();
    private final Deque<j.C0425j> cw = new ArrayDeque();

    /* renamed from: r, reason: collision with root package name */
    private final Deque<j> f27290r = new ArrayDeque();
    private AtomicInteger up = new AtomicInteger(64);

    @Override // com.bytedance.sdk.component.xt.j.r
    public void j(int i6) {
        this.up.set(i6);
    }

    @Override // com.bytedance.sdk.component.xt.j.r
    public void xt(int i6) {
    }

    private void cw() {
        if (this.cw.size() < j() && !this.xt.isEmpty()) {
            Iterator<j.C0425j> it = this.xt.iterator();
            while (it.hasNext()) {
                j.C0425j next = it.next();
                it.remove();
                this.cw.add(next);
                if (next != null) {
                    next.j();
                }
                xt().submit(next);
                if (this.cw.size() >= j()) {
                    return;
                }
            }
        }
    }

    @Override // com.bytedance.sdk.component.xt.j.r
    public int j() {
        return this.up.get();
    }

    @Override // com.bytedance.sdk.component.xt.j.r
    public ExecutorService xt() {
        return this.f27289j;
    }

    public r() {
        if (this.f27289j == null) {
            this.f27289j = new com.bytedance.sdk.component.oq.r.r(0, Integer.MAX_VALUE, 20L, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadFactory() { // from class: com.bytedance.sdk.component.xt.j.j.xt.r.1
                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(Runnable runnable) {
                    com.bytedance.sdk.component.oq.r.cw cwVar = new com.bytedance.sdk.component.oq.r.cw(runnable, "systemHttp Dispatcher");
                    cwVar.setDaemon(false);
                    cwVar.setPriority(10);
                    return cwVar;
                }
            });
        }
    }

    public synchronized void j(j.C0425j c0425j) {
        try {
            if (this.cw.size() < j()) {
                this.cw.add(c0425j);
                if (c0425j != null) {
                    c0425j.j();
                }
                xt().submit(c0425j);
                return;
            }
            this.xt.add(c0425j);
        } catch (Throwable unused) {
        }
    }

    void xt(j.C0425j c0425j) {
        j(this.cw, c0425j, true);
    }

    void xt(j jVar) {
        j(this.f27290r, jVar, false);
    }

    synchronized void j(j jVar) {
        this.f27290r.add(jVar);
    }

    private <T> void j(Deque<T> deque, T t5, boolean z5) {
        synchronized (this) {
            try {
                deque.remove(t5);
                if (z5) {
                    cw();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
