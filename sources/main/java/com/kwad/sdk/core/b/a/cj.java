package com.kwad.sdk.core.b.a;

import com.tencent.open.SocialConstants;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class cj implements com.kwad.sdk.core.d<com.kwad.sdk.core.report.h> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.report.h hVar, JSONObject jSONObject) {
        a2(hVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.report.h hVar, JSONObject jSONObject) {
        return b2(hVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.report.h hVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        hVar.llsid = jSONObject.optLong("llsid");
        hVar.creativeId = jSONObject.optLong("creative_id");
        hVar.score = jSONObject.optInt("score");
        hVar.aGB = jSONObject.optInt("is_bidding");
        hVar.source = jSONObject.optString(SocialConstants.PARAM_SOURCE);
        if (JSONObject.NULL.toString().equals(hVar.source)) {
            hVar.source = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.report.h hVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j6 = hVar.llsid;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "llsid", j6);
        }
        long j7 = hVar.creativeId;
        if (j7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "creative_id", j7);
        }
        int i6 = hVar.score;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "score", i6);
        }
        int i7 = hVar.aGB;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "is_bidding", i7);
        }
        String str = hVar.source;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, SocialConstants.PARAM_SOURCE, hVar.source);
        }
        return jSONObject;
    }
}
