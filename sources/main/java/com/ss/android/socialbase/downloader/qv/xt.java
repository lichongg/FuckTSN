package com.ss.android.socialbase.downloader.qv;

import androidx.annotation.NonNull;

/* loaded from: D:\Downloads\app\classes6.dex */
class xt implements cw, r, up {
    private j ae;

    /* renamed from: g, reason: collision with root package name */
    private j f38958g;

    /* renamed from: j, reason: collision with root package name */
    private final int f38959j;

    /* renamed from: m, reason: collision with root package name */
    private j f38960m;
    private volatile boolean oq;
    private int qv;
    private j tl;
    private j up;
    private final int xt;
    private final Object cw = new Object();

    /* renamed from: r, reason: collision with root package name */
    private final Object f38961r = new Object();

    public void cw() {
        this.oq = true;
        synchronized (this.cw) {
            this.cw.notifyAll();
        }
        synchronized (this.f38961r) {
            this.f38961r.notifyAll();
        }
    }

    @Override // com.ss.android.socialbase.downloader.qv.r
    @NonNull
    public j j() throws av, InterruptedException {
        j jVar;
        j jVar2 = this.f38958g;
        if (jVar2 != null) {
            this.f38958g = jVar2.f38922r;
            jVar2.f38922r = null;
            return jVar2;
        }
        synchronized (this.f38961r) {
            try {
                jVar = this.ae;
                while (jVar == null) {
                    if (this.oq) {
                        throw new av("read");
                    }
                    this.f38961r.wait();
                    jVar = this.ae;
                }
                this.f38958g = jVar.f38922r;
                this.tl = null;
                this.ae = null;
                jVar.f38922r = null;
            } catch (Throwable th) {
                throw th;
            }
        }
        return jVar;
    }

    @Override // com.ss.android.socialbase.downloader.qv.cw
    @NonNull
    public j xt() throws av, InterruptedException {
        synchronized (this.cw) {
            try {
                if (this.oq) {
                    throw new av("obtain");
                }
                j jVar = this.up;
                if (jVar == null) {
                    int i6 = this.qv;
                    if (i6 < this.f38959j) {
                        this.qv = i6 + 1;
                        return new j(this.xt);
                    }
                    do {
                        this.cw.wait();
                        if (this.oq) {
                            throw new av("obtain");
                        }
                        jVar = this.up;
                    } while (jVar == null);
                }
                this.up = jVar.f38922r;
                if (jVar == this.f38960m) {
                    this.f38960m = null;
                }
                jVar.f38922r = null;
                return jVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    xt(int i6, int i7) {
        i6 = i6 < 64 ? 64 : i6;
        i7 = i7 < 8192 ? 8192 : i7;
        this.f38959j = i6;
        this.xt = i7;
    }

    @Override // com.ss.android.socialbase.downloader.qv.cw
    public void j(@NonNull j jVar) {
        synchronized (this.cw) {
            try {
                j jVar2 = this.f38960m;
                if (jVar2 == null) {
                    this.f38960m = jVar;
                    this.up = jVar;
                } else {
                    jVar2.f38922r = jVar;
                    this.f38960m = jVar;
                }
                this.cw.notify();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.qv.up
    public void xt(@NonNull j jVar) {
        synchronized (this.f38961r) {
            try {
                j jVar2 = this.tl;
                if (jVar2 == null) {
                    this.tl = jVar;
                    this.ae = jVar;
                    this.f38961r.notify();
                } else {
                    jVar2.f38922r = jVar;
                    this.tl = jVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
