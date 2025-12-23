package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RouteSearch;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class s extends b4<RouteSearch.RideRouteQuery, RideRouteResult> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    protected final String M() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(x0.i(this.f7866q));
        stringBuffer.append("&origin=");
        stringBuffer.append(j4.d(((RouteSearch.RideRouteQuery) this.f7863n).getFromAndTo().getFrom()));
        stringBuffer.append("&destination=");
        stringBuffer.append(j4.d(((RouteSearch.RideRouteQuery) this.f7863n).getFromAndTo().getTo()));
        stringBuffer.append("&output=json");
        stringBuffer.append("&geometry=false");
        if (TextUtils.isEmpty(((RouteSearch.RideRouteQuery) this.f7863n).getExtensions())) {
            stringBuffer.append("&extensions=base");
        } else {
            stringBuffer.append("&extensions=");
            stringBuffer.append(((RouteSearch.RideRouteQuery) this.f7863n).getExtensions());
        }
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.dz
    public final String h() {
        return i4.c() + "/direction/bicycling?";
    }

    public s(Context context, RouteSearch.RideRouteQuery rideRouteQuery) {
        super(context, rideRouteQuery);
    }

    private static RideRouteResult U(String str) throws AMapException {
        return r4.t0(str);
    }

    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    protected final /* synthetic */ Object I(String str) throws AMapException {
        return U(str);
    }
}
