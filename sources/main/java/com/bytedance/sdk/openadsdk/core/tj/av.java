package com.bytedance.sdk.openadsdk.core.tj;

import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class av {
    public double cw;

    /* renamed from: j, reason: collision with root package name */
    public double f30221j;

    /* renamed from: r, reason: collision with root package name */
    public double f30222r;
    public double xt;

    public boolean j(double d6, double d7) {
        double d8 = this.cw;
        if (d8 <= 0.0d) {
            return false;
        }
        double d9 = this.f30222r;
        if (d9 <= 0.0d) {
            return false;
        }
        double d10 = this.f30221j;
        if (d6 <= d10 || d6 >= d10 + d8) {
            return false;
        }
        double d11 = this.xt;
        return d7 > d11 && d7 < d11 + d9;
    }

    public static av j(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("point");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("size");
        if (optJSONArray == null || optJSONArray.length() != 2 || optJSONArray2 == null || optJSONArray2.length() != 2) {
            return null;
        }
        return new av(optJSONArray.optDouble(0), optJSONArray.optDouble(1), optJSONArray2.optInt(0), optJSONArray2.optInt(1));
    }

    public static av xt(av avVar, av avVar2) {
        if (avVar == null) {
            return avVar2;
        }
        if (avVar2 == null) {
            return null;
        }
        double d6 = avVar.f30221j;
        double d7 = avVar.xt;
        double d8 = avVar.cw + d6;
        double d9 = avVar.f30222r + d7;
        double d10 = avVar2.f30221j;
        double d11 = avVar2.xt;
        double d12 = avVar2.cw + d10;
        double d13 = avVar2.f30222r + d11;
        double min = Math.min(d6, d10);
        double min2 = Math.min(d7, d11);
        return new av(min, min2, Math.abs(Math.max(d8, d12) - min), Math.abs(Math.max(d9, d13) - min2));
    }

    public av(double d6, double d7, double d8, double d9) {
        this.f30221j = d6;
        this.xt = d7;
        this.cw = d8;
        this.f30222r = d9;
    }

    public static JSONObject j(av avVar) {
        if (avVar == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(0, avVar.f30221j);
            jSONArray.put(1, avVar.xt);
            jSONObject.put("point", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(0, avVar.cw);
            jSONArray2.put(1, avVar.f30222r);
            jSONObject.put("size", jSONArray2);
            return jSONObject;
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.j("xeasy", "json:" + e6.getMessage());
            return null;
        }
    }

    public static double j(av avVar, av avVar2) {
        if (avVar == null || avVar2 == null) {
            return 0.0d;
        }
        double d6 = avVar.f30221j;
        double d7 = avVar.xt;
        double d8 = avVar.cw + d6;
        double d9 = avVar.f30222r + d7;
        double d10 = avVar2.f30221j;
        double d11 = avVar2.xt;
        double d12 = avVar2.cw + d10;
        double d13 = avVar2.f30222r + d11;
        double max = Math.max(d6, d10);
        double max2 = Math.max(d7, d11);
        double min = (Math.min(d8, d12) - max) * (Math.min(d9, d13) - max2);
        if (d7 >= d13 || d8 <= d10 || d9 <= d11 || d6 >= d12) {
            return 0.0d;
        }
        return min;
    }
}
