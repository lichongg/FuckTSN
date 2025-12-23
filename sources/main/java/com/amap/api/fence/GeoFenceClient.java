package com.amap.api.fence;

import android.app.PendingIntent;
import android.content.Context;
import com.amap.api.col.p0003l.a;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.DPoint;
import com.autonavi.aps.amapapi.utils.b;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class GeoFenceClient {
    public static final int GEOFENCE_IN = 1;
    public static final int GEOFENCE_OUT = 2;
    public static final int GEOFENCE_STAYED = 4;

    /* renamed from: a, reason: collision with root package name */
    Context f8807a;

    /* renamed from: b, reason: collision with root package name */
    a f8808b;

    public void addGeoFence(DPoint dPoint, float f6, String str) {
        try {
            this.f8808b.o(dPoint, f6, str);
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "addGeoFence round");
        }
    }

    public void removeGeoFence() {
        try {
            this.f8808b.g();
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "removeGeoFence");
        }
    }

    private static a a(Context context) {
        return new a(context);
    }

    public PendingIntent createPendingIntent(String str) {
        try {
            return this.f8808b.d(str);
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "creatPendingIntent");
            return null;
        }
    }

    public List<GeoFence> getAllGeoFence() {
        ArrayList arrayList = new ArrayList();
        try {
            return this.f8808b.C();
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "getGeoFenceList");
            return arrayList;
        }
    }

    public boolean isPause() {
        try {
            return this.f8808b.a0();
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "isPause");
            return true;
        }
    }

    public void pauseGeoFence() {
        try {
            this.f8808b.T();
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "pauseGeoFence");
        }
    }

    public void resumeGeoFence() {
        try {
            this.f8808b.X();
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "resumeGeoFence");
        }
    }

    public void setActivateAction(int i6) {
        try {
            this.f8808b.h(i6);
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "setActivatesAction");
        }
    }

    public void setGeoFenceAble(String str, boolean z5) {
        try {
            this.f8808b.t(str, z5);
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "setGeoFenceAble");
        }
    }

    public void setGeoFenceListener(GeoFenceListener geoFenceListener) {
        try {
            this.f8808b.l(geoFenceListener);
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "setGeoFenceListener");
        }
    }

    public void setLocationClientOption(AMapLocationClientOption aMapLocationClientOption) {
        try {
            this.f8808b.n(aMapLocationClientOption);
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "setGeoFenceListener");
        }
    }

    public GeoFenceClient(Context context) {
        this.f8807a = null;
        this.f8808b = null;
        try {
            if (context != null) {
                Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                this.f8807a = origApplicationContext;
                this.f8808b = a(origApplicationContext);
                return;
            }
            throw new IllegalArgumentException("Context参数不能为null");
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "<init>");
        }
    }

    public void addGeoFence(List<DPoint> list, String str) {
        try {
            this.f8808b.u(list, str);
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "addGeoFence polygon");
        }
    }

    public boolean removeGeoFence(GeoFence geoFence) {
        try {
            return this.f8808b.w(geoFence);
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "removeGeoFence1");
            return false;
        }
    }

    public void addGeoFence(String str, String str2, DPoint dPoint, float f6, int i6, String str3) {
        try {
            this.f8808b.r(str, str2, dPoint, f6, i6, str3);
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "addGeoFence searche");
        }
    }

    public void addGeoFence(String str, String str2, String str3, int i6, String str4) {
        try {
            this.f8808b.s(str, str2, str3, i6, str4);
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "addGeoFence searche");
        }
    }

    public void addGeoFence(String str, String str2) {
        try {
            this.f8808b.q(str, str2);
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "addGeoFence district");
        }
    }
}
