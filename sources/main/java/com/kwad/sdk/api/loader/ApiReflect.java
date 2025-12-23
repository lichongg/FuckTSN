package com.kwad.sdk.api.loader;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ApiReflect {
    private final Class<?> atF;
    private final Object atG;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class ReflectException extends RuntimeException {
        private static final long serialVersionUID = -6213149635297151442L;

        public ReflectException(String str) {
            super(str);
        }

        public ReflectException(String str, Throwable th) {
            super(str, th);
        }

        public ReflectException() {
        }

        public ReflectException(Throwable th) {
            super(th);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a {
        private static final Method atH;
        private static final Method atI;
        private static final Method atJ;
        private static final Method atK;
        private static final Method atL;
        private static final Method atM;
        private static final Method atN;
        private static final Method atO;
        private static final Method atP;
        private static final Method atQ;
        private static final Method atR;
        private static final Method atS;
        private static final Method atT;
        private static final Method atU;

        static Field a(Class cls, String str) {
            try {
                return (Field) atJ.invoke(cls, str);
            } catch (Exception e6) {
                NoSuchFieldException noSuchFieldException = new NoSuchFieldException();
                noSuchFieldException.initCause(e6);
                throw noSuchFieldException;
            }
        }

        static Method c(Class cls, String str, Class<?>... clsArr) {
            try {
                return (Method) atL.invoke(cls, str, clsArr);
            } catch (Exception e6) {
                NoSuchMethodException noSuchMethodException = new NoSuchMethodException();
                noSuchMethodException.initCause(e6);
                throw noSuchMethodException;
            }
        }

        static Method d(Class cls, String str, Class<?>... clsArr) {
            try {
                return (Method) atR.invoke(cls, str, clsArr);
            } catch (Exception e6) {
                NoSuchMethodException noSuchMethodException = new NoSuchMethodException();
                noSuchMethodException.initCause(e6);
                throw noSuchMethodException;
            }
        }

        static {
            try {
                atH = Class.class.getDeclaredMethod("forName", String.class);
                atI = Class.class.getDeclaredMethod("forName", String.class, Boolean.TYPE, ClassLoader.class);
                atJ = Class.class.getDeclaredMethod("getDeclaredField", String.class);
                atK = Class.class.getDeclaredMethod("getDeclaredFields", null);
                atL = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
                atM = Class.class.getDeclaredMethod("getDeclaredMethods", null);
                atN = Class.class.getDeclaredMethod("getDeclaredConstructor", Class[].class);
                atO = Class.class.getDeclaredMethod("getDeclaredConstructors", null);
                atP = Class.class.getDeclaredMethod("getField", String.class);
                atQ = Class.class.getDeclaredMethod("getFields", null);
                atR = Class.class.getDeclaredMethod("getMethod", String.class, Class[].class);
                atS = Class.class.getDeclaredMethod("getMethods", null);
                atT = Class.class.getDeclaredMethod("getConstructor", Class[].class);
                atU = Class.class.getDeclaredMethod("getConstructors", null);
            } catch (NoSuchMethodException e6) {
                throw new ReflectException(e6);
            }
        }

        static Field b(Class cls, String str) {
            try {
                return (Field) atP.invoke(cls, str);
            } catch (Exception e6) {
                NoSuchFieldException noSuchFieldException = new NoSuchFieldException();
                noSuchFieldException.initCause(e6);
                throw noSuchFieldException;
            }
        }

        static Constructor[] e(Class cls) {
            try {
                return (Constructor[]) atO.invoke(cls, null);
            } catch (Exception e6) {
                throw new ReflectException(e6);
            }
        }

        static Class forName(String str) {
            try {
                return (Class) atH.invoke(null, str);
            } catch (Exception e6) {
                ClassNotFoundException classNotFoundException = new ClassNotFoundException();
                classNotFoundException.initCause(e6);
                throw classNotFoundException;
            }
        }

        static Constructor a(Class cls, Class<?>... clsArr) {
            try {
                return (Constructor) atN.invoke(cls, clsArr);
            } catch (Exception e6) {
                NoSuchMethodException noSuchMethodException = new NoSuchMethodException();
                noSuchMethodException.initCause(e6);
                throw noSuchMethodException;
            }
        }

        static Method[] c(Class cls) {
            try {
                return (Method[]) atM.invoke(cls, null);
            } catch (Exception e6) {
                throw new ReflectException(e6);
            }
        }

        static Method[] d(Class cls) {
            try {
                return (Method[]) atS.invoke(cls, null);
            } catch (Exception e6) {
                throw new ReflectException(e6);
            }
        }
    }

    private ApiReflect(Class<?> cls) {
        this(cls, cls);
    }

    public static ApiReflect a(Class<?> cls) {
        return new ApiReflect(cls);
    }

    private static Class<?>[] c(Object... objArr) {
        if (objArr == null) {
            return new Class[0];
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i6 = 0; i6 < objArr.length; i6++) {
            Object obj = objArr[i6];
            clsArr[i6] = obj == null ? b.class : obj.getClass();
        }
        return clsArr;
    }

    public static ApiReflect h(Object obj) {
        return new ApiReflect(obj == null ? Object.class : obj.getClass(), obj);
    }

    public final ApiReflect Dk() {
        return b(new Object[0]);
    }

    public final ApiReflect b(String str, Object obj) {
        try {
            Field cp = cp(str);
            if ((cp.getModifiers() & 16) == 16) {
                try {
                    Field a6 = a.a(Field.class, "modifiers");
                    a6.setAccessible(true);
                    a6.setInt(cp, cp.getModifiers() & (-17));
                } catch (NoSuchFieldException unused) {
                }
            }
            cp.set(this.atG, i(obj));
            return this;
        } catch (Exception e6) {
            throw new ReflectException(e6);
        }
    }

    public final ApiReflect cq(String str) {
        return h(str, new Object[0]);
    }

    public final <T> T get() {
        return (T) this.atG;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b {
        private b() {
        }
    }

    private ApiReflect(Class<?> cls, Object obj) {
        this.atF = cls;
        this.atG = obj;
    }

    private static ApiReflect a(Class<?> cls, Object obj) {
        return new ApiReflect(cls, obj);
    }

    private ApiReflect h(String str, Object... objArr) {
        return a(str, c(objArr), objArr);
    }

    private static Object i(Object obj) {
        return obj instanceof ApiReflect ? ((ApiReflect) obj).get() : obj;
    }

    private Class<?> type() {
        return this.atF;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ApiReflect) {
            return this.atG.equals(((ApiReflect) obj).get());
        }
        return false;
    }

    public final <T> T get(String str) {
        return (T) co(str).get();
    }

    public final int hashCode() {
        return this.atG.hashCode();
    }

    public final String toString() {
        return String.valueOf(this.atG);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
    
        if (java.lang.reflect.Modifier.isPublic(r0.getDeclaringClass().getModifiers()) != false) goto L15;
     */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static <T extends java.lang.reflect.AccessibleObject> T a(T r2) {
        /*
            if (r2 != 0) goto L4
            r2 = 0
            return r2
        L4:
            boolean r0 = r2 instanceof java.lang.reflect.Member
            if (r0 == 0) goto L24
            r0 = r2
            java.lang.reflect.Member r0 = (java.lang.reflect.Member) r0
            int r1 = r0.getModifiers()
            boolean r1 = java.lang.reflect.Modifier.isPublic(r1)
            if (r1 == 0) goto L24
            java.lang.Class r0 = r0.getDeclaringClass()
            int r0 = r0.getModifiers()
            boolean r0 = java.lang.reflect.Modifier.isPublic(r0)
            if (r0 == 0) goto L24
            goto L2e
        L24:
            boolean r0 = r2.isAccessible()
            if (r0 != 0) goto L2e
            r0 = 1
            r2.setAccessible(r0)
        L2e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.api.loader.ApiReflect.a(java.lang.reflect.AccessibleObject):java.lang.reflect.AccessibleObject");
    }

    public static ApiReflect cn(String str) {
        return a(forName(str));
    }

    private ApiReflect co(String str) {
        try {
            Field cp = cp(str);
            return a(cp.getType(), cp.get(this.atG));
        } catch (Exception e6) {
            throw new ReflectException(e6);
        }
    }

    private Field cp(String str) {
        Class<?> type = type();
        try {
            return (Field) a(a.b(type, str));
        } catch (NoSuchFieldException e6) {
            do {
                try {
                    return (Field) a(a.a(type, str));
                } catch (NoSuchFieldException unused) {
                    type = type.getSuperclass();
                    if (type == null) {
                        throw new ReflectException(e6);
                    }
                }
            } while (type == null);
            throw new ReflectException(e6);
        }
    }

    private static Class<?> forName(String str) {
        try {
            return a.forName(str);
        } catch (Exception e6) {
            throw new ReflectException(e6);
        }
    }

    private Method b(String str, Class<?>[] clsArr) {
        Class<?> type = type();
        for (Method method : a.d(type)) {
            if (a(method, str, clsArr)) {
                return method;
            }
        }
        do {
            for (Method method2 : a.c(type)) {
                if (a(method2, str, clsArr)) {
                    return method2;
                }
            }
            type = type.getSuperclass();
        } while (type != null);
        throw new NoSuchMethodException("No similar method " + str + " with params " + Arrays.toString(clsArr) + " could be found on type " + type() + ".");
    }

    public final ApiReflect a(String str, Class<?>[] clsArr, Object... objArr) {
        try {
            try {
                return a(a(str, clsArr), this.atG, objArr);
            } catch (NoSuchMethodException e6) {
                throw new ReflectException(e6);
            }
        } catch (NoSuchMethodException unused) {
            return a(b(str, clsArr), this.atG, objArr);
        }
    }

    private Method a(String str, Class<?>[] clsArr) {
        Class<?> type = type();
        try {
            return a.d(type, str, clsArr);
        } catch (NoSuchMethodException unused) {
            do {
                try {
                    return a.c(type, str, clsArr);
                } catch (NoSuchMethodException unused2) {
                    type = type.getSuperclass();
                }
            } while (type != null);
            throw new NoSuchMethodException();
        }
    }

    private ApiReflect b(Object... objArr) {
        return a(c(objArr), objArr);
    }

    private boolean a(Method method, String str, Class<?>[] clsArr) {
        return method.getName().equals(str) && a(method.getParameterTypes(), clsArr);
    }

    private static Class<?> b(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        if (!cls.isPrimitive()) {
            return cls;
        }
        if (Boolean.TYPE == cls) {
            return Boolean.class;
        }
        if (Integer.TYPE == cls) {
            return Integer.class;
        }
        if (Long.TYPE == cls) {
            return Long.class;
        }
        if (Short.TYPE == cls) {
            return Short.class;
        }
        if (Byte.TYPE == cls) {
            return Byte.class;
        }
        if (Double.TYPE == cls) {
            return Double.class;
        }
        if (Float.TYPE == cls) {
            return Float.class;
        }
        if (Character.TYPE == cls) {
            return Character.class;
        }
        return Void.TYPE == cls ? Void.class : cls;
    }

    public final ApiReflect a(Class<?>[] clsArr, Object... objArr) {
        try {
            return a((Constructor<?>) a.a(type(), clsArr), objArr);
        } catch (NoSuchMethodException e6) {
            for (Constructor constructor : a.e(type())) {
                if (a(constructor.getParameterTypes(), clsArr)) {
                    return a((Constructor<?>) constructor, objArr);
                }
            }
            throw new ReflectException(e6);
        }
    }

    private static boolean a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        for (int i6 = 0; i6 < clsArr2.length; i6++) {
            if (clsArr2[i6] != b.class && !b(clsArr[i6]).isAssignableFrom(b(clsArr2[i6]))) {
                return false;
            }
        }
        return true;
    }

    private static ApiReflect a(Constructor<?> constructor, Object... objArr) {
        try {
            return a(constructor.getDeclaringClass(), ((Constructor) a(constructor)).newInstance(objArr));
        } catch (Exception e6) {
            throw new ReflectException(e6);
        }
    }

    private static ApiReflect a(Method method, Object obj, Object... objArr) {
        try {
            a(method);
            if (method.getReturnType() == Void.TYPE) {
                method.invoke(obj, objArr);
                return h(obj);
            }
            return h(method.invoke(obj, objArr));
        } catch (Exception e6) {
            throw new ReflectException(e6);
        }
    }
}
