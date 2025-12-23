package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.reward.h;
import org.json.JSONObject;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class cm implements com.kwad.sdk.core.d<h.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(h.c cVar, JSONObject jSONObject) {
        a2(cVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(h.c cVar, JSONObject jSONObject) {
        return b2(cVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(h.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.style = jSONObject.optInt(ResIdentify.RES_TYPE_STYLE);
        cVar.title = jSONObject.optString("title");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(cVar.title)) {
            cVar.title = "";
        }
        cVar.sS = jSONObject.optString("closeBtnText");
        if (obj.toString().equals(cVar.sS)) {
            cVar.sS = "";
        }
        cVar.sT = jSONObject.optString("continueBtnText");
        if (obj.toString().equals(cVar.sT)) {
            cVar.sT = "";
        }
        cVar.sU = jSONObject.optString("viewDetailText");
        if (obj.toString().equals(cVar.sU)) {
            cVar.sU = "";
        }
        cVar.sV = jSONObject.optString("unWatchedVideoTime");
        if (obj.toString().equals(cVar.sV)) {
            cVar.sV = "";
        }
        cVar.sW = jSONObject.optString("iconUrl");
        if (obj.toString().equals(cVar.sW)) {
            cVar.sW = "";
        }
        cVar.sX = jSONObject.optString("desc");
        if (obj.toString().equals(cVar.sX)) {
            cVar.sX = "";
        }
        cVar.sY = jSONObject.optString("descTxt");
        if (obj.toString().equals(cVar.sY)) {
            cVar.sY = "";
        }
        cVar.sZ = jSONObject.optString("currentPlayTime");
        if (obj.toString().equals(cVar.sZ)) {
            cVar.sZ = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(h.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = cVar.style;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, ResIdentify.RES_TYPE_STYLE, i6);
        }
        String str = cVar.title;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "title", cVar.title);
        }
        String str2 = cVar.sS;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "closeBtnText", cVar.sS);
        }
        String str3 = cVar.sT;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "continueBtnText", cVar.sT);
        }
        String str4 = cVar.sU;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "viewDetailText", cVar.sU);
        }
        String str5 = cVar.sV;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "unWatchedVideoTime", cVar.sV);
        }
        String str6 = cVar.sW;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "iconUrl", cVar.sW);
        }
        String str7 = cVar.sX;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "desc", cVar.sX);
        }
        String str8 = cVar.sY;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "descTxt", cVar.sY);
        }
        String str9 = cVar.sZ;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "currentPlayTime", cVar.sZ);
        }
        return jSONObject;
    }
}
