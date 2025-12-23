package com.bytedance.sdk.openadsdk.core.xt;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.qv;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class up extends j {
    protected abstract void xt(View view, qv qvVar);

    @Override // com.bytedance.sdk.openadsdk.core.xt.xt, com.bytedance.sdk.openadsdk.core.xt.r
    public void j(View view, qv qvVar) {
        if (n.up(this.f31364j)) {
            return;
        }
        super.j(view, qvVar);
        com.bytedance.sdk.openadsdk.core.xt.j.xt xtVar = (com.bytedance.sdk.openadsdk.core.xt.j.xt) this.tl.j(com.bytedance.sdk.openadsdk.core.xt.j.xt.class);
        if (xtVar == null || !xtVar.xt(view)) {
            return;
        }
        xt(view, qvVar);
    }

    public up(Context context, n nVar, String str, int i6) {
        super(context, nVar, str, i6);
    }
}
