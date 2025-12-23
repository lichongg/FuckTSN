package com.bytedance.pangle.xt.j;

import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.FieldUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    private static Map<String, Field> f25563j = new HashMap();
    private static Map<String, Method> xt = new HashMap();
    private static Map<String, Constructor> cw = new HashMap();

    /* renamed from: r, reason: collision with root package name */
    private static Map<String, Class> f25564r = new HashMap();

    public static Field j(Class<?> cls, String str) {
        Field field;
        String xt2 = xt(cls, str);
        synchronized (f25563j) {
            field = f25563j.get(xt2);
        }
        if (field != null) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            return field;
        }
        try {
            Field j6 = xt.j(cls, str);
            if (j6 == null) {
                return j6;
            }
            synchronized (f25563j) {
                f25563j.put(xt2, j6);
            }
            return j6;
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG, "HackHelper" + String.format("getField %s#%s failed !!!", cls.getName(), str), th);
            return null;
        }
    }

    private static String xt(Class<?> cls, String str) {
        return cls.getName() + "#" + str;
    }

    static {
        try {
            FieldUtils.writeField(xt.class, "classLoader", (Object) null);
            ZeusLogger.w(ZeusLogger.TAG_INIT, "HackHelper HackHelperImpl use BootClassLoader");
        } catch (Exception e6) {
            ZeusLogger.errReport(ZeusLogger.TAG_INIT, "HackHelperinit failed", e6);
        }
    }

    private static String xt(Class<?> cls, String str, Class<?>... clsArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(cls.getName());
        sb.append("#");
        sb.append(str);
        if (clsArr == null || clsArr.length <= 0) {
            sb.append(Void.class.getName());
        } else {
            for (Class<?> cls2 : clsArr) {
                sb.append(cls2.getName());
                sb.append("#");
            }
        }
        return sb.toString();
    }

    public static Method j(Class<?> cls, String str, Class<?>... clsArr) {
        Method method;
        String xt2 = xt(cls, str, clsArr);
        synchronized (xt) {
            method = xt.get(xt2);
        }
        if (method != null) {
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            return method;
        }
        try {
            Method j6 = xt.j(cls, str, clsArr);
            if (j6 == null) {
                return j6;
            }
            synchronized (xt) {
                xt.put(xt2, j6);
            }
            return j6;
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG, "HackHelper" + String.format("getMethod %s#%s failed !!!", cls.getName(), str), th);
            return null;
        }
    }

    public static Constructor j(Class<?> cls, Class<?>... clsArr) {
        Constructor constructor;
        String xt2 = xt(cls, "clinit", clsArr);
        synchronized (cw) {
            constructor = cw.get(xt2);
        }
        if (constructor != null) {
            if (!constructor.isAccessible()) {
                constructor.setAccessible(true);
            }
            return constructor;
        }
        try {
            Constructor j6 = xt.j(cls, clsArr);
            if (j6 == null) {
                return j6;
            }
            synchronized (cw) {
                cw.put(xt2, j6);
            }
            return j6;
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG, "HackHelper" + String.format("getConstructor %s failed !!!", cls.getName()), th);
            return null;
        }
    }
}
