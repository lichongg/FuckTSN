package com.kwad.sdk.commercial.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.aa;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a implements b {
    public int adOperationType;
    public int campaignType;
    public int industryFirstLevelId;
    public int ocpcActionType;
    public int webUriSourceType;

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.putValue(jSONObject, "campaign_type", this.campaignType);
        aa.putValue(jSONObject, "ocpc_action_type", this.ocpcActionType);
        aa.putValue(jSONObject, "industry_first_level_id", this.industryFirstLevelId);
        aa.putValue(jSONObject, "ad_operation_type", this.adOperationType);
        aa.putValue(jSONObject, "web_uri_source_type", this.webUriSourceType);
        return jSONObject;
    }

    public a(AdInfo adInfo) {
        if (adInfo != null) {
            this.campaignType = com.kwad.sdk.core.response.b.a.m121do(adInfo);
            this.ocpcActionType = com.kwad.sdk.core.response.b.a.dp(adInfo);
            this.industryFirstLevelId = com.kwad.sdk.core.response.b.a.dq(adInfo);
            this.adOperationType = com.kwad.sdk.core.response.b.a.aQ(adInfo);
            this.webUriSourceType = com.kwad.sdk.core.response.b.a.dr(adInfo);
        }
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }
}
