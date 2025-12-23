package com.amap.api.col.p0003l;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.umeng.analytics.pro.bm;
import java.io.File;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class f4 {

    /* renamed from: a, reason: collision with root package name */
    private static String f6166a = "";

    /* renamed from: b, reason: collision with root package name */
    private static String f6167b = "";

    /* renamed from: c, reason: collision with root package name */
    private static String f6168c = "";

    /* renamed from: d, reason: collision with root package name */
    private static String f6169d = "";

    /* renamed from: e, reason: collision with root package name */
    static String f6170e;

    /* renamed from: f, reason: collision with root package name */
    static boolean f6171f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a extends b8 {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f6172d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f6173e;

        @Override // com.amap.api.col.p0003l.b8
        public final void runTask() {
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    File file = new File(s5.i(this.f6172d, "k.store"));
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        fileOutputStream2.write(q4.o(this.f6173e));
                        fileOutputStream2.close();
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        try {
                            r5.e(th, "AI", bm.f41038c);
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                        } catch (Throwable th2) {
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Throwable th3) {
                                    th3.printStackTrace();
                                }
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }

        a(Context context, String str) {
            this.f6172d = context;
            this.f6173e = str;
        }
    }

    static boolean d() {
        if (f6171f) {
            return true;
        }
        if (f(f6170e)) {
            f6171f = true;
            return true;
        }
        if (!TextUtils.isEmpty(f6170e)) {
            f6171f = false;
            f6170e = null;
            return false;
        }
        if (f(f6167b)) {
            f6171f = true;
            return true;
        }
        if (!TextUtils.isEmpty(f6167b)) {
            f6171f = false;
            f6167b = null;
            return false;
        }
        return true;
    }

    public static void c(String str) {
        f6167b = str;
    }

    public static String e(Context context) {
        try {
        } catch (Throwable th) {
            r5.e(th, "AI", "gAN");
        }
        if (!"".equals(f6166a)) {
            return f6166a;
        }
        PackageManager packageManager = context.getPackageManager();
        f6166a = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
        return f6166a;
    }

    public static String g(Context context) {
        String str;
        try {
            str = f6167b;
        } catch (Throwable th) {
            r5.e(th, "AI", "gpck");
        }
        if (str != null && !"".equals(str)) {
            return f6167b;
        }
        String packageName = context.getPackageName();
        f6167b = packageName;
        if (!f(packageName)) {
            f6167b = context.getPackageName();
        }
        return f6167b;
    }

    public static String h(Context context) {
        try {
        } catch (Throwable th) {
            r5.e(th, "AI", "gAV");
        }
        if (!"".equals(f6168c)) {
            return f6168c;
        }
        f6168c = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        String str = f6168c;
        return str == null ? "" : str;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String k(android.content.Context r6) {
        /*
            java.lang.String r0 = "k.store"
            java.lang.String r6 = com.amap.api.col.p0003l.s5.i(r6, r0)
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
            java.lang.String r6 = com.amap.api.col.p0003l.q4.g(r6)     // Catch: java.lang.Throwable -> L39
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
            com.amap.api.col.p0003l.r5.e(r6, r3, r4)     // Catch: java.lang.Throwable -> L5f
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
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.f4.k(android.content.Context):java.lang.String");
    }

    private static String l(Context context) throws PackageManager.NameNotFoundException {
        Bundle bundle;
        String str = f6169d;
        if (str == null || str.equals("")) {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                return f6169d;
            }
            String string = bundle.getString("com.amap.api.v2.apikey");
            f6169d = string;
            if (string == null) {
                f6169d = k(context);
            }
        }
        return f6169d;
    }

    public static String a(Context context) {
        try {
            return l(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return f6169d;
        }
    }

    static void b(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            f6169d = str;
            if (context != null) {
                a8.h().b(new a(context, str));
            }
        }
    }

    private static boolean f(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        str.toCharArray();
        for (char c6 : str.toCharArray()) {
            if (('A' > c6 || c6 > 'z') && (('0' > c6 || c6 > ':') && c6 != '.')) {
                try {
                    v5.o(q4.a(), str, "errorPackage");
                } catch (Throwable unused) {
                }
                return false;
            }
        }
        return true;
    }

    public static String i(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            byte[] digest = MessageDigest.getInstance(q4.u("IU0hBMQ")).digest(packageInfo.signatures[0].toByteArray());
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
            if (f(str)) {
                str = packageInfo.packageName;
            }
            if (!TextUtils.isEmpty(f6167b)) {
                str = g(context);
            }
            stringBuffer.append(str);
            String stringBuffer2 = stringBuffer.toString();
            f6170e = stringBuffer2;
            return stringBuffer2;
        } catch (Throwable th) {
            r5.e(th, "AI", "gsp");
            return f6170e;
        }
    }

    public static String j(Context context) {
        try {
            g4.g(context);
        } catch (Throwable unused) {
        }
        try {
            return l(context);
        } catch (Throwable th) {
            r5.e(th, "AI", "gKy");
            return f6169d;
        }
    }
}
