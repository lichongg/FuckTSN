package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class kx implements com.kwad.sdk.core.d<AdMatrixInfo.Styles> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.Styles styles, JSONObject jSONObject) {
        a2(styles, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.Styles styles, JSONObject jSONObject) {
        return b2(styles, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdMatrixInfo.Styles styles, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        styles.templateList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("templates");
        if (optJSONArray != null) {
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                AdMatrixInfo.MatrixTemplate matrixTemplate = new AdMatrixInfo.MatrixTemplate();
                matrixTemplate.parseJson(optJSONArray.optJSONObject(i6));
                styles.templateList.add(matrixTemplate);
            }
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdMatrixInfo.Styles styles, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "templates", styles.templateList);
        return jSONObject;
    }
}
