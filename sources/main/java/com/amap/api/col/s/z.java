package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.TruckRouteRestult;
import com.huawei.hms.common.util.Logger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class z extends b4<RouteSearch.TruckRouteQuery, TruckRouteRestult> {

    /* renamed from: t, reason: collision with root package name */
    private final String f8775t;

    /* renamed from: u, reason: collision with root package name */
    private final String f8776u;

    /* renamed from: v, reason: collision with root package name */
    private final String f8777v;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    protected final String M() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(x0.i(this.f7866q));
        if (((RouteSearch.TruckRouteQuery) this.f7863n).getFromAndTo() != null) {
            stringBuffer.append("&origin=");
            stringBuffer.append(j4.d(((RouteSearch.TruckRouteQuery) this.f7863n).getFromAndTo().getFrom()));
            if (!r4.s0(((RouteSearch.TruckRouteQuery) this.f7863n).getFromAndTo().getStartPoiID())) {
                stringBuffer.append("&originid=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f7863n).getFromAndTo().getStartPoiID());
            }
            stringBuffer.append("&destination=");
            stringBuffer.append(j4.d(((RouteSearch.TruckRouteQuery) this.f7863n).getFromAndTo().getTo()));
            if (!r4.s0(((RouteSearch.TruckRouteQuery) this.f7863n).getFromAndTo().getDestinationPoiID())) {
                stringBuffer.append("&destinationid=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f7863n).getFromAndTo().getDestinationPoiID());
            }
            if (!r4.s0(((RouteSearch.TruckRouteQuery) this.f7863n).getFromAndTo().getOriginType())) {
                stringBuffer.append("&origintype=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f7863n).getFromAndTo().getOriginType());
            }
            if (!r4.s0(((RouteSearch.TruckRouteQuery) this.f7863n).getFromAndTo().getDestinationType())) {
                stringBuffer.append("&destinationtype=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f7863n).getFromAndTo().getDestinationType());
            }
            if (!r4.s0(((RouteSearch.TruckRouteQuery) this.f7863n).getFromAndTo().getPlateProvince())) {
                stringBuffer.append("&province=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f7863n).getFromAndTo().getPlateProvince());
            }
            if (!r4.s0(((RouteSearch.TruckRouteQuery) this.f7863n).getFromAndTo().getPlateNumber())) {
                stringBuffer.append("&number=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f7863n).getFromAndTo().getPlateNumber());
            }
        }
        stringBuffer.append("&strategy=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f7863n).getMode());
        if (((RouteSearch.TruckRouteQuery) this.f7863n).hasPassPoint()) {
            stringBuffer.append("&waypoints=");
            stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f7863n).getPassedPointStr());
        }
        stringBuffer.append("&size=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f7863n).getTruckSize());
        stringBuffer.append("&height=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f7863n).getTruckHeight());
        stringBuffer.append("&width=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f7863n).getTruckWidth());
        stringBuffer.append("&load=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f7863n).getTruckLoad());
        stringBuffer.append("&weight=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f7863n).getTruckWeight());
        stringBuffer.append("&axis=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f7863n).getTruckAxis());
        if (TextUtils.isEmpty(((RouteSearch.TruckRouteQuery) this.f7863n).getExtensions())) {
            stringBuffer.append("&extensions=base");
        } else {
            stringBuffer.append("&extensions=");
            stringBuffer.append(((RouteSearch.TruckRouteQuery) this.f7863n).getExtensions());
        }
        stringBuffer.append("&output=json");
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.dz
    public final String h() {
        return i4.c() + "/direction/truck?";
    }

    public z(Context context, RouteSearch.TruckRouteQuery truckRouteQuery) {
        super(context, truckRouteQuery);
        this.f8775t = "/direction/truck?";
        this.f8776u = Logger.f33116c;
        this.f8777v = ",";
    }

    private static TruckRouteRestult U(String str) throws AMapException {
        return r4.A0(str);
    }

    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    protected final /* synthetic */ Object I(String str) throws AMapException {
        return U(str);
    }
}
