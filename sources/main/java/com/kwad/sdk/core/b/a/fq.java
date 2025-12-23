package com.kwad.sdk.core.b.a;

import com.kwad.sdk.commercial.model.HybridLoadMsg;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class fq implements com.kwad.sdk.core.d<HybridLoadMsg> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(HybridLoadMsg hybridLoadMsg, JSONObject jSONObject) {
        a2(hybridLoadMsg, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(HybridLoadMsg hybridLoadMsg, JSONObject jSONObject) {
        return b2(hybridLoadMsg, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(HybridLoadMsg hybridLoadMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        hybridLoadMsg.sceneId = jSONObject.optString("scene_id");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(hybridLoadMsg.sceneId)) {
            hybridLoadMsg.sceneId = "";
        }
        hybridLoadMsg.h5Version = jSONObject.optString("h5_version");
        if (obj.toString().equals(hybridLoadMsg.h5Version)) {
            hybridLoadMsg.h5Version = "";
        }
        hybridLoadMsg.loadType = jSONObject.optInt("load_type");
        hybridLoadMsg.state = jSONObject.optInt("state");
        hybridLoadMsg.interval = jSONObject.optString(com.umeng.analytics.pro.bi.aX);
        if (obj.toString().equals(hybridLoadMsg.interval)) {
            hybridLoadMsg.interval = "";
        }
        hybridLoadMsg.failState = jSONObject.optInt("fail_state");
        hybridLoadMsg.failReason = jSONObject.optString("fail_reason");
        if (obj.toString().equals(hybridLoadMsg.failReason)) {
            hybridLoadMsg.failReason = "";
        }
        hybridLoadMsg.url = jSONObject.optString("url");
        if (obj.toString().equals(hybridLoadMsg.url)) {
            hybridLoadMsg.url = "";
        }
        hybridLoadMsg.packageUrl = jSONObject.optString("package_url");
        if (obj.toString().equals(hybridLoadMsg.packageUrl)) {
            hybridLoadMsg.packageUrl = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(HybridLoadMsg hybridLoadMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = hybridLoadMsg.sceneId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "scene_id", hybridLoadMsg.sceneId);
        }
        String str2 = hybridLoadMsg.h5Version;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "h5_version", hybridLoadMsg.h5Version);
        }
        int i6 = hybridLoadMsg.loadType;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "load_type", i6);
        }
        int i7 = hybridLoadMsg.state;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "state", i7);
        }
        String str3 = hybridLoadMsg.interval;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, com.umeng.analytics.pro.bi.aX, hybridLoadMsg.interval);
        }
        int i8 = hybridLoadMsg.failState;
        if (i8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "fail_state", i8);
        }
        String str4 = hybridLoadMsg.failReason;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "fail_reason", hybridLoadMsg.failReason);
        }
        String str5 = hybridLoadMsg.url;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "url", hybridLoadMsg.url);
        }
        String str6 = hybridLoadMsg.packageUrl;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "package_url", hybridLoadMsg.packageUrl);
        }
        return jSONObject;
    }
}
