package com.bytedance.sdk.openadsdk.core.tj;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class wq {

    /* renamed from: j, reason: collision with root package name */
    public JSONObject f30471j;

    public String j() {
        JSONObject jSONObject = this.f30471j;
        JSONObject optJSONObject = jSONObject == null ? null : jSONObject.optJSONObject("performance_js");
        return optJSONObject != null ? optJSONObject.optString("url") : "";
    }

    public String toString() {
        JSONObject jSONObject = this.f30471j;
        return jSONObject == null ? "" : jSONObject.toString();
    }

    public static wq j(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return j(new JSONObject(str));
        } catch (JSONException unused) {
            return null;
        }
    }

    public static wq j(JSONObject jSONObject) {
        wq wqVar = new wq();
        wqVar.f30471j = jSONObject;
        return wqVar;
    }
}
