package com.kwad.sdk.core.b.a;

import com.tencent.connect.common.Constants;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ai implements com.kwad.sdk.core.d<com.kwad.sdk.core.adlog.a.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.adlog.a.c cVar, JSONObject jSONObject) {
        a2(cVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.adlog.a.c cVar, JSONObject jSONObject) {
        return b2(cVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.adlog.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.axz = jSONObject.optBoolean("retrySwitch");
        cVar.axA = jSONObject.optInt("retryCountConfig", new Integer("1").intValue());
        cVar.axB = jSONObject.optLong("cacheExpireTime", new Long("600").longValue());
        cVar.axC = jSONObject.optInt("retryQueueSize", new Integer(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ).intValue());
        cVar.axD = jSONObject.optBoolean("retryCountFeeOnly");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.adlog.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z5 = cVar.axz;
        if (z5) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "retrySwitch", z5);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "retryCountConfig", cVar.axA);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "cacheExpireTime", cVar.axB);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "retryQueueSize", cVar.axC);
        boolean z6 = cVar.axD;
        if (z6) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "retryCountFeeOnly", z6);
        }
        return jSONObject;
    }
}
