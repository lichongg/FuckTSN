package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.col.s.n;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.GeocodeQuery;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class p4 extends b4<GeocodeQuery, ArrayList<GeocodeAddress>> {
    private static ArrayList<GeocodeAddress> U(String str) throws AMapException {
        ArrayList<GeocodeAddress> arrayList = new ArrayList<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("count") && jSONObject.getInt("count") > 0) {
                return r4.r0(jSONObject);
            }
        } catch (JSONException e6) {
            j4.i(e6, "GeocodingHandler", "paseJSONJSONException");
        } catch (Exception e7) {
            j4.i(e7, "GeocodingHandler", "paseJSONException");
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    protected final String M() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json&address=");
        stringBuffer.append(b4.i(((GeocodeQuery) this.f7863n).getLocationName()));
        String city = ((GeocodeQuery) this.f7863n).getCity();
        if (!r4.s0(city)) {
            String i6 = b4.i(city);
            stringBuffer.append("&city=");
            stringBuffer.append(i6);
        }
        if (!r4.s0(((GeocodeQuery) this.f7863n).getCountry())) {
            stringBuffer.append("&country=");
            stringBuffer.append(b4.i(((GeocodeQuery) this.f7863n).getCountry()));
        }
        stringBuffer.append("&key=" + x0.i(this.f7866q));
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.a3
    protected final n.b P() {
        n.b bVar = new n.b();
        bVar.f8260a = h() + M() + "language=" + ServiceSettings.getInstance().getLanguage();
        return bVar;
    }

    @Override // com.amap.api.col.s.dz
    public final String h() {
        return i4.b() + "/geocode/geo?";
    }

    public p4(Context context, GeocodeQuery geocodeQuery) {
        super(context, geocodeQuery);
    }

    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    protected final /* synthetic */ Object I(String str) throws AMapException {
        return U(str);
    }
}
