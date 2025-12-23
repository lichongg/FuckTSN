package com.kwad.sdk.core.b.a;

import com.kwad.sdk.j.a;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class jn implements com.kwad.sdk.core.d<a.C0702a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0702a c0702a, JSONObject jSONObject) {
        a2(c0702a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0702a c0702a, JSONObject jSONObject) {
        return b2(c0702a, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(a.C0702a c0702a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0702a.aTs = jSONObject.optInt("ds");
        c0702a.sdkVersion = jSONObject.optString("sv");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(c0702a.sdkVersion)) {
            c0702a.sdkVersion = "";
        }
        c0702a.aOu = jSONObject.optString("spv");
        if (obj.toString().equals(c0702a.aOu)) {
            c0702a.aOu = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(a.C0702a c0702a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = c0702a.aTs;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ds", i6);
        }
        String str = c0702a.sdkVersion;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sv", c0702a.sdkVersion);
        }
        String str2 = c0702a.aOu;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "spv", c0702a.aOu);
        }
        return jSONObject;
    }
}
