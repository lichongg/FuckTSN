package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class hq implements com.kwad.sdk.core.d<AdMatrixInfo.NativeMatrixAdInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.NativeMatrixAdInfo nativeMatrixAdInfo, JSONObject jSONObject) {
        a2(nativeMatrixAdInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.NativeMatrixAdInfo nativeMatrixAdInfo, JSONObject jSONObject) {
        return b2(nativeMatrixAdInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdMatrixInfo.NativeMatrixAdInfo nativeMatrixAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        AdMatrixInfo.AdInteractionInfo adInteractionInfo = new AdMatrixInfo.AdInteractionInfo();
        nativeMatrixAdInfo.interactionInfo = adInteractionInfo;
        adInteractionInfo.parseJson(jSONObject.optJSONObject("interactionInfo"));
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdMatrixInfo.NativeMatrixAdInfo nativeMatrixAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "interactionInfo", nativeMatrixAdInfo.interactionInfo);
        return jSONObject;
    }
}
