package com.autonavi.base.ae.gmap.glyph;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class ReflectUtil {
    public static Object getField(String str, Object obj, String str2) {
        if (str == null || str.equals("")) {
            throw new IllegalArgumentException("className 不能为空");
        }
        if (str2 == null || str2.equals("")) {
            throw new IllegalArgumentException("fieldName 不能为空");
        }
        try {
            Field declaredField = Class.forName(str).getDeclaredField(str2);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static Object getInstance(String str, Object... objArr) {
        if (str == null || str.equals("")) {
            throw new IllegalArgumentException("className 不能为空");
        }
        try {
            Class<?> cls = Class.forName(str);
            if (objArr == null) {
                Constructor<?> declaredConstructor = cls.getDeclaredConstructor(null);
                declaredConstructor.setAccessible(true);
                return declaredConstructor.newInstance(null);
            }
            int length = objArr.length;
            Class<?>[] clsArr = new Class[length];
            for (int i6 = 0; i6 < length; i6++) {
                clsArr[i6] = objArr[i6].getClass();
            }
            Constructor<?> declaredConstructor2 = cls.getDeclaredConstructor(clsArr);
            declaredConstructor2.setAccessible(true);
            return declaredConstructor2.newInstance(objArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static Method getMethod(String str, String str2, Class... clsArr) {
        if (str == null || str.equals("")) {
            throw new IllegalArgumentException("className 不能为空");
        }
        if (str2 == null || str2.equals("")) {
            throw new IllegalArgumentException("methodName不能为空");
        }
        try {
            return Class.forName(str).getDeclaredMethod(str2, clsArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static Object invoke(String str, Object obj, String str2, Object... objArr) {
        if (str == null || str.equals("")) {
            throw new IllegalArgumentException("className 不能为空");
        }
        if (str2 == null || str2.equals("")) {
            throw new IllegalArgumentException("methodName不能为空");
        }
        try {
            Class<?> cls = Class.forName(str);
            if (objArr == null) {
                Method declaredMethod = cls.getDeclaredMethod(str2, null);
                declaredMethod.setAccessible(true);
                return declaredMethod.invoke(obj, null);
            }
            int length = objArr.length;
            Class<?>[] clsArr = new Class[length];
            for (int i6 = 0; i6 < length; i6++) {
                clsArr[i6] = objArr[i6].getClass();
            }
            Method declaredMethod2 = cls.getDeclaredMethod(str2, clsArr);
            declaredMethod2.setAccessible(true);
            return declaredMethod2.invoke(obj, objArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static Object invokeMethod(Object obj, Method method, Object... objArr) {
        if (method == null) {
            throw new IllegalArgumentException("method 不能为空");
        }
        method.setAccessible(true);
        try {
            return method.invoke(obj, objArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static Object newInstance(String str, Class<?>[] clsArr, Object[] objArr) {
        if (str == null || str.equals("")) {
            throw new IllegalArgumentException("className 不能为空");
        }
        try {
            Class<?> cls = Class.forName(str);
            if (clsArr != null) {
                Constructor<?> declaredConstructor = cls.getDeclaredConstructor(clsArr);
                declaredConstructor.setAccessible(true);
                return declaredConstructor.newInstance(objArr);
            }
            Constructor<?> declaredConstructor2 = cls.getDeclaredConstructor(null);
            declaredConstructor2.setAccessible(true);
            return declaredConstructor2.newInstance(null);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static void setField(String str, Object obj, String str2, Object obj2) {
        if (str == null || str.equals("")) {
            throw new IllegalArgumentException("className 不能为空");
        }
        if (str2 == null || str2.equals("")) {
            throw new IllegalArgumentException("fieldName 不能为空");
        }
        try {
            Field declaredField = Class.forName(str).getDeclaredField(str2);
            declaredField.setAccessible(true);
            declaredField.set(obj, obj2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
