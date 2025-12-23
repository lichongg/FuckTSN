package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.s.n;
import com.amap.api.col.s.p;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeQuery;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class r extends b4<RegeocodeQuery, RegeocodeAddress> {
    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    protected final String M() {
        return U(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String U(boolean z5) {
        StringBuilder sb = new StringBuilder();
        sb.append("output=json&location=");
        if (z5) {
            sb.append(j4.a(((RegeocodeQuery) this.f7863n).getPoint().getLongitude()));
            sb.append(",");
            sb.append(j4.a(((RegeocodeQuery) this.f7863n).getPoint().getLatitude()));
        }
        if (!TextUtils.isEmpty(((RegeocodeQuery) this.f7863n).getPoiType())) {
            sb.append("&poitype=");
            sb.append(((RegeocodeQuery) this.f7863n).getPoiType());
        }
        if (!TextUtils.isEmpty(((RegeocodeQuery) this.f7863n).getMode())) {
            sb.append("&mode=");
            sb.append(((RegeocodeQuery) this.f7863n).getMode());
        }
        if (TextUtils.isEmpty(((RegeocodeQuery) this.f7863n).getExtensions())) {
            sb.append("&extensions=base");
        } else {
            sb.append("&extensions=");
            sb.append(((RegeocodeQuery) this.f7863n).getExtensions());
        }
        sb.append("&radius=");
        sb.append((int) ((RegeocodeQuery) this.f7863n).getRadius());
        sb.append("&coordsys=");
        sb.append(((RegeocodeQuery) this.f7863n).getLatLonType());
        sb.append("&key=");
        sb.append(x0.i(this.f7866q));
        return sb.toString();
    }

    private static RegeocodeAddress V(String str) throws AMapException {
        RegeocodeAddress regeocodeAddress = new RegeocodeAddress();
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("regeocode");
            if (optJSONObject != null) {
                regeocodeAddress.setFormatAddress(r4.v(optJSONObject, "formatted_address"));
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("addressComponent");
                if (optJSONObject2 != null) {
                    r4.J(optJSONObject2, regeocodeAddress);
                }
                regeocodeAddress.setPois(r4.U(optJSONObject));
                JSONArray optJSONArray = optJSONObject.optJSONArray("roads");
                if (optJSONArray != null) {
                    r4.R(optJSONArray, regeocodeAddress);
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("roadinters");
                if (optJSONArray2 != null) {
                    r4.H(optJSONArray2, regeocodeAddress);
                }
                JSONArray optJSONArray3 = optJSONObject.optJSONArray("aois");
                if (optJSONArray3 != null) {
                    r4.X(optJSONArray3, regeocodeAddress);
                }
            }
            return regeocodeAddress;
        } catch (JSONException e6) {
            j4.i(e6, "ReverseGeocodingHandler", "paseJSON");
            return regeocodeAddress;
        }
    }

    @Override // com.amap.api.col.s.dz
    public final String h() {
        return i4.b() + "/geocode/regeo?";
    }

    public r(Context context, RegeocodeQuery regeocodeQuery) {
        super(context, regeocodeQuery);
    }

    private static p W() {
        o c6 = n.b().c("regeo");
        if (c6 == null) {
            return null;
        }
        return (p) c6;
    }

    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    protected final /* synthetic */ Object I(String str) throws AMapException {
        return V(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.a3
    protected final n.b P() {
        double d6;
        p W = W();
        if (W != null) {
            d6 = W.l();
        } else {
            d6 = 0.0d;
        }
        double d7 = d6;
        n.b bVar = new n.b();
        bVar.f8260a = h() + U(false) + "language=" + ServiceSettings.getInstance().getLanguage();
        T t5 = this.f7863n;
        if (t5 != 0 && ((RegeocodeQuery) t5).getPoint() != null) {
            bVar.f8261b = new p.a(((RegeocodeQuery) this.f7863n).getPoint().getLatitude(), ((RegeocodeQuery) this.f7863n).getPoint().getLongitude(), d7);
        }
        return bVar;
    }
}
