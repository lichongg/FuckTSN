package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class hy implements com.kwad.sdk.core.d<com.kwad.sdk.core.network.j> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.network.j jVar, JSONObject jSONObject) {
        a2(jVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.network.j jVar, JSONObject jSONObject) {
        return b2(jVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.network.j jVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        jVar.aEJ = jSONObject.optLong("request_prepare_cost");
        jVar.aEK = jSONObject.optLong("request_add_params_cost");
        jVar.aEL = jSONObject.optLong("request_create_cost");
        jVar.aEM = jSONObject.optInt("keep_alive");
        jVar.aEN = jSONObject.optLong("dns_start");
        jVar.aEO = jSONObject.optLong("dns_cost");
        jVar.aEP = jSONObject.optLong("connect_establish_start");
        jVar.aEQ = jSONObject.optLong("connect_establish_cost");
        jVar.aER = jSONObject.optLong("request_start");
        jVar.aES = jSONObject.optLong("request_cost");
        jVar.aET = jSONObject.optLong("request_size");
        jVar.aEU = jSONObject.optLong("response_start");
        jVar.aEV = jSONObject.optLong("response_cost");
        jVar.aEW = jSONObject.optLong("response_parse_cost");
        jVar.aEX = jSONObject.optLong("response_size");
        jVar.aEY = jSONObject.optLong("waiting_response_cost");
        jVar.aEZ = jSONObject.optLong("total_cost");
        jVar.aFa = jSONObject.optInt("proxy_used");
        jVar.aFb = jSONObject.optString("request_id");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(jVar.aFb)) {
            jVar.aFb = "";
        }
        jVar.aFc = jSONObject.optInt("has_data_v2");
        jVar.result = jSONObject.optInt("result");
        jVar.aFd = jSONObject.optLong("response_done_cost");
        jVar.aFe = jSONObject.optString("host_ip");
        if (obj.toString().equals(jVar.aFe)) {
            jVar.aFe = "";
        }
        jVar.aFf = jSONObject.optInt("ip_type");
        jVar.aFg = jSONObject.optInt("recommend_ping_time");
        jVar.aFh = jSONObject.optInt("backup_ping_time");
        jVar.aFi = jSONObject.optInt("other_ping_time");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.network.j jVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j6 = jVar.aEJ;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "request_prepare_cost", j6);
        }
        long j7 = jVar.aEK;
        if (j7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "request_add_params_cost", j7);
        }
        long j8 = jVar.aEL;
        if (j8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "request_create_cost", j8);
        }
        int i6 = jVar.aEM;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "keep_alive", i6);
        }
        long j9 = jVar.aEN;
        if (j9 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "dns_start", j9);
        }
        long j10 = jVar.aEO;
        if (j10 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "dns_cost", j10);
        }
        long j11 = jVar.aEP;
        if (j11 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "connect_establish_start", j11);
        }
        long j12 = jVar.aEQ;
        if (j12 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "connect_establish_cost", j12);
        }
        long j13 = jVar.aER;
        if (j13 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "request_start", j13);
        }
        long j14 = jVar.aES;
        if (j14 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "request_cost", j14);
        }
        long j15 = jVar.aET;
        if (j15 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "request_size", j15);
        }
        long j16 = jVar.aEU;
        if (j16 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "response_start", j16);
        }
        long j17 = jVar.aEV;
        if (j17 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "response_cost", j17);
        }
        long j18 = jVar.aEW;
        if (j18 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "response_parse_cost", j18);
        }
        long j19 = jVar.aEX;
        if (j19 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "response_size", j19);
        }
        long j20 = jVar.aEY;
        if (j20 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "waiting_response_cost", j20);
        }
        long j21 = jVar.aEZ;
        if (j21 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "total_cost", j21);
        }
        int i7 = jVar.aFa;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "proxy_used", i7);
        }
        String str = jVar.aFb;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "request_id", jVar.aFb);
        }
        int i8 = jVar.aFc;
        if (i8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "has_data_v2", i8);
        }
        int i9 = jVar.result;
        if (i9 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "result", i9);
        }
        long j22 = jVar.aFd;
        if (j22 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "response_done_cost", j22);
        }
        String str2 = jVar.aFe;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "host_ip", jVar.aFe);
        }
        int i10 = jVar.aFf;
        if (i10 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ip_type", i10);
        }
        int i11 = jVar.aFg;
        if (i11 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "recommend_ping_time", i11);
        }
        int i12 = jVar.aFh;
        if (i12 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "backup_ping_time", i12);
        }
        int i13 = jVar.aFi;
        if (i13 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "other_ping_time", i13);
        }
        return jSONObject;
    }
}
