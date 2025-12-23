package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ao implements com.kwad.sdk.core.d<AdInfo.AdRewardInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdRewardInfo adRewardInfo, JSONObject jSONObject) {
        a2(adRewardInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdRewardInfo adRewardInfo, JSONObject jSONObject) {
        return b2(adRewardInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.AdRewardInfo adRewardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adRewardInfo.skipShowTime = jSONObject.optInt("skipShowTime", new Integer("30").intValue());
        adRewardInfo.rewardTime = jSONObject.optInt("rewardTime", new Integer("30").intValue());
        adRewardInfo.showLandingPage = jSONObject.optInt("showLandingPage");
        adRewardInfo.rewardVideoEndCardSwitch = jSONObject.optBoolean("rewardVideoEndCardSwitch");
        adRewardInfo.recommendAggregateSwitch = jSONObject.optBoolean("recommendAggregateSwitch");
        AdInfo.CallBackStrategyInfo callBackStrategyInfo = new AdInfo.CallBackStrategyInfo();
        adRewardInfo.callBackStrategyInfo = callBackStrategyInfo;
        callBackStrategyInfo.parseJson(jSONObject.optJSONObject("callBackStrategyInfo"));
        AdInfo.RewardFraudVerifyInfo rewardFraudVerifyInfo = new AdInfo.RewardFraudVerifyInfo();
        adRewardInfo.rewardFraudVerifyInfo = rewardFraudVerifyInfo;
        rewardFraudVerifyInfo.parseJson(jSONObject.optJSONObject("rewardFraudVerifyInfo"));
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo.AdRewardInfo adRewardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "skipShowTime", adRewardInfo.skipShowTime);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "rewardTime", adRewardInfo.rewardTime);
        int i6 = adRewardInfo.showLandingPage;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "showLandingPage", i6);
        }
        boolean z5 = adRewardInfo.rewardVideoEndCardSwitch;
        if (z5) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "rewardVideoEndCardSwitch", z5);
        }
        boolean z6 = adRewardInfo.recommendAggregateSwitch;
        if (z6) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "recommendAggregateSwitch", z6);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "callBackStrategyInfo", adRewardInfo.callBackStrategyInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "rewardFraudVerifyInfo", adRewardInfo.rewardFraudVerifyInfo);
        return jSONObject;
    }
}
