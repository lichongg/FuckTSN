package com.kwad.sdk.core.request.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.bd;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c implements com.kwad.sdk.core.b {
    private static c aIA;
    private double latitude;
    private double longitude;
    private int type;

    public static c IL() {
        com.kwad.sdk.internal.api.a aVar;
        c cVar = aIA;
        if (cVar != null) {
            return cVar;
        }
        try {
            aIA = new c();
            com.kwad.sdk.utils.c.a cL = bd.cL(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext());
            if (cL != null && (aVar = cL.bcT) != null) {
                aIA.latitude = aVar.getLatitude();
                aIA.longitude = cL.bcT.getLongitude();
                aIA.type = cL.type;
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return aIA;
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.putValue(jSONObject, "latitude", this.latitude);
        aa.putValue(jSONObject, "longitude", this.longitude);
        aa.putValue(jSONObject, "type", this.type);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }
}
