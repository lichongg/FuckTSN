package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class p {
    private static final HashMap<Class<?>, Class<?>> cw;

    /* renamed from: j, reason: collision with root package name */
    public static final Class<?>[] f26892j;
    private static Map<String, Method> xt = new HashMap();

    public static int j(Context context, float f6) {
        return (int) ((f6 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    static {
        HashMap<Class<?>, Class<?>> hashMap = new HashMap<>();
        cw = hashMap;
        hashMap.put(Boolean.TYPE, Boolean.class);
        hashMap.put(Byte.TYPE, Byte.class);
        hashMap.put(Character.TYPE, Character.class);
        hashMap.put(Short.TYPE, Short.class);
        hashMap.put(Integer.TYPE, Integer.class);
        hashMap.put(Long.TYPE, Long.class);
        hashMap.put(Double.TYPE, Double.class);
        hashMap.put(Float.TYPE, Float.class);
        hashMap.put(Void.TYPE, Void.class);
        f26892j = new Class[0];
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
        while (cls != null) {
            try {
                method = cls.getDeclaredMethod(str, clsArr);
            } catch (NoSuchMethodException unused) {
            }
            if (method == null) {
                try {
                    for (Method method2 : cls.getDeclaredMethods()) {
                        if (method2 != null && TextUtils.equals(method2.getName(), str)) {
                            Class<?>[] parameterTypes = method2.getParameterTypes();
                            if (clsArr != null && parameterTypes != null && clsArr.length == parameterTypes.length) {
                                boolean z5 = true;
                                for (int i6 = 0; i6 < clsArr.length; i6++) {
                                    if (!j(clsArr[i6], parameterTypes[i6])) {
                                        z5 = false;
                                    }
                                }
                                if (z5) {
                                    method = method2;
                                }
                            }
                        }
                    }
                } catch (Throwable unused2) {
                }
            }
            if (method != null) {
                method.setAccessible(true);
                synchronized (xt) {
                    xt.put(xt2, method);
                }
                return method;
            }
            cls = cls.getSuperclass();
        }
        return null;
    }

    private static String xt(Class<?> cls, String str, Class<?>... clsArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(cls.toString());
        sb.append("#");
        sb.append(str);
        sb.append("#");
        sb.append(cls.getClassLoader() != null ? Integer.valueOf(cls.getClassLoader().hashCode()) : "");
        if (clsArr == null || clsArr.length <= 0) {
            sb.append(Void.class.toString());
        } else {
            for (Class<?> cls2 : clsArr) {
                sb.append(cls2.toString());
                sb.append("#");
            }
        }
        return sb.toString();
    }

    public static boolean j(Class<?> cls, Class<?> cls2) {
        if (cls2 == null) {
            return false;
        }
        if (cls == null) {
            return !cls2.isPrimitive();
        }
        if (cls.isPrimitive() && !cls2.isPrimitive()) {
            cls = cw.get(cls);
        }
        if (cls2.isPrimitive() && !cls.isPrimitive()) {
            cls2 = cw.get(cls2);
        }
        return cls2.isAssignableFrom(cls);
    }

    public static Object j(Object obj, String str, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return j(obj, str, objArr, j(objArr));
    }

    public static Object j(Object obj, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method j6 = j(obj.getClass(), str, clsArr);
        if (j6 != null) {
            return j6.invoke(obj, objArr);
        }
        throw new NoSuchMethodException(str);
    }

    public static Class<?>[] j(Object... objArr) {
        if (objArr != null && objArr.length != 0) {
            Class<?>[] clsArr = new Class[objArr.length];
            for (int i6 = 0; i6 < objArr.length; i6++) {
                Object obj = objArr[i6];
                clsArr[i6] = obj == null ? null : obj.getClass();
            }
            return clsArr;
        }
        return f26892j;
    }
}
