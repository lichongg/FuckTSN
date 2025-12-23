package com.amap.api.col.p0003l;

import android.content.Context;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class z3<T, V> extends y3<T, V> {
    @Override // com.amap.api.col.p0003l.y3
    protected abstract V g(String str) throws fc;

    @Override // com.amap.api.col.p0003l.g2, com.amap.api.col.p0003l.Cif
    public Map<String, String> getParams() {
        return null;
    }

    @Override // com.amap.api.col.p0003l.y3
    protected abstract String l();

    @Override // com.amap.api.col.p0003l.y3, com.amap.api.col.p0003l.Cif
    public Map<String, String> getRequestHead() {
        HashMap hashMap = new HashMap(16);
        hashMap.put("Content-Type", " application/json");
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("User-Agent", "AMAP SDK Android Trace 10.0.600");
        hashMap.put("x-INFO", h4.i(this.f7756t));
        hashMap.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", "10.0.600", "trace"));
        hashMap.put("logversion", "2.1");
        return hashMap;
    }

    public z3(Context context, T t5) {
        super(context, t5);
    }

    @Override // com.amap.api.col.p0003l.Cif
    public byte[] getEntityBytes() {
        try {
            return l().getBytes("utf-8");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
