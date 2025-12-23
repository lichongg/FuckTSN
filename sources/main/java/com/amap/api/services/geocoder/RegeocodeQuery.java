package com.amap.api.services.geocoder;

import com.amap.api.services.core.LatLonPoint;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class RegeocodeQuery {

    /* renamed from: a, reason: collision with root package name */
    private LatLonPoint f9314a;

    /* renamed from: b, reason: collision with root package name */
    private float f9315b;

    /* renamed from: c, reason: collision with root package name */
    private String f9316c = GeocodeSearch.AMAP;

    /* renamed from: d, reason: collision with root package name */
    private String f9317d = "";

    /* renamed from: e, reason: collision with root package name */
    private String f9318e = "distance";

    /* renamed from: f, reason: collision with root package name */
    private String f9319f = "base";

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RegeocodeQuery regeocodeQuery = (RegeocodeQuery) obj;
        String str = this.f9316c;
        if (str == null) {
            if (regeocodeQuery.f9316c != null) {
                return false;
            }
        } else if (!str.equals(regeocodeQuery.f9316c)) {
            return false;
        }
        LatLonPoint latLonPoint = this.f9314a;
        if (latLonPoint == null) {
            if (regeocodeQuery.f9314a != null) {
                return false;
            }
        } else if (!latLonPoint.equals(regeocodeQuery.f9314a)) {
            return false;
        }
        if (Float.floatToIntBits(this.f9315b) != Float.floatToIntBits(regeocodeQuery.f9315b) || !this.f9318e.equals(regeocodeQuery.f9318e)) {
            return false;
        }
        String str2 = this.f9319f;
        if (str2 == null) {
            if (regeocodeQuery.f9319f != null) {
                return false;
            }
        } else if (!str2.equals(regeocodeQuery.f9319f)) {
            return false;
        }
        return true;
    }

    public String getExtensions() {
        return this.f9319f;
    }

    public String getLatLonType() {
        return this.f9316c;
    }

    public String getMode() {
        return this.f9318e;
    }

    public String getPoiType() {
        return this.f9317d;
    }

    public LatLonPoint getPoint() {
        return this.f9314a;
    }

    public float getRadius() {
        return this.f9315b;
    }

    public int hashCode() {
        String str = this.f9316c;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        LatLonPoint latLonPoint = this.f9314a;
        return ((hashCode + (latLonPoint != null ? latLonPoint.hashCode() : 0)) * 31) + Float.floatToIntBits(this.f9315b);
    }

    public void setExtensions(String str) {
        this.f9319f = str;
    }

    public void setLatLonType(String str) {
        if (str != null) {
            if (str.equals(GeocodeSearch.AMAP) || str.equals(GeocodeSearch.GPS)) {
                this.f9316c = str;
            }
        }
    }

    public void setMode(String str) {
        this.f9318e = str;
    }

    public void setPoiType(String str) {
        this.f9317d = str;
    }

    public void setPoint(LatLonPoint latLonPoint) {
        this.f9314a = latLonPoint;
    }

    public void setRadius(float f6) {
        this.f9315b = f6;
    }

    public RegeocodeQuery(LatLonPoint latLonPoint, float f6, String str) {
        this.f9314a = latLonPoint;
        this.f9315b = f6;
        setLatLonType(str);
    }
}
