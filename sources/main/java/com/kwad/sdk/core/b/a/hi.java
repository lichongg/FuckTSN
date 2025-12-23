package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class hi implements com.kwad.sdk.core.d<com.kwad.sdk.crash.online.monitor.a.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.crash.online.monitor.a.c cVar, JSONObject jSONObject) {
        a2(cVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.crash.online.monitor.a.c cVar, JSONObject jSONObject) {
        return b2(cVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.crash.online.monitor.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        com.kwad.sdk.crash.online.monitor.a.a aVar = new com.kwad.sdk.crash.online.monitor.a.a();
        cVar.aQl = aVar;
        aVar.parseJson(jSONObject.optJSONObject("blockConfig"));
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.crash.online.monitor.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "blockConfig", cVar.aQl);
        return jSONObject;
    }
}
