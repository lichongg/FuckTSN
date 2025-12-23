package com.amap.api.col.s;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import java.security.MessageDigest;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class x0 {

    /* renamed from: a, reason: collision with root package name */
    private static String f8607a = "";

    /* renamed from: b, reason: collision with root package name */
    private static String f8608b = "";

    /* renamed from: c, reason: collision with root package name */
    private static String f8609c = "";

    /* renamed from: d, reason: collision with root package name */
    private static String f8610d = "";

    /* renamed from: e, reason: collision with root package name */
    static String f8611e;

    /* renamed from: f, reason: collision with root package name */
    static boolean f8612f;

    static boolean c() {
        if (f8612f) {
            return true;
        }
        if (e(f8611e)) {
            f8612f = true;
            return true;
        }
        if (!TextUtils.isEmpty(f8611e)) {
            f8612f = false;
            f8611e = null;
            return false;
        }
        if (e(f8608b)) {
            f8612f = true;
            return true;
        }
        if (!TextUtils.isEmpty(f8608b)) {
            f8612f = false;
            f8608b = null;
            return false;
        }
        return true;
    }

    public static String d(Context context) {
        try {
        } catch (Throwable th) {
            d2.e(th, "AI", "gAN");
        }
        if (!"".equals(f8607a)) {
            return f8607a;
        }
        PackageManager packageManager = context.getPackageManager();
        f8607a = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
        return f8607a;
    }

    public static String f(Context context) {
        String str;
        try {
            str = f8608b;
        } catch (Throwable th) {
            d2.e(th, "AI", "gpck");
        }
        if (str != null && !"".equals(str)) {
            return f8608b;
        }
        String packageName = context.getPackageName();
        f8608b = packageName;
        if (!e(packageName)) {
            f8608b = context.getPackageName();
        }
        return f8608b;
    }

    public static String g(Context context) {
        try {
        } catch (Throwable th) {
            d2.e(th, "AI", "gAV");
        }
        if (!"".equals(f8609c)) {
            return f8609c;
        }
        f8609c = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        String str = f8609c;
        return str == null ? "" : str;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String j(android.content.Context r6) {
        /*
            java.lang.String r0 = "k.store"
            java.lang.String r6 = com.amap.api.col.s.e2.i(r6, r0)
            java.io.File r0 = new java.io.File
            r0.<init>(r6)
            boolean r6 = r0.exists()
            java.lang.String r1 = ""
            if (r6 != 0) goto L14
            return r1
        L14:
            r6 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L3b
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L3b
            int r6 = r2.available()     // Catch: java.lang.Throwable -> L39
            byte[] r6 = new byte[r6]     // Catch: java.lang.Throwable -> L39
            r2.read(r6)     // Catch: java.lang.Throwable -> L39
            java.lang.String r6 = com.amap.api.col.s.j1.g(r6)     // Catch: java.lang.Throwable -> L39
            int r0 = r6.length()     // Catch: java.lang.Throwable -> L39
            r3 = 32
            if (r0 != r3) goto L30
            r1 = r6
        L30:
            r2.close()     // Catch: java.lang.Throwable -> L34
            return r1
        L34:
            r6 = move-exception
            r6.printStackTrace()
            return r1
        L39:
            r6 = move-exception
            goto L3f
        L3b:
            r2 = move-exception
            r5 = r2
            r2 = r6
            r6 = r5
        L3f:
            java.lang.String r3 = "AI"
            java.lang.String r4 = "gKe"
            com.amap.api.col.s.d2.e(r6, r3, r4)     // Catch: java.lang.Throwable -> L5f
            boolean r6 = r0.exists()     // Catch: java.lang.Throwable -> L50
            if (r6 == 0) goto L54
            r0.delete()     // Catch: java.lang.Throwable -> L50
            goto L54
        L50:
            r6 = move-exception
            r6.printStackTrace()     // Catch: java.lang.Throwable -> L5f
        L54:
            if (r2 == 0) goto L5e
            r2.close()     // Catch: java.lang.Throwable -> L5a
            goto L5e
        L5a:
            r6 = move-exception
            r6.printStackTrace()
        L5e:
            return r1
        L5f:
            r6 = move-exception
            if (r2 == 0) goto L6a
            r2.close()     // Catch: java.lang.Throwable -> L66
            goto L6a
        L66:
            r0 = move-exception
            r0.printStackTrace()
        L6a:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.s.x0.j(android.content.Context):java.lang.String");
    }

    private static String k(Context context) throws PackageManager.NameNotFoundException {
        Bundle bundle;
        String str = f8610d;
        if (str == null || str.equals("")) {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                return f8610d;
            }
            String string = bundle.getString("com.amap.api.v2.apikey");
            f8610d = string;
            if (string == null) {
                f8610d = j(context);
            }
        }
        return f8610d;
    }

    public static String a(Context context) {
        try {
            return k(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return f8610d;
        }
    }

    static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f8610d = str;
    }

    private static boolean e(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        str.toCharArray();
        for (char c6 : str.toCharArray()) {
            if (('A' > c6 || c6 > 'z') && (('0' > c6 || c6 > ':') && c6 != '.')) {
                try {
                    g2.l(j1.a(), str, "errorPackage");
                } catch (Throwable unused) {
                }
                return false;
            }
        }
        return true;
    }

    public static String h(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            byte[] digest = MessageDigest.getInstance(j1.t("IU0hBMQ")).digest(packageInfo.signatures[0].toByteArray());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b6 : digest) {
                String upperCase = Integer.toHexString(b6 & 255).toUpperCase(Locale.US);
                if (upperCase.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(upperCase);
                stringBuffer.append(":");
            }
            String str = packageInfo.packageName;
            if (e(str)) {
                str = packageInfo.packageName;
            }
            if (!TextUtils.isEmpty(f8608b)) {
                str = f(context);
            }
            stringBuffer.append(str);
            String stringBuffer2 = stringBuffer.toString();
            f8611e = stringBuffer2;
            return stringBuffer2;
        } catch (Throwable th) {
            d2.e(th, "AI", "gsp");
            return f8611e;
        }
    }

    public static String i(Context context) {
        try {
            y0.e(context);
        } catch (Throwable unused) {
        }
        try {
            return k(context);
        } catch (Throwable th) {
            d2.e(th, "AI", "gKy");
            return f8610d;
        }
    }
}
