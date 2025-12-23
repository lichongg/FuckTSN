package com.bytedance.sdk.component.ae.cw.j;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.openadsdk.ats.AutoService;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* loaded from: D:\Downloads\app\classes4.dex */
class cw {

    /* renamed from: j, reason: collision with root package name */
    private static SoftReference<ConcurrentHashMap<String, Map<String, Object>>> f26069j;

    private static SharedPreferences cw(String str) {
        return ((com.bytedance.sdk.component.r.r) AutoService.j(com.bytedance.sdk.component.r.r.class)).j(r(str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    static synchronized <T> void j(String str, String str2, T t5) {
        synchronized (cw.class) {
            try {
                SharedPreferences cw = cw(str);
                if (cw == null) {
                    return;
                }
                if (t5.equals(cw(str, str2))) {
                    return;
                }
                SharedPreferences.Editor edit = cw.edit();
                if (t5 instanceof Boolean) {
                    edit.putBoolean(str2, ((Boolean) t5).booleanValue());
                }
                if (t5 instanceof String) {
                    edit.putString(str2, (String) t5);
                }
                if (t5 instanceof Integer) {
                    edit.putInt(str2, ((Integer) t5).intValue());
                }
                if (t5 instanceof Long) {
                    edit.putLong(str2, ((Long) t5).longValue());
                }
                if (t5 instanceof Float) {
                    edit.putFloat(str2, ((Float) t5).floatValue());
                }
                edit.apply();
                xt(str, str2, t5);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void xt(String str, String str2, Object obj) {
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = f26069j;
        if (softReference == null || softReference.get() == null) {
            f26069j = new SoftReference<>(new ConcurrentHashMap());
        }
        String r5 = r(str);
        ConcurrentHashMap<String, Map<String, Object>> concurrentHashMap = f26069j.get();
        if (concurrentHashMap.get(r5) == null) {
            concurrentHashMap.put(r5, new HashMap());
        }
        concurrentHashMap.get(r5).put(str2, obj);
    }

    private static void up(String str) {
        Map<String, Object> map;
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = f26069j;
        if (softReference == null || softReference.get() == null || (map = f26069j.get().get(r(str))) == null) {
            return;
        }
        map.clear();
    }

    private static Object cw(String str, String str2) {
        ConcurrentHashMap<String, Map<String, Object>> concurrentHashMap;
        Map<String, Object> map;
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = f26069j;
        if (softReference == null || (concurrentHashMap = softReference.get()) == null || (map = concurrentHashMap.get(r(str))) == null) {
            return null;
        }
        return map.get(str2);
    }

    private static String r(String str) {
        if (TextUtils.isEmpty(str)) {
            return "sphelper_ttopenadsdk";
        }
        return str;
    }

    private static String cw(String str, String str2, String str3) {
        SharedPreferences cw = cw(str);
        return cw == null ? str3 : cw.getString(str2, str3);
    }

    private static Object xt(String str, String str2, String str3) {
        String r5 = r(str);
        if (!j(r5, str2)) {
            return null;
        }
        if (str3.equalsIgnoreCase(ResIdentify.RES_TYPE_STRING)) {
            return cw(r5, str2, null);
        }
        if (str3.equalsIgnoreCase("boolean")) {
            return Boolean.valueOf(j(r5, str2, false));
        }
        if (str3.equalsIgnoreCase(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL)) {
            return Integer.valueOf(j(r5, str2, 0));
        }
        if (str3.equalsIgnoreCase("long")) {
            return Long.valueOf(j(r5, str2, 0L));
        }
        if (str3.equalsIgnoreCase("float")) {
            return Float.valueOf(j(r5, str2, 0.0f));
        }
        if (str3.equalsIgnoreCase("string_set")) {
            return cw(r5, str2, null);
        }
        return null;
    }

    static String j(String str, String str2, String str3) {
        Object cw = cw(str, str2);
        if (cw != null) {
            return String.valueOf(cw);
        }
        Object xt = xt(str, str2, str3);
        xt(str, str2, xt);
        return String.valueOf(xt);
    }

    static void xt(String str, String str2) {
        Map<String, Object> map;
        try {
            SharedPreferences cw = cw(str);
            if (cw == null) {
                return;
            }
            SharedPreferences.Editor edit = cw.edit();
            edit.remove(str2);
            edit.apply();
            SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = f26069j;
            if (softReference == null || softReference.get() == null) {
                return;
            }
            String r5 = r(str);
            if (!TextUtils.isEmpty(r5) && (map = f26069j.get().get(r5)) != null && map.size() != 0) {
                map.remove(str2);
                SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference2 = f26069j;
                if (softReference2 == null || softReference2.get() == null) {
                    return;
                }
                f26069j.get().put(r5, map);
            }
        } catch (Throwable unused) {
        }
    }

    private static int j(String str, String str2, int i6) {
        SharedPreferences cw = cw(str);
        return cw == null ? i6 : cw.getInt(str2, i6);
    }

    private static float j(String str, String str2, float f6) {
        SharedPreferences cw = cw(str);
        return cw == null ? f6 : cw.getFloat(str2, f6);
    }

    private static boolean j(String str, String str2, boolean z5) {
        SharedPreferences cw = cw(str);
        return cw == null ? z5 : cw.getBoolean(str2, z5);
    }

    private static long j(String str, String str2, long j6) {
        SharedPreferences cw = cw(str);
        return cw == null ? j6 : cw.getLong(str2, j6);
    }

    static boolean j(String str, String str2) {
        SharedPreferences cw = cw(str);
        return cw != null && cw.contains(str2);
    }

    static void j(String str) {
        SharedPreferences.Editor edit = cw(str).edit();
        edit.clear();
        edit.apply();
        up(str);
    }

    static Map<String, ?> xt(String str) {
        return cw(str).getAll();
    }
}
