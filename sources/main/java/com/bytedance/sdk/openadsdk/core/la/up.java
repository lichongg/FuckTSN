package com.bytedance.sdk.openadsdk.core.la;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.bytedance.sdk.component.utils.vl;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up {
    @SuppressLint({"PackageManagerGetSignatures"})
    public static byte[] j(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        if (context.getPackageName().equalsIgnoreCase(str)) {
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 64);
                if (packageInfo.packageName.equals(str)) {
                    return packageInfo.signatures[0].toByteArray();
                }
            } catch (PackageManager.NameNotFoundException e6) {
                vl.j(e6);
            }
        }
        return null;
    }
}
