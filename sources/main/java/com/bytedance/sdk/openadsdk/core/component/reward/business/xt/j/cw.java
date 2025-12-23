package com.bytedance.sdk.openadsdk.core.component.reward.business.xt.j;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.component.reward.cw.oq;
import com.bytedance.sdk.openadsdk.core.component.reward.cw.xt;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.qa;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw extends j {
    @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.xt
    public int ae() {
        return 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.xt.j.j, com.bytedance.sdk.openadsdk.core.component.reward.cw.xt
    public xt.j j(oq oqVar) {
        return cw(oqVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.xt
    public String j() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(MediationConstant.REWARD_NAME, this.qv);
            jSONObject.put(MediationConstant.REWARD_AMOUNT, this.vl);
            jSONObject.put("extra_info", this.f28138j);
        } catch (JSONException e6) {
            vl.j(e6);
        }
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.xt
    public boolean m() {
        return (TextUtils.isEmpty(this.qv) || TextUtils.isEmpty(this.vl)) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.xt
    protected float tl() {
        return 0.75f;
    }

    public cw(Activity activity, n nVar, qa qaVar) {
        super(activity, nVar, qaVar);
    }
}
