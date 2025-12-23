package com.kwad.sdk.utils;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ab {
    public static void merge(JSONObject jSONObject, JSONObject jSONObject2) {
        a(jSONObject, jSONObject2, true);
    }

    public static void putValue(JSONObject jSONObject, String str, String str2) {
        try {
            jSONObject.put(str, str2);
        } catch (Throwable unused) {
        }
    }

    public static void a(JSONObject jSONObject, JSONObject jSONObject2, boolean z5) {
        if (jSONObject == null || jSONObject2 == null) {
            return;
        }
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String obj = keys.next().toString();
            Object opt = jSONObject2.opt(obj);
            if (opt != null) {
                try {
                    if (!jSONObject.has(obj)) {
                        jSONObject.put(obj, opt);
                    } else if (z5) {
                        jSONObject.put(obj, opt);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static <T> List<T> gV(String str) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        try {
            return h(new JSONArray(str));
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
            return arrayList;
        }
    }

    public static <T> List<T> h(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                try {
                    Object obj = jSONArray.get(i6);
                    if (obj != null) {
                        arrayList.add(obj);
                    }
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTrace(th);
                    return arrayList;
                }
            }
        }
        return arrayList;
    }

    public static Map<String, String> parseJSON2MapString(String str) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String optString = jSONObject.optString(next, "");
                if (TextUtils.isEmpty(optString) || TextUtils.equals("null", optString)) {
                    optString = "";
                }
                hashMap.put(next, optString);
            }
        } catch (JSONException unused) {
        }
        return hashMap;
    }

    public static JSONObject parseMap2JSON(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null && !map.isEmpty()) {
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }

    public static void putValue(JSONObject jSONObject, String str, double d6) {
        try {
            jSONObject.put(str, d6);
        } catch (Throwable unused) {
        }
    }

    public static JSONArray toJsonArray(@NonNull List<String> list) {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        return jSONArray;
    }

    public static void putValue(JSONObject jSONObject, String str, int i6) {
        try {
            jSONObject.put(str, i6);
        } catch (Throwable unused) {
        }
    }

    public static void putValue(JSONObject jSONObject, String str, float f6) {
        try {
            jSONObject.put(str, f6);
        } catch (Throwable unused) {
        }
    }

    public static void putValue(JSONObject jSONObject, String str, byte b6) {
        try {
            jSONObject.put(str, (int) b6);
        } catch (Throwable unused) {
        }
    }

    public static void putValue(JSONObject jSONObject, String str, long j6) {
        try {
            jSONObject.put(str, j6);
        } catch (Throwable unused) {
        }
    }

    public static void putValue(JSONObject jSONObject, String str, boolean z5) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject.put(str, z5);
        } catch (Throwable unused) {
        }
    }

    public static void putValue(JSONObject jSONObject, String str, JSONObject jSONObject2) {
        if (jSONObject2 == null || jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject.put(str, jSONObject2);
        } catch (Throwable unused) {
        }
    }

    public static void putValue(JSONObject jSONObject, String str, JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0 || jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject.put(str, jSONArray);
        } catch (Throwable unused) {
        }
    }
}
