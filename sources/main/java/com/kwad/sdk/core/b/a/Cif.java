package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* renamed from: com.kwad.sdk.core.b.a.if, reason: invalid class name */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class Cif implements com.kwad.sdk.core.d<com.kwad.sdk.core.config.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.config.d dVar, JSONObject jSONObject) {
        a2(dVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.config.d dVar, JSONObject jSONObject) {
        return b2(dVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.config.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.aCc = jSONObject.optInt("enableDialog", new Integer("0").intValue());
        dVar.aCd = jSONObject.optInt("delayTime", new Integer("800").intValue());
        dVar.aCe = jSONObject.optInt("showTimesPerDay", new Integer("3").intValue());
        dVar.aCf = jSONObject.optInt("maxShowTimes", new Integer("100000").intValue());
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.config.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "enableDialog", dVar.aCc);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "delayTime", dVar.aCd);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "showTimesPerDay", dVar.aCe);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "maxShowTimes", dVar.aCf);
        return jSONObject;
    }
}
