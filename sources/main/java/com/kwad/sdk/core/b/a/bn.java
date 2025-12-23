package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.tachikoma.b.x;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class bn implements com.kwad.sdk.core.d<x.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(x.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(x.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(x.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.agO = jSONObject.optBoolean("hasLoseAudioFocus");
        aVar.agP = jSONObject.optInt("audioFocusStatus");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(x.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z5 = aVar.agO;
        if (z5) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "hasLoseAudioFocus", z5);
        }
        int i6 = aVar.agP;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "audioFocusStatus", i6);
        }
        return jSONObject;
    }
}
