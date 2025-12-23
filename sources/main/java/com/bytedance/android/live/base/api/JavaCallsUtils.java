package com.bytedance.android.live.base.api;

import com.bytedance.sdk.openadsdk.api.m;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class JavaCallsUtils {
    private static final String LOG_TAG = "JavaCalls";
    private static final Map<Class<?>, Class<?>> PRIMITIVE_MAP;

    public static <T> T callStaticMethodOrThrow(Class<?> cls, String str, Object... objArr) {
        return (T) getDeclaredMethod(cls, str, getParameterTypes(objArr)).invoke(null, getParameters(objArr));
    }

    public static <T> T callStaticMethodWithClassLoader(String str, String str2, ClassLoader classLoader, Object... objArr) {
        try {
            return (T) callStaticMethodOrThrow(Class.forName(str, true, classLoader), str2, objArr);
        } catch (Exception e6) {
            m.r(LOG_TAG, "Meet exception when call Method '" + str2 + "' in " + str, e6);
            return null;
        }
    }

    private static boolean compareClassLists(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr == null) {
            return clsArr2 == null || clsArr2.length == 0;
        }
        if (clsArr2 == null) {
            return clsArr.length == 0;
        }
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        for (int i6 = 0; i6 < clsArr.length; i6++) {
            if (!clsArr[i6].isAssignableFrom(clsArr2[i6])) {
                Map<Class<?>, Class<?>> map = PRIMITIVE_MAP;
                if (!map.containsKey(clsArr[i6]) || !map.get(clsArr[i6]).equals(map.get(clsArr2[i6]))) {
                    return false;
                }
            }
        }
        return true;
    }

    private static Class<?>[] getParameterTypes(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i6 = 0; i6 < objArr.length; i6++) {
            Object obj = objArr[i6];
            clsArr[i6] = (obj == null || !(obj instanceof JavaParam)) ? obj == null ? null : obj.getClass() : ((JavaParam) obj).clazz;
        }
        return clsArr;
    }

    public static <T> T newInstance(Class<?> cls, Object... objArr) {
        try {
            return (T) newInstanceOrThrow(cls, objArr);
        } catch (Exception e6) {
            m.r(LOG_TAG, "Meet exception when make instance as a " + cls.getSimpleName(), e6);
            return null;
        }
    }

    public static <T> T newInstanceOrThrow(Class<?> cls, Object... objArr) {
        Constructor<?> constructor = cls.getConstructor(getParameterTypes(objArr));
        constructor.setAccessible(true);
        return (T) constructor.newInstance(getParameters(objArr));
    }

    public static class JavaParam<T> {
        public final Class<? extends T> clazz;
        public final T obj;

        public JavaParam(Class<? extends T> cls, T t5) {
            this.clazz = cls;
            this.obj = t5;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        PRIMITIVE_MAP = hashMap;
        Class cls = Boolean.TYPE;
        hashMap.put(Boolean.class, cls);
        Class cls2 = Byte.TYPE;
        hashMap.put(Byte.class, cls2);
        Class cls3 = Character.TYPE;
        hashMap.put(Character.class, cls3);
        Class cls4 = Short.TYPE;
        hashMap.put(Short.class, cls4);
        Class cls5 = Integer.TYPE;
        hashMap.put(Integer.class, cls5);
        Class cls6 = Float.TYPE;
        hashMap.put(Float.class, cls6);
        Class cls7 = Long.TYPE;
        hashMap.put(Long.class, cls7);
        Class cls8 = Double.TYPE;
        hashMap.put(Double.class, cls8);
        hashMap.put(cls, cls);
        hashMap.put(cls2, cls2);
        hashMap.put(cls3, cls3);
        hashMap.put(cls4, cls4);
        hashMap.put(cls5, cls5);
        hashMap.put(cls6, cls6);
        hashMap.put(cls7, cls7);
        hashMap.put(cls8, cls8);
    }

    public static <T> T callStaticMethodOrThrow(String str, String str2, Object... objArr) {
        return (T) getDeclaredMethod(Class.forName(str), str2, getParameterTypes(objArr)).invoke(null, getParameters(objArr));
    }

    private static Method findMethodByName(Method[] methodArr, String str, Class<?>[] clsArr) {
        if (str == null) {
            throw new NullPointerException("Method name must not be null.");
        }
        for (Method method : methodArr) {
            if (method.getName().equals(str) && compareClassLists(method.getParameterTypes(), clsArr)) {
                return method;
            }
        }
        return null;
    }

    private static Object getDefaultValue(Class<?> cls) {
        if (Integer.TYPE.equals(cls) || Integer.class.equals(cls) || Byte.TYPE.equals(cls) || Byte.class.equals(cls) || Short.TYPE.equals(cls) || Short.class.equals(cls) || Long.TYPE.equals(cls) || Long.class.equals(cls) || Double.TYPE.equals(cls) || Double.class.equals(cls) || Float.TYPE.equals(cls) || Float.class.equals(cls)) {
            return 0;
        }
        return (Boolean.TYPE.equals(cls) || Boolean.class.equals(cls)) ? Boolean.FALSE : (Character.TYPE.equals(cls) || Character.class.equals(cls)) ? (char) 0 : null;
    }

    private static Object[] getParameters(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Object[] objArr2 = new Object[objArr.length];
        for (int i6 = 0; i6 < objArr.length; i6++) {
            Object obj = objArr[i6];
            if (obj == null || !(obj instanceof JavaParam)) {
                objArr2[i6] = obj;
            } else {
                objArr2[i6] = ((JavaParam) obj).obj;
            }
        }
        return objArr2;
    }

    public static Object newInstance(String str, Object... objArr) {
        try {
            return newInstanceOrThrow(str, objArr);
        } catch (Exception e6) {
            m.r(LOG_TAG, "Meet exception when make instance as a ".concat(String.valueOf(str)), e6);
            return null;
        }
    }

    public static Object newInstanceOrThrow(String str, Object... objArr) {
        return newInstanceOrThrow(Class.forName(str), getParameters(objArr));
    }

    public static <T> T callMethod(Object obj, String str, Object... objArr) {
        try {
            return (T) callMethodOrThrow(obj, str, objArr);
        } catch (Exception e6) {
            m.r(LOG_TAG, "Meet exception when call Method '" + str + "' in " + obj, e6);
            return null;
        }
    }

    public static <T> T callMethodOrThrow(Object obj, String str, Object... objArr) {
        return (T) getDeclaredMethod(obj.getClass(), str, getParameterTypes(objArr)).invoke(obj, getParameters(objArr));
    }

    public static <T> T callStaticMethod(String str, String str2, Object... objArr) {
        try {
            return (T) callStaticMethodOrThrow(Class.forName(str), str2, objArr);
        } catch (Exception e6) {
            m.r(LOG_TAG, "Meet exception when call Method '" + str2 + "' in " + str, e6);
            return null;
        }
    }

    private static Method getDeclaredMethod(Class<?> cls, String str, Class<?>... clsArr) {
        Method findMethodByName = findMethodByName(cls.getDeclaredMethods(), str, clsArr);
        if (findMethodByName == null) {
            if (cls.getSuperclass() != null) {
                return getDeclaredMethod(cls.getSuperclass(), str, clsArr);
            }
            throw new NoSuchMethodException();
        }
        findMethodByName.setAccessible(true);
        return findMethodByName;
    }

    public static <T> T getField(Object obj, String str) {
        try {
            return (T) getFieldOrThrow(obj, str);
        } catch (IllegalAccessException | NoSuchFieldException e6) {
            m.j(e6);
            return null;
        }
    }

    public static <T> T getFieldOrThrow(Object obj, String str) {
        Class<?> cls = obj.getClass();
        Field field = null;
        while (field == null) {
            try {
                field = cls.getDeclaredField(str);
                field.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
            if (cls == null) {
                throw new NoSuchFieldException();
            }
        }
        field.setAccessible(true);
        return (T) field.get(obj);
    }

    public static <T> T newEmptyInstance(Class<?> cls) {
        try {
            return (T) newEmptyInstanceOrThrow(cls);
        } catch (Exception e6) {
            m.r(LOG_TAG, "Meet exception when make instance as a " + cls.getSimpleName(), e6);
            return null;
        }
    }

    public static <T> T newEmptyInstanceOrThrow(Class<?> cls) {
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        if (declaredConstructors != null && declaredConstructors.length != 0) {
            Constructor<?> constructor = declaredConstructors[0];
            constructor.setAccessible(true);
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes != null && parameterTypes.length != 0) {
                Object[] objArr = new Object[parameterTypes.length];
                for (int i6 = 0; i6 < parameterTypes.length; i6++) {
                    objArr[i6] = getDefaultValue(parameterTypes[i6]);
                }
                return (T) constructor.newInstance(objArr);
            }
            return (T) constructor.newInstance(null);
        }
        throw new IllegalArgumentException("Can't get even one available constructor for ".concat(String.valueOf(cls)));
    }

    public static void setField(Object obj, String str, Object obj2) {
        try {
            setFieldOrThrow(obj, str, obj2);
        } catch (IllegalAccessException | NoSuchFieldException e6) {
            m.j(e6);
        }
    }

    public static void setFieldOrThrow(Object obj, String str, Object obj2) {
        Class<?> cls = obj.getClass();
        Field field = null;
        while (field == null) {
            try {
                field = cls.getDeclaredField(str);
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
            if (cls == null) {
                throw new NoSuchFieldException();
            }
        }
        field.setAccessible(true);
        field.set(obj, obj2);
    }
}
