package com.kwad.sdk.core.b.a;

import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class km implements com.kwad.sdk.core.d<AdMatrixInfo.SplashSlideInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.SplashSlideInfo splashSlideInfo, JSONObject jSONObject) {
        a2(splashSlideInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.SplashSlideInfo splashSlideInfo, JSONObject jSONObject) {
        return b2(splashSlideInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdMatrixInfo.SplashSlideInfo splashSlideInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        splashSlideInfo.title = jSONObject.optString("title");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(splashSlideInfo.title)) {
            splashSlideInfo.title = "";
        }
        splashSlideInfo.subtitle = jSONObject.optString(MediaFormat.KEY_SUBTITLE);
        if (obj.toString().equals(splashSlideInfo.subtitle)) {
            splashSlideInfo.subtitle = "";
        }
        splashSlideInfo.style = jSONObject.optInt(ResIdentify.RES_TYPE_STYLE);
        splashSlideInfo.convertDistance = jSONObject.optInt("convertDistance");
        AdMatrixInfo.DownloadTexts downloadTexts = new AdMatrixInfo.DownloadTexts();
        splashSlideInfo.downloadTexts = downloadTexts;
        downloadTexts.parseJson(jSONObject.optJSONObject("downloadTexts"));
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdMatrixInfo.SplashSlideInfo splashSlideInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = splashSlideInfo.title;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "title", splashSlideInfo.title);
        }
        String str2 = splashSlideInfo.subtitle;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, MediaFormat.KEY_SUBTITLE, splashSlideInfo.subtitle);
        }
        int i6 = splashSlideInfo.style;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, ResIdentify.RES_TYPE_STYLE, i6);
        }
        int i7 = splashSlideInfo.convertDistance;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "convertDistance", i7);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "downloadTexts", splashSlideInfo.downloadTexts);
        return jSONObject;
    }
}
