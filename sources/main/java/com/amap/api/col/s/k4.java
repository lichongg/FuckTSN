package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.DistanceResult;
import com.amap.api.services.route.DistanceSearch;
import com.huawei.hms.common.util.Logger;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class k4 extends b4<DistanceSearch.DistanceQuery, DistanceResult> {

    /* renamed from: t, reason: collision with root package name */
    private final String f8214t;

    /* renamed from: u, reason: collision with root package name */
    private final String f8215u;

    /* renamed from: v, reason: collision with root package name */
    private final String f8216v;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    protected final String M() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(x0.i(this.f7866q));
        List<LatLonPoint> origins = ((DistanceSearch.DistanceQuery) this.f7863n).getOrigins();
        if (origins != null && origins.size() > 0) {
            stringBuffer.append("&origins=");
            int size = origins.size();
            for (int i6 = 0; i6 < size; i6++) {
                LatLonPoint latLonPoint = origins.get(i6);
                if (latLonPoint != null) {
                    double a6 = j4.a(latLonPoint.getLatitude());
                    stringBuffer.append(j4.a(latLonPoint.getLongitude()));
                    stringBuffer.append(",");
                    stringBuffer.append(a6);
                    if (i6 < size) {
                        stringBuffer.append(Logger.f33116c);
                    }
                }
            }
        }
        LatLonPoint destination = ((DistanceSearch.DistanceQuery) this.f7863n).getDestination();
        if (destination != null) {
            double a7 = j4.a(destination.getLatitude());
            double a8 = j4.a(destination.getLongitude());
            stringBuffer.append("&destination=");
            stringBuffer.append(a8);
            stringBuffer.append(",");
            stringBuffer.append(a7);
        }
        stringBuffer.append("&type=");
        stringBuffer.append(((DistanceSearch.DistanceQuery) this.f7863n).getType());
        if (TextUtils.isEmpty(((DistanceSearch.DistanceQuery) this.f7863n).getExtensions())) {
            stringBuffer.append("&extensions=base");
        } else {
            stringBuffer.append("&extensions=");
            stringBuffer.append(((DistanceSearch.DistanceQuery) this.f7863n).getExtensions());
        }
        stringBuffer.append("&output=json");
        if (((DistanceSearch.DistanceQuery) this.f7863n).getType() == 1) {
            stringBuffer.append("&strategy=");
            stringBuffer.append(((DistanceSearch.DistanceQuery) this.f7863n).getMode());
        }
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.dz
    public final String h() {
        return i4.b() + "/distance?";
    }

    public k4(Context context, DistanceSearch.DistanceQuery distanceQuery) {
        super(context, distanceQuery);
        this.f8214t = "/distance?";
        this.f8215u = Logger.f33116c;
        this.f8216v = ",";
    }

    private static DistanceResult U(String str) throws AMapException {
        return r4.y0(str);
    }

    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    protected final /* synthetic */ Object I(String str) throws AMapException {
        return U(str);
    }
}
