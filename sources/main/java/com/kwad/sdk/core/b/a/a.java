package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.ABParams;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a implements com.kwad.sdk.core.d<ABParams> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(ABParams aBParams, JSONObject jSONObject) {
        a2(aBParams, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(ABParams aBParams, JSONObject jSONObject) {
        return b2(aBParams, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(ABParams aBParams, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aBParams.videoBlackAreaClick = jSONObject.optInt("videoBlackAreaClick");
        aBParams.videoBlackAreaNewStyle = jSONObject.optInt("videoBlackAreaNewStyle");
        aBParams.drawActionBarTimes = jSONObject.optString("drawActionBarTimes");
        if (JSONObject.NULL.toString().equals(aBParams.drawActionBarTimes)) {
            aBParams.drawActionBarTimes = "";
        }
        aBParams.showVideoAtH5 = jSONObject.optInt("showVideoAtH5");
        aBParams.playableStyle = jSONObject.optInt("playableStyle");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(ABParams aBParams, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = aBParams.videoBlackAreaClick;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "videoBlackAreaClick", i6);
        }
        int i7 = aBParams.videoBlackAreaNewStyle;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "videoBlackAreaNewStyle", i7);
        }
        String str = aBParams.drawActionBarTimes;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "drawActionBarTimes", aBParams.drawActionBarTimes);
        }
        int i8 = aBParams.showVideoAtH5;
        if (i8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "showVideoAtH5", i8);
        }
        int i9 = aBParams.playableStyle;
        if (i9 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "playableStyle", i9);
        }
        return jSONObject;
    }
}
