package com.kwad.sdk.core.b.a;

import cn.jpush.android.api.JThirdPlatFormInterface;
import com.kwad.components.core.webview.jshandler.a;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class hs implements com.kwad.sdk.core.d<a.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.c cVar, JSONObject jSONObject) {
        a2(cVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.c cVar, JSONObject jSONObject) {
        return b2(cVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.errorCode = jSONObject.optInt("errorCode");
        cVar.ach = jSONObject.optInt(JThirdPlatFormInterface.KEY_EXTRA);
        cVar.aci = jSONObject.optLong("playDuration");
        cVar.acj = jSONObject.optBoolean("clickRewardDialog");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = cVar.errorCode;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "errorCode", i6);
        }
        int i7 = cVar.ach;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, JThirdPlatFormInterface.KEY_EXTRA, i7);
        }
        long j6 = cVar.aci;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "playDuration", j6);
        }
        boolean z5 = cVar.acj;
        if (z5) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "clickRewardDialog", z5);
        }
        return jSONObject;
    }
}
