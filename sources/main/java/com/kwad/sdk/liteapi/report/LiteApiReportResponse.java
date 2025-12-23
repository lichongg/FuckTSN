package com.kwad.sdk.liteapi.report;

import androidx.annotation.Keep;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public class LiteApiReportResponse {
    String errorMsg;
    long result;

    boolean isLegal() {
        return this.result == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.result = jSONObject.optLong("result");
        this.errorMsg = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
    }

    public String toString() {
        return "LiteApiReportResponse{result=" + this.result + ", errorMsg='" + this.errorMsg + "'}";
    }
}
