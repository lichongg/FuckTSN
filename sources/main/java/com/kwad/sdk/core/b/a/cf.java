package com.kwad.sdk.core.b.a;

import com.baidu.idl.face.platform.FaceEnvironment;
import com.kwad.components.core.webview.jshandler.a.a;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class cf implements com.kwad.sdk.core.d<a.C0638a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0638a c0638a, JSONObject jSONObject) {
        a2(c0638a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0638a c0638a, JSONObject jSONObject) {
        return b2(c0638a, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(a.C0638a c0638a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0638a.aeH = jSONObject.optString(FaceEnvironment.OS);
        if (JSONObject.NULL.toString().equals(c0638a.aeH)) {
            c0638a.aeH = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(a.C0638a c0638a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0638a.aeH;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, FaceEnvironment.OS, c0638a.aeH);
        }
        return jSONObject;
    }
}
