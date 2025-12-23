package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.reward.model.RewardFraudVerifyRespInfo;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ev implements com.kwad.sdk.core.d<RewardFraudVerifyRespInfo.FraudDataInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(RewardFraudVerifyRespInfo.FraudDataInfo fraudDataInfo, JSONObject jSONObject) {
        a2(fraudDataInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(RewardFraudVerifyRespInfo.FraudDataInfo fraudDataInfo, JSONObject jSONObject) {
        return b2(fraudDataInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(RewardFraudVerifyRespInfo.FraudDataInfo fraudDataInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        fraudDataInfo.fraud = jSONObject.optBoolean("fraud");
        fraudDataInfo.code = jSONObject.optInt("code");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(RewardFraudVerifyRespInfo.FraudDataInfo fraudDataInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z5 = fraudDataInfo.fraud;
        if (z5) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "fraud", z5);
        }
        int i6 = fraudDataInfo.code;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "code", i6);
        }
        return jSONObject;
    }
}
