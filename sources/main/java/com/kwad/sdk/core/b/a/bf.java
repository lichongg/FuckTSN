package com.kwad.sdk.core.b.a;

import com.kwad.sdk.n.a.b;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class bf implements com.kwad.sdk.core.d<com.kwad.sdk.n.a.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.n.a.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.n.a.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.n.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.aXr = jSONObject.optString("nodeClassName");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(bVar.aXr)) {
            bVar.aXr = "";
        }
        bVar.aXs = jSONObject.optString("childFieldName");
        if (obj.toString().equals(bVar.aXs)) {
            bVar.aXs = "";
        }
        bVar.aXt = jSONObject.optBoolean("childFieldIsStatic");
        bVar.aXu = jSONObject.optString("reportKey");
        if (obj.toString().equals(bVar.aXu)) {
            bVar.aXu = "";
        }
        b.C0706b c0706b = new b.C0706b();
        bVar.aXv = c0706b;
        c0706b.parseJson(jSONObject.optJSONObject("childMethod"));
        com.kwad.sdk.n.a.b bVar2 = new com.kwad.sdk.n.a.b();
        bVar.aXw = bVar2;
        bVar2.parseJson(jSONObject.optJSONObject("deepNode"));
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.n.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.aXr;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "nodeClassName", bVar.aXr);
        }
        String str2 = bVar.aXs;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "childFieldName", bVar.aXs);
        }
        boolean z5 = bVar.aXt;
        if (z5) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "childFieldIsStatic", z5);
        }
        String str3 = bVar.aXu;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "reportKey", bVar.aXu);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "childMethod", bVar.aXv);
        com.kwad.sdk.utils.aa.a(jSONObject, "deepNode", bVar.aXw);
        return jSONObject;
    }
}
