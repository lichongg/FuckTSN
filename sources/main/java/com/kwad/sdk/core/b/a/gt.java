package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class gt implements com.kwad.sdk.core.d<com.kwad.components.core.page.b.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.page.b.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.page.b.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.page.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.adStyle = jSONObject.optInt("ad_style");
        aVar.Tx = jSONObject.optInt("neo_tk_render_type");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.page.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = aVar.adStyle;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ad_style", i6);
        }
        int i7 = aVar.Tx;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "neo_tk_render_type", i7);
        }
        return jSONObject;
    }
}
