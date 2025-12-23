package cn.jpush.android.ad;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import cn.jpush.android.helper.Logger;
import java.io.FileInputStream;
import java.lang.reflect.Method;

/* loaded from: D:\Downloads\app\classes2.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private static String f3479a;

    private static String a() {
        String processName;
        if (Build.VERSION.SDK_INT < 28) {
            return null;
        }
        processName = Application.getProcessName();
        return processName;
    }

    private static String b() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", null);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, null);
            if (invoke instanceof String) {
                return (String) invoke;
            }
            return null;
        } catch (Throwable th) {
            Logger.w("ProcessUtil", "getCurrentProcessNameByActivityThread failed, " + th.getMessage());
            return null;
        }
    }

    private static String c() {
        FileInputStream fileInputStream;
        byte[] bArr;
        int i6;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream("/proc/self/cmdline");
                try {
                    bArr = new byte[256];
                    i6 = 0;
                    while (true) {
                        int read = fileInputStream.read();
                        if (read <= 0 || i6 >= 256) {
                            break;
                        }
                        bArr[i6] = (byte) read;
                        i6++;
                    }
                } catch (Throwable unused) {
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 == null) {
                        return "";
                    }
                    fileInputStream2.close();
                    return "";
                }
            } catch (Throwable unused2) {
            }
            if (i6 <= 0) {
                fileInputStream.close();
                return "";
            }
            String str = new String(bArr, 0, i6, "UTF-8");
            try {
                fileInputStream.close();
            } catch (Throwable unused3) {
            }
            return str;
        } catch (Throwable unused4) {
            return "";
        }
    }

    public static String a(Context context) {
        if (!TextUtils.isEmpty(f3479a)) {
            return f3479a;
        }
        String a6 = a();
        f3479a = a6;
        if (!TextUtils.isEmpty(a6)) {
            return f3479a;
        }
        String b6 = b();
        f3479a = b6;
        if (!TextUtils.isEmpty(b6)) {
            return f3479a;
        }
        String c6 = c();
        f3479a = c6;
        String str = !TextUtils.isEmpty(c6) ? f3479a : "";
        f3479a = str;
        return str;
    }
}
