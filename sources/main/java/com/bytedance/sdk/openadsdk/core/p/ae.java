package com.bytedance.sdk.openadsdk.core.p;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ae {

    /* renamed from: j, reason: collision with root package name */
    public boolean f29783j = false;
    public boolean xt = false;
    public boolean cw = false;

    /* renamed from: r, reason: collision with root package name */
    public boolean f29784r = false;
    private boolean up = false;

    public static ae j(String str) {
        ae aeVar = new ae();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                aeVar.f29783j = jSONObject.optBoolean("use_csj_main", false);
                aeVar.xt = jSONObject.optBoolean("use_layze_layout", false);
                aeVar.cw = jSONObject.optBoolean("create_ad_in_io", false);
                aeVar.f29784r = jSONObject.optBoolean("opt_panel_view", false);
                boolean optBoolean = jSONObject.optBoolean("so_lock", false);
                aeVar.up = optBoolean;
                if (optBoolean) {
                    com.bytedance.sdk.openadsdk.l.m.j().mkdirs();
                }
            } catch (Throwable unused) {
            }
        }
        return aeVar;
    }

    @NonNull
    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("use_csj_main", this.f29783j);
            jSONObject.put("use_layze_layout", this.xt);
            jSONObject.put("create_ad_in_io", this.cw);
            jSONObject.put("opt_panel_view", this.f29784r);
            jSONObject.put("so_lock", this.up);
            return jSONObject.toString();
        } catch (Throwable unused) {
            return "";
        }
    }
}
