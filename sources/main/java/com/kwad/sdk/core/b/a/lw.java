package com.kwad.sdk.core.b.a;

import com.kwad.components.core.video.a.d;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class lw implements com.kwad.sdk.core.d<d.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(d.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(d.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(d.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.code = jSONObject.optInt("code");
        aVar.msg = jSONObject.optString("msg");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(aVar.msg)) {
            aVar.msg = "";
        }
        aVar.videoUrl = jSONObject.optString("video_url");
        if (obj.toString().equals(aVar.videoUrl)) {
            aVar.videoUrl = "";
        }
        aVar.llsid = jSONObject.optLong("llsid");
        aVar.creativeId = jSONObject.optLong("creative_id");
        aVar.XI = jSONObject.optLong("ad_info_uid");
        aVar.abz = jSONObject.optString("ad_info_user_name");
        if (obj.toString().equals(aVar.abz)) {
            aVar.abz = "";
        }
        aVar.abA = jSONObject.optInt("ad_media_player_type");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(d.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = aVar.code;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "code", i6);
        }
        String str = aVar.msg;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "msg", aVar.msg);
        }
        String str2 = aVar.videoUrl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "video_url", aVar.videoUrl);
        }
        long j6 = aVar.llsid;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "llsid", j6);
        }
        long j7 = aVar.creativeId;
        if (j7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "creative_id", j7);
        }
        long j8 = aVar.XI;
        if (j8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ad_info_uid", j8);
        }
        String str3 = aVar.abz;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ad_info_user_name", aVar.abz);
        }
        int i7 = aVar.abA;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ad_media_player_type", i7);
        }
        return jSONObject;
    }
}
