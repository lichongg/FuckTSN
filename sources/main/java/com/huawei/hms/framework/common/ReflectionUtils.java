package com.huawei.hms.framework.common;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class ReflectionUtils {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33342a = "ReflectionUtils";

    private static Class<?> a(String str) {
        if (str == null) {
            return null;
        }
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static boolean checkCompatible(String str) {
        try {
            d(str);
            return true;
        } catch (Exception unused) {
            Logger.w(f33342a, str + "ClassNotFoundException");
            return false;
        }
    }

    public static Method getMethod(Class<?> cls, String str, Class<?>... clsArr) {
        if (cls == null || str == null) {
            Logger.w(f33342a, "targetClass is  null pr name is null:");
            return null;
        }
        try {
            return cls.getDeclaredMethod(str, clsArr);
        } catch (NoSuchMethodException e6) {
            Logger.e(f33342a, "NoSuchMethodException:", e6);
            return null;
        } catch (SecurityException e7) {
            Logger.e(f33342a, "SecurityException:", e7);
            return null;
        }
    }

    public static Object invokeStaticMethod(String str, String str2, Object... objArr) {
        Class[] clsArr;
        if (str == null) {
            return null;
        }
        if (objArr != null) {
            int length = objArr.length;
            clsArr = new Class[length];
            for (int i6 = 0; i6 < length; i6++) {
                c(clsArr, objArr[i6], i6);
            }
        } else {
            clsArr = null;
        }
        Method method = getMethod(a(str), str2, clsArr);
        if (method == null) {
            return null;
        }
        return b(null, method, objArr);
    }

    private static Object b(Object obj, Method method, Object... objArr) throws UnsupportedOperationException {
        if (method == null) {
            return null;
        }
        try {
            return method.invoke(obj, objArr);
        } catch (RuntimeException e6) {
            Logger.e(f33342a, "RuntimeException in invoke:", e6);
            return null;
        } catch (Exception e7) {
            Logger.e(f33342a, "Exception in invoke:", e7);
            return null;
        }
    }

    private static void c(Class<?>[] clsArr, Object obj, int i6) {
        if (obj instanceof Integer) {
            clsArr[i6] = Integer.TYPE;
            return;
        }
        if (obj instanceof Long) {
            clsArr[i6] = Long.TYPE;
            return;
        }
        if (obj instanceof Double) {
            clsArr[i6] = Double.TYPE;
            return;
        }
        if (obj instanceof Float) {
            clsArr[i6] = Float.TYPE;
            return;
        }
        if (obj instanceof Boolean) {
            clsArr[i6] = Boolean.TYPE;
            return;
        }
        if (obj instanceof Character) {
            clsArr[i6] = Character.TYPE;
            return;
        }
        if (obj instanceof Byte) {
            clsArr[i6] = Byte.TYPE;
            return;
        }
        if (obj instanceof Void) {
            clsArr[i6] = Void.TYPE;
        } else if (obj instanceof Short) {
            clsArr[i6] = Short.TYPE;
        } else {
            clsArr[i6] = obj.getClass();
        }
    }

    private static void d(String str) throws ClassNotFoundException {
        ClassLoader classLoader = ReflectionUtils.class.getClassLoader();
        if (classLoader == null) {
            throw new ClassNotFoundException("not found classloader");
        }
        classLoader.loadClass(str);
    }

    public static Field getField(Object obj, String str) {
        if (obj != null && !TextUtils.isEmpty(str)) {
            try {
                final Field declaredField = obj.getClass().getDeclaredField(str);
                AccessController.doPrivileged(new PrivilegedAction() { // from class: com.huawei.hms.framework.common.ReflectionUtils.2
                    @Override // java.security.PrivilegedAction
                    public Object run() {
                        declaredField.setAccessible(true);
                        return null;
                    }
                });
                return declaredField;
            } catch (IllegalArgumentException e6) {
                Logger.e(f33342a, "Exception in getField :: IllegalArgumentException:", e6);
            } catch (NoSuchFieldException e7) {
                Logger.e(f33342a, "Exception in getField :: NoSuchFieldException:", e7);
            } catch (SecurityException e8) {
                Logger.e(f33342a, "not security int method getField,SecurityException:", e8);
            }
        }
        return null;
    }

    public static Object getFieldObj(Object obj, String str) {
        if (obj != null && !TextUtils.isEmpty(str)) {
            try {
                final Field declaredField = obj.getClass().getDeclaredField(str);
                AccessController.doPrivileged(new PrivilegedAction() { // from class: com.huawei.hms.framework.common.ReflectionUtils.1
                    @Override // java.security.PrivilegedAction
                    public Object run() {
                        declaredField.setAccessible(true);
                        return null;
                    }
                });
                return declaredField.get(obj);
            } catch (IllegalAccessException e6) {
                Logger.e(f33342a, "Exception in getFieldObj :: IllegalAccessException:", e6);
            } catch (IllegalArgumentException e7) {
                Logger.e(f33342a, "Exception in getFieldObj :: IllegalArgumentException:", e7);
            } catch (NoSuchFieldException e8) {
                Logger.e(f33342a, "Exception in getFieldObj :: NoSuchFieldException:", e8);
            } catch (SecurityException e9) {
                Logger.e(f33342a, "not security int method getFieldObj,SecurityException:", e9);
            }
        }
        return null;
    }

    public static Object getStaticFieldObj(String str, String str2) {
        Class<?> a6;
        if (str != null && (a6 = a(str)) != null && !TextUtils.isEmpty(str2)) {
            try {
                final Field declaredField = a6.getDeclaredField(str2);
                AccessController.doPrivileged(new PrivilegedAction() { // from class: com.huawei.hms.framework.common.ReflectionUtils.3
                    @Override // java.security.PrivilegedAction
                    public Object run() {
                        declaredField.setAccessible(true);
                        return null;
                    }
                });
                return declaredField.get(a6);
            } catch (IllegalAccessException e6) {
                Logger.e(f33342a, "Exception in getFieldObj :: IllegalAccessException:", e6);
            } catch (IllegalArgumentException e7) {
                Logger.e(f33342a, "Exception in getFieldObj :: IllegalArgumentException:", e7);
            } catch (NoSuchFieldException e8) {
                Logger.e(f33342a, "Exception in getFieldObj :: NoSuchFieldException:", e8);
            } catch (SecurityException e9) {
                Logger.e(f33342a, "not security int method getStaticFieldObj,SecurityException:", e9);
            }
        }
        return null;
    }

    public static boolean checkCompatible(String str, String str2, Class<?>... clsArr) {
        try {
            if (str == null || str2 == null) {
                Logger.w(f33342a, "targetClass is  null or name is null:");
                return false;
            }
            Class.forName(str).getDeclaredMethod(str2, clsArr);
            Logger.v(f33342a, "has method : " + str2);
            return true;
        } catch (RuntimeException unused) {
            Logger.w(f33342a, str + " RuntimeException");
            return false;
        } catch (Exception unused2) {
            Logger.w(f33342a, str2 + " NoSuchMethodException");
            return false;
        }
    }

    public static Object invokeStaticMethod(String str, String str2, Class<?>[] clsArr, Object... objArr) {
        Method method = getMethod(a(str), str2, clsArr);
        if (method == null) {
            return null;
        }
        return b(null, method, objArr);
    }
}
