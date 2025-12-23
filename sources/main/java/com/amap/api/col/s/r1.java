package com.amap.api.col.s;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class r1 extends f1 {

    /* renamed from: m, reason: collision with root package name */
    public Context f8378m;

    @Override // com.amap.api.col.s.dz
    public final String m() {
        return "core";
    }

    @Override // com.amap.api.col.s.dz
    public final Map<String, String> o() {
        HashMap hashMap = new HashMap();
        hashMap.put("key", x0.i(this.f8378m));
        String a6 = a1.a();
        String c6 = a1.c(this.f8378m, a6, j1.r(hashMap));
        hashMap.put("ts", a6);
        hashMap.put("scode", c6);
        return hashMap;
    }

    @Override // com.amap.api.col.s.dz
    public final Map<String, String> p() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("User-Agent", "AMAP SDK Android core 4.3.5");
        hashMap.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", "4.3.5", "core"));
        hashMap.put("logversion", "2.1");
        return hashMap;
    }

    public r1(Context context) {
        this.f8378m = context;
        d(5000);
        j(5000);
    }

    @Override // com.amap.api.col.s.dz
    public final String h() {
        if (e1.a().h()) {
            return "https://restapi.amap.com/rest/aaid/get";
        }
        return "http://restapi.amap.com/rest/aaid/get";
    }
}
