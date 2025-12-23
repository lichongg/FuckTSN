package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class cg implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.d.b.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.webview.d.b.c cVar, JSONObject jSONObject) {
        a2(cVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.webview.d.b.c cVar, JSONObject jSONObject) {
        return b2(cVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.webview.d.b.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.f36350x = jSONObject.optDouble("x");
        cVar.f36351y = jSONObject.optDouble("y");
        cVar.width = jSONObject.optInt("width");
        cVar.height = jSONObject.optInt("height");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.webview.d.b.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        double d6 = cVar.f36350x;
        if (d6 != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "x", d6);
        }
        double d7 = cVar.f36351y;
        if (d7 != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "y", d7);
        }
        int i6 = cVar.width;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "width", i6);
        }
        int i7 = cVar.height;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "height", i7);
        }
        return jSONObject;
    }
}
