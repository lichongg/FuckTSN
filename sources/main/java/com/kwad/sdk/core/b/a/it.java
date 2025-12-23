package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class it implements com.kwad.sdk.core.d<AdInfo.PlayableStyleInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.PlayableStyleInfo playableStyleInfo, JSONObject jSONObject) {
        a2(playableStyleInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.PlayableStyleInfo playableStyleInfo, JSONObject jSONObject) {
        return b2(playableStyleInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.PlayableStyleInfo playableStyleInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        playableStyleInfo.playableOrientation = jSONObject.optInt("playableOrientation");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo.PlayableStyleInfo playableStyleInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = playableStyleInfo.playableOrientation;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "playableOrientation", i6);
        }
        return jSONObject;
    }
}
