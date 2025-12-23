package com.kwad.sdk.core.b.a;

import com.kwad.sdk.commercial.model.WebCloseStatus;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class mh implements com.kwad.sdk.core.d<WebCloseStatus> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(WebCloseStatus webCloseStatus, JSONObject jSONObject) {
        a2(webCloseStatus, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(WebCloseStatus webCloseStatus, JSONObject jSONObject) {
        return b2(webCloseStatus, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(WebCloseStatus webCloseStatus, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        webCloseStatus.interactSuccess = jSONObject.optBoolean("interactSuccess");
        webCloseStatus.closeType = jSONObject.optInt("closeType");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(WebCloseStatus webCloseStatus, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z5 = webCloseStatus.interactSuccess;
        if (z5) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "interactSuccess", z5);
        }
        int i6 = webCloseStatus.closeType;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "closeType", i6);
        }
        return jSONObject;
    }
}
