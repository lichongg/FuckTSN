package com.kwad.sdk.core.b.a;

import com.kwad.sdk.n.a.b;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class lb implements com.kwad.sdk.core.d<b.C0706b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(b.C0706b c0706b, JSONObject jSONObject) {
        a2(c0706b, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(b.C0706b c0706b, JSONObject jSONObject) {
        return b2(c0706b, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(b.C0706b c0706b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0706b.name = jSONObject.optString(CommonNetImpl.NAME);
        if (JSONObject.NULL.toString().equals(c0706b.name)) {
            c0706b.name = "";
        }
        c0706b.aXE = jSONObject.optBoolean("isStatic");
        c0706b.aXF = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("paramList");
        if (optJSONArray != null) {
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                b.a aVar = new b.a();
                aVar.parseJson(optJSONArray.optJSONObject(i6));
                c0706b.aXF.add(aVar);
            }
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(b.C0706b c0706b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0706b.name;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, CommonNetImpl.NAME, c0706b.name);
        }
        boolean z5 = c0706b.aXE;
        if (z5) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isStatic", z5);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "paramList", c0706b.aXF);
        return jSONObject;
    }
}
