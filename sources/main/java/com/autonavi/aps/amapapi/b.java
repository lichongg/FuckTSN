package com.autonavi.aps.amapapi;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import com.amap.api.col.p0003l.l9;
import com.amap.api.col.p0003l.q4;
import com.amap.api.col.p0003l.v5;
import com.amap.api.col.p0003l.z6;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.autonavi.aps.amapapi.restruct.e;
import com.autonavi.aps.amapapi.restruct.g;
import com.autonavi.aps.amapapi.restruct.k;
import com.autonavi.aps.amapapi.trans.f;
import com.autonavi.aps.amapapi.utils.h;
import com.autonavi.aps.amapapi.utils.j;
import com.autonavi.base.amap.mapcore.tools.GLMapStaticValue;
import com.stub.StubApp;
import com.tencent.connect.common.Constants;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"NewApi"})
/* loaded from: D:\Downloads\app\classes2.dex */
public final class b {
    static int A = -1;
    private static boolean K;
    boolean F;
    private Handler N;
    private g O;
    private String P;
    private c R;
    public static String[] D = {com.kuaishou.weapon.p0.g.f36048h, com.kuaishou.weapon.p0.g.f36047g};
    public static String E = "android.permission.ACCESS_BACKGROUND_LOCATION";
    private static volatile boolean Q = false;

    /* renamed from: a, reason: collision with root package name */
    Context f9917a = null;

    /* renamed from: b, reason: collision with root package name */
    ConnectivityManager f9918b = null;

    /* renamed from: c, reason: collision with root package name */
    k f9919c = null;

    /* renamed from: d, reason: collision with root package name */
    e f9920d = null;

    /* renamed from: e, reason: collision with root package name */
    com.autonavi.aps.amapapi.storage.a f9921e = null;

    /* renamed from: f, reason: collision with root package name */
    com.autonavi.aps.amapapi.trans.e f9922f = null;

    /* renamed from: g, reason: collision with root package name */
    ArrayList<l9> f9923g = new ArrayList<>();

    /* renamed from: h, reason: collision with root package name */
    a f9924h = null;

    /* renamed from: i, reason: collision with root package name */
    AMapLocationClientOption f9925i = new AMapLocationClientOption();

    /* renamed from: j, reason: collision with root package name */
    com.autonavi.aps.amapapi.model.a f9926j = null;

    /* renamed from: k, reason: collision with root package name */
    long f9927k = 0;
    private int I = 0;

    /* renamed from: l, reason: collision with root package name */
    f f9928l = null;

    /* renamed from: m, reason: collision with root package name */
    boolean f9929m = false;
    private String J = null;

    /* renamed from: n, reason: collision with root package name */
    com.autonavi.aps.amapapi.trans.c f9930n = null;

    /* renamed from: o, reason: collision with root package name */
    StringBuilder f9931o = new StringBuilder();

    /* renamed from: p, reason: collision with root package name */
    boolean f9932p = true;

    /* renamed from: q, reason: collision with root package name */
    boolean f9933q = true;

    /* renamed from: r, reason: collision with root package name */
    AMapLocationClientOption.GeoLanguage f9934r = AMapLocationClientOption.GeoLanguage.DEFAULT;

    /* renamed from: s, reason: collision with root package name */
    boolean f9935s = true;

    /* renamed from: t, reason: collision with root package name */
    boolean f9936t = false;
    private String L = null;

    /* renamed from: u, reason: collision with root package name */
    StringBuilder f9937u = null;

    /* renamed from: v, reason: collision with root package name */
    boolean f9938v = false;

    /* renamed from: w, reason: collision with root package name */
    public boolean f9939w = false;

    /* renamed from: x, reason: collision with root package name */
    int f9940x = 12;
    private boolean M = true;

    /* renamed from: y, reason: collision with root package name */
    com.autonavi.aps.amapapi.restruct.b f9941y = null;

    /* renamed from: z, reason: collision with root package name */
    boolean f9942z = false;
    com.autonavi.aps.amapapi.filters.a B = null;
    String C = null;
    IntentFilter G = null;
    LocationManager H = null;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            k kVar;
            k kVar2;
            if (context == null || intent == null) {
                return;
            }
            try {
                String action = intent.getAction();
                if (TextUtils.isEmpty(action)) {
                    return;
                }
                if (!action.equals("android.net.wifi.SCAN_RESULTS")) {
                    if (!action.equals("android.net.wifi.WIFI_STATE_CHANGED") || (kVar = b.this.f9919c) == null) {
                        return;
                    }
                    kVar.j();
                    return;
                }
                k kVar3 = b.this.f9919c;
                if (kVar3 != null) {
                    kVar3.i();
                }
                try {
                    if (intent.getExtras() == null || !intent.getExtras().getBoolean("resultsUpdated", true) || (kVar2 = b.this.f9919c) == null) {
                        return;
                    }
                    kVar2.h();
                } catch (Throwable unused) {
                }
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "Aps", "onReceive");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void l() {
        /*
            r4 = this;
            r0 = 0
            android.content.Context r1 = r4.f9917a     // Catch: java.lang.Throwable -> Ld
            if (r1 == 0) goto Lf
            com.autonavi.aps.amapapi.b$a r2 = r4.f9924h     // Catch: java.lang.Throwable -> Ld
            if (r2 == 0) goto Lf
            r1.unregisterReceiver(r2)     // Catch: java.lang.Throwable -> Ld
            goto Lf
        Ld:
            r1 = move-exception
            goto L12
        Lf:
            r4.f9924h = r0
            goto L1a
        L12:
            java.lang.String r2 = "Aps"
            java.lang.String r3 = "destroy"
            com.autonavi.aps.amapapi.utils.b.a(r1, r2, r3)     // Catch: java.lang.Throwable -> L2d
            goto Lf
        L1a:
            com.autonavi.aps.amapapi.restruct.e r0 = r4.f9920d
            if (r0 == 0) goto L23
            boolean r1 = r4.F
            r0.a(r1)
        L23:
            com.autonavi.aps.amapapi.restruct.k r0 = r4.f9919c
            if (r0 == 0) goto L2c
            boolean r1 = r4.F
            r0.c(r1)
        L2c:
            return
        L2d:
            r1 = move-exception
            r4.f9924h = r0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.b.l():void");
    }

    public final void a(Handler handler) {
        this.N = handler;
    }

    public final void b() {
        this.f9930n = com.autonavi.aps.amapapi.trans.c.a(this.f9917a);
        i();
        if (this.f9918b == null) {
            this.f9918b = (ConnectivityManager) j.a(this.f9917a, "connectivity");
        }
        if (this.f9928l == null) {
            this.f9928l = new f();
        }
    }

    public final void c() {
        if (this.f9941y == null) {
            this.f9941y = new com.autonavi.aps.amapapi.restruct.b(this.f9917a);
        }
        m();
        k kVar = this.f9919c;
        if (kVar != null) {
            kVar.b(false);
            this.f9923g = this.f9919c.e();
        }
        e eVar = this.f9920d;
        if (eVar != null) {
            eVar.a(false, q());
        }
        this.f9921e.a(this.f9917a);
        b(this.f9917a);
        this.f9939w = true;
    }

    public final void d() {
        if (this.f9931o.length() > 0) {
            StringBuilder sb = this.f9931o;
            sb.delete(0, sb.length());
        }
    }

    @SuppressLint({"NewApi"})
    public final void e() {
        this.C = null;
        this.f9938v = false;
        this.f9939w = false;
        com.autonavi.aps.amapapi.storage.a aVar = this.f9921e;
        if (aVar != null) {
            aVar.b(this.f9917a);
        }
        com.autonavi.aps.amapapi.filters.a aVar2 = this.B;
        if (aVar2 != null) {
            aVar2.a();
        }
        if (this.f9922f != null) {
            this.f9922f = null;
        }
        g gVar = this.O;
        if (gVar != null) {
            gVar.a(this.F);
        }
        l();
        ArrayList<l9> arrayList = this.f9923g;
        if (arrayList != null) {
            arrayList.clear();
        }
        com.autonavi.aps.amapapi.restruct.b bVar = this.f9941y;
        if (bVar != null) {
            bVar.f();
        }
        this.f9926j = null;
        this.f9917a = null;
        this.f9937u = null;
        this.H = null;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.autonavi.aps.amapapi.b$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f9943a;

        static {
            int[] iArr = new int[AMapLocationClientOption.GeoLanguage.values().length];
            f9943a = iArr;
            try {
                iArr[AMapLocationClientOption.GeoLanguage.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9943a[AMapLocationClientOption.GeoLanguage.ZH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9943a[AMapLocationClientOption.GeoLanguage.EN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private void i() {
        if (this.f9930n != null) {
            try {
                if (this.f9925i == null) {
                    this.f9925i = new AMapLocationClientOption();
                }
                this.f9930n.a(this.f9925i.getHttpTimeOut(), this.f9925i.getLocationProtocol().equals(AMapLocationClientOption.AMapLocationProtocol.HTTPS), j());
            } catch (Throwable unused) {
            }
        }
    }

    private int j() {
        int i6;
        if (this.f9925i.getGeoLanguage() == null || (i6 = AnonymousClass1.f9943a[this.f9925i.getGeoLanguage().ordinal()]) == 1) {
            return 0;
        }
        if (i6 != 2) {
            return i6 != 3 ? 0 : 2;
        }
        return 1;
    }

    private void k() {
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        AMapLocationClientOption.GeoLanguage geoLanguage = AMapLocationClientOption.GeoLanguage.DEFAULT;
        boolean z9 = true;
        try {
            geoLanguage = this.f9925i.getGeoLanguage();
            z5 = this.f9925i.isNeedAddress();
            try {
                z7 = this.f9925i.isOffset();
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            z5 = true;
        }
        try {
            z8 = this.f9925i.isLocationCacheEnable();
            try {
                this.f9936t = this.f9925i.isOnceLocationLatest();
                this.f9942z = this.f9925i.isSensorEnable();
                if (z7 != this.f9933q || z5 != this.f9932p || z8 != this.f9935s || geoLanguage != this.f9934r) {
                    s();
                }
            } catch (Throwable unused3) {
                z6 = z8;
                z9 = z7;
                boolean z10 = z6;
                z7 = z9;
                z8 = z10;
                this.f9933q = z7;
                this.f9932p = z5;
                this.f9935s = z8;
                this.f9934r = geoLanguage;
            }
        } catch (Throwable unused4) {
            z9 = z7;
            z6 = true;
            boolean z102 = z6;
            z7 = z9;
            z8 = z102;
            this.f9933q = z7;
            this.f9932p = z5;
            this.f9935s = z8;
            this.f9934r = geoLanguage;
        }
        this.f9933q = z7;
        this.f9932p = z5;
        this.f9935s = z8;
        this.f9934r = geoLanguage;
    }

    private void m() {
        try {
            if (this.f9924h == null) {
                this.f9924h = new a();
            }
            if (this.G == null) {
                IntentFilter intentFilter = new IntentFilter();
                this.G = intentFilter;
                intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
                this.G.addAction("android.net.wifi.SCAN_RESULTS");
            }
            this.f9917a.registerReceiver(this.f9924h, this.G);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "Aps", "initBroadcastListener");
        }
    }

    private byte[] n() throws Throwable {
        if (this.f9928l == null) {
            this.f9928l = new f();
        }
        if (this.f9925i == null) {
            this.f9925i = new AMapLocationClientOption();
        }
        if (this.f9920d != null && this.f9919c != null) {
            this.f9928l.a(this.f9917a, this.f9925i.isNeedAddress(), this.f9925i.isOffset(), this.f9920d, this.f9919c, this.f9918b, this.C, this.O);
        }
        return this.f9928l.a();
    }

    private boolean o() {
        return this.f9927k == 0 || j.b() - this.f9927k > 20000;
    }

    private void p() {
        k kVar = this.f9919c;
        if (kVar == null) {
            return;
        }
        kVar.a(this.f9929m);
    }

    private boolean q() {
        k kVar = this.f9919c;
        if (kVar != null) {
            this.f9923g = kVar.e();
        }
        ArrayList<l9> arrayList = this.f9923g;
        return arrayList == null || arrayList.size() <= 0;
    }

    private void r() {
        if (this.L != null) {
            this.L = null;
        }
        StringBuilder sb = this.f9937u;
        if (sb != null) {
            sb.delete(0, sb.length());
        }
    }

    private void s() {
        try {
            com.autonavi.aps.amapapi.storage.a aVar = this.f9921e;
            if (aVar != null) {
                aVar.a();
            }
            d(null);
            this.M = false;
            com.autonavi.aps.amapapi.filters.a aVar2 = this.B;
            if (aVar2 != null) {
                aVar2.a();
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "Aps", "cleanCache");
        }
    }

    public final void a(Context context) {
        try {
            if (this.f9917a != null) {
                return;
            }
            this.B = new com.autonavi.aps.amapapi.filters.a();
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f9917a = origApplicationContext;
            j.b(origApplicationContext);
            if (this.f9919c == null) {
                this.f9919c = new k(this.f9917a, (WifiManager) j.a(this.f9917a, "wifi"), this.N);
            }
            if (this.f9920d == null) {
                this.f9920d = new e(this.f9917a, this.N);
            }
            this.O = new g(context, this.N);
            if (this.f9921e == null) {
                this.f9921e = new com.autonavi.aps.amapapi.storage.a();
            }
            if (this.f9922f == null) {
                this.f9922f = new com.autonavi.aps.amapapi.trans.e();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            com.autonavi.aps.amapapi.utils.b.a(th, "Aps", "initBase");
        }
    }

    public final void f() {
        c cVar = this.R;
        if (cVar != null) {
            cVar.d();
        }
    }

    public final void g() {
        k kVar;
        try {
            if (this.f9917a == null) {
                return;
            }
            if (this.R == null) {
                this.R = new c(this.f9917a);
            }
            e eVar = this.f9920d;
            if (eVar == null || (kVar = this.f9919c) == null) {
                return;
            }
            this.R.a(eVar, kVar, this.N);
        } catch (Throwable th) {
            v5.p(th, CommonNetImpl.AS, "stc");
        }
    }

    public final void h() {
        c cVar = this.R;
        if (cVar != null) {
            cVar.a();
        }
    }

    public b(boolean z5) {
        this.F = z5;
    }

    private void d(com.autonavi.aps.amapapi.model.a aVar) {
        if (aVar != null) {
            this.f9926j = aVar;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x010a A[Catch: all -> 0x0085, TRY_LEAVE, TryCatch #1 {all -> 0x0085, blocks: (B:12:0x0052, B:14:0x007b, B:17:0x008a, B:19:0x0092, B:22:0x009a, B:23:0x009c, B:25:0x00a2, B:26:0x00ac, B:29:0x00b5, B:31:0x00c8, B:33:0x00cc, B:34:0x00d6, B:37:0x00ec, B:39:0x00f2, B:41:0x00f6, B:42:0x0106, B:44:0x010a, B:74:0x00fd, B:75:0x0103), top: B:11:0x0052 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0142 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x013b  */
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.autonavi.aps.amapapi.model.a b(boolean r12, com.autonavi.aps.amapapi.a r13) {
        /*
            Method dump skipped, instructions count: 782
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.b.b(boolean, com.autonavi.aps.amapapi.a):com.autonavi.aps.amapapi.model.a");
    }

    private String c(com.autonavi.aps.amapapi.a aVar) {
        e eVar = this.f9920d;
        String str = "";
        if (eVar != null && this.f9919c != null) {
            int h6 = eVar.h();
            com.autonavi.aps.amapapi.restruct.d e6 = this.f9920d.e();
            com.autonavi.aps.amapapi.restruct.d f6 = this.f9920d.f();
            ArrayList<l9> arrayList = this.f9923g;
            boolean z5 = arrayList == null || arrayList.isEmpty();
            if (e6 == null && f6 == null && z5) {
                if (this.f9918b == null) {
                    this.f9918b = (ConnectivityManager) j.a(this.f9917a, "connectivity");
                }
                if (j.c() >= 31) {
                    if (j.a(this.f9917a) && !this.f9919c.l()) {
                        this.f9940x = 18;
                        this.f9931o.append("飞行模式下关闭了WIFI开关，请关闭飞行模式或者打开WIFI开关#1802");
                        h.a((String) null, 2132);
                        aVar.f("#1802");
                        return "";
                    }
                } else if (j.a(this.f9917a) && !this.f9919c.k()) {
                    this.f9940x = 18;
                    this.f9931o.append("飞行模式下关闭了WIFI开关，请关闭飞行模式或者打开WIFI开关#1801");
                    h.a((String) null, 2132);
                    aVar.f("#1801");
                    return "";
                }
                if (j.c() >= 28) {
                    if (this.H == null) {
                        this.H = (LocationManager) StubApp.getOrigApplicationContext(this.f9917a.getApplicationContext()).getSystemService(SocializeConstants.KEY_LOCATION);
                    }
                    if (!((Boolean) com.autonavi.aps.amapapi.utils.f.a(this.H, "isLocationEnabled", new Object[0])).booleanValue()) {
                        this.f9940x = 12;
                        this.f9931o.append("定位服务没有开启，请在设置中打开定位服务开关#1206");
                        aVar.f("#1206");
                        h.a((String) null, 2121);
                        return "";
                    }
                }
                if (!j.e(this.f9917a)) {
                    this.f9940x = 12;
                    this.f9931o.append("定位权限被禁用,请授予应用定位权限#1201");
                    aVar.f("#1201");
                    h.a((String) null, 2121);
                    return "";
                }
                if (j.c() >= 24 && j.c() < 28 && Settings.Secure.getInt(this.f9917a.getContentResolver(), "location_mode", 0) == 0) {
                    this.f9940x = 12;
                    aVar.f("#1206");
                    this.f9931o.append("定位服务没有开启，请在设置中打开定位服务开关#1206");
                    h.a((String) null, 2121);
                    return "";
                }
                String k6 = this.f9920d.k();
                String d6 = this.f9919c.d();
                if (this.f9919c.a(this.f9918b) && d6 != null) {
                    this.f9940x = 12;
                    aVar.f("#1202");
                    this.f9931o.append("获取基站与获取WIFI的权限都被禁用，请在安全软件中打开应用的定位权限#1202");
                    h.a((String) null, 2121);
                    return "";
                }
                if (k6 != null) {
                    this.f9940x = 12;
                    if (!this.f9919c.k()) {
                        aVar.f("#1204");
                        this.f9931o.append("WIFI开关关闭，并且获取基站权限被禁用，请在安全软件中打开应用的定位权限或者打开WIFI开关#1204");
                    } else {
                        aVar.f("#1205");
                        this.f9931o.append("获取的WIFI列表为空，并且获取基站权限被禁用，请在安全软件中打开应用的定位权限#1205");
                    }
                    h.a((String) null, 2121);
                    return "";
                }
                if (!this.f9919c.k() && !this.f9920d.n()) {
                    this.f9940x = 19;
                    aVar.f("#1901");
                    this.f9931o.append("没有检查到SIM卡，并且WIFI开关关闭，请打开WIFI开关或者插入SIM卡#1901");
                    h.a((String) null, 2133);
                    return "";
                }
                if (!this.f9919c.k()) {
                    aVar.f("#1301");
                    this.f9931o.append("获取到的基站为空，并且关闭了WIFI开关，请您打开WIFI开关再发起定位#1301");
                } else {
                    aVar.f("#1302");
                    if (this.f9919c.c() != null) {
                        this.f9931o.append("获取到的基站和WIFI信息均为空，请检查是否授予APP定位权限");
                        if (!j.f(this.f9917a)) {
                            this.f9931o.append("或后台运行没有后台定位权限");
                        }
                        this.f9931o.append("#1302");
                    } else {
                        this.f9931o.append("获取到的基站和WIFI信息均为空，请移动到有WIFI的区域，若确定当前区域有WIFI，请检查是否授予APP定位权限");
                        if (!j.f(this.f9917a)) {
                            this.f9931o.append("或后台运行没有后台定位权限");
                        }
                        this.f9931o.append("#1302");
                    }
                }
                this.f9940x = 13;
                h.a((String) null, 2131);
                return "";
            }
            boolean a6 = this.f9919c.a(this.f9919c.m());
            String str2 = "cgiwifi";
            if (h6 == 0) {
                boolean z6 = !this.f9923g.isEmpty() || a6;
                boolean z7 = f6 != null;
                if (!z7) {
                    if (a6 && this.f9923g.isEmpty()) {
                        this.f9940x = 2;
                        aVar.f("#0201");
                        this.f9931o.append("当前基站为伪基站，并且WIFI权限被禁用，请在安全软件中打开应用的定位权限#0201");
                        h.a((String) null, 2021);
                        return "";
                    }
                    if (this.f9923g.size() == 1) {
                        this.f9940x = 2;
                        if (!a6) {
                            aVar.f("#0202");
                            this.f9931o.append("当前基站为伪基站，并且搜到的WIFI数量不足，请移动到WIFI比较丰富的区域#0202");
                            h.a((String) null, GLMapStaticValue.MAP_PARAMETERNAME_CLEAR_INDOORBUILDING_LAST);
                            return "";
                        }
                        if (this.f9923g.get(0).f6752h) {
                            aVar.f("#0202");
                            this.f9931o.append("当前基站为伪基站，并且搜到的WIFI数量不足，请移动到WIFI比较丰富的区域#0202");
                            h.a((String) null, 2021);
                            return "";
                        }
                    }
                }
                String format = String.format(Locale.US, "#%s#", "network");
                if (z7) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(f6.b());
                    if (this.f9923g.isEmpty() && !a6) {
                        str2 = "cgi";
                    }
                    sb.append("network");
                    sb.append("#");
                    sb.append(str2);
                    str = sb.toString();
                } else if (z6) {
                    str = format + "wifi";
                } else {
                    this.f9940x = 2;
                    if (!this.f9919c.k()) {
                        aVar.f("#0203");
                        this.f9931o.append("当前基站为伪基站,并且关闭了WIFI开关，请在设置中打开WIFI开关#0203");
                    } else {
                        aVar.f("#0204");
                        this.f9931o.append("当前基站为伪基站,并且没有搜索到WIFI，请移动到WIFI比较丰富的区域#0204");
                    }
                    h.a((String) null, GLMapStaticValue.MAP_PARAMETERNAME_CLEAR_INDOORBUILDING_LAST);
                }
            } else if (h6 != 1) {
                if (h6 != 2) {
                    this.f9940x = 11;
                    h.a((String) null, 2111);
                    aVar.f("#1101");
                    this.f9931o.append("get cgi failure#1101");
                } else if (e6 != null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(e6.f10029a);
                    sb2.append("#");
                    sb2.append(e6.f10030b);
                    sb2.append("#");
                    sb2.append(e6.f10036h);
                    sb2.append("#");
                    sb2.append(e6.f10037i);
                    sb2.append("#");
                    sb2.append(e6.f10038j);
                    sb2.append("#");
                    sb2.append("network");
                    sb2.append("#");
                    if (this.f9923g.isEmpty() && !a6) {
                        str2 = "cgi";
                    }
                    sb2.append(str2);
                    str = sb2.toString();
                }
            } else if (e6 != null) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(e6.f10029a);
                sb3.append("#");
                sb3.append(e6.f10030b);
                sb3.append("#");
                sb3.append(e6.f10031c);
                sb3.append("#");
                sb3.append(e6.f10032d);
                sb3.append("#");
                sb3.append("network");
                sb3.append("#");
                if (this.f9923g.isEmpty() && !a6) {
                    str2 = "cgi";
                }
                sb3.append(str2);
                str = sb3.toString();
            }
            if (!TextUtils.isEmpty(str)) {
                if (!str.startsWith("#")) {
                    str = "#" + str;
                }
                return j.e() + str;
            }
        }
        return str;
    }

    public final void a() {
        e eVar = this.f9920d;
        if (eVar != null) {
            eVar.b();
        }
    }

    public final void a(AMapLocationClientOption aMapLocationClientOption) {
        this.f9925i = aMapLocationClientOption;
        if (aMapLocationClientOption == null) {
            this.f9925i = new AMapLocationClientOption();
        }
        k kVar = this.f9919c;
        if (kVar != null) {
            this.f9925i.isWifiActiveScan();
            kVar.a(this.f9925i.isWifiScan(), this.f9925i.isMockEnable(), AMapLocationClientOption.isOpenAlwaysScanWifi(), aMapLocationClientOption.getScanWifiInterval());
        }
        i();
        com.autonavi.aps.amapapi.storage.a aVar = this.f9921e;
        if (aVar != null) {
            aVar.a(this.f9925i);
        }
        com.autonavi.aps.amapapi.trans.e eVar = this.f9922f;
        if (eVar != null) {
            eVar.a(this.f9925i);
        }
        e eVar2 = this.f9920d;
        if (eVar2 != null) {
            eVar2.c(this.f9925i.isNoLocReqCgiEnable());
        }
        k();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:53|(1:101)(1:57)|58|(1:60)(2:87|(3:89|(1:91)|92)(4:93|(1:97)|98|(8:100|62|63|(2:66|(1:68)(2:69|(1:71)(2:72|(1:74)(1:75))))|76|(2:78|(1:83)(1:82))|84|85)))|61|62|63|(2:66|(0)(0))|76|(0)|84|85) */
    /* JADX WARN: Can't wrap try/catch for region: R(13:20|(2:22|(1:24)(1:25))|26|(2:27|28)|(8:33|34|(1:36)|38|39|(1:41)|43|(2:45|46)(2:47|(12:53|(1:101)(1:57)|58|(1:60)(2:87|(3:89|(1:91)|92)(4:93|(1:97)|98|(8:100|62|63|(2:66|(1:68)(2:69|(1:71)(2:72|(1:74)(1:75))))|76|(2:78|(1:83)(1:82))|84|85)))|61|62|63|(2:66|(0)(0))|76|(0)|84|85)(2:51|52)))|104|34|(0)|38|39|(0)|43|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x00a4, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x00a5, code lost:
    
        com.autonavi.aps.amapapi.utils.b.a(r0, "Aps", "getLocation getCgiListParam");
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0087 A[Catch: all -> 0x0080, TRY_LEAVE, TryCatch #1 {all -> 0x0080, blocks: (B:28:0x006d, B:30:0x0075, B:34:0x0083, B:36:0x0087), top: B:27:0x006d }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009c A[Catch: all -> 0x00a4, TRY_LEAVE, TryCatch #2 {all -> 0x00a4, blocks: (B:39:0x0098, B:41:0x009c), top: B:38:0x0098 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x017c A[Catch: all -> 0x0180, TryCatch #0 {all -> 0x0180, blocks: (B:63:0x016c, B:66:0x0172, B:68:0x017c, B:71:0x0188, B:74:0x0192, B:75:0x0197), top: B:62:0x016c }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.autonavi.aps.amapapi.model.a a(com.autonavi.aps.amapapi.a r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 489
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.b.a(com.autonavi.aps.amapapi.a):com.autonavi.aps.amapapi.model.a");
    }

    private void b(Context context) {
        try {
            if (context.checkCallingOrSelfPermission(q4.u("EYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFQ1VSRV9TRVRUSU5HUw==")) == 0) {
                this.f9929m = true;
            }
        } catch (Throwable unused) {
        }
    }

    public final void b(com.autonavi.aps.amapapi.a aVar) {
        try {
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "Aps", "initFirstLocateParam");
        }
        if (this.f9938v) {
            return;
        }
        r();
        if (this.f9936t) {
            m();
        }
        k kVar = this.f9919c;
        if (kVar != null) {
            kVar.b(this.f9936t);
            this.f9923g = this.f9919c.e();
        }
        e eVar = this.f9920d;
        if (eVar != null) {
            eVar.a(true, q());
        }
        String c6 = c(aVar);
        this.L = c6;
        if (!TextUtils.isEmpty(c6)) {
            this.f9937u = a(this.f9937u);
        }
        this.f9938v = true;
    }

    public final com.autonavi.aps.amapapi.model.a a(com.autonavi.aps.amapapi.model.a aVar) {
        this.B.a(this.f9935s);
        return this.B.a(aVar);
    }

    public final void a(boolean z5) {
        e eVar = this.f9920d;
        if (eVar != null) {
            eVar.b(z5);
        }
    }

    private boolean a(long j6) {
        if (!this.M) {
            this.M = true;
            return false;
        }
        if (j.b() - j6 < 800) {
            if ((j.a(this.f9926j) ? j.a() - this.f9926j.getTime() : 0L) <= 10000) {
                return true;
            }
        }
        return false;
    }

    private StringBuilder a(StringBuilder sb) {
        if (sb == null) {
            sb = new StringBuilder(700);
        } else {
            sb.delete(0, sb.length());
        }
        e eVar = this.f9920d;
        if (eVar != null && this.f9919c != null) {
            sb.append(eVar.m());
            sb.append(this.f9919c.o());
        }
        return sb;
    }

    public final com.autonavi.aps.amapapi.model.a b(boolean z5) {
        k kVar = this.f9919c;
        if (kVar != null && kVar.n()) {
            return a(15, "networkLocation has been mocked!#1502");
        }
        if (TextUtils.isEmpty(this.L)) {
            return a(this.f9940x, this.f9931o.toString());
        }
        com.autonavi.aps.amapapi.model.a a6 = this.f9921e.a(this.f9917a, this.L, this.f9937u, true, z5);
        if (j.a(a6)) {
            d(a6);
        }
        return a6;
    }

    private com.autonavi.aps.amapapi.model.a a(com.autonavi.aps.amapapi.model.a aVar, z6 z6Var, com.autonavi.aps.amapapi.a aVar2) {
        if (z6Var != null) {
            try {
                byte[] bArr = z6Var.f7800a;
                if (bArr != null && bArr.length != 0) {
                    com.autonavi.aps.amapapi.trans.e eVar = new com.autonavi.aps.amapapi.trans.e();
                    String str = new String(z6Var.f7800a, "UTF-8");
                    if (str.contains("\"status\":\"0\"")) {
                        com.autonavi.aps.amapapi.model.a a6 = eVar.a(str, this.f9917a, z6Var, aVar2);
                        a6.h(this.f9937u.toString());
                        return a6;
                    }
                    if (!str.contains("</body></html>")) {
                        return null;
                    }
                    aVar.setErrorCode(5);
                    k kVar = this.f9919c;
                    if (kVar != null && kVar.a(this.f9918b)) {
                        aVar2.f("#0501");
                        this.f9931o.append("您连接的是一个需要登录的网络，请确认已经登入网络#0501");
                        h.a((String) null, 2051);
                    } else {
                        aVar2.f("#0502");
                        this.f9931o.append("请求可能被劫持了#0502");
                        h.a((String) null, 2052);
                    }
                    aVar.setLocationDetail(this.f9931o.toString());
                    return aVar;
                }
            } catch (Throwable th) {
                aVar.setErrorCode(4);
                com.autonavi.aps.amapapi.utils.b.a(th, "Aps", "checkResponseEntity");
                aVar2.f("#0403");
                this.f9931o.append("check response exception ex is" + th.getMessage() + "#0403");
                aVar.setLocationDetail(this.f9931o.toString());
                return aVar;
            }
        }
        aVar.setErrorCode(4);
        this.f9931o.append("网络异常,请求异常#0403");
        aVar2.f("#0403");
        aVar.h(this.f9937u.toString());
        aVar.setLocationDetail(this.f9931o.toString());
        if (z6Var != null) {
            h.a(z6Var.f7803d, 2041);
        }
        return aVar;
    }

    public final void b(com.autonavi.aps.amapapi.model.a aVar) {
        if (j.a(aVar)) {
            this.f9921e.a(this.L, this.f9937u, aVar, this.f9917a, true);
        }
    }

    public final com.autonavi.aps.amapapi.model.a a(boolean z5, com.autonavi.aps.amapapi.a aVar) {
        if (z5) {
            aVar.e("statics");
        } else {
            aVar.e("first");
        }
        if (this.f9917a == null) {
            aVar.f("#0101");
            this.f9931o.append("context is null#0101");
            h.a((String) null, GLMapStaticValue.MAP_PARAMETERNAME_SATELLITE);
            return a(1, this.f9931o.toString());
        }
        k kVar = this.f9919c;
        if (kVar != null && kVar.n()) {
            aVar.f("#1502");
            return a(15, "networkLocation has been mocked!#1502");
        }
        b();
        if (TextUtils.isEmpty(this.L)) {
            return a(this.f9940x, this.f9931o.toString());
        }
        com.autonavi.aps.amapapi.model.a b6 = b(z5, aVar);
        if (j.a(b6) && !Q) {
            this.f9921e.a(this.f9937u.toString());
            e eVar = this.f9920d;
            if (eVar != null) {
                this.f9921e.a(eVar.e());
            }
            d(b6);
        }
        Q = true;
        return b6;
    }

    private static void c(com.autonavi.aps.amapapi.model.a aVar) {
        if (aVar.getErrorCode() == 0 && aVar.getLocationType() == 0) {
            if (!"-5".equals(aVar.d()) && !"1".equals(aVar.d()) && !"2".equals(aVar.d()) && !Constants.VIA_REPORT_TYPE_MAKE_FRIEND.equals(aVar.d()) && !Constants.VIA_REPORT_TYPE_CHAT_AIO.equals(aVar.d()) && !"-1".equals(aVar.d())) {
                aVar.setLocationType(6);
            } else {
                aVar.setLocationType(5);
            }
        }
    }

    public final com.autonavi.aps.amapapi.model.a a(double d6, double d7) {
        try {
            String a6 = this.f9930n.a(this.f9917a, d6, d7);
            if (!a6.contains("\"status\":\"1\"")) {
                return null;
            }
            com.autonavi.aps.amapapi.model.a a7 = this.f9922f.a(a6);
            a7.setLatitude(d6);
            a7.setLongitude(d7);
            return a7;
        } catch (Throwable unused) {
            return null;
        }
    }

    public final void a(AMapLocation aMapLocation) {
        if (aMapLocation.getErrorCode() != 0) {
            return;
        }
        com.autonavi.aps.amapapi.restruct.f fVar = new com.autonavi.aps.amapapi.restruct.f();
        fVar.f10074a = aMapLocation.getLocationType();
        fVar.f10077d = aMapLocation.getTime();
        fVar.f10078e = (int) aMapLocation.getAccuracy();
        fVar.f10075b = aMapLocation.getLatitude();
        fVar.f10076c = aMapLocation.getLongitude();
        if (aMapLocation.getLocationType() == 1) {
            this.O.a(fVar);
        }
    }

    public final void a(com.autonavi.aps.amapapi.model.a aVar, int i6) {
        if (aVar != null && aVar.getErrorCode() == 0) {
            com.autonavi.aps.amapapi.restruct.f fVar = new com.autonavi.aps.amapapi.restruct.f();
            fVar.f10077d = aVar.getTime();
            fVar.f10078e = (int) aVar.getAccuracy();
            fVar.f10075b = aVar.getLatitude();
            fVar.f10076c = aVar.getLongitude();
            fVar.f10074a = i6;
            fVar.f10080g = Integer.parseInt(aVar.d());
            fVar.f10081h = aVar.l();
            this.O.b(fVar);
        }
    }

    private static com.autonavi.aps.amapapi.model.a a(int i6, String str) {
        com.autonavi.aps.amapapi.model.a aVar = new com.autonavi.aps.amapapi.model.a("");
        aVar.setErrorCode(i6);
        aVar.setLocationDetail(str);
        if (i6 == 15) {
            h.a((String) null, 2151);
        }
        return aVar;
    }
}
