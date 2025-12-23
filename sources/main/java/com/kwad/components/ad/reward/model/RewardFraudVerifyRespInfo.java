package com.kwad.components.ad.reward.model;

import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.a.e;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.bp;
import java.io.Serializable;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class RewardFraudVerifyRespInfo extends BaseResultData {
    private static final long serialVersionUID = -8657363515914699792L;
    private FraudDataInfo data = new FraudDataInfo();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsJson
    public static class FraudDataInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = -8657363515914699792L;
        public int code;
        public boolean fraud;

        public int getCode() {
            return this.code;
        }

        public boolean isFraud() {
            return this.fraud;
        }
    }

    public int getCode() {
        return this.data.getCode();
    }

    public boolean isFraud() {
        return this.data.isFraud();
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData
    public JSONObject baseToJson() {
        JSONObject json = super.toJson();
        aa.a(json, "data", this.data);
        return json;
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        try {
            String optString = jSONObject.optString("data");
            if (!bp.isNullString(optString)) {
                optString = ((e) com.kwad.sdk.components.d.f(e.class)).getResponseData(optString);
            }
            this.data.parseJson(new JSONObject(optString));
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTrace(e6);
        }
    }
}
