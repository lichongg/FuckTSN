package com.baidu.mobads.sdk.internal;

import android.content.Context;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class au {

    /* renamed from: c, reason: collision with root package name */
    private static volatile Map<String, au> f10646c = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    private Class<?> f10647a;

    /* renamed from: b, reason: collision with root package name */
    private Method[] f10648b;

    public static au a(Context context, String str) {
        if (!f10646c.containsKey(str) || f10646c.get(str).f10647a == null) {
            synchronized (au.class) {
                try {
                    if (f10646c.containsKey(str)) {
                        if (f10646c.get(str).f10647a == null) {
                        }
                    }
                    f10646c.put(str, new au(context, str));
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f10646c.get(str);
    }

    public Object b(Object obj, String str, Object... objArr) {
        try {
            Method a6 = a(str);
            if (a6 != null) {
                if (objArr != null && objArr.length != 0) {
                    return a6.invoke(obj, objArr);
                }
                return a6.invoke(obj, null);
            }
        } catch (Throwable th) {
            bu.a().a(th);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001c A[Catch: all -> 0x0012, TRY_LEAVE, TryCatch #0 {all -> 0x0012, blocks: (B:3:0x0001, B:6:0x0009, B:9:0x000d, B:10:0x0018, B:12:0x001c, B:16:0x0014), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String c(java.lang.Object r3, java.lang.String r4, java.lang.Object... r5) {
        /*
            r2 = this;
            r0 = 0
            java.lang.reflect.Method r4 = r2.a(r4)     // Catch: java.lang.Throwable -> L12
            if (r4 == 0) goto L26
            if (r5 == 0) goto L14
            int r1 = r5.length     // Catch: java.lang.Throwable -> L12
            if (r1 != 0) goto Ld
            goto L14
        Ld:
            java.lang.Object r3 = r4.invoke(r3, r5)     // Catch: java.lang.Throwable -> L12
            goto L18
        L12:
            r3 = move-exception
            goto L1f
        L14:
            java.lang.Object r3 = r4.invoke(r3, r0)     // Catch: java.lang.Throwable -> L12
        L18:
            boolean r4 = r3 instanceof java.lang.String     // Catch: java.lang.Throwable -> L12
            if (r4 == 0) goto L26
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L12
            return r3
        L1f:
            com.baidu.mobads.sdk.internal.bu r4 = com.baidu.mobads.sdk.internal.bu.a()
            r4.a(r3)
        L26:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.au.c(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.String");
    }

    private au(Context context, String str) {
        this.f10648b = null;
        try {
            Class<?> cls = Class.forName(str, true, bt.a(context));
            this.f10647a = cls;
            this.f10648b = cls.getMethods();
        } catch (Throwable th) {
            bu.a().a(th);
        }
    }

    public Object a(Class<?>[] clsArr, Object... objArr) {
        Constructor<?> constructor;
        if (objArr != null) {
            try {
                if (objArr.length != 0) {
                    constructor = this.f10647a.getConstructor(clsArr);
                    return constructor.newInstance(objArr);
                }
            } catch (Throwable th) {
                bu.a().a(th);
                return null;
            }
        }
        constructor = this.f10647a.getConstructor(null);
        return constructor.newInstance(objArr);
    }

    public void a(Object obj, String str, Object... objArr) {
        try {
            Method a6 = a(str);
            if (a6 != null) {
                if (objArr != null && objArr.length != 0) {
                    a6.invoke(obj, objArr);
                    return;
                }
                a6.invoke(obj, null);
            }
        } catch (Throwable th) {
            bu.a().a(th);
        }
    }

    private Method a(String str) {
        Method[] methodArr = this.f10648b;
        if (methodArr == null) {
            return null;
        }
        for (Method method : methodArr) {
            if (method.getName().equals(str)) {
                method.setAccessible(true);
                return method;
            }
        }
        return null;
    }
}
