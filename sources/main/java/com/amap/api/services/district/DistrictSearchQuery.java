package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.s.j4;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class DistrictSearchQuery implements Parcelable, Cloneable {
    public static final Parcelable.Creator<DistrictSearchQuery> CREATOR = new Parcelable.Creator<DistrictSearchQuery>() { // from class: com.amap.api.services.district.DistrictSearchQuery.1
        private static DistrictSearchQuery a(Parcel parcel) {
            DistrictSearchQuery districtSearchQuery = new DistrictSearchQuery();
            districtSearchQuery.setKeywords(parcel.readString());
            districtSearchQuery.setKeywordsLevel(parcel.readString());
            districtSearchQuery.setPageNum(parcel.readInt());
            districtSearchQuery.setPageSize(parcel.readInt());
            districtSearchQuery.setShowChild(parcel.readByte() == 1);
            districtSearchQuery.setShowBoundary(parcel.readByte() == 1);
            districtSearchQuery.setShowBusinessArea(parcel.readByte() == 1);
            districtSearchQuery.setSubDistrict(parcel.readInt());
            return districtSearchQuery;
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DistrictSearchQuery createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DistrictSearchQuery[] newArray(int i6) {
            return a(i6);
        }

        private static DistrictSearchQuery[] a(int i6) {
            return new DistrictSearchQuery[i6];
        }
    };
    public static final String KEYWORDS_BUSINESS = "biz_area";
    public static final String KEYWORDS_CITY = "city";
    public static final String KEYWORDS_COUNTRY = "country";
    public static final String KEYWORDS_DISTRICT = "district";
    public static final String KEYWORDS_PROVINCE = "province";

    /* renamed from: a, reason: collision with root package name */
    private int f9263a;

    /* renamed from: b, reason: collision with root package name */
    private int f9264b;

    /* renamed from: c, reason: collision with root package name */
    private String f9265c;

    /* renamed from: d, reason: collision with root package name */
    private String f9266d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f9267e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f9268f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f9269g;

    /* renamed from: h, reason: collision with root package name */
    private int f9270h;

    public DistrictSearchQuery() {
        this.f9263a = 1;
        this.f9264b = 20;
        this.f9267e = true;
        this.f9268f = false;
        this.f9269g = false;
        this.f9270h = 1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DistrictSearchQuery districtSearchQuery = (DistrictSearchQuery) obj;
        if (this.f9269g != districtSearchQuery.f9269g) {
            return false;
        }
        String str = this.f9265c;
        if (str == null) {
            if (districtSearchQuery.f9265c != null) {
                return false;
            }
        } else if (!str.equals(districtSearchQuery.f9265c)) {
            return false;
        }
        return this.f9263a == districtSearchQuery.f9263a && this.f9264b == districtSearchQuery.f9264b && this.f9267e == districtSearchQuery.f9267e && this.f9270h == districtSearchQuery.f9270h;
    }

    public boolean weakEquals(DistrictSearchQuery districtSearchQuery) {
        if (this == districtSearchQuery) {
            return true;
        }
        if (districtSearchQuery == null) {
            return false;
        }
        String str = this.f9265c;
        if (str == null) {
            if (districtSearchQuery.f9265c != null) {
                return false;
            }
        } else if (!str.equals(districtSearchQuery.f9265c)) {
            return false;
        }
        return this.f9264b == districtSearchQuery.f9264b && this.f9267e == districtSearchQuery.f9267e && this.f9269g == districtSearchQuery.f9269g && this.f9270h == districtSearchQuery.f9270h;
    }

    public boolean checkKeyWords() {
        String str = this.f9265c;
        return (str == null || str.trim().equalsIgnoreCase("")) ? false : true;
    }

    public boolean checkLevels() {
        String str = this.f9266d;
        if (str == null) {
            return false;
        }
        return str.trim().equals("country") || this.f9266d.trim().equals(KEYWORDS_PROVINCE) || this.f9266d.trim().equals(KEYWORDS_CITY) || this.f9266d.trim().equals(KEYWORDS_DISTRICT) || this.f9266d.trim().equals(KEYWORDS_BUSINESS);
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public DistrictSearchQuery m65clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e6) {
            j4.i(e6, "DistrictSearchQuery", "clone");
        }
        DistrictSearchQuery districtSearchQuery = new DistrictSearchQuery();
        districtSearchQuery.setKeywords(this.f9265c);
        districtSearchQuery.setKeywordsLevel(this.f9266d);
        districtSearchQuery.setPageNum(this.f9263a);
        districtSearchQuery.setPageSize(this.f9264b);
        districtSearchQuery.setShowChild(this.f9267e);
        districtSearchQuery.setSubDistrict(this.f9270h);
        districtSearchQuery.setShowBoundary(this.f9269g);
        districtSearchQuery.setShowBusinessArea(this.f9268f);
        return districtSearchQuery;
    }

    public String getKeywords() {
        return this.f9265c;
    }

    public String getKeywordsLevel() {
        return this.f9266d;
    }

    public int getPageNum() {
        int i6 = this.f9263a;
        if (i6 <= 0) {
            return 1;
        }
        return i6;
    }

    public int getPageSize() {
        return this.f9264b;
    }

    public int getSubDistrict() {
        return this.f9270h;
    }

    public int hashCode() {
        int i6 = ((this.f9269g ? 1231 : 1237) + 31) * 31;
        String str = this.f9265c;
        int hashCode = (i6 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f9266d;
        return ((((((((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f9263a) * 31) + this.f9264b) * 31) + (this.f9267e ? 1231 : 1237)) * 31) + this.f9270h;
    }

    public boolean isShowBoundary() {
        return this.f9269g;
    }

    public boolean isShowBusinessArea() {
        return this.f9268f;
    }

    public boolean isShowChild() {
        return this.f9267e;
    }

    public void setKeywords(String str) {
        this.f9265c = str;
    }

    public void setKeywordsLevel(String str) {
        this.f9266d = str;
    }

    public void setPageNum(int i6) {
        this.f9263a = i6;
    }

    public void setPageSize(int i6) {
        this.f9264b = i6;
    }

    public void setShowBoundary(boolean z5) {
        this.f9269g = z5;
    }

    public void setShowBusinessArea(boolean z5) {
        this.f9268f = z5;
    }

    public void setShowChild(boolean z5) {
        this.f9267e = z5;
    }

    public void setSubDistrict(int i6) {
        this.f9270h = i6;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f9265c);
        parcel.writeString(this.f9266d);
        parcel.writeInt(this.f9263a);
        parcel.writeInt(this.f9264b);
        parcel.writeByte(this.f9267e ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f9269g ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f9268f ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f9270h);
    }

    public DistrictSearchQuery(String str, String str2, int i6) {
        this.f9264b = 20;
        this.f9267e = true;
        this.f9268f = false;
        this.f9269g = false;
        this.f9270h = 1;
        this.f9265c = str;
        this.f9266d = str2;
        this.f9263a = i6;
    }

    public DistrictSearchQuery(String str, String str2, int i6, boolean z5, int i7) {
        this(str, str2, i6);
        this.f9267e = z5;
        this.f9264b = i7;
    }
}
