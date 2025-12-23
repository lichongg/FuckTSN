package com.bytedance.sdk.openadsdk.core.component.reward.xt;

import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.r.g;
import com.bytedance.sdk.openadsdk.core.tj.ln;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.video.xt.j;
import com.bytedance.sdk.openadsdk.l.oq;
import com.bytedance.sdk.openadsdk.m.cw.i;
import java.io.File;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m {
    com.bykv.vk.openvk.component.video.api.r.cw ae;
    private com.bykv.vk.openvk.component.video.api.cw.r av;
    private com.bytedance.sdk.openadsdk.core.xt.j az;
    private String jy;

    /* renamed from: m, reason: collision with root package name */
    boolean f28518m;
    private TTBaseVideoActivity oq;
    private n qv;

    /* renamed from: r, reason: collision with root package name */
    protected long f28519r;
    long tl;
    protected int up;
    private FrameLayout vl;
    private long ws;

    /* renamed from: g, reason: collision with root package name */
    private final int f28515g = 210;

    /* renamed from: j, reason: collision with root package name */
    boolean f28517j = false;
    protected boolean xt = false;
    protected boolean cw = false;

    /* renamed from: i, reason: collision with root package name */
    private boolean f28516i = false;

    public boolean cw() {
        com.bykv.vk.openvk.component.video.api.r.cw cwVar = this.ae;
        return (cwVar == null || cwVar.i() == null || !this.ae.i().ws()) ? false : true;
    }

    public void j(n nVar) {
        this.qv = nVar;
    }

    public void nd() {
        this.cw = true;
    }

    public boolean xt() {
        com.bykv.vk.openvk.component.video.api.r.cw cwVar = this.ae;
        return (cwVar == null || cwVar.i() == null || !this.ae.i().jy()) ? false : true;
    }

    private void ol() {
        com.bykv.vk.openvk.component.video.api.r.cw cwVar = this.ae;
        if (cwVar == null || cwVar.i() == null) {
            return;
        }
        this.tl = this.ae.qv();
        if (this.ae.i().oq() || !this.ae.i().g()) {
            this.ae.m();
            this.ae.g();
            this.xt = true;
        }
    }

    public void a() {
        try {
            this.oq.ws(1);
        } catch (Throwable th) {
            vl.r("TTBaseVideoActivity", "onContinue throw Exception :" + th.getMessage());
        }
    }

    public void ae() {
        com.bykv.vk.openvk.component.video.api.r.cw cwVar = this.ae;
        if (cwVar == null) {
            return;
        }
        cwVar.g();
        this.ae = null;
    }

    public long av() {
        com.bykv.vk.openvk.component.video.api.r.cw cwVar = this.ae;
        return cwVar != null ? cwVar.qv() : this.tl;
    }

    public int az() {
        com.bykv.vk.openvk.component.video.api.r.cw cwVar = this.ae;
        if (cwVar != null) {
            return cwVar.az();
        }
        return 0;
    }

    public com.bykv.vk.openvk.component.video.api.r.cw c() {
        return this.ae;
    }

    public void cw(boolean z5) {
        com.bykv.vk.openvk.component.video.api.r.cw cwVar = this.ae;
        if (cwVar != null) {
            cwVar.xt(z5);
        }
    }

    public boolean ed() {
        com.bykv.vk.openvk.component.video.api.r.cw cwVar = this.ae;
        if (cwVar == null || cwVar.i() == null) {
            return false;
        }
        return this.ae.i().m();
    }

    public boolean f() {
        com.bykv.vk.openvk.component.video.api.r.cw cwVar = this.ae;
        if (cwVar != null) {
            if (cwVar.i() != null) {
                com.bykv.vk.openvk.component.video.api.j i6 = this.ae.i();
                if (i6.ws() || i6.az()) {
                    ((com.bytedance.sdk.openadsdk.core.video.xt.j) this.ae).e();
                    return true;
                }
            } else if (up()) {
                j(false);
                ((com.bytedance.sdk.openadsdk.core.video.xt.j) this.ae).e();
                return true;
            }
        }
        return false;
    }

    public void g() {
        com.bykv.vk.openvk.component.video.api.r.cw cwVar = this.ae;
        if (cwVar != null) {
            cwVar.oq();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void gx() {
        int i6;
        i.j jVar = new i.j();
        long kt = kt();
        long av = av();
        if (gq() != null) {
            jVar.j(gq().j(av, kt));
        }
        jVar.cw(kt);
        jVar.xt(i());
        jVar.up(3);
        jVar.m(w());
        com.bykv.vk.openvk.component.video.api.r.cw cwVar = this.ae;
        if (cwVar instanceof com.bytedance.sdk.openadsdk.core.video.xt.j) {
            ((com.bytedance.sdk.openadsdk.core.video.xt.j) cwVar).tj.cw(32);
            i6 = ((com.bytedance.sdk.openadsdk.core.video.xt.j) this.ae).tj.j(2);
        } else {
            i6 = 0;
        }
        com.bytedance.sdk.openadsdk.m.xt.r.j(uf(), jVar, this.oq.ae(), i6 ^ 1);
    }

    public long i() {
        com.bykv.vk.openvk.component.video.api.r.cw cwVar = this.ae;
        if (cwVar != null) {
            return cwVar.vl();
        }
        return 0L;
    }

    public void j(FrameLayout frameLayout, String str, boolean z5) {
        if (this.f28516i) {
            return;
        }
        this.f28516i = true;
        this.vl = frameLayout;
        this.jy = str;
        this.f28518m = z5;
        if (z5) {
            this.ae = new com.bytedance.sdk.openadsdk.core.component.reward.m.xt(this.oq, frameLayout, this.qv, this.az);
        } else {
            this.ae = new com.bytedance.sdk.openadsdk.core.component.reward.m.j(this.oq, frameLayout, this.qv, this.az);
        }
        this.up = (int) l();
    }

    public boolean jy() {
        com.bykv.vk.openvk.component.video.api.r.cw cwVar = this.ae;
        if (cwVar != null) {
            return cwVar.mi();
        }
        return false;
    }

    public long kt() {
        com.bykv.vk.openvk.component.video.api.r.cw cwVar = this.ae;
        if (cwVar != null) {
            return cwVar.ws() + this.ae.vl();
        }
        return 0L;
    }

    public double l() {
        if (ln.ws(this.qv) == null) {
            return 0.0d;
        }
        double m6 = ln.m(this.qv);
        if (this.qv.to() != 2 || m6 <= 60.0d) {
            return m6;
        }
        return 60.0d;
    }

    public long m() {
        return this.tl;
    }

    public void mi() {
        com.bykv.vk.openvk.component.video.api.r.cw cwVar = this.ae;
        if (cwVar == null || cwVar.i() == null) {
            return;
        }
        this.ae.i().r();
    }

    public boolean n() {
        return this.cw;
    }

    public void oq() {
        com.bykv.vk.openvk.component.video.api.r.cw cwVar = this.ae;
        if (cwVar != null) {
            cwVar.xt();
        }
    }

    public int p() {
        return this.up;
    }

    public boolean qv() {
        com.bykv.vk.openvk.component.video.api.r.cw cwVar = this.ae;
        if (cwVar != null) {
            return cwVar.r();
        }
        return false;
    }

    public boolean r() {
        com.bykv.vk.openvk.component.video.api.r.cw cwVar = this.ae;
        return cwVar != null && cwVar.f();
    }

    public void rh() {
        try {
            com.bykv.vk.openvk.component.video.api.r.cw cwVar = this.ae;
            if (cwVar instanceof com.bytedance.sdk.openadsdk.core.video.xt.j) {
                ((com.bytedance.sdk.openadsdk.core.video.xt.j) cwVar).ry();
            }
        } catch (Throwable unused) {
        }
    }

    public void s() {
        try {
            this.oq.jy(1);
        } catch (Throwable th) {
            vl.r("TTBaseVideoActivity", "onPause throw Exception :" + th.getMessage());
        }
    }

    public long tj() {
        com.bykv.vk.openvk.component.video.api.r.cw cwVar = this.ae;
        if (cwVar != null) {
            return cwVar.ws();
        }
        return 0L;
    }

    public void tl() {
        if (this.ae != null && xt()) {
            this.ae.xt(true);
        }
    }

    public com.bykv.vk.openvk.component.video.api.r.xt uf() {
        com.bykv.vk.openvk.component.video.api.r.cw cwVar = this.ae;
        if (cwVar != null) {
            return cwVar.w();
        }
        return null;
    }

    public boolean up() {
        return this.xt;
    }

    public boolean v() {
        return this.ae != null;
    }

    public boolean vl() {
        com.bykv.vk.openvk.component.video.api.r.cw cwVar = this.ae;
        if (cwVar != null) {
            return cwVar.up();
        }
        return false;
    }

    public int w() {
        com.bykv.vk.openvk.component.video.api.r.cw cwVar = this.ae;
        if (cwVar != null) {
            return cwVar.jy();
        }
        return 0;
    }

    public boolean wq() {
        com.bykv.vk.openvk.component.video.api.r.cw cwVar = this.ae;
        if (cwVar == null) {
            return false;
        }
        return cwVar.cw();
    }

    public long ws() {
        com.bykv.vk.openvk.component.video.api.r.cw cwVar = this.ae;
        if (cwVar != null) {
            return cwVar.ws();
        }
        return 0L;
    }

    public boolean x() {
        com.bykv.vk.openvk.component.video.api.r.cw cwVar = this.ae;
        return cwVar != null && cwVar.i() == null;
    }

    public void xt(boolean z5) {
        if (this.ae == null) {
            return;
        }
        int i6 = z5 ? ed() ? 2 : 4 : ed() ? 0 : 1;
        i.j jVar = new i.j();
        jVar.xt(i());
        long kt = kt();
        jVar.cw(kt);
        long av = av();
        if (gq() != null) {
            jVar.j(gq().j(av, kt));
        }
        jVar.cw(1 ^ (ed() ? 1 : 0));
        jVar.r(i6);
        com.bykv.vk.openvk.component.video.api.r.cw cwVar = this.ae;
        if (!(cwVar instanceof com.bytedance.sdk.openadsdk.core.video.xt.j) || ((com.bytedance.sdk.openadsdk.core.video.xt.j) cwVar).tj.j(128)) {
            return;
        }
        ((com.bytedance.sdk.openadsdk.core.video.xt.j) this.ae).tj.cw(128);
        com.bytedance.sdk.openadsdk.m.xt.r.cw(this.ae.w(), jVar);
    }

    public m(TTBaseVideoActivity tTBaseVideoActivity) {
        this.oq = tTBaseVideoActivity;
    }

    public void ch() {
        ae();
    }

    public com.bytedance.sdk.openadsdk.core.video.xt.j gq() {
        return (com.bytedance.sdk.openadsdk.core.video.xt.j) c();
    }

    public long h() {
        long la = la();
        com.bytedance.sdk.openadsdk.core.video.xt.j gq = gq();
        if (gq != null && gq.rn()) {
            return gq.j(this.f28519r, tj());
        }
        return la;
    }

    public long la() {
        if (qv()) {
            double m6 = ln.av(this.qv).m() * 1000.0d * gq().hl();
            long j6 = this.f28519r;
            if (m6 - j6 > 210.0d) {
                long j7 = (long) (j6 + m6);
                this.ws = j7;
                return j7;
            }
        }
        return Math.max(this.f28519r, this.ws);
    }

    public boolean rn() {
        com.bytedance.sdk.openadsdk.core.video.xt.j gq = gq();
        if (gq == null) {
            return false;
        }
        return gq.k();
    }

    public boolean j() {
        com.bykv.vk.openvk.component.video.api.r.cw cwVar = this.ae;
        return (cwVar == null || cwVar.i() == null || !this.ae.i().g()) ? false : true;
    }

    public void j(boolean z5) {
        this.xt = z5;
    }

    public void j(long j6) {
        this.tl = j6;
    }

    public void j(long j6, boolean z5) {
        com.bykv.vk.openvk.component.video.api.r.cw cwVar = this.ae;
        if (cwVar == null || this.cw) {
            return;
        }
        if (j6 != 0) {
            cwVar.j(j6);
            this.ae.xt(z5);
        } else {
            cwVar.tl();
        }
    }

    public void j(Map<String, Object> map) {
        com.bykv.vk.openvk.component.video.api.r.cw cwVar = this.ae;
        if (cwVar == null || this.cw) {
            return;
        }
        cwVar.j(map);
    }

    public void xt(Map<String, Object> map) {
        com.bykv.vk.openvk.component.video.api.r.cw cwVar = this.ae;
        if (cwVar != null) {
            cwVar.xt(map);
        }
    }

    public void j(j.InterfaceC0494j interfaceC0494j) {
        com.bykv.vk.openvk.component.video.api.r.cw cwVar = this.ae;
        if (cwVar instanceof com.bytedance.sdk.openadsdk.core.video.xt.j) {
            ((com.bytedance.sdk.openadsdk.core.video.xt.j) cwVar).j(interfaceC0494j);
        }
    }

    public void xt(long j6) {
        this.f28519r = j6;
        com.bytedance.sdk.openadsdk.core.video.xt.j gq = gq();
        if (!vl() && qv()) {
            this.up = (int) Math.max(0L, Math.round(l() - ((this.f28519r + (ln.av(this.qv).m() * 1000.0d)) / 1000.0d)));
        } else if (gq != null && !(this.oq.e() instanceof g)) {
            this.up = Math.max(0, (int) (l() - (gq.hh() / 1000)));
        } else {
            this.up = Math.max(0, (int) (l() - (this.f28519r / 1000)));
        }
    }

    public boolean j(long j6, boolean z5, int i6) {
        if (this.ae == null || ln.ws(this.qv) == null) {
            return false;
        }
        com.bykv.vk.openvk.component.video.api.cw.r rVar = this.av;
        if (rVar == null) {
            File file = new File(com.bytedance.sdk.openadsdk.l.g.j(this.qv.ly()).j(), ln.ae(this.qv));
            if (file.exists() && file.length() > 0) {
                this.f28517j = true;
            }
            rVar = ln.j(1, this.qv);
            rVar.xt(this.qv.fs());
            FrameLayout frameLayout = this.vl;
            rVar.xt(frameLayout == null ? 100 : frameLayout.getWidth());
            FrameLayout frameLayout2 = this.vl;
            rVar.cw(frameLayout2 != null ? frameLayout2.getHeight() : 100);
            rVar.cw(this.qv.os());
            rVar.j(j6);
            rVar.xt(z5);
            if (oq.j(this.qv)) {
                rVar.j(true);
            }
        }
        return this.ae.j(rVar);
    }

    public void j(boolean z5, TTBaseVideoActivity tTBaseVideoActivity, boolean z6) {
        boolean z7;
        long j6;
        boolean z8;
        if (!z6 || z5 || this.oq.qb()) {
            return;
        }
        if (cw()) {
            com.bytedance.sdk.openadsdk.core.video.xt.xt rn = this.oq.e().rn();
            if (rn != null) {
                z7 = rn.r();
                j6 = rn.up();
                z8 = rn.m();
            } else {
                z7 = false;
                j6 = 0;
                z8 = false;
            }
            if (z7) {
                ol();
                j(tTBaseVideoActivity);
            } else {
                j(j6, z8);
            }
            vl.j("TTBaseVideoActivity", "resumeOrRestartVideo: continue play");
            return;
        }
        ol();
        j(tTBaseVideoActivity);
        vl.j("TTBaseVideoActivity", "resumeOrRestartVideo: recreate video player & exec play");
    }

    protected void j(TTBaseVideoActivity tTBaseVideoActivity) {
        if (!f() || tTBaseVideoActivity == null) {
            return;
        }
        tTBaseVideoActivity.xt(m(), true);
    }

    public void j(int i6) {
        com.bykv.vk.openvk.component.video.api.r.cw cwVar = this.ae;
        if (cwVar != null) {
            cwVar.j(i6);
        }
    }

    public void j(n nVar, com.bykv.vk.openvk.component.video.api.r.cw cwVar, com.bykv.vk.openvk.component.video.api.cw.r rVar) {
        this.qv = nVar;
        this.ae = cwVar;
        this.av = rVar;
    }

    public void j(com.bytedance.sdk.openadsdk.core.xt.j jVar) {
        this.az = jVar;
    }

    public void j(float f6) {
        if (this.ae.i() != null) {
            this.ae.i().j(f6);
        }
    }
}
