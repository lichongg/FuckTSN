package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ip implements com.kwad.sdk.core.d<AdStyleInfo.PlayEndInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdStyleInfo.PlayEndInfo playEndInfo, JSONObject jSONObject) {
        a2(playEndInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdStyleInfo.PlayEndInfo playEndInfo, JSONObject jSONObject) {
        return b2(playEndInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdStyleInfo.PlayEndInfo playEndInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        playEndInfo.type = jSONObject.optInt("type");
        playEndInfo.showLandingPage3 = jSONObject.optInt("showLandingPage3");
        AdStyleInfo.PlayEndInfo.AdWebCardInfo adWebCardInfo = new AdStyleInfo.PlayEndInfo.AdWebCardInfo();
        playEndInfo.adWebCardInfo = adWebCardInfo;
        adWebCardInfo.parseJson(jSONObject.optJSONObject("adWebCardInfo"));
        AdStyleInfo.PlayEndInfo.EndTopToolBarInfo endTopToolBarInfo = new AdStyleInfo.PlayEndInfo.EndTopToolBarInfo();
        playEndInfo.endTopToolBarInfo = endTopToolBarInfo;
        endTopToolBarInfo.parseJson(jSONObject.optJSONObject("endTopToolBarInfo"));
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdStyleInfo.PlayEndInfo playEndInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = playEndInfo.type;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "type", i6);
        }
        int i7 = playEndInfo.showLandingPage3;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "showLandingPage3", i7);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "adWebCardInfo", playEndInfo.adWebCardInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "endTopToolBarInfo", playEndInfo.endTopToolBarInfo);
        return jSONObject;
    }
}
