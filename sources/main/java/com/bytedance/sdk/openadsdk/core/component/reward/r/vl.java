package com.bytedance.sdk.openadsdk.core.component.reward.r;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.cw.xt;
import com.bytedance.sdk.openadsdk.core.rn.tj;
import com.bytedance.sdk.openadsdk.core.tj.kt;
import com.bytedance.sdk.openadsdk.core.tj.n;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class vl extends j {
    int rn;
    private com.bytedance.sdk.openadsdk.core.jy.up uf;
    int wq;

    public static boolean j(n nVar) {
        return nVar.l() == 1 && kt.j(nVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public void cw(boolean z5) {
        super.cw(z5);
        com.bytedance.sdk.openadsdk.core.component.reward.layout.xt xtVar = this.f28366g;
        if (xtVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.j) {
            if (((com.bytedance.sdk.openadsdk.core.component.reward.layout.j) xtVar).m()) {
                this.uf.j(((com.bytedance.sdk.openadsdk.core.component.reward.layout.j) this.f28366g).up().get());
            }
            ((com.bytedance.sdk.openadsdk.core.component.reward.layout.j) this.f28366g).tl();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.xt
    public boolean e() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public boolean m() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.xt
    public boolean q() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.xt
    public boolean qb() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public void xt(boolean z5) {
        super.xt(z5);
        this.uf.cw();
        com.bytedance.sdk.openadsdk.core.component.reward.layout.xt xtVar = this.f28366g;
        if (xtVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.j) {
            ((com.bytedance.sdk.openadsdk.core.component.reward.layout.j) xtVar).g();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    protected int ae(boolean z5) {
        if ((this.tj.rn() && kt.j(this.xt)) || this.rn == 0) {
            return 0;
        }
        return (com.bytedance.sdk.openadsdk.core.ugeno.oq.up(this.xt) || com.bytedance.sdk.openadsdk.core.ugeno.oq.r(this.xt)) ? Math.max(this.rn - ch(), 0) : Math.max(Math.min(this.rn, 27) - ch(), 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    protected int ed() {
        if ((this.tj.rn() && kt.j(this.xt)) || this.rn == 0) {
            return 0;
        }
        if (com.bytedance.sdk.openadsdk.core.ugeno.oq.up(this.xt) || com.bytedance.sdk.openadsdk.core.ugeno.oq.r(this.xt)) {
            return Math.max(this.rn - ch(), 0);
        }
        return Math.max(((int) Math.min((this.rn * this.xt.nw()) / 100.0f, 27.0f)) - ch(), 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public void f() {
        if (com.bytedance.sdk.openadsdk.core.ugeno.oq.r(this.xt) && ((com.bytedance.sdk.openadsdk.core.component.reward.layout.j) this.f28366g).cw()) {
            ((com.bytedance.sdk.openadsdk.core.component.reward.layout.j) this.f28366g).j(false);
        } else {
            super.f();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.xt
    public void ff() {
        this.f28366g.up(0);
        this.mi.j(true);
        if (com.bytedance.sdk.openadsdk.core.ugeno.oq.r(this.xt)) {
            this.mi.up(true);
        }
        if (com.bytedance.sdk.openadsdk.core.ugeno.oq.up(this.xt) || com.bytedance.sdk.openadsdk.core.ugeno.oq.r(this.xt)) {
            this.mi.xt(false);
        } else {
            this.mi.xt(this.xt.xa());
        }
        if (!com.bytedance.sdk.openadsdk.core.ugeno.oq.cw(this.xt)) {
            this.mi.up(false);
            this.mi.j(false, null, null, true, true);
            return;
        }
        this.mi.cw(true);
        this.mi.up(true);
        com.bytedance.sdk.openadsdk.core.component.reward.xt.up upVar = this.mi;
        boolean z5 = this.ws;
        StringBuilder sb = new StringBuilder();
        sb.append(uf());
        sb.append("s");
        sb.append(this.ws ? "后可领取奖励" : "");
        upVar.j(z5, sb.toString(), null, true, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public View g() {
        FrameLayout frameLayout = new FrameLayout(this.f28369j);
        frameLayout.setId(2114387959);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return frameLayout;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.xt
    protected void k() {
        int ch = ch();
        int max = Math.max(0, this.rn - ch);
        if (!this.tj.rn()) {
            int i6 = this.rn;
            if (ch >= i6) {
                if (com.bytedance.sdk.openadsdk.core.ugeno.oq.cw(this.xt)) {
                    com.bytedance.sdk.openadsdk.core.component.reward.xt.up upVar = this.mi;
                    boolean z5 = this.ws;
                    upVar.j(z5, z5 ? "领取成功" : "", null, true, true);
                } else {
                    this.mi.j(false, null, null, true, true);
                }
                this.f28369j.qv();
            } else if (this.wq >= i6) {
                this.mi.j(false, String.valueOf(max), null, false, false);
            } else if (com.bytedance.sdk.openadsdk.core.ugeno.oq.cw(this.xt)) {
                com.bytedance.sdk.openadsdk.core.component.reward.xt.up upVar2 = this.mi;
                boolean z6 = this.ws;
                StringBuilder sb = new StringBuilder();
                sb.append(max);
                sb.append("s");
                sb.append(this.ws ? "后可领取奖励" : "");
                upVar2.j(z6, sb.toString(), null, this.wq <= ch, true);
            } else if (com.bytedance.sdk.openadsdk.core.ugeno.oq.up(this.xt) || com.bytedance.sdk.openadsdk.core.ugeno.oq.r(this.xt)) {
                if (ch >= this.wq) {
                    this.mi.j(false, null, null, true, true);
                }
            } else if (ch >= this.wq) {
                this.mi.j(false, String.valueOf(max), "跳过", false, true);
            } else {
                this.mi.j(false, String.valueOf(max), (this.wq - ch) + "s后可跳过", false, false);
            }
        }
        this.f28369j.cw(0);
        if (com.bytedance.sdk.openadsdk.core.ugeno.oq.up(this.xt)) {
            ((com.bytedance.sdk.openadsdk.core.component.reward.layout.j) this.f28366g).j(max);
        }
        if (max == 0) {
            com.bytedance.sdk.openadsdk.core.component.reward.layout.xt xtVar = this.f28366g;
            if (xtVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.j) {
                ((com.bytedance.sdk.openadsdk.core.component.reward.layout.j) xtVar).ae();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public int p() {
        return xt(this.xt);
    }

    public vl(TTBaseVideoActivity tTBaseVideoActivity, n nVar) {
        super(tTBaseVideoActivity, nVar);
        this.rn = 0;
        this.wq = 0;
        com.bytedance.sdk.openadsdk.core.jy.up upVar = new com.bytedance.sdk.openadsdk.core.jy.up(nVar);
        this.uf = upVar;
        upVar.j(true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public void az() {
        super.az();
        com.bytedance.sdk.openadsdk.core.component.reward.layout.xt xtVar = this.f28366g;
        if ((xtVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.j) && ((com.bytedance.sdk.openadsdk.core.component.reward.layout.j) xtVar).m()) {
            this.uf.r();
        }
        this.f28366g.oq();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public com.bytedance.sdk.openadsdk.core.component.reward.layout.xt j(boolean z5) {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.j jVar = new com.bytedance.sdk.openadsdk.core.component.reward.layout.j(this.f28369j, this.xt, z5, this.uf, this.mi);
        this.f28366g = jVar;
        return jVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public boolean la() {
        if (uf() > 0) {
            return false;
        }
        if (com.bytedance.sdk.openadsdk.core.ugeno.oq.up(this.xt)) {
            ((com.bytedance.sdk.openadsdk.core.component.reward.layout.j) this.f28366g).j(0);
            return true;
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public void tj() {
        super.tj();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public void tl() {
        JSONObject cw;
        super.tl();
        com.bytedance.sdk.openadsdk.core.playable.xt.j().j(this.xt);
        if (!com.bytedance.sdk.openadsdk.core.ugeno.oq.up(this.xt) && !com.bytedance.sdk.openadsdk.core.ugeno.oq.r(this.xt)) {
            this.rn = tj.up(this.xt);
        } else {
            com.bytedance.sdk.openadsdk.core.ugeno.g.j h6 = this.xt.h();
            this.rn = 30;
            if (h6 != null && (cw = h6.cw()) != null) {
                this.rn = cw.optInt("reward_time", 30);
            }
        }
        this.wq = tj.m(this.xt);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public void up(boolean z5) {
        super.up(z5);
        if (com.bytedance.sdk.openadsdk.core.ugeno.oq.r(this.xt)) {
            ((com.bytedance.sdk.openadsdk.core.component.reward.layout.j) this.f28366g).xt(z5);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public void ws() {
        super.ws();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public xt.j j(final com.bytedance.sdk.openadsdk.core.component.reward.cw.oq oqVar) {
        this.f28369j.gx();
        this.f28369j.c();
        com.bytedance.sdk.openadsdk.core.component.reward.cw.tl tlVar = new com.bytedance.sdk.openadsdk.core.component.reward.cw.tl(this.f28369j, this.xt);
        tlVar.j(this.tj.kt());
        tlVar.j(c());
        return tlVar.xt(new com.bytedance.sdk.openadsdk.core.component.reward.cw.oq() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.r.vl.1
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.oq
            public void j() {
                com.bytedance.sdk.openadsdk.core.component.reward.cw.oq oqVar2 = oqVar;
                if (oqVar2 != null) {
                    oqVar2.j();
                }
                if (com.bytedance.sdk.openadsdk.core.ugeno.oq.r(vl.this.xt) && ((com.bytedance.sdk.openadsdk.core.component.reward.layout.j) vl.this.f28366g).r()) {
                    return;
                }
                vl.this.f28369j.n();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.oq
            public void xt() {
                com.bytedance.sdk.openadsdk.core.component.reward.cw.oq oqVar2 = oqVar;
                if (oqVar2 != null) {
                    oqVar2.xt();
                }
            }
        });
    }

    public static int xt(n nVar) {
        return com.bytedance.sdk.openadsdk.core.ugeno.oq.cw(nVar) ? 6 : 7;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j, com.bytedance.sdk.openadsdk.core.component.reward.r.xt
    protected void cw() {
        this.mi.j(4);
        this.f28366g.cw(true);
        if (com.bytedance.sdk.openadsdk.core.ugeno.oq.up(this.xt) || com.bytedance.sdk.openadsdk.core.ugeno.oq.r(this.xt)) {
            ((com.bytedance.sdk.openadsdk.core.component.reward.layout.j) this.f28366g).j(Math.max(0, this.rn - ch()));
        }
        this.f28369j.xt(true, true);
        s();
    }
}
