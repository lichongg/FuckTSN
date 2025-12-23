package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class SubPoiItemV2 implements Parcelable {
    public static final Parcelable.Creator<SubPoiItemV2> CREATOR = new Parcelable.Creator<SubPoiItemV2>() { // from class: com.amap.api.services.poisearch.SubPoiItemV2.1
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SubPoiItemV2[] newArray(int i6) {
            return null;
        }

        private static SubPoiItemV2 a(Parcel parcel) {
            return new SubPoiItemV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SubPoiItemV2 createFromParcel(Parcel parcel) {
            return a(parcel);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f9453a;

    /* renamed from: b, reason: collision with root package name */
    private String f9454b;

    /* renamed from: c, reason: collision with root package name */
    private LatLonPoint f9455c;

    /* renamed from: d, reason: collision with root package name */
    private String f9456d;

    /* renamed from: e, reason: collision with root package name */
    private String f9457e;

    /* renamed from: f, reason: collision with root package name */
    private String f9458f;

    public SubPoiItemV2(String str, LatLonPoint latLonPoint, String str2, String str3) {
        this.f9453a = str;
        this.f9455c = latLonPoint;
        this.f9454b = str2;
        this.f9456d = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getLatLonPoint() {
        return this.f9455c;
    }

    public String getPoiId() {
        return this.f9453a;
    }

    public String getSnippet() {
        return this.f9456d;
    }

    public String getSubTypeDes() {
        return this.f9457e;
    }

    public String getTitle() {
        return this.f9454b;
    }

    public String getTypeCode() {
        return this.f9458f;
    }

    public void setLatLonPoint(LatLonPoint latLonPoint) {
        this.f9455c = latLonPoint;
    }

    public void setPoiId(String str) {
        this.f9453a = str;
    }

    public void setSnippet(String str) {
        this.f9456d = str;
    }

    public void setSubTypeDes(String str) {
        this.f9457e = str;
    }

    public void setTitle(String str) {
        this.f9454b = str;
    }

    public void setTypeCode(String str) {
        this.f9458f = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f9453a);
        parcel.writeString(this.f9454b);
        parcel.writeValue(this.f9455c);
        parcel.writeString(this.f9456d);
        parcel.writeString(this.f9457e);
        parcel.writeString(this.f9458f);
    }

    public SubPoiItemV2(Parcel parcel) {
        this.f9453a = parcel.readString();
        this.f9454b = parcel.readString();
        this.f9455c = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f9456d = parcel.readString();
        this.f9457e = parcel.readString();
        this.f9458f = parcel.readString();
    }
}
