package com.amap.api.col.p0003l;

import android.content.Context;
import android.text.TextUtils;
import androidx.work.WorkRequest;
import com.amap.api.location.AMapLocation;
import com.autonavi.aps.amapapi.security.a;
import com.autonavi.aps.amapapi.storage.b;
import com.autonavi.aps.amapapi.storage.c;
import com.autonavi.aps.amapapi.utils.j;
import com.baidu.mobads.sdk.internal.by;
import com.stub.StubApp;
import java.util.List;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class t7 {

    /* renamed from: g, reason: collision with root package name */
    static b f7302g;

    /* renamed from: h, reason: collision with root package name */
    static e6 f7303h;

    /* renamed from: i, reason: collision with root package name */
    static long f7304i;

    /* renamed from: a, reason: collision with root package name */
    private Context f7305a;

    /* renamed from: b, reason: collision with root package name */
    String f7306b = null;

    /* renamed from: c, reason: collision with root package name */
    b f7307c = null;

    /* renamed from: d, reason: collision with root package name */
    b f7308d = null;

    /* renamed from: e, reason: collision with root package name */
    long f7309e = 0;

    /* renamed from: f, reason: collision with root package name */
    boolean f7310f = false;

    private void g() {
        if (f7302g == null || j.b() - f7304i > 180000) {
            b h6 = h();
            f7304i = j.b();
            if (h6 == null || !j.a(h6.a())) {
                return;
            }
            f7302g = h6;
        }
    }

    private b h() {
        Throwable th;
        b bVar;
        byte[] b6;
        byte[] b7;
        String str = null;
        if (this.f7305a == null) {
            return null;
        }
        b();
        try {
            e6 e6Var = f7303h;
            if (e6Var == null) {
                return null;
            }
            List p5 = e6Var.p("_id=1", b.class);
            if (p5 == null || p5.size() <= 0) {
                bVar = null;
            } else {
                bVar = (b) p5.get(0);
                try {
                    byte[] g6 = j4.g(bVar.c());
                    String str2 = (g6 == null || g6.length <= 0 || (b7 = a.b(g6, this.f7306b)) == null || b7.length <= 0) ? null : new String(b7, "UTF-8");
                    byte[] g7 = j4.g(bVar.b());
                    if (g7 != null && g7.length > 0 && (b6 = a.b(g7, this.f7306b)) != null && b6.length > 0) {
                        str = new String(b6, "UTF-8");
                    }
                    bVar.a(str);
                    str = str2;
                } catch (Throwable th2) {
                    th = th2;
                    com.autonavi.aps.amapapi.utils.b.a(th, "LastLocationManager", "readLastFix");
                    return bVar;
                }
            }
            if (!TextUtils.isEmpty(str)) {
                AMapLocation aMapLocation = new AMapLocation("");
                com.autonavi.aps.amapapi.utils.b.a(aMapLocation, new JSONObject(str));
                if (j.b(aMapLocation)) {
                    bVar.a(aMapLocation);
                }
            }
            return bVar;
        } catch (Throwable th3) {
            th = th3;
            bVar = null;
        }
    }

    public final AMapLocation a(AMapLocation aMapLocation, String str, long j6) {
        boolean a6;
        if (aMapLocation == null) {
            return aMapLocation;
        }
        if (aMapLocation.getErrorCode() != 0 && aMapLocation.getLocationType() != 1 && aMapLocation.getErrorCode() != 7) {
            try {
                g();
                b bVar = f7302g;
                if (bVar != null && bVar.a() != null) {
                    if (TextUtils.isEmpty(str)) {
                        long b6 = j.b() - f7302g.d();
                        a6 = b6 >= 0 && b6 <= j6;
                        aMapLocation.setTrustedLevel(3);
                    } else {
                        a6 = j.a(f7302g.b(), str);
                        aMapLocation.setTrustedLevel(2);
                    }
                    if (a6) {
                        AMapLocation a7 = f7302g.a();
                        try {
                            a7.setLocationType(9);
                            a7.setFixLastLocation(true);
                            a7.setLocationDetail(aMapLocation.getLocationDetail());
                            return a7;
                        } catch (Throwable th) {
                            th = th;
                            aMapLocation = a7;
                            com.autonavi.aps.amapapi.utils.b.a(th, "LastLocationManager", "fixLastLocation");
                            return aMapLocation;
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return aMapLocation;
    }

    public final void b() {
        if (this.f7310f) {
            return;
        }
        try {
            if (this.f7306b == null) {
                this.f7306b = a.a(by.f10823a, i4.P());
            }
            if (f7303h == null) {
                f7303h = new e6(this.f7305a, e6.c(c.class));
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "LastLocationManager", "<init>:DBOperation");
        }
        this.f7310f = true;
    }

    public final boolean c(AMapLocation aMapLocation, String str) {
        if (this.f7305a != null && aMapLocation != null && j.a(aMapLocation) && aMapLocation.getLocationType() != 2 && !aMapLocation.isMock() && !aMapLocation.isFixLastLocation()) {
            b bVar = new b();
            bVar.a(aMapLocation);
            if (aMapLocation.getLocationType() == 1) {
                bVar.a((String) null);
            } else {
                bVar.a(str);
            }
            try {
                f7302g = bVar;
                f7304i = j.b();
                this.f7307c = bVar;
                b bVar2 = this.f7308d;
                if (bVar2 != null && j.a(bVar2.a(), bVar.a()) <= 500.0f) {
                    return false;
                }
                if (j.b() - this.f7309e > WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
                    return true;
                }
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "LastLocationManager", "setLastFix");
            }
        }
        return false;
    }

    public final void f() {
        b bVar;
        String str;
        try {
            b();
            b bVar2 = this.f7307c;
            if (bVar2 != null && j.a(bVar2.a()) && f7303h != null && (bVar = this.f7307c) != this.f7308d && bVar.d() == 0) {
                String str2 = this.f7307c.a().toStr();
                String b6 = this.f7307c.b();
                this.f7308d = this.f7307c;
                if (TextUtils.isEmpty(str2)) {
                    str = null;
                } else {
                    String f6 = j4.f(a.a(str2.getBytes("UTF-8"), this.f7306b));
                    str = TextUtils.isEmpty(b6) ? null : j4.f(a.a(b6.getBytes("UTF-8"), this.f7306b));
                    r4 = f6;
                }
                if (TextUtils.isEmpty(r4)) {
                    return;
                }
                b bVar3 = new b();
                bVar3.b(r4);
                bVar3.a(j.b());
                bVar3.a(str);
                f7303h.h(bVar3, "_id=1");
                this.f7309e = j.b();
                b bVar4 = f7302g;
                if (bVar4 != null) {
                    bVar4.a(j.b());
                }
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "LastLocationManager", "saveLastFix");
        }
    }

    public t7(Context context) {
        this.f7305a = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    public final AMapLocation d() {
        g();
        b bVar = f7302g;
        if (bVar == null || !j.a(bVar.a())) {
            return null;
        }
        return f7302g.a();
    }

    public final void e() {
        try {
            f();
            this.f7309e = 0L;
            this.f7310f = false;
            this.f7307c = null;
            this.f7308d = null;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "LastLocationManager", "destroy");
        }
    }
}
