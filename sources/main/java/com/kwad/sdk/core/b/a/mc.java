package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class mc implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.c.z> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.c.z zVar, JSONObject jSONObject) {
        a2(zVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.c.z zVar, JSONObject jSONObject) {
        return b2(zVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.tachikoma.c.z zVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        zVar.qz = jSONObject.optInt("currentTime");
        zVar.aho = jSONObject.optBoolean("failed");
        zVar.Wy = jSONObject.optBoolean("finished");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.c.z zVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = zVar.qz;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "currentTime", i6);
        }
        boolean z5 = zVar.aho;
        if (z5) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "failed", z5);
        }
        boolean z6 = zVar.Wy;
        if (z6) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "finished", z6);
        }
        return jSONObject;
    }
}
