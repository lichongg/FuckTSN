package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.cf;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IRouteSearch;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.DriveRoutePlanResult;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.TruckRouteRestult;
import com.amap.api.services.route.WalkRouteResult;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class t0 implements IRouteSearch {

    /* renamed from: a, reason: collision with root package name */
    private RouteSearch.OnRouteSearchListener f8460a;

    /* renamed from: b, reason: collision with root package name */
    private RouteSearch.OnTruckRouteSearchListener f8461b;

    /* renamed from: c, reason: collision with root package name */
    private RouteSearch.OnRoutePlanSearchListener f8462c;

    /* renamed from: d, reason: collision with root package name */
    private Context f8463d;

    /* renamed from: e, reason: collision with root package name */
    private Handler f8464e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RouteSearch.WalkRouteQuery f8465a;

        a(RouteSearch.WalkRouteQuery walkRouteQuery) {
            this.f8465a = walkRouteQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = u4.a().obtainMessage();
            obtainMessage.what = 102;
            obtainMessage.arg1 = 1;
            Bundle bundle = new Bundle();
            WalkRouteResult walkRouteResult = null;
            try {
                try {
                    walkRouteResult = t0.this.calculateWalkRoute(this.f8465a);
                    bundle.putInt("errorCode", 1000);
                } catch (AMapException e6) {
                    bundle.putInt("errorCode", e6.getErrorCode());
                }
            } finally {
                obtainMessage.obj = t0.this.f8460a;
                bundle.putParcelable("result", walkRouteResult);
                obtainMessage.setData(bundle);
                t0.this.f8464e.sendMessage(obtainMessage);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RouteSearch.BusRouteQuery f8467a;

        b(RouteSearch.BusRouteQuery busRouteQuery) {
            this.f8467a = busRouteQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = u4.a().obtainMessage();
            obtainMessage.what = 100;
            obtainMessage.arg1 = 1;
            Bundle bundle = new Bundle();
            BusRouteResult busRouteResult = null;
            try {
                try {
                    busRouteResult = t0.this.calculateBusRoute(this.f8467a);
                    bundle.putInt("errorCode", 1000);
                } catch (AMapException e6) {
                    bundle.putInt("errorCode", e6.getErrorCode());
                }
            } finally {
                obtainMessage.obj = t0.this.f8460a;
                bundle.putParcelable("result", busRouteResult);
                obtainMessage.setData(bundle);
                t0.this.f8464e.sendMessage(obtainMessage);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RouteSearch.DriveRouteQuery f8469a;

        c(RouteSearch.DriveRouteQuery driveRouteQuery) {
            this.f8469a = driveRouteQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = u4.a().obtainMessage();
            obtainMessage.what = 101;
            obtainMessage.arg1 = 1;
            Bundle bundle = new Bundle();
            DriveRouteResult driveRouteResult = null;
            try {
                try {
                    driveRouteResult = t0.this.calculateDriveRoute(this.f8469a);
                    bundle.putInt("errorCode", 1000);
                } catch (AMapException e6) {
                    bundle.putInt("errorCode", e6.getErrorCode());
                }
            } finally {
                obtainMessage.obj = t0.this.f8460a;
                bundle.putParcelable("result", driveRouteResult);
                obtainMessage.setData(bundle);
                t0.this.f8464e.sendMessage(obtainMessage);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RouteSearch.RideRouteQuery f8471a;

        d(RouteSearch.RideRouteQuery rideRouteQuery) {
            this.f8471a = rideRouteQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = u4.a().obtainMessage();
            obtainMessage.what = 103;
            obtainMessage.arg1 = 1;
            Bundle bundle = new Bundle();
            RideRouteResult rideRouteResult = null;
            try {
                try {
                    rideRouteResult = t0.this.calculateRideRoute(this.f8471a);
                    bundle.putInt("errorCode", 1000);
                } catch (AMapException e6) {
                    bundle.putInt("errorCode", e6.getErrorCode());
                }
            } finally {
                obtainMessage.obj = t0.this.f8460a;
                bundle.putParcelable("result", rideRouteResult);
                obtainMessage.setData(bundle);
                t0.this.f8464e.sendMessage(obtainMessage);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RouteSearch.TruckRouteQuery f8473a;

        e(RouteSearch.TruckRouteQuery truckRouteQuery) {
            this.f8473a = truckRouteQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = u4.a().obtainMessage();
            obtainMessage.what = 104;
            obtainMessage.arg1 = 17;
            Bundle bundle = new Bundle();
            TruckRouteRestult truckRouteRestult = null;
            try {
                try {
                    truckRouteRestult = t0.this.calculateTruckRoute(this.f8473a);
                    bundle.putInt("errorCode", 1000);
                } catch (AMapException e6) {
                    bundle.putInt("errorCode", e6.getErrorCode());
                }
            } finally {
                obtainMessage.obj = t0.this.f8461b;
                bundle.putParcelable("result", truckRouteRestult);
                obtainMessage.setData(bundle);
                t0.this.f8464e.sendMessage(obtainMessage);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RouteSearch.DrivePlanQuery f8475a;

        f(RouteSearch.DrivePlanQuery drivePlanQuery) {
            this.f8475a = drivePlanQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = u4.a().obtainMessage();
            obtainMessage.what = 105;
            obtainMessage.arg1 = 18;
            Bundle bundle = new Bundle();
            DriveRoutePlanResult driveRoutePlanResult = null;
            try {
                try {
                    driveRoutePlanResult = t0.this.calculateDrivePlan(this.f8475a);
                    bundle.putInt("errorCode", 1000);
                } catch (AMapException e6) {
                    bundle.putInt("errorCode", e6.getErrorCode());
                }
            } finally {
                obtainMessage.obj = t0.this.f8462c;
                bundle.putParcelable("result", driveRoutePlanResult);
                obtainMessage.setData(bundle);
                t0.this.f8464e.sendMessage(obtainMessage);
            }
        }
    }

    private static boolean b(RouteSearch.FromAndTo fromAndTo) {
        return (fromAndTo == null || fromAndTo.getFrom() == null || fromAndTo.getTo() == null) ? false : true;
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final BusRouteResult calculateBusRoute(RouteSearch.BusRouteQuery busRouteQuery) throws AMapException {
        try {
            s4.d(this.f8463d);
            if (busRouteQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (!b(busRouteQuery.getFromAndTo())) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            RouteSearch.BusRouteQuery m71clone = busRouteQuery.m71clone();
            BusRouteResult O = new c4(this.f8463d, m71clone).O();
            if (O == null) {
                return O;
            }
            O.setBusQuery(m71clone);
            return O;
        } catch (AMapException e6) {
            j4.i(e6, "RouteSearch", "calculateBusRoute");
            throw e6;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final DriveRoutePlanResult calculateDrivePlan(RouteSearch.DrivePlanQuery drivePlanQuery) throws AMapException {
        try {
            s4.d(this.f8463d);
            if (drivePlanQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (!b(drivePlanQuery.getFromAndTo())) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            DriveRoutePlanResult O = new m4(this.f8463d, drivePlanQuery.m72clone()).O();
            if (O == null) {
                return O;
            }
            O.setDrivePlanQuery(drivePlanQuery);
            return O;
        } catch (AMapException e6) {
            j4.i(e6, "RouteSearch", "calculateDrivePlan");
            throw e6;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final DriveRouteResult calculateDriveRoute(RouteSearch.DriveRouteQuery driveRouteQuery) throws AMapException {
        try {
            s4.d(this.f8463d);
            if (driveRouteQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (!b(driveRouteQuery.getFromAndTo())) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            q.a().g(driveRouteQuery.getPassedByPoints());
            q.a().o(driveRouteQuery.getAvoidpolygons());
            RouteSearch.DriveRouteQuery m73clone = driveRouteQuery.m73clone();
            DriveRouteResult O = new n4(this.f8463d, m73clone).O();
            if (O == null) {
                return O;
            }
            O.setDriveQuery(m73clone);
            return O;
        } catch (AMapException e6) {
            j4.i(e6, "RouteSearch", "calculateDriveRoute");
            throw e6;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final RideRouteResult calculateRideRoute(RouteSearch.RideRouteQuery rideRouteQuery) throws AMapException {
        try {
            s4.d(this.f8463d);
            if (rideRouteQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (!b(rideRouteQuery.getFromAndTo())) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            q.a().c(rideRouteQuery.getFromAndTo());
            RouteSearch.RideRouteQuery m75clone = rideRouteQuery.m75clone();
            RideRouteResult O = new s(this.f8463d, m75clone).O();
            if (O == null) {
                return O;
            }
            O.setRideQuery(m75clone);
            return O;
        } catch (AMapException e6) {
            j4.i(e6, "RouteSearch", "calculaterideRoute");
            throw e6;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final TruckRouteRestult calculateTruckRoute(RouteSearch.TruckRouteQuery truckRouteQuery) throws AMapException {
        try {
            s4.d(this.f8463d);
            if (truckRouteQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (!b(truckRouteQuery.getFromAndTo())) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            q.a().d(truckRouteQuery.getFromAndTo(), truckRouteQuery.getPassedByPoints());
            q.a();
            q.l(truckRouteQuery.getPassedByPoints());
            RouteSearch.TruckRouteQuery m76clone = truckRouteQuery.m76clone();
            TruckRouteRestult O = new z(this.f8463d, m76clone).O();
            if (O == null) {
                return O;
            }
            O.setTruckQuery(m76clone);
            return O;
        } catch (AMapException e6) {
            j4.i(e6, "RouteSearch", "calculateDriveRoute");
            throw e6;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final WalkRouteResult calculateWalkRoute(RouteSearch.WalkRouteQuery walkRouteQuery) throws AMapException {
        try {
            s4.d(this.f8463d);
            if (walkRouteQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (!b(walkRouteQuery.getFromAndTo())) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            q.a().j(walkRouteQuery.getFromAndTo());
            RouteSearch.WalkRouteQuery m77clone = walkRouteQuery.m77clone();
            WalkRouteResult O = new a0(this.f8463d, m77clone).O();
            if (O == null) {
                return O;
            }
            O.setWalkQuery(m77clone);
            return O;
        } catch (AMapException e6) {
            j4.i(e6, "RouteSearch", "calculateWalkRoute");
            throw e6;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void setOnRoutePlanSearchListener(RouteSearch.OnRoutePlanSearchListener onRoutePlanSearchListener) {
        this.f8462c = onRoutePlanSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void setOnTruckRouteSearchListener(RouteSearch.OnTruckRouteSearchListener onTruckRouteSearchListener) {
        this.f8461b = onTruckRouteSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void setRouteSearchListener(RouteSearch.OnRouteSearchListener onRouteSearchListener) {
        this.f8460a = onRouteSearchListener;
    }

    public t0(Context context) throws AMapException {
        h1 a6 = cf.a(context, i4.a(false));
        if (a6.f8108a == cf.c.SuccessCode) {
            this.f8463d = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f8464e = u4.a();
        } else {
            String str = a6.f8109b;
            throw new AMapException(str, 1, str, a6.f8108a.a());
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void calculateBusRouteAsyn(RouteSearch.BusRouteQuery busRouteQuery) {
        try {
            y.a().b(new b(busRouteQuery));
        } catch (Throwable th) {
            j4.i(th, "RouteSearch", "calculateBusRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void calculateDrivePlanAsyn(RouteSearch.DrivePlanQuery drivePlanQuery) {
        try {
            y.a().b(new f(drivePlanQuery));
        } catch (Throwable th) {
            j4.i(th, "RouteSearch", "calculateTruckRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void calculateDriveRouteAsyn(RouteSearch.DriveRouteQuery driveRouteQuery) {
        try {
            y.a().b(new c(driveRouteQuery));
        } catch (Throwable th) {
            j4.i(th, "RouteSearch", "calculateDriveRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void calculateRideRouteAsyn(RouteSearch.RideRouteQuery rideRouteQuery) {
        try {
            y.a().b(new d(rideRouteQuery));
        } catch (Throwable th) {
            j4.i(th, "RouteSearch", "calculateRideRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void calculateTruckRouteAsyn(RouteSearch.TruckRouteQuery truckRouteQuery) {
        try {
            y.a().b(new e(truckRouteQuery));
        } catch (Throwable th) {
            j4.i(th, "RouteSearch", "calculateTruckRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void calculateWalkRouteAsyn(RouteSearch.WalkRouteQuery walkRouteQuery) {
        try {
            y.a().b(new a(walkRouteQuery));
        } catch (Throwable th) {
            j4.i(th, "RouteSearch", "calculateWalkRouteAsyn");
        }
    }
}
