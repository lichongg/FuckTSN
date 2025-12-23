package com.kwad.sdk.core.network;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.BaseResultData;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class BaseRealData extends BaseResultData {
    protected abstract void parseData(@NonNull JSONObject jSONObject);

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            String responseData = com.kwad.sdk.core.a.d.getResponseData(jSONObject.optString("data"));
            if (responseData != null && !responseData.isEmpty()) {
                parseData(new JSONObject(responseData));
            } else {
                this.result = 0;
            }
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTrace(e6);
            this.result = 0;
            this.errorMsg = e6.getMessage();
        }
    }
}
