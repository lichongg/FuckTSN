package com.amap.api.location;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.services.district.DistrictSearchQuery;
import com.autonavi.aps.amapapi.utils.b;
import com.autonavi.aps.amapapi.utils.j;
import com.tencent.open.SocialConstants;
import com.umeng.analytics.pro.d;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class AMapLocation extends Location implements Parcelable, Cloneable {
    public static final String COORD_TYPE_GCJ02 = "GCJ02";
    public static final String COORD_TYPE_WGS84 = "WGS84";
    public static final Parcelable.Creator<AMapLocation> CREATOR = new Parcelable.Creator<AMapLocation>() { // from class: com.amap.api.location.AMapLocation.1
        private static AMapLocation a(Parcel parcel) {
            AMapLocation aMapLocation = new AMapLocation((Location) Location.CREATOR.createFromParcel(parcel));
            aMapLocation.f8827h = parcel.readString();
            aMapLocation.f8828i = parcel.readString();
            aMapLocation.B = parcel.readString();
            aMapLocation.f8820a = parcel.readString();
            aMapLocation.f8824e = parcel.readString();
            aMapLocation.f8826g = parcel.readString();
            aMapLocation.f8830k = parcel.readString();
            aMapLocation.f8825f = parcel.readString();
            aMapLocation.f8835p = parcel.readInt();
            aMapLocation.f8836q = parcel.readString();
            aMapLocation.f8821b = parcel.readString();
            aMapLocation.F = parcel.readInt() != 0;
            aMapLocation.f8834o = parcel.readInt() != 0;
            aMapLocation.f8839t = parcel.readDouble();
            aMapLocation.f8837r = parcel.readString();
            aMapLocation.f8838s = parcel.readInt();
            aMapLocation.f8840u = parcel.readDouble();
            aMapLocation.D = parcel.readInt() != 0;
            aMapLocation.f8833n = parcel.readString();
            aMapLocation.f8829j = parcel.readString();
            aMapLocation.f8823d = parcel.readString();
            aMapLocation.f8831l = parcel.readString();
            aMapLocation.A = parcel.readInt();
            aMapLocation.C = parcel.readInt();
            aMapLocation.f8832m = parcel.readString();
            aMapLocation.E = parcel.readString();
            aMapLocation.G = parcel.readString();
            aMapLocation.H = parcel.readInt();
            aMapLocation.I = parcel.readInt();
            return aMapLocation;
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AMapLocation createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AMapLocation[] newArray(int i6) {
            return a(i6);
        }

        private static AMapLocation[] a(int i6) {
            return new AMapLocation[i6];
        }
    };
    public static final int ERROR_CODE_AIRPLANEMODE_WIFIOFF = 18;
    public static final int ERROR_CODE_FAILURE_AUTH = 7;
    public static final int ERROR_CODE_FAILURE_CELL = 11;
    public static final int ERROR_CODE_FAILURE_COARSE_LOCATION = 20;
    public static final int ERROR_CODE_FAILURE_CONNECTION = 4;
    public static final int ERROR_CODE_FAILURE_INIT = 9;
    public static final int ERROR_CODE_FAILURE_LOCATION = 6;
    public static final int ERROR_CODE_FAILURE_LOCATION_PARAMETER = 3;
    public static final int ERROR_CODE_FAILURE_LOCATION_PERMISSION = 12;
    public static final int ERROR_CODE_FAILURE_NOENOUGHSATELLITES = 14;
    public static final int ERROR_CODE_FAILURE_NOWIFIANDAP = 13;
    public static final int ERROR_CODE_FAILURE_PARSER = 5;
    public static final int ERROR_CODE_FAILURE_SIMULATION_LOCATION = 15;
    public static final int ERROR_CODE_FAILURE_WIFI_INFO = 2;
    public static final int ERROR_CODE_INVALID_PARAMETER = 1;
    public static final int ERROR_CODE_NOCGI_WIFIOFF = 19;
    public static final int ERROR_CODE_NO_COMPENSATION_CACHE = 33;
    public static final int ERROR_CODE_SERVICE_FAIL = 10;
    public static final int ERROR_CODE_UNKNOWN = 8;
    public static final int GPS_ACCURACY_BAD = 0;
    public static final int GPS_ACCURACY_GOOD = 1;
    public static final int GPS_ACCURACY_UNKNOWN = -1;
    public static final int LOCATION_COMPENSATION = 10;
    public static final int LOCATION_SUCCESS = 0;
    public static final int LOCATION_TYPE_AMAP = 7;
    public static final int LOCATION_TYPE_CELL = 6;
    public static final int LOCATION_TYPE_COARSE_LOCATION = 11;
    public static final int LOCATION_TYPE_FAST = 3;
    public static final int LOCATION_TYPE_FIX_CACHE = 4;
    public static final int LOCATION_TYPE_GPS = 1;
    public static final int LOCATION_TYPE_LAST_LOCATION_CACHE = 9;
    public static final int LOCATION_TYPE_OFFLINE = 8;
    public static final int LOCATION_TYPE_SAME_REQ = 2;
    public static final int LOCATION_TYPE_WIFI = 5;
    public static final int TRUSTED_LEVEL_BAD = 4;
    public static final int TRUSTED_LEVEL_HIGH = 1;
    public static final int TRUSTED_LEVEL_LOW = 3;
    public static final int TRUSTED_LEVEL_NORMAL = 2;
    private int A;
    private String B;
    private int C;
    private boolean D;
    private String E;
    private boolean F;
    private String G;
    private int H;
    private int I;

    /* renamed from: a, reason: collision with root package name */
    protected String f8820a;

    /* renamed from: b, reason: collision with root package name */
    protected String f8821b;

    /* renamed from: c, reason: collision with root package name */
    AMapLocationQualityReport f8822c;

    /* renamed from: d, reason: collision with root package name */
    private String f8823d;

    /* renamed from: e, reason: collision with root package name */
    private String f8824e;

    /* renamed from: f, reason: collision with root package name */
    private String f8825f;

    /* renamed from: g, reason: collision with root package name */
    private String f8826g;

    /* renamed from: h, reason: collision with root package name */
    private String f8827h;

    /* renamed from: i, reason: collision with root package name */
    private String f8828i;

    /* renamed from: j, reason: collision with root package name */
    private String f8829j;

    /* renamed from: k, reason: collision with root package name */
    private String f8830k;

    /* renamed from: l, reason: collision with root package name */
    private String f8831l;

    /* renamed from: m, reason: collision with root package name */
    private String f8832m;

    /* renamed from: n, reason: collision with root package name */
    private String f8833n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f8834o;

    /* renamed from: p, reason: collision with root package name */
    private int f8835p;

    /* renamed from: q, reason: collision with root package name */
    private String f8836q;

    /* renamed from: r, reason: collision with root package name */
    private String f8837r;

    /* renamed from: s, reason: collision with root package name */
    private int f8838s;

    /* renamed from: t, reason: collision with root package name */
    private double f8839t;

    /* renamed from: u, reason: collision with root package name */
    private double f8840u;

    /* renamed from: v, reason: collision with root package name */
    private double f8841v;

    /* renamed from: w, reason: collision with root package name */
    private float f8842w;

    /* renamed from: x, reason: collision with root package name */
    private float f8843x;

    /* renamed from: y, reason: collision with root package name */
    private Bundle f8844y;

    /* renamed from: z, reason: collision with root package name */
    private String f8845z;

    public AMapLocation(String str) {
        super(str);
        this.f8823d = "";
        this.f8824e = "";
        this.f8825f = "";
        this.f8826g = "";
        this.f8827h = "";
        this.f8828i = "";
        this.f8829j = "";
        this.f8830k = "";
        this.f8831l = "";
        this.f8832m = "";
        this.f8833n = "";
        this.f8834o = true;
        this.f8835p = 0;
        this.f8836q = "success";
        this.f8837r = "";
        this.f8838s = 0;
        this.f8839t = 0.0d;
        this.f8840u = 0.0d;
        this.f8841v = 0.0d;
        this.f8842w = 0.0f;
        this.f8843x = 0.0f;
        this.f8844y = null;
        this.A = 0;
        this.B = "";
        this.C = -1;
        this.D = false;
        this.E = "";
        this.F = false;
        this.f8820a = "";
        this.f8821b = "";
        this.f8822c = new AMapLocationQualityReport();
        this.G = COORD_TYPE_GCJ02;
        this.H = 1;
        this.f8845z = str;
    }

    @Override // android.location.Location, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toStr() {
        return toStr(1);
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public AMapLocation m45clone() {
        try {
            super.clone();
        } catch (Throwable unused) {
        }
        AMapLocation aMapLocation = new AMapLocation(this);
        try {
            aMapLocation.setLatitude(this.f8839t);
            aMapLocation.setLongitude(this.f8840u);
            aMapLocation.setAdCode(this.f8827h);
            aMapLocation.setAddress(this.f8828i);
            aMapLocation.setAoiName(this.B);
            aMapLocation.setBuildingId(this.f8820a);
            aMapLocation.setCity(this.f8824e);
            aMapLocation.setCityCode(this.f8826g);
            aMapLocation.setCountry(this.f8830k);
            aMapLocation.setDistrict(this.f8825f);
            aMapLocation.setErrorCode(this.f8835p);
            aMapLocation.setErrorInfo(this.f8836q);
            aMapLocation.setFloor(this.f8821b);
            aMapLocation.setFixLastLocation(this.F);
            aMapLocation.setOffset(this.f8834o);
            aMapLocation.setLocationDetail(this.f8837r);
            aMapLocation.setLocationType(this.f8838s);
            aMapLocation.setMock(this.D);
            aMapLocation.setNumber(this.f8833n);
            aMapLocation.setPoiName(this.f8829j);
            aMapLocation.setProvince(this.f8823d);
            aMapLocation.setRoad(this.f8831l);
            aMapLocation.setSatellites(this.A);
            aMapLocation.setGpsAccuracyStatus(this.C);
            aMapLocation.setStreet(this.f8832m);
            aMapLocation.setDescription(this.E);
            aMapLocation.setExtras(getExtras());
            AMapLocationQualityReport aMapLocationQualityReport = this.f8822c;
            if (aMapLocationQualityReport != null) {
                aMapLocation.setLocationQualityReport(aMapLocationQualityReport.m47clone());
            }
            aMapLocation.setCoordType(this.G);
            aMapLocation.setTrustedLevel(this.H);
            aMapLocation.setConScenario(this.I);
        } catch (Throwable th) {
            b.a(th, "AMapLocation", "clone");
        }
        return aMapLocation;
    }

    public String getAdCode() {
        return this.f8827h;
    }

    public String getAddress() {
        return this.f8828i;
    }

    @Override // android.location.Location
    public double getAltitude() {
        return this.f8841v;
    }

    public String getAoiName() {
        return this.B;
    }

    @Override // android.location.Location
    public float getBearing() {
        return this.f8843x;
    }

    public String getBuildingId() {
        return this.f8820a;
    }

    public String getCity() {
        return this.f8824e;
    }

    public String getCityCode() {
        return this.f8826g;
    }

    public int getConScenario() {
        return this.I;
    }

    public String getCoordType() {
        return this.G;
    }

    public String getCountry() {
        return this.f8830k;
    }

    public String getDescription() {
        return this.E;
    }

    public String getDistrict() {
        return this.f8825f;
    }

    public int getErrorCode() {
        return this.f8835p;
    }

    public String getErrorInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f8836q);
        if (this.f8835p != 0) {
            sb.append(" 请到http://lbs.amap.com/api/android-location-sdk/guide/utilities/errorcode/查看错误码说明");
            sb.append(",错误详细信息:" + this.f8837r);
        }
        return sb.toString();
    }

    @Override // android.location.Location
    public Bundle getExtras() {
        return this.f8844y;
    }

    public String getFloor() {
        return this.f8821b;
    }

    public int getGpsAccuracyStatus() {
        return this.C;
    }

    @Override // android.location.Location
    public double getLatitude() {
        return this.f8839t;
    }

    public String getLocationDetail() {
        return this.f8837r;
    }

    public AMapLocationQualityReport getLocationQualityReport() {
        return this.f8822c;
    }

    public int getLocationType() {
        return this.f8838s;
    }

    @Override // android.location.Location
    public double getLongitude() {
        return this.f8840u;
    }

    public String getPoiName() {
        return this.f8829j;
    }

    @Override // android.location.Location
    public String getProvider() {
        return this.f8845z;
    }

    public String getProvince() {
        return this.f8823d;
    }

    public String getRoad() {
        return this.f8831l;
    }

    public int getSatellites() {
        return this.A;
    }

    @Override // android.location.Location
    public float getSpeed() {
        return this.f8842w;
    }

    public String getStreet() {
        return this.f8832m;
    }

    public String getStreetNum() {
        return this.f8833n;
    }

    public int getTrustedLevel() {
        return this.H;
    }

    public boolean isFixLastLocation() {
        return this.F;
    }

    @Override // android.location.Location
    public boolean isMock() {
        return this.D;
    }

    public boolean isOffset() {
        return this.f8834o;
    }

    public void setAdCode(String str) {
        this.f8827h = str;
    }

    public void setAddress(String str) {
        this.f8828i = str;
    }

    public void setAoiName(String str) {
        this.B = str;
    }

    public void setBuildingId(String str) {
        this.f8820a = str;
    }

    public void setCity(String str) {
        this.f8824e = str;
    }

    public void setCityCode(String str) {
        this.f8826g = str;
    }

    public void setConScenario(int i6) {
        this.I = i6;
    }

    public void setCoordType(String str) {
        this.G = str;
    }

    public void setCountry(String str) {
        this.f8830k = str;
    }

    public void setDescription(String str) {
        this.E = str;
    }

    public void setDistrict(String str) {
        this.f8825f = str;
    }

    public void setErrorCode(int i6) {
        if (this.f8835p != 0) {
            return;
        }
        this.f8836q = j.a(i6);
        this.f8835p = i6;
    }

    public void setErrorInfo(String str) {
        this.f8836q = str;
    }

    public void setFixLastLocation(boolean z5) {
        this.F = z5;
    }

    public void setGpsAccuracyStatus(int i6) {
        this.C = i6;
    }

    @Override // android.location.Location
    public void setLatitude(double d6) {
        this.f8839t = d6;
    }

    public void setLocationDetail(String str) {
        this.f8837r = str;
    }

    public void setLocationQualityReport(AMapLocationQualityReport aMapLocationQualityReport) {
        if (aMapLocationQualityReport == null) {
            return;
        }
        this.f8822c = aMapLocationQualityReport;
    }

    public void setLocationType(int i6) {
        this.f8838s = i6;
    }

    @Override // android.location.Location
    public void setLongitude(double d6) {
        this.f8840u = d6;
    }

    @Override // android.location.Location
    public void setMock(boolean z5) {
        this.D = z5;
    }

    public void setNumber(String str) {
        this.f8833n = str;
    }

    public void setOffset(boolean z5) {
        this.f8834o = z5;
    }

    public void setPoiName(String str) {
        this.f8829j = str;
    }

    public void setProvince(String str) {
        this.f8823d = str;
    }

    public void setRoad(String str) {
        this.f8831l = str;
    }

    public void setSatellites(int i6) {
        this.A = i6;
    }

    public void setStreet(String str) {
        this.f8832m = str;
    }

    public void setTrustedLevel(int i6) {
        this.H = i6;
    }

    public JSONObject toJson(int i6) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (i6 == 1) {
                try {
                    jSONObject.put("altitude", getAltitude());
                    jSONObject.put("speed", getSpeed());
                    jSONObject.put("bearing", getBearing());
                } catch (Throwable unused) {
                }
                jSONObject.put("citycode", this.f8826g);
                jSONObject.put("adcode", this.f8827h);
                jSONObject.put("country", this.f8830k);
                jSONObject.put(DistrictSearchQuery.KEYWORDS_PROVINCE, this.f8823d);
                jSONObject.put(DistrictSearchQuery.KEYWORDS_CITY, this.f8824e);
                jSONObject.put(DistrictSearchQuery.KEYWORDS_DISTRICT, this.f8825f);
                jSONObject.put("road", this.f8831l);
                jSONObject.put("street", this.f8832m);
                jSONObject.put("number", this.f8833n);
                jSONObject.put("poiname", this.f8829j);
                jSONObject.put("errorCode", this.f8835p);
                jSONObject.put(MyLocationStyle.ERROR_INFO, this.f8836q);
                jSONObject.put(MyLocationStyle.LOCATION_TYPE, this.f8838s);
                jSONObject.put("locationDetail", this.f8837r);
                jSONObject.put("aoiname", this.B);
                jSONObject.put("address", this.f8828i);
                jSONObject.put("poiid", this.f8820a);
                jSONObject.put("floor", this.f8821b);
                jSONObject.put(SocialConstants.PARAM_COMMENT, this.E);
            } else if (i6 != 2) {
                if (i6 != 3) {
                    return jSONObject;
                }
                jSONObject.put(d.M, getProvider());
                jSONObject.put("lon", getLongitude());
                jSONObject.put(d.C, getLatitude());
                jSONObject.put("accuracy", getAccuracy());
                jSONObject.put("isOffset", this.f8834o);
                jSONObject.put("isFixLastLocation", this.F);
                jSONObject.put("coordType", this.G);
                return jSONObject;
            }
            jSONObject.put("time", getTime());
            jSONObject.put(d.M, getProvider());
            jSONObject.put("lon", getLongitude());
            jSONObject.put(d.C, getLatitude());
            jSONObject.put("accuracy", getAccuracy());
            jSONObject.put("isOffset", this.f8834o);
            jSONObject.put("isFixLastLocation", this.F);
            jSONObject.put("coordType", this.G);
            return jSONObject;
        } catch (Throwable th) {
            b.a(th, "AmapLoc", "toStr");
            return null;
        }
    }

    public String toStr(int i6) {
        JSONObject jSONObject;
        try {
            jSONObject = toJson(i6);
        } catch (Throwable th) {
            b.a(th, "AMapLocation", "toStr part2");
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.toString();
    }

    @Override // android.location.Location
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            stringBuffer.append("latitude=" + this.f8839t + "#");
            stringBuffer.append("longitude=" + this.f8840u + "#");
            stringBuffer.append("province=" + this.f8823d + "#");
            stringBuffer.append("coordType=" + this.G + "#");
            stringBuffer.append("city=" + this.f8824e + "#");
            stringBuffer.append("district=" + this.f8825f + "#");
            stringBuffer.append("cityCode=" + this.f8826g + "#");
            stringBuffer.append("adCode=" + this.f8827h + "#");
            stringBuffer.append("address=" + this.f8828i + "#");
            stringBuffer.append("country=" + this.f8830k + "#");
            stringBuffer.append("road=" + this.f8831l + "#");
            stringBuffer.append("poiName=" + this.f8829j + "#");
            stringBuffer.append("street=" + this.f8832m + "#");
            stringBuffer.append("streetNum=" + this.f8833n + "#");
            stringBuffer.append("aoiName=" + this.B + "#");
            stringBuffer.append("poiid=" + this.f8820a + "#");
            stringBuffer.append("floor=" + this.f8821b + "#");
            stringBuffer.append("errorCode=" + this.f8835p + "#");
            stringBuffer.append("errorInfo=" + this.f8836q + "#");
            stringBuffer.append("locationDetail=" + this.f8837r + "#");
            stringBuffer.append("description=" + this.E + "#");
            stringBuffer.append("locationType=" + this.f8838s + "#");
            StringBuilder sb = new StringBuilder("conScenario=");
            sb.append(this.I);
            stringBuffer.append(sb.toString());
        } catch (Throwable unused) {
        }
        return stringBuffer.toString();
    }

    @Override // android.location.Location
    public float getAccuracy() {
        return super.getAccuracy();
    }

    @Override // android.location.Location
    public void setAltitude(double d6) {
        super.setAltitude(d6);
        this.f8841v = d6;
    }

    @Override // android.location.Location
    public void setBearing(float f6) {
        super.setBearing(f6);
        while (f6 < 0.0f) {
            f6 += 360.0f;
        }
        while (f6 >= 360.0f) {
            f6 -= 360.0f;
        }
        this.f8843x = f6;
    }

    @Override // android.location.Location
    public void setExtras(Bundle bundle) {
        Bundle bundle2;
        super.setExtras(bundle);
        if (bundle == null) {
            bundle2 = null;
        } else {
            bundle2 = new Bundle(bundle);
        }
        this.f8844y = bundle2;
    }

    public void setFloor(String str) {
        if (!TextUtils.isEmpty(str)) {
            str = str.replace("F", "");
            try {
                Integer.parseInt(str);
            } catch (Throwable th) {
                b.a(th, "AmapLoc", "setFloor");
                str = null;
            }
        }
        this.f8821b = str;
    }

    @Override // android.location.Location
    public void setProvider(String str) {
        super.setProvider(str);
        this.f8845z = str;
    }

    @Override // android.location.Location
    public void setSpeed(float f6) {
        super.setSpeed(f6);
        this.f8842w = f6;
    }

    @Override // android.location.Location, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        try {
            super.writeToParcel(parcel, i6);
            parcel.writeString(this.f8827h);
            parcel.writeString(this.f8828i);
            parcel.writeString(this.B);
            parcel.writeString(this.f8820a);
            parcel.writeString(this.f8824e);
            parcel.writeString(this.f8826g);
            parcel.writeString(this.f8830k);
            parcel.writeString(this.f8825f);
            parcel.writeInt(this.f8835p);
            parcel.writeString(this.f8836q);
            parcel.writeString(this.f8821b);
            parcel.writeInt(this.F ? 1 : 0);
            parcel.writeInt(this.f8834o ? 1 : 0);
            parcel.writeDouble(this.f8839t);
            parcel.writeString(this.f8837r);
            parcel.writeInt(this.f8838s);
            parcel.writeDouble(this.f8840u);
            parcel.writeInt(this.D ? 1 : 0);
            parcel.writeString(this.f8833n);
            parcel.writeString(this.f8829j);
            parcel.writeString(this.f8823d);
            parcel.writeString(this.f8831l);
            parcel.writeInt(this.A);
            parcel.writeInt(this.C);
            parcel.writeString(this.f8832m);
            parcel.writeString(this.E);
            parcel.writeString(this.G);
            parcel.writeInt(this.H);
            parcel.writeInt(this.I);
        } catch (Throwable th) {
            b.a(th, "AMapLocation", "writeToParcel");
        }
    }

    public AMapLocation(Location location) {
        super(location);
        this.f8823d = "";
        this.f8824e = "";
        this.f8825f = "";
        this.f8826g = "";
        this.f8827h = "";
        this.f8828i = "";
        this.f8829j = "";
        this.f8830k = "";
        this.f8831l = "";
        this.f8832m = "";
        this.f8833n = "";
        this.f8834o = true;
        this.f8835p = 0;
        this.f8836q = "success";
        this.f8837r = "";
        this.f8838s = 0;
        this.f8839t = 0.0d;
        this.f8840u = 0.0d;
        this.f8841v = 0.0d;
        this.f8842w = 0.0f;
        this.f8843x = 0.0f;
        this.f8844y = null;
        this.A = 0;
        this.B = "";
        this.C = -1;
        this.D = false;
        this.E = "";
        this.F = false;
        this.f8820a = "";
        this.f8821b = "";
        this.f8822c = new AMapLocationQualityReport();
        this.G = COORD_TYPE_GCJ02;
        this.H = 1;
        this.f8839t = location.getLatitude();
        this.f8840u = location.getLongitude();
        this.f8841v = location.getAltitude();
        this.f8843x = location.getBearing();
        this.f8842w = location.getSpeed();
        this.f8845z = location.getProvider();
        this.f8844y = location.getExtras() != null ? new Bundle(location.getExtras()) : null;
    }
}
