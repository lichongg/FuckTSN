package com.bytedance.sdk.openadsdk.core.tj;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class rn {

    /* renamed from: j, reason: collision with root package name */
    private boolean f30419j;
    private int xt;

    public void j(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("swipe_back_type", this.f30419j ? 1 : 0);
            jSONObject2.put("filter_track", this.xt);
        } catch (JSONException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
        try {
            jSONObject.put("landing_page_conf", jSONObject2);
        } catch (JSONException e7) {
            com.bytedance.sdk.component.utils.vl.j(e7);
        }
    }

    private static rn cw(n nVar) {
        if (nVar == null) {
            return null;
        }
        return nVar.uh();
    }

    public rn(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("landing_page_conf");
        if (optJSONObject != null) {
            this.f30419j = optJSONObject.optInt("swipe_back_type", 0) == 1;
            this.xt = optJSONObject.optInt("filter_track", 0);
        }
    }

    public static boolean xt(n nVar) {
        rn cw = cw(nVar);
        if (cw == null || cw.xt != 1) {
            return false;
        }
        return true;
    }

    public static boolean j(n nVar) {
        rn cw = cw(nVar);
        if (cw == null) {
            return false;
        }
        return cw.f30419j;
    }
}
