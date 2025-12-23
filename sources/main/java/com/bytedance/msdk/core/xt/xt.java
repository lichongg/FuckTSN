package com.bytedance.msdk.core.xt;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.msdk.tl.tj;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt {

    /* renamed from: j, reason: collision with root package name */
    private int f24830j;
    private final Map<String, Float> xt = new ConcurrentHashMap();
    private final Map<String, r> cw = new ConcurrentHashMap();

    public String cw(String str) {
        r xt;
        if (str == null || (xt = xt(str)) == null) {
            return null;
        }
        return xt.j();
    }

    public JSONObject j(String str, @NonNull tj tjVar) {
        up upVar;
        if (!com.bytedance.msdk.core.xt.xt().ed() || str == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            return jSONObject;
        }
        float j6 = j(str);
        r rVar = this.cw.get(str);
        if (rVar != null) {
            Map<String, up> up = rVar.up();
            String[] cw = rVar.cw();
            if (up != null && !up.isEmpty() && cw != null && cw.length > 0) {
                for (String str2 : cw) {
                    if (!TextUtils.isEmpty(str2) && (upVar = up.get(str2)) != null) {
                        try {
                            jSONObject.putOpt(str2, Integer.valueOf(upVar.j(j6)));
                        } catch (Exception e6) {
                            com.bytedance.msdk.j.up.cw.r("", "calculateRangeByScore计算异常：(tableName：" + str2 + ",primeRit:" + str + "），" + e6.getMessage());
                        }
                    }
                }
            }
        }
        tjVar.put(MediationConstant.KEY_GM_POLICY, jSONObject);
        tjVar.put("adl_scr", Float.valueOf(j6));
        com.bytedance.msdk.core.j.qv().j(str, j6);
        return jSONObject;
    }

    public r xt(String str) {
        return this.cw.get(str);
    }

    public xt(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject != null) {
            this.f24830j = jSONObject.optInt("lt_days");
            JSONObject optJSONObject = jSONObject.optJSONObject("estimate");
            if (optJSONObject != null && optJSONObject.length() > 0) {
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    this.xt.put(next, Float.valueOf((float) optJSONObject.optDouble(next)));
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("rule_excs");
            if (optJSONObject2 != null && optJSONObject2.length() != 0) {
                Iterator<String> keys2 = optJSONObject2.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    JSONObject optJSONObject3 = optJSONObject2.optJSONObject(next2);
                    if (optJSONObject3 != null && (optJSONArray = optJSONObject3.optJSONArray("prime_rits")) != null && optJSONArray.length() > 0) {
                        for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                            String optString = optJSONArray.optString(i6);
                            this.cw.put(optString, new r(next2, optString, optJSONObject3));
                        }
                    }
                }
            }
        }
    }

    public float j(String str) {
        r rVar = this.cw.get(str);
        float f6 = -1.0f;
        if (rVar != null) {
            Map<String, Float> xt = rVar.xt();
            String r5 = rVar.r();
            if (xt != null) {
                if (xt.containsKey("lt_x_times")) {
                    Float f7 = xt.get("lt_x_times");
                    int xt2 = j.xt();
                    if (f7 != null) {
                        f6 = j(r5, f7.floatValue() * xt2, -1.0f);
                    }
                }
                if (xt.containsKey("active_duration")) {
                    Float f8 = xt.get("active_duration");
                    long m6 = j.m();
                    if (f8 != null) {
                        f6 = j(r5, f8.floatValue() * m6, f6);
                    }
                }
                if (xt.containsKey("active_count")) {
                    Float f9 = xt.get("active_count");
                    int r6 = j.r();
                    if (f9 != null) {
                        f6 = j(r5, f9.floatValue() * r6, f6);
                    }
                }
                if (xt.containsKey("show_period")) {
                    Float f10 = xt.get("show_period");
                    long tl = j.tl(str);
                    if (f10 != null) {
                        f6 = j(r5, f10.floatValue() * tl, f6);
                    }
                }
                if (xt.containsKey("show_count")) {
                    Float f11 = xt.get("show_count");
                    int r7 = j.r(str);
                    if (f11 != null) {
                        f6 = j(r5, f11.floatValue() * r7, f6);
                    }
                }
                if (xt.containsKey("dislike_count")) {
                    Float f12 = xt.get("dislike_count");
                    int xt3 = j.xt(str);
                    if (f12 != null) {
                        f6 = j(r5, f12.floatValue() * xt3, f6);
                    }
                }
                if (xt.containsKey("click_count")) {
                    Float f13 = xt.get("click_count");
                    int m7 = j.m(str);
                    if (f13 != null) {
                        f6 = j(r5, f13.floatValue() * m7, f6);
                    }
                }
                if (xt.containsKey("install_days")) {
                    Float f14 = xt.get("install_days");
                    int up = j.up();
                    if (f14 != null) {
                        f6 = j(r5, f14.floatValue() * up, f6);
                    }
                }
                if (!this.xt.isEmpty()) {
                    for (Map.Entry<String, Float> entry : this.xt.entrySet()) {
                        if (entry != null) {
                            String key = entry.getKey();
                            float floatValue = entry.getValue().floatValue();
                            Float f15 = xt.get(key);
                            if (f15 != null) {
                                f6 = j(r5, f15.floatValue() * floatValue, f6);
                            }
                        }
                    }
                }
            }
        }
        return f6;
    }

    private float j(String str, float f6, float f7) {
        if (f7 == -1.0f) {
            return f6;
        }
        str.getClass();
        switch (str) {
            case "*":
                return f7 * f6;
            case "+":
                return f7 + f6;
            case "max":
                return Math.max(f6, f7);
            case "min":
                return Math.min(f6, f7);
            default:
                return f7;
        }
    }

    public int j() {
        return this.f24830j;
    }
}
