package com.amap.api.services.geocoder;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class RegeocodeResult {

    /* renamed from: a, reason: collision with root package name */
    private RegeocodeQuery f9320a;

    /* renamed from: b, reason: collision with root package name */
    private RegeocodeAddress f9321b;

    public RegeocodeAddress getRegeocodeAddress() {
        return this.f9321b;
    }

    public RegeocodeQuery getRegeocodeQuery() {
        return this.f9320a;
    }

    public void setRegeocodeAddress(RegeocodeAddress regeocodeAddress) {
        this.f9321b = regeocodeAddress;
    }

    public void setRegeocodeQuery(RegeocodeQuery regeocodeQuery) {
        this.f9320a = regeocodeQuery;
    }

    public RegeocodeResult(RegeocodeQuery regeocodeQuery, RegeocodeAddress regeocodeAddress) {
        this.f9320a = regeocodeQuery;
        this.f9321b = regeocodeAddress;
    }
}
