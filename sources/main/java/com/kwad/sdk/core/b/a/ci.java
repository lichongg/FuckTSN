package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.report.n;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ci implements com.kwad.sdk.core.d<n.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(n.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(n.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(n.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aHN = jSONObject.optInt("posIdWidth");
        aVar.aHO = jSONObject.optInt("posIdHeight");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(n.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = aVar.aHN;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "posIdWidth", i6);
        }
        int i7 = aVar.aHO;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "posIdHeight", i7);
        }
        return jSONObject;
    }
}
