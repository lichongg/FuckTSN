package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.PhotoInfo;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class bw implements com.kwad.sdk.core.d<PhotoInfo.BaseInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(PhotoInfo.BaseInfo baseInfo, JSONObject jSONObject) {
        a2(baseInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(PhotoInfo.BaseInfo baseInfo, JSONObject jSONObject) {
        return b2(baseInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(PhotoInfo.BaseInfo baseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        baseInfo.photoId = jSONObject.optLong("photoId");
        baseInfo.sdkExtraData = jSONObject.optString("sdkExtraData");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(baseInfo.sdkExtraData)) {
            baseInfo.sdkExtraData = "";
        }
        baseInfo.title = jSONObject.optString("title");
        if (obj.toString().equals(baseInfo.title)) {
            baseInfo.title = "";
        }
        baseInfo.photoDescribeSize = jSONObject.optInt("photoDescribeSize");
        baseInfo.photoTitleSize = jSONObject.optInt("photoTitleSize");
        baseInfo.shareUrl = jSONObject.optString("shareUrl");
        if (obj.toString().equals(baseInfo.shareUrl)) {
            baseInfo.shareUrl = "";
        }
        baseInfo.waterMarkPosition = jSONObject.optInt("waterMarkPosition", new Integer("1").intValue());
        baseInfo.waterMarkShowDuration = jSONObject.optLong("waterMarkShowDuration", new Long("-1").longValue());
        baseInfo.recoExt = jSONObject.optString("recoExt");
        if (obj.toString().equals(baseInfo.recoExt)) {
            baseInfo.recoExt = "";
        }
        baseInfo.likeCount = jSONObject.optLong("likeCount");
        baseInfo.commentCount = jSONObject.optLong("commentCount");
        baseInfo.viewCount = jSONObject.optLong("viewCount");
        baseInfo.createTime = jSONObject.optLong("createTime");
        baseInfo.videoDesc = jSONObject.optString("videoDesc");
        if (obj.toString().equals(baseInfo.videoDesc)) {
            baseInfo.videoDesc = "";
        }
        baseInfo.playTimes = jSONObject.optLong("playTimes");
        baseInfo.videoUrlCacheTime = jSONObject.optLong("videoUrlCacheTime");
        baseInfo.contentSourceType = jSONObject.optInt("contentSourceType");
        baseInfo.toolbarDisable = jSONObject.optBoolean("toolbarDisable");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(PhotoInfo.BaseInfo baseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j6 = baseInfo.photoId;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "photoId", j6);
        }
        String str = baseInfo.sdkExtraData;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkExtraData", baseInfo.sdkExtraData);
        }
        String str2 = baseInfo.title;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "title", baseInfo.title);
        }
        int i6 = baseInfo.photoDescribeSize;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "photoDescribeSize", i6);
        }
        int i7 = baseInfo.photoTitleSize;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "photoTitleSize", i7);
        }
        String str3 = baseInfo.shareUrl;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "shareUrl", baseInfo.shareUrl);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "waterMarkPosition", baseInfo.waterMarkPosition);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "waterMarkShowDuration", baseInfo.waterMarkShowDuration);
        String str4 = baseInfo.recoExt;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "recoExt", baseInfo.recoExt);
        }
        long j7 = baseInfo.likeCount;
        if (j7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "likeCount", j7);
        }
        long j8 = baseInfo.commentCount;
        if (j8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "commentCount", j8);
        }
        long j9 = baseInfo.viewCount;
        if (j9 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "viewCount", j9);
        }
        long j10 = baseInfo.createTime;
        if (j10 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "createTime", j10);
        }
        String str5 = baseInfo.videoDesc;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "videoDesc", baseInfo.videoDesc);
        }
        long j11 = baseInfo.playTimes;
        if (j11 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "playTimes", j11);
        }
        long j12 = baseInfo.videoUrlCacheTime;
        if (j12 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "videoUrlCacheTime", j12);
        }
        int i8 = baseInfo.contentSourceType;
        if (i8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "contentSourceType", i8);
        }
        boolean z5 = baseInfo.toolbarDisable;
        if (z5) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "toolbarDisable", z5);
        }
        return jSONObject;
    }
}
