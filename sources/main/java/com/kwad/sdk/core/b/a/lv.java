package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.PhotoInfo;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class lv implements com.kwad.sdk.core.d<PhotoInfo.VideoInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(PhotoInfo.VideoInfo videoInfo, JSONObject jSONObject) {
        a2(videoInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(PhotoInfo.VideoInfo videoInfo, JSONObject jSONObject) {
        return b2(videoInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(PhotoInfo.VideoInfo videoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        videoInfo.videoUrl = jSONObject.optString("videoUrl");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(videoInfo.videoUrl)) {
            videoInfo.videoUrl = "";
        }
        videoInfo.manifest = jSONObject.optString("manifest");
        if (obj.toString().equals(videoInfo.manifest)) {
            videoInfo.manifest = "";
        }
        videoInfo.firstFrame = jSONObject.optString("firstFrame");
        if (obj.toString().equals(videoInfo.firstFrame)) {
            videoInfo.firstFrame = "";
        }
        videoInfo.duration = jSONObject.optLong("duration");
        videoInfo.size = jSONObject.optInt("size");
        videoInfo.width = jSONObject.optInt("width");
        videoInfo.height = jSONObject.optInt("height");
        videoInfo.leftRatio = jSONObject.optDouble("leftRatio");
        videoInfo.topRatio = jSONObject.optDouble("topRatio");
        videoInfo.widthRatio = jSONObject.optDouble("widthRatio", new Double("1.0f").doubleValue());
        videoInfo.heightRatio = jSONObject.optDouble("heightRatio", new Double("1.0f").doubleValue());
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(PhotoInfo.VideoInfo videoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = videoInfo.videoUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "videoUrl", videoInfo.videoUrl);
        }
        String str2 = videoInfo.manifest;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "manifest", videoInfo.manifest);
        }
        String str3 = videoInfo.firstFrame;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "firstFrame", videoInfo.firstFrame);
        }
        long j6 = videoInfo.duration;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "duration", j6);
        }
        int i6 = videoInfo.size;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "size", i6);
        }
        int i7 = videoInfo.width;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "width", i7);
        }
        int i8 = videoInfo.height;
        if (i8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "height", i8);
        }
        double d6 = videoInfo.leftRatio;
        if (d6 != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "leftRatio", d6);
        }
        double d7 = videoInfo.topRatio;
        if (d7 != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "topRatio", d7);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "widthRatio", videoInfo.widthRatio);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "heightRatio", videoInfo.heightRatio);
        return jSONObject;
    }
}
