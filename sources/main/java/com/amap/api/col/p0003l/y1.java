package com.amap.api.col.p0003l;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class y1 extends y3<String, a> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public byte[] f7739a;

        /* renamed from: b, reason: collision with root package name */
        public int f7740b = -1;
    }

    @Override // com.amap.api.col.p0003l.y3
    protected final /* bridge */ /* synthetic */ a g(String str) throws fc {
        return null;
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final boolean isSupportIPV6() {
        return true;
    }

    @Override // com.amap.api.col.p0003l.y3
    protected final String l() {
        return null;
    }

    private static a o(byte[] bArr) throws fc {
        a aVar = new a();
        aVar.f7739a = bArr;
        return aVar;
    }

    public final void b(String str) {
        this.f7757u = str;
    }

    @Override // com.amap.api.col.p0003l.g2, com.amap.api.col.p0003l.Cif
    public final Map<String, String> getParams() {
        HashMap hashMap = new HashMap(16);
        hashMap.put("key", f4.j(this.f7756t));
        hashMap.put("output", "bin");
        String a6 = h4.a();
        String c6 = h4.c(this.f7756t, a6, q4.r(hashMap));
        hashMap.put("ts", a6);
        hashMap.put("scode", c6);
        return hashMap;
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final String getURL() {
        return this.f7757u;
    }

    public y1(Context context, String str) {
        super(context, str);
        this.f7757u = "/map/styles";
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final String getIPV6URL() {
        return b3.y(getURL());
    }

    @Override // com.amap.api.col.p0003l.y3
    protected final /* synthetic */ a h(byte[] bArr) throws fc {
        return o(bArr);
    }
}
