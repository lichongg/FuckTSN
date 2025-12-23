package com.bytedance.sdk.openadsdk.core.component.reward.cw;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.component.reward.cw.xt;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.qa;
import com.bytedance.sdk.openadsdk.core.tj.s;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class g extends j {

    /* renamed from: i, reason: collision with root package name */
    private String f28166i;

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.xt
    public int ae() {
        return 5;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.xt
    public String j() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("red_pack_amount", this.f28166i);
            boolean z5 = false;
            try {
                if (Double.parseDouble(this.f28166i) != 0.0d) {
                    z5 = true;
                }
            } catch (NumberFormatException unused) {
            }
            jSONObject.put("is_display_unit", z5);
        } catch (JSONException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.xt
    public boolean m() {
        String str = this.f28166i;
        return (str == null || str.equals("0") || TextUtils.isEmpty(this.f28166i)) ? false : true;
    }

    g(Activity activity, n nVar, qa qaVar) {
        super(activity, nVar, qaVar);
        s mc = this.ae.mc();
        if (mc != null) {
            this.f28166i = mc.j();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.xt
    protected float tl() {
        return 0.6f;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.j, com.bytedance.sdk.openadsdk.core.component.reward.cw.xt
    public xt.j xt(oq oqVar) {
        return cw(oqVar);
    }
}
