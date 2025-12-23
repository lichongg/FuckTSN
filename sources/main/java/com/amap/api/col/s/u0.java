package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.cf;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IRouteSearchV2;
import com.amap.api.services.route.BusRouteResultV2;
import com.amap.api.services.route.DriveRouteResultV2;
import com.amap.api.services.route.RideRouteResultV2;
import com.amap.api.services.route.RouteSearchV2;
import com.amap.api.services.route.WalkRouteResultV2;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class u0 implements IRouteSearchV2 {

    /* renamed from: a, reason: collision with root package name */
    private RouteSearchV2.OnRouteSearchListener f8486a;

    /* renamed from: b, reason: collision with root package name */
    private Context f8487b;

    /* renamed from: c, reason: collision with root package name */
    private Handler f8488c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RouteSearchV2.DriveRouteQuery f8489a;

        a(RouteSearchV2.DriveRouteQuery driveRouteQuery) {
            this.f8489a = driveRouteQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = u4.a().obtainMessage();
            obtainMessage.what = 101;
            obtainMessage.arg1 = 101;
            Bundle bundle = new Bundle();
            DriveRouteResultV2 driveRouteResultV2 = null;
            try {
                try {
                    driveRouteResultV2 = u0.this.calculateDriveRoute(this.f8489a);
                    bundle.putInt("errorCode", 1000);
                } catch (AMapException e6) {
                    bundle.putInt("errorCode", e6.getErrorCode());
                }
            } finally {
                obtainMessage.obj = u0.this.f8486a;
                bundle.putParcelable("result", driveRouteResultV2);
                obtainMessage.setData(bundle);
                u0.this.f8488c.sendMessage(obtainMessage);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RouteSearchV2.WalkRouteQuery f8491a;

        b(RouteSearchV2.WalkRouteQuery walkRouteQuery) {
            this.f8491a = walkRouteQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = u4.a().obtainMessage();
            obtainMessage.what = 102;
            obtainMessage.arg1 = 101;
            Bundle bundle = new Bundle();
            WalkRouteResultV2 walkRouteResultV2 = null;
            try {
                try {
                    walkRouteResultV2 = u0.this.calculateWalkRoute(this.f8491a);
                    bundle.putInt("errorCode", 1000);
                } catch (AMapException e6) {
                    bundle.putInt("errorCode", e6.getErrorCode());
                }
            } finally {
                obtainMessage.obj = u0.this.f8486a;
                bundle.putParcelable("result", walkRouteResultV2);
                obtainMessage.setData(bundle);
                u0.this.f8488c.sendMessage(obtainMessage);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RouteSearchV2.RideRouteQuery f8493a;

        c(RouteSearchV2.RideRouteQuery rideRouteQuery) {
            this.f8493a = rideRouteQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = u4.a().obtainMessage();
            obtainMessage.what = 103;
            obtainMessage.arg1 = 101;
            Bundle bundle = new Bundle();
            RideRouteResultV2 rideRouteResultV2 = null;
            try {
                try {
                    rideRouteResultV2 = u0.this.calculateRideRoute(this.f8493a);
                    bundle.putInt("errorCode", 1000);
                } catch (AMapException e6) {
                    bundle.putInt("errorCode", e6.getErrorCode());
                }
            } finally {
                obtainMessage.obj = u0.this.f8486a;
                bundle.putParcelable("result", rideRouteResultV2);
                obtainMessage.setData(bundle);
                u0.this.f8488c.sendMessage(obtainMessage);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RouteSearchV2.BusRouteQuery f8495a;

        d(RouteSearchV2.BusRouteQuery busRouteQuery) {
            this.f8495a = busRouteQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = u4.a().obtainMessage();
            obtainMessage.what = 100;
            obtainMessage.arg1 = 101;
            Bundle bundle = new Bundle();
            BusRouteResultV2 busRouteResultV2 = null;
            try {
                try {
                    busRouteResultV2 = u0.this.calculateBusRoute(this.f8495a);
                    bundle.putInt("errorCode", 1000);
                } catch (AMapException e6) {
                    bundle.putInt("errorCode", e6.getErrorCode());
                }
            } finally {
                obtainMessage.obj = u0.this.f8486a;
                bundle.putParcelable("result", busRouteResultV2);
                obtainMessage.setData(bundle);
                u0.this.f8488c.sendMessage(obtainMessage);
            }
        }
    }

    private static boolean b(RouteSearchV2.FromAndTo fromAndTo) {
        return (fromAndTo == null || fromAndTo.getFrom() == null || fromAndTo.getTo() == null) ? false : true;
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public final BusRouteResultV2 calculateBusRoute(RouteSearchV2.BusRouteQuery busRouteQuery) throws AMapException {
        try {
            s4.d(this.f8487b);
            if (busRouteQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (!b(busRouteQuery.getFromAndTo())) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            RouteSearchV2.BusRouteQuery m78clone = busRouteQuery.m78clone();
            BusRouteResultV2 O = new d4(this.f8487b, m78clone).O();
            if (O == null) {
                return O;
            }
            O.setBusQuery(m78clone);
            return O;
        } catch (AMapException e6) {
            j4.i(e6, "RouteSearch", "calculateBusRoute");
            throw e6;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public final DriveRouteResultV2 calculateDriveRoute(RouteSearchV2.DriveRouteQuery driveRouteQuery) throws AMapException {
        try {
            s4.d(this.f8487b);
            if (driveRouteQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (!b(driveRouteQuery.getFromAndTo())) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            q.a();
            q.l(driveRouteQuery.getPassedByPoints());
            q.a().o(driveRouteQuery.getAvoidpolygons());
            RouteSearchV2.DriveRouteQuery m79clone = driveRouteQuery.m79clone();
            DriveRouteResultV2 O = new o4(this.f8487b, m79clone).O();
            if (O == null) {
                return O;
            }
            O.setDriveQuery(m79clone);
            return O;
        } catch (AMapException e6) {
            j4.i(e6, "RouteSearch", "calculateDriveRoute");
            throw e6;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public final RideRouteResultV2 calculateRideRoute(RouteSearchV2.RideRouteQuery rideRouteQuery) throws AMapException {
        try {
            s4.d(this.f8487b);
            if (rideRouteQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (!b(rideRouteQuery.getFromAndTo())) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            q.a().e(rideRouteQuery.getFromAndTo());
            RouteSearchV2.RideRouteQuery m81clone = rideRouteQuery.m81clone();
            RideRouteResultV2 O = new t(this.f8487b, m81clone).O();
            if (O == null) {
                return O;
            }
            O.setRideQuery(m81clone);
            return O;
        } catch (AMapException e6) {
            j4.i(e6, "RouteSearch", "calculaterideRoute");
            throw e6;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public final WalkRouteResultV2 calculateWalkRoute(RouteSearchV2.WalkRouteQuery walkRouteQuery) throws AMapException {
        try {
            s4.d(this.f8487b);
            if (walkRouteQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (!b(walkRouteQuery.getFromAndTo())) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            q.a().k(walkRouteQuery.getFromAndTo());
            RouteSearchV2.WalkRouteQuery m82clone = walkRouteQuery.m82clone();
            WalkRouteResultV2 O = new c0(this.f8487b, m82clone).O();
            if (O == null) {
                return O;
            }
            O.setWalkQuery(m82clone);
            return O;
        } catch (AMapException e6) {
            j4.i(e6, "RouteSearch", "calculateWalkRoute");
            throw e6;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public final void setRouteSearchListener(RouteSearchV2.OnRouteSearchListener onRouteSearchListener) {
        this.f8486a = onRouteSearchListener;
    }

    public u0(Context context) throws AMapException {
        h1 a6 = cf.a(context, i4.a(false));
        if (a6.f8108a == cf.c.SuccessCode) {
            this.f8487b = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f8488c = u4.a();
        } else {
            String str = a6.f8109b;
            throw new AMapException(str, 1, str, a6.f8108a.a());
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public final void calculateBusRouteAsyn(RouteSearchV2.BusRouteQuery busRouteQuery) {
        try {
            y.a().b(new d(busRouteQuery));
        } catch (Throwable th) {
            j4.i(th, "RouteSearch", "calculateBusRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public final void calculateDriveRouteAsyn(RouteSearchV2.DriveRouteQuery driveRouteQuery) {
        try {
            y.a().b(new a(driveRouteQuery));
        } catch (Throwable th) {
            j4.i(th, "RouteSearch", "calculateDriveRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public final void calculateRideRouteAsyn(RouteSearchV2.RideRouteQuery rideRouteQuery) {
        try {
            y.a().b(new c(rideRouteQuery));
        } catch (Throwable th) {
            j4.i(th, "RouteSearch", "calculateRideRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public final void calculateWalkRouteAsyn(RouteSearchV2.WalkRouteQuery walkRouteQuery) {
        try {
            y.a().b(new b(walkRouteQuery));
        } catch (Throwable th) {
            j4.i(th, "RouteSearch", "calculateWalkRouteAsyn");
        }
    }
}
