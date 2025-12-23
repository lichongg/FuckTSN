package com.autonavi.aps.amapapi.restruct;

import android.content.ContentResolver;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.work.WorkRequest;
import com.amap.api.col.p0003l.l9;
import com.umeng.analytics.pro.bi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.TreeMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class k {

    /* renamed from: d, reason: collision with root package name */
    static long f10094d;

    /* renamed from: e, reason: collision with root package name */
    static long f10095e;

    /* renamed from: f, reason: collision with root package name */
    static long f10096f;

    /* renamed from: g, reason: collision with root package name */
    public static long f10097g;

    /* renamed from: h, reason: collision with root package name */
    static long f10098h;

    /* renamed from: v, reason: collision with root package name */
    public static HashMap<String, Long> f10099v = new HashMap<>(36);

    /* renamed from: w, reason: collision with root package name */
    public static long f10100w = 0;

    /* renamed from: x, reason: collision with root package name */
    static int f10101x = 0;

    /* renamed from: z, reason: collision with root package name */
    public static long f10102z = 0;
    private com.autonavi.aps.amapapi.c E;

    /* renamed from: a, reason: collision with root package name */
    WifiManager f10103a;

    /* renamed from: i, reason: collision with root package name */
    Context f10106i;

    /* renamed from: t, reason: collision with root package name */
    i f10117t;

    /* renamed from: b, reason: collision with root package name */
    ArrayList<l9> f10104b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    ArrayList<l9> f10105c = new ArrayList<>();

    /* renamed from: j, reason: collision with root package name */
    boolean f10107j = false;

    /* renamed from: k, reason: collision with root package name */
    StringBuilder f10108k = null;

    /* renamed from: l, reason: collision with root package name */
    boolean f10109l = true;

    /* renamed from: m, reason: collision with root package name */
    boolean f10110m = true;

    /* renamed from: n, reason: collision with root package name */
    boolean f10111n = true;
    private volatile j B = null;

    /* renamed from: o, reason: collision with root package name */
    String f10112o = null;

    /* renamed from: p, reason: collision with root package name */
    TreeMap<Integer, l9> f10113p = null;

    /* renamed from: q, reason: collision with root package name */
    public boolean f10114q = true;

    /* renamed from: r, reason: collision with root package name */
    public boolean f10115r = true;

    /* renamed from: s, reason: collision with root package name */
    public boolean f10116s = false;
    private String C = "";

    /* renamed from: u, reason: collision with root package name */
    long f10118u = 0;

    /* renamed from: y, reason: collision with root package name */
    ConnectivityManager f10119y = null;
    private long D = WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;
    volatile boolean A = false;

    public static long b() {
        return ((com.autonavi.aps.amapapi.utils.j.b() - f10100w) / 1000) + 1;
    }

    public final ArrayList<l9> a() {
        if (!this.f10116s) {
            return this.f10105c;
        }
        b(true);
        return this.f10105c;
    }

    public final WifiInfo c() {
        try {
            if (this.f10103a == null) {
                return null;
            }
            if (com.autonavi.aps.amapapi.utils.j.c(this.f10106i, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF")) {
                return this.f10103a.getConnectionInfo();
            }
            com.autonavi.aps.amapapi.utils.b.a(new Exception("gci_n_aws"), "OPENSDK_WMW", "gci_n_aws");
            return null;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "WifiManagerWrapper", "getConnectionInfo");
            return null;
        }
    }

    public final String d() {
        return this.f10112o;
    }

    public final void f() {
        try {
            this.f10116s = true;
            List<l9> r5 = r();
            if (r5 != null) {
                this.f10104b.clear();
                this.f10104b.addAll(r5);
            }
            d(true);
        } catch (Throwable unused) {
        }
    }

    public final void g() {
        this.B = null;
        this.f10104b.clear();
    }

    private void A() {
        try {
            if (com.autonavi.aps.amapapi.utils.j.c(this.f10106i, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF")) {
                this.f10115r = this.f10103a.isWifiEnabled();
            }
        } catch (Throwable unused) {
            com.autonavi.aps.amapapi.utils.d.b();
        }
    }

    private void d(boolean z5) {
        ArrayList<l9> arrayList = this.f10104b;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (com.autonavi.aps.amapapi.utils.j.b() - f10097g > 3600000) {
            g();
        }
        if (this.f10113p == null) {
            this.f10113p = new TreeMap<>(Collections.reverseOrder());
        }
        this.f10113p.clear();
        if (this.f10116s && z5) {
            try {
                this.f10105c.clear();
            } catch (Throwable unused) {
            }
        }
        int size = this.f10104b.size();
        this.f10118u = 0L;
        for (int i6 = 0; i6 < size; i6++) {
            l9 l9Var = this.f10104b.get(i6);
            if (l9Var.f6752h) {
                this.f10118u = l9Var.f6750f;
            }
            if (com.autonavi.aps.amapapi.utils.j.a(l9.c(l9Var.f6745a)) && (size <= 20 || a(l9Var.f6747c))) {
                if (this.f10116s && z5) {
                    this.f10105c.add(l9Var);
                }
                if (TextUtils.isEmpty(l9Var.f6746b)) {
                    l9Var.f6746b = "unkwn";
                } else if (!"<unknown ssid>".equals(l9Var.f6746b)) {
                    l9Var.f6746b = String.valueOf(i6);
                }
                this.f10113p.put(Integer.valueOf((l9Var.f6747c * 25) + i6), l9Var);
            }
        }
        this.f10104b.clear();
        Iterator<l9> it = this.f10113p.values().iterator();
        while (it.hasNext()) {
            this.f10104b.add(it.next());
        }
        this.f10113p.clear();
    }

    private List<l9> r() {
        List<ScanResult> list;
        if (this.f10103a != null) {
            try {
                if (com.autonavi.aps.amapapi.utils.j.c(this.f10106i, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF")) {
                    list = this.f10103a.getScanResults();
                } else {
                    com.autonavi.aps.amapapi.utils.b.a(new Exception("gst_n_aws"), "OPENSDK_WMW", "gsr_n_aws");
                    list = null;
                }
                HashMap<String, Long> hashMap = new HashMap<>(36);
                if (list != null) {
                    for (ScanResult scanResult : list) {
                        hashMap.put(scanResult.BSSID, Long.valueOf(scanResult.timestamp));
                    }
                }
                if (f10099v.isEmpty() || !f10099v.equals(hashMap)) {
                    f10099v = hashMap;
                    f10100w = com.autonavi.aps.amapapi.utils.j.b();
                }
                this.f10112o = null;
                ArrayList arrayList = new ArrayList();
                this.C = "";
                this.B = m();
                if (a(this.B)) {
                    this.C = this.B.a();
                }
                if (list != null && list.size() > 0) {
                    int size = list.size();
                    for (int i6 = 0; i6 < size; i6++) {
                        ScanResult scanResult2 = list.get(i6);
                        l9 l9Var = new l9(!TextUtils.isEmpty(this.C) && this.C.equals(scanResult2.BSSID));
                        l9Var.f6746b = scanResult2.SSID;
                        l9Var.f6748d = scanResult2.frequency;
                        l9Var.f6749e = scanResult2.timestamp;
                        l9Var.f6745a = l9.a(scanResult2.BSSID);
                        l9Var.f6747c = (short) scanResult2.level;
                        short elapsedRealtime = (short) ((SystemClock.elapsedRealtime() - (scanResult2.timestamp / 1000)) / 1000);
                        l9Var.f6751g = elapsedRealtime;
                        if (elapsedRealtime < 0) {
                            l9Var.f6751g = (short) 0;
                        }
                        l9Var.f6750f = com.autonavi.aps.amapapi.utils.j.b();
                        arrayList.add(l9Var);
                    }
                }
                this.f10117t.a((List) arrayList);
                return arrayList;
            } catch (SecurityException e6) {
                this.f10112o = e6.getMessage();
            } catch (Throwable th) {
                this.f10112o = null;
                com.autonavi.aps.amapapi.utils.b.a(th, "WifiManagerWrapper", "getScanResults");
            }
        }
        return null;
    }

    private int s() {
        WifiManager wifiManager = this.f10103a;
        if (wifiManager != null) {
            return wifiManager.getWifiState();
        }
        return 4;
    }

    private boolean u() {
        if (this.f10119y == null) {
            this.f10119y = (ConnectivityManager) com.autonavi.aps.amapapi.utils.j.a(this.f10106i, "connectivity");
        }
        return a(this.f10119y);
    }

    private boolean v() {
        if (this.f10103a == null) {
            return false;
        }
        return com.autonavi.aps.amapapi.utils.j.g(this.f10106i);
    }

    private void y() {
        List<l9> list;
        if (f10098h != f10097g) {
            try {
                list = r();
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "WifiManager", "updateScanResult");
                list = null;
            }
            f10098h = f10097g;
            if (list == null) {
                this.f10104b.clear();
            } else {
                this.f10104b.clear();
                this.f10104b.addAll(list);
            }
        }
    }

    private void z() {
        int i6;
        try {
            if (this.f10103a == null) {
                return;
            }
            try {
                i6 = s();
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "OPENSDK_WMW", "cwsc");
                i6 = 4;
            }
            if (this.f10104b == null) {
                this.f10104b = new ArrayList<>();
            }
            if (i6 == 0 || i6 == 1 || i6 == 4) {
                g();
            }
        } catch (Throwable unused) {
        }
    }

    public final void b(boolean z5) {
        if (z5) {
            w();
        } else {
            x();
        }
        boolean z6 = false;
        if (this.A) {
            this.A = false;
            z();
        }
        y();
        if (com.autonavi.aps.amapapi.utils.j.b() - f10097g > 20000) {
            this.f10104b.clear();
        }
        f10095e = com.autonavi.aps.amapapi.utils.j.b();
        if (this.f10104b.isEmpty()) {
            f10097g = com.autonavi.aps.amapapi.utils.j.b();
            List<l9> r5 = r();
            if (r5 != null) {
                this.f10104b.addAll(r5);
                z6 = true;
            }
        }
        d(z6);
    }

    public final ArrayList<l9> e() {
        if (this.f10104b == null) {
            return null;
        }
        ArrayList<l9> arrayList = new ArrayList<>();
        if (!this.f10104b.isEmpty()) {
            arrayList.addAll(this.f10104b);
        }
        return arrayList;
    }

    public final void i() {
        if (this.f10103a != null && com.autonavi.aps.amapapi.utils.j.b() - f10097g > 4900) {
            f10097g = com.autonavi.aps.amapapi.utils.j.b();
        }
    }

    public final void j() {
        if (this.f10103a == null) {
            return;
        }
        this.A = true;
    }

    public final boolean k() {
        return this.f10114q;
    }

    public final boolean l() {
        return this.f10115r;
    }

    public final boolean n() {
        return this.f10107j;
    }

    public final String o() {
        boolean z5;
        String str;
        StringBuilder sb = this.f10108k;
        if (sb == null) {
            this.f10108k = new StringBuilder(700);
        } else {
            sb.delete(0, sb.length());
        }
        this.f10107j = false;
        int size = this.f10104b.size();
        int i6 = 0;
        boolean z6 = false;
        boolean z7 = false;
        while (i6 < size) {
            String c6 = l9.c(this.f10104b.get(i6).f6745a);
            if (!this.f10110m && !"<unknown ssid>".equals(this.f10104b.get(i6).f6746b)) {
                z6 = true;
            }
            if (TextUtils.isEmpty(this.C) || !this.C.equals(c6)) {
                z5 = z7;
                str = "nb";
            } else {
                str = bi.Q;
                z5 = true;
            }
            this.f10108k.append(String.format(Locale.US, "#%s,%s", c6, str));
            i6++;
            z7 = z5;
        }
        if (this.f10104b.size() == 0) {
            z6 = true;
        }
        if (!this.f10110m && !z6) {
            this.f10107j = true;
        }
        if (!z7 && !TextUtils.isEmpty(this.C)) {
            StringBuilder sb2 = this.f10108k;
            sb2.append("#");
            sb2.append(this.C);
            this.f10108k.append(",access");
        }
        return this.f10108k.toString();
    }

    public final long q() {
        return this.f10118u;
    }

    public k(Context context, WifiManager wifiManager, Handler handler) {
        this.f10103a = wifiManager;
        this.f10106i = context;
        i iVar = new i(context, "wifiAgee", handler);
        this.f10117t = iVar;
        iVar.a();
    }

    private boolean B() {
        this.f10114q = v();
        A();
        if (!this.f10114q || !this.f10109l) {
            return false;
        }
        if (f10096f == 0) {
            return true;
        }
        if (com.autonavi.aps.amapapi.utils.j.b() - f10096f < 4900 || com.autonavi.aps.amapapi.utils.j.b() - f10097g < 1500) {
            return false;
        }
        com.autonavi.aps.amapapi.utils.j.b();
        return true;
    }

    public static String p() {
        return String.valueOf(com.autonavi.aps.amapapi.utils.j.b() - f10097g);
    }

    private boolean t() {
        long b6 = com.autonavi.aps.amapapi.utils.j.b() - f10094d;
        if (b6 < 4900) {
            return false;
        }
        if (u() && b6 < 9900) {
            return false;
        }
        if (f10101x > 1) {
            long j6 = this.D;
            if (j6 == WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
                if (com.autonavi.aps.amapapi.utils.a.o() != -1) {
                    j6 = com.autonavi.aps.amapapi.utils.a.o();
                } else {
                    j6 = 30000;
                }
            }
            if (Build.VERSION.SDK_INT >= 28 && b6 < j6) {
                return false;
            }
        }
        if (this.f10103a != null) {
            f10094d = com.autonavi.aps.amapapi.utils.j.b();
            int i6 = f10101x;
            if (i6 < 2) {
                f10101x = i6 + 1;
            }
            if (com.autonavi.aps.amapapi.utils.j.c(this.f10106i, "WYW5kcm9pZC5wZXJtaXNzaW9uLkNIQU5HRV9XSUZJX1NUQVRF")) {
                return this.f10103a.startScan();
            }
            com.autonavi.aps.amapapi.utils.b.a(new Exception("n_cws"), "OPENSDK_WMW", "wfs_n_cws");
        }
        return false;
    }

    private void w() {
        if (B()) {
            long b6 = com.autonavi.aps.amapapi.utils.j.b();
            if (b6 - f10095e >= 10000) {
                this.f10104b.clear();
                f10098h = f10097g;
            }
            x();
            if (b6 - f10095e >= 10000) {
                for (int i6 = 20; i6 > 0 && f10097g == f10098h; i6--) {
                    try {
                        Thread.sleep(150L);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    private void x() {
        if (B()) {
            try {
                if (t()) {
                    f10096f = com.autonavi.aps.amapapi.utils.j.b();
                }
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "WifiManager", "wifiScan");
            }
        }
    }

    public final void h() {
        f10102z = System.currentTimeMillis();
        com.autonavi.aps.amapapi.c cVar = this.E;
        if (cVar != null) {
            cVar.b();
        }
    }

    public final j m() {
        A();
        if (!l()) {
            return null;
        }
        if (this.B == null) {
            Objects.toString(this.B);
            this.B = new j(c());
        }
        return this.B;
    }

    public final boolean a(ConnectivityManager connectivityManager) {
        try {
            if (com.autonavi.aps.amapapi.utils.j.a(connectivityManager.getActiveNetworkInfo()) == 1) {
                if (a(m())) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "WifiManagerWrapper", "wifiAccess");
            return false;
        }
    }

    public final void c(boolean z5) {
        g();
        this.f10104b.clear();
        this.f10117t.a(z5);
    }

    public final void a(boolean z5) {
        Context context = this.f10106i;
        if (!com.autonavi.aps.amapapi.utils.a.n() || !this.f10111n || this.f10103a == null || context == null || !z5 || com.autonavi.aps.amapapi.utils.j.c() <= 17) {
            return;
        }
        ContentResolver contentResolver = context.getContentResolver();
        try {
            if (((Integer) com.autonavi.aps.amapapi.utils.f.a("android.provider.Settings$Global", "getInt", new Object[]{contentResolver, "wifi_scan_always_enabled"}, (Class<?>[]) new Class[]{ContentResolver.class, String.class})).intValue() == 0) {
                com.autonavi.aps.amapapi.utils.f.a("android.provider.Settings$Global", "putInt", new Object[]{contentResolver, "wifi_scan_always_enabled", 1}, (Class<?>[]) new Class[]{ContentResolver.class, String.class, Integer.TYPE});
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "WifiManagerWrapper", "enableWifiAlwaysScan");
        }
    }

    public final boolean a(j jVar) {
        if (jVar == null) {
            return false;
        }
        boolean d6 = jVar.d();
        if (!d6 && v()) {
            g();
        }
        return d6;
    }

    public final void a(boolean z5, boolean z6, boolean z7, long j6) {
        this.f10109l = z5;
        this.f10110m = z6;
        this.f10111n = z7;
        if (j6 < 10000) {
            this.D = 10000L;
        } else {
            this.D = j6;
        }
    }

    public final void a(com.autonavi.aps.amapapi.c cVar) {
        this.E = cVar;
    }

    private static boolean a(int i6) {
        int i7 = 20;
        try {
            i7 = WifiManager.calculateSignalLevel(i6, 20);
        } catch (ArithmeticException e6) {
            com.autonavi.aps.amapapi.utils.b.a(e6, "Aps", "wifiSigFine");
        }
        return i7 > 0;
    }
}
