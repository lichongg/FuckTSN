package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.h.a.a.b;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class lj implements com.kwad.sdk.core.d<b.a> {
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
        aVar.qw = jSONObject.optInt("timerName");
        aVar.qx = jSONObject.optInt("time");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = aVar.qw;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "timerName", i6);
        }
        int i7 = aVar.qx;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "time", i7);
        }
        return jSONObject;
    }
}
