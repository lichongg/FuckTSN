package com.amap.api.col.p0003l;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.location.GnssStatus;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.work.PeriodicWorkRequest;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.DPoint;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.autonavi.aps.amapapi.utils.d;
import com.autonavi.aps.amapapi.utils.e;
import com.autonavi.aps.amapapi.utils.f;
import com.autonavi.aps.amapapi.utils.h;
import com.autonavi.aps.amapapi.utils.i;
import com.autonavi.aps.amapapi.utils.j;
import com.umeng.socialize.common.SocializeConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class u5 {
    static AMapLocation D;
    static long E;
    static Object F = new Object();
    static long G;
    static boolean H;
    static boolean I;
    public static volatile AMapLocation J;

    /* renamed from: a, reason: collision with root package name */
    Handler f7366a;

    /* renamed from: b, reason: collision with root package name */
    private Context f7367b;

    /* renamed from: c, reason: collision with root package name */
    LocationManager f7368c;

    /* renamed from: d, reason: collision with root package name */
    AMapLocationClientOption f7369d;

    /* renamed from: i, reason: collision with root package name */
    com.autonavi.aps.amapapi.filters.a f7374i;

    /* renamed from: t, reason: collision with root package name */
    private GnssStatus.Callback f7385t;

    /* renamed from: e, reason: collision with root package name */
    private long f7370e = 0;

    /* renamed from: f, reason: collision with root package name */
    long f7371f = 0;

    /* renamed from: g, reason: collision with root package name */
    boolean f7372g = false;

    /* renamed from: h, reason: collision with root package name */
    private int f7373h = 0;

    /* renamed from: j, reason: collision with root package name */
    int f7375j = 240;

    /* renamed from: k, reason: collision with root package name */
    int f7376k = 80;

    /* renamed from: l, reason: collision with root package name */
    AMapLocation f7377l = null;

    /* renamed from: m, reason: collision with root package name */
    long f7378m = 0;

    /* renamed from: n, reason: collision with root package name */
    float f7379n = 0.0f;

    /* renamed from: o, reason: collision with root package name */
    Object f7380o = new Object();

    /* renamed from: p, reason: collision with root package name */
    Object f7381p = new Object();

    /* renamed from: q, reason: collision with root package name */
    private int f7382q = 0;

    /* renamed from: r, reason: collision with root package name */
    private GpsStatus f7383r = null;

    /* renamed from: s, reason: collision with root package name */
    private GpsStatus.Listener f7384s = null;

    /* renamed from: u, reason: collision with root package name */
    AMapLocationClientOption.GeoLanguage f7386u = AMapLocationClientOption.GeoLanguage.DEFAULT;

    /* renamed from: v, reason: collision with root package name */
    boolean f7387v = true;

    /* renamed from: w, reason: collision with root package name */
    long f7388w = 0;

    /* renamed from: x, reason: collision with root package name */
    int f7389x = 0;

    /* renamed from: y, reason: collision with root package name */
    LocationListener f7390y = null;

    /* renamed from: z, reason: collision with root package name */
    private String f7391z = null;
    private boolean A = false;
    private int B = 0;
    private boolean C = false;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a extends GnssStatus.Callback {
        a() {
        }

        @Override // android.location.GnssStatus.Callback
        public final void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            u5.this.f(gnssStatus);
        }

        @Override // android.location.GnssStatus.Callback
        public final void onStopped() {
            u5.this.M();
        }

        @Override // android.location.GnssStatus.Callback
        public final void onFirstFix(int i6) {
            u5.N();
        }

        @Override // android.location.GnssStatus.Callback
        public final void onStarted() {
            u5.L();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class b implements GpsStatus.Listener {
        b() {
        }

        @Override // android.location.GpsStatus.Listener
        public final void onGpsStatusChanged(int i6) {
            try {
                u5 u5Var = u5.this;
                LocationManager locationManager = u5Var.f7368c;
                if (locationManager == null) {
                    return;
                }
                u5Var.f7383r = locationManager.getGpsStatus(u5Var.f7383r);
                if (i6 == 1) {
                    u5.L();
                    return;
                }
                if (i6 == 2) {
                    u5.this.M();
                } else if (i6 == 3) {
                    u5.N();
                } else {
                    if (i6 != 4) {
                        return;
                    }
                    u5.this.O();
                }
            } catch (Throwable th) {
                new StringBuilder("GpsLocation | onGpsStatusChanged error: ").append(th.getMessage());
                d.a();
                com.autonavi.aps.amapapi.utils.b.a(th, "GpsLocation", "onGpsStatusChanged");
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class c implements LocationListener {

        /* renamed from: a, reason: collision with root package name */
        private u5 f7394a;

        final void a() {
            this.f7394a = null;
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(Location location) {
            try {
                new StringBuilder("tid=").append(Thread.currentThread().getId());
                d.a();
                u5 u5Var = this.f7394a;
                if (u5Var != null) {
                    u5Var.g(location);
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String str) {
            try {
                u5 u5Var = this.f7394a;
                if (u5Var != null) {
                    u5Var.q(str);
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String str, int i6, Bundle bundle) {
            try {
                u5 u5Var = this.f7394a;
                if (u5Var != null) {
                    u5Var.d(i6);
                }
            } catch (Throwable unused) {
            }
        }

        c(u5 u5Var) {
            this.f7394a = u5Var;
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String str) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        Iterable<GpsSatellite> satellites;
        int i6 = 0;
        try {
            GpsStatus gpsStatus = this.f7383r;
            if (gpsStatus != null && (satellites = gpsStatus.getSatellites()) != null) {
                Iterator<GpsSatellite> it = satellites.iterator();
                int maxSatellites = this.f7383r.getMaxSatellites();
                while (it.hasNext() && i6 < maxSatellites) {
                    if (it.next().usedInFix()) {
                        i6++;
                    }
                }
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GpsLocation", "GPS_EVENT_SATELLITE_STATUS");
        }
        this.f7382q = i6;
    }

    private AMapLocation R() {
        float f6;
        float f7;
        try {
            if (j.a(this.f7377l) && com.autonavi.aps.amapapi.utils.a.k() && Q()) {
                JSONObject jSONObject = new JSONObject((String) f.a(q4.u("KY29tLmFtYXAuYXBpLm5hdmkuQU1hcE5hdmk="), q4.u("UZ2V0TmF2aUxvY2F0aW9u"), (Object[]) null, (Class<?>[]) null));
                long optLong = jSONObject.optLong("time");
                if (!this.C) {
                    this.C = true;
                    h.a("useNaviLoc", "use NaviLoc");
                }
                if (j.a() - optLong <= 5500) {
                    double optDouble = jSONObject.optDouble(com.umeng.analytics.pro.d.C, 0.0d);
                    double optDouble2 = jSONObject.optDouble(com.umeng.analytics.pro.d.D, 0.0d);
                    float f8 = 0.0f;
                    try {
                        f6 = Float.parseFloat(jSONObject.optString("accuracy", "0"));
                    } catch (NumberFormatException unused) {
                        f6 = 0.0f;
                    }
                    double optDouble3 = jSONObject.optDouble("altitude", 0.0d);
                    try {
                        f7 = Float.parseFloat(jSONObject.optString("bearing", "0"));
                    } catch (NumberFormatException unused2) {
                        f7 = 0.0f;
                    }
                    try {
                        f8 = (Float.parseFloat(jSONObject.optString("speed", "0")) * 10.0f) / 36.0f;
                    } catch (NumberFormatException unused3) {
                    }
                    AMapLocation aMapLocation = new AMapLocation("lbs");
                    aMapLocation.setLocationType(9);
                    aMapLocation.setLatitude(optDouble);
                    aMapLocation.setLongitude(optDouble2);
                    aMapLocation.setAccuracy(f6);
                    aMapLocation.setAltitude(optDouble3);
                    aMapLocation.setBearing(f7);
                    aMapLocation.setSpeed(f8);
                    aMapLocation.setTime(optLong);
                    aMapLocation.setCoordType(AMapLocation.COORD_TYPE_GCJ02);
                    if (j.a(aMapLocation, this.f7377l) <= 300.0f) {
                        synchronized (this.f7381p) {
                            this.f7377l.setLongitude(optDouble2);
                            this.f7377l.setLatitude(optDouble);
                            this.f7377l.setAccuracy(f6);
                            this.f7377l.setBearing(f7);
                            this.f7377l.setSpeed(f8);
                            this.f7377l.setTime(optLong);
                            this.f7377l.setCoordType(AMapLocation.COORD_TYPE_GCJ02);
                        }
                        return aMapLocation;
                    }
                }
            }
        } catch (Throwable unused4) {
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(GnssStatus gnssStatus) {
        int satelliteCount;
        boolean usedInFix;
        int i6 = 0;
        if (gnssStatus != null) {
            try {
                if (Build.VERSION.SDK_INT >= 24) {
                    satelliteCount = gnssStatus.getSatelliteCount();
                    int i7 = 0;
                    while (i6 < satelliteCount) {
                        try {
                            usedInFix = gnssStatus.usedInFix(i6);
                            if (usedInFix) {
                                i7++;
                            }
                            i6++;
                        } catch (Throwable th) {
                            th = th;
                            i6 = i7;
                            com.autonavi.aps.amapapi.utils.b.a(th, "GpsLocation_Gnss", "GPS_EVENT_SATELLITE_STATUS");
                            this.f7382q = i6;
                        }
                    }
                    i6 = i7;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        this.f7382q = i6;
    }

    public final void x() {
        this.f7389x = 0;
    }

    private void B(AMapLocation aMapLocation) {
        if (this.f7366a != null) {
            Message obtain = Message.obtain();
            obtain.obj = aMapLocation;
            obtain.what = 2;
            this.f7366a.sendMessage(obtain);
        }
    }

    private void D(AMapLocation aMapLocation) {
        try {
            if (!com.autonavi.aps.amapapi.utils.b.a(aMapLocation.getLatitude(), aMapLocation.getLongitude()) || !this.f7369d.isOffset()) {
                aMapLocation.setOffset(false);
                aMapLocation.setCoordType(AMapLocation.COORD_TYPE_WGS84);
                return;
            }
            DPoint a6 = e.a(this.f7367b, new DPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude()));
            aMapLocation.setLatitude(a6.getLatitude());
            aMapLocation.setLongitude(a6.getLongitude());
            aMapLocation.setOffset(this.f7369d.isOffset());
            aMapLocation.setCoordType(AMapLocation.COORD_TYPE_GCJ02);
        } catch (Throwable unused) {
            aMapLocation.setOffset(false);
            aMapLocation.setCoordType(AMapLocation.COORD_TYPE_WGS84);
        }
    }

    private void E(AMapLocation aMapLocation) {
        try {
            int i6 = this.f7382q;
            if (i6 >= 4) {
                aMapLocation.setGpsAccuracyStatus(1);
            } else if (i6 == 0) {
                aMapLocation.setGpsAccuracyStatus(-1);
            } else {
                aMapLocation.setGpsAccuracyStatus(0);
            }
        } catch (Throwable unused) {
        }
    }

    private void K() {
        u5 u5Var;
        if (this.f7368c == null) {
            return;
        }
        try {
            P();
            this.f7387v = true;
            Looper myLooper = Looper.myLooper();
            if (myLooper == null) {
                myLooper = this.f7367b.getMainLooper();
            }
            Looper looper = myLooper;
            this.f7370e = j.b();
            if (!r(this.f7368c)) {
                d.a();
                u5Var = this;
                try {
                    u5Var.e(8, 14, "no gps provider#1402", 0L);
                    return;
                } catch (SecurityException e6) {
                    e = e6;
                    d.a();
                    u5Var.f7387v = false;
                    h.a((String) null, 2121);
                    u5Var.e(2, 12, e.getMessage() + "#1201", 0L);
                } catch (Throwable th) {
                    th = th;
                    new StringBuilder("GpsLocation | requestLocationUpdates error: ").append(th.getMessage());
                    d.a();
                    com.autonavi.aps.amapapi.utils.b.a(th, "GpsLocation", "requestLocationUpdates part2");
                }
            }
            try {
                if (j.a() - G >= 259200000) {
                    if (j.c(this.f7367b, "WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19MT0NBVElPTl9FWFRSQV9DT01NQU5EUw==")) {
                        this.f7368c.sendExtraCommand(GeocodeSearch.GPS, "force_xtra_injection", null);
                        G = j.a();
                        SharedPreferences.Editor a6 = i.a(this.f7367b, "pref");
                        i.a(a6, "lagt", G);
                        i.a(a6);
                        d.a();
                    } else {
                        com.autonavi.aps.amapapi.utils.b.a(new Exception("n_alec"), "OPENSDK_GL", "rlu_n_alec");
                    }
                }
            } catch (Throwable th2) {
                new StringBuilder("GpsLocation | sendExtraCommand error: ").append(th2.getMessage());
                d.a();
            }
            if (this.f7390y == null) {
                this.f7390y = new c(this);
            }
            if (!this.f7369d.getLocationMode().equals(AMapLocationClientOption.AMapLocationMode.Device_Sensors) || this.f7369d.getDeviceModeDistanceFilter() <= 0.0f) {
                this.f7368c.requestLocationUpdates(GeocodeSearch.GPS, 900L, 0.0f, this.f7390y, looper);
            } else {
                this.f7368c.requestLocationUpdates(GeocodeSearch.GPS, this.f7369d.getInterval(), this.f7369d.getDeviceModeDistanceFilter(), this.f7390y, looper);
            }
            if (Build.VERSION.SDK_INT >= 24) {
                a aVar = new a();
                this.f7385t = aVar;
                this.f7368c.registerGnssStatusCallback(aVar);
            } else {
                b bVar = new b();
                this.f7384s = bVar;
                this.f7368c.addGpsStatusListener(bVar);
                d.a();
            }
            e(8, 14, "no enough satellites#1401", this.f7369d.getHttpTimeOut());
        } catch (SecurityException e7) {
            e = e7;
            u5Var = this;
            d.a();
            u5Var.f7387v = false;
            h.a((String) null, 2121);
            u5Var.e(2, 12, e.getMessage() + "#1201", 0L);
        } catch (Throwable th3) {
            th = th3;
            new StringBuilder("GpsLocation | requestLocationUpdates error: ").append(th.getMessage());
            d.a();
            com.autonavi.aps.amapapi.utils.b.a(th, "GpsLocation", "requestLocationUpdates part2");
        }
    }

    private static boolean Q() {
        try {
            return ((Boolean) f.a(q4.u("KY29tLmFtYXAuYXBpLm5hdmkuQU1hcE5hdmk="), q4.u("UaXNOYXZpU3RhcnRlZA=="), (Object[]) null, (Class<?>[]) null)).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i6) {
        if (i6 == 0) {
            try {
                this.f7371f = 0L;
                this.f7382q = 0;
            } catch (Throwable unused) {
            }
        }
    }

    private void e(int i6, int i7, String str, long j6) {
        try {
            if (this.f7366a == null || this.f7369d.getLocationMode() != AMapLocationClientOption.AMapLocationMode.Device_Sensors) {
                return;
            }
            Message obtain = Message.obtain();
            AMapLocation aMapLocation = new AMapLocation("");
            aMapLocation.setProvider(GeocodeSearch.GPS);
            aMapLocation.setErrorCode(i7);
            aMapLocation.setLocationDetail(str);
            aMapLocation.setLocationType(1);
            obtain.obj = aMapLocation;
            obtain.what = i6;
            this.f7366a.sendMessageDelayed(obtain, j6);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Location location) {
        Handler handler = this.f7366a;
        if (handler != null) {
            handler.removeMessages(8);
        }
        if (location == null) {
            return;
        }
        try {
            AMapLocation aMapLocation = new AMapLocation(location);
            if (j.a(aMapLocation)) {
                aMapLocation.setProvider(GeocodeSearch.GPS);
                aMapLocation.setLocationType(1);
                if (!this.f7372g && j.a(aMapLocation)) {
                    h.a(this.f7367b, j.b() - this.f7370e, com.autonavi.aps.amapapi.utils.b.a(aMapLocation.getLatitude(), aMapLocation.getLongitude()));
                    this.f7372g = true;
                }
                if (j.a(aMapLocation, this.f7382q)) {
                    aMapLocation.setMock(true);
                    aMapLocation.setTrustedLevel(4);
                    if (!this.f7369d.isMockEnable()) {
                        int i6 = this.f7389x;
                        if (i6 <= 3) {
                            this.f7389x = i6 + 1;
                            return;
                        }
                        h.a((String) null, 2152);
                        aMapLocation.setErrorCode(15);
                        aMapLocation.setLocationDetail("GpsLocation has been mocked!#1501");
                        aMapLocation.setLatitude(0.0d);
                        aMapLocation.setLongitude(0.0d);
                        aMapLocation.setAltitude(0.0d);
                        aMapLocation.setSpeed(0.0f);
                        aMapLocation.setAccuracy(0.0f);
                        aMapLocation.setBearing(0.0f);
                        aMapLocation.setExtras(null);
                        z(aMapLocation);
                        return;
                    }
                } else {
                    this.f7389x = 0;
                }
                aMapLocation.setSatellites(this.f7382q);
                D(aMapLocation);
                E(aMapLocation);
                J(aMapLocation);
                AMapLocation G2 = G(aMapLocation);
                n(G2);
                t(G2);
                synchronized (this.f7380o) {
                    o(G2, J);
                }
                try {
                    if (j.a(G2)) {
                        if (this.f7377l != null) {
                            this.f7378m = location.getTime() - this.f7377l.getTime();
                            this.f7379n = j.a(this.f7377l, G2);
                        }
                        synchronized (this.f7381p) {
                            this.f7377l = G2.m45clone();
                        }
                        this.f7391z = null;
                        this.A = false;
                        this.B = 0;
                    }
                } catch (Throwable th) {
                    com.autonavi.aps.amapapi.utils.b.a(th, "GpsLocation", "onLocationChangedLast");
                }
                z(G2);
            }
        } catch (Throwable th2) {
            com.autonavi.aps.amapapi.utils.b.a(th2, "GpsLocation", "onLocationChanged");
        }
    }

    private void o(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        if (aMapLocation2 == null || !this.f7369d.isNeedAddress() || j.a(aMapLocation, aMapLocation2) >= this.f7375j) {
            return;
        }
        com.autonavi.aps.amapapi.utils.b.a(aMapLocation, aMapLocation2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(String str) {
        try {
            if (GeocodeSearch.GPS.equalsIgnoreCase(str)) {
                this.f7371f = 0L;
                this.f7382q = 0;
            }
        } catch (Throwable unused) {
        }
    }

    private static boolean r(LocationManager locationManager) {
        try {
            if (H) {
                return I;
            }
            List<String> allProviders = locationManager.getAllProviders();
            if (allProviders == null || allProviders.size() <= 0) {
                I = false;
            } else {
                I = allProviders.contains(GeocodeSearch.GPS);
            }
            H = true;
            return I;
        } catch (Throwable th) {
            new StringBuilder("GpsLocation | hasProvider error: ").append(th.getMessage());
            d.a();
            return I;
        }
    }

    @SuppressLint({"NewApi"})
    public final int A() {
        LocationManager locationManager = this.f7368c;
        if (locationManager == null || !r(locationManager)) {
            return 1;
        }
        int i6 = Settings.Secure.getInt(this.f7367b.getContentResolver(), "location_mode", 0);
        if (i6 == 0) {
            return 2;
        }
        if (i6 == 2) {
            return 3;
        }
        return !this.f7387v ? 4 : 0;
    }

    public final int C() {
        return this.f7382q;
    }

    public final boolean F() {
        AMapLocationClientOption aMapLocationClientOption = this.f7369d;
        return (aMapLocationClientOption == null || aMapLocationClientOption.isOnceLocation() || j.b() - this.f7371f <= PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.amap.api.location.AMapLocation b(com.amap.api.location.AMapLocation r17, java.lang.String r18) {
        /*
            Method dump skipped, instructions count: 232
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.u5.b(com.amap.api.location.AMapLocation, java.lang.String):com.amap.api.location.AMapLocation");
    }

    public final void c() {
        LocationManager locationManager = this.f7368c;
        if (locationManager == null) {
            return;
        }
        try {
            LocationListener locationListener = this.f7390y;
            if (locationListener != null) {
                locationManager.removeUpdates(locationListener);
                ((c) this.f7390y).a();
                this.f7390y = null;
            }
        } catch (Throwable unused) {
        }
        try {
            GpsStatus.Listener listener = this.f7384s;
            if (listener != null) {
                this.f7368c.removeGpsStatusListener(listener);
            }
        } catch (Throwable unused2) {
        }
        try {
            GnssStatus.Callback callback = this.f7385t;
            if (callback != null) {
                this.f7368c.unregisterGnssStatusCallback(callback);
            }
        } catch (Throwable unused3) {
        }
        try {
            Handler handler = this.f7366a;
            if (handler != null) {
                handler.removeMessages(8);
            }
        } catch (Throwable unused4) {
        }
        this.f7382q = 0;
        this.f7370e = 0L;
        this.f7388w = 0L;
        this.f7371f = 0L;
        this.f7373h = 0;
        this.f7389x = 0;
        this.f7374i.a();
        this.f7377l = null;
        this.f7378m = 0L;
        this.f7379n = 0.0f;
        this.f7391z = null;
        this.C = false;
    }

    public final void h(Bundle bundle) {
        if (bundle != null) {
            try {
                bundle.setClassLoader(AMapLocation.class.getClassLoader());
                this.f7375j = bundle.getInt("I_MAX_GEO_DIS");
                this.f7376k = bundle.getInt("I_MIN_GEO_DIS");
                AMapLocation aMapLocation = (AMapLocation) bundle.getParcelable("loc");
                if (TextUtils.isEmpty(aMapLocation.getAdCode())) {
                    return;
                }
                synchronized (this.f7380o) {
                    J = aMapLocation;
                }
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "GpsLocation", "setLastGeoLocation");
            }
        }
    }

    public final void p(AMapLocationClientOption aMapLocationClientOption) {
        this.f7369d = aMapLocationClientOption;
        if (aMapLocationClientOption == null) {
            this.f7369d = new AMapLocationClientOption();
        }
        try {
            G = i.a(this.f7367b, "pref", "lagt", G);
        } catch (Throwable unused) {
        }
        K();
    }

    public final void u(AMapLocationClientOption aMapLocationClientOption) {
        Handler handler;
        if (aMapLocationClientOption == null) {
            aMapLocationClientOption = new AMapLocationClientOption();
        }
        this.f7369d = aMapLocationClientOption;
        if (aMapLocationClientOption.getLocationMode() != AMapLocationClientOption.AMapLocationMode.Device_Sensors && (handler = this.f7366a) != null) {
            handler.removeMessages(8);
        }
        if (this.f7386u != this.f7369d.getGeoLanguage()) {
            synchronized (this.f7380o) {
                J = null;
            }
        }
        this.f7386u = this.f7369d.getGeoLanguage();
    }

    public u5(Context context, Handler handler) {
        this.f7374i = null;
        this.f7367b = context;
        this.f7366a = handler;
        try {
            this.f7368c = (LocationManager) context.getSystemService(SocializeConstants.KEY_LOCATION);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GpsLocation", "<init>");
        }
        this.f7374i = new com.autonavi.aps.amapapi.filters.a();
    }

    private AMapLocation G(AMapLocation aMapLocation) {
        if (!j.a(aMapLocation) || this.f7373h < 3) {
            return aMapLocation;
        }
        if (aMapLocation.getAccuracy() < 0.0f || aMapLocation.getAccuracy() == Float.MAX_VALUE) {
            aMapLocation.setAccuracy(0.0f);
        }
        if (aMapLocation.getSpeed() < 0.0f || aMapLocation.getSpeed() == Float.MAX_VALUE) {
            aMapLocation.setSpeed(0.0f);
        }
        return this.f7374i.a(aMapLocation);
    }

    private static void J(AMapLocation aMapLocation) {
        if (j.a(aMapLocation) && com.autonavi.aps.amapapi.utils.a.s()) {
            long time = aMapLocation.getTime();
            long currentTimeMillis = System.currentTimeMillis();
            long a6 = com.autonavi.aps.amapapi.utils.c.a(time, currentTimeMillis, com.autonavi.aps.amapapi.utils.a.t());
            if (a6 != time) {
                aMapLocation.setTime(a6);
                h.a(time, currentTimeMillis);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void L() {
        d.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        d.a();
        this.f7382q = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void N() {
        d.a();
    }

    private void P() {
        if (j.b() - E <= 5000 && j.a(D)) {
            if (this.f7369d.isMockEnable() || !D.isMock()) {
                this.f7371f = j.b();
                z(D);
            }
        }
    }

    private void n(AMapLocation aMapLocation) {
        if (!j.a(aMapLocation)) {
            return;
        }
        this.f7371f = j.b();
        synchronized (F) {
            E = j.b();
            D = aMapLocation.m45clone();
        }
        this.f7373h++;
    }

    private void t(AMapLocation aMapLocation) {
        if (j.a(aMapLocation) && this.f7366a != null) {
            long b6 = j.b();
            if (this.f7369d.getInterval() <= 8000 || b6 - this.f7388w > this.f7369d.getInterval() - 8000) {
                Bundle bundle = new Bundle();
                bundle.putDouble(com.umeng.analytics.pro.d.C, aMapLocation.getLatitude());
                bundle.putDouble("lon", aMapLocation.getLongitude());
                bundle.putFloat("radius", aMapLocation.getAccuracy());
                bundle.putLong("time", aMapLocation.getTime());
                Message obtain = Message.obtain();
                obtain.setData(bundle);
                obtain.what = 5;
                synchronized (this.f7380o) {
                    try {
                        if (J == null) {
                            this.f7366a.sendMessage(obtain);
                        } else if (j.a(aMapLocation, J) > this.f7376k) {
                            this.f7366a.sendMessage(obtain);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
    }

    private boolean w(String str) {
        try {
            ArrayList<String> b6 = j.b(str);
            ArrayList<String> b7 = j.b(this.f7391z);
            if (b6.size() >= 8 && b7.size() >= 8) {
                return j.a(this.f7391z, str);
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private void z(AMapLocation aMapLocation) {
        if (aMapLocation.getErrorCode() != 15 || AMapLocationClientOption.AMapLocationMode.Device_Sensors.equals(this.f7369d.getLocationMode())) {
            if (this.f7369d.getLocationMode().equals(AMapLocationClientOption.AMapLocationMode.Device_Sensors) && this.f7369d.getDeviceModeDistanceFilter() > 0.0f) {
                B(aMapLocation);
            } else if (j.b() - this.f7388w >= this.f7369d.getInterval() - 200) {
                this.f7388w = j.b();
                B(aMapLocation);
            }
        }
    }

    public final boolean v() {
        if (j.b() - this.f7371f > 2800) {
            return false;
        }
        return true;
    }
}
