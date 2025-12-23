package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class aj implements com.kwad.sdk.core.d<AdInfo.AdMaterialInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdMaterialInfo adMaterialInfo, JSONObject jSONObject) {
        a2(adMaterialInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdMaterialInfo adMaterialInfo, JSONObject jSONObject) {
        return b2(adMaterialInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.AdMaterialInfo adMaterialInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adMaterialInfo.materialType = jSONObject.optInt("materialType", new Integer("2").intValue());
        adMaterialInfo.videoVoice = jSONObject.optBoolean("videoVoice", new Boolean("false").booleanValue());
        adMaterialInfo.materialFeatureList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("materialFeature");
        if (optJSONArray != null) {
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                AdInfo.AdMaterialInfo.MaterialFeature materialFeature = new AdInfo.AdMaterialInfo.MaterialFeature();
                materialFeature.parseJson(optJSONArray.optJSONObject(i6));
                adMaterialInfo.materialFeatureList.add(materialFeature);
            }
        }
        adMaterialInfo.derivativeMaterialType = jSONObject.optInt("derivativeMaterialType");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo.AdMaterialInfo adMaterialInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "materialType", adMaterialInfo.materialType);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "videoVoice", adMaterialInfo.videoVoice);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "materialFeature", adMaterialInfo.materialFeatureList);
        int i6 = adMaterialInfo.derivativeMaterialType;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "derivativeMaterialType", i6);
        }
        return jSONObject;
    }
}
