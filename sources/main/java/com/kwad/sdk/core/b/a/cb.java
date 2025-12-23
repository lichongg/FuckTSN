package com.kwad.sdk.core.b.a;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class cb implements com.kwad.sdk.core.d<com.kwad.sdk.crash.online.monitor.block.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.crash.online.monitor.block.d dVar, JSONObject jSONObject) {
        a2(dVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.crash.online.monitor.block.d dVar, JSONObject jSONObject) {
        return b2(dVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.crash.online.monitor.block.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.aPO = jSONObject.optString("printerName");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(dVar.aPO)) {
            dVar.aPO = "";
        }
        dVar.errorMsg = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
        if (obj.toString().equals(dVar.errorMsg)) {
            dVar.errorMsg = "";
        }
        dVar.aPP = jSONObject.optBoolean("isDisable");
        dVar.aPQ = jSONObject.optBoolean("hasMatrix");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.crash.online.monitor.block.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = dVar.aPO;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "printerName", dVar.aPO);
        }
        String str2 = dVar.errorMsg;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, MediationConstant.KEY_ERROR_MSG, dVar.errorMsg);
        }
        boolean z5 = dVar.aPP;
        if (z5) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isDisable", z5);
        }
        boolean z6 = dVar.aPQ;
        if (z6) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "hasMatrix", z6);
        }
        return jSONObject;
    }
}
