package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class cq implements com.kwad.sdk.core.d<AdMatrixInfo.ComponentParam> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.ComponentParam componentParam, JSONObject jSONObject) {
        a2(componentParam, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.ComponentParam componentParam, JSONObject jSONObject) {
        return b2(componentParam, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdMatrixInfo.ComponentParam componentParam, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        componentParam.pageId = jSONObject.optLong("page_id");
        componentParam.endPageId = jSONObject.optLong("endcard_page_id");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdMatrixInfo.ComponentParam componentParam, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j6 = componentParam.pageId;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "page_id", j6);
        }
        long j7 = componentParam.endPageId;
        if (j7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "endcard_page_id", j7);
        }
        return jSONObject;
    }
}
