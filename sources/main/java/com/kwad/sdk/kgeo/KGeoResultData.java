package com.kwad.sdk.kgeo;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.a.d;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.aa;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class KGeoResultData extends BaseResultData implements com.kwad.sdk.core.b {
    private static final long serialVersionUID = -4058631267047548112L;
    public KGeoInfo kGeoInfo = new KGeoInfo();

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject != null) {
            try {
                String responseData = d.getResponseData(jSONObject.optString("data"));
                if (!TextUtils.isEmpty(responseData)) {
                    this.kGeoInfo.parseJson(new JSONObject(responseData).optJSONObject("kGeoInfo"));
                }
            } catch (Exception e6) {
                com.kwad.sdk.core.d.c.printStackTrace(e6);
            }
        }
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        aa.a(json, "kGeoInfo", this.kGeoInfo);
        return json;
    }
}
