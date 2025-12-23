package com.bytedance.sdk.openadsdk.core.component.reward.cw;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.component.reward.cw.xt;
import com.bytedance.sdk.openadsdk.core.tj.e;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.qa;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class qv extends j {
    @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.xt
    public int ae() {
        return 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.xt
    public String j() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("alert_title", "继续观看 " + this.f28167j + "s 可获得奖励");
            jSONObject.put("number", this.vl);
            jSONObject.put("number_unit", this.qv);
            jSONObject.put("remain_time", this.f28167j);
        } catch (JSONException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.xt
    public boolean m() {
        if (e.cw(this.ae)) {
            return (Integer.parseInt(this.vl) == 0 || TextUtils.isEmpty(this.vl) || TextUtils.isEmpty(this.qv)) ? false : true;
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.xt
    protected float tl() {
        return 0.75f;
    }

    qv(Activity activity, n nVar, qa qaVar) {
        super(activity, nVar, qaVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.j, com.bytedance.sdk.openadsdk.core.component.reward.cw.xt
    public xt.j xt(oq oqVar) {
        return cw(oqVar);
    }
}
