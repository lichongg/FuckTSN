package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.DistanceSearch;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class DistanceResult implements Parcelable {
    public static final Parcelable.Creator<DistanceResult> CREATOR = new Parcelable.Creator<DistanceResult>() { // from class: com.amap.api.services.route.DistanceResult.1
        private static DistanceResult a(Parcel parcel) {
            return new DistanceResult(parcel);
        }

        private static DistanceResult[] a(int i6) {
            return new DistanceResult[i6];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DistanceResult createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DistanceResult[] newArray(int i6) {
            return a(i6);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private DistanceSearch.DistanceQuery f9523a;

    /* renamed from: b, reason: collision with root package name */
    private List<DistanceItem> f9524b;

    public DistanceResult() {
        this.f9524b = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public DistanceSearch.DistanceQuery getDistanceQuery() {
        return this.f9523a;
    }

    public List<DistanceItem> getDistanceResults() {
        return this.f9524b;
    }

    public void setDistanceQuery(DistanceSearch.DistanceQuery distanceQuery) {
        this.f9523a = distanceQuery;
    }

    public void setDistanceResults(List<DistanceItem> list) {
        this.f9524b = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeTypedList(this.f9524b);
    }

    protected DistanceResult(Parcel parcel) {
        this.f9524b = null;
        this.f9524b = parcel.createTypedArrayList(DistanceItem.CREATOR);
    }
}
