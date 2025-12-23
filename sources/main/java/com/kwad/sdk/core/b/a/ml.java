package com.kwad.sdk.core.b.a;

import com.kwad.sdk.o.l;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ml implements com.kwad.sdk.core.d<l.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(l.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(l.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(l.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.bee = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("c_cns");
        if (optJSONArray != null) {
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                aVar.bee.add((String) optJSONArray.opt(i6));
            }
        }
        aVar.bef = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("s_cns");
        if (optJSONArray2 != null) {
            for (int i7 = 0; i7 < optJSONArray2.length(); i7++) {
                l.a.C0708a c0708a = new l.a.C0708a();
                c0708a.parseJson(optJSONArray2.optJSONObject(i7));
                aVar.bef.add(c0708a);
            }
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(l.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "c_cns", aVar.bee);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "s_cns", aVar.bef);
        return jSONObject;
    }
}
