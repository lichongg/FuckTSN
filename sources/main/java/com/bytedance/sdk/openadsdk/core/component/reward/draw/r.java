package com.bytedance.sdk.openadsdk.core.component.reward.draw;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.tj.n;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r extends com.bytedance.sdk.openadsdk.core.component.reward.m.xt {
    private boolean rn;

    public r(Context context, ViewGroup viewGroup, n nVar) {
        super(context, viewGroup, nVar, null);
        j(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.xt.j, com.bykv.vk.openvk.component.video.api.r.cw
    public void oq() {
        this.rn = false;
        super.oq();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.m.xt, com.bytedance.sdk.openadsdk.core.video.xt.j
    protected int v() {
        return 4;
    }

    public void ae(boolean z5) {
        this.rn = z5;
    }

    public boolean ch() {
        return this.rn;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.m.xt, com.bytedance.sdk.openadsdk.core.video.xt.j, com.bykv.vk.openvk.component.video.api.r.cw
    public void tl() {
        if (this.rn) {
            return;
        }
        super.tl();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.xt.j
    protected void m(boolean z5) {
        super.m(z5);
        xt();
    }

    public boolean x() {
        if (i() != null && i().ws()) {
            return true;
        }
        return false;
    }
}
