package com.bytedance.sdk.component.adexpress.dynamic.r;

import com.bxkj.base.v2.common.utils.g0;
import com.bytedance.sdk.component.utils.vl;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class g {
    public static void j(String str, JSONObject jSONObject) {
        JSONObject qa = com.bytedance.sdk.component.adexpress.xt.qa(str);
        if (qa == null) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        JSONObject optJSONObject = qa.optJSONObject("values");
        if (optJSONObject == null) {
            return;
        }
        j(optJSONObject, jSONObject);
    }

    public static String xt(String str, String str2) {
        if (com.bytedance.sdk.component.adexpress.r.j()) {
            if (str.indexOf(46) < 0) {
                str = str + g0.f16898c;
            }
            return str2 + "static/images/" + str;
        }
        return j.j(str);
    }

    public static JSONObject j(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject qa = com.bytedance.sdk.component.adexpress.xt.qa(str);
        if (qa == null) {
            return null;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        return j(jSONObject2, qa.optJSONObject("themeValues"), jSONObject);
    }

    private static void j(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        if (jSONObject == null) {
            return;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!jSONObject2.has(next)) {
                try {
                    jSONObject2.put(next, jSONObject.opt(next));
                } catch (JSONException e6) {
                    vl.j(e6);
                }
            }
        }
    }

    public static JSONObject j(JSONObject... jSONObjectArr) {
        JSONObject jSONObject = new JSONObject();
        for (JSONObject jSONObject2 : jSONObjectArr) {
            if (jSONObject2 != null) {
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    try {
                        jSONObject.put(next, jSONObject2.opt(next));
                    } catch (JSONException e6) {
                        vl.j(e6);
                    }
                }
            }
        }
        return jSONObject;
    }

    public static String j(String str) {
        JSONObject optJSONObject;
        JSONObject qa = com.bytedance.sdk.component.adexpress.xt.qa(str);
        if (qa == null || (optJSONObject = qa.optJSONObject("values")) == null) {
            return null;
        }
        return optJSONObject.optString("data");
    }

    public static String j(String str, String str2) {
        JSONObject optJSONObject;
        JSONObject qa = com.bytedance.sdk.component.adexpress.xt.qa(str);
        if (qa == null || (optJSONObject = qa.optJSONObject("values")) == null) {
            return null;
        }
        return optJSONObject.optString(str2);
    }

    public static JSONObject j(JSONArray jSONArray) {
        JSONObject optJSONObject;
        if (jSONArray == null || jSONArray.length() <= 0 || (optJSONObject = jSONArray.optJSONObject(0)) == null) {
            return null;
        }
        return optJSONObject.optJSONObject("values");
    }
}
