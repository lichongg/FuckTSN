package com.kwad.components.core.webview.tachikoma.c;

import com.kwad.sdk.utils.aa;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class l extends com.kwad.sdk.core.response.a.a {
    public int ahc;
    public int ahd = -1;
    public int ahe;

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.putValue(jSONObject, "insertScreenAdShowStrategy", this.ahc);
        aa.putValue(jSONObject, "isAutoShow", this.ahe);
        int i6 = this.ahd;
        if (i6 != -1) {
            aa.putValue(jSONObject, "triggerType", i6);
        }
        return jSONObject;
    }
}
