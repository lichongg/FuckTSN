package com.bytedance.sdk.component.oq.r;

import com.bytedance.sdk.component.oq.j.ae;
import com.bytedance.sdk.component.oq.qv;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw extends Thread {
    private ae proxy;

    public cw() {
    }

    @Override // java.lang.Thread
    public synchronized void start() {
        try {
            try {
                if (!isProxyEnable()) {
                    super.start();
                    return;
                }
                if (this.proxy == null) {
                    this.proxy = new ae(this);
                }
                this.proxy.start();
            } catch (OutOfMemoryError unused) {
                com.bytedance.sdk.component.oq.r.f26648j.j("PThread");
                qv qvVar = qv.xt;
                qvVar.vl().schedule(new Runnable() { // from class: com.bytedance.sdk.component.oq.r.cw.1
                    @Override // java.lang.Runnable
                    public void run() {
                        cw.super.start();
                    }
                }, qvVar.r(), TimeUnit.MILLISECONDS);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public cw(Runnable runnable) {
        super(runnable);
    }

    @Override // java.lang.Thread
    public void interrupt() {
        ae aeVar = this.proxy;
        if (aeVar != null) {
            aeVar.interrupt();
        } else {
            super.interrupt();
        }
    }

    @Override // java.lang.Thread
    public boolean isInterrupted() {
        ae aeVar = this.proxy;
        return aeVar != null ? aeVar.isInterrupted() : super.isInterrupted();
    }

    protected boolean isProxyEnable() {
        return qv.xt.xt(1);
    }

    public cw(String str) {
        super(str);
    }

    public cw(ThreadGroup threadGroup, Runnable runnable) {
        super(threadGroup, runnable);
    }

    public cw(ThreadGroup threadGroup, String str) {
        super(threadGroup, str);
    }

    public cw(Runnable runnable, String str) {
        super(runnable, str);
    }

    public cw(ThreadGroup threadGroup, Runnable runnable, String str) {
        super(threadGroup, runnable, str);
    }

    public cw(ThreadGroup threadGroup, Runnable runnable, String str, long j6) {
        super(threadGroup, runnable, str, j6);
    }
}
