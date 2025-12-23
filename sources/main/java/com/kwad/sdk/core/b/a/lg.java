package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class lg implements com.kwad.sdk.core.d<AdMatrixInfo.TemplateData> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.TemplateData templateData, JSONObject jSONObject) {
        a2(templateData, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.TemplateData templateData, JSONObject jSONObject) {
        return b2(templateData, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdMatrixInfo.TemplateData templateData, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        templateData.templateShowTime = jSONObject.optLong("templateShowTime");
        templateData.templateDelayTime = jSONObject.optLong("templateDelayTime");
        templateData.data = jSONObject.optString("data");
        if (JSONObject.NULL.toString().equals(templateData.data)) {
            templateData.data = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdMatrixInfo.TemplateData templateData, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j6 = templateData.templateShowTime;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "templateShowTime", j6);
        }
        long j7 = templateData.templateDelayTime;
        if (j7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "templateDelayTime", j7);
        }
        String str = templateData.data;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "data", templateData.data);
        }
        return jSONObject;
    }
}
