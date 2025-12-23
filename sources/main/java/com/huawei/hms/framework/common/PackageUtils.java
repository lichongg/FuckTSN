package com.huawei.hms.framework.common;

import android.content.Context;
import android.content.pm.PackageManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class PackageUtils {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33340a = "PackageUtils";

    public static String getVersionName(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionName;
        } catch (PackageManager.NameNotFoundException e6) {
            Logger.w("PackageUtils", "", e6);
            return "";
        }
    }
}
