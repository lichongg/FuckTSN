package com.kwad.sdk.core.b.a;

import androidx.core.app.NotificationCompat;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class x implements com.kwad.sdk.core.d<AdInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo adInfo, JSONObject jSONObject) {
        a2(adInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo adInfo, JSONObject jSONObject) {
        return b2(adInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdInfo adInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        AdInfo.AdBaseInfo adBaseInfo = new AdInfo.AdBaseInfo();
        adInfo.adBaseInfo = adBaseInfo;
        adBaseInfo.parseJson(jSONObject.optJSONObject("adBaseInfo"));
        AdInfo.AdvertiserInfo advertiserInfo = new AdInfo.AdvertiserInfo();
        adInfo.advertiserInfo = advertiserInfo;
        advertiserInfo.parseJson(jSONObject.optJSONObject("advertiserInfo"));
        AdInfo.AdConversionInfo adConversionInfo = new AdInfo.AdConversionInfo();
        adInfo.adConversionInfo = adConversionInfo;
        adConversionInfo.parseJson(jSONObject.optJSONObject("adConversionInfo"));
        AdInfo.AdMaterialInfo adMaterialInfo = new AdInfo.AdMaterialInfo();
        adInfo.adMaterialInfo = adMaterialInfo;
        adMaterialInfo.parseJson(jSONObject.optJSONObject("adMaterialInfo"));
        adInfo.adTrackInfoList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("adTrackInfo");
        if (optJSONArray != null) {
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                AdInfo.AdTrackInfo adTrackInfo = new AdInfo.AdTrackInfo();
                adTrackInfo.parseJson(optJSONArray.optJSONObject(i6));
                adInfo.adTrackInfoList.add(adTrackInfo);
            }
        }
        AdInfo.DownloadSafeInfo downloadSafeInfo = new AdInfo.DownloadSafeInfo();
        adInfo.downloadSafeInfo = downloadSafeInfo;
        downloadSafeInfo.parseJson(jSONObject.optJSONObject("downloadSafeInfo"));
        AdInfo.UnDownloadConf unDownloadConf = new AdInfo.UnDownloadConf();
        adInfo.unDownloadConf = unDownloadConf;
        unDownloadConf.parseJson(jSONObject.optJSONObject("unDownloadConf"));
        adInfo.status = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
        adInfo.progress = jSONObject.optInt(NotificationCompat.CATEGORY_PROGRESS);
        adInfo.soFarBytes = jSONObject.optLong("soFarBytes");
        adInfo.totalBytes = jSONObject.optLong("totalBytes");
        adInfo.downloadFilePath = jSONObject.optString("downloadFilePath");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(adInfo.downloadFilePath)) {
            adInfo.downloadFilePath = "";
        }
        adInfo.downloadId = jSONObject.optString("downloadId");
        if (obj.toString().equals(adInfo.downloadId)) {
            adInfo.downloadId = "";
        }
        adInfo.mStartDownloadTime = jSONObject.optLong("mStartDownloadTime");
        adInfo.isAllowVideoAutoPlay = jSONObject.optBoolean("isAllowVideoAutoPlay");
        adInfo.ksUaPattern = jSONObject.optBoolean("ksUaPattern");
        adInfo.unionMark = jSONObject.optBoolean("unionMark");
        AdInfo.AdPreloadInfo adPreloadInfo = new AdInfo.AdPreloadInfo();
        adInfo.adPreloadInfo = adPreloadInfo;
        adPreloadInfo.parseJson(jSONObject.optJSONObject("adPreloadInfo"));
        AdInfo.AdSplashInfo adSplashInfo = new AdInfo.AdSplashInfo();
        adInfo.adSplashInfo = adSplashInfo;
        adSplashInfo.parseJson(jSONObject.optJSONObject("adSplashInfo"));
        AdInfo.AdBannerInfo adBannerInfo = new AdInfo.AdBannerInfo();
        adInfo.adBannerInfo = adBannerInfo;
        adBannerInfo.parseJson(jSONObject.optJSONObject("adBannerInfo"));
        AdInfo.AdDrawInfo adDrawInfo = new AdInfo.AdDrawInfo();
        adInfo.adDrawInfo = adDrawInfo;
        adDrawInfo.parseJson(jSONObject.optJSONObject("adDrawInfo"));
        AdStyleInfo adStyleInfo = new AdStyleInfo();
        adInfo.adStyleInfo = adStyleInfo;
        adStyleInfo.parseJson(jSONObject.optJSONObject("adStyleInfo"));
        AdStyleInfo adStyleInfo2 = new AdStyleInfo();
        adInfo.adStyleInfo2 = adStyleInfo2;
        adStyleInfo2.parseJson(jSONObject.optJSONObject("adStyleInfo2"));
        AdInfo.AdAggregateInfo adAggregateInfo = new AdInfo.AdAggregateInfo();
        adInfo.adAggregateInfo = adAggregateInfo;
        adAggregateInfo.parseJson(jSONObject.optJSONObject("adAggregateInfo"));
        AdInfo.AdRewardInfo adRewardInfo = new AdInfo.AdRewardInfo();
        adInfo.adRewardInfo = adRewardInfo;
        adRewardInfo.parseJson(jSONObject.optJSONObject("adRewardInfo"));
        adInfo.serverExt = jSONObject.optString("serverExt");
        if (obj.toString().equals(adInfo.serverExt)) {
            adInfo.serverExt = "";
        }
        AdInfo.AdStyleConfInfo adStyleConfInfo = new AdInfo.AdStyleConfInfo();
        adInfo.adStyleConfInfo = adStyleConfInfo;
        adStyleConfInfo.parseJson(jSONObject.optJSONObject("adStyleConfInfo"));
        AdInfo.FullScreenVideoInfo fullScreenVideoInfo = new AdInfo.FullScreenVideoInfo();
        adInfo.fullScreenVideoInfo = fullScreenVideoInfo;
        fullScreenVideoInfo.parseJson(jSONObject.optJSONObject("fullScreenVideoInfo"));
        AdInfo.AdFeedInfo adFeedInfo = new AdInfo.AdFeedInfo();
        adInfo.adFeedInfo = adFeedInfo;
        adFeedInfo.parseJson(jSONObject.optJSONObject("adFeedInfo"));
        AdInfo.AdInsertScreenInfo adInsertScreenInfo = new AdInfo.AdInsertScreenInfo();
        adInfo.adInsertScreenInfo = adInsertScreenInfo;
        adInsertScreenInfo.parseJson(jSONObject.optJSONObject("adInsertScreenInfo"));
        AdProductInfo adProductInfo = new AdProductInfo();
        adInfo.adProductInfo = adProductInfo;
        adProductInfo.parseJson(jSONObject.optJSONObject("adProductInfo"));
        adInfo.ocpcActionType = jSONObject.optInt("ocpcActionType");
        AdMatrixInfo adMatrixInfo = new AdMatrixInfo();
        adInfo.adMatrixInfo = adMatrixInfo;
        adMatrixInfo.parseJson(jSONObject.optJSONObject("adMatrixInfo"));
        adInfo.trace = jSONObject.optString("trace");
        if (obj.toString().equals(adInfo.trace)) {
            adInfo.trace = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo adInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "adBaseInfo", adInfo.adBaseInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "advertiserInfo", adInfo.advertiserInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "adConversionInfo", adInfo.adConversionInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "adMaterialInfo", adInfo.adMaterialInfo);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "adTrackInfo", adInfo.adTrackInfoList);
        com.kwad.sdk.utils.aa.a(jSONObject, "downloadSafeInfo", adInfo.downloadSafeInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "unDownloadConf", adInfo.unDownloadConf);
        int i6 = adInfo.status;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, NotificationCompat.CATEGORY_STATUS, i6);
        }
        int i7 = adInfo.progress;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, NotificationCompat.CATEGORY_PROGRESS, i7);
        }
        long j6 = adInfo.soFarBytes;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "soFarBytes", j6);
        }
        long j7 = adInfo.totalBytes;
        if (j7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "totalBytes", j7);
        }
        String str = adInfo.downloadFilePath;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "downloadFilePath", adInfo.downloadFilePath);
        }
        String str2 = adInfo.downloadId;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "downloadId", adInfo.downloadId);
        }
        long j8 = adInfo.mStartDownloadTime;
        if (j8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mStartDownloadTime", j8);
        }
        boolean z5 = adInfo.isAllowVideoAutoPlay;
        if (z5) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isAllowVideoAutoPlay", z5);
        }
        boolean z6 = adInfo.ksUaPattern;
        if (z6) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ksUaPattern", z6);
        }
        boolean z7 = adInfo.unionMark;
        if (z7) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "unionMark", z7);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "adPreloadInfo", adInfo.adPreloadInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "adSplashInfo", adInfo.adSplashInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "adBannerInfo", adInfo.adBannerInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "adDrawInfo", adInfo.adDrawInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "adStyleInfo", adInfo.adStyleInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "adStyleInfo2", adInfo.adStyleInfo2);
        com.kwad.sdk.utils.aa.a(jSONObject, "adAggregateInfo", adInfo.adAggregateInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "adRewardInfo", adInfo.adRewardInfo);
        String str3 = adInfo.serverExt;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "serverExt", adInfo.serverExt);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "adStyleConfInfo", adInfo.adStyleConfInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "fullScreenVideoInfo", adInfo.fullScreenVideoInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "adFeedInfo", adInfo.adFeedInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "adInsertScreenInfo", adInfo.adInsertScreenInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "adProductInfo", adInfo.adProductInfo);
        int i8 = adInfo.ocpcActionType;
        if (i8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ocpcActionType", i8);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "adMatrixInfo", adInfo.adMatrixInfo);
        String str4 = adInfo.trace;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "trace", adInfo.trace);
        }
        return jSONObject;
    }
}
