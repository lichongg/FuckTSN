package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class DistanceItem implements Parcelable {
    public static final Parcelable.Creator<DistanceItem> CREATOR = new Parcelable.Creator<DistanceItem>() { // from class: com.amap.api.services.route.DistanceItem.1
        private static DistanceItem a(Parcel parcel) {
            return new DistanceItem(parcel);
        }

        private static DistanceItem[] a(int i6) {
            return new DistanceItem[i6];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DistanceItem createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DistanceItem[] newArray(int i6) {
            return a(i6);
        }
    };
    public final int ERROR_CODE_NOT_IN_CHINA;
    public final int ERROR_CODE_NO_DRIVE;
    public final int ERROR_CODE_TOO_FAR;

    /* renamed from: a, reason: collision with root package name */
    private int f9517a;

    /* renamed from: b, reason: collision with root package name */
    private int f9518b;

    /* renamed from: c, reason: collision with root package name */
    private float f9519c;

    /* renamed from: d, reason: collision with root package name */
    private float f9520d;

    /* renamed from: e, reason: collision with root package name */
    private String f9521e;

    /* renamed from: f, reason: collision with root package name */
    private int f9522f;

    public DistanceItem() {
        this.ERROR_CODE_NO_DRIVE = 1;
        this.ERROR_CODE_TOO_FAR = 2;
        this.ERROR_CODE_NOT_IN_CHINA = 3;
        this.f9517a = 1;
        this.f9518b = 1;
        this.f9519c = 0.0f;
        this.f9520d = 0.0f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDestId() {
        return this.f9518b;
    }

    public float getDistance() {
        return this.f9519c;
    }

    public float getDuration() {
        return this.f9520d;
    }

    public int getErrorCode() {
        return this.f9522f;
    }

    public String getErrorInfo() {
        return this.f9521e;
    }

    public int getOriginId() {
        return this.f9517a;
    }

    public void setDestId(int i6) {
        this.f9518b = i6;
    }

    public void setDistance(float f6) {
        this.f9519c = f6;
    }

    public void setDuration(float f6) {
        this.f9520d = f6;
    }

    public void setErrorCode(int i6) {
        this.f9522f = i6;
    }

    public void setErrorInfo(String str) {
        this.f9521e = str;
    }

    public void setOriginId(int i6) {
        this.f9517a = i6;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeInt(this.f9517a);
        parcel.writeInt(this.f9518b);
        parcel.writeFloat(this.f9519c);
        parcel.writeFloat(this.f9520d);
        parcel.writeString(this.f9521e);
        parcel.writeInt(this.f9522f);
    }

    protected DistanceItem(Parcel parcel) {
        this.ERROR_CODE_NO_DRIVE = 1;
        this.ERROR_CODE_TOO_FAR = 2;
        this.ERROR_CODE_NOT_IN_CHINA = 3;
        this.f9517a = 1;
        this.f9518b = 1;
        this.f9519c = 0.0f;
        this.f9520d = 0.0f;
        this.f9517a = parcel.readInt();
        this.f9518b = parcel.readInt();
        this.f9519c = parcel.readFloat();
        this.f9520d = parcel.readFloat();
        this.f9521e = parcel.readString();
        this.f9522f = parcel.readInt();
    }
}
