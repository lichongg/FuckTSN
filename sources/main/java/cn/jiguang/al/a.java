package cn.jiguang.al;

import android.annotation.SuppressLint;
import android.location.GnssStatus;
import android.location.Location;
import com.amap.api.services.geocoder.GeocodeSearch;

@SuppressLint({"NewApi"})
/* loaded from: D:\Downloads\app\classes2.dex */
public class a extends GnssStatus.Callback {

    /* renamed from: a, reason: collision with root package name */
    private b f1561a;

    @Override // android.location.GnssStatus.Callback
    public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
        final Location a6;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            b bVar = this.f1561a;
            long j6 = currentTimeMillis - bVar.f1567d;
            long j7 = e.f1603m;
            if (j6 > j7 * 1000) {
                bVar.f1567d = currentTimeMillis;
                bVar.f1569f = 0;
            }
            int i6 = bVar.f1569f;
            if (i6 >= 3) {
                Long.signum(j7);
                long j8 = ((j7 * 1000) - j6) - 1000;
                cn.jiguang.bb.f.d("GnssStatus", "count >= 3  time remaining:" + j8);
                if (j8 <= 0) {
                    return;
                }
                this.f1561a.a(j8);
                return;
            }
            if (currentTimeMillis - bVar.f1568e >= 2000) {
                bVar.f1569f = i6 + 1;
                bVar.f1568e = currentTimeMillis;
                if (f.a().b() && (a6 = this.f1561a.a(true)) != null && GeocodeSearch.GPS.equals(a6.getProvider())) {
                    Location location = this.f1561a.f1564a;
                    if (location == null || a6.distanceTo(location) >= e.f1604n) {
                        cn.jiguang.be.b.e(new Runnable() { // from class: cn.jiguang.al.a.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.f1561a.f1566c.a(a6);
                            }
                        });
                        this.f1561a.f1564a = new Location(a6);
                    }
                }
            }
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("GnssStatus", "onGnssStatus error:" + th);
        }
    }

    @Override // android.location.GnssStatus.Callback
    public void onStarted() {
        cn.jiguang.bb.f.c("GnssStatus", "onGnssStatus start");
        this.f1561a.f1567d = System.currentTimeMillis() - (e.f1603m * 1000);
    }

    a(b bVar) {
        this.f1561a = bVar;
    }
}
