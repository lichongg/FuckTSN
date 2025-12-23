package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.j;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class fe implements com.kwad.sdk.core.d<j.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(j.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(j.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(j.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.acq = jSONObject.optInt("playableSrc");
        bVar.acr = jSONObject.optInt("isMiddleEnd");
        bVar.Re = jSONObject.optInt("adType");
        bVar.acs = jSONObject.optString("showTime");
        if (JSONObject.NULL.toString().equals(bVar.acs)) {
            bVar.acs = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(j.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = bVar.acq;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "playableSrc", i6);
        }
        int i7 = bVar.acr;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isMiddleEnd", i7);
        }
        int i8 = bVar.Re;
        if (i8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adType", i8);
        }
        String str = bVar.acs;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "showTime", bVar.acs);
        }
        return jSONObject;
    }
}
