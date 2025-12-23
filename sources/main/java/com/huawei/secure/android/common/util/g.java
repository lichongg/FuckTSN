package com.huawei.secure.android.common.util;

import android.text.TextUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class g {
    private static boolean a(String str) {
        String[] strArr = {"java.io.FileNotFoundException", "java.util.jar.JarException", "java.util.MissingResourceException", "java.security.acl.NotOwnerException", "java.util.ConcurrentModificationException", "javax.naming.InsufficientResourcesException", "java.net.BindException", "java.lang.OutOfMemoryError", "java.lang.StackOverflowError", "java.sql.SQLException"};
        for (int i6 = 0; i6 < 10; i6++) {
            if (str.contains(strArr[i6])) {
                return true;
            }
        }
        return false;
    }

    public static String b(String str, Throwable th) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            sb.append(" ");
        }
        sb.append("Exception: ");
        sb.append(th.getClass().getName());
        sb.append('\n');
        if (!a(th.getClass().getCanonicalName())) {
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace == null) {
                sb.append("Stack trace is NULL!");
                sb.append('\n');
            } else {
                for (StackTraceElement stackTraceElement : stackTrace) {
                    sb.append(stackTraceElement.toString());
                    sb.append('\n');
                }
            }
        }
        return sb.toString();
    }

    public static void c(String str, String str2, Throwable th) {
        if (th == null) {
            return;
        }
        b(str2, th);
    }
}
