package com.kwad.sdk.core.webview.c;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.aa;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b implements com.kwad.sdk.core.b {
    public String aNF;
    public String aNG;
    public String data;

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.aNF = jSONObject.optString(com.umeng.ccg.a.f41544t);
        this.data = jSONObject.optString("data");
        this.aNG = jSONObject.optString("callback");
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.putValue(jSONObject, com.umeng.ccg.a.f41544t, this.aNF);
        aa.putValue(jSONObject, "data", this.data);
        aa.putValue(jSONObject, "callback", this.aNG);
        return jSONObject;
    }
}
