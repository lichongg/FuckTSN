package com.bytedance.sdk.component.cw.xt.j.up;

import com.bytedance.sdk.component.cw.j.kt;
import com.bytedance.sdk.component.cw.j.mi;
import com.bytedance.sdk.component.cw.j.w;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class g {

    /* renamed from: g, reason: collision with root package name */
    static final /* synthetic */ boolean f26264g = true;
    final int cw;
    private final xt jy;
    private final List<com.bytedance.sdk.component.cw.xt.j.up.cw> oq;
    private List<com.bytedance.sdk.component.cw.xt.j.up.cw> qv;

    /* renamed from: r, reason: collision with root package name */
    final ae f26267r;
    final j up;
    private boolean vl;
    long xt;

    /* renamed from: j, reason: collision with root package name */
    long f26265j = 0;

    /* renamed from: m, reason: collision with root package name */
    final cw f26266m = new cw();
    final cw ae = new cw();
    com.bytedance.sdk.component.cw.xt.j.up.xt tl = null;

    class cw extends com.bytedance.sdk.component.cw.j.j {
        cw() {
        }

        @Override // com.bytedance.sdk.component.cw.j.j
        protected void m_() {
            g.this.xt(com.bytedance.sdk.component.cw.xt.j.up.xt.CANCEL);
        }

        @Override // com.bytedance.sdk.component.cw.j.j
        protected IOException xt(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        public void tl() throws IOException {
            if (!xt()) {
            } else {
                throw xt((IOException) null);
            }
        }
    }

    final class j implements w {
        static final /* synthetic */ boolean cw = true;

        /* renamed from: j, reason: collision with root package name */
        boolean f26268j;
        private final com.bytedance.sdk.component.cw.j.cw up = new com.bytedance.sdk.component.cw.j.cw();
        boolean xt;

        private void j(boolean z5) throws IOException {
            g gVar;
            long min;
            g gVar2;
            synchronized (g.this) {
                g.this.ae.j();
                while (true) {
                    try {
                        gVar = g.this;
                        if (gVar.xt > 0 || this.xt || this.f26268j || gVar.tl != null) {
                            break;
                        } else {
                            gVar.vl();
                        }
                    } finally {
                        g.this.ae.tl();
                    }
                }
                gVar.ae.tl();
                g.this.qv();
                min = Math.min(g.this.xt, this.up.xt());
                gVar2 = g.this;
                gVar2.xt -= min;
            }
            gVar2.ae.j();
            try {
                g gVar3 = g.this;
                gVar3.f26267r.j(gVar3.cw, z5 && min == this.up.xt(), this.up, min);
                g.this.ae.tl();
            } catch (Throwable th) {
                throw th;
            }
        }

        j() {
        }

        @Override // com.bytedance.sdk.component.cw.j.w
        public void a_(com.bytedance.sdk.component.cw.j.cw cwVar, long j6) throws IOException {
            if (!cw && Thread.holdsLock(g.this)) {
                throw new AssertionError();
            }
            this.up.a_(cwVar, j6);
            while (this.up.xt() >= 16384) {
                j(false);
            }
        }

        @Override // com.bytedance.sdk.component.cw.j.w, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!cw && Thread.holdsLock(g.this)) {
                throw new AssertionError();
            }
            synchronized (g.this) {
                try {
                    if (this.f26268j) {
                        return;
                    }
                    if (!g.this.up.xt) {
                        if (this.up.xt() > 0) {
                            while (this.up.xt() > 0) {
                                j(true);
                            }
                        } else {
                            g gVar = g.this;
                            gVar.f26267r.j(gVar.cw, true, (com.bytedance.sdk.component.cw.j.cw) null, 0L);
                        }
                    }
                    synchronized (g.this) {
                        this.f26268j = true;
                    }
                    g.this.f26267r.xt();
                    g.this.oq();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.bytedance.sdk.component.cw.j.w, java.io.Flushable
        public void flush() throws IOException {
            if (!cw && Thread.holdsLock(g.this)) {
                throw new AssertionError();
            }
            synchronized (g.this) {
                g.this.qv();
            }
            while (this.up.xt() > 0) {
                j(false);
                g.this.f26267r.xt();
            }
        }

        @Override // com.bytedance.sdk.component.cw.j.w
        public kt j() {
            return g.this.ae;
        }
    }

    private final class xt implements mi {
        static final /* synthetic */ boolean cw = true;
        private final long ae;

        /* renamed from: j, reason: collision with root package name */
        boolean f26270j;
        boolean xt;
        private final com.bytedance.sdk.component.cw.j.cw up = new com.bytedance.sdk.component.cw.j.cw();

        /* renamed from: m, reason: collision with root package name */
        private final com.bytedance.sdk.component.cw.j.cw f26271m = new com.bytedance.sdk.component.cw.j.cw();

        @Override // com.bytedance.sdk.component.cw.j.mi
        public long j(com.bytedance.sdk.component.cw.j.cw cwVar, long j6) throws IOException {
            if (j6 < 0) {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j6)));
            }
            synchronized (g.this) {
                try {
                    xt();
                    cw();
                    if (this.f26271m.xt() == 0) {
                        return -1L;
                    }
                    com.bytedance.sdk.component.cw.j.cw cwVar2 = this.f26271m;
                    long j7 = cwVar2.j(cwVar, Math.min(j6, cwVar2.xt()));
                    g gVar = g.this;
                    long j8 = gVar.f26265j + j7;
                    gVar.f26265j = j8;
                    if (j8 >= gVar.f26267r.vl.r() / 2) {
                        g gVar2 = g.this;
                        gVar2.f26267r.j(gVar2.cw, gVar2.f26265j);
                        g.this.f26265j = 0L;
                    }
                    synchronized (g.this.f26267r) {
                        try {
                            ae aeVar = g.this.f26267r;
                            long j9 = aeVar.oq + j7;
                            aeVar.oq = j9;
                            if (j9 >= aeVar.vl.r() / 2) {
                                ae aeVar2 = g.this.f26267r;
                                aeVar2.j(0, aeVar2.oq);
                                g.this.f26267r.oq = 0L;
                            }
                        } finally {
                        }
                    }
                    return j7;
                } finally {
                }
            }
        }

        xt(long j6) {
            this.ae = j6;
        }

        private void cw() throws IOException {
            if (this.f26270j) {
                throw new IOException("stream closed");
            }
            if (g.this.tl != null) {
                throw new az(g.this.tl);
            }
        }

        private void xt() throws IOException {
            g.this.f26266m.j();
            while (this.f26271m.xt() == 0 && !this.xt && !this.f26270j) {
                try {
                    g gVar = g.this;
                    if (gVar.tl != null) {
                        break;
                    } else {
                        gVar.vl();
                    }
                } finally {
                    g.this.f26266m.tl();
                }
            }
        }

        @Override // com.bytedance.sdk.component.cw.j.mi, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (g.this) {
                this.f26270j = true;
                this.f26271m.w();
                g.this.notifyAll();
            }
            g.this.oq();
        }

        void j(com.bytedance.sdk.component.cw.j.up upVar, long j6) throws IOException {
            boolean z5;
            boolean z6;
            if (!cw && Thread.holdsLock(g.this)) {
                throw new AssertionError();
            }
            while (j6 > 0) {
                synchronized (g.this) {
                    z5 = this.xt;
                    z6 = this.f26271m.xt() + j6 > this.ae;
                }
                if (z6) {
                    upVar.tl(j6);
                    g.this.xt(com.bytedance.sdk.component.cw.xt.j.up.xt.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z5) {
                    upVar.tl(j6);
                    return;
                }
                long j7 = upVar.j(this.up, j6);
                if (j7 != -1) {
                    j6 -= j7;
                    synchronized (g.this) {
                        try {
                            boolean z7 = this.f26271m.xt() == 0;
                            this.f26271m.j(this.up);
                            if (z7) {
                                g.this.notifyAll();
                            }
                        } finally {
                        }
                    }
                } else {
                    throw new EOFException();
                }
            }
        }

        @Override // com.bytedance.sdk.component.cw.j.mi
        public kt j() {
            return g.this.f26266m;
        }
    }

    public boolean cw() {
        return this.f26267r.xt == ((this.cw & 1) == 1);
    }

    public int j() {
        return this.cw;
    }

    public synchronized List<com.bytedance.sdk.component.cw.xt.j.up.cw> r() throws IOException {
        List<com.bytedance.sdk.component.cw.xt.j.up.cw> list;
        if (!cw()) {
            throw new IllegalStateException("servers cannot read response headers");
        }
        this.f26266m.j();
        while (this.qv == null && this.tl == null) {
            try {
                vl();
            } catch (Throwable th) {
                this.f26266m.tl();
                throw th;
            }
        }
        this.f26266m.tl();
        list = this.qv;
        if (list == null) {
            throw new az(this.tl);
        }
        this.qv = null;
        return list;
    }

    public w tl() {
        synchronized (this) {
            try {
                if (!this.vl && !cw()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.up;
    }

    public synchronized boolean xt() {
        try {
            if (this.tl != null) {
                return false;
            }
            xt xtVar = this.jy;
            if (!xtVar.xt) {
                if (xtVar.f26270j) {
                }
                return true;
            }
            j jVar = this.up;
            if (jVar.xt || jVar.f26268j) {
                if (this.vl) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public mi ae() {
        return this.jy;
    }

    void g() {
        boolean xt2;
        if (!f26264g && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            this.jy.xt = true;
            xt2 = xt();
            notifyAll();
        }
        if (xt2) {
            return;
        }
        this.f26267r.xt(this.cw);
    }

    public void j(com.bytedance.sdk.component.cw.xt.j.up.xt xtVar) throws IOException {
        if (r(xtVar)) {
            this.f26267r.xt(this.cw, xtVar);
        }
    }

    public kt m() {
        return this.ae;
    }

    void oq() throws IOException {
        boolean z5;
        boolean xt2;
        if (!f26264g && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            try {
                xt xtVar = this.jy;
                if (!xtVar.xt && xtVar.f26270j) {
                    j jVar = this.up;
                    if (!jVar.xt) {
                        if (jVar.f26268j) {
                        }
                    }
                    z5 = true;
                    xt2 = xt();
                }
                z5 = false;
                xt2 = xt();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z5) {
            j(com.bytedance.sdk.component.cw.xt.j.up.xt.CANCEL);
        } else {
            if (xt2) {
                return;
            }
            this.f26267r.xt(this.cw);
        }
    }

    void qv() throws IOException {
        j jVar = this.up;
        if (jVar.f26268j) {
            throw new IOException("stream closed");
        }
        if (jVar.xt) {
            throw new IOException("stream finished");
        }
        if (this.tl != null) {
            throw new az(this.tl);
        }
    }

    public kt up() {
        return this.f26266m;
    }

    g(int i6, ae aeVar, boolean z5, boolean z6, List<com.bytedance.sdk.component.cw.xt.j.up.cw> list) {
        if (aeVar != null) {
            if (list != null) {
                this.cw = i6;
                this.f26267r = aeVar;
                this.xt = aeVar.jy.r();
                xt xtVar = new xt(aeVar.vl.r());
                this.jy = xtVar;
                j jVar = new j();
                this.up = jVar;
                xtVar.xt = z6;
                jVar.xt = z5;
                this.oq = list;
                return;
            }
            throw new NullPointerException("requestHeaders == null");
        }
        throw new NullPointerException("connection == null");
    }

    synchronized void cw(com.bytedance.sdk.component.cw.xt.j.up.xt xtVar) {
        if (this.tl == null) {
            this.tl = xtVar;
            notifyAll();
        }
    }

    void vl() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            throw new InterruptedIOException();
        }
    }

    void j(List<com.bytedance.sdk.component.cw.xt.j.up.cw> list) {
        boolean z5;
        if (!f26264g && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            z5 = true;
            try {
                this.vl = true;
                if (this.qv == null) {
                    this.qv = list;
                    z5 = xt();
                    notifyAll();
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(this.qv);
                    arrayList.add(null);
                    arrayList.addAll(list);
                    this.qv = arrayList;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z5) {
            return;
        }
        this.f26267r.xt(this.cw);
    }

    public void xt(com.bytedance.sdk.component.cw.xt.j.up.xt xtVar) {
        if (r(xtVar)) {
            this.f26267r.j(this.cw, xtVar);
        }
    }

    private boolean r(com.bytedance.sdk.component.cw.xt.j.up.xt xtVar) {
        if (!f26264g && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            try {
                if (this.tl != null) {
                    return false;
                }
                if (this.jy.xt && this.up.xt) {
                    return false;
                }
                this.tl = xtVar;
                notifyAll();
                this.f26267r.xt(this.cw);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void j(com.bytedance.sdk.component.cw.j.up upVar, int i6) throws IOException {
        if (!f26264g && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        this.jy.j(upVar, i6);
    }

    void j(long j6) {
        this.xt += j6;
        if (j6 > 0) {
            notifyAll();
        }
    }
}
