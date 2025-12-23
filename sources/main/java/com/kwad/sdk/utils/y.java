package com.kwad.sdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class y {
    private static long mLastCallTime;
    private static long packageInfoLimiter;
    private static HashMap<String, PackageInfo> sPackageInfoHashMap;
    public static String[] requestedPermissions = new String[0];
    public static AtomicBoolean mHasInit = new AtomicBoolean(false);

    public static PackageInfo getPackageInfo(Context context, String str, int i6) {
        HashMap<String, PackageInfo> hashMap;
        PackageInfo packageInfo;
        try {
            init(context);
            hashMap = sPackageInfoHashMap;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
        if (hashMap != null && hashMap.containsKey(str)) {
            return sPackageInfoHashMap.get(str);
        }
        if (!shouldCall()) {
            com.kwad.sdk.core.d.c.d("PackageInfoLimiter", "调用频次过高，跳过本次调用");
            return null;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, i6);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        HashMap<String, PackageInfo> hashMap2 = sPackageInfoHashMap;
        if (hashMap2 != null) {
            hashMap2.put(str, packageInfo);
        }
        return packageInfo;
    }

    public static PackageInfo getPackageInfoNoCache(Context context, String str, int i6) {
        PackageInfo packageInfo;
        try {
            init(context);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
        if (!shouldCall()) {
            com.kwad.sdk.core.d.c.d("PackageInfoLimiter", "调用频次过高，跳过本次调用");
            return null;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        HashMap<String, PackageInfo> hashMap = sPackageInfoHashMap;
        if (hashMap != null) {
            hashMap.put(str, packageInfo);
        }
        return packageInfo;
    }

    @Nullable
    public static String[] cN(Context context) {
        String[] strArr = requestedPermissions;
        if (strArr != null && strArr.length > 0) {
            return strArr;
        }
        try {
            PackageInfo packageInfo = getPackageInfo(context, context.getPackageName(), 4096);
            if (packageInfo == null) {
                return null;
            }
            String[] strArr2 = packageInfo.requestedPermissions;
            requestedPermissions = strArr2;
            return strArr2;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return null;
        }
    }

    private static void init(Context context) {
        if (mHasInit.compareAndSet(false, true)) {
            long j6 = context.getSharedPreferences("ksadsdk_config", 0).getLong("packageInfoLimiter", 0L);
            packageInfoLimiter = j6;
            if (j6 > 0) {
                sPackageInfoHashMap = new HashMap<>();
            }
        }
    }

    private static synchronized boolean shouldCall() {
        synchronized (y.class) {
            if (packageInfoLimiter <= 0) {
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - mLastCallTime <= packageInfoLimiter) {
                return false;
            }
            mLastCallTime = currentTimeMillis;
            return true;
        }
    }

    @RequiresApi(api = 26)
    public static boolean cM(Context context) {
        boolean canRequestPackageInstalls;
        try {
            init(context);
            canRequestPackageInstalls = context.getPackageManager().canRequestPackageInstalls();
            return canRequestPackageInstalls;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return false;
        }
    }
}
