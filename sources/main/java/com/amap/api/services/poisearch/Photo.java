package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class Photo implements Parcelable {
    public static final Parcelable.Creator<Photo> CREATOR = new Parcelable.Creator<Photo>() { // from class: com.amap.api.services.poisearch.Photo.1
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Photo[] newArray(int i6) {
            return null;
        }

        private static Photo a(Parcel parcel) {
            return new Photo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Photo createFromParcel(Parcel parcel) {
            return a(parcel);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f9382a;

    /* renamed from: b, reason: collision with root package name */
    private String f9383b;

    public Photo() {
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public Photo(String str, String str2) {
        this.f9382a = str;
        this.f9383b = str2;
    }

    public final String getTitle() {
        return this.f9382a;
    }

    public final String getUrl() {
        return this.f9383b;
    }

    public final void setTitle(String str) {
        this.f9382a = str;
    }

    public final void setUrl(String str) {
        this.f9383b = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f9382a);
        parcel.writeString(this.f9383b);
    }

    public Photo(Parcel parcel) {
        this.f9382a = parcel.readString();
        this.f9383b = parcel.readString();
    }
}
