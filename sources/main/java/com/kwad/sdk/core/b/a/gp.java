package com.kwad.sdk.core.b.a;

import com.kwad.sdk.kgeo.KGeoInfo;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class gp implements com.kwad.sdk.core.d<KGeoInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(KGeoInfo kGeoInfo, JSONObject jSONObject) {
        a2(kGeoInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(KGeoInfo kGeoInfo, JSONObject jSONObject) {
        return b2(kGeoInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(KGeoInfo kGeoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        kGeoInfo.latitude = jSONObject.optDouble("latitude");
        kGeoInfo.longitude = jSONObject.optDouble("longitude");
        kGeoInfo.range = jSONObject.optInt("range");
        kGeoInfo.rate = jSONObject.optInt("rate");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(KGeoInfo kGeoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        double d6 = kGeoInfo.latitude;
        if (d6 != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "latitude", d6);
        }
        double d7 = kGeoInfo.longitude;
        if (d7 != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "longitude", d7);
        }
        int i6 = kGeoInfo.range;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "range", i6);
        }
        int i7 = kGeoInfo.rate;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "rate", i7);
        }
        return jSONObject;
    }
}
