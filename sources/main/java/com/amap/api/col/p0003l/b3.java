package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.amap.api.col.p0003l.p4;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.BaseHoleOptions;
import com.amap.api.maps.model.CircleHoleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.PolygonHoleOptions;
import com.amap.api.maps.utils.SpatialRelationUtil;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import com.autonavi.amap.mapcore.interfaces.IMapConfig;
import com.autonavi.base.amap.mapcore.AeUtil;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.FileUtil;
import com.huawei.hms.framework.common.ContainerUtils;
import com.kuaishou.weapon.p0.t;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class b3 {

    /* renamed from: a, reason: collision with root package name */
    private static FPoint[] f5694a = {FPoint.obtain(), FPoint.obtain(), FPoint.obtain(), FPoint.obtain()};

    /* renamed from: b, reason: collision with root package name */
    private static List<Float> f5695b = new ArrayList(4);

    /* renamed from: c, reason: collision with root package name */
    private static List<Float> f5696c = new ArrayList(4);

    /* renamed from: d, reason: collision with root package name */
    private static int f5697d = 0;

    public static boolean F(double d6, LatLng latLng, CircleHoleOptions circleHoleOptions) {
        try {
            return ((double) AMapUtils.calculateLineDistance(circleHoleOptions.getCenter(), latLng)) <= d6 - circleHoleOptions.getRadius();
        } catch (Throwable th) {
            v5.p(th, "CircleDelegateImp", "isCircleInCircle");
            th.printStackTrace();
            return true;
        }
    }

    private static boolean G(double d6, LatLng latLng, List<BaseHoleOptions> list, LatLng latLng2) throws RemoteException {
        if (list != null && list.size() > 0) {
            Iterator<BaseHoleOptions> it = list.iterator();
            while (it.hasNext()) {
                if (K(it.next(), latLng2)) {
                    return false;
                }
            }
        }
        return d6 >= ((double) AMapUtils.calculateLineDistance(latLng, latLng2));
    }

    public static boolean H(double d6, LatLng latLng, List<BaseHoleOptions> list, PolygonHoleOptions polygonHoleOptions) {
        boolean z5 = true;
        try {
            List<LatLng> points = polygonHoleOptions.getPoints();
            for (int i6 = 0; i6 < points.size(); i6++) {
                z5 = G(d6, latLng, list, points.get(i6));
                if (!z5) {
                    return z5;
                }
            }
            return z5;
        } catch (Throwable th) {
            v5.p(th, "CircleDelegateImp", "isPolygonInCircle");
            th.printStackTrace();
            return z5;
        }
    }

    private static boolean L(CircleHoleOptions circleHoleOptions, CircleHoleOptions circleHoleOptions2) {
        try {
            return ((double) AMapUtils.calculateLineDistance(circleHoleOptions2.getCenter(), circleHoleOptions.getCenter())) < circleHoleOptions.getRadius() + circleHoleOptions2.getRadius();
        } catch (Throwable th) {
            v5.p(th, "Util", "isPolygon2CircleIntersect");
            th.printStackTrace();
            return false;
        }
    }

    public static boolean N(List<BaseHoleOptions> list, CircleHoleOptions circleHoleOptions) {
        boolean z5 = false;
        for (int i6 = 0; i6 < list.size(); i6++) {
            BaseHoleOptions baseHoleOptions = list.get(i6);
            if (baseHoleOptions instanceof PolygonHoleOptions) {
                z5 = a0(((PolygonHoleOptions) baseHoleOptions).getPoints(), circleHoleOptions);
                if (z5) {
                    return true;
                }
            } else if ((baseHoleOptions instanceof CircleHoleOptions) && (z5 = L(circleHoleOptions, (CircleHoleOptions) baseHoleOptions))) {
                return true;
            }
        }
        return z5;
    }

    public static boolean O(List<BaseHoleOptions> list, PolygonHoleOptions polygonHoleOptions) {
        boolean z5 = false;
        for (int i6 = 0; i6 < list.size(); i6++) {
            BaseHoleOptions baseHoleOptions = list.get(i6);
            if (baseHoleOptions instanceof PolygonHoleOptions) {
                z5 = P(((PolygonHoleOptions) baseHoleOptions).getPoints(), polygonHoleOptions.getPoints());
                if (z5) {
                    return true;
                }
            } else if (baseHoleOptions instanceof CircleHoleOptions) {
                z5 = a0(polygonHoleOptions.getPoints(), (CircleHoleOptions) baseHoleOptions);
                if (z5) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return z5;
    }

    private static boolean P(List<LatLng> list, List<LatLng> list2) {
        for (int i6 = 0; i6 < list2.size(); i6++) {
            try {
                if (M(list2.get(i6), list)) {
                    return true;
                }
            } catch (Throwable th) {
                v5.p(th, "Util", "isPolygon2PolygonIntersect");
                th.printStackTrace();
                return false;
            }
        }
        for (int i7 = 0; i7 < list.size(); i7++) {
            if (M(list.get(i7), list2)) {
                return true;
            }
        }
        return c0(list, list2);
    }

    private static boolean R(List<LatLng> list, List<BaseHoleOptions> list2, LatLng latLng) throws RemoteException {
        if (latLng == null) {
            return false;
        }
        if (list2 != null) {
            try {
                if (list2.size() > 0) {
                    Iterator<BaseHoleOptions> it = list2.iterator();
                    while (it.hasNext()) {
                        if (K(it.next(), latLng)) {
                            return false;
                        }
                    }
                }
            } catch (Throwable th) {
                v5.p(th, "PolygonDelegateImp", "contains");
                th.printStackTrace();
                return false;
            }
        }
        return M(latLng, list);
    }

    public static byte[] S(byte[] bArr, int i6) {
        return T(bArr, i6, i6, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002a, code lost:
    
        r2.setPixel(r5, r6, r9);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] T(byte[] r7, int r8, int r9, boolean r10) {
        /*
            int r0 = r7.length     // Catch: java.lang.Throwable -> L26
            r1 = 0
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeByteArray(r7, r1, r0)     // Catch: java.lang.Throwable -> L26
            android.graphics.Bitmap$Config r2 = r0.getConfig()     // Catch: java.lang.Throwable -> L26
            r3 = 1
            android.graphics.Bitmap r2 = r0.copy(r2, r3)     // Catch: java.lang.Throwable -> L26
            int r3 = r0.getWidth()     // Catch: java.lang.Throwable -> L26
            int r4 = r0.getHeight()     // Catch: java.lang.Throwable -> L26
            r5 = 0
        L18:
            if (r5 >= r3) goto L33
            r6 = 0
        L1b:
            if (r6 >= r4) goto L30
            if (r5 == 0) goto L28
            if (r6 != 0) goto L22
            goto L28
        L22:
            r2.setPixel(r5, r6, r8)     // Catch: java.lang.Throwable -> L26
            goto L2d
        L26:
            r8 = move-exception
            goto L41
        L28:
            if (r10 != 0) goto L2d
            r2.setPixel(r5, r6, r9)     // Catch: java.lang.Throwable -> L26
        L2d:
            int r6 = r6 + 1
            goto L1b
        L30:
            int r5 = r5 + 1
            goto L18
        L33:
            byte[] r8 = d0(r2)     // Catch: java.lang.Throwable -> L26
            if (r8 != 0) goto L3a
            r8 = r7
        L3a:
            B(r2)     // Catch: java.lang.Throwable -> L26
            B(r0)     // Catch: java.lang.Throwable -> L26
            return r8
        L41:
            r8.printStackTrace()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.b3.T(byte[], int, int, boolean):byte[]");
    }

    private static double a(double d6, double d7, double d8, double d9, double d10, double d11) {
        return ((d8 - d6) * (d11 - d7)) - ((d10 - d6) * (d9 - d7));
    }

    private static boolean a0(List<LatLng> list, CircleHoleOptions circleHoleOptions) {
        int i6;
        try {
            ArrayList arrayList = new ArrayList();
            for (int i7 = 0; i7 < list.size(); i7++) {
                arrayList.add(list.get(i7));
            }
            arrayList.add(list.get(0));
            ArrayList arrayList2 = new ArrayList();
            int i8 = 0;
            while (i8 < arrayList.size() && (i6 = i8 + 1) < arrayList.size()) {
                if (circleHoleOptions.getRadius() < AMapUtils.calculateLineDistance(circleHoleOptions.getCenter(), (LatLng) arrayList.get(i8)) && circleHoleOptions.getRadius() < AMapUtils.calculateLineDistance(circleHoleOptions.getCenter(), (LatLng) arrayList.get(i6))) {
                    arrayList2.clear();
                    arrayList2.add(arrayList.get(i8));
                    arrayList2.add(arrayList.get(i6));
                    if (circleHoleOptions.getRadius() >= AMapUtils.calculateLineDistance(circleHoleOptions.getCenter(), (LatLng) SpatialRelationUtil.calShortestDistancePoint(arrayList2, circleHoleOptions.getCenter()).second)) {
                        return true;
                    }
                    i8 = i6;
                }
                return true;
            }
        } catch (Throwable th) {
            v5.p(th, "Util", "isPolygon2CircleIntersect");
            th.printStackTrace();
        }
        return false;
    }

    private static double b(float f6, double d6, double d7) {
        return 20.0d - (Math.log(d7 / (d6 * f6)) / Math.log(2.0d));
    }

    public static boolean b0(List<LatLng> list, PolygonHoleOptions polygonHoleOptions) {
        boolean z5 = false;
        z5 = false;
        z5 = false;
        if (list != null && polygonHoleOptions != null) {
            try {
                List<LatLng> points = polygonHoleOptions.getPoints();
                boolean z6 = false;
                for (int i6 = 0; i6 < points.size(); i6++) {
                    try {
                        z6 = M(points.get(i6), list);
                        if (!z6) {
                            return z6;
                        }
                    } catch (Throwable th) {
                        th = th;
                        z5 = z6;
                        v5.p(th, "PolygonDelegateImp", "isPolygonInPolygon");
                        th.printStackTrace();
                        return z5;
                    }
                }
                return z6;
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return z5;
    }

    private static boolean c0(List<LatLng> list, List<LatLng> list2) {
        int i6;
        int i7;
        int i8 = 0;
        while (i8 < list.size() && (i6 = i8 + 1) < list.size()) {
            try {
                int i9 = 0;
                while (i9 < list2.size() && (i7 = i9 + 1) < list2.size()) {
                    boolean b6 = w2.b(list.get(i8), list.get(i6), list2.get(i9), list2.get(i7));
                    if (b6) {
                        return b6;
                    }
                    i9 = i7;
                }
                i8 = i6;
            } catch (Throwable th) {
                v5.p(th, "Util", "isSegmentsIntersect");
                th.printStackTrace();
            }
        }
        return false;
    }

    private static float d(float f6, float f7, float f8) {
        return (float) (f8 * Math.pow(2.0d, 20.0f - f7) * f6);
    }

    private static byte[] d0(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (Throwable unused) {
            byteArrayOutputStream = null;
        }
        try {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
                return byteArray;
            } catch (Throwable th) {
                th.printStackTrace();
                return byteArray;
            }
        } catch (Throwable unused2) {
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            return null;
        }
    }

    public static boolean h0(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        NetworkInfo.State state;
        return (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || (state = activeNetworkInfo.getState()) == null || state == NetworkInfo.State.DISCONNECTED || state == NetworkInfo.State.DISCONNECTING) ? false : true;
    }

    public static float i(IMapConfig iMapConfig, float f6, float f7) {
        boolean z5;
        if (iMapConfig != null) {
            boolean isAbroadEnable = iMapConfig.isAbroadEnable();
            z5 = iMapConfig.getAbroadState() != 1;
            r0 = isAbroadEnable;
        } else {
            z5 = false;
        }
        float f8 = f6 >= 0.0f ? f6 : 0.0f;
        if (r0 && z5) {
            if (f8 > 40.0f) {
                return 40.0f;
            }
        } else if (iMapConfig == null || !iMapConfig.isTerrainEnable()) {
            if (f6 > 40.0f) {
                float f9 = f7 <= 15.0f ? 40 : f7 <= 16.0f ? 56 : f7 <= 17.0f ? 66 : f7 <= 18.0f ? 74 : f7 <= 18.0f ? 78 : 80;
                if (f8 > f9) {
                    return f9;
                }
            }
        } else if (f8 > 80.0f) {
            return 80.0f;
        }
        return f8;
    }

    public static Bitmap n(View view) {
        try {
            g0(view);
            view.destroyDrawingCache();
            view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            Bitmap drawingCache = view.getDrawingCache();
            if (drawingCache != null) {
                return drawingCache.copy(Bitmap.Config.ARGB_8888, false);
            }
            return null;
        } catch (Throwable th) {
            v5.p(th, "Utils", "getBitmapFromView");
            th.printStackTrace();
            return null;
        }
    }

    public static Bitmap o(int[] iArr, int i6, int i7) {
        return p(iArr, i6, i7, false);
    }

    public static Bitmap p(int[] iArr, int i6, int i7, boolean z5) {
        try {
            int[] iArr2 = new int[iArr.length];
            for (int i8 = 0; i8 < i7; i8++) {
                for (int i9 = 0; i9 < i6; i9++) {
                    int i10 = (i8 * i6) + i9;
                    int i11 = iArr[i10];
                    int i12 = (i11 & (-16711936)) | ((i11 << 16) & 16711680) | ((i11 >> 16) & 255);
                    if (z5) {
                        iArr2[(((i7 - i8) - 1) * i6) + i9] = i12;
                    } else {
                        iArr2[i10] = i12;
                    }
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(i6, i7, Bitmap.Config.ARGB_8888);
            createBitmap.setPixels(iArr2, 0, i6, 0, 0, i6, i7);
            return createBitmap;
        } catch (Throwable th) {
            v5.p(th, "Util", "rgbaToArgb");
            th.printStackTrace();
            return null;
        }
    }

    public static String A(String... strArr) {
        StringBuilder sb = new StringBuilder();
        int i6 = 0;
        for (String str : strArr) {
            sb.append(str);
            if (i6 != strArr.length - 1) {
                sb.append(",");
            }
            i6++;
        }
        return sb.toString();
    }

    public static void C(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    private static boolean E(double d6, double d7, double d8, double d9, double d10, double d11, double d12) {
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

    public static boolean I(int i6, int i7) {
        return i6 > 0 && i7 > 0;
    }

    public static boolean K(BaseHoleOptions baseHoleOptions, LatLng latLng) {
        if (baseHoleOptions instanceof CircleHoleOptions) {
            CircleHoleOptions circleHoleOptions = (CircleHoleOptions) baseHoleOptions;
            LatLng center = circleHoleOptions.getCenter();
            return center != null && ((double) AMapUtils.calculateLineDistance(center, latLng)) <= circleHoleOptions.getRadius();
        }
        List<LatLng> points = ((PolygonHoleOptions) baseHoleOptions).getPoints();
        if (points == null || points.size() == 0) {
            return false;
        }
        return M(latLng, points);
    }

    public static boolean M(LatLng latLng, List<LatLng> list) {
        boolean z5;
        if (latLng == null || list == null) {
            return false;
        }
        double d6 = latLng.longitude;
        double d7 = latLng.latitude;
        if (list.size() < 3) {
            return false;
        }
        if (list.get(0).equals(list.get(list.size() - 1))) {
            z5 = false;
        } else {
            list.add(list.get(0));
            z5 = true;
        }
        int i6 = 0;
        int i7 = 0;
        while (i6 < list.size() - 1) {
            try {
                double d8 = list.get(i6).longitude;
                double d9 = list.get(i6).latitude;
                i6++;
                double d10 = list.get(i6).longitude;
                double d11 = list.get(i6).latitude;
                double d12 = d6;
                double d13 = d7;
                d6 = d12;
                d7 = d13;
                if (Z(d12, d13, d8, d9, d10, d11)) {
                    if (z5) {
                        list.remove(list.size() - 1);
                    }
                    return true;
                }
                if (Math.abs(d11 - d9) >= 1.0E-9d) {
                    if (Z(d8, d9, d6, d7, 180.0d, d7)) {
                        if (d9 > d11) {
                            i7++;
                        }
                    } else if (!Z(d10, d11, d6, d7, 180.0d, d7)) {
                        boolean E = E(d8, d9, d10, d11, d6, d7, d7);
                        d6 = d6;
                        d7 = d7;
                        if (E) {
                            i7++;
                        }
                    } else if (d11 > d9) {
                        i7++;
                    }
                }
            } catch (Throwable th) {
                if (z5) {
                    list.remove(list.size() - 1);
                }
                throw th;
            }
        }
        boolean z6 = i7 % 2 != 0;
        if (z5) {
            list.remove(list.size() - 1);
        }
        return z6;
    }

    public static synchronized int[] U(int i6, int i7, int i8, int i9, IMapConfig iMapConfig, IGLMapState iGLMapState, int i10, int i11) {
        int[] iArr;
        synchronized (b3.class) {
            int mapWidth = iMapConfig.getMapWidth();
            int mapHeight = iMapConfig.getMapHeight();
            int anchorX = iMapConfig.getAnchorX();
            int anchorY = iMapConfig.getAnchorY();
            iArr = new int[]{(int) Math.max(i8 + d(iMapConfig.getMapZoomScale(), iGLMapState.getMapZoomer(), anchorX), Math.min(i10, i6 - d(iMapConfig.getMapZoomScale(), iGLMapState.getMapZoomer(), mapWidth - anchorX))), (int) Math.max(i7 + d(iMapConfig.getMapZoomScale(), iGLMapState.getMapZoomer(), anchorY), Math.min(i11, i9 - d(iMapConfig.getMapZoomScale(), iGLMapState.getMapZoomer(), mapHeight - anchorY)))};
        }
        return iArr;
    }

    public static synchronized int V() {
        int i6;
        synchronized (b3.class) {
            try {
                int i7 = f5697d + 1;
                f5697d = i7;
                if (i7 == Integer.MAX_VALUE) {
                    f5697d = 0;
                }
                i6 = f5697d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return i6;
    }

    public static String X(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(FileUtil.getMapBaseStorage(context));
        String str = File.separator;
        sb.append(str);
        sb.append("data");
        sb.append(str);
        return sb.toString();
    }

    public static String Y(View view) {
        StringBuilder sb = new StringBuilder();
        if (view != null) {
            try {
                if (view instanceof TextView) {
                    sb = new StringBuilder(((TextView) view).getText().toString());
                }
                if (view instanceof ViewGroup) {
                    int childCount = ((ViewGroup) view).getChildCount();
                    for (int i6 = 0; i6 < childCount; i6++) {
                        String Y = Y(((ViewGroup) view).getChildAt(i6));
                        if (!TextUtils.isEmpty(Y)) {
                            sb.append("--");
                            sb.append(Y);
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return sb.toString();
    }

    private static float c(float f6, float f7, double d6) {
        return (float) (d6 / (Math.pow(2.0d, 20.0f - f7) * f6));
    }

    private static byte[] e0(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[2048];
        while (true) {
            int read = inputStream.read(bArr, 0, 2048);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    private static float f(IGLMapState iGLMapState, int i6, int i7, int i8, int i9, int i10) {
        if (iGLMapState != null) {
            return iGLMapState.calculateMapZoomer(i6, i7, i8, i9, i10);
        }
        return 3.0f;
    }

    public static float g(DPoint dPoint, DPoint dPoint2) {
        if (dPoint == null || dPoint2 == null) {
            return 0.0f;
        }
        double d6 = dPoint.f9903x;
        double d7 = dPoint2.f9903x;
        return (float) ((Math.atan2(dPoint2.f9904y - dPoint.f9904y, d7 - d6) / 3.141592653589793d) * 180.0d);
    }

    private static void g0(View view) {
        int i6 = 0;
        if (!(view instanceof ViewGroup)) {
            if (view instanceof TextView) {
                ((TextView) view).setHorizontallyScrolling(false);
            }
        } else {
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i6 >= viewGroup.getChildCount()) {
                    return;
                }
                g0(viewGroup.getChildAt(i6));
                i6++;
            }
        }
    }

    public static float h(IMapConfig iMapConfig, float f6) {
        if (iMapConfig != null) {
            if (f6 > iMapConfig.getMaxZoomLevel()) {
                return iMapConfig.getMaxZoomLevel();
            }
            if (f6 < iMapConfig.getMinZoomLevel()) {
                return iMapConfig.getMinZoomLevel();
            }
        } else {
            if (f6 > 20.0f) {
                return 20.0f;
            }
            if (f6 < 3.0f) {
                return 3.0f;
            }
        }
        return f6;
    }

    public static boolean i0(Context context) {
        File file = new File(X(context));
        if (file.exists()) {
            return FileUtil.deleteFile(file);
        }
        return true;
    }

    public static Bitmap m(Bitmap bitmap, float f6) {
        if (bitmap == null) {
            return null;
        }
        return Bitmap.createScaledBitmap(bitmap, (int) (bitmap.getWidth() * f6), (int) (bitmap.getHeight() * f6), true);
    }

    public static Pair<Float, IPoint> q(AbstractCameraUpdateMessage abstractCameraUpdateMessage, IMapConfig iMapConfig) {
        return r(iMapConfig, Math.max(abstractCameraUpdateMessage.paddingLeft, 1), Math.max(abstractCameraUpdateMessage.paddingRight, 1), Math.max(abstractCameraUpdateMessage.paddingTop, 1), Math.max(abstractCameraUpdateMessage.paddingBottom, 1), abstractCameraUpdateMessage.bounds, abstractCameraUpdateMessage.width, abstractCameraUpdateMessage.height);
    }

    public static Pair<Float, IPoint> r(IMapConfig iMapConfig, int i6, int i7, int i8, int i9, LatLngBounds latLngBounds, int i10, int i11) {
        LatLng latLng;
        int i12;
        float f6;
        float f7;
        int i13;
        if (latLngBounds == null || (latLng = latLngBounds.northeast) == null || latLngBounds.southwest == null || iMapConfig == null) {
            return null;
        }
        Point latLongToPixels = VirtualEarthProjection.latLongToPixels(latLng.latitude, latLng.longitude, 20);
        LatLng latLng2 = latLngBounds.southwest;
        Point latLongToPixels2 = VirtualEarthProjection.latLongToPixels(latLng2.latitude, latLng2.longitude, 20);
        int i14 = latLongToPixels.x;
        int i15 = latLongToPixels2.x;
        int i16 = i14 - i15;
        int i17 = latLongToPixels2.y;
        int i18 = latLongToPixels.y;
        int i19 = i17 - i18;
        int i20 = i10 - (i6 + i7);
        int i21 = i11 - (i8 + i9);
        if (i16 < 0 && i19 < 0) {
            return null;
        }
        if (i16 <= 0) {
            i16 = 1;
        }
        int i22 = i19 <= 0 ? 1 : i19;
        if (i20 <= 0) {
            i20 = 1;
        }
        if (i21 <= 0) {
            i21 = 1;
        }
        Pair<Float, Boolean> W = W(iMapConfig, i14, i18, i15, i17, i20, i21);
        Float f8 = (Float) W.first;
        float floatValue = f8.floatValue();
        boolean booleanValue = ((Boolean) W.second).booleanValue();
        float c6 = c(iMapConfig.getMapZoomScale(), floatValue, i16);
        float c7 = c(iMapConfig.getMapZoomScale(), floatValue, i22);
        if (floatValue >= iMapConfig.getMaxZoomLevel()) {
            i12 = (int) (latLongToPixels2.x + ((((i7 - i6) + c6) * i16) / (c6 * 2.0f)));
            i13 = latLongToPixels.y;
        } else {
            if (!booleanValue) {
                i12 = (int) (latLongToPixels2.x + ((((i7 - i6) + c6) * i16) / (c6 * 2.0f)));
                f6 = latLongToPixels.y;
                f7 = (((i11 / 2) - i8) / c7) * i22;
                return new Pair<>(f8, IPoint.obtain((int) (i12 + d(iMapConfig.getMapZoomScale(), floatValue, iMapConfig.getAnchorX() - (iMapConfig.getMapWidth() >> 1))), (int) (((int) (f6 + f7)) + d(iMapConfig.getMapZoomScale(), floatValue, iMapConfig.getAnchorY() - (iMapConfig.getMapHeight() >> 1)))));
            }
            i12 = (int) (latLongToPixels2.x + ((((i10 / 2) - i6) / c6) * i16));
            i13 = latLongToPixels.y;
        }
        f6 = i13;
        f7 = (((i9 - i8) + c7) * i22) / (c7 * 2.0f);
        return new Pair<>(f8, IPoint.obtain((int) (i12 + d(iMapConfig.getMapZoomScale(), floatValue, iMapConfig.getAnchorX() - (iMapConfig.getMapWidth() >> 1))), (int) (((int) (f6 + f7)) + d(iMapConfig.getMapZoomScale(), floatValue, iMapConfig.getAnchorY() - (iMapConfig.getMapHeight() >> 1)))));
    }

    public static p4 s() {
        try {
            if (ga.f6368e == null) {
                ga.f6368e = new p4.a("3dmap", "10.0.600", ga.f6366c).b(new String[]{"com.amap.api.maps", "com.amap.api.mapcore", "com.autonavi.amap.mapcore", "com.autonavi.amap", "com.autonavi.ae", "com.autonavi.base", "com.autonavi.patch", "com.amap.api.3dmap.admic", "com.amap.api.trace", "com.amap.api.trace.core"}).a("10.0.600").c();
            }
            return ga.f6368e;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static DPoint t(LatLng latLng) {
        double d6 = (latLng.longitude / 360.0d) + 0.5d;
        double sin = Math.sin(Math.toRadians(latLng.latitude));
        return DPoint.obtain(d6 * 1.0d, (((Math.log((sin + 1.0d) / (1.0d - sin)) * 0.5d) / (-6.283185307179586d)) + 0.5d) * 1.0d);
    }

    public static String u(int i6) {
        if (i6 < 1000) {
            return i6 + t.f36152m;
        }
        return (i6 / 1000) + "km";
    }

    public static String v(Context context) {
        File file = new File(FileUtil.getMapBaseStorage(context), AeUtil.ROOT_DATA_PATH_NAME);
        if (!file.exists()) {
            file.mkdir();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(file.toString());
        String str = File.separator;
        sb.append(str);
        File file2 = new File(sb.toString());
        if (!file2.exists()) {
            file2.mkdir();
        }
        return file.toString() + str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ac, code lost:
    
        if (r7 != null) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x009e, code lost:
    
        if (r7 == null) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0087, code lost:
    
        if (r7 != null) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0079, code lost:
    
        if (r7 == null) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x00d6, code lost:
    
        if (r7 == 0) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x00c2, code lost:
    
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x00c6, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x00c7, code lost:
    
        r7.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x00c0, code lost:
    
        if (r7 == 0) goto L100;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00b6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v25 */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.io.BufferedReader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String w(java.io.File r7) {
        /*
            Method dump skipped, instructions count: 218
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.b3.w(java.io.File):java.lang.String");
    }

    public static String x(InputStream inputStream) {
        try {
            return new String(e0(inputStream), "utf-8");
        } catch (Throwable th) {
            v5.p(th, "Util", "decodeAssetResData");
            th.printStackTrace();
            return null;
        }
    }

    public static String z(String str, Object obj) {
        return str + ContainerUtils.KEY_VALUE_DELIMITER + String.valueOf(obj);
    }

    public static void D(Throwable th) {
        try {
            if (MapsInitializer.getExceptionLogger() != null) {
                MapsInitializer.getExceptionLogger().onException(th);
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean J(Rect rect, int i6, int i7) {
        return rect.contains(i6, i7);
    }

    public static boolean Q(List<LatLng> list, List<BaseHoleOptions> list2, CircleHoleOptions circleHoleOptions) {
        try {
            if (!a0(list, circleHoleOptions)) {
                if (R(list, list2, circleHoleOptions.getCenter())) {
                    return true;
                }
                return false;
            }
            return false;
        } catch (Throwable th) {
            v5.p(th, "PolygonDelegateImp", "isCircleInPolygon");
            th.printStackTrace();
            return false;
        }
    }

    private static Pair<Float, Boolean> W(IMapConfig iMapConfig, int i6, int i7, int i8, int i9, int i10, int i11) {
        float min;
        iMapConfig.getSZ();
        boolean z5 = true;
        if (i6 == i8 && i7 == i9) {
            min = iMapConfig.getMaxZoomLevel();
        } else {
            float b6 = (float) b(iMapConfig.getMapZoomScale(), i11, Math.abs(i9 - i7));
            float b7 = (float) b(iMapConfig.getMapZoomScale(), i10, Math.abs(i8 - i6));
            float min2 = Math.min(b7, b6);
            if (min2 != b7) {
                z5 = false;
            }
            min = Math.min(iMapConfig.getMaxZoomLevel(), Math.max(iMapConfig.getMinZoomLevel(), min2));
        }
        return new Pair<>(Float.valueOf(min), Boolean.valueOf(z5));
    }

    private static boolean Z(double d6, double d7, double d8, double d9, double d10, double d11) {
        if (Math.abs(a(d6, d7, d8, d9, d10, d11)) < 1.0E-9d && (d6 - d8) * (d6 - d10) <= 0.0d && (d7 - d9) * (d7 - d11) <= 0.0d) {
            return true;
        }
        return false;
    }

    public static float e(IGLMapState iGLMapState, int i6, int i7, double d6, double d7, int i8) {
        IPoint obtain = IPoint.obtain();
        VirtualEarthProjection.latLongToPixels(d6, d7, 20, obtain);
        float f6 = f(iGLMapState, i6, i7, ((Point) obtain).x, ((Point) obtain).y, i8);
        obtain.recycle();
        return f6;
    }

    public static String f0(Context context) {
        String v5 = v(context);
        if (v5 == null) {
            return null;
        }
        File file = new File(v5, "VMAP2");
        if (!file.exists()) {
            file.mkdir();
        }
        return file.toString() + File.separator;
    }

    public static float j(IMapConfig iMapConfig, int i6, int i7, int i8, int i9, int i10, int i11) {
        float sz = iMapConfig.getSZ();
        if (i6 != i8 && i7 != i9) {
            return Math.max((float) b(iMapConfig.getMapZoomScale(), i10, Math.abs(i8 - i6)), (float) b(iMapConfig.getMapZoomScale(), i11, Math.abs(i9 - i7)));
        }
        return sz;
    }

    public static int k(Object[] objArr) {
        return Arrays.hashCode(objArr);
    }

    public static Bitmap l(Context context, String str) {
        try {
            InputStream open = v2.b(context).open(str);
            Bitmap decodeStream = BitmapFactory.decodeStream(open);
            open.close();
            return decodeStream;
        } catch (Throwable th) {
            v5.p(th, "Util", "fromAsset");
            D(th);
            return null;
        }
    }

    public static String y(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                Uri parse = Uri.parse(str);
                if (parse.getAuthority() == null || !parse.getAuthority().startsWith("dualstack-")) {
                    if (parse.getAuthority() != null && parse.getAuthority().startsWith("restsdk.amap.com")) {
                        return parse.buildUpon().authority("dualstack-arestapi.amap.com").build().toString();
                    }
                    return parse.buildUpon().authority("dualstack-" + parse.getAuthority()).build().toString();
                }
                return str;
            } catch (Throwable unused) {
                return str;
            }
        }
        return str;
    }

    public static void B(Bitmap bitmap) {
    }
}
