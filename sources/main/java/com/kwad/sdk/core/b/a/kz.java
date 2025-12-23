package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.reward.k.r;
import com.kwad.components.ad.reward.model.RewardFraudVerifyRespInfo;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class kz implements com.kwad.sdk.core.d<r.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(r.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(r.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(r.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        RewardFraudVerifyRespInfo.FraudDataInfo fraudDataInfo = new RewardFraudVerifyRespInfo.FraudDataInfo();
        aVar.AL = fraudDataInfo;
        fraudDataInfo.parseJson(jSONObject.optJSONObject("verifyResult"));
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(r.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "verifyResult", aVar.AL);
        return jSONObject;
    }
}
