package com.bytedance.sdk.openadsdk.core.i.j;

import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.openadsdk.core.rn;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class kt extends com.bytedance.sdk.component.j.up<JSONObject, JSONObject> {

    /* renamed from: j, reason: collision with root package name */
    private String f29140j;
    private com.bytedance.sdk.openadsdk.core.rn xt;

    public static void j(com.bytedance.sdk.component.j.i iVar, com.bytedance.sdk.openadsdk.core.rn rnVar) {
        iVar.j("appInfo", (com.bytedance.sdk.component.j.up<?, ?>) new kt("appInfo", rnVar));
        iVar.j("adInfo", (com.bytedance.sdk.component.j.up<?, ?>) new kt("adInfo", rnVar));
        iVar.j("getTemplateInfo", (com.bytedance.sdk.component.j.up<?, ?>) new kt("getTemplateInfo", rnVar));
        iVar.j("getTeMaiAds", (com.bytedance.sdk.component.j.up<?, ?>) new kt("getTeMaiAds", rnVar));
        iVar.j("isViewable", (com.bytedance.sdk.component.j.up<?, ?>) new kt("isViewable", rnVar));
        iVar.j("getScreenSize", (com.bytedance.sdk.component.j.up<?, ?>) new kt("getScreenSize", rnVar));
        iVar.j("getCloseButtonInfo", (com.bytedance.sdk.component.j.up<?, ?>) new kt("getCloseButtonInfo", rnVar));
        iVar.j("getVolume", (com.bytedance.sdk.component.j.up<?, ?>) new kt("getVolume", rnVar));
        iVar.j("sendReward", (com.bytedance.sdk.component.j.up<?, ?>) new kt("sendReward", rnVar));
        iVar.j("subscribe_app_ad", (com.bytedance.sdk.component.j.up<?, ?>) new kt("subscribe_app_ad", rnVar));
        iVar.j("download_app_ad", (com.bytedance.sdk.component.j.up<?, ?>) new kt("download_app_ad", rnVar));
        iVar.j("cancel_download_app_ad", (com.bytedance.sdk.component.j.up<?, ?>) new kt("cancel_download_app_ad", rnVar));
        iVar.j("unsubscribe_app_ad", (com.bytedance.sdk.component.j.up<?, ?>) new kt("unsubscribe_app_ad", rnVar));
        iVar.j("clickEvent", (com.bytedance.sdk.component.j.up<?, ?>) new kt("clickEvent", rnVar));
        iVar.j("renderDidFinish", (com.bytedance.sdk.component.j.up<?, ?>) new kt("renderDidFinish", rnVar));
        iVar.j("dynamicTrack", (com.bytedance.sdk.component.j.up<?, ?>) new kt("dynamicTrack", rnVar));
        iVar.j("skipVideo", (com.bytedance.sdk.component.j.up<?, ?>) new kt("skipVideo", rnVar));
        iVar.j("muteVideo", (com.bytedance.sdk.component.j.up<?, ?>) new kt("muteVideo", rnVar));
        iVar.j("changeVideoState", (com.bytedance.sdk.component.j.up<?, ?>) new kt("changeVideoState", rnVar));
        iVar.j("getCurrentVideoState", (com.bytedance.sdk.component.j.up<?, ?>) new kt("getCurrentVideoState", rnVar));
        iVar.j("send_temai_product_ids", (com.bytedance.sdk.component.j.up<?, ?>) new kt("send_temai_product_ids", rnVar));
        iVar.j("getMaterialMeta", (com.bytedance.sdk.component.j.up<?, ?>) new kt("getMaterialMeta", rnVar));
        iVar.j("endcard_load", (com.bytedance.sdk.component.j.up<?, ?>) new kt("endcard_load", rnVar));
        iVar.j("pauseWebView", (com.bytedance.sdk.component.j.up<?, ?>) new kt("pauseWebView", rnVar));
        iVar.j("pauseWebViewTimers", (com.bytedance.sdk.component.j.up<?, ?>) new kt("pauseWebViewTimers", rnVar));
        iVar.j("webview_time_track", (com.bytedance.sdk.component.j.up<?, ?>) new kt("webview_time_track", rnVar));
        iVar.j("adInfoStash", (com.bytedance.sdk.component.j.up<?, ?>) new kt("adInfoStash", rnVar));
    }

    public kt(String str, com.bytedance.sdk.openadsdk.core.rn rnVar) {
        this.xt = rnVar;
        this.f29140j = str;
    }

    @Override // com.bytedance.sdk.component.j.up
    public JSONObject j(JSONObject jSONObject, com.bytedance.sdk.component.j.m mVar) throws Exception {
        rn.j jVar = new rn.j();
        jVar.f30080j = NotificationCompat.CATEGORY_CALL;
        jVar.cw = this.f29140j;
        jVar.f30081r = jSONObject;
        return this.xt.j(jVar, 3);
    }
}
