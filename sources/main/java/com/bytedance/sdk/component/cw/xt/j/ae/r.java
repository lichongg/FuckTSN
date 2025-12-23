package com.bytedance.sdk.component.cw.xt.j.ae;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: D:\Downloads\app\classes4.dex */
class r<T> {
    private final Class[] cw;

    /* renamed from: j, reason: collision with root package name */
    private final Class<?> f26158j;
    private final String xt;

    public boolean j(T t5) {
        return j(t5.getClass()) != null;
    }

    public Object j(T t5, Object... objArr) throws InvocationTargetException {
        Method j6 = j(t5.getClass());
        if (j6 == null) {
            return null;
        }
        try {
            return j6.invoke(t5, objArr);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }

    r(Class<?> cls, String str, Class... clsArr) {
        this.f26158j = cls;
        this.xt = str;
        this.cw = clsArr;
    }

    public Object cw(T t5, Object... objArr) throws InvocationTargetException {
        Method j6 = j(t5.getClass());
        if (j6 != null) {
            try {
                return j6.invoke(t5, objArr);
            } catch (IllegalAccessException e6) {
                AssertionError assertionError = new AssertionError("Unexpectedly could not call: ".concat(String.valueOf(j6)));
                assertionError.initCause(e6);
                throw assertionError;
            }
        }
        throw new AssertionError("Method " + this.xt + " not supported for object " + t5);
    }

    public Object r(T t5, Object... objArr) {
        try {
            return cw(t5, objArr);
        } catch (InvocationTargetException e6) {
            Throwable targetException = e6.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public Object xt(T t5, Object... objArr) {
        try {
            return j(t5, objArr);
        } catch (InvocationTargetException e6) {
            Throwable targetException = e6.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    private Method j(Class<?> cls) {
        Class<?> cls2;
        String str = this.xt;
        if (str == null) {
            return null;
        }
        Method j6 = j(cls, str, this.cw);
        if (j6 == null || (cls2 = this.f26158j) == null || cls2.isAssignableFrom(j6.getReturnType())) {
            return j6;
        }
        return null;
    }

    private static Method j(Class<?> cls, String str, Class[] clsArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            try {
                if ((method.getModifiers() & 1) == 0) {
                    return null;
                }
                return method;
            } catch (NoSuchMethodException unused) {
                return method;
            }
        } catch (NoSuchMethodException unused2) {
            return null;
        }
    }
}
