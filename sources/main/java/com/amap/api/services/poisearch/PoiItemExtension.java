package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class PoiItemExtension implements Parcelable {
    public static final Parcelable.Creator<PoiItemExtension> CREATOR = new Parcelable.Creator<PoiItemExtension>() { // from class: com.amap.api.services.poisearch.PoiItemExtension.1
        private static PoiItemExtension a(Parcel parcel) {
            return new PoiItemExtension(parcel);
        }

        private static PoiItemExtension[] a(int i6) {
            return new PoiItemExtension[i6];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PoiItemExtension createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PoiItemExtension[] newArray(int i6) {
            return a(i6);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f9384a;

    /* renamed from: b, reason: collision with root package name */
    private String f9385b;

    public PoiItemExtension(String str, String str2) {
        this.f9384a = str;
        this.f9385b = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getOpentime() {
        return this.f9384a;
    }

    public String getmRating() {
        return this.f9385b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f9384a);
        parcel.writeString(this.f9385b);
    }

    protected PoiItemExtension(Parcel parcel) {
        this.f9384a = parcel.readString();
        this.f9385b = parcel.readString();
    }
}
