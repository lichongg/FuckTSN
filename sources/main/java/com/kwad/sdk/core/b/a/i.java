package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class i implements com.kwad.sdk.core.d<AdInfo.AdBannerInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdBannerInfo adBannerInfo, JSONObject jSONObject) {
        a2(adBannerInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdBannerInfo adBannerInfo, JSONObject jSONObject) {
        return b2(adBannerInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.AdBannerInfo adBannerInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adBannerInfo.videoSoundType = jSONObject.optInt("videoSoundType");
        adBannerInfo.videoAutoPlayType = jSONObject.optInt("videoAutoPlayType");
        adBannerInfo.isSupportCarousel = jSONObject.optBoolean("isSupportCarousel");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo.AdBannerInfo adBannerInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = adBannerInfo.videoSoundType;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "videoSoundType", i6);
        }
        int i7 = adBannerInfo.videoAutoPlayType;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "videoAutoPlayType", i7);
        }
        boolean z5 = adBannerInfo.isSupportCarousel;
        if (z5) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isSupportCarousel", z5);
        }
        return jSONObject;
    }
}
