package com.beizi.ad.model;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class BeiZiLocation {

    /* renamed from: a, reason: collision with root package name */
    private String f12764a;

    /* renamed from: b, reason: collision with root package name */
    private String f12765b;

    /* renamed from: c, reason: collision with root package name */
    private String f12766c;

    /* renamed from: d, reason: collision with root package name */
    private long f12767d;

    public BeiZiLocation() {
    }

    public BeiZiLocation(String str, String str2, String str3, long j6) {
        this.f12764a = str;
        this.f12765b = str2;
        this.f12766c = str3;
        this.f12767d = j6;
    }

    public String getLatitude() {
        return this.f12765b;
    }

    public String getLongitude() {
        return this.f12764a;
    }

    public long getTime() {
        return this.f12767d;
    }

    public String getType() {
        return this.f12766c;
    }

    public void setLatitude(String str) {
        this.f12765b = str;
    }

    public void setLongitude(String str) {
        this.f12764a = str;
    }

    public void setTime(long j6) {
        this.f12767d = j6;
    }

    public void setType(String str) {
        this.f12766c = str;
    }
}
