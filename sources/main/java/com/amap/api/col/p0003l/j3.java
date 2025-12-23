package com.amap.api.col.p0003l;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class j3 {

    /* renamed from: a, reason: collision with root package name */
    private boolean f6620a = false;

    /* renamed from: b, reason: collision with root package name */
    ArrayList<a> f6621b = new ArrayList<>();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f6622a;

        /* renamed from: b, reason: collision with root package name */
        private Object f6623b;

        /* renamed from: c, reason: collision with root package name */
        private Class<?>[] f6624c;

        /* renamed from: d, reason: collision with root package name */
        private Object[] f6625d;

        public a(Object obj, String str, Object... objArr) {
            this.f6623b = obj;
            this.f6622a = str;
            if (objArr != null && objArr.length > 0) {
                this.f6624c = new Class[objArr.length];
                for (int i6 = 0; i6 < objArr.length; i6++) {
                    this.f6624c[i6] = objArr[i6].getClass();
                }
                this.f6625d = new Object[objArr.length];
                for (int i7 = 0; i7 < objArr.length; i7++) {
                    this.f6625d[i7] = objArr[i7];
                }
            }
        }
    }

    public final synchronized void a() {
        Method method;
        if (this.f6620a) {
            return;
        }
        this.f6620a = true;
        for (int i6 = 0; i6 < this.f6621b.size(); i6++) {
            a aVar = this.f6621b.get(i6);
            try {
                try {
                    try {
                        if (aVar.f6623b != null) {
                            Class<?> cls = aVar.f6623b.getClass();
                            try {
                                method = cls.getDeclaredMethod(aVar.f6622a, aVar.f6624c);
                            } catch (NoSuchMethodException unused) {
                                if (aVar.f6624c.length > 0) {
                                    Class<?>[] clsArr = new Class[aVar.f6624c.length];
                                    for (int i7 = 0; i7 < aVar.f6624c.length; i7++) {
                                        if (aVar.f6624c[i7].getInterfaces().length > 0) {
                                            clsArr[i7] = aVar.f6624c[i7].getInterfaces()[0];
                                        }
                                    }
                                    method = cls.getDeclaredMethod(aVar.f6622a, clsArr);
                                } else {
                                    method = null;
                                }
                            }
                            if (method != null) {
                                method.setAccessible(true);
                                method.invoke(aVar.f6623b, aVar.f6625d);
                            }
                        }
                    } catch (IllegalArgumentException e6) {
                        e6.printStackTrace();
                    } catch (InvocationTargetException e7) {
                        e7.printStackTrace();
                    }
                } catch (IllegalAccessException e8) {
                    e8.printStackTrace();
                } catch (SecurityException e9) {
                    e9.printStackTrace();
                }
            } catch (NoSuchMethodException e10) {
                e10.printStackTrace();
            }
        }
        this.f6621b.clear();
    }

    public final synchronized void b(Object obj, Object... objArr) {
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace != null && stackTrace.length >= 3) {
                this.f6621b.add(new a(obj, stackTrace[3].getMethodName(), objArr));
            }
        } catch (Throwable unused) {
        }
        this.f6620a = false;
    }
}
