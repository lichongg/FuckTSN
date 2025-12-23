package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class dk implements com.kwad.sdk.core.d<AdInfo.AdConversionInfo.DeeplinkItemInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdConversionInfo.DeeplinkItemInfo deeplinkItemInfo, JSONObject jSONObject) {
        a2(deeplinkItemInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdConversionInfo.DeeplinkItemInfo deeplinkItemInfo, JSONObject jSONObject) {
        return b2(deeplinkItemInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.AdConversionInfo.DeeplinkItemInfo deeplinkItemInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        deeplinkItemInfo.sceneConf = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("sceneConf");
        if (optJSONArray != null) {
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                deeplinkItemInfo.sceneConf.add((Integer) optJSONArray.opt(i6));
            }
        }
        deeplinkItemInfo.areaConf = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("areaConf");
        if (optJSONArray2 != null) {
            for (int i7 = 0; i7 < optJSONArray2.length(); i7++) {
                deeplinkItemInfo.areaConf.add((Integer) optJSONArray2.opt(i7));
            }
        }
        deeplinkItemInfo.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(deeplinkItemInfo.url)) {
            deeplinkItemInfo.url = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo.AdConversionInfo.DeeplinkItemInfo deeplinkItemInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "sceneConf", deeplinkItemInfo.sceneConf);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "areaConf", deeplinkItemInfo.areaConf);
        String str = deeplinkItemInfo.url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "url", deeplinkItemInfo.url);
        }
        return jSONObject;
    }
}
