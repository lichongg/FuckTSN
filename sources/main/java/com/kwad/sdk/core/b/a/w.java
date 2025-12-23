package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.y;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class w implements com.kwad.sdk.core.d<y.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(y.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(y.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(y.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.creativeId = jSONObject.optLong("creativeId", new Long("-1").longValue());
        aVar.adStyle = jSONObject.optInt("adStyle", new Integer("-1").intValue());
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(y.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "creativeId", aVar.creativeId);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "adStyle", aVar.adStyle);
        return jSONObject;
    }
}
