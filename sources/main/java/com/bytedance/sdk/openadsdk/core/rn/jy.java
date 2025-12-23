package com.bytedance.sdk.openadsdk.core.rn;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import com.acse.ottn.j4;
import com.acse.ottn.l3;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class jy {
    private static int ae = 1;
    private static Boolean cw = null;

    /* renamed from: j, reason: collision with root package name */
    private static String f30093j = null;

    /* renamed from: m, reason: collision with root package name */
    private static Boolean f30094m = null;

    /* renamed from: r, reason: collision with root package name */
    private static String f30095r = null;
    private static int tl = 1;
    private static String up;
    private static String xt;

    public static void j() {
        if (cw == null) {
            if (!r() && !cw()) {
                cw = Boolean.FALSE;
                return;
            }
            try {
                Class<?> cls = Class.forName("com.huawei.system.BuildEx");
                cw = Boolean.valueOf(j4.f4664a.equals(cls.getMethod("getOsBrand", null).invoke(cls, null)));
            } catch (Throwable unused) {
                cw = Boolean.FALSE;
            }
            if (f30093j == null) {
                f30093j = j("getApiVersion");
            }
            if (xt == null) {
                xt = j("getVersion");
            }
            if (up == null) {
                up = j("getReleaseType");
            }
            if (f30095r == null) {
                f30095r = j("getBuildVersion");
            }
            if (f30094m == null) {
                f30094m = Boolean.FALSE;
                try {
                    f30094m = Boolean.valueOf("156".equals(xt("ro.config.hw_optb", "0")) && "true".equals(xt("hw_mc.pure_mode.enable", "false")));
                } catch (Exception unused2) {
                }
            }
            try {
                ae = Settings.Secure.getInt(com.bytedance.sdk.openadsdk.core.v.getContext().getContentResolver(), "pure_enhanced_mode_state", 1);
            } catch (Throwable unused3) {
            }
            try {
                Class<?> cls2 = Class.forName("com.huawei.android.os.UserHandleEx");
                tl = ((Integer) cls2.getMethod("getUserId", Integer.TYPE).invoke(cls2, Integer.valueOf(Process.myUid()))).intValue();
            } catch (Throwable unused4) {
            }
        }
    }

    public static boolean xt() {
        Boolean bool = cw;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static String ae() {
        return up;
    }

    public static boolean cw() {
        String str = Build.BRAND;
        if (!TextUtils.isEmpty(str) && str.toUpperCase().startsWith("HUAWEI")) {
            return true;
        }
        String str2 = Build.MANUFACTURER;
        return !TextUtils.isEmpty(str2) && str2.toUpperCase().startsWith("HUAWEI");
    }

    private static int jy() {
        return tl;
    }

    public static String m() {
        return xt;
    }

    public static int qv() {
        return ae;
    }

    public static boolean r() {
        String str = Build.BRAND;
        if (!TextUtils.isEmpty(str) && str.toUpperCase().startsWith("HONOR")) {
            return true;
        }
        String str2 = Build.MANUFACTURER;
        return !TextUtils.isEmpty(str2) && str2.toUpperCase().startsWith("HONOR");
    }

    public static String tl() {
        return f30095r;
    }

    public static String up() {
        return f30093j;
    }

    public static boolean vl() {
        Boolean bool = f30094m;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static boolean g() {
        if (qv() == 0 && oq()) {
            return true;
        }
        return false;
    }

    public static boolean oq() {
        if (vl() && j(m(), up()) && jy() == 0) {
            return true;
        }
        return false;
    }

    private static int xt(Context context) {
        if (context != null) {
            return Settings.Secure.getInt(context.getContentResolver(), "pure_mode_state", 0);
        }
        return 1;
    }

    private static String xt(String str, String str2) {
        try {
            Class<?> cls = Class.forName("com.huawei.android.os.SystemPropertiesEx");
            return (String) cls.getMethod(l3.f4736f, String.class, String.class).invoke(cls, str, "unknown");
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
            return str2;
        } catch (Throwable unused) {
            return str2;
        }
    }

    private static String j(String str) {
        try {
            Class<?> cls = Class.forName("ohos.system.version.SystemVersion");
            return cls.getMethod(str, null).invoke(cls, null).toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean j(Context context) {
        return context != null && xt(context) == 0 && vl();
    }

    public static void j(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("pure_enhanced_mode", g() ? 1 : 2);
            jSONObject.put("pure_enhanced_mode_enable", oq() ? 1 : 2);
        } catch (Throwable unused) {
        }
    }

    private static boolean j(String str, String str2) {
        return (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || !str.startsWith("3")) ? false : true;
    }
}
