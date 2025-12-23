package com.kwad.sdk.core.b.a;

import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class hw implements com.kwad.sdk.core.d<com.kwad.sdk.core.request.model.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.request.model.d dVar, JSONObject jSONObject) {
        a2(dVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.request.model.d dVar, JSONObject jSONObject) {
        return b2(dVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.request.model.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.aIB = jSONObject.optString(SocializeProtocolConstants.PROTOCOL_KEY_MAC);
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(dVar.aIB)) {
            dVar.aIB = "";
        }
        dVar.aIC = jSONObject.optString("kMac");
        if (obj.toString().equals(dVar.aIC)) {
            dVar.aIC = "";
        }
        dVar.aID = jSONObject.optInt("connectionType");
        dVar.operatorType = jSONObject.optInt("operatorType");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.request.model.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = dVar.aIB;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, SocializeProtocolConstants.PROTOCOL_KEY_MAC, dVar.aIB);
        }
        String str2 = dVar.aIC;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "kMac", dVar.aIC);
        }
        int i6 = dVar.aID;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "connectionType", i6);
        }
        int i7 = dVar.operatorType;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "operatorType", i7);
        }
        return jSONObject;
    }
}
