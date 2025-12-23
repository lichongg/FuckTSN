package com.bytedance.msdk.core.oq;

import com.bytedance.sdk.component.utils.vl;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class r {
    private JSONObject ae;
    private int cw;

    /* renamed from: j, reason: collision with root package name */
    private double f24647j;

    /* renamed from: m, reason: collision with root package name */
    private String f24648m;

    /* renamed from: r, reason: collision with root package name */
    private String f24649r;
    private int up;
    private double xt;

    public static void j(JSONObject jSONObject, Map<String, r> map) {
        JSONArray optJSONArray;
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("prime_rits")) == null) {
            return;
        }
        for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
            try {
                String optString = optJSONArray.optString(i6);
                try {
                    map.put(optString, new r(jSONObject.optDouble("upper", 0.0d), jSONObject.optDouble("lower", 0.0d), jSONObject.optInt("type"), optString, jSONObject.optInt("js_mode"), jSONObject.optString("rule_id"), jSONObject.optJSONObject("refresh_time")));
                } catch (Exception e6) {
                    e = e6;
                    vl.j(e);
                }
            } catch (Exception e7) {
                e = e7;
            }
        }
    }

    public int cw() {
        return this.up;
    }

    public int getType() {
        return this.cw;
    }

    public String r() {
        return this.f24648m;
    }

    public boolean up() {
        return this.f24647j <= 0.0d && this.xt <= 0.0d;
    }

    public double xt() {
        return this.xt;
    }

    private r(double d6, double d7, int i6, String str, int i7, String str2, JSONObject jSONObject) {
        this.f24647j = d6;
        this.xt = d7;
        this.cw = i6;
        this.f24649r = str;
        this.up = i7;
        this.f24648m = str2;
        this.ae = jSONObject;
    }

    public double j() {
        return this.f24647j;
    }

    public int j(String str) {
        JSONObject jSONObject = this.ae;
        if (jSONObject != null) {
            return jSONObject.optInt(str);
        }
        return 0;
    }
}
