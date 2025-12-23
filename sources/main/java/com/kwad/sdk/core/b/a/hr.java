package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.nativead.monitor.NativeAdMonitor;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class hr implements com.kwad.sdk.core.d<NativeAdMonitor.NativeReportMsg> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(NativeAdMonitor.NativeReportMsg nativeReportMsg, JSONObject jSONObject) {
        a2(nativeReportMsg, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(NativeAdMonitor.NativeReportMsg nativeReportMsg, JSONObject jSONObject) {
        return b2(nativeReportMsg, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(NativeAdMonitor.NativeReportMsg nativeReportMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        nativeReportMsg.state = jSONObject.optInt("state");
        nativeReportMsg.containerType = jSONObject.optString("container_type");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(nativeReportMsg.containerType)) {
            nativeReportMsg.containerType = "";
        }
        nativeReportMsg.containerName = jSONObject.optString("container_name");
        if (obj.toString().equals(nativeReportMsg.containerName)) {
            nativeReportMsg.containerName = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(NativeAdMonitor.NativeReportMsg nativeReportMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = nativeReportMsg.state;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "state", i6);
        }
        String str = nativeReportMsg.containerType;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "container_type", nativeReportMsg.containerType);
        }
        String str2 = nativeReportMsg.containerName;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "container_name", nativeReportMsg.containerName);
        }
        return jSONObject;
    }
}
