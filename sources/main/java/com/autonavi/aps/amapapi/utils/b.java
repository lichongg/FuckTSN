package com.autonavi.aps.amapapi.utils;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.amap.api.col.p0003l.f4;
import com.amap.api.col.p0003l.fk;
import com.amap.api.col.p0003l.m4;
import com.amap.api.col.p0003l.p4;
import com.amap.api.col.p0003l.q4;
import com.amap.api.col.p0003l.v5;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.DPoint;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.services.district.DistrictSearchQuery;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.tencent.open.SocialConstants;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static String f10234a = "5.3";

    /* renamed from: l, reason: collision with root package name */
    static String f10245l;

    /* renamed from: m, reason: collision with root package name */
    static HashMap<String, String> f10246m;

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f10235b = {"5.1"};

    /* renamed from: c, reason: collision with root package name */
    static String f10236c = "http://apilocate.amap.com/mobile/binary";

    /* renamed from: d, reason: collision with root package name */
    static String f10237d = "http://dualstack-a.apilocate.amap.com/mobile/binary";

    /* renamed from: e, reason: collision with root package name */
    static String f10238e = "";

    /* renamed from: p, reason: collision with root package name */
    private static final String[] f10249p = {"com.amap.api.location", "com.loc", "com.amap.api.fence"};

    /* renamed from: f, reason: collision with root package name */
    static String f10239f = "11G;11K;13J;13S;15O;15U;17J;17Y;197;1A6";

    /* renamed from: g, reason: collision with root package name */
    public static String f10240g = null;

    /* renamed from: h, reason: collision with root package name */
    public static String f10241h = null;

    /* renamed from: i, reason: collision with root package name */
    public static int f10242i = KSImageLoader.InnerImageLoadingListener.MAX_DURATION;

    /* renamed from: j, reason: collision with root package name */
    public static String f10243j = null;

    /* renamed from: k, reason: collision with root package name */
    public static String f10244k = null;

    /* renamed from: q, reason: collision with root package name */
    private static p4 f10250q = null;

    /* renamed from: r, reason: collision with root package name */
    private static boolean f10251r = false;

    /* renamed from: s, reason: collision with root package name */
    private static boolean f10252s = false;

    /* renamed from: n, reason: collision with root package name */
    static boolean f10247n = false;

    /* renamed from: o, reason: collision with root package name */
    static boolean f10248o = false;

    private static boolean a(double d6, double d7, double d8, double d9, double d10, double d11, double d12) {
        double d13 = d8 - d6;
        double d14 = d12 - d11;
        double d15 = d9 - d7;
        double d16 = 180.0d - d10;
        double d17 = (d13 * d14) - (d15 * d16);
        if (d17 == 0.0d) {
            return false;
        }
        double d18 = d7 - d11;
        double d19 = d6 - d10;
        double d20 = ((d16 * d18) - (d14 * d19)) / d17;
        double d21 = ((d18 * d13) - (d19 * d15)) / d17;
        return d20 >= 0.0d && d20 <= 1.0d && d21 >= 0.0d && d21 <= 1.0d;
    }

    private static double b(double d6, double d7, double d8, double d9, double d10, double d11) {
        return ((d8 - d6) * (d11 - d7)) - ((d10 - d6) * (d9 - d7));
    }

    public static p4 c() {
        try {
            if (f10250q == null) {
                f10250q = new p4.a("loc", "6.4.3", "AMAP_Location_SDK_Android 6.4.3").b(e()).a("6.4.3").c();
            }
        } catch (Throwable th) {
            a(th, "CoreUtil", "getSDKInfo");
        }
        return f10250q;
    }

    public static String a() {
        return f10236c;
    }

    public static String b() {
        return f10237d;
    }

    public static String d() {
        return f10239f;
    }

    private static String[] e() {
        return (String[]) f10249p.clone();
    }

    private static void f() {
        try {
            if (f10246m == null) {
                f10246m = new HashMap<>(16);
            }
            f10246m.clear();
            f10246m.put("fe643c382e5c3b3962141f1a2e815a78", "FB923EE67A8B4032DAA517DD8CD7A26FF7C25B0C3663F92A0B61251C4FFFA858DF169D61321C3E7919CB67DF8EFEC827");
            f10246m.put("9a571aa113ad987d626c0457828962e6", "D2FF99A88BEB04683D89470D4FA72B1749DA456AB0D0F1A476477CE5A6874F53A9106423D905F9D808C0FCE8E7F1E04AC642F01FE41D0C7D933971F45CBA72B7");
            f10246m.put("668319f11506def6208d6afe320dfd52", "53E53D46011A6BBAEA4FAE5442E659E0577CDD336F930C28635C322FB3F51C3C63F7FBAC9EAE448DFA2E5E5D716C4807");
        } catch (Throwable th) {
            a(th, "CoreUtil", "initUrlHash");
        }
    }

    public static boolean a(double d6, double d7) {
        int i6 = (int) ((d7 - 73.0d) / 0.5d);
        int i7 = (int) ((d6 - 3.5d) / 0.5d);
        if (i7 < 0 || i7 >= 101 || i6 < 0 || i6 >= 124) {
            return false;
        }
        try {
            return "00000000000000000000000000000000000000000000000000000000000000000000000000000010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001100000001011000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011101010111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000110111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111101111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001000110111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011010111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001110011100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010001000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000110000001000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001010011100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111100110001000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111000111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111110011000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111000000000111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111100000000000010111110100000011000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111110000000001111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111111000000111111111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111101111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111111111111111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000101111111111111111111111111111111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000001111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000111111111111111111111111111111111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000001111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000011110000000001111111111111111111111111111111111111111111110000000000000000000000000000000000000000000000000000000000011000011111100000000111111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000001111111100111111111100110111111111111111111111111111111111111111111111110000000000000000000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000000101111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111011111000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100100000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100011100000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000111110000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110011111110000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110111111110000000000000000000000111011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000011111111111111111111111111111111111111111111111100001111111111111111111111111111111111111111111111111010000000000000000000000111111111111111111111111111111111111111111110000000000000001111111111111111111111111111111111111111111100000000000000000000011111111111111111111111111111111100000000000000000000000000001111111111111111111111111111111111111111110000000000000000000001111111111111111111111111111111100000000000000000000000000000001111111111111111111111111111111111111111000000000000000000000111111111111111111111111111111110000000000000000000000000000001111111111111111111111111111111111111111100000000000000000000111111111111111111111111111111000000000000000000000000000000000111111111111111111111111111111111111111111000000000000000000001111111111111111111111111110000000000000000000000000000000000001110011111111111111111111111111111111111111100000000000000000000011111111111111111100000000000000000000000000000000000000000000000001111111111111111111111111111111111111000000000000000000001111111111111111111000000000000000000000000000000000000000000000000011111111111111111111111111111111111100000000000000000000011111111111111111100000000000000000000000000000000000000000000000000011111111111111111111111111111111111000000000000000000001111111111111111100000000000000000000000000000000000000000000000000000000111111111111111111111111111111110000000000000000000000000111111111100000000000000000000000000000000000000000000000000111111111111111111111111111111111111111000000000000000000000000011111111100000000000000000000000000000000000000000000000000011111111111111111111111111111110001111100000000000000000000000000111110000000000000000000000000000000000000000000000000000001111111111111111111111111111111000000000000000000000000000000000001110000000000000000000000000000000000000000000000000000000011111111111111111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010110000000000000000000000".charAt((i7 * 124) + i6) == '1';
        } catch (Throwable th) {
            a(th, "CoreUtil", "isChina");
            return true;
        }
    }

    private static byte[] b(String str) {
        if (str != null && str.length() >= 2) {
            String lowerCase = str.toLowerCase(Locale.US);
            int length = lowerCase.length() / 2;
            byte[] bArr = new byte[length];
            for (int i6 = 0; i6 < length; i6++) {
                int i7 = i6 * 2;
                bArr[i6] = (byte) (j.f(lowerCase.substring(i7, i7 + 2)) & 255);
            }
            return bArr;
        }
        return new byte[0];
    }

    public static AMapLocation a(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        if (aMapLocation2 != null) {
            try {
                aMapLocation.setCountry(aMapLocation2.getCountry());
                aMapLocation.setRoad(aMapLocation2.getRoad());
                aMapLocation.setPoiName(aMapLocation2.getPoiName());
                aMapLocation.setStreet(aMapLocation2.getStreet());
                aMapLocation.setNumber(aMapLocation2.getStreetNum());
                String cityCode = aMapLocation2.getCityCode();
                String adCode = aMapLocation2.getAdCode();
                aMapLocation.setCityCode(cityCode);
                aMapLocation.setAdCode(adCode);
                aMapLocation.setCity(aMapLocation2.getCity());
                aMapLocation.setDistrict(aMapLocation2.getDistrict());
                aMapLocation.setProvince(aMapLocation2.getProvince());
                aMapLocation.setAoiName(aMapLocation2.getAoiName());
                aMapLocation.setAddress(aMapLocation2.getAddress());
                aMapLocation.setDescription(aMapLocation2.getDescription());
                if (aMapLocation.getExtras() != null) {
                    aMapLocation.getExtras().putString("citycode", aMapLocation2.getCityCode());
                    aMapLocation.getExtras().putString("desc", aMapLocation2.getExtras().getString("desc"));
                    aMapLocation.getExtras().putString("adcode", aMapLocation2.getAdCode());
                    return aMapLocation;
                }
                Bundle bundle = new Bundle();
                bundle.putString("citycode", aMapLocation2.getCityCode());
                bundle.putString("desc", aMapLocation2.getExtras().getString("desc"));
                bundle.putString("adcode", aMapLocation2.getAdCode());
                aMapLocation.setExtras(bundle);
            } catch (Throwable unused) {
            }
        }
        return aMapLocation;
    }

    public static void c(Context context) {
        try {
            if (q4.s(context)) {
                f10236c = "http://abroad.apilocate.amap.com/mobile/binary";
                f10237d = "http://abroad.apilocate.amap.com/mobile/binary";
            } else {
                f10236c = "http://apilocate.amap.com/mobile/binary";
                f10237d = "http://dualstack-a.apilocate.amap.com/mobile/binary";
            }
        } catch (Throwable th) {
            a(th, "CoreUtil", "changeUrl");
        }
    }

    public static String b(Context context) {
        return m4.d(f4.i(context));
    }

    public static void a(AMapLocation aMapLocation, JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                double optDouble = jSONObject.optDouble(com.umeng.analytics.pro.d.C, aMapLocation.getLatitude());
                double optDouble2 = jSONObject.optDouble("lon", aMapLocation.getLongitude());
                aMapLocation.setProvider(jSONObject.optString(com.umeng.analytics.pro.d.M, aMapLocation.getProvider()));
                aMapLocation.setLatitude(optDouble);
                aMapLocation.setLongitude(optDouble2);
                aMapLocation.setAltitude(jSONObject.optDouble("altitude", aMapLocation.getAltitude()));
                try {
                    String optString = jSONObject.optString("accuracy");
                    if (!TextUtils.isEmpty(optString)) {
                        aMapLocation.setAccuracy(Float.parseFloat(optString));
                    }
                } catch (Throwable unused) {
                }
                try {
                    String optString2 = jSONObject.optString("speed");
                    if (!TextUtils.isEmpty(optString2)) {
                        aMapLocation.setSpeed(Float.parseFloat(optString2));
                    }
                } catch (Throwable unused2) {
                }
                try {
                    String optString3 = jSONObject.optString("bearing");
                    if (!TextUtils.isEmpty(optString3)) {
                        aMapLocation.setBearing(Float.parseFloat(optString3));
                    }
                } catch (Throwable unused3) {
                }
                aMapLocation.setAdCode(jSONObject.optString("adcode", aMapLocation.getAdCode()));
                aMapLocation.setCityCode(jSONObject.optString("citycode", aMapLocation.getCityCode()));
                aMapLocation.setAddress(jSONObject.optString("address", aMapLocation.getAddress()));
                String optString4 = jSONObject.optString("desc", "");
                aMapLocation.setCountry(jSONObject.optString("country", aMapLocation.getCountry()));
                aMapLocation.setProvince(jSONObject.optString(DistrictSearchQuery.KEYWORDS_PROVINCE, aMapLocation.getProvince()));
                aMapLocation.setCity(jSONObject.optString(DistrictSearchQuery.KEYWORDS_CITY, aMapLocation.getCity()));
                aMapLocation.setDistrict(jSONObject.optString(DistrictSearchQuery.KEYWORDS_DISTRICT, aMapLocation.getDistrict()));
                aMapLocation.setRoad(jSONObject.optString("road", aMapLocation.getRoad()));
                aMapLocation.setStreet(jSONObject.optString("street", aMapLocation.getStreet()));
                aMapLocation.setNumber(jSONObject.optString("number", aMapLocation.getStreetNum()));
                aMapLocation.setPoiName(jSONObject.optString("poiname", aMapLocation.getPoiName()));
                aMapLocation.setAoiName(jSONObject.optString("aoiname", aMapLocation.getAoiName()));
                aMapLocation.setErrorCode(jSONObject.optInt("errorCode", aMapLocation.getErrorCode()));
                aMapLocation.setErrorInfo(jSONObject.optString(MyLocationStyle.ERROR_INFO, aMapLocation.getErrorInfo()));
                aMapLocation.setLocationType(jSONObject.optInt(MyLocationStyle.LOCATION_TYPE, aMapLocation.getLocationType()));
                aMapLocation.setLocationDetail(jSONObject.optString("locationDetail", aMapLocation.getLocationDetail()));
                aMapLocation.setTime(jSONObject.optLong("time", aMapLocation.getTime()));
                boolean optBoolean = jSONObject.optBoolean("isOffset", aMapLocation.isOffset());
                aMapLocation.setOffset(optBoolean);
                aMapLocation.setBuildingId(jSONObject.optString("poiid", aMapLocation.getBuildingId()));
                aMapLocation.setFloor(jSONObject.optString("floor", aMapLocation.getFloor()));
                aMapLocation.setDescription(jSONObject.optString(SocialConstants.PARAM_COMMENT, aMapLocation.getDescription()));
                if (jSONObject.has("coordType")) {
                    aMapLocation.setCoordType(jSONObject.optString("coordType", AMapLocation.COORD_TYPE_GCJ02));
                } else if (a(optDouble, optDouble2) && optBoolean) {
                    aMapLocation.setCoordType(AMapLocation.COORD_TYPE_GCJ02);
                } else {
                    aMapLocation.setCoordType(AMapLocation.COORD_TYPE_WGS84);
                }
                Bundle bundle = new Bundle();
                bundle.putString("citycode", aMapLocation.getCityCode());
                bundle.putString("desc", optString4.toString());
                bundle.putString("adcode", aMapLocation.getAdCode());
                aMapLocation.setExtras(bundle);
            } catch (Throwable th) {
                a(th, "CoreUtil", "transformLocation");
            }
        }
    }

    public static void a(Context context) {
        try {
            if (q4.s(context)) {
                f10236c = "http://abroad.apilocate.amap.com/mobile/binary";
                return;
            }
            f();
            String a6 = com.autonavi.aps.amapapi.security.a.a(f4.j(context));
            f10245l = a6;
            a(a6);
        } catch (Throwable th) {
            a(th, "CoreUtil", "checkUrl");
        }
    }

    private static void a(String str) {
        HashMap<String, String> hashMap;
        if (str != null) {
            try {
                if (str.length() != 0 && (hashMap = f10246m) != null && hashMap.containsKey(str)) {
                    String str2 = f10246m.get(str);
                    String str3 = (str2 == null || str2.length() <= 0) ? null : new String(com.autonavi.aps.amapapi.security.a.b(b(str2), str), "utf-8");
                    if (str3 == null || str3.length() <= 0 || !str3.contains("http:")) {
                        return;
                    }
                    f10238e = str3;
                    f10236c = str3;
                }
            } catch (Throwable th) {
                a(th, "CoreUtil", "checkUrl");
            }
        }
    }

    public static void a(Throwable th, String str, String str2) {
        if ("reportError".equals(str2) || (th instanceof fk)) {
            return;
        }
        try {
            v5.p(th, str, str2);
        } catch (Throwable unused) {
        }
    }

    public static Bundle a(AMapLocationClientOption aMapLocationClientOption) {
        Bundle bundle = new Bundle();
        if (aMapLocationClientOption == null) {
            aMapLocationClientOption = new AMapLocationClientOption();
        }
        try {
            bundle.putParcelable("opt", aMapLocationClientOption);
            return bundle;
        } catch (Throwable th) {
            a(th, "CoreUtil", "getOptionBundle");
            return bundle;
        }
    }

    public static AMapLocationClientOption a(Bundle bundle) {
        AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
        if (bundle == null) {
            return aMapLocationClientOption;
        }
        try {
            bundle.setClassLoader(AMapLocationClientOption.class.getClassLoader());
            return (AMapLocationClientOption) bundle.getParcelable("opt");
        } catch (Throwable th) {
            a(th, "CoreUtil", "getOptionFromBundle");
            return aMapLocationClientOption;
        }
    }

    public static boolean a(DPoint dPoint, List<DPoint> list) {
        double d6;
        double longitude = dPoint.getLongitude();
        double latitude = dPoint.getLatitude();
        double latitude2 = dPoint.getLatitude();
        if (!list.get(0).equals(list.get(list.size() - 1))) {
            list.add(list.get(0));
        }
        int i6 = 0;
        int i7 = 0;
        while (i6 < list.size() - 1) {
            double longitude2 = list.get(i6).getLongitude();
            double latitude3 = list.get(i6).getLatitude();
            int i8 = i6 + 1;
            double longitude3 = list.get(i8).getLongitude();
            double latitude4 = list.get(i8).getLatitude();
            double d7 = longitude;
            double d8 = latitude;
            longitude = d7;
            latitude = d8;
            if (a(d7, d8, longitude2, latitude3, longitude3, latitude4)) {
                return true;
            }
            if (Math.abs(latitude4 - latitude3) >= 1.0E-9d) {
                d6 = latitude2;
                if (a(longitude2, latitude3, longitude, latitude, 180.0d, d6)) {
                    if (latitude3 <= latitude4) {
                    }
                    i7++;
                } else if (a(longitude3, latitude4, longitude, latitude, 180.0d, d6)) {
                    if (latitude4 <= latitude3) {
                    }
                    i7++;
                } else {
                    boolean a6 = a(longitude2, latitude3, longitude3, latitude4, longitude, latitude, d6);
                    longitude = longitude;
                    latitude = latitude;
                    d6 = d6;
                    if (!a6) {
                    }
                    i7++;
                }
            } else {
                d6 = latitude2;
            }
            latitude2 = d6;
            i6 = i8;
        }
        return i7 % 2 != 0;
    }

    private static boolean a(double d6, double d7, double d8, double d9, double d10, double d11) {
        return Math.abs(b(d6, d7, d8, d9, d10, d11)) < 1.0E-9d && (d6 - d8) * (d6 - d10) <= 0.0d && (d7 - d9) * (d7 - d11) <= 0.0d;
    }
}
