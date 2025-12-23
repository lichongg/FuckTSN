package com.bytedance.android.openliveplugin.process;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.api.m;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.stub.StubApp;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public class LiveProcessUtils {
    private static String currentProcessName;

    private static String getCurrentProcessNameByActivityManager(Context context) {
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

    private static String getCurrentProcessNameByActivityThread() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", null);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, null);
            if (invoke instanceof String) {
                return (String) invoke;
            }
            return null;
        } catch (Throwable th) {
            m.j(th);
            return null;
        }
    }

    public static String getCurrentProcessName(Context context) {
        if (!TextUtils.isEmpty(currentProcessName)) {
            return currentProcessName;
        }
        String currentProcessNameByApplication = getCurrentProcessNameByApplication();
        currentProcessName = currentProcessNameByApplication;
        if (!TextUtils.isEmpty(currentProcessNameByApplication)) {
            return currentProcessName;
        }
        String currentProcessNameByActivityThread = getCurrentProcessNameByActivityThread();
        currentProcessName = currentProcessNameByActivityThread;
        if (!TextUtils.isEmpty(currentProcessNameByActivityThread)) {
            return currentProcessName;
        }
        String currentProcessNameByActivityManager = getCurrentProcessNameByActivityManager(context);
        currentProcessName = currentProcessNameByActivityManager;
        return currentProcessNameByActivityManager;
    }

    private static String getCurrentProcessNameByApplication() {
        String processName;
        if (Build.VERSION.SDK_INT < 28) {
            return null;
        }
        try {
            processName = Application.getProcessName();
            return processName;
        } catch (Exception e6) {
            m.j(e6);
            return null;
        }
    }

    public static Boolean inLiveProcess(Context context) {
        return (context == null || StubApp.getOrigApplicationContext(context.getApplicationContext()) == null) ? Boolean.FALSE : Boolean.valueOf(getCurrentProcessName(context).endsWith(":bytelive"));
    }

    public static boolean isMainProcess(Context context) {
        if (context == null || StubApp.getOrigApplicationContext(context.getApplicationContext()) == null) {
            return false;
        }
        return TextUtils.equals(StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageName(), getCurrentProcessName(context));
    }
}
