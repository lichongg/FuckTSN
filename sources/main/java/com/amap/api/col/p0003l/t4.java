package com.amap.api.col.p0003l;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.DPoint;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.autonavi.aps.amapapi.utils.b;
import com.autonavi.aps.amapapi.utils.c;
import com.autonavi.aps.amapapi.utils.d;
import com.autonavi.aps.amapapi.utils.e;
import com.autonavi.aps.amapapi.utils.f;
import com.autonavi.aps.amapapi.utils.h;
import com.autonavi.aps.amapapi.utils.i;
import com.autonavi.aps.amapapi.utils.j;
import com.stub.StubApp;
import com.umeng.socialize.common.SocializeConstants;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class t4 {

    /* renamed from: r, reason: collision with root package name */
    private static String f7263r = "CoarseLocation";

    /* renamed from: s, reason: collision with root package name */
    private static long f7264s;

    /* renamed from: t, reason: collision with root package name */
    private static boolean f7265t;

    /* renamed from: u, reason: collision with root package name */
    private static boolean f7266u;

    /* renamed from: v, reason: collision with root package name */
    private static boolean f7267v;

    /* renamed from: w, reason: collision with root package name */
    private static boolean f7268w;

    /* renamed from: x, reason: collision with root package name */
    public static volatile AMapLocation f7269x;

    /* renamed from: d, reason: collision with root package name */
    private com.autonavi.aps.amapapi.filters.a f7273d;

    /* renamed from: h, reason: collision with root package name */
    private Handler f7277h;

    /* renamed from: i, reason: collision with root package name */
    private Context f7278i;

    /* renamed from: l, reason: collision with root package name */
    private LocationManager f7281l;

    /* renamed from: m, reason: collision with root package name */
    private AMapLocationClientOption f7282m;

    /* renamed from: a, reason: collision with root package name */
    private long f7270a = 0;

    /* renamed from: b, reason: collision with root package name */
    private boolean f7271b = false;

    /* renamed from: c, reason: collision with root package name */
    private int f7272c = 0;

    /* renamed from: e, reason: collision with root package name */
    private int f7274e = 240;

    /* renamed from: f, reason: collision with root package name */
    private int f7275f = 80;

    /* renamed from: g, reason: collision with root package name */
    private int f7276g = 0;

    /* renamed from: j, reason: collision with root package name */
    private long f7279j = 0;

    /* renamed from: k, reason: collision with root package name */
    private int f7280k = 0;

    /* renamed from: n, reason: collision with root package name */
    private Object f7283n = new Object();

    /* renamed from: o, reason: collision with root package name */
    private boolean f7284o = true;

    /* renamed from: p, reason: collision with root package name */
    private AMapLocationClientOption.GeoLanguage f7285p = AMapLocationClientOption.GeoLanguage.DEFAULT;

    /* renamed from: q, reason: collision with root package name */
    private LocationListener f7286q = null;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements LocationListener {

        /* renamed from: a, reason: collision with root package name */
        private t4 f7287a;

        final void a() {
            this.f7287a = null;
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(Location location) {
            try {
                t4 t4Var = this.f7287a;
                if (t4Var != null) {
                    t4Var.e(location);
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String str) {
            try {
                t4 t4Var = this.f7287a;
                if (t4Var != null) {
                    t4Var.A();
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String str) {
            if (GeocodeSearch.GPS.equalsIgnoreCase(str)) {
                d.a();
            }
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String str, int i6, Bundle bundle) {
            try {
                t4 t4Var = this.f7287a;
                if (t4Var != null) {
                    t4Var.c(i6);
                }
            } catch (Throwable unused) {
            }
        }

        a(t4 t4Var) {
            this.f7287a = t4Var;
        }
    }

    private boolean t() {
        boolean z5 = true;
        try {
            if (j.c() >= 28) {
                if (this.f7281l == null) {
                    this.f7281l = (LocationManager) StubApp.getOrigApplicationContext(this.f7278i.getApplicationContext()).getSystemService(SocializeConstants.KEY_LOCATION);
                }
                z5 = ((Boolean) f.a(this.f7281l, "isLocationEnabled", new Object[0])).booleanValue();
            }
            if (j.c() >= 24 && j.c() < 28) {
                if (Settings.Secure.getInt(this.f7278i.getContentResolver(), "location_mode", 0) == 0) {
                    return false;
                }
            }
            return z5;
        } catch (Throwable unused) {
            d.a();
            return z5;
        }
    }

    private static com.autonavi.aps.amapapi.model.a a(int i6, String str) {
        com.autonavi.aps.amapapi.model.a aVar = new com.autonavi.aps.amapapi.model.a("");
        aVar.setErrorCode(i6);
        aVar.setLocationDetail(str);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i6) {
        if (i6 == 0) {
            try {
                d.a();
                this.f7276g = 0;
            } catch (Throwable unused) {
            }
        }
    }

    private void d(int i6, String str, long j6) {
        try {
            if (this.f7277h != null) {
                Message obtain = Message.obtain();
                AMapLocation aMapLocation = new AMapLocation("");
                aMapLocation.setErrorCode(20);
                aMapLocation.setLocationDetail(str);
                aMapLocation.setLocationType(11);
                obtain.obj = aMapLocation;
                obtain.what = i6;
                this.f7277h.sendMessageDelayed(obtain, j6);
            }
        } catch (Throwable unused) {
            d.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0080 A[Catch: all -> 0x002c, TryCatch #3 {all -> 0x002c, blocks: (B:6:0x000d, B:11:0x001a, B:13:0x0026, B:14:0x0034, B:16:0x003e, B:18:0x0044, B:19:0x005e, B:25:0x007a, B:27:0x0080, B:29:0x008f, B:31:0x0094, B:33:0x00c0, B:35:0x00c6, B:36:0x00e1, B:40:0x00e8, B:45:0x00ee, B:46:0x00c4, B:52:0x002f, B:38:0x00e2, B:39:0x00e7), top: B:5:0x000d, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c4 A[Catch: all -> 0x002c, TryCatch #3 {all -> 0x002c, blocks: (B:6:0x000d, B:11:0x001a, B:13:0x0026, B:14:0x0034, B:16:0x003e, B:18:0x0044, B:19:0x005e, B:25:0x007a, B:27:0x0080, B:29:0x008f, B:31:0x0094, B:33:0x00c0, B:35:0x00c6, B:36:0x00e1, B:40:0x00e8, B:45:0x00ee, B:46:0x00c4, B:52:0x002f, B:38:0x00e2, B:39:0x00e7), top: B:5:0x000d, inners: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void e(android.location.Location r10) {
        /*
            Method dump skipped, instructions count: 247
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.t4.e(android.location.Location):void");
    }

    private void k(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        if (aMapLocation2 == null || !this.f7282m.isNeedAddress() || j.a(aMapLocation, aMapLocation2) >= this.f7274e) {
            return;
        }
        b.a(aMapLocation, aMapLocation2);
    }

    private static boolean m(LocationManager locationManager) {
        try {
            if (f7265t) {
                return f7266u;
            }
            List<String> allProviders = locationManager.getAllProviders();
            if (allProviders == null || allProviders.size() <= 0) {
                f7266u = false;
            } else {
                f7266u = allProviders.contains(GeocodeSearch.GPS);
            }
            f7265t = true;
            return f7266u;
        } catch (Throwable th) {
            new StringBuilder("CoarseLocation | hasProvider error: ").append(th.getMessage());
            d.a();
            return f7266u;
        }
    }

    private static boolean r(LocationManager locationManager) {
        try {
            if (f7267v) {
                return f7268w;
            }
            boolean isProviderEnabled = locationManager.isProviderEnabled("network");
            f7268w = isProviderEnabled;
            f7267v = true;
            return isProviderEnabled;
        } catch (Throwable th) {
            new StringBuilder("CoarseLocation | hasProvider error: ").append(th.getMessage());
            d.a();
            return f7268w;
        }
    }

    private void s(AMapLocation aMapLocation) {
        if (this.f7282m.getLocationMode().equals(AMapLocationClientOption.AMapLocationMode.Device_Sensors) && this.f7282m.getDeviceModeDistanceFilter() > 0.0f) {
            v(aMapLocation);
        } else if (j.b() - this.f7279j >= this.f7282m.getInterval() - 200) {
            this.f7279j = j.b();
            v(aMapLocation);
        }
    }

    private void u() {
        s(a(12, "定位服务没有开启，请在设置中打开定位服务开关#1206"));
    }

    private void v(AMapLocation aMapLocation) {
        if (this.f7277h != null) {
            d.a();
            Message obtain = Message.obtain();
            obtain.obj = aMapLocation;
            obtain.what = 101;
            this.f7277h.sendMessage(obtain);
        }
    }

    private void w() {
        s(a(20, "模糊权限下不支持连续定位#2006"));
    }

    private void x(AMapLocation aMapLocation) {
        try {
            if (!b.a(aMapLocation.getLatitude(), aMapLocation.getLongitude()) || !this.f7282m.isOffset()) {
                aMapLocation.setOffset(false);
                aMapLocation.setCoordType(AMapLocation.COORD_TYPE_WGS84);
                return;
            }
            DPoint a6 = e.a(this.f7278i, new DPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude()));
            aMapLocation.setLatitude(a6.getLatitude());
            aMapLocation.setLongitude(a6.getLongitude());
            aMapLocation.setOffset(this.f7282m.isOffset());
            aMapLocation.setCoordType(AMapLocation.COORD_TYPE_GCJ02);
        } catch (Throwable th) {
            aMapLocation.setOffset(false);
            aMapLocation.setCoordType(AMapLocation.COORD_TYPE_WGS84);
            new StringBuilder("CoarseLocation | offset error: ").append(th.getMessage());
            d.a();
        }
    }

    private void z() {
        if (this.f7281l == null) {
            return;
        }
        try {
            this.f7284o = true;
            Looper myLooper = Looper.myLooper();
            if (myLooper == null) {
                myLooper = this.f7278i.getMainLooper();
            }
            Looper looper = myLooper;
            this.f7270a = j.b();
            if (r(this.f7281l)) {
                if (this.f7286q == null) {
                    this.f7286q = new a(this);
                }
                this.f7281l.requestLocationUpdates("network", this.f7282m.getInterval(), this.f7282m.getDeviceModeDistanceFilter(), this.f7286q, looper);
            }
            if (m(this.f7281l)) {
                try {
                    if (j.a() - f7264s >= 259200000) {
                        if (j.c(this.f7278i, "WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19MT0NBVElPTl9FWFRSQV9DT01NQU5EUw==")) {
                            this.f7281l.sendExtraCommand(GeocodeSearch.GPS, "force_xtra_injection", null);
                            f7264s = j.a();
                            SharedPreferences.Editor a6 = i.a(this.f7278i, "pref");
                            i.a(a6, "lagt", f7264s);
                            i.a(a6);
                            d.a();
                        } else {
                            b.a(new Exception("n_alec"), "OPENSDK_CL", "rlu_n_alec");
                        }
                    }
                } catch (Throwable th) {
                    new StringBuilder("CoarseLocation | sendExtraCommand error: ").append(th.getMessage());
                    d.a();
                }
                if (this.f7286q == null) {
                    this.f7286q = new a(this);
                }
                this.f7281l.requestLocationUpdates(GeocodeSearch.GPS, this.f7282m.getInterval(), this.f7282m.getDeviceModeDistanceFilter(), this.f7286q, looper);
                d.a();
            }
            if (f7266u || f7268w) {
                d(100, "系统返回定位结果超时#2002", this.f7282m.getHttpTimeOut());
            }
            if (f7266u || f7268w) {
                return;
            }
            d.a();
            d(100, "系统定位当前不可用#2003", 0L);
        } catch (SecurityException e6) {
            d.a();
            this.f7284o = false;
            h.a((String) null, 2121);
            d(101, e6.getMessage() + "#2004", 0L);
        } catch (Throwable th2) {
            new StringBuilder("CoarseLocation | requestLocationUpdates error: ").append(th2.getMessage());
            d.a();
            b.a(th2, "CoarseLocation", "requestLocationUpdates part2");
        }
    }

    public final void f(Bundle bundle) {
        if (bundle != null) {
            try {
                bundle.setClassLoader(AMapLocation.class.getClassLoader());
                this.f7274e = bundle.getInt("I_MAX_GEO_DIS");
                this.f7275f = bundle.getInt("I_MIN_GEO_DIS");
                AMapLocation aMapLocation = (AMapLocation) bundle.getParcelable("loc");
                if (TextUtils.isEmpty(aMapLocation.getAdCode())) {
                    return;
                }
                synchronized (this.f7283n) {
                    f7269x = aMapLocation;
                }
            } catch (Throwable th) {
                b.a(th, "CoarseLocation", "setLastGeoLocation");
            }
        }
    }

    public final void l(AMapLocationClientOption aMapLocationClientOption) {
        this.f7282m = aMapLocationClientOption;
        if (aMapLocationClientOption == null) {
            this.f7282m = new AMapLocationClientOption();
        }
        new StringBuilder("option: ").append(this.f7282m.toString());
        d.a();
        if (!this.f7282m.isOnceLocation()) {
            w();
        } else if (!t()) {
            u();
        } else {
            try {
                f7264s = i.a(this.f7278i, "pref", "lagt", f7264s);
            } catch (Throwable unused) {
            }
            z();
        }
    }

    @SuppressLint({"NewApi"})
    public final int n() {
        LocationManager locationManager = this.f7281l;
        if (locationManager == null || !m(locationManager)) {
            return 1;
        }
        int i6 = Settings.Secure.getInt(this.f7278i.getContentResolver(), "location_mode", 0);
        if (i6 == 0) {
            return 2;
        }
        if (i6 == 2) {
            return 3;
        }
        return !this.f7284o ? 4 : 0;
    }

    public final void q(AMapLocationClientOption aMapLocationClientOption) {
        if (aMapLocationClientOption == null) {
            aMapLocationClientOption = new AMapLocationClientOption();
        }
        this.f7282m = aMapLocationClientOption;
        new StringBuilder("option: ").append(this.f7282m.toString());
        d.a();
        this.f7277h.removeMessages(100);
        if (this.f7285p != this.f7282m.getGeoLanguage()) {
            synchronized (this.f7283n) {
                f7269x = null;
            }
        }
        this.f7285p = this.f7282m.getGeoLanguage();
    }

    public t4(Context context, Handler handler) {
        this.f7273d = null;
        this.f7278i = context;
        this.f7277h = handler;
        try {
            this.f7281l = (LocationManager) context.getSystemService(SocializeConstants.KEY_LOCATION);
        } catch (Throwable th) {
            b.a(th, f7263r, "<init>");
        }
        this.f7273d = new com.autonavi.aps.amapapi.filters.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        try {
            d.a();
            this.f7276g = 0;
        } catch (Throwable unused) {
        }
    }

    private static void B(AMapLocation aMapLocation) {
        if (j.a(aMapLocation) && com.autonavi.aps.amapapi.utils.a.s()) {
            long time = aMapLocation.getTime();
            long currentTimeMillis = System.currentTimeMillis();
            long a6 = c.a(time, currentTimeMillis, com.autonavi.aps.amapapi.utils.a.t());
            if (a6 != time) {
                aMapLocation.setTime(a6);
                h.a(time, currentTimeMillis);
            }
        }
    }

    private void j(AMapLocation aMapLocation) {
        if (!j.a(aMapLocation)) {
            return;
        }
        this.f7272c++;
    }

    private static int o(Location location) {
        int i6;
        Bundle extras = location.getExtras();
        if (extras != null) {
            i6 = extras.getInt("satellites");
        } else {
            i6 = 0;
        }
        d.b();
        return i6;
    }

    private void p(AMapLocation aMapLocation) {
        if (j.a(aMapLocation) && this.f7277h != null) {
            long b6 = j.b();
            if (this.f7282m.getInterval() <= 8000 || b6 - this.f7279j > this.f7282m.getInterval() - 8000) {
                Bundle bundle = new Bundle();
                bundle.putDouble(com.umeng.analytics.pro.d.C, aMapLocation.getLatitude());
                bundle.putDouble("lon", aMapLocation.getLongitude());
                bundle.putFloat("radius", aMapLocation.getAccuracy());
                bundle.putLong("time", aMapLocation.getTime());
                Message obtain = Message.obtain();
                obtain.setData(bundle);
                obtain.what = 102;
                synchronized (this.f7283n) {
                    try {
                        if (f7269x == null) {
                            this.f7277h.sendMessage(obtain);
                        } else if (j.a(aMapLocation, f7269x) > this.f7275f) {
                            this.f7277h.sendMessage(obtain);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
    }

    private AMapLocation y(AMapLocation aMapLocation) {
        if (!j.a(aMapLocation) || this.f7272c < 3) {
            return aMapLocation;
        }
        if (aMapLocation.getAccuracy() < 0.0f || aMapLocation.getAccuracy() == Float.MAX_VALUE) {
            aMapLocation.setAccuracy(0.0f);
        }
        if (aMapLocation.getSpeed() < 0.0f || aMapLocation.getSpeed() == Float.MAX_VALUE) {
            aMapLocation.setSpeed(0.0f);
        }
        return this.f7273d.a(aMapLocation);
    }

    public final void b() {
        d.a();
        LocationManager locationManager = this.f7281l;
        if (locationManager == null) {
            return;
        }
        try {
            LocationListener locationListener = this.f7286q;
            if (locationListener != null) {
                locationManager.removeUpdates(locationListener);
                ((a) this.f7286q).a();
                this.f7286q = null;
                d.a();
            }
        } catch (Throwable th) {
            new StringBuilder("CoarseLocation | removeUpdates error ").append(th.getMessage());
            d.a();
        }
        try {
            Handler handler = this.f7277h;
            if (handler != null) {
                handler.removeMessages(100);
            }
        } catch (Throwable unused) {
        }
        this.f7276g = 0;
        this.f7270a = 0L;
        this.f7279j = 0L;
        this.f7272c = 0;
        this.f7280k = 0;
        this.f7273d.a();
    }
}
