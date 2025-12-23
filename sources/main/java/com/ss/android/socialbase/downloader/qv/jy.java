package com.ss.android.socialbase.downloader.qv;

import android.os.Process;
import android.text.TextUtils;
import com.umeng.analytics.pro.au;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import master.flame.danmaku.danmaku.parser.b;

/* loaded from: D:\Downloads\app\classes6.dex */
class jy implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private Thread f38923a;
    volatile long ae;
    private com.ss.android.socialbase.downloader.ae.m av;
    private com.ss.android.socialbase.downloader.g.g az;

    /* renamed from: c, reason: collision with root package name */
    private boolean f38924c;
    private volatile boolean ch;
    final int cw;
    private boolean ed;

    /* renamed from: f, reason: collision with root package name */
    private volatile long f38925f;

    /* renamed from: g, reason: collision with root package name */
    String f38926g;
    private long gq;
    private com.ss.android.socialbase.downloader.az.up gx;

    /* renamed from: h, reason: collision with root package name */
    private int f38927h;

    /* renamed from: j, reason: collision with root package name */
    volatile g f38929j;
    private final com.ss.android.socialbase.downloader.ae.cw jy;
    private volatile long kt;

    /* renamed from: l, reason: collision with root package name */
    private volatile boolean f38930l;
    private int la;

    /* renamed from: m, reason: collision with root package name */
    volatile long f38931m;
    private volatile long mi;
    String oq;

    /* renamed from: p, reason: collision with root package name */
    private int f38932p;
    private final m qv;

    /* renamed from: r, reason: collision with root package name */
    volatile long f38933r;
    private int rn;

    /* renamed from: s, reason: collision with root package name */
    private volatile boolean f38934s;
    String tl;
    private com.ss.android.socialbase.downloader.up.j uf;
    volatile long up;

    /* renamed from: v, reason: collision with root package name */
    private Future f38935v;
    private final cw vl;

    /* renamed from: w, reason: collision with root package name */
    private long f38936w;
    private boolean wq;
    private final com.ss.android.socialbase.downloader.jy.j ws;

    /* renamed from: x, reason: collision with root package name */
    private volatile boolean f38937x;
    i xt;

    /* renamed from: i, reason: collision with root package name */
    private final List<g> f38928i = new ArrayList();
    private volatile long tj = -1;

    private void cw(g gVar) throws com.ss.android.socialbase.downloader.up.j {
        String str;
        String str2;
        com.ss.android.socialbase.downloader.g.g j6;
        try {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                this.up = 0L;
                this.f38933r = currentTimeMillis;
                this.f38936w = gVar.up();
                this.kt = gVar.m();
                if (this.kt > 0 && this.f38936w > this.kt) {
                    throw new oq(6, "createConn, ".concat(String.valueOf(gVar)));
                }
                this.gx = new com.ss.android.socialbase.downloader.az.up();
                List<com.ss.android.socialbase.downloader.ae.up> j7 = com.ss.android.socialbase.downloader.az.m.j(this.jy.uf(), this.jy.u(), this.f38936w, this.kt);
                j7.add(new com.ss.android.socialbase.downloader.ae.up("Segment-Index", String.valueOf(gVar.ae())));
                j7.add(new com.ss.android.socialbase.downloader.ae.up("Thread-Index", String.valueOf(this.cw)));
                com.ss.android.socialbase.downloader.az.m.j(j7, this.jy);
                com.ss.android.socialbase.downloader.az.m.xt(j7, this.jy);
                str = this.xt.f38918j;
                if (this.wq && !TextUtils.isEmpty(str) && str.startsWith(b.f50155b)) {
                    str = str.replaceFirst(b.f50155b, b.f50154a);
                }
                str2 = this.xt.xt;
                com.ss.android.socialbase.downloader.m.j.cw("SegmentReader", "createConnectionBegin: url = " + str + ", ip = " + str2 + ", segment = " + gVar + ", threadIndex = " + this.cw);
                this.tl = str;
                this.f38926g = str2;
                j6 = com.ss.android.socialbase.downloader.downloader.cw.j(this.jy.az(), this.jy.ed(), str, str2, j7, 0, currentTimeMillis - this.gq > 3000 && this.ws.xt("monitor_download_connect") > 0, this.jy);
            } catch (com.ss.android.socialbase.downloader.up.j e6) {
                throw e6;
            } catch (Throwable th) {
                com.ss.android.socialbase.downloader.az.m.j(th, "createConn");
            }
            if (j6 == null) {
                throw new com.ss.android.socialbase.downloader.up.j(1022, new IOException("download can't continue, chunk connection is null"));
            }
            this.az = j6;
            this.av = new com.ss.android.socialbase.downloader.ae.m(str, j6);
            if (this.f38937x) {
                throw new av("createConn");
            }
            if (j6 instanceof com.ss.android.socialbase.downloader.g.j) {
                this.oq = ((com.ss.android.socialbase.downloader.g.j) j6).up();
            }
            com.bytedance.sdk.component.utils.vl.j("SegmentReader", "createConnectionSuccess: url = " + str + ", ip = " + str2 + ", hostRealIp = " + this.oq + ", threadIndex = " + this.cw);
            this.up = System.currentTimeMillis();
        } catch (Throwable th2) {
            this.up = System.currentTimeMillis();
            throw th2;
        }
    }

    private boolean j(g gVar) throws com.ss.android.socialbase.downloader.up.j {
        qv();
        while (true) {
            try {
                xt(gVar);
                r(gVar);
                g();
                return true;
            } catch (oq e6) {
                this.uf = e6;
                throw e6;
            } catch (Throwable th) {
                try {
                    com.ss.android.socialbase.downloader.m.j.up("SegmentReader", "download: e = " + th + ", threadIndex = " + this.cw + ", reconnect = " + this.ch + ", closed = " + this.f38937x);
                    if (this.f38937x) {
                        g();
                        return false;
                    }
                    if (this.ch) {
                        this.ch = false;
                        try {
                            Thread.interrupted();
                        } catch (Throwable th2) {
                            com.bytedance.sdk.component.utils.vl.j(th2);
                        }
                        if (this.f38934s) {
                            this.f38934s = false;
                            throw new oq(5, "download");
                        }
                    } else {
                        com.bytedance.sdk.component.utils.vl.j(th);
                        if (th instanceof com.ss.android.socialbase.downloader.up.j) {
                            e = th;
                        } else {
                            try {
                                com.ss.android.socialbase.downloader.az.m.j((Throwable) th, "download");
                                e = null;
                            } catch (com.ss.android.socialbase.downloader.up.j e7) {
                                e = e7;
                            }
                        }
                        if (e == null || !j(gVar, e)) {
                            g();
                            return false;
                        }
                    }
                    g();
                } catch (Throwable th3) {
                    g();
                    throw th3;
                }
            }
        }
    }

    private void qv() {
        this.wq = false;
        vl();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:188:0x0157
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1179)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:270:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x03df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void r(com.ss.android.socialbase.downloader.qv.g r41) throws com.ss.android.socialbase.downloader.up.j {
        /*
            Method dump skipped, instructions count: 1055
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.qv.jy.r(com.ss.android.socialbase.downloader.qv.g):void");
    }

    private void xt(g gVar) throws com.ss.android.socialbase.downloader.up.j, com.ss.android.socialbase.downloader.up.oq {
        cw(gVar);
        this.qv.j(this, gVar, this.xt, this.av);
        this.xt.cw();
    }

    public void m() {
        j(false);
    }

    private void g() {
        this.gq = this.f38933r;
        this.f38933r = -1L;
        this.up = -1L;
        this.f38931m = -1L;
        this.ae = -1L;
        oq();
    }

    private long jy() {
        long j6 = this.mi;
        this.mi = 0L;
        if (j6 <= 0) {
            return Long.MAX_VALUE;
        }
        return j6;
    }

    private void oq() {
        com.ss.android.socialbase.downloader.g.g gVar = this.az;
        if (gVar != null) {
            try {
                com.ss.android.socialbase.downloader.m.j.cw("SegmentReader", "closeConnection: thread = " + this.cw);
                gVar.r();
                gVar.cw();
            } catch (Throwable unused) {
            }
        }
    }

    private void vl() {
        this.f38927h = this.xt.f38920r ? this.jy.c() : this.jy.gx();
        this.la = 0;
    }

    boolean ae() {
        return this.ed;
    }

    @Override // java.lang.Runnable
    public void run() {
        g j6;
        Process.setThreadPriority(10);
        try {
            this.f38923a = Thread.currentThread();
            this.qv.j(this);
            this.xt.j(this);
            while (true) {
                j6 = this.qv.j(this, this.xt);
                if (j6 != null) {
                    this.f38929j = j6;
                    try {
                        try {
                        } catch (Throwable th) {
                            this.f38929j = null;
                            this.qv.j(this, j6);
                            throw th;
                        }
                    } catch (oq e6) {
                        com.ss.android.socialbase.downloader.m.j.up("SegmentReader", "run: SegmentApplyException, e = ".concat(String.valueOf(e6)));
                        int i6 = this.f38932p;
                        if (i6 >= 50) {
                            com.ss.android.socialbase.downloader.m.j.up("SegmentReader", "segment apply failed " + this.f38932p + "times, thread_index = " + this.cw);
                            this.f38929j = null;
                            break;
                        }
                        this.f38932p = i6 + 1;
                        this.f38929j = null;
                    }
                    if (!j(j6)) {
                        if (!this.f38937x) {
                            com.ss.android.socialbase.downloader.m.j.up("SegmentReader", "download segment failed, segment = " + j6 + ", thread_index = " + this.cw + ", failedException = " + this.uf);
                            break;
                        }
                        break;
                    }
                    this.f38928i.add(j6);
                    this.f38929j = null;
                    this.qv.j(this, j6);
                } else {
                    com.ss.android.socialbase.downloader.m.j.cw("SegmentReader", "no more segment, thread_index = " + this.cw);
                    break;
                }
            }
            this.f38929j = null;
            this.qv.j(this, j6);
        } catch (Throwable th2) {
            try {
                com.bytedance.sdk.component.utils.vl.j(th2);
                try {
                    this.xt.xt(this);
                    this.qv.xt(this);
                } catch (Throwable unused) {
                }
                this.f38923a = null;
            } finally {
                try {
                    this.xt.xt(this);
                    this.qv.xt(this);
                } catch (Throwable unused2) {
                }
                this.f38923a = null;
            }
        }
    }

    long tl() {
        return this.f38936w;
    }

    public void up() {
        com.ss.android.socialbase.downloader.m.j.cw("SegmentReader", "close: threadIndex = " + this.cw);
        synchronized (this) {
            this.f38937x = true;
            this.f38930l = true;
        }
        oq();
        Future future = this.f38935v;
        if (future != null) {
            this.f38935v = null;
            try {
                future.cancel(true);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.vl.j(th);
            }
        }
    }

    jy(com.ss.android.socialbase.downloader.ae.cw cwVar, qv qvVar, cw cwVar2, i iVar, int i6) {
        this.jy = cwVar;
        this.qv = qvVar;
        this.vl = cwVar2;
        this.ws = com.ss.android.socialbase.downloader.jy.j.j(cwVar.ae());
        this.xt = iVar;
        this.cw = i6;
    }

    public long xt() {
        long cw;
        synchronized (this.qv) {
            cw = this.f38925f + cw();
        }
        return cw;
    }

    void xt(boolean z5) {
        this.ed = z5;
    }

    void xt(long j6) {
        long j7 = this.tj;
        com.ss.android.socialbase.downloader.az.up upVar = this.gx;
        if (j7 < 0 || upVar == null) {
            return;
        }
        com.bytedance.sdk.component.utils.vl.j("SegmentReader", "markProgress: curSegmentReadOffset = " + j7 + ", threadIndex = " + this.cw);
        upVar.j(j7, j6);
    }

    boolean j(i iVar) {
        int i6 = this.rn;
        if (i6 >= 30) {
            return false;
        }
        this.rn = i6 + 1;
        i iVar2 = this.xt;
        if (iVar2 != null) {
            iVar2.xt(this);
        }
        iVar.j(this);
        this.xt = iVar;
        vl();
        return true;
    }

    private boolean j(g gVar, com.ss.android.socialbase.downloader.up.j jVar) {
        com.ss.android.socialbase.downloader.m.j.up("SegmentReader", "handleDownloadFailed:  e = " + jVar + ", curRetryCount = " + this.la + ", retryCount = " + this.f38927h);
        this.uf = jVar;
        this.xt.xt();
        this.qv.j(this, this.xt, gVar, jVar, this.la, this.f38927h);
        int i6 = this.la;
        if (i6 < this.f38927h) {
            this.la = i6 + 1;
            return true;
        }
        if (j(jVar)) {
            return true;
        }
        this.qv.j(this, this.xt, gVar, jVar);
        return false;
    }

    public long cw() {
        synchronized (this.qv) {
            try {
                long j6 = this.tj;
                long j7 = this.f38936w;
                if (j7 < 0 || j6 <= j7) {
                    return 0L;
                }
                return j6 - j7;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private boolean j(com.ss.android.socialbase.downloader.up.j jVar) {
        if (!com.ss.android.socialbase.downloader.az.m.cw(jVar)) {
            return false;
        }
        String str = this.xt.f38918j;
        if (TextUtils.isEmpty(str) || !str.startsWith(b.f50155b) || !this.jy.d() || this.wq) {
            return false;
        }
        this.wq = true;
        vl();
        return true;
    }

    public void cw(boolean z5) {
        this.f38924c = z5;
    }

    private j j(cw cwVar, InputStream inputStream) throws InterruptedException, com.ss.android.socialbase.downloader.up.j, IOException {
        int i6;
        j xt = cwVar.xt();
        try {
            i6 = inputStream.read(xt.f38921j);
            try {
                if (i6 != -1) {
                    xt.cw = i6;
                    if (i6 == -1) {
                        cwVar.j(xt);
                    }
                    return xt;
                }
                throw new com.ss.android.socialbase.downloader.up.j(1073, au.f40914s);
            } catch (Throwable th) {
                th = th;
                if (i6 == -1) {
                    cwVar.j(xt);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            i6 = -1;
        }
    }

    public boolean j(long j6) {
        long j7 = this.kt;
        if (j6 <= 0 && j7 > 0) {
            return false;
        }
        if (j6 > j7 && j7 > 0) {
            return false;
        }
        this.mi = j6;
        this.f38930l = true;
        return true;
    }

    void j() {
        i iVar = this.xt;
        try {
            synchronized (this.qv) {
                try {
                    long cw = cw();
                    if (cw > 0) {
                        this.f38925f += cw;
                        iVar.j(cw);
                    }
                    this.tj = -1L;
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void j(boolean z5) {
        com.ss.android.socialbase.downloader.m.j.cw("SegmentReader", "reconnect: threadIndex = " + this.cw);
        synchronized (this) {
            this.f38934s = z5;
            this.ch = true;
            this.f38930l = true;
        }
        oq();
        Thread thread = this.f38923a;
        if (thread != null) {
            try {
                com.bytedance.sdk.component.utils.vl.j("SegmentReader", "reconnect: t.interrupt threadIndex = " + this.cw);
                thread.interrupt();
            } catch (Throwable unused) {
            }
        }
    }

    void j(Future future) {
        this.f38935v = future;
    }

    long j(long j6, long j7) {
        com.ss.android.socialbase.downloader.az.up upVar = this.gx;
        if (upVar == null) {
            return -1L;
        }
        return upVar.xt(j6, j7);
    }

    public long r() {
        return this.tj;
    }
}
