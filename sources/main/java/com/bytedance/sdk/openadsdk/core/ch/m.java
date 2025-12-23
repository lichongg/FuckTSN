package com.bytedance.sdk.openadsdk.core.ch;

import androidx.annotation.NonNull;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m {

    /* renamed from: j, reason: collision with root package name */
    private JSONObject f28015j;

    public int j() {
        JSONObject jSONObject = this.f28015j;
        if (jSONObject != null) {
            return jSONObject.optInt("code", -1);
        }
        return -1;
    }

    @NonNull
    public String toString() {
        JSONObject jSONObject = this.f28015j;
        return jSONObject != null ? jSONObject.toString() : "pitaya error is null";
    }

    public m(JSONObject jSONObject) {
        this.f28015j = jSONObject;
    }
}
