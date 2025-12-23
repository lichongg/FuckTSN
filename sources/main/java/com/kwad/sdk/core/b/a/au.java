package com.kwad.sdk.core.b.a;

import cn.jpush.android.api.JThirdPlatFormInterface;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class au implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.d.b.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.webview.d.b.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.webview.d.b.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.webview.d.b.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        AdTemplate adTemplate = new AdTemplate();
        bVar.adTemplate = adTemplate;
        adTemplate.parseJson(jSONObject.optJSONObject("adTemplate"));
        bVar.aNS = jSONObject.optString("llsid");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(bVar.aNS)) {
            bVar.aNS = "";
        }
        bVar.extra = jSONObject.optString(JThirdPlatFormInterface.KEY_EXTRA);
        if (obj.toString().equals(bVar.extra)) {
            bVar.extra = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.webview.d.b.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "adTemplate", bVar.adTemplate);
        String str = bVar.aNS;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "llsid", bVar.aNS);
        }
        String str2 = bVar.extra;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, JThirdPlatFormInterface.KEY_EXTRA, bVar.extra);
        }
        return jSONObject;
    }
}
