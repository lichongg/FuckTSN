package com.bytedance.msdk.core.oq;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j {
    private com.bytedance.msdk.api.r.j.xt.cw.xt cw;

    /* renamed from: j, reason: collision with root package name */
    private String f24634j;
    private String xt;

    public j(String str, String str2) {
        this.f24634j = str;
        this.xt = str2;
        this.cw = new com.bytedance.msdk.api.r.j.xt.cw.xt();
    }

    public String j() {
        return this.f24634j;
    }

    public static j j(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("app_id");
        String optString2 = jSONObject.optString("app_key");
        String optString3 = jSONObject.optString("custom_type");
        return !TextUtils.equals(optString3, "1") ? new j(optString, optString2) : new j(str, optString, optString2, jSONObject.optString("init_class_name"), jSONObject.optString("banner_class_name"), jSONObject.optString("interstitial_class_name"), jSONObject.optString("reward_class_name"), jSONObject.optString("full_video_class_name"), jSONObject.optString("splash_class_name"), jSONObject.optString("feed_class_name"), jSONObject.optString("draw_class_name"), optString3);
    }

    public com.bytedance.msdk.api.r.j.xt.cw.xt cw() {
        return this.cw;
    }

    public boolean r() {
        com.bytedance.msdk.api.r.j.xt.cw.xt xtVar = this.cw;
        return xtVar != null && xtVar.r();
    }

    public String toString() {
        return "AdNetworkConfValue{mAppId='" + this.f24634j + "', mAppKey='" + this.xt + "', mGMCustomConfig=" + this.cw + '}';
    }

    public String up() {
        com.bytedance.msdk.api.r.j.xt.cw.xt xtVar = this.cw;
        if (xtVar != null) {
            return xtVar.xt();
        }
        return null;
    }

    public String xt() {
        return this.xt;
    }

    public j(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        this.f24634j = str2;
        this.xt = str3;
        this.cw = new com.bytedance.msdk.api.r.j.xt.cw.xt(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12);
    }
}
