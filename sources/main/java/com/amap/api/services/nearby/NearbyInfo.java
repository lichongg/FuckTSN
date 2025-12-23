package com.amap.api.services.nearby;

import com.amap.api.services.core.LatLonPoint;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class NearbyInfo {

    /* renamed from: a, reason: collision with root package name */
    private String f9346a;

    /* renamed from: b, reason: collision with root package name */
    private LatLonPoint f9347b;

    /* renamed from: c, reason: collision with root package name */
    private long f9348c;

    /* renamed from: d, reason: collision with root package name */
    private int f9349d;

    /* renamed from: e, reason: collision with root package name */
    private int f9350e;

    public int getDistance() {
        return this.f9349d;
    }

    public int getDrivingDistance() {
        return this.f9350e;
    }

    public LatLonPoint getPoint() {
        return this.f9347b;
    }

    public long getTimeStamp() {
        return this.f9348c;
    }

    public String getUserID() {
        return this.f9346a;
    }

    public void setDistance(int i6) {
        this.f9349d = i6;
    }

    public void setDrivingDistance(int i6) {
        this.f9350e = i6;
    }

    public void setPoint(LatLonPoint latLonPoint) {
        this.f9347b = latLonPoint;
    }

    public void setTimeStamp(long j6) {
        this.f9348c = j6;
    }

    public void setUserID(String str) {
        this.f9346a = str;
    }
}
