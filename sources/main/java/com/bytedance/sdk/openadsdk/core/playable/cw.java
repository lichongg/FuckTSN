package com.bytedance.sdk.openadsdk.core.playable;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.l.oq;

/* loaded from: D:\Downloads\app\classes4.dex */
class cw extends com.bytedance.sdk.openadsdk.core.video.xt.j {
    private boolean rn;

    @Override // com.bytedance.sdk.openadsdk.core.video.xt.j
    protected int v() {
        return 5;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.xt.j
    protected boolean v_() {
        return false;
    }

    public void ae(boolean z5) {
        this.rn = z5;
    }

    protected cw(Context context, ViewGroup viewGroup, n nVar, com.bytedance.sdk.openadsdk.core.xt.j jVar) {
        super(context, viewGroup, nVar, jVar);
        this.rn = true;
        j(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.xt.j
    protected void m(boolean z5) {
        super.m(z5);
        if (this.rn) {
            if (!oq.j(this.f30967m) || up()) {
                xt();
            }
        }
    }

    public void x() {
        b();
    }
}
