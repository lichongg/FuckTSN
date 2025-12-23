package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ma implements com.kwad.sdk.core.d<VideoPlayerStatus> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(VideoPlayerStatus videoPlayerStatus, JSONObject jSONObject) {
        a2(videoPlayerStatus, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(VideoPlayerStatus videoPlayerStatus, JSONObject jSONObject) {
        return b2(videoPlayerStatus, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(VideoPlayerStatus videoPlayerStatus, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        videoPlayerStatus.mVideoPlayerType = jSONObject.optInt("mVideoPlayerType");
        videoPlayerStatus.mVideoPlayerBehavior = jSONObject.optInt("mVideoPlayerBehavior", new Integer("1").intValue());
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(VideoPlayerStatus videoPlayerStatus, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = videoPlayerStatus.mVideoPlayerType;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mVideoPlayerType", i6);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "mVideoPlayerBehavior", videoPlayerStatus.mVideoPlayerBehavior);
        return jSONObject;
    }
}
