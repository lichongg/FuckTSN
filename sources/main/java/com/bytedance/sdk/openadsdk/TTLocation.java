package com.bytedance.sdk.openadsdk;

/* loaded from: D:\Downloads\app\classes4.dex */
public class TTLocation implements LocationProvider {

    /* renamed from: j, reason: collision with root package name */
    private double f27516j;
    private double xt;

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLatitude() {
        return this.f27516j;
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLongitude() {
        return this.xt;
    }

    public void setLatitude(double d6) {
        this.f27516j = d6;
    }

    public void setLongitude(double d6) {
        this.xt = d6;
    }

    public TTLocation(double d6, double d7) {
        this.f27516j = d6;
        this.xt = d7;
    }
}
