package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class kw implements com.kwad.sdk.core.d<AdMatrixInfo.StyleInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.StyleInfo styleInfo, JSONObject jSONObject) {
        a2(styleInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.StyleInfo styleInfo, JSONObject jSONObject) {
        return b2(styleInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdMatrixInfo.StyleInfo styleInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        styleInfo.title = jSONObject.optString("title");
        if (JSONObject.NULL.toString().equals(styleInfo.title)) {
            styleInfo.title = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdMatrixInfo.StyleInfo styleInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = styleInfo.title;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "title", styleInfo.title);
        }
        return jSONObject;
    }
}
