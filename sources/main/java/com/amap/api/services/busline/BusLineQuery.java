package com.amap.api.services.busline;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class BusLineQuery implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private String f9128a;

    /* renamed from: b, reason: collision with root package name */
    private String f9129b;

    /* renamed from: e, reason: collision with root package name */
    private SearchType f9132e;

    /* renamed from: c, reason: collision with root package name */
    private int f9130c = 20;

    /* renamed from: d, reason: collision with root package name */
    private int f9131d = 1;

    /* renamed from: f, reason: collision with root package name */
    private String f9133f = "base";

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum SearchType {
        BY_LINE_ID,
        BY_LINE_NAME
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BusLineQuery busLineQuery = (BusLineQuery) obj;
        if (this.f9132e != busLineQuery.f9132e) {
            return false;
        }
        String str = this.f9129b;
        if (str == null) {
            if (busLineQuery.f9129b != null) {
                return false;
            }
        } else if (!str.equals(busLineQuery.f9129b)) {
            return false;
        }
        if (this.f9131d != busLineQuery.f9131d || this.f9130c != busLineQuery.f9130c) {
            return false;
        }
        String str2 = this.f9128a;
        if (str2 == null) {
            if (busLineQuery.f9128a != null) {
                return false;
            }
        } else if (!str2.equals(busLineQuery.f9128a)) {
            return false;
        }
        String str3 = this.f9133f;
        if (str3 == null) {
            if (busLineQuery.f9133f != null) {
                return false;
            }
        } else if (!str3.equals(busLineQuery.f9133f)) {
            return false;
        }
        return true;
    }

    public boolean weakEquals(BusLineQuery busLineQuery) {
        if (this == busLineQuery) {
            return true;
        }
        if (busLineQuery == null) {
            return false;
        }
        if (this.f9128a == null) {
            if (busLineQuery.getQueryString() != null) {
                return false;
            }
        } else if (!busLineQuery.getQueryString().equals(this.f9128a)) {
            return false;
        }
        if (this.f9129b == null) {
            if (busLineQuery.getCity() != null) {
                return false;
            }
        } else if (!busLineQuery.getCity().equals(this.f9129b)) {
            return false;
        }
        return this.f9130c == busLineQuery.getPageSize() && busLineQuery.getCategory().compareTo(this.f9132e) == 0;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public BusLineQuery m61clone() {
        BusLineQuery busLineQuery = new BusLineQuery(this.f9128a, this.f9132e, this.f9129b);
        busLineQuery.setPageNumber(this.f9131d);
        busLineQuery.setPageSize(this.f9130c);
        busLineQuery.setExtensions(this.f9133f);
        return busLineQuery;
    }

    public SearchType getCategory() {
        return this.f9132e;
    }

    public String getCity() {
        return this.f9129b;
    }

    public String getExtensions() {
        return this.f9133f;
    }

    public int getPageNumber() {
        return this.f9131d;
    }

    public int getPageSize() {
        return this.f9130c;
    }

    public String getQueryString() {
        return this.f9128a;
    }

    public int hashCode() {
        SearchType searchType = this.f9132e;
        int hashCode = ((searchType == null ? 0 : searchType.hashCode()) + 31) * 31;
        String str = this.f9129b;
        int hashCode2 = (((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f9131d) * 31) + this.f9130c) * 31;
        String str2 = this.f9128a;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f9133f;
        return hashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public void setCategory(SearchType searchType) {
        this.f9132e = searchType;
    }

    public void setCity(String str) {
        this.f9129b = str;
    }

    public void setExtensions(String str) {
        this.f9133f = str;
    }

    public void setPageNumber(int i6) {
        if (i6 <= 0) {
            i6 = 1;
        }
        this.f9131d = i6;
    }

    public void setPageSize(int i6) {
        this.f9130c = i6;
    }

    public void setQueryString(String str) {
        this.f9128a = str;
    }

    public BusLineQuery(String str, SearchType searchType, String str2) {
        this.f9128a = str;
        this.f9132e = searchType;
        this.f9129b = str2;
    }
}
