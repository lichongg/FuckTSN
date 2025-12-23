package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.app.AppPackageInfo;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.cd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class bd {
    public static String bam = "";

    private static String Rs() {
        return com.kwad.sdk.e.b.a(false, "1", 0);
    }

    static /* synthetic */ String cf(boolean z5) {
        return cc(true);
    }

    static /* synthetic */ String ci(boolean z5) {
        return cd(true);
    }

    static /* synthetic */ String cj(boolean z5) {
        return ce(true);
    }

    /* renamed from: do, reason: not valid java name */
    public static String m125do(Context context) {
        return e(context, false);
    }

    public static String dp(Context context) {
        return f(context, false);
    }

    public static String dq(Context context) {
        return g(context, false);
    }

    public static String dr(Context context) {
        return h(context, false);
    }

    public static String ds(Context context) {
        return i(context, false);
    }

    public static String dt(Context context) {
        return j(context, false);
    }

    public static String du(Context context) {
        return k(context, false);
    }

    public static String getDeviceId() {
        return cd(false);
    }

    public static String getOaid() {
        return cc(false);
    }

    static /* synthetic */ String l(Context context, boolean z5) {
        return e(context, true);
    }

    static /* synthetic */ String m(Context context, boolean z5) {
        return f(context, true);
    }

    static /* synthetic */ String n(Context context, boolean z5) {
        return g(context, true);
    }

    static /* synthetic */ String o(Context context, boolean z5) {
        return h(context, true);
    }

    static /* synthetic */ String p(Context context, boolean z5) {
        return i(context, true);
    }

    static /* synthetic */ String q(Context context, boolean z5) {
        return j(context, true);
    }

    static /* synthetic */ String r(Context context, boolean z5) {
        return k(context, true);
    }

    private static String cd(boolean z5) {
        if (com.kwad.framework.a.a.oz.booleanValue() && !TextUtils.isEmpty(bs.getDeviceId())) {
            return bs.getDeviceId();
        }
        String deviceId = br.getDeviceId();
        if (!z5) {
            return TextUtils.isEmpty(deviceId) ? "" : deviceId;
        }
        if (TextUtils.isEmpty(deviceId)) {
            return (bc.usePhoneStateDisable() || !s.PS()) ? com.kwad.sdk.e.b.a(false, deviceId, 1) : com.kwad.sdk.e.b.a(false, deviceId, 5);
        }
        return com.kwad.sdk.e.b.a(bc.usePhoneStateDisable() && !TextUtils.isEmpty(bc.getDevAndroidId()), deviceId, 0);
    }

    @NonNull
    private static com.kwad.sdk.e.c dC(final Context context) {
        return new com.kwad.sdk.e.c() { // from class: com.kwad.sdk.utils.bd.1
            @Override // com.kwad.sdk.e.a
            public final String Mj() {
                String cg = bd.cg(true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getSimCardActivePhoneCount:" + cg);
                return cg;
            }

            @Override // com.kwad.sdk.e.a
            public final String Mk() {
                String ch = bd.ch(true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getBaseStationInfo:" + ch);
                return ch;
            }

            @Override // com.kwad.sdk.e.a
            public final String Mn() {
                String ck = bd.ck(true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getSdkType:" + ck);
                return ck;
            }

            @Override // com.kwad.sdk.e.a
            public final String getAppId() {
                String cm = bd.cm(true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getAppId:" + cm);
                return cm;
            }

            @Override // com.kwad.sdk.e.a
            public final String getDeviceId() {
                String ci = bd.ci(true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getDeviceId:" + ci);
                return ci;
            }

            @Override // com.kwad.sdk.e.a
            public final String getIp() {
                String cj = bd.cj(true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getIp:" + cj);
                return cj;
            }

            @Override // com.kwad.sdk.e.a
            public final String getSdkVersion() {
                String cl = bd.cl(true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getSdkVersion:" + cl);
                return cl;
            }

            @Override // com.kwad.sdk.e.a
            public final String Mc() {
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getIMEI:" + bd.l(context, true));
                return bd.l(context, true);
            }

            @Override // com.kwad.sdk.e.a
            public final String Md() {
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getAndroidID:" + bd.m(context, true));
                return bd.m(context, true);
            }

            @Override // com.kwad.sdk.e.a
            public final String Me() {
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getMac:" + bd.n(context, true));
                return bd.n(context, true);
            }

            @Override // com.kwad.sdk.e.a
            public final String Mf() {
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getIMEI2:" + bd.o(context, true));
                return bd.o(context, true);
            }

            @Override // com.kwad.sdk.e.a
            public final String Mg() {
                String p5 = bd.p(context, true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getIMEI2:" + p5);
                return p5;
            }

            @Override // com.kwad.sdk.e.a
            public final String Mh() {
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getIMSI:" + bd.q(context, true));
                return bd.q(context, true);
            }

            @Override // com.kwad.sdk.e.a
            public final String Mi() {
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getSimCardPhoneCount:" + bd.s(context, true));
                return bd.s(context, true);
            }

            @Override // com.kwad.sdk.e.a
            public final String Ml() {
                String t5 = bd.t(context, true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getWifiList:" + t5);
                return t5;
            }

            @Override // com.kwad.sdk.e.a
            public final String Mm() {
                String v5 = bd.v(context, true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getAppList:" + v5);
                return v5;
            }

            @Override // com.kwad.sdk.e.a
            public final String getIccId() {
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getIccId:" + bd.r(context, true));
                return bd.r(context, true);
            }

            @Override // com.kwad.sdk.e.a
            public final String getLocation() {
                String u5 = bd.u(context, true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getLocation:" + u5);
                return u5;
            }

            @Override // com.kwad.sdk.e.a
            public final String getOaid() {
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getOaid:" + bd.cf(true));
                return bd.cf(true);
            }
        };
    }

    private static String dy(Context context) {
        List<cd.a> o5 = o(context, 15);
        if (o5 != null && o5.size() > 0) {
            return com.kwad.sdk.e.b.a(bc.useNetworkStateDisable(), aa.S(o5), 0);
        }
        if (bc.useNetworkStateDisable() || ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ai(32L)) {
            return com.kwad.sdk.e.b.a(false, "", 1);
        }
        return com.kwad.sdk.e.b.a(false, "", cd.ef(context) ? 1 : 3);
    }

    private static Map<String, AppPackageInfo> dz(Context context) {
        com.kwad.sdk.components.p pVar = (com.kwad.sdk.components.p) com.kwad.sdk.components.d.f(com.kwad.sdk.components.p.class);
        return (pVar == null || !s.PW()) ? new HashMap() : pVar.P(context);
    }

    private static String getAppId() {
        return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).getAppId();
    }

    private static String getSdkVersion() {
        return BuildConfig.VERSION_NAME;
    }

    public static List<cd.a> o(Context context, int i6) {
        return cd.o(context, 15);
    }

    public static com.kwad.sdk.l.a.b OO() {
        return com.kwad.sdk.l.a.b.OO();
    }

    public static com.kwad.sdk.l.a.f OP() {
        return com.kwad.sdk.l.a.f.OP();
    }

    private static String Rq() {
        int i6;
        com.kwad.sdk.l.a.f OP = com.kwad.sdk.l.a.f.OP();
        if (OP != null) {
            i6 = OP.aWR;
        } else {
            i6 = -1;
        }
        if (i6 >= 0) {
            return com.kwad.sdk.e.b.a(false, String.valueOf(i6), 0);
        }
        if (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).Bv()) {
            return com.kwad.sdk.e.b.a(false, String.valueOf(i6), 1);
        }
        return com.kwad.sdk.e.b.a(false, String.valueOf(i6), 2);
    }

    private static String Rr() {
        com.kwad.sdk.l.a.b OO = com.kwad.sdk.l.a.b.OO();
        if (OO != null) {
            return com.kwad.sdk.e.b.a(false, OO.toJson(), 0);
        }
        if (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).Bx()) {
            return com.kwad.sdk.e.b.a(false, "", 1);
        }
        return com.kwad.sdk.e.b.a(false, "", 2);
    }

    private static String Rt() {
        return com.kwad.sdk.e.b.a(false, String.valueOf(getSdkVersion()), 0);
    }

    private static String Ru() {
        return com.kwad.sdk.e.b.a(false, String.valueOf(getAppId()), 0);
    }

    public static com.kwad.sdk.utils.c.a cL(Context context) {
        return x.cL(context);
    }

    private static String cc(boolean z5) {
        String cn2 = br.cn(z5);
        if (!z5) {
            if (TextUtils.isEmpty(cn2)) {
                return "";
            }
            return cn2;
        }
        boolean z6 = true;
        if (!TextUtils.isEmpty(cn2)) {
            if (!bc.useOaidDisable() || TextUtils.isEmpty(bc.getDevOaid())) {
                z6 = false;
            }
            return com.kwad.sdk.e.b.a(z6, cn2, 0);
        }
        if (!bc.useOaidDisable() && s.PU()) {
            return com.kwad.sdk.e.b.a(false, cn2, 5);
        }
        return com.kwad.sdk.e.b.a(false, cn2, 1);
    }

    private static String ce(boolean z5) {
        String Sh = br.Sh();
        if (!z5) {
            if (TextUtils.isEmpty(Sh)) {
                return "";
            }
            return Sh;
        }
        if (!TextUtils.isEmpty(Sh)) {
            return com.kwad.sdk.e.b.a(bc.useNetworkStateDisable(), Sh, 0);
        }
        if (!bc.useNetworkStateDisable() && !((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ai(8L)) {
            return com.kwad.sdk.e.b.a(false, Sh, 2);
        }
        return com.kwad.sdk.e.b.a(false, Sh, 1);
    }

    static /* synthetic */ String cg(boolean z5) {
        return Rq();
    }

    static /* synthetic */ String ch(boolean z5) {
        return Rr();
    }

    static /* synthetic */ String ck(boolean z5) {
        return Rs();
    }

    static /* synthetic */ String cl(boolean z5) {
        return Rt();
    }

    static /* synthetic */ String cm(boolean z5) {
        return Ru();
    }

    private static String dA(Context context) {
        boolean z5;
        com.kwad.sdk.core.c.b.Ho();
        if (!com.kwad.sdk.core.c.b.isAppOnForeground()) {
            return com.kwad.sdk.e.b.a(false, "", 5);
        }
        Map<String, AppPackageInfo> dz = dz(context);
        int i6 = 1;
        if (dz.size() > 0) {
            if (bc.readInstalledPackagesDisable() && bc.getDevInstalledPackages() != null) {
                z5 = true;
            } else {
                z5 = false;
            }
            com.kwad.sdk.components.p pVar = (com.kwad.sdk.components.p) com.kwad.sdk.components.d.f(com.kwad.sdk.components.p.class);
            if (pVar != null && s.PW()) {
                return com.kwad.sdk.e.b.a(z5, pVar.c(dz), 0);
            }
        }
        if (!bc.readInstalledPackagesDisable() && s.PW()) {
            if (br.ed(context)) {
                i6 = 3;
            }
            return com.kwad.sdk.e.b.a(false, "", i6);
        }
        return com.kwad.sdk.e.b.a(false, "", 1);
    }

    private static String dB(Context context) {
        com.kwad.sdk.utils.c.a cL = x.cL(context);
        int i6 = 1;
        boolean z5 = true;
        if (cL != null && cL.bcT != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("latitude", String.valueOf(cL.bcT.getLatitude()));
            hashMap.put("longitude", String.valueOf(cL.bcT.getLongitude()));
            if (!bc.readLocationDisable() || bc.Ro() == null) {
                z5 = false;
            }
            return com.kwad.sdk.e.b.a(z5, aa.parseMap2JSON(hashMap), 0);
        }
        if (!bc.readLocationDisable() && !((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ai(64L)) {
            if (ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f36047g) == 0) {
                i6 = 3;
            }
            return com.kwad.sdk.e.b.a(false, "", i6);
        }
        return com.kwad.sdk.e.b.a(false, "", 1);
    }

    public static int dv(Context context) {
        return br.dW(context);
    }

    private static String dw(Context context) {
        int dW = br.dW(context);
        if (dW > 0) {
            return com.kwad.sdk.e.b.a(false, String.valueOf(dW), 0);
        }
        if (Build.VERSION.SDK_INT < 23) {
            return com.kwad.sdk.e.b.a(false, String.valueOf(dW), 1);
        }
        return com.kwad.sdk.e.b.a(false, String.valueOf(dW), 3);
    }

    public static int dx(Context context) {
        return br.dX(context);
    }

    private static String e(Context context, boolean z5) {
        String w5 = br.w(context, z5);
        if (!z5) {
            if (TextUtils.isEmpty(w5)) {
                return "";
            }
            return w5;
        }
        int i6 = 1;
        boolean z6 = true;
        if (!TextUtils.isEmpty(w5)) {
            if (!bc.usePhoneStateDisable() || TextUtils.isEmpty(bc.getDevImei())) {
                z6 = false;
            }
            return com.kwad.sdk.e.b.a(z6, w5, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return com.kwad.sdk.e.b.a(false, w5, 4);
        }
        if (!bc.usePhoneStateDisable() && s.PY()) {
            if (SystemUtil.dN(context)) {
                i6 = 3;
            }
            return com.kwad.sdk.e.b.a(false, w5, i6);
        }
        return com.kwad.sdk.e.b.a(false, w5, 1);
    }

    private static String f(Context context, boolean z5) {
        String dp = br.dp(context);
        if (!z5) {
            if (TextUtils.isEmpty(dp)) {
                return "";
            }
            return dp;
        }
        boolean z6 = true;
        if (!TextUtils.isEmpty(dp)) {
            if (!bc.usePhoneStateDisable() || TextUtils.isEmpty(bc.getDevAndroidId())) {
                z6 = false;
            }
            return com.kwad.sdk.e.b.a(z6, dp, 0);
        }
        if (!bc.usePhoneStateDisable() && s.PS()) {
            return com.kwad.sdk.e.b.a(false, dp, 5);
        }
        return com.kwad.sdk.e.b.a(false, dp, 1);
    }

    private static String g(Context context, boolean z5) {
        String eb = br.eb(context);
        if (!z5) {
            if (TextUtils.isEmpty(eb)) {
                return "";
            }
            return eb;
        }
        int i6 = 1;
        boolean z6 = true;
        if (!TextUtils.isEmpty(eb)) {
            if (!bc.useMacAddressDisable() || TextUtils.isEmpty(bc.getDevMacAddress())) {
                z6 = false;
            }
            return com.kwad.sdk.e.b.a(z6, eb.toLowerCase(), 0);
        }
        if (!bc.useMacAddressDisable() && s.PT()) {
            if (au.at(context, com.kuaishou.weapon.p0.g.f36044d) == 0) {
                i6 = 3;
            }
            return com.kwad.sdk.e.b.a(false, eb, i6);
        }
        return com.kwad.sdk.e.b.a(false, eb, 0);
    }

    private static String h(Context context, boolean z5) {
        String str;
        String[] dV = br.dV(context);
        if (dV != null && dV.length > 0) {
            str = dV[0];
        } else {
            str = null;
        }
        if (!z5) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            return str;
        }
        int i6 = 1;
        boolean z6 = true;
        if (!TextUtils.isEmpty(str)) {
            if (!bc.usePhoneStateDisable() || TextUtils.isEmpty(bc.getDevImei())) {
                z6 = false;
            }
            return com.kwad.sdk.e.b.a(z6, str, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return com.kwad.sdk.e.b.a(false, str, 4);
        }
        if (!bc.usePhoneStateDisable() && s.PY()) {
            if (SystemUtil.dN(context)) {
                i6 = 3;
            }
            return com.kwad.sdk.e.b.a(false, str, i6);
        }
        return com.kwad.sdk.e.b.a(false, str, 1);
    }

    private static String i(Context context, boolean z5) {
        String str;
        String[] dV = br.dV(context);
        int i6 = 1;
        boolean z6 = true;
        if (dV != null && dV.length > 1) {
            str = dV[1];
        } else {
            str = null;
        }
        if (!z5) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            return str;
        }
        if (!TextUtils.isEmpty(str)) {
            if (!bc.usePhoneStateDisable() || TextUtils.isEmpty(bc.getDevImei())) {
                z6 = false;
            }
            return com.kwad.sdk.e.b.a(z6, str, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return com.kwad.sdk.e.b.a(false, str, 4);
        }
        if (!bc.usePhoneStateDisable() && s.PY()) {
            if (SystemUtil.dN(context)) {
                i6 = 3;
            }
            return com.kwad.sdk.e.b.a(false, str, i6);
        }
        return com.kwad.sdk.e.b.a(false, str, 1);
    }

    public static void init(Context context) {
        com.kwad.sdk.e.b.a(dC(context));
    }

    private static String j(Context context, boolean z5) {
        String dt = br.dt(context);
        if (!z5) {
            if (TextUtils.isEmpty(dt)) {
                return "";
            }
            return dt;
        }
        if (!TextUtils.isEmpty(dt)) {
            return com.kwad.sdk.e.b.a(bc.usePhoneStateDisable(), dt, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return com.kwad.sdk.e.b.a(false, dt, 4);
        }
        int i6 = 1;
        if (!bc.usePhoneStateDisable() && s.PZ()) {
            if (SystemUtil.dN(context)) {
                i6 = 3;
            }
            return com.kwad.sdk.e.b.a(false, dt, i6);
        }
        return com.kwad.sdk.e.b.a(false, dt, 1);
    }

    private static String k(Context context, boolean z5) {
        String dY = br.dY(context);
        if (!z5) {
            if (TextUtils.isEmpty(dY)) {
                return "";
            }
            return dY;
        }
        if (!TextUtils.isEmpty(dY)) {
            return com.kwad.sdk.e.b.a(bc.usePhoneStateDisable(), dY, 0);
        }
        int i6 = 1;
        if (!bc.usePhoneStateDisable() && s.Qa()) {
            if (SystemUtil.dN(context)) {
                i6 = 3;
            }
            return com.kwad.sdk.e.b.a(false, dY, i6);
        }
        return com.kwad.sdk.e.b.a(false, dY, 1);
    }

    static /* synthetic */ String s(Context context, boolean z5) {
        return dw(context);
    }

    static /* synthetic */ String t(Context context, boolean z5) {
        return dy(context);
    }

    static /* synthetic */ String u(Context context, boolean z5) {
        return dB(context);
    }

    static /* synthetic */ String v(Context context, boolean z5) {
        return dA(context);
    }
}
