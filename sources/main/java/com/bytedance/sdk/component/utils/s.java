package com.bytedance.sdk.component.utils;

import android.text.TextUtils;
import java.lang.reflect.Method;

/* loaded from: D:\Downloads\app\classes4.dex */
public class s {
    public static Method j(String str, String str2, Class<?>... clsArr) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                Class<?> j6 = j(str);
                if (j6 != null) {
                    return j6.getMethod(str2, clsArr);
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static Class<?> j(String str) {
        try {
            try {
                try {
                    return Class.forName(str, true, j());
                } catch (ClassNotFoundException unused) {
                    return Class.forName(str, true, s.class.getClassLoader());
                }
            } catch (ClassNotFoundException unused2) {
                return null;
            }
        } catch (ClassNotFoundException unused3) {
            return Class.forName(str);
        }
    }

    private static ClassLoader j() {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        return contextClassLoader == null ? s.class.getClassLoader() : contextClassLoader;
    }
}
