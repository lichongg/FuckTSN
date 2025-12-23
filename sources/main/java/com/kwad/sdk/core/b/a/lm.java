package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.scene.URLPackage;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class lm implements com.kwad.sdk.core.d<URLPackage> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(URLPackage uRLPackage, JSONObject jSONObject) {
        a2(uRLPackage, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(URLPackage uRLPackage, JSONObject jSONObject) {
        return b2(uRLPackage, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(URLPackage uRLPackage, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        uRLPackage.page = jSONObject.optInt("page");
        uRLPackage.identity = jSONObject.optString("identity");
        if (JSONObject.NULL.toString().equals(uRLPackage.identity)) {
            uRLPackage.identity = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(URLPackage uRLPackage, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = uRLPackage.page;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "page", i6);
        }
        String str = uRLPackage.identity;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "identity", uRLPackage.identity);
        }
        return jSONObject;
    }
}
