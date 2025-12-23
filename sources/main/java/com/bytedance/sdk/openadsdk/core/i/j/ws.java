package com.bytedance.sdk.openadsdk.core.i.j;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.av.j;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ws extends com.bytedance.sdk.component.j.up<JSONObject, JSONObject> {
    public static void j(com.bytedance.sdk.component.j.i iVar) {
        iVar.j("getDownloadStatus", (com.bytedance.sdk.component.j.up<?, ?>) new ws());
    }

    @Override // com.bytedance.sdk.component.j.up
    public JSONObject j(JSONObject jSONObject, com.bytedance.sdk.component.j.m mVar) throws Exception {
        return j(jSONObject);
    }

    public static JSONObject j(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            j(jSONObject2, 1, "params is null", 1, 1);
            return jSONObject2;
        }
        try {
            String optString = jSONObject.optString("ad_down_load_id");
            if (TextUtils.isEmpty(optString)) {
                j(jSONObject2, 1, "ad_down_load_id is null", 1, 1);
                return jSONObject2;
            }
            return j.C0431j.j(optString);
        } catch (Throwable unused) {
            return jSONObject2;
        }
    }

    private static void j(JSONObject jSONObject, int i6, String str, int i7, int i8) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("code", i6);
            jSONObject.put("codeMsg", str);
            jSONObject.put("downloadStatus", i7);
            jSONObject.put("downloadProcessRate", i8);
        } catch (Exception unused) {
        }
    }
}
