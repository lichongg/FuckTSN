package com.umeng.analytics;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.pro.at;
import com.umeng.analytics.pro.d;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.MLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONTokener;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final int f40795a = 3;

    /* renamed from: b, reason: collision with root package name */
    private static final String f40796b = "umeng_pcp";

    /* renamed from: c, reason: collision with root package name */
    private static final String f40797c = "mob";

    /* renamed from: d, reason: collision with root package name */
    private static final String f40798d = "em";

    /* renamed from: e, reason: collision with root package name */
    private static final String f40799e = "cp";

    /* renamed from: f, reason: collision with root package name */
    private static final String f40800f = "pk";

    /* renamed from: g, reason: collision with root package name */
    private static final String f40801g = "pv";

    /* renamed from: h, reason: collision with root package name */
    private static String[] f40802h = new String[2];

    /* renamed from: i, reason: collision with root package name */
    private static Object f40803i = new Object();

    /* renamed from: j, reason: collision with root package name */
    private static Map<String, Object> f40804j = new HashMap();

    public static void a(Context context, String str, String str2) {
        String[] strArr = f40802h;
        strArr[0] = str;
        strArr[1] = str2;
        if (context != null) {
            com.umeng.common.b.a(context).a(str, str2);
        }
    }

    public static void b(Context context) {
        String[] strArr = f40802h;
        strArr[0] = null;
        strArr[1] = null;
        if (context != null) {
            com.umeng.common.b.a(context).b();
        }
    }

    public static Map<String, Object> c(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(f40796b, 0);
        String string = sharedPreferences.getString(f40799e, "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            String str = new String(at.a(Base64.decode(string, 0), UMConfigure.sAppkey.getBytes()));
            if (str.length() <= 0) {
                return null;
            }
            HashMap hashMap = new HashMap();
            try {
                JSONArray jSONArray = (JSONArray) new JSONTokener(str).nextValue();
                for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i6);
                    hashMap.put(jSONObject.getString("pk"), jSONObject.get("pv"));
                }
                sharedPreferences.edit().putString(f40799e, "").apply();
                return hashMap;
            } catch (Throwable unused) {
                return hashMap;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static String[] a(Context context) {
        String[] a6;
        if (!TextUtils.isEmpty(f40802h[0]) && !TextUtils.isEmpty(f40802h[1])) {
            return f40802h;
        }
        if (context == null || (a6 = com.umeng.common.b.a(context).a()) == null) {
            return null;
        }
        String[] strArr = f40802h;
        strArr[0] = a6[0];
        strArr[1] = a6[1];
        return strArr;
    }

    public static void b(String str) {
        String encodeToString;
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext != null) {
            try {
                SharedPreferences sharedPreferences = appContext.getSharedPreferences(f40796b, 0);
                byte[] a6 = at.a(str.getBytes(), UMConfigure.sAppkey.getBytes());
                if (a6.length == 0) {
                    encodeToString = d.Q;
                } else {
                    encodeToString = Base64.encodeToString(a6, 0);
                }
                sharedPreferences.edit().putString(f40798d, encodeToString).apply();
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(String str) {
        String encodeToString;
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext != null) {
            try {
                SharedPreferences sharedPreferences = appContext.getSharedPreferences(f40796b, 0);
                byte[] a6 = at.a(str.getBytes(), UMConfigure.sAppkey.getBytes());
                if (a6.length == 0) {
                    encodeToString = d.Q;
                } else {
                    encodeToString = Base64.encodeToString(a6, 0);
                }
                sharedPreferences.edit().putString(f40797c, encodeToString).apply();
            } catch (Throwable unused) {
            }
        }
    }

    public static String b() {
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext != null) {
            try {
                SharedPreferences sharedPreferences = appContext.getSharedPreferences(f40796b, 0);
                String string = sharedPreferences.getString(f40798d, "");
                if (d.Q.equals(string)) {
                    sharedPreferences.edit().putString(f40798d, "").apply();
                    return "";
                }
                if (TextUtils.isEmpty(string)) {
                    return null;
                }
                sharedPreferences.edit().putString(f40798d, "").apply();
                return new String(at.a(Base64.decode(string, 0), UMConfigure.sAppkey.getBytes()));
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static String a() {
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext != null) {
            try {
                SharedPreferences sharedPreferences = appContext.getSharedPreferences(f40796b, 0);
                String string = sharedPreferences.getString(f40797c, "");
                if (d.Q.equals(string)) {
                    sharedPreferences.edit().putString(f40797c, "").apply();
                    return "";
                }
                if (TextUtils.isEmpty(string)) {
                    return null;
                }
                sharedPreferences.edit().putString(f40797c, "").apply();
                return new String(at.a(Base64.decode(string, 0), UMConfigure.sAppkey.getBytes()));
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static void a(Context context, Map<String, Object> map) {
        if (map != null) {
            JSONStringer jSONStringer = new JSONStringer();
            try {
                synchronized (f40803i) {
                    try {
                        jSONStringer.array();
                        for (String str : map.keySet()) {
                            jSONStringer.object();
                            jSONStringer.key("pk");
                            jSONStringer.value(str);
                            jSONStringer.key("pv");
                            jSONStringer.value(map.get(str));
                            jSONStringer.endObject();
                        }
                        jSONStringer.endArray();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                SharedPreferences sharedPreferences = context.getSharedPreferences(f40796b, 0);
                sharedPreferences.edit().putString(f40799e, Base64.encodeToString(at.a(jSONStringer.toString().getBytes(), UMConfigure.sAppkey.getBytes()), 0)).apply();
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(String str, Object obj) {
        synchronized (f40803i) {
            try {
                if (f40804j.containsKey(str)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "更新账号自定义KV: key=" + str + "; val=" + obj);
                    f40804j.put(str, obj);
                    a(UMGlobalContext.getAppContext(), f40804j);
                } else {
                    if (f40804j.size() >= 3) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "设置账号自定义KV: 已经设置3个KV键值对，忽略设置请求。");
                        MLog.e("userProfile: Only 3 user-defined key-value pairs can be configured, please check!");
                        return;
                    }
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "设置账号自定义KV: key=" + str + "; val=" + obj);
                    f40804j.put(str, obj);
                    a(UMGlobalContext.getAppContext(), f40804j);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
