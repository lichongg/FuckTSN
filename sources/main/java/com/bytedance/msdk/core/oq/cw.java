package com.bytedance.msdk.core.oq;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class cw {
    private double ae;
    private String cw;

    /* renamed from: j, reason: collision with root package name */
    private String f24628j;

    /* renamed from: m, reason: collision with root package name */
    private double f24629m;

    /* renamed from: r, reason: collision with root package name */
    private int f24630r;
    private String up;
    private String xt;

    public String j() {
        return this.xt;
    }

    public static cw j(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || jSONObject == null) {
            return null;
        }
        return new cw(str, jSONObject.optString("label_name"), jSONObject.optString("timestamp"), jSONObject.optInt("label_id"), jSONObject.optString("label_version"), jSONObject.optDouble("upper_bound"), jSONObject.optDouble("lower_bound"));
    }

    public int cw() {
        return this.f24630r;
    }

    public double m() {
        return this.ae;
    }

    public String r() {
        return this.up;
    }

    public double up() {
        return this.f24629m;
    }

    public String xt() {
        return this.cw;
    }

    public cw(String str, String str2, String str3, int i6, String str4, double d6, double d7) {
        this.f24628j = str;
        this.xt = str2;
        this.cw = str3;
        this.f24630r = i6;
        this.up = str4;
        this.f24629m = d6;
        this.ae = d7;
    }
}
