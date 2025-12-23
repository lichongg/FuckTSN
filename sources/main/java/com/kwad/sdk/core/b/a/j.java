package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.ABParams;
import com.kwad.sdk.core.response.model.AdInfo;
import com.qq.e.comm.constants.Constants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class j implements com.kwad.sdk.core.d<AdInfo.AdBaseInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdBaseInfo adBaseInfo, JSONObject jSONObject) {
        a2(adBaseInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdBaseInfo adBaseInfo, JSONObject jSONObject) {
        return b2(adBaseInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.AdBaseInfo adBaseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adBaseInfo.creativeId = jSONObject.optLong("creativeId");
        adBaseInfo.adSourceType = jSONObject.optInt("adSourceType");
        adBaseInfo.liveStreamId = jSONObject.optString("liveStreamId");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(adBaseInfo.liveStreamId)) {
            adBaseInfo.liveStreamId = "";
        }
        adBaseInfo.roiType = jSONObject.optInt("roiType");
        adBaseInfo.liveDisplayWatchingCount = jSONObject.optLong("liveDisplayWatchingCount");
        adBaseInfo.universeLiveType = jSONObject.optInt("universeLiveType");
        adBaseInfo.viewCount = jSONObject.optLong("viewCount");
        adBaseInfo.sdkExtraData = jSONObject.optString("sdkExtraData");
        if (obj.toString().equals(adBaseInfo.sdkExtraData)) {
            adBaseInfo.sdkExtraData = "";
        }
        adBaseInfo.adDescription = jSONObject.optString("adDescription");
        if (obj.toString().equals(adBaseInfo.adDescription)) {
            adBaseInfo.adDescription = "";
        }
        adBaseInfo.installAppLabel = jSONObject.optString("installAppLabel");
        if (obj.toString().equals(adBaseInfo.installAppLabel)) {
            adBaseInfo.installAppLabel = "";
        }
        adBaseInfo.openAppLabel = jSONObject.optString("openAppLabel");
        if (obj.toString().equals(adBaseInfo.openAppLabel)) {
            adBaseInfo.openAppLabel = "";
        }
        adBaseInfo.adMarkIcon = jSONObject.optString("adMarkIcon");
        if (obj.toString().equals(adBaseInfo.adMarkIcon)) {
            adBaseInfo.adMarkIcon = "";
        }
        adBaseInfo.adGrayMarkIcon = jSONObject.optString("adGrayMarkIcon");
        if (obj.toString().equals(adBaseInfo.adGrayMarkIcon)) {
            adBaseInfo.adGrayMarkIcon = "";
        }
        adBaseInfo.adSourceDescription = jSONObject.optString("adSourceDescription");
        if (obj.toString().equals(adBaseInfo.adSourceDescription)) {
            adBaseInfo.adSourceDescription = "";
        }
        adBaseInfo.adOperationType = jSONObject.optInt("adOperationType");
        adBaseInfo.adActionDescription = jSONObject.optString("adActionDescription");
        if (obj.toString().equals(adBaseInfo.adActionDescription)) {
            adBaseInfo.adActionDescription = "";
        }
        adBaseInfo.adActionBarColor = jSONObject.optString("adActionBarColor");
        if (obj.toString().equals(adBaseInfo.adActionBarColor)) {
            adBaseInfo.adActionBarColor = "";
        }
        adBaseInfo.adShowDuration = jSONObject.optInt("adShowDuration");
        adBaseInfo.appName = jSONObject.optString("appName");
        if (obj.toString().equals(adBaseInfo.appName)) {
            adBaseInfo.appName = "";
        }
        adBaseInfo.realAppName = jSONObject.optString("realAppName");
        if (obj.toString().equals(adBaseInfo.realAppName)) {
            adBaseInfo.realAppName = "";
        }
        adBaseInfo.appIconUrl = jSONObject.optString("appIconUrl");
        if (obj.toString().equals(adBaseInfo.appIconUrl)) {
            adBaseInfo.appIconUrl = "";
        }
        adBaseInfo.appPackageName = jSONObject.optString("appPackageName");
        if (obj.toString().equals(adBaseInfo.appPackageName)) {
            adBaseInfo.appPackageName = "";
        }
        adBaseInfo.appScore = jSONObject.optInt("appScore");
        adBaseInfo.appDownloadCountDesc = jSONObject.optString("appDownloadCountDesc");
        if (obj.toString().equals(adBaseInfo.appDownloadCountDesc)) {
            adBaseInfo.appDownloadCountDesc = "";
        }
        adBaseInfo.appCategory = jSONObject.optString("appCategory");
        if (obj.toString().equals(adBaseInfo.appCategory)) {
            adBaseInfo.appCategory = "";
        }
        adBaseInfo.appVersion = jSONObject.optString("appVersion");
        if (obj.toString().equals(adBaseInfo.appVersion)) {
            adBaseInfo.appVersion = "";
        }
        adBaseInfo.corporationName = jSONObject.optString("corporationName");
        if (obj.toString().equals(adBaseInfo.corporationName)) {
            adBaseInfo.corporationName = "";
        }
        adBaseInfo.packageSize = jSONObject.optLong("packageSize");
        adBaseInfo.appImageUrl = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("appImageUrl");
        if (optJSONArray != null) {
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                adBaseInfo.appImageUrl.add((String) optJSONArray.opt(i6));
            }
        }
        AdInfo.MaterialSize materialSize = new AdInfo.MaterialSize();
        adBaseInfo.appImageSize = materialSize;
        materialSize.parseJson(jSONObject.optJSONObject("appImageSize"));
        adBaseInfo.appDescription = jSONObject.optString("appDescription");
        Object obj2 = JSONObject.NULL;
        if (obj2.toString().equals(adBaseInfo.appDescription)) {
            adBaseInfo.appDescription = "";
        }
        adBaseInfo.enableSkipAd = jSONObject.optInt("enableSkipAd");
        adBaseInfo.adCacheSwitch = jSONObject.optInt("adCacheSwitch", new Integer("0").intValue());
        adBaseInfo.adCacheSecond = jSONObject.optLong("adCacheSecond", new Long("1800").longValue());
        adBaseInfo.adCacheStrategy = jSONObject.optInt("adCacheStrategy", new Integer("1").intValue());
        adBaseInfo.adCacheSize = jSONObject.optInt("adCacheSize", new Integer("1").intValue());
        adBaseInfo.adRolloutSize = jSONObject.optInt("adRolloutSize");
        adBaseInfo.skipSecond = jSONObject.optInt("skipSecond");
        adBaseInfo.ecpm = jSONObject.optInt("ecpm");
        adBaseInfo.videoPlayedNS = jSONObject.optString("videoPlayedNS");
        if (obj2.toString().equals(adBaseInfo.videoPlayedNS)) {
            adBaseInfo.videoPlayedNS = "";
        }
        adBaseInfo.videoPlayedNSConfig = jSONObject.optString("videoPlayedNSConfig");
        if (obj2.toString().equals(adBaseInfo.videoPlayedNSConfig)) {
            adBaseInfo.videoPlayedNSConfig = "";
        }
        adBaseInfo.productName = jSONObject.optString("productName");
        if (obj2.toString().equals(adBaseInfo.productName)) {
            adBaseInfo.productName = "";
        }
        ABParams aBParams = new ABParams();
        adBaseInfo.mABParams = aBParams;
        try {
            aBParams.parseJson(new JSONObject(jSONObject.optString("expParam")));
        } catch (Exception unused) {
        }
        adBaseInfo.showUrl = jSONObject.optString("showUrl");
        Object obj3 = JSONObject.NULL;
        if (obj3.toString().equals(adBaseInfo.showUrl)) {
            adBaseInfo.showUrl = "";
        }
        adBaseInfo.clickUrl = jSONObject.optString(Constants.KEYS.EXPOSED_CLICK_URL_KEY);
        if (obj3.toString().equals(adBaseInfo.clickUrl)) {
            adBaseInfo.clickUrl = "";
        }
        adBaseInfo.convUrl = jSONObject.optString("convUrl");
        if (obj3.toString().equals(adBaseInfo.convUrl)) {
            adBaseInfo.convUrl = "";
        }
        adBaseInfo.adAttributeType = jSONObject.optInt("adAttributeType");
        AdInfo.H5Config h5Config = new AdInfo.H5Config();
        adBaseInfo.apiExpParam = h5Config;
        h5Config.parseJson(jSONObject.optJSONObject("apiExpParam"));
        adBaseInfo.taskType = jSONObject.optInt("taskType");
        adBaseInfo.campaignType = jSONObject.optInt("campaignType");
        adBaseInfo.itemType = jSONObject.optInt("itemType");
        adBaseInfo.industryFirstLevelId = jSONObject.optInt("industryFirstLevelId");
        adBaseInfo.extraClickReward = jSONObject.optBoolean("extraClickReward");
        adBaseInfo.enableClientProofreadTime = jSONObject.optBoolean("enableClientProofreadTime");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo.AdBaseInfo adBaseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j6 = adBaseInfo.creativeId;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "creativeId", j6);
        }
        int i6 = adBaseInfo.adSourceType;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adSourceType", i6);
        }
        String str = adBaseInfo.liveStreamId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "liveStreamId", adBaseInfo.liveStreamId);
        }
        int i7 = adBaseInfo.roiType;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "roiType", i7);
        }
        long j7 = adBaseInfo.liveDisplayWatchingCount;
        if (j7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "liveDisplayWatchingCount", j7);
        }
        int i8 = adBaseInfo.universeLiveType;
        if (i8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "universeLiveType", i8);
        }
        long j8 = adBaseInfo.viewCount;
        if (j8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "viewCount", j8);
        }
        String str2 = adBaseInfo.sdkExtraData;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkExtraData", adBaseInfo.sdkExtraData);
        }
        String str3 = adBaseInfo.adDescription;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adDescription", adBaseInfo.adDescription);
        }
        String str4 = adBaseInfo.installAppLabel;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "installAppLabel", adBaseInfo.installAppLabel);
        }
        String str5 = adBaseInfo.openAppLabel;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "openAppLabel", adBaseInfo.openAppLabel);
        }
        String str6 = adBaseInfo.adMarkIcon;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adMarkIcon", adBaseInfo.adMarkIcon);
        }
        String str7 = adBaseInfo.adGrayMarkIcon;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adGrayMarkIcon", adBaseInfo.adGrayMarkIcon);
        }
        String str8 = adBaseInfo.adSourceDescription;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adSourceDescription", adBaseInfo.adSourceDescription);
        }
        int i9 = adBaseInfo.adOperationType;
        if (i9 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adOperationType", i9);
        }
        String str9 = adBaseInfo.adActionDescription;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adActionDescription", adBaseInfo.adActionDescription);
        }
        String str10 = adBaseInfo.adActionBarColor;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adActionBarColor", adBaseInfo.adActionBarColor);
        }
        int i10 = adBaseInfo.adShowDuration;
        if (i10 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adShowDuration", i10);
        }
        String str11 = adBaseInfo.appName;
        if (str11 != null && !str11.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appName", adBaseInfo.appName);
        }
        String str12 = adBaseInfo.realAppName;
        if (str12 != null && !str12.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "realAppName", adBaseInfo.realAppName);
        }
        String str13 = adBaseInfo.appIconUrl;
        if (str13 != null && !str13.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appIconUrl", adBaseInfo.appIconUrl);
        }
        String str14 = adBaseInfo.appPackageName;
        if (str14 != null && !str14.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appPackageName", adBaseInfo.appPackageName);
        }
        int i11 = adBaseInfo.appScore;
        if (i11 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appScore", i11);
        }
        String str15 = adBaseInfo.appDownloadCountDesc;
        if (str15 != null && !str15.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appDownloadCountDesc", adBaseInfo.appDownloadCountDesc);
        }
        String str16 = adBaseInfo.appCategory;
        if (str16 != null && !str16.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appCategory", adBaseInfo.appCategory);
        }
        String str17 = adBaseInfo.appVersion;
        if (str17 != null && !str17.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appVersion", adBaseInfo.appVersion);
        }
        String str18 = adBaseInfo.corporationName;
        if (str18 != null && !str18.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "corporationName", adBaseInfo.corporationName);
        }
        long j9 = adBaseInfo.packageSize;
        if (j9 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "packageSize", j9);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "appImageUrl", adBaseInfo.appImageUrl);
        com.kwad.sdk.utils.aa.a(jSONObject, "appImageSize", adBaseInfo.appImageSize);
        String str19 = adBaseInfo.appDescription;
        if (str19 != null && !str19.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appDescription", adBaseInfo.appDescription);
        }
        int i12 = adBaseInfo.enableSkipAd;
        if (i12 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "enableSkipAd", i12);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "adCacheSwitch", adBaseInfo.adCacheSwitch);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "adCacheSecond", adBaseInfo.adCacheSecond);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "adCacheStrategy", adBaseInfo.adCacheStrategy);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "adCacheSize", adBaseInfo.adCacheSize);
        int i13 = adBaseInfo.adRolloutSize;
        if (i13 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adRolloutSize", i13);
        }
        int i14 = adBaseInfo.skipSecond;
        if (i14 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "skipSecond", i14);
        }
        int i15 = adBaseInfo.ecpm;
        if (i15 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ecpm", i15);
        }
        String str20 = adBaseInfo.videoPlayedNS;
        if (str20 != null && !str20.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "videoPlayedNS", adBaseInfo.videoPlayedNS);
        }
        String str21 = adBaseInfo.videoPlayedNSConfig;
        if (str21 != null && !str21.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "videoPlayedNSConfig", adBaseInfo.videoPlayedNSConfig);
        }
        String str22 = adBaseInfo.productName;
        if (str22 != null && !str22.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "productName", adBaseInfo.productName);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "expParam", adBaseInfo.mABParams.toJson().toString());
        String str23 = adBaseInfo.showUrl;
        if (str23 != null && !str23.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "showUrl", adBaseInfo.showUrl);
        }
        String str24 = adBaseInfo.clickUrl;
        if (str24 != null && !str24.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, Constants.KEYS.EXPOSED_CLICK_URL_KEY, adBaseInfo.clickUrl);
        }
        String str25 = adBaseInfo.convUrl;
        if (str25 != null && !str25.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "convUrl", adBaseInfo.convUrl);
        }
        int i16 = adBaseInfo.adAttributeType;
        if (i16 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adAttributeType", i16);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "apiExpParam", adBaseInfo.apiExpParam);
        int i17 = adBaseInfo.taskType;
        if (i17 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "taskType", i17);
        }
        int i18 = adBaseInfo.campaignType;
        if (i18 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "campaignType", i18);
        }
        int i19 = adBaseInfo.itemType;
        if (i19 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "itemType", i19);
        }
        int i20 = adBaseInfo.industryFirstLevelId;
        if (i20 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "industryFirstLevelId", i20);
        }
        boolean z5 = adBaseInfo.extraClickReward;
        if (z5) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "extraClickReward", z5);
        }
        boolean z6 = adBaseInfo.enableClientProofreadTime;
        if (z6) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "enableClientProofreadTime", z6);
        }
        return jSONObject;
    }
}
