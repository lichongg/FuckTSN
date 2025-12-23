package com.beizi.ad.lance.a;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import com.beizi.fusion.tool.PackageUtil;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    private static String f12763a = "SystemUtil";

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

    public static String b(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            return packageManager != null ? String.valueOf(packageManager.getPackageInfo("com.huawei.appmarket", 0).versionCode) : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String c(Context context) {
        return String.valueOf(context.getResources().getDisplayMetrics().widthPixels);
    }

    public static String j(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo.totalMem + "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static int d(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static String e(Context context) {
        return String.valueOf(context.getResources().getDisplayMetrics().heightPixels);
    }

    public static int f(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int g(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int h(Context context) {
        float f6 = context.getResources().getDisplayMetrics().density;
        float f7 = context.getResources().getDisplayMetrics().widthPixels;
        if (f6 <= 0.0f) {
            f6 = 1.0f;
        }
        return (int) ((f7 / f6) + 0.5f);
    }

    public static String i(Context context) {
        if (context.getResources().getConfiguration().orientation == 2) {
            return "2";
        }
        return "1";
    }

    public static String k(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID);
        if (string != null) {
            return string;
        }
        return "";
    }

    public static String a(Context context, String str) {
        try {
            int i6 = context.getPackageManager().getPackageInfo(str, 0).versionCode;
            if (i6 != 0) {
                return String.valueOf(i6);
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static long c() {
        Long l6 = 0L;
        switch (Calendar.getInstance().get(7)) {
            case 1:
            case 2:
            case 4:
            case 6:
                l6 = Long.valueOf(System.currentTimeMillis() / 1000);
                break;
            case 3:
            case 5:
            case 7:
                l6 = Long.valueOf(System.currentTimeMillis());
                break;
        }
        return l6.longValue();
    }

    public static String b(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String a() {
        return (new File("/system/bin/su").exists() && a("/system/bin/su")) ? "yes" : (new File("/system/xbin/su").exists() && a("/system/xbin/su")) ? "yes" : "no";
    }

    public static String b() {
        try {
            if (!Environment.getExternalStorageState().equals("mounted")) {
                return "";
            }
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            long blockSize = statFs.getBlockSize();
            return (statFs.getBlockCount() * blockSize) + "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    private static boolean a(String str) {
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
}
