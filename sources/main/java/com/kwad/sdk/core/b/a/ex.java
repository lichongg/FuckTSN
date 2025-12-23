package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ex implements com.kwad.sdk.core.d<AdInfo.FullScreenVideoInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.FullScreenVideoInfo fullScreenVideoInfo, JSONObject jSONObject) {
        a2(fullScreenVideoInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.FullScreenVideoInfo fullScreenVideoInfo, JSONObject jSONObject) {
        return b2(fullScreenVideoInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.FullScreenVideoInfo fullScreenVideoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        fullScreenVideoInfo.fullScreenEndCardSwitch = jSONObject.optBoolean("fullScreenEndCardSwitch");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo.FullScreenVideoInfo fullScreenVideoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z5 = fullScreenVideoInfo.fullScreenEndCardSwitch;
        if (z5) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "fullScreenEndCardSwitch", z5);
        }
        return jSONObject;
    }
}
