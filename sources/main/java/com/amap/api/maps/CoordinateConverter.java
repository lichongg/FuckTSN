package com.amap.api.maps;

import android.content.Context;
import com.amap.api.col.p0003l.q;
import com.amap.api.col.p0003l.u2;
import com.amap.api.col.p0003l.v5;
import com.amap.api.col.p0003l.y2;
import com.amap.api.maps.model.LatLng;
import com.amap.api.services.geocoder.GeocodeSearch;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class CoordinateConverter {
    private static final String TAG = "CoordinateConverter";
    private Context ctx;
    private CoordType coordType = null;
    private LatLng sourceLatLng = null;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum CoordType {
        BAIDU,
        MAPBAR,
        GPS,
        MAPABC,
        SOSOMAP,
        ALIYUN,
        GOOGLE
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.amap.api.maps.CoordinateConverter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f8950a;

        static {
            int[] iArr = new int[CoordType.values().length];
            f8950a = iArr;
            try {
                iArr[CoordType.BAIDU.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8950a[CoordType.MAPBAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8950a[CoordType.MAPABC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8950a[CoordType.SOSOMAP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8950a[CoordType.ALIYUN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f8950a[CoordType.GOOGLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f8950a[CoordType.GPS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public LatLng convert() {
        CoordType coordType = this.coordType;
        LatLng latLng = null;
        if (coordType == null || this.sourceLatLng == null) {
            return null;
        }
        try {
            String str = "";
            switch (AnonymousClass1.f8950a[coordType.ordinal()]) {
                case 1:
                    latLng = q.d(this.sourceLatLng);
                    str = "baidu";
                    break;
                case 2:
                    latLng = q.i(this.ctx, this.sourceLatLng);
                    str = "mapbar";
                    break;
                case 3:
                    str = "mapabc";
                    latLng = this.sourceLatLng;
                    break;
                case 4:
                    str = "sosomap";
                    latLng = this.sourceLatLng;
                    break;
                case 5:
                    str = "aliyun";
                    latLng = this.sourceLatLng;
                    break;
                case 6:
                    str = "google";
                    latLng = this.sourceLatLng;
                    break;
                case 7:
                    str = GeocodeSearch.GPS;
                    latLng = q.c(this.ctx, this.sourceLatLng);
                    break;
            }
            y2.h(this.ctx, str);
            return latLng;
        } catch (Throwable th) {
            th.printStackTrace();
            v5.p(th, TAG, "convert");
            return this.sourceLatLng;
        }
    }

    public CoordinateConverter coord(LatLng latLng) {
        this.sourceLatLng = latLng;
        return this;
    }

    public CoordinateConverter from(CoordType coordType) {
        this.coordType = coordType;
        return this;
    }

    public CoordinateConverter(Context context) {
        this.ctx = context;
    }

    public static boolean isAMapDataAvailable(double d6, double d7) {
        return u2.a(d6, d7);
    }
}
