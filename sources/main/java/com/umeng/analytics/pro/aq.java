package com.umeng.analytics.pro;

import android.text.TextUtils;
import com.acse.ottn.l3;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class aq {

    /* renamed from: a, reason: collision with root package name */
    private static String f40873a = "";

    /* renamed from: b, reason: collision with root package name */
    private static String f40874b = "";

    /* renamed from: c, reason: collision with root package name */
    private static final String f40875c = "hw_sc.build.platform.version";

    /* renamed from: d, reason: collision with root package name */
    private static final String f40876d = "ro.build.version.emui";

    /* renamed from: e, reason: collision with root package name */
    private static final String f40877e = "ro.build.version.magic";

    /* renamed from: f, reason: collision with root package name */
    private static final String f40878f = "ro.miui.ui.version.name";

    /* renamed from: g, reason: collision with root package name */
    private static final String f40879g = "ro.build.version.opporom";

    /* renamed from: h, reason: collision with root package name */
    private static final String f40880h = "ro.vivo.os.name";

    /* renamed from: i, reason: collision with root package name */
    private static final String f40881i = "ro.vivo.os.version";

    /* renamed from: j, reason: collision with root package name */
    private static final String f40882j = "ro.build.version.oplusrom";

    /* renamed from: k, reason: collision with root package name */
    private static final String f40883k = "ro.rom.version";

    private static boolean a() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return !TextUtils.isEmpty((String) cls.getMethod("getOsBrand", null).invoke(cls, null));
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(f40873a)) {
            e(str);
        }
        return f40874b;
    }

    private static String d(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getDeclaredMethod(l3.f4736f, String.class).invoke(cls, str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00af, code lost:
    
        if (r5.equals("XIAOMI") != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00c4, code lost:
    
        if (r5.equals("REALME") != false) goto L46;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void e(java.lang.String r5) {
        /*
            java.lang.String r0 = "ro.build.version.magic"
            java.lang.String r5 = c(r5)     // Catch: java.lang.Throwable -> Ld9
            int r1 = r5.hashCode()     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r2 = "ro.build.version.emui"
            java.lang.String r3 = "EMUI"
            java.lang.String r4 = "ColorOS"
            switch(r1) {
                case -1881642058: goto Lbe;
                case -1706170181: goto La9;
                case -602397472: goto L86;
                case 2432928: goto L7d;
                case 2634924: goto L68;
                case 68924490: goto L42;
                case 77852109: goto L39;
                case 2141820391: goto L15;
                default: goto L13;
            }
        L13:
            goto Ld1
        L15:
            java.lang.String r0 = "HUAWEI"
            boolean r5 = r5.equals(r0)     // Catch: java.lang.Throwable -> Ld9
            if (r5 == 0) goto Ld1
            boolean r5 = a()     // Catch: java.lang.Throwable -> Ld9
            if (r5 == 0) goto L30
            java.lang.String r5 = "hw_sc.build.platform.version"
            java.lang.String r5 = d(r5)     // Catch: java.lang.Throwable -> Ld9
            com.umeng.analytics.pro.aq.f40874b = r5     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r5 = "HarmonyOS"
            com.umeng.analytics.pro.aq.f40873a = r5     // Catch: java.lang.Throwable -> Ld9
            return
        L30:
            com.umeng.analytics.pro.aq.f40873a = r3     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r5 = d(r2)     // Catch: java.lang.Throwable -> Ld9
            com.umeng.analytics.pro.aq.f40874b = r5     // Catch: java.lang.Throwable -> Ld9
            return
        L39:
            java.lang.String r0 = "REDMI"
            boolean r5 = r5.equals(r0)     // Catch: java.lang.Throwable -> Ld9
            if (r5 == 0) goto Ld1
            goto Lb1
        L42:
            java.lang.String r1 = "HONOR"
            boolean r5 = r5.equals(r1)     // Catch: java.lang.Throwable -> Ld9
            if (r5 == 0) goto Ld1
            java.lang.String r5 = d(r0)     // Catch: java.lang.Throwable -> Ld9
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> Ld9
            if (r5 != 0) goto L5f
            java.lang.String r5 = "MagicUI"
            com.umeng.analytics.pro.aq.f40873a = r5     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r5 = d(r0)     // Catch: java.lang.Throwable -> Ld9
            com.umeng.analytics.pro.aq.f40874b = r5     // Catch: java.lang.Throwable -> Ld9
            return
        L5f:
            com.umeng.analytics.pro.aq.f40873a = r3     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r5 = d(r2)     // Catch: java.lang.Throwable -> Ld9
            com.umeng.analytics.pro.aq.f40874b = r5     // Catch: java.lang.Throwable -> Ld9
            return
        L68:
            java.lang.String r0 = "VIVO"
            boolean r5 = r5.equals(r0)     // Catch: java.lang.Throwable -> Ld9
            if (r5 == 0) goto Ld1
            java.lang.String r5 = "Funtouch"
            com.umeng.analytics.pro.aq.f40873a = r5     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r5 = "ro.vivo.os.version"
            java.lang.String r5 = d(r5)     // Catch: java.lang.Throwable -> Ld9
            com.umeng.analytics.pro.aq.f40874b = r5     // Catch: java.lang.Throwable -> Ld9
            return
        L7d:
            java.lang.String r0 = "OPPO"
            boolean r5 = r5.equals(r0)     // Catch: java.lang.Throwable -> Ld9
            if (r5 == 0) goto Ld1
            goto Lc6
        L86:
            java.lang.String r0 = "ONEPLUS"
            boolean r5 = r5.equals(r0)     // Catch: java.lang.Throwable -> Ld9
            if (r5 == 0) goto Ld1
            java.lang.String r5 = "HydrogenOS"
            com.umeng.analytics.pro.aq.f40873a = r5     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r5 = "ro.rom.version"
            java.lang.String r5 = d(r5)     // Catch: java.lang.Throwable -> Ld9
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> Ld9
            if (r0 == 0) goto La6
            com.umeng.analytics.pro.aq.f40873a = r4     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r5 = "ro.build.version.oplusrom"
            java.lang.String r5 = d(r5)     // Catch: java.lang.Throwable -> Ld9
        La6:
            com.umeng.analytics.pro.aq.f40874b = r5     // Catch: java.lang.Throwable -> Ld9
            return
        La9:
            java.lang.String r0 = "XIAOMI"
            boolean r5 = r5.equals(r0)     // Catch: java.lang.Throwable -> Ld9
            if (r5 == 0) goto Ld1
        Lb1:
            java.lang.String r5 = "MIUI"
            com.umeng.analytics.pro.aq.f40873a = r5     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r5 = "ro.miui.ui.version.name"
            java.lang.String r5 = d(r5)     // Catch: java.lang.Throwable -> Ld9
            com.umeng.analytics.pro.aq.f40874b = r5     // Catch: java.lang.Throwable -> Ld9
            return
        Lbe:
            java.lang.String r0 = "REALME"
            boolean r5 = r5.equals(r0)     // Catch: java.lang.Throwable -> Ld9
            if (r5 == 0) goto Ld1
        Lc6:
            com.umeng.analytics.pro.aq.f40873a = r4     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r5 = "ro.build.version.opporom"
            java.lang.String r5 = d(r5)     // Catch: java.lang.Throwable -> Ld9
            com.umeng.analytics.pro.aq.f40874b = r5     // Catch: java.lang.Throwable -> Ld9
            return
        Ld1:
            java.lang.String r5 = "Android"
            com.umeng.analytics.pro.aq.f40873a = r5     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r5 = android.os.Build.VERSION.RELEASE     // Catch: java.lang.Throwable -> Ld9
            com.umeng.analytics.pro.aq.f40874b = r5     // Catch: java.lang.Throwable -> Ld9
        Ld9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.aq.e(java.lang.String):void");
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.replaceAll(" ", "").toUpperCase();
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(f40873a)) {
            e(str);
        }
        return f40873a;
    }
}
