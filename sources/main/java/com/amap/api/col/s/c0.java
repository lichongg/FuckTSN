package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.RouteSearchV2;
import com.amap.api.services.route.WalkRouteResultV2;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class c0 extends b4<RouteSearchV2.WalkRouteQuery, WalkRouteResultV2> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    protected final String M() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(x0.i(this.f7866q));
        stringBuffer.append("&origin=");
        stringBuffer.append(j4.d(((RouteSearchV2.WalkRouteQuery) this.f7863n).getFromAndTo().getFrom()));
        stringBuffer.append("&destination=");
        stringBuffer.append(j4.d(((RouteSearchV2.WalkRouteQuery) this.f7863n).getFromAndTo().getTo()));
        stringBuffer.append("&output=json");
        stringBuffer.append("&isindoor=");
        stringBuffer.append(((RouteSearchV2.WalkRouteQuery) this.f7863n).isIndoor() ? 1 : 0);
        stringBuffer.append("&alternative_route=");
        stringBuffer.append(((RouteSearchV2.WalkRouteQuery) this.f7863n).getAlternativeRoute());
        stringBuffer.append("&show_fields=");
        stringBuffer.append(j4.c(((RouteSearchV2.WalkRouteQuery) this.f7863n).getShowFields()));
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.dz
    public final String h() {
        return i4.d() + "/direction/walking?";
    }

    public c0(Context context, RouteSearchV2.WalkRouteQuery walkRouteQuery) {
        super(context, walkRouteQuery);
    }

    private static WalkRouteResultV2 U(String str) throws AMapException {
        return r4.j0(str);
    }

    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    protected final /* synthetic */ Object I(String str) throws AMapException {
        return U(str);
    }
}
