package com.bytedance.sdk.component.oq.j;

import com.bytedance.sdk.component.oq.g;
import com.bytedance.sdk.component.oq.qv;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class ae extends Thread {
    private final Thread cw;

    /* renamed from: j, reason: collision with root package name */
    private volatile Thread f26618j;
    private volatile boolean xt;

    @Override // java.lang.Thread
    public synchronized void start() {
        if (this.xt) {
            return;
        }
        this.xt = true;
        qv.xt.oq().execute(new com.bytedance.sdk.component.oq.cw.cw(new g(this.cw.getName()) { // from class: com.bytedance.sdk.component.oq.j.ae.1
            @Override // java.lang.Runnable
            public void run() {
                if (qv.xt.az()) {
                    ae.this.j();
                } else {
                    ae.this.xt();
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        Thread currentThread = Thread.currentThread();
        String name = currentThread.getName();
        try {
            xt cw = qv.xt.cw();
            String name2 = this.cw.getName();
            if (cw != null) {
                name2 = cw.j(name2);
            }
            currentThread.setName(name2);
            this.f26618j = currentThread;
            currentThread.setPriority(this.cw.getPriority());
            this.cw.run();
            currentThread.setName(name);
        } catch (Throwable th) {
            currentThread.setName(name);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt() {
        Thread currentThread = Thread.currentThread();
        this.f26618j = currentThread;
        currentThread.setPriority(this.cw.getPriority());
        this.cw.run();
    }

    @Override // java.lang.Thread
    public void interrupt() {
        if (this.f26618j != null) {
            this.f26618j.interrupt();
        }
    }

    @Override // java.lang.Thread
    public boolean isInterrupted() {
        if (this.f26618j != null) {
            return this.f26618j.isInterrupted();
        }
        return true;
    }

    public ae(Thread thread) {
        this.cw = thread;
    }
}
