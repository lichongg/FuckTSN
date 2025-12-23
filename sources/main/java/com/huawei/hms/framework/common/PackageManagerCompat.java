package com.huawei.hms.framework.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class PackageManagerCompat {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33337a = "PackageUtils";

    /* renamed from: b, reason: collision with root package name */
    private static final String f33338b = "7.0.2.301";

    /* renamed from: c, reason: collision with root package name */
    private static String f33339c = "";

    private static Bundle a(Context context) {
        PackageManager packageManager;
        Bundle bundle = Bundle.EMPTY;
        if (ContextHolder.getAppContext() != null) {
            context = ContextHolder.getAppContext();
        }
        if (context != null && (packageManager = context.getPackageManager()) != null) {
            try {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128);
                if (applicationInfo != null) {
                    Bundle bundle2 = applicationInfo.metaData;
                    if (bundle2 != null) {
                        return bundle2;
                    }
                }
            } catch (PackageManager.NameNotFoundException | RuntimeException e6) {
                Logger.w("PackageUtils", "NameNotFoundException:", e6);
                return bundle;
            }
        }
        return bundle;
    }

    public static String getAppVersion(Context context) {
        if (!TextUtils.isEmpty(f33339c)) {
            return f33339c;
        }
        if (ContextHolder.getAppContext() != null) {
            context = ContextHolder.getAppContext();
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return f33339c;
        }
        try {
            f33339c = String.valueOf(packageManager.getPackageInfo(context.getPackageName(), 16384).versionCode);
        } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            Logger.w("PackageUtils", "Failed to get Package managers Package Info");
        }
        return f33339c;
    }

    public static Map<String, String> getMetaDataMapFromKitOrApp(Context context, String str) {
        HashMap hashMap = new HashMap();
        Bundle c6 = c(context);
        for (String str2 : c6.keySet()) {
            if (str2.startsWith(str)) {
                String string = c6.getString(str2);
                if (!TextUtils.isEmpty(string)) {
                    hashMap.put(str2.substring(str.length()), string);
                }
            }
        }
        return hashMap;
    }

    private static Bundle b(Context context) {
        if (ContextHolder.getKitContext() != null) {
            context = ContextHolder.getKitContext();
        }
        if (context == null) {
            Logger.v("PackageUtils", "the kitContext is null");
            return Bundle.EMPTY;
        }
        if (context.getApplicationInfo() == null) {
            Logger.v("PackageUtils", "the kit applicationInfo is null");
            return Bundle.EMPTY;
        }
        Logger.i("PackageUtils", "kitContext: " + context.getPackageName());
        Bundle bundle = context.getApplicationInfo().metaData;
        if (bundle == null) {
            return Bundle.EMPTY;
        }
        return bundle;
    }

    private static Bundle c(Context context) {
        Bundle b6 = b(context);
        if (b6 != null && !b6.isEmpty()) {
            return b6;
        }
        return a(context);
    }

    public static String getAppPackageName(Context context) {
        if (ContextHolder.getAppContext() != null) {
            context = ContextHolder.getAppContext();
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return "";
        }
        try {
            return packageManager.getPackageInfo(context.getPackageName(), 16384).packageName;
        } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            Logger.w("PackageUtils", "Failed to get Package managers Package Info");
            return "";
        }
    }

    public static String getMetaDataFromApp(Context context, String str, String str2) {
        Bundle a6 = a(context);
        if (a6 != null) {
            return a6.getString(str, str2);
        }
        return str2;
    }

    public static String getMetaDataFromKit(Context context, String str, String str2) {
        try {
            Bundle b6 = b(context);
            if (b6 == null) {
                return str2;
            }
            return b6.getString(str, str2);
        } catch (RuntimeException unused) {
            Logger.v("PackageUtils", "the kit metaData is runtimeException");
            return str2;
        }
    }

    public static String getMetaDataFromKitOrApp(Context context, String str, String str2) {
        return c(context).getString(str, str2);
    }
}
