package com.bytedance.pangle.xt.xt;

import com.bytedance.pangle.log.ZeusLogger;
import java.lang.reflect.Method;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {
    private static Method cw;

    /* renamed from: j, reason: collision with root package name */
    private static Method f25565j;

    /* renamed from: r, reason: collision with root package name */
    private static Method f25566r;
    private static Method xt;

    /* JADX WARN: Removed duplicated region for block: B:17:0x0046 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.reflect.Field j(java.lang.Class<?> r8, java.lang.String r9) {
        /*
            java.lang.reflect.Method r0 = com.bytedance.pangle.xt.xt.j.f25565j
            r1 = 0
            if (r0 == 0) goto L44
            r2 = 0
            r3 = 1
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L1b
            r4[r2] = r9     // Catch: java.lang.Throwable -> L1b
            java.lang.Object r0 = r0.invoke(r8, r4)     // Catch: java.lang.Throwable -> L1b
            java.lang.reflect.Field r0 = (java.lang.reflect.Field) r0     // Catch: java.lang.Throwable -> L1b
            if (r0 == 0) goto L19
            r0.setAccessible(r3)     // Catch: java.lang.Throwable -> L17
            goto L19
        L17:
            r1 = move-exception
            goto L1f
        L19:
            r1 = r0
            goto L44
        L1b:
            r0 = move-exception
            r7 = r1
            r1 = r0
            r0 = r7
        L1f:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "DoubleReflector"
            r4.<init>(r5)
            java.lang.String r5 = r8.getName()
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]
            r6[r2] = r5
            r6[r3] = r9
            java.lang.String r2 = "getField %s#%s failed !!!"
            java.lang.String r2 = java.lang.String.format(r2, r6)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            java.lang.String r3 = "Zeus_pangle"
            com.bytedance.pangle.log.ZeusLogger.w(r3, r2, r1)
            goto L19
        L44:
            if (r1 == 0) goto L47
            return r1
        L47:
            java.lang.reflect.Field r8 = com.bytedance.pangle.xt.j.j.j(r8, r9)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.xt.xt.j.j(java.lang.Class, java.lang.String):java.lang.reflect.Field");
    }

    static {
        try {
            f25565j = Class.class.getDeclaredMethod("getDeclaredField", String.class);
            xt = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            cw = Class.class.getDeclaredMethod("getDeclaredConstructor", Class[].class);
            f25566r = Class.class.getDeclaredMethod("forName", String.class);
        } catch (Throwable th) {
            ZeusLogger.errReport(ZeusLogger.TAG_INIT, "DoubleReflectorinit failed", th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0048 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.reflect.Method j(java.lang.Class<?> r8, java.lang.String r9, java.lang.Class<?>... r10) {
        /*
            java.lang.reflect.Method r0 = com.bytedance.pangle.xt.xt.j.xt
            r1 = 0
            if (r0 == 0) goto L46
            r2 = 0
            r3 = 2
            r4 = 1
            java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L1e
            r5[r2] = r9     // Catch: java.lang.Throwable -> L1e
            r5[r4] = r10     // Catch: java.lang.Throwable -> L1e
            java.lang.Object r0 = r0.invoke(r8, r5)     // Catch: java.lang.Throwable -> L1e
            java.lang.reflect.Method r0 = (java.lang.reflect.Method) r0     // Catch: java.lang.Throwable -> L1e
            if (r0 == 0) goto L1c
            r0.setAccessible(r4)     // Catch: java.lang.Throwable -> L1a
            goto L1c
        L1a:
            r1 = move-exception
            goto L22
        L1c:
            r1 = r0
            goto L46
        L1e:
            r0 = move-exception
            r7 = r1
            r1 = r0
            r0 = r7
        L22:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "DoubleReflector"
            r5.<init>(r6)
            java.lang.String r6 = r8.getName()
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r2] = r6
            r3[r4] = r9
            java.lang.String r2 = "getMethod %s#%s failed !!!"
            java.lang.String r2 = java.lang.String.format(r2, r3)
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            java.lang.String r3 = "Zeus_pangle"
            com.bytedance.pangle.log.ZeusLogger.w(r3, r2, r1)
            goto L1c
        L46:
            if (r1 == 0) goto L49
            return r1
        L49:
            java.lang.reflect.Method r8 = com.bytedance.pangle.xt.j.j.j(r8, r9, r10)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.xt.xt.j.j(java.lang.Class, java.lang.String, java.lang.Class[]):java.lang.reflect.Method");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0042 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.reflect.Constructor j(java.lang.Class<?> r7, java.lang.Class<?>... r8) {
        /*
            java.lang.reflect.Method r0 = com.bytedance.pangle.xt.xt.j.cw
            if (r0 == 0) goto L3f
            r1 = 1
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L11
            r3[r2] = r8     // Catch: java.lang.Throwable -> L11
            java.lang.Object r0 = r0.invoke(r7, r3)     // Catch: java.lang.Throwable -> L11
            java.lang.reflect.Constructor r0 = (java.lang.reflect.Constructor) r0     // Catch: java.lang.Throwable -> L11
            goto L40
        L11:
            r0 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "DoubleReflector"
            r3.<init>(r4)
            java.lang.String r4 = r7.getName()
            if (r8 == 0) goto L21
            int r5 = r8.length
            goto L22
        L21:
            r5 = 0
        L22:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]
            r6[r2] = r4
            r6[r1] = r5
            java.lang.String r1 = "getConstructor %s<init>%s failed !!!"
            java.lang.String r1 = java.lang.String.format(r1, r6)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            java.lang.String r2 = "Zeus_pangle"
            com.bytedance.pangle.log.ZeusLogger.w(r2, r1, r0)
        L3f:
            r0 = 0
        L40:
            if (r0 == 0) goto L43
            return r0
        L43:
            java.lang.reflect.Constructor r7 = com.bytedance.pangle.xt.j.j.j(r7, r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.xt.xt.j.j(java.lang.Class, java.lang.Class[]):java.lang.reflect.Constructor");
    }
}
