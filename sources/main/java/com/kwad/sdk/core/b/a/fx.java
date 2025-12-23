package com.kwad.sdk.core.b.a;

import com.huawei.hms.mlsdk.common.MLApplicationSetting;
import com.kwad.components.core.webview.jshandler.m;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class fx implements com.kwad.sdk.core.d<m.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(m.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(m.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(m.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.acu = jSONObject.optString("apkUrl");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(aVar.acu)) {
            aVar.acu = "";
        }
        aVar.packageName = jSONObject.optString(MLApplicationSetting.BundleKeyConstants.AppInfo.PACKAGE_NAME);
        if (obj.toString().equals(aVar.packageName)) {
            aVar.packageName = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(m.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.acu;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "apkUrl", aVar.acu);
        }
        String str2 = aVar.packageName;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, MLApplicationSetting.BundleKeyConstants.AppInfo.PACKAGE_NAME, aVar.packageName);
        }
        return jSONObject;
    }
}
