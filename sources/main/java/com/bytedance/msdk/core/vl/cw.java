package com.bytedance.msdk.core.vl;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.vl;

/* loaded from: D:\Downloads\app\classes3.dex */
public class cw {
    public static int j(@NonNull Context context, @NonNull String str) {
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

    public static void requestPermissions(@NonNull Activity activity, @NonNull String[] strArr, int i6) {
        if (Build.VERSION.SDK_INT >= 23) {
            activity.requestPermissions(strArr, i6);
        }
    }
}
