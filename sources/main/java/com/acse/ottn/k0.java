package com.acse.ottn;

import com.acse.ottn.util.HelpShopAppUtil;
import com.kwad.sdk.liteapi.encrypt.LiteEncryptUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class k0 {

    /* renamed from: c, reason: collision with root package name */
    public static o0 f4667c;

    /* renamed from: w, reason: collision with root package name */
    public static String f4687w;

    /* renamed from: x, reason: collision with root package name */
    public static String f4688x;

    /* renamed from: y, reason: collision with root package name */
    public static String f4689y;

    /* renamed from: a, reason: collision with root package name */
    public static String f4665a = j1.c().b();

    /* renamed from: b, reason: collision with root package name */
    public static String f4666b = a("");

    /* renamed from: d, reason: collision with root package name */
    public static boolean f4668d = false;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f4669e = true;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f4670f = true;

    /* renamed from: g, reason: collision with root package name */
    public static boolean f4671g = false;

    /* renamed from: h, reason: collision with root package name */
    public static boolean f4672h = false;

    /* renamed from: i, reason: collision with root package name */
    public static String f4673i = "1";

    /* renamed from: j, reason: collision with root package name */
    public static String f4674j = "0";

    /* renamed from: k, reason: collision with root package name */
    public static String f4675k = "18";

    /* renamed from: l, reason: collision with root package name */
    public static String f4676l = "1";

    /* renamed from: m, reason: collision with root package name */
    public static int f4677m = 13;

    /* renamed from: n, reason: collision with root package name */
    public static int f4678n = 16;

    /* renamed from: o, reason: collision with root package name */
    public static String f4679o = "com.acse.oozk";

    /* renamed from: p, reason: collision with root package name */
    public static String f4680p = "0";

    /* renamed from: q, reason: collision with root package name */
    public static String f4681q = "1";

    /* renamed from: r, reason: collision with root package name */
    public static String f4682r = "com.zjwh.android_wh_physicalfitness";

    /* renamed from: s, reason: collision with root package name */
    public static String f4683s = "com.huachenjie.shandong_school";

    /* renamed from: t, reason: collision with root package name */
    public static String f4684t = com.bxkj.student.d.f17843b;

    /* renamed from: u, reason: collision with root package name */
    public static String f4685u = "com.lptiyu.tanke";

    /* renamed from: v, reason: collision with root package name */
    public static String f4686v = "";

    public static String a(String str) {
        return "程序";
    }

    public static String a(boolean z5) {
        return z5 ? "QVbZFjAoPF6LCCQm6RgDs1g13mnJ8nA0" : j3.a().e(LiteEncryptUtils.KEY_AES);
    }

    public static void c(boolean z5) {
        c2.a("MyService", "setServiceHightButteryState come on");
        if (j3.a() != null) {
            j3.a().a("background_battery_hignt", Boolean.valueOf(z5));
        }
        l2.b().a("vivo_battery_permission");
    }

    static {
        String str;
        String e6;
        if (HelpShopAppUtil.getContext() == null) {
            str = "";
        } else {
            str = HelpShopAppUtil.getContext().getPackageName();
        }
        f4687w = str;
        if ("".equals(j3.a().e("app_version_code"))) {
            e6 = j4.r();
        } else {
            e6 = j3.a().e("app_version_code");
        }
        f4688x = e6;
        f4689y = j4.q();
    }

    public static void a(o0 o0Var) {
        f4667c = o0Var;
    }

    public static void b(boolean z5) {
        if (j3.a() != null) {
            l2.b().a("battery_permission");
            j3.a().a("open_battery_white", Boolean.valueOf(z5));
        }
    }

    public static o0 a() {
        return f4667c;
    }
}
