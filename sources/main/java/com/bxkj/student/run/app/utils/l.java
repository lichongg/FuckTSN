package com.bxkj.student.run.app.utils;

import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.bxkj.student.run.app.location.LatLngTimeSpeed;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class l {
    public static double c(Double[] x5) {
        int length = x5.length;
        double d6 = 0.0d;
        double d7 = 0.0d;
        for (Double d8 : x5) {
            d7 += d8.doubleValue();
        }
        double d9 = length;
        double d10 = d7 / d9;
        for (Double d11 : x5) {
            double doubleValue = d11.doubleValue() - d10;
            d6 += doubleValue * doubleValue;
        }
        return Math.sqrt(d6 / d9);
    }

    public static double d(double[] x5) {
        int length = x5.length;
        double d6 = 0.0d;
        double d7 = 0.0d;
        for (double d8 : x5) {
            d7 += d8;
        }
        double d9 = length;
        double d10 = d7 / d9;
        for (double d11 : x5) {
            double d12 = d11 - d10;
            d6 += d12 * d12;
        }
        return d6 / d9;
    }

    public static List<LatLngTimeSpeed> a(List<LatLngTimeSpeed> latLngTimeSpeedList) {
        float floatValue;
        double d6 = 0.0d;
        BigDecimal bigDecimal = new BigDecimal(0.0d);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i6 = 1; i6 < latLngTimeSpeedList.size(); i6++) {
            LatLngTimeSpeed latLngTimeSpeed = latLngTimeSpeedList.get(i6 - 1);
            arrayList2.add(latLngTimeSpeed);
            LatLngTimeSpeed latLngTimeSpeed2 = latLngTimeSpeedList.get(i6);
            double calculateLineDistance = AMapUtils.calculateLineDistance(new LatLng(latLngTimeSpeed.getLatitude(), latLngTimeSpeed.getLongitude()), new LatLng(latLngTimeSpeed2.getLatitude(), latLngTimeSpeed2.getLongitude()));
            arrayList.add(Double.valueOf(calculateLineDistance));
            latLngTimeSpeed2.getSpeed();
            if (i6 <= 5) {
                arrayList2.add(latLngTimeSpeed2);
                floatValue = bigDecimal.add(new BigDecimal(calculateLineDistance)).floatValue();
            } else if (calculateLineDistance <= b(arrayList.subList(i6 - 5, i6)) * 3.0d) {
                arrayList2.add(latLngTimeSpeed2);
                floatValue = bigDecimal.add(new BigDecimal(calculateLineDistance)).floatValue();
            }
            d6 += floatValue;
        }
        i.d(d6);
        return arrayList2;
    }

    private static double b(List<Double> distanceList) {
        Iterator<Double> it = distanceList.iterator();
        double d6 = 0.0d;
        while (it.hasNext()) {
            d6 += it.next().doubleValue();
        }
        return d6 / distanceList.size();
    }
}
