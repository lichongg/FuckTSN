package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.RouteSearch;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class n4 extends b4<RouteSearch.DriveRouteQuery, DriveRouteResult> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    protected final String M() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(x0.i(this.f7866q));
        if (((RouteSearch.DriveRouteQuery) this.f7863n).getFromAndTo() != null) {
            stringBuffer.append("&origin=");
            stringBuffer.append(j4.d(((RouteSearch.DriveRouteQuery) this.f7863n).getFromAndTo().getFrom()));
            if (!r4.s0(((RouteSearch.DriveRouteQuery) this.f7863n).getFromAndTo().getStartPoiID())) {
                stringBuffer.append("&originid=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) this.f7863n).getFromAndTo().getStartPoiID());
            }
            stringBuffer.append("&destination=");
            stringBuffer.append(j4.d(((RouteSearch.DriveRouteQuery) this.f7863n).getFromAndTo().getTo()));
            if (!r4.s0(((RouteSearch.DriveRouteQuery) this.f7863n).getFromAndTo().getDestinationPoiID())) {
                stringBuffer.append("&destinationid=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) this.f7863n).getFromAndTo().getDestinationPoiID());
            }
            if (!r4.s0(((RouteSearch.DriveRouteQuery) this.f7863n).getFromAndTo().getOriginType())) {
                stringBuffer.append("&origintype=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) this.f7863n).getFromAndTo().getOriginType());
            }
            if (!r4.s0(((RouteSearch.DriveRouteQuery) this.f7863n).getFromAndTo().getDestinationType())) {
                stringBuffer.append("&destinationtype=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) this.f7863n).getFromAndTo().getDestinationType());
            }
            if (!r4.s0(((RouteSearch.DriveRouteQuery) this.f7863n).getFromAndTo().getPlateProvince())) {
                stringBuffer.append("&province=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) this.f7863n).getFromAndTo().getPlateProvince());
            }
            if (!r4.s0(((RouteSearch.DriveRouteQuery) this.f7863n).getFromAndTo().getPlateNumber())) {
                stringBuffer.append("&number=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) this.f7863n).getFromAndTo().getPlateNumber());
            }
        }
        stringBuffer.append("&strategy=");
        StringBuilder sb = new StringBuilder();
        sb.append(((RouteSearch.DriveRouteQuery) this.f7863n).getMode());
        stringBuffer.append(sb.toString());
        if (TextUtils.isEmpty(((RouteSearch.DriveRouteQuery) this.f7863n).getExtensions())) {
            stringBuffer.append("&extensions=base");
        } else {
            stringBuffer.append("&extensions=");
            stringBuffer.append(((RouteSearch.DriveRouteQuery) this.f7863n).getExtensions());
        }
        stringBuffer.append("&ferry=");
        stringBuffer.append(!((RouteSearch.DriveRouteQuery) this.f7863n).isUseFerry() ? 1 : 0);
        stringBuffer.append("&cartype=");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(((RouteSearch.DriveRouteQuery) this.f7863n).getCarType());
        stringBuffer.append(sb2.toString());
        if (((RouteSearch.DriveRouteQuery) this.f7863n).hasPassPoint()) {
            stringBuffer.append("&waypoints=");
            stringBuffer.append(((RouteSearch.DriveRouteQuery) this.f7863n).getPassedPointStr());
        }
        if (((RouteSearch.DriveRouteQuery) this.f7863n).hasAvoidpolygons()) {
            stringBuffer.append("&avoidpolygons=");
            stringBuffer.append(((RouteSearch.DriveRouteQuery) this.f7863n).getAvoidpolygonsStr());
        }
        if (((RouteSearch.DriveRouteQuery) this.f7863n).hasAvoidRoad()) {
            stringBuffer.append("&avoidroad=");
            stringBuffer.append(b4.i(((RouteSearch.DriveRouteQuery) this.f7863n).getAvoidRoad()));
        }
        stringBuffer.append("&output=json");
        stringBuffer.append("&geometry=false");
        if (((RouteSearch.DriveRouteQuery) this.f7863n).getExclude() != null) {
            stringBuffer.append("&exclude=");
            stringBuffer.append(((RouteSearch.DriveRouteQuery) this.f7863n).getExclude());
        }
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.dz
    public final String h() {
        return i4.b() + "/direction/driving?";
    }

    public n4(Context context, RouteSearch.DriveRouteQuery driveRouteQuery) {
        super(context, driveRouteQuery);
    }

    private static DriveRouteResult U(String str) throws AMapException {
        return r4.T(str);
    }

    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    protected final /* synthetic */ Object I(String str) throws AMapException {
        return U(str);
    }
}
