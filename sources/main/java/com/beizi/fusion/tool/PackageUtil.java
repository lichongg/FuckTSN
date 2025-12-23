package com.beizi.fusion.tool;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class PackageUtil {
    private static PackageUtil instance;
    private volatile PackageInfo mPackageInfo;

    public static synchronized PackageUtil getInstance() {
        PackageUtil packageUtil;
        synchronized (PackageUtil.class) {
            try {
                if (instance == null) {
                    synchronized (PackageUtil.class) {
                        instance = new PackageUtil();
                    }
                }
                packageUtil = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return packageUtil;
    }

    public PackageInfo getPackageInfo(Context context) {
        if (this.mPackageInfo == null) {
            synchronized (PackageUtil.class) {
                if (this.mPackageInfo == null) {
                    try {
                        this.mPackageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                    } catch (PackageManager.NameNotFoundException e6) {
                        e6.printStackTrace();
                        this.mPackageInfo = null;
                    }
                }
            }
        }
        return this.mPackageInfo;
    }
}
