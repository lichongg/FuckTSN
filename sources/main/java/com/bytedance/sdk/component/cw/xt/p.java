package com.bytedance.sdk.component.cw.xt;

import com.bytedance.sdk.component.cw.xt.w;
import java.io.Closeable;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class p implements Closeable {
    final h ae;
    final int cw;

    /* renamed from: g, reason: collision with root package name */
    final p f26342g;

    /* renamed from: j, reason: collision with root package name */
    final s f26343j;
    private volatile r jy;

    /* renamed from: m, reason: collision with root package name */
    final w f26344m;
    final p oq;
    final long qv;

    /* renamed from: r, reason: collision with root package name */
    final String f26345r;
    final p tl;
    final i up;
    final long vl;
    final x xt;

    public static class j {
        h ae;
        int cw;

        /* renamed from: g, reason: collision with root package name */
        p f26346g;

        /* renamed from: j, reason: collision with root package name */
        s f26347j;

        /* renamed from: m, reason: collision with root package name */
        w.j f26348m;
        p oq;
        long qv;

        /* renamed from: r, reason: collision with root package name */
        String f26349r;
        p tl;
        i up;
        long vl;
        x xt;

        public j() {
            this.cw = -1;
            this.f26348m = new w.j();
        }

        public j j(s sVar) {
            this.f26347j = sVar;
            return this;
        }

        public j xt(p pVar) {
            if (pVar != null) {
                j("cacheResponse", pVar);
            }
            this.f26346g = pVar;
            return this;
        }

        private void r(p pVar) {
            if (pVar.ae != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public j cw(p pVar) {
            if (pVar != null) {
                r(pVar);
            }
            this.oq = pVar;
            return this;
        }

        public j j(x xVar) {
            this.xt = xVar;
            return this;
        }

        public j j(int i6) {
            this.cw = i6;
            return this;
        }

        public j xt(long j6) {
            this.vl = j6;
            return this;
        }

        j(p pVar) {
            this.cw = -1;
            this.f26347j = pVar.f26343j;
            this.xt = pVar.xt;
            this.cw = pVar.cw;
            this.f26349r = pVar.f26345r;
            this.up = pVar.up;
            this.f26348m = pVar.f26344m.xt();
            this.ae = pVar.ae;
            this.tl = pVar.tl;
            this.f26346g = pVar.f26342g;
            this.oq = pVar.oq;
            this.qv = pVar.qv;
            this.vl = pVar.vl;
        }

        public j j(String str) {
            this.f26349r = str;
            return this;
        }

        public j j(i iVar) {
            this.up = iVar;
            return this;
        }

        public j j(String str, String str2) {
            this.f26348m.j(str, str2);
            return this;
        }

        public j j(w wVar) {
            this.f26348m = wVar.xt();
            return this;
        }

        public j j(h hVar) {
            this.ae = hVar;
            return this;
        }

        public j j(p pVar) {
            if (pVar != null) {
                j("networkResponse", pVar);
            }
            this.tl = pVar;
            return this;
        }

        private void j(String str, p pVar) {
            if (pVar.ae == null) {
                if (pVar.tl == null) {
                    if (pVar.f26342g == null) {
                        if (pVar.oq == null) {
                            return;
                        }
                        throw new IllegalArgumentException(str + ".priorResponse != null");
                    }
                    throw new IllegalArgumentException(str + ".cacheResponse != null");
                }
                throw new IllegalArgumentException(str + ".networkResponse != null");
            }
            throw new IllegalArgumentException(str + ".body != null");
        }

        public j j(long j6) {
            this.qv = j6;
            return this;
        }

        public p j() {
            if (this.f26347j != null) {
                if (this.xt != null) {
                    if (this.cw >= 0) {
                        if (this.f26349r != null) {
                            return new p(this);
                        }
                        throw new IllegalStateException("message == null");
                    }
                    throw new IllegalStateException("code < 0: " + this.cw);
                }
                throw new IllegalStateException("protocol == null");
            }
            throw new IllegalStateException("request == null");
        }
    }

    public s j() {
        return this.f26343j;
    }

    public w ae() {
        return this.f26344m;
    }

    public l az() {
        s sVar = this.f26343j;
        if (sVar == null) {
            return null;
        }
        return sVar.f26363m;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        h hVar = this.ae;
        if (hVar == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        hVar.close();
    }

    public int cw() {
        return this.cw;
    }

    public j g() {
        return new j(this);
    }

    public String j(String str) {
        return j(str, null);
    }

    public long jy() {
        return this.qv;
    }

    public i m() {
        return this.up;
    }

    public p oq() {
        return this.tl;
    }

    public p qv() {
        return this.oq;
    }

    public boolean r() {
        int i6 = this.cw;
        return i6 >= 200 && i6 < 300;
    }

    public h tl() {
        return this.ae;
    }

    public String toString() {
        return "Response{protocol=" + this.xt + ", code=" + this.cw + ", message=" + this.f26345r + ", url=" + this.f26343j.j() + '}';
    }

    public String up() {
        return this.f26345r;
    }

    public r vl() {
        r rVar = this.jy;
        if (rVar != null) {
            return rVar;
        }
        r j6 = r.j(this.f26344m);
        this.jy = j6;
        return j6;
    }

    public long ws() {
        return this.vl;
    }

    public x xt() {
        return this.xt;
    }

    p(j jVar) {
        this.f26343j = jVar.f26347j;
        this.xt = jVar.xt;
        this.cw = jVar.cw;
        this.f26345r = jVar.f26349r;
        this.up = jVar.up;
        this.f26344m = jVar.f26348m.j();
        this.ae = jVar.ae;
        this.tl = jVar.tl;
        this.f26342g = jVar.f26346g;
        this.oq = jVar.oq;
        this.qv = jVar.qv;
        this.vl = jVar.vl;
    }

    public String j(String str, String str2) {
        String j6 = this.f26344m.j(str);
        return j6 != null ? j6 : str2;
    }
}
