package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class RailwaySpace implements Parcelable {
    public static final Parcelable.Creator<RailwaySpace> CREATOR = new Parcelable.Creator<RailwaySpace>() { // from class: com.amap.api.services.route.RailwaySpace.1
        private static RailwaySpace a(Parcel parcel) {
            return new RailwaySpace(parcel);
        }

        private static RailwaySpace[] a(int i6) {
            return new RailwaySpace[i6];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RailwaySpace createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RailwaySpace[] newArray(int i6) {
            return a(i6);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f9598a;

    /* renamed from: b, reason: collision with root package name */
    private float f9599b;

    public RailwaySpace(String str, float f6) {
        this.f9598a = str;
        this.f9599b = f6;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCode() {
        return this.f9598a;
    }

    public float getCost() {
        return this.f9599b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f9598a);
        parcel.writeFloat(this.f9599b);
    }

    protected RailwaySpace(Parcel parcel) {
        this.f9598a = parcel.readString();
        this.f9599b = parcel.readFloat();
    }
}
