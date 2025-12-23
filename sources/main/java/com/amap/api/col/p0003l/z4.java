package com.amap.api.col.p0003l;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class z4 extends l4 {

    /* renamed from: r, reason: collision with root package name */
    public Context f7798r;

    @Override // com.amap.api.col.p0003l.Cif
    public Map<String, String> getParams() {
        HashMap hashMap = new HashMap();
        hashMap.put("key", f4.j(this.f7798r));
        String a6 = h4.a();
        String c6 = h4.c(this.f7798r, a6, q4.r(hashMap));
        hashMap.put("ts", a6);
        hashMap.put("scode", c6);
        return hashMap;
    }

    @Override // com.amap.api.col.p0003l.Cif
    public Map<String, String> getRequestHead() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("User-Agent", "AMAP SDK Android core 4.3.11");
        hashMap.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", "4.3.11", "core"));
        hashMap.put("logversion", "2.1");
        return hashMap;
    }

    @Override // com.amap.api.col.p0003l.Cif
    public String getSDKName() {
        return "core";
    }

    public z4(Context context) {
        this.f7798r = context;
        setConnectionTimeout(5000);
        setSoTimeout(5000);
    }

    @Override // com.amap.api.col.p0003l.Cif
    public String getURL() {
        if (k4.a().h()) {
            return "https://restapi.amap.com/rest/aaid/get";
        }
        return "http://restapi.amap.com/rest/aaid/get";
    }
}
