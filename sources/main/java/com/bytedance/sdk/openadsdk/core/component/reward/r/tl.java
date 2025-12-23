package com.bytedance.sdk.openadsdk.core.component.reward.r;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.cw.xt;
import com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.RewardJointEndCardFrameLayout;
import com.bytedance.sdk.openadsdk.core.rn.tj;
import com.bytedance.sdk.openadsdk.core.tj.kt;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.ol;

/* loaded from: D:\Downloads\app\classes4.dex */
public class tl extends j {
    int rn;
    boolean uf;
    int wq;

    public static boolean j(n nVar) {
        return tj.cw(nVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j, com.bytedance.sdk.openadsdk.core.component.reward.r.xt
    protected void cw() {
        this.mi.j(4);
        this.tj.j();
        this.f28369j.w();
        if (kt.qv(this.xt)) {
            this.mi.xt(true);
        }
        this.rn = tj.up(this.xt);
        this.wq = tj.m(this.xt);
        s();
        if (kt.r(this.xt)) {
            this.f28369j.up();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.xt
    public boolean e() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public boolean m() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.xt
    public boolean q() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public void xt(boolean z5) {
        super.xt(z5);
    }

    public static int xt(n nVar) {
        return kt.j(nVar) ? 6 : 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    protected int ae(boolean z5) {
        int i6;
        if (kt.qv(this.xt) || (i6 = this.rn) == 0) {
            return 0;
        }
        return Math.max(0, ((int) Math.min(i6, 27.0f)) - ch());
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    protected int ed() {
        if (kt.qv(this.xt) || this.rn == 0) {
            return 0;
        }
        return Math.max(0, ((int) Math.min((this.rn * this.xt.nw()) / 100.0f, 27.0f)) - ch());
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.xt
    public void ff() {
        this.mi.j(true);
        this.f28366g.m(8);
        if (kt.j(this.xt)) {
            zz();
        } else {
            this.mi.up(true);
            this.mi.xt(this.xt.xa());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public View g() {
        return com.bytedance.sdk.openadsdk.res.up.j(this.f28369j);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public xt.j j(final com.bytedance.sdk.openadsdk.core.component.reward.cw.oq oqVar) {
        if (this.f28365f.up()) {
            return new xt.j(false, 0, "");
        }
        this.f28369j.gx();
        this.f28369j.c();
        com.bytedance.sdk.openadsdk.core.component.reward.cw.tl tlVar = new com.bytedance.sdk.openadsdk.core.component.reward.cw.tl(this.f28369j, this.xt);
        tlVar.j(this.tj.kt());
        tlVar.j(c());
        return tlVar.xt(new com.bytedance.sdk.openadsdk.core.component.reward.cw.oq() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.r.tl.1
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.oq
            public void j() {
                com.bytedance.sdk.openadsdk.core.component.reward.cw.oq oqVar2 = oqVar;
                if (oqVar2 != null) {
                    oqVar2.j();
                }
                tl.this.f28369j.n();
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

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.xt
    protected void k() {
        if (kt.qv(this.xt)) {
            return;
        }
        int ch = ch();
        int i6 = this.rn;
        int i7 = i6 - ch;
        if (ch >= i6) {
            this.mi.j(false, null, null, true, true);
            if (!kt.qv(this.xt)) {
                this.f28369j.qv();
            }
        } else {
            int i8 = this.wq;
            if (i8 >= i6) {
                this.mi.j(false, String.valueOf(i7), null, false, false);
            } else if (ch >= i8) {
                this.mi.j(false, String.valueOf(i7), "跳过", false, true);
            } else {
                this.mi.j(false, String.valueOf(i7), (this.wq - ch) + "s后可跳过", false, false);
            }
        }
        this.f28369j.cw(0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public View oq() {
        if (kt.r(this.xt)) {
            this.qv = new RewardJointEndCardFrameLayout(this.f28369j, this.xt);
        }
        return super.oq();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public int p() {
        return xt(this.xt);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.xt
    public boolean qb() {
        return kt.r(this.xt) && n.xt(this.xt);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.xt
    protected boolean xq() {
        return kt.r(this.xt);
    }

    public void zz() {
        int fv = this.xt.fv();
        if (fv == 0) {
            this.f28366g.up(0);
            this.mi.up(true);
            this.mi.xt(this.xt.xa());
        } else {
            if (fv != 1) {
                if (fv != 3) {
                    return;
                }
                this.mi.up(false);
                this.mi.xt(false);
                this.mi.j(false, null, null, true, true);
                return;
            }
            this.f28366g.up(0);
            this.mi.xt(this.xt.xa());
            if (kt.r(this.xt)) {
                this.mi.up(n.xt(this.xt));
            } else {
                this.mi.up(com.bytedance.sdk.openadsdk.l.oq.j(this.xt));
            }
        }
    }

    public tl(TTBaseVideoActivity tTBaseVideoActivity, n nVar) {
        super(tTBaseVideoActivity, nVar);
        this.rn = 0;
        this.wq = 0;
        this.uf = false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public void az() {
        super.az();
        com.bytedance.sdk.openadsdk.core.playable.xt.j().xt(this.xt);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public boolean la() {
        if (uf() > 0) {
            return false;
        }
        if (kt.r(this.xt) || ol.j(this.xt) != 0) {
            return true;
        }
        return this.tj.kt();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public void tl() {
        super.tl();
        com.bytedance.sdk.openadsdk.core.playable.xt.j().j(this.xt);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public void ws() {
        super.ws();
        this.f28369j.c();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public void cw(boolean z5) {
        super.cw(z5);
    }
}
