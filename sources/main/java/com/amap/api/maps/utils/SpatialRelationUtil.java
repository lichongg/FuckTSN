package com.amap.api.maps.utils;

import android.util.Pair;
import com.amap.api.col.p0003l.b3;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.DPoint;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class SpatialRelationUtil {
    public static final int A_CIRCLE_DEGREE = 360;
    public static final int A_HALF_CIRCLE_DEGREE = 180;
    public static final int MIN_OFFSET_DEGREE = 50;
    public static final int MIN_POLYLINE_POINT_SIZE = 2;

    public static Pair<Integer, LatLng> calShortestDistancePoint(List<LatLng> list, LatLng latLng, float f6, double d6) {
        if (list != null && latLng != null) {
            try {
                if (list.size() != 0) {
                    ArrayList arrayList = new ArrayList();
                    int i6 = 0;
                    for (LatLng latLng2 : list) {
                        arrayList.add(DPoint.obtain(latLng2.latitude, latLng2.longitude));
                        if (latLng2.equals(latLng)) {
                            return new Pair<>(Integer.valueOf(i6), latLng);
                        }
                        i6++;
                    }
                    Pair<Integer, DPoint> calShortestDistancePoint = calShortestDistancePoint(arrayList, DPoint.obtain(latLng.latitude, latLng.longitude), f6);
                    if (calShortestDistancePoint != null) {
                        DPoint dPoint = (DPoint) calShortestDistancePoint.second;
                        if (AMapUtils.calculateLineDistance(new LatLng(dPoint.f9903x, dPoint.f9904y), latLng) < d6) {
                            Object obj = calShortestDistancePoint.first;
                            Object obj2 = calShortestDistancePoint.second;
                            return new Pair<>(obj, new LatLng(((DPoint) obj2).f9903x, ((DPoint) obj2).f9904y));
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    private static boolean checkRotateIsMatch(DPoint dPoint, DPoint dPoint2, float f6) {
        if (f6 == -1.0f) {
            return true;
        }
        if (dPoint != null && dPoint2 != null) {
            float abs = Math.abs((b3.g(dPoint, dPoint2) + 360.0f) - f6) % 360.0f;
            if (abs > 180.0f) {
                abs = 360.0f - abs;
            }
            if (abs < 50.0f) {
                return true;
            }
        }
        return false;
    }

    private static Pair<Double, DPoint> pointToSegDist(double d6, double d7, double d8, double d9, double d10, double d11) {
        double d12 = d10 - d8;
        double d13 = d6 - d8;
        double d14 = d11 - d9;
        double d15 = d7 - d9;
        double d16 = (d12 * d13) + (d14 * d15);
        if (d16 <= 0.0d) {
            return new Pair<>(Double.valueOf(Math.sqrt((d13 * d13) + (d15 * d15))), new DPoint(d8, d9));
        }
        double d17 = (d12 * d12) + (d14 * d14);
        if (d16 >= d17) {
            double d18 = d6 - d10;
            double d19 = d7 - d11;
            return new Pair<>(Double.valueOf(Math.sqrt((d18 * d18) + (d19 * d19))), new DPoint(d10, d11));
        }
        double d20 = d16 / d17;
        double d21 = d8 + (d12 * d20);
        double d22 = d9 + (d14 * d20);
        double d23 = d6 - d21;
        double d24 = d22 - d7;
        return new Pair<>(Double.valueOf(Math.sqrt((d23 * d23) + (d24 * d24))), new DPoint(d21, d22));
    }

    public static Pair<Integer, LatLng> calShortestDistancePoint(List<LatLng> list, LatLng latLng) {
        if (list != null && latLng != null) {
            try {
                if (list.size() != 0) {
                    ArrayList arrayList = new ArrayList();
                    int i6 = 0;
                    for (LatLng latLng2 : list) {
                        arrayList.add(DPoint.obtain(latLng2.latitude, latLng2.longitude));
                        if (latLng2.equals(latLng)) {
                            return new Pair<>(Integer.valueOf(i6), latLng);
                        }
                        i6++;
                    }
                    Pair<Integer, DPoint> calShortestDistancePoint = calShortestDistancePoint(arrayList, DPoint.obtain(latLng.latitude, latLng.longitude));
                    if (calShortestDistancePoint != null) {
                        Object obj = calShortestDistancePoint.first;
                        Object obj2 = calShortestDistancePoint.second;
                        return new Pair<>(obj, new LatLng(((DPoint) obj2).f9903x, ((DPoint) obj2).f9904y));
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    public static Pair<Integer, DPoint> calShortestDistancePoint(List<DPoint> list, DPoint dPoint) {
        return calShortestDistancePoint(list, dPoint, -1.0f);
    }

    public static Pair<Integer, DPoint> calShortestDistancePoint(List<DPoint> list, DPoint dPoint, float f6) {
        double d6;
        int i6;
        double doubleValue;
        Pair<Integer, DPoint> pair;
        List<DPoint> list2 = list;
        DPoint dPoint2 = dPoint;
        Pair<Integer, DPoint> pair2 = null;
        if (list2 != null && dPoint2 != null && list2.size() != 0) {
            if (list2.size() >= 2) {
                DPoint dPoint3 = list2.get(0);
                int size = list2.size();
                int i7 = 1;
                double d7 = 0.0d;
                int i8 = 1;
                while (true) {
                    int i9 = size - 1;
                    if (i8 > i9) {
                        break;
                    }
                    DPoint dPoint4 = list2.get(i8);
                    if (i8 == i9 && dPoint4.equals(dPoint2)) {
                        return new Pair<>(Integer.valueOf(i8), dPoint2);
                    }
                    if (!checkRotateIsMatch(dPoint3, dPoint4, f6)) {
                        d6 = d7;
                        i6 = i8;
                    } else {
                        if (dPoint3.equals(dPoint2)) {
                            return new Pair<>(Integer.valueOf(i8 - i7), dPoint2);
                        }
                        d6 = d7;
                        i6 = i8;
                        Pair<Double, DPoint> pointToSegDist = pointToSegDist(dPoint2.f9903x, dPoint2.f9904y, dPoint3.f9903x, dPoint3.f9904y, dPoint4.f9903x, dPoint4.f9904y);
                        if (pair2 == null) {
                            doubleValue = ((Double) pointToSegDist.first).doubleValue();
                            pair = new Pair<>(Integer.valueOf(i6 - 1), pointToSegDist.second);
                        } else if (d6 > ((Double) pointToSegDist.first).doubleValue()) {
                            doubleValue = ((Double) pointToSegDist.first).doubleValue();
                            pair = new Pair<>(Integer.valueOf(i6 - 1), pointToSegDist.second);
                        }
                        d7 = doubleValue;
                        pair2 = pair;
                        i8 = i6 + 1;
                        list2 = list;
                        dPoint2 = dPoint;
                        dPoint3 = dPoint4;
                        i7 = 1;
                    }
                    d7 = d6;
                    i8 = i6 + 1;
                    list2 = list;
                    dPoint2 = dPoint;
                    dPoint3 = dPoint4;
                    i7 = 1;
                }
            } else {
                return null;
            }
        }
        return pair2;
    }
}
