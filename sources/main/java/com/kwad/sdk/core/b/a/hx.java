package com.kwad.sdk.core.b.a;

import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class hx implements com.kwad.sdk.core.d<com.kwad.sdk.core.network.i> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.network.i iVar, JSONObject jSONObject) {
        a2(iVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.network.i iVar, JSONObject jSONObject) {
        return b2(iVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.network.i iVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        iVar.url = jSONObject.optString("url");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(iVar.url)) {
            iVar.url = "";
        }
        iVar.host = jSONObject.optString("host");
        if (obj.toString().equals(iVar.host)) {
            iVar.host = "";
        }
        iVar.httpCode = jSONObject.optInt(IjkMediaPlayer.OnNativeInvokeListener.ARG_HTTP_CODE);
        iVar.aEH = jSONObject.optString("req_type");
        if (obj.toString().equals(iVar.aEH)) {
            iVar.aEH = "";
        }
        iVar.aEI = jSONObject.optInt("use_ip");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.network.i iVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = iVar.url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "url", iVar.url);
        }
        String str2 = iVar.host;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "host", iVar.host);
        }
        int i6 = iVar.httpCode;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, IjkMediaPlayer.OnNativeInvokeListener.ARG_HTTP_CODE, i6);
        }
        String str3 = iVar.aEH;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "req_type", iVar.aEH);
        }
        int i7 = iVar.aEI;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "use_ip", i7);
        }
        return jSONObject;
    }
}
