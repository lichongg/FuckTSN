package com.kwad.sdk.mobileid.model;

import androidx.annotation.Nullable;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.kwad.sdk.core.response.a.a;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bp;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class CMTokenResponse extends BaseResultData implements Serializable {
    private static final long serialVersionUID = -8501365728042530876L;
    public Header mHeader = new Header();
    public Body mBody = new Body();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Body extends a implements Serializable {
        private static final long serialVersionUID = -4941153252697477901L;
        public String mResultCode;
        public String mResultDesc;
        public String mToken;

        @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
        public void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.mResultCode = jSONObject.optString("resultCode");
            this.mResultDesc = jSONObject.optString("resultDesc");
            this.mToken = jSONObject.optString(JThirdPlatFormInterface.KEY_TOKEN);
        }

        @Override // com.kwad.sdk.core.response.a.a
        public String toString() {
            return "Body{mResultCode='" + this.mResultCode + "', mResultDesc='" + this.mResultDesc + "', mToken='" + this.mToken + "'}";
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Header extends a implements Serializable {
        private static final long serialVersionUID = -1244494639407773564L;
        public String mAppId;
        public String mTimestamp;
        public String mTraceId;

        @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
        public void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.mTraceId = jSONObject.optString("traceId");
            this.mTimestamp = jSONObject.optString("timestamp");
            this.mAppId = jSONObject.optString("appId");
        }

        @Override // com.kwad.sdk.core.response.a.a
        public String toString() {
            return "Header{mTraceId='" + this.mTraceId + "', mTimestamp='" + this.mTimestamp + "', mAppId='" + this.mAppId + "'}";
        }
    }

    public String getResultCode() {
        return this.mBody.mResultCode;
    }

    public String getResultMsg() {
        return this.mBody.mResultDesc;
    }

    public String getResultToken() {
        return this.mBody.mToken;
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData
    public boolean isResultOk() {
        String str = this.mBody.mResultCode;
        return str != null && str.equals("103000");
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            String optString = jSONObject.optString("header");
            String optString2 = jSONObject.optString("body");
            if (bp.isNullString(optString)) {
                return;
            }
            try {
                JSONObject jSONObject2 = new JSONObject(optString);
                Header header = new Header();
                this.mHeader = header;
                header.parseJson(jSONObject2);
                JSONObject jSONObject3 = new JSONObject(optString2);
                Body body = new Body();
                this.mBody = body;
                body.parseJson(jSONObject3);
            } catch (JSONException e6) {
                ServiceProvider.reportSdkCaughtException(e6);
            }
        } catch (Throwable unused) {
        }
    }

    public String toString() {
        return "UaidTokenResponse{mHeader=" + this.mHeader + ", mBody=" + this.mBody + '}';
    }
}
