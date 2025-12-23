package com.bytedance.adsdk.ugeno.m;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.vl;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt {
    public static void j(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject2 == null) {
            return;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                jSONObject2.put(next, jSONObject.opt(next));
            } catch (JSONException e6) {
                vl.j(e6);
            }
        }
    }

    public static JSONObject j(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return jSONObject;
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e6) {
            vl.j(e6);
            return jSONObject;
        }
    }

    public static JSONArray j(String str, JSONArray jSONArray) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return new JSONArray(str);
            } catch (JSONException unused) {
            }
        }
        return jSONArray;
    }

    public static void j(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray2 == null || jSONArray2.length() <= 0) {
            return;
        }
        if (jSONArray == null) {
            jSONArray = new JSONArray();
        }
        for (int i6 = 0; i6 < jSONArray2.length(); i6++) {
            Object opt = jSONArray2.opt(i6);
            if (opt != null) {
                jSONArray.put(opt);
            }
        }
    }
}
