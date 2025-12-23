package com.kwad.sdk.core.b.a;

import com.amap.api.maps.model.amap3dmodeltile.AMap3DTileBuildType;
import com.kwad.sdk.core.response.model.AdInfo;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class m implements com.kwad.sdk.core.d<AdInfo.AdConversionInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdConversionInfo adConversionInfo, JSONObject jSONObject) {
        a2(adConversionInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdConversionInfo adConversionInfo, JSONObject jSONObject) {
        return b2(adConversionInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.AdConversionInfo adConversionInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adConversionInfo.h5Url = jSONObject.optString("h5Url");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(adConversionInfo.h5Url)) {
            adConversionInfo.h5Url = "";
        }
        adConversionInfo.h5Type = jSONObject.optInt("h5Type");
        adConversionInfo.deeplinkUrl = jSONObject.optString("deeplinkUrl");
        if (obj.toString().equals(adConversionInfo.deeplinkUrl)) {
            adConversionInfo.deeplinkUrl = "";
        }
        adConversionInfo.deeplinkConf = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("deeplinkConf");
        if (optJSONArray != null) {
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                AdInfo.AdConversionInfo.DeeplinkItemInfo deeplinkItemInfo = new AdInfo.AdConversionInfo.DeeplinkItemInfo();
                deeplinkItemInfo.parseJson(optJSONArray.optJSONObject(i6));
                adConversionInfo.deeplinkConf.add(deeplinkItemInfo);
            }
        }
        adConversionInfo.deeplinkExtra = jSONObject.optString("deeplinkExtra");
        Object obj2 = JSONObject.NULL;
        if (obj2.toString().equals(adConversionInfo.deeplinkExtra)) {
            adConversionInfo.deeplinkExtra = "";
        }
        adConversionInfo.adExt = jSONObject.optString("adExt");
        if (obj2.toString().equals(adConversionInfo.adExt)) {
            adConversionInfo.adExt = "";
        }
        adConversionInfo.appSecondConfirmationSwitch = jSONObject.optBoolean("appSecondConfirmationSwitch");
        adConversionInfo.h5SecondConfirmationSwitch = jSONObject.optBoolean("h5SecondConfirmationSwitch");
        adConversionInfo.appDownloadUrl = jSONObject.optString("appDownloadUrl");
        if (obj2.toString().equals(adConversionInfo.appDownloadUrl)) {
            adConversionInfo.appDownloadUrl = "";
        }
        adConversionInfo.marketUrl = jSONObject.optString("marketUrl");
        if (obj2.toString().equals(adConversionInfo.marketUrl)) {
            adConversionInfo.marketUrl = "";
        }
        adConversionInfo.supportThirdDownload = jSONObject.optInt("supportThirdDownload");
        adConversionInfo.retryH5TimeStep = jSONObject.optInt("retryH5TimeStep", new Integer("2000").intValue());
        adConversionInfo.playableUrl = jSONObject.optString("playableUrl");
        if (obj2.toString().equals(adConversionInfo.playableUrl)) {
            adConversionInfo.playableUrl = "";
        }
        AdInfo.PlayableStyleInfo playableStyleInfo = new AdInfo.PlayableStyleInfo();
        adConversionInfo.playableStyleInfo = playableStyleInfo;
        playableStyleInfo.parseJson(jSONObject.optJSONObject("playableStyleInfo"));
        adConversionInfo.liveServiceToken = jSONObject.optString("liveServiceToken");
        if (obj2.toString().equals(adConversionInfo.liveServiceToken)) {
            adConversionInfo.liveServiceToken = "";
        }
        adConversionInfo.liveVisitorId = jSONObject.optLong("liveVisitorId");
        AdInfo.SmallAppJumpInfo smallAppJumpInfo = new AdInfo.SmallAppJumpInfo();
        adConversionInfo.smallAppJumpInfo = smallAppJumpInfo;
        smallAppJumpInfo.parseJson(jSONObject.optJSONObject("smallAppJumpInfo"));
        adConversionInfo.webUriSourceType = jSONObject.optInt("webUriSourceType");
        adConversionInfo.callbackUrl = jSONObject.optString("callbackUrl");
        if (obj2.toString().equals(adConversionInfo.callbackUrl)) {
            adConversionInfo.callbackUrl = "";
        }
        adConversionInfo.callbackUrlInfo = jSONObject.optString("callbackUrlInfo");
        if (obj2.toString().equals(adConversionInfo.callbackUrlInfo)) {
            adConversionInfo.callbackUrlInfo = "";
        }
        adConversionInfo.blockCallbackIfSpam = jSONObject.optBoolean("blockCallbackIfSpam");
        adConversionInfo.needDeeplinkReplaceAdapta = jSONObject.optBoolean("needDeeplinkReplaceAdapta");
        adConversionInfo.interceptH5JumpAppMkt = jSONObject.optBoolean("interceptH5JumpAppMkt");
        adConversionInfo.interceptH5JumpTimeOut = jSONObject.optInt("interceptH5JumpTimeOut", new Integer(Constants.DEFAULT_UIN).intValue());
        adConversionInfo.h5DeeplinkLimitedTimeMs = jSONObject.optInt("h5DeeplinkLimitedTimeMs", new Integer("0").intValue());
        adConversionInfo.playableDeeplinkLimitedTimeMs = jSONObject.optInt("playableDeeplinkLimitedTimeMs", new Integer("0").intValue());
        adConversionInfo.isSupportKeepPlaying = jSONObject.optBoolean("isSupportKeepPlaying");
        adConversionInfo.keepPlayingBackOffTime = jSONObject.optLong("keepPlayingBackOffTime", new Long(AMap3DTileBuildType.HOUSING).longValue());
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo.AdConversionInfo adConversionInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = adConversionInfo.h5Url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "h5Url", adConversionInfo.h5Url);
        }
        int i6 = adConversionInfo.h5Type;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "h5Type", i6);
        }
        String str2 = adConversionInfo.deeplinkUrl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deeplinkUrl", adConversionInfo.deeplinkUrl);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "deeplinkConf", adConversionInfo.deeplinkConf);
        String str3 = adConversionInfo.deeplinkExtra;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deeplinkExtra", adConversionInfo.deeplinkExtra);
        }
        String str4 = adConversionInfo.adExt;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adExt", adConversionInfo.adExt);
        }
        boolean z5 = adConversionInfo.appSecondConfirmationSwitch;
        if (z5) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appSecondConfirmationSwitch", z5);
        }
        boolean z6 = adConversionInfo.h5SecondConfirmationSwitch;
        if (z6) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "h5SecondConfirmationSwitch", z6);
        }
        String str5 = adConversionInfo.appDownloadUrl;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appDownloadUrl", adConversionInfo.appDownloadUrl);
        }
        String str6 = adConversionInfo.marketUrl;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "marketUrl", adConversionInfo.marketUrl);
        }
        int i7 = adConversionInfo.supportThirdDownload;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "supportThirdDownload", i7);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "retryH5TimeStep", adConversionInfo.retryH5TimeStep);
        String str7 = adConversionInfo.playableUrl;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "playableUrl", adConversionInfo.playableUrl);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "playableStyleInfo", adConversionInfo.playableStyleInfo);
        String str8 = adConversionInfo.liveServiceToken;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "liveServiceToken", adConversionInfo.liveServiceToken);
        }
        long j6 = adConversionInfo.liveVisitorId;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "liveVisitorId", j6);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "smallAppJumpInfo", adConversionInfo.smallAppJumpInfo);
        int i8 = adConversionInfo.webUriSourceType;
        if (i8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "webUriSourceType", i8);
        }
        String str9 = adConversionInfo.callbackUrl;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "callbackUrl", adConversionInfo.callbackUrl);
        }
        String str10 = adConversionInfo.callbackUrlInfo;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "callbackUrlInfo", adConversionInfo.callbackUrlInfo);
        }
        boolean z7 = adConversionInfo.blockCallbackIfSpam;
        if (z7) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "blockCallbackIfSpam", z7);
        }
        boolean z8 = adConversionInfo.needDeeplinkReplaceAdapta;
        if (z8) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "needDeeplinkReplaceAdapta", z8);
        }
        boolean z9 = adConversionInfo.interceptH5JumpAppMkt;
        if (z9) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "interceptH5JumpAppMkt", z9);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "interceptH5JumpTimeOut", adConversionInfo.interceptH5JumpTimeOut);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "h5DeeplinkLimitedTimeMs", adConversionInfo.h5DeeplinkLimitedTimeMs);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "playableDeeplinkLimitedTimeMs", adConversionInfo.playableDeeplinkLimitedTimeMs);
        boolean z10 = adConversionInfo.isSupportKeepPlaying;
        if (z10) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isSupportKeepPlaying", z10);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "keepPlayingBackOffTime", adConversionInfo.keepPlayingBackOffTime);
        return jSONObject;
    }
}
