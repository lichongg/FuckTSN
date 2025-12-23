package com.bxkj.base.v2.common.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class h0 {
    public static boolean e(Class<?> cls) throws SecurityException {
        try {
            cls.getConstructor(null);
            return true;
        } catch (NoSuchMethodException unused) {
            return false;
        }
    }

    public static String b(Type type) {
        if (type == null) {
            return "";
        }
        String obj = type.toString();
        return obj.startsWith("class") ? obj.substring(5) : obj;
    }

    public static Class<?> a(Type type) throws ClassNotFoundException {
        String b6 = b(type);
        if (b6 != null && !b6.isEmpty()) {
            return Class.forName(b6);
        }
        return null;
    }

    public static Type c(Object obj) {
        return obj.getClass().getGenericInterfaces()[0];
    }

    public static Type d(Object obj) {
        Type genericSuperclass = obj.getClass().getGenericSuperclass();
        if (!ParameterizedType.class.isAssignableFrom(genericSuperclass.getClass())) {
            return null;
        }
        return ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
    }

    public static Object f(Type type) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> a6 = a(type);
        if (a6 == null) {
            return null;
        }
        return a6.newInstance();
    }
}
