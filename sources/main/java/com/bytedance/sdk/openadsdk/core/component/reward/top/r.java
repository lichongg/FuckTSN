package com.bytedance.sdk.openadsdk.core.component.reward.top;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.cw.oq;
import com.bytedance.sdk.openadsdk.core.tj.e;
import com.bytedance.sdk.openadsdk.core.tj.n;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r extends cw {
    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.cw, com.bytedance.sdk.openadsdk.core.component.reward.top.xt
    public void cw(View view) {
        super.cw(view);
        this.up.cw(this.cw.uf());
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.cw, com.bytedance.sdk.openadsdk.core.component.reward.top.xt
    public void xt(View view) {
        super.xt(view);
        this.up.wq();
    }

    public r(TTBaseVideoActivity tTBaseVideoActivity, n nVar, com.bytedance.sdk.openadsdk.core.component.reward.xt.xt xtVar, com.bytedance.sdk.openadsdk.core.component.reward.xt.up upVar, boolean z5) {
        super(tTBaseVideoActivity, nVar, xtVar, upVar, z5);
    }

    private void xt() {
        oq oqVar = new oq() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.r.1
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.oq
            public void xt() {
                r.this.up.j();
            }
        };
        if (this.up.j(oqVar)) {
            this.f28422m--;
        } else {
            oqVar.xt();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.cw, com.bytedance.sdk.openadsdk.core.component.reward.top.xt
    public void j(View view) {
        super.j(view);
        if (j()) {
            return;
        }
        this.up.b().xt();
        if (this.cw.c()) {
            this.up.j();
        } else if (e.i(this.xt)) {
            xt();
        } else {
            cw();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.cw, com.bytedance.sdk.openadsdk.core.component.reward.top.xt
    public void m(View view) {
        super.m(view);
        j();
    }

    private void cw() {
        this.up.j();
    }
}
