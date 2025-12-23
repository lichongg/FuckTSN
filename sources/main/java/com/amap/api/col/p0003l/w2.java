package com.amap.api.col.p0003l;

import com.amap.api.maps.model.LatLng;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class w2 {
    private static double a(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        double d6 = latLng.latitude;
        double d7 = d6 - latLng3.latitude;
        double d8 = latLng.longitude;
        return ((d8 - latLng3.longitude) * (d6 - latLng2.latitude)) - ((d8 - latLng2.longitude) * d7);
    }

    public static boolean b(LatLng latLng, LatLng latLng2, LatLng latLng3, LatLng latLng4) {
        double a6 = a(latLng3, latLng4, latLng);
        double a7 = a(latLng3, latLng4, latLng2);
        double a8 = a(latLng, latLng2, latLng3);
        double a9 = a(latLng, latLng2, latLng4);
        if (((a6 > 0.0d && a7 < 0.0d) || (a6 < 0.0d && a7 > 0.0d)) && ((a8 > 0.0d && a9 < 0.0d) || (a8 < 0.0d && a9 > 0.0d))) {
            return true;
        }
        if (a6 == 0.0d && c(latLng3, latLng4, latLng)) {
            return true;
        }
        if (a7 == 0.0d && c(latLng3, latLng4, latLng2)) {
            return true;
        }
        if (a8 == 0.0d && c(latLng, latLng2, latLng3)) {
            return true;
        }
        return a9 == 0.0d && c(latLng, latLng2, latLng4);
    }

    private static boolean c(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        double d6 = latLng.longitude;
        double d7 = latLng2.longitude;
        double d8 = d6 - d7 > 0.0d ? d6 : d7;
        if (d6 - d7 >= 0.0d) {
            d6 = d7;
        }
        double d9 = latLng.latitude;
        double d10 = latLng2.latitude;
        double d11 = d9 - d10 > 0.0d ? d9 : d10;
        if (d9 - d10 >= 0.0d) {
            d9 = d10;
        }
        double d12 = latLng3.longitude;
        if (d6 > d12 || d12 > d8) {
            return false;
        }
        double d13 = latLng3.latitude;
        return d9 <= d13 && d13 <= d11;
    }
}
