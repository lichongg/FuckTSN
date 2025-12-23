package com.huawei.agconnect.core.a;

import android.content.Context;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes5.dex */
public final class d {

    /* renamed from: c, reason: collision with root package name */
    private static Map<Class<?>, com.huawei.agconnect.core.b> f32973c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private static Map<Class<?>, Object> f32974d = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    private Map<Class<?>, com.huawei.agconnect.core.b> f32975a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private Map<Class<?>, Object> f32976b = new HashMap();

    private Object a(com.huawei.agconnect.d dVar, com.huawei.agconnect.core.b bVar) {
        if (bVar.g() != null) {
            return bVar.g();
        }
        Class<?> type = bVar.getType();
        if (type == null) {
            return null;
        }
        try {
            Constructor c6 = c(type, Context.class, com.huawei.agconnect.d.class);
            if (c6 != null) {
                return c6.newInstance(dVar.getContext(), dVar);
            }
            Constructor c7 = c(type, Context.class);
            return c7 != null ? c7.newInstance(dVar.getContext()) : type.newInstance();
        } catch (IllegalAccessException e6) {
            e = e6;
            e.getLocalizedMessage();
            return null;
        } catch (InstantiationException e7) {
            e = e7;
            e.getLocalizedMessage();
            return null;
        } catch (InvocationTargetException e8) {
            e = e8;
            e.getLocalizedMessage();
            return null;
        }
    }

    public <T> T b(com.huawei.agconnect.d dVar, Class<?> cls) {
        T t5;
        com.huawei.agconnect.core.b bVar = this.f32975a.get(cls);
        if (bVar == null && (bVar = f32973c.get(cls)) != null) {
            return (T) f32974d.get(cls);
        }
        if (bVar == null) {
            return null;
        }
        if (bVar.k() && (t5 = (T) this.f32976b.get(cls)) != null) {
            return t5;
        }
        T t6 = (T) a(dVar, bVar);
        if (t6 != null && bVar.k()) {
            this.f32976b.put(cls, t6);
        }
        return t6;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005d A[Catch: InvocationTargetException -> 0x0066, InstantiationException -> 0x0068, IllegalAccessException -> 0x006a, TryCatch #2 {IllegalAccessException -> 0x006a, InstantiationException -> 0x0068, InvocationTargetException -> 0x0066, blocks: (B:20:0x004b, B:24:0x005d, B:25:0x0074, B:28:0x006c), top: B:19:0x004b }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006c A[Catch: InvocationTargetException -> 0x0066, InstantiationException -> 0x0068, IllegalAccessException -> 0x006a, TryCatch #2 {IllegalAccessException -> 0x006a, InstantiationException -> 0x0068, InvocationTargetException -> 0x0066, blocks: (B:20:0x004b, B:24:0x005d, B:25:0x0074, B:28:0x006c), top: B:19:0x004b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void e(java.util.List<com.huawei.agconnect.core.b> r7, android.content.Context r8) {
        /*
            r6 = this;
            if (r7 != 0) goto L4
            goto L8a
        L4:
            java.util.Iterator r7 = r7.iterator()
        L8:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L8a
            java.lang.Object r0 = r7.next()
            com.huawei.agconnect.core.b r0 = (com.huawei.agconnect.core.b) r0
            boolean r1 = r0.j()
            if (r1 == 0) goto L30
            java.util.Map<java.lang.Class<?>, com.huawei.agconnect.core.b> r1 = com.huawei.agconnect.core.a.d.f32973c
            java.lang.Class r2 = r0.h()
            boolean r1 = r1.containsKey(r2)
            if (r1 != 0) goto L33
            java.util.Map<java.lang.Class<?>, com.huawei.agconnect.core.b> r1 = com.huawei.agconnect.core.a.d.f32973c
        L28:
            java.lang.Class r2 = r0.h()
            r1.put(r2, r0)
            goto L33
        L30:
            java.util.Map<java.lang.Class<?>, com.huawei.agconnect.core.b> r1 = r6.f32975a
            goto L28
        L33:
            boolean r1 = r0.i()
            if (r1 == 0) goto L8
            java.lang.Class r1 = r0.getType()
            if (r1 == 0) goto L8
            java.util.Map<java.lang.Class<?>, java.lang.Object> r1 = com.huawei.agconnect.core.a.d.f32974d
            java.lang.Class r2 = r0.h()
            boolean r1 = r1.containsKey(r2)
            if (r1 != 0) goto L8
            java.lang.Class r1 = r0.getType()     // Catch: java.lang.reflect.InvocationTargetException -> L66 java.lang.InstantiationException -> L68 java.lang.IllegalAccessException -> L6a
            r2 = 1
            java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch: java.lang.reflect.InvocationTargetException -> L66 java.lang.InstantiationException -> L68 java.lang.IllegalAccessException -> L6a
            java.lang.Class<android.content.Context> r4 = android.content.Context.class
            r5 = 0
            r3[r5] = r4     // Catch: java.lang.reflect.InvocationTargetException -> L66 java.lang.InstantiationException -> L68 java.lang.IllegalAccessException -> L6a
            java.lang.reflect.Constructor r1 = c(r1, r3)     // Catch: java.lang.reflect.InvocationTargetException -> L66 java.lang.InstantiationException -> L68 java.lang.IllegalAccessException -> L6a
            if (r1 == 0) goto L6c
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.reflect.InvocationTargetException -> L66 java.lang.InstantiationException -> L68 java.lang.IllegalAccessException -> L6a
            r2[r5] = r8     // Catch: java.lang.reflect.InvocationTargetException -> L66 java.lang.InstantiationException -> L68 java.lang.IllegalAccessException -> L6a
            java.lang.Object r1 = r1.newInstance(r2)     // Catch: java.lang.reflect.InvocationTargetException -> L66 java.lang.InstantiationException -> L68 java.lang.IllegalAccessException -> L6a
            goto L74
        L66:
            r0 = move-exception
            goto L7e
        L68:
            r0 = move-exception
            goto L84
        L6a:
            r0 = move-exception
            goto L87
        L6c:
            java.lang.Class r1 = r0.getType()     // Catch: java.lang.reflect.InvocationTargetException -> L66 java.lang.InstantiationException -> L68 java.lang.IllegalAccessException -> L6a
            java.lang.Object r1 = r1.newInstance()     // Catch: java.lang.reflect.InvocationTargetException -> L66 java.lang.InstantiationException -> L68 java.lang.IllegalAccessException -> L6a
        L74:
            java.util.Map<java.lang.Class<?>, java.lang.Object> r2 = com.huawei.agconnect.core.a.d.f32974d     // Catch: java.lang.reflect.InvocationTargetException -> L66 java.lang.InstantiationException -> L68 java.lang.IllegalAccessException -> L6a
            java.lang.Class r0 = r0.h()     // Catch: java.lang.reflect.InvocationTargetException -> L66 java.lang.InstantiationException -> L68 java.lang.IllegalAccessException -> L6a
            r2.put(r0, r1)     // Catch: java.lang.reflect.InvocationTargetException -> L66 java.lang.InstantiationException -> L68 java.lang.IllegalAccessException -> L6a
            goto L8
        L7e:
            java.lang.String r1 = "TargetException"
        L80:
            r6.d(r1, r0)
            goto L8
        L84:
            java.lang.String r1 = "InstantiationException"
            goto L80
        L87:
            java.lang.String r1 = "AccessException"
            goto L80
        L8a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.agconnect.core.a.d.e(java.util.List, android.content.Context):void");
    }

    d(List<com.huawei.agconnect.core.b> list, Context context) {
        e(list, context);
    }

    private static Constructor c(Class cls, Class... clsArr) {
        boolean z5 = false;
        for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length == clsArr.length) {
                for (int i6 = 0; i6 < clsArr.length; i6++) {
                    if (parameterTypes[i6] == clsArr[i6]) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                }
                if (z5) {
                    return constructor;
                }
            }
        }
        return null;
    }

    private void d(String str, Exception exc) {
        exc.getLocalizedMessage();
        if (exc.getCause() != null) {
            exc.getCause().getMessage();
        }
    }
}
