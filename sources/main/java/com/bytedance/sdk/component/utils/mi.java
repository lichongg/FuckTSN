package com.bytedance.sdk.component.utils;

import java.lang.reflect.Method;

/* loaded from: D:\Downloads\app\classes4.dex */
public class mi {

    /* renamed from: j, reason: collision with root package name */
    private static Object f26891j;
    private static Method xt;

    public static boolean j(String... strArr) {
        Method method;
        Object obj = f26891j;
        if (obj != null && (method = xt) != null) {
            try {
                method.invoke(obj, strArr);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    static {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
            Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            Class cls = (Class) declaredMethod.invoke(null, "dalvik.system.VMRuntime");
            Method method = (Method) declaredMethod2.invoke(cls, "getRuntime", null);
            xt = (Method) declaredMethod2.invoke(cls, "setHiddenApiExemptions", new Class[]{String[].class});
            f26891j = method.invoke(null, null);
        } catch (Throwable th) {
            vl.xt("Reflection", "reflect bootstrap failed:", th);
        }
    }

    public static boolean j() {
        return j("L");
    }
}
