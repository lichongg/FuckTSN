package com.amap.api.maps;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.amap.api.col.p0003l.f4;
import com.amap.api.col.p0003l.fk;
import com.amap.api.col.p0003l.g4;
import com.amap.api.col.p0003l.ga;
import com.amap.api.col.p0003l.p4;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.NaviPara;
import com.amap.api.maps.model.PoiPara;
import com.amap.api.maps.model.RoutePara;
import com.stub.StubApp;
import java.util.List;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class AMapUtils {
    private static final String AMAPNAVIURL = "androidamap://navi?sourceApplication=%s&lat=%f&lon=%f&dev=0&style=%d";
    private static final String AMAPPOISEARCHURL = "androidamap://arroundpoi?sourceApplication=%s&keywords=%s&dev=0";
    private static final String AMAPROUTEURL = "androidamap://route?sourceApplication=%s&slat=%f&slon=%f&sname=%s&dlat=%f&dlon=%f&dname=%s&dev=0&t=%d";
    public static final int BUS_COMFORT = 4;
    public static final int BUS_MONEY_LITTLE = 1;
    public static final int BUS_NO_SUBWAY = 5;
    public static final int BUS_TIME_FIRST = 0;
    public static final int BUS_TRANSFER_LITTLE = 2;
    public static final int BUS_WALK_LITTLE = 3;
    private static final double DEG_TO_RAD = 0.017453292519943295d;
    private static final int DRING_ROUTE_MODEL = 2;
    public static final int DRIVING_AVOID_CONGESTION = 4;
    public static final int DRIVING_DEFAULT = 0;
    public static final int DRIVING_NO_HIGHWAY = 3;
    public static final int DRIVING_NO_HIGHWAY_AVOID_CONGESTION = 6;
    public static final int DRIVING_NO_HIGHWAY_AVOID_SHORT_MONEY = 5;
    public static final int DRIVING_NO_HIGHWAY_SAVE_MONEY_AVOID_CONGESTION = 8;
    public static final int DRIVING_SAVE_MONEY = 1;
    public static final int DRIVING_SAVE_MONEY_AVOID_CONGESTION = 7;
    public static final int DRIVING_SHORT_DISTANCE = 2;
    private static final double EARTHRADIUS = 6378137.0d;
    private static final double NF_PI = 0.01745329251994329d;
    private static final double R = 6378137.0d;
    private static final int TRANSIT_ROUTE_MODEL = 1;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a extends Thread {

        /* renamed from: a, reason: collision with root package name */
        String f8947a;

        /* renamed from: b, reason: collision with root package name */
        Context f8948b;

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            if (this.f8948b != null) {
                try {
                    g4.c(this.f8948b, new p4.a(this.f8947a, "10.0.600", ga.f6366c).b(new String[]{"com.amap.api.maps"}).c(), "", null);
                    interrupt();
                } catch (fk e6) {
                    e6.printStackTrace();
                }
            }
        }

        public a(String str, Context context) {
            this.f8947a = str;
            if (context != null) {
                this.f8948b = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
        }
    }

    private static void a(RoutePara routePara, Context context, int i6) throws AMapException {
        if (!a(routePara)) {
            throw new AMapException(AMapException.ILLEGAL_AMAP_ARGUMENT);
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(276824064);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setData(Uri.parse(b(routePara, context, i6)));
        intent.setPackage("com.autonavi.minimap");
        new a("oan", context).start();
        context.startActivity(intent);
    }

    public static float calculateArea(LatLng latLng, LatLng latLng2) {
        if (latLng == null || latLng2 == null) {
            try {
                throw new AMapException(AMapException.ERROR_ILLEGAL_VALUE);
            } catch (AMapException e6) {
                e6.printStackTrace();
                return 0.0f;
            }
        }
        try {
            double sin = Math.sin((latLng.latitude * 3.141592653589793d) / 180.0d) - Math.sin((latLng2.latitude * 3.141592653589793d) / 180.0d);
            double d6 = (latLng2.longitude - latLng.longitude) / 360.0d;
            if (d6 < 0.0d) {
                d6 += 1.0d;
            }
            return (float) (sin * 2.5560394669790553E14d * d6);
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public static void openAMapDrivingRoute(RoutePara routePara, Context context) throws AMapException {
        a(routePara, context, 2);
    }

    public static void openAMapTransitRoute(RoutePara routePara, Context context) throws AMapException {
        a(routePara, context, 1);
    }

    public static void openAMapWalkingRoute(RoutePara routePara, Context context) throws AMapException {
        a(routePara, context, 4);
    }

    private static String b(RoutePara routePara, Context context, int i6) {
        String format = String.format(Locale.US, AMAPROUTEURL, f4.e(context), Double.valueOf(routePara.getStartPoint().latitude), Double.valueOf(routePara.getStartPoint().longitude), routePara.getStartName(), Double.valueOf(routePara.getEndPoint().latitude), Double.valueOf(routePara.getEndPoint().longitude), routePara.getEndName(), Integer.valueOf(i6));
        if (i6 == 1) {
            return format + "&m=" + routePara.getTransitRouteStyle();
        }
        if (i6 != 2) {
            return format;
        }
        return format + "&m=" + routePara.getDrivingRouteStyle();
    }

    public static float calculateLineDistance(LatLng latLng, LatLng latLng2) {
        if (latLng == null || latLng2 == null) {
            try {
                throw new AMapException(AMapException.ERROR_ILLEGAL_VALUE);
            } catch (AMapException e6) {
                e6.printStackTrace();
                return 0.0f;
            }
        }
        try {
            double d6 = latLng.longitude;
            double d7 = latLng.latitude;
            double d8 = latLng2.longitude;
            double d9 = latLng2.latitude;
            double d10 = d6 * NF_PI;
            double d11 = d7 * NF_PI;
            double d12 = d8 * NF_PI;
            double d13 = d9 * NF_PI;
            double sin = Math.sin(d10);
            double sin2 = Math.sin(d11);
            double cos = Math.cos(d10);
            double cos2 = Math.cos(d11);
            double sin3 = Math.sin(d12);
            double sin4 = Math.sin(d13);
            double cos3 = Math.cos(d12);
            double cos4 = Math.cos(d13);
            double[] dArr = {cos * cos2, cos2 * sin, sin2};
            double[] dArr2 = {cos3 * cos4, cos4 * sin3, sin4};
            double d14 = dArr[0];
            double d15 = dArr2[0];
            double d16 = (d14 - d15) * (d14 - d15);
            double d17 = dArr[1];
            double d18 = dArr2[1];
            double d19 = d16 + ((d17 - d18) * (d17 - d18));
            double d20 = dArr[2];
            double d21 = dArr2[2];
            return (float) (Math.asin(Math.sqrt(d19 + ((d20 - d21) * (d20 - d21))) / 2.0d) * 1.27420015798544E7d);
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public static void getLatestAMapApp(Context context) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(276824064);
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setData(Uri.parse("http://wap.amap.com/"));
            new a("glaa", context).start();
            context.startActivity(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void openAMapNavi(NaviPara naviPara, Context context) throws AMapException {
        if (naviPara.getTargetPoint() != null) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(276824064);
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setData(Uri.parse(a(naviPara, context)));
            intent.setPackage("com.autonavi.minimap");
            new a("oan", context).start();
            context.startActivity(intent);
            return;
        }
        throw new AMapException(AMapException.ILLEGAL_AMAP_ARGUMENT);
    }

    public static void openAMapPoiNearbySearch(PoiPara poiPara, Context context) throws AMapException {
        if (poiPara.getKeywords() != null && poiPara.getKeywords().trim().length() > 0) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(276824064);
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setData(Uri.parse(a(poiPara, context)));
            intent.setPackage("com.autonavi.minimap");
            new a("oan", context).start();
            context.startActivity(intent);
            return;
        }
        throw new AMapException(AMapException.ILLEGAL_AMAP_ARGUMENT);
    }

    public static float calculateArea(List<LatLng> list) {
        if (list == null || list.size() < 3) {
            return 0.0f;
        }
        int size = list.size();
        double d6 = 0.0d;
        int i6 = 0;
        while (i6 < size) {
            LatLng latLng = list.get(i6);
            i6++;
            LatLng latLng2 = list.get(i6 % size);
            double cos = latLng.longitude * 111319.49079327357d * Math.cos(latLng.latitude * 0.017453292519943295d);
            double d7 = latLng.latitude * 111319.49079327357d;
            d6 += (cos * (latLng2.latitude * 111319.49079327357d)) - (((latLng2.longitude * 111319.49079327357d) * Math.cos(latLng2.latitude * 0.017453292519943295d)) * d7);
        }
        return Math.abs((float) (d6 / 2.0d));
    }

    private static boolean a(RoutePara routePara) {
        return (routePara.getStartPoint() == null || routePara.getEndPoint() == null || routePara.getStartName() == null || routePara.getStartName().trim().length() <= 0 || routePara.getEndName() == null || routePara.getEndName().trim().length() <= 0) ? false : true;
    }

    private static String a(NaviPara naviPara, Context context) {
        return String.format(Locale.US, AMAPNAVIURL, f4.e(context), Double.valueOf(naviPara.getTargetPoint().latitude), Double.valueOf(naviPara.getTargetPoint().longitude), Integer.valueOf(naviPara.getNaviStyle()));
    }

    private static String a(PoiPara poiPara, Context context) {
        String format = String.format(Locale.US, AMAPPOISEARCHURL, f4.e(context), poiPara.getKeywords());
        if (poiPara.getCenter() == null) {
            return format;
        }
        return format + "&lat=" + poiPara.getCenter().latitude + "&lon=" + poiPara.getCenter().longitude;
    }
}
