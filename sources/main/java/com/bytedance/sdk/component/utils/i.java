package com.bytedance.sdk.component.utils;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.stub.StubApp;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class i {

    /* renamed from: j, reason: collision with root package name */
    private static String f26885j;

    private static String cw(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null) {
            return null;
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
        return null;
    }

    public static boolean j(Context context) {
        if (context == null || StubApp.getOrigApplicationContext(context.getApplicationContext()) == null) {
            return false;
        }
        return TextUtils.equals(StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageName(), xt(context));
    }

    public static String xt(Context context) {
        if (!TextUtils.isEmpty(f26885j)) {
            return f26885j;
        }
        String j6 = j();
        f26885j = j6;
        if (!TextUtils.isEmpty(j6)) {
            return f26885j;
        }
        String xt = xt();
        f26885j = xt;
        if (!TextUtils.isEmpty(xt)) {
            return f26885j;
        }
        String cw = cw(context);
        f26885j = cw;
        return cw;
    }

    private static String j() {
        String processName;
        if (Build.VERSION.SDK_INT < 28) {
            return null;
        }
        try {
            processName = Application.getProcessName();
            return processName;
        } catch (Exception e6) {
            vl.j(e6);
            return null;
        }
    }

    private static String xt() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, null);
            if (invoke instanceof String) {
                return (String) invoke;
            }
            return null;
        } catch (Throwable th) {
            vl.j(th);
            return null;
        }
    }
}
