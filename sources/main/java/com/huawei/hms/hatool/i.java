package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class i {
    public static Map<String, List<f>> a(Context context, String str) {
        if (context == null) {
            return null;
        }
        Map<String, ?> c6 = l.c(context, str);
        g(c6);
        return c(c6);
    }

    public static Map<String, List<f>> b(Context context, String str, String str2) {
        Map<String, List<f>> a6;
        Map<String, List<f>> a7;
        if ("alltype".equals(str2) || TextUtils.isEmpty(str)) {
            j1.h("hmsSdk", "read all event records");
            a6 = a(context, "stat_v2_1");
            a7 = a(context, "cached_v2_1");
        } else {
            String d6 = q0.d(str, str2);
            a6 = f(context, "stat_v2_1", d6);
            a7 = f(context, "cached_v2_1", d6);
        }
        return d(a6, a7);
    }

    private static Map<String, List<f>> c(Map<String, ?> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            String key = entry.getKey();
            if (entry.getValue() instanceof String) {
                e(key, (String) entry.getValue(), hashMap);
            }
        }
        return hashMap;
    }

    private static void e(String str, String str2, Map<String, List<f>> map) {
        ArrayList arrayList = new ArrayList();
        try {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(str2);
            if (jSONArray.length() == 0) {
                return;
            }
            for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                f fVar = new f();
                try {
                    fVar.c(jSONArray.getJSONObject(i6));
                    arrayList.add(fVar);
                } catch (JSONException unused) {
                    j1.l("hmsSdk", "JSON Exception happened when create data for report - readDataToRecord");
                }
            }
            map.put(str, arrayList);
        } catch (JSONException unused2) {
            j1.l("hmsSdk", "When events turn to JSONArray,JSON Exception has happened");
        }
    }

    public static Map<String, List<f>> f(Context context, String str, String str2) {
        String b6 = l.b(context, str, str2, "");
        HashMap hashMap = new HashMap();
        e(str2, b6, hashMap);
        return hashMap;
    }

    private static Map<String, List<f>> d(Map<String, List<f>> map, Map<String, List<f>> map2) {
        if (map.size() == 0 && map2.size() == 0) {
            return new HashMap();
        }
        if (map.size() == 0) {
            return map2;
        }
        if (map2.size() == 0) {
            return map;
        }
        HashMap hashMap = new HashMap(map);
        hashMap.putAll(map2);
        return hashMap;
    }

    private static void g(Map<String, ?> map) {
        Iterator<Map.Entry<String, ?>> it = map.entrySet().iterator();
        Set<String> f6 = q0.f(y0.c());
        while (it.hasNext()) {
            if (!f6.contains(it.next().getKey())) {
                it.remove();
            }
        }
    }
}
