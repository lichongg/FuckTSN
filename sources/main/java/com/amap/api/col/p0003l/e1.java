package com.amap.api.col.p0003l;

import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.acse.ottn.adapter.AutoScrollViewPager;
import com.amap.api.fence.DistrictItem;
import com.amap.api.fence.GeoFence;
import com.amap.api.fence.PoiItem;
import com.amap.api.location.DPoint;
import com.autonavi.aps.amapapi.utils.j;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class e1 {

    /* renamed from: a, reason: collision with root package name */
    private static long f5932a;

    public static int b(String str, List<GeoFence> list, Bundle bundle) {
        JSONArray optJSONArray;
        int i6;
        try {
            JSONObject jSONObject = new JSONObject(str);
            char c6 = 0;
            int optInt = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS, 0);
            int optInt2 = jSONObject.optInt("infocode", 0);
            if (optInt == 1 && (optJSONArray = jSONObject.optJSONArray("pois")) != null) {
                int i7 = 0;
                while (i7 < optJSONArray.length()) {
                    GeoFence geoFence = new GeoFence();
                    PoiItem poiItem = new PoiItem();
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i7);
                    poiItem.setPoiId(jSONObject2.optString("id"));
                    poiItem.setPoiName(jSONObject2.optString(CommonNetImpl.NAME));
                    poiItem.setPoiType(jSONObject2.optString("type"));
                    poiItem.setTypeCode(jSONObject2.optString("typecode"));
                    poiItem.setAddress(jSONObject2.optString("address"));
                    String optString = jSONObject2.optString(SocializeConstants.KEY_LOCATION);
                    if (optString != null) {
                        String[] split = optString.split(",");
                        poiItem.setLongitude(Double.parseDouble(split[c6]));
                        poiItem.setLatitude(Double.parseDouble(split[1]));
                        List<List<DPoint>> arrayList = new ArrayList<>();
                        ArrayList arrayList2 = new ArrayList();
                        i6 = optInt2;
                        DPoint dPoint = new DPoint(poiItem.getLatitude(), poiItem.getLongitude());
                        arrayList2.add(dPoint);
                        arrayList.add(arrayList2);
                        geoFence.setPointList(arrayList);
                        geoFence.setCenter(dPoint);
                    } else {
                        i6 = optInt2;
                    }
                    poiItem.setTel(jSONObject2.optString("tel"));
                    poiItem.setProvince(jSONObject2.optString("pname"));
                    poiItem.setCity(jSONObject2.optString("cityname"));
                    poiItem.setAdname(jSONObject2.optString("adname"));
                    geoFence.setPoiItem(poiItem);
                    StringBuilder sb = new StringBuilder();
                    sb.append(c());
                    geoFence.setFenceId(sb.toString());
                    if (bundle != null) {
                        geoFence.setCustomId(bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID));
                        geoFence.setPendingIntentAction(bundle.getString("pendingIntentAction"));
                        geoFence.setType(2);
                        geoFence.setRadius(bundle.getFloat("fenceRadius"));
                        geoFence.setExpiration(bundle.getLong("expiration"));
                        geoFence.setActivatesAction(bundle.getInt("activatesAction", 1));
                    }
                    if (list != null) {
                        list.add(geoFence);
                    }
                    i7++;
                    optInt2 = i6;
                    c6 = 0;
                }
            }
            return optInt2;
        } catch (Throwable unused) {
            return 5;
        }
    }

    public static synchronized long c() {
        long j6;
        synchronized (e1.class) {
            try {
                long b6 = j.b();
                long j7 = f5932a;
                if (b6 > j7) {
                    f5932a = b6;
                } else {
                    f5932a = j7 + 1;
                }
                j6 = f5932a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return j6;
    }

    private List<DPoint> d(List<DPoint> list, float f6) {
        if (list == null) {
            return null;
        }
        if (list.size() <= 2) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        DPoint dPoint = list.get(0);
        DPoint dPoint2 = list.get(list.size() - 1);
        double d6 = 0.0d;
        int i6 = 0;
        for (int i7 = 1; i7 < list.size() - 1; i7++) {
            double a6 = a(list.get(i7), dPoint, dPoint2);
            if (a6 > d6) {
                i6 = i7;
                d6 = a6;
            }
        }
        if (d6 < f6) {
            arrayList.add(dPoint);
            arrayList.add(dPoint2);
            return arrayList;
        }
        List<DPoint> d7 = d(list.subList(0, i6 + 1), f6);
        List<DPoint> d8 = d(list.subList(i6, list.size()), f6);
        arrayList.addAll(d7);
        arrayList.remove(arrayList.size() - 1);
        arrayList.addAll(d8);
        return arrayList;
    }

    public final int f(String str, List<GeoFence> list, Bundle bundle) {
        JSONArray optJSONArray;
        ArrayList arrayList;
        String str2;
        int i6;
        String str3;
        String str4;
        float f6;
        long j6;
        float f7;
        long j7;
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS, 0);
            int optInt2 = jSONObject.optInt("infocode", 0);
            String string = bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID);
            String string2 = bundle.getString("pendingIntentAction");
            float f8 = bundle.getFloat("fenceRadius");
            long j8 = bundle.getLong("expiration");
            int i7 = bundle.getInt("activatesAction", 1);
            if (optInt == 1 && (optJSONArray = jSONObject.optJSONArray("districts")) != null) {
                int i8 = 0;
                while (i8 < optJSONArray.length()) {
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    GeoFence geoFence = new GeoFence();
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i8);
                    String optString = jSONObject2.optString("citycode");
                    String optString2 = jSONObject2.optString("adcode");
                    String optString3 = jSONObject2.optString(CommonNetImpl.NAME);
                    JSONArray jSONArray = optJSONArray;
                    String string3 = jSONObject2.getString(AutoScrollViewPager.f4187g);
                    int i9 = i8;
                    DPoint dPoint = new DPoint();
                    int i10 = optInt2;
                    if (string3 != null) {
                        String[] split = string3.split(",");
                        arrayList = arrayList2;
                        str2 = optString3;
                        dPoint.setLatitude(Double.parseDouble(split[1]));
                        dPoint.setLongitude(Double.parseDouble(split[0]));
                        geoFence.setCenter(dPoint);
                    } else {
                        arrayList = arrayList2;
                        str2 = optString3;
                    }
                    geoFence.setCustomId(string);
                    geoFence.setPendingIntentAction(string2);
                    geoFence.setType(3);
                    geoFence.setRadius(f8);
                    geoFence.setExpiration(j8);
                    geoFence.setActivatesAction(i7);
                    StringBuilder sb = new StringBuilder();
                    sb.append(c());
                    geoFence.setFenceId(sb.toString());
                    String optString4 = jSONObject2.optString("polyline");
                    if (optString4 != null) {
                        String[] split2 = optString4.split("\\|");
                        int length = split2.length;
                        float f9 = Float.MIN_VALUE;
                        float f10 = Float.MAX_VALUE;
                        i6 = i7;
                        int i11 = 0;
                        while (i11 < length) {
                            int i12 = i11;
                            String str5 = split2[i12];
                            String[] strArr = split2;
                            DistrictItem districtItem = new DistrictItem();
                            String str6 = string;
                            List<DPoint> arrayList4 = new ArrayList<>();
                            districtItem.setCitycode(optString);
                            districtItem.setAdcode(optString2);
                            String str7 = optString2;
                            String str8 = str2;
                            districtItem.setDistrictName(str8);
                            str2 = str8;
                            String[] split3 = str5.split(";");
                            String str9 = string2;
                            int i13 = 0;
                            while (i13 < split3.length) {
                                String[] split4 = split3[i13].split(",");
                                String[] strArr2 = split3;
                                int i14 = i13;
                                if (split4.length > 1) {
                                    f7 = f8;
                                    j7 = j8;
                                    arrayList4.add(new DPoint(Double.parseDouble(split4[1]), Double.parseDouble(split4[0])));
                                } else {
                                    f7 = f8;
                                    j7 = j8;
                                }
                                i13 = i14 + 1;
                                split3 = strArr2;
                                f8 = f7;
                                j8 = j7;
                            }
                            float f11 = f8;
                            long j9 = j8;
                            if (arrayList4.size() > 100.0f) {
                                try {
                                    arrayList4 = d(arrayList4, 100.0f);
                                } catch (Throwable unused) {
                                    return 5;
                                }
                            }
                            arrayList3.add(arrayList4);
                            districtItem.setPolyline(arrayList4);
                            ArrayList arrayList5 = arrayList;
                            arrayList5.add(districtItem);
                            f9 = Math.max(f9, a.A(dPoint, arrayList4));
                            f10 = Math.min(f10, a.b(dPoint, arrayList4));
                            i11 = i12 + 1;
                            arrayList = arrayList5;
                            split2 = strArr;
                            string = str6;
                            optString2 = str7;
                            string2 = str9;
                            f8 = f11;
                            j8 = j9;
                        }
                        str3 = string;
                        str4 = string2;
                        f6 = f8;
                        j6 = j8;
                        geoFence.setMaxDis2Center(f9);
                        geoFence.setMinDis2Center(f10);
                        geoFence.setDistrictItemList(arrayList);
                        geoFence.setPointList(arrayList3);
                        list.add(geoFence);
                    } else {
                        i6 = i7;
                        str3 = string;
                        str4 = string2;
                        f6 = f8;
                        j6 = j8;
                    }
                    i8 = i9 + 1;
                    optJSONArray = jSONArray;
                    optInt2 = i10;
                    i7 = i6;
                    string = str3;
                    string2 = str4;
                    f8 = f6;
                    j8 = j6;
                }
            }
            return optInt2;
        } catch (Throwable unused2) {
            return 5;
        }
    }

    private static double a(DPoint dPoint, DPoint dPoint2, DPoint dPoint3) {
        boolean z5;
        double longitude;
        double latitude;
        double longitude2 = dPoint.getLongitude() - dPoint2.getLongitude();
        double latitude2 = dPoint.getLatitude() - dPoint2.getLatitude();
        double longitude3 = dPoint3.getLongitude() - dPoint2.getLongitude();
        double latitude3 = dPoint3.getLatitude() - dPoint2.getLatitude();
        double d6 = ((longitude2 * longitude3) + (latitude2 * latitude3)) / ((longitude3 * longitude3) + (latitude3 * latitude3));
        if (dPoint2.getLongitude() == dPoint3.getLongitude() && dPoint2.getLatitude() == dPoint3.getLatitude()) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (d6 >= 0.0d && !z5) {
            if (d6 > 1.0d) {
                longitude = dPoint3.getLongitude();
                latitude = dPoint3.getLatitude();
            } else {
                double longitude4 = dPoint2.getLongitude() + (longitude3 * d6);
                latitude = dPoint2.getLatitude() + (d6 * latitude3);
                longitude = longitude4;
            }
        } else {
            longitude = dPoint2.getLongitude();
            latitude = dPoint2.getLatitude();
        }
        return j.a(new DPoint(dPoint.getLatitude(), dPoint.getLongitude()), new DPoint(latitude, longitude));
    }

    public static int e(String str, List<GeoFence> list, Bundle bundle) {
        return b(str, list, bundle);
    }
}
