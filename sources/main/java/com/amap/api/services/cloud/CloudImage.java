package com.amap.api.services.cloud;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class CloudImage implements Parcelable {
    public static final Parcelable.Creator<CloudImage> CREATOR = new Parcelable.Creator<CloudImage>() { // from class: com.amap.api.services.cloud.CloudImage.1
        private static CloudImage a(Parcel parcel) {
            return new CloudImage(parcel);
        }

        private static CloudImage[] a(int i6) {
            return new CloudImage[i6];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CloudImage createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CloudImage[] newArray(int i6) {
            return a(i6);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f9157a;

    /* renamed from: b, reason: collision with root package name */
    private String f9158b;

    /* renamed from: c, reason: collision with root package name */
    private String f9159c;

    public CloudImage(String str, String str2, String str3) {
        this.f9157a = str;
        this.f9158b = str2;
        this.f9159c = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.f9157a;
    }

    public String getPreurl() {
        return this.f9158b;
    }

    public String getUrl() {
        return this.f9159c;
    }

    public void setId(String str) {
        this.f9157a = str;
    }

    public void setPreurl(String str) {
        this.f9158b = str;
    }

    public void setUrl(String str) {
        this.f9159c = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f9157a);
        parcel.writeString(this.f9158b);
        parcel.writeString(this.f9159c);
    }

    public CloudImage(Parcel parcel) {
        this.f9157a = parcel.readString();
        this.f9158b = parcel.readString();
        this.f9159c = parcel.readString();
    }
}
