package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.FeedSlideConf;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class en implements com.kwad.sdk.core.d<FeedSlideConf> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(FeedSlideConf feedSlideConf, JSONObject jSONObject) {
        a2(feedSlideConf, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(FeedSlideConf feedSlideConf, JSONObject jSONObject) {
        return b2(feedSlideConf, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(FeedSlideConf feedSlideConf, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        feedSlideConf.maxRange = jSONObject.optInt("maxRange");
        feedSlideConf.minRange = jSONObject.optInt("minRange");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(FeedSlideConf feedSlideConf, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = feedSlideConf.maxRange;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "maxRange", i6);
        }
        int i7 = feedSlideConf.minRange;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "minRange", i7);
        }
        return jSONObject;
    }
}
