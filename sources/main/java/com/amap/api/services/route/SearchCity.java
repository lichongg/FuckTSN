package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class SearchCity implements Parcelable {
    public static final Parcelable.Creator<SearchCity> CREATOR = new Parcelable.Creator<SearchCity>() { // from class: com.amap.api.services.route.SearchCity.1
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SearchCity[] newArray(int i6) {
            return null;
        }

        private static SearchCity a(Parcel parcel) {
            return new SearchCity(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SearchCity createFromParcel(Parcel parcel) {
            return a(parcel);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f9762a;

    /* renamed from: b, reason: collision with root package name */
    private String f9763b;

    /* renamed from: c, reason: collision with root package name */
    private String f9764c;

    public SearchCity(Parcel parcel) {
        this.f9762a = parcel.readString();
        this.f9763b = parcel.readString();
        this.f9764c = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getSearchCityAdCode() {
        return this.f9764c;
    }

    public String getSearchCityName() {
        return this.f9762a;
    }

    public String getSearchCitycode() {
        return this.f9763b;
    }

    public void setSearchCityName(String str) {
        this.f9762a = str;
    }

    public void setSearchCitycode(String str) {
        this.f9763b = str;
    }

    public void setSearchCityhAdCode(String str) {
        this.f9764c = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f9762a);
        parcel.writeString(this.f9763b);
        parcel.writeString(this.f9764c);
    }

    public SearchCity() {
    }
}
