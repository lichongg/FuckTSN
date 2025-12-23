package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ge implements com.kwad.sdk.core.d<AdMatrixInfo.InterstitialCardInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.InterstitialCardInfo interstitialCardInfo, JSONObject jSONObject) {
        a2(interstitialCardInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.InterstitialCardInfo interstitialCardInfo, JSONObject jSONObject) {
        return b2(interstitialCardInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdMatrixInfo.InterstitialCardInfo interstitialCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        AdMatrixInfo.AdInteractionInfo adInteractionInfo = new AdMatrixInfo.AdInteractionInfo();
        interstitialCardInfo.interactionInfo = adInteractionInfo;
        adInteractionInfo.parseJson(jSONObject.optJSONObject("interactionInfo"));
        AdMatrixInfo.CycleAggregateInfo cycleAggregateInfo = new AdMatrixInfo.CycleAggregateInfo();
        interstitialCardInfo.cycleAggregateInfo = cycleAggregateInfo;
        cycleAggregateInfo.parseJson(jSONObject.optJSONObject("cycleAggregateInfo"));
        interstitialCardInfo.closeAfterClick = jSONObject.optBoolean("closeAfterClick", new Boolean("false").booleanValue());
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdMatrixInfo.InterstitialCardInfo interstitialCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "interactionInfo", interstitialCardInfo.interactionInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "cycleAggregateInfo", interstitialCardInfo.cycleAggregateInfo);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "closeAfterClick", interstitialCardInfo.closeAfterClick);
        return jSONObject;
    }
}
