package com.amap.api.col.s;

import com.amap.api.col.s.dz;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class t2 extends dz {

    /* renamed from: m, reason: collision with root package name */
    private byte[] f8480m;

    /* renamed from: n, reason: collision with root package name */
    private Map<String, String> f8481n;

    @Override // com.amap.api.col.s.dz
    public final Map<String, String> p() {
        return null;
    }

    @Override // com.amap.api.col.s.dz
    public final String h() {
        return "https://adiu.amap.com/ws/device/adius";
    }

    @Override // com.amap.api.col.s.dz
    public final Map<String, String> o() {
        return this.f8481n;
    }

    @Override // com.amap.api.col.s.dz
    public final byte[] q() {
        return this.f8480m;
    }

    public t2(byte[] bArr, Map<String, String> map) {
        this.f8480m = bArr;
        this.f8481n = map;
        e(dz.a.SINGLE);
        g(dz.c.HTTPS);
    }
}
