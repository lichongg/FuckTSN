package com.amap.api.services.busline;

import com.amap.api.col.s.j4;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class BusStationQuery implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private String f9147a;

    /* renamed from: b, reason: collision with root package name */
    private String f9148b;

    /* renamed from: c, reason: collision with root package name */
    private int f9149c = 20;

    /* renamed from: d, reason: collision with root package name */
    private int f9150d = 1;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BusStationQuery busStationQuery = (BusStationQuery) obj;
        String str = this.f9148b;
        if (str == null) {
            if (busStationQuery.f9148b != null) {
                return false;
            }
        } else if (!str.equals(busStationQuery.f9148b)) {
            return false;
        }
        if (this.f9150d != busStationQuery.f9150d || this.f9149c != busStationQuery.f9149c) {
            return false;
        }
        String str2 = this.f9147a;
        if (str2 == null) {
            if (busStationQuery.f9147a != null) {
                return false;
            }
        } else if (!str2.equals(busStationQuery.f9147a)) {
            return false;
        }
        return true;
    }

    public boolean weakEquals(BusStationQuery busStationQuery) {
        if (this == busStationQuery) {
            return true;
        }
        if (busStationQuery == null) {
            return false;
        }
        String str = this.f9148b;
        if (str == null) {
            if (busStationQuery.f9148b != null) {
                return false;
            }
        } else if (!str.equals(busStationQuery.f9148b)) {
            return false;
        }
        if (this.f9149c != busStationQuery.f9149c) {
            return false;
        }
        String str2 = this.f9147a;
        if (str2 == null) {
            if (busStationQuery.f9147a != null) {
                return false;
            }
        } else if (!str2.equals(busStationQuery.f9147a)) {
            return false;
        }
        return true;
    }

    private boolean a() {
        return !j4.j(this.f9147a);
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public BusStationQuery m62clone() {
        BusStationQuery busStationQuery = new BusStationQuery(this.f9147a, this.f9148b);
        busStationQuery.setPageNumber(this.f9150d);
        busStationQuery.setPageSize(this.f9149c);
        return busStationQuery;
    }

    public String getCity() {
        return this.f9148b;
    }

    public int getPageNumber() {
        return this.f9150d;
    }

    public int getPageSize() {
        return this.f9149c;
    }

    public String getQueryString() {
        return this.f9147a;
    }

    public int hashCode() {
        String str = this.f9148b;
        int hashCode = ((((((str == null ? 0 : str.hashCode()) + 31) * 31) + this.f9150d) * 31) + this.f9149c) * 31;
        String str2 = this.f9147a;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public void setCity(String str) {
        this.f9148b = str;
    }

    public void setPageNumber(int i6) {
        if (i6 <= 0) {
            i6 = 1;
        }
        this.f9150d = i6;
    }

    public void setPageSize(int i6) {
        this.f9149c = i6;
    }

    public void setQueryString(String str) {
        this.f9147a = str;
    }

    public BusStationQuery(String str, String str2) {
        this.f9147a = str;
        this.f9148b = str2;
        if (!a()) {
            new IllegalArgumentException("Empty query").printStackTrace();
        }
    }
}
