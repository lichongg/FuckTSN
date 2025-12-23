package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.os.Process;

/* loaded from: D:\Downloads\app\classes6.dex */
public final class dm {

    /* renamed from: a, reason: collision with root package name */
    private static a f36017a;

    public enum a {
        UNKNOWN,
        ARMEABI_V7A,
        ARM64_V8A
    }

    public static boolean b(Context context) {
        return c(context) == a.ARM64_V8A;
    }

    private static a c(Context context) {
        boolean is64Bit;
        a aVar = f36017a;
        if (aVar != null) {
            return aVar;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            is64Bit = Process.is64Bit();
            f36017a = is64Bit ? a.ARM64_V8A : a.ARMEABI_V7A;
        } else {
            try {
                Class<?> cls = Class.forName("dalvik.system.VMRuntime");
                f36017a = ((Boolean) cls.getDeclaredMethod("is64Bit", null).invoke(cls.getDeclaredMethod("getRuntime", null).invoke(cls, null), null)).booleanValue() ? a.ARM64_V8A : a.ARMEABI_V7A;
            } catch (Throwable th) {
                th.printStackTrace();
                try {
                    if (context.getApplicationInfo().nativeLibraryDir.contains("arm64")) {
                        f36017a = a.ARM64_V8A;
                    } else {
                        f36017a = a.UNKNOWN;
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    f36017a = a.UNKNOWN;
                }
            }
        }
        return f36017a;
    }

    private dm() {
    }

    public static String a(Context context) {
        if (b(context)) {
            return "arm64-v8a";
        }
        return "armeabi-v7a";
    }
}
