package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ae implements com.kwad.sdk.core.d<AdInfo.AdLiveTypeInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdLiveTypeInfo adLiveTypeInfo, JSONObject jSONObject) {
        a2(adLiveTypeInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdLiveTypeInfo adLiveTypeInfo, JSONObject jSONObject) {
        return b2(adLiveTypeInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.AdLiveTypeInfo adLiveTypeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adLiveTypeInfo.actionbarCardType = jSONObject.optInt("actionbarCardType");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo.AdLiveTypeInfo adLiveTypeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = adLiveTypeInfo.actionbarCardType;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "actionbarCardType", i6);
        }
        return jSONObject;
    }
}
