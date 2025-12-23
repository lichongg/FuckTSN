package com.uyumao;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.stub.StubApp;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileReader;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    public static String f42603a = null;

    /* renamed from: b, reason: collision with root package name */
    public static String f42604b = null;

    /* renamed from: c, reason: collision with root package name */
    public static String f42605c = null;

    /* renamed from: d, reason: collision with root package name */
    public static String f42606d = "";

    public static String a() {
        if (TextUtils.isEmpty(f42605c)) {
            f42605c = Build.BOARD;
        }
        return f42605c;
    }

    public static String b() {
        if (TextUtils.isEmpty(f42603a)) {
            String str = Build.BRAND;
            f42603a = str;
            if (TextUtils.isEmpty(str)) {
                f42603a = Build.MANUFACTURER;
            }
        }
        return f42603a;
    }

    public static String c() {
        if (TextUtils.isEmpty(f42604b)) {
            f42604b = Build.MODEL;
        }
        return f42604b;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean c(Context context) {
        try {
            String b6 = b(context);
            String packageName = StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageName();
            if (TextUtils.isEmpty(b6) || TextUtils.isEmpty(packageName)) {
                return false;
            }
            return b6.equals(packageName);
        } catch (Exception unused) {
            return false;
        }
    }

    public static Object a(Object obj, String str, int i6) {
        try {
            return ((PackageManager) obj).getPackageInfo(str, i6);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String b(Context context) {
        String str;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (TextUtils.isEmpty(f42606d)) {
            try {
                if (Build.VERSION.SDK_INT >= 28) {
                    str = Application.getProcessName();
                } else {
                    str = "";
                }
                if (TextUtils.isEmpty(str)) {
                    int myPid = Process.myPid();
                    String a6 = a(myPid);
                    if (!TextUtils.isEmpty(a6)) {
                        f42606d = a6;
                    } else {
                        ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
                        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null && runningAppProcesses.size() > 0) {
                            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                ActivityManager.RunningAppProcessInfo next = it.next();
                                if (next.pid == myPid) {
                                    f42606d = next.processName;
                                    break;
                                }
                            }
                        }
                    }
                } else {
                    f42606d = str;
                }
            } catch (Throwable unused) {
            }
        }
        return f42606d;
    }

    public static String a(int i6) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/" + i6 + "/cmdline"));
        } catch (Throwable unused) {
            bufferedReader = null;
        }
        try {
            String readLine = bufferedReader.readLine();
            if (!TextUtils.isEmpty(readLine)) {
                readLine = readLine.trim();
            }
            try {
                bufferedReader.close();
            } catch (Throwable unused2) {
            }
            return readLine;
        } catch (Throwable unused3) {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Throwable unused4) {
                }
            }
            return null;
        }
    }

    public static boolean a(Context context) {
        return UMUtils.checkPermission(context, "android.permission.QUERY_ALL_PACKAGES");
    }
}
