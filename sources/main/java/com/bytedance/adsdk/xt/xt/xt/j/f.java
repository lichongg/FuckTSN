package com.bytedance.adsdk.xt.xt.xt.j;

import android.text.TextUtils;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class f implements com.bytedance.adsdk.xt.xt.xt.j {

    /* renamed from: j, reason: collision with root package name */
    private final String f23970j;

    @Override // com.bytedance.adsdk.xt.xt.xt.j
    public Object j(Map<String, JSONObject> map) {
        Object j6;
        if (map == null || map.size() <= 0 || (j6 = j(this.f23970j, map.get("default_key"))) == JSONObject.NULL) {
            return null;
        }
        return j6;
    }

    public String toString() {
        return "VariableNode [literals=" + this.f23970j + "]";
    }

    @Override // com.bytedance.adsdk.xt.xt.xt.j
    public String xt() {
        return this.f23970j;
    }

    public f(String str) {
        this.f23970j = str;
    }

    @Override // com.bytedance.adsdk.xt.xt.xt.j
    public com.bytedance.adsdk.xt.xt.r.up j() {
        return com.bytedance.adsdk.xt.xt.r.m.VARIABLE;
    }

    public Object j(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return j(str.split("\\."), 0, jSONObject);
    }

    private Object j(String[] strArr, int i6, JSONObject jSONObject) {
        Object opt;
        if (strArr != null && strArr.length > 0 && i6 < strArr.length && jSONObject != null) {
            String str = strArr[i6];
            int indexOf = str.indexOf("[");
            int indexOf2 = str.indexOf("]");
            if (indexOf >= 0 && indexOf2 >= 0 && indexOf <= indexOf2) {
                String substring = str.substring(0, indexOf);
                try {
                    int parseInt = Integer.parseInt(str.substring(indexOf + 1, indexOf2));
                    Object opt2 = jSONObject.opt(substring);
                    opt = opt2 instanceof JSONArray ? ((JSONArray) opt2).opt(parseInt) : null;
                } catch (NumberFormatException e6) {
                    com.bytedance.sdk.component.utils.vl.j(e6);
                    return null;
                }
            } else {
                opt = jSONObject.opt(str);
            }
            if (i6 == strArr.length - 1) {
                return opt;
            }
            if (opt instanceof String) {
                try {
                    return j(strArr, i6 + 1, new JSONObject((String) opt));
                } catch (JSONException e7) {
                    com.bytedance.sdk.component.utils.vl.j(e7);
                    return opt;
                }
            }
            if (opt instanceof JSONObject) {
                return j(strArr, i6 + 1, (JSONObject) opt);
            }
        }
        return null;
    }
}
