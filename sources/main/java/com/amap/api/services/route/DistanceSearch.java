package com.amap.api.services.route;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.s.j4;
import com.amap.api.col.s.l0;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.IDistanceSearch;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class DistanceSearch {
    public static final String EXTENSIONS_ALL = "all";
    public static final String EXTENSIONS_BASE = "base";
    public static final int TYPE_DISTANCE = 0;
    public static final int TYPE_DRIVING_DISTANCE = 1;
    public static final int TYPE_WALK_DISTANCE = 3;

    /* renamed from: a, reason: collision with root package name */
    private IDistanceSearch f9525a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class DistanceQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<DistanceQuery> CREATOR = new Parcelable.Creator<DistanceQuery>() { // from class: com.amap.api.services.route.DistanceSearch.DistanceQuery.1
            private static DistanceQuery a(Parcel parcel) {
                return new DistanceQuery(parcel);
            }

            private static DistanceQuery[] a(int i6) {
                return new DistanceQuery[i6];
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DistanceQuery createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DistanceQuery[] newArray(int i6) {
                return a(i6);
            }
        };

        /* renamed from: a, reason: collision with root package name */
        private int f9526a;

        /* renamed from: b, reason: collision with root package name */
        private List<LatLonPoint> f9527b;

        /* renamed from: c, reason: collision with root package name */
        private LatLonPoint f9528c;

        /* renamed from: d, reason: collision with root package name */
        private String f9529d;

        /* renamed from: e, reason: collision with root package name */
        private int f9530e;

        public DistanceQuery() {
            this.f9526a = 1;
            this.f9527b = new ArrayList();
            this.f9529d = "base";
            this.f9530e = 4;
        }

        public void addOrigins(LatLonPoint... latLonPointArr) {
            for (LatLonPoint latLonPoint : latLonPointArr) {
                if (latLonPoint != null) {
                    this.f9527b.add(latLonPoint);
                }
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public DistanceQuery m70clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e6) {
                j4.i(e6, "DistanceSearch", "DistanceQueryclone");
            }
            DistanceQuery distanceQuery = new DistanceQuery();
            distanceQuery.setType(this.f9526a);
            distanceQuery.setOrigins(this.f9527b);
            distanceQuery.setDestination(this.f9528c);
            distanceQuery.setExtensions(this.f9529d);
            distanceQuery.setMode(this.f9530e);
            return distanceQuery;
        }

        public LatLonPoint getDestination() {
            return this.f9528c;
        }

        public String getExtensions() {
            return this.f9529d;
        }

        public int getMode() {
            return this.f9530e;
        }

        public List<LatLonPoint> getOrigins() {
            return this.f9527b;
        }

        public int getType() {
            return this.f9526a;
        }

        public void setDestination(LatLonPoint latLonPoint) {
            this.f9528c = latLonPoint;
        }

        public void setExtensions(String str) {
            this.f9529d = str;
        }

        public void setMode(int i6) {
            this.f9530e = i6;
        }

        public void setOrigins(List<LatLonPoint> list) {
            if (list != null) {
                this.f9527b = list;
            }
        }

        public void setType(int i6) {
            this.f9526a = i6;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            parcel.writeInt(this.f9526a);
            parcel.writeTypedList(this.f9527b);
            parcel.writeParcelable(this.f9528c, i6);
            parcel.writeString(this.f9529d);
            parcel.writeInt(this.f9530e);
        }

        protected DistanceQuery(Parcel parcel) {
            this.f9526a = 1;
            this.f9527b = new ArrayList();
            this.f9529d = "base";
            this.f9530e = 4;
            this.f9526a = parcel.readInt();
            this.f9527b = parcel.createTypedArrayList(LatLonPoint.CREATOR);
            this.f9528c = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
            this.f9529d = parcel.readString();
            this.f9530e = parcel.readInt();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface OnDistanceSearchListener {
        void onDistanceSearched(DistanceResult distanceResult, int i6);
    }

    public DistanceResult calculateRouteDistance(DistanceQuery distanceQuery) throws AMapException {
        IDistanceSearch iDistanceSearch = this.f9525a;
        if (iDistanceSearch != null) {
            return iDistanceSearch.calculateRouteDistance(distanceQuery);
        }
        return null;
    }

    public void calculateRouteDistanceAsyn(DistanceQuery distanceQuery) {
        IDistanceSearch iDistanceSearch = this.f9525a;
        if (iDistanceSearch != null) {
            iDistanceSearch.calculateRouteDistanceAsyn(distanceQuery);
        }
    }

    public void setDistanceSearchListener(OnDistanceSearchListener onDistanceSearchListener) {
        IDistanceSearch iDistanceSearch = this.f9525a;
        if (iDistanceSearch != null) {
            iDistanceSearch.setDistanceSearchListener(onDistanceSearchListener);
        }
    }

    public DistanceSearch(Context context) throws AMapException {
        if (this.f9525a == null) {
            try {
                this.f9525a = new l0(context);
            } catch (Exception e6) {
                e6.printStackTrace();
                if (e6 instanceof AMapException) {
                    throw ((AMapException) e6);
                }
            }
        }
    }
}
