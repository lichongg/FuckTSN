package com.amap.api.col.p0003l;

import android.text.TextUtils;
import com.amap.api.services.district.DistrictSearchQuery;
import com.umeng.analytics.pro.d;
import io.netty.handler.codec.http.HttpHeaders;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class c2 {

    /* renamed from: a, reason: collision with root package name */
    public static final int[][] f5797a = {new int[]{0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}, new int[]{12}, new int[]{1}, new int[]{13}, new int[]{14}, new int[]{15, 16}, new int[]{17, 18, 19, 20, 21, 26, 27, 28}, new int[]{22, 23}, new int[]{24, 25}, new int[]{39, 40, 41}, new int[]{29, 30, 31}, new int[]{32, 33, 34, 35, 36, 37, 38}};

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f5798b = {"land", "water", "green", "building", "highway", "arterial", "local", "railway", "subway", HttpHeaders.Values.BOUNDARY, "poilabel", "districtlable"};

    /* renamed from: c, reason: collision with root package name */
    public static final String[][] f5799c = {new String[]{"land", "edu", "public", d.F, "scenicSpot", "culture", "health", "sports", "business", "parkingLot", "subway"}, new String[]{"water"}, new String[]{"green"}, new String[]{"buildings"}, new String[]{"highWay"}, new String[]{"ringRoad", "nationalRoad"}, new String[]{"provincialRoad", "secondaryRoad", "levelThreeRoad", "levelFourRoad", "roadsBeingBuilt", "overPass", "underPass", "other"}, new String[]{"railway", "highSpeedRailway"}, new String[]{"subwayline", "subwayBeingBuilt"}, new String[]{"China", "foreign", "provincial"}, new String[]{"guideBoards", "pois", "aois"}, new String[]{"continent", "country", DistrictSearchQuery.KEYWORDS_PROVINCE, DistrictSearchQuery.KEYWORDS_CITY, DistrictSearchQuery.KEYWORDS_DISTRICT, "town", "village"}};

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f5800d = {"regions", "water", "regions", "buildings", "roads", "roads", "roads", "roads", "roads", "borders", "labels", "labels"};

    public static String[] a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int i6 = 0;
        while (true) {
            String[] strArr = f5798b;
            if (i6 < strArr.length) {
                if (strArr[i6].equals(str)) {
                    break;
                }
                i6++;
            } else {
                i6 = -1;
                break;
            }
        }
        if (i6 < 0) {
            return null;
        }
        return f5799c[i6];
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int i6 = 0;
        while (true) {
            String[] strArr = f5798b;
            if (i6 < strArr.length) {
                if (strArr[i6].equals(str)) {
                    break;
                }
                i6++;
            } else {
                i6 = -1;
                break;
            }
        }
        if (i6 < 0) {
            return null;
        }
        return f5800d[i6];
    }
}
