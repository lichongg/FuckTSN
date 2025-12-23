package com.beizi.ad.internal.h;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.ad.model.c;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    public static String f12120a = ".AD_CLK_PT_DOWN_X.";

    /* renamed from: b, reason: collision with root package name */
    public static String f12121b = ".AD_CLK_PT_DOWN_Y.";

    /* renamed from: c, reason: collision with root package name */
    public static String f12122c = ".AD_CLK_PT_UP_X.";

    /* renamed from: d, reason: collision with root package name */
    public static String f12123d = ".AD_CLK_PT_UP_Y.";

    /* renamed from: e, reason: collision with root package name */
    public static String f12124e = ".SCRN_CLK_PT_DOWN_X.";

    /* renamed from: f, reason: collision with root package name */
    public static String f12125f = ".SCRN_CLK_PT_DOWN_Y.";

    /* renamed from: g, reason: collision with root package name */
    public static String f12126g = ".SCRN_CLK_PT_UP_X.";

    /* renamed from: h, reason: collision with root package name */
    public static String f12127h = ".SCRN_CLK_PT_UP_Y.";

    /* renamed from: i, reason: collision with root package name */
    public static String f12128i = ".UTC_TS.";

    /* renamed from: j, reason: collision with root package name */
    public static String f12129j = ".AD_CLK_PT_DOWN_X_DP.";

    /* renamed from: k, reason: collision with root package name */
    public static String f12130k = ".AD_CLK_PT_DOWN_Y_DP.";

    /* renamed from: l, reason: collision with root package name */
    public static String f12131l = ".AD_CLK_PT_UP_X_DP.";

    /* renamed from: m, reason: collision with root package name */
    public static String f12132m = ".AD_CLK_PT_UP_Y_DP.";

    /* renamed from: n, reason: collision with root package name */
    public static String f12133n = ".SCRN_CLK_PT_DOWN_X_DP.";

    /* renamed from: o, reason: collision with root package name */
    public static String f12134o = ".SCRN_CLK_PT_DOWN_Y_DP.";

    /* renamed from: p, reason: collision with root package name */
    public static String f12135p = ".SCRN_CLK_PT_UP_X_DP.";

    /* renamed from: q, reason: collision with root package name */
    public static String f12136q = ".SCRN_CLK_PT_UP_Y_DP.";

    /* renamed from: r, reason: collision with root package name */
    public static String f12137r = ".EVENT_TS_START.";

    /* renamed from: s, reason: collision with root package name */
    public static String f12138s = ".EVENT_TS_END.";

    /* renamed from: t, reason: collision with root package name */
    public static String f12139t = ".VIDEO_DURATION.";

    /* renamed from: u, reason: collision with root package name */
    public static String f12140u = "__CLT__";

    /* renamed from: v, reason: collision with root package name */
    public static String f12141v = "__CLT-999__";

    public static String a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("url must no null");
        }
        if (str.contains(f12120a)) {
            str = str.replace(f12120a, str2);
        }
        if (str.contains(f12121b)) {
            str = str.replace(f12121b, str3);
        }
        if (str.contains(f12122c)) {
            str = str.replace(f12122c, str2);
        }
        if (str.contains(f12123d)) {
            str = str.replace(f12123d, str3);
        }
        if (str.contains(f12124e)) {
            str = str.replace(f12124e, str4);
        }
        if (str.contains(f12125f)) {
            str = str.replace(f12125f, str5);
        }
        if (str.contains(f12126g)) {
            str = str.replace(f12126g, str4);
        }
        if (str.contains(f12127h)) {
            str = str.replace(f12127h, str5);
        }
        if (str.contains(f12128i)) {
            str = str.replace(f12128i, String.valueOf(System.currentTimeMillis()));
        }
        if (str.contains(f12137r)) {
            str = str.replace(f12137r, str6);
        }
        if (str.contains(f12138s)) {
            str = str.replace(f12138s, str7);
        }
        return str.contains(f12139t) ? str.replace(f12139t, str8) : str;
    }

    public static void b(c.j jVar) {
        String e6 = jVar.e();
        if (!TextUtils.isEmpty(e6)) {
            new com.beizi.ad.internal.i(a(e6, "", "", "", "", "", "", "")).executeOnExecutor(com.beizi.ad.lance.a.c.b().f(), new Void[0]);
        }
    }

    public static void c(c.j jVar) {
        String f6 = jVar.f();
        if (!TextUtils.isEmpty(f6)) {
            new com.beizi.ad.internal.i(a(f6, "", "", "", "", "", "", "")).executeOnExecutor(com.beizi.ad.lance.a.c.b().f(), new Void[0]);
        }
    }

    public static String a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i6) {
        if (!TextUtils.isEmpty(str)) {
            if (i6 == 2) {
                if (str.contains(f12140u)) {
                    str2 = "0";
                    str3 = "0";
                    str4 = str3;
                    str5 = str4;
                }
                if (str.contains(f12141v)) {
                    str2 = "-999";
                    str3 = "-999";
                    str4 = str3;
                    str5 = str4;
                }
            }
            if (str.contains(f12120a)) {
                str = str.replace(f12120a, str2);
            }
            if (str.contains(f12121b)) {
                str = str.replace(f12121b, str3);
            }
            if (str.contains(f12122c)) {
                str = str.replace(f12122c, str2);
            }
            if (str.contains(f12123d)) {
                str = str.replace(f12123d, str3);
            }
            if (str.contains(f12124e)) {
                str = str.replace(f12124e, str4);
            }
            if (str.contains(f12125f)) {
                str = str.replace(f12125f, str5);
            }
            if (str.contains(f12126g)) {
                str = str.replace(f12126g, str4);
            }
            if (str.contains(f12127h)) {
                str = str.replace(f12127h, str5);
            }
            if (str.contains(f12129j)) {
                str = str.replace(f12129j, a(com.beizi.ad.internal.h.a().f12002j, str2));
            }
            if (str.contains(f12130k)) {
                str = str.replace(f12130k, a(com.beizi.ad.internal.h.a().f12002j, str3));
            }
            if (str.contains(f12131l)) {
                str = str.replace(f12131l, a(com.beizi.ad.internal.h.a().f12002j, str2));
            }
            if (str.contains(f12132m)) {
                str = str.replace(f12132m, a(com.beizi.ad.internal.h.a().f12002j, str3));
            }
            if (str.contains(f12133n)) {
                str = str.replace(f12133n, a(com.beizi.ad.internal.h.a().f12002j, str4));
            }
            if (str.contains(f12134o)) {
                str = str.replace(f12134o, a(com.beizi.ad.internal.h.a().f12002j, str5));
            }
            if (str.contains(f12135p)) {
                str = str.replace(f12135p, a(com.beizi.ad.internal.h.a().f12002j, str4));
            }
            if (str.contains(f12136q)) {
                str = str.replace(f12136q, a(com.beizi.ad.internal.h.a().f12002j, str5));
            }
            if (str.contains(f12140u)) {
                str = str.replace(f12140u, String.valueOf(i6));
            }
            if (str.contains(f12141v)) {
                str = str.replace(f12141v, String.valueOf(i6));
            }
            if (str.contains(f12128i)) {
                str = str.replace(f12128i, String.valueOf(System.currentTimeMillis()));
            }
            if (str.contains(f12137r)) {
                str = str.replace(f12137r, str6);
            }
            if (str.contains(f12138s)) {
                str = str.replace(f12138s, str7);
            }
            return str.contains(f12139t) ? str.replace(f12139t, str8) : str;
        }
        throw new IllegalArgumentException("url must no null");
    }

    public static String a(String str, com.beizi.ad.model.d dVar, String str2, String str3, String str4) {
        if (str.contains(f12120a) && !TextUtils.isEmpty(dVar.a())) {
            str = str.replace(f12120a, dVar.a());
        }
        if (str.contains(f12121b) && !TextUtils.isEmpty(dVar.b())) {
            str = str.replace(f12121b, dVar.b());
        }
        if (str.contains(f12122c) && !TextUtils.isEmpty(dVar.e())) {
            str = str.replace(f12122c, dVar.e());
        }
        if (str.contains(f12123d) && !TextUtils.isEmpty(dVar.f())) {
            str = str.replace(f12123d, dVar.f());
        }
        if (str.contains(f12124e) && !TextUtils.isEmpty(dVar.c())) {
            str = str.replace(f12124e, dVar.c());
        }
        if (str.contains(f12125f) && !TextUtils.isEmpty(dVar.d())) {
            str = str.replace(f12125f, dVar.d());
        }
        if (str.contains(f12126g) && !TextUtils.isEmpty(dVar.g())) {
            str = str.replace(f12126g, dVar.g());
        }
        if (str.contains(f12127h) && !TextUtils.isEmpty(dVar.h())) {
            str = str.replace(f12127h, dVar.h());
        }
        if (str.contains(f12129j) && !TextUtils.isEmpty(dVar.a())) {
            str = str.replace(f12129j, a(com.beizi.ad.internal.h.a().f12002j, dVar.a()));
        }
        if (str.contains(f12130k) && !TextUtils.isEmpty(dVar.b())) {
            str = str.replace(f12130k, a(com.beizi.ad.internal.h.a().f12002j, dVar.b()));
        }
        if (str.contains(f12131l) && !TextUtils.isEmpty(dVar.e())) {
            str = str.replace(f12131l, a(com.beizi.ad.internal.h.a().f12002j, dVar.e()));
        }
        if (str.contains(f12132m) && !TextUtils.isEmpty(dVar.f())) {
            str = str.replace(f12132m, a(com.beizi.ad.internal.h.a().f12002j, dVar.f()));
        }
        if (str.contains(f12133n) && !TextUtils.isEmpty(dVar.c())) {
            str = str.replace(f12133n, a(com.beizi.ad.internal.h.a().f12002j, dVar.c()));
        }
        if (str.contains(f12134o) && !TextUtils.isEmpty(dVar.d())) {
            str = str.replace(f12134o, a(com.beizi.ad.internal.h.a().f12002j, dVar.d()));
        }
        if (str.contains(f12135p) && !TextUtils.isEmpty(dVar.g())) {
            str = str.replace(f12135p, a(com.beizi.ad.internal.h.a().f12002j, dVar.g()));
        }
        return (!str.contains(f12136q) || TextUtils.isEmpty(dVar.h())) ? str : str.replace(f12136q, a(com.beizi.ad.internal.h.a().f12002j, dVar.h()));
    }

    public static String a(String str, com.beizi.ad.model.d dVar, String str2, String str3, String str4, int i6) {
        if (!TextUtils.isEmpty(str)) {
            if (i6 != 2 && i6 != 5) {
                str = a(str, dVar, str2, str3, str4);
            } else {
                com.beizi.ad.model.d dVar2 = new com.beizi.ad.model.d();
                if (str.contains(f12140u)) {
                    dVar2.a("0");
                    dVar2.b("0");
                    dVar2.c("0");
                    dVar2.d("0");
                    dVar2.e("0");
                    dVar2.f("0");
                    dVar2.g("0");
                    dVar2.h("0");
                    str = a(str, dVar2, str2, str3, str4);
                }
                if (str.contains(f12141v)) {
                    dVar2.a("-999");
                    dVar2.b("-999");
                    dVar2.c("-999");
                    dVar2.d("-999");
                    dVar2.e("-999");
                    dVar2.f("-999");
                    dVar2.g("-999");
                    dVar2.h("-999");
                    str = a(str, dVar2, str2, str3, str4);
                }
            }
            if (str.contains(f12140u)) {
                str = str.replace(f12140u, String.valueOf(i6));
            }
            if (str.contains(f12141v)) {
                str = str.replace(f12141v, String.valueOf(i6));
            }
            if (str.contains(f12128i)) {
                str = str.replace(f12128i, String.valueOf(System.currentTimeMillis()));
            }
            if (str.contains(f12137r)) {
                str = str.replace(f12137r, str2);
            }
            if (str.contains(f12138s)) {
                str = str.replace(f12138s, str3);
            }
            return str.contains(f12139t) ? str.replace(f12139t, str4) : str;
        }
        throw new IllegalArgumentException("url must no null");
    }

    public static String a(Context context, String str) {
        try {
            if (!TextUtils.isEmpty(str) && !str.equals("-999") && !str.equals("0")) {
                return String.valueOf((int) ((((long) Double.parseDouble(str)) / context.getResources().getDisplayMetrics().density) + 0.5f));
            }
            return str;
        } catch (Throwable th) {
            th.printStackTrace();
            return str;
        }
    }

    public static void a(c.j jVar) {
        String d6 = jVar.d();
        if (TextUtils.isEmpty(d6)) {
            return;
        }
        new com.beizi.ad.internal.i(a(d6, "", "", "", "", "", "", "")).executeOnExecutor(com.beizi.ad.lance.a.c.b().f(), new Void[0]);
    }
}
