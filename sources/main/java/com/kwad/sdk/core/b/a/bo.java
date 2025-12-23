package com.kwad.sdk.core.b.a;

import com.kwad.components.core.request.model.b;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class bo implements com.kwad.sdk.core.d<b.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(b.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(b.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.streamType = jSONObject.optInt("streamType");
        aVar.XF = jSONObject.optInt("maxVolume");
        aVar.XG = jSONObject.optInt("minVolume");
        aVar.XH = jSONObject.optInt("currentVolume");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = aVar.streamType;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "streamType", i6);
        }
        int i7 = aVar.XF;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "maxVolume", i7);
        }
        int i8 = aVar.XG;
        if (i8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "minVolume", i8);
        }
        int i9 = aVar.XH;
        if (i9 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "currentVolume", i9);
        }
        return jSONObject;
    }
}
