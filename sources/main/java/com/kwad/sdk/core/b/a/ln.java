package com.kwad.sdk.core.b.a;

import androidx.core.app.NotificationCompat;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.kwad.sdk.mobileid.UaidInfo;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ln implements com.kwad.sdk.core.d<UaidInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(UaidInfo uaidInfo, JSONObject jSONObject) {
        a2(uaidInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(UaidInfo uaidInfo, JSONObject jSONObject) {
        return b2(uaidInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(UaidInfo uaidInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        uaidInfo.status = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
        uaidInfo.canRequest = jSONObject.optString("can_request");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(uaidInfo.canRequest)) {
            uaidInfo.canRequest = "";
        }
        uaidInfo.traceId = jSONObject.optString("trace_id");
        if (obj.toString().equals(uaidInfo.traceId)) {
            uaidInfo.traceId = "";
        }
        uaidInfo.operatorType = jSONObject.optInt("operator_type");
        uaidInfo.networkType = jSONObject.optInt(com.umeng.analytics.pro.bi.T);
        uaidInfo.dcontrollerEnableNetwork = jSONObject.optBoolean("dcontroller_enable_network");
        uaidInfo.dcontrollerEnablePhoneState = jSONObject.optBoolean("dcontroller_enable_phone_state");
        uaidInfo.imsiNotEmpty = jSONObject.optBoolean("imsi_not_empty");
        uaidInfo.uaid = jSONObject.optString("uaid");
        if (obj.toString().equals(uaidInfo.uaid)) {
            uaidInfo.uaid = "";
        }
        uaidInfo.result = jSONObject.optInt("result");
        uaidInfo.token = jSONObject.optString(JThirdPlatFormInterface.KEY_TOKEN);
        if (obj.toString().equals(uaidInfo.token)) {
            uaidInfo.token = "";
        }
        uaidInfo.errorCode = jSONObject.optString("error_code");
        if (obj.toString().equals(uaidInfo.errorCode)) {
            uaidInfo.errorCode = "";
        }
        uaidInfo.errorMsg = jSONObject.optString("error_msg");
        if (obj.toString().equals(uaidInfo.errorMsg)) {
            uaidInfo.errorMsg = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(UaidInfo uaidInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = uaidInfo.status;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, NotificationCompat.CATEGORY_STATUS, i6);
        }
        String str = uaidInfo.canRequest;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "can_request", uaidInfo.canRequest);
        }
        String str2 = uaidInfo.traceId;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "trace_id", uaidInfo.traceId);
        }
        int i7 = uaidInfo.operatorType;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "operator_type", i7);
        }
        int i8 = uaidInfo.networkType;
        if (i8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, com.umeng.analytics.pro.bi.T, i8);
        }
        boolean z5 = uaidInfo.dcontrollerEnableNetwork;
        if (z5) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "dcontroller_enable_network", z5);
        }
        boolean z6 = uaidInfo.dcontrollerEnablePhoneState;
        if (z6) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "dcontroller_enable_phone_state", z6);
        }
        boolean z7 = uaidInfo.imsiNotEmpty;
        if (z7) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "imsi_not_empty", z7);
        }
        String str3 = uaidInfo.uaid;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "uaid", uaidInfo.uaid);
        }
        int i9 = uaidInfo.result;
        if (i9 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "result", i9);
        }
        String str4 = uaidInfo.token;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, JThirdPlatFormInterface.KEY_TOKEN, uaidInfo.token);
        }
        String str5 = uaidInfo.errorCode;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "error_code", uaidInfo.errorCode);
        }
        String str6 = uaidInfo.errorMsg;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "error_msg", uaidInfo.errorMsg);
        }
        return jSONObject;
    }
}
