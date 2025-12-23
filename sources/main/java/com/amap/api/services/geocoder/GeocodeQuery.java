package com.amap.api.services.geocoder;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class GeocodeQuery {

    /* renamed from: a, reason: collision with root package name */
    private String f9290a;

    /* renamed from: b, reason: collision with root package name */
    private String f9291b;

    /* renamed from: c, reason: collision with root package name */
    private String f9292c;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        GeocodeQuery geocodeQuery = (GeocodeQuery) obj;
        String str = this.f9291b;
        if (str == null) {
            if (geocodeQuery.f9291b != null) {
                return false;
            }
        } else if (!str.equals(geocodeQuery.f9291b)) {
            return false;
        }
        String str2 = this.f9290a;
        if (str2 == null) {
            if (geocodeQuery.f9290a != null) {
                return false;
            }
        } else if (!str2.equals(geocodeQuery.f9290a)) {
            return false;
        }
        return true;
    }

    public String getCity() {
        return this.f9291b;
    }

    public String getCountry() {
        return this.f9292c;
    }

    public String getLocationName() {
        return this.f9290a;
    }

    public int hashCode() {
        String str = this.f9291b;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.f9290a;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public void setCity(String str) {
        this.f9291b = str;
    }

    public void setCountry(String str) {
        this.f9292c = str;
    }

    public void setLocationName(String str) {
        this.f9290a = str;
    }

    public GeocodeQuery(String str, String str2) {
        this.f9290a = str;
        this.f9291b = str2;
    }
}
