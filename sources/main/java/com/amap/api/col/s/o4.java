package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.DriveRouteResultV2;
import com.amap.api.services.route.RouteSearchV2;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class o4 extends b4<RouteSearchV2.DriveRouteQuery, DriveRouteResultV2> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    protected final String M() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(x0.i(this.f7866q));
        if (((RouteSearchV2.DriveRouteQuery) this.f7863n).getFromAndTo() != null) {
            stringBuffer.append("&origin=");
            stringBuffer.append(j4.d(((RouteSearchV2.DriveRouteQuery) this.f7863n).getFromAndTo().getFrom()));
            if (!r4.s0(((RouteSearchV2.DriveRouteQuery) this.f7863n).getFromAndTo().getStartPoiID())) {
                stringBuffer.append("&origin_id=");
                stringBuffer.append(((RouteSearchV2.DriveRouteQuery) this.f7863n).getFromAndTo().getStartPoiID());
            }
            stringBuffer.append("&destination=");
            stringBuffer.append(j4.d(((RouteSearchV2.DriveRouteQuery) this.f7863n).getFromAndTo().getTo()));
            if (!r4.s0(((RouteSearchV2.DriveRouteQuery) this.f7863n).getFromAndTo().getDestinationPoiID())) {
                stringBuffer.append("&destination_id=");
                stringBuffer.append(((RouteSearchV2.DriveRouteQuery) this.f7863n).getFromAndTo().getDestinationPoiID());
            }
            if (!r4.s0(((RouteSearchV2.DriveRouteQuery) this.f7863n).getFromAndTo().getOriginType())) {
                stringBuffer.append("&origin_type=");
                stringBuffer.append(((RouteSearchV2.DriveRouteQuery) this.f7863n).getFromAndTo().getOriginType());
            }
            if (!r4.s0(((RouteSearchV2.DriveRouteQuery) this.f7863n).getFromAndTo().getPlateNumber())) {
                stringBuffer.append("&plate=");
                stringBuffer.append(((RouteSearchV2.DriveRouteQuery) this.f7863n).getFromAndTo().getPlateNumber());
            }
        }
        stringBuffer.append("&strategy=");
        StringBuilder sb = new StringBuilder();
        sb.append(((RouteSearchV2.DriveRouteQuery) this.f7863n).getMode().getValue());
        stringBuffer.append(sb.toString());
        int showFields = ((RouteSearchV2.DriveRouteQuery) this.f7863n).getShowFields();
        stringBuffer.append("&show_fields=");
        stringBuffer.append(j4.c(showFields));
        RouteSearchV2.NewEnergy newEnergy = ((RouteSearchV2.DriveRouteQuery) this.f7863n).getNewEnergy();
        if (newEnergy != null) {
            stringBuffer.append(newEnergy.buildParam());
            stringBuffer.append("&force_new_version=true");
        }
        stringBuffer.append("&ferry=");
        stringBuffer.append(!((RouteSearchV2.DriveRouteQuery) this.f7863n).isUseFerry() ? 1 : 0);
        stringBuffer.append("&cartype=");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(((RouteSearchV2.DriveRouteQuery) this.f7863n).getCarType());
        stringBuffer.append(sb2.toString());
        if (((RouteSearchV2.DriveRouteQuery) this.f7863n).hasPassPoint()) {
            stringBuffer.append("&waypoints=");
            stringBuffer.append(((RouteSearchV2.DriveRouteQuery) this.f7863n).getPassedPointStr());
        }
        if (((RouteSearchV2.DriveRouteQuery) this.f7863n).hasAvoidpolygons()) {
            stringBuffer.append("&avoidpolygons=");
            stringBuffer.append(((RouteSearchV2.DriveRouteQuery) this.f7863n).getAvoidpolygonsStr());
        }
        if (((RouteSearchV2.DriveRouteQuery) this.f7863n).hasAvoidRoad()) {
            stringBuffer.append("&avoidroad=");
            stringBuffer.append(b4.i(((RouteSearchV2.DriveRouteQuery) this.f7863n).getAvoidRoad()));
        }
        stringBuffer.append("&output=json");
        stringBuffer.append("&geometry=false");
        if (((RouteSearchV2.DriveRouteQuery) this.f7863n).getExclude() != null) {
            stringBuffer.append("&exclude=");
            stringBuffer.append(((RouteSearchV2.DriveRouteQuery) this.f7863n).getExclude());
        }
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.dz
    public final String h() {
        return i4.d() + "/direction/driving?";
    }

    public o4(Context context, RouteSearchV2.DriveRouteQuery driveRouteQuery) {
        super(context, driveRouteQuery);
    }

    private static DriveRouteResultV2 U(String str) throws AMapException {
        return r4.Y(str);
    }

    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    protected final /* synthetic */ Object I(String str) throws AMapException {
        return U(str);
    }
}
