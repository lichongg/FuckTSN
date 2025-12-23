package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class gq implements com.kwad.sdk.core.d<WebCardVideoPositionHandler.VideoPosition.KSAdJSCornerModel> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(WebCardVideoPositionHandler.VideoPosition.KSAdJSCornerModel kSAdJSCornerModel, JSONObject jSONObject) {
        a2(kSAdJSCornerModel, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(WebCardVideoPositionHandler.VideoPosition.KSAdJSCornerModel kSAdJSCornerModel, JSONObject jSONObject) {
        return b2(kSAdJSCornerModel, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(WebCardVideoPositionHandler.VideoPosition.KSAdJSCornerModel kSAdJSCornerModel, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        kSAdJSCornerModel.topLeft = jSONObject.optDouble("topLeft");
        kSAdJSCornerModel.topRight = jSONObject.optDouble("topRight");
        kSAdJSCornerModel.bottomRight = jSONObject.optDouble("bottomRight");
        kSAdJSCornerModel.bottomLeft = jSONObject.optDouble("bottomLeft");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(WebCardVideoPositionHandler.VideoPosition.KSAdJSCornerModel kSAdJSCornerModel, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        double d6 = kSAdJSCornerModel.topLeft;
        if (d6 != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "topLeft", d6);
        }
        double d7 = kSAdJSCornerModel.topRight;
        if (d7 != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "topRight", d7);
        }
        double d8 = kSAdJSCornerModel.bottomRight;
        if (d8 != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "bottomRight", d8);
        }
        double d9 = kSAdJSCornerModel.bottomLeft;
        if (d9 != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "bottomLeft", d9);
        }
        return jSONObject;
    }
}
