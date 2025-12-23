package com.beizi.fusion.tool;

import android.os.Build;
import android.text.TextUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class ac {

    /* renamed from: a, reason: collision with root package name */
    private c f13564a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.beizi.fusion.tool.ac$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static ac f13565a = new ac(null);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private enum b {
        REALME("ColorOS", "ro.build.version.oplusrom"),
        OPPO("ColorOS", "ro.build.version.oplusrom"),
        MIUI("MIUI", "ro.miui.ui.version.name"),
        HYPER("HyperOS", "ro.mi.os.version.incremental"),
        REDMI("MIUI", "ro.miui.ui.version.name"),
        HARMONY("HarmonyOS", "hw_sc.build.platform.version"),
        MAGICUI("MagicUI", "ro.build.version.magic"),
        EMUI("EMUI", "ro.build.version.emui"),
        MEIZU("Flyme", "ro.build.display.id"),
        ONEPLUS("HydrogenOS", "ro.rom.version"),
        VIVO("Funtouch", "ro.vivo.os.version"),
        NUBIA("ro.build.nubia.rom.name", "ro.build.nubia.rom.code");


        /* renamed from: m, reason: collision with root package name */
        private final String f13579m;

        /* renamed from: n, reason: collision with root package name */
        private final String f13580n;

        b(String str, String str2) {
            this.f13579m = str;
            this.f13580n = str2;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class c {

        /* renamed from: a, reason: collision with root package name */
        private final String f13581a;

        /* renamed from: b, reason: collision with root package name */
        private final String f13582b;

        /* renamed from: c, reason: collision with root package name */
        private final String f13583c;

        /* synthetic */ c(String str, String str2, String str3, AnonymousClass1 anonymousClass1) {
            this(str, str2, str3);
        }

        private c(String str, String str2, String str3) {
            this.f13581a = str;
            this.f13582b = str2;
            this.f13583c = str3;
        }
    }

    /* synthetic */ ac(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static ac a() {
        return a.f13565a;
    }

    private void c(String str) {
        try {
            if (Integer.valueOf(com.beizi.ad.internal.h.p.a("ro.miui.ui.version.code", "0")).intValue() >= 816) {
                a(str, b.HYPER);
                return;
            }
        } catch (NumberFormatException unused) {
        }
        a(str, b.MIUI);
    }

    private String d(String str) {
        return !TextUtils.isEmpty(str) ? str.replaceAll(" ", "").toUpperCase() : "";
    }

    public void b() {
        b bVar;
        if (this.f13564a != null) {
            return;
        }
        String d6 = d(Build.BRAND);
        if (TextUtils.isEmpty(d6)) {
            return;
        }
        try {
            bVar = b.valueOf(d6);
        } catch (Throwable unused) {
            bVar = null;
        }
        if (bVar != null) {
            a(d6, bVar);
            return;
        }
        d6.getClass();
        switch (d6) {
            case "XIAOMI":
                c(d6);
                break;
            case "HONOR":
                b(d6);
                break;
            case "HUAWEI":
                a(d6);
                break;
        }
    }

    private ac() {
        if (a.f13565a != null) {
            throw new RuntimeException("Singleton ...");
        }
    }

    private void a(String str, b bVar) {
        if (TextUtils.isEmpty(bVar.f13579m)) {
            return;
        }
        this.f13564a = new c(str, bVar.f13579m.contains(".") ? e(bVar.f13579m) : bVar.f13579m, e(bVar.f13580n), null);
    }

    private String e(String str) {
        return com.beizi.ad.internal.h.p.a(str, "");
    }

    private boolean d() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return !TextUtils.isEmpty((String) cls.getMethod("getOsBrand", null).invoke(cls, null));
        } catch (Exception unused) {
            return false;
        }
    }

    public String c() {
        c cVar = this.f13564a;
        if (cVar != null) {
            return cVar.f13583c;
        }
        return "";
    }

    private void a(String str) {
        if (d()) {
            a(str, b.HARMONY);
        } else {
            a(str, b.EMUI);
        }
    }

    private void b(String str) {
        if (d()) {
            a(str, b.HARMONY);
            return;
        }
        b bVar = b.MAGICUI;
        if (!TextUtils.isEmpty(e(bVar.f13580n))) {
            a(str, bVar);
        } else {
            a(str, b.EMUI);
        }
    }
}
