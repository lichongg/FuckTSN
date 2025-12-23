package com.bytedance.sdk.openadsdk.core.component.reward.top;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.cw.oq;
import com.bytedance.sdk.openadsdk.core.component.reward.r.g;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.e;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.v;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m extends cw {
    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.cw, com.bytedance.sdk.openadsdk.core.component.reward.top.xt
    public void cw(View view) {
        super.cw(view);
        this.up.cw("video_player");
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.cw, com.bytedance.sdk.openadsdk.core.component.reward.top.xt
    public void xt(View view) {
        super.xt(view);
        if (this.up.e() instanceof g) {
            this.up.wq();
        }
        this.up.rn();
    }

    public m(TTBaseVideoActivity tTBaseVideoActivity, n nVar, com.bytedance.sdk.openadsdk.core.component.reward.xt.xt xtVar, com.bytedance.sdk.openadsdk.core.component.reward.xt.up upVar, boolean z5) {
        super(tTBaseVideoActivity, nVar, xtVar, upVar, z5);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.cw, com.bytedance.sdk.openadsdk.core.component.reward.top.xt
    public void j(View view) {
        super.j(view);
        if (j()) {
            return;
        }
        this.up.b().j();
        if (e.i(this.xt)) {
            xt();
        } else {
            cw();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.cw, com.bytedance.sdk.openadsdk.core.component.reward.top.xt
    public void m(View view) {
        super.m(view);
        this.up.onSkipBorderClick(view);
    }

    private void cw() {
        oq oqVar = new oq() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.m.2
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.oq
            public void xt() {
                m.this.up.xt();
            }
        };
        if (this.up.j(oqVar)) {
            return;
        }
        oqVar.xt();
    }

    private void xt() {
        oq oqVar = new oq() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.m.1
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.oq
            public void xt() {
                m.this.up.jy();
                m.this.up.uf().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.m.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        m.this.up.j();
                    }
                }, 100L);
            }
        };
        int i6 = 2;
        int up = this.up.up(2);
        if (this.xt.tz() == 7) {
            if (v.xt().ae(String.valueOf(uf.g(this.xt))) && !this.up.q()) {
                i6 = 1;
            }
            up = i6;
        }
        if (up == 1) {
            if (this.up.j(oqVar)) {
                return;
            }
            oqVar.xt();
            return;
        }
        this.up.xt();
    }
}
