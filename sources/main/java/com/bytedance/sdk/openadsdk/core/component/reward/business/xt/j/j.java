package com.bytedance.sdk.openadsdk.core.component.reward.business.xt.j;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.core.component.reward.cw.oq;
import com.bytedance.sdk.openadsdk.core.component.reward.cw.xt;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.qa;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class j extends com.bytedance.sdk.openadsdk.core.component.reward.cw.xt {

    /* renamed from: j, reason: collision with root package name */
    protected String f28138j;

    public j(Activity activity, n nVar) {
        super(activity, nVar);
    }

    public void j(String str) {
        this.f28138j = str;
    }

    public j(Activity activity, n nVar, qa qaVar) {
        super(activity, nVar, qaVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.xt
    public xt.j j(oq oqVar) {
        r rVar = new r(this.tl, this.ae);
        rVar.r(this.qv);
        rVar.cw(this.vl);
        rVar.xt(this.az);
        rVar.j(this.f28138j);
        return rVar.j(oqVar);
    }
}
