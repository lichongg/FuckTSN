package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class bx implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.c.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.commercial.c.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.commercial.c.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.commercial.c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.creativeId = jSONObject.optLong("creative_id");
        aVar.llsid = jSONObject.optLong("llsid");
        aVar.posId = jSONObject.optLong("pos_Id");
        aVar.templateId = jSONObject.optString("template_id");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(aVar.templateId)) {
            aVar.templateId = "";
        }
        aVar.templateVersion = jSONObject.optString("template_version");
        if (obj.toString().equals(aVar.templateVersion)) {
            aVar.templateVersion = "";
        }
        aVar.tkPublishType = jSONObject.optInt("tk_publish_type");
        aVar.errorCode = jSONObject.optInt("error_code");
        aVar.errorMsg = jSONObject.optString("error_msg");
        if (obj.toString().equals(aVar.errorMsg)) {
            aVar.errorMsg = "";
        }
        aVar.campaignType = jSONObject.optInt("campaign_type");
        aVar.ocpcActionType = jSONObject.optInt("ocpc_action_type");
        aVar.industryFirstLevelId = jSONObject.optInt("industry_first_level_id");
        aVar.adOperationType = jSONObject.optInt("ad_operation_type");
        aVar.webUriSourceType = jSONObject.optInt("web_uri_source_type");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.commercial.c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j6 = aVar.creativeId;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "creative_id", j6);
        }
        long j7 = aVar.llsid;
        if (j7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "llsid", j7);
        }
        long j8 = aVar.posId;
        if (j8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "pos_Id", j8);
        }
        String str = aVar.templateId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "template_id", aVar.templateId);
        }
        String str2 = aVar.templateVersion;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "template_version", aVar.templateVersion);
        }
        int i6 = aVar.tkPublishType;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "tk_publish_type", i6);
        }
        int i7 = aVar.errorCode;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "error_code", i7);
        }
        String str3 = aVar.errorMsg;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "error_msg", aVar.errorMsg);
        }
        int i8 = aVar.campaignType;
        if (i8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "campaign_type", i8);
        }
        int i9 = aVar.ocpcActionType;
        if (i9 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ocpc_action_type", i9);
        }
        int i10 = aVar.industryFirstLevelId;
        if (i10 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "industry_first_level_id", i10);
        }
        int i11 = aVar.adOperationType;
        if (i11 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ad_operation_type", i11);
        }
        int i12 = aVar.webUriSourceType;
        if (i12 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "web_uri_source_type", i12);
        }
        return jSONObject;
    }
}
