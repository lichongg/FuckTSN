package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.district.DistrictResult;
import com.amap.api.services.district.DistrictSearchQuery;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class l4 extends b4<DistrictSearchQuery, DistrictResult> {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public DistrictResult I(String str) throws AMapException {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        DistrictResult districtResult = new DistrictResult((DistrictSearchQuery) this.f7863n, arrayList);
        try {
            JSONObject jSONObject = new JSONObject(str);
            districtResult.setPageCount(jSONObject.optInt("count"));
            optJSONArray = jSONObject.optJSONArray("districts");
        } catch (JSONException e6) {
            j4.i(e6, "DistrictServerHandler", "paseJSONJSONException");
        } catch (Exception e7) {
            j4.i(e7, "DistrictServerHandler", "paseJSONException");
        }
        if (optJSONArray == null) {
            return districtResult;
        }
        r4.I(optJSONArray, arrayList, null);
        return districtResult;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    protected final String M() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json");
        stringBuffer.append("&page=");
        stringBuffer.append(((DistrictSearchQuery) this.f7863n).getPageNum());
        stringBuffer.append("&offset=");
        stringBuffer.append(((DistrictSearchQuery) this.f7863n).getPageSize());
        if (((DistrictSearchQuery) this.f7863n).isShowBoundary()) {
            stringBuffer.append("&extensions=all");
        } else {
            stringBuffer.append("&extensions=base");
        }
        if (((DistrictSearchQuery) this.f7863n).checkKeyWords()) {
            String i6 = b4.i(((DistrictSearchQuery) this.f7863n).getKeywords());
            stringBuffer.append("&keywords=");
            stringBuffer.append(i6);
        }
        stringBuffer.append("&key=" + x0.i(this.f7866q));
        stringBuffer.append("&subdistrict=" + String.valueOf(((DistrictSearchQuery) this.f7863n).getSubDistrict()));
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.dz
    public final String h() {
        return i4.b() + "/config/district?";
    }

    public l4(Context context, DistrictSearchQuery districtSearchQuery) {
        super(context, districtSearchQuery);
    }
}
