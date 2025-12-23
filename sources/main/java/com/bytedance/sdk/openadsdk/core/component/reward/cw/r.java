package com.bytedance.sdk.openadsdk.core.component.reward.cw;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.component.reward.cw.xt;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.qa;
import com.umeng.analytics.pro.d;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r extends j {

    /* renamed from: i, reason: collision with root package name */
    private int f28173i;
    private String kt;
    private String mi;

    /* renamed from: w, reason: collision with root package name */
    private int f28174w;

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.xt
    public int ae() {
        return 6;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.xt
    public String j() {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("amount", this.f28173i);
            jSONObject.put("threshold", "满" + this.f28174w + "元可用");
            if (TextUtils.isEmpty(this.mi)) {
                if (TextUtils.isEmpty(this.kt)) {
                    str = "领取当日起30分钟内有效";
                } else {
                    str = "有效期至" + this.kt;
                }
            } else if (TextUtils.isEmpty(this.kt)) {
                str = "有效期至" + this.mi;
            } else {
                str = "有效期" + this.mi + "至" + this.kt;
            }
            jSONObject.put(d.f41197p, this.mi);
            jSONObject.put("expire_text", str);
        } catch (JSONException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.xt
    public boolean m() {
        return (this.f28173i == 0 || this.f28174w == 0) ? false : true;
    }

    r(Activity activity, n nVar, qa qaVar) {
        super(activity, nVar, qaVar);
        JSONObject optJSONObject;
        JSONObject xt = qaVar.xt();
        if (xt != null && (optJSONObject = xt.optJSONObject("coupon")) != null) {
            this.f28173i = optJSONObject.optInt("amount");
            this.f28174w = optJSONObject.optInt("threshold");
            this.mi = optJSONObject.optString(d.f41197p);
            this.kt = optJSONObject.optString("expire_time");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.xt
    protected float tl() {
        return 0.55f;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.j, com.bytedance.sdk.openadsdk.core.component.reward.cw.xt
    public xt.j xt(oq oqVar) {
        return cw(oqVar);
    }
}
