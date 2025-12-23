package com.kwad.sdk.core.b.a;

import com.kwad.sdk.n.d;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ix implements com.kwad.sdk.core.d<com.kwad.sdk.n.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.n.d dVar, JSONObject jSONObject) {
        a2(dVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.n.d dVar, JSONObject jSONObject) {
        return b2(dVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.n.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.funcSwitch = jSONObject.optLong("funcSwitch");
        dVar.aXc = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("urlList");
        if (optJSONArray != null) {
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                dVar.aXc.add((String) optJSONArray.opt(i6));
            }
        }
        dVar.aXd = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("actConfigList");
        if (optJSONArray2 != null) {
            for (int i7 = 0; i7 < optJSONArray2.length(); i7++) {
                d.a aVar = new d.a();
                aVar.parseJson(optJSONArray2.optJSONObject(i7));
                dVar.aXd.add(aVar);
            }
        }
        dVar.byteCount = jSONObject.optLong("byteCount");
        dVar.sampleRate = jSONObject.optDouble("sampleRate");
        dVar.aXe = new ArrayList();
        JSONArray optJSONArray3 = jSONObject.optJSONArray("anchorNodeList");
        if (optJSONArray3 != null) {
            for (int i8 = 0; i8 < optJSONArray3.length(); i8++) {
                com.kwad.sdk.n.a.b bVar = new com.kwad.sdk.n.a.b();
                bVar.parseJson(optJSONArray3.optJSONObject(i8));
                dVar.aXe.add(bVar);
            }
        }
        dVar.aWU = new ArrayList();
        JSONArray optJSONArray4 = jSONObject.optJSONArray("aggregationCheckConfigList");
        if (optJSONArray4 != null) {
            for (int i9 = 0; i9 < optJSONArray4.length(); i9++) {
                com.kwad.sdk.n.a.a aVar2 = new com.kwad.sdk.n.a.a();
                aVar2.parseJson(optJSONArray4.optJSONObject(i9));
                dVar.aWU.add(aVar2);
            }
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.n.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j6 = dVar.funcSwitch;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "funcSwitch", j6);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "urlList", dVar.aXc);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "actConfigList", dVar.aXd);
        long j7 = dVar.byteCount;
        if (j7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "byteCount", j7);
        }
        double d6 = dVar.sampleRate;
        if (d6 != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sampleRate", d6);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "anchorNodeList", dVar.aXe);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "aggregationCheckConfigList", dVar.aWU);
        return jSONObject;
    }
}
