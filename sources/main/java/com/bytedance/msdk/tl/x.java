package com.bytedance.msdk.tl;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.bytedance.sdk.openadsdk.ats.AutoService;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\Downloads\app\classes3.dex */
public class x {

    /* renamed from: j, reason: collision with root package name */
    private static final AtomicInteger f25241j = new AtomicInteger(0);

    public static String cw() {
        com.bytedance.sdk.component.r.j jVar = (com.bytedance.sdk.component.r.j) AutoService.j(com.bytedance.sdk.component.r.j.class);
        return jVar != null ? jVar.x() : "";
    }

    private static int j(int i6) {
        if (i6 == 0) {
            return 0;
        }
        int i7 = 2;
        if (i6 != 2) {
            i7 = 3;
            if (i6 != 3) {
                if (i6 == 4) {
                    return 1;
                }
                if (i6 == 5) {
                    return 4;
                }
                if (i6 != 6) {
                    return i6;
                }
                return 5;
            }
        }
        return i7;
    }

    public static String r() {
        com.bytedance.sdk.component.r.j jVar = (com.bytedance.sdk.component.r.j) AutoService.j(com.bytedance.sdk.component.r.j.class);
        return jVar != null ? jVar.j() : "";
    }

    public static String xt() {
        com.bytedance.sdk.component.r.xt xtVar = (com.bytedance.sdk.component.r.xt) AutoService.j(com.bytedance.sdk.component.r.xt.class);
        return xtVar != null ? xtVar.xt() : "";
    }

    public static String a() {
        com.bytedance.sdk.component.r.j jVar = (com.bytedance.sdk.component.r.j) AutoService.j(com.bytedance.sdk.component.r.j.class);
        return jVar != null ? jVar.ch() : "";
    }

    public static String ae() {
        com.bytedance.sdk.component.r.j jVar = (com.bytedance.sdk.component.r.j) AutoService.j(com.bytedance.sdk.component.r.j.class);
        return jVar != null ? jVar.r() : "";
    }

    public static String av() {
        com.bytedance.sdk.component.r.j jVar = (com.bytedance.sdk.component.r.j) AutoService.j(com.bytedance.sdk.component.r.j.class);
        return jVar != null ? jVar.ws() : "";
    }

    public static String az() {
        com.bytedance.sdk.component.r.j jVar = (com.bytedance.sdk.component.r.j) AutoService.j(com.bytedance.sdk.component.r.j.class);
        return jVar != null ? jVar.jy() : "";
    }

    public static String ch() {
        com.bytedance.sdk.component.r.j jVar = (com.bytedance.sdk.component.r.j) AutoService.j(com.bytedance.sdk.component.r.j.class);
        return jVar != null ? jVar.v() : "";
    }

    public static String f() {
        com.bytedance.sdk.component.r.j jVar = (com.bytedance.sdk.component.r.j) AutoService.j(com.bytedance.sdk.component.r.j.class);
        return jVar != null ? jVar.mi() : "";
    }

    public static String g() {
        com.bytedance.sdk.component.r.j jVar = (com.bytedance.sdk.component.r.j) AutoService.j(com.bytedance.sdk.component.r.j.class);
        return jVar != null ? jVar.m() : "";
    }

    public static int gq() {
        com.bytedance.sdk.component.r.j jVar = (com.bytedance.sdk.component.r.j) AutoService.j(com.bytedance.sdk.component.r.j.class);
        if (jVar != null) {
            return jVar.h();
        }
        return 0;
    }

    public static String h() {
        com.bytedance.sdk.component.r.j jVar = (com.bytedance.sdk.component.r.j) AutoService.j(com.bytedance.sdk.component.r.j.class);
        return jVar != null ? jVar.l() : "";
    }

    public static String i() {
        com.bytedance.sdk.component.r.j jVar = (com.bytedance.sdk.component.r.j) AutoService.j(com.bytedance.sdk.component.r.j.class);
        return jVar != null ? jVar.az() : "";
    }

    public static String j() {
        com.bytedance.sdk.component.r.xt xtVar = (com.bytedance.sdk.component.r.xt) AutoService.j(com.bytedance.sdk.component.r.xt.class);
        return xtVar != null ? xtVar.j() : "";
    }

    public static int jy() {
        com.bytedance.sdk.component.r.j jVar = (com.bytedance.sdk.component.r.j) AutoService.j(com.bytedance.sdk.component.r.j.class);
        if (jVar != null) {
            return jVar.oq();
        }
        return 0;
    }

    public static String l() {
        com.bytedance.sdk.component.r.j jVar = (com.bytedance.sdk.component.r.j) AutoService.j(com.bytedance.sdk.component.r.j.class);
        return jVar != null ? jVar.s() : "";
    }

    public static String la() {
        com.bytedance.sdk.component.r.j jVar = (com.bytedance.sdk.component.r.j) AutoService.j(com.bytedance.sdk.component.r.j.class);
        return jVar != null ? jVar.p() : "";
    }

    public static String m() {
        com.bytedance.sdk.component.r.j jVar = (com.bytedance.sdk.component.r.j) AutoService.j(com.bytedance.sdk.component.r.j.class);
        int i6 = 0;
        if (com.bytedance.msdk.core.j.qv().p().cw() && jVar != null) {
            i6 = jVar.cw();
        }
        return xt(i6);
    }

    public static String mi() {
        com.bytedance.sdk.component.r.j jVar = (com.bytedance.sdk.component.r.j) AutoService.j(com.bytedance.sdk.component.r.j.class);
        return jVar != null ? jVar.av() : "";
    }

    public static String oq() {
        com.bytedance.sdk.component.r.j jVar = (com.bytedance.sdk.component.r.j) AutoService.j(com.bytedance.sdk.component.r.j.class);
        return jVar != null ? jVar.ae() : "";
    }

    public static int p() {
        com.bytedance.sdk.component.r.j jVar = (com.bytedance.sdk.component.r.j) AutoService.j(com.bytedance.sdk.component.r.j.class);
        if (jVar != null) {
            return jVar.a();
        }
        return 1;
    }

    public static String rn() {
        com.bytedance.sdk.component.r.j jVar = (com.bytedance.sdk.component.r.j) AutoService.j(com.bytedance.sdk.component.r.j.class);
        return jVar != null ? jVar.la() : "";
    }

    public static String s() {
        com.bytedance.sdk.component.r.j jVar = (com.bytedance.sdk.component.r.j) AutoService.j(com.bytedance.sdk.component.r.j.class);
        return jVar != null ? jVar.f() : "";
    }

    public static String tj() {
        AtomicInteger atomicInteger = f25241j;
        if (atomicInteger.intValue() > 5) {
            return null;
        }
        atomicInteger.incrementAndGet();
        com.bytedance.sdk.component.r.j jVar = (com.bytedance.sdk.component.r.j) AutoService.j(com.bytedance.sdk.component.r.j.class);
        if (jVar != null) {
            return jVar.w();
        }
        return null;
    }

    public static String tl() {
        com.bytedance.sdk.component.r.j jVar = (com.bytedance.sdk.component.r.j) AutoService.j(com.bytedance.sdk.component.r.j.class);
        return jVar != null ? jVar.up() : "";
    }

    public static int up() {
        com.bytedance.sdk.component.r.j jVar = (com.bytedance.sdk.component.r.j) AutoService.j(com.bytedance.sdk.component.r.j.class);
        int i6 = 0;
        if (com.bytedance.msdk.core.j.qv().p().cw() && jVar != null) {
            i6 = jVar.cw();
        }
        return j(i6);
    }

    public static String v() {
        com.bytedance.sdk.component.r.j jVar = (com.bytedance.sdk.component.r.j) AutoService.j(com.bytedance.sdk.component.r.j.class);
        return jVar != null ? jVar.kt() : "";
    }

    public static String w() {
        com.bytedance.sdk.component.r.j jVar = (com.bytedance.sdk.component.r.j) AutoService.j(com.bytedance.sdk.component.r.j.class);
        return jVar != null ? jVar.vl() : "";
    }

    public static String ws() {
        com.bytedance.sdk.component.r.j jVar = (com.bytedance.sdk.component.r.j) AutoService.j(com.bytedance.sdk.component.r.j.class);
        return jVar != null ? jVar.qv() : "";
    }

    public static String x() {
        com.bytedance.sdk.component.r.j jVar = (com.bytedance.sdk.component.r.j) AutoService.j(com.bytedance.sdk.component.r.j.class);
        return jVar != null ? jVar.tj() : "";
    }

    public static boolean cw(Context context) {
        return com.bytedance.sdk.component.utils.ws.cw(context) == 2;
    }

    public static String kt() {
        com.bytedance.sdk.component.r.j jVar;
        if (!wq() || (jVar = (com.bytedance.sdk.component.r.j) AutoService.j(com.bytedance.sdk.component.r.j.class)) == null) {
            return "";
        }
        return jVar.i();
    }

    public static String qv() {
        com.bytedance.sdk.component.r.j jVar;
        if (!wq() || (jVar = (com.bytedance.sdk.component.r.j) AutoService.j(com.bytedance.sdk.component.r.j.class)) == null) {
            return "";
        }
        return jVar.tl();
    }

    private static boolean r(Context context) {
        return com.bytedance.msdk.core.vl.cw.j(context, com.kuaishou.weapon.p0.g.f36043c) == 0;
    }

    public static String vl() {
        com.bytedance.sdk.component.r.j jVar;
        if (!wq() || (jVar = (com.bytedance.sdk.component.r.j) AutoService.j(com.bytedance.sdk.component.r.j.class)) == null) {
            return "";
        }
        return jVar.g();
    }

    private static boolean wq() {
        if (!com.bytedance.msdk.core.j.qv().p().cw() || !r(com.bytedance.msdk.core.xt.getContext())) {
            return false;
        }
        return true;
    }

    private static String xt(int i6) {
        if (i6 == 0) {
            return "unknown";
        }
        if (i6 == 2) {
            return "2g";
        }
        if (i6 == 3) {
            return "3g";
        }
        if (i6 == 4) {
            return "wifi";
        }
        if (i6 == 5) {
            return "4g";
        }
        if (i6 != 6) {
            return "mobile";
        }
        return "5g";
    }

    public static boolean j(Context context) {
        NetworkInfo[] allNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (allNetworkInfo = connectivityManager.getAllNetworkInfo()) != null) {
                for (NetworkInfo networkInfo : allNetworkInfo) {
                    if (networkInfo.getState() == NetworkInfo.State.CONNECTED || networkInfo.getState() == NetworkInfo.State.CONNECTING) {
                        return true;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean xt(Context context) {
        return com.bytedance.sdk.component.utils.ws.cw(context) == 3;
    }
}
