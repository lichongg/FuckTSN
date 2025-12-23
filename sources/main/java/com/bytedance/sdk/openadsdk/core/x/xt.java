package com.bytedance.sdk.openadsdk.core.x;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.bytedance.sdk.component.utils.vl;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {
    public static int j(Context context, String str) {
        if (str == null) {
            throw new IllegalArgumentException("permission is null");
        }
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        } catch (Throwable th) {
            vl.j(th);
            return Build.VERSION.SDK_INT >= 23 ? -1 : 0;
        }
    }

    public static void requestPermissions(Activity activity, String[] strArr, int i6) {
        if (Build.VERSION.SDK_INT >= 23) {
            activity.requestPermissions(strArr, i6);
        }
    }
}
