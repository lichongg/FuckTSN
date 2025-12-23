package com.bytedance.sdk.openadsdk.core.component.reward.r;

import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.tj.e;
import com.bytedance.sdk.openadsdk.core.tj.hh;
import com.bytedance.sdk.openadsdk.core.tj.n;

/* loaded from: D:\Downloads\app\classes4.dex */
public class jy extends j {
    public static boolean j(n nVar) {
        return true;
    }

    public static int xt(n nVar) {
        return 1;
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
    protected boolean sm() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.xt
    public void ff() {
        this.mi.xt(this.xt.xa());
        if (m()) {
            this.f28366g.up(8);
            this.f28366g.m(8);
            this.mi.j(false);
        } else {
            this.f28366g.up(0);
            this.f28366g.m(0);
            this.mi.up(true);
            this.f28369j.ol();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.xt
    protected void k() {
        if (e.i(this.xt)) {
            boolean cw = e.cw();
            boolean cw2 = e.cw();
            this.f28369j.cw(0);
            if (ch() > n() || this.av) {
                com.bytedance.sdk.openadsdk.core.tl.r.f30512j = 0;
                com.bytedance.sdk.openadsdk.core.component.reward.xt.up upVar = this.mi;
                boolean z5 = this.ws;
                upVar.j(z5, z5 ? "领取成功" : "", cw ? "" : "跳过", cw2, true);
                this.f28369j.hh();
                return;
            }
            int m6 = m(true);
            int m7 = m(false);
            com.bytedance.sdk.openadsdk.core.tl.r.f30512j = m6;
            boolean z6 = ch() > this.gq.up() || this.f28369j.z();
            boolean z7 = !cw && z6;
            boolean z8 = cw2 && z6;
            com.bytedance.sdk.openadsdk.core.component.reward.xt.up upVar2 = this.mi;
            boolean z9 = this.ws;
            StringBuilder sb = new StringBuilder();
            sb.append(m7);
            sb.append("s");
            sb.append(this.ws ? "后可领取奖励" : "");
            upVar2.j(z9, sb.toString(), z7 ? "跳过" : "", z8, z6);
            xt(m6);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public int p() {
        return xt(this.xt);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.xt
    protected boolean xq() {
        if (!this.ws) {
            return false;
        }
        if (hh.j(this.xt) == 2 && hh.xt(this.xt) == 3) {
            return false;
        }
        return (hh.j(this.xt) == 2 && hh.xt(this.xt) == 7) ? false : true;
    }

    public jy(TTBaseVideoActivity tTBaseVideoActivity, n nVar) {
        super(tTBaseVideoActivity, nVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public void av() {
        super.av();
        this.mi.xt(this.xt.xa());
        this.mi.up(true);
        this.f28366g.m(0);
        this.f28366g.up(0);
        this.f28369j.ol();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.xt
    public boolean e() {
        return q();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public void f() {
        super.f();
        nd();
    }
}
