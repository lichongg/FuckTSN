package com.amap.api.col.p0003l;

import com.amap.api.col.p0003l.Cif;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class q6 extends Cif {

    /* renamed from: r, reason: collision with root package name */
    private byte[] f6984r;

    /* renamed from: s, reason: collision with root package name */
    private Map<String, String> f6985s;

    @Override // com.amap.api.col.p0003l.Cif
    public final Map<String, String> getRequestHead() {
        return null;
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final byte[] getEntityBytes() {
        return this.f6984r;
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final Map<String, String> getParams() {
        return this.f6985s;
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final String getURL() {
        return "https://adiu.amap.com/ws/device/adius";
    }

    public q6(byte[] bArr, Map<String, String> map) {
        this.f6984r = bArr;
        this.f6985s = map;
        setDegradeAbility(Cif.a.SINGLE);
        setHttpProtocol(Cif.c.HTTPS);
    }
}
