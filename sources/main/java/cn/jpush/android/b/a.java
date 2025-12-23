package cn.jpush.android.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkRequest;
import cn.jpush.android.ad.m;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.n.e;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.umeng.socialize.common.SocializeConstants;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a extends c {

    /* renamed from: b, reason: collision with root package name */
    private long f3524b;

    /* renamed from: c, reason: collision with root package name */
    private LocationManager f3525c;

    /* renamed from: d, reason: collision with root package name */
    private Handler f3526d;

    /* renamed from: e, reason: collision with root package name */
    private long f3527e;

    /* renamed from: f, reason: collision with root package name */
    private long f3528f;

    /* renamed from: g, reason: collision with root package name */
    private String f3529g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f3530h;

    /* renamed from: i, reason: collision with root package name */
    @SuppressLint({"MissingPermission"})
    private LocationListener f3531i;

    /* renamed from: j, reason: collision with root package name */
    private final AtomicBoolean f3532j;

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"MissingPermission"})
    public void d() {
        String str;
        try {
            LocationListener locationListener = this.f3531i;
            if (locationListener != null) {
                LocationManager locationManager = this.f3525c;
                if (locationManager != null) {
                    locationManager.removeUpdates(locationListener);
                    return;
                }
                str = "locationManager is null , do nothing!";
            } else {
                str = "Location listener is null , do nothing!";
            }
            Logger.w("CustomGeofenAction", str);
        } catch (Throwable th) {
            Logger.w("CustomGeofenAction", "remove location listener failed  e:" + th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Logger.d("CustomGeofenAction", "try locate...");
        if (!cn.jpush.android.n.c.a(this.f3556a, this.f3525c)) {
            Logger.dd("CustomGeofenAction", "No enabled provider");
            return;
        }
        Logger.d("CustomGeofenAction", "sdk int:" + Build.VERSION.SDK_INT + ",targetSdkVersion:" + this.f3556a.getApplicationInfo().targetSdkVersion);
        if (e.a().c() <= 0) {
            a();
        } else if (this.f3532j.get()) {
            Logger.d("CustomGeofenAction", "isLocating...");
        } else {
            f();
        }
    }

    private void c() {
        try {
            HandlerThread handlerThread = new HandlerThread("jg_cgf_thread") { // from class: cn.jpush.android.b.a.2
                @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        super.run();
                    } catch (RuntimeException e6) {
                        Logger.e("CustomGeofenAction", "handler thread run e:" + e6 + "  t=" + Thread.currentThread().getName() + "_" + Thread.currentThread().getId());
                    }
                }
            };
            handlerThread.start();
            this.f3526d = new Handler(handlerThread.getLooper()) { // from class: cn.jpush.android.b.a.3
                @Override // android.os.Handler
                @SuppressLint({"MissingPermission"})
                public void handleMessage(Message message) {
                    String str;
                    switch (message.what) {
                        case 1000:
                            Logger.d("CustomGeofenAction", "period task tid " + Thread.currentThread().getId());
                            a aVar = a.this;
                            aVar.b(aVar.f3527e);
                            break;
                        case 1001:
                            a.this.d();
                            try {
                                if (a.this.f3529g == null || !a.this.f3529g.equals(GeocodeSearch.GPS)) {
                                    str = "Network provider time out!";
                                } else {
                                    Logger.dd("CustomGeofenAction", "GPS provider time out!");
                                    a.this.f3529g = "network";
                                    if (a.this.f3525c.isProviderEnabled(a.this.f3529g)) {
                                        a.this.f3525c.requestLocationUpdates(a.this.f3529g, 2000L, 0.0f, a.this.f3531i);
                                        a.this.f3526d.sendEmptyMessageDelayed(1001, a.this.f3528f / 2);
                                        return;
                                    }
                                    str = "Network provider is disabled";
                                }
                                Logger.dd("CustomGeofenAction", str);
                            } catch (Throwable th) {
                                Logger.dd("CustomGeofenAction", "request location error#" + th);
                            }
                            a.this.f3532j.set(false);
                            return;
                        case 1002:
                            break;
                        default:
                            return;
                    }
                    a.this.e();
                }
            };
        } catch (Throwable th) {
            Logger.ww("CustomGeofenAction", "init geofence handler failed:" + th);
        }
    }

    @SuppressLint({"MissingPermission"})
    private void f() {
        String str;
        try {
            LocationManager locationManager = this.f3525c;
            if (locationManager == null) {
                Logger.ww("CustomGeofenAction", "locationManager is null");
                return;
            }
            Location a6 = cn.jpush.android.n.c.a(this.f3556a, locationManager, true);
            if (System.currentTimeMillis() - (a6 != null ? a6.getTime() : 0L) < WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
                StringBuilder sb = new StringBuilder();
                sb.append("need not restart gpslocation,the time with last:");
                sb.append(System.currentTimeMillis() - (a6 != null ? a6.getTime() : 0L));
                Logger.dd("CustomGeofenAction", sb.toString());
                a(a6);
                return;
            }
            this.f3529g = null;
            if (this.f3525c.isProviderEnabled(GeocodeSearch.GPS)) {
                this.f3529g = GeocodeSearch.GPS;
            } else if (this.f3525c.isProviderEnabled("network")) {
                this.f3529g = "network";
            }
            Logger.d("CustomGeofenAction", "provider " + this.f3529g);
            if (TextUtils.isEmpty(this.f3529g)) {
                Logger.dd("CustomGeofenAction", "not gps nor network provider,stop scan geofence");
                return;
            }
            this.f3532j.set(true);
            this.f3525c.requestLocationUpdates(this.f3529g, 2000L, 0.0f, this.f3531i);
            this.f3526d.sendEmptyMessageDelayed(1001, this.f3528f);
        } catch (SecurityException unused) {
            str = "No suitable permission when get last known location!";
            Logger.ww("CustomGeofenAction", str);
        } catch (Throwable th) {
            str = "The provider is illegal argument!" + th;
            Logger.ww("CustomGeofenAction", str);
        }
    }

    @Override // cn.jpush.android.b.c
    public synchronized void b() {
        boolean geoEnable = JCoreHelper.geoEnable(this.f3556a);
        Logger.dd("CustomGeofenAction", "start listen geofence lbsEnable=" + geoEnable);
        if (!geoEnable) {
            Logger.ww("CustomGeofenAction", "lbs is disable!");
            return;
        }
        if (this.f3530h) {
            Logger.ii("CustomGeofenAction", "geofence is running!");
            return;
        }
        if (e.a().c() == 0) {
            Logger.dd("CustomGeofenAction", "No geofence,not need listen");
            return;
        }
        if (this.f3526d == null) {
            c();
        }
        b(0L);
        this.f3530h = true;
    }

    public a(Context context) {
        super(context);
        this.f3527e = PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS;
        this.f3528f = WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;
        this.f3530h = false;
        this.f3531i = new LocationListener() { // from class: cn.jpush.android.b.a.1
            @Override // android.location.LocationListener
            public void onLocationChanged(Location location) {
                a.this.f3525c.removeUpdates(this);
                a.this.f3532j.set(false);
                a.this.a(location);
            }

            @Override // android.location.LocationListener
            public void onProviderDisabled(String str) {
            }

            @Override // android.location.LocationListener
            public void onProviderEnabled(String str) {
            }

            @Override // android.location.LocationListener
            public void onStatusChanged(String str, int i6, Bundle bundle) {
            }
        };
        this.f3532j = new AtomicBoolean();
        this.f3525c = (LocationManager) context.getSystemService(SocializeConstants.KEY_LOCATION);
        this.f3527e = cn.jpush.android.cache.a.c(context, PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS);
        this.f3524b = cn.jpush.android.cache.a.c(context, -1L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j6) {
        Logger.dd("CustomGeofenAction", "Scan geofence after " + j6 + "ms");
        Handler handler = this.f3526d;
        if (handler == null) {
            return;
        }
        if (handler.hasMessages(1000)) {
            this.f3526d.removeMessages(1000);
        }
        this.f3526d.sendEmptyMessageDelayed(1000, j6);
    }

    private void c(b bVar) {
        long currentTimeMillis = System.currentTimeMillis();
        bVar.f3550o = currentTimeMillis;
        Date date = new Date(currentTimeMillis);
        String format = m.a("yyyy-DDD").format(date);
        if (format.equals(bVar.f3553r)) {
            bVar.f3554s++;
        } else {
            bVar.f3553r = format;
            bVar.f3554s = 1;
        }
        String format2 = m.a("yyyy-ww").format(date);
        if (format2.equals(bVar.f3551p)) {
            bVar.f3552q++;
        } else {
            bVar.f3551p = format2;
            bVar.f3552q = 1;
        }
    }

    private boolean d(b bVar) {
        StringBuilder sb;
        int i6;
        String sb2;
        if (bVar.f3550o <= 0) {
            return true;
        }
        if (bVar.f3539d) {
            if (bVar.f3549n <= 0 && bVar.f3538c.equals("inside")) {
                bVar.f3549n = 3600;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (bVar.f3549n > 0) {
                long j6 = bVar.f3550o;
                if (j6 > 0 && currentTimeMillis < j6 + (r0 * 1000)) {
                    sb = new StringBuilder();
                    sb.append("in ");
                    sb.append(bVar.f3549n);
                    sb.append("s, can't repeat geofence");
                    sb2 = sb.toString();
                }
            }
            if (bVar.f3548m > 0 && !TextUtils.isEmpty(bVar.f3553r)) {
                if (bVar.f3553r.equals(m.a("yyyy-DDD").format(new Date(currentTimeMillis))) && bVar.f3554s >= bVar.f3548m) {
                    sb = new StringBuilder();
                    sb.append("today already repeat enough:");
                    sb.append(bVar.f3554s);
                    sb.append("/");
                    i6 = bVar.f3548m;
                    sb.append(i6);
                    sb2 = sb.toString();
                }
            }
            if (bVar.f3547l > 0 && !TextUtils.isEmpty(bVar.f3551p)) {
                if (bVar.f3551p.equals(m.a("yyyy-ww").format(new Date(currentTimeMillis))) && bVar.f3552q >= bVar.f3547l) {
                    sb = new StringBuilder();
                    sb.append("this week already repeat enough:");
                    sb.append(bVar.f3552q);
                    sb.append("/");
                    i6 = bVar.f3547l;
                    sb.append(i6);
                    sb2 = sb.toString();
                }
            }
            return true;
        }
        sb2 = "can't repeat geofence";
        Logger.dd("CustomGeofenAction", sb2);
        return false;
    }

    @Override // cn.jpush.android.b.c
    protected synchronized void a() {
        try {
            Logger.dd("CustomGeofenAction", "geofence size:" + e.a().c());
            Logger.dd("CustomGeofenAction", "stop listen geofence");
            if (this.f3530h) {
                Handler handler = this.f3526d;
                if (handler != null) {
                    handler.removeMessages(1000);
                }
                this.f3530h = false;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // cn.jpush.android.b.c
    public void a(long j6) {
        Logger.dd("CustomGeofenAction", "Set geofence interval " + j6);
        this.f3527e = j6;
        this.f3524b = j6;
        cn.jpush.android.cache.a.b(this.f3556a, j6);
    }

    @Override // cn.jpush.android.b.c
    protected void b(b bVar) {
        Logger.dd("CustomGeofenAction", "Geofence delete success, id=" + bVar.f3536a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Location location) {
        Logger.dd("CustomGeofenAction", "current location:" + location);
        Handler handler = this.f3526d;
        if (handler != null && handler.hasMessages(1001)) {
            this.f3526d.removeMessages(1001);
        }
        if (location != null && e.a().c() > 0) {
            double longitude = location.getLongitude();
            double latitude = location.getLatitude();
            Iterator<Map.Entry<String, b>> it = e.a().b().entrySet().iterator();
            boolean z5 = false;
            while (it.hasNext()) {
                b value = it.next().getValue();
                if (value.f3540e * 1000 <= System.currentTimeMillis()) {
                    Logger.dd("CustomGeofenAction", "Out of date geofence " + value.f3536a);
                    it.remove();
                    e.a().a(value);
                } else {
                    double a6 = m.a(longitude, latitude, value.f3541f, value.f3542g);
                    Logger.dd("CustomGeofenAction", value.f3536a + " distance to center:" + a6);
                    long j6 = value.f3537b;
                    boolean z6 = z5;
                    String str = a6 <= ((double) j6) ? "in" : "out";
                    z5 = Math.abs(a6 - ((double) j6)) < 1000.0d ? true : z6;
                    Logger.d("CustomGeofenAction", "lastStatus:" + value.f3543h + ",currentStatus:" + str);
                    Logger.d("CustomGeofenAction", "geofence status :" + value.f3543h + ",currentStatus:" + str + ",geoStatus:" + str);
                    if ((value.f3538c.equals("inside") || !str.equals(value.f3543h)) && (!value.f3538c.equals("inside") || str != "out")) {
                        if ((value.f3538c.equals("inside") || (value.f3543h != null && str.equals(value.f3538c))) && d(value)) {
                            c(value);
                            a(value, location);
                            double d6 = longitude;
                            cn.jpush.android.n.a.a(this.f3556a, value.a().toString(), latitude, d6);
                            longitude = d6;
                            if (!value.f3539d) {
                                Logger.dd("CustomGeofenAction", "No repeat geofence " + value.f3536a);
                                it.remove();
                                e.a().a(value);
                            }
                        }
                        value.f3543h = str;
                        e.a().a(value.f3536a, value.a(), false);
                    }
                }
            }
            boolean z7 = z5;
            if (this.f3524b == -1) {
                long j7 = z7 ? 180000 : 900000;
                if (this.f3527e != j7) {
                    this.f3527e = j7;
                    Logger.dd("CustomGeofenAction", "need update scan peroid to:" + this.f3527e);
                    b(j7);
                }
            }
        }
    }

    @Override // cn.jpush.android.b.c
    protected void a(b bVar) {
        Handler handler;
        Logger.dd("CustomGeofenAction", "Geofence create success, id=" + bVar.f3536a);
        if (!this.f3530h || (handler = this.f3526d) == null) {
            return;
        }
        handler.sendEmptyMessage(1002);
    }

    @Override // cn.jpush.android.b.c
    protected void a(b bVar, b bVar2) {
        Handler handler;
        if (bVar != null) {
            Logger.dd("CustomGeofenAction", "Geofence update success, id=" + bVar.f3536a);
        }
        if (!this.f3530h || (handler = this.f3526d) == null) {
            return;
        }
        handler.sendEmptyMessage(1002);
    }
}
