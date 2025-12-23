package com.amap.api.col.s;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.cf;
import com.amap.api.col.s.u4;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.GeocodeQuery;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.amap.api.services.interfaces.IGeocodeSearch;
import com.stub.StubApp;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class n0 implements IGeocodeSearch {

    /* renamed from: a, reason: collision with root package name */
    private Context f8264a;

    /* renamed from: b, reason: collision with root package name */
    private GeocodeSearch.OnGeocodeSearchListener f8265b;

    /* renamed from: c, reason: collision with root package name */
    private Handler f8266c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RegeocodeQuery f8267a;

        a(RegeocodeQuery regeocodeQuery) {
            this.f8267a = regeocodeQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = u4.a().obtainMessage();
            try {
                try {
                    obtainMessage.arg1 = 2;
                    obtainMessage.what = 201;
                    u4.l lVar = new u4.l();
                    lVar.f8541b = n0.this.f8265b;
                    obtainMessage.obj = lVar;
                    lVar.f8540a = new RegeocodeResult(this.f8267a, n0.this.getFromLocation(this.f8267a));
                    obtainMessage.arg2 = 1000;
                } catch (AMapException e6) {
                    obtainMessage.arg2 = e6.getErrorCode();
                }
            } finally {
                n0.this.f8266c.sendMessage(obtainMessage);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GeocodeQuery f8269a;

        b(GeocodeQuery geocodeQuery) {
            this.f8269a = geocodeQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = u4.a().obtainMessage();
            try {
                try {
                    obtainMessage.what = 200;
                    obtainMessage.arg1 = 2;
                    obtainMessage.arg2 = 1000;
                    u4.f fVar = new u4.f();
                    fVar.f8529b = n0.this.f8265b;
                    obtainMessage.obj = fVar;
                    fVar.f8528a = new GeocodeResult(this.f8269a, n0.this.getFromLocationName(this.f8269a));
                } catch (AMapException e6) {
                    obtainMessage.arg2 = e6.getErrorCode();
                }
            } finally {
                n0.this.f8266c.sendMessage(obtainMessage);
            }
        }
    }

    private static boolean b(RegeocodeQuery regeocodeQuery) {
        return (regeocodeQuery == null || regeocodeQuery.getPoint() == null || regeocodeQuery.getLatLonType() == null) ? false : true;
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public final RegeocodeAddress getFromLocation(RegeocodeQuery regeocodeQuery) throws AMapException {
        try {
            s4.d(this.f8264a);
            if (b(regeocodeQuery)) {
                return new r(this.f8264a, regeocodeQuery).O();
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e6) {
            j4.i(e6, "GeocodeSearch", "getFromLocationAsyn");
            throw e6;
        }
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public final List<GeocodeAddress> getFromLocationName(GeocodeQuery geocodeQuery) throws AMapException {
        try {
            s4.d(this.f8264a);
            if (geocodeQuery != null) {
                return new p4(this.f8264a, geocodeQuery).O();
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e6) {
            j4.i(e6, "GeocodeSearch", "getFromLocationName");
            throw e6;
        }
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public final void setOnGeocodeSearchListener(GeocodeSearch.OnGeocodeSearchListener onGeocodeSearchListener) {
        this.f8265b = onGeocodeSearchListener;
    }

    public n0(Context context) throws AMapException {
        h1 a6 = cf.a(context, i4.a(false));
        if (a6.f8108a == cf.c.SuccessCode) {
            this.f8264a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f8266c = u4.a();
        } else {
            String str = a6.f8109b;
            throw new AMapException(str, 1, str, a6.f8108a.a());
        }
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public final void getFromLocationAsyn(RegeocodeQuery regeocodeQuery) {
        try {
            y.a().b(new a(regeocodeQuery));
        } catch (Throwable th) {
            j4.i(th, "GeocodeSearch", "getFromLocationAsyn_threadcreate");
        }
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public final void getFromLocationNameAsyn(GeocodeQuery geocodeQuery) {
        try {
            y.a().b(new b(geocodeQuery));
        } catch (Throwable th) {
            j4.i(th, "GeocodeSearch", "getFromLocationNameAsynThrowable");
        }
    }
}
