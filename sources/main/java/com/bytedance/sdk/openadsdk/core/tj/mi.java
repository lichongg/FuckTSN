package com.bytedance.sdk.openadsdk.core.tj;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class mi {
    private static int cw;

    /* renamed from: j, reason: collision with root package name */
    private static int f30332j;

    /* renamed from: r, reason: collision with root package name */
    private static JSONObject f30333r;
    private static int xt;

    public static boolean j() {
        return f30332j == 1;
    }

    public static boolean xt() {
        return xt == 1;
    }

    public static boolean cw() {
        return cw == 1;
    }

    public static void j(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("app_common_config")) == null) {
            return;
        }
        xt(optJSONObject.optJSONObject("dex_strategy"));
    }

    private static void xt(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        f30332j = jSONObject.optInt("use_dex_load_gdt");
        xt = jSONObject.optInt("use_dex_load_ks");
        cw = jSONObject.optInt("use_dex_load_xiaomi");
        f30333r = jSONObject;
    }

    public static void j(com.bytedance.sdk.component.r.j.xt xtVar) {
        JSONObject jSONObject;
        if (xtVar == null || (jSONObject = f30333r) == null) {
            return;
        }
        xtVar.j("dex_strategy", jSONObject.toString());
    }

    public static void xt(com.bytedance.sdk.component.r.j.xt xtVar) {
        if (xtVar != null) {
            try {
                xt(new JSONObject(xtVar.xt("dex_strategy", "")));
            } catch (JSONException unused) {
            }
        }
    }
}
