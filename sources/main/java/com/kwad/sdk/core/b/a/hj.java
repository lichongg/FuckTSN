package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class hj implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.c.n> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.c.n nVar, JSONObject jSONObject) {
        a2(nVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.c.n nVar, JSONObject jSONObject) {
        return b2(nVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.tachikoma.c.n nVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        nVar.ahg = jSONObject.optBoolean("muted");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.c.n nVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z5 = nVar.ahg;
        if (z5) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "muted", z5);
        }
        return jSONObject;
    }
}
