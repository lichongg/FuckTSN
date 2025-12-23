package com.bytedance.sdk.openadsdk.core.up.xt;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r {

    /* renamed from: j, reason: collision with root package name */
    public String f30945j;
    public String xt;

    public static JSONObject j(List<r> list) {
        if (list == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        for (r rVar : list) {
            if (rVar != null) {
                jSONArray.put(j(rVar.f30945j, rVar.xt));
            }
        }
        try {
            jSONObject.put("ads", jSONArray);
            return jSONObject;
        } catch (JSONException e6) {
            throw new RuntimeException(e6);
        }
    }

    public r(String str, String str2) {
        this.f30945j = str;
        this.xt = str2;
    }

    public static JSONObject j(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            String upperCase = com.bytedance.sdk.component.utils.up.xt("id=" + str + "&timestamp=" + currentTimeMillis + "&ext=" + str2).toUpperCase();
            jSONObject.put("id", str);
            jSONObject.put("timestamp", currentTimeMillis);
            jSONObject.put("sign", upperCase);
            jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_EXTEND, str2);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static List<r> j(n nVar) {
        if (nVar == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new r(nVar.fs(), nVar.os()));
        String kg = nVar.kg();
        if (!TextUtils.isEmpty(kg)) {
            try {
                JSONArray jSONArray = new JSONArray(kg);
                for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i6);
                    if (optJSONObject != null) {
                        arrayList.add(new r(optJSONObject.optString(MediationConstant.EXTRA_ADID), optJSONObject.optString(SocializeProtocolConstants.PROTOCOL_KEY_EXTEND)));
                    }
                }
            } catch (JSONException e6) {
                throw new RuntimeException(e6);
            }
        }
        return arrayList;
    }

    public static n j(cw cwVar, n nVar) {
        Map<String, Boolean> map;
        Boolean bool;
        Boolean bool2;
        if (cwVar != null && (map = cwVar.xt) != null && nVar != null && (bool = map.get(nVar.fs())) != null && bool.booleanValue()) {
            String kg = nVar.kg();
            if (!TextUtils.isEmpty(kg)) {
                try {
                    JSONArray jSONArray = new JSONArray(kg);
                    for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i6);
                        if (optJSONObject != null && ((bool2 = map.get(optJSONObject.optString(MediationConstant.EXTRA_ADID))) == null || !bool2.booleanValue())) {
                            return null;
                        }
                    }
                } catch (JSONException e6) {
                    vl.j(e6);
                }
            }
            return nVar;
        }
        return null;
    }
}
