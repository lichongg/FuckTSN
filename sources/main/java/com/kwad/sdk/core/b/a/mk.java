package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class mk implements com.kwad.sdk.core.d<AdStyleInfo.PlayDetailInfo.WidgetAdInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdStyleInfo.PlayDetailInfo.WidgetAdInfo widgetAdInfo, JSONObject jSONObject) {
        a2(widgetAdInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdStyleInfo.PlayDetailInfo.WidgetAdInfo widgetAdInfo, JSONObject jSONObject) {
        return b2(widgetAdInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdStyleInfo.PlayDetailInfo.WidgetAdInfo widgetAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        widgetAdInfo.widgetAdIcon = jSONObject.optString("widgetAdIcon");
        if (JSONObject.NULL.toString().equals(widgetAdInfo.widgetAdIcon)) {
            widgetAdInfo.widgetAdIcon = "";
        }
        widgetAdInfo.downloadStartLabel = jSONObject.optString("downloadStartLabel", new String("开始下载"));
        widgetAdInfo.downloadOngoingLabel = jSONObject.optString("downloadOngoingLabel", new String("下载中"));
        widgetAdInfo.downloadResumeLabel = jSONObject.optString("downloadResumeLabel", new String("恢复下载"));
        widgetAdInfo.installAppLabel = jSONObject.optString("installAppLabel", new String("开始安装"));
        widgetAdInfo.openAppLabel = jSONObject.optString("openAppLabel", new String("立刻打开"));
        widgetAdInfo.type = jSONObject.optInt("type");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdStyleInfo.PlayDetailInfo.WidgetAdInfo widgetAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = widgetAdInfo.widgetAdIcon;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "widgetAdIcon", widgetAdInfo.widgetAdIcon);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "downloadStartLabel", widgetAdInfo.downloadStartLabel);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "downloadOngoingLabel", widgetAdInfo.downloadOngoingLabel);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "downloadResumeLabel", widgetAdInfo.downloadResumeLabel);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "installAppLabel", widgetAdInfo.installAppLabel);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "openAppLabel", widgetAdInfo.openAppLabel);
        int i6 = widgetAdInfo.type;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "type", i6);
        }
        return jSONObject;
    }
}
