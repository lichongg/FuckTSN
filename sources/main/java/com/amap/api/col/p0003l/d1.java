package com.amap.api.col.p0003l;

import java.util.Hashtable;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class d1 extends g2 {

    /* renamed from: r, reason: collision with root package name */
    private String f5892r;

    @Override // com.amap.api.col.p0003l.g2, com.amap.api.col.p0003l.Cif
    public final Map<String, String> getParams() {
        return null;
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final boolean isSupportIPV6() {
        return false;
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final Map<String, String> getRequestHead() {
        Hashtable hashtable = new Hashtable(32);
        hashtable.put("User-Agent", "MAC=channel:amapapi");
        return hashtable;
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final String getURL() {
        return this.f5892r;
    }

    public d1(String str) {
        this.f5892r = str;
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final String getIPV6URL() {
        return getURL();
    }
}
