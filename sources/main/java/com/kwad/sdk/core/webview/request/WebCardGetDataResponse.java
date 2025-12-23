package com.kwad.sdk.core.webview.request;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.a.d;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.bp;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class WebCardGetDataResponse extends BaseResultData implements com.kwad.sdk.core.b, Serializable {
    private static final String TAG = "WebCardGetDataResponse";
    private static final long serialVersionUID = 2407409365862659643L;
    public JSONObject data;
    public JSONArray impAdInfo;

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject != null) {
            try {
                String optString = jSONObject.optString("impAdInfo");
                if (!bp.isNullString(optString)) {
                    String responseData = d.getResponseData(optString);
                    if (!bp.isNullString(responseData)) {
                        this.impAdInfo = new JSONArray(responseData);
                        return;
                    }
                    return;
                }
                String optString2 = jSONObject.optString("data");
                if (!bp.isNullString(optString2)) {
                    this.data = new JSONObject(d.getResponseData(optString2));
                }
            } catch (Exception e6) {
                c.printStackTrace(e6);
            }
        }
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        JSONObject jSONObject = this.data;
        if (jSONObject != null) {
            aa.putValue(json, "data", jSONObject);
        }
        JSONArray jSONArray = this.impAdInfo;
        if (jSONArray != null) {
            aa.putValue(json, "impAdInfo", jSONArray);
        }
        return json;
    }
}
