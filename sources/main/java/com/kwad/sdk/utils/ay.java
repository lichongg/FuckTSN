package com.kwad.sdk.utils;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ay {
    private static String bah = "";
    private static volatile Boolean bai;

    private static String Ri() {
        String processName;
        if (Build.VERSION.SDK_INT < 28) {
            return "";
        }
        processName = Application.getProcessName();
        return processName;
    }

    private static String Rj() {
        try {
            Object callStaticMethod = z.callStaticMethod(Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()), "currentProcessName", new Object[0]);
            return callStaticMethod instanceof String ? (String) callStaticMethod : "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    private static String dm(@NonNull Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null) {
            return "";
        }
        int myPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        return "";
    }

    public static String getProcessName(@NonNull Context context) {
        if (!TextUtils.isEmpty(bah)) {
            return bah;
        }
        String Ri = Ri();
        bah = Ri;
        if (!TextUtils.isEmpty(Ri)) {
            return bah;
        }
        String Rj = Rj();
        bah = Rj;
        if (!TextUtils.isEmpty(Rj)) {
            return bah;
        }
        String dm = dm(context);
        bah = dm;
        return dm;
    }

    public static boolean isInMainProcess(Context context) {
        if (bai == null) {
            String processName = getProcessName(context);
            bai = Boolean.valueOf(!TextUtils.isEmpty(processName) && processName.equals(context.getPackageName()));
        }
        return bai.booleanValue();
    }
}
