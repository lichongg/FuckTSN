package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class DistrictItem implements Parcelable {
    public static final Parcelable.Creator<DistrictItem> CREATOR = new Parcelable.Creator<DistrictItem>() { // from class: com.amap.api.services.district.DistrictItem.1
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
    private String f9250a;

    /* renamed from: b, reason: collision with root package name */
    private String f9251b;

    /* renamed from: c, reason: collision with root package name */
    private String f9252c;

    /* renamed from: d, reason: collision with root package name */
    private LatLonPoint f9253d;

    /* renamed from: e, reason: collision with root package name */
    private String f9254e;

    /* renamed from: f, reason: collision with root package name */
    private List<DistrictItem> f9255f;

    /* renamed from: g, reason: collision with root package name */
    private String[] f9256g;

    public DistrictItem() {
        this.f9255f = new ArrayList();
        this.f9256g = new String[0];
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DistrictItem.class != obj.getClass()) {
            return false;
        }
        DistrictItem districtItem = (DistrictItem) obj;
        String str = this.f9251b;
        if (str == null) {
            if (districtItem.f9251b != null) {
                return false;
            }
        } else if (!str.equals(districtItem.f9251b)) {
            return false;
        }
        LatLonPoint latLonPoint = this.f9253d;
        if (latLonPoint == null) {
            if (districtItem.f9253d != null) {
                return false;
            }
        } else if (!latLonPoint.equals(districtItem.f9253d)) {
            return false;
        }
        String str2 = this.f9250a;
        if (str2 == null) {
            if (districtItem.f9250a != null) {
                return false;
            }
        } else if (!str2.equals(districtItem.f9250a)) {
            return false;
        }
        if (!Arrays.equals(this.f9256g, districtItem.f9256g)) {
            return false;
        }
        List<DistrictItem> list = this.f9255f;
        if (list == null) {
            if (districtItem.f9255f != null) {
                return false;
            }
        } else if (!list.equals(districtItem.f9255f)) {
            return false;
        }
        String str3 = this.f9254e;
        if (str3 == null) {
            if (districtItem.f9254e != null) {
                return false;
            }
        } else if (!str3.equals(districtItem.f9254e)) {
            return false;
        }
        String str4 = this.f9252c;
        if (str4 == null) {
            if (districtItem.f9252c != null) {
                return false;
            }
        } else if (!str4.equals(districtItem.f9252c)) {
            return false;
        }
        return true;
    }

    public final String[] districtBoundary() {
        return this.f9256g;
    }

    public final String getAdcode() {
        return this.f9251b;
    }

    public final LatLonPoint getCenter() {
        return this.f9253d;
    }

    public final String getCitycode() {
        return this.f9250a;
    }

    public final String getLevel() {
        return this.f9254e;
    }

    public final String getName() {
        return this.f9252c;
    }

    public final List<DistrictItem> getSubDistrict() {
        return this.f9255f;
    }

    public final int hashCode() {
        String str = this.f9251b;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        LatLonPoint latLonPoint = this.f9253d;
        int hashCode2 = (hashCode + (latLonPoint == null ? 0 : latLonPoint.hashCode())) * 31;
        String str2 = this.f9250a;
        int hashCode3 = (((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + Arrays.hashCode(this.f9256g)) * 31;
        List<DistrictItem> list = this.f9255f;
        int hashCode4 = (hashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        String str3 = this.f9254e;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f9252c;
        return hashCode5 + (str4 != null ? str4.hashCode() : 0);
    }

    public final void setAdcode(String str) {
        this.f9251b = str;
    }

    public final void setCenter(LatLonPoint latLonPoint) {
        this.f9253d = latLonPoint;
    }

    public final void setCitycode(String str) {
        this.f9250a = str;
    }

    public final void setDistrictBoundary(String[] strArr) {
        this.f9256g = strArr;
    }

    public final void setLevel(String str) {
        this.f9254e = str;
    }

    public final void setName(String str) {
        this.f9252c = str;
    }

    public final void setSubDistrict(ArrayList<DistrictItem> arrayList) {
        this.f9255f = arrayList;
    }

    public final String toString() {
        return "DistrictItem [mCitycode=" + this.f9250a + ", mAdcode=" + this.f9251b + ", mName=" + this.f9252c + ", mCenter=" + this.f9253d + ", mLevel=" + this.f9254e + ", mDistricts=" + this.f9255f + "]";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f9250a);
        parcel.writeString(this.f9251b);
        parcel.writeString(this.f9252c);
        parcel.writeParcelable(this.f9253d, i6);
        parcel.writeString(this.f9254e);
        parcel.writeTypedList(this.f9255f);
        parcel.writeInt(this.f9256g.length);
        parcel.writeStringArray(this.f9256g);
    }

    public DistrictItem(String str, String str2, String str3, LatLonPoint latLonPoint, String str4) {
        this.f9255f = new ArrayList();
        this.f9256g = new String[0];
        this.f9252c = str;
        this.f9250a = str2;
        this.f9251b = str3;
        this.f9253d = latLonPoint;
        this.f9254e = str4;
    }

    public DistrictItem(Parcel parcel) {
        this.f9255f = new ArrayList();
        this.f9256g = new String[0];
        this.f9250a = parcel.readString();
        this.f9251b = parcel.readString();
        this.f9252c = parcel.readString();
        this.f9253d = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f9254e = parcel.readString();
        this.f9255f = parcel.createTypedArrayList(CREATOR);
        String[] strArr = new String[parcel.readInt()];
        this.f9256g = strArr;
        parcel.readStringArray(strArr);
    }
}
