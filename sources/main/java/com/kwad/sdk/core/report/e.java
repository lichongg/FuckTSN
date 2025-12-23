package com.kwad.sdk.core.report;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.ab;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class e extends com.kwad.sdk.core.response.a.a {
    public String actionId;
    private JSONObject mMergeJsonData;

    public void setJsonMergeData(JSONObject jSONObject) {
        this.mMergeJsonData = jSONObject;
    }

    @Override // com.kwad.sdk.core.response.a.a
    public void afterParseJson(@Nullable JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        if (jSONObject != null) {
            this.mMergeJsonData = jSONObject.optJSONObject("mMergeJsonData");
        }
    }

    @Override // com.kwad.sdk.core.response.a.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        JSONObject jSONObject2 = this.mMergeJsonData;
        if (jSONObject2 != null) {
            aa.putValue(jSONObject, "mMergeJsonData", jSONObject2);
        }
    }

    public JSONObject buildReportData() {
        JSONObject json = toJson();
        if (this.mMergeJsonData != null) {
            json.remove("mMergeJsonData");
            ab.merge(json, this.mMergeJsonData);
        }
        return json;
    }
}
