package com.umeng.socialize.a;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class f {

    /* renamed from: a, reason: collision with root package name */
    final String f42218a;

    /* renamed from: b, reason: collision with root package name */
    final String f42219b;

    /* renamed from: c, reason: collision with root package name */
    final String f42220c;

    /* renamed from: d, reason: collision with root package name */
    final long f42221d;

    /* renamed from: e, reason: collision with root package name */
    final long f42222e;

    /* renamed from: f, reason: collision with root package name */
    final int f42223f;

    private int a(PackageInfo packageInfo) {
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        if (applicationInfo == null) {
            return -1;
        }
        int i6 = applicationInfo.flags;
        return ((i6 & 1) == 0 && (i6 & 128) == 0) ? 1 : 0;
    }

    public f(Object obj, Object obj2) {
        String str;
        PackageManager packageManager = (PackageManager) obj;
        PackageInfo packageInfo = (PackageInfo) obj2;
        this.f42218a = packageInfo.packageName;
        this.f42220c = packageInfo.versionName;
        this.f42221d = packageInfo.firstInstallTime;
        this.f42222e = packageInfo.lastUpdateTime;
        this.f42223f = a(packageInfo);
        try {
            str = String.valueOf(packageManager.getApplicationLabel(packageInfo.applicationInfo));
        } catch (Throwable unused) {
            str = "";
        }
        this.f42219b = str;
    }
}
