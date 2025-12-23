package com.beizi.ad.internal.h;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.beizi.ad.model.BeiZiLocation;
import com.beizi.ad.model.f;
import com.beizi.fusion.model.EnvInfo;
import com.beizi.fusion.model.RequestInfo;
import com.umeng.socialize.common.SocializeConstants;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class r {

    /* renamed from: i, reason: collision with root package name */
    private static r f12142i;

    /* renamed from: b, reason: collision with root package name */
    public String f12144b;

    /* renamed from: c, reason: collision with root package name */
    public String f12145c;

    /* renamed from: e, reason: collision with root package name */
    public long f12147e;

    /* renamed from: j, reason: collision with root package name */
    private EnvInfo f12151j;

    /* renamed from: f, reason: collision with root package name */
    private f.d f12148f = f.d.NET_OTHER;

    /* renamed from: g, reason: collision with root package name */
    private f.c f12149g = f.c.ISP_OTHER;

    /* renamed from: a, reason: collision with root package name */
    public boolean f12143a = true;

    /* renamed from: h, reason: collision with root package name */
    private int f12150h = -1;

    /* renamed from: d, reason: collision with root package name */
    public String f12146d = AMapLocation.COORD_TYPE_WGS84;

    public static synchronized r a() {
        r rVar;
        synchronized (r.class) {
            try {
                if (f12142i == null) {
                    synchronized (r.class) {
                        try {
                            if (f12142i == null) {
                                f12142i = new r();
                            }
                        } finally {
                        }
                    }
                }
                rVar = f12142i;
            } catch (Throwable th) {
                throw th;
            }
        }
        return rVar;
    }

    public f.d b() {
        f.d dVar = this.f12148f;
        f.d dVar2 = f.d.NET_OTHER;
        if (dVar == dVar2) {
            EnvInfo envInfo = this.f12151j;
            if (envInfo != null) {
                String net2 = envInfo.getNet();
                if ("1".equals(net2)) {
                    this.f12148f = f.d.NET_3G;
                } else if ("2".equals(net2)) {
                    this.f12148f = f.d.NET_4G;
                } else if ("3".equals(net2)) {
                    this.f12148f = f.d.NET_5G;
                } else if ("4".equals(net2)) {
                    this.f12148f = f.d.NET_WIFI;
                } else if ("5".equals(net2)) {
                    this.f12148f = dVar2;
                } else if ("6".equals(net2)) {
                    this.f12148f = f.d.NET_2G;
                }
            } else {
                this.f12148f = s.b(com.beizi.ad.internal.h.a().f12002j);
            }
        }
        return this.f12148f;
    }

    public f.c c() {
        f.c cVar = this.f12149g;
        f.c cVar2 = f.c.ISP_OTHER;
        if (cVar == cVar2) {
            EnvInfo envInfo = this.f12151j;
            if (envInfo != null) {
                String isp = envInfo.getIsp();
                if ("0".equals(isp)) {
                    this.f12149g = f.c.ISP_UNKNOWN;
                } else if ("1".equals(isp)) {
                    this.f12149g = f.c.ISP_CN_MOBILE;
                } else if ("2".equals(isp)) {
                    this.f12149g = f.c.ISP_CN_UNICOM;
                } else if ("3".equals(isp)) {
                    this.f12149g = f.c.ISP_CN_TEL;
                }
            } else if (cVar == cVar2) {
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) com.beizi.ad.internal.h.a().f12002j.getSystemService("phone");
                    if (telephonyManager != null && 5 == telephonyManager.getSimState()) {
                        String simOperator = telephonyManager.getSimOperator();
                        if (simOperator != null) {
                            if (!simOperator.equals("46000") && !simOperator.equals("46002") && !simOperator.equals("46007")) {
                                if (simOperator.equals("46001")) {
                                    this.f12149g = f.c.ISP_CN_UNICOM;
                                } else if (simOperator.equals("46003")) {
                                    this.f12149g = f.c.ISP_CN_TEL;
                                }
                            }
                            this.f12149g = f.c.ISP_CN_MOBILE;
                        } else {
                            this.f12149g = f.c.ISP_UNKNOWN;
                        }
                    }
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            }
        }
        return this.f12149g;
    }

    @SuppressLint({"MissingPermission"})
    public void d() {
        try {
            if (TextUtils.isEmpty(this.f12144b) && TextUtils.isEmpty(this.f12145c)) {
                if (com.beizi.ad.f.a() != null && !com.beizi.ad.f.a().a()) {
                    e();
                    return;
                }
                Context e6 = com.beizi.ad.internal.h.a().e();
                if (e6.checkCallingOrSelfPermission(com.kuaishou.weapon.p0.g.f36047g) != 0 && e6.checkCallingOrSelfPermission(com.kuaishou.weapon.p0.g.f36048h) != 0) {
                    e();
                    return;
                }
                LocationManager locationManager = (LocationManager) e6.getSystemService(SocializeConstants.KEY_LOCATION);
                if (locationManager == null) {
                    return;
                }
                Iterator<String> it = locationManager.getProviders(true).iterator();
                Location location = null;
                while (it.hasNext()) {
                    Location lastKnownLocation = locationManager.getLastKnownLocation(it.next());
                    if (lastKnownLocation != null) {
                        if (location != null) {
                            if (lastKnownLocation.getTime() > 0 && location.getTime() > 0 && lastKnownLocation.getTime() > location.getTime()) {
                            }
                        }
                        location = lastKnownLocation;
                    }
                }
                if (location == null) {
                    e();
                    return;
                }
                this.f12144b = String.valueOf(location.getLongitude());
                this.f12145c = String.valueOf(location.getLatitude());
                this.f12147e = location.getTime();
            }
        } catch (Exception e7) {
            e7.printStackTrace();
        }
    }

    private r() {
        RequestInfo requestInfo;
        Context e6 = com.beizi.fusion.c.b.a().e();
        if (e6 == null || (requestInfo = RequestInfo.getInstance(e6)) == null) {
            return;
        }
        if (!requestInfo.isInit) {
            requestInfo.init();
        }
        this.f12151j = requestInfo.getEnvInfo();
    }

    private void e() {
        BeiZiLocation b6;
        if (com.beizi.ad.f.a() == null || (b6 = com.beizi.ad.f.a().b()) == null) {
            return;
        }
        this.f12144b = b6.getLongitude();
        this.f12145c = b6.getLatitude();
        this.f12146d = b6.getType();
        this.f12147e = b6.getTime();
    }
}
