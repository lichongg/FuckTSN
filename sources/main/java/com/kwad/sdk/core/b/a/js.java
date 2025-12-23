package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class js implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.c.r> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.c.r rVar, JSONObject jSONObject) {
        a2(rVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.c.r rVar, JSONObject jSONObject) {
        return b2(rVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.tachikoma.c.r rVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        rVar.ahj = jSONObject.optBoolean("userForce");
        rVar.type = jSONObject.optInt("type");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.c.r rVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z5 = rVar.ahj;
        if (z5) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "userForce", z5);
        }
        int i6 = rVar.type;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "type", i6);
        }
        return jSONObject;
    }
}
