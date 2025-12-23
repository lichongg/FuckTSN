package com.bytedance.sdk.openadsdk.core.qv.cw;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.qv.xt.r;
import com.bytedance.sdk.openadsdk.core.tj.n;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j extends xt implements com.bytedance.sdk.openadsdk.core.qv.xt.r {
    private r.j ch;

    @Override // com.bytedance.sdk.openadsdk.core.qv.xt.r
    public void j(r.j jVar) {
        this.ch = jVar;
    }

    public j(Context context, n nVar, String str, boolean z5) {
        super(context, nVar, str, z5);
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.cw.up, com.bytedance.sdk.openadsdk.core.qv.xt.cw
    public void xt() {
        super.xt();
        this.ch = null;
    }
}
