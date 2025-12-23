package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class mb implements com.kwad.sdk.core.d<WebCardVideoPositionHandler.VideoPosition> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(WebCardVideoPositionHandler.VideoPosition videoPosition, JSONObject jSONObject) {
        a2(videoPosition, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(WebCardVideoPositionHandler.VideoPosition videoPosition, JSONObject jSONObject) {
        return b2(videoPosition, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(WebCardVideoPositionHandler.VideoPosition videoPosition, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        videoPosition.leftMarginRation = jSONObject.optDouble("leftMarginRation");
        videoPosition.topMarginRation = jSONObject.optDouble("topMarginRation");
        videoPosition.widthRation = jSONObject.optDouble("widthRation");
        videoPosition.heightWidthRation = jSONObject.optDouble("heightWidthRation");
        videoPosition.leftMargin = jSONObject.optInt("leftMargin");
        videoPosition.topMargin = jSONObject.optInt("topMargin");
        videoPosition.width = jSONObject.optInt("width");
        videoPosition.height = jSONObject.optInt("height");
        videoPosition.borderRadius = jSONObject.optInt("borderRadius");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(WebCardVideoPositionHandler.VideoPosition videoPosition, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        double d6 = videoPosition.leftMarginRation;
        if (d6 != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "leftMarginRation", d6);
        }
        double d7 = videoPosition.topMarginRation;
        if (d7 != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "topMarginRation", d7);
        }
        double d8 = videoPosition.widthRation;
        if (d8 != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "widthRation", d8);
        }
        double d9 = videoPosition.heightWidthRation;
        if (d9 != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "heightWidthRation", d9);
        }
        int i6 = videoPosition.leftMargin;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "leftMargin", i6);
        }
        int i7 = videoPosition.topMargin;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "topMargin", i7);
        }
        int i8 = videoPosition.width;
        if (i8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "width", i8);
        }
        int i9 = videoPosition.height;
        if (i9 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "height", i9);
        }
        int i10 = videoPosition.borderRadius;
        if (i10 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "borderRadius", i10);
        }
        return jSONObject;
    }
}
