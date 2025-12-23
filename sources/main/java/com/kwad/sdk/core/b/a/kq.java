package com.kwad.sdk.core.b.a;

import com.huawei.hms.mlsdk.common.MLApplicationSetting;
import com.kwad.components.core.webview.jshandler.v;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class kq implements com.kwad.sdk.core.d<v.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(v.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(v.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(v.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.packageName = jSONObject.optString(MLApplicationSetting.BundleKeyConstants.AppInfo.PACKAGE_NAME);
        if (JSONObject.NULL.toString().equals(bVar.packageName)) {
            bVar.packageName = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(v.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.packageName;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, MLApplicationSetting.BundleKeyConstants.AppInfo.PACKAGE_NAME, bVar.packageName);
        }
        return jSONObject;
    }
}
