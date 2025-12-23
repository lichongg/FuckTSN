package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.g;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class fa implements com.kwad.sdk.core.d<g.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(g.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(g.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(g.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.showLiveStatus = jSONObject.optInt("showLiveStatus");
        aVar.showLiveStyle = jSONObject.optInt("showLiveStyle");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(g.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = aVar.showLiveStatus;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "showLiveStatus", i6);
        }
        int i7 = aVar.showLiveStyle;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "showLiveStyle", i7);
        }
        return jSONObject;
    }
}
