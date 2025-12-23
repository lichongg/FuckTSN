package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.adlog.a;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ch implements com.kwad.sdk.core.d<a.C0675a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0675a c0675a, JSONObject jSONObject) {
        a2(c0675a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0675a c0675a, JSONObject jSONObject) {
        return b2(c0675a, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(a.C0675a c0675a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0675a.awU = jSONObject.optInt("ad_retry_type");
        c0675a.templateId = jSONObject.optString("template_id");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(c0675a.templateId)) {
            c0675a.templateId = "";
        }
        c0675a.awV = jSONObject.optString("template_sub_id");
        if (obj.toString().equals(c0675a.awV)) {
            c0675a.awV = "";
        }
        c0675a.awW = jSONObject.optString("default_type");
        if (obj.toString().equals(c0675a.awW)) {
            c0675a.awW = "";
        }
        c0675a.awY = jSONObject.optString("template_show_type");
        if (obj.toString().equals(c0675a.awY)) {
            c0675a.awY = "";
        }
        c0675a.awZ = jSONObject.optInt("network_download_status", new Integer("3").intValue());
        c0675a.axa = jSONObject.optInt("award_task_name");
        c0675a.axb = jSONObject.optInt("jumps_liveroom_type");
        c0675a.axc = jSONObject.optInt("universe_feature_freg");
        c0675a.axd = jSONObject.optInt("replace_url_succ");
        c0675a.axe = jSONObject.optBoolean("is_dp_opt");
        c0675a.axf = jSONObject.optString("component_module");
        if (obj.toString().equals(c0675a.axf)) {
            c0675a.axf = "";
        }
        c0675a.axh = jSONObject.optInt("is_carousel");
        c0675a.axi = jSONObject.optInt("is_special_preload");
        c0675a.axj = jSONObject.optInt("card_type");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(a.C0675a c0675a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = c0675a.awU;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ad_retry_type", i6);
        }
        String str = c0675a.templateId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "template_id", c0675a.templateId);
        }
        String str2 = c0675a.awV;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "template_sub_id", c0675a.awV);
        }
        String str3 = c0675a.awW;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "default_type", c0675a.awW);
        }
        String str4 = c0675a.awY;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "template_show_type", c0675a.awY);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "network_download_status", c0675a.awZ);
        int i7 = c0675a.axa;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "award_task_name", i7);
        }
        int i8 = c0675a.axb;
        if (i8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "jumps_liveroom_type", i8);
        }
        int i9 = c0675a.axc;
        if (i9 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "universe_feature_freg", i9);
        }
        int i10 = c0675a.axd;
        if (i10 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "replace_url_succ", i10);
        }
        boolean z5 = c0675a.axe;
        if (z5) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "is_dp_opt", z5);
        }
        String str5 = c0675a.axf;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "component_module", c0675a.axf);
        }
        int i11 = c0675a.axh;
        if (i11 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "is_carousel", i11);
        }
        int i12 = c0675a.axi;
        if (i12 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "is_special_preload", i12);
        }
        int i13 = c0675a.axj;
        if (i13 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "card_type", i13);
        }
        return jSONObject;
    }
}
