package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.cf;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IDistanceSearch;
import com.amap.api.services.route.DistanceResult;
import com.amap.api.services.route.DistanceSearch;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class l0 implements IDistanceSearch {

    /* renamed from: d, reason: collision with root package name */
    private static final String f8219d = "l0";

    /* renamed from: a, reason: collision with root package name */
    private Context f8220a;

    /* renamed from: b, reason: collision with root package name */
    private Handler f8221b;

    /* renamed from: c, reason: collision with root package name */
    private DistanceSearch.OnDistanceSearchListener f8222c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ DistanceSearch.DistanceQuery f8223a;

        a(DistanceSearch.DistanceQuery distanceQuery) {
            this.f8223a = distanceQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = u4.a().obtainMessage();
            obtainMessage.what = 400;
            obtainMessage.arg1 = 16;
            Bundle bundle = new Bundle();
            DistanceResult distanceResult = null;
            try {
                try {
                    distanceResult = l0.this.calculateRouteDistance(this.f8223a);
                    bundle.putInt("errorCode", 1000);
                } catch (AMapException e6) {
                    bundle.putInt("errorCode", e6.getErrorCode());
                }
            } finally {
                obtainMessage.obj = l0.this.f8222c;
                bundle.putParcelable("result", distanceResult);
                obtainMessage.setData(bundle);
                l0.this.f8221b.sendMessage(obtainMessage);
            }
        }
    }

    @Override // com.amap.api.services.interfaces.IDistanceSearch
    public DistanceResult calculateRouteDistance(DistanceSearch.DistanceQuery distanceQuery) throws AMapException {
        try {
            s4.d(this.f8220a);
            if (distanceQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (b(distanceQuery)) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            DistanceSearch.DistanceQuery m70clone = distanceQuery.m70clone();
            DistanceResult O = new k4(this.f8220a, m70clone).O();
            if (O == null) {
                return O;
            }
            O.setDistanceQuery(m70clone);
            return O;
        } catch (AMapException e6) {
            j4.i(e6, f8219d, "calculateWalkRoute");
            throw e6;
        }
    }

    @Override // com.amap.api.services.interfaces.IDistanceSearch
    public void setDistanceSearchListener(DistanceSearch.OnDistanceSearchListener onDistanceSearchListener) {
        this.f8222c = onDistanceSearchListener;
    }

    public l0(Context context) throws AMapException {
        h1 a6 = cf.a(context, i4.a(false));
        if (a6.f8108a == cf.c.SuccessCode) {
            this.f8220a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f8221b = u4.a();
        } else {
            String str = a6.f8109b;
            throw new AMapException(str, 1, str, a6.f8108a.a());
        }
    }

    private static boolean b(DistanceSearch.DistanceQuery distanceQuery) {
        if (distanceQuery.getDestination() == null || distanceQuery.getOrigins() == null || distanceQuery.getOrigins().size() <= 0) {
            return true;
        }
        return false;
    }

    @Override // com.amap.api.services.interfaces.IDistanceSearch
    public void calculateRouteDistanceAsyn(DistanceSearch.DistanceQuery distanceQuery) {
        y.a().b(new a(distanceQuery));
    }
}
