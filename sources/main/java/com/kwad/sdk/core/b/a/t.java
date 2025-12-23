package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class t implements com.kwad.sdk.core.d<AdInfo.AdFeedInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdFeedInfo adFeedInfo, JSONObject jSONObject) {
        a2(adFeedInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdFeedInfo adFeedInfo, JSONObject jSONObject) {
        return b2(adFeedInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.AdFeedInfo adFeedInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adFeedInfo.videoSoundType = jSONObject.optInt("videoSoundType");
        adFeedInfo.videoAutoPlayType = jSONObject.optInt("videoAutoPlayType");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo.AdFeedInfo adFeedInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = adFeedInfo.videoSoundType;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "videoSoundType", i6);
        }
        int i7 = adFeedInfo.videoAutoPlayType;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "videoAutoPlayType", i7);
        }
        return jSONObject;
    }
}
