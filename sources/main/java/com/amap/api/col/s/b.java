package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.nearby.NearbyInfo;
import com.amap.api.services.nearby.NearbySearch;
import com.amap.api.services.nearby.NearbySearchResult;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class b extends b4<NearbySearch.NearbyQuery, NearbySearchResult> {

    /* renamed from: t, reason: collision with root package name */
    private Context f7873t;

    /* renamed from: u, reason: collision with root package name */
    private NearbySearch.NearbyQuery f7874u;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public NearbySearchResult I(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            boolean z5 = true;
            if (this.f7874u.getType() != 1) {
                z5 = false;
            }
            ArrayList<NearbyInfo> x5 = r4.x(jSONObject, z5);
            NearbySearchResult nearbySearchResult = new NearbySearchResult();
            nearbySearchResult.setNearbyInfoList(x5);
            return nearbySearchResult;
        } catch (JSONException e6) {
            j4.i(e6, "NearbySearchHandler", "paseJSON");
            return null;
        }
    }

    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    protected final String M() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(x0.i(this.f7873t));
        LatLonPoint centerPoint = this.f7874u.getCenterPoint();
        if (centerPoint != null) {
            stringBuffer.append("&center=");
            stringBuffer.append(centerPoint.getLongitude());
            stringBuffer.append(",");
            stringBuffer.append(centerPoint.getLatitude());
        }
        stringBuffer.append("&radius=");
        stringBuffer.append(this.f7874u.getRadius());
        stringBuffer.append("&limit=30");
        stringBuffer.append("&searchtype=");
        stringBuffer.append(this.f7874u.getType());
        stringBuffer.append("&timerange=");
        stringBuffer.append(this.f7874u.getTimeRange());
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.dz
    public final String h() {
        return i4.e() + "/nearby/around";
    }

    public b(Context context, NearbySearch.NearbyQuery nearbyQuery) {
        super(context, nearbyQuery);
        this.f7873t = context;
        this.f7874u = nearbyQuery;
    }
}
