package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.auto.AutoTChargeStationResult;
import com.amap.api.services.auto.AutoTSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class b0 extends b4<AutoTSearch.Query, AutoTChargeStationResult> {

    /* renamed from: t, reason: collision with root package name */
    private a f7875t;

    private static AutoTChargeStationResult U(String str) throws AMapException {
        try {
            return b1.a(new JSONObject(str));
        } catch (Exception e6) {
            e6.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    protected final String M() {
        StringBuilder sb = new StringBuilder(this.f7875t.a());
        sb.append("&adcode=");
        sb.append(((AutoTSearch.Query) this.f7863n).getAdCode());
        sb.append("&city=");
        sb.append(((AutoTSearch.Query) this.f7863n).getCity());
        sb.append("&data_type=");
        sb.append(((AutoTSearch.Query) this.f7863n).getDataType());
        sb.append("&geoobj=");
        sb.append(((AutoTSearch.Query) this.f7863n).getGeoObj());
        sb.append("&keywords=");
        sb.append(((AutoTSearch.Query) this.f7863n).getKeywords());
        sb.append("&pagenum=");
        sb.append(((AutoTSearch.Query) this.f7863n).getPageNum());
        sb.append("&pagesize=");
        sb.append(((AutoTSearch.Query) this.f7863n).getPageSize());
        sb.append("&qii=");
        sb.append(((AutoTSearch.Query) this.f7863n).isQii());
        sb.append("&query_type=");
        sb.append(((AutoTSearch.Query) this.f7863n).getQueryType());
        sb.append("&range=");
        sb.append(((AutoTSearch.Query) this.f7863n).getRange());
        LatLonPoint latLonPoint = ((AutoTSearch.Query) this.f7863n).getLatLonPoint();
        if (latLonPoint != null) {
            sb.append("&longitude=");
            sb.append(latLonPoint.getLongitude());
            sb.append("&latitude=");
            sb.append(latLonPoint.getLatitude());
        }
        sb.append("&user_loc=");
        sb.append(((AutoTSearch.Query) this.f7863n).getUserLoc());
        sb.append("&user_city=");
        sb.append(((AutoTSearch.Query) this.f7863n).getUserCity());
        AutoTSearch.FilterBox filterBox = ((AutoTSearch.Query) this.f7863n).getFilterBox();
        if (filterBox != null) {
            sb.append("&retain_state=");
            sb.append(filterBox.getRetainState());
            sb.append("&checked_level=");
            sb.append(filterBox.getCheckedLevel());
            sb.append("&classify_v2_data=");
            sb.append(filterBox.getClassifyV2Data());
            sb.append("&classify_v2_level2_data=");
            sb.append(filterBox.getClassifyV2Level2Data());
            sb.append("&classify_v2_level3_data=");
            sb.append(filterBox.getClassifyV2Level3Data());
        }
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.dz
    public final String h() {
        try {
            String c6 = b2.c(new HashMap(), ((AutoTSearch.Query) this.f7863n).getAccessKey());
            return i4.g() + "/ws/mapapi/poi/infolite/auto?" + c6 + "&Signature=" + b2.b("POST", c6, ((AutoTSearch.Query) this.f7863n).getSecretKey());
        } catch (Exception e6) {
            e6.printStackTrace();
            return null;
        }
    }

    public b0(Context context, AutoTSearch.Query query) {
        super(context, query);
        this.f7875t = null;
        this.f7875t = new a(context);
    }

    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    protected final /* synthetic */ Object I(String str) throws AMapException {
        return U(str);
    }
}
