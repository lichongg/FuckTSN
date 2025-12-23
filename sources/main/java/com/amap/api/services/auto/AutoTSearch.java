package com.amap.api.services.auto;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.s.h0;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.IAutoTSearch;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class AutoTSearch {

    /* renamed from: a, reason: collision with root package name */
    private IAutoTSearch f9091a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class FilterBox implements Parcelable, Cloneable {
        public static final Parcelable.Creator<FilterBox> CREATOR = new Parcelable.Creator<FilterBox>() { // from class: com.amap.api.services.auto.AutoTSearch.FilterBox.1
            private static FilterBox a(Parcel parcel) {
                return new FilterBox(parcel);
            }

            private static FilterBox[] a(int i6) {
                return new FilterBox[i6];
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ FilterBox createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ FilterBox[] newArray(int i6) {
                return a(i6);
            }
        };

        /* renamed from: a, reason: collision with root package name */
        private String f9092a;

        /* renamed from: b, reason: collision with root package name */
        private String f9093b;

        /* renamed from: c, reason: collision with root package name */
        private String f9094c;

        /* renamed from: d, reason: collision with root package name */
        private String f9095d;

        /* renamed from: e, reason: collision with root package name */
        private String f9096e;

        public FilterBox() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        protected FilterBox(Parcel parcel) {
            this.f9092a = parcel.readString();
            this.f9093b = parcel.readString();
            this.f9094c = parcel.readString();
            this.f9095d = parcel.readString();
            this.f9096e = parcel.readString();
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public FilterBox m59clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e6) {
                e6.printStackTrace();
            }
            FilterBox filterBox = new FilterBox();
            filterBox.setRetainState(this.f9092a);
            filterBox.setCheckedLevel(this.f9093b);
            filterBox.setClassifyV2Data(this.f9094c);
            filterBox.setClassifyV2Level2Data(this.f9095d);
            filterBox.setClassifyV2Level3Data(this.f9096e);
            return filterBox;
        }

        public String getCheckedLevel() {
            return this.f9093b;
        }

        public String getClassifyV2Data() {
            return this.f9094c;
        }

        public String getClassifyV2Level2Data() {
            return this.f9095d;
        }

        public String getClassifyV2Level3Data() {
            return this.f9096e;
        }

        public String getRetainState() {
            return this.f9092a;
        }

        public void setCheckedLevel(String str) {
            this.f9093b = str;
        }

        public void setClassifyV2Data(String str) {
            this.f9094c = str;
        }

        public void setClassifyV2Level2Data(String str) {
            this.f9095d = str;
        }

        public void setClassifyV2Level3Data(String str) {
            this.f9096e = str;
        }

        public void setRetainState(String str) {
            this.f9092a = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            parcel.writeString(this.f9092a);
            parcel.writeString(this.f9093b);
            parcel.writeString(this.f9094c);
            parcel.writeString(this.f9095d);
            parcel.writeString(this.f9096e);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface OnChargeStationListener {
        void onChargeStationSearched(AutoTChargeStationResult autoTChargeStationResult, int i6);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Query implements Parcelable, Cloneable {
        public static final Parcelable.Creator<Query> CREATOR = new Parcelable.Creator<Query>() { // from class: com.amap.api.services.auto.AutoTSearch.Query.1
            private static Query a(Parcel parcel) {
                return new Query(parcel);
            }

            private static Query[] a(int i6) {
                return new Query[i6];
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Query createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Query[] newArray(int i6) {
                return a(i6);
            }
        };

        /* renamed from: a, reason: collision with root package name */
        private String f9097a;

        /* renamed from: b, reason: collision with root package name */
        private String f9098b;

        /* renamed from: c, reason: collision with root package name */
        private String f9099c;

        /* renamed from: d, reason: collision with root package name */
        private String f9100d;

        /* renamed from: e, reason: collision with root package name */
        private String f9101e;

        /* renamed from: f, reason: collision with root package name */
        private int f9102f;

        /* renamed from: g, reason: collision with root package name */
        private int f9103g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f9104h;

        /* renamed from: i, reason: collision with root package name */
        private String f9105i;

        /* renamed from: j, reason: collision with root package name */
        private int f9106j;

        /* renamed from: k, reason: collision with root package name */
        private LatLonPoint f9107k;

        /* renamed from: l, reason: collision with root package name */
        private String f9108l;

        /* renamed from: m, reason: collision with root package name */
        private String f9109m;

        /* renamed from: n, reason: collision with root package name */
        private FilterBox f9110n;

        /* renamed from: o, reason: collision with root package name */
        private String f9111o;

        /* renamed from: p, reason: collision with root package name */
        private String f9112p;

        public Query() {
            this.f9104h = false;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public Query m60clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e6) {
                e6.printStackTrace();
            }
            Query query = new Query();
            query.setAdCode(this.f9097a);
            query.setCity(this.f9098b);
            query.setDataType(this.f9099c);
            query.setGeoObj(this.f9100d);
            query.setKeywords(this.f9101e);
            query.setPageNum(this.f9102f);
            query.setPageSize(this.f9103g);
            query.setQii(this.f9104h);
            query.setQueryType(this.f9105i);
            query.setRange(this.f9106j);
            query.setLatLonPoint(this.f9107k);
            query.setUserLoc(this.f9108l);
            query.setUserCity(this.f9109m);
            query.setAccessKey(this.f9111o);
            query.setSecretKey(this.f9112p);
            query.setFilterBox(this.f9110n);
            return query;
        }

        public String getAccessKey() {
            return this.f9111o;
        }

        public String getAdCode() {
            return this.f9097a;
        }

        public String getCity() {
            return this.f9098b;
        }

        public String getDataType() {
            return this.f9099c;
        }

        public FilterBox getFilterBox() {
            return this.f9110n;
        }

        public String getGeoObj() {
            return this.f9100d;
        }

        public String getKeywords() {
            return this.f9101e;
        }

        public LatLonPoint getLatLonPoint() {
            return this.f9107k;
        }

        public int getPageNum() {
            return this.f9102f;
        }

        public int getPageSize() {
            return this.f9103g;
        }

        public String getQueryType() {
            return this.f9105i;
        }

        public int getRange() {
            return this.f9106j;
        }

        public String getSecretKey() {
            return this.f9112p;
        }

        public String getUserCity() {
            return this.f9109m;
        }

        public String getUserLoc() {
            return this.f9108l;
        }

        public boolean isQii() {
            return this.f9104h;
        }

        public void setAccessKey(String str) {
            this.f9111o = str;
        }

        public void setAdCode(String str) {
            this.f9097a = str;
        }

        public void setCity(String str) {
            this.f9098b = str;
        }

        public void setDataType(String str) {
            this.f9099c = str;
        }

        public void setFilterBox(FilterBox filterBox) {
            this.f9110n = filterBox;
        }

        public void setGeoObj(String str) {
            this.f9100d = str;
        }

        public void setKeywords(String str) {
            this.f9101e = str;
        }

        public void setLatLonPoint(LatLonPoint latLonPoint) {
            this.f9107k = latLonPoint;
        }

        public void setPageNum(int i6) {
            this.f9102f = i6;
        }

        public void setPageSize(int i6) {
            this.f9103g = i6;
        }

        public void setQii(boolean z5) {
            this.f9104h = z5;
        }

        public void setQueryType(String str) {
            this.f9105i = str;
        }

        public void setRange(int i6) {
            this.f9106j = i6;
        }

        public void setSecretKey(String str) {
            this.f9112p = str;
        }

        public void setUserCity(String str) {
            this.f9109m = str;
        }

        public void setUserLoc(String str) {
            this.f9108l = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            parcel.writeString(this.f9097a);
            parcel.writeString(this.f9098b);
            parcel.writeString(this.f9099c);
            parcel.writeString(this.f9100d);
            parcel.writeString(this.f9101e);
            parcel.writeInt(this.f9102f);
            parcel.writeInt(this.f9103g);
            parcel.writeByte(this.f9104h ? (byte) 1 : (byte) 0);
            parcel.writeString(this.f9105i);
            parcel.writeInt(this.f9106j);
            parcel.writeParcelable(this.f9107k, i6);
            parcel.writeString(this.f9108l);
            parcel.writeString(this.f9109m);
            parcel.writeParcelable(this.f9110n, i6);
            parcel.writeString(this.f9111o);
            parcel.writeString(this.f9112p);
        }

        protected Query(Parcel parcel) {
            this.f9104h = false;
            this.f9097a = parcel.readString();
            this.f9098b = parcel.readString();
            this.f9099c = parcel.readString();
            this.f9100d = parcel.readString();
            this.f9101e = parcel.readString();
            this.f9102f = parcel.readInt();
            this.f9103g = parcel.readInt();
            this.f9104h = parcel.readByte() != 0;
            this.f9105i = parcel.readString();
            this.f9106j = parcel.readInt();
            this.f9107k = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
            this.f9108l = parcel.readString();
            this.f9109m = parcel.readString();
            this.f9110n = (FilterBox) parcel.readParcelable(FilterBox.class.getClassLoader());
            this.f9111o = parcel.readString();
            this.f9112p = parcel.readString();
        }
    }

    public AutoTChargeStationResult searchChargeStation() throws AMapException {
        IAutoTSearch iAutoTSearch = this.f9091a;
        if (iAutoTSearch == null) {
            return null;
        }
        return iAutoTSearch.searchChargeStation();
    }

    public void searchChargeStationAsync() throws AMapException {
        IAutoTSearch iAutoTSearch = this.f9091a;
        if (iAutoTSearch == null) {
            return;
        }
        iAutoTSearch.searchChargeStationAsync();
    }

    public void setChargeStationListener(OnChargeStationListener onChargeStationListener) {
        IAutoTSearch iAutoTSearch = this.f9091a;
        if (iAutoTSearch == null || onChargeStationListener == null) {
            return;
        }
        iAutoTSearch.setChargeStationListener(onChargeStationListener);
    }

    public void setQuery(Query query) {
        IAutoTSearch iAutoTSearch = this.f9091a;
        if (iAutoTSearch == null) {
            return;
        }
        iAutoTSearch.setQuery(query);
    }

    public AutoTSearch(Context context) throws AMapException {
        if (this.f9091a == null) {
            try {
                this.f9091a = new h0(context);
            } catch (Exception e6) {
                e6.printStackTrace();
                if (e6 instanceof AMapException) {
                    throw ((AMapException) e6);
                }
            }
        }
    }
}
