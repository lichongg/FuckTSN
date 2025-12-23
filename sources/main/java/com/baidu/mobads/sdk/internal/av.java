package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class av {

    /* renamed from: a, reason: collision with root package name */
    static bu f10649a = bu.a();

    /* renamed from: b, reason: collision with root package name */
    private static final String f10650b = "com.baidu.mobads.sdk.internal.av";

    public static Class<?> a(String str, ClassLoader classLoader) {
        if (classLoader != null) {
            try {
                return classLoader.loadClass(str);
            } catch (Exception e6) {
                f10649a.a(f10650b, Log.getStackTraceString(e6));
            }
        }
        return null;
    }

    public static Field b(Object obj, String str) {
        for (Class<?> cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            try {
                return cls.getDeclaredField(str);
            } catch (Exception e6) {
                f10649a.b(f10650b, Log.getStackTraceString(e6));
            }
        }
        return null;
    }

    public static Class<?> a(String str) {
        try {
            return Class.forName(str);
        } catch (Exception e6) {
            f10649a.b(f10650b, Log.getStackTraceString(e6));
            return null;
        }
    }

    public static Object a(String str, ClassLoader classLoader, String str2, Class[] clsArr, Object[] objArr) {
        try {
            Class<?> a6 = a(str, classLoader);
            if (a6 == null) {
                return null;
            }
            Method declaredMethod = a6.getDeclaredMethod(str2, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(null, objArr);
        } catch (Exception e6) {
            f10649a.b(f10650b, Log.getStackTraceString(e6));
            return null;
        }
    }

    public static Field b(Class<?> cls, String str) {
        while (cls != Object.class) {
            try {
                return cls.getDeclaredField(str);
            } catch (Exception e6) {
                f10649a.b(f10650b, Log.getStackTraceString(e6));
                cls = cls.getSuperclass();
            }
        }
        return null;
    }

    public static boolean a(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return cls.getDeclaredMethod(str, clsArr) != null;
        } catch (NoSuchMethodException unused) {
            return false;
        } catch (Exception e6) {
            f10649a.b(f10650b, Log.getStackTraceString(e6));
            return false;
        }
    }

    public static Method b(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            if (declaredMethod == null) {
                return null;
            }
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Exception e6) {
            f10649a.b(f10650b, Log.getStackTraceString(e6));
            return null;
        }
    }

    public static Object a(Object obj, String str) {
        Field b6 = b(obj, str);
        if (b6 == null) {
            return null;
        }
        b6.setAccessible(true);
        try {
            return b6.get(obj);
        } catch (Exception e6) {
            f10649a.b(f10650b, Log.getStackTraceString(e6));
            return null;
        }
    }

    public static Object a(Class cls, String str) {
        Field b6 = b((Class<?>) cls, str);
        if (b6 == null) {
            return null;
        }
        b6.setAccessible(true);
        try {
            return b6.get(cls);
        } catch (Exception e6) {
            f10649a.b(f10650b, Log.getStackTraceString(e6));
            return null;
        }
    }

    public static Object a(Object obj, String str, Object... objArr) {
        try {
            return a(obj.getClass(), obj, str, a(objArr), objArr);
        } catch (Exception e6) {
            f10649a.b(f10650b, Log.getStackTraceString(e6));
            return null;
        }
    }

    public static Class<?>[] a(Object... objArr) {
        try {
            int length = objArr.length;
            Class<?>[] clsArr = new Class[length];
            for (int i6 = 0; i6 < length; i6++) {
                clsArr[i6] = objArr[i6].getClass();
            }
            return clsArr;
        } catch (Exception e6) {
            f10649a.b(f10650b, Log.getStackTraceString(e6));
            return null;
        }
    }

    public static Object a(Object obj, String str, Class<?>[] clsArr, Object[] objArr) {
        try {
            return a(obj.getClass(), obj, str, clsArr, objArr);
        } catch (Exception e6) {
            f10649a.b(f10650b, Log.getStackTraceString(e6));
            return null;
        }
    }

    public static Object a(Class<?> cls, Object obj, String str, Class<?>[] clsArr, Object[] objArr) {
        try {
            if (a(cls, str, clsArr)) {
                return b(cls, str, clsArr).invoke(obj, objArr);
            }
            return null;
        } catch (Exception e6) {
            f10649a.b(f10650b, Log.getStackTraceString(e6));
            return null;
        }
    }

    public static Object a(String str, ClassLoader classLoader, Class<?>[] clsArr, Object... objArr) {
        try {
            Class<?> a6 = a(str, classLoader);
            if (a6 != null) {
                return a6.getDeclaredConstructor(clsArr).newInstance(objArr);
            }
            return null;
        } catch (Exception e6) {
            f10649a.b(f10650b, Log.getStackTraceString(e6));
            return null;
        }
    }

    public static Object a(String str, Class<?>[] clsArr, Object... objArr) {
        try {
            Class<?> a6 = a(str);
            if (a6 != null) {
                return a6.getDeclaredConstructor(clsArr).newInstance(objArr);
            }
            return null;
        } catch (Exception e6) {
            f10649a.b(f10650b, Log.getStackTraceString(e6));
            return null;
        }
    }

    public static Object a(String str, ClassLoader classLoader, InvocationHandler invocationHandler) {
        Class<?> a6 = a(str, classLoader);
        if (a6 != null) {
            return Proxy.newProxyInstance(a6.getClassLoader(), new Class[]{a6}, invocationHandler);
        }
        return null;
    }

    public static Object a(String str, InvocationHandler invocationHandler) {
        Class<?> a6 = a(str);
        if (a6 != null) {
            return Proxy.newProxyInstance(a6.getClassLoader(), new Class[]{a6}, invocationHandler);
        }
        return null;
    }

    public static Object a(String str, Object obj, ClassLoader classLoader, String str2, Class<?>[] clsArr, Object... objArr) {
        Method declaredMethod;
        try {
            Class<?> a6 = a(str, classLoader);
            if (a6 == null || (declaredMethod = a6.getDeclaredMethod(str2, clsArr)) == null) {
                return null;
            }
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(obj, objArr);
        } catch (Exception e6) {
            f10649a.b(f10650b, Log.getStackTraceString(e6));
            return null;
        }
    }

    public static Object a(String str, Object obj, String str2, Class<?>[] clsArr, Object... objArr) {
        Method declaredMethod;
        try {
            Class<?> a6 = a(str);
            if (a6 == null || (declaredMethod = a6.getDeclaredMethod(str2, clsArr)) == null) {
                return null;
            }
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(obj, objArr);
        } catch (Exception e6) {
            f10649a.b(f10650b, Log.getStackTraceString(e6));
            return null;
        }
    }

    public static Object a(ClassLoader classLoader, String str, String str2) {
        try {
            return a((Class) Class.forName(str, true, classLoader), str2);
        } catch (Exception e6) {
            f10649a.b(f10650b, Log.getStackTraceString(e6));
            return null;
        }
    }

    public static ClassLoader a(Context context) {
        return ao.a(ca.a(context), context.getFilesDir().getAbsolutePath(), (String) null, av.class.getClassLoader());
    }
}
