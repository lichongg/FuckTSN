package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class Railway implements Parcelable {
    public static final Parcelable.Creator<Railway> CREATOR = new Parcelable.Creator<Railway>() { // from class: com.amap.api.services.route.Railway.1
        private static Railway a(Parcel parcel) {
            return new Railway(parcel);
        }

        private static Railway[] a(int i6) {
            return new Railway[i6];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Railway createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Railway[] newArray(int i6) {
            return a(i6);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f9596a;

    /* renamed from: b, reason: collision with root package name */
    private String f9597b;

    public Railway() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected Railway(Parcel parcel) {
        this.f9596a = parcel.readString();
        this.f9597b = parcel.readString();
    }

    public String getID() {
        return this.f9596a;
    }

    public String getName() {
        return this.f9597b;
    }

    public void setID(String str) {
        this.f9596a = str;
    }

    public void setName(String str) {
        this.f9597b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f9596a);
        parcel.writeString(this.f9597b);
    }
}
