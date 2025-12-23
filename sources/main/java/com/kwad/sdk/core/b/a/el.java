package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class el implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.c.i> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.c.i iVar, JSONObject jSONObject) {
        a2(iVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.c.i iVar, JSONObject jSONObject) {
        return b2(iVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.tachikoma.c.i iVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        iVar.agZ = jSONObject.optInt("motionType");
        iVar.aha = jSONObject.optInt("convertType");
        iVar.ahb = jSONObject.optString("convertSensitivity");
        if (JSONObject.NULL.toString().equals(iVar.ahb)) {
            iVar.ahb = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.c.i iVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = iVar.agZ;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "motionType", i6);
        }
        int i7 = iVar.aha;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "convertType", i7);
        }
        String str = iVar.ahb;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "convertSensitivity", iVar.ahb);
        }
        return jSONObject;
    }
}
