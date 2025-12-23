package com.bytedance.sdk.openadsdk.core.p;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m {

    /* renamed from: j, reason: collision with root package name */
    public boolean f29801j = false;
    public boolean xt = true;

    public static m j(String str) {
        m mVar = new m();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                mVar.f29801j = jSONObject.optBoolean("encrypt", false);
                mVar.xt = jSONObject.optBoolean("wait_io", true);
            } catch (Throwable unused) {
            }
        }
        return mVar;
    }

    @NonNull
    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("encrypt", this.f29801j);
            jSONObject.put("wait_io", this.xt);
            return jSONObject.toString();
        } catch (Throwable unused) {
            return "";
        }
    }
}
