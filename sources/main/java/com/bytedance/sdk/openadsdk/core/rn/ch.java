package com.bytedance.sdk.openadsdk.core.rn;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.ats.AutoService;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ch {
    private static String ae = null;

    /* renamed from: g, reason: collision with root package name */
    private static String f30056g = null;

    /* renamed from: j, reason: collision with root package name */
    public static int f30057j = 0;
    private static int tl = Integer.MAX_VALUE;
    public static int xt;
    private static final CharSequence cw = "sony";

    /* renamed from: r, reason: collision with root package name */
    private static final CharSequence f30059r = "amigo";
    private static final CharSequence up = "funtouch";

    /* renamed from: m, reason: collision with root package name */
    private static final CharSequence f30058m = "origin";

    public static class j implements Callable<String> {

        /* renamed from: j, reason: collision with root package name */
        private String f30061j;

        @Override // java.util.concurrent.Callable
        public String call() throws Exception {
            System.currentTimeMillis();
            String xt = ch.xt(this.f30061j);
            System.currentTimeMillis();
            if (!TextUtils.isEmpty(xt)) {
                try {
                    h.j("rom_info").j("rom_property_info", xt);
                } catch (Throwable unused) {
                }
            }
            return xt;
        }

        public j(String str) {
            this.f30061j = str;
        }
    }

    public static String cw() {
        if (!av()) {
            return "";
        }
        return "miui_" + xt("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
    }

    public static String j() {
        if (TextUtils.isEmpty(ae)) {
            ae = s();
        }
        return ae;
    }

    public static boolean v() {
        try {
            String str = Build.BRAND;
            if (TextUtils.isEmpty(str) || !str.toLowerCase().startsWith("huawei")) {
                String str2 = Build.MANUFACTURER;
                if (TextUtils.isEmpty(str2)) {
                    return false;
                }
                if (!str2.toLowerCase().startsWith("huawei")) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean w() {
        try {
            String str = Build.MANUFACTURER;
            if (!TextUtils.isEmpty(str)) {
                if (str.toLowerCase().contains("oppo")) {
                    return true;
                }
                return str.toLowerCase().contains("realme");
            }
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.r("romUtil", e6.getMessage());
        }
        return false;
    }

    public static String xt() {
        return xt("ro.build.uiversion") + "_" + Build.DISPLAY;
    }

    private static String a() {
        try {
            return h.j("rom_info").xt("rom_property_info", "");
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean ae() {
        String xt2 = xt("ro.vivo.os.build.display.id");
        if (TextUtils.isEmpty(xt2)) {
            return false;
        }
        return xt2.toLowerCase().contains(up) || xt2.toLowerCase().contains("origin");
    }

    public static boolean av() {
        if (f30057j == 0) {
            try {
                Class.forName("miui.os.Build");
                f30057j = 1;
            } catch (Exception unused) {
            }
        }
        return f30057j == 1;
    }

    public static String az() {
        if (TextUtils.isEmpty(f30056g)) {
            f30056g = ch();
        }
        return f30056g;
    }

    public static boolean f() {
        if (tl == Integer.MAX_VALUE) {
            String str = Build.MANUFACTURER;
            String oq = uf.oq("kllk");
            if (TextUtils.isEmpty(str) || !str.toLowerCase(Locale.ROOT).contains(oq)) {
                tl = 0;
            } else {
                tl = 1;
            }
        }
        return tl == 1;
    }

    public static boolean g() {
        String str = Build.DISPLAY;
        return !TextUtils.isEmpty(str) && str.toLowerCase().contains(f30059r);
    }

    public static boolean i() {
        if (xt == 0) {
            try {
                Class.forName("com.huawei.system.BuildEx");
                xt = 1;
            } catch (Exception unused) {
            }
        }
        return xt == 1;
    }

    public static boolean kt() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }

    public static boolean mi() {
        try {
            String str = Build.MANUFACTURER;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.toLowerCase().contains("vivo");
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.r("romUtils", e6.getMessage());
            return false;
        }
    }

    public static boolean oq() {
        try {
            return "FreemeOS".equalsIgnoreCase(xt("ro.build.freemeos_label"));
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String qv() {
        return Build.DISPLAY + "_" + xt("ro.gn.sv.version");
    }

    public static String r() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase().contains("flyme")) ? "" : str;
    }

    private static String s() {
        String str = Build.DISPLAY + "_" + Build.VERSION.INCREMENTAL;
        String str2 = Build.MANUFACTURER;
        if (av()) {
            return "miui_".concat(String.valueOf(str));
        }
        if (i()) {
            return "huawei_".concat(String.valueOf(str));
        }
        Locale locale = Locale.ROOT;
        return str2.toLowerCase(locale).contains("oppo") ? "oppo_".concat(String.valueOf(str)) : str2.toLowerCase(locale).contains("vivo") ? "vivo_".concat(String.valueOf(str)) : str2.toLowerCase(locale).contains("oneplus") ? "oneplus_".concat(String.valueOf(str)) : str;
    }

    public static String tj() {
        return cw("ro.build.version.emui");
    }

    public static String tl() {
        return "vivo_" + xt("ro.vivo.os.build.display.id") + "_" + xt("ro.vivo.product.version");
    }

    public static boolean vl() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.contains("360") || lowerCase.contains("qiku");
    }

    public static boolean ws() {
        return !TextUtils.isEmpty(xt("ro.letv.release.version"));
    }

    public static boolean x() {
        String str = Build.BRAND;
        if (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith("honor")) {
            return true;
        }
        String str2 = Build.MANUFACTURER;
        return (!TextUtils.isEmpty(str2) && str2.toLowerCase().startsWith("honor")) || "HONOR".equalsIgnoreCase(str2);
    }

    public static String xt(String str) {
        com.bytedance.sdk.component.r.up upVar = (com.bytedance.sdk.component.r.up) AutoService.j(com.bytedance.sdk.component.r.up.class);
        return upVar != null ? upVar.j(str) : "";
    }

    private static String ch() {
        if (av()) {
            return cw();
        }
        if (kt()) {
            return r();
        }
        if (f()) {
            return up();
        }
        String m6 = m();
        if (!TextUtils.isEmpty(m6)) {
            return m6;
        }
        if (ae()) {
            return tl();
        }
        if (g()) {
            return qv();
        }
        if (vl()) {
            return xt();
        }
        String jy = jy();
        if (!TextUtils.isEmpty(jy)) {
            return jy;
        }
        if (Build.MANUFACTURER.toLowerCase(Locale.ROOT).contains("oneplus")) {
            return "oneplus_" + Build.DISPLAY + "_" + Build.VERSION.INCREMENTAL;
        }
        if (x()) {
            return "honor_" + tj();
        }
        if (oq()) {
            return "freeme_" + tj();
        }
        return Build.DISPLAY + "_" + Build.VERSION.INCREMENTAL;
    }

    public static String jy() {
        if (ws()) {
            return "eui_" + xt("ro.letv.release.version") + "_" + Build.DISPLAY;
        }
        return "";
    }

    public static String m() {
        String tj = tj();
        if (tj != null) {
            if (tj.toLowerCase().contains("emotionui") || tj.toLowerCase().contains("magicui")) {
                return tj + "_" + Build.DISPLAY;
            }
            return "";
        }
        return "";
    }

    public static String up() {
        if (f()) {
            return "coloros_" + xt("ro.build.version.kllkrom") + "_" + Build.DISPLAY;
        }
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static String cw(String str) {
        String str2;
        try {
            str2 = a();
            try {
                if (TextUtils.isEmpty(str2)) {
                    final com.bytedance.sdk.component.oq.tl tlVar = new com.bytedance.sdk.component.oq.tl(new j(str), 5, 2);
                    com.bytedance.sdk.component.oq.ae.cw(new com.bytedance.sdk.component.oq.g("getSystemPropertyTask") { // from class: com.bytedance.sdk.openadsdk.core.rn.ch.1
                        @Override // java.lang.Runnable
                        public void run() {
                            tlVar.run();
                        }
                    });
                    str2 = (String) tlVar.get(1L, TimeUnit.SECONDS);
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            str2 = "";
        }
        return str2 == null ? "" : str2;
    }

    public static boolean j(String str) {
        if (TextUtils.isEmpty(str)) {
            str = tj();
        }
        return (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith("emotionui")) || v();
    }
}
