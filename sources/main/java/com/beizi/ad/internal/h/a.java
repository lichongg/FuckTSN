package com.beizi.ad.internal.h;

import android.content.Context;
import android.os.Build;
import android.system.Os;
import android.system.StructStat;
import android.system.StructTimespec;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.beizi.ad.model.f;
import com.beizi.fusion.model.DevInfo;
import com.beizi.fusion.model.RequestInfo;
import com.beizi.fusion.tool.ac;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class a {
    private static a J = null;

    /* renamed from: a, reason: collision with root package name */
    public static String f12019a = "SDK_UID_KEY";

    /* renamed from: b, reason: collision with root package name */
    public static String f12020b = "SDK_UID_KEY_NEW";
    private String A;
    private String B;
    private String C;
    private long D;
    private long E;
    private String F;
    private Context G;
    private String H;
    private String I;
    private RequestInfo K;
    private DevInfo L;

    /* renamed from: e, reason: collision with root package name */
    private String f12023e;

    /* renamed from: i, reason: collision with root package name */
    private String f12027i;

    /* renamed from: j, reason: collision with root package name */
    private String f12028j;

    /* renamed from: k, reason: collision with root package name */
    private String f12029k;

    /* renamed from: l, reason: collision with root package name */
    private String f12030l;

    /* renamed from: m, reason: collision with root package name */
    private String f12031m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f12032n;

    /* renamed from: o, reason: collision with root package name */
    private String f12033o;

    /* renamed from: p, reason: collision with root package name */
    private String f12034p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f12035q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f12036r;

    /* renamed from: s, reason: collision with root package name */
    private String f12037s;

    /* renamed from: t, reason: collision with root package name */
    private String f12038t;

    /* renamed from: u, reason: collision with root package name */
    private String f12039u;

    /* renamed from: v, reason: collision with root package name */
    private String f12040v;

    /* renamed from: w, reason: collision with root package name */
    private String f12041w;

    /* renamed from: x, reason: collision with root package name */
    private String f12042x;

    /* renamed from: y, reason: collision with root package name */
    private String f12043y;

    /* renamed from: z, reason: collision with root package name */
    private String f12044z;

    /* renamed from: d, reason: collision with root package name */
    private String f12022d = null;

    /* renamed from: c, reason: collision with root package name */
    public boolean f12021c = false;

    /* renamed from: f, reason: collision with root package name */
    private f.b f12024f = f.b.DEVICE_OTHER;

    /* renamed from: g, reason: collision with root package name */
    private String f12025g = null;

    /* renamed from: h, reason: collision with root package name */
    private String f12026h = null;

    private boolean G() {
        if (Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
            return true;
        }
        String str = Build.BRAND;
        return str.equalsIgnoreCase("HUAWEI") || str.equalsIgnoreCase("HONOR");
    }

    private String H() {
        StructTimespec structTimespec;
        long j6;
        long j7;
        try {
            int i6 = Build.VERSION.SDK_INT;
            StructStat stat = Os.stat("/data/data");
            if (stat == null) {
                return "";
            }
            if (i6 < 27) {
                return stat.st_atime + ".0";
            }
            structTimespec = stat.st_atim;
            StringBuilder sb = new StringBuilder();
            j6 = structTimespec.tv_sec;
            sb.append(j6);
            sb.append(".");
            j7 = structTimespec.tv_nsec;
            sb.append(j7);
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    private boolean I() {
        return Build.MANUFACTURER.equalsIgnoreCase("VIVO") || Build.BRAND.equalsIgnoreCase("VIVO");
    }

    private boolean J() {
        if (Build.MANUFACTURER.equalsIgnoreCase("OPPO")) {
            return true;
        }
        String str = Build.BRAND;
        return str.equalsIgnoreCase("OPPO") || str.equalsIgnoreCase("REALME");
    }

    private boolean K() {
        if (Build.MANUFACTURER.equalsIgnoreCase("XIAOMI")) {
            return true;
        }
        String str = Build.BRAND;
        return str.equalsIgnoreCase("XIAOMI") || str.equalsIgnoreCase("REDMI");
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            try {
                if (J == null) {
                    synchronized (a.class) {
                        try {
                            if (J == null) {
                                J = new a();
                            }
                        } finally {
                        }
                    }
                }
                aVar = J;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    public long A() {
        RequestInfo requestInfo;
        if (this.D == 0 && (requestInfo = this.K) != null) {
            try {
                this.D = Long.parseLong(requestInfo.getInstallTime());
            } catch (NumberFormatException e6) {
                e6.printStackTrace();
            }
        }
        return this.D;
    }

    public long B() {
        RequestInfo requestInfo;
        if (this.E == 0 && (requestInfo = this.K) != null) {
            try {
                this.E = Long.parseLong(requestInfo.getUpdateTime());
            } catch (NumberFormatException e6) {
                e6.printStackTrace();
            }
        }
        return this.E;
    }

    public String C() {
        RequestInfo requestInfo;
        if (TextUtils.isEmpty(this.F) && (requestInfo = this.K) != null) {
            this.F = requestInfo.getPackageName();
        }
        return this.F;
    }

    public String D() {
        if (TextUtils.isEmpty(this.H)) {
            try {
                if (com.beizi.fusion.c.b.a().o()) {
                    this.H = com.beizi.ad.lance.a.q.k(com.beizi.fusion.c.b.a().e());
                } else {
                    this.H = com.beizi.fusion.c.b.a().p();
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
        return this.H;
    }

    public String E() {
        try {
            if (TextUtils.isEmpty(this.I)) {
                if (I()) {
                    this.I = com.beizi.ad.lance.a.q.b(com.beizi.ad.internal.h.a().f12002j, "com.bbk.appstore");
                } else if (J()) {
                    this.I = com.beizi.ad.lance.a.q.b(com.beizi.ad.internal.h.a().f12002j, "com.heytap.market");
                } else if (K()) {
                    this.I = com.beizi.ad.lance.a.q.b(com.beizi.ad.internal.h.a().f12002j, "com.xiaomi.market");
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.I;
    }

    public String b() {
        if (TextUtils.isEmpty(this.f12028j)) {
            this.f12028j = H();
        }
        return this.f12028j;
    }

    public String c() {
        if (TextUtils.isEmpty(this.f12034p)) {
            DevInfo devInfo = this.L;
            if (devInfo != null) {
                this.f12034p = devInfo.getRomVersion();
            } else {
                try {
                    ac a6 = ac.a();
                    a6.b();
                    this.f12034p = a6.c();
                } catch (Throwable unused) {
                }
            }
        }
        return this.f12034p;
    }

    public String d() {
        if (TextUtils.isEmpty(this.f12022d)) {
            DevInfo devInfo = this.L;
            if (devInfo != null) {
                this.f12022d = devInfo.getSdkUID();
            } else {
                this.f12022d = (String) m.b(com.beizi.ad.internal.h.a().f12002j, f12020b, "");
            }
        }
        return this.f12022d;
    }

    public String e() {
        if (TextUtils.isEmpty(this.f12027i)) {
            DevInfo devInfo = this.L;
            if (devInfo != null) {
                this.f12027i = devInfo.getDensity();
            } else {
                try {
                    if (TextUtils.isEmpty(this.f12027i)) {
                        this.f12027i = com.beizi.ad.internal.h.a().f12002j.getResources().getDisplayMetrics().density + "";
                    }
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            }
        }
        return this.f12027i;
    }

    public String f() {
        if (TextUtils.isEmpty(this.f12023e)) {
            DevInfo devInfo = this.L;
            if (devInfo != null) {
                this.f12023e = devInfo.getRoot();
            } else {
                this.f12023e = com.beizi.ad.lance.a.q.a();
            }
        }
        return this.f12023e;
    }

    public String g() {
        if (TextUtils.isEmpty(this.f12025g)) {
            DevInfo devInfo = this.L;
            if (devInfo != null) {
                this.f12025g = devInfo.getResolution();
            } else {
                F();
            }
        }
        return this.f12025g;
    }

    public String h() {
        if (TextUtils.isEmpty(this.f12026h)) {
            DevInfo devInfo = this.L;
            if (devInfo != null) {
                this.f12026h = devInfo.getScreenSize();
            } else {
                F();
            }
        }
        return this.f12026h;
    }

    public String i() {
        if (TextUtils.isEmpty(this.f12029k)) {
            com.beizi.ad.lance.a.q.j(com.beizi.ad.internal.h.a().f12002j);
        }
        return this.f12029k;
    }

    public String j() {
        if (TextUtils.isEmpty(this.f12030l)) {
            this.f12030l = com.beizi.ad.lance.a.q.b();
        }
        return this.f12030l;
    }

    public boolean m() {
        if (!this.f12032n) {
            this.f12032n = com.beizi.ad.lance.a.h.a(com.beizi.ad.internal.h.a().f12002j, "com.tencent.mm");
        }
        return this.f12032n;
    }

    public f.b n() {
        f.b bVar = this.f12024f;
        f.b bVar2 = f.b.DEVICE_OTHER;
        if (bVar == bVar2) {
            DevInfo devInfo = this.L;
            if (devInfo != null) {
                String devType = devInfo.getDevType();
                if ("1".equals(devType)) {
                    this.f12024f = f.b.DEVICE_PHONE;
                } else if ("2".equals(devType)) {
                    this.f12024f = f.b.DEVICE_FLAT;
                }
            } else if (bVar == bVar2) {
                try {
                    try {
                        if (((TelephonyManager) com.beizi.ad.internal.h.a().f12002j.getSystemService("phone")).getPhoneType() != 0) {
                            this.f12024f = f.b.DEVICE_PHONE;
                        } else {
                            this.f12024f = f.b.DEVICE_FLAT;
                        }
                    } catch (Throwable unused) {
                        int i6 = com.beizi.ad.internal.h.a().f12002j.getResources().getConfiguration().screenLayout & 15;
                        if (i6 == 4 || i6 == 3) {
                            this.f12024f = f.b.DEVICE_FLAT;
                        } else {
                            this.f12024f = f.b.DEVICE_PHONE;
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        return this.f12024f;
    }

    public String o() {
        if (this.f12035q) {
            return this.f12037s;
        }
        this.f12035q = true;
        String d6 = com.beizi.ad.lance.a.r.d();
        this.f12037s = d6;
        return d6;
    }

    public String p() {
        if (this.f12036r) {
            return this.f12038t;
        }
        this.f12036r = true;
        String c6 = com.beizi.ad.lance.a.r.c();
        this.f12038t = c6;
        return c6;
    }

    public String r() {
        if (TextUtils.isEmpty(this.f12039u)) {
            this.f12039u = Build.VERSION.SDK_INT + " (" + Build.VERSION.RELEASE + ")";
        }
        return this.f12039u;
    }

    public String s() {
        if (TextUtils.isEmpty(this.f12040v)) {
            DevInfo devInfo = this.L;
            if (devInfo != null) {
                this.f12040v = devInfo.getBrand();
            } else {
                this.f12040v = Build.BRAND;
            }
        }
        return this.f12040v;
    }

    public String t() {
        if (TextUtils.isEmpty(this.f12041w)) {
            DevInfo devInfo = this.L;
            if (devInfo != null) {
                this.f12041w = devInfo.getModel();
            } else {
                this.f12041w = Build.MODEL;
            }
        }
        return this.f12041w;
    }

    public String u() {
        if (TextUtils.isEmpty(this.f12042x)) {
            this.f12042x = com.beizi.fusion.tool.p.d();
        }
        return this.f12042x;
    }

    public String v() {
        if (TextUtils.isEmpty(this.f12043y)) {
            DevInfo devInfo = this.L;
            if (devInfo != null) {
                this.f12043y = devInfo.getLanguage();
            } else {
                this.f12043y = Locale.getDefault().getLanguage();
            }
        }
        return this.f12043y;
    }

    public String w() {
        if (TextUtils.isEmpty(this.f12044z)) {
            this.f12044z = com.beizi.ad.lance.a.n.a(this.G);
        }
        return this.f12044z;
    }

    public String x() {
        if (TextUtils.isEmpty(this.A)) {
            this.A = com.beizi.ad.lance.a.n.b(this.G);
        }
        return this.A;
    }

    public String y() {
        RequestInfo requestInfo;
        if (TextUtils.isEmpty(this.B) && (requestInfo = this.K) != null) {
            this.B = requestInfo.getAppVersion();
        }
        return this.B;
    }

    public String z() {
        RequestInfo requestInfo;
        if (TextUtils.isEmpty(this.C) && (requestInfo = this.K) != null) {
            this.C = requestInfo.getSdkVersion();
        }
        return this.C;
    }

    private a() {
        Context e6 = com.beizi.fusion.c.b.a().e();
        this.G = e6;
        if (e6 != null) {
            RequestInfo requestInfo = RequestInfo.getInstance(e6);
            this.K = requestInfo;
            if (requestInfo == null) {
                return;
            }
            if (!requestInfo.isInit) {
                requestInfo.init();
            }
            this.L = this.K.getDevInfo();
        }
    }

    private void F() {
        try {
            WindowManager windowManager = (WindowManager) com.beizi.ad.internal.h.a().f12002j.getSystemService("window");
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            this.f12025g = displayMetrics.widthPixels + "_" + displayMetrics.heightPixels;
            float f6 = ((float) displayMetrics.heightPixels) / displayMetrics.ydpi;
            float f7 = ((float) displayMetrics.widthPixels) / displayMetrics.xdpi;
            double sqrt = Math.sqrt((double) ((f7 * f7) + (f6 * f6)));
            this.f12026h = String.format("%.2f", Double.valueOf(Math.round(sqrt * r2) / Math.pow(10.0d, 2.0d)));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public String k() {
        if (G() && TextUtils.isEmpty(this.f12031m)) {
            this.f12031m = com.beizi.ad.lance.a.q.b(com.beizi.ad.internal.h.a().f12002j);
        }
        return this.f12031m;
    }

    public String l() {
        if (G() && TextUtils.isEmpty(this.f12033o)) {
            this.f12033o = com.beizi.ad.lance.a.q.a(com.beizi.ad.internal.h.a().f12002j, "com.huawei.hwid");
        }
        return this.f12033o;
    }

    public String q() {
        return com.beizi.ad.lance.a.r.b();
    }
}
