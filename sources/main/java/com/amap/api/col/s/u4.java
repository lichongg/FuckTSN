package com.amap.api.col.s;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.services.auto.AutoTChargeStationResult;
import com.amap.api.services.auto.AutoTSearch;
import com.amap.api.services.busline.BusLineResult;
import com.amap.api.services.busline.BusLineSearch;
import com.amap.api.services.busline.BusStationResult;
import com.amap.api.services.busline.BusStationSearch;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.cloud.CloudResult;
import com.amap.api.services.cloud.CloudSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.PoiItemV2;
import com.amap.api.services.district.DistrictResult;
import com.amap.api.services.district.DistrictSearch;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.amap.api.services.help.Inputtips;
import com.amap.api.services.nearby.NearbySearch;
import com.amap.api.services.nearby.NearbySearchResult;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiResultV2;
import com.amap.api.services.poisearch.PoiSearch;
import com.amap.api.services.poisearch.PoiSearchV2;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.BusRouteResultV2;
import com.amap.api.services.route.DistanceResult;
import com.amap.api.services.route.DistanceSearch;
import com.amap.api.services.route.DriveRoutePlanResult;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.DriveRouteResultV2;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RideRouteResultV2;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.RouteSearchV2;
import com.amap.api.services.route.TruckRouteRestult;
import com.amap.api.services.route.WalkRouteResult;
import com.amap.api.services.route.WalkRouteResultV2;
import com.amap.api.services.routepoisearch.RoutePOISearch;
import com.amap.api.services.routepoisearch.RoutePOISearchResult;
import com.amap.api.services.share.ShareSearch;
import com.amap.api.services.weather.LocalWeatherForecastResult;
import com.amap.api.services.weather.LocalWeatherLiveResult;
import com.amap.api.services.weather.WeatherSearch;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class u4 extends Handler {

    /* renamed from: a, reason: collision with root package name */
    private static u4 f8517a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public AutoTChargeStationResult f8518a;

        /* renamed from: b, reason: collision with root package name */
        public AutoTSearch.OnChargeStationListener f8519b;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public BusLineResult f8520a;

        /* renamed from: b, reason: collision with root package name */
        public BusLineSearch.OnBusLineSearchListener f8521b;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public BusStationResult f8522a;

        /* renamed from: b, reason: collision with root package name */
        public BusStationSearch.OnBusStationSearchListener f8523b;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public CloudItemDetail f8524a;

        /* renamed from: b, reason: collision with root package name */
        public CloudSearch.OnCloudSearchListener f8525b;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public CloudResult f8526a;

        /* renamed from: b, reason: collision with root package name */
        public CloudSearch.OnCloudSearchListener f8527b;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public GeocodeResult f8528a;

        /* renamed from: b, reason: collision with root package name */
        public GeocodeSearch.OnGeocodeSearchListener f8529b;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        public List<NearbySearch.NearbyListener> f8530a;

        /* renamed from: b, reason: collision with root package name */
        public NearbySearchResult f8531b;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class h {

        /* renamed from: a, reason: collision with root package name */
        public PoiItem f8532a;

        /* renamed from: b, reason: collision with root package name */
        public PoiSearch.OnPoiSearchListener f8533b;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class i {

        /* renamed from: a, reason: collision with root package name */
        public PoiItemV2 f8534a;

        /* renamed from: b, reason: collision with root package name */
        public PoiSearchV2.OnPoiSearchListener f8535b;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class j {

        /* renamed from: a, reason: collision with root package name */
        public PoiResult f8536a;

        /* renamed from: b, reason: collision with root package name */
        public PoiSearch.OnPoiSearchListener f8537b;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class k {

        /* renamed from: a, reason: collision with root package name */
        public PoiResultV2 f8538a;

        /* renamed from: b, reason: collision with root package name */
        public PoiSearchV2.OnPoiSearchListener f8539b;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class l {

        /* renamed from: a, reason: collision with root package name */
        public RegeocodeResult f8540a;

        /* renamed from: b, reason: collision with root package name */
        public GeocodeSearch.OnGeocodeSearchListener f8541b;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class m {

        /* renamed from: a, reason: collision with root package name */
        public RoutePOISearchResult f8542a;

        /* renamed from: b, reason: collision with root package name */
        public RoutePOISearch.OnRoutePOISearchListener f8543b;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class n {

        /* renamed from: a, reason: collision with root package name */
        public LocalWeatherForecastResult f8544a;

        /* renamed from: b, reason: collision with root package name */
        public WeatherSearch.OnWeatherSearchListener f8545b;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class o {

        /* renamed from: a, reason: collision with root package name */
        public LocalWeatherLiveResult f8546a;

        /* renamed from: b, reason: collision with root package name */
        public WeatherSearch.OnWeatherSearchListener f8547b;
    }

    u4() {
    }

    private u4(Looper looper) {
        super(looper);
    }

    public static synchronized u4 a() {
        u4 u4Var;
        synchronized (u4.class) {
            try {
                if (f8517a == null) {
                    if (Looper.myLooper() != null && Looper.myLooper() == Looper.getMainLooper()) {
                        f8517a = new u4();
                    }
                    f8517a = new u4(Looper.getMainLooper());
                }
                u4Var = f8517a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return u4Var;
    }

    private static void b(Message message) {
        int i6 = message.arg2;
        ShareSearch.OnShareSearchListener onShareSearchListener = (ShareSearch.OnShareSearchListener) message.obj;
        String string = message.getData().getString("shareurlkey");
        if (onShareSearchListener == null) {
            return;
        }
        switch (message.what) {
            case 1100:
                onShareSearchListener.onPoiShareUrlSearched(string, i6);
                break;
            case AMapException.CODE_AMAP_ENGINE_RESPONSE_DATA_ERROR /* 1101 */:
                onShareSearchListener.onLocationShareUrlSearched(string, i6);
                break;
            case AMapException.CODE_AMAP_ENGINE_CONNECT_TIMEOUT /* 1102 */:
                onShareSearchListener.onNaviShareUrlSearched(string, i6);
                break;
            case AMapException.CODE_AMAP_ENGINE_RETURN_TIMEOUT /* 1103 */:
                onShareSearchListener.onBusRouteShareUrlSearched(string, i6);
                break;
            case 1104:
                onShareSearchListener.onDrivingRouteShareUrlSearched(string, i6);
                break;
            case 1105:
                onShareSearchListener.onWalkRouteShareUrlSearched(string, i6);
                break;
        }
    }

    private static void c(Message message) {
        List list = (List) message.obj;
        if (list == null || list.size() == 0) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((NearbySearch.NearbyListener) it.next()).onNearbyInfoUploaded(message.what);
        }
    }

    private static void d(Message message) {
        List<NearbySearch.NearbyListener> list;
        g gVar = (g) message.obj;
        if (gVar == null || (list = gVar.f8530a) == null || list.size() == 0) {
            return;
        }
        NearbySearchResult nearbySearchResult = message.what == 1000 ? gVar.f8531b : null;
        Iterator<NearbySearch.NearbyListener> it = list.iterator();
        while (it.hasNext()) {
            it.next().onNearbyInfoSearched(nearbySearchResult, message.what);
        }
    }

    private static void e(Message message) {
        List list = (List) message.obj;
        if (list == null || list.size() == 0) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((NearbySearch.NearbyListener) it.next()).onUserInfoCleared(message.what);
        }
    }

    private static void f(Message message) {
        BusStationSearch.OnBusStationSearchListener onBusStationSearchListener;
        c cVar = (c) message.obj;
        if (cVar == null || (onBusStationSearchListener = cVar.f8523b) == null) {
            return;
        }
        int i6 = message.what;
        onBusStationSearchListener.onBusStationSearched(i6 == 1000 ? cVar.f8522a : null, i6);
    }

    private static void g(Message message) {
        h hVar;
        PoiSearch.OnPoiSearchListener onPoiSearchListener;
        Bundle data;
        int i6 = message.what;
        if (i6 == 600) {
            j jVar = (j) message.obj;
            if (jVar == null || (onPoiSearchListener = jVar.f8537b) == null || (data = message.getData()) == null) {
                return;
            }
            onPoiSearchListener.onPoiSearched(jVar.f8536a, data.getInt("errorCode"));
            return;
        }
        if (i6 != 602 || (hVar = (h) message.obj) == null) {
            return;
        }
        PoiSearch.OnPoiSearchListener onPoiSearchListener2 = hVar.f8533b;
        Bundle data2 = message.getData();
        if (data2 != null) {
            onPoiSearchListener2.onPoiItemSearched(hVar.f8532a, data2.getInt("errorCode"));
        }
    }

    private static void h(Message message) {
        i iVar;
        PoiSearchV2.OnPoiSearchListener onPoiSearchListener;
        Bundle data;
        int i6 = message.what;
        if (i6 == 603) {
            k kVar = (k) message.obj;
            if (kVar == null || (onPoiSearchListener = kVar.f8539b) == null || (data = message.getData()) == null) {
                return;
            }
            onPoiSearchListener.onPoiSearched(kVar.f8538a, data.getInt("errorCode"));
            return;
        }
        if (i6 != 604 || (iVar = (i) message.obj) == null) {
            return;
        }
        PoiSearchV2.OnPoiSearchListener onPoiSearchListener2 = iVar.f8535b;
        Bundle data2 = message.getData();
        if (data2 != null) {
            onPoiSearchListener2.onPoiItemSearched(iVar.f8534a, data2.getInt("errorCode"));
        }
    }

    private static void i(Message message) {
        a aVar;
        if (message.what != 600 || (aVar = (a) message.obj) == null) {
            return;
        }
        AutoTSearch.OnChargeStationListener onChargeStationListener = aVar.f8519b;
        Bundle data = message.getData();
        if (data != null) {
            int i6 = data.getInt("errorCode");
            if (onChargeStationListener != null) {
                onChargeStationListener.onChargeStationSearched(aVar.f8518a, i6);
            }
        }
    }

    private static void j(Message message) {
        Inputtips.InputtipsListener inputtipsListener = (Inputtips.InputtipsListener) message.obj;
        if (inputtipsListener == null) {
            return;
        }
        inputtipsListener.onGetInputtips(message.what == 1000 ? message.getData().getParcelableArrayList("result") : null, message.what);
    }

    private static void k(Message message) {
        f fVar;
        GeocodeSearch.OnGeocodeSearchListener onGeocodeSearchListener;
        GeocodeSearch.OnGeocodeSearchListener onGeocodeSearchListener2;
        int i6 = message.what;
        if (i6 == 201) {
            l lVar = (l) message.obj;
            if (lVar == null || (onGeocodeSearchListener2 = lVar.f8541b) == null) {
                return;
            }
            onGeocodeSearchListener2.onRegeocodeSearched(lVar.f8540a, message.arg2);
            return;
        }
        if (i6 != 200 || (fVar = (f) message.obj) == null || (onGeocodeSearchListener = fVar.f8529b) == null) {
            return;
        }
        onGeocodeSearchListener.onGeocodeSearched(fVar.f8528a, message.arg2);
    }

    private static void l(Message message) {
        DistrictSearch.OnDistrictSearchListener onDistrictSearchListener = (DistrictSearch.OnDistrictSearchListener) message.obj;
        if (onDistrictSearchListener == null) {
            return;
        }
        onDistrictSearchListener.onDistrictSearched((DistrictResult) message.getData().getParcelable("result"));
    }

    private static void m(Message message) {
        BusLineSearch.OnBusLineSearchListener onBusLineSearchListener;
        b bVar = (b) message.obj;
        if (bVar == null || (onBusLineSearchListener = bVar.f8521b) == null) {
            return;
        }
        int i6 = message.what;
        onBusLineSearchListener.onBusLineSearched(i6 == 1000 ? bVar.f8520a : null, i6);
    }

    private static void n(Message message) {
        Bundle data;
        RouteSearch.OnRouteSearchListener onRouteSearchListener = (RouteSearch.OnRouteSearchListener) message.obj;
        if (onRouteSearchListener == null) {
            return;
        }
        int i6 = message.what;
        if (i6 == 100) {
            Bundle data2 = message.getData();
            if (data2 != null) {
                onRouteSearchListener.onBusRouteSearched((BusRouteResult) message.getData().getParcelable("result"), data2.getInt("errorCode"));
                return;
            }
            return;
        }
        if (i6 == 101) {
            Bundle data3 = message.getData();
            if (data3 != null) {
                onRouteSearchListener.onDriveRouteSearched((DriveRouteResult) message.getData().getParcelable("result"), data3.getInt("errorCode"));
                return;
            }
            return;
        }
        if (i6 == 102) {
            Bundle data4 = message.getData();
            if (data4 != null) {
                onRouteSearchListener.onWalkRouteSearched((WalkRouteResult) message.getData().getParcelable("result"), data4.getInt("errorCode"));
                return;
            }
            return;
        }
        if (i6 == 103) {
            Bundle data5 = message.getData();
            if (data5 != null) {
                onRouteSearchListener.onRideRouteSearched((RideRouteResult) message.getData().getParcelable("result"), data5.getInt("errorCode"));
                return;
            }
            return;
        }
        if (i6 != 104 || (data = message.getData()) == null) {
            return;
        }
        onRouteSearchListener.onRideRouteSearched((RideRouteResult) message.getData().getParcelable("result"), data.getInt("errorCode"));
    }

    private static void o(Message message) {
        Bundle data;
        RouteSearchV2.OnRouteSearchListener onRouteSearchListener = (RouteSearchV2.OnRouteSearchListener) message.obj;
        if (onRouteSearchListener == null) {
            return;
        }
        int i6 = message.what;
        if (i6 == 101) {
            Bundle data2 = message.getData();
            if (data2 != null) {
                onRouteSearchListener.onDriveRouteSearched((DriveRouteResultV2) message.getData().getParcelable("result"), data2.getInt("errorCode"));
                return;
            }
            return;
        }
        if (i6 == 100) {
            Bundle data3 = message.getData();
            if (data3 != null) {
                onRouteSearchListener.onBusRouteSearched((BusRouteResultV2) message.getData().getParcelable("result"), data3.getInt("errorCode"));
                return;
            }
            return;
        }
        if (i6 == 102) {
            Bundle data4 = message.getData();
            if (data4 != null) {
                onRouteSearchListener.onWalkRouteSearched((WalkRouteResultV2) message.getData().getParcelable("result"), data4.getInt("errorCode"));
                return;
            }
            return;
        }
        if (i6 != 103 || (data = message.getData()) == null) {
            return;
        }
        onRouteSearchListener.onRideRouteSearched((RideRouteResultV2) message.getData().getParcelable("result"), data.getInt("errorCode"));
    }

    private static void p(Message message) {
        Bundle data;
        RouteSearch.OnTruckRouteSearchListener onTruckRouteSearchListener = (RouteSearch.OnTruckRouteSearchListener) message.obj;
        if (onTruckRouteSearchListener == null || message.what != 104 || (data = message.getData()) == null) {
            return;
        }
        onTruckRouteSearchListener.onTruckRouteSearched((TruckRouteRestult) message.getData().getParcelable("result"), data.getInt("errorCode"));
    }

    private static void q(Message message) {
        Bundle data;
        RouteSearch.OnRoutePlanSearchListener onRoutePlanSearchListener = (RouteSearch.OnRoutePlanSearchListener) message.obj;
        if (onRoutePlanSearchListener == null || message.what != 105 || (data = message.getData()) == null) {
            return;
        }
        onRoutePlanSearchListener.onDriveRoutePlanSearched((DriveRoutePlanResult) message.getData().getParcelable("result"), data.getInt("errorCode"));
    }

    private static void r(Message message) {
        d dVar;
        int i6 = message.what;
        if (i6 == 700) {
            e eVar = (e) message.obj;
            if (eVar == null) {
                return;
            }
            eVar.f8527b.onCloudSearched(eVar.f8526a, message.arg2);
            return;
        }
        if (i6 != 701 || (dVar = (d) message.obj) == null) {
            return;
        }
        dVar.f8525b.onCloudItemDetailSearched(dVar.f8524a, message.arg2);
    }

    private static void s(Message message) {
        n nVar;
        WeatherSearch.OnWeatherSearchListener onWeatherSearchListener;
        Bundle data;
        WeatherSearch.OnWeatherSearchListener onWeatherSearchListener2;
        Bundle data2;
        int i6 = message.what;
        if (i6 == 1301) {
            o oVar = (o) message.obj;
            if (oVar == null || (onWeatherSearchListener2 = oVar.f8547b) == null || (data2 = message.getData()) == null) {
                return;
            }
            onWeatherSearchListener2.onWeatherLiveSearched(oVar.f8546a, data2.getInt("errorCode"));
            return;
        }
        if (i6 != 1302 || (nVar = (n) message.obj) == null || (onWeatherSearchListener = nVar.f8545b) == null || (data = message.getData()) == null) {
            return;
        }
        onWeatherSearchListener.onWeatherForecastSearched(nVar.f8544a, data.getInt("errorCode"));
    }

    private static void t(Message message) {
        RoutePOISearch.OnRoutePOISearchListener onRoutePOISearchListener;
        Bundle data;
        m mVar = (m) message.obj;
        if (mVar == null || (onRoutePOISearchListener = mVar.f8543b) == null || (data = message.getData()) == null) {
            return;
        }
        onRoutePOISearchListener.onRoutePoiSearched(mVar.f8542a, data.getInt("errorCode"));
    }

    private static void u(Message message) {
        Bundle data;
        DistanceSearch.OnDistanceSearchListener onDistanceSearchListener = (DistanceSearch.OnDistanceSearchListener) message.obj;
        if (onDistanceSearchListener == null || message.what != 400 || (data = message.getData()) == null) {
            return;
        }
        onDistanceSearchListener.onDistanceSearched((DistanceResult) message.getData().getParcelable("result"), data.getInt("errorCode"));
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        try {
            int i6 = message.arg1;
            if (i6 == 101) {
                o(message);
                return;
            }
            switch (i6) {
                case 1:
                    n(message);
                    break;
                case 2:
                    k(message);
                    break;
                case 3:
                    m(message);
                    break;
                case 4:
                    l(message);
                    break;
                case 5:
                    j(message);
                    break;
                case 6:
                    g(message);
                    break;
                case 7:
                    f(message);
                    break;
                case 8:
                    e(message);
                    break;
                case 9:
                    d(message);
                    break;
                case 10:
                    c(message);
                    break;
                case 11:
                    b(message);
                    break;
                case 12:
                    r(message);
                    break;
                case 13:
                    s(message);
                    break;
                case 14:
                    t(message);
                    break;
                default:
                    switch (i6) {
                        case 16:
                            u(message);
                            break;
                        case 17:
                            p(message);
                            break;
                        case 18:
                            q(message);
                            break;
                        case 19:
                            h(message);
                            break;
                        case 20:
                            i(message);
                            break;
                    }
            }
        } catch (Throwable th) {
            j4.i(th, "MessageHandler", "handleMessage");
        }
    }
}
