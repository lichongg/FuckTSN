package com.umeng.socialize.a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.Closeable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static String f42208a;

    /* renamed from: b, reason: collision with root package name */
    public static String f42209b;

    /* renamed from: c, reason: collision with root package name */
    public static String f42210c;

    public static String a() {
        if (TextUtils.isEmpty(f42208a)) {
            String str = Build.BRAND;
            f42208a = str;
            if (TextUtils.isEmpty(str)) {
                f42208a = Build.MANUFACTURER;
            }
        }
        return f42208a;
    }

    public static String b() {
        if (TextUtils.isEmpty(f42209b)) {
            f42209b = Build.MODEL;
        }
        return f42209b;
    }

    public static String c() {
        if (TextUtils.isEmpty(f42210c)) {
            f42210c = Build.BOARD;
        }
        return f42210c;
    }

    public static boolean b(Context context) {
        return UMUtils.checkPermission(context, "android.permission.QUERY_ALL_PACKAGES");
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static Object a(Object obj, String str, int i6) {
        try {
            return ((PackageManager) obj).getPackageInfo(str, i6);
        } catch (Throwable th) {
            if (!a.f42199c) {
                return null;
            }
            UMRTLog.e("MISC", "pkg:" + str + " failed:" + th.getMessage());
            return null;
        }
    }

    public static boolean a(Context context) {
        return UMUtils.isMainProgress(context);
    }
}
