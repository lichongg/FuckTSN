package cn.jiguang.bz;

import android.app.Application;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: D:\Downloads\app\classes2.dex */
public class t {
    public static Application a() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("getApplication", null).invoke(c(), null);
            if (invoke == null) {
                return null;
            }
            return (Application) invoke;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String b() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", null);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, null);
            if (invoke instanceof String) {
                return (String) invoke;
            }
            return null;
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("ReflectUtils", "getCurrentProcessNameByActivityThread: " + th.getMessage());
            return null;
        }
    }

    private static Object d() {
        try {
            Field declaredField = Class.forName("android.app.ActivityThread").getDeclaredField("sCurrentActivityThread");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("ReflectUtils", "getActivityThreadInActivityThreadStaticField: " + th.getMessage());
            return null;
        }
    }

    private static Object e() {
        try {
            return Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", null).invoke(null, null);
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("ReflectUtils", "getActivityThreadInActivityThreadStaticMethod: " + th.getMessage());
            return null;
        }
    }

    public static Object a(Class<?> cls, String str, Object[] objArr, Class[] clsArr) {
        a(cls);
        a(clsArr, objArr);
        return cls.getMethod(str, clsArr).invoke(cls, objArr);
    }

    public static Object a(Object obj, String str, Object[] objArr, Class[] clsArr) {
        a(obj);
        a(clsArr, objArr);
        return obj.getClass().getMethod(str, clsArr).invoke(obj, objArr);
    }

    private static Object c() {
        Object d6 = d();
        if (d6 != null) {
            return d6;
        }
        return e();
    }

    private static void a(Object obj) {
        if (obj == null) {
            throw new Exception("owner can not be null");
        }
    }

    private static void a(Class<?>[] clsArr, Object[] objArr) {
        if ((objArr != null ? objArr.length : 0) != (clsArr != null ? clsArr.length : 0)) {
            throw new Exception("argClasses' size is not equal to args' size");
        }
    }
}
