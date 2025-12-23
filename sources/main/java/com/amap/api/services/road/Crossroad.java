package com.amap.api.services.road;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class Crossroad extends Road implements Parcelable {
    public static final Parcelable.Creator<Crossroad> CREATOR = new Parcelable.Creator<Crossroad>() { // from class: com.amap.api.services.road.Crossroad.1
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Crossroad[] newArray(int i6) {
            return null;
        }

        private static Crossroad a(Parcel parcel) {
            return new Crossroad(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Crossroad createFromParcel(Parcel parcel) {
            return a(parcel);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private float f9459a;

    /* renamed from: b, reason: collision with root package name */
    private String f9460b;

    /* renamed from: c, reason: collision with root package name */
    private String f9461c;

    /* renamed from: d, reason: collision with root package name */
    private String f9462d;

    /* renamed from: e, reason: collision with root package name */
    private String f9463e;

    /* renamed from: f, reason: collision with root package name */
    private String f9464f;

    /* synthetic */ Crossroad(Parcel parcel, byte b6) {
        this(parcel);
    }

    @Override // com.amap.api.services.road.Road, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public Crossroad() {
    }

    public final String getDirection() {
        return this.f9460b;
    }

    public final float getDistance() {
        return this.f9459a;
    }

    public final String getFirstRoadId() {
        return this.f9461c;
    }

    public final String getFirstRoadName() {
        return this.f9462d;
    }

    public final String getSecondRoadId() {
        return this.f9463e;
    }

    public final String getSecondRoadName() {
        return this.f9464f;
    }

    public final void setDirection(String str) {
        this.f9460b = str;
    }

    public final void setDistance(float f6) {
        this.f9459a = f6;
    }

    public final void setFirstRoadId(String str) {
        this.f9461c = str;
    }

    public final void setFirstRoadName(String str) {
        this.f9462d = str;
    }

    public final void setSecondRoadId(String str) {
        this.f9463e = str;
    }

    public final void setSecondRoadName(String str) {
        this.f9464f = str;
    }

    private Crossroad(Parcel parcel) {
        super(parcel);
        this.f9459a = parcel.readFloat();
        this.f9460b = parcel.readString();
        this.f9461c = parcel.readString();
        this.f9462d = parcel.readString();
        this.f9463e = parcel.readString();
        this.f9464f = parcel.readString();
    }

    @Override // com.amap.api.services.road.Road, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i6) {
        super.writeToParcel(parcel, i6);
        parcel.writeFloat(this.f9459a);
        parcel.writeString(this.f9460b);
        parcel.writeString(this.f9461c);
        parcel.writeString(this.f9462d);
        parcel.writeString(this.f9463e);
        parcel.writeString(this.f9464f);
    }
}
