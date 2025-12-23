package com.ss.android.socialbase.appdownloader.m;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.acse.ottn.j4;
import com.acse.ottn.l3;
import com.bytedance.sdk.component.utils.vl;
import com.ss.android.socialbase.downloader.az.m;
import com.ss.android.socialbase.downloader.downloader.cw;
import com.ss.android.socialbase.downloader.jy.j;
import com.ss.android.socialbase.downloader.xt.up;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* loaded from: D:\Downloads\app\classes6.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static String f38490a = null;

    /* renamed from: b, reason: collision with root package name */
    private static String f38491b = "";

    /* renamed from: c, reason: collision with root package name */
    public static String f38492c = "";

    /* renamed from: d, reason: collision with root package name */
    private static String f38493d;

    /* renamed from: e, reason: collision with root package name */
    private static String f38494e;

    /* renamed from: f, reason: collision with root package name */
    public static String f38495f;

    /* renamed from: g, reason: collision with root package name */
    private static String f38496g;

    /* renamed from: h, reason: collision with root package name */
    private static Boolean f38497h;

    public static String v(String str) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str))).getInputStream()), 1024);
            try {
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                m.j(bufferedReader);
                return readLine;
            } catch (Throwable unused) {
                m.j(bufferedReader);
                return null;
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
    }

    public static boolean a() {
        return i("SAMSUNG");
    }

    public static boolean b() {
        if (f38497h == null) {
            f38497h = Boolean.valueOf(d.a().equals(j4.f4664a));
        }
        return f38497h.booleanValue();
    }

    public static String d(String str) throws Throwable {
        return (String) Class.forName("android.os.SystemProperties").getMethod(l3.f4736f, String.class).invoke(null, str);
    }

    public static boolean e() {
        return i("MIUI");
    }

    public static String f() {
        if (f38494e == null) {
            i("");
        }
        return f38494e;
    }

    public static boolean g() {
        String str = Build.BRAND;
        if (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith("honor")) {
            return true;
        }
        String str2 = Build.MANUFACTURER;
        return !TextUtils.isEmpty(str2) && str2.toLowerCase().startsWith("honor");
    }

    public static boolean h() {
        return i("EMUI") || i("MAGICUI");
    }

    public static boolean k() {
        return i("FLYME");
    }

    private static void l() {
        if (f38496g == null) {
            try {
                f38496g = o("ro.miui.ui.version.name");
            } catch (Exception e6) {
                vl.j(e6);
            }
            String str = f38496g;
            if (str == null) {
                str = "";
            }
            f38496g = str;
        }
    }

    public static String m() {
        if (f38495f == null) {
            i("");
        }
        return f38495f;
    }

    @NonNull
    public static String n() {
        String str = Build.MANUFACTURER;
        return str == null ? "" : str.trim();
    }

    public static boolean p() {
        return i("VIVO");
    }

    public static String q() {
        if (f38493d == null) {
            i("");
        }
        return f38493d;
    }

    @NonNull
    public static String s() {
        String str = Build.DISPLAY;
        return str == null ? "" : str.trim();
    }

    private static void t() {
        if (TextUtils.isEmpty(f38490a)) {
            cw.gq();
            f38490a = up.xt;
            f38491b = "ro.build.version." + up.cw + "rom";
            f38492c = "com." + up.cw + ".market";
        }
    }

    public static boolean w() {
        return i("MAGICUI");
    }

    public static boolean c() {
        l();
        return "V12".equals(f38496g);
    }

    public static boolean i(String str) {
        String str2;
        t();
        String str3 = f38493d;
        if (str3 != null) {
            return str3.equals(str);
        }
        String o5 = o("ro.miui.ui.version.name");
        f38494e = o5;
        if (!TextUtils.isEmpty(o5)) {
            f38493d = "MIUI";
            f38495f = "com.xiaomi.market";
            f38496g = f38494e;
        } else {
            String o6 = o("ro.build.version.emui");
            f38494e = o6;
            if (!TextUtils.isEmpty(o6)) {
                if (g()) {
                    str2 = "MAGICUI";
                } else {
                    str2 = "EMUI";
                }
                f38493d = str2;
                if (TextUtils.equals(str2, "MAGICUI")) {
                    f38495f = "com.hihonor.appmarket";
                } else {
                    f38495f = "com.huawei.appmarket";
                }
            } else {
                String o7 = o("ro.build.version.magic");
                f38494e = o7;
                if (!TextUtils.isEmpty(o7)) {
                    f38493d = "MAGICUI";
                    f38495f = "com.hihonor.appmarket";
                } else {
                    String o8 = o(f38491b);
                    f38494e = o8;
                    if (!TextUtils.isEmpty(o8)) {
                        f38493d = f38490a;
                        if (com.ss.android.socialbase.appdownloader.a.b(f38492c) >= 0) {
                            f38495f = f38492c;
                        } else {
                            f38495f = "com.heytap.market";
                        }
                    } else {
                        String o9 = o("ro.vivo.os.version");
                        f38494e = o9;
                        if (!TextUtils.isEmpty(o9)) {
                            f38493d = "VIVO";
                            f38495f = "com.bbk.appstore";
                        } else {
                            String o10 = o("ro.smartisan.version");
                            f38494e = o10;
                            if (!TextUtils.isEmpty(o10)) {
                                f38493d = "SMARTISAN";
                                f38495f = "com.smartisanos.appstore";
                            } else {
                                String o11 = o("ro.gn.sv.version");
                                f38494e = o11;
                                if (!TextUtils.isEmpty(o11)) {
                                    f38493d = "QIONEE";
                                    f38495f = "com.gionee.aora.market";
                                } else {
                                    String o12 = o("ro.lenovo.lvp.version");
                                    f38494e = o12;
                                    if (!TextUtils.isEmpty(o12)) {
                                        f38493d = "LENOVO";
                                        f38495f = "com.lenovo.leos.appstore";
                                    } else if (n().toUpperCase().contains("SAMSUNG")) {
                                        f38493d = "SAMSUNG";
                                        f38495f = "com.sec.android.app.samsungapps";
                                    } else if (n().toUpperCase().contains("ZTE")) {
                                        f38493d = "ZTE";
                                        f38495f = "zte.com.market";
                                    } else if (n().toUpperCase().contains("NUBIA")) {
                                        f38493d = "NUBIA";
                                        f38495f = "cn.nubia.neostore";
                                    } else if (s().toUpperCase().contains("FLYME")) {
                                        f38493d = "FLYME";
                                        f38495f = "com.meizu.mstore";
                                        f38494e = s();
                                    } else if (n().toUpperCase().contains("ONEPLUS")) {
                                        f38493d = "ONEPLUS";
                                        f38494e = o("ro.rom.version");
                                        if (com.ss.android.socialbase.appdownloader.a.b(f38492c) >= 0) {
                                            f38495f = f38492c;
                                        } else {
                                            f38495f = "com.heytap.market";
                                        }
                                    } else {
                                        f38493d = n().toUpperCase();
                                        f38495f = "";
                                        f38494e = "";
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return f38493d.equals(str);
    }

    public static boolean j() {
        l();
        return "V10".equals(f38496g);
    }

    public static String o(String str) {
        if (j.xt().optBoolean("enable_reflect_system_properties", true)) {
            try {
                return d(str);
            } catch (Throwable th) {
                vl.j(th);
            }
        }
        return v(str);
    }

    public static boolean r() {
        t();
        return i(f38490a);
    }

    public static boolean u() {
        l();
        return "V11".equals(f38496g);
    }
}
