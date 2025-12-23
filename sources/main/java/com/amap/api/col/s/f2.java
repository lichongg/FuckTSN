package com.amap.api.col.s;

import com.amap.api.col.s.dz;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class f2 extends f1 {

    /* renamed from: m, reason: collision with root package name */
    private byte[] f8071m;

    /* renamed from: n, reason: collision with root package name */
    private String f8072n;

    @Override // com.amap.api.col.s.dz
    public final boolean k() {
        return false;
    }

    @Override // com.amap.api.col.s.dz
    public final Map<String, String> o() {
        return null;
    }

    @Override // com.amap.api.col.s.dz
    public final String h() {
        String t5 = j1.t(s1.f8427b);
        String str = this.f8072n;
        byte[] o5 = j1.o(s1.f8426a);
        byte[] bArr = new byte[o5.length + 50];
        System.arraycopy(this.f8071m, 0, bArr, 0, 50);
        System.arraycopy(o5, 0, bArr, 50, o5.length);
        return String.format(t5, "1", str, "1", "open", g1.b(bArr));
    }

    @Override // com.amap.api.col.s.dz
    public final Map<String, String> p() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/zip");
        hashMap.put("Content-Length", String.valueOf(this.f8071m.length));
        return hashMap;
    }

    @Override // com.amap.api.col.s.dz
    public final byte[] q() {
        return this.f8071m;
    }

    public f2(byte[] bArr, String str) {
        this.f8072n = "1";
        this.f8071m = (byte[]) bArr.clone();
        this.f8072n = str;
        e(dz.a.SINGLE);
        g(dz.c.HTTP);
    }
}
