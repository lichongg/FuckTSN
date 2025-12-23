package com.kwad.sdk.core.b.a;

import com.kwad.components.core.video.a.d;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class lx implements com.kwad.sdk.core.d<d.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(d.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(d.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(d.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.abB = jSONObject.optLong("start_play_duration_ms");
        bVar.abC = jSONObject.optLong("first_frame_duration_ms");
        bVar.abD = jSONObject.optLong("block_total_duration_ms");
        bVar.videoDuration = jSONObject.optLong("video_duration_ms");
        bVar.abg = jSONObject.optInt("block_times");
        bVar.videoUrl = jSONObject.optString("video_url");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(bVar.videoUrl)) {
            bVar.videoUrl = "";
        }
        bVar.llsid = jSONObject.optLong("llsid");
        bVar.creativeId = jSONObject.optLong("creative_id");
        bVar.XI = jSONObject.optLong("ad_info_uid");
        bVar.abz = jSONObject.optString("ad_info_user_name");
        if (obj.toString().equals(bVar.abz)) {
            bVar.abz = "";
        }
        bVar.adStyle = jSONObject.optInt("ad_style");
        bVar.abA = jSONObject.optInt("ad_media_player_type");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(d.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j6 = bVar.abB;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "start_play_duration_ms", j6);
        }
        long j7 = bVar.abC;
        if (j7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "first_frame_duration_ms", j7);
        }
        long j8 = bVar.abD;
        if (j8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "block_total_duration_ms", j8);
        }
        long j9 = bVar.videoDuration;
        if (j9 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "video_duration_ms", j9);
        }
        int i6 = bVar.abg;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "block_times", i6);
        }
        String str = bVar.videoUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "video_url", bVar.videoUrl);
        }
        long j10 = bVar.llsid;
        if (j10 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "llsid", j10);
        }
        long j11 = bVar.creativeId;
        if (j11 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "creative_id", j11);
        }
        long j12 = bVar.XI;
        if (j12 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ad_info_uid", j12);
        }
        String str2 = bVar.abz;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ad_info_user_name", bVar.abz);
        }
        int i7 = bVar.adStyle;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ad_style", i7);
        }
        int i8 = bVar.abA;
        if (i8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ad_media_player_type", i8);
        }
        return jSONObject;
    }
}
