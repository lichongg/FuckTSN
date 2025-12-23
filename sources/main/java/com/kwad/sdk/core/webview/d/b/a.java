package com.kwad.sdk.core.webview.d.b;

import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bp;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsJson
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a extends com.kwad.sdk.core.response.a.a {

    @Deprecated
    public boolean OU;
    public String Pv;
    public int aNO;
    public int aNP;

    @Deprecated
    public boolean adL;
    public int adN;
    public d adO;
    public AdTemplate adTemplate;
    public int mI;
    public boolean Ph = true;
    public long creativeId = -1;
    public int adStyle = -1;
    public boolean aNQ = false;
    public boolean aNR = false;

    public final boolean KY() {
        return 1 == this.adN;
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        try {
            if (this.mI == 0 && this.aNP == 0) {
                if (jSONObject != null && jSONObject.has("logParam")) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("logParam");
                    this.mI = optJSONObject.getInt("itemClickType");
                    this.aNP = optJSONObject.getInt("sceneType");
                    this.aNQ = optJSONObject.optBoolean("isCallbackOnly");
                }
                String optString = jSONObject.optString("adTemplate");
                if (bp.isNullString(optString)) {
                    return;
                }
                try {
                    JSONObject jSONObject2 = new JSONObject(optString);
                    AdTemplate adTemplate = new AdTemplate();
                    this.adTemplate = adTemplate;
                    adTemplate.parseJson(jSONObject2);
                } catch (JSONException e6) {
                    ServiceProvider.reportSdkCaughtException(e6);
                }
            }
        } catch (Throwable unused) {
        }
    }
}
