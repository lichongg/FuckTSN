package com.bytedance.sdk.openadsdk.core.component.reward.cw;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.core.component.reward.cw.xt;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.qa;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class vl extends j {
    @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.xt
    public int ae() {
        return 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.xt
    public String j() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("alert_title", "距离领取奖励还剩");
            jSONObject.put("number", this.f28167j);
            jSONObject.put("number_unit", "秒");
        } catch (JSONException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.xt
    protected float tl() {
        return 0.75f;
    }

    vl(Activity activity, n nVar, qa qaVar) {
        super(activity, nVar, qaVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.j, com.bytedance.sdk.openadsdk.core.component.reward.cw.xt
    public xt.j xt(oq oqVar) {
        return cw(oqVar);
    }
}
