package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ak implements com.kwad.sdk.core.d<AdMatrixInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo adMatrixInfo, JSONObject jSONObject) {
        a2(adMatrixInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo adMatrixInfo, JSONObject jSONObject) {
        return b2(adMatrixInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdMatrixInfo adMatrixInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        AdMatrixInfo.Styles styles = new AdMatrixInfo.Styles();
        adMatrixInfo.styles = styles;
        styles.parseJson(jSONObject.optJSONObject("styles"));
        AdMatrixInfo.AdDataV2 adDataV2 = new AdMatrixInfo.AdDataV2();
        adMatrixInfo.adDataV2 = adDataV2;
        adDataV2.parseJson(jSONObject.optJSONObject("adDataV2"));
        adMatrixInfo.tag = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray(CommonNetImpl.TAG);
        if (optJSONArray != null) {
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                AdMatrixInfo.MatrixTag matrixTag = new AdMatrixInfo.MatrixTag();
                matrixTag.parseJson(optJSONArray.optJSONObject(i6));
                adMatrixInfo.tag.add(matrixTag);
            }
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdMatrixInfo adMatrixInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "styles", adMatrixInfo.styles);
        com.kwad.sdk.utils.aa.a(jSONObject, "adDataV2", adMatrixInfo.adDataV2);
        com.kwad.sdk.utils.aa.putValue(jSONObject, CommonNetImpl.TAG, adMatrixInfo.tag);
        return jSONObject;
    }
}
