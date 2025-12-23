package com.amap.api.col.s;

import android.content.Context;
import com.huawei.hms.framework.common.ContainerUtils;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class i2 extends f1 {

    /* renamed from: m, reason: collision with root package name */
    public JSONObject f8166m = null;

    /* renamed from: n, reason: collision with root package name */
    public Context f8167n = null;

    @Override // com.amap.api.col.s.dz
    public final Map<String, String> o() {
        return null;
    }

    @Override // com.amap.api.col.s.dz
    public final String m() {
        return "core";
    }

    @Override // com.amap.api.col.s.dz
    public final Map<String, String> p() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/x-www-form-urlencoded");
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("User-Agent", "AMAP SDK Android core 4.3.5");
        hashMap.put("X-INFO", a1.b(this.f8167n));
        hashMap.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", "4.3.5", "core"));
        hashMap.put("logversion", "2.1");
        return hashMap;
    }

    @Override // com.amap.api.col.s.dz
    public final byte[] q() {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            JSONObject jSONObject = this.f8166m;
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    stringBuffer.append(next + ContainerUtils.KEY_VALUE_DELIMITER + URLEncoder.encode(this.f8166m.get(next).toString(), "utf-8") + ContainerUtils.FIELD_DELIMITER);
                }
            }
            stringBuffer.append("output=json");
            String i6 = x0.i(this.f8167n);
            stringBuffer.append("&key=".concat(String.valueOf(i6)));
            String a6 = a1.a();
            stringBuffer.append("&ts=".concat(String.valueOf(a6)));
            stringBuffer.append("&scode=" + a1.c(this.f8167n, a6, "key=".concat(String.valueOf(i6))));
            return stringBuffer.toString().getBytes("utf-8");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.col.s.dz
    public final String h() {
        if (e1.a().h()) {
            return "https://restsdk.amap.com/sdk/compliance/params";
        }
        return "http://restsdk.amap.com/sdk/compliance/params";
    }
}
