package com.ss.android.socialbase.downloader.oq;

import android.os.Process;
import com.bytedance.sdk.component.utils.vl;
import com.ss.android.socialbase.downloader.az.m;
import com.ss.android.socialbase.downloader.qv.av;
import java.io.InputStream;
import java.util.concurrent.Future;

/* loaded from: D:\Downloads\app\classes6.dex */
public class j implements xt {
    private com.ss.android.socialbase.downloader.qv.j ae;
    private int av;
    private volatile Future az;
    private final int cw;

    /* renamed from: g, reason: collision with root package name */
    private com.ss.android.socialbase.downloader.qv.j f38902g;

    /* renamed from: j, reason: collision with root package name */
    private final InputStream f38904j;
    private volatile boolean jy;

    /* renamed from: m, reason: collision with root package name */
    private com.ss.android.socialbase.downloader.qv.j f38905m;
    private com.ss.android.socialbase.downloader.qv.j oq;
    private com.ss.android.socialbase.downloader.qv.j qv;
    private com.ss.android.socialbase.downloader.qv.j tl;
    private volatile boolean vl;
    private volatile Throwable ws;
    private final int xt;

    /* renamed from: r, reason: collision with root package name */
    private final Object f38906r = new Object();
    private final Object up = new Object();

    /* renamed from: i, reason: collision with root package name */
    private final Runnable f38903i = new Runnable() { // from class: com.ss.android.socialbase.downloader.oq.j.1
        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.socialbase.downloader.qv.j r5;
            Process.setThreadPriority(10);
            do {
                try {
                    r5 = j.this.r();
                    r5.cw = j.this.f38904j.read(r5.f38921j);
                    j.this.cw(r5);
                } catch (Throwable th) {
                    try {
                        j.this.ws = th;
                        vl.j(th);
                        synchronized (j.this.up) {
                            j.this.jy = true;
                            j.this.up.notify();
                            m.j(j.this.f38904j);
                            return;
                        }
                    } catch (Throwable th2) {
                        synchronized (j.this.up) {
                            j.this.jy = true;
                            j.this.up.notify();
                            m.j(j.this.f38904j);
                            throw th2;
                        }
                    }
                }
            } while (r5.cw != -1);
            synchronized (j.this.up) {
                j.this.jy = true;
                j.this.up.notify();
            }
            m.j(j.this.f38904j);
        }
    };

    private void cw() throws Throwable {
        this.az = com.ss.android.socialbase.downloader.downloader.cw.av().submit(this.f38903i);
    }

    private void m() throws com.ss.android.socialbase.downloader.up.j {
        Throwable th = this.ws;
        if (th != null) {
            if (th instanceof av) {
                throw new com.ss.android.socialbase.downloader.up.j(1068, "async reader closed!");
            }
            m.j(th, "async_read");
        }
        throw new com.ss.android.socialbase.downloader.up.j(1069, "async reader terminated!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.ss.android.socialbase.downloader.qv.j r() throws av, InterruptedException {
        int i6;
        com.ss.android.socialbase.downloader.qv.j jVar = this.tl;
        if (jVar != null) {
            if (this.vl) {
                throw new av("");
            }
            this.tl = jVar.f38922r;
            jVar.f38922r = null;
            return jVar;
        }
        synchronized (this.f38906r) {
            try {
                if (this.vl) {
                    throw new av("");
                }
                com.ss.android.socialbase.downloader.qv.j jVar2 = this.f38905m;
                if (jVar2 == null && (i6 = this.av) < this.cw) {
                    this.av = i6 + 1;
                    return new com.ss.android.socialbase.downloader.qv.j(this.xt);
                }
                while (jVar2 == null) {
                    this.f38906r.wait();
                    if (this.vl) {
                        throw new av("");
                    }
                    jVar2 = this.f38905m;
                }
                this.tl = jVar2.f38922r;
                this.ae = null;
                this.f38905m = null;
                jVar2.f38922r = null;
                return jVar2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private com.ss.android.socialbase.downloader.qv.j up() throws com.ss.android.socialbase.downloader.up.j, InterruptedException {
        com.ss.android.socialbase.downloader.qv.j jVar;
        com.ss.android.socialbase.downloader.qv.j jVar2 = this.qv;
        if (jVar2 != null) {
            this.qv = jVar2.f38922r;
            jVar2.f38922r = null;
            return jVar2;
        }
        synchronized (this.up) {
            try {
                jVar = this.f38902g;
                if (jVar == null) {
                    do {
                        if (this.jy) {
                            m();
                        }
                        this.up.wait();
                        jVar = this.f38902g;
                    } while (jVar == null);
                }
                this.qv = jVar.f38922r;
                this.oq = null;
                this.f38902g = null;
                jVar.f38922r = null;
            } catch (Throwable th) {
                throw th;
            }
        }
        return jVar;
    }

    @Override // com.ss.android.socialbase.downloader.oq.xt
    public void xt() {
        synchronized (this.f38906r) {
            this.vl = true;
            this.f38906r.notify();
        }
        Future future = this.az;
        if (future != null) {
            try {
                future.cancel(true);
            } catch (Throwable unused) {
            }
            this.az = null;
        }
    }

    public j(InputStream inputStream, int i6, int i7) throws Throwable {
        this.f38904j = inputStream;
        this.xt = i6;
        if (i7 <= 0) {
            i7 = 1;
        } else if (i7 > 64) {
            i7 = 64;
        }
        this.cw = i7;
        cw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cw(com.ss.android.socialbase.downloader.qv.j jVar) {
        synchronized (this.up) {
            try {
                com.ss.android.socialbase.downloader.qv.j jVar2 = this.oq;
                if (jVar2 == null) {
                    this.oq = jVar;
                    this.f38902g = jVar;
                    this.up.notify();
                } else {
                    jVar2.f38922r = jVar;
                    this.oq = jVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.oq.xt
    public com.ss.android.socialbase.downloader.qv.j j() throws com.ss.android.socialbase.downloader.up.j, InterruptedException {
        return up();
    }

    @Override // com.ss.android.socialbase.downloader.oq.xt
    public void j(com.ss.android.socialbase.downloader.qv.j jVar) {
        xt(jVar);
    }

    private void xt(com.ss.android.socialbase.downloader.qv.j jVar) {
        synchronized (this.f38906r) {
            try {
                com.ss.android.socialbase.downloader.qv.j jVar2 = this.ae;
                if (jVar2 == null) {
                    this.ae = jVar;
                    this.f38905m = jVar;
                    this.f38906r.notify();
                } else {
                    jVar2.f38922r = jVar;
                    this.ae = jVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
