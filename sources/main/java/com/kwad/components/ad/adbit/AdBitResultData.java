package com.kwad.components.ad.adbit;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class AdBitResultData extends AdResultData {
    private static final long serialVersionUID = -3932631606478587475L;
    public List<AdBid> adBidList;
    public String adxId;

    public AdBitResultData(SceneImpl sceneImpl) {
        super(sceneImpl);
        this.adBidList = new ArrayList();
    }

    @Override // com.kwad.sdk.core.response.model.AdResultData, com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        super.parseJson(jSONObject);
        try {
            this.adxId = jSONObject.optString("adxId");
            String optString = jSONObject.optString("adBids");
            if (!TextUtils.isEmpty(optString)) {
                JSONArray jSONArray = new JSONArray(optString);
                if (jSONArray.length() > 0) {
                    for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i6);
                        if (optJSONObject != null) {
                            AdBid adBid = new AdBid();
                            adBid.parseJson(optJSONObject);
                            this.adBidList.add(adBid);
                        }
                    }
                }
            }
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
        }
    }
}
