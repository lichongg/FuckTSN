package com.huawei.hms.hatool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import com.acse.ottn.l3;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.lang.reflect.InvocationTargetException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class s0 {
    private static String f(String str, String str2, String str3) {
        Object b6 = b(str, l3.f4736f, new Class[]{String.class, String.class}, new Object[]{str2, str3});
        return b6 != null ? (String) b6 : str3;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a extends Exception {
        a(String str) {
            super(str);
        }
    }

    private static Object a(Class cls, String str, Class[] clsArr, Object[] objArr) {
        String str2;
        if (cls == null) {
            throw new a("class is null in invokeStaticFun");
        }
        if (clsArr == null) {
            if (objArr != null) {
                throw new a("paramsType is null, but params is not null");
            }
        } else {
            if (objArr == null) {
                throw new a("paramsType or params should be same");
            }
            if (clsArr.length != objArr.length) {
                throw new a("paramsType len:" + clsArr.length + " should equal params.len:" + objArr.length);
            }
        }
        try {
            try {
                return cls.getMethod(str, clsArr).invoke(null, objArr);
            } catch (IllegalAccessException unused) {
                str2 = "invokeStaticFun(): method invoke Exception!";
                j1.m("hmsSdk", str2);
                return null;
            } catch (IllegalArgumentException unused2) {
                str2 = "invokeStaticFun(): Illegal Argument!";
                j1.m("hmsSdk", str2);
                return null;
            } catch (InvocationTargetException unused3) {
                str2 = "invokeStaticFun(): Invocation Target Exception!";
                j1.m("hmsSdk", str2);
                return null;
            }
        } catch (NoSuchMethodException unused4) {
            j1.m("hmsSdk", "invokeStaticFun(): cls.getMethod(),No Such Method !");
        }
    }

    private static Object b(String str, String str2, Class[] clsArr, Object[] objArr) {
        String str3;
        try {
            return a(Class.forName(str), str2, clsArr, objArr);
        } catch (a unused) {
            str3 = "invokeStaticFun(): Static function call Exception ";
            j1.m("hmsSdk", str3);
            return null;
        } catch (ClassNotFoundException unused2) {
            str3 = "invokeStaticFun() Not found class!";
            j1.m("hmsSdk", str3);
            return null;
        }
    }

    public static String c() {
        return e("ro.build.version.emui", "");
    }

    @SuppressLint({"HardwareIds"})
    public static String d(Context context) {
        return context == null ? "" : Settings.Secure.getString(context.getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID);
    }

    public static String g() {
        String f6 = f("com.huawei.android.os.SystemPropertiesEx", "ro.huawei.build.display.id", "");
        j1.h("hmsSdk", "SystemPropertiesEx: get rom_ver: " + f6);
        if (!TextUtils.isEmpty(f6)) {
            return f6;
        }
        String str = Build.DISPLAY;
        j1.h("hmsSdk", "SystemProperties: get rom_ver: " + str);
        return str;
    }

    public static String h(Context context) {
        Bundle bundle;
        Object obj;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null && (bundle = applicationInfo.metaData) != null && (obj = bundle.get("CHANNEL")) != null) {
                String obj2 = obj.toString();
                return obj2.length() > 256 ? "Unknown" : obj2;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            j1.m("hmsSdk", "getChannel(): The packageName is not correct!");
        }
        return "Unknown";
    }

    public static String i(Context context) {
        return context == null ? "" : context.getPackageName();
    }

    public static String j(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return context.getPackageManager().getPackageInfo(i(context), 16384).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            j1.m("hmsSdk", "getVersion(): The package name is not correct!");
            return "";
        }
    }

    public static String e(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        String f6 = f("android.os.SystemProperties", str, str2);
        if (TextUtils.isEmpty(f6)) {
            return f("com.huawei.android.os.SystemPropertiesEx", str, str2);
        }
        return f6;
    }
}
