package com.acse.ottn;

import android.os.Build;
import android.text.TextUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class n3 {

    /* renamed from: a, reason: collision with root package name */
    public static final String f4931a = "RomUtils";

    /* JADX WARN: Removed duplicated region for block: B:29:0x0069 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.lang.String r7) {
        /*
            java.lang.String r0 = "Exception while closing InputStream"
            java.lang.String r1 = "RomUtils"
            r2 = 0
            java.lang.Runtime r3 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L46
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L46
            r4.<init>()     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L46
            java.lang.String r5 = "getprop "
            r4.append(r5)     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L46
            r4.append(r7)     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L46
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L46
            java.lang.Process r3 = r3.exec(r4)     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L46
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L46
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L46
            java.io.InputStream r3 = r3.getInputStream()     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L46
            r5.<init>(r3)     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L46
            r3 = 1024(0x400, float:1.435E-42)
            r4.<init>(r5, r3)     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L46
            java.lang.String r3 = r4.readLine()     // Catch: java.lang.Throwable -> L3e java.io.IOException -> L40
            r4.close()     // Catch: java.lang.Throwable -> L3e java.io.IOException -> L40
            r4.close()     // Catch: java.io.IOException -> L39
            return r3
        L39:
            r7 = move-exception
            com.acse.ottn.c2.a(r1, r0, r7)
            return r3
        L3e:
            r7 = move-exception
            goto L42
        L40:
            r3 = move-exception
            goto L48
        L42:
            r2 = r4
            goto L67
        L44:
            r7 = move-exception
            goto L67
        L46:
            r3 = move-exception
            r4 = r2
        L48:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3e
            r5.<init>()     // Catch: java.lang.Throwable -> L3e
            java.lang.String r6 = "Unable to read sysprop "
            r5.append(r6)     // Catch: java.lang.Throwable -> L3e
            r5.append(r7)     // Catch: java.lang.Throwable -> L3e
            java.lang.String r7 = r5.toString()     // Catch: java.lang.Throwable -> L3e
            com.acse.ottn.c2.a(r1, r7, r3)     // Catch: java.lang.Throwable -> L3e
            if (r4 == 0) goto L66
            r4.close()     // Catch: java.io.IOException -> L62
            goto L66
        L62:
            r7 = move-exception
            com.acse.ottn.c2.a(r1, r0, r7)
        L66:
            return r2
        L67:
            if (r2 == 0) goto L71
            r2.close()     // Catch: java.io.IOException -> L6d
            goto L71
        L6d:
            r2 = move-exception
            com.acse.ottn.c2.a(r1, r0, r2)
        L71:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.acse.ottn.n3.a(java.lang.String):java.lang.String");
    }

    public static boolean b() {
        return Build.MANUFACTURER.contains("HUAWEI");
    }

    public static boolean c() {
        String a6 = a("ro.build.display.id");
        if (TextUtils.isEmpty(a6)) {
            return false;
        }
        return a6.contains("flyme") || a6.toLowerCase().contains("flyme");
    }

    public static boolean d() {
        return !TextUtils.isEmpty(a("ro.miui.ui.version.name"));
    }

    public static boolean e() {
        String str = Build.MANUFACTURER;
        return str.contains("OPPO") || str.contains("oppo");
    }

    public static double f() {
        try {
            String a6 = a("ro.build.version.emui");
            return Double.parseDouble(a6.substring(a6.indexOf("_") + 1));
        } catch (Exception e6) {
            e6.printStackTrace();
            return 4.0d;
        }
    }

    public static int g() {
        String a6 = a("ro.miui.ui.version.name");
        if (a6 == null) {
            return -1;
        }
        try {
            return Integer.parseInt(a6.substring(1));
        } catch (Exception unused) {
            c2.b(f4931a, "get miui version code error, version : " + a6);
            return -1;
        }
    }

    public static boolean a() {
        String str = Build.MANUFACTURER;
        return str.contains("QiKU") || str.contains("360");
    }
}
