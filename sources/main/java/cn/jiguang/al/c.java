package cn.jiguang.al;

import android.location.GpsStatus;
import android.location.Location;
import com.amap.api.services.geocoder.GeocodeSearch;

/* loaded from: D:\Downloads\app\classes2.dex */
class c implements GpsStatus.Listener {

    /* renamed from: a, reason: collision with root package name */
    private b f1577a;

    @Override // android.location.GpsStatus.Listener
    public void onGpsStatusChanged(int i6) {
        final Location a6;
        if (i6 == 1) {
            cn.jiguang.bb.f.c("GpsStatuListener", "onGpsStatus start");
            this.f1577a.f1567d = System.currentTimeMillis() - (e.f1603m * 1000);
            return;
        }
        if (i6 != 4) {
            return;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            b bVar = this.f1577a;
            if (currentTimeMillis - bVar.f1567d > e.f1603m * 1000) {
                bVar.f1567d = currentTimeMillis;
                bVar.f1569f = 0;
            }
            int i7 = bVar.f1569f;
            if (i7 >= 3 || currentTimeMillis - bVar.f1568e < 2000) {
                return;
            }
            bVar.f1569f = i7 + 1;
            bVar.f1568e = currentTimeMillis;
            if (f.a().b() && (a6 = this.f1577a.a(true)) != null && GeocodeSearch.GPS.equals(a6.getProvider())) {
                Location location = this.f1577a.f1564a;
                if (location == null || a6.distanceTo(location) >= e.f1604n) {
                    cn.jiguang.be.b.e(new Runnable() { // from class: cn.jiguang.al.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.f1577a.f1566c.a(a6);
                        }
                    });
                    this.f1577a.f1564a = new Location(a6);
                }
            }
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("GpsStatuListener", "onGpsStatus error:" + th);
        }
    }

    c(b bVar) {
        this.f1577a = bVar;
    }
}
