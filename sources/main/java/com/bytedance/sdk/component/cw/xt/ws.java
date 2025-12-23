package com.bytedance.sdk.component.cw.xt;

import com.bytedance.sdk.component.cw.xt.ch;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class ws {
    private Runnable cw;

    /* renamed from: r, reason: collision with root package name */
    private String f26413r;
    private ExecutorService up;

    /* renamed from: j, reason: collision with root package name */
    private int f26411j = 64;
    private int xt = 5;

    /* renamed from: m, reason: collision with root package name */
    private final Deque<ch.j> f26412m = new ArrayDeque();
    private final Deque<ch.j> ae = new ArrayDeque();
    private final Deque<ch> tl = new ArrayDeque();

    public ws() {
    }

    private void cw() {
        if (this.ae.size() < this.f26411j && !this.f26412m.isEmpty()) {
            Iterator<ch.j> it = this.f26412m.iterator();
            while (it.hasNext()) {
                ch.j next = it.next();
                if (cw(next) < this.xt) {
                    it.remove();
                    this.ae.add(next);
                    if (next != null) {
                        next.xt();
                    }
                    j().execute(next);
                }
                if (this.ae.size() >= this.f26411j) {
                    return;
                }
            }
        }
    }

    public synchronized ExecutorService j() {
        String str;
        try {
            if (this.up == null) {
                String str2 = this.f26413r;
                if (str2 != null && str2.length() != 0) {
                    str = this.f26413r;
                    this.up = new com.bytedance.sdk.component.oq.r.r(0, Integer.MAX_VALUE, 20L, TimeUnit.SECONDS, new SynchronousQueue(), com.bytedance.sdk.component.cw.xt.j.cw.j(str, false));
                }
                str = TKDownloadReason.KSAD_TK_NET;
                this.up = new com.bytedance.sdk.component.oq.r.r(0, Integer.MAX_VALUE, 20L, TimeUnit.SECONDS, new SynchronousQueue(), com.bytedance.sdk.component.cw.xt.j.cw.j(str, false));
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.up;
    }

    public synchronized void xt(int i6) {
        if (i6 <= 0) {
            throw new IllegalArgumentException("max < 1: ".concat(String.valueOf(i6)));
        }
        this.xt = i6;
        cw();
    }

    public synchronized void j(int i6) {
        if (i6 > 0) {
            this.f26411j = i6;
            cw();
        } else {
            throw new IllegalArgumentException("max < 1: ".concat(String.valueOf(i6)));
        }
    }

    void xt(ch.j jVar) {
        j(this.ae, jVar, true);
    }

    public ws(String str) {
        this.f26413r = str;
    }

    void xt(ch chVar) {
        j(this.tl, chVar, false);
    }

    public synchronized int xt() {
        return this.ae.size() + this.tl.size();
    }

    private int cw(ch.j jVar) {
        Iterator<ch.j> it = this.ae.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            if (it.next().j().equals(jVar.j())) {
                i6++;
            }
        }
        return i6;
    }

    synchronized void j(ch.j jVar) {
        try {
            if (this.ae.size() < this.f26411j && cw(jVar) < this.xt) {
                this.ae.add(jVar);
                if (jVar != null) {
                    jVar.xt();
                }
                j().execute(jVar);
                return;
            }
            this.f26412m.add(jVar);
        } catch (Throwable unused) {
        }
    }

    synchronized void j(ch chVar) {
        this.tl.add(chVar);
    }

    private <T> void j(Deque<T> deque, T t5, boolean z5) {
        int xt;
        Runnable runnable;
        synchronized (this) {
            try {
                if (deque.remove(t5)) {
                    if (z5) {
                        cw();
                    }
                    xt = xt();
                    runnable = this.cw;
                } else {
                    throw new AssertionError("Call wasn't in-flight!");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (xt != 0 || runnable == null) {
            return;
        }
        runnable.run();
    }
}
