package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class jw implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.c.u> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.c.u uVar, JSONObject jSONObject) {
        a2(uVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.c.u uVar, JSONObject jSONObject) {
        return b2(uVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.tachikoma.c.u uVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        uVar.ahk = jSONObject.optBoolean("needPromopt");
        uVar.Ph = jSONObject.optBoolean("needReport");
        uVar.showTime = jSONObject.optInt("showTime");
        uVar.aci = jSONObject.optLong("playDuration");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.c.u uVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z5 = uVar.ahk;
        if (z5) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "needPromopt", z5);
        }
        boolean z6 = uVar.Ph;
        if (z6) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "needReport", z6);
        }
        int i6 = uVar.showTime;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "showTime", i6);
        }
        long j6 = uVar.aci;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "playDuration", j6);
        }
        return jSONObject;
    }
}
