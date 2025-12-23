package com.kwad.components.core.request;

import android.text.TextUtils;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aa;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class f extends com.kwad.sdk.core.network.d {
    public long requestStartTime;

    public f(int i6, AdTemplate adTemplate) {
        String bS = com.kwad.sdk.core.response.b.a.bS(com.kwad.sdk.core.response.b.e.el(adTemplate));
        try {
            String bT = com.kwad.sdk.core.response.b.a.bT(com.kwad.sdk.core.response.b.e.el(adTemplate));
            try {
                if (!TextUtils.isEmpty(bT)) {
                    putBody("serverExt", new JSONObject(bT));
                }
            } catch (JSONException e6) {
                com.kwad.sdk.core.d.c.printStackTrace(e6);
            }
            if (!TextUtils.isEmpty(bS) && bS != null) {
                JSONObject jSONObject = new JSONObject(bS);
                aa.putValue(jSONObject, "checkType", i6);
                putBody("callbackUrlInfo", jSONObject.toString());
            }
        } catch (Exception e7) {
            com.kwad.sdk.core.d.c.printStackTrace(e7);
        }
        ImpInfo impInfo = new ImpInfo(adTemplate.mAdScene);
        JSONArray jSONArray = new JSONArray();
        aa.a(jSONArray, impInfo.toJson());
        putBody("impInfo", jSONArray);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return com.kwad.sdk.h.AV();
    }
}
