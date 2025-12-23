package com.kwad.components.offline.api.core.adlive.model;

import androidx.annotation.Nullable;
import com.kwad.components.offline.api.core.network.model.CommonOfflineCompoResultData;
import java.io.Serializable;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class KSAdLiveEndResultData extends CommonOfflineCompoResultData implements Serializable {
    private static final long serialVersionUID = -6047167317852134995L;
    public KSAdLivePushEndInfo mQLivePushEndInfo = new KSAdLivePushEndInfo();

    @Override // com.kwad.components.offline.api.core.network.model.CommonOfflineCompoResultData
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        parseJson(this, jSONObject);
    }

    @Override // com.kwad.components.offline.api.core.network.model.CommonOfflineCompoResultData
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        toJson(this, json);
        return json;
    }

    public void parseJson(KSAdLiveEndResultData kSAdLiveEndResultData, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        kSAdLiveEndResultData.mQLivePushEndInfo.parseJson(jSONObject);
    }

    public JSONObject toJson(KSAdLiveEndResultData kSAdLiveEndResultData, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        kSAdLiveEndResultData.mQLivePushEndInfo.toJson(jSONObject);
        return jSONObject;
    }
}
