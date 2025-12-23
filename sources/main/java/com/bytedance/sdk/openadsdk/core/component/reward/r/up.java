package com.bytedance.sdk.openadsdk.core.component.reward.r;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.tj.e;
import com.bytedance.sdk.openadsdk.core.tj.n;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up extends j {
    public static int xt(n nVar) {
        return 3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.xt
    public boolean e() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public com.bytedance.sdk.openadsdk.core.component.reward.layout.xt j(boolean z5) {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.m mVar = new com.bytedance.sdk.openadsdk.core.component.reward.layout.m(this.f28369j, this.xt, z5);
        this.f28366g = mVar;
        return mVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.xt
    public boolean q() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.xt
    protected boolean sm() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.xt
    protected boolean xq() {
        return true;
    }

    public static boolean j(n nVar) {
        return (nVar == null || n.xt(nVar)) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.xt
    public void ff() {
        this.f28366g.up(8);
        this.f28366g.m(8);
        this.mi.up(com.bytedance.sdk.openadsdk.l.oq.j(this.xt));
        this.mi.xt(this.xt.xa());
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public View g() {
        if (this.cw == 2) {
            int ve = this.xt.ve();
            return ve != 3 ? ve != 33 ? com.bytedance.sdk.openadsdk.res.up.w(this.f28369j) : com.bytedance.sdk.openadsdk.res.up.i(this.f28369j) : com.bytedance.sdk.openadsdk.res.up.av(this.f28369j);
        }
        int ve2 = this.xt.ve();
        return ve2 != 3 ? ve2 != 33 ? com.bytedance.sdk.openadsdk.res.up.tj(this.f28369j) : com.bytedance.sdk.openadsdk.res.up.kt(this.f28369j) : com.bytedance.sdk.openadsdk.res.up.mi(this.f28369j);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public int p() {
        return xt(this.xt);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.xt
    public boolean qb() {
        if (this.oq.m()) {
            return this.oq.oq();
        }
        return true;
    }

    public up(TTBaseVideoActivity tTBaseVideoActivity, n nVar) {
        super(tTBaseVideoActivity, nVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.xt
    protected void k() {
        boolean z5;
        super.k();
        if (e.i(this.xt)) {
            this.f28369j.cw(0);
            int ch = ch();
            String str = "";
            if (ch <= n() && !this.av) {
                int m6 = m(true);
                int m7 = m(false);
                com.bytedance.sdk.openadsdk.core.tl.r.f30512j = m6;
                if (ch <= this.gq.up() && !this.f28369j.z()) {
                    z5 = false;
                } else {
                    z5 = true;
                }
                com.bytedance.sdk.openadsdk.core.component.reward.xt.up upVar = this.mi;
                boolean z6 = this.ws;
                StringBuilder sb = new StringBuilder();
                sb.append(m7);
                sb.append("s");
                if (this.ws) {
                    str = "后可领取奖励";
                }
                sb.append(str);
                upVar.j(z6, sb.toString(), null, z5, z5);
                xt(m6);
                if (this.oq != null && v() == 7) {
                    this.oq.j((CharSequence) String.valueOf(m7), ch, 0, false);
                    return;
                }
                return;
            }
            com.bytedance.sdk.openadsdk.core.tl.r.f30512j = 0;
            String str2 = "";
            com.bytedance.sdk.openadsdk.core.component.reward.xt.up upVar2 = this.mi;
            boolean z7 = this.ws;
            if (z7) {
                str2 = "领取成功";
            }
            upVar2.j(z7, str2, null, true, true);
            this.f28369j.hh();
            if (this.oq != null && v() == 7) {
                this.oq.j((CharSequence) "0", ch, 0, false);
            }
        }
    }
}
