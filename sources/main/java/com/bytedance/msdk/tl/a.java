package com.bytedance.msdk.tl;

import android.os.Build;
import android.text.TextUtils;
import com.acse.ottn.n3;
import com.bytedance.sdk.openadsdk.ats.AutoService;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes3.dex */
public class a {
    private static final CharSequence cw = "sony";

    /* renamed from: r, reason: collision with root package name */
    private static final CharSequence f25202r = "amigo";
    private static final CharSequence up = "funtouch";

    /* renamed from: m, reason: collision with root package name */
    private static final ExecutorService f25201m = com.bytedance.msdk.j.up.m.j("romutils", 2, new RejectedExecutionHandler() { // from class: com.bytedance.msdk.tl.a.1
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        }
    });

    /* renamed from: j, reason: collision with root package name */
    public static boolean f25200j = false;
    public static boolean xt = false;

    public static class j implements Callable<String> {

        /* renamed from: j, reason: collision with root package name */
        private final String f25203j;

        @Override // java.util.concurrent.Callable
        public String call() throws Exception {
            long currentTimeMillis = System.currentTimeMillis();
            String xt = a.xt(this.f25203j);
            com.bytedance.msdk.j.up.cw.j(n3.f4931a, "property:" + xt + ",getSystemProperty use time :" + (System.currentTimeMillis() - currentTimeMillis));
            if (!TextUtils.isEmpty(xt)) {
                try {
                    com.bytedance.msdk.j.up.cw.cw(n3.f4931a, "SP-getPropertyFromSP:".concat(String.valueOf(xt)));
                    l.j("rom_info", com.bytedance.msdk.core.xt.getContext()).j("rom_property_info", xt);
                } catch (Throwable unused) {
                }
            }
            return xt;
        }

        public j(String str) {
            this.f25203j = str;
        }
    }

    public static String cw() {
        return cw("ro.build.uiversion") + "_" + Build.DISPLAY;
    }

    public static boolean xt() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }

    public static boolean ae() {
        String cw2 = cw("ro.vivo.os.build.display.id");
        return !TextUtils.isEmpty(cw2) && cw2.toLowerCase().contains(up);
    }

    public static boolean az() {
        return "smartisan".equalsIgnoreCase(Build.MANUFACTURER) || "smartisan".equalsIgnoreCase(Build.BRAND);
    }

    private static String cw(String str) {
        String str2;
        try {
            str2 = kt();
            try {
                if (TextUtils.isEmpty(str2)) {
                    FutureTask futureTask = new FutureTask(new j(str));
                    f25201m.execute(futureTask);
                    str2 = (String) futureTask.get(1L, TimeUnit.SECONDS);
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            str2 = "";
        }
        return str2 == null ? "" : str2;
    }

    public static String g() {
        return Build.DISPLAY + "_" + cw("ro.gn.sv.version");
    }

    public static String i() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase().contains("flyme")) ? "" : str;
    }

    public static String j() {
        if (az()) {
            return av();
        }
        if (up()) {
            return vl();
        }
        if (xt()) {
            return i();
        }
        if (w()) {
            return mi();
        }
        String jy = jy();
        if (!TextUtils.isEmpty(jy)) {
            return jy;
        }
        if (ae()) {
            return m();
        }
        if (tl()) {
            return g();
        }
        if (r()) {
            return cw();
        }
        String oq = oq();
        return !TextUtils.isEmpty(oq) ? oq : Build.DISPLAY;
    }

    private static String kt() {
        try {
            String xt2 = l.j("rom_info", com.bytedance.msdk.core.xt.getContext()).xt("rom_property_info", "");
            com.bytedance.msdk.j.up.cw.xt(n3.f4931a, "get Property From SP...=".concat(String.valueOf(xt2)));
            return xt2;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String m() {
        return cw("ro.vivo.os.build.display.id") + "_" + cw("ro.vivo.product.version");
    }

    public static boolean qv() {
        return !TextUtils.isEmpty(cw("ro.letv.release.version"));
    }

    public static boolean r() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.contains("360") || lowerCase.contains("qiku");
    }

    public static boolean tl() {
        String str = Build.DISPLAY;
        return !TextUtils.isEmpty(str) && str.toLowerCase().contains(f25202r);
    }

    public static boolean up() {
        if (!xt) {
            try {
                Class.forName("miui.os.Build");
                f25200j = true;
                xt = true;
                return true;
            } catch (Exception unused) {
                xt = true;
            }
        }
        return f25200j;
    }

    public static boolean w() {
        String str = Build.MANUFACTURER;
        return !TextUtils.isEmpty(str) && str.toLowerCase().contains("oppo");
    }

    public static String ws() {
        return cw("ro.build.version.emui");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String xt(String str) {
        com.bytedance.sdk.component.r.up upVar = (com.bytedance.sdk.component.r.up) AutoService.j(com.bytedance.sdk.component.r.up.class);
        return upVar != null ? upVar.j(str) : "";
    }

    public static String av() {
        if (az()) {
            try {
                return "smartisan_".concat(String.valueOf(cw("ro.smartisan.version")));
            } catch (Throwable unused) {
            }
        }
        return Build.DISPLAY;
    }

    public static String jy() {
        String ws = ws();
        if (ws != null && ws.toLowerCase().contains("emotionui")) {
            return ws + "_" + Build.DISPLAY;
        }
        return "";
    }

    public static String mi() {
        if (w()) {
            return "coloros_" + cw("ro.build.version.opporom") + "_" + Build.DISPLAY;
        }
        return "";
    }

    public static String oq() {
        if (qv()) {
            return "eui_" + cw("ro.letv.release.version") + "_" + Build.DISPLAY;
        }
        return "";
    }

    public static String vl() {
        if (up()) {
            return "miui_" + cw("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
        }
        return "";
    }
}
