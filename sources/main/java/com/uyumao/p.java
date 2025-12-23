package com.uyumao;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    public final String f42611a;

    /* renamed from: b, reason: collision with root package name */
    public final String f42612b;

    /* renamed from: c, reason: collision with root package name */
    public final String f42613c;

    /* renamed from: d, reason: collision with root package name */
    public final long f42614d;

    /* renamed from: e, reason: collision with root package name */
    public final long f42615e;

    /* renamed from: f, reason: collision with root package name */
    public final int f42616f;

    public final int a(PackageInfo packageInfo) {
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        if (applicationInfo == null) {
            return -1;
        }
        int i6 = applicationInfo.flags;
        return ((i6 & 1) == 0 && (i6 & 128) == 0) ? 1 : 0;
    }

    public p(Object obj, Object obj2) {
        String str;
        PackageManager packageManager = (PackageManager) obj;
        PackageInfo packageInfo = (PackageInfo) obj2;
        this.f42611a = packageInfo.packageName;
        this.f42613c = packageInfo.versionName;
        this.f42614d = packageInfo.firstInstallTime;
        this.f42615e = packageInfo.lastUpdateTime;
        this.f42616f = a(packageInfo);
        try {
            str = String.valueOf(packageManager.getApplicationLabel(packageInfo.applicationInfo));
        } catch (Throwable unused) {
            str = "";
        }
        this.f42612b = str;
    }
}
