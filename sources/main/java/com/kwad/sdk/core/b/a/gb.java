package com.kwad.sdk.core.b.a;

import androidx.core.app.NotificationCompat;
import com.kwad.components.ad.j.b;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class gb implements com.kwad.sdk.core.d<b.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(b.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(b.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.LM = jSONObject.optString("device_model");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(aVar.LM)) {
            aVar.LM = "";
        }
        aVar.LN = jSONObject.optString(com.umeng.analytics.pro.bi.F);
        if (obj.toString().equals(aVar.LN)) {
            aVar.LN = "";
        }
        aVar.LO = jSONObject.optString("os_version");
        if (obj.toString().equals(aVar.LO)) {
            aVar.LO = "";
        }
        aVar.LP = jSONObject.optString("rom_name");
        if (obj.toString().equals(aVar.LP)) {
            aVar.LP = "";
        }
        aVar.LQ = jSONObject.optString("device_id");
        if (obj.toString().equals(aVar.LQ)) {
            aVar.LQ = "";
        }
        aVar.status = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
        aVar.LR = jSONObject.optString("install_check_record");
        if (obj.toString().equals(aVar.LR)) {
            aVar.LR = "";
        }
        aVar.LS = jSONObject.optString("local_installer_pkgs");
        if (obj.toString().equals(aVar.LS)) {
            aVar.LS = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.LM;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "device_model", aVar.LM);
        }
        String str2 = aVar.LN;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, com.umeng.analytics.pro.bi.F, aVar.LN);
        }
        String str3 = aVar.LO;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "os_version", aVar.LO);
        }
        String str4 = aVar.LP;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "rom_name", aVar.LP);
        }
        String str5 = aVar.LQ;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "device_id", aVar.LQ);
        }
        int i6 = aVar.status;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, NotificationCompat.CATEGORY_STATUS, i6);
        }
        String str6 = aVar.LR;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "install_check_record", aVar.LR);
        }
        String str7 = aVar.LS;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "local_installer_pkgs", aVar.LS);
        }
        return jSONObject;
    }
}
