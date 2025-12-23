package com.acse.ottn;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class l3<T, V> extends g3<T, V> {

    /* renamed from: f, reason: collision with root package name */
    public static final String f4736f = "get";

    /* renamed from: g, reason: collision with root package name */
    public static final String f4737g = "is";

    /* renamed from: h, reason: collision with root package name */
    public static final String f4738h = "set";

    /* renamed from: c, reason: collision with root package name */
    public Method f4739c;

    /* renamed from: d, reason: collision with root package name */
    public Method f4740d;

    /* renamed from: e, reason: collision with root package name */
    public Field f4741e;

    public final boolean a(Class<V> cls, Class cls2) {
        if (cls2 != cls) {
            return cls2.isPrimitive() && ((cls2 == Float.TYPE && cls == Float.class) || ((cls2 == Integer.TYPE && cls == Integer.class) || ((cls2 == Boolean.TYPE && cls == Boolean.class) || ((cls2 == Long.TYPE && cls == Long.class) || ((cls2 == Double.TYPE && cls == Double.class) || ((cls2 == Short.TYPE && cls == Short.class) || ((cls2 == Byte.TYPE && cls == Byte.class) || (cls2 == Character.TYPE && cls == Character.class))))))));
        }
        return true;
    }

    public l3(Class<T> cls, Class<V> cls2, String str) {
        super(cls2, str);
        String str2 = Character.toUpperCase(str.charAt(0)) + str.substring(1);
        String str3 = f4736f + str2;
        try {
            try {
                this.f4740d = cls.getMethod(str3, null);
            } catch (NoSuchMethodException unused) {
                Method declaredMethod = cls.getDeclaredMethod(str3, null);
                this.f4740d = declaredMethod;
                declaredMethod.setAccessible(true);
            }
        } catch (NoSuchMethodException unused2) {
            String str4 = "is" + str2;
            try {
                try {
                    try {
                        this.f4740d = cls.getMethod(str4, null);
                    } catch (NoSuchMethodException unused3) {
                        Field field = cls.getField(str);
                        this.f4741e = field;
                        Class<?> type = field.getType();
                        if (a((Class) cls2, (Class) type)) {
                            return;
                        }
                        throw new r2("Underlying type (" + type + ") does not match Property type (" + cls2 + ")");
                    }
                } catch (NoSuchMethodException unused4) {
                    Method declaredMethod2 = cls.getDeclaredMethod(str4, null);
                    this.f4740d = declaredMethod2;
                    declaredMethod2.setAccessible(true);
                }
            } catch (NoSuchFieldException unused5) {
                throw new r2("No accessor method or field found for property with name " + str);
            }
        }
        Class<?> returnType = this.f4740d.getReturnType();
        if (!a((Class) cls2, (Class) returnType)) {
            throw new r2("Underlying type (" + returnType + ") does not match Property type (" + cls2 + ")");
        }
        try {
            Method declaredMethod3 = cls.getDeclaredMethod(f4738h + str2, returnType);
            this.f4739c = declaredMethod3;
            declaredMethod3.setAccessible(true);
        } catch (NoSuchMethodException unused6) {
        }
    }

    @Override // com.acse.ottn.g3
    public boolean c() {
        return this.f4739c == null && this.f4741e == null;
    }

    @Override // com.acse.ottn.g3
    public void a(T t5, V v5) {
        Method method = this.f4739c;
        if (method != null) {
            try {
                method.invoke(t5, v5);
                return;
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (InvocationTargetException e6) {
                throw new RuntimeException(e6.getCause());
            }
        }
        Field field = this.f4741e;
        if (field != null) {
            try {
                field.set(t5, v5);
            } catch (IllegalAccessException unused2) {
                throw new AssertionError();
            }
        } else {
            throw new UnsupportedOperationException("Property " + a() + " is read-only");
        }
    }

    @Override // com.acse.ottn.g3
    public V a(T t5) {
        Method method = this.f4740d;
        if (method != null) {
            try {
                return (V) method.invoke(t5, null);
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (InvocationTargetException e6) {
                throw new RuntimeException(e6.getCause());
            }
        }
        Field field = this.f4741e;
        if (field != null) {
            try {
                return (V) field.get(t5);
            } catch (IllegalAccessException unused2) {
                throw new AssertionError();
            }
        }
        throw new AssertionError();
    }
}
