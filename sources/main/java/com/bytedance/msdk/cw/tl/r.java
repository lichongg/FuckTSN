package com.bytedance.msdk.cw.tl;

import android.text.TextUtils;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.tl.la;
import com.bytedance.sdk.openadsdk.i.cw.cw.xt;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class r {

    /* renamed from: j, reason: collision with root package name */
    public static Map<String, List<com.bytedance.msdk.core.oq.up>> f25126j = new ConcurrentHashMap();
    public static Map<String, String> xt = new ConcurrentHashMap();

    public static PluginValueSet j(String str, xt.j jVar, int i6) {
        long j6;
        int i7;
        String str2;
        int i8;
        String str3;
        if (TextUtils.isEmpty(str)) {
            return com.bytedance.sdk.openadsdk.mediation.xt.xt.j.j(jVar.j());
        }
        if (com.bytedance.msdk.core.qv.j.j().j(str)) {
            return com.bytedance.sdk.openadsdk.mediation.xt.xt.j.j(jVar.j());
        }
        String j7 = j(str);
        if (TextUtils.isEmpty(j7)) {
            long currentTimeMillis = System.currentTimeMillis();
            String xt2 = xt(str);
            j6 = System.currentTimeMillis() - currentTimeMillis;
            i7 = !TextUtils.isEmpty(xt2) ? 2 : 3;
            str2 = str;
            i8 = i6;
            str3 = xt2;
        } else {
            j6 = 0;
            i7 = 1;
            str2 = str;
            i8 = i6;
            str3 = j7;
        }
        com.bytedance.msdk.up.m.j(i8, i7, j6, str2, str3);
        int i9 = i7;
        String str4 = str3;
        if (TextUtils.isEmpty(str4)) {
            return com.bytedance.sdk.openadsdk.mediation.xt.xt.j.j(jVar.j());
        }
        jVar.r(str4);
        return com.bytedance.sdk.openadsdk.mediation.xt.xt.j.j(jVar.j(), str2, i9 == 2);
    }

    private static String xt(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (xt.size() == 0) {
            cw();
        }
        return xt.get(str);
    }

    private static void cw() {
        String xt2 = com.bytedance.msdk.ae.j.cw().xt("mediation_adn_map");
        if (!TextUtils.isEmpty(xt2)) {
            try {
                JSONObject jSONObject = new JSONObject(xt2);
                Iterator<String> keys = jSONObject.keys();
                if (keys != null) {
                    while (keys.hasNext()) {
                        String next = keys.next();
                        String string = jSONObject.getString(next);
                        if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(string)) {
                            xt.put(next, string);
                        }
                    }
                }
            } catch (JSONException e6) {
                throw new RuntimeException(e6);
            }
        }
    }

    private static void xt() {
        String xt2 = com.bytedance.msdk.ae.j.cw().xt("mediation_csj_map");
        if (TextUtils.isEmpty(xt2)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(xt2);
            Iterator<String> keys = jSONObject.keys();
            if (keys != null) {
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONArray jSONArray = jSONObject.getJSONArray(next);
                    if (jSONArray.length() > 0) {
                        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                        for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                            JSONObject optJSONObject = jSONArray.optJSONObject(i6);
                            String optString = optJSONObject.optString("csj_code_id");
                            if (TextUtils.isEmpty(optString)) {
                                optString = optJSONObject.optString("csj_rit_id");
                            }
                            double optDouble = optJSONObject.optDouble("price");
                            if (optDouble <= 0.0d) {
                                optDouble = optJSONObject.optDouble("ecpm");
                            }
                            copyOnWriteArrayList.add(new com.bytedance.msdk.core.oq.up(optString, optDouble, optJSONObject.optInt("load_sort"), optJSONObject.optInt("show_sort")));
                        }
                        f25126j.put(next, copyOnWriteArrayList);
                    }
                }
            }
        } catch (JSONException e6) {
            throw new RuntimeException(e6);
        }
    }

    public static void j(final JSONObject jSONObject) {
        JSONArray optJSONArray;
        double d6;
        if (jSONObject == null) {
            return;
        }
        f25126j.clear();
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next) && (optJSONArray = jSONObject.optJSONArray(next)) != null) {
                    CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                    for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i6);
                        String optString = jSONObject2.optString("price");
                        long optLong = jSONObject2.optLong("csj_code_id");
                        try {
                            d6 = Double.valueOf(optString).doubleValue();
                        } catch (Throwable unused) {
                            d6 = 0.0d;
                        }
                        copyOnWriteArrayList.add(new com.bytedance.msdk.core.oq.up(String.valueOf(optLong), d6, 0, 0));
                    }
                    f25126j.put(next, copyOnWriteArrayList);
                }
            }
        } catch (Throwable unused2) {
        }
        com.bytedance.msdk.j.up.m.r(new Runnable() { // from class: com.bytedance.msdk.cw.tl.r.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.ae.j.cw().j("mediation_csj_map", jSONObject.toString());
            }
        });
    }

    public static void j() {
        if (xt.size() == 0) {
            return;
        }
        final JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, String> entry : xt.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                try {
                    jSONObject.put(entry.getKey(), entry.getValue());
                } catch (JSONException e6) {
                    throw new RuntimeException(e6);
                }
            }
        }
        com.bytedance.msdk.j.up.m.r(new Runnable() { // from class: com.bytedance.msdk.cw.tl.r.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.ae.j.cw().j("mediation_adn_map", jSONObject.toString());
            }
        });
    }

    public static boolean j(String str, String str2) {
        List<com.bytedance.msdk.core.oq.up> list;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (list = f25126j.get(str)) == null || list.size() == 0) {
            return true;
        }
        la.j(list);
        return str2.equals(list.get(0).j());
    }

    private static String j(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (f25126j.size() == 0) {
            xt();
        }
        for (String str2 : f25126j.keySet()) {
            List<com.bytedance.msdk.core.oq.up> list = f25126j.get(str2);
            if (list != null) {
                Iterator<com.bytedance.msdk.core.oq.up> it = list.iterator();
                while (it.hasNext()) {
                    if (str.equals(it.next().j())) {
                        return str2;
                    }
                }
            }
        }
        return null;
    }
}
