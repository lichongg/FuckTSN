package com.bytedance.sdk.component.panglearmor;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Process;

/* loaded from: D:\Downloads\app\classes4.dex */
public class oq {
    public static int j(Context context, String str) {
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        } catch (Throwable unused) {
            return Build.VERSION.SDK_INT >= 23 ? -1 : 0;
        }
    }

    public static boolean j(Context context) {
        ApplicationInfo applicationInfo;
        return (context == null || (applicationInfo = context.getApplicationInfo()) == null || (applicationInfo.flags & 1) <= 0) ? false : true;
    }
}
