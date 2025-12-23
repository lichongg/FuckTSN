package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class jx implements com.kwad.sdk.core.d<AdMatrixInfo.SlideInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.SlideInfo slideInfo, JSONObject jSONObject) {
        a2(slideInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.SlideInfo slideInfo, JSONObject jSONObject) {
        return b2(slideInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdMatrixInfo.SlideInfo slideInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        slideInfo.angle = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("angle");
        if (optJSONArray != null) {
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                slideInfo.angle.add((Integer) optJSONArray.opt(i6));
            }
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdMatrixInfo.SlideInfo slideInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "angle", slideInfo.angle);
        return jSONObject;
    }
}
