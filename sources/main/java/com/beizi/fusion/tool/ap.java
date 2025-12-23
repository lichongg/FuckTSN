package com.beizi.fusion.tool;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.stub.StubApp;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.NetworkInterface;
import java.util.Enumeration;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class ap {

    /* renamed from: a, reason: collision with root package name */
    private static String f13672a = "SystemUtil";

    public static boolean a(Context context, String str) {
        PackageInfo packageInfo;
        if (context == null || str == null || str.isEmpty()) {
            return false;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (Throwable unused) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public static long b(Context context) {
        try {
            PackageInfo packageInfo = PackageUtil.getInstance().getPackageInfo(context);
            if (packageInfo != null) {
                return packageInfo.lastUpdateTime;
            }
            return 0L;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0L;
        }
    }

    public static String c(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getPackageName();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static boolean f(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    public static boolean g(Context context) {
        return Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0;
    }

    public static boolean h(Context context) {
        try {
            String property = System.getProperty("http.proxyHost");
            String property2 = System.getProperty("http.proxyPort");
            if (property2 == null) {
                property2 = "-1";
            }
            return (TextUtils.isEmpty(property) || Integer.parseInt(property2) == -1) ? false : true;
        } catch (Exception e6) {
            e6.printStackTrace();
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static Long o(Context context) {
        if (context == null) {
            return 0L;
        }
        try {
            PackageInfo packageInfo = PackageUtil.getInstance().getPackageInfo(context);
            if (packageInfo != null) {
                return Long.valueOf(packageInfo.lastUpdateTime);
            }
        } catch (Exception unused) {
        }
        return 0L;
    }

    public static long a(Context context) {
        try {
            PackageInfo packageInfo = PackageUtil.getInstance().getPackageInfo(context);
            if (packageInfo != null) {
                return packageInfo.firstInstallTime;
            }
            return 0L;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0L;
        }
    }

    private static boolean c(String str) {
        Process process = null;
        try {
            try {
                process = Runtime.getRuntime().exec("ls -l " + str);
                String readLine = new BufferedReader(new InputStreamReader(process.getInputStream())).readLine();
                if (readLine != null && readLine.length() >= 4) {
                    char charAt = readLine.charAt(3);
                    if (charAt == 's' || charAt == 'x') {
                        process.destroy();
                        return true;
                    }
                }
            } catch (IOException e6) {
                e6.printStackTrace();
                if (process == null) {
                    return false;
                }
            }
            process.destroy();
            return false;
        } catch (Throwable th) {
            if (process != null) {
                process.destroy();
            }
            throw th;
        }
    }

    public static String d(Context context) {
        try {
            PackageInfo packageInfo = PackageUtil.getInstance().getPackageInfo(context);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static int e(Context context) {
        try {
            PackageInfo packageInfo = PackageUtil.getInstance().getPackageInfo(context);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static float i(Context context) {
        float f6 = context.getResources().getDisplayMetrics().density;
        float f7 = context.getResources().getDisplayMetrics().widthPixels;
        if (f6 <= 0.0f) {
            f6 = 1.0f;
        }
        return (f7 / f6) + 0.5f;
    }

    public static float j(Context context) {
        return b(context, context.getResources().getDisplayMetrics().heightPixels);
    }

    public static float k(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static float l(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int m(Context context) {
        return StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources().getDisplayMetrics().widthPixels;
    }

    public static int n(Context context) {
        return StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources().getDisplayMetrics().heightPixels;
    }

    public static boolean b() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if ("tun0".equals(nextElement.getName()) || "ppp0".equals(nextElement.getName())) {
                    return true;
                }
            }
            return false;
        } catch (Exception e6) {
            e6.printStackTrace();
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static String a() {
        return (new File("/system/bin/su").exists() && c("/system/bin/su")) ? "yes" : (new File("/system/xbin/su").exists() && c("/system/xbin/su")) ? "yes" : "no";
    }

    public static int a(Context context, float f6) {
        return (int) ((f6 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static boolean a(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static int b(Context context, float f6) {
        return (int) ((f6 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static void a(View view) {
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
        }
    }

    public static void b(String str) {
        new IllegalArgumentException(str).printStackTrace();
    }
}
