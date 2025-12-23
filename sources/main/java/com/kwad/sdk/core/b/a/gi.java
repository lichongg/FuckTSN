package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.HttpDnsInfo;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class gi implements com.kwad.sdk.core.d<HttpDnsInfo.IpInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(HttpDnsInfo.IpInfo ipInfo, JSONObject jSONObject) {
        a2(ipInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(HttpDnsInfo.IpInfo ipInfo, JSONObject jSONObject) {
        return b2(ipInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(HttpDnsInfo.IpInfo ipInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        ipInfo.ip = jSONObject.optString(IjkMediaPlayer.OnNativeInvokeListener.ARG_IP);
        if (JSONObject.NULL.toString().equals(ipInfo.ip)) {
            ipInfo.ip = "";
        }
        ipInfo.weight = jSONObject.optInt("weight");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(HttpDnsInfo.IpInfo ipInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = ipInfo.ip;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, IjkMediaPlayer.OnNativeInvokeListener.ARG_IP, ipInfo.ip);
        }
        int i6 = ipInfo.weight;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "weight", i6);
        }
        return jSONObject;
    }
}
