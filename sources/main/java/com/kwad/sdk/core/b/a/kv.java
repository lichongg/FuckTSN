package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class kv implements com.kwad.sdk.core.d<AdMatrixInfo.StyleComponentInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.StyleComponentInfo styleComponentInfo, JSONObject jSONObject) {
        a2(styleComponentInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.StyleComponentInfo styleComponentInfo, JSONObject jSONObject) {
        return b2(styleComponentInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdMatrixInfo.StyleComponentInfo styleComponentInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        AdMatrixInfo.ComponentTemplateInfo componentTemplateInfo = new AdMatrixInfo.ComponentTemplateInfo();
        styleComponentInfo.playCardInfo = componentTemplateInfo;
        componentTemplateInfo.parseJson(jSONObject.optJSONObject("playCardInfo"));
        AdMatrixInfo.ComponentTemplateInfo componentTemplateInfo2 = new AdMatrixInfo.ComponentTemplateInfo();
        styleComponentInfo.endCardInfo = componentTemplateInfo2;
        componentTemplateInfo2.parseJson(jSONObject.optJSONObject("endCardInfo"));
        styleComponentInfo.styleComponentFlag = jSONObject.optBoolean("styleComponentFlag");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdMatrixInfo.StyleComponentInfo styleComponentInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "playCardInfo", styleComponentInfo.playCardInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "endCardInfo", styleComponentInfo.endCardInfo);
        boolean z5 = styleComponentInfo.styleComponentFlag;
        if (z5) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "styleComponentFlag", z5);
        }
        return jSONObject;
    }
}
