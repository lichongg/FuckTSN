package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.AMapException;
import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class DistrictResult implements Parcelable {
    public Parcelable.Creator<DistrictResult> CREATOR;

    /* renamed from: a, reason: collision with root package name */
    private DistrictSearchQuery f9257a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<DistrictItem> f9258b;

    /* renamed from: c, reason: collision with root package name */
    private int f9259c;

    /* renamed from: d, reason: collision with root package name */
    private AMapException f9260d;

    public DistrictResult(DistrictSearchQuery districtSearchQuery, ArrayList<DistrictItem> arrayList) {
        this.f9258b = new ArrayList<>();
        this.CREATOR = new Parcelable.Creator<DistrictResult>() { // from class: com.amap.api.services.district.DistrictResult.1
            private static DistrictResult a(Parcel parcel) {
                return new DistrictResult(parcel);
            }

            private static DistrictResult[] a(int i6) {
                return new DistrictResult[i6];
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DistrictResult createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DistrictResult[] newArray(int i6) {
                return a(i6);
            }
        };
        this.f9257a = districtSearchQuery;
        this.f9258b = arrayList;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DistrictResult.class != obj.getClass()) {
            return false;
        }
        DistrictResult districtResult = (DistrictResult) obj;
        DistrictSearchQuery districtSearchQuery = this.f9257a;
        if (districtSearchQuery == null) {
            if (districtResult.f9257a != null) {
                return false;
            }
        } else if (!districtSearchQuery.equals(districtResult.f9257a)) {
            return false;
        }
        ArrayList<DistrictItem> arrayList = this.f9258b;
        if (arrayList == null) {
            if (districtResult.f9258b != null) {
                return false;
            }
        } else if (!arrayList.equals(districtResult.f9258b)) {
            return false;
        }
        return true;
    }

    public final AMapException getAMapException() {
        return this.f9260d;
    }

    public final ArrayList<DistrictItem> getDistrict() {
        return this.f9258b;
    }

    public final int getPageCount() {
        return this.f9259c;
    }

    public final DistrictSearchQuery getQuery() {
        return this.f9257a;
    }

    public final int hashCode() {
        DistrictSearchQuery districtSearchQuery = this.f9257a;
        int hashCode = ((districtSearchQuery == null ? 0 : districtSearchQuery.hashCode()) + 31) * 31;
        ArrayList<DistrictItem> arrayList = this.f9258b;
        return hashCode + (arrayList != null ? arrayList.hashCode() : 0);
    }

    public final void setAMapException(AMapException aMapException) {
        this.f9260d = aMapException;
    }

    public final void setDistrict(ArrayList<DistrictItem> arrayList) {
        this.f9258b = arrayList;
    }

    public final void setPageCount(int i6) {
        this.f9259c = i6;
    }

    public final void setQuery(DistrictSearchQuery districtSearchQuery) {
        this.f9257a = districtSearchQuery;
    }

    public final String toString() {
        return "DistrictResult [mDisQuery=" + this.f9257a + ", mDistricts=" + this.f9258b + "]";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i6) {
        parcel.writeParcelable(this.f9257a, i6);
        parcel.writeTypedList(this.f9258b);
    }

    public DistrictResult() {
        this.f9258b = new ArrayList<>();
        this.CREATOR = new Parcelable.Creator<DistrictResult>() { // from class: com.amap.api.services.district.DistrictResult.1
            private static DistrictResult a(Parcel parcel) {
                return new DistrictResult(parcel);
            }

            private static DistrictResult[] a(int i6) {
                return new DistrictResult[i6];
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DistrictResult createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DistrictResult[] newArray(int i6) {
                return a(i6);
            }
        };
    }

    protected DistrictResult(Parcel parcel) {
        this.f9258b = new ArrayList<>();
        this.CREATOR = new Parcelable.Creator<DistrictResult>() { // from class: com.amap.api.services.district.DistrictResult.1
            private static DistrictResult a(Parcel parcel2) {
                return new DistrictResult(parcel2);
            }

            private static DistrictResult[] a(int i6) {
                return new DistrictResult[i6];
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DistrictResult createFromParcel(Parcel parcel2) {
                return a(parcel2);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DistrictResult[] newArray(int i6) {
                return a(i6);
            }
        };
        this.f9257a = (DistrictSearchQuery) parcel.readParcelable(DistrictSearchQuery.class.getClassLoader());
        this.f9258b = parcel.createTypedArrayList(DistrictItem.CREATOR);
    }
}
