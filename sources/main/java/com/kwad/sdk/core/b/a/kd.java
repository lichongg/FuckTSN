package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class kd implements com.kwad.sdk.core.d<AdMatrixInfo.SplashEndCardTKInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.SplashEndCardTKInfo splashEndCardTKInfo, JSONObject jSONObject) {
        a2(splashEndCardTKInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.SplashEndCardTKInfo splashEndCardTKInfo, JSONObject jSONObject) {
        return b2(splashEndCardTKInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdMatrixInfo.SplashEndCardTKInfo splashEndCardTKInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        splashEndCardTKInfo.endCardCountDaily = jSONObject.optInt("endCardCountDaily", new Integer("5").intValue());
        splashEndCardTKInfo.endCardShowSecond = jSONObject.optInt("endCardShowSecond", new Integer("5").intValue());
        splashEndCardTKInfo.endCardFullScreenClick = jSONObject.optBoolean("endCardFullScreenClick", new Boolean("true").booleanValue());
        splashEndCardTKInfo.endCardShowCountDown = jSONObject.optBoolean("endCardShowCountDown", new Boolean("false").booleanValue());
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdMatrixInfo.SplashEndCardTKInfo splashEndCardTKInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "endCardCountDaily", splashEndCardTKInfo.endCardCountDaily);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "endCardShowSecond", splashEndCardTKInfo.endCardShowSecond);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "endCardFullScreenClick", splashEndCardTKInfo.endCardFullScreenClick);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "endCardShowCountDown", splashEndCardTKInfo.endCardShowCountDown);
        return jSONObject;
    }
}
