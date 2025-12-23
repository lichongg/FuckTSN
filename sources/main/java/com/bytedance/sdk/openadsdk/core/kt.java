package com.bytedance.sdk.openadsdk.core;

import android.annotation.SuppressLint;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.stub.StubApp;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class kt {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f29320a = false;
    private static volatile String ae = null;
    private static volatile String av = null;
    private static volatile String az = null;

    /* renamed from: c, reason: collision with root package name */
    private static volatile TelephonyManager f29321c = null;
    private static volatile boolean ch = false;
    private static volatile String cw = null;
    private static volatile boolean ed = false;

    /* renamed from: f, reason: collision with root package name */
    private static volatile boolean f29322f = false;

    /* renamed from: g, reason: collision with root package name */
    private static volatile String f29323g = null;
    private static volatile boolean gq = false;
    private static volatile WifiManager gx = null;

    /* renamed from: h, reason: collision with root package name */
    private static volatile boolean f29324h = false;

    /* renamed from: i, reason: collision with root package name */
    private static volatile String f29325i = null;

    /* renamed from: j, reason: collision with root package name */
    private static String f29326j = null;
    private static volatile String jy = null;

    /* renamed from: l, reason: collision with root package name */
    private static volatile boolean f29327l = false;
    private static volatile boolean la = false;

    /* renamed from: m, reason: collision with root package name */
    private static volatile String f29328m = null;
    private static volatile String mi = null;

    /* renamed from: n, reason: collision with root package name */
    private static volatile WifiInfo f29329n = null;

    /* renamed from: p, reason: collision with root package name */
    private static volatile boolean f29330p = false;

    /* renamed from: r, reason: collision with root package name */
    private static volatile String f29331r = null;

    /* renamed from: s, reason: collision with root package name */
    private static volatile boolean f29332s = false;
    private static volatile long uf = 0;
    private static volatile String up = null;

    /* renamed from: v, reason: collision with root package name */
    private static volatile boolean f29333v = false;

    /* renamed from: w, reason: collision with root package name */
    private static volatile String f29334w = null;
    private static volatile String wq = null;
    private static volatile String ws = null;

    /* renamed from: x, reason: collision with root package name */
    private static volatile boolean f29335x = false;
    private static volatile String xt = "";
    private static AtomicBoolean tl = new AtomicBoolean(false);
    private static volatile String oq = "";
    private static volatile String qv = "";
    private static volatile boolean vl = true;
    private static volatile String kt = null;
    private static AtomicBoolean tj = new AtomicBoolean(false);
    private static AtomicBoolean rn = new AtomicBoolean(false);

    public static String i() {
        try {
            uf();
            if (!TextUtils.isEmpty(jy)) {
                return jy;
            }
            if (!j(uf, 60000L)) {
                return wq;
            }
            if (!av()) {
                return null;
            }
            int i6 = v.getContext().getResources().getConfiguration().mcc;
            String valueOf = i6 != 0 ? String.valueOf(i6) : jy;
            wq = valueOf;
            uf = System.currentTimeMillis();
            return valueOf;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static TelephonyManager j() {
        if (f29321c != null) {
            return f29321c;
        }
        synchronized (kt.class) {
            try {
                if (f29321c != null) {
                    return f29321c;
                }
                f29321c = (TelephonyManager) v.getContext().getSystemService("phone");
                return f29321c;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static String nd() {
        String str = null;
        try {
            String cw2 = com.bytedance.sdk.openadsdk.core.cw.r.j().cw("new_mac_address", "");
            if (!TextUtils.isEmpty(cw2)) {
                JSONObject jSONObject = new JSONObject(cw2);
                long j6 = jSONObject.getLong("time");
                str = com.bytedance.sdk.component.utils.j.cw(jSONObject.getString("value"));
                if (System.currentTimeMillis() - j6 <= 864000000) {
                    if (!TextUtils.isEmpty(str)) {
                        return str;
                    }
                }
            }
        } catch (Exception unused) {
        }
        if (com.bytedance.sdk.openadsdk.core.r.j.tl()) {
            if (!TextUtils.isEmpty(kt)) {
                str = kt;
            }
            if (!TextUtils.isEmpty(str)) {
                if (!tj.get()) {
                    new com.bytedance.sdk.openadsdk.core.r.xt("device_get_macaddress").j(5).j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.kt.6
                        @Override // java.lang.Runnable
                        public void run() {
                            kt.tj.set(false);
                        }
                    }).xt(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.kt.5
                        @Override // java.lang.Runnable
                        public void run() {
                            kt.tj.set(false);
                            kt.gx();
                        }
                    });
                }
                tj.set(true);
                return str;
            }
        }
        gx();
        return kt;
    }

    public static String r() {
        if (!TextUtils.isEmpty(f29334w)) {
            return f29334w;
        }
        String valueOf = String.valueOf(Build.TIME);
        f29334w = valueOf;
        return valueOf;
    }

    public static boolean up() {
        return f29322f;
    }

    @SuppressLint({"HardwareIds"})
    public static String ae() {
        if (!TextUtils.isEmpty(up)) {
            return up;
        }
        com.bytedance.sdk.openadsdk.i.cw.cw.r w5 = oq.i().w();
        return j(w5, w5 != null && w5.cw());
    }

    public static boolean av() {
        if (f29330p) {
            return vl;
        }
        synchronized (kt.class) {
            if (f29330p) {
                return vl;
            }
            try {
                int simState = j().getSimState();
                if (1 == simState) {
                    vl = false;
                }
                if (simState == 0) {
                    vl = false;
                }
                f29330p = true;
            } catch (Throwable unused) {
            }
            return vl;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0028, code lost:
    
        if (r2.length() < 13) goto L17;
     */
    @android.annotation.SuppressLint({"TrulyRandom", "HardwareIds"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static synchronized java.lang.String c() {
        /*
            java.lang.Class<com.bytedance.sdk.openadsdk.core.kt> r0 = com.bytedance.sdk.openadsdk.core.kt.class
            monitor-enter(r0)
            android.content.Context r1 = com.bytedance.sdk.openadsdk.core.v.getContext()     // Catch: java.lang.Throwable -> L1a
            r2 = 0
            if (r1 != 0) goto Lc
            monitor-exit(r0)
            return r2
        Lc:
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
            java.lang.String r3 = "android_id"
            java.lang.String r2 = android.provider.Settings.Secure.getString(r1, r3)     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
            r1 = 1
            com.bytedance.sdk.openadsdk.core.kt.f29322f = r1     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
            goto L1c
        L1a:
            r1 = move-exception
            goto L2e
        L1c:
            boolean r1 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L1a
            if (r1 != 0) goto L2a
            int r1 = r2.length()     // Catch: java.lang.Throwable -> L1a
            r3 = 13
            if (r1 >= r3) goto L2c
        L2a:
            java.lang.String r2 = ""
        L2c:
            monitor-exit(r0)
            return r2
        L2e:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1a
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.kt.c():java.lang.String");
    }

    public static String cw() {
        if (!TextUtils.isEmpty(cw)) {
            return cw;
        }
        String xt2 = xt.j().xt("did", f29326j);
        cw = xt2;
        return xt2;
    }

    private static synchronized void ed() {
        int activeSubscriptionInfoCount;
        List activeSubscriptionInfoList;
        int mcc;
        String valueOf;
        int mnc;
        String valueOf2;
        synchronized (kt.class) {
            if (ed) {
                return;
            }
            if (Build.VERSION.SDK_INT < 22) {
                return;
            }
            synchronized (kt.class) {
                ed = true;
                SubscriptionManager a6 = d.a(v.getContext().getSystemService("telephony_subscription_service"));
                activeSubscriptionInfoCount = a6.getActiveSubscriptionInfoCount();
                if (activeSubscriptionInfoCount < 2) {
                    return;
                }
                activeSubscriptionInfoList = a6.getActiveSubscriptionInfoList();
                if (activeSubscriptionInfoList.size() < 2) {
                    return;
                }
                for (int i6 = 0; i6 < 2; i6++) {
                    SubscriptionInfo a7 = n.a(activeSubscriptionInfoList.get(i6));
                    if (Build.VERSION.SDK_INT >= 29) {
                        valueOf = a7.getMccString();
                        valueOf2 = a7.getMncString();
                    } else {
                        mcc = a7.getMcc();
                        valueOf = String.valueOf(mcc);
                        mnc = a7.getMnc();
                        valueOf2 = String.valueOf(mnc);
                    }
                    if (i6 == 0) {
                        if (!TextUtils.isEmpty(valueOf)) {
                            jy = valueOf;
                        }
                        if (!TextUtils.isEmpty(valueOf2)) {
                            az = valueOf2;
                        }
                    } else {
                        if (!TextUtils.isEmpty(valueOf)) {
                            ws = valueOf;
                        }
                        if (!TextUtils.isEmpty(valueOf2)) {
                            av = valueOf2;
                        }
                    }
                }
            }
        }
    }

    public static String f() {
        if (!TextUtils.isEmpty(kt)) {
            return kt;
        }
        com.bytedance.sdk.openadsdk.i.cw.cw.r w5 = oq.i().w();
        return (w5 == null || w5.r()) ? n() : w5.qv();
    }

    public static String g() {
        if (!TextUtils.isEmpty(f29328m)) {
            return f29328m;
        }
        com.bytedance.sdk.openadsdk.i.cw.cw.r w5 = oq.i().w();
        if (w5 == null || (w5.r() && w5.j())) {
            return rn();
        }
        return null;
    }

    private static String gq() {
        if (f29320a) {
            return f29323g;
        }
        synchronized (kt.class) {
            try {
                if (f29320a) {
                    return f29323g;
                }
                if (f29335x) {
                    return up;
                }
                TelephonyManager j6 = j();
                if (j6 == null) {
                    return f29323g;
                }
                try {
                    f29323g = j6.getSubscriberId();
                } catch (Throwable unused) {
                }
                f29320a = true;
                return f29323g;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void gx() {
        String up2 = up("wlan0");
        if (TextUtils.isEmpty(up2)) {
            up2 = up("eth0");
        }
        if (TextUtils.isEmpty(up2)) {
            up2 = "DU:MM:YA:DD:RE:SS";
        }
        com.bytedance.sdk.openadsdk.core.cw.r.j().r("mac_address", up2);
        com.bytedance.sdk.openadsdk.core.cw.r.j().r("new_mac_address", com.bytedance.sdk.component.utils.j.xt(up2));
        kt = up2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h() {
        synchronized (kt.class) {
            try {
                if (f29322f) {
                    return;
                }
                f29331r = c();
                com.bytedance.sdk.openadsdk.tools.xt.xt(9, f29331r);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void la() {
        String imei;
        synchronized (kt.class) {
            try {
                if (f29333v) {
                    return;
                }
                if (f29335x) {
                    return;
                }
                if (com.bytedance.sdk.openadsdk.core.x.xt.j(v.getContext(), com.kuaishou.weapon.p0.g.f36043c) == 0) {
                    f29335x = true;
                    TelephonyManager j6 = j();
                    if (j6 == null) {
                        return;
                    }
                    try {
                        if (Build.VERSION.SDK_INT >= 26) {
                            imei = j6.getImei();
                            up = imei;
                        } else {
                            up = j6.getDeviceId();
                        }
                    } catch (Throwable unused) {
                    }
                    f29333v = true;
                    com.bytedance.sdk.openadsdk.tools.xt.xt(6, up);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static String m() {
        if (!TextUtils.isEmpty(f29331r)) {
            return f29331r;
        }
        com.bytedance.sdk.openadsdk.i.cw.cw.r w5 = oq.i().w();
        if (w5 != null && h.xt >= 4600 && !w5.m()) {
            if (h.xt >= 4900) {
                return w5.ws();
            }
            return null;
        }
        if (f29322f) {
            return f29331r;
        }
        if (com.bytedance.sdk.openadsdk.core.r.j.tl()) {
            String ae2 = com.bytedance.sdk.openadsdk.core.cw.r.j().ae();
            if (!TextUtils.isEmpty(ae2)) {
                f29331r = ae2;
                new com.bytedance.sdk.openadsdk.core.r.xt("device_get_android_id").j(5).xt(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.kt.1
                    @Override // java.lang.Runnable
                    public void run() {
                        kt.h();
                    }
                });
                return f29331r;
            }
        }
        h();
        return f29331r;
    }

    private static String n() {
        if (gq) {
            return kt;
        }
        synchronized (kt.class) {
            try {
                if (gq) {
                    return kt;
                }
                kt = nd();
                gq = true;
                return kt;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static String oq() {
        if (!TextUtils.isEmpty(ae)) {
            return ae;
        }
        com.bytedance.sdk.openadsdk.i.cw.cw.r w5 = oq.i().w();
        if (w5 == null || (w5.r() && w5.j())) {
            return wq();
        }
        return null;
    }

    private static WifiManager p() {
        if (gx != null) {
            return gx;
        }
        synchronized (kt.class) {
            try {
                if (gx != null) {
                    return gx;
                }
                gx = (WifiManager) StubApp.getOrigApplicationContext(v.getContext().getApplicationContext()).getSystemService("wifi");
                return gx;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static String qv() {
        if (!TextUtils.isEmpty(ae) || f29332s) {
            return ae;
        }
        if (tl.get()) {
            return null;
        }
        tl.set(true);
        com.bytedance.sdk.component.oq.ae.xt(new com.bytedance.sdk.component.oq.g("") { // from class: com.bytedance.sdk.openadsdk.core.kt.3
            @Override // java.lang.Runnable
            public void run() {
                kt.oq();
                kt.tl.set(false);
            }
        });
        return null;
    }

    private static String rn() {
        WifiInfo xt2;
        if (ch) {
            return f29328m;
        }
        synchronized (kt.class) {
            if (ch) {
                return f29328m;
            }
            try {
                xt2 = xt();
            } catch (Throwable unused) {
            }
            if (xt2 == null) {
                return f29328m;
            }
            f29328m = xt2.getSSID();
            ch = true;
            return f29328m;
        }
    }

    @SuppressLint({"HardwareIds"})
    public static String tl() {
        if (!TextUtils.isEmpty(f29323g)) {
            return f29323g;
        }
        com.bytedance.sdk.openadsdk.i.cw.cw.r w5 = oq.i().w();
        if (w5 == null || w5.cw()) {
            return gq();
        }
        return null;
    }

    private static void uf() {
        String str;
        String str2;
        String str3;
        if (f29324h) {
            return;
        }
        synchronized (kt.class) {
            try {
                if (f29324h) {
                    return;
                }
                TelephonyManager j6 = j();
                String str4 = null;
                try {
                    str = j6.getNetworkOperator();
                } catch (Throwable unused) {
                    str = null;
                }
                if (TextUtils.isEmpty(str) || str.length() < 5) {
                    str = az();
                }
                try {
                    str2 = j6.getSimOperatorName();
                } catch (Throwable unused2) {
                    str2 = null;
                }
                if (TextUtils.isEmpty(str) || str.length() <= 4) {
                    str3 = null;
                } else {
                    str4 = str.substring(0, 3);
                    str3 = str.substring(3);
                }
                if (!TextUtils.isEmpty(str4)) {
                    jy = str4;
                }
                if (!TextUtils.isEmpty(str3)) {
                    az = str3;
                }
                if (!TextUtils.isEmpty(str2)) {
                    f29325i = str2;
                }
                ed();
                f29324h = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static String up(com.bytedance.sdk.openadsdk.core.x.j jVar) {
        if (!TextUtils.isEmpty(kt) || gq) {
            return kt;
        }
        com.bytedance.sdk.openadsdk.i.cw.cw.r w5 = oq.i().w();
        return (w5 == null || jVar.xt()) ? n() : w5.qv();
    }

    public static String v() {
        if (!TextUtils.isEmpty(xt)) {
            return xt;
        }
        String j6 = com.bytedance.sdk.component.utils.x.j();
        xt = j6;
        return j6;
    }

    private static String wq() {
        if (f29332s) {
            return ae;
        }
        synchronized (kt.class) {
            try {
                if (f29332s) {
                    return ae;
                }
                ae = jy();
                f29332s = true;
                return ae;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void ws() {
        TelephonyManager j6;
        String imei;
        if (f29335x) {
            return;
        }
        com.bytedance.sdk.openadsdk.i.cw.cw.r w5 = oq.i().w();
        if ((w5 == null || w5.cw()) && com.bytedance.sdk.openadsdk.core.x.xt.j(v.getContext(), com.kuaishou.weapon.p0.g.f36043c) == 0 && (j6 = j()) != null) {
            synchronized (kt.class) {
                try {
                    f29335x = true;
                    if (TextUtils.isEmpty(up)) {
                        try {
                            if (Build.VERSION.SDK_INT >= 26) {
                                imei = j6.getImei();
                                up = imei;
                            } else {
                                up = j6.getDeviceId();
                            }
                        } catch (Throwable unused) {
                        }
                        com.bytedance.sdk.openadsdk.tools.xt.xt(6, up);
                    }
                    if (TextUtils.isEmpty(f29323g)) {
                        try {
                            f29323g = j6.getSubscriberId();
                        } catch (Throwable unused2) {
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static WifiInfo xt() {
        com.bytedance.sdk.openadsdk.i.cw.cw.r w5 = oq.i().w();
        if (w5 != null && (!w5.r() || !w5.j())) {
            return f29329n;
        }
        if (f29329n != null) {
            return f29329n;
        }
        synchronized (kt.class) {
            try {
                if (f29329n != null) {
                    return f29329n;
                }
                WifiManager p5 = p();
                if (p5 == null) {
                    return f29329n;
                }
                f29329n = p5.getConnectionInfo();
                return f29329n;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static String az() {
        com.bytedance.sdk.openadsdk.i.cw.cw.r w5 = oq.i().w();
        if (w5 != null && !w5.cw()) {
            return "";
        }
        if (!TextUtils.isEmpty(oq)) {
            return oq;
        }
        if (f29327l) {
            return oq;
        }
        synchronized (kt.class) {
            try {
                if (f29327l) {
                    return oq;
                }
                TelephonyManager j6 = j();
                if (j6 == null) {
                    return oq;
                }
                try {
                    oq = j6.getSimOperator();
                } catch (Throwable unused) {
                }
                f29327l = true;
                return oq;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static String jy() {
        if (com.bytedance.sdk.openadsdk.core.r.j.tl()) {
            new com.bytedance.sdk.openadsdk.core.r.xt("device_get_bssid").j(3).xt(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.kt.4
                @Override // java.lang.Runnable
                public void run() {
                    String unused = kt.ae = kt.r("02:00:00:00:00:00");
                }
            });
            if (TextUtils.isEmpty(ae)) {
                return "02:00:00:00:00:00";
            }
            return ae;
        }
        return r("02:00:00:00:00:00");
    }

    public static String kt() {
        uf();
        return av;
    }

    public static String mi() {
        uf();
        return az;
    }

    public static String tj() {
        uf();
        return f29325i;
    }

    public static String vl() {
        String serial;
        com.bytedance.sdk.openadsdk.i.cw.cw.r w5 = oq.i().w();
        if (w5 != null && !w5.cw()) {
            return null;
        }
        if (!TextUtils.isEmpty(mi)) {
            return mi;
        }
        if (la) {
            return mi;
        }
        synchronized (kt.class) {
            try {
                if (la) {
                    return mi;
                }
                if (Build.VERSION.SDK_INT >= 28) {
                    try {
                        serial = Build.getSerial();
                        mi = serial;
                    } catch (Throwable unused) {
                    }
                } else {
                    mi = Build.SERIAL;
                }
                la = true;
                return mi;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static String w() {
        uf();
        return ws;
    }

    public static String r(com.bytedance.sdk.openadsdk.core.x.j jVar) {
        if (TextUtils.isEmpty(ae) && !f29332s) {
            if (jVar.xt() && jVar.cw()) {
                return wq();
            }
            return null;
        }
        return ae;
    }

    public static String cw(com.bytedance.sdk.openadsdk.core.x.j jVar) {
        if (TextUtils.isEmpty(f29328m) && !ch) {
            if (jVar.xt() && jVar.cw()) {
                return rn();
            }
            return null;
        }
        return f29328m;
    }

    @SuppressLint({"NewApi"})
    private static String up(String str) {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (str == null || networkInterface.getName().equalsIgnoreCase(str)) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    for (byte b6 : hardwareAddress) {
                        sb.append(String.format("%02X:", Byte.valueOf(b6)));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String r(String str) {
        try {
            WifiInfo xt2 = xt();
            if (xt2 != null) {
                String bssid = xt2.getBSSID();
                if (!TextUtils.isEmpty(bssid)) {
                    return bssid;
                }
            }
        } catch (Throwable unused) {
        }
        return str;
    }

    public static void j(String str) {
        if (com.bytedance.sdk.openadsdk.j.j.j.j() != null) {
            com.bytedance.sdk.openadsdk.j.j.j.j().j(str);
        }
        if (TextUtils.isEmpty(str) || str.equals(cw)) {
            return;
        }
        xt.j().j("did", str);
        cw = str;
    }

    public static String j(com.bytedance.sdk.openadsdk.core.x.j jVar) {
        if (TextUtils.isEmpty(up) && !f29333v) {
            return j(oq.i().w(), jVar.j());
        }
        return up;
    }

    public static String xt(com.bytedance.sdk.openadsdk.core.x.j jVar) {
        if (TextUtils.isEmpty(f29323g) && !f29320a && !f29335x) {
            if (jVar.j()) {
                return gq();
            }
            return null;
        }
        return f29323g;
    }

    private static String j(com.bytedance.sdk.openadsdk.i.cw.cw.r rVar, boolean z5) {
        if (rVar != null && !z5) {
            String oq2 = rVar.oq();
            up = oq2;
            com.bytedance.sdk.openadsdk.tools.xt.xt(6, oq2);
            return oq2;
        }
        if (f29333v) {
            return up;
        }
        if (com.bytedance.sdk.openadsdk.core.r.j.tl()) {
            String qv2 = TextUtils.isEmpty(up) ? com.bytedance.sdk.openadsdk.core.cw.r.j().qv(null) : up;
            if (!TextUtils.isEmpty(qv2)) {
                new com.bytedance.sdk.openadsdk.core.r.xt("device_get_imei").j(5).xt(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.kt.2
                    @Override // java.lang.Runnable
                    public void run() {
                        kt.la();
                    }
                });
                return qv2;
            }
        }
        la();
        return up;
    }

    private static boolean j(long j6, long j7) {
        return System.currentTimeMillis() - j6 > j7;
    }
}
