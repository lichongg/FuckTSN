package com.kwad.components.core.request;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.ag;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class g extends com.kwad.sdk.core.network.d {
    @Override // com.kwad.sdk.core.network.d
    public final void buildBaseBodyWithPrivateInfo() {
        try {
            putBody("geoInfo", com.kwad.sdk.core.request.model.c.IL());
            putBody("kGeoInfo", ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).Bp());
        } catch (Throwable th) {
            reportSdkCaughtException(th);
        }
    }

    public g() {
        try {
            JSONArray jSONArray = new JSONArray();
            aa.a(jSONArray, new JSONObject());
            putBody("impInfo", jSONArray);
            putBody("appTag", ag.Qy());
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return com.kwad.sdk.h.AQ();
    }
}
