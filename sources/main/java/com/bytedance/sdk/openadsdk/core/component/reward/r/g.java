package com.bytedance.sdk.openadsdk.core.component.reward.r;

import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.tj.e;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.q;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: D:\Downloads\app\classes4.dex */
public class g extends j {

    /* renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f28361c;
    private final AtomicBoolean ed;
    private final AtomicBoolean gx;

    /* renamed from: n, reason: collision with root package name */
    private final AtomicBoolean f28362n;
    private com.bytedance.sdk.openadsdk.core.component.reward.business.j.j nd;
    private final com.bytedance.sdk.openadsdk.core.video.xt.xt rh;
    protected final AtomicLong rn;
    private long uf;
    private final int wq;

    public static int xt(n nVar) {
        return 10;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.xt
    public boolean e() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.xt
    public boolean q() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.xt
    public boolean qb() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.xt
    public boolean xq() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.xt
    public boolean ya() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aq() {
        this.ed.set(false);
    }

    public static boolean j(n nVar) {
        return q.j(nVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kc() {
        this.f28366g.up(0);
        this.f28369j.gx();
        this.nd.cw();
        this.f28369j.tj();
    }

    private void pz() {
        if (this.f28361c.get()) {
            long j6 = this.uf - 1;
            this.uf = j6;
            if (j6 != 0) {
                if (j6 > 0) {
                    this.nd.j(j6);
                }
            } else {
                this.nd.j(j6);
                this.gx.set(true);
                if (ae()) {
                    this.nd.j(this.f28377x);
                } else {
                    this.nd.j(this.tl);
                }
            }
        }
    }

    private void rr() {
        this.f28361c.set(true);
        this.nd.j();
    }

    private void st() {
        if (this.ed.get()) {
            zz();
            pz();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.xt
    public void ff() {
        this.f28366g.up(8);
        this.f28366g.m(0);
        this.mi.up(true);
        this.mi.cw(true);
        this.mi.xt(true);
        this.mi.j(true);
        this.f28369j.ol();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public int p() {
        return xt(this.xt);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public com.bytedance.sdk.openadsdk.core.video.xt.xt rn() {
        return this.rh;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.xt
    protected void ry() {
        com.bytedance.sdk.openadsdk.core.nativeexpress.up upVar = this.f28377x;
        if (upVar != null) {
            ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) upVar.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(this.rh);
            ((com.bytedance.sdk.openadsdk.core.xt.j.cw.j) this.f28377x.j(com.bytedance.sdk.openadsdk.core.xt.j.cw.j.class)).j(this.rh);
        }
        com.bytedance.sdk.openadsdk.core.xt.up upVar2 = this.tl;
        if (upVar2 != null) {
            ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) upVar2.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(this.rh);
            ((com.bytedance.sdk.openadsdk.core.xt.j.cw.j) this.tl.j(com.bytedance.sdk.openadsdk.core.xt.j.cw.j.class)).j(this.rh);
        }
        com.bytedance.sdk.openadsdk.core.component.reward.business.j.j jVar = new com.bytedance.sdk.openadsdk.core.component.reward.business.j.j(this.f28369j, this.xt, this.rh);
        this.nd = jVar;
        jVar.j(this.f28369j.gq().getSceneFrameContainer(), this.f28369j.gq().getSceneFrame());
        this.ed.set(q.cw(this.xt) != 0);
        if (this.ed.get()) {
            s();
            this.f28368i = true;
        }
    }

    public void zz() {
        if (this.f28361c.get()) {
            return;
        }
        int h6 = (int) this.kt.h();
        int tj = (int) this.kt.tj();
        int cw = q.cw(this.xt);
        if (cw == 1) {
            j(q.r(this.xt), tj, this.gq.cw() * 1000, false);
        } else if (cw == 2) {
            j((int) (tj * 0.001f * 0.01f * q.r(this.xt)), tj, h6, false);
        } else {
            if (cw != 3) {
                return;
            }
            j(uf(), tj, h6, true);
        }
    }

    public g(TTBaseVideoActivity tTBaseVideoActivity, n nVar) {
        super(tTBaseVideoActivity, nVar);
        this.wq = 4;
        this.uf = 4L;
        this.ed = new AtomicBoolean(false);
        this.f28361c = new AtomicBoolean(false);
        this.gx = new AtomicBoolean(false);
        this.f28362n = new AtomicBoolean(false);
        this.rn = new AtomicLong();
        this.rh = new com.bytedance.sdk.openadsdk.core.video.xt.xt() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.r.g.1
            @Override // com.bytedance.sdk.openadsdk.core.video.xt.xt
            public boolean j() {
                if (!g.this.gx.get() && !q.xt(g.this.xt)) {
                    return false;
                }
                g.this.kc();
                return true;
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.xt.xt
            public Map<String, Object> ae() {
                HashMap hashMap = new HashMap();
                hashMap.put("refer", "in_video");
                return hashMap;
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.xt.xt
            public void cw() {
                g.this.gq();
                g.this.f28362n.set(true);
                g.this.f28369j.qv();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.xt.xt
            public void g() {
                g.this.f28369j.n();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.xt.xt
            public boolean m() {
                return g.this.f28365f.m();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.xt.xt
            public void oq() {
                TTBaseVideoActivity tTBaseVideoActivity2 = g.this.f28369j;
                if (tTBaseVideoActivity2 != null) {
                    tTBaseVideoActivity2.oq();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.xt.xt
            public int qv() {
                return g.this.gx.get() ? 1 : 2;
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.xt.xt
            public boolean r() {
                return g.this.f28362n.get();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.xt.xt
            public void tl() {
                g.this.aq();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.xt.xt
            public long up() {
                return g.this.rn.get();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.xt.xt
            public void xt() {
                g.this.gx.set(false);
                g.this.f28366g.up(8);
                if (!g.this.ae()) {
                    g.this.f28369j.n();
                }
                g.this.f28369j.f();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.xt.xt
            public void j(long j6, long j7) {
                g.this.kt.xt(j6);
                g.this.kt();
                g.this.rn.set(j6);
            }
        };
    }

    private void j(int i6, long j6, long j7, boolean z5) {
        if (z5) {
            if (i6 <= 3) {
                rr();
            }
        } else if (i6 > 0) {
            long j8 = i6 * 1000;
            if (j8 > j6) {
                return;
            }
            long j9 = j8 - j7;
            if (j9 <= 0 || Math.abs(j9) > 3200) {
                return;
            }
            rr();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public void gq() {
        super.gq();
        this.mi.j(false, "奖励已领取", "跳过", false, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.xt
    protected void k() {
        st();
        if (!e.i(this.xt)) {
            return;
        }
        this.f28369j.cw(0);
        if (ch() > n() || this.av) {
            com.bytedance.sdk.openadsdk.core.tl.r.f30512j = 0;
        }
        xt(m(true));
        com.bytedance.sdk.openadsdk.core.tl.r.f30512j = c();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public void kt() {
        boolean z5;
        String str;
        super.kt();
        this.f28368i = false;
        if (((int) (this.kt.h() / 1000)) < this.gq.up() && !this.f28369j.z()) {
            z5 = false;
        } else {
            z5 = true;
        }
        if (this.kt.rn()) {
            this.mi.j(false, null, "跳过", false, true);
            return;
        }
        int p5 = this.kt.p();
        if (!this.kt.j()) {
            com.bytedance.sdk.openadsdk.core.component.reward.xt.up upVar = this.mi;
            String str2 = p5 + "s";
            if (z5) {
                str = "跳过";
            } else {
                str = "";
            }
            upVar.j(false, str2, str, false, z5);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public void x() {
        super.x();
        this.mi.j(false, "奖励已领取", "跳过", false, true);
    }
}
