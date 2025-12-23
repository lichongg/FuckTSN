package com.bytedance.j.xt.tl;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.vl;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

/* loaded from: D:\Downloads\app\classes3.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    private static String f24240a;

    private static String a() {
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
                String sb2 = sb.toString();
                try {
                    bufferedReader.close();
                } catch (IOException unused) {
                }
                return sb2;
            } catch (Throwable unused2) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException unused3) {
                    }
                }
                return null;
            }
        } catch (Throwable unused4) {
            bufferedReader = null;
        }
    }

    private static String d() {
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

    private static String b() {
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

    public static String c(Context context) {
        if (!TextUtils.isEmpty(f24240a)) {
            return f24240a;
        }
        String b6 = b();
        f24240a = b6;
        if (!TextUtils.isEmpty(b6)) {
            return f24240a;
        }
        String d6 = d();
        f24240a = d6;
        if (!TextUtils.isEmpty(d6)) {
            return f24240a;
        }
        String a6 = a();
        f24240a = a6;
        return a6;
    }
}
