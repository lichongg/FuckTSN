package com.snail.antifake.deviceid;

import android.app.ActivityManager;
import android.app.Application;
import android.os.Process;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.lang.Thread;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class c implements Thread.UncaughtExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    private Application f37530a;

    public c(Application application) {
        this.f37530a = application;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        Process.killProcess(Process.myPid());
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) this.f37530a.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == Process.myPid()) {
                if (!this.f37530a.getPackageName().equals(runningAppProcessInfo.processName)) {
                    Process.killProcess(Process.myPid());
                    return;
                }
                return;
            }
        }
    }
}
