package com.kwad.sdk.core.b.a;

import com.umeng.socialize.net.dplus.CommonNetImpl;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class kr implements com.kwad.sdk.core.d<com.kwad.sdk.n.b.a.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.n.b.a.d dVar, JSONObject jSONObject) {
        a2(dVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.n.b.a.d dVar, JSONObject jSONObject) {
        return b2(dVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.n.b.a.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.name = jSONObject.optString(CommonNetImpl.NAME);
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(dVar.name)) {
            dVar.name = "";
        }
        dVar.aXO = jSONObject.optString("detect_info");
        if (obj.toString().equals(dVar.aXO)) {
            dVar.aXO = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.n.b.a.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = dVar.name;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, CommonNetImpl.NAME, dVar.name);
        }
        String str2 = dVar.aXO;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "detect_info", dVar.aXO);
        }
        return jSONObject;
    }
}
