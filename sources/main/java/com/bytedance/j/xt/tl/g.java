package com.bytedance.j.xt.tl;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;

/* loaded from: D:\Downloads\app\classes3.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static final CharSequence f24236a = "sony";

    /* renamed from: b, reason: collision with root package name */
    private static final CharSequence f24237b = "amigo";

    /* renamed from: c, reason: collision with root package name */
    private static final CharSequence f24238c = "funtouch";

    public static String a() {
        return Build.DISPLAY + "_" + e("ro.gn.sv.version");
    }

    public static boolean b() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase(Locale.getDefault());
        return lowerCase.contains("360") || lowerCase.contains("qiku");
    }

    public static boolean c() {
        return !TextUtils.isEmpty(e("ro.letv.release.version"));
    }

    private static String e(String str) {
        BufferedReader bufferedReader;
        Process exec;
        String str2 = "";
        try {
            exec = Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str)));
            bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()), 1024);
        } catch (Throwable unused) {
            bufferedReader = null;
        }
        try {
            str2 = bufferedReader.readLine();
            exec.destroy();
            h.a(bufferedReader);
            return str2;
        } catch (Throwable unused2) {
            h.a(bufferedReader);
            return str2;
        }
    }

    public static boolean f() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase(Locale.getDefault()).contains("oppo");
    }

    public static boolean g() {
        String str = Build.DISPLAY;
        return !TextUtils.isEmpty(str) && str.toLowerCase(Locale.getDefault()).contains(f24237b);
    }

    public static String j() {
        return e("ro.vivo.os.build.display.id") + "_" + e("ro.vivo.product.version");
    }

    public static boolean l() {
        String e6 = e("ro.vivo.os.build.display.id");
        return !TextUtils.isEmpty(e6) && e6.toLowerCase(Locale.getDefault()).contains(f24238c);
    }

    public static String m() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase(Locale.getDefault()).contains("flyme")) ? "" : str;
    }

    public static String o() {
        return e("ro.build.uiversion") + "_" + Build.DISPLAY;
    }

    public static String d() {
        if (d.a()) {
            return h();
        }
        if (d.d()) {
            return m();
        }
        if (f()) {
            return n();
        }
        String i6 = i();
        if (!TextUtils.isEmpty(i6)) {
            return i6;
        }
        if (l()) {
            return j();
        }
        if (g()) {
            return a();
        }
        if (b()) {
            return o();
        }
        String k6 = k();
        if (!TextUtils.isEmpty(k6)) {
            return k6;
        }
        return Build.DISPLAY;
    }

    public static String h() {
        if (d.a()) {
            return "miui_" + e("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
        }
        return "";
    }

    public static String i() {
        String b6 = d.b();
        if (b6 != null && b6.toLowerCase(Locale.getDefault()).contains("emotionui")) {
            return b6 + "_" + Build.DISPLAY;
        }
        return "";
    }

    public static String k() {
        if (c()) {
            return "eui_" + e("ro.letv.release.version") + "_" + Build.DISPLAY;
        }
        return "";
    }

    public static String n() {
        if (f()) {
            return "coloros_" + e("ro.build.version.opporom") + "_" + Build.DISPLAY;
        }
        return "";
    }
}
