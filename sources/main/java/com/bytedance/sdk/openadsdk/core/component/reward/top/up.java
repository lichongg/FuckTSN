package com.bytedance.sdk.openadsdk.core.component.reward.top;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.tj.kt;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.ugeno.oq;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up extends cw {
    public up(TTBaseVideoActivity tTBaseVideoActivity, n nVar, com.bytedance.sdk.openadsdk.core.component.reward.xt.xt xtVar, com.bytedance.sdk.openadsdk.core.component.reward.xt.up upVar, boolean z5) {
        super(tTBaseVideoActivity, nVar, xtVar, upVar, z5);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.cw, com.bytedance.sdk.openadsdk.core.component.reward.top.xt
    public void cw(View view) {
        super.cw(view);
        this.up.cw("playable");
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.cw, com.bytedance.sdk.openadsdk.core.component.reward.top.xt
    public void j(View view) {
        super.j(view);
        if (j()) {
            return;
        }
        this.up.b().j();
        if (!kt.qv(this.xt) && !oq.up(this.xt) && !oq.r(this.xt)) {
            com.bytedance.sdk.openadsdk.core.component.reward.cw.oq oqVar = new com.bytedance.sdk.openadsdk.core.component.reward.cw.oq() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.up.1
                @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.oq
                public void xt() {
                    up.this.up.jy();
                    up.this.up.j();
                }
            };
            if (this.up.j(oqVar)) {
                this.f28422m--;
                return;
            } else {
                oqVar.xt();
                return;
            }
        }
        this.up.g();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.cw, com.bytedance.sdk.openadsdk.core.component.reward.top.xt
    public void m(View view) {
        super.m(view);
        if (!oq.up(this.xt) && !oq.r(this.xt)) {
            j();
        } else {
            this.up.g();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.cw, com.bytedance.sdk.openadsdk.core.component.reward.top.xt
    public void xt(View view) {
        super.xt(view);
        if (kt.r(this.xt)) {
            this.up.rn();
        } else {
            this.up.wq();
        }
    }
}
