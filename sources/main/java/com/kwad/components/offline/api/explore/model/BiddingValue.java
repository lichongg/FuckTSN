package com.kwad.components.offline.api.explore.model;

import com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse;
import java.io.Serializable;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class BiddingValue extends BaseOfflineCompoJsonParse<BiddingValue> implements Serializable {
    private static final long serialVersionUID = -6149616231567033423L;
    public double biddingRitCpm;

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public void parseJson(BiddingValue biddingValue, JSONObject jSONObject) {
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(BiddingValue biddingValue, JSONObject jSONObject) {
        return jSONObject == null ? new JSONObject() : jSONObject;
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(BiddingValue biddingValue) {
        return toJson(biddingValue, (JSONObject) null);
    }
}
