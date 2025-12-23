package com.bytedance.sdk.openadsdk.core.component.splash;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.component.splash.cw.j.g;
import com.bytedance.sdk.openadsdk.core.oq;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.hh;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.nd;
import com.bytedance.sdk.openadsdk.core.tj.ry;
import com.bytedance.sdk.openadsdk.core.tj.sm;
import com.bytedance.sdk.openadsdk.core.v;
import com.stub.StubApp;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r implements l.j {
    private int ae;
    private com.bytedance.sdk.openadsdk.core.component.splash.cw.j.m av;
    private long az;
    private com.bytedance.sdk.openadsdk.core.component.splash.cw.j.r ch;
    private nd cw;

    /* renamed from: f, reason: collision with root package name */
    private ry f28707f;

    /* renamed from: g, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.component.splash.j.j f28708g;

    /* renamed from: i, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.component.splash.cw.j.m f28710i;
    private long jy;
    private g kt;

    /* renamed from: m, reason: collision with root package name */
    private final l f28713m;
    private com.bytedance.sdk.openadsdk.i.cw.xt.xt mi;

    /* renamed from: n, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.up f28714n;
    private com.bytedance.sdk.openadsdk.core.component.splash.cw.j.ae nd;
    private j oq;
    private long qv;
    private g tj;
    private int tl;
    private Context up;

    /* renamed from: v, reason: collision with root package name */
    private ry f28718v;
    private long vl;

    /* renamed from: w, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.component.splash.cw.j.tl f28719w;
    private long ws;

    /* renamed from: x, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.component.splash.cw.j.r f28720x;
    private com.bytedance.sdk.openadsdk.i.cw.cw.xt xt;

    /* renamed from: j, reason: collision with root package name */
    private int f28711j = 2;

    /* renamed from: r, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.tj.j.xt.j.j f28716r = null;

    /* renamed from: s, reason: collision with root package name */
    private final AtomicBoolean f28717s = new AtomicBoolean(false);

    /* renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f28705a = new AtomicBoolean(false);

    /* renamed from: l, reason: collision with root package name */
    private final AtomicBoolean f28712l = new AtomicBoolean(false);

    /* renamed from: p, reason: collision with root package name */
    private final AtomicBoolean f28715p = new AtomicBoolean(false);

    /* renamed from: h, reason: collision with root package name */
    private final AtomicBoolean f28709h = new AtomicBoolean(false);
    private final AtomicBoolean la = new AtomicBoolean(false);
    private final AtomicInteger gq = new AtomicInteger(0);
    private final AtomicBoolean rn = new AtomicBoolean(false);
    private final AtomicBoolean wq = new AtomicBoolean(false);
    private final AtomicBoolean uf = new AtomicBoolean(false);
    private final AtomicBoolean ed = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name */
    private final AtomicInteger f28706c = new AtomicInteger(0);
    private boolean gx = false;

    class j {
        private final AtomicBoolean xt = new AtomicBoolean(false);

        public void cw(com.bytedance.sdk.openadsdk.core.component.splash.cw.j.ae aeVar) {
            r.this.g();
            if (this.xt.get()) {
                return;
            }
            this.xt.set(true);
            up.j(aeVar.tl(), r.this.j(aeVar.tl()), r.this.xt, aeVar);
            r(aeVar);
            vl.r("SplashLoadManager", "渲染失败 code " + aeVar.r() + " msg " + aeVar.up());
        }

        public void xt(final com.bytedance.sdk.openadsdk.core.component.splash.cw.j.ae aeVar) {
            if (aeVar == null) {
                return;
            }
            r.this.g();
            if (this.xt.get()) {
                return;
            }
            this.xt.set(true);
            com.bytedance.sdk.openadsdk.l.ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.r.j.3
                @Override // java.lang.Runnable
                public void run() {
                    if (r.this.f28716r != null) {
                        if (r.this.gq.get() > 0) {
                            r.this.f28716r.j(null, new com.bytedance.sdk.openadsdk.i.cw.cw(1, "load splash material fail"));
                        } else {
                            r.this.f28716r.j(new com.bytedance.sdk.openadsdk.i.cw.cw(aeVar.r(), aeVar.up()));
                        }
                    }
                }
            });
            r.this.cw();
            com.bytedance.sdk.openadsdk.core.ae.j.r("Splash_FullLink", "onSplashLoadFail 素材加载加载失败 code: " + aeVar.r());
            up.j(aeVar.tl(), r.this.j(aeVar.tl()), r.this.xt, aeVar);
        }

        j() {
        }

        private void r(final com.bytedance.sdk.openadsdk.core.component.splash.cw.j.ae aeVar) {
            if (aeVar == null) {
                return;
            }
            com.bytedance.sdk.openadsdk.l.ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.r.j.1
                @Override // java.lang.Runnable
                public void run() {
                    if (r.this.f28716r != null) {
                        r.this.f28716r.j(aeVar.g(), new com.bytedance.sdk.openadsdk.i.cw.cw(aeVar.r(), aeVar.up()));
                        com.bytedance.sdk.openadsdk.core.ae.j.j("Splash_FullLink", "onSplashRenderFail回调 true " + aeVar.r());
                    }
                }
            });
            r.this.cw();
        }

        public void j(final com.bytedance.sdk.openadsdk.core.component.splash.cw.j.ae aeVar) {
            if (aeVar == null) {
                return;
            }
            r.this.g();
            if (this.xt.get()) {
                return;
            }
            this.xt.set(true);
            com.bytedance.sdk.openadsdk.l.ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.r.j.2
                @Override // java.lang.Runnable
                public void run() {
                    if (r.this.f28716r != null) {
                        if (aeVar.r() == 22) {
                            aeVar.xt(1);
                        }
                        r.this.f28716r.j(new com.bytedance.sdk.openadsdk.i.cw.cw(aeVar.r(), aeVar.up()));
                        com.bytedance.sdk.openadsdk.core.ae.j.j("Splash_FullLink", "onSplashLoadFail 回调");
                    }
                }
            });
            j(false, true, (Object) null);
            r.this.cw();
            com.bytedance.sdk.openadsdk.core.ae.j.j("Splash_FullLink", "onLoadSplashAdFail回调 广告获取失败");
            up.j(aeVar.tl(), r.this.j(aeVar.tl()), r.this.xt, aeVar);
        }

        public boolean cw() {
            return this.xt.get();
        }

        public void xt() {
            if (this.xt.get()) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.ae.j.j("Splash_FullLink", "触发 buffer_time超时 开始给加载成功回调以及开始渲染");
            r.this.tl();
        }

        public void j(com.bytedance.sdk.openadsdk.core.component.splash.cw.j.tl tlVar) {
            ry ryVar;
            if (this.xt.get() || tlVar == null) {
                return;
            }
            if (tlVar.qv()) {
                ryVar = r.this.f28718v;
            } else {
                ryVar = r.this.f28707f;
            }
            ry ryVar2 = ryVar;
            if (ryVar2 != null) {
                ryVar2.m(tlVar.j());
                ryVar2.w(tlVar.ws());
                ryVar2.tj(System.currentTimeMillis() - ryVar2.x());
            }
            j(r.this.f28716r, ryVar2, tlVar.xt(), tlVar.vl(), tlVar.qv(), tlVar.az());
        }

        private void j(com.bytedance.sdk.openadsdk.tj.j.xt.j.j jVar, ry ryVar, n nVar, com.bytedance.sdk.openadsdk.i.cw.xt.xt xtVar, boolean z5, boolean z6) {
            ry ryVar2;
            if (jVar == null || ryVar == null || r.this.gq.get() > 0) {
                return;
            }
            if (r.this.j(nVar)) {
                r rVar = r.this;
                if (z5) {
                    ryVar2 = rVar.f28718v;
                } else {
                    ryVar2 = rVar.f28707f;
                }
                up.j(ryVar2, 2);
                r.this.g();
            }
            r.this.uf.set(z5);
            r.this.gq.set(1);
            long currentTimeMillis = System.currentTimeMillis();
            j(xtVar, 1);
            jVar.j(xtVar);
            r.this.gq.set(2);
            com.bytedance.sdk.openadsdk.core.ae.j.j("Splash_FullLink", "onSplashLoadSuccess() 媒体处理完成");
            j(z5, false, (Object) xtVar);
            ryVar.i(System.currentTimeMillis() - currentTimeMillis);
            if (z6) {
                up.j(r.this.up, ryVar, nVar, z5, currentTimeMillis);
            }
        }

        public void j(final g gVar) {
            ry ryVar;
            r.this.g();
            if (this.xt.get()) {
                return;
            }
            this.xt.set(true);
            boolean z5 = gVar != null && gVar.cw();
            r.this.j(gVar);
            r rVar = r.this;
            if (z5) {
                ryVar = rVar.f28718v;
            } else {
                ryVar = rVar.f28707f;
            }
            rVar.j(z5, ryVar);
            com.bytedance.sdk.openadsdk.l.ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.r.j.4
                @Override // java.lang.Runnable
                public void run() {
                    g gVar2;
                    if (r.this.f28716r == null || (gVar2 = gVar) == null) {
                        return;
                    }
                    j.this.j(gVar2.j(), 2);
                    r.this.f28716r.xt(gVar.j());
                }
            });
        }

        public void j() {
            com.bytedance.sdk.openadsdk.core.ae.j.j("Splash_FullLink", "onTimeOut start");
            r.this.f28717s.set(true);
            if (this.xt.get()) {
                return;
            }
            this.xt.set(true);
            if (r.this.f28714n != null) {
                r.this.f28714n.j();
            }
            com.bytedance.sdk.openadsdk.core.ae.j.j("Splash_FullLink", "开屏超时");
            if (r.this.f28716r != null) {
                if (r.this.gq.get() > 0) {
                    r.this.f28716r.j(null, new com.bytedance.sdk.openadsdk.i.cw.cw(3, "load success but render fail"));
                } else {
                    r.this.f28716r.j(new com.bytedance.sdk.openadsdk.i.cw.cw(23, "load splash time out"));
                }
                com.bytedance.sdk.openadsdk.core.ae.j.j("Splash_FullLink", "回调开屏超时 true");
                r.this.cw();
            }
            boolean z5 = r.this.gx;
            r rVar = r.this;
            up.j(z5, rVar.j(rVar.gx), r.this.xt, new com.bytedance.sdk.openadsdk.core.component.splash.cw.j.ae(23, "load splash time out", r.this.gx));
            boolean z6 = r.this.gx;
            r rVar2 = r.this;
            up.j(z6, rVar2.j(rVar2.gx), r.this.xt);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(com.bytedance.sdk.openadsdk.i.cw.xt.xt xtVar, int i6) {
            if (xtVar instanceof com.bytedance.sdk.openadsdk.core.component.splash.r.j) {
                ((com.bytedance.sdk.openadsdk.core.component.splash.r.j) xtVar).j(i6);
            }
        }

        private void j(boolean z5, boolean z6, Object obj) {
            n j6 = r.this.j(true);
            if (r.this.f28708g == null || j6 == null) {
                return;
            }
            String ej = j6.ej();
            r.this.f28708g.j(r.this.xt.r(), ej, z5, z6, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae() {
        com.bytedance.sdk.openadsdk.core.ae.j.j("Splash_FullLink", "startCallBackWhenBufferTimeout ");
        this.oq.j(this.f28719w);
        this.wq.set(true);
        if (!this.f28715p.get() || this.rn.get()) {
            return;
        }
        this.rn.set(true);
        com.bytedance.sdk.openadsdk.core.ae.j.j("Splash_FullLink", "素材加载和渲染并发 buffer_time超时 缓存素材加载成功，渲染成功开始给 onRenderSplashSuccess回调");
        this.oq.j(this.tj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        l lVar = this.f28713m;
        if (lVar != null) {
            lVar.removeMessages(4);
        }
        l lVar2 = this.f28713m;
        if (lVar2 != null) {
            lVar2.removeMessages(2);
        }
    }

    private boolean jy() {
        return (com.bytedance.sdk.openadsdk.core.cw.up.j().qv() & 4) == 4;
    }

    private void m() {
        l lVar = this.f28713m;
        if (lVar != null) {
            lVar.removeMessages(4);
        }
        j jVar = this.oq;
        if (jVar != null) {
            jVar.xt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oq() {
        if (com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.up.j(this.xt, this.cw)) {
            return;
        }
        this.f28708g.j(new sm(this.av.r(), this.av.xt(), null), this.xt, true);
    }

    private void qv() {
        this.f28707f = new ry();
        ry ryVar = new ry();
        this.f28718v = ryVar;
        up.j(this.f28707f, ryVar);
        this.f28720x = new com.bytedance.sdk.openadsdk.core.component.splash.cw.j.r();
        this.ch = new com.bytedance.sdk.openadsdk.core.component.splash.cw.j.r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tl() {
        if (this.oq == null) {
            return;
        }
        if (xt(j(true), true)) {
            AtomicBoolean atomicBoolean = this.f28705a;
            if (atomicBoolean == null || !atomicBoolean.get()) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.ae.j.j("Splash_FullLink", "buffer_time超时-并发 缓存素材加载成功，开始给加载成功回调");
            com.bytedance.sdk.openadsdk.core.component.splash.cw.j.tl tlVar = this.f28719w;
            if (tlVar != null) {
                tlVar.j(this.mi);
            }
            final long currentTimeMillis = System.currentTimeMillis();
            com.bytedance.sdk.openadsdk.l.ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.r.4
                @Override // java.lang.Runnable
                public void run() {
                    up.r(r.this.f28718v, currentTimeMillis);
                    r.this.ae();
                }
            });
            return;
        }
        AtomicBoolean atomicBoolean2 = this.f28705a;
        if (atomicBoolean2 == null || !atomicBoolean2.get()) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.ae.j.j("Splash_FullLink", "buffer_time超时-串行 缓存素材加载成功，开始给加载成功回调以及开始渲染");
        final com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.j xt = xt(this.f28710i, this.f28719w, this.oq);
        com.bytedance.sdk.openadsdk.core.component.splash.cw.j.tl tlVar2 = this.f28719w;
        if (tlVar2 != null) {
            tlVar2.j(xt.j());
        }
        final long currentTimeMillis2 = System.currentTimeMillis();
        com.bytedance.sdk.openadsdk.l.ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.r.5
            @Override // java.lang.Runnable
            public void run() {
                up.r(r.this.f28718v, currentTimeMillis2);
                r.this.oq.j(r.this.f28719w);
                r rVar = r.this;
                rVar.j(rVar.f28710i, xt, r.this.f28719w.up());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean vl() {
        return this.f28711j == 2;
    }

    private r(Context context) {
        if (context != null) {
            this.up = StubApp.getOrigApplicationContext(context.getApplicationContext());
        } else {
            this.up = v.getContext();
        }
        this.f28713m = new l(Looper.getMainLooper(), this);
        this.oq = new j();
        oq.i().g(false);
        qv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void up() {
        int optInt;
        com.bytedance.sdk.openadsdk.core.component.splash.cw.j.m mVar = this.f28710i;
        if (mVar != null && mVar.xt() != null && this.f28710i.xt().qf() != null && (optInt = this.f28710i.xt().qf().optInt("real_drop_cache_type", 0)) == 1) {
            com.bytedance.sdk.openadsdk.core.ae.j.j("SplashLoadManager", "loadCacheWhenRealAdDrop - 缓存兜底返回配置 realDropCacheType： " + optInt);
            m();
            return;
        }
        j jVar = this.oq;
        if (jVar != null) {
            jVar.j(this.nd);
        }
    }

    private void r() {
        com.bytedance.sdk.openadsdk.core.component.splash.j.j jVar = this.f28708g;
        if (jVar != null) {
            jVar.xt(this.xt, this.cw);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cw() {
        int i6;
        if (com.bytedance.sdk.openadsdk.core.component.splash.j.j.j(this.f28711j) && ((i6 = this.f28711j) == 1 || i6 == 3)) {
            return;
        }
        r();
    }

    private void m(boolean z5) {
        if (this.f28713m != null) {
            if (vl()) {
                if (z5) {
                    return;
                } else {
                    this.f28713m.removeMessages(4);
                }
            }
            this.f28713m.removeMessages(2);
        }
    }

    private void r(boolean z5) {
        if (z5) {
            this.az = System.currentTimeMillis();
        } else {
            this.ws = System.currentTimeMillis();
        }
    }

    private void xt() {
        this.f28717s.set(false);
        this.f28705a.set(false);
        this.f28712l.set(false);
        this.f28715p.set(false);
        this.rn.set(false);
        this.wq.set(false);
        this.f28709h.set(false);
        this.la.set(false);
        this.uf.set(false);
        this.ed.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cw(boolean z5) {
        return z5 && vl();
    }

    private int cw(n nVar) {
        return Math.max(com.bytedance.sdk.openadsdk.core.cw.up.j().ws(), (this.tl - ((int) (System.currentTimeMillis() - this.qv))) - (nVar != null ? hh.up(nVar) : 100));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void up(boolean z5) {
        if (z5) {
            this.ch.cw(System.currentTimeMillis() - this.az);
        } else {
            this.f28720x.cw(System.currentTimeMillis() - this.ws);
        }
    }

    public static r j(Context context) {
        return new r(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean xt(boolean z5) {
        com.bytedance.sdk.openadsdk.core.component.splash.cw.j.m mVar;
        return (z5 || this.f28708g == null || (mVar = this.av) == null || mVar.r() == null || this.av.xt() == null || !com.bytedance.sdk.openadsdk.core.up.r.r.j(this.av.xt())) ? false : true;
    }

    public void j(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, com.bytedance.sdk.openadsdk.tj.j.xt.j.j jVar, int i6) {
        this.f28716r = jVar;
        j(xtVar, i6);
    }

    private void j(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, int i6) {
        com.bytedance.sdk.openadsdk.core.ae.j.j("Splash_FullLink", "加载开屏广告--begin ");
        this.qv = System.currentTimeMillis();
        this.cw = xt(xtVar);
        this.xt = xtVar;
        this.ae = uf.xt(xtVar);
        this.f28708g = com.bytedance.sdk.openadsdk.core.component.splash.j.j.j();
        int g6 = v.xt().g(this.ae);
        this.f28711j = g6;
        com.bytedance.sdk.openadsdk.core.ae.j.j("Splash_FullLink", "当前rit位 " + this.ae);
        int m6 = v.xt().m(xtVar.r());
        j(xtVar.r(), m6, i6);
        nd ndVar = this.cw;
        long j6 = i6;
        ndVar.f30362g = j6;
        ndVar.oq = m6;
        ndVar.qv = this.tl;
        up.j(xtVar, j6);
        xt();
        j(xtVar, this.cw, g6);
    }

    private void xt(com.bytedance.sdk.openadsdk.core.component.splash.cw.j.tl tlVar, long j6) {
        if (tlVar.qv()) {
            if (this.la.get()) {
                return;
            }
            this.ch.xt(j6 - this.jy);
            this.f28718v.cw(tlVar.m());
            this.f28718v.xt(tlVar.up());
            return;
        }
        if (this.f28709h.get()) {
            return;
        }
        this.f28720x.xt(j6 - this.vl);
        this.f28707f.cw(tlVar.m());
        this.f28707f.xt(tlVar.up());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(com.bytedance.sdk.openadsdk.core.component.splash.cw.j.m mVar, j jVar) {
        if (mVar == null || jVar == null) {
            return;
        }
        n xt = mVar.xt();
        boolean up = mVar.up();
        com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.j j6 = j(mVar, new com.bytedance.sdk.openadsdk.core.component.splash.cw.j.tl(xt, up), jVar);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        com.bytedance.sdk.openadsdk.core.component.splash.cw.j.xt xtVar = new com.bytedance.sdk.openadsdk.core.component.splash.cw.j.xt(xt, up);
        xtVar.j(up);
        xtVar.j(mVar.r());
        xtVar.j(mVar.j());
        xtVar.j(mVar.cw());
        com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.m j7 = j(mVar, jVar, j6.j(), xtVar, elapsedRealtime);
        j6.j(j7);
        up.cw(up ? this.f28718v : this.f28707f, System.currentTimeMillis());
        j7.xt();
        int cw = cw(xt);
        if (this.f28717s.get()) {
            return;
        }
        if (j(xt, xtVar.r()) && this.f28713m != null && cw <= 0) {
            cw = 0;
        }
        j(up, 1);
        j(j6, up, cw);
    }

    private void j(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, nd ndVar, int i6) {
        if (xtVar == null) {
            return;
        }
        up.j(this.f28707f, this.f28718v, ndVar, this.f28711j, i6);
        j(xtVar, ndVar, this.oq);
    }

    private void j(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, nd ndVar, final j jVar) {
        if (jVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.up upVar = new com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.up(new com.bytedance.sdk.openadsdk.core.component.splash.cw.j.up(xtVar, ndVar), new com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.xt<com.bytedance.sdk.openadsdk.core.component.splash.cw.j.m, com.bytedance.sdk.openadsdk.core.component.splash.cw.j.ae>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.r.1
            @Override // com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.xt
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public void xt(com.bytedance.sdk.openadsdk.core.component.splash.cw.j.m mVar) {
                if (mVar == null || mVar.xt() == null) {
                    jVar.j(new com.bytedance.sdk.openadsdk.core.component.splash.cw.j.ae(1, "no ad model", false));
                    return;
                }
                n xt = mVar.xt();
                if (mVar.up()) {
                    r.this.f28706c.set(1);
                    r.this.f28710i = mVar;
                    if (!r.this.vl()) {
                        r.this.gx = true;
                    }
                } else {
                    r.this.av = mVar;
                    r.this.gx = false;
                }
                if (r.this.f28717s.get() || r.this.oq.cw() || r.this.gq.get() > 0) {
                    r.this.j(mVar, mVar.up(), true);
                    return;
                }
                r.this.j(mVar);
                if (r.this.xt(xt, mVar.up())) {
                    com.bytedance.sdk.openadsdk.core.ae.j.j("Splash_FullLink", "开始并发加载素材 ");
                    r.this.xt(mVar, jVar);
                } else {
                    com.bytedance.sdk.openadsdk.core.ae.j.j("Splash_FullLink", "开始串行加载素材 getReqId " + mVar.xt().ej());
                    r.this.j(mVar, jVar);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.xt
            public void j(com.bytedance.sdk.openadsdk.core.component.splash.cw.j.ae aeVar) {
                boolean tl = aeVar.tl();
                if (tl) {
                    r.this.f28706c.set(-1);
                }
                if (!r.this.cw(tl)) {
                    r.this.nd = aeVar;
                    if (r.this.vl()) {
                        if (r.this.f28706c.get() != -1) {
                            if (r.this.f28706c.get() == 1) {
                                r.this.up();
                            }
                        } else {
                            jVar.j(aeVar);
                        }
                        r.this.ed.set(true);
                        return;
                    }
                    jVar.j(aeVar);
                    return;
                }
                if (r.this.ed.get()) {
                    jVar.j(r.this.nd);
                }
            }
        }, this.f28708g);
        this.f28714n = upVar;
        upVar.j(this.f28711j);
    }

    @Override // com.bytedance.sdk.component.utils.l.j
    public void j(Message message) {
        if (message.what == 2) {
            j jVar = this.oq;
            if (jVar != null) {
                jVar.j();
            }
            l lVar = this.f28713m;
            if (lVar != null) {
                lVar.removeMessages(2);
            }
        }
        if (message.what == 4) {
            m();
        }
    }

    private boolean j(n nVar, boolean z5) {
        return (nVar == null || z5 || nVar.xp() != 3) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j(n nVar) {
        return (nVar != null ? nVar.xp() : 0) == 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean xt(n nVar, boolean z5) {
        if (nVar == null) {
            return false;
        }
        if (vl() && z5 && jy()) {
            return false;
        }
        if ((com.bytedance.sdk.openadsdk.core.cw.up.j().jy() & 1) == 1) {
            return true;
        }
        return m.xt(nVar) && xt(nVar) && nVar.u() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public n j(boolean z5) {
        if (z5) {
            com.bytedance.sdk.openadsdk.core.component.splash.cw.j.m mVar = this.f28710i;
            if (mVar == null) {
                return null;
            }
            return mVar.xt();
        }
        com.bytedance.sdk.openadsdk.core.component.splash.cw.j.m mVar2 = this.av;
        if (mVar2 == null) {
            return null;
        }
        return mVar2.xt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final boolean z5, final ry ryVar) {
        com.bytedance.sdk.openadsdk.l.ae.j(new com.bytedance.sdk.component.oq.g("preloadSplash") { // from class: com.bytedance.sdk.openadsdk.core.component.splash.r.6
            @Override // java.lang.Runnable
            public void run() {
                if (r.this.xt(z5)) {
                    r.this.oq();
                } else {
                    r.this.cw();
                }
                ry ryVar2 = ryVar;
                boolean z6 = false;
                boolean z7 = ryVar2 != null && ryVar2.wq();
                ry ryVar3 = ryVar;
                if (ryVar3 != null && ryVar3.gq()) {
                    z6 = true;
                }
                boolean z8 = z5;
                up.j(z8, r.this.j(z8), r.this.xt, z7, z6);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(com.bytedance.sdk.openadsdk.core.component.splash.cw.j.m mVar) {
        boolean up = mVar.up();
        long currentTimeMillis = System.currentTimeMillis();
        long j6 = currentTimeMillis - this.qv;
        if (up) {
            up.j(this.f28718v);
            this.ch.j(hh.j(j(up)));
            this.ch.xt(hh.xt(j(up)));
            this.ch.j(j6);
            this.jy = currentTimeMillis;
            com.bytedance.sdk.openadsdk.core.ae.j.j("Splash_FullLink", "缓存加载物料--end 耗时S1： " + j6);
            return;
        }
        up.j(this.f28707f);
        this.f28720x.j(hh.j(j(up)));
        this.f28720x.xt(hh.xt(j(up)));
        this.f28720x.j(j6);
        this.vl = currentTimeMillis;
        up.j(this.f28707f, mVar);
        com.bytedance.sdk.openadsdk.core.v.up.j().cw().j(this.f28707f);
        com.bytedance.sdk.openadsdk.core.ae.j.j("Splash_FullLink", "实时加载物料--end 耗时S1： " + j6);
    }

    private boolean xt(n nVar) {
        return nVar != null && hh.j(nVar) == 2;
    }

    private com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.j xt(final com.bytedance.sdk.openadsdk.core.component.splash.cw.j.m mVar, com.bytedance.sdk.openadsdk.core.component.splash.cw.j.tl tlVar, final j jVar) {
        if (mVar == null || tlVar == null || jVar == null) {
            return null;
        }
        return new com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.j(new com.bytedance.sdk.openadsdk.core.component.splash.cw.j.cw(this.up, "splash_ad", mVar, tlVar, this.xt), new com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.r<g, com.bytedance.sdk.openadsdk.core.component.splash.cw.j.ae>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.r.3
            @Override // com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.r
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public void xt(g gVar) {
                r.this.up(mVar.up());
                if (r.this.uf.get()) {
                    if (mVar.up()) {
                        jVar.j(gVar);
                    }
                } else {
                    if (mVar.up()) {
                        return;
                    }
                    jVar.j(gVar);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.r
            public void j(com.bytedance.sdk.openadsdk.core.component.splash.cw.j.ae aeVar) {
                jVar.cw(aeVar);
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.r
            public void j() {
                r.this.xt(mVar);
            }
        }, this.f28708g);
    }

    private nd xt(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar) {
        long currentTimeMillis = System.currentTimeMillis();
        nd ndVar = new nd();
        ndVar.ae = currentTimeMillis;
        ndVar.jy = oq.i().xq();
        Object obj = this.f28716r;
        if (obj != null && (obj instanceof com.bytedance.sdk.openadsdk.core.j.xt)) {
            ndVar.tl = ((com.bytedance.sdk.openadsdk.core.j.xt) obj).xt();
        }
        return ndVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(com.bytedance.sdk.openadsdk.core.component.splash.cw.j.m mVar) {
        if (mVar == null || !mVar.up()) {
            r();
        }
    }

    private void j(final com.bytedance.sdk.openadsdk.core.component.splash.cw.j.tl tlVar, final com.bytedance.sdk.openadsdk.core.component.splash.cw.j.m mVar, final j jVar) {
        if (tlVar != null && this.gq.get() <= 0) {
            final boolean qv = tlVar.qv();
            final com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.j xt = xt(mVar, tlVar, jVar);
            tlVar.j(xt.j());
            if (!cw(tlVar.qv())) {
                com.bytedance.sdk.openadsdk.core.ae.j.j("Splash_FullLink", "不需要等待实时广告 isCacheAd " + qv);
                if (j()) {
                    jVar.j(tlVar);
                    j(mVar, xt, tlVar.up());
                    return;
                } else {
                    final long currentTimeMillis = System.currentTimeMillis();
                    com.bytedance.sdk.openadsdk.l.ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.r.7
                        @Override // java.lang.Runnable
                        public void run() {
                            up.r(qv ? r.this.f28718v : r.this.f28707f, currentTimeMillis);
                            jVar.j(tlVar);
                            r.this.j(mVar, xt, tlVar.up());
                        }
                    });
                    return;
                }
            }
            com.bytedance.sdk.openadsdk.core.ae.j.j("Splash_FullLink", "缓存素材加载成功，等待实时广告 isCacheAd " + qv);
            this.f28719w = tlVar;
            this.mi = xt.j();
            this.f28705a.set(true);
            if (this.ed.get()) {
                up();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final com.bytedance.sdk.openadsdk.core.component.splash.cw.j.m mVar, final j jVar) {
        if (mVar == null || jVar == null) {
            return;
        }
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        up.cw(mVar.up() ? this.f28718v : this.f28707f, System.currentTimeMillis());
        com.bytedance.sdk.openadsdk.core.component.splash.cw.j.xt xtVar = new com.bytedance.sdk.openadsdk.core.component.splash.cw.j.xt(mVar.xt(), mVar.up());
        xtVar.j(mVar.r());
        xtVar.j(mVar.up());
        xtVar.j(mVar.j());
        xtVar.j(mVar.cw());
        new com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.m(xtVar, new com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.cw<com.bytedance.sdk.openadsdk.core.component.splash.cw.j.tl, com.bytedance.sdk.openadsdk.core.component.splash.cw.j.ae>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.r.8
            private com.bytedance.sdk.openadsdk.core.component.splash.cw.j.tl up;

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.cw
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public void cw(com.bytedance.sdk.openadsdk.core.component.splash.cw.j.tl tlVar) {
                this.up = tlVar;
                r.this.j(tlVar, mVar, jVar, (com.bytedance.sdk.openadsdk.i.cw.xt.xt) null, true);
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.cw
            public void xt(com.bytedance.sdk.openadsdk.core.component.splash.cw.j.tl tlVar) {
                com.bytedance.sdk.openadsdk.core.component.splash.cw.j.tl tlVar2 = this.up;
                if (tlVar2 != null) {
                    tlVar2.up(true);
                }
                r.this.j(tlVar, mVar, jVar, (com.bytedance.sdk.openadsdk.i.cw.xt.xt) null, elapsedRealtime, true);
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.cw
            public void j(com.bytedance.sdk.openadsdk.core.component.splash.cw.j.ae aeVar) {
                r.this.j(mVar, aeVar, jVar, elapsedRealtime);
            }
        }).xt();
        j(mVar.up(), 0);
    }

    private void j(final com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.j jVar, boolean z5, final int i6) {
        r(z5);
        com.bytedance.sdk.openadsdk.l.ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.r.9
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.j jVar2 = jVar;
                if (jVar2 == null) {
                    return;
                }
                jVar2.j(i6);
                jVar.xt();
            }
        });
    }

    private void j(com.bytedance.sdk.openadsdk.core.component.splash.cw.j.tl tlVar, long j6) {
        long currentTimeMillis = System.currentTimeMillis();
        boolean qv = tlVar.qv();
        if (qv) {
            up.j(this.f28718v, tlVar);
            up.j(this.f28718v, tlVar, j6, j(qv));
            up.j(j(qv), this.f28718v, tlVar);
            j(qv, tlVar, currentTimeMillis - this.jy);
            com.bytedance.sdk.openadsdk.core.component.splash.cw.j.tl tlVar2 = this.f28719w;
            if (tlVar2 != null) {
                tlVar2.up(true);
            }
        } else {
            up.j(this.f28707f, tlVar);
            up.j(this.f28707f, tlVar, j6, j(qv));
            up.j(j(qv), this.f28707f, tlVar);
            j(qv, tlVar, currentTimeMillis - this.vl);
        }
        xt(tlVar, currentTimeMillis);
        if (this.gq.get() <= 0 || this.f28717s.get()) {
            return;
        }
        if (this.uf.get()) {
            if (qv) {
                up.j(this.up, this.f28718v, tlVar.xt(), true, currentTimeMillis);
            }
        } else {
            if (qv) {
                return;
            }
            up.j(this.up, this.f28707f, tlVar.xt(), false, currentTimeMillis);
        }
    }

    private void j(boolean z5, com.bytedance.sdk.openadsdk.core.component.splash.cw.j.tl tlVar, long j6) {
        String str = z5 ? "缓存广告" : "实时广告";
        if (tlVar.up()) {
            if (tlVar.oq()) {
                com.bytedance.sdk.openadsdk.core.ae.j.j("Splash_FullLink", str + "： 加载缓存视频素材--end, 耗时S2： " + j6);
                return;
            }
            com.bytedance.sdk.openadsdk.core.ae.j.j("Splash_FullLink", str + "： 加载网络视频素材--end, 耗时S2： " + j6);
            return;
        }
        if (tlVar.m()) {
            com.bytedance.sdk.openadsdk.core.ae.j.j("Splash_FullLink", str + "： 加载缓存图片素材--end, 耗时S2： " + j6);
            return;
        }
        com.bytedance.sdk.openadsdk.core.ae.j.j("Splash_FullLink", str + "： 加载网络图片素材--end, 耗时S2：" + j6);
    }

    private void j(final com.bytedance.sdk.openadsdk.core.component.splash.cw.j.tl tlVar, com.bytedance.sdk.openadsdk.core.component.splash.cw.j.m mVar, final j jVar, com.bytedance.sdk.openadsdk.i.cw.xt.xt xtVar) {
        if (tlVar != null && this.gq.get() <= 0) {
            final boolean qv = tlVar.qv();
            if (!cw(qv)) {
                com.bytedance.sdk.openadsdk.core.ae.j.j("Splash_FullLink", "实时素材加载成功，不需要等待实时广告, 此时渲染结果: " + this.f28712l.get());
                tlVar.j(xtVar);
                if (j()) {
                    jVar.j(tlVar);
                    if (this.f28712l.get()) {
                        jVar.j(this.kt);
                    }
                } else {
                    final long currentTimeMillis = System.currentTimeMillis();
                    com.bytedance.sdk.openadsdk.l.ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.r.10
                        @Override // java.lang.Runnable
                        public void run() {
                            up.r(qv ? r.this.f28718v : r.this.f28707f, currentTimeMillis);
                            jVar.j(tlVar);
                            if (r.this.f28712l.get()) {
                                jVar.j(r.this.kt);
                            }
                        }
                    });
                }
            } else {
                com.bytedance.sdk.openadsdk.core.ae.j.j("Splash_FullLink", "缓存广告: 素材加载成功，需要等待实时广告");
                this.f28719w = tlVar;
                this.mi = xtVar;
                this.f28705a.set(true);
                if (this.ed.get()) {
                    up();
                }
            }
        }
    }

    private com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.m j(final com.bytedance.sdk.openadsdk.core.component.splash.cw.j.m mVar, final j jVar, final com.bytedance.sdk.openadsdk.i.cw.xt.xt xtVar, com.bytedance.sdk.openadsdk.core.component.splash.cw.j.xt xtVar2, final long j6) {
        return new com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.m(xtVar2, new com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.cw<com.bytedance.sdk.openadsdk.core.component.splash.cw.j.tl, com.bytedance.sdk.openadsdk.core.component.splash.cw.j.ae>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.r.11

            /* renamed from: m, reason: collision with root package name */
            private com.bytedance.sdk.openadsdk.core.component.splash.cw.j.tl f28725m;

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.cw
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public void cw(com.bytedance.sdk.openadsdk.core.component.splash.cw.j.tl tlVar) {
                this.f28725m = tlVar;
                r.this.j(tlVar, mVar, jVar, xtVar, false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.cw
            public void xt(com.bytedance.sdk.openadsdk.core.component.splash.cw.j.tl tlVar) {
                com.bytedance.sdk.openadsdk.core.component.splash.cw.j.tl tlVar2 = this.f28725m;
                if (tlVar2 != null) {
                    tlVar2.up(true);
                }
                r.this.j(tlVar, mVar, jVar, xtVar, j6, false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.cw
            public void j(com.bytedance.sdk.openadsdk.core.component.splash.cw.j.ae aeVar) {
                r.this.j(mVar, aeVar, jVar, j6);
            }
        });
    }

    private com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.j j(final com.bytedance.sdk.openadsdk.core.component.splash.cw.j.m mVar, com.bytedance.sdk.openadsdk.core.component.splash.cw.j.tl tlVar, final j jVar) {
        return new com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.j(new com.bytedance.sdk.openadsdk.core.component.splash.cw.j.cw(this.up, "splash_ad", mVar, tlVar, this.xt), new com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.r<g, com.bytedance.sdk.openadsdk.core.component.splash.cw.j.ae>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.r.2
            @Override // com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.r
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public void xt(g gVar) {
                r.this.up(mVar.up());
                if (r.this.cw(gVar.cw())) {
                    com.bytedance.sdk.openadsdk.core.ae.j.j("Splash_FullLink", "缓存渲染成功 需要等待实时广告: ");
                    if (r.this.wq.get() && !r.this.rn.get()) {
                        com.bytedance.sdk.openadsdk.core.ae.j.j("Splash_FullLink", "已经超时走缓存广告");
                        r.this.rn.set(true);
                        jVar.j(gVar);
                    }
                    r.this.f28715p.set(true);
                    r.this.tj = gVar;
                    return;
                }
                r.this.f28712l.set(true);
                r.this.kt = gVar;
                if (r.this.gq.get() == 2) {
                    if (!r.this.vl()) {
                        jVar.j(gVar);
                    } else {
                        if (r.this.uf.get()) {
                            return;
                        }
                        jVar.j(gVar);
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.r
            public void j(com.bytedance.sdk.openadsdk.core.component.splash.cw.j.ae aeVar) {
                if (!r.this.cw(aeVar.tl())) {
                    r.this.f28712l.set(false);
                    jVar.cw(aeVar);
                } else {
                    r.this.f28715p.set(false);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.r
            public void j() {
                r.this.xt(mVar);
            }
        }, this.f28708g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(com.bytedance.sdk.openadsdk.core.component.splash.cw.j.m mVar, com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.j jVar, boolean z5) {
        if (jVar == null) {
            return;
        }
        int cw = cw(j(mVar.up()));
        com.bytedance.sdk.openadsdk.core.ae.j.j("Splash_FullLink", "渲染 timeout " + cw);
        if (this.f28717s.get()) {
            return;
        }
        if (j(mVar.xt(), z5) && this.f28713m != null && cw <= 0) {
            cw = 0;
        }
        com.bytedance.sdk.openadsdk.core.ae.j.j("Splash_FullLink", "开始渲染 isCache " + mVar.up());
        j(jVar, mVar.up(), cw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(g gVar) {
        if (gVar == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean cw = gVar.cw();
        if (cw) {
            up.j(j(cw), this.ch, gVar);
            this.ch.r(currentTimeMillis - this.qv);
            this.ch.r(this.f28711j);
            this.ch.j(cw);
            up.j(j(cw), this.ch);
            up.xt(j(cw), this.ch);
        } else {
            up.j(j(cw), this.f28720x, gVar);
            this.f28720x.r(currentTimeMillis - this.qv);
            this.f28720x.r(this.f28711j);
            this.f28720x.j(cw);
            up.j(j(cw), this.f28720x);
            up.xt(j(cw), this.f28720x);
            com.bytedance.sdk.openadsdk.core.ae.j.j("Splash_FullLink", "开屏广告渲染--end, 耗时S3： " + (currentTimeMillis - this.ws));
        }
        StringBuilder sb = new StringBuilder("渲染成功回调 开屏广告类型： ");
        sb.append(cw ? "缓存" : "实时");
        com.bytedance.sdk.openadsdk.core.ae.j.j("Splash_FullLink", sb.toString());
        com.bytedance.sdk.openadsdk.core.ae.j.j("Splash_FullLink", "加载开屏广告--end，总耗时： " + (currentTimeMillis - this.qv));
        com.bytedance.sdk.openadsdk.core.ae.j.j("Splash_FullLink", "加载开屏广告--end，getReqId： " + j(cw).ej());
    }

    private void j(String str, int i6, int i7) {
        int az = v.xt().az(str);
        if (az == 1) {
            this.tl = i6 > 0 ? Math.min(i6, i7) : Math.max(i7, 500);
        } else if (az != 2) {
            this.tl = i6 > 0 ? Math.max(i6, i7) : Math.max(i7, 500);
        } else {
            this.tl = i6 > 0 ? i6 : Math.max(i7, 500);
        }
        int currentTimeMillis = (int) (this.tl - (System.currentTimeMillis() - this.cw.tl));
        if (currentTimeMillis <= 0) {
            currentTimeMillis = this.tl;
        }
        this.tl = currentTimeMillis;
        com.bytedance.sdk.openadsdk.core.ae.j.j("Splash_FullLink", "splashTimeOutControlType = " + az + "; devTimeOut = " + i7 + "; cloudTimeOut = " + i6 + "; realTimeOut = " + this.tl);
        this.f28713m.sendEmptyMessageDelayed(2, (long) this.tl);
        j(this.tl);
    }

    private void j(int i6) {
        int oq = v.xt().oq(this.ae);
        if (oq >= i6 || oq <= 0 || !vl() || this.f28713m == null) {
            return;
        }
        int i7 = i6 - oq;
        com.bytedance.sdk.openadsdk.core.ae.j.j("Splash_FullLink", "buffer time: " + oq + "  减去buffer time后超时时间：" + i7);
        this.f28713m.sendEmptyMessageDelayed(4, (long) i7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(com.bytedance.sdk.openadsdk.core.component.splash.cw.j.tl tlVar, com.bytedance.sdk.openadsdk.core.component.splash.cw.j.m mVar, j jVar, com.bytedance.sdk.openadsdk.i.cw.xt.xt xtVar, boolean z5) {
        if (this.f28717s.get()) {
            return;
        }
        xt(tlVar, System.currentTimeMillis());
        if (tlVar.qv()) {
            com.bytedance.sdk.openadsdk.core.ae.j.j("Splash_FullLink", "缓存广告： 素材首包回调");
            this.la.set(true);
        } else {
            com.bytedance.sdk.openadsdk.core.ae.j.j("Splash_FullLink", "实时广告： 素材首包回调");
            this.f28709h.set(true);
        }
        up.j(tlVar.qv() ? this.f28718v : this.f28707f, 3);
        m(tlVar.qv());
        if (z5) {
            j(tlVar, mVar, jVar);
        } else {
            j(tlVar, mVar, jVar, xtVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(com.bytedance.sdk.openadsdk.core.component.splash.cw.j.tl tlVar, com.bytedance.sdk.openadsdk.core.component.splash.cw.j.m mVar, j jVar, com.bytedance.sdk.openadsdk.i.cw.xt.xt xtVar, long j6, boolean z5) {
        if (tlVar == null) {
            return;
        }
        j(mVar, mVar.up(), false);
        if (this.f28717s.get()) {
            return;
        }
        if (xtVar instanceof com.bytedance.sdk.openadsdk.core.component.splash.r.j) {
            ((com.bytedance.sdk.openadsdk.core.component.splash.r.j) xtVar).j(tlVar, false);
        }
        j(tlVar, j6);
        if (tlVar.qv() && this.la.get()) {
            return;
        }
        if (tlVar.qv() || !this.f28709h.get()) {
            if (j(tlVar.xt(), tlVar.up()) || j(mVar.xt())) {
                up.j(tlVar.qv() ? this.f28718v : this.f28707f, 2);
                m(tlVar.qv());
            }
            if (z5) {
                j(tlVar, mVar, jVar);
            } else {
                j(tlVar, mVar, jVar, xtVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(com.bytedance.sdk.openadsdk.core.component.splash.cw.j.m mVar, com.bytedance.sdk.openadsdk.core.component.splash.cw.j.ae aeVar, j jVar, long j6) {
        if (aeVar == null) {
            return;
        }
        boolean tl = aeVar.tl();
        if (!cw(tl)) {
            com.bytedance.sdk.openadsdk.core.ae.j.j("Splash_FullLink", "实时cac广告: 素材加载失败，直接给回调");
            jVar.xt(aeVar);
        } else {
            com.bytedance.sdk.openadsdk.core.ae.j.j("Splash_FullLink", "缓存广告: 素材加载失败");
            this.f28705a.set(false);
            if (this.ed.get()) {
                jVar.xt(aeVar);
            }
        }
        j(mVar, tl, false);
        int i6 = aeVar.m() ? -14 : -7;
        if (!aeVar.m()) {
            m.j(j6, false, false, j(aeVar.tl()), i6, aeVar.up());
        }
        com.bytedance.sdk.openadsdk.core.ae.j.j("Splash_FullLink", (tl ? "缓存广告" : "实时广告") + "加载素材失败 " + aeVar.r());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(com.bytedance.sdk.openadsdk.core.component.splash.cw.j.m mVar, boolean z5, boolean z6) {
        if (z5) {
            return;
        }
        try {
            if (this.gq.get() > 0 && !this.uf.get()) {
                com.bytedance.sdk.openadsdk.core.ae.j.j("lqmt", "该实时广告已回调媒体");
            } else {
                if (com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.up.j(this.xt, this.cw)) {
                    return;
                }
                if (this.gq.get() > 0 || this.oq.cw()) {
                    this.f28708g.j(mVar, this.xt, z6, this.f28711j);
                }
            }
        } catch (Exception unused) {
        }
    }

    private void j(boolean z5, int i6) {
        (z5 ? this.ch : this.f28720x).up(i6);
    }

    public static boolean j() {
        return (com.bytedance.sdk.openadsdk.core.cw.up.j().vl() & 256) == 256;
    }

    public static boolean j(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar) {
        return com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.up.j(xtVar, new nd()) && (com.bytedance.sdk.openadsdk.core.cw.up.j().vl() & 4) == 4;
    }
}
