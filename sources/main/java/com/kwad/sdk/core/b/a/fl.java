package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class fl implements com.kwad.sdk.core.d<com.kwad.sdk.f.a.a.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.f.a.a.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.f.a.a.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.f.a.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aRf = jSONObject.optInt("apiLevel");
        aVar.aRg = jSONObject.optInt("colorModeSupport");
        aVar.aRh = jSONObject.optInt("screenHdrAvailable");
        aVar.aRi = jSONObject.optInt("hdrSupport");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.f.a.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = aVar.aRf;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "apiLevel", i6);
        }
        int i7 = aVar.aRg;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "colorModeSupport", i7);
        }
        int i8 = aVar.aRh;
        if (i8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "screenHdrAvailable", i8);
        }
        int i9 = aVar.aRi;
        if (i9 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "hdrSupport", i9);
        }
        return jSONObject;
    }
}
