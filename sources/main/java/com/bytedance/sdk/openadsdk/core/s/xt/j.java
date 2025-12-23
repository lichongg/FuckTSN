package com.bytedance.sdk.openadsdk.core.s.xt;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    private static Map<String, Field> f30202j = new HashMap();

    public static Field j(Class<?> cls, String str) {
        Field field;
        String xt = xt(cls, str);
        synchronized (f30202j) {
            field = f30202j.get(xt);
        }
        if (field != null) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            return field;
        }
        while (cls != null) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                synchronized (f30202j) {
                    continue;
                    f30202j.put(xt, declaredField);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
        }
        return null;
    }

    private static String xt(Class<?> cls, String str) {
        return cls.toString() + "#" + str;
    }

    public static Object j(Field field, Object obj) throws IllegalAccessException {
        if (!field.isAccessible()) {
            field.setAccessible(true);
        }
        return field.get(obj);
    }

    public static Object j(Object obj, String str) throws IllegalAccessException {
        Field j6 = j(obj.getClass(), str);
        if (j6 != null) {
            return j(j6, obj);
        }
        return null;
    }
}
