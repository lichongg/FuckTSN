package com.kwad.sdk.core.b.a;

import com.kwad.sdk.o.l;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class kp implements com.kwad.sdk.core.d<l.a.C0708a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(l.a.C0708a c0708a, JSONObject jSONObject) {
        a2(c0708a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(l.a.C0708a c0708a, JSONObject jSONObject) {
        return b2(c0708a, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(l.a.C0708a c0708a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0708a.beg = jSONObject.optString("s_cn");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(c0708a.beg)) {
            c0708a.beg = "";
        }
        c0708a.beh = jSONObject.optString("s_mn");
        if (obj.toString().equals(c0708a.beh)) {
            c0708a.beh = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(l.a.C0708a c0708a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0708a.beg;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "s_cn", c0708a.beg);
        }
        String str2 = c0708a.beh;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "s_mn", c0708a.beh);
        }
        return jSONObject;
    }
}
