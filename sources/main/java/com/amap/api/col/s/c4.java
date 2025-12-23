package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.RouteSearch;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class c4 extends b4<RouteSearch.BusRouteQuery, BusRouteResult> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    protected final String M() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(x0.i(this.f7866q));
        stringBuffer.append("&origin=");
        stringBuffer.append(j4.d(((RouteSearch.BusRouteQuery) this.f7863n).getFromAndTo().getFrom()));
        stringBuffer.append("&destination=");
        stringBuffer.append(j4.d(((RouteSearch.BusRouteQuery) this.f7863n).getFromAndTo().getTo()));
        String city = ((RouteSearch.BusRouteQuery) this.f7863n).getCity();
        if (!r4.s0(city)) {
            city = b4.i(city);
            stringBuffer.append("&city=");
            stringBuffer.append(city);
        }
        if (!r4.s0(((RouteSearch.BusRouteQuery) this.f7863n).getCity())) {
            String i6 = b4.i(city);
            stringBuffer.append("&cityd=");
            stringBuffer.append(i6);
        }
        stringBuffer.append("&strategy=");
        StringBuilder sb = new StringBuilder();
        sb.append(((RouteSearch.BusRouteQuery) this.f7863n).getMode());
        stringBuffer.append(sb.toString());
        stringBuffer.append("&nightflag=");
        stringBuffer.append(((RouteSearch.BusRouteQuery) this.f7863n).getNightFlag());
        if (TextUtils.isEmpty(((RouteSearch.BusRouteQuery) this.f7863n).getExtensions())) {
            stringBuffer.append("&extensions=base");
        } else {
            stringBuffer.append("&extensions=");
            stringBuffer.append(((RouteSearch.BusRouteQuery) this.f7863n).getExtensions());
        }
        stringBuffer.append("&output=json");
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.dz
    public final String h() {
        return i4.b() + "/direction/transit/integrated?";
    }

    public c4(Context context, RouteSearch.BusRouteQuery busRouteQuery) {
        super(context, busRouteQuery);
    }

    private static BusRouteResult U(String str) throws AMapException {
        return r4.u(str);
    }

    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    protected final /* synthetic */ Object I(String str) throws AMapException {
        return U(str);
    }
}
