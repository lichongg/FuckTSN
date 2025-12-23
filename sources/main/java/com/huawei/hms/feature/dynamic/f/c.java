package com.huawei.hms.feature.dynamic.f;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.huawei.hms.common.util.Logger;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static final String f33244a = "HMSPkgManager";

    /* renamed from: b, reason: collision with root package name */
    public static final List<String> f33245b = new a();

    /* renamed from: c, reason: collision with root package name */
    public static final int f33246c = 8;

    /* renamed from: d, reason: collision with root package name */
    public static final int f33247d = 4;

    /* renamed from: e, reason: collision with root package name */
    public static final int f33248e = 5;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class b implements PrivilegedAction {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Field f33249a;

        public b(Field field) {
            this.f33249a = field;
        }

        @Override // java.security.PrivilegedAction
        public Object run() {
            this.f33249a.setAccessible(true);
            return null;
        }
    }

    public static boolean a(Context context) {
        if (context == null) {
            Logger.e(f33244a, "The given context is null.");
            return false;
        }
        for (String str : f33245b) {
            try {
            } catch (PackageManager.NameNotFoundException unused) {
                Logger.w(f33244a, "Query for HMS Core package name:" + str + " failed.");
            }
            if (context.getPackageManager().getPackageInfo(str, 0) != null) {
                Logger.i(f33244a, "The HMS Core is installed, pkgName:" + str);
                return true;
            }
            continue;
        }
        return false;
    }

    public static boolean c(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            Logger.w(f33244a, "context is null or pkgName is null.");
            return false;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
            boolean z5 = (packageInfo == null || (packageInfo.applicationInfo.flags & 1) == 0) ? false : true;
            Logger.i(f33244a, "isHMSSystemApp:" + z5);
            if (z5) {
                Logger.i(f33244a, "The HMS package:" + str + " is SystemApp");
                return true;
            }
        } catch (PackageManager.NameNotFoundException e6) {
            Logger.e(f33244a, "getSystemApp flag error for " + str + ":" + e6.getMessage());
        }
        return false;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a extends ArrayList<String> {
        public a() {
            add("com.huawei.hwid");
            add("com.huawei.hwid.tv");
        }
    }

    public static boolean a(Context context, String str) {
        String str2;
        if (context == null || TextUtils.isEmpty(str)) {
            Logger.e(f33244a, "context is null or filePath is null.");
            return false;
        }
        try {
        } catch (IOException unused) {
            Logger.e(f33244a, "checkPathValidity IOException");
        }
        if (!new File(str).exists()) {
            Logger.w(f33244a, "the file does not exist.");
            return false;
        }
        String canonicalPath = new File(str).getCanonicalPath();
        if (canonicalPath.startsWith("/system/app/HFF")) {
            Logger.i(f33244a, "HFF file path, need not to verify.");
            return true;
        }
        if (canonicalPath.startsWith("/data/data/")) {
            String[] split = canonicalPath.split("/");
            if (split.length >= 4) {
                str2 = split[3];
            }
            return false;
        }
        if (!canonicalPath.startsWith("/data/user_de/") && !canonicalPath.startsWith("/data/user/")) {
            Logger.w(f33244a, "illegal path.");
            return false;
        }
        String[] split2 = canonicalPath.split("/");
        if (split2.length >= 5) {
            str2 = split2[4];
        }
        return false;
        return b(context, str2);
    }

    public static boolean b(Context context, String str) {
        PackageInfo packageInfo;
        ApplicationInfo applicationInfo;
        if (context == null || TextUtils.isEmpty(str)) {
            Logger.e(f33244a, "context is null or pkgName is null.");
            return false;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (PackageManager.NameNotFoundException e6) {
            Logger.e(f33244a, "get PrivAppFlag err for " + str + ":" + e6.getMessage());
            packageInfo = null;
        }
        if (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null) {
            Logger.i(f33244a, "Get pkg application null:" + str);
            return false;
        }
        try {
            Field field = applicationInfo.getClass().getField("privateFlags");
            AccessController.doPrivileged(new b(field));
            Object obj = field.get(applicationInfo);
            if (!(obj instanceof Integer)) {
                Logger.i(f33244a, "Get privFlag instance error.");
                return false;
            }
            int intValue = ((Integer) obj).intValue();
            Logger.d(f33244a, "privFlag of " + str + " is:" + intValue);
            boolean z5 = (intValue & 8) != 0;
            Logger.i(f33244a, "pkgName:" + str + ", isPrivApp:" + z5);
            return z5;
        } catch (IllegalAccessException e7) {
            e = e7;
            Logger.e(f33244a, "get Priv App Flag err for " + str + ":" + e.getMessage());
            return false;
        } catch (NoSuchFieldException e8) {
            e = e8;
            Logger.e(f33244a, "get Priv App Flag err for " + str + ":" + e.getMessage());
            return false;
        }
    }
}
