package com.bytedance.sdk.openadsdk.core.qv;

import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw {

    /* renamed from: j, reason: collision with root package name */
    private JSONObject f29880j;

    public int ae() {
        JSONObject jSONObject = this.f29880j;
        if (jSONObject == null) {
            return 1;
        }
        return jSONObject.optInt("max_interface", 1);
    }

    public boolean cw() {
        JSONObject jSONObject = this.f29880j;
        return jSONObject != null && jSONObject.optInt("enable_install_interface", 0) == 1;
    }

    public boolean j() {
        JSONObject jSONObject = this.f29880j;
        return jSONObject == null || jSONObject.optInt("enable_install_notification", 1) == 1;
    }

    public int m() {
        JSONObject jSONObject = this.f29880j;
        if (jSONObject == null) {
            return 1;
        }
        return jSONObject.optInt("max_notification", 1);
    }

    public long r() {
        JSONObject jSONObject = this.f29880j;
        if (jSONObject == null) {
            return 300L;
        }
        return jSONObject.optLong("uninstall_delay", 300L);
    }

    public long up() {
        JSONObject jSONObject = this.f29880j;
        if (jSONObject == null) {
            return 1800L;
        }
        return jSONObject.optLong("notification_internal", 1800L);
    }

    public boolean xt() {
        JSONObject jSONObject = this.f29880j;
        return jSONObject == null || jSONObject.optInt("enable_active_notification", 1) == 1;
    }

    public cw(JSONObject jSONObject) {
        this.f29880j = jSONObject;
    }
}
