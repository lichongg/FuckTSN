package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.BaseHoleOptions;
import com.amap.api.maps.model.BaseOptions;
import com.amap.api.maps.model.BaseOverlay;
import com.amap.api.maps.model.BasePointOverlay;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.GLTFOverlay;
import com.amap.api.maps.model.ImageOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MultiPointItem;
import com.amap.api.maps.model.MultiPointOverlay;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.maps.model.amap3dmodeltile.AMap3DModelTileProvider;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.base.ae.gmap.AMapAppRequestParam;
import com.autonavi.base.ae.gmap.AMapAppResourceItem;
import com.autonavi.base.ae.gmap.bean.MultiPointItemHitTest;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer;
import com.autonavi.base.amap.mapcore.FPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class c implements IGlOverlayLayer, AMapNativeGlOverlayLayer.NativeFunCallListener {

    /* renamed from: a, reason: collision with root package name */
    IAMapDelegate f5752a;

    /* renamed from: b, reason: collision with root package name */
    private Context f5753b;

    /* renamed from: g, reason: collision with root package name */
    private r1 f5758g;

    /* renamed from: c, reason: collision with root package name */
    private int f5754c = 0;

    /* renamed from: d, reason: collision with root package name */
    private final Object f5755d = new Object();

    /* renamed from: f, reason: collision with root package name */
    private final Map<String, BaseOverlay> f5757f = new ConcurrentHashMap();

    /* renamed from: h, reason: collision with root package name */
    private BitmapDescriptor f5759h = null;

    /* renamed from: i, reason: collision with root package name */
    private BitmapDescriptor f5760i = null;

    /* renamed from: j, reason: collision with root package name */
    private BitmapDescriptor f5761j = null;

    /* renamed from: k, reason: collision with root package name */
    private BitmapDescriptor f5762k = null;

    /* renamed from: l, reason: collision with root package name */
    private BitmapDescriptor f5763l = null;

    /* renamed from: m, reason: collision with root package name */
    private BitmapDescriptor f5764m = null;

    /* renamed from: n, reason: collision with root package name */
    private BitmapDescriptor f5765n = null;

    /* renamed from: o, reason: collision with root package name */
    private BitmapDescriptor f5766o = null;

    /* renamed from: p, reason: collision with root package name */
    boolean f5767p = false;

    /* renamed from: q, reason: collision with root package name */
    List<String> f5768q = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private AMapNativeGlOverlayLayer f5756e = new AMapNativeGlOverlayLayer();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a extends b8 {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AMapAppRequestParam f5769d;

        a(AMapAppRequestParam aMapAppRequestParam) {
            this.f5769d = aMapAppRequestParam;
        }

        @Override // com.amap.api.col.p0003l.b8
        public final void runTask() {
            try {
                byte[] makeHttpRequestWithInterrupted = new AMap3DModelTileProvider.AMap3DModelRequest(this.f5769d.getUrl()).makeHttpRequestWithInterrupted();
                AMapAppResourceItem aMapAppResourceItem = new AMapAppResourceItem();
                aMapAppResourceItem.setData(makeHttpRequestWithInterrupted);
                aMapAppResourceItem.setSize(makeHttpRequestWithInterrupted.length);
                aMapAppResourceItem.setResourceType(this.f5769d.getResourceType());
                this.f5769d.getCallback().callSuccess(aMapAppResourceItem);
            } catch (Exception e6) {
                e6.printStackTrace();
                this.f5769d.getCallback().callFailed(e6.getMessage());
            }
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final boolean IsCircleContainPoint(CircleOptions circleOptions, LatLng latLng) {
        if (latLng != null && circleOptions != null) {
            try {
                synchronized (circleOptions) {
                    try {
                        List<BaseHoleOptions> holeOptions = circleOptions.getHoleOptions();
                        if (holeOptions != null && holeOptions.size() > 0) {
                            Iterator<BaseHoleOptions> it = holeOptions.iterator();
                            while (it.hasNext()) {
                                if (b3.K(it.next(), latLng)) {
                                    return false;
                                }
                            }
                        }
                        return circleOptions.getRadius() >= ((double) AMapUtils.calculateLineDistance(circleOptions.getCenter(), latLng));
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final boolean IsPolygonContainsPoint(PolygonOptions polygonOptions, LatLng latLng) {
        if (latLng == null) {
            return false;
        }
        try {
            List<BaseHoleOptions> holeOptions = polygonOptions.getHoleOptions();
            if (holeOptions != null && holeOptions.size() > 0) {
                Iterator<BaseHoleOptions> it = holeOptions.iterator();
                while (it.hasNext()) {
                    if (b3.K(it.next(), latLng)) {
                        return false;
                    }
                }
            }
            return b3.M(latLng, polygonOptions.getPoints());
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final synchronized void clear(String... strArr) {
        int i6;
        try {
            AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f5756e;
            if (aMapNativeGlOverlayLayer != null && strArr != null) {
                aMapNativeGlOverlayLayer.clear(strArr);
            }
            synchronized (this.f5757f) {
                try {
                    if (strArr != null) {
                        Iterator<Map.Entry<String, BaseOverlay>> it = this.f5757f.entrySet().iterator();
                        while (it.hasNext()) {
                            Map.Entry<String, BaseOverlay> next = it.next();
                            int length = strArr.length;
                            while (true) {
                                if (i6 >= length) {
                                    it.remove();
                                    break;
                                } else {
                                    String str = strArr[i6];
                                    i6 = (str == null || !str.equals(next.getKey())) ? i6 + 1 : 0;
                                }
                            }
                        }
                    } else {
                        this.f5757f.clear();
                    }
                } finally {
                }
            }
        } catch (Throwable th) {
            v5.p(th, "GlOverlayLayer", "clear");
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final synchronized void destroy() {
        try {
            if (this.f5756e == null) {
                return;
            }
            synchronized (this.f5757f) {
                this.f5757f.clear();
            }
            this.f5756e.clear("");
            this.f5756e.destroy();
            this.f5756e = null;
        } catch (Throwable th) {
            v5.p(th, "GlOverlayLayer", "destroy");
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final synchronized boolean draw(int i6, int i7, boolean z5) {
        boolean z6 = false;
        try {
            r1 r1Var = this.f5758g;
            if (r1Var != null) {
                r1Var.a();
            }
        } finally {
            return z6;
        }
        if (this.f5752a.getMapConfig() == null) {
            return false;
        }
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f5756e;
        if (aMapNativeGlOverlayLayer != null) {
            aMapNativeGlOverlayLayer.render(i6, i7, z5);
        }
        z6 = true;
        return z6;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final synchronized BaseOverlay getHitBaseOverlay(LatLng latLng, int i6) {
        BaseOverlay baseOverlay;
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f5756e;
        if (aMapNativeGlOverlayLayer == null) {
            return null;
        }
        String contain = aMapNativeGlOverlayLayer.contain(latLng, i6);
        if (TextUtils.isEmpty(contain)) {
            return null;
        }
        synchronized (this.f5757f) {
            baseOverlay = this.f5757f.get(contain);
        }
        return baseOverlay;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final synchronized Polyline getHitOverlay(LatLng latLng, int i6) {
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f5756e;
        if (aMapNativeGlOverlayLayer != null) {
            String contain = aMapNativeGlOverlayLayer.contain(latLng, i6);
            if (TextUtils.isEmpty(contain)) {
                return null;
            }
            synchronized (this.f5757f) {
                try {
                    BaseOverlay baseOverlay = this.f5757f.get(contain);
                    r1 = baseOverlay instanceof Polyline ? (Polyline) baseOverlay : null;
                } finally {
                }
            }
        }
        return r1;
    }

    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final BitmapDescriptor getInfoWindowClick(String str) {
        return null;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final LatLng getNearestLatLng(PolylineOptions polylineOptions, LatLng latLng) {
        List<LatLng> points;
        if (latLng != null && polylineOptions != null && (points = polylineOptions.getPoints()) != null && points.size() != 0) {
            int i6 = 0;
            float f6 = 0.0f;
            for (int i7 = 0; i7 < points.size(); i7++) {
                try {
                    if (i7 == 0) {
                        f6 = AMapUtils.calculateLineDistance(latLng, points.get(i7));
                    } else {
                        float calculateLineDistance = AMapUtils.calculateLineDistance(latLng, points.get(i7));
                        if (f6 > calculateLineDistance) {
                            i6 = i7;
                            f6 = calculateLineDistance;
                        }
                    }
                } catch (Throwable th) {
                    v5.p(th, "PolylineDelegate", "getNearestLatLng");
                    th.printStackTrace();
                }
            }
            return points.get(i6);
        }
        return null;
    }

    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final BitmapDescriptor getOverturnInfoWindow(String str) {
        return null;
    }

    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final BitmapDescriptor getOverturnInfoWindowClick(String str) {
        return null;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final boolean removeOverlay(String str, boolean z5) {
        return false;
    }

    private BitmapDescriptor a(View view) {
        if (view == null) {
            return null;
        }
        if ((view instanceof RelativeLayout) && this.f5753b != null) {
            LinearLayout linearLayout = new LinearLayout(this.f5753b);
            linearLayout.setOrientation(1);
            linearLayout.addView(view);
            view = linearLayout;
        }
        view.setDrawingCacheEnabled(true);
        view.setDrawingCacheQuality(0);
        return BitmapDescriptorFactory.fromBitmap(b3.n(view));
    }

    private void b(String str, BaseOptions baseOptions) {
        try {
            this.f5756e.createOverlay(str, baseOptions);
        } catch (Throwable th) {
            v5.p(th, "GlOverlayLayer", "addOverlay");
            th.printStackTrace();
            th.getMessage();
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final boolean checkInBounds(String str) {
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f5756e;
        if (aMapNativeGlOverlayLayer != null) {
            Object nativeProperties = aMapNativeGlOverlayLayer.getNativeProperties(str, "checkInBounds", new Object[]{str});
            if (nativeProperties instanceof Boolean) {
                return ((Boolean) nativeProperties).booleanValue();
            }
        }
        return true;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void clearOverlayByType(String str) {
        synchronized (this.f5757f) {
            try {
                ArrayList arrayList = new ArrayList();
                Iterator<Map.Entry<String, BaseOverlay>> it = this.f5757f.entrySet().iterator();
                while (it.hasNext()) {
                    String key = it.next().getKey();
                    if (key.contains(str)) {
                        it.remove();
                        arrayList.add(key);
                    }
                }
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    removeOverlay((String) it2.next());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void clearTileCache() {
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f5756e;
        if (aMapNativeGlOverlayLayer != null) {
            aMapNativeGlOverlayLayer.getNativeProperties("", "clearTileCache", null);
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final String createId(String str) {
        String str2;
        synchronized (this.f5755d) {
            this.f5754c++;
            str2 = str + this.f5754c;
        }
        return str2;
    }

    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final BitmapDescriptor getBuildInImageData(int i6) {
        try {
            switch (i6) {
                case 0:
                    BitmapDescriptor bitmapDescriptor = this.f5759h;
                    if (bitmapDescriptor == null || bitmapDescriptor.getBitmap().isRecycled()) {
                        this.f5759h = BitmapDescriptorFactory.fromBitmap(b3.l(this.f5753b, "amap_sdk_lineTexture.png"));
                    }
                    return this.f5759h;
                case 1:
                    BitmapDescriptor bitmapDescriptor2 = this.f5762k;
                    if (bitmapDescriptor2 == null || bitmapDescriptor2.getBitmap().isRecycled()) {
                        this.f5762k = BitmapDescriptorFactory.fromBitmap(b3.l(this.f5753b, "amap_sdk_lineTexture.png"));
                    }
                    return this.f5762k;
                case 2:
                    BitmapDescriptor bitmapDescriptor3 = this.f5761j;
                    if (bitmapDescriptor3 == null || bitmapDescriptor3.getBitmap().isRecycled()) {
                        this.f5761j = BitmapDescriptorFactory.fromBitmap(b3.l(this.f5753b, "amap_sdk_lineDashTexture_circle.png"));
                    }
                    return this.f5761j;
                case 3:
                    BitmapDescriptor bitmapDescriptor4 = this.f5760i;
                    if (bitmapDescriptor4 == null || bitmapDescriptor4.getBitmap().isRecycled()) {
                        this.f5760i = BitmapDescriptorFactory.fromBitmap(b3.l(this.f5753b, "amap_sdk_lineDashTexture_square.png"));
                    }
                    return this.f5760i;
                case 4:
                    BitmapDescriptor bitmapDescriptor5 = this.f5763l;
                    if (bitmapDescriptor5 == null || bitmapDescriptor5.getBitmap().isRecycled()) {
                        this.f5763l = BitmapDescriptorFactory.defaultMarker();
                    }
                    return this.f5763l;
                case 5:
                    BitmapDescriptor bitmapDescriptor6 = this.f5764m;
                    if (bitmapDescriptor6 == null || bitmapDescriptor6.getBitmap().isRecycled()) {
                        this.f5764m = BitmapDescriptorFactory.fromAsset("arrow/arrow_line_inner.png");
                    }
                    return this.f5764m;
                case 6:
                    BitmapDescriptor bitmapDescriptor7 = this.f5765n;
                    if (bitmapDescriptor7 == null || bitmapDescriptor7.getBitmap().isRecycled()) {
                        this.f5765n = BitmapDescriptorFactory.fromAsset("arrow/arrow_line_outer.png");
                    }
                    return this.f5765n;
                case 7:
                    BitmapDescriptor bitmapDescriptor8 = this.f5766o;
                    if (bitmapDescriptor8 == null || bitmapDescriptor8.getBitmap().isRecycled()) {
                        this.f5766o = BitmapDescriptorFactory.fromAsset("arrow/arrow_line_shadow.png");
                    }
                    return this.f5766o;
                default:
                    return null;
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final int getCurrentParticleNum(String str) {
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f5756e;
        if (aMapNativeGlOverlayLayer != null) {
            return aMapNativeGlOverlayLayer.getCurrentParticleNum(str);
        }
        return 0;
    }

    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final BitmapDescriptor getCustomImageData(ImageOptions imageOptions) {
        int argb;
        if (imageOptions == null) {
            return null;
        }
        if (imageOptions.type == ImageOptions.ShapeType.CIRCLE.value()) {
            if (imageOptions.radius == 0.0d) {
                return null;
            }
            float a6 = v2.a(this.f5753b, (int) r3);
            int i6 = ((int) a6) * 2;
            Bitmap createBitmap = Bitmap.createBitmap(i6, i6, Bitmap.Config.ARGB_8888);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            Canvas canvas = new Canvas(createBitmap);
            Path path = new Path();
            path.addCircle(a6, a6, a6, Path.Direction.CW);
            canvas.clipPath(path);
            canvas.drawColor(imageOptions.color);
            canvas.drawBitmap(createBitmap, 0.0f, 0.0f, paint);
            return BitmapDescriptorFactory.fromBitmap(createBitmap);
        }
        if (imageOptions.type == ImageOptions.ShapeType.TEXT.value()) {
            String str = imageOptions.content;
            int i7 = imageOptions.fontSize;
            if (str.isEmpty()) {
                return null;
            }
            float a7 = v2.a(this.f5753b, i7);
            Paint paint2 = new Paint();
            paint2.setTextSize(a7);
            paint2.setFakeBoldText(true);
            paint2.setColor(imageOptions.color);
            float measureText = paint2.measureText(str);
            Rect rect = new Rect();
            paint2.getTextBounds(str, 0, str.length(), rect);
            Bitmap createBitmap2 = Bitmap.createBitmap((int) measureText, rect.height(), Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(createBitmap2);
            canvas2.save();
            canvas2.drawColor(0);
            canvas2.drawText(str, 0.0f, -rect.top, paint2);
            canvas2.restore();
            return BitmapDescriptorFactory.fromBitmap(createBitmap2);
        }
        if (imageOptions.type != ImageOptions.ShapeType.DEFAULT.value()) {
            return null;
        }
        if (imageOptions.radius == 0.0d) {
            return null;
        }
        float a8 = v2.a(this.f5753b, (int) r3);
        int i8 = (int) a8;
        Bitmap createBitmap3 = Bitmap.createBitmap(i8, i8, Bitmap.Config.ARGB_8888);
        Paint paint3 = new Paint();
        paint3.setAntiAlias(true);
        Canvas canvas3 = new Canvas(createBitmap3);
        Path path2 = new Path();
        path2.addRect(0.0f, 0.0f, a8, a8, Path.Direction.CW);
        canvas3.clipPath(path2);
        double[] dArr = imageOptions.rgba;
        argb = Color.argb((float) dArr[3], (float) dArr[0], (float) dArr[1], (float) dArr[2]);
        canvas3.drawColor(argb);
        canvas3.drawBitmap(createBitmap3, 0.0f, 0.0f, paint3);
        return BitmapDescriptorFactory.fromBitmap(createBitmap3);
    }

    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final BitmapDescriptor getInfoContents(String str) {
        a0 infoWindowDelegate;
        IAMapDelegate iAMapDelegate = this.f5752a;
        if (iAMapDelegate == null || (infoWindowDelegate = iAMapDelegate.getInfoWindowDelegate()) == null) {
            return null;
        }
        BaseOverlay baseOverlay = this.f5757f.get(str);
        if (baseOverlay instanceof BasePointOverlay) {
            return a(infoWindowDelegate.p((BasePointOverlay) baseOverlay));
        }
        return null;
    }

    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final BitmapDescriptor getInfoWindow(String str) {
        a0 infoWindowDelegate;
        IAMapDelegate iAMapDelegate = this.f5752a;
        if (iAMapDelegate == null || (infoWindowDelegate = iAMapDelegate.getInfoWindowDelegate()) == null) {
            return null;
        }
        BaseOverlay baseOverlay = this.f5757f.get(str);
        if (baseOverlay instanceof BasePointOverlay) {
            return a(infoWindowDelegate.d((BasePointOverlay) baseOverlay));
        }
        return null;
    }

    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final long getInfoWindowUpdateOffsetTime(String str) {
        a0 infoWindowDelegate;
        IAMapDelegate iAMapDelegate = this.f5752a;
        if (iAMapDelegate == null || (infoWindowDelegate = iAMapDelegate.getInfoWindowDelegate()) == null) {
            return 0L;
        }
        BaseOverlay baseOverlay = this.f5757f.get(str);
        if (baseOverlay instanceof BasePointOverlay) {
            return infoWindowDelegate.u((BasePointOverlay) baseOverlay);
        }
        return 0L;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final IAMapDelegate getMap() {
        return this.f5752a;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final List<Marker> getMapScreenMarkers() {
        if (this.f5756e == null) {
            return null;
        }
        this.f5768q.clear();
        this.f5756e.getNativeProperties("", "getMapScreenOverlays", new Object[]{this.f5768q});
        if (this.f5768q.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : this.f5768q) {
            if (str != null && str.contains("MARKER")) {
                arrayList.add((Marker) this.f5757f.get(str));
            }
        }
        return arrayList;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void getMarkerInfoWindowOffset(String str, FPoint fPoint) {
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f5756e;
        if (aMapNativeGlOverlayLayer != null) {
            Object nativeProperties = aMapNativeGlOverlayLayer.getNativeProperties(str, "getMarkerInfoWindowOffset", null);
            if (nativeProperties instanceof Point) {
                Point point = (Point) nativeProperties;
                ((PointF) fPoint).x = point.x;
                ((PointF) fPoint).y = point.y;
            }
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final MultiPointItem getMultiPointItem(LatLng latLng) {
        List<MultiPointItem> items;
        try {
            AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f5756e;
            if (aMapNativeGlOverlayLayer == null) {
                return null;
            }
            Object nativeProperties = aMapNativeGlOverlayLayer.getNativeProperties("", "getMultiPointItem", new LatLng[]{latLng});
            if (!(nativeProperties instanceof MultiPointItemHitTest)) {
                return null;
            }
            MultiPointItemHitTest multiPointItemHitTest = (MultiPointItemHitTest) nativeProperties;
            if (multiPointItemHitTest.index == -1) {
                return null;
            }
            BaseOverlay baseOverlay = this.f5757f.get(multiPointItemHitTest.overlayName);
            if (!(baseOverlay instanceof MultiPointOverlay) || (items = ((MultiPointOverlay) baseOverlay).getItems()) == null) {
                return null;
            }
            int size = items.size();
            int i6 = multiPointItemHitTest.index;
            if (size > i6) {
                return items.get(i6);
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final Object getNativeProperties(String str, String str2, Object[] objArr) {
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f5756e;
        if (aMapNativeGlOverlayLayer != null) {
            return aMapNativeGlOverlayLayer.getNativeProperties(str, str2, objArr);
        }
        return null;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void getOverlayScreenPos(String str, FPoint fPoint) {
        if (this.f5757f.get(str) instanceof BasePointOverlay) {
            Object nativeProperties = this.f5756e.getNativeProperties(str, "getMarkerScreenPos", null);
            if (nativeProperties instanceof Point) {
                Point point = (Point) nativeProperties;
                ((PointF) fPoint).x = point.x;
                ((PointF) fPoint).y = point.y;
            }
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void hideInfoWindow(String str) {
        if (this.f5756e != null) {
            this.f5752a.hideInfoWindow();
            this.f5756e.getNativeProperties(str, "setInfoWindowShown", new Object[]{Boolean.FALSE});
        }
        setRunLowFrame(false);
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final boolean isGLTFAnimated() {
        boolean z5;
        synchronized (this.f5757f) {
            try {
                Iterator<Map.Entry<String, BaseOverlay>> it = this.f5757f.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z5 = false;
                        break;
                    }
                    Map.Entry<String, BaseOverlay> next = it.next();
                    String key = next.getKey();
                    BaseOverlay value = next.getValue();
                    if (key.contains("GLTFOVERLAY") && ((GLTFOverlay) value).isAnimated()) {
                        z5 = true;
                        break;
                    }
                }
            } finally {
            }
        }
        return z5;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void onCreateAMapInstance() {
        if (this.f5756e == null) {
            this.f5756e = new AMapNativeGlOverlayLayer();
        }
        this.f5756e.setEngineId(this.f5752a.getNativeEngineID());
        this.f5756e.createNative(this.f5752a.getGLMapEngine().getNativeInstance());
        this.f5756e.setNativeFunCallListener(this);
    }

    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final void onRedrawInfowindow() {
        IAMapDelegate iAMapDelegate = this.f5752a;
        if (iAMapDelegate != null) {
            iAMapDelegate.redrawInfoWindow();
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final boolean removeOverlay(String str) {
        boolean z5;
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f5756e;
        if (aMapNativeGlOverlayLayer != null) {
            aMapNativeGlOverlayLayer.removeOverlay(str);
            z5 = true;
        } else {
            z5 = false;
        }
        synchronized (this.f5757f) {
            this.f5757f.remove(str);
        }
        return z5;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void set2Top(String str) {
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f5756e;
        if (aMapNativeGlOverlayLayer != null) {
            aMapNativeGlOverlayLayer.getNativeProperties(str, "set2Top", null);
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void setFlingState(boolean z5) {
        AMapNativeGlOverlayLayer aMapNativeGlOverlayLayer = this.f5756e;
        if (aMapNativeGlOverlayLayer != null) {
            aMapNativeGlOverlayLayer.getNativeProperties("", "setFlingState", new Object[]{Boolean.valueOf(z5)});
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void setRunLowFrame(boolean z5) {
        IAMapDelegate iAMapDelegate = this.f5752a;
        if (iAMapDelegate != null) {
            iAMapDelegate.setRunLowFrame(z5);
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void showInfoWindow(String str) {
        Map<String, BaseOverlay> map;
        if (this.f5756e == null || (map = this.f5757f) == null) {
            return;
        }
        try {
            this.f5752a.showInfoWindow(map.get(str));
            setRunLowFrame(false);
        } catch (RemoteException e6) {
            e6.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void updateOption(String str, BaseOptions baseOptions) {
        try {
            if (this.f5756e == null) {
                return;
            }
            setRunLowFrame(false);
            this.f5756e.updateOptions(str, baseOptions);
        } catch (Throwable th) {
            v5.p(th, "GlOverlayLayer", "updateOption");
            th.printStackTrace();
        }
    }

    public c(IAMapDelegate iAMapDelegate, Context context) {
        this.f5752a = iAMapDelegate;
        this.f5753b = context;
        this.f5758g = new r1(iAMapDelegate);
    }

    private void c(String str, BaseOverlay baseOverlay, BaseOptions baseOptions) {
        b(str, baseOptions);
        synchronized (this.f5757f) {
            this.f5757f.put(str, baseOverlay);
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final BaseOverlay addOverlayObject(String str, BaseOverlay baseOverlay, BaseOptions baseOptions) {
        c(str, baseOverlay, baseOptions);
        return baseOverlay;
    }

    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final void getAMapResource(AMapAppRequestParam aMapAppRequestParam) {
        z2.a().b(new a(aMapAppRequestParam));
    }

    @Override // com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener
    public final void onSetRunLowFrame(boolean z5) {
        setRunLowFrame(z5);
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final BaseOverlay getHitBaseOverlay(MotionEvent motionEvent, int i6) {
        if (this.f5752a == null) {
            return null;
        }
        DPoint obtain = DPoint.obtain();
        this.f5752a.getPixel2LatLng((int) motionEvent.getX(), (int) motionEvent.getY(), obtain);
        LatLng latLng = new LatLng(obtain.f9904y, obtain.f9903x);
        obtain.recycle();
        return getHitBaseOverlay(latLng, i6);
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public final void changeOverlayIndex() {
    }
}
