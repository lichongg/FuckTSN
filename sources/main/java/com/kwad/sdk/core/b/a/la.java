package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.h.a;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class la implements com.kwad.sdk.core.d<a.C0687a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0687a c0687a, JSONObject jSONObject) {
        a2(c0687a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0687a c0687a, JSONObject jSONObject) {
        return b2(c0687a, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(a.C0687a c0687a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0687a.aJY = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("sdk_version");
        if (optJSONArray != null) {
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                c0687a.aJY.add((String) optJSONArray.opt(i6));
            }
        }
        c0687a.aJZ = jSONObject.optInt("os_version");
        c0687a.aKa = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("abi");
        if (optJSONArray2 != null) {
            for (int i7 = 0; i7 < optJSONArray2.length(); i7++) {
                c0687a.aKa.add((String) optJSONArray2.opt(i7));
            }
        }
        c0687a.aKb = new ArrayList();
        JSONArray optJSONArray3 = jSONObject.optJSONArray(com.baidu.mobads.sdk.internal.bn.f10754j);
        if (optJSONArray3 != null) {
            for (int i8 = 0; i8 < optJSONArray3.length(); i8++) {
                c0687a.aKb.add((String) optJSONArray3.opt(i8));
            }
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(a.C0687a c0687a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "sdk_version", c0687a.aJY);
        int i6 = c0687a.aJZ;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "os_version", i6);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "abi", c0687a.aKa);
        com.kwad.sdk.utils.aa.putValue(jSONObject, com.baidu.mobads.sdk.internal.bn.f10754j, c0687a.aKb);
        return jSONObject;
    }
}
