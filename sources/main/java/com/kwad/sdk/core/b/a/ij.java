package com.kwad.sdk.core.b.a;

import com.kwad.sdk.n.a.b;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ij implements com.kwad.sdk.core.d<b.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(b.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(b.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aXx = jSONObject.optString("typeStr");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(aVar.aXx)) {
            aVar.aXx = "";
        }
        aVar.aXy = jSONObject.optString("valueStr");
        if (obj.toString().equals(aVar.aXy)) {
            aVar.aXy = "";
        }
        aVar.aXz = jSONObject.optString("listValueType");
        if (obj.toString().equals(aVar.aXz)) {
            aVar.aXz = "";
        }
        aVar.aXA = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("valueStrList");
        if (optJSONArray != null) {
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                aVar.aXA.add((String) optJSONArray.opt(i6));
            }
        }
        aVar.fieldName = jSONObject.optString("fieldName");
        Object obj2 = JSONObject.NULL;
        if (obj2.toString().equals(aVar.fieldName)) {
            aVar.fieldName = "";
        }
        aVar.className = jSONObject.optString("className");
        if (obj2.toString().equals(aVar.className)) {
            aVar.className = "";
        }
        aVar.aXB = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("childParamList");
        if (optJSONArray2 != null) {
            for (int i7 = 0; i7 < optJSONArray2.length(); i7++) {
                b.a aVar2 = new b.a();
                aVar2.parseJson(optJSONArray2.optJSONObject(i7));
                aVar.aXB.add(aVar2);
            }
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.aXx;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "typeStr", aVar.aXx);
        }
        String str2 = aVar.aXy;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "valueStr", aVar.aXy);
        }
        String str3 = aVar.aXz;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "listValueType", aVar.aXz);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "valueStrList", aVar.aXA);
        String str4 = aVar.fieldName;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "fieldName", aVar.fieldName);
        }
        String str5 = aVar.className;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "className", aVar.className);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "childParamList", aVar.aXB);
        return jSONObject;
    }
}
