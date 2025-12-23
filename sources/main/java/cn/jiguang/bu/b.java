package cn.jiguang.bu;

import android.content.Context;
import android.os.Build;
import cn.jiguang.bb.f;
import java.io.File;
import java.nio.charset.Charset;

/* loaded from: D:\Downloads\app\classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static final Charset f2567a = Charset.forName("UTF-8");

    /* renamed from: f, reason: collision with root package name */
    private static final byte[] f2568f = {15, 106, 113, 101, 101, 85, 77, 54, 112, 116, 120, 94, 15, 110, 96, Byte.MAX_VALUE, 114, 88};

    /* renamed from: b, reason: collision with root package name */
    private final Context f2569b;

    /* renamed from: c, reason: collision with root package name */
    private final String[] f2570c;

    /* renamed from: d, reason: collision with root package name */
    private final String[] f2571d;

    /* renamed from: e, reason: collision with root package name */
    private final Runtime f2572e;

    public b(Context context) {
        this(context, new String[]{"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su", "/su/bin", "/system/xbin/daemonsu"}, new String[]{"com.devadvance.rootcloak", "com.devadvance.rootcloakplus", "com.koushikdutta.superuser", "com.thirdparty.superuser", "eu.chainfire.supersu", "com.noshufou.android.su"}, Runtime.getRuntime());
    }

    b(Context context, String[] strArr, String[] strArr2, Runtime runtime) {
        this.f2569b = context;
        this.f2570c = strArr;
        this.f2571d = strArr2;
        this.f2572e = runtime;
    }

    private boolean b() {
        String str = Build.TAGS;
        return str != null && str.contains("test-keys");
    }

    private boolean c() {
        for (String str : this.f2570c) {
            try {
            } catch (RuntimeException unused) {
                f.i("RootChecker", String.format("Error when trying to check if root file %s exists.", str));
            }
            if (new File(str).exists()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x007f, code lost:
    
        if (0 == 0) goto L33;
     */
    @android.annotation.TargetApi(19)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean d() {
        /*
            r7 = this;
            java.lang.String r0 = "RootChecker"
            byte[] r1 = cn.jiguang.bu.b.f2568f
            java.lang.String r1 = cn.jiguang.bz.l.b(r1)
            java.lang.String r2 = "su"
            java.lang.String[] r1 = new java.lang.String[]{r1, r2}
            r2 = 0
            r3 = 0
            java.lang.Process r3 = cn.jiguang.v.c.a(r1)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38 java.io.IOException -> L3a
            if (r3 == 0) goto L46
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38 java.io.IOException -> L3a
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38 java.io.IOException -> L3a
            java.io.InputStream r5 = r3.getInputStream()     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38 java.io.IOException -> L3a
            java.nio.charset.Charset r6 = java.nio.charset.StandardCharsets.UTF_8     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38 java.io.IOException -> L3a
            r4.<init>(r5, r6)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38 java.io.IOException -> L3a
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38 java.io.IOException -> L3a
            java.lang.String r4 = r1.readLine()     // Catch: java.lang.Throwable -> L3c
            if (r4 == 0) goto L2e
            r4 = 1
            goto L2f
        L2e:
            r4 = 0
        L2f:
            r1.close()     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38 java.io.IOException -> L3a
            r3.destroy()
            return r4
        L36:
            r0 = move-exception
            goto L83
        L38:
            r1 = move-exception
            goto L4c
        L3a:
            r1 = move-exception
            goto L67
        L3c:
            r4 = move-exception
            r1.close()     // Catch: java.lang.Throwable -> L41
            goto L45
        L41:
            r1 = move-exception
            r4.addSuppressed(r1)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38 java.io.IOException -> L3a
        L45:
            throw r4     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L38 java.io.IOException -> L3a
        L46:
            if (r3 == 0) goto L82
        L48:
            r3.destroy()
            goto L82
        L4c:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L36
            r4.<init>()     // Catch: java.lang.Throwable -> L36
            java.lang.String r5 = "Error when trying to check if SU exists: "
            r4.append(r5)     // Catch: java.lang.Throwable -> L36
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L36
            r4.append(r1)     // Catch: java.lang.Throwable -> L36
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Throwable -> L36
            cn.jiguang.bb.f.i(r0, r1)     // Catch: java.lang.Throwable -> L36
            if (r3 == 0) goto L82
            goto L48
        L67:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L36
            r4.<init>()     // Catch: java.lang.Throwable -> L36
            java.lang.String r5 = "SU isn't found on this Device: "
            r4.append(r5)     // Catch: java.lang.Throwable -> L36
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L36
            r4.append(r1)     // Catch: java.lang.Throwable -> L36
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Throwable -> L36
            cn.jiguang.bb.f.i(r0, r1)     // Catch: java.lang.Throwable -> L36
            if (r3 == 0) goto L82
            goto L48
        L82:
            return r2
        L83:
            if (r3 == 0) goto L88
            r3.destroy()
        L88:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.bu.b.d():boolean");
    }

    public boolean a() {
        if (!b() && !c() && !d()) {
            return false;
        }
        return true;
    }
}
