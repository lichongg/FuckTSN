package com.kwad.sdk.core.b.a;

import androidx.core.app.NotificationCompat;
import com.kwad.components.ad.interstitial.report.InterstitialReportInfo;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class gh implements com.kwad.sdk.core.d<InterstitialReportInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(InterstitialReportInfo interstitialReportInfo, JSONObject jSONObject) {
        a2(interstitialReportInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(InterstitialReportInfo interstitialReportInfo, JSONObject jSONObject) {
        return b2(interstitialReportInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(InterstitialReportInfo interstitialReportInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        interstitialReportInfo.status = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
        interstitialReportInfo.type = jSONObject.optInt("type");
        interstitialReportInfo.loadDataTime = jSONObject.optLong("load_data_duration_ms");
        interstitialReportInfo.renderDuration = jSONObject.optLong("render_duration_ms");
        interstitialReportInfo.renderType = jSONObject.optInt("render_type");
        interstitialReportInfo.expectedRenderType = jSONObject.optInt("expected_render_type");
        interstitialReportInfo.materialType = jSONObject.optInt("material_type");
        interstitialReportInfo.downloadDuration = jSONObject.optLong("download_duration_ms");
        interstitialReportInfo.downloadType = jSONObject.optInt("download_type");
        interstitialReportInfo.downloadSize = jSONObject.optLong("download_size");
        interstitialReportInfo.creativeId = jSONObject.optLong("creative_id");
        interstitialReportInfo.videoUrl = jSONObject.optString("video_url");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(interstitialReportInfo.videoUrl)) {
            interstitialReportInfo.videoUrl = "";
        }
        interstitialReportInfo.videoDuration = jSONObject.optLong("video_duration_ms");
        interstitialReportInfo.playStartedDuration = jSONObject.optLong("play_started_duration_ms");
        interstitialReportInfo.abParams = jSONObject.optString("ab_params");
        if (obj.toString().equals(interstitialReportInfo.abParams)) {
            interstitialReportInfo.abParams = "";
        }
        interstitialReportInfo.actionType = jSONObject.optLong("action_type");
        interstitialReportInfo.callbackType = jSONObject.optLong("callback_type");
        interstitialReportInfo.clickSceneType = jSONObject.optLong("click_scene_type");
        interstitialReportInfo.itemClickType = jSONObject.optLong("item_click_type");
        interstitialReportInfo.visiblePercent = jSONObject.optDouble("visible_percent");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(InterstitialReportInfo interstitialReportInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = interstitialReportInfo.status;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, NotificationCompat.CATEGORY_STATUS, i6);
        }
        int i7 = interstitialReportInfo.type;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "type", i7);
        }
        long j6 = interstitialReportInfo.loadDataTime;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "load_data_duration_ms", j6);
        }
        long j7 = interstitialReportInfo.renderDuration;
        if (j7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "render_duration_ms", j7);
        }
        int i8 = interstitialReportInfo.renderType;
        if (i8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "render_type", i8);
        }
        int i9 = interstitialReportInfo.expectedRenderType;
        if (i9 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "expected_render_type", i9);
        }
        int i10 = interstitialReportInfo.materialType;
        if (i10 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "material_type", i10);
        }
        long j8 = interstitialReportInfo.downloadDuration;
        if (j8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "download_duration_ms", j8);
        }
        int i11 = interstitialReportInfo.downloadType;
        if (i11 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "download_type", i11);
        }
        long j9 = interstitialReportInfo.downloadSize;
        if (j9 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "download_size", j9);
        }
        long j10 = interstitialReportInfo.creativeId;
        if (j10 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "creative_id", j10);
        }
        String str = interstitialReportInfo.videoUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "video_url", interstitialReportInfo.videoUrl);
        }
        long j11 = interstitialReportInfo.videoDuration;
        if (j11 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "video_duration_ms", j11);
        }
        long j12 = interstitialReportInfo.playStartedDuration;
        if (j12 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "play_started_duration_ms", j12);
        }
        String str2 = interstitialReportInfo.abParams;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ab_params", interstitialReportInfo.abParams);
        }
        long j13 = interstitialReportInfo.actionType;
        if (j13 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "action_type", j13);
        }
        long j14 = interstitialReportInfo.callbackType;
        if (j14 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "callback_type", j14);
        }
        long j15 = interstitialReportInfo.clickSceneType;
        if (j15 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "click_scene_type", j15);
        }
        long j16 = interstitialReportInfo.itemClickType;
        if (j16 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "item_click_type", j16);
        }
        double d6 = interstitialReportInfo.visiblePercent;
        if (d6 != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "visible_percent", d6);
        }
        return jSONObject;
    }
}
