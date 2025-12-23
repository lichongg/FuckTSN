package com.autonavi.aps.amapapi.storage;

import com.amap.api.col.p0003l.hk;
import com.amap.api.col.p0003l.hl;
import com.amap.api.location.AMapLocation;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@hk(a = "c")
/* loaded from: D:\Downloads\app\classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    @hl(a = "a2", b = 6)
    private String f10140a;

    /* renamed from: b, reason: collision with root package name */
    @hl(a = "a3", b = 5)
    private long f10141b;

    /* renamed from: c, reason: collision with root package name */
    @hl(a = "a4", b = 6)
    private String f10142c;

    /* renamed from: d, reason: collision with root package name */
    private AMapLocation f10143d;

    public final AMapLocation a() {
        return this.f10143d;
    }

    public final String b() {
        return this.f10142c;
    }

    public final void a(AMapLocation aMapLocation) {
        this.f10143d = aMapLocation;
    }

    public final void b(String str) {
        this.f10140a = str;
    }

    public final String c() {
        return this.f10140a;
    }

    public final long d() {
        return this.f10141b;
    }

    public final void a(String str) {
        this.f10142c = str;
    }

    public final void a(long j6) {
        this.f10141b = j6;
    }
}
