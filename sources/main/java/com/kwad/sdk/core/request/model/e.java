package com.kwad.sdk.core.request.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.network.k;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aa;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class e implements com.kwad.sdk.core.b {
    private com.kwad.sdk.core.b aIE;

    public static e IO() {
        e eVar = new e();
        try {
            eVar.aIE = ((k) ServiceProvider.get(k.class)).Bf();
            return eVar;
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
            return eVar;
        }
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.a(jSONObject, "modeInfo", this.aIE);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }
}
