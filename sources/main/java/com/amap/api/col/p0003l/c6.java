package com.amap.api.col.p0003l;

import android.content.Context;
import com.huawei.hms.framework.common.ContainerUtils;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class c6 extends l4 {

    /* renamed from: r, reason: collision with root package name */
    public JSONObject f5847r = null;

    /* renamed from: s, reason: collision with root package name */
    public Context f5848s = null;

    @Override // com.amap.api.col.p0003l.Cif
    public final Map<String, String> getParams() {
        return null;
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final byte[] getEntityBytes() {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            JSONObject jSONObject = this.f5847r;
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    stringBuffer.append(next + ContainerUtils.KEY_VALUE_DELIMITER + URLEncoder.encode(this.f5847r.get(next).toString(), "utf-8") + ContainerUtils.FIELD_DELIMITER);
                }
            }
            stringBuffer.append("output=json");
            String j6 = f4.j(this.f5848s);
            stringBuffer.append("&key=".concat(String.valueOf(j6)));
            String a6 = h4.a();
            stringBuffer.append("&ts=".concat(String.valueOf(a6)));
            stringBuffer.append("&scode=" + h4.c(this.f5848s, a6, "key=".concat(String.valueOf(j6))));
            return stringBuffer.toString().getBytes("utf-8");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final Map<String, String> getRequestHead() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/x-www-form-urlencoded");
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("User-Agent", "AMAP SDK Android core 4.3.11");
        hashMap.put("X-INFO", h4.i(this.f5848s));
        hashMap.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", "4.3.11", "core"));
        hashMap.put("logversion", "2.1");
        return hashMap;
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final String getSDKName() {
        return "core";
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final String getURL() {
        if (k4.a().h()) {
            return "https://restsdk.amap.com/sdk/compliance/params";
        }
        return "http://restsdk.amap.com/sdk/compliance/params";
    }
}
