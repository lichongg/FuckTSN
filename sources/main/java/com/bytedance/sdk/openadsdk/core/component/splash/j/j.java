package com.bytedance.sdk.openadsdk.core.component.splash.j;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.m.qv;
import com.bytedance.sdk.openadsdk.core.component.splash.cw.j.ae;
import com.bytedance.sdk.openadsdk.core.component.splash.cw.j.g;
import com.bytedance.sdk.openadsdk.core.component.splash.cw.j.m;
import com.bytedance.sdk.openadsdk.core.cw.up;
import com.bytedance.sdk.openadsdk.core.oq;
import com.bytedance.sdk.openadsdk.core.rn.i;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.core.tj.h;
import com.bytedance.sdk.openadsdk.core.tj.ln;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.nd;
import com.bytedance.sdk.openadsdk.core.tj.ry;
import com.bytedance.sdk.openadsdk.core.tj.sm;
import com.bytedance.sdk.openadsdk.core.v;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class j {

    /* renamed from: j, reason: collision with root package name */
    protected long f28694j = 0;
    protected long xt = 0;
    protected AtomicBoolean cw = new AtomicBoolean(false);

    /* renamed from: r, reason: collision with root package name */
    protected AtomicBoolean f28695r = new AtomicBoolean(false);
    protected AtomicBoolean up = new AtomicBoolean(false);

    /* renamed from: com.bytedance.sdk.openadsdk.core.component.splash.j.j$j, reason: collision with other inner class name */
    public interface InterfaceC0450j {
        void j();

        void j(m mVar);
    }

    public static j j() {
        return (up.j().qv() & 16) == 16 ? new cw() : new r();
    }

    public abstract void cw();

    public abstract void j(com.bytedance.sdk.openadsdk.core.component.splash.cw.cw.r<g, ae> rVar, n nVar, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, boolean z5);

    public abstract void j(ae aeVar, String str, InterfaceC0450j interfaceC0450j);

    public abstract void j(sm smVar, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, boolean z5);

    public abstract void j(String str, String str2, boolean z5, boolean z6, Object obj);

    public abstract void xt();

    public void xt(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, nd ndVar) {
        if (v.xt().xt(uf.xt(xtVar)) && xtVar != null && TextUtils.isEmpty(xtVar.tj())) {
            com.bytedance.sdk.openadsdk.core.ae.j.j("lqmt", "preLoadSplashAd... ");
            nd ndVar2 = ndVar == null ? new nd() : ndVar.j();
            ndVar2.ae = System.currentTimeMillis();
            ndVar2.jy = oq.i().xq();
            j(xtVar, ndVar2);
        }
    }

    public void j(m mVar, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, boolean z5, int i6) {
        if (j(i6) && com.bytedance.sdk.openadsdk.core.up.r.r.j(mVar.xt()) && !this.cw.get()) {
            this.cw.set(true);
            com.bytedance.sdk.openadsdk.core.ae.j.j("Splash_FullLink", "cacheRealTimeAdWhenTimeout start");
            j(new sm(mVar.r(), mVar.xt(), null), xtVar, false);
            if (z5) {
                j(mVar.r(), mVar.xt(), xtVar);
            }
            com.bytedance.sdk.openadsdk.core.ae.j.j("Splash_FullLink", "cacheRealTimeAdWhenTimeout end");
        }
    }

    public static boolean j(int i6) {
        int qv = up.j().qv();
        return i6 == 2 ? (qv & 2) == 2 : (i6 == 3 || i6 == 1) && (qv & 32) == 32;
    }

    protected void j(final com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, nd ndVar) {
        if (this.cw.get()) {
            com.bytedance.sdk.openadsdk.core.ae.j.j("lqmt", "已经存储了一个实时广告");
            return;
        }
        if (this.f28695r.getAndSet(true)) {
            com.bytedance.sdk.openadsdk.core.ae.j.j("lqmt", "已在预加载开屏广告....不再发出");
            return;
        }
        if (v.xt().qv(xtVar.r()) && ndVar != null) {
            ndVar.f30364m = 2;
        }
        v.j().j(xtVar, ndVar, 4, new s.xt() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.j.j.1
            @Override // com.bytedance.sdk.openadsdk.core.s.xt
            public void j(int i6, String str, com.bytedance.sdk.openadsdk.core.tj.xt xtVar2) {
                j.this.f28695r.set(false);
                xtVar2.j(i6);
                com.bytedance.sdk.openadsdk.core.tj.xt.j(xtVar2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.s.xt
            public void j(com.bytedance.sdk.openadsdk.core.tj.j jVar, com.bytedance.sdk.openadsdk.core.tj.xt xtVar2) {
                if (com.bytedance.sdk.openadsdk.core.component.splash.m.xt(jVar)) {
                    n nVar = jVar.xt().get(0);
                    if (nVar.sj()) {
                        AtomicBoolean atomicBoolean = j.this.cw;
                        if ((atomicBoolean == null || !atomicBoolean.get()) && com.bytedance.sdk.openadsdk.core.up.r.r.j(nVar)) {
                            j.this.j(new sm(jVar, nVar, null), xtVar, false);
                            j.this.j(jVar, nVar, xtVar);
                            return;
                        }
                        return;
                    }
                    xtVar2.j(-4);
                    com.bytedance.sdk.openadsdk.core.tj.xt.j(xtVar2);
                    return;
                }
                j.this.f28695r.set(false);
            }
        });
    }

    public void j(final com.bytedance.sdk.openadsdk.core.tj.j jVar, final n nVar, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar) {
        if (nVar.fp() == null || nVar.fp().size() <= 0) {
            return;
        }
        h hVar = nVar.fp().get(0);
        String j6 = hVar.j();
        int xt = hVar.xt();
        int cw = hVar.cw();
        this.f28694j = System.currentTimeMillis();
        this.xt = SystemClock.elapsedRealtime();
        ry cw2 = com.bytedance.sdk.openadsdk.core.v.up.j().cw().cw();
        if (cw2 != null) {
            cw2.j(false);
        }
        final boolean z5 = ln.ws(nVar) != null;
        i.j(new com.bytedance.sdk.openadsdk.ws.xt(j6, hVar.ae()), xt, cw, new i.j() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.j.j.2
            @Override // com.bytedance.sdk.openadsdk.core.rn.i.j
            public void j(com.bytedance.sdk.openadsdk.core.v.j.xt xtVar2, qv qvVar) {
                com.bytedance.sdk.openadsdk.core.component.splash.m.j(jVar);
                if (!z5) {
                    com.bytedance.sdk.openadsdk.core.jy.cw.j(nVar, "splash_ad", System.currentTimeMillis() - j.this.f28694j);
                }
                j jVar2 = j.this;
                jVar2.f28694j = 0L;
                if (z5) {
                    com.bytedance.sdk.openadsdk.core.component.splash.m.j(jVar2.xt, false, true, nVar, 0L, "preLoadImageSuccess");
                }
                j.this.f28695r.set(false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.rn.i.j
            public void j() {
                com.bytedance.sdk.openadsdk.core.component.splash.m.j(jVar);
                if (z5) {
                    com.bytedance.sdk.openadsdk.core.component.splash.m.j(j.this.xt, false, false, nVar, -7L, "preLoadImageFailed");
                }
                j.this.f28695r.set(false);
            }
        }, com.bytedance.sdk.openadsdk.l.g.up(), 4, null, false);
    }
}
