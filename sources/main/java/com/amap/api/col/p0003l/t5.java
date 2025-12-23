package com.amap.api.col.p0003l;

import com.amap.api.col.p0003l.Cif;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class t5 extends l4 {

    /* renamed from: r, reason: collision with root package name */
    private byte[] f7288r;

    /* renamed from: s, reason: collision with root package name */
    private String f7289s;

    @Override // com.amap.api.col.p0003l.Cif
    public final Map<String, String> getParams() {
        return null;
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final boolean isHostToIP() {
        return false;
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final byte[] getEntityBytes() {
        return this.f7288r;
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final Map<String, String> getRequestHead() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/zip");
        hashMap.put("Content-Length", String.valueOf(this.f7288r.length));
        return hashMap;
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final String getURL() {
        String u5 = q4.u(f5.f6175b);
        String str = this.f7289s;
        byte[] o5 = q4.o(f5.f6174a);
        byte[] bArr = new byte[o5.length + 50];
        System.arraycopy(this.f7288r, 0, bArr, 0, 50);
        System.arraycopy(o5, 0, bArr, 50, o5.length);
        return String.format(u5, "1", str, "1", "open", m4.b(bArr));
    }

    public t5(byte[] bArr, String str) {
        this.f7289s = "1";
        this.f7288r = (byte[]) bArr.clone();
        this.f7289s = str;
        setDegradeAbility(Cif.a.SINGLE);
        setHttpProtocol(Cif.c.HTTP);
    }
}
