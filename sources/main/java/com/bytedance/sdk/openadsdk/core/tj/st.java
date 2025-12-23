package com.bytedance.sdk.openadsdk.core.tj;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class st {
    private String cw;

    /* renamed from: j, reason: collision with root package name */
    private String f30440j;

    /* renamed from: m, reason: collision with root package name */
    private String f30441m;

    /* renamed from: r, reason: collision with root package name */
    private String f30442r;
    private String up;
    private String xt;

    public void j(String str, String str2, String str3, String str4) {
        this.f30440j = str3;
        this.xt = str2;
        this.f30442r = str;
        this.cw = str4;
    }

    public String xt() {
        return this.f30440j;
    }

    public JSONObject cw() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tk", this.f30440j).put("vd", this.f30442r).put("cr", this.cw).put(NotificationCompat.CATEGORY_ERROR, this.xt);
            if (!TextUtils.isEmpty(this.cw) && this.cw.equals("2")) {
                if (!TextUtils.isEmpty(this.up)) {
                    jSONObject.put("i6", this.up);
                }
                if (!TextUtils.isEmpty(this.f30441m)) {
                    jSONObject.put("prov", this.f30441m);
                }
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public void xt(String str) {
        this.f30441m = str;
    }

    public st(String str, String str2, String str3, String str4) {
        this.f30440j = str3;
        this.xt = str2;
        this.f30442r = str;
        this.cw = str4;
    }

    public String toString() {
        JSONObject cw = cw();
        if (cw.length() > 0) {
            return cw.toString();
        }
        return "";
    }

    public String j() {
        return this.xt;
    }

    public void j(String str) {
        this.up = str;
    }
}
