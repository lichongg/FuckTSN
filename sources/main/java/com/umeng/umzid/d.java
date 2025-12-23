package com.umeng.umzid;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static String[] f42559a = {"com.bly.dkplat", "com.by.chaos", "com.lbe.parallel", "com.excelliance.dualaid", "com.excelliance.multiaccounts", "com.lody.virtual", "com.qihoo.magic"};

    public static String a(Context context) {
        try {
            Class<?> cls = Class.forName("com.umeng.commonsdk.statistics.common.DeviceConfig");
            Method declaredMethod = cls.getDeclaredMethod("getAndroidId", Context.class);
            if (declaredMethod == null) {
                return "";
            }
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(cls, context);
            return (invoke == null || !(invoke instanceof String)) ? "" : (String) invoke;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String b(Context context) {
        SharedPreferences a6;
        if (context == null || (a6 = a.a(context)) == null) {
            return "";
        }
        String string = a6.getString("inputDomain", "");
        return c(string) ? a(string) : string;
    }

    public static String c(Context context) {
        SharedPreferences a6;
        return (context == null || (a6 = a.a(context)) == null) ? "" : a6.getString("uabc", "");
    }

    public static String d(Context context) {
        SharedPreferences a6;
        if (context == null || (a6 = a.a(context)) == null) {
            return null;
        }
        return a6.getString("aaid", null);
    }

    public static String e(Context context) {
        try {
            Class<?> cls = Class.forName("com.umeng.commonsdk.statistics.common.DeviceConfig");
            Method declaredMethod = cls.getDeclaredMethod("getMac", Context.class);
            if (declaredMethod == null) {
                return "";
            }
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(cls, context);
            return (invoke == null || !(invoke instanceof String)) ? "" : (String) invoke;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String f(Context context) {
        try {
            Class<?> cls = Class.forName("com.umeng.commonsdk.statistics.common.DeviceConfig");
            Method declaredMethod = cls.getDeclaredMethod("getOaid", Context.class);
            if (declaredMethod == null) {
                return "";
            }
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(cls, context);
            return (invoke == null || !(invoke instanceof String)) ? "" : (String) invoke;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean g(Context context) {
        try {
            String path = context.getFilesDir().getPath();
            for (String str : f42559a) {
                if (path.contains(str)) {
                    return true;
                }
            }
        } catch (Throwable th) {
            try {
                th.printStackTrace();
            } catch (Throwable th2) {
                th2.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public static boolean j(Context context) {
        try {
            String property = System.getProperty("http.proxyHost");
            String property2 = System.getProperty("http.proxyPort");
            if (property2 == null) {
                property2 = "-1";
            }
            return (TextUtils.isEmpty(property) || Integer.parseInt(property2) == -1) ? false : true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static String a(String str) {
        try {
            return new String(Base64.decode(str.getBytes("UTF-8"), 2));
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    public static String b(String str) {
        try {
            return Base64.encodeToString(str.getBytes("UTF-8"), 2);
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    public static void c(Context context, String str) {
        SharedPreferences a6;
        SharedPreferences.Editor edit;
        if (context == null || TextUtils.isEmpty(str) || (a6 = a.a(context)) == null || (edit = a6.edit()) == null) {
            return;
        }
        edit.putString("resetToken", str).commit();
    }

    public static void d(Context context, String str) {
        SharedPreferences a6;
        SharedPreferences.Editor edit;
        if (context == null || TextUtils.isEmpty(str) || (a6 = a.a(context)) == null || (edit = a6.edit()) == null) {
            return;
        }
        edit.putString("uabc", str).commit();
    }

    public static void e(Context context, String str) {
        SharedPreferences a6;
        SharedPreferences.Editor edit;
        if (context == null || str == null || TextUtils.isEmpty(str) || (a6 = a.a(context)) == null || (edit = a6.edit()) == null) {
            return;
        }
        edit.putString("aaid", str).commit();
    }

    public static void f(Context context, String str) {
        SharedPreferences a6;
        SharedPreferences.Editor edit;
        if (context == null || str == null || TextUtils.isEmpty(str) || (a6 = a.a(context)) == null || (edit = a6.edit()) == null) {
            return;
        }
        edit.putString("zdata", str).commit();
    }

    public static boolean h(Context context) {
        try {
            Class<?> cls = Class.forName("com.umeng.commonsdk.utils.UMUtils");
            Method declaredMethod = cls.getDeclaredMethod("isMainProgress", Context.class);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                return ((Boolean) declaredMethod.invoke(cls, context)).booleanValue();
            }
        } catch (Throwable unused) {
        }
        return true;
    }

    public static boolean i(Context context) {
        NetworkInfo networkInfo;
        if (context == null) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (networkInfo = connectivityManager.getNetworkInfo(17)) == null) {
                return false;
            }
            return networkInfo.isConnected();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static void a(Context context, String str) {
        SharedPreferences a6;
        SharedPreferences.Editor edit;
        String b6 = b(str);
        if (context == null || b6 == null || TextUtils.isEmpty(b6) || (a6 = a.a(context)) == null || (edit = a6.edit()) == null) {
            return;
        }
        edit.putString(SocializeProtocolConstants.PROTOCOL_KEY_MAC, b6).commit();
    }

    public static void b(Context context, String str) {
        SharedPreferences a6;
        SharedPreferences.Editor edit;
        String b6 = b(str);
        if (context == null || b6 == null || TextUtils.isEmpty(b6) || (a6 = a.a(context)) == null || (edit = a6.edit()) == null) {
            return;
        }
        edit.putString("oaid", b6).commit();
    }

    public static boolean c(String str) {
        return !TextUtils.isEmpty(str) && str.equals(b(a(str)));
    }
}
