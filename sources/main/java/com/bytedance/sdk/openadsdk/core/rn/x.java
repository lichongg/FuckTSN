package com.bytedance.sdk.openadsdk.core.rn;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class x {
    private static Method cw;

    /* renamed from: j, reason: collision with root package name */
    private static Method f30174j;
    private static Method xt;

    public static Object j(Object obj, String str, String str2, Object obj2) {
        Field j6;
        try {
            j6 = j(str, str2);
        } catch (IllegalAccessException unused) {
        }
        if (j6 == null) {
            return obj2;
        }
        j6.setAccessible(true);
        return j6.get(obj);
    }

    static {
        try {
            f30174j = Class.class.getDeclaredMethod("forName", String.class);
            xt = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            cw = Class.class.getDeclaredMethod("getDeclaredField", String.class);
        } catch (NoSuchMethodException | NullPointerException unused) {
        }
    }

    public static Field j(String str, String str2) {
        if (!j()) {
            return null;
        }
        try {
            Field field = (Field) cw.invoke((Class) f30174j.invoke(null, str), str2);
            try {
                field.setAccessible(true);
                return field;
            } catch (Throwable unused) {
                return field;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    private static boolean j() {
        return (f30174j == null || xt == null || cw == null) ? false : true;
    }
}
