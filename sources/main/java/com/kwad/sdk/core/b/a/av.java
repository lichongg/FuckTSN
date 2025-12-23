package com.kwad.sdk.core.b.a;

import cn.jpush.android.api.JThirdPlatFormInterface;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdStatusInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.AdVideoPreCacheConfig;
import com.kwad.sdk.core.response.model.PageInfo;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class av implements com.kwad.sdk.core.d<AdTemplate> {
    private static void l(AdTemplate adTemplate, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adTemplate.mOriginJString = jSONObject.optString("mOriginJString");
        if (JSONObject.NULL.toString().equals(adTemplate.mOriginJString)) {
            adTemplate.mOriginJString = "";
        }
        adTemplate.posId = jSONObject.optLong("posId");
        adTemplate.adStyle = jSONObject.optInt("adStyle");
        adTemplate.type = jSONObject.optInt("type");
        adTemplate.subType = jSONObject.optInt("subType");
        adTemplate.defaultType = jSONObject.optInt("defaultType");
        adTemplate.contentType = jSONObject.optInt("contentType");
        adTemplate.adInfoList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("adInfo");
        if (optJSONArray != null) {
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                AdInfo adInfo = new AdInfo();
                adInfo.parseJson(optJSONArray.optJSONObject(i6));
                adTemplate.adInfoList.add(adInfo);
            }
        }
        adTemplate.impAdExtra = jSONObject.optString("impAdExtra");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(adTemplate.impAdExtra)) {
            adTemplate.impAdExtra = "";
        }
        adTemplate.llsid = jSONObject.optLong("llsid");
        adTemplate.mIsFromContent = jSONObject.optBoolean("mIsFromContent");
        adTemplate.extra = jSONObject.optString(JThirdPlatFormInterface.KEY_EXTRA);
        if (obj.toString().equals(adTemplate.extra)) {
            adTemplate.extra = "";
        }
        adTemplate.mUniqueId = jSONObject.optString("mUniqueId");
        if (obj.toString().equals(adTemplate.mUniqueId)) {
            adTemplate.mUniqueId = "";
        }
        adTemplate.mBidEcpm = jSONObject.optLong("mBidEcpm");
        SceneImpl sceneImpl = new SceneImpl();
        adTemplate.mAdScene = sceneImpl;
        sceneImpl.parseJson(jSONObject.optJSONObject("mAdScene"));
        adTemplate.realShowType = jSONObject.optInt("realShowType");
        adTemplate.mInitVoiceStatus = jSONObject.optInt("mInitVoiceStatus");
        adTemplate.mMediaPlayerType = jSONObject.optInt("mMediaPlayerType");
        VideoPlayerStatus videoPlayerStatus = new VideoPlayerStatus();
        adTemplate.mVideoPlayerStatus = videoPlayerStatus;
        videoPlayerStatus.parseJson(jSONObject.optJSONObject("mVideoPlayerStatus"));
        adTemplate.mOutClickTimeParam = jSONObject.optLong("mOutClickTimeParam", new Long("-1").longValue());
        adTemplate.mVisibleTimeParam = jSONObject.optLong("mVisibleTimeParam", new Long("-1").longValue());
        adTemplate.mIsLeftSlipStatus = jSONObject.optInt("mIsLeftSlipStatus");
        adTemplate.mPhotoResponseType = jSONObject.optInt("mPhotoResponseType");
        PageInfo pageInfo = new PageInfo();
        adTemplate.mPageInfo = pageInfo;
        pageInfo.parseJson(jSONObject.optJSONObject("mPageInfo"));
        adTemplate.mIsForceJumpLandingPage = jSONObject.optBoolean("mIsForceJumpLandingPage", new Boolean("false").booleanValue());
        adTemplate.mIsAudioEnable = jSONObject.optBoolean("mIsAudioEnable");
        adTemplate.mRewardVerifyCalled = jSONObject.optBoolean("mRewardVerifyCalled");
        adTemplate.isWebViewDownload = jSONObject.optBoolean("isWebViewDownload");
        adTemplate.watched = jSONObject.optBoolean("watched");
        adTemplate.swipeAngle = jSONObject.optInt("swipeAngle");
        adTemplate.converted = jSONObject.optBoolean("converted");
        adTemplate.fromCache = jSONObject.optBoolean("fromCache", new Boolean("false").booleanValue());
        adTemplate.requestStartTime = jSONObject.optLong("requestStartTime");
        adTemplate.loadDataTime = jSONObject.optLong("loadDataTime");
        adTemplate.showStartTime = jSONObject.optLong("showStartTime");
        adTemplate.addStartTime = jSONObject.optLong("addStartTime");
        adTemplate.showTime = jSONObject.optLong("showTime");
        adTemplate.notNetworkRequest = jSONObject.optBoolean("notNetworkRequest");
        adTemplate.downloadDuration = jSONObject.optLong("downloadDuration");
        adTemplate.adLoadTotalTime = jSONObject.optLong("adLoadTotalTime");
        adTemplate.adShowStartTimeStamp = jSONObject.optLong("adShowStartTimeStamp");
        AdStatusInfo adStatusInfo = new AdStatusInfo();
        adTemplate.mAdStatusInfo = adStatusInfo;
        adStatusInfo.parseJson(jSONObject.optJSONObject("mAdStatusInfo"));
        AdVideoPreCacheConfig adVideoPreCacheConfig = new AdVideoPreCacheConfig();
        adTemplate.adVideoPreCacheConfig = adVideoPreCacheConfig;
        adVideoPreCacheConfig.parseJson(jSONObject.optJSONObject("adVideoPreCacheConfig"));
        adTemplate.isNativeRewardPreview = jSONObject.optBoolean("isNativeRewardPreview");
        adTemplate.mInstallApkFromSDK = jSONObject.optBoolean("mInstallApkFromSDK");
        adTemplate.mInstallApkFormUser = jSONObject.optBoolean("mInstallApkFormUser");
        adTemplate.mClickOpenAppStore = jSONObject.optBoolean("mClickOpenAppStore");
        adTemplate.mDataLoadTraceElement = jSONObject.optString("mDataLoadTraceElement");
        if (obj.toString().equals(adTemplate.mDataLoadTraceElement)) {
            adTemplate.mDataLoadTraceElement = "";
        }
        adTemplate.mDataCacheTraceElement = jSONObject.optString("mDataCacheTraceElement");
        if (obj.toString().equals(adTemplate.mDataCacheTraceElement)) {
            adTemplate.mDataCacheTraceElement = "";
        }
        adTemplate.downLoadType = jSONObject.optInt("downLoadType", new Integer("3").intValue());
    }

    private static JSONObject m(AdTemplate adTemplate, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = adTemplate.mOriginJString;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mOriginJString", adTemplate.mOriginJString);
        }
        long j6 = adTemplate.posId;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "posId", j6);
        }
        int i6 = adTemplate.adStyle;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adStyle", i6);
        }
        int i7 = adTemplate.type;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "type", i7);
        }
        int i8 = adTemplate.subType;
        if (i8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "subType", i8);
        }
        int i9 = adTemplate.defaultType;
        if (i9 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "defaultType", i9);
        }
        int i10 = adTemplate.contentType;
        if (i10 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "contentType", i10);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "adInfo", adTemplate.adInfoList);
        String str2 = adTemplate.impAdExtra;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "impAdExtra", adTemplate.impAdExtra);
        }
        long j7 = adTemplate.llsid;
        if (j7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "llsid", j7);
        }
        boolean z5 = adTemplate.mIsFromContent;
        if (z5) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mIsFromContent", z5);
        }
        String str3 = adTemplate.extra;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, JThirdPlatFormInterface.KEY_EXTRA, adTemplate.extra);
        }
        String str4 = adTemplate.mUniqueId;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mUniqueId", adTemplate.mUniqueId);
        }
        long j8 = adTemplate.mBidEcpm;
        if (j8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mBidEcpm", j8);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "mAdScene", adTemplate.mAdScene);
        int i11 = adTemplate.realShowType;
        if (i11 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "realShowType", i11);
        }
        int i12 = adTemplate.mInitVoiceStatus;
        if (i12 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mInitVoiceStatus", i12);
        }
        int i13 = adTemplate.mMediaPlayerType;
        if (i13 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mMediaPlayerType", i13);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "mVideoPlayerStatus", adTemplate.mVideoPlayerStatus);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "mOutClickTimeParam", adTemplate.mOutClickTimeParam);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "mVisibleTimeParam", adTemplate.mVisibleTimeParam);
        int i14 = adTemplate.mIsLeftSlipStatus;
        if (i14 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mIsLeftSlipStatus", i14);
        }
        int i15 = adTemplate.mPhotoResponseType;
        if (i15 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mPhotoResponseType", i15);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "mPageInfo", adTemplate.mPageInfo);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "mIsForceJumpLandingPage", adTemplate.mIsForceJumpLandingPage);
        boolean z6 = adTemplate.mIsAudioEnable;
        if (z6) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mIsAudioEnable", z6);
        }
        boolean z7 = adTemplate.mRewardVerifyCalled;
        if (z7) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mRewardVerifyCalled", z7);
        }
        boolean z8 = adTemplate.isWebViewDownload;
        if (z8) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isWebViewDownload", z8);
        }
        boolean z9 = adTemplate.watched;
        if (z9) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "watched", z9);
        }
        int i16 = adTemplate.swipeAngle;
        if (i16 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "swipeAngle", i16);
        }
        boolean z10 = adTemplate.converted;
        if (z10) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "converted", z10);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "fromCache", adTemplate.fromCache);
        long j9 = adTemplate.requestStartTime;
        if (j9 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "requestStartTime", j9);
        }
        long j10 = adTemplate.loadDataTime;
        if (j10 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "loadDataTime", j10);
        }
        long j11 = adTemplate.showStartTime;
        if (j11 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "showStartTime", j11);
        }
        long j12 = adTemplate.addStartTime;
        if (j12 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "addStartTime", j12);
        }
        long j13 = adTemplate.showTime;
        if (j13 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "showTime", j13);
        }
        boolean z11 = adTemplate.notNetworkRequest;
        if (z11) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "notNetworkRequest", z11);
        }
        long j14 = adTemplate.downloadDuration;
        if (j14 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "downloadDuration", j14);
        }
        long j15 = adTemplate.adLoadTotalTime;
        if (j15 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adLoadTotalTime", j15);
        }
        long j16 = adTemplate.adShowStartTimeStamp;
        if (j16 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adShowStartTimeStamp", j16);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "mAdStatusInfo", adTemplate.mAdStatusInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "adVideoPreCacheConfig", adTemplate.adVideoPreCacheConfig);
        boolean z12 = adTemplate.isNativeRewardPreview;
        if (z12) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isNativeRewardPreview", z12);
        }
        boolean z13 = adTemplate.mInstallApkFromSDK;
        if (z13) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mInstallApkFromSDK", z13);
        }
        boolean z14 = adTemplate.mInstallApkFormUser;
        if (z14) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mInstallApkFormUser", z14);
        }
        boolean z15 = adTemplate.mClickOpenAppStore;
        if (z15) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mClickOpenAppStore", z15);
        }
        String str5 = adTemplate.mDataLoadTraceElement;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mDataLoadTraceElement", adTemplate.mDataLoadTraceElement);
        }
        String str6 = adTemplate.mDataCacheTraceElement;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mDataCacheTraceElement", adTemplate.mDataCacheTraceElement);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "downLoadType", adTemplate.downLoadType);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* synthetic */ void a(AdTemplate adTemplate, JSONObject jSONObject) {
        l(adTemplate, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* synthetic */ JSONObject b(AdTemplate adTemplate, JSONObject jSONObject) {
        return m(adTemplate, jSONObject);
    }
}
