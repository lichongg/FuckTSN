package com.beizi.ad.internal.h;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class k {
    public static JSONArray a(JSONObject jSONObject, String str) {
        JSONArray jSONArray;
        if (jSONObject == null) {
            return null;
        }
        try {
            jSONArray = jSONObject.getJSONArray(str);
        } catch (JSONException unused) {
        }
        if (jSONArray.length() > 0) {
            return jSONArray;
        }
        return null;
    }

    public static JSONObject b(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.getJSONObject(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    public static int d(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return -1;
        }
        try {
            return jSONObject.getInt(str);
        } catch (JSONException unused) {
            return -1;
        }
    }

    public static String c(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return "";
        }
        try {
            return jSONObject.getString(str);
        } catch (JSONException unused) {
            return "";
        }
    }

    public static double e(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return -1.0d;
        }
        try {
            return jSONObject.getDouble(str);
        } catch (JSONException unused) {
            return -1.0d;
        }
    }

    public static ArrayList<String> a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        try {
            if (jSONArray.length() > 0) {
                int length = jSONArray.length();
                ArrayList<String> arrayList = new ArrayList<>(length);
                for (int i6 = 0; i6 < length; i6++) {
                    arrayList.add((String) jSONArray.get(i6));
                }
                return arrayList;
            }
        } catch (ClassCastException | JSONException unused) {
        }
        return null;
    }

    public static HashMap<String, Object> a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            Iterator<String> keys = jSONObject.keys();
            HashMap<String, Object> hashMap = new HashMap<>();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.getString(next));
            }
            return hashMap;
        } catch (JSONException unused) {
            return null;
        }
    }
}
