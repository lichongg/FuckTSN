package cn.jiguang.aj;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.work.WorkRequest;
import cn.jiguang.bb.f;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.umeng.analytics.pro.i;
import com.umeng.socialize.common.SocializeConstants;

@SuppressLint({"MissingPermission"})
/* loaded from: D:\Downloads\app\classes2.dex */
class c {

    /* renamed from: e, reason: collision with root package name */
    private static final Object f1536e = new Object();

    /* renamed from: i, reason: collision with root package name */
    private static c f1537i;

    /* renamed from: a, reason: collision with root package name */
    protected Handler f1538a;

    /* renamed from: b, reason: collision with root package name */
    private Context f1539b;

    /* renamed from: c, reason: collision with root package name */
    private LocationManager f1540c;

    /* renamed from: d, reason: collision with root package name */
    private cn.jiguang.ak.a f1541d;

    /* renamed from: f, reason: collision with root package name */
    private boolean f1542f;

    /* renamed from: g, reason: collision with root package name */
    private String f1543g;

    /* renamed from: h, reason: collision with root package name */
    private long f1544h = 0;

    /* renamed from: j, reason: collision with root package name */
    private LocationListener f1545j = new LocationListener() { // from class: cn.jiguang.aj.c.1
        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            try {
                f.c("JLocationGps", "onLocationChanged:" + location + ",provider:" + c.this.f1543g);
                cn.jiguang.bw.a.a().b((Object) 2054);
                c.this.a(location);
                c.this.h();
            } catch (Throwable th) {
                f.i("JLocationGps", "onLocationChanged failed:" + th.getMessage());
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            f.c("JLocationGps", "onProviderDisabled:" + str);
            cn.jiguang.bw.a.a().b((Object) 2053);
            c.this.h();
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
            f.c("JLocationGps", "onProviderEnabled:" + str);
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i6, Bundle bundle) {
            f.c("JLocationGps", "onStatusChanged status:" + i6);
            if (i6 == 0) {
                cn.jiguang.bw.a.a().b((Object) 2053);
                c.this.h();
            }
        }
    };

    class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str;
            int i6 = 1001;
            switch (message.what) {
                case 1001:
                    try {
                        if (c.this.f1543g == null || !c.this.f1543g.equals("network")) {
                            f.i("JLocationGps", "get " + c.this.f1543g + " time out ");
                            cn.jiguang.bw.a.a().b((Object) 2053);
                            c.this.h();
                            break;
                        } else {
                            f.i("JLocationGps", "get gps with network time out ");
                            c.this.f1543g = GeocodeSearch.GPS;
                            c.this.g();
                            boolean e6 = cn.jiguang.g.a.a().e(AVMDLDataLoader.KeyIsIsTestSpeedVersion);
                            boolean e7 = cn.jiguang.aj.a.a().e();
                            if (!e7 && !e6) {
                                cn.jiguang.bw.a.a().b((Object) 2066);
                                f.c("JLocationGps", "request " + c.this.f1543g + " location canCollect " + e6 + " isGpsEnable=" + e7);
                                c.this.f1538a.sendEmptyMessageDelayed(1001, 15000L);
                                break;
                            }
                            cn.jiguang.bw.a.a().b((Object) 2052);
                            c.this.f1540c.requestLocationUpdates(c.this.f1543g, 2000L, 0.0f, c.this.f1545j);
                            f.c("JLocationGps", "request " + c.this.f1543g + " location canCollect " + e6 + " isGpsEnable=" + e7);
                            c.this.f1538a.sendEmptyMessageDelayed(1001, 15000L);
                        }
                    } catch (Throwable th) {
                        str = "when location time out " + th.getMessage();
                        f.i("JLocationGps", str);
                        cn.jiguang.bw.a.a().b((Object) 2053);
                        c.this.h();
                        return;
                    }
                    break;
                case 1004:
                    f.c("JLocationGps", "LOAD_GPS_ACTION_REQUEST_ONLY_NETWORK");
                    i6 = 1005;
                case 1003:
                    try {
                        boolean e8 = cn.jiguang.g.a.a().e(AVMDLDataLoader.KeyIsIsTestSpeedVersion);
                        boolean e9 = cn.jiguang.aj.a.a().e();
                        if (!e9) {
                            cn.jiguang.bw.a.a().b((Object) 2048);
                        }
                        if (e9 || e8) {
                            cn.jiguang.bw.a.a().b((Object) 2052);
                            c.this.f1540c.requestLocationUpdates(c.this.f1543g, 2000L, 0.0f, c.this.f1545j);
                        }
                        f.c("JLocationGps", "request " + c.this.f1543g + " location canCollect " + e8 + " isGpsEnable=" + e9);
                        c.this.f1538a.sendEmptyMessageDelayed(i6, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
                        break;
                    } catch (SecurityException unused) {
                        str = "No suitable permission when get last known location!";
                        f.i("JLocationGps", str);
                        cn.jiguang.bw.a.a().b((Object) 2053);
                        c.this.h();
                        return;
                    } catch (Throwable unused2) {
                        str = "The provider is illegal argument!";
                        f.i("JLocationGps", str);
                        cn.jiguang.bw.a.a().b((Object) 2053);
                        c.this.h();
                        return;
                    }
                case 1005:
                    f.i("JLocationGps", "get only network " + c.this.f1543g + " time out ");
                    cn.jiguang.bw.a.a().b((Object) 2053);
                    c.this.h();
                    break;
            }
        }
    }

    public static c a(Context context) {
        if (f1537i == null) {
            synchronized (f1536e) {
                try {
                    if (f1537i == null) {
                        f1537i = new c(context);
                    }
                } finally {
                }
            }
        }
        return f1537i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void h() {
        f.c("JLocationGps", "gps will done");
        this.f1542f = true;
        g();
        Handler handler = this.f1538a;
        if (handler != null) {
            try {
                if (handler.hasMessages(1004)) {
                    this.f1538a.removeMessages(1004);
                }
                if (this.f1538a.hasMessages(1003)) {
                    this.f1538a.removeMessages(1003);
                }
                if (this.f1538a.hasMessages(1001)) {
                    this.f1538a.removeMessages(1001);
                }
                if (this.f1538a.hasMessages(1005)) {
                    this.f1538a.removeMessages(1005);
                }
                this.f1538a.getLooper().quit();
            } finally {
                try {
                } finally {
                }
            }
        } else {
            f.j("JLocationGps", "cellLocationManager is null,please check it");
        }
    }

    void c() {
        this.f1542f = false;
        this.f1541d = null;
        if (this.f1540c == null) {
            f.i("JLocationGps", "get locationManager failed");
            cn.jiguang.bw.a.a().b(Integer.valueOf(i.f41296b));
            this.f1542f = true;
            return;
        }
        f();
        if (this.f1538a == null) {
            f.i("JLocationGps", " mAsyncHandler is empty");
            this.f1542f = true;
            cn.jiguang.bw.a.a().b((Object) 2051);
        } else if (this.f1540c.isProviderEnabled("network")) {
            this.f1543g = "network";
            this.f1538a.sendEmptyMessage(1003);
        } else if (this.f1540c.isProviderEnabled(GeocodeSearch.GPS)) {
            this.f1543g = GeocodeSearch.GPS;
            this.f1538a.sendEmptyMessage(1003);
        } else {
            this.f1543g = "network";
            this.f1538a.sendEmptyMessage(1004);
        }
    }

    private void f() {
        try {
            if (this.f1538a == null) {
                HandlerThread handlerThread = new HandlerThread("jg_lcn_thread");
                handlerThread.start();
                this.f1538a = new a(handlerThread.getLooper());
            }
        } catch (Throwable th) {
            f.l("JLocationGps", "start load loc-info failed - error:" + th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        String str;
        try {
            LocationListener locationListener = this.f1545j;
            if (locationListener != null) {
                LocationManager locationManager = this.f1540c;
                if (locationManager != null) {
                    locationManager.removeUpdates(locationListener);
                    return;
                }
                str = "locationManager is null , do nothing!";
            } else {
                str = "Location listener is null , do nothing!";
            }
            f.i("JLocationGps", str);
        } catch (Throwable th) {
            f.i("JLocationGps", "remove location listener failed  e:" + th.getMessage());
        }
    }

    cn.jiguang.ak.a a() {
        return this.f1541d;
    }

    boolean b() {
        return this.f1542f;
    }

    public cn.jiguang.ak.a d() {
        try {
        } catch (Throwable th) {
            f.i("JLocationGps", "loadLastGpsInfo failed: " + th.getMessage());
        }
        if (this.f1544h > 0 && System.currentTimeMillis() - this.f1544h >= WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
            f.c("JLocationGps", "g scan time compare last time than: " + (System.currentTimeMillis() - this.f1544h));
            return null;
        }
        this.f1544h = System.currentTimeMillis();
        Location lastKnownLocation = this.f1540c.getLastKnownLocation(GeocodeSearch.GPS);
        Location lastKnownLocation2 = this.f1540c.getLastKnownLocation("network");
        Location lastKnownLocation3 = this.f1540c.getLastKnownLocation("passive");
        if (a(lastKnownLocation, lastKnownLocation2)) {
            if (a(lastKnownLocation, lastKnownLocation3)) {
            }
            lastKnownLocation = lastKnownLocation3;
        } else {
            if (a(lastKnownLocation2, lastKnownLocation3)) {
                lastKnownLocation = lastKnownLocation2;
            }
            lastKnownLocation = lastKnownLocation3;
        }
        if (lastKnownLocation != null && System.currentTimeMillis() - lastKnownLocation.getTime() < WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
            a(lastKnownLocation);
            f.c("JLocationGps", "bestLocation:" + this.f1541d + ",curTime:" + System.currentTimeMillis());
            return this.f1541d;
        }
        return null;
    }

    public boolean e() {
        String str;
        try {
            LocationManager locationManager = this.f1540c;
            if (locationManager == null) {
                return false;
            }
            if (locationManager.isProviderEnabled(GeocodeSearch.GPS) || this.f1540c.isProviderEnabled("network")) {
                return true;
            }
            return this.f1540c.isProviderEnabled("passive");
        } catch (IllegalArgumentException unused) {
            str = "The provider [gps] is illegal argument!";
            f.i("JLocationGps", str);
            return false;
        } catch (SecurityException unused2) {
            str = "No suitable permission is present when get GPS_PROVIDER!";
            f.i("JLocationGps", str);
            return false;
        } catch (Exception unused3) {
            str = "The ILocationManager is null!";
            f.i("JLocationGps", str);
            return false;
        }
    }

    private c(Context context) {
        this.f1539b = context;
        this.f1540c = (LocationManager) context.getSystemService(SocializeConstants.KEY_LOCATION);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Location location) {
        if (location == null) {
            this.f1541d = null;
            return;
        }
        f.c("JLocationGps", "updateGpsInfo location time:" + location.getTime());
        if (this.f1541d == null) {
            this.f1541d = new cn.jiguang.ak.a();
        }
        this.f1541d.f1549a = cn.jiguang.d.b.a(this.f1539b, location.getTime());
        this.f1541d.f1550b = location.getProvider();
        this.f1541d.f1551c = location.getLatitude();
        this.f1541d.f1552d = location.getLongitude();
        this.f1541d.f1554f = location.getBearing();
        this.f1541d.f1555g = location.getAccuracy();
    }

    private boolean a(Location location, Location location2) {
        if (location == null) {
            return false;
        }
        if (location2 == null) {
            return true;
        }
        long time = location.getTime() - location2.getTime();
        boolean z5 = time > 120000;
        boolean z6 = time < -120000;
        boolean z7 = time > 0;
        if (z5) {
            return true;
        }
        if (z6) {
            return false;
        }
        int accuracy = (int) (location.getAccuracy() - location2.getAccuracy());
        boolean z8 = accuracy > 0;
        boolean z9 = accuracy < 0;
        boolean z10 = accuracy > 200;
        boolean a6 = a(location.getProvider(), location2.getProvider());
        if (z9) {
            return true;
        }
        if (!z7 || z8) {
            return z7 && !z10 && a6;
        }
        return true;
    }

    private boolean a(String str, String str2) {
        return str == null ? str2 == null : str.equals(str2);
    }
}
