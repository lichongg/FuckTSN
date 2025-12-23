package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.bg;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class fm implements com.kwad.sdk.core.d<bg.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(bg.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(bg.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(bg.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.visibility = jSONObject.optInt("visibility");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(bg.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = aVar.visibility;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "visibility", i6);
        }
        return jSONObject;
    }
}
