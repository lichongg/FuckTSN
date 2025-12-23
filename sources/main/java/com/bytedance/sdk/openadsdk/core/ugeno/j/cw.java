package com.bytedance.sdk.openadsdk.core.ugeno.j;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.ugeno.express.r;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw extends r {
    private JSONObject ws() {
        try {
            return new JSONObject(j.j(this.f30705m, this.ae).j(this.f30705m));
        } catch (Throwable th) {
            vl.j(th);
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.express.r, com.bytedance.sdk.component.adexpress.xt.r
    public int cw() {
        return 8;
    }

    public cw(Context context, n nVar, com.bytedance.sdk.openadsdk.core.ugeno.express.xt xtVar, ViewGroup viewGroup) {
        super(context, nVar, xtVar, viewGroup);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.express.r
    protected JSONObject j() {
        return ws();
    }
}
