package com.bytedance.sdk.component.cw.xt.j.xt;

import com.bytedance.sdk.component.cw.xt.av;
import com.bytedance.sdk.component.cw.xt.j.up.az;
import com.bytedance.sdk.component.cw.xt.j.xt.m;
import com.bytedance.sdk.component.cw.xt.kt;
import com.bytedance.sdk.component.cw.xt.la;
import com.bytedance.sdk.component.cw.xt.oq;
import com.bytedance.sdk.component.cw.xt.v;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class ae {

    /* renamed from: r, reason: collision with root package name */
    static final /* synthetic */ boolean f26305r = true;
    private final oq ae;
    private com.bytedance.sdk.component.cw.xt.j.cw.cw az;
    public final av cw;

    /* renamed from: g, reason: collision with root package name */
    private final m f26306g;

    /* renamed from: j, reason: collision with root package name */
    public final com.bytedance.sdk.component.cw.xt.j f26307j;
    private boolean jy;

    /* renamed from: m, reason: collision with root package name */
    private la f26308m;
    private int oq;
    private cw qv;
    private final Object tl;
    private m.j up;
    private boolean vl;
    private boolean ws;
    public final com.bytedance.sdk.component.cw.xt.up xt;

    public com.bytedance.sdk.component.cw.xt.j.cw.cw j(v vVar, kt.j jVar, boolean z5) {
        try {
            com.bytedance.sdk.component.cw.xt.j.cw.cw j6 = j(jVar.xt(), jVar.cw(), jVar.r(), vVar.w(), z5).j(vVar, jVar, this);
            synchronized (this.ae) {
                this.az = j6;
            }
            return j6;
        } catch (IOException e6) {
            throw new up(e6);
        }
    }

    public synchronized cw xt() {
        return this.qv;
    }

    public static final class j extends WeakReference<ae> {

        /* renamed from: j, reason: collision with root package name */
        public final Object f26309j;

        j(ae aeVar, Object obj) {
            super(aeVar);
            this.f26309j = obj;
        }
    }

    private Socket ae() {
        if (!f26305r && !Thread.holdsLock(this.ae)) {
            throw new AssertionError();
        }
        cw cwVar = this.qv;
        if (cwVar == null || !cwVar.f26311j) {
            return null;
        }
        return j(false, false, true);
    }

    private r tl() {
        return com.bytedance.sdk.component.cw.xt.j.j.f26187j.j(this.ae);
    }

    private void xt(cw cwVar) {
        int size = cwVar.f26312r.size();
        for (int i6 = 0; i6 < size; i6++) {
            if (cwVar.f26312r.get(i6).get() == this) {
                cwVar.f26312r.remove(i6);
                return;
            }
        }
        throw new IllegalStateException();
    }

    public void cw() {
        Socket j6;
        synchronized (this.ae) {
            j6 = j(false, true, false);
        }
        com.bytedance.sdk.component.cw.xt.j.cw.j(j6);
    }

    public boolean m() {
        if (this.f26308m != null) {
            return true;
        }
        m.j jVar = this.up;
        return (jVar != null && jVar.j()) || this.f26306g.j();
    }

    public void r() {
        Socket j6;
        synchronized (this.ae) {
            j6 = j(true, false, false);
        }
        com.bytedance.sdk.component.cw.xt.j.cw.j(j6);
    }

    public void up() {
        com.bytedance.sdk.component.cw.xt.j.cw.cw cwVar;
        cw cwVar2;
        synchronized (this.ae) {
            this.ws = true;
            cwVar = this.az;
            cwVar2 = this.qv;
        }
        if (cwVar != null) {
            cwVar.cw();
        } else if (cwVar2 != null) {
            cwVar2.xt();
        }
    }

    public ae(oq oqVar, com.bytedance.sdk.component.cw.xt.j jVar, com.bytedance.sdk.component.cw.xt.up upVar, av avVar, Object obj) throws IOException {
        this.ae = oqVar;
        this.f26307j = jVar;
        this.xt = upVar;
        this.cw = avVar;
        this.f26306g = new m(jVar, tl(), upVar, avVar);
        this.tl = obj;
    }

    public String toString() {
        cw xt = xt();
        if (xt != null) {
            return xt.toString();
        }
        return this.f26307j.toString();
    }

    private cw j(int i6, int i7, int i8, boolean z5, boolean z6) throws IOException {
        while (true) {
            cw j6 = j(i6, i7, i8, z5);
            synchronized (this.ae) {
                try {
                    if (j6.xt == 0) {
                        return j6;
                    }
                    if (j6.j(z6)) {
                        return j6;
                    }
                    r();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private cw j(int i6, int i7, int i8, boolean z5) throws IOException {
        Socket ae;
        cw cwVar;
        Socket socket;
        la laVar;
        boolean z6;
        boolean z7;
        cw cwVar2;
        m.j jVar;
        synchronized (this.ae) {
            try {
                if (!this.jy) {
                    if (this.az == null) {
                        if (!this.ws) {
                            ae = ae();
                            cwVar = this.qv;
                            socket = null;
                            if (cwVar == null) {
                                cwVar = null;
                            }
                            if (cwVar == null) {
                                com.bytedance.sdk.component.cw.xt.j.j.f26187j.j(this.ae, this.f26307j, this, null);
                                cw cwVar3 = this.qv;
                                if (cwVar3 != null) {
                                    cwVar = cwVar3;
                                    z6 = true;
                                    laVar = null;
                                } else {
                                    laVar = this.f26308m;
                                }
                            } else {
                                laVar = null;
                            }
                            z6 = false;
                        } else {
                            throw new IOException("Canceled");
                        }
                    } else {
                        throw new IllegalStateException("codec != null");
                    }
                } else {
                    throw new IllegalStateException("released");
                }
            } finally {
            }
        }
        com.bytedance.sdk.component.cw.xt.j.cw.j(ae);
        if (cwVar != null) {
            return cwVar;
        }
        if (laVar != null || ((jVar = this.up) != null && jVar.j())) {
            z7 = false;
        } else {
            this.up = this.f26306g.xt();
            z7 = true;
        }
        synchronized (this.ae) {
            try {
                if (this.ws) {
                    throw new IOException("Canceled");
                }
                if (z7) {
                    List<la> cw = this.up.cw();
                    int size = cw.size();
                    int i9 = 0;
                    while (true) {
                        if (i9 >= size) {
                            break;
                        }
                        la laVar2 = cw.get(i9);
                        com.bytedance.sdk.component.cw.xt.j.j.f26187j.j(this.ae, this.f26307j, this, laVar2);
                        cw cwVar4 = this.qv;
                        if (cwVar4 != null) {
                            this.f26308m = laVar2;
                            cwVar = cwVar4;
                            z6 = true;
                            break;
                        }
                        i9++;
                    }
                }
                if (!z6) {
                    if (laVar == null) {
                        laVar = this.up.xt();
                    }
                    this.f26308m = laVar;
                    this.oq = 0;
                    cwVar = new cw(this.ae, laVar);
                    j(cwVar, false);
                }
                cwVar2 = cwVar;
            } finally {
            }
        }
        if (z6) {
            return cwVar2;
        }
        cwVar2.j(i6, i7, i8, z5, this.xt, this.cw);
        tl().xt(cwVar2.j());
        synchronized (this.ae) {
            try {
                this.vl = true;
                com.bytedance.sdk.component.cw.xt.j.j.f26187j.xt(this.ae, cwVar2);
                if (cwVar2.up()) {
                    socket = com.bytedance.sdk.component.cw.xt.j.j.f26187j.j(this.ae, this.f26307j, this);
                    cwVar2 = this.qv;
                }
            } finally {
            }
        }
        com.bytedance.sdk.component.cw.xt.j.cw.j(socket);
        return cwVar2;
    }

    public void j(boolean z5, com.bytedance.sdk.component.cw.xt.j.cw.cw cwVar, long j6, IOException iOException) {
        Socket j7;
        synchronized (this.ae) {
            if (cwVar != null) {
                try {
                    if (cwVar == this.az) {
                        if (!z5) {
                            this.qv.xt++;
                        }
                        j7 = j(z5, false, true);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            throw new IllegalStateException("expected " + this.az + " but was " + cwVar);
        }
        com.bytedance.sdk.component.cw.xt.j.cw.j(j7);
        if (iOException != null) {
            this.cw.j(this.xt, iOException);
        }
    }

    public com.bytedance.sdk.component.cw.xt.j.cw.cw j() {
        com.bytedance.sdk.component.cw.xt.j.cw.cw cwVar;
        synchronized (this.ae) {
            cwVar = this.az;
        }
        return cwVar;
    }

    private Socket j(boolean z5, boolean z6, boolean z7) {
        Socket socket;
        if (!f26305r && !Thread.holdsLock(this.ae)) {
            throw new AssertionError();
        }
        if (z7) {
            this.az = null;
        }
        if (z6) {
            this.jy = true;
        }
        cw cwVar = this.qv;
        if (cwVar != null) {
            if (z5) {
                cwVar.f26311j = true;
            }
            if (this.az == null && (this.jy || cwVar.f26311j)) {
                xt(cwVar);
                if (this.qv.f26312r.isEmpty()) {
                    this.qv.up = System.nanoTime();
                    if (com.bytedance.sdk.component.cw.xt.j.j.f26187j.j(this.ae, this.qv)) {
                        socket = this.qv.cw();
                        this.qv = null;
                        return socket;
                    }
                }
                socket = null;
                this.qv = null;
                return socket;
            }
        }
        return null;
    }

    public void j(IOException iOException) {
        boolean z5;
        Socket j6;
        synchronized (this.ae) {
            try {
                if (iOException instanceof az) {
                    com.bytedance.sdk.component.cw.xt.j.up.xt xtVar = ((az) iOException).f26259j;
                    com.bytedance.sdk.component.cw.xt.j.up.xt xtVar2 = com.bytedance.sdk.component.cw.xt.j.up.xt.REFUSED_STREAM;
                    if (xtVar == xtVar2) {
                        this.oq++;
                    }
                    if (xtVar != xtVar2 || this.oq > 1) {
                        this.f26308m = null;
                        z5 = true;
                    }
                    z5 = false;
                } else {
                    cw cwVar = this.qv;
                    if (cwVar != null && (!cwVar.up() || (iOException instanceof com.bytedance.sdk.component.cw.xt.j.up.j))) {
                        if (this.qv.xt == 0) {
                            la laVar = this.f26308m;
                            if (laVar != null && iOException != null) {
                                this.f26306g.j(laVar, iOException);
                            }
                            this.f26308m = null;
                        }
                        z5 = true;
                    }
                    z5 = false;
                }
                j6 = j(z5, false, true);
            } catch (Throwable th) {
                throw th;
            }
        }
        com.bytedance.sdk.component.cw.xt.j.cw.j(j6);
    }

    public void j(cw cwVar, boolean z5) {
        if (!f26305r && !Thread.holdsLock(this.ae)) {
            throw new AssertionError();
        }
        if (this.qv == null) {
            this.qv = cwVar;
            this.vl = z5;
            cwVar.f26312r.add(new j(this, this.tl));
            return;
        }
        throw new IllegalStateException();
    }

    public Socket j(cw cwVar) {
        if (!f26305r && !Thread.holdsLock(this.ae)) {
            throw new AssertionError();
        }
        if (this.az == null && this.qv.f26312r.size() == 1) {
            Reference<ae> reference = this.qv.f26312r.get(0);
            Socket j6 = j(true, false, false);
            this.qv = cwVar;
            cwVar.f26312r.add(reference);
            return j6;
        }
        throw new IllegalStateException();
    }
}
