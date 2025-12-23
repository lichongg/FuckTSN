package com.amap.api.services.nearby;

import com.amap.api.services.core.LatLonPoint;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class UploadInfo {

    /* renamed from: a, reason: collision with root package name */
    private int f9362a = 1;

    /* renamed from: b, reason: collision with root package name */
    private String f9363b;

    /* renamed from: c, reason: collision with root package name */
    private LatLonPoint f9364c;

    public int getCoordType() {
        return this.f9362a;
    }

    public LatLonPoint getPoint() {
        return this.f9364c;
    }

    public String getUserID() {
        return this.f9363b;
    }

    public void setCoordType(int i6) {
        if (i6 == 0 || i6 == 1) {
            this.f9362a = i6;
        } else {
            this.f9362a = 1;
        }
    }

    public void setPoint(LatLonPoint latLonPoint) {
        this.f9364c = latLonPoint;
    }

    public void setUserID(String str) {
        this.f9363b = str;
    }
}
