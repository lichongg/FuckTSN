package com.kwad.sdk.core.b.a;

import com.kwad.sdk.j.a;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class jo implements com.kwad.sdk.core.d<a.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.aTt = jSONObject.optInt("enable_monitor");
        bVar.aTu = jSONObject.optString("c_sc_name");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(bVar.aTu)) {
            bVar.aTu = "";
        }
        bVar.aTv = jSONObject.optString("c_pcl_name");
        if (obj.toString().equals(bVar.aTv)) {
            bVar.aTv = "";
        }
        bVar.aTw = jSONObject.optString("m_gam_name");
        if (obj.toString().equals(bVar.aTw)) {
            bVar.aTw = "";
        }
        bVar.aTx = jSONObject.optString("m_gsv_name");
        if (obj.toString().equals(bVar.aTx)) {
            bVar.aTx = "";
        }
        bVar.aTy = jSONObject.optString("m_gpv_name");
        if (obj.toString().equals(bVar.aTy)) {
            bVar.aTy = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = bVar.aTt;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "enable_monitor", i6);
        }
        String str = bVar.aTu;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "c_sc_name", bVar.aTu);
        }
        String str2 = bVar.aTv;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "c_pcl_name", bVar.aTv);
        }
        String str3 = bVar.aTw;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "m_gam_name", bVar.aTw);
        }
        String str4 = bVar.aTx;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "m_gsv_name", bVar.aTx);
        }
        String str5 = bVar.aTy;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "m_gpv_name", bVar.aTy);
        }
        return jSONObject;
    }
}
