package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.RideRouteResultV2;
import com.amap.api.services.route.RouteSearchV2;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class t extends b4<RouteSearchV2.RideRouteQuery, RideRouteResultV2> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    protected final String M() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(x0.i(this.f7866q));
        stringBuffer.append("&origin=");
        stringBuffer.append(j4.d(((RouteSearchV2.RideRouteQuery) this.f7863n).getFromAndTo().getFrom()));
        stringBuffer.append("&destination=");
        stringBuffer.append(j4.d(((RouteSearchV2.RideRouteQuery) this.f7863n).getFromAndTo().getTo()));
        stringBuffer.append("&alternative_route=");
        stringBuffer.append(((RouteSearchV2.RideRouteQuery) this.f7863n).getAlternativeRoute());
        stringBuffer.append("&output=json");
        stringBuffer.append("&show_fields=");
        stringBuffer.append(j4.c(((RouteSearchV2.RideRouteQuery) this.f7863n).getShowFields()));
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.dz
    public final String h() {
        return i4.d() + "/direction/bicycling?";
    }

    public t(Context context, RouteSearchV2.RideRouteQuery rideRouteQuery) {
        super(context, rideRouteQuery);
    }

    private static RideRouteResultV2 U(String str) throws AMapException {
        return r4.v0(str);
    }

    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    protected final /* synthetic */ Object I(String str) throws AMapException {
        return U(str);
    }
}
