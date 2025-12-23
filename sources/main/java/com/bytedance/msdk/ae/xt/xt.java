package com.bytedance.msdk.ae.xt;

import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt {

    /* renamed from: j, reason: collision with root package name */
    private static volatile xt f24325j;

    public static xt j() {
        if (f24325j == null) {
            synchronized (xt.class) {
                try {
                    if (f24325j == null) {
                        f24325j = new xt();
                    }
                } finally {
                }
            }
        }
        return f24325j;
    }

    private xt() {
    }

    public void j(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.api.plugin.xt.xt(com.bytedance.msdk.core.xt.getContext(), "tt_sdk_test_tool_data_" + com.bytedance.msdk.core.j.qv().vl(), 0).edit().putString("rit_conf", jSONArray.toString()).apply();
    }

    public void j(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.api.plugin.xt.xt(com.bytedance.msdk.core.xt.getContext(), "tt_sdk_test_tool_data_" + com.bytedance.msdk.core.j.qv().vl(), 0).edit().putString("adn_init_conf", jSONObject.toString()).apply();
    }
}
