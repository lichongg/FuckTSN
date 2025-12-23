package com.autonavi.aps.amapapi.trans;

import android.text.TextUtils;
import com.amap.api.col.p0003l.l4;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class b extends l4 {

    /* renamed from: a, reason: collision with root package name */
    Map<String, String> f10158a = null;

    /* renamed from: b, reason: collision with root package name */
    Map<String, String> f10159b = null;

    /* renamed from: c, reason: collision with root package name */
    String f10160c = "";

    /* renamed from: d, reason: collision with root package name */
    byte[] f10161d = null;

    /* renamed from: e, reason: collision with root package name */
    private String f10162e = null;

    public final void a(Map<String, String> map) {
        this.f10158a = map;
    }

    public final void b(Map<String, String> map) {
        this.f10159b = map;
    }

    public final void a(String str) {
        this.f10160c = str;
    }

    public final void b(String str) {
        this.f10162e = str;
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final byte[] getEntityBytes() {
        return this.f10161d;
    }

    @Override // com.amap.api.col.p0003l.l4, com.amap.api.col.p0003l.Cif
    public final String getIPV6URL() {
        return !TextUtils.isEmpty(this.f10162e) ? this.f10162e : super.getIPV6URL();
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final Map<String, String> getParams() {
        return this.f10159b;
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final Map<String, String> getRequestHead() {
        return this.f10158a;
    }

    @Override // com.amap.api.col.p0003l.Cif
    public final String getURL() {
        return this.f10160c;
    }

    public final void a(byte[] bArr) {
        this.f10161d = bArr;
    }
}
