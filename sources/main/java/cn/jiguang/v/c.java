package cn.jiguang.v;

import cn.jiguang.bz.l;
import java.lang.reflect.Method;

/* loaded from: D:\Downloads\app\classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f3298a = {90, 65, 111, 105, 56, 125, 81, 78, 126, 38, 68, 100, 94, 84, 112, 101, 115};

    /* renamed from: b, reason: collision with root package name */
    private static final byte[] f3299b = {118, 85, 84, 75, 125, 120, 101, 89, 77, 124};

    /* renamed from: c, reason: collision with root package name */
    private static final byte[] f3300c = {116, 72, 69, 122};

    /* renamed from: d, reason: collision with root package name */
    private static final byte[] f3301d = {39, 101, 104, 67, 84, 124, 101, 57, 115, 89, 78, 54, 123, 126};

    public static Process a(Object[] objArr) {
        try {
            Class<?> cls = Class.forName(l.b(f3298a));
            Method declaredMethod = cls.getDeclaredMethod(l.b(f3299b), null);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, null);
            Method declaredMethod2 = cls.getDeclaredMethod(l.b(f3300c), String.class);
            declaredMethod2.setAccessible(true);
            return (Process) declaredMethod2.invoke(invoke, objArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x005f, code lost:
    
        if (r2 != null) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b2, code lost:
    
        if (r2 == null) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<java.lang.String> a(java.lang.String[] r8, int r9) {
        /*
            java.lang.String r0 = "executeCommand "
            java.lang.String r1 = "JCommonShellHelper"
            r2 = 0
            if (r9 == 0) goto Ld
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            goto Le
        Ld:
            r3 = r2
        Le:
            java.lang.Process r2 = a(r8)     // Catch: java.lang.Throwable -> L13
            goto L30
        L13:
            int r4 = r8.length     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
            r5 = 2
            int r4 = r4 + r5
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
            byte[] r6 = cn.jiguang.v.c.f3301d     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
            java.lang.String r6 = cn.jiguang.bz.l.b(r6)     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
            java.lang.String r7 = "-c"
            java.lang.String[] r6 = new java.lang.String[]{r6, r7}     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
            r7 = 0
            java.lang.System.arraycopy(r6, r7, r4, r7, r5)     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
            int r6 = r8.length     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
            java.lang.System.arraycopy(r8, r7, r4, r5, r6)     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
            java.lang.Process r2 = a(r4)     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
        L30:
            if (r9 == 0) goto L5f
            if (r2 == 0) goto L5f
            java.io.BufferedReader r9 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
            java.io.InputStream r5 = r2.getInputStream()     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
            r9.<init>(r4)     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
        L42:
            java.lang.String r4 = r9.readLine()     // Catch: java.lang.Throwable -> L4c
            if (r4 == 0) goto L4e
            r3.add(r4)     // Catch: java.lang.Throwable -> L4c
            goto L42
        L4c:
            r4 = move-exception
            goto L56
        L4e:
            r9.close()     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
            goto L5f
        L52:
            r9 = move-exception
            goto L69
        L54:
            r9 = move-exception
            goto L90
        L56:
            r9.close()     // Catch: java.lang.Throwable -> L5a
            goto L5e
        L5a:
            r9 = move-exception
            r4.addSuppressed(r9)     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
        L5e:
            throw r4     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54
        L5f:
            if (r2 == 0) goto Lb5
        L61:
            r2.exitValue()     // Catch: java.lang.IllegalThreadStateException -> L65
            goto Lb5
        L65:
            r2.destroy()
            goto Lb5
        L69:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8e
            r4.<init>()     // Catch: java.lang.Throwable -> L8e
            r4.append(r0)     // Catch: java.lang.Throwable -> L8e
            java.lang.String r8 = java.util.Arrays.toString(r8)     // Catch: java.lang.Throwable -> L8e
            r4.append(r8)     // Catch: java.lang.Throwable -> L8e
            java.lang.String r8 = " throwable: "
            r4.append(r8)     // Catch: java.lang.Throwable -> L8e
            java.lang.String r8 = r9.getMessage()     // Catch: java.lang.Throwable -> L8e
            r4.append(r8)     // Catch: java.lang.Throwable -> L8e
            java.lang.String r8 = r4.toString()     // Catch: java.lang.Throwable -> L8e
            cn.jiguang.bb.f.i(r1, r8)     // Catch: java.lang.Throwable -> L8e
            if (r2 == 0) goto Lb5
            goto L61
        L8e:
            r8 = move-exception
            goto Lb6
        L90:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8e
            r4.<init>()     // Catch: java.lang.Throwable -> L8e
            r4.append(r0)     // Catch: java.lang.Throwable -> L8e
            java.lang.String r8 = java.util.Arrays.toString(r8)     // Catch: java.lang.Throwable -> L8e
            r4.append(r8)     // Catch: java.lang.Throwable -> L8e
            java.lang.String r8 = " exception: "
            r4.append(r8)     // Catch: java.lang.Throwable -> L8e
            java.lang.String r8 = r9.getMessage()     // Catch: java.lang.Throwable -> L8e
            r4.append(r8)     // Catch: java.lang.Throwable -> L8e
            java.lang.String r8 = r4.toString()     // Catch: java.lang.Throwable -> L8e
            cn.jiguang.bb.f.i(r1, r8)     // Catch: java.lang.Throwable -> L8e
            if (r2 == 0) goto Lb5
            goto L61
        Lb5:
            return r3
        Lb6:
            if (r2 == 0) goto Lbf
            r2.exitValue()     // Catch: java.lang.IllegalThreadStateException -> Lbc
            goto Lbf
        Lbc:
            r2.destroy()
        Lbf:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.v.c.a(java.lang.String[], int):java.util.List");
    }
}
