package cn.jiguang.al;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.GnssStatus;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.telephony.CellInfo;
import android.telephony.NeighboringCellInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import cn.jiguang.bz.q;
import cn.jiguang.bz.t;
import cn.jiguang.bz.x;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.umeng.socialize.common.SocializeConstants;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    protected Location f1564a;

    /* renamed from: b, reason: collision with root package name */
    public Context f1565b;

    /* renamed from: c, reason: collision with root package name */
    public h f1566c;

    /* renamed from: d, reason: collision with root package name */
    public long f1567d = 0;

    /* renamed from: e, reason: collision with root package name */
    public long f1568e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f1569f = 0;

    /* renamed from: g, reason: collision with root package name */
    private LocationManager f1570g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f1571h;

    /* renamed from: i, reason: collision with root package name */
    private GpsStatus.Listener f1572i;

    /* renamed from: j, reason: collision with root package name */
    private GnssStatus.Callback f1573j;

    @SuppressLint({"MissingPermission"})
    private boolean c() {
        LocationManager locationManager;
        try {
            if (!d() || (locationManager = this.f1570g) == null) {
                return false;
            }
            if (!locationManager.isProviderEnabled(GeocodeSearch.GPS) && !this.f1570g.isProviderEnabled("network")) {
                if (!this.f1570g.isProviderEnabled("passive")) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private boolean d() {
        return q.a(this.f1565b, com.kuaishou.weapon.p0.g.f36047g) && q.a(this.f1565b, com.kuaishou.weapon.p0.g.f36048h) && a(this.f1565b, com.kuaishou.weapon.p0.g.f36047g) && a(this.f1565b, com.kuaishou.weapon.p0.g.f36048h);
    }

    @SuppressLint({"MissingPermission"})
    protected Location a(boolean z5) {
        LocationManager locationManager;
        String str;
        try {
            if (this.f1570g != null && c()) {
                if (z5) {
                    locationManager = this.f1570g;
                    str = GeocodeSearch.GPS;
                } else {
                    locationManager = this.f1570g;
                    str = "network";
                }
                return locationManager.getLastKnownLocation(str);
            }
            return null;
        } catch (Throwable th) {
            cn.jiguang.bb.f.c("CellHelper", "getLocation error:" + th);
            return null;
        }
    }

    public void b() {
        try {
            List<d> e6 = e();
            if (e6 != null) {
                this.f1566c.a(e6);
            } else {
                cn.jiguang.an.a.a(this.f1565b, "loc_info_v2", "c", -6);
            }
        } catch (Throwable th) {
            cn.jiguang.an.a.a(this.f1565b, "loc_info_v2", "c", -1);
            cn.jiguang.bb.f.i("CellHelper", "startScanCell error:" + th);
        }
    }

    @SuppressLint({"MissingPermission"})
    public b(Context context) {
        this.f1565b = cn.jiguang.bz.d.a(context);
        this.f1570g = (LocationManager) context.getSystemService(SocializeConstants.KEY_LOCATION);
        if (a(context)) {
            this.f1573j = new a(this);
        } else {
            this.f1572i = new c(this);
        }
    }

    @SuppressLint({"MissingPermission"})
    private List<d> e() {
        d a6;
        List<NeighboringCellInfo> list = null;
        if (!c()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        TelephonyManager telephonyManager = (TelephonyManager) this.f1565b.getSystemService("phone");
        String a7 = x.a(this.f1565b, false);
        try {
            if (Build.VERSION.SDK_INT < 31) {
                list = (List) t.a(telephonyManager, "getNeighboringCellInfo", (Object[]) null, (Class[]) null);
            }
        } catch (Throwable th) {
            cn.jiguang.bb.f.c("CellHelper", "getNeighborCell error:" + th.getMessage());
        }
        StringBuilder sb = new StringBuilder();
        if (list != null && !list.isEmpty()) {
            for (NeighboringCellInfo neighboringCellInfo : list) {
                if (neighboringCellInfo != null) {
                    if (sb.length() > 0) {
                        sb.append(",");
                    }
                    sb.append(neighboringCellInfo.getCid());
                }
            }
        }
        String b6 = x.b(this.f1565b, false);
        for (CellInfo cellInfo : telephonyManager.getAllCellInfo()) {
            if (cellInfo != null && (a6 = cn.jiguang.bz.c.a(cellInfo)) != null) {
                if (TextUtils.equals(a6.f1585f, a7)) {
                    a6.f1586g = b6;
                }
                a6.f1590k = list;
                arrayList.add(a6);
            }
        }
        return arrayList;
    }

    @SuppressLint({"MissingPermission"})
    public void a() {
        String str;
        try {
            if (this.f1571h) {
                str = "g is on listening";
            } else {
                boolean b6 = f.a().b();
                boolean c6 = c();
                cn.jiguang.bb.f.c("CellHelper", " init checkSafeStatus = " + b6 + " , deviceEnv=" + c6);
                if (!b6) {
                    cn.jiguang.an.a.a(this.f1565b, "loc_info_v2", "g", 2);
                }
                if (!c6) {
                    cn.jiguang.an.a.a(this.f1565b, "loc_info_v2", "g", -6);
                }
                if (!b6 || this.f1570g == null || !c6) {
                    return;
                }
                new Handler(Looper.getMainLooper()).post(new cn.jiguang.by.b() { // from class: cn.jiguang.al.b.1
                    @Override // cn.jiguang.by.b
                    public void a() {
                        try {
                            b bVar = b.this;
                            if (bVar.a(bVar.f1565b)) {
                                b.this.f1570g.registerGnssStatusCallback(b.this.f1573j);
                            } else {
                                b.this.f1570g.addGpsStatusListener(b.this.f1572i);
                            }
                        } catch (Throwable th) {
                            cn.jiguang.bb.f.i("CellHelper", "addGpsStatusListener error:" + th);
                        }
                    }
                });
                this.f1571h = true;
                str = "g is start listening";
            }
            cn.jiguang.bb.f.c("CellHelper", str);
        } catch (Throwable th) {
            cn.jiguang.bb.f.c("CellHelper", "init error:" + th);
            this.f1571h = false;
        }
    }

    @SuppressLint({"MissingPermission"})
    public void a(long j6) {
        if (this.f1571h) {
            Handler handler = new Handler(Looper.getMainLooper());
            handler.post(new cn.jiguang.by.b() { // from class: cn.jiguang.al.b.2
                @Override // cn.jiguang.by.b
                public void a() {
                    try {
                        b bVar = b.this;
                        if (bVar.a(bVar.f1565b)) {
                            b.this.f1570g.unregisterGnssStatusCallback(b.this.f1573j);
                        }
                    } catch (Throwable th) {
                        cn.jiguang.bb.f.i("CellHelper", "unregisterGnssStatusCallback error:" + th);
                    }
                }
            });
            handler.postDelayed(new cn.jiguang.by.b() { // from class: cn.jiguang.al.b.3
                @Override // cn.jiguang.by.b
                public void a() {
                    try {
                        b bVar = b.this;
                        if (bVar.a(bVar.f1565b)) {
                            b.this.f1570g.registerGnssStatusCallback(b.this.f1573j);
                        }
                    } catch (Throwable th) {
                        cn.jiguang.bb.f.i("CellHelper", "registerGnssStatusCallback error:" + th);
                    }
                }
            }, j6);
        }
    }

    public void a(h hVar) {
        this.f1566c = hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Context context) {
        return Build.VERSION.SDK_INT >= 24 && context.getApplicationInfo().targetSdkVersion >= 31;
    }

    private boolean a(Context context, String str) {
        try {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (Throwable unused) {
            return false;
        }
    }
}
