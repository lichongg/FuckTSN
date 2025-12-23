package com.amap.api.fence;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.location.DPoint;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class DistrictItem implements Parcelable {
    public static final Parcelable.Creator<DistrictItem> CREATOR = new Parcelable.Creator<DistrictItem>() { // from class: com.amap.api.fence.DistrictItem.1
        private static DistrictItem a(Parcel parcel) {
            return new DistrictItem(parcel);
        }

        private static DistrictItem[] a(int i6) {
            return new DistrictItem[i6];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DistrictItem createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DistrictItem[] newArray(int i6) {
            return a(i6);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f8785a;

    /* renamed from: b, reason: collision with root package name */
    private String f8786b;

    /* renamed from: c, reason: collision with root package name */
    private String f8787c;

    /* renamed from: d, reason: collision with root package name */
    private List<DPoint> f8788d;

    public DistrictItem() {
        this.f8785a = "";
        this.f8786b = null;
        this.f8787c = null;
        this.f8788d = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public static Parcelable.Creator<DistrictItem> getCreator() {
        return CREATOR;
    }

    public String getAdcode() {
        return this.f8787c;
    }

    public String getCitycode() {
        return this.f8786b;
    }

    public String getDistrictName() {
        return this.f8785a;
    }

    public List<DPoint> getPolyline() {
        return this.f8788d;
    }

    public void setAdcode(String str) {
        this.f8787c = str;
    }

    public void setCitycode(String str) {
        this.f8786b = str;
    }

    public void setDistrictName(String str) {
        this.f8785a = str;
    }

    public void setPolyline(List<DPoint> list) {
        this.f8788d = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f8785a);
        parcel.writeString(this.f8786b);
        parcel.writeString(this.f8787c);
        parcel.writeTypedList(this.f8788d);
    }

    protected DistrictItem(Parcel parcel) {
        this.f8785a = "";
        this.f8786b = null;
        this.f8787c = null;
        this.f8788d = null;
        this.f8785a = parcel.readString();
        this.f8786b = parcel.readString();
        this.f8787c = parcel.readString();
        this.f8788d = parcel.createTypedArrayList(DPoint.CREATOR);
    }
}
