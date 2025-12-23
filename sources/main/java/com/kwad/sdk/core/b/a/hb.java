package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import com.tencent.connect.share.QzonePublish;
import com.tencent.open.SocialConstants;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class hb implements com.kwad.sdk.core.d<AdInfo.AdMaterialInfo.MaterialFeature> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdMaterialInfo.MaterialFeature materialFeature, JSONObject jSONObject) {
        a2(materialFeature, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdMaterialInfo.MaterialFeature materialFeature, JSONObject jSONObject) {
        return b2(materialFeature, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.AdMaterialInfo.MaterialFeature materialFeature, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        materialFeature.featureType = jSONObject.optInt("featureType");
        materialFeature.materialUrl = jSONObject.optString("materialUrl");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(materialFeature.materialUrl)) {
            materialFeature.materialUrl = "";
        }
        materialFeature.photoId = jSONObject.optLong("photoId");
        materialFeature.coverUrl = jSONObject.optString("coverUrl");
        if (obj.toString().equals(materialFeature.coverUrl)) {
            materialFeature.coverUrl = "";
        }
        materialFeature.videoDuration = jSONObject.optInt(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION);
        materialFeature.firstFrame = jSONObject.optString("firstFrame");
        if (obj.toString().equals(materialFeature.firstFrame)) {
            materialFeature.firstFrame = "";
        }
        materialFeature.blurBackgroundUrl = jSONObject.optString("blurBackgroundUrl");
        if (obj.toString().equals(materialFeature.blurBackgroundUrl)) {
            materialFeature.blurBackgroundUrl = "";
        }
        materialFeature.webpCoverUrl = jSONObject.optString("webpCoverUrl");
        if (obj.toString().equals(materialFeature.webpCoverUrl)) {
            materialFeature.webpCoverUrl = "";
        }
        materialFeature.videoWidth = jSONObject.optInt("videoWidth");
        materialFeature.videoHeight = jSONObject.optInt("videoHeight");
        materialFeature.likeCount = jSONObject.optLong("likeCount");
        materialFeature.commentCount = jSONObject.optLong("commentCount");
        materialFeature.source = jSONObject.optInt(SocialConstants.PARAM_SOURCE);
        materialFeature.ruleId = jSONObject.optString("ruleId");
        if (obj.toString().equals(materialFeature.ruleId)) {
            materialFeature.ruleId = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo.AdMaterialInfo.MaterialFeature materialFeature, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = materialFeature.featureType;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "featureType", i6);
        }
        String str = materialFeature.materialUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "materialUrl", materialFeature.materialUrl);
        }
        long j6 = materialFeature.photoId;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "photoId", j6);
        }
        String str2 = materialFeature.coverUrl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "coverUrl", materialFeature.coverUrl);
        }
        int i7 = materialFeature.videoDuration;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, i7);
        }
        String str3 = materialFeature.firstFrame;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "firstFrame", materialFeature.firstFrame);
        }
        String str4 = materialFeature.blurBackgroundUrl;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "blurBackgroundUrl", materialFeature.blurBackgroundUrl);
        }
        String str5 = materialFeature.webpCoverUrl;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "webpCoverUrl", materialFeature.webpCoverUrl);
        }
        int i8 = materialFeature.videoWidth;
        if (i8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "videoWidth", i8);
        }
        int i9 = materialFeature.videoHeight;
        if (i9 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "videoHeight", i9);
        }
        long j7 = materialFeature.likeCount;
        if (j7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "likeCount", j7);
        }
        long j8 = materialFeature.commentCount;
        if (j8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "commentCount", j8);
        }
        int i10 = materialFeature.source;
        if (i10 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, SocialConstants.PARAM_SOURCE, i10);
        }
        String str6 = materialFeature.ruleId;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ruleId", materialFeature.ruleId);
        }
        return jSONObject;
    }
}
