package com.amap.api.services.help;

import com.amap.api.services.core.LatLonPoint;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class InputtipsQuery implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private String f9333a;

    /* renamed from: b, reason: collision with root package name */
    private String f9334b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f9335c = false;

    /* renamed from: d, reason: collision with root package name */
    private String f9336d = null;

    /* renamed from: e, reason: collision with root package name */
    private LatLonPoint f9337e;

    public String getCity() {
        return this.f9334b;
    }

    public boolean getCityLimit() {
        return this.f9335c;
    }

    public String getKeyword() {
        return this.f9333a;
    }

    public LatLonPoint getLocation() {
        return this.f9337e;
    }

    public String getType() {
        return this.f9336d;
    }

    public void setCityLimit(boolean z5) {
        this.f9335c = z5;
    }

    public void setLocation(LatLonPoint latLonPoint) {
        this.f9337e = latLonPoint;
    }

    public void setType(String str) {
        this.f9336d = str;
    }

    public InputtipsQuery(String str, String str2) {
        this.f9333a = str;
        this.f9334b = str2;
    }
}
