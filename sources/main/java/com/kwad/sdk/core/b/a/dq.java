package com.kwad.sdk.core.b.a;

import com.huawei.hms.mlsdk.common.MLApplicationSetting;
import com.kwad.components.core.webview.a.a;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class dq implements com.kwad.sdk.core.d<a.C0636a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0636a c0636a, JSONObject jSONObject) {
        a2(c0636a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0636a c0636a, JSONObject jSONObject) {
        return b2(c0636a, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(a.C0636a c0636a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0636a.url = jSONObject.optString("url");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(c0636a.url)) {
            c0636a.url = "";
        }
        c0636a.packageName = jSONObject.optString(MLApplicationSetting.BundleKeyConstants.AppInfo.PACKAGE_NAME);
        if (obj.toString().equals(c0636a.packageName)) {
            c0636a.packageName = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(a.C0636a c0636a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0636a.url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "url", c0636a.url);
        }
        String str2 = c0636a.packageName;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, MLApplicationSetting.BundleKeyConstants.AppInfo.PACKAGE_NAME, c0636a.packageName);
        }
        return jSONObject;
    }
}
