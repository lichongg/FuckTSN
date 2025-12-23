package com.qq.e.comm.managers.plugin;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class i {

    /* renamed from: a, reason: collision with root package name */
    private static volatile String f36789a;

    public static synchronized String a(String str) {
        synchronized (i.class) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return str;
                }
                String str2 = f36789a;
                if (TextUtils.isEmpty(str2)) {
                    return str;
                }
                boolean endsWith = str2.endsWith("_");
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(endsWith ? "" : "_");
                sb.append(d.a(str2));
                return sb.toString();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static synchronized String a(Context context) {
        ActivityManager.RunningAppProcessInfo next;
        String processName;
        synchronized (i.class) {
            if (!TextUtils.isEmpty(f36789a)) {
                return f36789a;
            }
            if (Build.VERSION.SDK_INT >= 28) {
                processName = Application.getProcessName();
                f36789a = processName;
                return f36789a;
            }
            int myPid = Process.myPid();
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                while (it.hasNext()) {
                    try {
                        next = it.next();
                    } catch (Exception unused) {
                    }
                    if (next.pid == myPid) {
                        f36789a = next.processName;
                        return f36789a;
                    }
                    continue;
                }
            }
            return null;
        }
    }
}
