package com.ss.android.socialbase.appdownloader.m;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.vl;
import com.ss.android.socialbase.appdownloader.a;
import java.lang.reflect.Field;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final HashMap<String, a.C0770a> f38483a = new HashMap<>();

    public static boolean a(JSONObject jSONObject) {
        return jSONObject == null || c.e() || jSONObject.optInt("scy_mode") != 1;
    }

    public static boolean c(JSONArray jSONArray) {
        int length;
        if (jSONArray == null || (length = jSONArray.length()) == 0) {
            return true;
        }
        boolean z5 = false;
        for (int i6 = 0; i6 < length; i6++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i6);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("package_names");
                JSONArray optJSONArray = optJSONObject.optJSONArray("version_allow");
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("version_block");
                String optString2 = optJSONObject.optString("allow_version_range");
                if (TextUtils.isEmpty(optString)) {
                    return false;
                }
                for (String str : optString.split(",")) {
                    if ("market".equals(str)) {
                        str = e.m();
                    }
                    a.C0770a h6 = h(str);
                    if (h6 != null && !(z5 = e(optJSONArray, optJSONArray2, optString2, h6))) {
                        return false;
                    }
                }
            }
        }
        return z5;
    }

    public static boolean d(JSONArray jSONArray, String str) {
        if (jSONArray != null && !TextUtils.isEmpty(str)) {
            int length = jSONArray.length();
            for (int i6 = 0; i6 < length; i6++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i6);
                if (optJSONObject != null && str.equals(optJSONObject.optString("type")) && f(optJSONObject)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean f(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        return j(jSONObject) && c(jSONObject.optJSONArray("device_requirements")) && a(jSONObject);
    }

    private static boolean i(JSONArray jSONArray, String str) {
        if (jSONArray != null && str != null) {
            int length = jSONArray.length();
            for (int i6 = 0; i6 < length; i6++) {
                if (str.equalsIgnoreCase(jSONArray.optString(i6).trim())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean j(JSONObject jSONObject) {
        if (jSONObject == null) {
            return true;
        }
        int i6 = Build.VERSION.SDK_INT;
        String optString = jSONObject.optString("allow_os_api_range");
        int optInt = jSONObject.optInt("min_os_api", -1);
        if (TextUtils.isEmpty(optString)) {
            return optInt <= 0 || i6 >= optInt;
        }
        try {
            String[] split = optString.split("[-,]");
            for (int i7 = 0; i7 < split.length; i7 += 2) {
                int parseInt = Integer.parseInt(split[i7]);
                int parseInt2 = Integer.parseInt(split[i7 + 1]);
                if (i6 >= parseInt && i6 <= parseInt2) {
                    return true;
                }
            }
        } catch (Exception e6) {
            vl.j(e6);
        }
        return false;
    }

    private static a.C0770a h(String str) {
        HashMap<String, a.C0770a> hashMap = f38483a;
        if (hashMap.containsKey(str)) {
            a.C0770a c0770a = hashMap.get(str);
            if (c0770a != null) {
                return c0770a;
            }
            return null;
        }
        a.C0770a d6 = com.ss.android.socialbase.appdownloader.a.d(str);
        hashMap.put(str, d6);
        if (d6 != null) {
            return d6;
        }
        return null;
    }

    public static a.C0770a b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                a.C0770a h6 = h(str);
                if (h6 != null) {
                    return h6;
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private static boolean e(JSONArray jSONArray, JSONArray jSONArray2, String str, @NonNull a.C0770a c0770a) {
        String a6 = c0770a.a();
        int i6 = c0770a.i();
        String str2 = i6 + "_" + a6;
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split("[-,]");
                for (int i7 = 0; i7 < split.length; i7 += 2) {
                    int parseInt = Integer.parseInt(split[i7]);
                    int parseInt2 = Integer.parseInt(split[i7 + 1]);
                    if (i6 >= parseInt && i6 <= parseInt2) {
                        return true;
                    }
                }
            } catch (Exception e6) {
                vl.j(e6);
            }
        } else if (jSONArray != null && jSONArray.length() > 0) {
            if (i(jSONArray, str2)) {
                return true;
            }
        } else if (jSONArray2 != null && jSONArray2.length() > 0 && !i(jSONArray2, str2)) {
            return true;
        }
        return false;
    }

    public static boolean g(JSONObject jSONObject, Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null && jSONObject != null) {
            String optString = jSONObject.optString("s");
            try {
                String b6 = a.b(jSONObject.optString("az"), optString);
                String b7 = a.b(jSONObject.optString("ba"), optString);
                Field declaredField = ContextWrapper.class.getDeclaredField(b6);
                declaredField.setAccessible(true);
                Object obj = declaredField.get(context);
                Field declaredField2 = obj.getClass().getDeclaredField(b7);
                declaredField2.setAccessible(true);
                declaredField2.set(obj, str);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
