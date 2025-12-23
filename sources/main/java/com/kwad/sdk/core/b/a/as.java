package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class as implements com.kwad.sdk.core.d<AdInfo.AdStyleConfInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdStyleConfInfo adStyleConfInfo, JSONObject jSONObject) {
        a2(adStyleConfInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdStyleConfInfo adStyleConfInfo, JSONObject jSONObject) {
        return b2(adStyleConfInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.AdStyleConfInfo adStyleConfInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adStyleConfInfo.fullScreenSkipShowTime = jSONObject.optInt("fullScreenSkipShowTime", new Integer("5").intValue());
        adStyleConfInfo.rewardSkipConfirmSwitch = jSONObject.optInt("rewardSkipConfirmSwitch", new Integer("1").intValue());
        adStyleConfInfo.closeDelaySeconds = jSONObject.optLong("closeDelaySeconds");
        adStyleConfInfo.playableCloseSeconds = jSONObject.optLong("playableCloseSeconds");
        adStyleConfInfo.rewardVideoInteractSwitch = jSONObject.optBoolean("rewardVideoInteractSwitch");
        AdInfo.AdShowVideoH5Info adShowVideoH5Info = new AdInfo.AdShowVideoH5Info();
        adStyleConfInfo.adShowVideoH5Info = adShowVideoH5Info;
        adShowVideoH5Info.parseJson(jSONObject.optJSONObject("adShowVideoH5Info"));
        adStyleConfInfo.adPushSwitch = jSONObject.optBoolean("adPushSwitch");
        adStyleConfInfo.adPushShowAfterTime = jSONObject.optInt("adPushShowAfterTime");
        adStyleConfInfo.adPushIntervalTime = jSONObject.optInt("adPushIntervalTime", new Integer("900").intValue());
        AdInfo.NativeAdInfo nativeAdInfo = new AdInfo.NativeAdInfo();
        adStyleConfInfo.nativeAdInfo = nativeAdInfo;
        nativeAdInfo.parseJson(jSONObject.optJSONObject("nativeAdInfo"));
        adStyleConfInfo.useNativeForOuterLiveAd = jSONObject.optBoolean("useNativeForOuterLiveAd");
        adStyleConfInfo.adPushDownloadJumpType = jSONObject.optInt("adPushDownloadJumpType");
        adStyleConfInfo.actionBarType = jSONObject.optInt("actionBarType");
        adStyleConfInfo.endCardType = jSONObject.optInt("endCardType");
        adStyleConfInfo.confirmCardType = jSONObject.optInt("confirmCardType");
        adStyleConfInfo.innerAdType = jSONObject.optInt("innerAdType");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo.AdStyleConfInfo adStyleConfInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "fullScreenSkipShowTime", adStyleConfInfo.fullScreenSkipShowTime);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "rewardSkipConfirmSwitch", adStyleConfInfo.rewardSkipConfirmSwitch);
        long j6 = adStyleConfInfo.closeDelaySeconds;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "closeDelaySeconds", j6);
        }
        long j7 = adStyleConfInfo.playableCloseSeconds;
        if (j7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "playableCloseSeconds", j7);
        }
        boolean z5 = adStyleConfInfo.rewardVideoInteractSwitch;
        if (z5) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "rewardVideoInteractSwitch", z5);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "adShowVideoH5Info", adStyleConfInfo.adShowVideoH5Info);
        boolean z6 = adStyleConfInfo.adPushSwitch;
        if (z6) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adPushSwitch", z6);
        }
        int i6 = adStyleConfInfo.adPushShowAfterTime;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adPushShowAfterTime", i6);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "adPushIntervalTime", adStyleConfInfo.adPushIntervalTime);
        com.kwad.sdk.utils.aa.a(jSONObject, "nativeAdInfo", adStyleConfInfo.nativeAdInfo);
        boolean z7 = adStyleConfInfo.useNativeForOuterLiveAd;
        if (z7) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "useNativeForOuterLiveAd", z7);
        }
        int i7 = adStyleConfInfo.adPushDownloadJumpType;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adPushDownloadJumpType", i7);
        }
        int i8 = adStyleConfInfo.actionBarType;
        if (i8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "actionBarType", i8);
        }
        int i9 = adStyleConfInfo.endCardType;
        if (i9 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "endCardType", i9);
        }
        int i10 = adStyleConfInfo.confirmCardType;
        if (i10 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "confirmCardType", i10);
        }
        int i11 = adStyleConfInfo.innerAdType;
        if (i11 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "innerAdType", i11);
        }
        return jSONObject;
    }
}
