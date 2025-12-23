package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class aq implements com.kwad.sdk.core.d<AdInfo.AdSplashInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdSplashInfo adSplashInfo, JSONObject jSONObject) {
        a2(adSplashInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdSplashInfo adSplashInfo, JSONObject jSONObject) {
        return b2(adSplashInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.AdSplashInfo adSplashInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adSplashInfo.logoPosition = jSONObject.optInt("logoPosition", new Integer("1").intValue());
        adSplashInfo.mute = jSONObject.optInt("mute", new Integer("1").intValue());
        adSplashInfo.skipType = jSONObject.optInt("skipType");
        adSplashInfo.skipTips = jSONObject.optString("skipTips");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(adSplashInfo.skipTips)) {
            adSplashInfo.skipTips = "";
        }
        adSplashInfo.speakerMuteIconUrl = jSONObject.optString("speakerMuteIconUrl");
        if (obj.toString().equals(adSplashInfo.speakerMuteIconUrl)) {
            adSplashInfo.speakerMuteIconUrl = "";
        }
        adSplashInfo.speakerIconUrl = jSONObject.optString("speakerIconUrl");
        if (obj.toString().equals(adSplashInfo.speakerIconUrl)) {
            adSplashInfo.speakerIconUrl = "";
        }
        adSplashInfo.imageDisplaySecond = jSONObject.optInt("imageDisplaySecond", new Integer("5").intValue());
        adSplashInfo.videoDisplaySecond = jSONObject.optInt("videoDisplaySecond", new Integer("5").intValue());
        adSplashInfo.countdownShow = jSONObject.optInt("countdownShow");
        adSplashInfo.fullScreenClickSwitch = jSONObject.optInt("fullScreenClickSwitch");
        adSplashInfo.skipButtonPosition = jSONObject.optInt("skipButtonPosition");
        adSplashInfo.splashShowClickButtonSwitch = jSONObject.optInt("splashShowClickButtonSwitch", new Integer("1").intValue());
        adSplashInfo.skipSecond = jSONObject.optInt("skipSecond");
        adSplashInfo.impressionStatisticalChangeSwitch = jSONObject.optBoolean("impressionStatisticalChangeSwitch");
        adSplashInfo.impressionLimitSize = jSONObject.optDouble("impressionLimitSize");
        AdInfo.CutRuleInfo cutRuleInfo = new AdInfo.CutRuleInfo();
        adSplashInfo.cutRuleInfo = cutRuleInfo;
        cutRuleInfo.parseJson(jSONObject.optJSONObject("cutRuleInfo"));
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo.AdSplashInfo adSplashInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "logoPosition", adSplashInfo.logoPosition);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "mute", adSplashInfo.mute);
        int i6 = adSplashInfo.skipType;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "skipType", i6);
        }
        String str = adSplashInfo.skipTips;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "skipTips", adSplashInfo.skipTips);
        }
        String str2 = adSplashInfo.speakerMuteIconUrl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "speakerMuteIconUrl", adSplashInfo.speakerMuteIconUrl);
        }
        String str3 = adSplashInfo.speakerIconUrl;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "speakerIconUrl", adSplashInfo.speakerIconUrl);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "imageDisplaySecond", adSplashInfo.imageDisplaySecond);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "videoDisplaySecond", adSplashInfo.videoDisplaySecond);
        int i7 = adSplashInfo.countdownShow;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "countdownShow", i7);
        }
        int i8 = adSplashInfo.fullScreenClickSwitch;
        if (i8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "fullScreenClickSwitch", i8);
        }
        int i9 = adSplashInfo.skipButtonPosition;
        if (i9 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "skipButtonPosition", i9);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "splashShowClickButtonSwitch", adSplashInfo.splashShowClickButtonSwitch);
        int i10 = adSplashInfo.skipSecond;
        if (i10 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "skipSecond", i10);
        }
        boolean z5 = adSplashInfo.impressionStatisticalChangeSwitch;
        if (z5) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "impressionStatisticalChangeSwitch", z5);
        }
        double d6 = adSplashInfo.impressionLimitSize;
        if (d6 != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "impressionLimitSize", d6);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "cutRuleInfo", adSplashInfo.cutRuleInfo);
        return jSONObject;
    }
}
