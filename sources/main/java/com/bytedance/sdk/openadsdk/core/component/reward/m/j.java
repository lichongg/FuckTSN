package com.bytedance.sdk.openadsdk.core.component.reward.m;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.tj.n;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j extends com.bytedance.sdk.openadsdk.core.video.xt.j {
    @Override // com.bytedance.sdk.openadsdk.core.video.xt.j
    protected int v() {
        return 2;
    }

    public j(Context context, ViewGroup viewGroup, n nVar, com.bytedance.sdk.openadsdk.core.xt.j jVar) {
        super(context, viewGroup, nVar, jVar);
        j(false);
    }

    public boolean x() {
        if (i() != null && i().ws()) {
            return true;
        }
        return false;
    }
}
