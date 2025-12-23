package com.bytedance.pangle.up;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.sdk.openadsdk.api.m;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r {

    /* renamed from: j, reason: collision with root package name */
    private static String f25539j;
    private static List<String> xt = new CopyOnWriteArrayList();

    private static String j() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int read = bufferedReader.read();
                    if (read <= 0) {
                        break;
                    }
                    sb.append((char) read);
                }
                if (ZeusLogger.isDebug()) {
                    ZeusLogger.d("Process", "get processName = " + sb.toString());
                }
                String sb2 = sb.toString();
                try {
                    bufferedReader.close();
                } catch (Exception unused) {
                }
                return sb2;
            } catch (Throwable unused2) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused3) {
                    }
                }
                return null;
            }
        } catch (Throwable unused4) {
            bufferedReader = null;
        }
    }

    public static boolean xt(Context context) {
        String j6 = j(context);
        if ((j6 != null && j6.contains(":")) || j6 == null || !j6.equals(context.getPackageName())) {
            return false;
        }
        return true;
    }

    public static String j(Context context) {
        String processName;
        if (!TextUtils.isEmpty(f25539j)) {
            return f25539j;
        }
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                processName = Application.getProcessName();
                if (!TextUtils.isEmpty(processName)) {
                    f25539j = processName;
                }
                return f25539j;
            }
        } catch (Throwable unused) {
        }
        try {
            Object invokeStaticMethod = MethodUtils.invokeStaticMethod(Class.forName("android.app.ActivityThread"), "currentProcessName", new Object[0]);
            if (!TextUtils.isEmpty((String) invokeStaticMethod)) {
                f25539j = (String) invokeStaticMethod;
            }
            return f25539j;
        } catch (Exception e6) {
            m.j(e6);
            String j6 = j();
            f25539j = j6;
            return j6;
        }
    }

    public static String j(String str) {
        if (!TextUtils.isEmpty(str) && str.contains(":")) {
            return str.split(":")[1];
        }
        return "main";
    }
}
