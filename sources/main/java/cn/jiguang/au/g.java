package cn.jiguang.au;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.bz.j;
import cn.jiguang.bz.p;
import cn.jiguang.bz.y;
import cn.jpush.android.service.WakedResultReceiver;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f1768a;

    /* renamed from: b, reason: collision with root package name */
    private static WakedResultReceiver f1769b;

    public static JSONArray a(Context context) {
        JSONObject a6;
        synchronized ("waked_cache_v2.json") {
            a6 = j.a("waked_cache_v2.json");
        }
        if (a6 == null) {
            a6 = new JSONObject();
        }
        JSONArray optJSONArray = a6.optJSONArray("content");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            return a(context, optJSONArray);
        }
        cn.jiguang.bb.f.c("JWakedHelper", "no save data");
        return null;
    }

    public static void b(Context context) {
        j.d("waked_cache_v2.json");
    }

    private static WakedResultReceiver c(Context context) {
        PackageInfo a6;
        WakedResultReceiver wakedResultReceiver = f1769b;
        if (wakedResultReceiver != null) {
            return wakedResultReceiver;
        }
        try {
            a6 = p.a(context, 0);
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("JWakedHelper", "find waked receiver throwable:" + th.getMessage());
        }
        if (a6 == null) {
            return null;
        }
        for (ActivityInfo activityInfo : a6.receivers) {
            if (WakedResultReceiver.class.isAssignableFrom(Class.forName(activityInfo.name, false, WakedResultReceiver.class.getClassLoader()))) {
                return (WakedResultReceiver) Class.forName(activityInfo.name).newInstance();
            }
            continue;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static JSONArray a(Context context, JSONArray jSONArray) {
        JSONArray jSONArray2;
        String str;
        HashMap hashMap;
        int i6;
        Map map;
        HashMap hashMap2;
        HashMap hashMap3;
        if (jSONArray != null) {
            try {
            } catch (Throwable th) {
                th = th;
                jSONArray2 = null;
            }
            if (jSONArray.length() > 0) {
                HashMap hashMap4 = new HashMap();
                int i7 = 0;
                while (true) {
                    str = "dead";
                    if (i7 >= jSONArray.length()) {
                        break;
                    }
                    JSONObject jSONObject = jSONArray.getJSONObject(i7);
                    String optString = jSONObject.optString("type");
                    long optLong = jSONObject.optLong("itime");
                    Iterator it = hashMap4.entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            hashMap = hashMap4;
                            i6 = i7;
                            map = null;
                            break;
                        }
                        Map.Entry entry = (Map.Entry) it.next();
                        long longValue = ((Long) entry.getKey()).longValue();
                        i6 = i7;
                        hashMap = hashMap4;
                        jSONArray2 = null;
                        try {
                            if (y.a(optLong * 1000, longValue * 1000)) {
                                map = (Map) entry.getValue();
                                optLong = longValue;
                                break;
                            }
                            i7 = i6;
                            hashMap4 = hashMap;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                    if (map == null) {
                        map = new HashMap();
                    }
                    if ("android_awake_target2".equals(optString) || "aat3".equals(optString)) {
                        String optString2 = jSONObject.optString(WiseOpenHianalyticsData.UNION_PACKAGE);
                        str = jSONObject.optBoolean("app_alive") ? "active" : "dead";
                        int optInt = jSONObject.optInt("wake_type");
                        if (map.containsKey(optString2)) {
                            Map map2 = (Map) map.get(optString2);
                            if (map2.containsKey(Integer.valueOf(optInt))) {
                                Map map3 = (Map) map2.get(Integer.valueOf(optInt));
                                if (map3.containsKey(str)) {
                                    map3.put(str, Integer.valueOf(((Integer) map3.get(str)).intValue() + 1));
                                    hashMap3 = map3;
                                } else {
                                    map3.put(str, 1);
                                    hashMap3 = map3;
                                }
                            } else {
                                HashMap hashMap5 = new HashMap();
                                hashMap5.put(str, 1);
                                hashMap3 = hashMap5;
                            }
                            map2.put(Integer.valueOf(optInt), hashMap3);
                            map.put(optString2, map2);
                        } else {
                            HashMap hashMap6 = new HashMap();
                            hashMap6.put(str, 1);
                            HashMap hashMap7 = new HashMap();
                            hashMap7.put(Integer.valueOf(optInt), hashMap6);
                            map.put(optString2, hashMap7);
                        }
                        hashMap2 = hashMap;
                        hashMap2.put(Long.valueOf(optLong), map);
                        String optString3 = jSONObject.optString("jg_extras");
                        cn.jiguang.bb.f.c("JWakedHelper", "jg_extras is :" + optString3);
                        if (!TextUtils.isEmpty(optString3)) {
                            String optString4 = new JSONObject(optString3).optString("di");
                            if (!TextUtils.isEmpty(optString4)) {
                                a(context, optString4);
                            }
                        }
                    } else {
                        cn.jiguang.bb.f.i("JWakedHelper", "unkown type :" + optString);
                        hashMap2 = hashMap;
                    }
                    i7 = i6 + 1;
                    hashMap4 = hashMap2;
                    th = th2;
                    cn.jiguang.bb.f.j("JWakedHelper", "merge waked json failed:" + th.getMessage());
                    return jSONArray2;
                }
                jSONArray2 = null;
                JSONArray jSONArray3 = new JSONArray();
                Iterator it2 = hashMap4.entrySet().iterator();
                while (it2.hasNext()) {
                    Map.Entry entry2 = (Map.Entry) it2.next();
                    JSONObject jSONObject2 = new JSONObject();
                    JSONArray jSONArray4 = new JSONArray();
                    Iterator it3 = ((Map) entry2.getValue()).entrySet().iterator();
                    while (it3.hasNext()) {
                        Map.Entry entry3 = (Map.Entry) it3.next();
                        JSONObject jSONObject3 = new JSONObject();
                        Iterator it4 = it2;
                        jSONObject3.put("p", entry3.getKey());
                        cn.jiguang.bb.f.c("JWakedHelper", "pkg:" + ((String) entry3.getKey()));
                        Iterator it5 = ((Map) entry3.getValue()).entrySet().iterator();
                        JSONArray jSONArray5 = new JSONArray();
                        while (it5.hasNext()) {
                            Map.Entry entry4 = (Map.Entry) it5.next();
                            Iterator it6 = it5;
                            int intValue = ((Integer) entry4.getKey()).intValue();
                            Map.Entry entry5 = entry2;
                            StringBuilder sb = new StringBuilder();
                            Iterator it7 = it3;
                            sb.append("type:");
                            sb.append(intValue);
                            cn.jiguang.bb.f.c("JWakedHelper", sb.toString());
                            Map map4 = (Map) entry4.getValue();
                            cn.jiguang.bb.f.c("JWakedHelper", "value:" + map4);
                            int intValue2 = map4.containsKey("active") ? ((Integer) map4.get("active")).intValue() : 0;
                            int intValue3 = map4.containsKey(str) ? ((Integer) map4.get(str)).intValue() : 0;
                            jSONArray5.put(intValue + "_" + (intValue2 + intValue3) + "_" + intValue2 + "_" + intValue3);
                            entry2 = entry5;
                            it5 = it6;
                            it3 = it7;
                            str = str;
                        }
                        jSONObject3.put("d", jSONArray5);
                        jSONArray4.put(jSONObject3);
                        it2 = it4;
                        entry2 = entry2;
                        it3 = it3;
                        str = str;
                    }
                    Iterator it8 = it2;
                    Map.Entry entry6 = entry2;
                    String str2 = str;
                    if (jSONArray4.length() > 0) {
                        jSONObject2.put("f", jSONArray4);
                        jSONObject2.put("itime", ((Long) entry6.getKey()).longValue());
                        jSONObject2.put("type", "aat3");
                        jSONArray3.put(jSONObject2);
                    }
                    it2 = it8;
                    str = str2;
                }
                return jSONArray3.length() > 0 ? jSONArray3 : jSONArray;
            }
        }
        return jSONArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, Bundle bundle, int i6) {
        String str;
        String str2;
        if (bundle == null) {
            str2 = "bundle is null,give up save";
        } else {
            if (b.b(context).f1713x) {
                try {
                    str = bundle.getString("from_package");
                } catch (Throwable unused) {
                    str = null;
                }
                if (str == null) {
                    str = "";
                }
                JSONObject a6 = a(str, i6, f1768a);
                f1768a = true;
                if (a6 == null) {
                    return;
                }
                try {
                    String string = bundle.getString("jg_extras");
                    if (!TextUtils.isEmpty(string)) {
                        a6.put("jg_extras", string);
                    }
                } catch (Throwable th) {
                    cn.jiguang.bb.f.i("JWakedHelper", "save waked extras error:" + th.getMessage());
                }
                a(context, a6);
                return;
            }
            str2 = "server set do not report waked data,give up save";
        }
        cn.jiguang.bb.f.i("JWakedHelper", str2);
    }

    private static JSONObject a(String str, int i6, boolean z5) {
        if (str == null) {
            str = "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("wake_type", i6);
            jSONObject.put(WiseOpenHianalyticsData.UNION_PACKAGE, str);
            jSONObject.put("app_alive", z5);
            return jSONObject;
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("JWakedHelper", "packageWakedJson error:" + th.getMessage());
            return null;
        }
    }

    private static void a(Context context, int i6) {
        if (context == null) {
            cn.jiguang.bb.f.i("JWakedHelper", "context is null,can not notify waked");
            return;
        }
        WakedResultReceiver c6 = c(context);
        f1769b = c6;
        if (c6 == null) {
            cn.jiguang.bb.f.i("JWakedHelper", "waked receiver is null");
            return;
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("1", context);
        hashMap.put("2", Integer.valueOf(i6));
        f1769b.onWakeMap(hashMap);
    }

    public static void a(final Context context, final Bundle bundle, final int i6) {
        try {
            cn.jiguang.bb.f.c("JWakedHelper", "executeWakedAction.");
            a(context, i6);
            cn.jiguang.be.b.b(new cn.jiguang.by.b() { // from class: cn.jiguang.au.g.1
                @Override // cn.jiguang.by.b
                public void a() {
                    g.c(context, bundle, i6);
                }
            });
            cn.jiguang.f.a.a(context, 2);
        } catch (Throwable th) {
            cn.jiguang.bb.f.c("JWakedHelper", "executeWakedAction failed:" + th.getLocalizedMessage());
        }
    }

    public static void a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("di", str);
            synchronized ("di.json") {
                try {
                    JSONObject a6 = j.a("di.json");
                    if (a6 == null) {
                        a6 = new JSONObject();
                    }
                    JSONArray optJSONArray = a6.optJSONArray("content");
                    if (optJSONArray == null) {
                        optJSONArray = new JSONArray();
                    }
                    optJSONArray.put(jSONObject);
                    a6.put("content", optJSONArray);
                    j.a("di.json", a6);
                    cn.jiguang.bb.f.c("JWakedHelper", "save di is: " + str + ", success!");
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            cn.jiguang.bb.f.i("JWakedHelper", "saveDId failed:" + th2.getMessage());
        }
    }

    private static void a(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("itime", cn.jiguang.d.b.b(context));
            jSONObject.put("type", "aat3");
            synchronized ("waked_cache_v2.json") {
                try {
                    JSONObject a6 = j.a("waked_cache_v2.json");
                    if (a6 == null) {
                        a6 = new JSONObject();
                    }
                    JSONArray optJSONArray = a6.optJSONArray("content");
                    if (optJSONArray == null) {
                        optJSONArray = new JSONArray();
                    }
                    optJSONArray.put(jSONObject);
                    a6.put("content", optJSONArray);
                    j.a("waked_cache_v2.json", a6);
                    cn.jiguang.bb.f.c("JWakedHelper", "save waked data : " + a6.toString());
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            cn.jiguang.bb.f.i("JWakedHelper", "saveWakedData failed:" + th2.getMessage());
        }
    }
}
