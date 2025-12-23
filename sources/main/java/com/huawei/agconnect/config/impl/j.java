package com.huawei.agconnect.config.impl;

import com.baidu.mobads.sdk.internal.cm;
import com.umeng.analytics.pro.bi;
import com.umeng.socialize.common.SocializeConstants;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes5.dex */
class j implements f {

    /* renamed from: a, reason: collision with root package name */
    private final JSONObject f32945a;

    private JSONObject b(InputStream inputStream) {
        if (inputStream != null) {
            try {
                return new JSONObject(b.g(inputStream, "UTF-8"));
            } catch (IOException | JSONException unused) {
            }
        }
        return new JSONObject();
    }

    private void c(String str) {
        try {
            JSONObject e6 = e(str);
            if (e6 == null) {
                return;
            }
            String a6 = a("/configuration_version", "");
            BigDecimal bigDecimal = new BigDecimal(cm.f10901d);
            try {
                bigDecimal = BigDecimal.valueOf(Double.parseDouble(a6));
            } catch (NumberFormatException unused) {
            }
            if (bigDecimal.compareTo(new BigDecimal("2.0")) == 0) {
                this.f32945a.getJSONObject("client").put("app_id", e6.getString("app_id"));
                return;
            }
            if (bigDecimal.compareTo(new BigDecimal(SocializeConstants.PROTOCOL_VERSON)) >= 0) {
                Iterator<String> keys = e6.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!bi.f40972o.equals(next)) {
                        d(next, e6.get(next), this.f32945a);
                    }
                }
            }
        } catch (JSONException unused2) {
        }
    }

    private void d(String str, Object obj, JSONObject jSONObject) throws JSONException {
        if (str == null || obj == null || jSONObject == null) {
            return;
        }
        if (!(obj instanceof JSONObject)) {
            jSONObject.put(str, obj);
            return;
        }
        JSONObject jSONObject2 = (JSONObject) obj;
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            d(next, jSONObject2.get(next), jSONObject.getJSONObject(str));
        }
    }

    private JSONObject e(String str) throws JSONException {
        JSONArray jSONArray = this.f32945a.getJSONArray("appInfos");
        for (int i6 = 0; i6 < jSONArray.length(); i6++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i6);
            if (jSONObject.getString(bi.f40972o).equals(str)) {
                return jSONObject;
            }
        }
        return null;
    }

    @Override // com.huawei.agconnect.config.impl.f
    public String a(String str, String str2) {
        if (!str.endsWith("/")) {
            String[] split = str.split("/");
            try {
                JSONObject jSONObject = this.f32945a;
                for (int i6 = 1; i6 < split.length; i6++) {
                    if (i6 == split.length - 1) {
                        return jSONObject.get(split[i6]).toString();
                    }
                    jSONObject = jSONObject.getJSONObject(split[i6]);
                }
            } catch (JSONException unused) {
            }
        }
        return str2;
    }

    public String toString() {
        return "InputStreamReader{config=" + this.f32945a.toString().hashCode() + '}';
    }

    j(InputStream inputStream, String str) {
        this.f32945a = b(inputStream);
        c(str);
    }
}
