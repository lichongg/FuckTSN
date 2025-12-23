package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class iu implements com.kwad.sdk.core.d<com.kwad.sdk.core.response.model.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.posId = jSONObject.optLong("posId");
        aVar.aIQ = jSONObject.optInt("adPhotoCountForMedia");
        aVar.aIR = jSONObject.optBoolean("enablePreload");
        aVar.aIS = jSONObject.optLong("increaseAdLoadTime", new Long("10000").longValue());
        aVar.aIT = jSONObject.optInt("adLoadStrategy");
        aVar.aIU = jSONObject.optInt("drawAdForcedWatchTimes", new Integer("3").intValue());
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j6 = aVar.posId;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "posId", j6);
        }
        int i6 = aVar.aIQ;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adPhotoCountForMedia", i6);
        }
        boolean z5 = aVar.aIR;
        if (z5) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "enablePreload", z5);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "increaseAdLoadTime", aVar.aIS);
        int i7 = aVar.aIT;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adLoadStrategy", i7);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "drawAdForcedWatchTimes", aVar.aIU);
        return jSONObject;
    }
}
