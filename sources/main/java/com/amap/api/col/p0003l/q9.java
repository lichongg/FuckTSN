package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.location.Location;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.util.Size;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.amap.api.col.p0003l.ef;
import com.amap.api.col.p0003l.ft;
import com.amap.api.col.p0003l.u8;
import com.amap.api.col.p0003l.z1;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.CameraUpdate;
import com.amap.api.maps.CustomRenderer;
import com.amap.api.maps.InfoWindowAnimationManager;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.Projection;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.AMapCameraInfo;
import com.amap.api.maps.model.AMapGestureListener;
import com.amap.api.maps.model.Arc;
import com.amap.api.maps.model.ArcOptions;
import com.amap.api.maps.model.BaseOptions;
import com.amap.api.maps.model.BaseOverlay;
import com.amap.api.maps.model.BuildingOverlay;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.CrossOverlay;
import com.amap.api.maps.model.CrossOverlayOptions;
import com.amap.api.maps.model.CustomMapStyleOptions;
import com.amap.api.maps.model.GL3DModel;
import com.amap.api.maps.model.GL3DModelOptions;
import com.amap.api.maps.model.GLTFOverlay;
import com.amap.api.maps.model.GLTFOverlayOptions;
import com.amap.api.maps.model.GroundOverlay;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.amap.api.maps.model.HeatMapGridLayer;
import com.amap.api.maps.model.HeatMapGridLayerOptions;
import com.amap.api.maps.model.HeatMapLayer;
import com.amap.api.maps.model.HeatMapLayerOptions;
import com.amap.api.maps.model.HeatmapTileProvider;
import com.amap.api.maps.model.IndoorBuildingInfo;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.MVTTileOverlay;
import com.amap.api.maps.model.MVTTileOverlayOptions;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MultiPointItem;
import com.amap.api.maps.model.MultiPointOverlay;
import com.amap.api.maps.model.MultiPointOverlayOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.maps.model.MyTrafficStyle;
import com.amap.api.maps.model.NavigateArrow;
import com.amap.api.maps.model.NavigateArrowOptions;
import com.amap.api.maps.model.Poi;
import com.amap.api.maps.model.Polygon;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.maps.model.RouteOverlay;
import com.amap.api.maps.model.Text;
import com.amap.api.maps.model.TextOptions;
import com.amap.api.maps.model.TileOverlay;
import com.amap.api.maps.model.TileOverlayOptions;
import com.amap.api.maps.model.TileProvider;
import com.amap.api.maps.model.amap3dmodeltile.AMap3DModelTileOverlay;
import com.amap.api.maps.model.amap3dmodeltile.AMap3DModelTileOverlayOptions;
import com.amap.api.maps.model.particle.ParticleOverlay;
import com.amap.api.maps.model.particle.ParticleOverlayOptions;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import com.autonavi.base.ae.gmap.AMapAppRequestParam;
import com.autonavi.base.ae.gmap.GLMapEngine;
import com.autonavi.base.ae.gmap.GLMapRender;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.ae.gmap.MapPoi;
import com.autonavi.base.ae.gmap.bean.NativeTextGenerate;
import com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo;
import com.autonavi.base.ae.gmap.gloverlay.BaseMapOverlay;
import com.autonavi.base.ae.gmap.gloverlay.CrossVectorOverlay;
import com.autonavi.base.ae.gmap.gloverlay.GLOverlayBundle;
import com.autonavi.base.ae.gmap.gloverlay.GLTextureProperty;
import com.autonavi.base.ae.gmap.gloverlay.RouteOverlayInner;
import com.autonavi.base.ae.gmap.listener.AMapWidgetListener;
import com.autonavi.base.ae.gmap.style.StyleItem;
import com.autonavi.base.amap.api.mapcore.BaseOverlayImp;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IGLSurfaceView;
import com.autonavi.base.amap.api.mapcore.IProjectionDelegate;
import com.autonavi.base.amap.api.mapcore.IUiSettingsDelegate;
import com.autonavi.base.amap.mapcore.AeUtil;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.MapConfig;
import com.autonavi.base.amap.mapcore.Rectangle;
import com.autonavi.base.amap.mapcore.interfaces.IAMapListener;
import com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage;
import com.autonavi.base.amap.mapcore.tools.GLConvertUtil;
import com.umeng.analytics.pro.bi;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class q9 implements z1.a, u8.a, IAMapDelegate, IAMapListener {
    private boolean A;
    private t0 A0;
    private boolean B;
    private t0 B0;
    private boolean C;
    private t0 C0;
    private boolean D;
    private t0 D0;
    private int E;
    private t0 E0;
    private boolean F;
    private t0 F0;
    private boolean G;
    private t0 G0;
    private Rect H;
    private t0 H0;
    private int I;
    private t0 I0;
    private MyTrafficStyle J;
    private t0 J0;
    private Thread K;
    private t0 K0;
    private Thread L;
    private t0 L0;
    private fa M;
    private t0 M0;
    private boolean N;
    private Runnable N0;
    private boolean O;
    private t0 O0;
    private int P;
    private com.autonavi.extra.b P0;
    private CustomRenderer Q;
    private String Q0;
    private int R;
    private String R0;
    private int S;
    private boolean S0;
    private List<com.amap.api.col.p0003l.e> T;
    private boolean T0;
    private x1 U;
    private int U0;
    private z1 V;
    private EAMapPlatformGestureInfo V0;
    s2 W;
    Point W0;
    private long X;
    private long X0;
    protected Context Y;
    protected String Y0;
    protected GLMapEngine Z;
    private com.amap.api.col.p0003l.z Z0;

    /* renamed from: a, reason: collision with root package name */
    private z9 f6988a;

    /* renamed from: a0, reason: collision with root package name */
    private GLMapRender f6989a0;

    /* renamed from: a1, reason: collision with root package name */
    float[] f6990a1;

    /* renamed from: b, reason: collision with root package name */
    private aa f6991b;

    /* renamed from: b0, reason: collision with root package name */
    private ia f6992b0;

    /* renamed from: b1, reason: collision with root package name */
    float[] f6993b1;

    /* renamed from: c, reason: collision with root package name */
    private AMapGestureListener f6994c;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f6995c0;

    /* renamed from: c1, reason: collision with root package name */
    float[] f6996c1;

    /* renamed from: d, reason: collision with root package name */
    private com.amap.api.col.p0003l.a0 f6997d;

    /* renamed from: d0, reason: collision with root package name */
    public int f6998d0;

    /* renamed from: d1, reason: collision with root package name */
    private IPoint[] f6999d1;

    /* renamed from: e, reason: collision with root package name */
    private UiSettings f7000e;

    /* renamed from: e0, reason: collision with root package name */
    public int f7001e0;

    /* renamed from: e1, reason: collision with root package name */
    float[] f7002e1;

    /* renamed from: f, reason: collision with root package name */
    private IProjectionDelegate f7003f;

    /* renamed from: f0, reason: collision with root package name */
    private float f7004f0;

    /* renamed from: f1, reason: collision with root package name */
    String f7005f1;

    /* renamed from: g, reason: collision with root package name */
    private final com.amap.api.col.p0003l.i f7006g;

    /* renamed from: g0, reason: collision with root package name */
    private float f7007g0;

    /* renamed from: g1, reason: collision with root package name */
    String f7008g1;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f7009h;

    /* renamed from: h0, reason: collision with root package name */
    private float f7010h0;

    /* renamed from: h1, reason: collision with root package name */
    int f7011h1;

    /* renamed from: i, reason: collision with root package name */
    private boolean f7012i;

    /* renamed from: i0, reason: collision with root package name */
    private boolean f7013i0;

    /* renamed from: j, reason: collision with root package name */
    private final IGLSurfaceView f7014j;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f7015j0;

    /* renamed from: k, reason: collision with root package name */
    private i3 f7016k;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f7017k0;

    /* renamed from: l, reason: collision with root package name */
    private final IGlOverlayLayer f7018l;

    /* renamed from: l0, reason: collision with root package name */
    private volatile boolean f7019l0;

    /* renamed from: m, reason: collision with root package name */
    private boolean f7020m;

    /* renamed from: m0, reason: collision with root package name */
    private volatile boolean f7021m0;

    /* renamed from: n, reason: collision with root package name */
    private int f7022n;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f7023n0;

    /* renamed from: o, reason: collision with root package name */
    private AtomicBoolean f7024o;

    /* renamed from: o0, reason: collision with root package name */
    private boolean f7025o0;

    /* renamed from: p, reason: collision with root package name */
    private boolean f7026p;

    /* renamed from: p0, reason: collision with root package name */
    private Lock f7027p0;

    /* renamed from: q, reason: collision with root package name */
    protected MapConfig f7028q;

    /* renamed from: q0, reason: collision with root package name */
    private int f7029q0;

    /* renamed from: r, reason: collision with root package name */
    private boolean f7030r;

    /* renamed from: r0, reason: collision with root package name */
    private int f7031r0;

    /* renamed from: s, reason: collision with root package name */
    private boolean f7032s;

    /* renamed from: s0, reason: collision with root package name */
    private int f7033s0;

    /* renamed from: t, reason: collision with root package name */
    protected com.amap.api.col.p0003l.z f7034t;

    /* renamed from: t0, reason: collision with root package name */
    private u0 f7035t0;

    /* renamed from: u, reason: collision with root package name */
    private q1 f7036u;

    /* renamed from: u0, reason: collision with root package name */
    private v1 f7037u0;

    /* renamed from: v, reason: collision with root package name */
    private LocationSource f7038v;

    /* renamed from: v0, reason: collision with root package name */
    private AMap.OnMultiPointClickListener f7039v0;

    /* renamed from: w, reason: collision with root package name */
    private boolean f7040w;

    /* renamed from: w0, reason: collision with root package name */
    private u8 f7041w0;

    /* renamed from: x, reason: collision with root package name */
    private boolean f7042x;

    /* renamed from: x0, reason: collision with root package name */
    private long f7043x0;

    /* renamed from: y, reason: collision with root package name */
    private Marker f7044y;

    /* renamed from: y0, reason: collision with root package name */
    boolean f7045y0;

    /* renamed from: z, reason: collision with root package name */
    private GLTFOverlay f7046z;

    /* renamed from: z0, reason: collision with root package name */
    protected final Handler f7047z0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ double f7048a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ double f7049b;

        a(double d6, double d7) {
            this.f7048a = d6;
            this.f7049b = d7;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtain = Message.obtain();
            obtain.what = 19;
            obtain.arg1 = (int) this.f7048a;
            obtain.arg2 = (int) this.f7049b;
            q9.this.f7047z0.sendMessage(obtain);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a0 implements Runnable {
        a0() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (q9.this.f7035t0 != null) {
                q9.this.f7035t0.a(q9.this.Z0);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class b extends t0 {
        b() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.3l.q9.t0, java.lang.Runnable
        public final void run() {
            super.run();
            try {
                q9.this.setTrafficEnabled(this.f7121b);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class b0 implements Runnable {
        b0() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (q9.this.f7018l != null) {
                    q9.this.f7018l.destroy();
                }
                q9 q9Var = q9.this;
                q9Var.destroySurface(q9Var.f7022n);
            } catch (Throwable th) {
                th.printStackTrace();
                b3.D(th);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ed f7054a;

        c(ed edVar) {
            this.f7054a = edVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (q9.this.f7026p) {
                return;
            }
            try {
                q9 q9Var = q9.this;
                com.amap.api.col.p0003l.z zVar = q9Var.f7034t;
                if (zVar != null) {
                    q9Var.setIndoorBuildingInfo(zVar);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.f7054a.a();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class c0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CrossVectorOverlay f7056a;

        c0(CrossVectorOverlay crossVectorOverlay) {
            this.f7056a = crossVectorOverlay;
        }

        @Override // java.lang.Runnable
        public final void run() {
            GLOverlayBundle overlayBundle;
            q9 q9Var = q9.this;
            GLMapEngine gLMapEngine = q9Var.Z;
            if (gLMapEngine == null || (overlayBundle = gLMapEngine.getOverlayBundle(q9Var.f7022n)) == null) {
                return;
            }
            overlayBundle.addOverlay(this.f7056a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f7058a;

        d(int i6) {
            this.f7058a = i6;
        }

        @Override // java.lang.Runnable
        public final void run() {
            GLMapEngine gLMapEngine;
            if (!q9.this.f7019l0 || (gLMapEngine = q9.this.Z) == null) {
                return;
            }
            gLMapEngine.setHighlightSubwayEnable(this.f7058a, false);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class d0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RouteOverlayInner f7060a;

        d0(RouteOverlayInner routeOverlayInner) {
            this.f7060a = routeOverlayInner;
        }

        @Override // java.lang.Runnable
        public final void run() {
            GLOverlayBundle overlayBundle;
            q9 q9Var = q9.this;
            GLMapEngine gLMapEngine = q9Var.Z;
            if (gLMapEngine == null || (overlayBundle = gLMapEngine.getOverlayBundle(q9Var.f7022n)) == null) {
                return;
            }
            overlayBundle.addOverlay(this.f7060a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f7062a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f7063b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f7064c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f7065d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ StyleItem[] f7066e;

        e(int i6, int i7, int i8, boolean z5, StyleItem[] styleItemArr) {
            this.f7062a = i6;
            this.f7063b = i7;
            this.f7064c = i8;
            this.f7065d = z5;
            this.f7066e = styleItemArr;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                q9.this.Z.setMapModeAndStyle(this.f7062a, this.f7063b, this.f7064c, this.f7065d, this.f7066e);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class e0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaseMapOverlay f7068a;

        e0(BaseMapOverlay baseMapOverlay) {
            this.f7068a = baseMapOverlay;
        }

        @Override // java.lang.Runnable
        public final void run() {
            q9 q9Var = q9.this;
            q9Var.Z.getOverlayBundle(q9Var.f7022n).removeOverlay(this.f7068a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f7070a;

        f(int i6) {
            this.f7070a = i6;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                q9.this.Z.clearAllMessages(this.f7070a);
                q9.this.Z.clearAnimations(this.f7070a, true);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class f0 implements Callable<Integer> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f7072a;

        f0(List list) {
            this.f7072a = list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer call() throws Exception {
            return Integer.valueOf(q9.this.Z.hideBuildings(this.f7072a));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f7074a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f7075b;

        g(int i6, boolean z5) {
            this.f7074a = i6;
            this.f7075b = z5;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                q9.this.Z.setBuildingEnable(this.f7074a, this.f7075b);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class g0 extends t0 {
        g0() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.3l.q9.t0, java.lang.Runnable
        public final void run() {
            super.run();
            try {
                q9.this.setTrafficStyleWithTextureData(this.f7127h);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class h implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f7078a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f7079b;

        h(boolean z5, int i6) {
            this.f7078a = z5;
            this.f7079b = i6;
        }

        @Override // java.lang.Runnable
        public final void run() {
            GLMapEngine gLMapEngine = q9.this.Z;
            if (gLMapEngine != null) {
                if (this.f7078a) {
                    gLMapEngine.setAllContentEnable(this.f7079b, true);
                } else {
                    gLMapEngine.setAllContentEnable(this.f7079b, false);
                }
                q9.this.Z.setSimple3DEnable(this.f7079b, false);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class h0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f7081a;

        h0(int i6) {
            this.f7081a = i6;
        }

        @Override // java.lang.Runnable
        public final void run() {
            q9.this.Z.showHideBuildings(this.f7081a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class i implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f7083a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f7084b;

        i(boolean z5, int i6) {
            this.f7083a = z5;
            this.f7084b = i6;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (this.f7083a) {
                    q9.this.Z.setBuildingTextureEnable(this.f7084b, true);
                } else {
                    q9.this.Z.setBuildingTextureEnable(this.f7084b, false);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class i0 extends t0 {
        i0() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.3l.q9.t0, java.lang.Runnable
        public final void run() {
            super.run();
            q9.this.setMapCustomEnable(this.f7121b);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class j implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LatLngBounds.Builder f7087a;

        j(LatLngBounds.Builder builder) {
            this.f7087a = builder;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                q9.this.moveCamera(com.amap.api.col.p0003l.p.i(this.f7087a.build(), 50));
            } catch (Throwable unused) {
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class j0 extends t0 {
        j0() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.3l.q9.t0, java.lang.Runnable
        public final void run() {
            super.run();
            q9.this.k(this.f7124e, this.f7121b);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class k extends Handler {
        k(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i6;
            el f6;
            if (message == null || q9.this.f7024o.get()) {
                return;
            }
            try {
                i6 = message.what;
            } catch (Throwable th) {
                v5.p(th, "AMapDelegateImp", "handleMessage");
                th.printStackTrace();
            }
            if (i6 == 2) {
                Object obj = message.obj;
                if (obj != null) {
                    Objects.toString(obj);
                    return;
                } else {
                    String str = g4.f6288b;
                    return;
                }
            }
            if (i6 == 30) {
                GLMapEngine gLMapEngine = q9.this.Z;
                if (gLMapEngine != null) {
                    gLMapEngine.triggerMainThread();
                    return;
                }
                return;
            }
            int i7 = 0;
            switch (i6) {
                case 10:
                    CameraPosition cameraPosition = (CameraPosition) message.obj;
                    try {
                        List a6 = q9.this.f6991b.a(AMap.OnCameraChangeListener.class.hashCode());
                        if (cameraPosition != null && a6 != null && a6.size() > 0) {
                            synchronized (a6) {
                                try {
                                    Iterator it = a6.iterator();
                                    while (it.hasNext()) {
                                        ((AMap.OnCameraChangeListener) it.next()).onCameraChange(cameraPosition);
                                    }
                                } finally {
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        b3.D(th2);
                    }
                    q9.this.f7028q.addChangedCounter();
                    return;
                case 11:
                    try {
                        CameraPosition cameraPosition2 = q9.this.getCameraPosition();
                        if (cameraPosition2 != null && q9.this.f7016k != null) {
                            q9.this.f7016k.s(cameraPosition2);
                        }
                        q9.this.C(cameraPosition2);
                        if (q9.this.f7017k0) {
                            q9.V(q9.this);
                            if (q9.this.f7018l != null) {
                                q9.this.f7018l.setFlingState(false);
                            }
                            q9.this.x();
                        }
                        if (q9.this.D) {
                            q9.this.redrawInfoWindow();
                            q9.f0(q9.this);
                        }
                        q9.this.n(cameraPosition2);
                        return;
                    } catch (Throwable th3) {
                        v5.p(th3, "AMapDelegateImp", "CameraUpdateFinish");
                        b3.D(th3);
                        return;
                    }
                case 12:
                    if (q9.this.f7016k != null) {
                        q9.this.f7016k.r(Float.valueOf(q9.this.getZoomLevel()));
                        return;
                    }
                    return;
                case 13:
                    if (q9.this.f7016k != null) {
                        q9.this.f7016k.h();
                        return;
                    }
                    return;
                case 14:
                    try {
                        List a7 = q9.this.f6991b.a(AMap.OnMapTouchListener.class.hashCode());
                        if (a7 == null || a7.size() <= 0) {
                            return;
                        }
                        synchronized (a7) {
                            try {
                                Iterator it2 = a7.iterator();
                                while (it2.hasNext()) {
                                    ((AMap.OnMapTouchListener) it2.next()).onTouch((MotionEvent) message.obj);
                                }
                            } catch (Throwable th4) {
                                throw th4;
                            }
                        }
                        return;
                    } catch (Throwable th5) {
                        v5.p(th5, "AMapDelegateImp", "onTouchHandler");
                        th5.printStackTrace();
                        return;
                    }
                case 15:
                    Bitmap bitmap = (Bitmap) message.obj;
                    int i8 = message.arg1;
                    if (bitmap == null || q9.this.f7016k == null) {
                        try {
                            List a8 = q9.this.f6991b.a(AMap.onMapPrintScreenListener.class.hashCode());
                            ArrayList arrayList = a8 != null ? new ArrayList(a8) : null;
                            List a9 = q9.this.f6991b.a(AMap.OnMapScreenShotListener.class.hashCode());
                            ArrayList arrayList2 = a9 != null ? new ArrayList(a9) : null;
                            q9.this.f6991b.d(Integer.valueOf(AMap.onMapPrintScreenListener.class.hashCode()));
                            q9.this.f6991b.d(Integer.valueOf(AMap.OnMapScreenShotListener.class.hashCode()));
                            if (arrayList != null && arrayList.size() > 0) {
                                synchronized (arrayList) {
                                    for (int i9 = 0; i9 < arrayList.size(); i9++) {
                                        try {
                                            ((AMap.onMapPrintScreenListener) arrayList.get(i9)).onMapPrint(null);
                                        } finally {
                                        }
                                    }
                                }
                            }
                            if (arrayList2 == null || arrayList2.size() <= 0) {
                                return;
                            }
                            synchronized (arrayList2) {
                                while (i7 < arrayList2.size()) {
                                    try {
                                        ((AMap.OnMapScreenShotListener) arrayList2.get(i7)).onMapScreenShot(null);
                                        ((AMap.OnMapScreenShotListener) arrayList2.get(i7)).onMapScreenShot(null, i8);
                                        i7++;
                                    } finally {
                                    }
                                }
                            }
                            return;
                        } catch (Throwable th6) {
                            th6.printStackTrace();
                            return;
                        }
                    }
                    Canvas canvas = new Canvas(bitmap);
                    if (q9.this.F && (f6 = q9.this.f7016k.f()) != null) {
                        f6.onDraw(canvas);
                    }
                    q9.this.f7016k.m(canvas);
                    try {
                        List a10 = q9.this.f6991b.a(AMap.onMapPrintScreenListener.class.hashCode());
                        ArrayList arrayList3 = a10 != null ? new ArrayList(a10) : null;
                        List a11 = q9.this.f6991b.a(AMap.OnMapScreenShotListener.class.hashCode());
                        ArrayList arrayList4 = a11 != null ? new ArrayList(a11) : null;
                        q9.this.f6991b.d(Integer.valueOf(AMap.onMapPrintScreenListener.class.hashCode()));
                        q9.this.f6991b.d(Integer.valueOf(AMap.OnMapScreenShotListener.class.hashCode()));
                        if (arrayList3 != null && arrayList3.size() > 0) {
                            synchronized (arrayList3) {
                                for (int i10 = 0; i10 < arrayList3.size(); i10++) {
                                    try {
                                        ((AMap.onMapPrintScreenListener) arrayList3.get(i10)).onMapPrint(new BitmapDrawable(q9.this.Y.getResources(), bitmap));
                                    } finally {
                                    }
                                }
                            }
                        }
                        if (arrayList4 == null || arrayList4.size() <= 0) {
                            return;
                        }
                        synchronized (arrayList4) {
                            while (i7 < arrayList4.size()) {
                                try {
                                    ((AMap.OnMapScreenShotListener) arrayList4.get(i7)).onMapScreenShot(bitmap);
                                    ((AMap.OnMapScreenShotListener) arrayList4.get(i7)).onMapScreenShot(bitmap, i8);
                                    i7++;
                                } finally {
                                }
                            }
                        }
                        return;
                    } catch (Throwable th7) {
                        th7.printStackTrace();
                        return;
                    }
                case 16:
                    try {
                        List a12 = q9.this.f6991b.a(AMap.OnMapLoadedListener.class.hashCode());
                        if (a12 != null) {
                            synchronized (a12) {
                                while (i7 < a12.size()) {
                                    try {
                                        ((AMap.OnMapLoadedListener) a12.get(i7)).onMapLoaded();
                                        i7++;
                                    } catch (Throwable th8) {
                                        throw th8;
                                    }
                                }
                            }
                        }
                    } catch (Throwable th9) {
                        v5.p(th9, "AMapDelegateImp", "onMapLoaded");
                        th9.printStackTrace();
                        b3.D(th9);
                    }
                    if (q9.this.f7016k != null) {
                        q9.this.f7016k.i();
                        return;
                    }
                    return;
                case 17:
                    q9 q9Var = q9.this;
                    if (!q9Var.Z.isInMapAnimation(q9Var.f7022n) || q9.this.f7018l == null) {
                        return;
                    }
                    q9.this.f7018l.setFlingState(false);
                    return;
                case 18:
                    if (q9.this.f6997d != null) {
                        q9.this.f6997d.r();
                        return;
                    }
                    return;
                case 19:
                    List a13 = q9.this.f6991b.a(AMap.OnMapClickListener.class.hashCode());
                    if (a13 != null) {
                        DPoint obtain = DPoint.obtain();
                        q9.this.getPixel2LatLng(message.arg1, message.arg2, obtain);
                        try {
                            synchronized (a13) {
                                try {
                                    Iterator it3 = a13.iterator();
                                    while (it3.hasNext()) {
                                        ((AMap.OnMapClickListener) it3.next()).onMapClick(new LatLng(obtain.f9904y, obtain.f9903x));
                                    }
                                } finally {
                                }
                            }
                            obtain.recycle();
                            return;
                        } catch (Throwable th10) {
                            v5.p(th10, "AMapDelegateImp", "OnMapClickListener.onMapClick");
                            th10.printStackTrace();
                            return;
                        }
                    }
                    return;
                case 20:
                    try {
                        List a14 = q9.this.f6991b.a(AMap.OnPOIClickListener.class.hashCode());
                        if (a14 == null || a14.size() <= 0) {
                            return;
                        }
                        synchronized (a14) {
                            while (i7 < a14.size()) {
                                try {
                                    ((AMap.OnPOIClickListener) a14.get(i7)).onPOIClick((Poi) message.obj);
                                    i7++;
                                } catch (Throwable th11) {
                                    throw th11;
                                }
                            }
                        }
                        return;
                    } catch (Throwable th12) {
                        v5.p(th12, "AMapDelegateImp", "OnPOIClickListener.onPOIClick");
                        th12.printStackTrace();
                        return;
                    }
                default:
                    return;
            }
            v5.p(th, "AMapDelegateImp", "handleMessage");
            th.printStackTrace();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class k0 extends t0 {
        k0() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.3l.q9.t0, java.lang.Runnable
        public final void run() {
            super.run();
            try {
                q9.this.setMapTextEnable(this.f7121b);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class l implements Runnable {
        l() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            q9 q9Var = q9.this;
            if (q9Var.Z == null || q9Var.f7024o.get()) {
                return;
            }
            q9 q9Var2 = q9.this;
            q9Var2.Z.removeNativeAllOverlay(q9Var2.f7022n);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class l0 extends t0 {
        l0() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.3l.q9.t0, java.lang.Runnable
        public final void run() {
            super.run();
            try {
                q9.this.setRoadArrowEnable(this.f7121b);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class m extends t0 {
        m() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.3l.q9.t0, java.lang.Runnable
        public final void run() {
            super.run();
            try {
                q9 q9Var = q9.this;
                q9Var.setCenterToPixel(q9Var.f7031r0, q9.this.f7033s0);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class m0 extends t0 {
        m0() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.3l.q9.t0, java.lang.Runnable
        public final void run() {
            super.run();
            try {
                q9.this.setNaviLabelEnable(this.f7121b, this.f7125f, this.f7126g);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class n implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f7096a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f7097b;

        n(boolean z5, boolean z6) {
            this.f7096a = z5;
            this.f7097b = z6;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (q9.this.f7028q.isTrafficEnabled() != this.f7096a) {
                    q9.this.f7028q.setTrafficEnabled(this.f7097b);
                    q9.this.f6989a0.setTrafficMode(this.f7096a);
                    q9 q9Var = q9.this;
                    q9Var.Z.setTrafficEnable(q9Var.f7022n, this.f7096a);
                    q9.this.resetRenderTime();
                }
            } catch (Throwable th) {
                th.printStackTrace();
                b3.D(th);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class n0 extends t0 {
        n0() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.3l.q9.t0, java.lang.Runnable
        public final void run() {
            super.run();
            try {
                q9.this.setTrafficStyleWithTexture(this.f7127h, this.f7128i);
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class o implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f7100a;

        o(boolean z5) {
            this.f7100a = z5;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f7100a) {
                q9.this.showIndoorSwitchControlsEnabled(true);
            } else if (q9.this.f7016k != null) {
                q9.this.f7016k.n(Boolean.FALSE);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class o0 extends t0 {
        o0() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.3l.q9.t0, java.lang.Runnable
        public final void run() {
            super.run();
            q9.this.z(this.f7124e, this.f7121b);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class p implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f7103a;

        p(boolean z5) {
            this.f7103a = z5;
        }

        @Override // java.lang.Runnable
        public final void run() {
            q9 q9Var = q9.this;
            GLMapEngine gLMapEngine = q9Var.Z;
            if (gLMapEngine != null) {
                gLMapEngine.setOfflineDataEnable(q9Var.f7022n, this.f7103a);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class p0 extends t0 {
        p0() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.3l.q9.t0, java.lang.Runnable
        public final void run() {
            super.run();
            try {
                q9.this.setIndoorEnabled(this.f7121b);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class q implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f7106a;

        q(boolean z5) {
            this.f7106a = z5;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                q9 q9Var = q9.this;
                q9Var.Z.setLabelEnable(q9Var.f7022n, this.f7106a);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class q0 implements Runnable {
        q0() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            el f6;
            if (q9.this.f7016k == null || (f6 = q9.this.f7016k.f()) == null) {
                return;
            }
            f6.l();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class r implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f7109a;

        r(boolean z5) {
            this.f7109a = z5;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                q9 q9Var = q9.this;
                q9Var.Z.setRoadArrowEnable(q9Var.f7022n, this.f7109a);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class r0 extends t0 {
        r0() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.3l.q9.t0, java.lang.Runnable
        public final void run() {
            super.run();
            q9.this.H(this.f7124e, this.f7121b);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class s implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f7112a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f7113b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f7114c;

        s(boolean z5, int i6, int i7) {
            this.f7112a = z5;
            this.f7113b = i6;
            this.f7114c = i7;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                q9 q9Var = q9.this;
                q9Var.Z.setNaviLabelEnable(q9Var.f7022n, this.f7112a, this.f7113b, this.f7114c);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class s0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MotionEvent f7116a;

        s0(MotionEvent motionEvent) {
            this.f7116a = motionEvent;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                q9.this.Z.addGestureSingleTapMessage(this.f7116a.getX(), this.f7116a.getY());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class t implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f7118a;

        t(boolean z5) {
            this.f7118a = z5;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                q9.this.Z.setMapOpenLayerEnable(this.f7118a);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class u implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ byte[] f7129a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ MyTrafficStyle f7130b;

        u(byte[] bArr, MyTrafficStyle myTrafficStyle) {
            this.f7129a = bArr;
            this.f7130b = myTrafficStyle;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                q9 q9Var = q9.this;
                q9Var.Z.setTrafficStyleWithTexture(q9Var.f7022n, this.f7129a, this.f7130b);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class u0 {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ef f7133a;

            a(ef efVar) {
                this.f7133a = efVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f7133a.j(false);
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        final class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ef f7135a;

            b(ef efVar) {
                this.f7135a = efVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    this.f7135a.k(q9.this.f7034t.floor_names);
                    this.f7135a.i(q9.this.f7034t.activeFloorName);
                    if (this.f7135a.o()) {
                        return;
                    }
                    this.f7135a.j(true);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        u0() {
        }

        public final void a(com.amap.api.col.p0003l.z zVar) {
            List a6;
            List a7;
            com.amap.api.col.p0003l.z zVar2;
            com.amap.api.col.p0003l.z zVar3;
            int[] iArr;
            String[] strArr;
            MapConfig mapConfig = q9.this.f7028q;
            if (mapConfig == null || !mapConfig.isIndoorEnable()) {
                return;
            }
            ef e6 = q9.this.f7016k.e();
            if (zVar == null) {
                try {
                    List a8 = q9.this.f6991b.a(AMap.OnIndoorBuildingActiveListener.class.hashCode());
                    if (a8 != null && a8.size() > 0) {
                        synchronized (a8) {
                            for (int i6 = 0; i6 < a8.size(); i6++) {
                                try {
                                    ((AMap.OnIndoorBuildingActiveListener) a8.get(i6)).OnIndoorBuilding(zVar);
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                com.amap.api.col.p0003l.z zVar4 = q9.this.f7034t;
                if (zVar4 != null) {
                    zVar4.f7782g = null;
                }
                if (e6.o()) {
                    q9.this.f7047z0.post(new a(e6));
                }
                MapConfig mapConfig2 = q9.this.f7028q;
                mapConfig2.maxZoomLevel = mapConfig2.isSetLimitZoomLevel() ? q9.this.f7028q.getMaxZoomLevel() : 20.0f;
                try {
                    if (!q9.this.f7006g.isZoomControlsEnabled() || (a6 = q9.this.f6991b.a(AMapWidgetListener.class.hashCode())) == null || a6.size() <= 0) {
                        return;
                    }
                    synchronized (a6) {
                        for (int i7 = 0; i7 < a6.size(); i7++) {
                            try {
                                ((AMapWidgetListener) a6.get(i7)).invalidateZoomController(q9.this.f7028q.getSZ());
                            } catch (Throwable th3) {
                                throw th3;
                            }
                        }
                    }
                    return;
                } catch (Throwable th4) {
                    th4.printStackTrace();
                }
            }
            if (zVar != null && (iArr = zVar.floor_indexs) != null && (strArr = zVar.floor_names) != null && iArr.length == strArr.length) {
                int i8 = 0;
                while (true) {
                    int[] iArr2 = zVar.floor_indexs;
                    if (i8 >= iArr2.length) {
                        break;
                    }
                    if (zVar.activeFloorIndex == iArr2[i8]) {
                        zVar.activeFloorName = zVar.floor_names[i8];
                        break;
                    }
                    i8++;
                }
            }
            if (zVar == null || (zVar3 = q9.this.f7034t) == null || zVar3.activeFloorIndex == zVar.activeFloorIndex || !e6.o()) {
                if (zVar != null && ((zVar2 = q9.this.f7034t) == null || !zVar2.poiid.equals(zVar.poiid) || q9.this.f7034t.f7782g == null)) {
                    q9 q9Var = q9.this;
                    q9Var.f7034t = zVar;
                    if (q9Var.f7028q != null) {
                        if (zVar.f7782g == null) {
                            zVar.f7782g = new Point();
                        }
                        DPoint mapGeoCenter = q9.this.f7028q.getMapGeoCenter();
                        if (mapGeoCenter != null) {
                            Point point = q9.this.f7034t.f7782g;
                            point.x = (int) mapGeoCenter.f9903x;
                            point.y = (int) mapGeoCenter.f9904y;
                        }
                    }
                }
                try {
                    List a9 = q9.this.f6991b.a(AMap.OnIndoorBuildingActiveListener.class.hashCode());
                    if (a9 != null && a9.size() > 0) {
                        synchronized (a9) {
                            for (int i9 = 0; i9 < a9.size(); i9++) {
                                try {
                                    ((AMap.OnIndoorBuildingActiveListener) a9.get(i9)).OnIndoorBuilding(zVar);
                                } finally {
                                }
                            }
                        }
                    }
                    MapConfig mapConfig3 = q9.this.f7028q;
                    mapConfig3.maxZoomLevel = mapConfig3.isSetLimitZoomLevel() ? q9.this.f7028q.getMaxZoomLevel() : 20.0f;
                    if (q9.this.f7006g.isZoomControlsEnabled() && (a7 = q9.this.f6991b.a(AMapWidgetListener.class.hashCode())) != null && a7.size() > 0) {
                        synchronized (a7) {
                            for (int i10 = 0; i10 < a7.size(); i10++) {
                                try {
                                    ((AMapWidgetListener) a7.get(i10)).invalidateZoomController(q9.this.f7028q.getSZ());
                                } finally {
                                }
                            }
                        }
                    }
                    if (q9.this.f7006g.isIndoorSwitchEnabled()) {
                        if (!e6.o()) {
                            q9.this.f7006g.setIndoorSwitchEnabled(true);
                        }
                        q9.this.f7047z0.post(new b(e6));
                    } else {
                        if (q9.this.f7006g.isIndoorSwitchEnabled() || !e6.o()) {
                            return;
                        }
                        q9.this.f7006g.setIndoorSwitchEnabled(false);
                    }
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class v extends t0 {
        v() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.3l.q9.t0, java.lang.Runnable
        public final void run() {
            super.run();
            try {
                q9.this.setConstructingRoadEnable(this.f7121b);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class v0 implements ef.d {
        private v0() {
        }

        /* synthetic */ v0(q9 q9Var, byte b6) {
            this();
        }

        @Override // com.amap.api.col.3l.ef.d
        public final void a(int i6) {
            q9 q9Var = q9.this;
            com.amap.api.col.p0003l.z zVar = q9Var.f7034t;
            if (zVar != null) {
                zVar.activeFloorIndex = zVar.floor_indexs[i6];
                zVar.activeFloorName = zVar.floor_names[i6];
                try {
                    q9Var.setIndoorBuildingInfo(zVar);
                } catch (RemoteException e6) {
                    e6.printStackTrace();
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class w implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ byte[] f7139a;

        w(byte[] bArr) {
            this.f7139a = bArr;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                q9 q9Var = q9.this;
                q9Var.Z.setTrafficStyleWithTextureData(q9Var.f7022n, this.f7139a);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class w0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private Context f7141a;

        /* renamed from: b, reason: collision with root package name */
        private AMap.OnCacheRemoveListener f7142b;

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0040, code lost:
        
            if (com.amap.api.col.p0003l.b3.i0(r2) != false) goto L22;
         */
        /* JADX WARN: Removed duplicated region for block: B:13:0x004c A[Catch: all -> 0x0024, TRY_LEAVE, TryCatch #2 {all -> 0x0024, blocks: (B:3:0x0002, B:5:0x001f, B:11:0x0044, B:13:0x004c), top: B:2:0x0002 }] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x003c A[Catch: all -> 0x0036, TRY_LEAVE, TryCatch #4 {all -> 0x0036, blocks: (B:61:0x0029, B:9:0x003c), top: B:60:0x0029 }] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void run() {
            /*
                r6 = this;
                r0 = 0
                r1 = 1
                android.content.Context r2 = r6.f7141a     // Catch: java.lang.Throwable -> L24
                android.content.Context r2 = r2.getApplicationContext()     // Catch: java.lang.Throwable -> L24
                android.content.Context r2 = com.stub.StubApp.getOrigApplicationContext(r2)     // Catch: java.lang.Throwable -> L24
                java.lang.String r3 = com.amap.api.col.p0003l.b3.f0(r2)     // Catch: java.lang.Throwable -> L24
                java.lang.String r4 = com.amap.api.col.p0003l.b3.v(r2)     // Catch: java.lang.Throwable -> L24
                java.io.File r5 = new java.io.File     // Catch: java.lang.Throwable -> L24
                r5.<init>(r3)     // Catch: java.lang.Throwable -> L24
                boolean r3 = r5.exists()     // Catch: java.lang.Throwable -> L24
                if (r3 == 0) goto L26
                boolean r3 = com.autonavi.base.amap.mapcore.FileUtil.deleteFile(r5)     // Catch: java.lang.Throwable -> L24
                goto L27
            L24:
                r2 = move-exception
                goto L68
            L26:
                r3 = 1
            L27:
                if (r3 == 0) goto L39
                java.io.File r5 = new java.io.File     // Catch: java.lang.Throwable -> L36
                r5.<init>(r4)     // Catch: java.lang.Throwable -> L36
                boolean r3 = com.autonavi.base.amap.mapcore.FileUtil.deleteFile(r5)     // Catch: java.lang.Throwable -> L36
                if (r3 == 0) goto L39
                r3 = 1
                goto L3a
            L36:
                r2 = move-exception
                r1 = r3
                goto L68
            L39:
                r3 = 0
            L3a:
                if (r3 == 0) goto L43
                boolean r2 = com.amap.api.col.p0003l.b3.i0(r2)     // Catch: java.lang.Throwable -> L36
                if (r2 == 0) goto L43
                goto L44
            L43:
                r1 = 0
            L44:
                com.amap.api.col.3l.q9 r2 = com.amap.api.col.p0003l.q9.this     // Catch: java.lang.Throwable -> L24
                com.amap.api.maps.interfaces.IGlOverlayLayer r2 = com.amap.api.col.p0003l.q9.W(r2)     // Catch: java.lang.Throwable -> L24
                if (r2 == 0) goto L55
                com.amap.api.col.3l.q9 r2 = com.amap.api.col.p0003l.q9.this     // Catch: java.lang.Throwable -> L24
                com.amap.api.maps.interfaces.IGlOverlayLayer r2 = com.amap.api.col.p0003l.q9.W(r2)     // Catch: java.lang.Throwable -> L24
                r2.clearTileCache()     // Catch: java.lang.Throwable -> L24
            L55:
                com.amap.api.col.3l.q9 r0 = com.amap.api.col.p0003l.q9.this     // Catch: java.lang.Throwable -> L63
                com.autonavi.base.ae.gmap.GLMapEngine r0 = r0.Z     // Catch: java.lang.Throwable -> L63
                if (r0 == 0) goto L82
                com.amap.api.maps.AMap$OnCacheRemoveListener r0 = r6.f7142b     // Catch: java.lang.Throwable -> L63
                if (r0 == 0) goto L82
                r0.onRemoveCacheFinish(r1)     // Catch: java.lang.Throwable -> L63
                return
            L63:
                r0 = move-exception
                r0.printStackTrace()
                return
            L68:
                com.amap.api.col.p0003l.b3.D(r2)     // Catch: java.lang.Throwable -> L87
                java.lang.String r3 = "AMapDelegateImp"
                java.lang.String r4 = "RemoveCacheRunnable"
                com.amap.api.col.p0003l.v5.p(r2, r3, r4)     // Catch: java.lang.Throwable -> L87
                com.amap.api.col.3l.q9 r1 = com.amap.api.col.p0003l.q9.this     // Catch: java.lang.Throwable -> L80
                com.autonavi.base.ae.gmap.GLMapEngine r1 = r1.Z     // Catch: java.lang.Throwable -> L80
                if (r1 == 0) goto L82
                com.amap.api.maps.AMap$OnCacheRemoveListener r1 = r6.f7142b     // Catch: java.lang.Throwable -> L80
                if (r1 == 0) goto L82
                r1.onRemoveCacheFinish(r0)     // Catch: java.lang.Throwable -> L80
                goto L82
            L80:
                r0 = move-exception
                goto L83
            L82:
                return
            L83:
                r0.printStackTrace()
                return
            L87:
                r0 = move-exception
                com.amap.api.col.3l.q9 r2 = com.amap.api.col.p0003l.q9.this     // Catch: java.lang.Throwable -> L96
                com.autonavi.base.ae.gmap.GLMapEngine r2 = r2.Z     // Catch: java.lang.Throwable -> L96
                if (r2 == 0) goto L9a
                com.amap.api.maps.AMap$OnCacheRemoveListener r2 = r6.f7142b     // Catch: java.lang.Throwable -> L96
                if (r2 == 0) goto L9a
                r2.onRemoveCacheFinish(r1)     // Catch: java.lang.Throwable -> L96
                goto L9a
            L96:
                r1 = move-exception
                r1.printStackTrace()
            L9a:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.3l.q9.w0.run():void");
        }

        public w0(Context context, AMap.OnCacheRemoveListener onCacheRemoveListener) {
            this.f7141a = context;
            this.f7142b = onCacheRemoveListener;
        }

        public final boolean equals(Object obj) {
            return obj instanceof w0;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class x implements Runnable {
        x() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                q9 q9Var = q9.this;
                q9Var.f7028q.setAnchorX(Math.max(0, Math.min(q9Var.f7031r0, q9.this.f6998d0)));
                q9 q9Var2 = q9.this;
                q9Var2.f7028q.setAnchorY(Math.max(0, Math.min(q9Var2.f7033s0, q9.this.f7001e0)));
                q9 q9Var3 = q9.this;
                q9Var3.Z.setProjectionCenter(q9Var3.f7022n, q9.this.f7028q.getAnchorX(), q9.this.f7028q.getAnchorY());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class y extends t0 {
        y() {
            super((byte) 0);
        }

        @Override // com.amap.api.col.3l.q9.t0, java.lang.Runnable
        public final void run() {
            super.run();
            q9.this.g(this.f7124e, this.f7122c, this.f7123d);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class z implements Runnable {
        z() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            q9 q9Var = q9.this;
            GLMapEngine gLMapEngine = q9Var.Z;
            if (gLMapEngine != null) {
                int i6 = q9Var.f7022n;
                com.amap.api.col.p0003l.z zVar = q9.this.f7034t;
                gLMapEngine.setIndoorBuildingToBeActive(i6, zVar.activeFloorName, zVar.activeFloorIndex, zVar.poiid);
            }
        }
    }

    public q9(IGLSurfaceView iGLSurfaceView, Context context) {
        this(iGLSurfaceView, context, false);
    }

    private boolean M(MotionEvent motionEvent) {
        try {
            List a6 = this.f6991b.a(AMap.OnPolylineClickListener.class.hashCode());
            if (a6 != null && a6.size() > 0) {
                DPoint obtain = DPoint.obtain();
                getPixel2LatLng((int) motionEvent.getX(), (int) motionEvent.getY(), obtain);
                LatLng latLng = new LatLng(obtain.f9904y, obtain.f9903x);
                obtain.recycle();
                Polyline hitOverlay = this.f7018l.getHitOverlay(latLng, 2);
                if (hitOverlay != null) {
                    synchronized (a6) {
                        try {
                            Iterator it = a6.iterator();
                            while (it.hasNext()) {
                                ((AMap.OnPolylineClickListener) it.next()).onPolylineClick(hitOverlay);
                            }
                        } finally {
                        }
                    }
                    return false;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private void O() {
        this.f6995c0 = true;
        this.f7015j0 = false;
        if (this.B) {
            this.B = false;
        }
        if (this.A) {
            this.A = false;
        }
        if (this.C) {
            this.C = false;
        }
        try {
            if (this.f7040w) {
                List a6 = this.f6991b.a(AMap.OnMarkerDragListener.class.hashCode());
                if (a6 != null && a6.size() > 0 && this.f7044y != null) {
                    synchronized (a6) {
                        for (int i6 = 0; i6 < a6.size(); i6++) {
                            try {
                                ((AMap.OnMarkerDragListener) a6.get(i6)).onMarkerDragEnd(this.f7044y);
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                    this.f7044y = null;
                }
                this.f7040w = false;
            }
        } catch (Throwable th2) {
            v5.p(th2, "AMapDelegateImp", "OnMarkerDragListener.onMarkerDragEnd");
            th2.printStackTrace();
        }
        if (this.f7042x) {
            if (this.f7046z != null) {
                this.f7046z = null;
            }
            this.f7042x = false;
        }
    }

    static /* synthetic */ boolean V(q9 q9Var) {
        q9Var.f7017k0 = false;
        return false;
    }

    private synchronized void a0() {
        synchronized (this.T) {
            try {
                int size = this.T.size();
                for (int i6 = 0; i6 < size; i6++) {
                    this.T.get(i6).a().recycle();
                }
                this.T.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private boolean c0(MotionEvent motionEvent) throws RemoteException {
        try {
            List a6 = this.f6991b.a(AMap.OnInfoWindowClickListener.class.hashCode());
            BaseOverlay f6 = this.f6997d.f(motionEvent);
            if (f6 != null && (f6 instanceof Marker)) {
                synchronized (a6) {
                    for (int i6 = 0; i6 < a6.size(); i6++) {
                        try {
                            ((AMap.OnInfoWindowClickListener) a6.get(i6)).onInfoWindowClick((Marker) f6);
                        } finally {
                        }
                    }
                }
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    static /* synthetic */ boolean f0(q9 q9Var) {
        q9Var.D = false;
        return false;
    }

    private synchronized void i(int i6, int i7, int i8, boolean z5, StyleItem[] styleItemArr) {
        try {
            try {
                if (this.f7021m0 && this.f7019l0 && this.f7009h) {
                    P(i8);
                    queueEvent(new e(i6, i7, i8, z5, styleItemArr));
                    return;
                }
                t0 t0Var = this.C0;
                t0Var.f7124e = i6;
                t0Var.f7122c = i7;
                t0Var.f7123d = i8;
                t0Var.f7120a = true;
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    private boolean v(boolean z5, boolean z6) {
        if (z5) {
            if (this.T0) {
                i2.c("setCustomMapStyle 和 setWorldVectorMapStyle 不能同时使用，setCustomMapStyle将不会生效");
                return true;
            }
            this.S0 = true;
        }
        if (!z6) {
            return false;
        }
        if (this.S0) {
            i2.c("setCustomMapStyle 和 setWorldVectorMapStyle 不能同时使用，setWorldVectorMapStyle将不会生效");
            return true;
        }
        this.T0 = true;
        return false;
    }

    @Override // com.amap.api.col.3l.u8.a
    public final void a() {
        com.autonavi.extra.b bVar = this.P0;
        if (bVar != null) {
            bVar.i();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final Arc addArc(ArcOptions arcOptions) throws RemoteException {
        if (arcOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            ArcOptions m48clone = arcOptions.m48clone();
            String createId = this.f7018l.createId("ARC");
            Arc arc = new Arc(this.f7018l, m48clone, createId);
            IGlOverlayLayer iGlOverlayLayer = this.f7018l;
            return iGlOverlayLayer != null ? (Arc) iGlOverlayLayer.addOverlayObject(createId, arc, m48clone) : arc;
        } catch (Throwable th) {
            b3.D(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final BuildingOverlay addBuildingOverlay() {
        try {
            y2.u(this.Y);
            String createId = this.f7018l.createId("BUILDINGOVERLAY");
            BuildingOverlay buildingOverlay = new BuildingOverlay(this.f7018l, createId);
            Field declaredField = BuildingOverlay.class.getDeclaredField("buildingOverlayTotalOptions");
            if (declaredField == null) {
                return null;
            }
            resetRenderTime();
            declaredField.setAccessible(true);
            Object obj = declaredField.get(buildingOverlay);
            IGlOverlayLayer iGlOverlayLayer = this.f7018l;
            return (iGlOverlayLayer == null || !(obj instanceof BaseOptions)) ? buildingOverlay : (BuildingOverlay) iGlOverlayLayer.addOverlayObject(createId, buildingOverlay, (BaseOptions) obj);
        } catch (Exception e6) {
            e6.printStackTrace();
            b3.D(e6);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final Circle addCircle(CircleOptions circleOptions) throws RemoteException {
        if (circleOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            CircleOptions m50clone = circleOptions.m50clone();
            String createId = this.f7018l.createId("CIRCLE");
            Circle circle = new Circle(this.f7018l, m50clone, createId);
            IGlOverlayLayer iGlOverlayLayer = this.f7018l;
            return iGlOverlayLayer != null ? (Circle) iGlOverlayLayer.addOverlayObject(createId, circle, m50clone) : circle;
        } catch (Throwable th) {
            b3.D(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final GLTFOverlay addGLTFOverlay(GLTFOverlayOptions gLTFOverlayOptions) throws RemoteException {
        try {
            if (ha.a().d() && !ha.a().c("feature_gltf")) {
                b3.D(new AMapException(AMapException.FEATURE_GLTF_NOT_SUPPORT));
                return null;
            }
            resetRenderTime();
            GLTFOverlayOptions m51clone = gLTFOverlayOptions.m51clone();
            String createId = this.f7018l.createId("GLTFOVERLAY");
            GLTFOverlay gLTFOverlay = new GLTFOverlay(this.f7018l, m51clone, createId);
            this.f7018l.addOverlayObject(createId, gLTFOverlay, m51clone);
            return gLTFOverlay;
        } catch (Throwable th) {
            b3.D(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final GroundOverlay addGroundOverlay(GroundOverlayOptions groundOverlayOptions) throws RemoteException {
        if (groundOverlayOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            GroundOverlayOptions m52clone = groundOverlayOptions.m52clone();
            String createId = this.f7018l.createId("GROUNDOVERLAY");
            GroundOverlay groundOverlay = new GroundOverlay(this.f7018l, m52clone, createId);
            IGlOverlayLayer iGlOverlayLayer = this.f7018l;
            return iGlOverlayLayer != null ? (GroundOverlay) iGlOverlayLayer.addOverlayObject(createId, groundOverlay, m52clone) : groundOverlay;
        } catch (Throwable th) {
            b3.D(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final HeatMapGridLayer addHeatMapGridLayer(HeatMapGridLayerOptions heatMapGridLayerOptions) throws RemoteException {
        try {
            resetRenderTime();
            if (heatMapGridLayerOptions == null) {
                return null;
            }
            String createId = this.f7018l.createId("HEATMAPGRIDLAYER");
            return (HeatMapGridLayer) this.f7018l.addOverlayObject(createId, new HeatMapGridLayer(this.f7018l, heatMapGridLayerOptions, createId), heatMapGridLayerOptions);
        } catch (Throwable th) {
            b3.D(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final HeatMapLayer addHeatMapLayer(HeatMapLayerOptions heatMapLayerOptions) throws RemoteException {
        try {
            resetRenderTime();
            if (heatMapLayerOptions == null) {
                return null;
            }
            String createId = this.f7018l.createId("HEATMAPLAYER");
            return (HeatMapLayer) this.f7018l.addOverlayObject(createId, new HeatMapLayer(this.f7018l, heatMapLayerOptions, createId), heatMapLayerOptions);
        } catch (Throwable th) {
            b3.D(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final MVTTileOverlay addMVTTileOverlay(MVTTileOverlayOptions mVTTileOverlayOptions) throws RemoteException {
        try {
            if (ha.a().d() && !ha.a().c("feature_mvt")) {
                b3.D(new AMapException(AMapException.FEATURE_MVT_NOT_SUPPORT));
                return null;
            }
            String createId = this.f7018l.createId("MVTTILEOVERLAY");
            MVTTileOverlay mVTTileOverlay = new MVTTileOverlay(this.f7018l, mVTTileOverlayOptions, createId);
            this.f7018l.addOverlayObject(createId, mVTTileOverlay, mVTTileOverlayOptions);
            return mVTTileOverlay;
        } catch (Throwable th) {
            b3.D(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final MultiPointOverlay addMultiPointOverlay(MultiPointOverlayOptions multiPointOverlayOptions) throws RemoteException {
        if (multiPointOverlayOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            MultiPointOverlayOptions m55clone = multiPointOverlayOptions.m55clone();
            String createId = this.f7018l.createId("MULTIOVERLAY");
            MultiPointOverlay multiPointOverlay = new MultiPointOverlay(this.f7018l, m55clone, createId);
            IGlOverlayLayer iGlOverlayLayer = this.f7018l;
            return iGlOverlayLayer != null ? (MultiPointOverlay) iGlOverlayLayer.addOverlayObject(createId, multiPointOverlay, m55clone) : multiPointOverlay;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final NavigateArrow addNavigateArrow(NavigateArrowOptions navigateArrowOptions) throws RemoteException {
        if (navigateArrowOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            NavigateArrowOptions m56clone = navigateArrowOptions.m56clone();
            String createId = this.f7018l.createId("NAVIGATEARROW");
            NavigateArrow navigateArrow = new NavigateArrow(this.f7018l, m56clone, createId);
            IGlOverlayLayer iGlOverlayLayer = this.f7018l;
            return iGlOverlayLayer != null ? (NavigateArrow) iGlOverlayLayer.addOverlayObject(createId, navigateArrow, m56clone) : navigateArrow;
        } catch (Throwable th) {
            b3.D(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final ParticleOverlay addParticleOverlay(ParticleOverlayOptions particleOverlayOptions) {
        if (particleOverlayOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            y2.n(this.Y);
            String createId = this.f7018l.createId("PARTICLEOVERLAY");
            return (ParticleOverlay) this.f7018l.addOverlayObject(createId, new ParticleOverlay(this.f7018l, particleOverlayOptions, createId), particleOverlayOptions);
        } catch (Throwable th) {
            b3.D(th);
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final Polygon addPolygon(PolygonOptions polygonOptions) throws RemoteException {
        if (polygonOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            PolygonOptions m57clone = polygonOptions.m57clone();
            String createId = this.f7018l.createId("POLYGON");
            Polygon polygon = new Polygon(this.f7018l, m57clone, createId);
            IGlOverlayLayer iGlOverlayLayer = this.f7018l;
            return iGlOverlayLayer != null ? (Polygon) iGlOverlayLayer.addOverlayObject(createId, polygon, m57clone) : polygon;
        } catch (Throwable th) {
            b3.D(th);
            d3.g(c3.f5804d, "addPolygon failed " + th.getMessage(), polygonOptions);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final Polyline addPolyline(PolylineOptions polylineOptions) throws RemoteException {
        if (polylineOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            String createId = this.f7018l.createId("POLYLINE");
            Polyline polyline = (Polyline) this.f7018l.addOverlayObject(createId, new Polyline(this.f7018l, polylineOptions, createId), polylineOptions);
            d3.m(c3.f5804d, "addPolyline ".concat(String.valueOf(createId)));
            return polyline;
        } catch (Throwable th) {
            b3.D(th);
            d3.h(c3.f5804d, "addPolyline failed " + th.getMessage(), polylineOptions);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void animateCamera(CameraUpdate cameraUpdate) throws RemoteException {
        if (cameraUpdate == null) {
            return;
        }
        animateCamera(cameraUpdate.getCameraUpdateFactoryDelegate());
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void animateCameraWithDurationAndCallback(CameraUpdate cameraUpdate, long j6, AMap.CancelableCallback cancelableCallback) {
        if (cameraUpdate == null) {
            return;
        }
        animateCameraWithDurationAndCallback(cameraUpdate.getCameraUpdateFactoryDelegate(), j6, cancelableCallback);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void changeSurface(int i6, GL10 gl10, int i7, int i8) {
        WindowManager windowManager;
        d3.e(c3.f5803c, "changeSurface " + i7 + " " + i8);
        this.f7025o0 = false;
        if (!this.f7019l0) {
            createSurface(i6, gl10, null);
        }
        ia iaVar = this.f6992b0;
        if (iaVar != null && this.Y != null && ((this.f6998d0 != iaVar.g() || this.f7001e0 != this.f6992b0.j()) && (windowManager = (WindowManager) this.Y.getSystemService("window")) != null)) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (defaultDisplay != null) {
                defaultDisplay.getRealMetrics(displayMetrics);
                this.f6992b0.c(displayMetrics.widthPixels, displayMetrics.heightPixels);
            }
        }
        this.f6998d0 = i7;
        this.f7001e0 = i8;
        this.H = new Rect(0, 0, i7, i8);
        this.f7022n = b(i6, new Rect(0, 0, this.f6998d0, this.f7001e0), this.f6998d0, this.f7001e0);
        d3.e(c3.f5803c, "create engine with frame complete");
        if (!this.f7021m0) {
            MapConfig mapConfig = this.f7028q;
            if (mapConfig != null) {
                mapConfig.setMapZoomScale(this.f7007g0);
                this.f7028q.setMapWidth(i7);
                this.f7028q.setMapHeight(i8);
            }
            this.Z.setIndoorEnable(this.f7022n, false);
            this.Z.setSimple3DEnable(this.f7022n, false);
            this.Z.setStyleChangeGradualEnable(this.f7022n, false);
            this.Z.initMapOpenLayer("{\"bounds\" : [{\"x2\" : 235405312,\"x1\" : 188874751,\"y2\" : 85065727,\"y1\" : 122421247}],\"sublyr\" : [{\"type\" : 4,\"sid\" : 9000006,\"zlevel\" : 2}],\"id\" : 9006,\"minzoom\" : 6,\"update_period\" : 90,\"maxzoom\" : 20,\"cachemode\" : 2,\"url\" : \"http://mpsapi.amap.com/ws/mps/lyrdata/ugc/\"}");
            GLMapEngine.InitParam initParam = new GLMapEngine.InitParam();
            AeUtil.initIntersectionRes(this.Y, initParam);
            this.Z.setVectorOverlayPath(initParam.mIntersectionResPath);
        }
        synchronized (this) {
            this.f7021m0 = true;
        }
        if (this.f7030r) {
            this.f7028q.setAnchorX(Math.max(1, Math.min(this.f7031r0, i7 - 1)));
            this.f7028q.setAnchorY(Math.max(1, Math.min(this.f7033s0, i8 - 1)));
        } else {
            this.f7028q.setAnchorX(i7 >> 1);
            this.f7028q.setAnchorY(i8 >> 1);
        }
        this.Z.setProjectionCenter(this.f7022n, this.f7028q.getAnchorX(), this.f7028q.getAnchorY());
        this.f7009h = true;
        t0 t0Var = this.L0;
        if (t0Var.f7120a) {
            t0Var.run();
        }
        t0 t0Var2 = this.C0;
        if (t0Var2.f7120a) {
            t0Var2.run();
        }
        t0 t0Var3 = this.D0;
        if (t0Var3.f7120a) {
            t0Var3.run();
        }
        t0 t0Var4 = this.A0;
        if (t0Var4.f7120a) {
            t0Var4.run();
        }
        t0 t0Var5 = this.E0;
        if (t0Var5.f7120a) {
            t0Var5.run();
        }
        t0 t0Var6 = this.O0;
        if (t0Var6.f7120a) {
            t0Var6.run();
        }
        t0 t0Var7 = this.F0;
        if (t0Var7.f7120a) {
            t0Var7.run();
        }
        t0 t0Var8 = this.G0;
        if (t0Var8.f7120a) {
            t0Var8.run();
        }
        t0 t0Var9 = this.H0;
        if (t0Var9.f7120a) {
            t0Var9.run();
        }
        t0 t0Var10 = this.M0;
        if (t0Var10.f7120a) {
            t0Var10.run();
        }
        t0 t0Var11 = this.B0;
        if (t0Var11.f7120a) {
            t0Var11.run();
        }
        t0 t0Var12 = this.I0;
        if (t0Var12.f7120a) {
            t0Var12.run();
        }
        t0 t0Var13 = this.J0;
        if (t0Var13 != null) {
            t0Var13.run();
        }
        t0 t0Var14 = this.K0;
        if (t0Var14 != null) {
            t0Var14.run();
        }
        CustomRenderer customRenderer = this.Q;
        if (customRenderer != null) {
            customRenderer.onSurfaceChanged(gl10, i7, i8);
        }
        com.autonavi.extra.b bVar = this.P0;
        if (bVar != null) {
            bVar.d();
        }
        Handler handler = this.f7047z0;
        if (handler != null) {
            handler.post(this.N0);
        }
        redrawInfoWindow();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void clear() throws RemoteException {
        try {
            clear(false);
        } catch (Throwable th) {
            v5.p(th, "AMapDelegateImp", "clear");
            b3.D(th);
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final int createOverlayTexture(int i6, Bitmap bitmap) {
        try {
            GLMapEngine gLMapEngine = this.Z;
            if (gLMapEngine == null || bitmap == null) {
                return -1;
            }
            return gLMapEngine.createOverlayTexture(i6, bitmap);
        } catch (Throwable th) {
            b3.D(th);
        }
        return -1;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(19:2|3|(16:8|9|10|11|(1:13)|14|15|(1:17)|18|(1:22)|23|(1:25)|26|(1:28)|29|30)|38|9|10|11|(0)|14|15|(0)|18|(2:20|22)|23|(0)|26|(0)|29|30) */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0086, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0094, code lost:
    
        com.amap.api.col.p0003l.b3.D(r4);
        com.amap.api.col.p0003l.v5.p(r4, "AMapDElegateImp", "createSurface");
        com.amap.api.col.p0003l.d3.l(com.amap.api.col.p0003l.c3.f5803c, "createSurface failed " + r4.getMessage());
        com.amap.api.col.p0003l.y2.l(r3.Y, "init failed:" + r4.getMessage());
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0082 A[Catch: all -> 0x0086, TryCatch #1 {all -> 0x0086, blocks: (B:11:0x0046, B:13:0x0082, B:14:0x0088), top: B:10:0x0046, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00dc A[Catch: all -> 0x0023, TryCatch #0 {all -> 0x0023, blocks: (B:3:0x0001, B:8:0x0017, B:9:0x0031, B:15:0x00cc, B:17:0x00dc, B:18:0x00df, B:20:0x00e5, B:22:0x00e9, B:23:0x00f7, B:25:0x00fb, B:26:0x00fe, B:28:0x0102, B:29:0x0105, B:37:0x0094, B:38:0x0026, B:11:0x0046, B:13:0x0082, B:14:0x0088), top: B:2:0x0001, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00fb A[Catch: all -> 0x0023, TryCatch #0 {all -> 0x0023, blocks: (B:3:0x0001, B:8:0x0017, B:9:0x0031, B:15:0x00cc, B:17:0x00dc, B:18:0x00df, B:20:0x00e5, B:22:0x00e9, B:23:0x00f7, B:25:0x00fb, B:26:0x00fe, B:28:0x0102, B:29:0x0105, B:37:0x0094, B:38:0x0026, B:11:0x0046, B:13:0x0082, B:14:0x0088), top: B:2:0x0001, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0102 A[Catch: all -> 0x0023, TryCatch #0 {all -> 0x0023, blocks: (B:3:0x0001, B:8:0x0017, B:9:0x0031, B:15:0x00cc, B:17:0x00dc, B:18:0x00df, B:20:0x00e5, B:22:0x00e9, B:23:0x00f7, B:25:0x00fb, B:26:0x00fe, B:28:0x0102, B:29:0x0105, B:37:0x0094, B:38:0x0026, B:11:0x0046, B:13:0x0082, B:14:0x0088), top: B:2:0x0001, inners: #1 }] */
    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void createSurface(int r4, javax.microedition.khronos.opengles.GL10 r5, javax.microedition.khronos.egl.EGLConfig r6) {
        /*
            Method dump skipped, instructions count: 270
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.q9.createSurface(int, javax.microedition.khronos.opengles.GL10, javax.microedition.khronos.egl.EGLConfig):void");
    }

    public final synchronized void g(int i6, int i7, int i8) {
        i(i6, i7, i8, false, null);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void geo2Latlng(int i6, int i7, DPoint dPoint) {
        DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(i6, i7, 20);
        dPoint.f9903x = pixelsToLatLong.f9903x;
        dPoint.f9904y = pixelsToLatLong.f9904y;
        pixelsToLatLong.recycle();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void geo2Map(int i6, int i7, FPoint fPoint) {
        ((PointF) fPoint).x = (int) (i6 - this.f7028q.getSX());
        ((PointF) fPoint).y = (int) (i7 - this.f7028q.getSY());
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final AMapCameraInfo getCamerInfo() {
        return null;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final CameraPosition getCameraPositionPrj(boolean z5) {
        LatLng X;
        try {
            if (this.f7028q == null) {
                return null;
            }
            if (!this.f7019l0 || this.f7026p || this.Z == null) {
                DPoint obtain = DPoint.obtain();
                geo2Latlng((int) this.f7028q.getSX(), (int) this.f7028q.getSY(), obtain);
                LatLng latLng = new LatLng(obtain.f9904y, obtain.f9903x);
                obtain.recycle();
                return CameraPosition.builder().target(latLng).bearing(this.f7028q.getSR()).tilt(this.f7028q.getSC()).zoom(this.f7028q.getSZ()).build();
            }
            if (z5) {
                DPoint obtain2 = DPoint.obtain();
                getPixel2LatLng(this.f7028q.getAnchorX(), this.f7028q.getAnchorY(), obtain2);
                X = new LatLng(obtain2.f9904y, obtain2.f9903x, false);
                obtain2.recycle();
            } else {
                X = X();
            }
            return CameraPosition.builder().target(X).bearing(this.f7028q.getSR()).tilt(this.f7028q.getSC()).zoom(this.f7028q.getSZ()).build();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final InfoWindowAnimationManager getInfoWindowAnimationManager() {
        return null;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final AMap.OnCameraChangeListener getOnCameraChangeListener() throws RemoteException {
        try {
            List a6 = this.f6991b.a(AMap.OnCameraChangeListener.class.hashCode());
            if (a6 == null && a6.size() != 0) {
                return (AMap.OnCameraChangeListener) a6.get(0);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final boolean isLockMapCameraDegree(int i6) {
        return false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void map2Geo(float f6, float f7, IPoint iPoint) {
        ((Point) iPoint).x = (int) (f6 + this.f7028q.getSX());
        ((Point) iPoint).y = (int) (f7 + this.f7028q.getSY());
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void moveCamera(CameraUpdate cameraUpdate) throws RemoteException {
        if (cameraUpdate == null) {
            return;
        }
        try {
            moveCamera(cameraUpdate.getCameraUpdateFactoryDelegate());
        } catch (Throwable th) {
            b3.D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void onActivityPause() {
        this.f7026p = true;
        G(this.f7022n);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void onActivityResume() {
        this.f7026p = false;
        L(this.f7022n);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void onLongPress(int i6, MotionEvent motionEvent) {
        int i7 = 0;
        try {
            this.A = false;
            y(i6);
            BaseOverlay hitBaseOverlay = this.f7018l.getHitBaseOverlay(motionEvent, 1);
            if (hitBaseOverlay instanceof Marker) {
                this.f7044y = (Marker) hitBaseOverlay;
            }
            BaseOverlay hitBaseOverlay2 = this.f7018l.getHitBaseOverlay(motionEvent, 3);
            if (hitBaseOverlay2 instanceof GLTFOverlay) {
                this.f7046z = (GLTFOverlay) hitBaseOverlay2;
            }
            Marker marker = this.f7044y;
            if (marker == null || !marker.isDraggable()) {
                GLTFOverlay gLTFOverlay = this.f7046z;
                if (gLTFOverlay == null || !gLTFOverlay.isDraggable()) {
                    List a6 = this.f6991b.a(AMap.OnMapLongClickListener.class.hashCode());
                    if (a6 != null && a6.size() > 0) {
                        DPoint obtain = DPoint.obtain();
                        getPixel2LatLng((int) motionEvent.getX(), (int) motionEvent.getY(), obtain);
                        synchronized (a6) {
                            while (i7 < a6.size()) {
                                try {
                                    ((AMap.OnMapLongClickListener) a6.get(i7)).onMapLongClick(new LatLng(obtain.f9904y, obtain.f9903x));
                                    i7++;
                                } finally {
                                }
                            }
                        }
                        this.B = true;
                        obtain.recycle();
                    }
                } else {
                    LatLng latlng = this.f7046z.getLatlng();
                    if (latlng != null) {
                        IPoint obtain2 = IPoint.obtain();
                        getLatLng2Pixel(latlng.latitude, latlng.longitude, obtain2);
                        ((Point) obtain2).y -= 60;
                        DPoint obtain3 = DPoint.obtain();
                        getPixel2LatLng(((Point) obtain2).x, ((Point) obtain2).y, obtain3);
                        this.f7046z.setLatLng(new LatLng(obtain3.f9904y, obtain3.f9903x));
                        this.f7018l.set2Top(this.f7046z.getId());
                        this.f7042x = true;
                        obtain2.recycle();
                        obtain3.recycle();
                    }
                }
            } else {
                LatLng position = this.f7044y.getPosition();
                if (position != null) {
                    IPoint obtain4 = IPoint.obtain();
                    getLatLng2Pixel(position.latitude, position.longitude, obtain4);
                    ((Point) obtain4).y -= 60;
                    DPoint obtain5 = DPoint.obtain();
                    getPixel2LatLng(((Point) obtain4).x, ((Point) obtain4).y, obtain5);
                    this.f7044y.setPosition(new LatLng(obtain5.f9904y, obtain5.f9903x));
                    this.f7018l.set2Top(this.f7044y.getId());
                    try {
                        List a7 = this.f6991b.a(AMap.OnMarkerDragListener.class.hashCode());
                        if (a7 != null && a7.size() > 0) {
                            synchronized (a7) {
                                while (i7 < a7.size()) {
                                    try {
                                        ((AMap.OnMarkerDragListener) a7.get(i7)).onMarkerDragStart(this.f7044y);
                                        i7++;
                                    } finally {
                                    }
                                }
                            }
                        }
                    } catch (Throwable th) {
                        v5.p(th, "AMapDelegateImp", "onMarkerDragStart");
                        th.printStackTrace();
                    }
                    this.f7040w = true;
                    obtain4.recycle();
                    obtain5.recycle();
                }
            }
            this.f6989a0.resetTickCount(30);
        } catch (Throwable th2) {
            v5.p(th2, "AMapDelegateImp", "onLongPress");
            th2.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removecache() throws RemoteException {
        removecache(null);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setCenterToPixel(int i6, int i7) throws RemoteException {
        this.f7030r = true;
        this.f7031r0 = i6;
        this.f7033s0 = i7;
        if (this.f7021m0 && this.f7019l0) {
            if (this.f7028q.getAnchorX() == this.f7031r0 && this.f7028q.getAnchorY() == this.f7033s0) {
                return;
            }
            this.f7028q.setAnchorX(this.f7031r0);
            this.f7028q.setAnchorY(this.f7033s0);
            queueEvent(new x());
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setCustomMapStyle(CustomMapStyleOptions customMapStyleOptions) {
        if (customMapStyleOptions != null) {
            try {
                if (v(true, false)) {
                    return;
                }
                if (customMapStyleOptions.isEnable()) {
                    if (customMapStyleOptions.getStyleId() == null) {
                        if (customMapStyleOptions.getStyleTexturePath() == null) {
                            if (customMapStyleOptions.getStyleTextureData() == null) {
                                if (customMapStyleOptions.getStyleResDataPath() == null) {
                                    if (customMapStyleOptions.getStyleResData() != null) {
                                    }
                                }
                            }
                        }
                    }
                    q0();
                }
                this.f7041w0.n();
                this.f7041w0.d(customMapStyleOptions);
                com.autonavi.extra.b bVar = this.P0;
                if (bVar != null) {
                    bVar.i();
                }
            } catch (Throwable th) {
                b3.D(th);
                return;
            }
        }
        resetRenderTime();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setInfoWindowAdapter(AMap.InfoWindowAdapter infoWindowAdapter) throws RemoteException {
        com.amap.api.col.p0003l.a0 a0Var;
        if (this.f7024o.get() || (a0Var = this.f6997d) == null) {
            return;
        }
        a0Var.i(infoWindowAdapter);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setMapCustomEnable(boolean z5, boolean z6) {
        x1 x1Var;
        if (!this.f7019l0 || this.f7024o.get()) {
            t0 t0Var = this.D0;
            t0Var.f7120a = true;
            t0Var.f7121b = z5;
            return;
        }
        boolean z7 = z6 ? z6 : false;
        if (TextUtils.isEmpty(this.f7028q.getCustomStylePath()) && TextUtils.isEmpty(this.f7028q.getCustomStyleID())) {
            return;
        }
        if (z5) {
            try {
                if (this.f7028q.isProFunctionAuthEnable() && !TextUtils.isEmpty(this.f7028q.getCustomStyleID()) && (x1Var = this.U) != null) {
                    x1Var.b(this.f7028q.getCustomStyleID());
                    this.U.b();
                }
            } catch (Throwable th) {
                th.printStackTrace();
                b3.D(th);
                return;
            }
        }
        if (z6 || this.f7012i || (this.f7028q.isCustomStyleEnable() ^ z5)) {
            r(z5, null, z7);
        }
        this.f7012i = false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setRenderFps(int i6) {
        try {
            if (i6 == -1) {
                this.S = i6;
            } else {
                this.S = Math.max(10, Math.min(i6, 40));
            }
            y2.t(this.Y);
        } catch (Throwable th) {
            b3.D(th);
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setWorldVectorMapStyle(String str) {
        if (v(false, true) || TextUtils.isEmpty(str) || this.f7028q == null || this.R0.equals(str)) {
            return;
        }
        this.R0 = str;
        com.autonavi.extra.b bVar = this.P0;
        if (bVar != null) {
            bVar.i();
        }
        resetRenderTime();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void showInfoWindow(BaseOverlayImp baseOverlayImp) throws RemoteException {
        com.amap.api.col.p0003l.a0 a0Var;
        if (baseOverlayImp == null || (a0Var = this.f6997d) == null) {
            return;
        }
        try {
            a0Var.k(baseOverlayImp);
        } catch (RemoteException e6) {
            e6.printStackTrace();
        }
    }

    public q9(IGLSurfaceView iGLSurfaceView, Context context, boolean z5) {
        this.f6988a = null;
        this.f6991b = new aa();
        byte b6 = 0;
        this.f7009h = false;
        this.f7012i = false;
        this.f7020m = false;
        this.f7024o = new AtomicBoolean(false);
        this.f7026p = false;
        this.f7028q = new MapConfig(true);
        this.f7030r = false;
        this.f7032s = false;
        this.f7040w = false;
        this.f7042x = false;
        this.f7044y = null;
        this.f7046z = null;
        this.A = false;
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = 0;
        this.F = true;
        this.G = true;
        this.H = new Rect();
        this.I = 1;
        this.J = null;
        this.N = false;
        this.O = false;
        this.P = 0;
        this.R = -1;
        this.S = -1;
        this.T = new ArrayList();
        this.W = null;
        this.X = -1L;
        this.f6995c0 = false;
        this.f7004f0 = 0.0f;
        this.f7007g0 = 1.0f;
        this.f7010h0 = 1.0f;
        this.f7013i0 = true;
        this.f7015j0 = false;
        this.f7017k0 = false;
        this.f7019l0 = false;
        this.f7021m0 = false;
        this.f7023n0 = false;
        this.f7025o0 = false;
        this.f7027p0 = new ReentrantLock();
        this.f7029q0 = 0;
        this.f7045y0 = true;
        this.f7047z0 = new k(Looper.getMainLooper());
        this.A0 = new b();
        this.B0 = new m();
        this.C0 = new y();
        this.D0 = new i0();
        this.E0 = new j0();
        this.F0 = new k0();
        this.G0 = new l0();
        this.H0 = new m0();
        this.I0 = new v();
        this.J0 = new g0();
        this.K0 = new n0();
        this.L0 = new o0();
        this.M0 = new p0();
        this.N0 = new q0();
        this.O0 = new r0();
        this.Q0 = "";
        this.R0 = "";
        this.S0 = false;
        this.T0 = false;
        this.U0 = 0;
        this.V0 = new EAMapPlatformGestureInfo();
        this.W0 = new Point();
        this.X0 = 0L;
        this.Y0 = null;
        this.Z0 = null;
        this.f6990a1 = new float[16];
        this.f6993b1 = new float[16];
        this.f6996c1 = new float[16];
        this.f6999d1 = null;
        this.f7002e1 = new float[12];
        this.f7005f1 = "precision highp float;\nattribute vec3 aVertex;//顶点数组,三维坐标\nuniform mat4 aMVPMatrix;//mvp矩阵\nvoid main(){\n  gl_Position = aMVPMatrix * vec4(aVertex, 1.0);\n}";
        this.f7008g1 = "//有颜色 没有纹理\nprecision highp float;\nvoid main(){\n  gl_FragColor = vec4(1.0,0,0,1.0);\n}";
        this.f7011h1 = -1;
        this.Y = context;
        n4 a6 = ft.a(context, b3.s());
        ft.c cVar = a6.f6803a;
        ft.c cVar2 = ft.c.SuccessCode;
        if (cVar == cVar2) {
            d3.d(context);
            d3.e(c3.f5803c, "init map delegate");
        }
        com.autonavi.extra.b bVar = new com.autonavi.extra.b();
        this.P0 = bVar;
        bVar.a();
        this.P0.b();
        v5.h(this.Y);
        p2.a().b(this.Y);
        ga.f6365b = f4.g(context);
        h2.a(this.Y);
        this.f6992b0 = new ia(this);
        GLMapRender gLMapRender = new GLMapRender(this);
        this.f6989a0 = gLMapRender;
        this.f7014j = iGLSurfaceView;
        iGLSurfaceView.setRenderer(gLMapRender);
        com.amap.api.col.p0003l.c cVar3 = new com.amap.api.col.p0003l.c(this, this.Y);
        this.f7018l = cVar3;
        this.Z = new GLMapEngine(this.Y, this);
        this.f7016k = new eh(this.Y, this, cVar3);
        this.f7006g = new com.amap.api.col.p0003l.i(this);
        this.f7016k.j(new v0(this, b6));
        this.f7035t0 = new u0();
        iGLSurfaceView.setRenderMode(0);
        this.f6989a0.setRenderFps(15.0f);
        this.Z.setMapListener(this);
        this.f7003f = new com.amap.api.col.p0003l.f(this);
        this.f6988a = new z9(this);
        com.amap.api.col.p0003l.a0 a0Var = new com.amap.api.col.p0003l.a0(this.Y);
        this.f6997d = a0Var;
        a0Var.l(this.f7016k);
        this.f6997d.s(new s1(cVar3, context));
        this.K = new da(this.Y, this);
        this.f7038v = new com.amap.api.col.p0003l.b0(this.Y);
        this.U = new x1(this.Y, this);
        z1 z1Var = new z1(this.Y);
        this.V = z1Var;
        z1Var.b(this);
        q(z5);
        MapConfig mapConfig = this.f7028q;
        u8 u8Var = new u8(this, this.Y, mapConfig != null ? mapConfig.isAbroadEnable() : false);
        this.f7041w0 = u8Var;
        u8Var.c(this);
        if (a6.f6803a != cVar2) {
            this.f7028q.setMapEnable(false);
        }
        this.f7022n = this.Z.getEngineIDWithType(1);
    }

    private void B(MotionEvent motionEvent) {
        if (!this.f7042x || this.f7046z == null) {
            return;
        }
        int x5 = (int) motionEvent.getX();
        int y5 = (int) (motionEvent.getY() - 60.0f);
        if (this.f7046z.getLatlng() != null) {
            DPoint obtain = DPoint.obtain();
            getPixel2LatLng(x5, y5, obtain);
            LatLng latLng = new LatLng(obtain.f9904y, obtain.f9903x);
            obtain.recycle();
            this.f7046z.setLatLng(latLng);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(CameraPosition cameraPosition) {
        if (!this.f7028q.getMapLanguage().equals("en")) {
            if (this.G) {
                return;
            }
            this.G = true;
            z(this.f7022n, true);
            return;
        }
        boolean J = J(cameraPosition);
        if (J != this.G) {
            this.G = J;
            z(this.f7022n, J);
        }
    }

    private void D(boolean z5) {
        this.f7013i0 = z5;
    }

    private float E() {
        if (this.f7028q != null) {
            return getMapConfig().getSZ();
        }
        return 0.0f;
    }

    private void G(int i6) {
        if (this.f7015j0) {
            this.f7015j0 = false;
        }
        GLMapRender gLMapRender = this.f6989a0;
        if (gLMapRender != null) {
            gLMapRender.renderPause();
        }
        T(i6);
    }

    private void I(MotionEvent motionEvent) {
        queueEvent(new s0(motionEvent));
    }

    private boolean J(CameraPosition cameraPosition) {
        if (cameraPosition.zoom < 6.0f) {
            return false;
        }
        if (cameraPosition.isAbroad) {
            return true;
        }
        if (this.f7028q != null) {
            try {
                return !u2.c(r4.getGeoRectangle().getClipRect());
            } catch (Throwable th) {
                th.printStackTrace();
                b3.D(th);
            }
        }
        return false;
    }

    private void K() {
        if (this.f7019l0) {
            this.f6992b0.b();
            this.f6995c0 = true;
            this.f7015j0 = true;
            try {
                stopAnimation();
            } catch (RemoteException unused) {
            }
        }
    }

    private void P(int i6) {
        i3 i3Var = this.f7016k;
        if (i3Var != null) {
            if (i6 == 0) {
                if (i3Var.b()) {
                    this.f7016k.o(Boolean.FALSE);
                    this.f7016k.c();
                    return;
                }
                return;
            }
            if (i3Var.b()) {
                return;
            }
            this.f7016k.o(Boolean.TRUE);
            this.f7016k.c();
        }
    }

    private void S() {
        GLMapState gLMapState;
        GLMapEngine gLMapEngine = this.Z;
        if (gLMapEngine == null || (gLMapState = (GLMapState) gLMapEngine.getNewMapState(this.f7022n)) == null) {
            return;
        }
        IPoint obtain = IPoint.obtain();
        gLMapState.recalculate();
        gLMapState.getMapGeoCenter(obtain);
        this.f7028q.setSX(((Point) obtain).x);
        this.f7028q.setSY(((Point) obtain).y);
        this.f7028q.setSZ(gLMapState.getMapZoomer());
        this.f7028q.setSC(gLMapState.getCameraDegree());
        this.f7028q.setSR(gLMapState.getMapAngle());
        gLMapState.recycle();
        obtain.recycle();
    }

    private void T(int i6) {
        queueEvent(new f(i6));
    }

    private LatLng X() {
        MapConfig mapConfig = this.f7028q;
        if (mapConfig == null) {
            return null;
        }
        DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(mapConfig.getSX(), this.f7028q.getSY(), 20);
        LatLng latLng = new LatLng(pixelsToLatLong.f9904y, pixelsToLatLong.f9903x, false);
        pixelsToLatLong.recycle();
        return latLng;
    }

    private boolean Y(int i6) {
        GLMapEngine gLMapEngine = this.Z;
        if (gLMapEngine != null) {
            return gLMapEngine.getSrvViewStateBoolValue(i6, 7);
        }
        return false;
    }

    private boolean Z(MotionEvent motionEvent) {
        if (this.f7018l != null && this.f7039v0 != null) {
            DPoint obtain = DPoint.obtain();
            if (this.Z != null) {
                getPixel2LatLng((int) motionEvent.getX(), (int) motionEvent.getY(), obtain);
                MultiPointItem multiPointItem = this.f7018l.getMultiPointItem(new LatLng(obtain.f9904y, obtain.f9903x));
                if (multiPointItem == null) {
                    return false;
                }
                boolean onPointClick = this.f7039v0.onPointClick(multiPointItem);
                obtain.recycle();
                return onPointClick;
            }
        }
        return false;
    }

    private int b(int i6, Rect rect, int i7, int i8) {
        q9 q9Var;
        int i9;
        GLMapEngine gLMapEngine = this.Z;
        if (gLMapEngine == null || i6 < 0) {
            q9Var = this;
            i9 = 0;
        } else {
            i9 = gLMapEngine.getEngineIDWithType(i6);
            if (this.Z.isEngineCreated(i9)) {
                q9Var = this;
                q9Var.h(i9, rect.left, rect.top, rect.width(), rect.height(), i7, i8);
            } else {
                int i10 = this.Y.getResources().getDisplayMetrics().densityDpi;
                float f6 = this.Y.getResources().getDisplayMetrics().density;
                NativeTextGenerate.getInstance().setDensity(f6);
                GLMapEngine.MapViewInitParam mapViewInitParam = new GLMapEngine.MapViewInitParam();
                mapViewInitParam.engineId = i9;
                mapViewInitParam.f10280x = rect.left;
                mapViewInitParam.f10281y = rect.top;
                mapViewInitParam.width = rect.width();
                mapViewInitParam.height = rect.height();
                mapViewInitParam.screenWidth = i7;
                mapViewInitParam.screenHeight = i8;
                mapViewInitParam.screenScale = f6;
                mapViewInitParam.textScale = this.f7010h0 * f6;
                mapViewInitParam.mapZoomScale = this.f7007g0;
                mapViewInitParam.taskThreadCount = 3;
                this.Z.createAMapEngineWithFrame(mapViewInitParam);
                GLMapState mapState = this.Z.getMapState(i9);
                mapState.setMapZoomer(this.f7028q.getSZ());
                mapState.setCameraDegree(this.f7028q.getSC());
                mapState.setMapAngle(this.f7028q.getSR());
                mapState.setMapGeoCenter(this.f7028q.getSX(), this.f7028q.getSY());
                this.Z.setMapState(i9, mapState);
                this.f7007g0 = mapState.calMapZoomScalefactor(i7, i8, i10);
                this.Z.setOvelayBundle(i9, new GLOverlayBundle<>(i9, this));
                q9Var = this;
            }
        }
        q9Var.f7024o.set(false);
        return i9;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005b A[Catch: all -> 0x0049, TryCatch #0 {all -> 0x0049, blocks: (B:5:0x0027, B:7:0x0039, B:9:0x003d, B:11:0x0043, B:12:0x0055, B:13:0x0073, B:21:0x004b, B:22:0x005b, B:24:0x0069, B:25:0x006e, B:42:0x0024), top: B:41:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0039 A[Catch: all -> 0x0049, TryCatch #0 {all -> 0x0049, blocks: (B:5:0x0027, B:7:0x0039, B:9:0x003d, B:11:0x0043, B:12:0x0055, B:13:0x0073, B:21:0x004b, B:22:0x005b, B:24:0x0069, B:25:0x006e, B:42:0x0024), top: B:41:0x0024 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b0(int r6) {
        /*
            r5 = this;
            r5.I = r6
            r0 = 0
            r1 = 1
            if (r6 != r1) goto L9
        L6:
            r6 = 0
        L7:
            r2 = 0
            goto L27
        L9:
            r2 = 2
            if (r6 != r2) goto Lf
            r6 = 0
            r2 = 1
            goto L27
        Lf:
            r3 = 3
            if (r6 != r3) goto L14
            r6 = 1
            goto L7
        L14:
            r4 = 4
            if (r6 != r4) goto L19
            r6 = 0
            goto L27
        L19:
            r4 = 6
            if (r6 != r4) goto L1e
            r6 = 1
            goto L27
        L1e:
            r2 = 5
            if (r6 != r2) goto L24
            r6 = 0
            r2 = 3
            goto L27
        L24:
            r5.I = r1     // Catch: java.lang.Throwable -> L49
            goto L6
        L27:
            com.autonavi.base.amap.mapcore.MapConfig r3 = r5.f7028q     // Catch: java.lang.Throwable -> L49
            r3.setMapStyleMode(r2)     // Catch: java.lang.Throwable -> L49
            com.autonavi.base.amap.mapcore.MapConfig r3 = r5.f7028q     // Catch: java.lang.Throwable -> L49
            r3.setMapStyleTime(r6)     // Catch: java.lang.Throwable -> L49
            com.autonavi.base.amap.mapcore.MapConfig r3 = r5.f7028q     // Catch: java.lang.Throwable -> L49
            boolean r3 = r3.isCustomStyleEnable()     // Catch: java.lang.Throwable -> L49
            if (r3 == 0) goto L5b
            com.amap.api.col.3l.u8 r3 = r5.f7041w0     // Catch: java.lang.Throwable -> L49
            if (r3 == 0) goto L4b
            boolean r3 = r3.p()     // Catch: java.lang.Throwable -> L49
            if (r3 == 0) goto L4b
            com.amap.api.col.3l.u8 r6 = r5.f7041w0     // Catch: java.lang.Throwable -> L49
            r6.q()     // Catch: java.lang.Throwable -> L49
            goto L55
        L49:
            r6 = move-exception
            goto L77
        L4b:
            int r3 = r5.f7022n     // Catch: java.lang.Throwable -> L49
            r5.g(r3, r2, r6)     // Catch: java.lang.Throwable -> L49
            com.autonavi.base.amap.mapcore.MapConfig r6 = r5.f7028q     // Catch: java.lang.Throwable -> L49
            r6.setCustomStyleEnable(r0)     // Catch: java.lang.Throwable -> L49
        L55:
            com.amap.api.col.3l.i r6 = r5.f7006g     // Catch: java.lang.Throwable -> L49
            r6.setLogoEnable(r1)     // Catch: java.lang.Throwable -> L49
            goto L73
        L5b:
            com.autonavi.base.amap.mapcore.MapConfig r0 = r5.f7028q     // Catch: java.lang.Throwable -> L49
            java.lang.String r0 = r0.getMapLanguage()     // Catch: java.lang.Throwable -> L49
            java.lang.String r1 = "en"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> L49
            if (r0 == 0) goto L6e
            java.lang.String r0 = "zh_cn"
            r5.setMapLanguage(r0)     // Catch: java.lang.Throwable -> L49
        L6e:
            int r0 = r5.f7022n     // Catch: java.lang.Throwable -> L49
            r5.g(r0, r2, r6)     // Catch: java.lang.Throwable -> L49
        L73:
            r5.resetRenderTime()     // Catch: java.lang.Throwable -> L49
            return
        L77:
            java.lang.String r0 = "AMapDelegateImp"
            java.lang.String r1 = "setMaptype"
            com.amap.api.col.p0003l.v5.p(r6, r0, r1)
            r6.printStackTrace()
            com.amap.api.col.p0003l.b3.D(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.q9.b0(int):void");
    }

    private void e(double d6, double d7) {
        this.f7047z0.post(new a(d6, d7));
    }

    private void e0() {
        if (this.E > 0) {
            boolean canStopMapRender = this.Z.canStopMapRender(this.f7022n);
            if (!canStopMapRender) {
                int i6 = this.E - 1;
                this.E = i6;
                if (i6 > 0) {
                    this.Z.renderAMap();
                    return;
                }
            }
            this.E = 0;
            Message obtainMessage = this.f7047z0.obtainMessage(15, this.Z.getScreenShot(this.f7022n, 0, 0, getMapWidth(), getMapHeight()));
            obtainMessage.arg1 = canStopMapRender ? 1 : 0;
            obtainMessage.sendToTarget();
        }
    }

    private void f(int i6) {
        int i7 = this.S;
        if (i7 != -1) {
            this.f6989a0.setRenderFps(i7);
            resetRenderTime();
        } else if (this.Z.isInMapAction(i6) || this.f7015j0) {
            this.f6989a0.setRenderFps(40.0f);
        } else if (this.Z.isInMapAnimation(i6)) {
            this.f6989a0.setRenderFps(30.0f);
            this.f6989a0.resetTickCount(15);
        } else if (this.f7018l.isGLTFAnimated()) {
            this.f6989a0.setRenderFps(30.0f);
            this.f6989a0.resetTickCount(15);
        } else {
            this.f6989a0.setRenderFps(15.0f);
        }
        if (this.f7028q.isWorldMapEnable() != MapsInitializer.isLoadWorldGridMap()) {
            x();
            this.f7028q.setWorldMapEnable(MapsInitializer.isLoadWorldGridMap());
        }
    }

    private void h(int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        GLMapEngine gLMapEngine = this.Z;
        if (gLMapEngine != null) {
            gLMapEngine.setServiceViewRect(i6, i7, i8, i9, i10, i11, i12);
        }
    }

    private void h0() {
        GLMapState mapState;
        List a6;
        List a7;
        List a8;
        if (this.f7024o.get() || (mapState = this.Z.getMapState(this.f7022n)) == null) {
            return;
        }
        mapState.getViewMatrix(this.f7028q.getViewMatrix());
        mapState.getProjectionMatrix(this.f7028q.getProjectionMatrix());
        this.f7028q.updateFinalMatrix();
        DPoint mapGeoCenter = mapState.getMapGeoCenter();
        this.f7028q.setSX(mapGeoCenter.f9903x);
        this.f7028q.setSY(mapGeoCenter.f9904y);
        this.f7028q.setSZ(mapState.getMapZoomer());
        this.f7028q.setSC(mapState.getCameraDegree());
        this.f7028q.setSR(mapState.getMapAngle());
        this.f7028q.setSkyHeight(mapState.getSkyHeight());
        if (!this.f7028q.isMapStateChange()) {
            if (!this.f7015j0 && this.Z.getAnimateionsCount() == 0 && this.Z.getStateMessageCount() == 0) {
                onChangeFinish();
                return;
            }
            return;
        }
        DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(mapGeoCenter.f9903x, mapGeoCenter.f9904y, 20);
        CameraPosition cameraPosition = new CameraPosition(new LatLng(pixelsToLatLong.f9904y, pixelsToLatLong.f9903x, false), this.f7028q.getSZ(), this.f7028q.getSC(), this.f7028q.getSR());
        pixelsToLatLong.recycle();
        Message obtainMessage = this.f7047z0.obtainMessage();
        obtainMessage.what = 10;
        obtainMessage.obj = cameraPosition;
        this.f7047z0.sendMessage(obtainMessage);
        this.f7017k0 = true;
        redrawInfoWindow();
        try {
            if (this.f7006g.isZoomControlsEnabled() && this.f7028q.isNeedUpdateZoomControllerState() && (a8 = this.f6991b.a(AMapWidgetListener.class.hashCode())) != null && a8.size() > 0) {
                synchronized (a8) {
                    for (int i6 = 0; i6 < a8.size(); i6++) {
                        try {
                            ((AMapWidgetListener) a8.get(i6)).invalidateZoomController(this.f7028q.getSZ());
                        } finally {
                        }
                    }
                }
            }
            if (this.f7028q.getChangeGridRatio() != 1.0d) {
                x();
            }
            if (this.f7006g.isCompassEnabled() && ((this.f7028q.isTiltChanged() || this.f7028q.isBearingChanged()) && (a7 = this.f6991b.a(AMapWidgetListener.class.hashCode())) != null && a7.size() > 0)) {
                synchronized (a7) {
                    for (int i7 = 0; i7 < a7.size(); i7++) {
                        try {
                            ((AMapWidgetListener) a7.get(i7)).invalidateCompassView();
                        } finally {
                        }
                    }
                }
            }
            if (!this.f7006g.isScaleControlsEnabled() || (a6 = this.f6991b.a(AMapWidgetListener.class.hashCode())) == null || a6.size() <= 0) {
                return;
            }
            synchronized (a6) {
                for (int i8 = 0; i8 < a6.size(); i8++) {
                    try {
                        ((AMapWidgetListener) a6.get(i8)).invalidateScaleView();
                    } finally {
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void j(int i6, int i7, FPoint fPoint) {
        GLMapEngine gLMapEngine;
        GLMapState mapState;
        if (this.f7024o.get() || !this.f7019l0 || (gLMapEngine = this.Z) == null || (mapState = gLMapEngine.getMapState(this.f7022n)) == null) {
            return;
        }
        mapState.p20ToScreenPoint(i6, i7, fPoint);
    }

    private void j0() {
        if (!this.f7032s) {
            this.f7047z0.sendEmptyMessage(16);
            this.f7032s = true;
            x();
        }
        long j6 = this.X0;
        if (j6 < 2) {
            this.X0 = j6 + 1;
            return;
        }
        ed d6 = this.f7016k.d();
        if (d6 == null || d6.getVisibility() == 8) {
            return;
        }
        y2.g(this.Y, System.currentTimeMillis() - this.f7043x0);
        this.f7047z0.post(new c(d6));
        this.Z.setStyleChangeGradualEnable(this.f7022n, true);
    }

    private void l(MotionEvent motionEvent) throws RemoteException {
        if (!this.f7040w || this.f7044y == null) {
            return;
        }
        int x5 = (int) motionEvent.getX();
        int y5 = (int) (motionEvent.getY() - 60.0f);
        if (this.f7044y.getPosition() != null) {
            DPoint obtain = DPoint.obtain();
            getPixel2LatLng(x5, y5, obtain);
            LatLng latLng = new LatLng(obtain.f9904y, obtain.f9903x);
            obtain.recycle();
            this.f7044y.setPosition(latLng);
            try {
                List a6 = this.f6991b.a(AMap.OnMarkerDragListener.class.hashCode());
                if (a6 == null || a6.size() <= 0) {
                    return;
                }
                synchronized (a6) {
                    for (int i6 = 0; i6 < a6.size(); i6++) {
                        try {
                            ((AMap.OnMarkerDragListener) a6.get(i6)).onMarkerDrag(this.f7044y);
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    private void l0() {
        GLMapRender gLMapRender = this.f6989a0;
        if (gLMapRender != null) {
            gLMapRender.resetTickCount(2);
        }
    }

    private void n0() {
        GLMapRender gLMapRender;
        if (!this.f7019l0 || (gLMapRender = this.f6989a0) == null || gLMapRender.isRenderPause()) {
            return;
        }
        requestRender();
    }

    private void o(AbstractCameraUpdateMessage abstractCameraUpdateMessage) {
        boolean z5 = this.f7030r;
        abstractCameraUpdateMessage.isUseAnchor = z5;
        if (z5) {
            abstractCameraUpdateMessage.anchorX = this.f7028q.getAnchorX();
            abstractCameraUpdateMessage.anchorY = this.f7028q.getAnchorY();
        }
        if (abstractCameraUpdateMessage.width == 0) {
            abstractCameraUpdateMessage.width = getMapWidth();
        }
        if (abstractCameraUpdateMessage.height == 0) {
            abstractCameraUpdateMessage.height = getMapHeight();
        }
        abstractCameraUpdateMessage.mapConfig = this.f7028q;
    }

    private void o0() {
        if (this.N) {
            return;
        }
        try {
            this.K.setName("AuthThread");
            this.K.start();
            this.N = true;
        } catch (Throwable th) {
            th.printStackTrace();
            b3.D(th);
        }
    }

    private void p(GLMapState gLMapState, int i6, int i7, DPoint dPoint) {
        if (!this.f7019l0 || this.Z == null) {
            return;
        }
        gLMapState.screenToP20Point(i6, i7, new Point());
        DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(r0.x, r0.y, 20);
        dPoint.f9903x = pixelsToLatLong.f9903x;
        dPoint.f9904y = pixelsToLatLong.f9904y;
        pixelsToLatLong.recycle();
    }

    private void q(boolean z5) {
        com.autonavi.extra.b bVar = this.P0;
        if (bVar != null) {
            Object j6 = bVar.j();
            if (j6 != null && (j6 instanceof Boolean)) {
                MapConfig mapConfig = this.f7028q;
                if (mapConfig != null) {
                    mapConfig.setAbroadEnable(z5 && ((Boolean) j6).booleanValue());
                }
                if (z5 && ((Boolean) j6).booleanValue()) {
                    MapsInitializer.setSupportRecycleView(false);
                }
            }
            Object j7 = this.P0.j();
            if (j7 != null && (j7 instanceof Boolean)) {
                this.f7016k.a(((Boolean) j7).booleanValue());
            }
            Object j8 = this.P0.j();
            if (j7 == null || !(j7 instanceof Integer)) {
                return;
            }
            this.P = ((Integer) j8).intValue();
        }
    }

    private void q0() {
        if (this.O) {
            return;
        }
        try {
            if (this.L == null) {
                this.L = new ba(this.Y, this);
            }
            this.L.setName("AuthProThread");
            this.L.start();
            this.O = true;
        } catch (Throwable th) {
            th.printStackTrace();
            b3.D(th);
        }
    }

    private void r(boolean z5, byte[] bArr, boolean z6) {
        f2 f2Var;
        try {
            this.f7028q.setCustomStyleEnable(z5);
            if (this.f7028q.isHideLogoEnable()) {
                this.f7006g.setLogoEnable(!z5);
            }
            boolean z7 = false;
            if (!z5) {
                H(this.f7022n, false);
                g(this.f7022n, this.f7028q.getMapStyleMode(), this.f7028q.getMapStyleTime());
                return;
            }
            H(this.f7022n, true);
            d2 d2Var = new d2();
            MyTrafficStyle myTrafficStyle = this.J;
            if (myTrafficStyle != null && myTrafficStyle.getTrafficRoadBackgroundColor() != -1) {
                d2Var.i(this.J.getTrafficRoadBackgroundColor());
            }
            if (this.f7028q.isProFunctionAuthEnable() && !TextUtils.isEmpty(this.f7028q.getCustomTextureResourcePath())) {
                z7 = true;
            }
            StyleItem[] styleItemArr = null;
            if (bArr != null) {
                f2Var = d2Var.e(bArr, z7);
                if (f2Var != null && (styleItemArr = f2Var.c()) != null) {
                    this.f7028q.setUseProFunction(true);
                }
            } else {
                f2Var = null;
            }
            if (styleItemArr == null && (f2Var = d2Var.d(this.f7028q.getCustomStylePath(), z7)) != null) {
                styleItemArr = f2Var.c();
            }
            if (d2Var.a() != 0) {
                this.f7028q.setCustomBackgroundColor(d2Var.a());
            }
            if (f2Var == null || f2Var.d() == null) {
                s(styleItemArr, z6);
            } else if (this.V != null) {
                this.V.d((String) f2Var.d());
                this.V.c(f2Var);
                this.V.b();
            }
        } catch (Throwable th) {
            b3.D(th);
        }
    }

    private void s(StyleItem[] styleItemArr, boolean z5) {
        if (!z5 && (styleItemArr == null || styleItemArr.length <= 0)) {
            y2.j(this.Y, false);
        } else {
            i(this.f7022n, 0, 0, true, styleItemArr);
            y2.j(this.Y, true);
        }
    }

    private boolean t(int i6, int i7) {
        AbstractCameraUpdateMessage d6;
        if (!this.f7019l0 || ((int) E()) >= this.f7028q.getMaxZoomLevel()) {
            return false;
        }
        try {
            if (this.f7030r || this.f7006g.isZoomInByScreenCenter()) {
                d6 = com.amap.api.col.p0003l.p.d(1.0f, null);
            } else {
                Point point = this.W0;
                point.x = i6;
                point.y = i7;
                d6 = com.amap.api.col.p0003l.p.d(1.0f, point);
            }
            animateCamera(d6);
        } catch (Throwable th) {
            v5.p(th, "AMapDelegateImp", "onDoubleTap");
            th.printStackTrace();
        }
        resetRenderTime();
        return true;
    }

    private void t0() {
        try {
            LatLngBounds limitLatLngBounds = this.f7028q.getLimitLatLngBounds();
            if (this.Z != null && u(limitLatLngBounds)) {
                GLMapState gLMapState = new GLMapState(this.f7022n, this.Z.getNativeInstance());
                IPoint obtain = IPoint.obtain();
                LatLng latLng = limitLatLngBounds.northeast;
                GLMapState.lonlat2Geo(latLng.longitude, latLng.latitude, obtain);
                IPoint obtain2 = IPoint.obtain();
                LatLng latLng2 = limitLatLngBounds.southwest;
                GLMapState.lonlat2Geo(latLng2.longitude, latLng2.latitude, obtain2);
                this.f7028q.setLimitIPoints(new IPoint[]{obtain, obtain2});
                gLMapState.recycle();
                return;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f7028q.setLimitIPoints(null);
    }

    private static boolean u(LatLngBounds latLngBounds) {
        return (latLngBounds == null || latLngBounds.northeast == null || latLngBounds.southwest == null) ? false : true;
    }

    private void v0() {
        aa aaVar = this.f6991b;
        if (aaVar != null) {
            aaVar.b();
        }
    }

    private void x0() {
        v1 v1Var = this.f7037u0;
        if (v1Var != null) {
            v1Var.a();
            this.f7037u0 = null;
        }
    }

    private void y(int i6) {
        queueEvent(new d(i6));
    }

    public final void H(int i6, boolean z5) {
        if (this.f7019l0 && this.f7021m0) {
            resetRenderTime();
            queueEvent(new i(z5, i6));
        } else {
            t0 t0Var = this.O0;
            t0Var.f7121b = z5;
            t0Var.f7120a = true;
            t0Var.f7124e = i6;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void accelerateNetworkInChinese(boolean z5) {
        com.autonavi.extra.b bVar = this.P0;
        if (bVar != null) {
            bVar.i();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addAMapAppResourceListener(AMap.AMapAppResourceRequestListener aMapAppResourceRequestListener) {
        aa aaVar = this.f6991b;
        if (aaVar != null) {
            aaVar.e(Integer.valueOf(AMap.AMapAppResourceRequestListener.class.hashCode()), aMapAppResourceRequestListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final m3 addContourLineOverlay(eo eoVar) {
        try {
            String createId = this.f7018l.createId("CONTOURLINE");
            m3 m3Var = new m3(this.f7018l, eoVar, createId);
            this.f7018l.addOverlayObject(createId, m3Var, eoVar);
            return m3Var;
        } catch (Exception e6) {
            b3.D(e6);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final CrossOverlay addCrossVector(CrossOverlayOptions crossOverlayOptions) {
        if (crossOverlayOptions == null || crossOverlayOptions.getRes() == null) {
            return null;
        }
        CrossVectorOverlay crossVectorOverlay = new CrossVectorOverlay(this.f7022n, getContext(), this);
        crossVectorOverlay.setAttribute(crossOverlayOptions.getAttribute());
        queueEvent(new c0(crossVectorOverlay));
        crossVectorOverlay.resumeMarker(crossOverlayOptions.getRes());
        return new CrossOverlay(crossOverlayOptions, crossVectorOverlay);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void addGestureMapMessage(int i6, AbstractGestureMapMessage abstractGestureMapMessage) {
        if (!this.f7019l0 || this.Z == null) {
            return;
        }
        try {
            abstractGestureMapMessage.isUseAnchor = this.f7030r;
            abstractGestureMapMessage.anchorX = this.f7028q.getAnchorX();
            abstractGestureMapMessage.anchorY = this.f7028q.getAnchorY();
            this.Z.addGestureMessage(i6, abstractGestureMapMessage, this.f7006g.isGestureScaleByMapCenter(), this.f7028q.getAnchorX(), this.f7028q.getAnchorY());
        } catch (RemoteException unused) {
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final RouteOverlay addNaviRouteOverlay() {
        RouteOverlayInner routeOverlayInner = new RouteOverlayInner(this.f7022n, getContext(), this);
        queueEvent(new d0(routeOverlayInner));
        return new RouteOverlay(routeOverlayInner);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnCameraChangeListener(AMap.OnCameraChangeListener onCameraChangeListener) throws RemoteException {
        aa aaVar = this.f6991b;
        if (aaVar != null) {
            aaVar.e(Integer.valueOf(AMap.OnCameraChangeListener.class.hashCode()), onCameraChangeListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnIndoorBuildingActiveListener(AMap.OnIndoorBuildingActiveListener onIndoorBuildingActiveListener) throws RemoteException {
        aa aaVar = this.f6991b;
        if (aaVar != null) {
            aaVar.e(Integer.valueOf(AMap.OnIndoorBuildingActiveListener.class.hashCode()), onIndoorBuildingActiveListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnInfoWindowClickListener(AMap.OnInfoWindowClickListener onInfoWindowClickListener) throws RemoteException {
        aa aaVar = this.f6991b;
        if (aaVar != null) {
            aaVar.e(Integer.valueOf(AMap.OnInfoWindowClickListener.class.hashCode()), onInfoWindowClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnMapClickListener(AMap.OnMapClickListener onMapClickListener) throws RemoteException {
        aa aaVar = this.f6991b;
        if (aaVar != null) {
            aaVar.e(Integer.valueOf(AMap.OnMapClickListener.class.hashCode()), onMapClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnMapLoadedListener(AMap.OnMapLoadedListener onMapLoadedListener) {
        aa aaVar = this.f6991b;
        if (aaVar != null) {
            aaVar.e(Integer.valueOf(AMap.OnMapLoadedListener.class.hashCode()), onMapLoadedListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnMapLongClickListener(AMap.OnMapLongClickListener onMapLongClickListener) throws RemoteException {
        aa aaVar = this.f6991b;
        if (aaVar != null) {
            aaVar.e(Integer.valueOf(AMap.OnMapLongClickListener.class.hashCode()), onMapLongClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnMapTouchListener(AMap.OnMapTouchListener onMapTouchListener) throws RemoteException {
        aa aaVar = this.f6991b;
        if (aaVar != null) {
            aaVar.e(Integer.valueOf(AMap.OnMapTouchListener.class.hashCode()), onMapTouchListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnMarkerClickListener(AMap.OnMarkerClickListener onMarkerClickListener) throws RemoteException {
        aa aaVar = this.f6991b;
        if (aaVar != null) {
            aaVar.e(Integer.valueOf(AMap.OnMarkerClickListener.class.hashCode()), onMarkerClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnMarkerDragListener(AMap.OnMarkerDragListener onMarkerDragListener) {
        aa aaVar = this.f6991b;
        if (aaVar != null) {
            aaVar.e(Integer.valueOf(AMap.OnMarkerDragListener.class.hashCode()), onMarkerDragListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnMyLocationChangeListener(AMap.OnMyLocationChangeListener onMyLocationChangeListener) throws RemoteException {
        aa aaVar = this.f6991b;
        if (aaVar != null) {
            aaVar.e(Integer.valueOf(AMap.OnMyLocationChangeListener.class.hashCode()), onMyLocationChangeListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnPOIClickListener(AMap.OnPOIClickListener onPOIClickListener) throws RemoteException {
        aa aaVar = this.f6991b;
        if (aaVar != null) {
            aaVar.e(Integer.valueOf(AMap.OnPOIClickListener.class.hashCode()), onPOIClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addOnPolylineClickListener(AMap.OnPolylineClickListener onPolylineClickListener) throws RemoteException {
        aa aaVar = this.f6991b;
        if (aaVar != null) {
            aaVar.e(Integer.valueOf(AMap.OnPolylineClickListener.class.hashCode()), onPolylineClickListener);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void addOverlayTexture(int i6, GLTextureProperty gLTextureProperty) {
        GLOverlayBundle overlayBundle;
        try {
            GLMapEngine gLMapEngine = this.Z;
            if (gLMapEngine != null && (overlayBundle = gLMapEngine.getOverlayBundle(i6)) != null && gLTextureProperty != null && gLTextureProperty.mBitmap != null) {
                this.Z.addOverlayTexture(i6, gLTextureProperty);
                overlayBundle.addOverlayTextureItem(gLTextureProperty.mId, gLTextureProperty.mAnchor, gLTextureProperty.mXRatio, gLTextureProperty.mYRatio, gLTextureProperty.mBitmap.getWidth(), gLTextureProperty.mBitmap.getHeight());
            }
        } catch (Throwable th) {
            b3.D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void addSignleClickInterceptorListener(AMap.SignleClickInterceptorListener signleClickInterceptorListener) {
        aa aaVar = this.f6991b;
        if (aaVar != null) {
            aaVar.e(Integer.valueOf(AMap.SignleClickInterceptorListener.class.hashCode()), signleClickInterceptorListener);
        }
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAMapListener
    public final void afterRendererOver(int i6, GLMapState gLMapState) {
        GLMapEngine gLMapEngine = this.Z;
        if (gLMapEngine != null) {
            gLMapEngine.pushRendererState();
        }
        this.f7018l.draw(2, this.P, this.f7045y0);
        GLMapEngine gLMapEngine2 = this.Z;
        if (gLMapEngine2 != null) {
            gLMapEngine2.popRendererState();
        }
        CustomRenderer customRenderer = this.Q;
        if (customRenderer != null) {
            customRenderer.onDrawFrame(null);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void animateCamera(AbstractCameraUpdateMessage abstractCameraUpdateMessage) throws RemoteException {
        animateCameraWithDurationAndCallback(abstractCameraUpdateMessage, 250L, (AMap.CancelableCallback) null);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void animateCameraWithCallback(CameraUpdate cameraUpdate, AMap.CancelableCallback cancelableCallback) throws RemoteException {
        if (cameraUpdate == null) {
            return;
        }
        animateCameraWithDurationAndCallback(cameraUpdate, 250L, cancelableCallback);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void animateCameraWithDurationAndCallback(AbstractCameraUpdateMessage abstractCameraUpdateMessage, long j6, AMap.CancelableCallback cancelableCallback) {
        if (abstractCameraUpdateMessage == null || this.f7024o.get() || this.Z == null) {
            return;
        }
        abstractCameraUpdateMessage.mCallback = cancelableCallback;
        abstractCameraUpdateMessage.mDuration = j6;
        if (!this.f7026p && getMapHeight() != 0 && getMapWidth() != 0) {
            try {
                this.Z.interruptAnimation();
                resetRenderTime();
                o(abstractCameraUpdateMessage);
                this.Z.addMessage(abstractCameraUpdateMessage, true);
                return;
            } catch (Throwable th) {
                b3.D(th);
                th.printStackTrace();
                return;
            }
        }
        try {
            moveCamera(abstractCameraUpdateMessage);
            AMap.CancelableCallback cancelableCallback2 = abstractCameraUpdateMessage.mCallback;
            if (cancelableCallback2 != null) {
                cancelableCallback2.onFinish();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
            b3.D(th2);
        }
    }

    public final Size c(Size size) {
        Size size2 = new Size(getMapWidth(), getMapHeight());
        h(getNativeEngineID(), 0, 0, size.getWidth(), size.getHeight(), size.getWidth(), size.getHeight());
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(size.getWidth(), size.getHeight());
        getGLMapView().setLayoutParams(layoutParams);
        this.f7016k.f().setLayoutParams(layoutParams);
        changeSize(size.getWidth(), size.getHeight());
        D(false);
        return size2;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final Pair<Float, LatLng> calculateZoomToSpanLevel(int i6, int i7, int i8, int i9, LatLng latLng, LatLng latLng2) {
        if (latLng != null && latLng2 != null && i6 == i7 && i7 == i8 && i8 == i9 && latLng.latitude == latLng2.latitude && latLng.longitude == latLng2.longitude) {
            return new Pair<>(Float.valueOf(getMaxZoomLevel()), latLng);
        }
        MapConfig mapConfig = getMapConfig();
        if (latLng == null || latLng2 == null || !this.f7019l0 || this.f7024o.get()) {
            DPoint obtain = DPoint.obtain();
            GLMapState.geo2LonLat((int) mapConfig.getSX(), (int) mapConfig.getSY(), obtain);
            Pair<Float, LatLng> pair = new Pair<>(Float.valueOf(mapConfig.getSZ()), new LatLng(obtain.f9904y, obtain.f9903x));
            obtain.recycle();
            return pair;
        }
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        builder.include(latLng);
        builder.include(latLng2);
        GLMapState gLMapState = new GLMapState(this.f7022n, this.Z.getNativeInstance());
        Pair<Float, IPoint> r5 = b3.r(mapConfig, i6, i7, i8, i9, builder.build(), getMapWidth(), getMapHeight());
        gLMapState.recycle();
        if (r5 == null) {
            return null;
        }
        DPoint obtain2 = DPoint.obtain();
        Object obj = r5.second;
        GLMapState.geo2LonLat(((Point) ((IPoint) obj)).x, ((Point) ((IPoint) obj)).y, obtain2);
        Pair<Float, LatLng> pair2 = new Pair<>(r5.first, new LatLng(obtain2.f9904y, obtain2.f9903x));
        obtain2.recycle();
        return pair2;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final boolean canStopMapRender() {
        GLMapEngine gLMapEngine = this.Z;
        if (gLMapEngine == null) {
            return true;
        }
        gLMapEngine.canStopMapRender(this.f7022n);
        return true;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void changeGLOverlayIndex() {
        this.f7018l.changeOverlayIndex();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void changeLogoIconStyle(String str, boolean z5, int i6) {
        i3 i3Var = this.f7016k;
        if (i3Var != null) {
            i3Var.q(str, Boolean.valueOf(z5), Integer.valueOf(i6));
        }
        com.amap.api.col.p0003l.i iVar = this.f7006g;
        if (iVar != null) {
            iVar.requestRefreshLogo();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void changeMapLogo(int i6, boolean z5) {
        if (this.f7024o.get()) {
            return;
        }
        try {
            List a6 = this.f6991b.a(AMapWidgetListener.class.hashCode());
            if (a6 == null || a6.size() <= 0) {
                return;
            }
            this.f7016k.o(Boolean.valueOf(!z5));
        } catch (Throwable unused) {
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void changeSize(int i6, int i7) {
        MapConfig mapConfig = this.f7028q;
        if (mapConfig != null) {
            this.f6998d0 = i6;
            this.f7001e0 = i7;
            mapConfig.setMapWidth(i6);
            this.f7028q.setMapHeight(i7);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void checkMapState(IGLMapState iGLMapState) {
        if (this.f7028q == null || this.f7024o.get()) {
            return;
        }
        LatLngBounds limitLatLngBounds = this.f7028q.getLimitLatLngBounds();
        try {
            if (limitLatLngBounds == null) {
                if (this.f7028q.isSetLimitZoomLevel()) {
                    iGLMapState.setMapZoomer(Math.max(this.f7028q.getMinZoomLevel(), Math.min(iGLMapState.getMapZoomer(), this.f7028q.getMaxZoomLevel())));
                    return;
                }
                return;
            }
            IPoint[] limitIPoints = this.f7028q.getLimitIPoints();
            if (limitIPoints == null) {
                IPoint obtain = IPoint.obtain();
                LatLng latLng = limitLatLngBounds.northeast;
                GLMapState.lonlat2Geo(latLng.longitude, latLng.latitude, obtain);
                IPoint obtain2 = IPoint.obtain();
                LatLng latLng2 = limitLatLngBounds.southwest;
                GLMapState.lonlat2Geo(latLng2.longitude, latLng2.latitude, obtain2);
                IPoint[] iPointArr = {obtain, obtain2};
                this.f7028q.setLimitIPoints(iPointArr);
                limitIPoints = iPointArr;
            }
            MapConfig mapConfig = this.f7028q;
            IPoint iPoint = limitIPoints[0];
            int i6 = ((Point) iPoint).x;
            int i7 = ((Point) iPoint).y;
            IPoint iPoint2 = limitIPoints[1];
            float j6 = b3.j(mapConfig, i6, i7, ((Point) iPoint2).x, ((Point) iPoint2).y, getMapWidth(), getMapHeight());
            float mapZoomer = iGLMapState.getMapZoomer();
            if (this.f7028q.isSetLimitZoomLevel()) {
                float maxZoomLevel = this.f7028q.getMaxZoomLevel();
                float minZoomLevel = this.f7028q.getMinZoomLevel();
                float max = Math.max(j6, Math.min(mapZoomer, maxZoomLevel));
                if (j6 <= maxZoomLevel) {
                    maxZoomLevel = max;
                }
                j6 = maxZoomLevel < minZoomLevel ? minZoomLevel : maxZoomLevel;
            } else if (j6 <= 0.0f || mapZoomer >= j6) {
                j6 = mapZoomer;
            }
            iGLMapState.setMapZoomer(j6);
            IPoint obtain3 = IPoint.obtain();
            iGLMapState.getMapGeoCenter(obtain3);
            int i8 = ((Point) obtain3).x;
            int i9 = ((Point) obtain3).y;
            IPoint iPoint3 = limitIPoints[0];
            int i10 = ((Point) iPoint3).x;
            int i11 = ((Point) iPoint3).y;
            IPoint iPoint4 = limitIPoints[1];
            int[] U = b3.U(i10, i11, ((Point) iPoint4).x, ((Point) iPoint4).y, this.f7028q, iGLMapState, i8, i9);
            iGLMapState.setMapGeoCenter(U[0], U[1]);
            obtain3.recycle();
        } catch (Throwable th) {
            b3.D(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float checkZoomLevel(float f6) throws RemoteException {
        return b3.h(this.f7028q, f6);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void clearTileCache() {
        this.f7018l.clearTileCache();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final long createGLOverlay(int i6) {
        GLMapEngine gLMapEngine = this.Z;
        if (gLMapEngine != null) {
            return gLMapEngine.createOverlay(this.f7022n, i6);
        }
        return 0L;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final String createId(String str) {
        IGlOverlayLayer iGlOverlayLayer = this.f7018l;
        if (iGlOverlayLayer != null) {
            return iGlOverlayLayer.createId(str);
        }
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void destroy() {
        this.f7024o.set(true);
        d3.e(c3.f5803c, "destroy map");
        try {
            LocationSource locationSource = this.f7038v;
            if (locationSource != null) {
                locationSource.deactivate();
            }
            this.f7038v = null;
            this.f7035t0 = null;
            GLMapRender gLMapRender = this.f6989a0;
            if (gLMapRender != null) {
                gLMapRender.renderPause();
            }
            a0();
            Thread thread = this.K;
            if (thread != null) {
                thread.interrupt();
                this.K = null;
            }
            Thread thread2 = this.L;
            if (thread2 != null) {
                thread2.interrupt();
                this.L = null;
            }
            fa faVar = this.M;
            if (faVar != null) {
                faVar.c();
                this.M = null;
            }
            x1 x1Var = this.U;
            if (x1Var != null) {
                x1Var.a();
                this.U = null;
            }
            z1 z1Var = this.V;
            if (z1Var != null) {
                z1Var.b(null);
                this.V.a();
                this.V = null;
            }
            p2.f();
            GLMapEngine gLMapEngine = this.Z;
            if (gLMapEngine != null) {
                gLMapEngine.setMapListener(null);
                queueEvent(new b0());
                int i6 = 0;
                while (this.Z != null) {
                    int i7 = i6 + 1;
                    if (i6 >= 50) {
                        break;
                    }
                    try {
                        Thread.sleep(20L);
                    } catch (InterruptedException e6) {
                        b3.D(e6);
                    }
                    i6 = i7;
                }
            }
            IGLSurfaceView iGLSurfaceView = this.f7014j;
            if (iGLSurfaceView != null) {
                try {
                    iGLSurfaceView.onDetachedGLThread();
                } catch (Exception e7) {
                    e7.printStackTrace();
                    b3.D(e7);
                }
            }
            i3 i3Var = this.f7016k;
            if (i3Var != null) {
                i3Var.g();
                this.f7016k = null;
            }
            q1 q1Var = this.f7036u;
            if (q1Var != null) {
                q1Var.n();
                this.f7036u = null;
            }
            this.f7038v = null;
            this.f6988a = null;
            v0();
            this.J = null;
            d3.a();
            v5.m();
        } catch (Throwable th) {
            v5.p(th, "AMapDelegateImp", "destroy");
            b3.D(th);
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void destroySurface(int i6) {
        this.f7027p0.lock();
        try {
            if (this.f7019l0) {
                EGL14.eglGetCurrentContext();
                EGLContext eGLContext = EGL14.EGL_NO_CONTEXT;
                x0();
                GLMapEngine gLMapEngine = this.Z;
                if (gLMapEngine != null) {
                    if (gLMapEngine.getOverlayBundle(this.f7022n) != null) {
                        this.Z.getOverlayBundle(this.f7022n).removeAll(true);
                    }
                    this.Z.destroyAMapEngine();
                    this.Z = null;
                    int i7 = this.U0;
                    if (i7 > 0) {
                        y2.d(this.Y, i7);
                    }
                    d3.e(c3.f5803c, "destroy engine complete");
                }
                com.autonavi.extra.b bVar = this.P0;
                if (bVar != null) {
                    bVar.f();
                }
            }
            this.f7019l0 = false;
            this.f7021m0 = false;
            this.f7025o0 = false;
        } finally {
            try {
            } finally {
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void drawFrame(GL10 gl10) {
        if (this.f7024o.get() || this.Z == null || EGL14.eglGetCurrentContext() == EGL14.EGL_NO_CONTEXT) {
            return;
        }
        MapConfig mapConfig = this.f7028q;
        if (mapConfig != null && !mapConfig.isMapEnable()) {
            GLES20.glClear(16640);
            return;
        }
        f(this.f7022n);
        this.Z.renderAMap();
        this.Z.pushRendererState();
        this.f7047z0.sendEmptyMessage(30);
        u8 u8Var = this.f7041w0;
        if (u8Var != null) {
            u8Var.a();
        }
        e0();
        j0();
        if (!this.f7023n0) {
            this.f7023n0 = true;
        }
        this.Z.popRendererState();
        if (s2.b()) {
            try {
                if (this.f7014j instanceof com.amap.api.col.p0003l.o) {
                    if (this.W == null) {
                        this.W = new s2();
                    }
                    this.W.i();
                    if (!this.W.j() || this.W.h()) {
                        return;
                    }
                    if (this.W.c(((com.amap.api.col.p0003l.o) this.f7014j).getBitmap())) {
                        if (s2.e()) {
                            removecache();
                        }
                        if (s2.g()) {
                            s2.k();
                        }
                        d3.l(c3.f5807g, "pure screen: found pure check");
                    }
                }
            } catch (Throwable th) {
                v5.p(th, "AMapDelegateImp", "PureScreenCheckTool.checkBlackScreen");
            }
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final com.autonavi.extra.b getAMapExtraInterfaceManager() {
        return this.P0;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final Projection getAMapProjection() throws RemoteException {
        return new Projection(this.f7003f);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final UiSettings getAMapUiSettings() throws RemoteException {
        if (this.f7000e == null) {
            this.f7000e = new UiSettings(this.f7006g);
        }
        return this.f7000e;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final float getCameraAngle() {
        return getCameraDegree(this.f7022n);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float getCameraDegree(int i6) {
        MapConfig mapConfig = this.f7028q;
        if (mapConfig != null) {
            return mapConfig.getSC();
        }
        return 0.0f;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final CameraPosition getCameraPosition() throws RemoteException {
        return getCameraPositionPrj(this.f7030r);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final Context getContext() {
        return this.Y;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final String getCurrentWorldVectorMapStyle() {
        try {
            com.autonavi.extra.b bVar = this.P0;
            if (bVar != null) {
                Object j6 = bVar.j();
                if (j6 instanceof String) {
                    return (String) j6;
                }
            }
            return "";
        } catch (Throwable th) {
            b3.D(th);
            return "";
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final u8 getCustomStyleManager() {
        return this.f7041w0;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final int getEngineIDWithGestureInfo(EAMapPlatformGestureInfo eAMapPlatformGestureInfo) {
        GLMapEngine gLMapEngine = this.Z;
        return gLMapEngine != null ? gLMapEngine.getEngineIDWithGestureInfo(eAMapPlatformGestureInfo) : this.f7022n;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float[] getFinalMatrix() {
        MapConfig mapConfig = this.f7028q;
        return mapConfig != null ? mapConfig.getMvpMatrix() : this.f6990a1;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final GLMapEngine getGLMapEngine() {
        return this.Z;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final View getGLMapView() {
        Object obj = this.f7014j;
        if (obj instanceof View) {
            return (View) obj;
        }
        return null;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void getGeoCenter(int i6, IPoint iPoint) {
        MapConfig mapConfig = this.f7028q;
        if (mapConfig != null) {
            ((Point) iPoint).x = (int) mapConfig.getSX();
            ((Point) iPoint).y = (int) this.f7028q.getSY();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final IGlOverlayLayer getGlOverlayLayer() {
        return this.f7018l;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final long getGlOverlayMgrPtr() {
        GLMapEngine gLMapEngine = this.Z;
        if (gLMapEngine != null) {
            return gLMapEngine.getGlOverlayMgrPtr(this.f7022n);
        }
        return 0L;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final com.amap.api.col.p0003l.a0 getInfoWindowDelegate() {
        return this.f6997d;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void getLatLng2Pixel(double d6, double d7, IPoint iPoint) {
        if (this.f7024o.get() || !this.f7019l0 || this.Z == null) {
            return;
        }
        try {
            Point latLongToPixels = VirtualEarthProjection.latLongToPixels(d6, d7, 20);
            FPoint obtain = FPoint.obtain();
            j(latLongToPixels.x, latLongToPixels.y, obtain);
            if (((PointF) obtain).x == -10000.0f && ((PointF) obtain).y == -10000.0f) {
                GLMapState gLMapState = (GLMapState) this.Z.getNewMapState(this.f7022n);
                gLMapState.setCameraDegree(0.0f);
                gLMapState.recalculate();
                gLMapState.p20ToScreenPoint(latLongToPixels.x, latLongToPixels.y, obtain);
                gLMapState.recycle();
            }
            ((Point) iPoint).x = (int) ((PointF) obtain).x;
            ((Point) iPoint).y = (int) ((PointF) obtain).y;
            obtain.recycle();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void getLatLngRect(DPoint[] dPointArr) {
        try {
            Rectangle geoRectangle = this.f7028q.getGeoRectangle();
            if (geoRectangle != null) {
                IPoint[] clipRect = geoRectangle.getClipRect();
                for (int i6 = 0; i6 < 4; i6++) {
                    IPoint iPoint = clipRect[i6];
                    GLMapState.geo2LonLat(((Point) iPoint).x, ((Point) iPoint).y, dPointArr[i6]);
                }
            }
        } catch (Throwable th) {
            b3.D(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float getLogoMarginRate(int i6) {
        i3 i3Var = this.f7016k;
        if (i3Var != null) {
            return i3Var.a(i6);
        }
        return 0.0f;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final int getLogoPosition() {
        try {
            return this.f7006g.getLogoPosition();
        } catch (RemoteException e6) {
            v5.p(e6, "AMapDelegateImp", "getLogoPosition");
            e6.printStackTrace();
            return 0;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final Handler getMainHandler() {
        return this.f7047z0;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float getMapAngle(int i6) {
        MapConfig mapConfig = this.f7028q;
        if (mapConfig != null) {
            return mapConfig.getSR();
        }
        return 0.0f;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final LatLngBounds getMapBounds(LatLng latLng, float f6, float f7, float f8) {
        int mapWidth = getMapWidth();
        int mapHeight = getMapHeight();
        if (mapWidth <= 0 || mapHeight <= 0 || this.f7024o.get()) {
            return null;
        }
        float h6 = b3.h(this.f7028q, f6);
        GLMapState gLMapState = new GLMapState(this.f7022n, this.Z.getNativeInstance());
        if (latLng != null) {
            IPoint obtain = IPoint.obtain();
            latlon2Geo(latLng.latitude, latLng.longitude, obtain);
            gLMapState.setCameraDegree(f8);
            gLMapState.setMapAngle(f7);
            gLMapState.setMapGeoCenter(((Point) obtain).x, ((Point) obtain).y);
            gLMapState.setMapZoomer(h6);
            gLMapState.recalculate();
            obtain.recycle();
        }
        DPoint obtain2 = DPoint.obtain();
        p(gLMapState, 0, 0, obtain2);
        LatLng latLng2 = new LatLng(obtain2.f9904y, obtain2.f9903x, false);
        p(gLMapState, mapWidth, mapHeight, obtain2);
        LatLng latLng3 = new LatLng(obtain2.f9904y, obtain2.f9903x, false);
        obtain2.recycle();
        gLMapState.recycle();
        return LatLngBounds.builder().include(latLng3).include(latLng2).build();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final MapConfig getMapConfig() {
        return this.f7028q;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final String getMapContentApprovalNumber() {
        MapConfig mapConfig = this.f7028q;
        if (mapConfig == null || mapConfig.isCustomStyleEnable()) {
            return null;
        }
        y2.q(this.Y);
        String b6 = r2.b(this.Y, "approval_number", bi.A, "");
        return !TextUtils.isEmpty(b6) ? b6 : "GS (2023)551号 | GS (2023)2175号";
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final int getMapHeight() {
        return this.f7001e0;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void getMapPrintScreen(AMap.onMapPrintScreenListener onmapprintscreenlistener) {
        try {
            this.f6991b.e(Integer.valueOf(AMap.onMapPrintScreenListener.class.hashCode()), onmapprintscreenlistener);
            this.E = 20;
            this.F = true;
            resetRenderTime();
        } catch (Throwable th) {
            b3.D(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final GLMapState getMapProjection() {
        GLMapEngine gLMapEngine = this.Z;
        if (gLMapEngine != null) {
            return gLMapEngine.getMapState(this.f7022n);
        }
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void getMapScreenShot(AMap.OnMapScreenShotListener onMapScreenShotListener, boolean z5) {
        try {
            this.f6991b.e(Integer.valueOf(AMap.OnMapScreenShotListener.class.hashCode()), onMapScreenShotListener);
            this.E = 20;
            this.F = z5;
            resetRenderTime();
        } catch (Throwable th) {
            b3.D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final int getMapTextZIndex() throws RemoteException {
        return this.P;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final int getMapType() throws RemoteException {
        return this.I;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final int getMapWidth() {
        return this.f6998d0;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float getMapZoomScale() {
        return this.f7007g0;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final int getMaskLayerType() {
        return this.R;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final float getMaxZoomLevel() {
        try {
            MapConfig mapConfig = this.f7028q;
            if (mapConfig != null) {
                return mapConfig.getMaxZoomLevel();
            }
            return 20.0f;
        } catch (Throwable th) {
            b3.D(th);
            return 20.0f;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final float getMinZoomLevel() {
        try {
            MapConfig mapConfig = this.f7028q;
            if (mapConfig != null) {
                return mapConfig.getMinZoomLevel();
            }
            return 3.0f;
        } catch (Throwable th) {
            b3.D(th);
            return 3.0f;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final Location getMyLocation() throws RemoteException {
        if (this.f7038v != null) {
            return this.f6988a.f7831b;
        }
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final MyLocationStyle getMyLocationStyle() throws RemoteException {
        q1 q1Var = this.f7036u;
        if (q1Var != null) {
            return q1Var.a();
        }
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final int getNativeEngineID() {
        return this.f7022n;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final long getNativeMapController() {
        GLMapEngine gLMapEngine = this.Z;
        if (gLMapEngine != null) {
            return gLMapEngine.getNativeMapController(this.f7022n);
        }
        return 0L;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void getPixel2Geo(int i6, int i7, IPoint iPoint) {
        GLMapEngine gLMapEngine;
        GLMapState mapState;
        if (this.f7024o.get() || !this.f7019l0 || (gLMapEngine = this.Z) == null || (mapState = gLMapEngine.getMapState(this.f7022n)) == null) {
            return;
        }
        mapState.screenToP20Point(i6, i7, iPoint);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void getPixel2LatLng(int i6, int i7, DPoint dPoint) {
        GLMapEngine gLMapEngine;
        GLMapState mapState;
        if (this.f7024o.get() || !this.f7019l0 || (gLMapEngine = this.Z) == null || (mapState = gLMapEngine.getMapState(this.f7022n)) == null) {
            return;
        }
        IPoint obtain = IPoint.obtain();
        mapState.screenToP20Point(i6, i7, obtain);
        DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(((Point) obtain).x, ((Point) obtain).y, 20);
        dPoint.f9903x = pixelsToLatLong.f9903x;
        dPoint.f9904y = pixelsToLatLong.f9904y;
        obtain.recycle();
        pixelsToLatLong.recycle();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float getPreciseLevel(int i6) {
        MapConfig mapConfig = this.f7028q;
        if (mapConfig != null) {
            return mapConfig.getSZ();
        }
        return 0.0f;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final IProjectionDelegate getProjection() throws RemoteException {
        return this.f7003f;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final float[] getProjectionMatrix() {
        MapConfig mapConfig = this.f7028q;
        return mapConfig != null ? mapConfig.getProjectionMatrix() : this.f6996c1;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final Rect getRect() {
        return this.H;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final int getRenderMode() {
        return this.f7014j.getRenderMode();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final int getSX() {
        MapConfig mapConfig = this.f7028q;
        if (mapConfig != null) {
            return (int) mapConfig.getSX();
        }
        return -1;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final int getSY() {
        MapConfig mapConfig = this.f7028q;
        if (mapConfig != null) {
            return (int) mapConfig.getSY();
        }
        return -1;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final String getSatelliteImageApprovalNumber() {
        y2.r(this.Y);
        String b6 = r2.b(this.Y, "approval_number", "si", "");
        return !TextUtils.isEmpty(b6) ? b6 : "GS (2023)4047号";
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final float getSkyHeight() {
        return this.f7028q.getSkyHeight();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final String getTerrainApprovalNumber() {
        y2.s(this.Y);
        String b6 = r2.b(this.Y, "approval_number", "te", "");
        return !TextUtils.isEmpty(b6) ? b6 : "GS(2021)6352号";
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final IUiSettingsDelegate getUiSettings() {
        return this.f7006g;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float getUnitLengthByZoom(int i6) {
        GLMapState gLMapState = new GLMapState(this.f7022n, this.Z.getNativeInstance());
        gLMapState.setMapZoomer(i6);
        gLMapState.recalculate();
        float gLUnitWithWin = gLMapState.getGLUnitWithWin(1);
        gLMapState.recycle();
        return gLUnitWithWin;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final View getView() throws RemoteException {
        i3 i3Var = this.f7016k;
        if (i3Var != null) {
            return i3Var.j();
        }
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final float[] getViewMatrix() {
        MapConfig mapConfig = this.f7028q;
        return mapConfig != null ? mapConfig.getViewMatrix() : this.f6993b1;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final Point getWaterMarkerPositon() {
        i3 i3Var = this.f7016k;
        return i3Var != null ? i3Var.a() : new Point();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final String getWorldVectorMapLanguage() {
        return this.Q0;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final String getWorldVectorMapStyle() {
        return this.R0;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final int hideBuildings(List<LatLng> list) {
        if (this.Z == null) {
            return -1;
        }
        FutureTask futureTask = new FutureTask(new f0(list));
        queueEvent(futureTask);
        try {
            return ((Integer) futureTask.get()).intValue();
        } catch (InterruptedException e6) {
            e6.printStackTrace();
            return -1;
        } catch (ExecutionException e7) {
            e7.printStackTrace();
            return -1;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void hideInfoWindow() {
        com.amap.api.col.p0003l.a0 a0Var = this.f6997d;
        if (a0Var != null) {
            a0Var.w();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final boolean isIndoorEnabled() throws RemoteException {
        return this.f7028q.isIndoorEnable();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final boolean isMaploaded() {
        return this.f7032s;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final boolean isMyLocationEnabled() throws RemoteException {
        return this.f7020m;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final boolean isTouchPoiEnable() {
        MapConfig mapConfig = this.f7028q;
        if (mapConfig != null) {
            return mapConfig.isTouchPoiEnable();
        }
        return true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final boolean isTrafficEnabled() throws RemoteException {
        return this.f7028q.isTrafficEnabled();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final boolean isUseAnchor() {
        return this.f7030r;
    }

    public final void k(int i6, boolean z5) {
        if (this.f7019l0 && this.f7021m0) {
            resetRenderTime();
            queueEvent(new g(i6, z5));
        } else {
            t0 t0Var = this.E0;
            t0Var.f7121b = z5;
            t0Var.f7120a = true;
            t0Var.f7124e = i6;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void latlon2Geo(double d6, double d7, IPoint iPoint) {
        Point latLongToPixels = VirtualEarthProjection.latLongToPixels(d6, d7, 20);
        ((Point) iPoint).x = latLongToPixels.x;
        ((Point) iPoint).y = latLongToPixels.y;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void loadWorldVectorMap(boolean z5) {
        MapConfig mapConfig = this.f7028q;
        if (mapConfig != null) {
            mapConfig.setAbroadEnable(z5);
        }
    }

    protected final void n(CameraPosition cameraPosition) {
        MapConfig mapConfig = this.f7028q;
        if (mapConfig == null || mapConfig.getChangedCounter() == 0) {
            return;
        }
        try {
            if (!this.f7015j0 && this.Z.getAnimateionsCount() == 0 && this.Z.getStateMessageCount() == 0) {
                AMapGestureListener aMapGestureListener = this.f6994c;
                if (aMapGestureListener != null) {
                    aMapGestureListener.onMapStable();
                }
                if (this.f7014j.isEnabled()) {
                    try {
                        List a6 = this.f6991b.a(AMap.OnCameraChangeListener.class.hashCode());
                        if (a6 != null && a6.size() != 0) {
                            if (cameraPosition == null) {
                                try {
                                    cameraPosition = getCameraPosition();
                                } catch (Throwable th) {
                                    v5.p(th, "AMapDelegateImp", "cameraChangeFinish");
                                    th.printStackTrace();
                                }
                            }
                            synchronized (a6) {
                                try {
                                    Iterator it = a6.iterator();
                                    while (it.hasNext()) {
                                        ((AMap.OnCameraChangeListener) it.next()).onCameraChangeFinish(cameraPosition);
                                    }
                                } finally {
                                }
                            }
                        }
                    } catch (Throwable unused) {
                    }
                    this.f7028q.resetChangedCounter();
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
            b3.D(th2);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void onAMapAppResourceRequest(AMapAppRequestParam aMapAppRequestParam) {
        aa aaVar = this.f6991b;
        if (aaVar == null) {
            return;
        }
        for (AMap.AMapAppResourceRequestListener aMapAppResourceRequestListener : aaVar.a(AMap.AMapAppResourceRequestListener.class.hashCode())) {
            if (aMapAppResourceRequestListener != null) {
                aMapAppResourceRequestListener.onRequest(aMapAppRequestParam);
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void onChangeFinish() {
        Message obtainMessage = this.f7047z0.obtainMessage();
        obtainMessage.what = 11;
        this.f7047z0.sendMessage(obtainMessage);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final boolean onDoubleTap(int i6, MotionEvent motionEvent) {
        if (!this.f7019l0) {
            return false;
        }
        t((int) motionEvent.getX(), (int) motionEvent.getY());
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void onFling() {
        IGlOverlayLayer iGlOverlayLayer = this.f7018l;
        if (iGlOverlayLayer != null) {
            iGlOverlayLayer.setFlingState(true);
        }
        this.D = true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void onIndoorBuildingActivity(int i6, byte[] bArr) {
        com.amap.api.col.p0003l.z zVar;
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    zVar = new com.amap.api.col.p0003l.z();
                    byte b6 = bArr[0];
                    zVar.f7776a = new String(bArr, 1, b6, "utf-8");
                    int i7 = b6 + 1;
                    int i8 = b6 + 2;
                    byte b7 = bArr[i7];
                    zVar.f7777b = new String(bArr, i8, b7, "utf-8");
                    int i9 = i8 + b7;
                    int i10 = i9 + 1;
                    byte b8 = bArr[i9];
                    zVar.activeFloorName = new String(bArr, i10, b8, "utf-8");
                    int i11 = i10 + b8;
                    zVar.activeFloorIndex = GLConvertUtil.getInt(bArr, i11);
                    int i12 = i11 + 4;
                    int i13 = i11 + 5;
                    byte b9 = bArr[i12];
                    zVar.poiid = new String(bArr, i13, b9, "utf-8");
                    int i14 = i13 + b9;
                    int i15 = i14 + 1;
                    byte b10 = bArr[i14];
                    zVar.f7783h = new String(bArr, i15, b10, "utf-8");
                    int i16 = i15 + b10;
                    int i17 = GLConvertUtil.getInt(bArr, i16);
                    zVar.f7778c = i17;
                    int i18 = i16 + 4;
                    zVar.floor_indexs = new int[i17];
                    zVar.floor_names = new String[i17];
                    zVar.f7779d = new String[i17];
                    for (int i19 = 0; i19 < zVar.f7778c; i19++) {
                        zVar.floor_indexs[i19] = GLConvertUtil.getInt(bArr, i18);
                        int i20 = i18 + 4;
                        int i21 = i18 + 5;
                        byte b11 = bArr[i20];
                        if (b11 > 0) {
                            zVar.floor_names[i19] = new String(bArr, i21, b11, "utf-8");
                            i21 += b11;
                        }
                        int i22 = i21 + 1;
                        byte b12 = bArr[i21];
                        if (b12 > 0) {
                            zVar.f7779d[i19] = new String(bArr, i22, b12, "utf-8");
                            i22 += b12;
                        }
                        i18 = i22;
                    }
                    int i23 = GLConvertUtil.getInt(bArr, i18);
                    zVar.f7780e = i23;
                    int i24 = i18 + 4;
                    if (i23 > 0) {
                        zVar.f7781f = new int[i23];
                        for (int i25 = 0; i25 < zVar.f7780e; i25++) {
                            zVar.f7781f[i25] = GLConvertUtil.getInt(bArr, i24);
                            i24 += 4;
                        }
                    }
                    this.Z0 = zVar;
                    post(new a0());
                }
            } catch (Throwable th) {
                b3.D(th);
                th.printStackTrace();
                return;
            }
        }
        zVar = null;
        this.Z0 = zVar;
        post(new a0());
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAMapListener
    public final void onMapPOIClick(MapPoi mapPoi) {
        List a6;
        MapConfig mapConfig = this.f7028q;
        if (mapConfig == null || !mapConfig.isTouchPoiEnable() || (a6 = this.f6991b.a(AMap.OnPOIClickListener.class.hashCode())) == null || a6.size() <= 0 || mapPoi == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 20;
        obtain.obj = new Poi(mapPoi.getName(), new LatLng(mapPoi.getLatitude(), mapPoi.getLongitude()), mapPoi.getPoiid());
        this.f7047z0.sendMessage(obtain);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void onResume() {
        try {
            this.f6989a0.setRenderFps(15.0f);
            this.f7014j.setRenderMode(0);
            IGlOverlayLayer iGlOverlayLayer = this.f7018l;
            if (iGlOverlayLayer != null) {
                iGlOverlayLayer.setFlingState(true);
            }
            q1 q1Var = this.f7036u;
            if (q1Var != null) {
                q1Var.k();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final boolean onSingleTapConfirmed(int i6, MotionEvent motionEvent) {
        if (!this.f7019l0) {
            return false;
        }
        try {
            y(i6);
            if (c0(motionEvent) || Q(motionEvent) || Z(motionEvent)) {
                return true;
            }
            M(motionEvent);
            if (U(motionEvent)) {
                return true;
            }
            I(motionEvent);
            return true;
        } catch (Throwable th) {
            v5.p(th, "AMapDelegateImp", "onSingleTapUp");
            th.printStackTrace();
            return true;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f7026p || !this.f7019l0 || !this.f7013i0) {
            return false;
        }
        EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.V0;
        eAMapPlatformGestureInfo.mGestureState = 3;
        eAMapPlatformGestureInfo.mGestureType = 8;
        eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
        getEngineIDWithGestureInfo(this.V0);
        l0();
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            n0();
            K();
        } else if (action == 1) {
            O();
        }
        if (motionEvent.getAction() == 2 && this.f7040w) {
            try {
                l(motionEvent);
            } catch (Throwable th) {
                v5.p(th, "AMapDelegateImp", "onDragMarker");
                th.printStackTrace();
            }
            return true;
        }
        if (motionEvent.getAction() == 2 && this.f7042x) {
            try {
                B(motionEvent);
            } catch (Throwable th2) {
                v5.p(th2, "AMapDelegateImp", "onDragGLTF");
                th2.printStackTrace();
            }
            return true;
        }
        if (this.f6995c0) {
            try {
                List a6 = this.f6991b.a(AMap.SignleClickInterceptorListener.class.hashCode());
                if (a6 == null || a6.size() <= 0) {
                    this.f6992b0.e(motionEvent);
                } else if (!((AMap.SignleClickInterceptorListener) a6.get(0)).isInterceptorSignleClick(motionEvent)) {
                    this.f6992b0.e(motionEvent);
                }
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
        }
        try {
            List a7 = this.f6991b.a(AMap.OnMapTouchListener.class.hashCode());
            if (a7 != null && a7.size() > 0) {
                this.f7047z0.removeMessages(14);
                Message obtainMessage = this.f7047z0.obtainMessage();
                obtainMessage.what = 14;
                obtainMessage.obj = MotionEvent.obtain(motionEvent);
                obtainMessage.sendToTarget();
            }
        } catch (Throwable unused) {
        }
        return true;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void pixel2Map(int i6, int i7, PointF pointF) {
        if (!this.f7019l0 || this.f7026p || this.Z == null) {
            return;
        }
        IPoint obtain = IPoint.obtain();
        getPixel2Geo(i6, i7, obtain);
        pointF.x = ((Point) obtain).x - ((float) this.f7028q.getSX());
        pointF.y = ((Point) obtain).y - ((float) this.f7028q.getSY());
        obtain.recycle();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void post(Runnable runnable) {
        IGLSurfaceView iGLSurfaceView = this.f7014j;
        if (iGLSurfaceView != null) {
            iGLSurfaceView.post(runnable);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void queueEvent(Runnable runnable) {
        long j6;
        try {
            try {
                j6 = Thread.currentThread().getId();
            } catch (Throwable th) {
                b3.D(th);
                v5.p(th, "AMapdelegateImp", "queueEvent");
                j6 = -1;
            }
            if (j6 != -1 && j6 == this.X) {
                runnable.run();
            } else if (this.Z != null) {
                this.f7014j.queueEvent(runnable);
            }
        } catch (Throwable th2) {
            b3.D(th2);
            v5.p(th2, "AMapdelegateImp", "queueEvent");
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void redrawInfoWindow() {
        if (!this.f7024o.get() && this.f7019l0) {
            this.f7047z0.sendEmptyMessage(18);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void refreshLogo() {
        i3 i3Var = this.f7016k;
        if (i3Var != null) {
            i3Var.c();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void reloadMapCustomStyle() {
        u8 u8Var = this.f7041w0;
        if (u8Var != null) {
            u8Var.j();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeAMapAppResourceListener(AMap.AMapAppResourceRequestListener aMapAppResourceRequestListener) {
        aa aaVar = this.f6991b;
        if (aaVar != null) {
            aaVar.f(Integer.valueOf(AMap.AMapAppResourceRequestListener.class.hashCode()), aMapAppResourceRequestListener);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void removeEngineGLOverlay(BaseMapOverlay baseMapOverlay) {
        if (this.Z != null) {
            queueEvent(new e0(baseMapOverlay));
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final boolean removeGLModel(String str) {
        try {
            this.f7018l.removeOverlay(str);
            return false;
        } catch (Throwable th) {
            v5.p(th, "AMapDelegateImp", "removeGLModel");
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnCameraChangeListener(AMap.OnCameraChangeListener onCameraChangeListener) throws RemoteException {
        aa aaVar = this.f6991b;
        if (aaVar != null) {
            aaVar.f(Integer.valueOf(AMap.OnCameraChangeListener.class.hashCode()), onCameraChangeListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnIndoorBuildingActiveListener(AMap.OnIndoorBuildingActiveListener onIndoorBuildingActiveListener) throws RemoteException {
        aa aaVar = this.f6991b;
        if (aaVar != null) {
            aaVar.f(Integer.valueOf(AMap.OnIndoorBuildingActiveListener.class.hashCode()), onIndoorBuildingActiveListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnInfoWindowClickListener(AMap.OnInfoWindowClickListener onInfoWindowClickListener) throws RemoteException {
        aa aaVar = this.f6991b;
        if (aaVar != null) {
            aaVar.f(Integer.valueOf(AMap.OnInfoWindowClickListener.class.hashCode()), onInfoWindowClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnMapClickListener(AMap.OnMapClickListener onMapClickListener) throws RemoteException {
        aa aaVar = this.f6991b;
        if (aaVar != null) {
            aaVar.f(Integer.valueOf(AMap.OnMapClickListener.class.hashCode()), onMapClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnMapLoadedListener(AMap.OnMapLoadedListener onMapLoadedListener) {
        aa aaVar = this.f6991b;
        if (aaVar != null) {
            aaVar.f(Integer.valueOf(AMap.OnMapLoadedListener.class.hashCode()), onMapLoadedListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnMapLongClickListener(AMap.OnMapLongClickListener onMapLongClickListener) throws RemoteException {
        aa aaVar = this.f6991b;
        if (aaVar != null) {
            aaVar.f(Integer.valueOf(AMap.OnMapLongClickListener.class.hashCode()), onMapLongClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnMapTouchListener(AMap.OnMapTouchListener onMapTouchListener) throws RemoteException {
        aa aaVar = this.f6991b;
        if (aaVar != null) {
            aaVar.f(Integer.valueOf(AMap.OnMapTouchListener.class.hashCode()), onMapTouchListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnMarkerClickListener(AMap.OnMarkerClickListener onMarkerClickListener) throws RemoteException {
        aa aaVar = this.f6991b;
        if (aaVar != null) {
            aaVar.f(Integer.valueOf(AMap.OnMarkerClickListener.class.hashCode()), onMarkerClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnMarkerDragListener(AMap.OnMarkerDragListener onMarkerDragListener) {
        aa aaVar = this.f6991b;
        if (aaVar != null) {
            aaVar.f(Integer.valueOf(AMap.OnMarkerDragListener.class.hashCode()), onMarkerDragListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnMyLocationChangeListener(AMap.OnMyLocationChangeListener onMyLocationChangeListener) throws RemoteException {
        aa aaVar = this.f6991b;
        if (aaVar != null) {
            aaVar.f(Integer.valueOf(AMap.OnMyLocationChangeListener.class.hashCode()), onMyLocationChangeListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnPOIClickListener(AMap.OnPOIClickListener onPOIClickListener) throws RemoteException {
        aa aaVar = this.f6991b;
        if (aaVar != null) {
            aaVar.f(Integer.valueOf(AMap.OnPOIClickListener.class.hashCode()), onPOIClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeOnPolylineClickListener(AMap.OnPolylineClickListener onPolylineClickListener) throws RemoteException {
        aa aaVar = this.f6991b;
        if (aaVar != null) {
            aaVar.f(Integer.valueOf(AMap.OnPolylineClickListener.class.hashCode()), onPolylineClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removeSignleClickInterceptorListener(AMap.SignleClickInterceptorListener signleClickInterceptorListener) {
        aa aaVar = this.f6991b;
        if (aaVar != null) {
            aaVar.f(Integer.valueOf(AMap.SignleClickInterceptorListener.class.hashCode()), signleClickInterceptorListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void removecache(AMap.OnCacheRemoveListener onCacheRemoveListener) throws RemoteException {
        if (this.f7047z0 == null || this.Z == null) {
            return;
        }
        try {
            w0 w0Var = new w0(this.Y, onCacheRemoveListener);
            this.f7047z0.removeCallbacks(w0Var);
            this.f7047z0.post(w0Var);
        } catch (Throwable th) {
            v5.p(th, "AMapDelegateImp", "removecache");
            th.printStackTrace();
            b3.D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void requestRender() {
        GLMapRender gLMapRender = this.f6989a0;
        if (gLMapRender == null || gLMapRender.isRenderPause()) {
            return;
        }
        this.f7014j.requestRender();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void resetMinMaxZoomPreference() {
        List a6;
        this.f7028q.resetMinMaxZoomPreference();
        try {
            if (!this.f7006g.isZoomControlsEnabled() || !this.f7028q.isNeedUpdateZoomControllerState() || (a6 = this.f6991b.a(AMapWidgetListener.class.hashCode())) == null || a6.size() <= 0) {
                return;
            }
            synchronized (a6) {
                for (int i6 = 0; i6 < a6.size(); i6++) {
                    try {
                        ((AMapWidgetListener) a6.get(i6)).invalidateZoomController(this.f7028q.getSZ());
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        } catch (Throwable th2) {
            b3.D(th2);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void resetRenderTime() {
        GLMapRender gLMapRender = this.f6989a0;
        if (gLMapRender != null) {
            gLMapRender.resetTickCount(2);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void resetRenderTimeLongLong() {
        GLMapRender gLMapRender = this.f6989a0;
        if (gLMapRender != null) {
            gLMapRender.resetTickCount(30);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void set3DBuildingEnabled(boolean z5) throws RemoteException {
        try {
            G(this.f7022n);
            k(this.f7022n, z5);
            L(this.f7022n);
        } catch (Throwable th) {
            b3.D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setAMapGestureListener(AMapGestureListener aMapGestureListener) {
        ia iaVar = this.f6992b0;
        if (iaVar != null) {
            this.f6994c = aMapGestureListener;
            iaVar.d(aMapGestureListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setConstructingRoadEnable(boolean z5) {
        try {
            if (this.f7019l0 && this.f7021m0) {
                resetRenderTime();
                queueEvent(new t(z5));
            } else {
                t0 t0Var = this.I0;
                t0Var.f7121b = z5;
                t0Var.f7120a = true;
                t0Var.f7124e = this.f7022n;
            }
        } catch (Throwable th) {
            b3.D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setCustomRenderer(CustomRenderer customRenderer) throws RemoteException {
        this.Q = customRenderer;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setGestureStatus(int i6, int i7) {
        if (this.f7029q0 == 0 || i7 != 5) {
            this.f7029q0 = i7;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setHideLogoEnble(boolean z5) {
        MapConfig mapConfig = this.f7028q;
        if (mapConfig != null) {
            mapConfig.setHideLogoEnble(z5);
            if (this.f7028q.isCustomStyleEnable()) {
                this.f7006g.setLogoEnable(!z5);
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setIndoorBuildingInfo(IndoorBuildingInfo indoorBuildingInfo) throws RemoteException {
        if (this.f7024o.get() || indoorBuildingInfo == null || indoorBuildingInfo.activeFloorName == null || indoorBuildingInfo.poiid == null) {
            return;
        }
        this.f7034t = (com.amap.api.col.p0003l.z) indoorBuildingInfo;
        resetRenderTime();
        queueEvent(new z());
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setIndoorEnabled(boolean z5) throws RemoteException {
        List a6;
        try {
            if (!this.f7019l0 || this.f7024o.get()) {
                t0 t0Var = this.M0;
                t0Var.f7121b = z5;
                t0Var.f7120a = true;
                t0Var.f7124e = this.f7022n;
                return;
            }
            this.f7028q.setIndoorEnable(z5);
            resetRenderTime();
            if (z5) {
                GLMapEngine gLMapEngine = this.Z;
                if (gLMapEngine != null) {
                    gLMapEngine.setIndoorEnable(this.f7022n, true);
                }
            } else {
                GLMapEngine gLMapEngine2 = this.Z;
                if (gLMapEngine2 != null) {
                    gLMapEngine2.setIndoorEnable(this.f7022n, false);
                }
                MapConfig mapConfig = this.f7028q;
                mapConfig.maxZoomLevel = mapConfig.isSetLimitZoomLevel() ? this.f7028q.getMaxZoomLevel() : 20.0f;
                try {
                    if (this.f7006g.isZoomControlsEnabled() && (a6 = this.f6991b.a(AMapWidgetListener.class.hashCode())) != null && a6.size() > 0) {
                        synchronized (a6) {
                            for (int i6 = 0; i6 < a6.size(); i6++) {
                                try {
                                    ((AMapWidgetListener) a6.get(i6)).invalidateZoomController(this.f7028q.getSZ());
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                        }
                    }
                } catch (Throwable unused) {
                }
            }
            y2.p(this.Y, z5);
            if (this.f7006g.isIndoorSwitchEnabled()) {
                this.f7047z0.post(new o(z5));
            }
        } catch (Throwable th2) {
            b3.D(th2);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setLoadOfflineData(boolean z5) throws RemoteException {
        queueEvent(new p(z5));
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setLocationSource(LocationSource locationSource) throws RemoteException {
        try {
            if (this.f7024o.get()) {
                return;
            }
            LocationSource locationSource2 = this.f7038v;
            if (locationSource2 != null && (locationSource2 instanceof com.amap.api.col.p0003l.b0)) {
                locationSource2.deactivate();
            }
            this.f7038v = locationSource;
            if (locationSource != null) {
                this.f7016k.p(Boolean.TRUE);
            } else {
                this.f7016k.p(Boolean.FALSE);
            }
        } catch (Throwable th) {
            v5.p(th, "AMapDelegateImp", "setLocationSource");
            th.printStackTrace();
            b3.D(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setLogoBottomMargin(int i6) {
        i3 i3Var = this.f7016k;
        if (i3Var != null) {
            i3Var.d(Integer.valueOf(i6));
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setLogoLeftMargin(int i6) {
        i3 i3Var = this.f7016k;
        if (i3Var != null) {
            i3Var.f(Integer.valueOf(i6));
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setLogoMarginRate(int i6, float f6) {
        i3 i3Var = this.f7016k;
        if (i3Var != null) {
            i3Var.a(Integer.valueOf(i6), Float.valueOf(f6));
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setLogoPosition(int i6) {
        i3 i3Var = this.f7016k;
        if (i3Var != null) {
            i3Var.k(Integer.valueOf(i6));
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setMapEnable(boolean z5) {
        MapConfig mapConfig = this.f7028q;
        if (mapConfig != null) {
            mapConfig.setMapEnable(z5);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMapStatusLimits(LatLngBounds latLngBounds) {
        try {
            this.f7028q.setLimitLatLngBounds(latLngBounds);
            t0();
        } catch (Throwable th) {
            th.printStackTrace();
            b3.D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMapTextEnable(boolean z5) throws RemoteException {
        try {
            if (this.f7019l0 && this.f7021m0) {
                resetRenderTime();
                queueEvent(new q(z5));
            } else {
                t0 t0Var = this.F0;
                t0Var.f7121b = z5;
                t0Var.f7120a = true;
                t0Var.f7124e = this.f7022n;
            }
        } catch (Throwable th) {
            b3.D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMapTextZIndex(int i6) throws RemoteException {
        this.P = i6;
        this.f7045y0 = false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMapType(int i6) throws RemoteException {
        MapConfig mapConfig;
        if (i6 != this.I || ((mapConfig = this.f7028q) != null && mapConfig.isCustomStyleEnable())) {
            this.I = i6;
            b0(i6);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setMapWidgetListener(AMapWidgetListener aMapWidgetListener) {
        try {
            aa aaVar = this.f6991b;
            if (aaVar != null) {
                aaVar.c(AMapWidgetListener.class.hashCode(), aMapWidgetListener);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMaxZoomLevel(float f6) {
        this.f7028q.setMaxZoomLevel(f6);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMinZoomLevel(float f6) {
        this.f7028q.setMinZoomLevel(f6);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMyLocationEnabled(boolean z5) throws RemoteException {
        if (this.f7024o.get()) {
            return;
        }
        try {
            i3 i3Var = this.f7016k;
            if (i3Var != null) {
                LocationSource locationSource = this.f7038v;
                if (locationSource == null) {
                    i3Var.p(Boolean.FALSE);
                } else if (z5) {
                    locationSource.activate(this.f6988a);
                    this.f7016k.p(Boolean.TRUE);
                    if (this.f7036u == null) {
                        this.f7036u = new q1(this, this.Y);
                    }
                } else {
                    q1 q1Var = this.f7036u;
                    if (q1Var != null) {
                        q1Var.n();
                        this.f7036u = null;
                    }
                    this.f7038v.deactivate();
                }
            }
            if (!z5) {
                this.f7006g.setMyLocationButtonEnabled(z5);
            }
            this.f7020m = z5;
            resetRenderTime();
        } catch (Throwable th) {
            v5.p(th, "AMapDelegateImp", "setMyLocationEnabled");
            th.printStackTrace();
            b3.D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMyLocationRotateAngle(float f6) throws RemoteException {
        try {
            q1 q1Var = this.f7036u;
            if (q1Var != null) {
                q1Var.b(f6);
            }
        } catch (Throwable th) {
            b3.D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMyLocationStyle(MyLocationStyle myLocationStyle) throws RemoteException {
        if (this.f7024o.get()) {
            return;
        }
        try {
            if (this.f7036u == null) {
                this.f7036u = new q1(this, this.Y);
            }
            if (this.f7036u != null) {
                if (myLocationStyle.getInterval() < 1000) {
                    myLocationStyle.interval(1000L);
                }
                LocationSource locationSource = this.f7038v;
                if (locationSource != null && (locationSource instanceof com.amap.api.col.p0003l.b0)) {
                    ((com.amap.api.col.p0003l.b0) locationSource).d(myLocationStyle.getInterval());
                    ((com.amap.api.col.p0003l.b0) this.f7038v).c(myLocationStyle.getMyLocationType());
                }
                this.f7036u.h(myLocationStyle);
            }
        } catch (Throwable th) {
            b3.D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMyLocationType(int i6) throws RemoteException {
        try {
            q1 q1Var = this.f7036u;
            if (q1Var == null || q1Var.a() == null) {
                return;
            }
            this.f7036u.a().myLocationType(i6);
            setMyLocationStyle(this.f7036u.a());
        } catch (Throwable th) {
            b3.D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setNaviLabelEnable(boolean z5, int i6, int i7) throws RemoteException {
        try {
            if (this.f7019l0 && this.f7021m0) {
                resetRenderTime();
                queueEvent(new s(z5, i6, i7));
                return;
            }
            t0 t0Var = this.H0;
            t0Var.f7121b = z5;
            t0Var.f7125f = i6;
            t0Var.f7126g = i7;
            t0Var.f7120a = true;
            t0Var.f7124e = this.f7022n;
        } catch (Throwable th) {
            b3.D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnCameraChangeListener(AMap.OnCameraChangeListener onCameraChangeListener) throws RemoteException {
        aa aaVar = this.f6991b;
        if (aaVar != null) {
            aaVar.c(AMap.OnCameraChangeListener.class.hashCode(), onCameraChangeListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnIndoorBuildingActiveListener(AMap.OnIndoorBuildingActiveListener onIndoorBuildingActiveListener) throws RemoteException {
        aa aaVar = this.f6991b;
        if (aaVar != null) {
            aaVar.c(AMap.OnIndoorBuildingActiveListener.class.hashCode(), onIndoorBuildingActiveListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnInfoWindowClickListener(AMap.OnInfoWindowClickListener onInfoWindowClickListener) throws RemoteException {
        aa aaVar = this.f6991b;
        if (aaVar != null) {
            aaVar.c(AMap.OnInfoWindowClickListener.class.hashCode(), onInfoWindowClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnMapClickListener(AMap.OnMapClickListener onMapClickListener) throws RemoteException {
        aa aaVar = this.f6991b;
        if (aaVar != null) {
            aaVar.c(AMap.OnMapClickListener.class.hashCode(), onMapClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnMapLongClickListener(AMap.OnMapLongClickListener onMapLongClickListener) throws RemoteException {
        aa aaVar = this.f6991b;
        if (aaVar != null) {
            aaVar.c(AMap.OnMapLongClickListener.class.hashCode(), onMapLongClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnMapTouchListener(AMap.OnMapTouchListener onMapTouchListener) throws RemoteException {
        aa aaVar = this.f6991b;
        if (aaVar != null) {
            aaVar.c(AMap.OnMapTouchListener.class.hashCode(), onMapTouchListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnMaploadedListener(AMap.OnMapLoadedListener onMapLoadedListener) throws RemoteException {
        aa aaVar = this.f6991b;
        if (aaVar != null) {
            aaVar.c(AMap.OnMapLoadedListener.class.hashCode(), onMapLoadedListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnMarkerClickListener(AMap.OnMarkerClickListener onMarkerClickListener) throws RemoteException {
        aa aaVar = this.f6991b;
        if (aaVar != null) {
            aaVar.c(AMap.OnMarkerClickListener.class.hashCode(), onMarkerClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnMarkerDragListener(AMap.OnMarkerDragListener onMarkerDragListener) throws RemoteException {
        aa aaVar = this.f6991b;
        if (aaVar != null) {
            aaVar.c(AMap.OnMarkerDragListener.class.hashCode(), onMarkerDragListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnMultiPointClickListener(AMap.OnMultiPointClickListener onMultiPointClickListener) {
        this.f7039v0 = onMultiPointClickListener;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnMyLocationChangeListener(AMap.OnMyLocationChangeListener onMyLocationChangeListener) {
        aa aaVar = this.f6991b;
        if (aaVar != null) {
            aaVar.c(AMap.OnMyLocationChangeListener.class.hashCode(), onMyLocationChangeListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnPOIClickListener(AMap.OnPOIClickListener onPOIClickListener) throws RemoteException {
        aa aaVar = this.f6991b;
        if (aaVar != null) {
            aaVar.c(AMap.OnPOIClickListener.class.hashCode(), onPOIClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setOnPolylineClickListener(AMap.OnPolylineClickListener onPolylineClickListener) throws RemoteException {
        aa aaVar = this.f6991b;
        if (aaVar != null) {
            aaVar.c(AMap.OnPolylineClickListener.class.hashCode(), onPolylineClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setRenderMode(int i6) {
        try {
            IGLSurfaceView iGLSurfaceView = this.f7014j;
            if (iGLSurfaceView != null) {
                iGLSurfaceView.setRenderMode(i6);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setRoadArrowEnable(boolean z5) throws RemoteException {
        try {
            if (this.f7019l0 && this.f7021m0) {
                resetRenderTime();
                queueEvent(new r(z5));
            } else {
                t0 t0Var = this.G0;
                t0Var.f7121b = z5;
                t0Var.f7120a = true;
                t0Var.f7124e = this.f7022n;
            }
        } catch (Throwable th) {
            b3.D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setRunLowFrame(boolean z5) {
        if (z5) {
            return;
        }
        try {
            if (this.S == -1) {
                n0();
            }
        } catch (Throwable th) {
            b3.D(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setTerrainAuth(boolean z5) {
        GLMapEngine gLMapEngine;
        if (this.f7024o.get() || (gLMapEngine = this.Z) == null) {
            return;
        }
        gLMapEngine.setTerrainAuth(z5);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setTouchPoiEnable(boolean z5) {
        MapConfig mapConfig = this.f7028q;
        if (mapConfig != null) {
            mapConfig.setTouchPoiEnable(z5);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setTrafficEnabled(boolean z5) throws RemoteException {
        try {
            if (this.f7019l0 && !this.f7024o.get()) {
                queueEvent(new n(z5, z5));
                return;
            }
            t0 t0Var = this.A0;
            t0Var.f7121b = z5;
            t0Var.f7120a = true;
            t0Var.f7124e = this.f7022n;
        } catch (Throwable th) {
            b3.D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setTrafficStyleWithTexture(byte[] bArr, MyTrafficStyle myTrafficStyle) {
        if (this.f7024o.get()) {
            return;
        }
        try {
            if (this.f7019l0 && this.f7021m0 && bArr != null && myTrafficStyle != null) {
                resetRenderTime();
                queueEvent(new u(bArr, myTrafficStyle));
                return;
            }
            t0 t0Var = this.K0;
            t0Var.f7127h = bArr;
            t0Var.f7128i = myTrafficStyle;
            t0Var.f7120a = true;
            t0Var.f7124e = this.f7022n;
        } catch (Exception e6) {
            b3.D(e6);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setTrafficStyleWithTextureData(byte[] bArr) {
        if (this.f7024o.get()) {
            return;
        }
        try {
            if (this.f7019l0 && this.f7021m0 && bArr != null) {
                resetRenderTime();
                queueEvent(new w(bArr));
            } else {
                t0 t0Var = this.J0;
                t0Var.f7127h = bArr;
                t0Var.f7120a = true;
                t0Var.f7124e = this.f7022n;
            }
        } catch (Throwable th) {
            b3.D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setVisibilityEx(int i6) {
        IGLSurfaceView iGLSurfaceView = this.f7014j;
        if (iGLSurfaceView != null) {
            try {
                iGLSurfaceView.setVisibility(i6);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setZoomPosition(int i6) {
        i3 i3Var;
        if (this.f7024o.get() || (i3Var = this.f7016k) == null) {
            return;
        }
        i3Var.h(Integer.valueOf(i6));
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setZoomScaleParam(float f6) {
        this.f7007g0 = f6;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void showCompassEnabled(boolean z5) {
        i3 i3Var;
        if (this.f7024o.get() || (i3Var = this.f7016k) == null) {
            return;
        }
        i3Var.e(Boolean.valueOf(z5));
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void showHideBuildings(int i6) {
        if (this.Z == null) {
            return;
        }
        queueEvent(new h0(i6));
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void showIndoorSwitchControlsEnabled(boolean z5) {
        i3 i3Var;
        if (this.f7024o.get() || (i3Var = this.f7016k) == null) {
            return;
        }
        i3Var.c(Boolean.valueOf(z5));
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void showLogoEnabled(boolean z5) {
        if (this.f7024o.get()) {
            return;
        }
        this.f7016k.i(Boolean.valueOf(z5));
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void showMyLocationButtonEnabled(boolean z5) {
        i3 i3Var;
        if (this.f7024o.get() || (i3Var = this.f7016k) == null) {
            return;
        }
        i3Var.g(Boolean.valueOf(z5));
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void showMyLocationOverlay(Location location) throws RemoteException {
        if (location == null) {
            return;
        }
        try {
            if (this.f7020m && this.f7038v != null) {
                if (this.f7036u == null) {
                    this.f7036u = new q1(this, this.Y);
                }
                if (location.getLongitude() != 0.0d && location.getLatitude() != 0.0d) {
                    this.f7036u.e(location);
                }
                List a6 = this.f6991b.a(AMap.OnMyLocationChangeListener.class.hashCode());
                if (a6 != null && a6.size() > 0) {
                    synchronized (a6) {
                        for (int i6 = 0; i6 < a6.size(); i6++) {
                            try {
                                ((AMap.OnMyLocationChangeListener) a6.get(i6)).onMyLocationChange(location);
                            } finally {
                            }
                        }
                    }
                }
                resetRenderTime();
                return;
            }
            q1 q1Var = this.f7036u;
            if (q1Var != null) {
                q1Var.n();
            }
            this.f7036u = null;
        } catch (Throwable th) {
            v5.p(th, "AMapDelegateImp", "showMyLocationOverlay");
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void showScaleEnabled(boolean z5) {
        i3 i3Var;
        if (this.f7024o.get() || (i3Var = this.f7016k) == null) {
            return;
        }
        i3Var.l(Boolean.valueOf(z5));
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void showZoomControlsEnabled(boolean z5) {
        i3 i3Var;
        if (this.f7024o.get() || (i3Var = this.f7016k) == null) {
            return;
        }
        i3Var.b(Boolean.valueOf(z5));
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void stopAnimation() throws RemoteException {
        try {
            GLMapEngine gLMapEngine = this.Z;
            if (gLMapEngine != null) {
                gLMapEngine.interruptAnimation();
            }
            resetRenderTime();
        } catch (Throwable th) {
            b3.D(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float toMapLenWithWin(int i6) {
        GLMapEngine gLMapEngine;
        if (!this.f7019l0 || this.f7026p || (gLMapEngine = this.Z) == null) {
            return 0.0f;
        }
        return gLMapEngine.getMapState(this.f7022n).getGLUnitWithWin(i6);
    }

    final void x() {
        this.f7047z0.obtainMessage(17, 1, 0).sendToTarget();
    }

    public final void z(int i6, boolean z5) {
        if (this.f7019l0 && this.f7021m0) {
            resetRenderTime();
            queueEvent(new h(z5, i6));
        } else {
            t0 t0Var = this.L0;
            t0Var.f7121b = z5;
            t0Var.f7120a = true;
            t0Var.f7124e = i6;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void zoomOut(int i6) {
        if (this.f7019l0 && ((int) E()) > this.f7028q.getMinZoomLevel()) {
            try {
                animateCamera(com.amap.api.col.p0003l.p.l());
            } catch (Throwable th) {
                v5.p(th, "AMapDelegateImp", "onDoubleTap");
                th.printStackTrace();
            }
            resetRenderTime();
        }
    }

    private void L(int i6) {
        T(i6);
        GLMapRender gLMapRender = this.f6989a0;
        if (gLMapRender != null) {
            gLMapRender.renderResume();
        }
    }

    private boolean Q(MotionEvent motionEvent) throws RemoteException {
        Throwable th;
        LatLng position;
        DPoint obtain = DPoint.obtain();
        getPixel2LatLng((int) motionEvent.getX(), (int) motionEvent.getY(), obtain);
        LatLng latLng = new LatLng(obtain.f9904y, obtain.f9903x);
        obtain.recycle();
        boolean z5 = true;
        BaseOverlay hitBaseOverlay = this.f7018l.getHitBaseOverlay(latLng, 1);
        if ((hitBaseOverlay instanceof Marker) && ((Marker) hitBaseOverlay).getId().contains("MARKER")) {
            try {
                Marker marker = (Marker) hitBaseOverlay;
                this.f7018l.set2Top(marker.getId());
                List a6 = this.f6991b.a(AMap.OnMarkerClickListener.class.hashCode());
                if (a6 != null) {
                    try {
                        if (a6.size() > 0) {
                            synchronized (a6) {
                                try {
                                    if (a6.size() == 1) {
                                        boolean onMarkerClick = ((AMap.OnMarkerClickListener) a6.get(0)).onMarkerClick(marker);
                                        if (onMarkerClick) {
                                            return true;
                                        }
                                        z5 = onMarkerClick;
                                    } else {
                                        Iterator it = a6.iterator();
                                        boolean z6 = false;
                                        while (it.hasNext()) {
                                            z6 |= ((AMap.OnMarkerClickListener) it.next()).onMarkerClick(marker);
                                        }
                                        if (z6) {
                                            return true;
                                        }
                                        z5 = z6;
                                    }
                                } finally {
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        v5.p(th, "AMapDelegateImp", "onMarkerTap");
                        th.printStackTrace();
                        return false;
                    }
                }
                this.f7018l.showInfoWindow(marker.getId());
                if (!marker.isViewMode() && (position = marker.getPosition()) != null) {
                    IPoint obtain2 = IPoint.obtain();
                    try {
                        latlon2Geo(position.latitude, position.longitude, obtain2);
                        moveCamera(com.amap.api.col.p0003l.p.e(obtain2));
                        return z5;
                    } catch (Throwable th3) {
                        th = th3;
                        th = th;
                        v5.p(th, "AMapDelegateImp", "onMarkerTap");
                        th.printStackTrace();
                        return false;
                    }
                }
                return z5;
            } catch (Throwable th4) {
                th = th4;
            }
        }
        return false;
    }

    private boolean U(MotionEvent motionEvent) {
        DPoint obtain = DPoint.obtain();
        getPixel2LatLng((int) motionEvent.getX(), (int) motionEvent.getY(), obtain);
        LatLng latLng = new LatLng(obtain.f9904y, obtain.f9903x);
        obtain.recycle();
        BaseOverlay hitBaseOverlay = this.f7018l.getHitBaseOverlay(latLng, 3);
        if (!(hitBaseOverlay instanceof GLTFOverlay)) {
            return false;
        }
        GLTFOverlay gLTFOverlay = (GLTFOverlay) hitBaseOverlay;
        if (!gLTFOverlay.isClickable()) {
            return false;
        }
        try {
            this.f7018l.set2Top(gLTFOverlay.getId());
            gLTFOverlay.tapClick();
            return true;
        } catch (Throwable th) {
            v5.p(th, "AMapDelegateImp", "onGLTFTap");
            th.printStackTrace();
            return false;
        }
    }

    public final void A(Size size) {
        h(getNativeEngineID(), 0, 0, size.getWidth(), size.getHeight(), size.getWidth(), size.getHeight());
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        getGLMapView().setLayoutParams(layoutParams);
        this.f7016k.f().setLayoutParams(layoutParams);
        changeSize(size.getWidth(), size.getHeight());
        D(true);
    }

    @Override // com.amap.api.col.3l.z1.a
    public final void a(String str, f2 f2Var) {
        setCustomTextureResourcePath(str);
        if (!this.f7028q.isCustomStyleEnable() || f2Var == null) {
            return;
        }
        s(f2Var.c(), false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final AMap3DModelTileOverlay add3DModelTileOverlay(AMap3DModelTileOverlayOptions aMap3DModelTileOverlayOptions) throws RemoteException {
        try {
            resetRenderTime();
            String createId = this.f7018l.createId("AMAP3DMODELTILE");
            AMap3DModelTileOverlay aMap3DModelTileOverlay = new AMap3DModelTileOverlay(this.f7018l, aMap3DModelTileOverlayOptions, createId);
            this.f7018l.addOverlayObject(createId, aMap3DModelTileOverlay, aMap3DModelTileOverlayOptions);
            return aMap3DModelTileOverlay;
        } catch (Throwable th) {
            b3.D(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final GL3DModel addGLModel(GL3DModelOptions gL3DModelOptions) {
        resetRenderTime();
        String createId = this.f7018l.createId("GL3DMODEL");
        GL3DModel gL3DModel = new GL3DModel(this.f7018l, gL3DModelOptions, createId);
        this.f7018l.addOverlayObject(createId, gL3DModel, gL3DModelOptions);
        return gL3DModel;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final Marker addMarker(MarkerOptions markerOptions) throws RemoteException {
        try {
            resetRenderTime();
            MarkerOptions m54clone = markerOptions.m54clone();
            String createId = this.f7018l.createId("MARKER");
            Marker marker = new Marker(this.f7018l, m54clone, createId);
            this.f7018l.addOverlayObject(createId, marker, m54clone);
            return marker;
        } catch (Throwable th) {
            b3.D(th);
            d3.f(c3.f5804d, "addMarker failed " + th.getMessage(), markerOptions);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final ArrayList<Marker> addMarkers(ArrayList<MarkerOptions> arrayList, boolean z5) throws RemoteException {
        try {
            resetRenderTime();
            ArrayList<Marker> arrayList2 = new ArrayList<>();
            LatLngBounds.Builder builder = LatLngBounds.builder();
            for (int i6 = 0; i6 < arrayList.size(); i6++) {
                MarkerOptions markerOptions = arrayList.get(i6);
                if (arrayList.get(i6) != null) {
                    arrayList2.add(addMarker(markerOptions));
                    if (markerOptions.getPosition() != null) {
                        builder.include(markerOptions.getPosition());
                    }
                }
            }
            if (z5 && arrayList2.size() > 0) {
                getMainHandler().postDelayed(new j(builder), 50L);
            }
            return arrayList2;
        } catch (Throwable th) {
            b3.D(th);
            d3.i(c3.f5804d, "addMarkers failed " + th.getMessage(), arrayList);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final Text addText(TextOptions textOptions) throws RemoteException {
        try {
            resetRenderTime();
            String createId = this.f7018l.createId("TEXT");
            TextOptions m58clone = textOptions.m58clone();
            MarkerOptions b6 = t1.b(m58clone);
            Marker marker = new Marker(this.f7018l, b6, createId);
            marker.setObject(m58clone.getObject());
            this.f7018l.addOverlayObject(createId, marker, b6);
            return new Text(marker, m58clone);
        } catch (Throwable th) {
            b3.D(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final TileOverlay addTileOverlay(TileOverlayOptions tileOverlayOptions) throws RemoteException {
        try {
            TileProvider tileProvider = tileOverlayOptions.getTileProvider();
            if (tileProvider != null && (tileProvider instanceof HeatmapTileProvider)) {
                y2.c(this.Y);
            }
            String createId = this.f7018l.createId("TILEOVERLAY");
            TileOverlay tileOverlay = new TileOverlay(this.f7018l, tileOverlayOptions, createId);
            this.f7018l.addOverlayObject(createId, tileOverlay, tileOverlayOptions);
            return tileOverlay;
        } catch (Throwable th) {
            b3.D(th);
            return null;
        }
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAMapListener
    public final void afterAnimation() {
        redrawInfoWindow();
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAMapListener
    public final void afterDrawFrame(int i6, GLMapState gLMapState) {
        float mapZoomer = gLMapState.getMapZoomer();
        GLMapEngine gLMapEngine = this.Z;
        if (gLMapEngine == null || (!gLMapEngine.isInMapAction(i6) && !this.Z.isInMapAnimation(i6))) {
            int i7 = this.S;
            if (i7 != -1) {
                this.f6989a0.setRenderFps(i7);
            } else {
                this.f6989a0.setRenderFps(15.0f);
            }
            if (this.f7004f0 != mapZoomer) {
                this.f7004f0 = mapZoomer;
            }
        }
        if (!this.f7025o0) {
            this.f7025o0 = true;
        }
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAMapListener
    public final void afterDrawLabel(int i6, GLMapState gLMapState) {
        int i7;
        h0();
        com.autonavi.extra.b bVar = this.P0;
        if (bVar != null) {
            bVar.e();
        }
        GLMapEngine gLMapEngine = this.Z;
        if (gLMapEngine != null) {
            gLMapEngine.pushRendererState();
        }
        if (this.f7018l.draw(1, this.P, this.f7045y0)) {
            i7 = this.U0;
        } else {
            i7 = this.U0 + 1;
        }
        this.U0 = i7;
        GLMapEngine gLMapEngine2 = this.Z;
        if (gLMapEngine2 != null) {
            gLMapEngine2.popRendererState();
        }
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAMapListener
    public final void beforeDrawLabel(int i6, GLMapState gLMapState) {
        int i7;
        h0();
        GLMapEngine gLMapEngine = this.Z;
        if (gLMapEngine != null) {
            gLMapEngine.pushRendererState();
        }
        if (this.f7018l.draw(0, this.P, this.f7045y0)) {
            i7 = this.U0;
        } else {
            i7 = this.U0 + 1;
        }
        this.U0 = i7;
        GLMapEngine gLMapEngine2 = this.Z;
        if (gLMapEngine2 != null) {
            gLMapEngine2.popRendererState();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final boolean canShowIndoorSwitch() {
        com.amap.api.col.p0003l.z zVar;
        if (getZoomLevel() >= 17.0f && (zVar = this.f7034t) != null && zVar.f7782g != null) {
            FPoint obtain = FPoint.obtain();
            Point point = this.f7034t.f7782g;
            j(point.x, point.y, obtain);
            if (this.H.contains((int) ((PointF) obtain).x, (int) ((PointF) obtain).y)) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void getLatLng2Map(double d6, double d7, FPoint fPoint) {
        IPoint obtain = IPoint.obtain();
        latlon2Geo(d6, d7, obtain);
        geo2Map(((Point) obtain).x, ((Point) obtain).y, fPoint);
        obtain.recycle();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final List<Marker> getMapScreenMarkers() throws RemoteException {
        if (!b3.I(getMapWidth(), getMapHeight())) {
            return new ArrayList();
        }
        if (this.f7024o.get()) {
            return new ArrayList();
        }
        return this.f7018l.getMapScreenMarkers();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final float getScalePerPixel() throws RemoteException {
        try {
            return ((float) ((((Math.cos((getCameraPosition().target.latitude * 3.141592653589793d) / 180.0d) * 2.0d) * 3.141592653589793d) * 6378137.0d) / (Math.pow(2.0d, getZoomLevel()) * 256.0d))) * getMapZoomScale();
        } catch (Throwable th) {
            v5.p(th, "AMapDelegateImp", "getScalePerPixel");
            b3.D(th);
            th.printStackTrace();
            return 0.0f;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final float getZoomLevel() {
        return E();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final float getZoomToSpanLevel(LatLng latLng, LatLng latLng2) {
        try {
            MapConfig mapConfig = getMapConfig();
            if (latLng != null && latLng2 != null && this.f7019l0 && !this.f7024o.get()) {
                Pair<Float, IPoint> r5 = b3.r(mapConfig, 0, 0, 0, 0, new LatLngBounds.Builder().include(latLng).include(latLng2).build(), getMapWidth(), getMapHeight());
                if (r5 != null) {
                    return ((Float) r5.first).floatValue();
                }
                GLMapState gLMapState = new GLMapState(this.f7022n, this.Z.getNativeInstance());
                float mapZoomer = gLMapState.getMapZoomer();
                gLMapState.recycle();
                return mapZoomer;
            }
            return mapConfig.getSZ();
        } catch (Throwable th) {
            b3.D(th);
            return 0.0f;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final boolean isLockMapAngle(int i6) {
        return Y(i6);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void moveCamera(AbstractCameraUpdateMessage abstractCameraUpdateMessage) throws RemoteException {
        if (this.Z == null || this.f7024o.get()) {
            return;
        }
        try {
            if (this.f7026p && this.Z.getStateMessageCount() > 0) {
                AbstractCameraUpdateMessage o5 = com.amap.api.col.p0003l.p.o();
                o5.nowType = AbstractCameraUpdateMessage.Type.changeGeoCenterZoomTiltBearing;
                o5.geoPoint = new DPoint(this.f7028q.getSX(), this.f7028q.getSY());
                o5.zoom = this.f7028q.getSZ();
                o5.bearing = this.f7028q.getSR();
                o5.tilt = this.f7028q.getSC();
                this.Z.addMessage(abstractCameraUpdateMessage, false);
                while (this.Z.getStateMessageCount() > 0) {
                    AbstractCameraUpdateMessage stateMessage = this.Z.getStateMessage();
                    if (stateMessage != null) {
                        stateMessage.mergeCameraUpdateDelegate(o5);
                    }
                }
                abstractCameraUpdateMessage = o5;
            }
        } catch (Throwable th) {
            b3.D(th);
        }
        resetRenderTime();
        this.Z.clearAnimations(this.f7022n, false);
        abstractCameraUpdateMessage.isChangeFinished = true;
        o(abstractCameraUpdateMessage);
        this.Z.addMessage(abstractCameraUpdateMessage, false);
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAMapListener
    public final void onMapBlankClick(double d6, double d7) {
        e(d6, d7);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void onPause() {
        S();
        IGlOverlayLayer iGlOverlayLayer = this.f7018l;
        if (iGlOverlayLayer != null) {
            iGlOverlayLayer.setFlingState(false);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final boolean removeGLOverlay(String str) throws RemoteException {
        resetRenderTime();
        return this.f7018l.removeOverlay(str);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void renderSurface(GL10 gl10) {
        drawFrame(gl10);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setCustomMapStyleID(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.f7028q.getCustomStyleID())) {
            this.f7028q.setCustomStyleID(str);
            this.f7012i = true;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setCustomMapStylePath(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.f7028q.getCustomStylePath())) {
            this.f7028q.setCustomStylePath(str);
            this.f7012i = true;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setCustomTextureResourcePath(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f7028q.setCustomTextureResourcePath(str);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMapLanguage(String str) {
        MapConfig mapConfig;
        if (!TextUtils.isEmpty(str) && (mapConfig = this.f7028q) != null && !mapConfig.isCustomStyleEnable() && !this.f7028q.getMapLanguage().equals(str)) {
            if (!str.equals("en")) {
                this.f7028q.setMapLanguage("zh_cn");
                this.P = 0;
            } else {
                if (this.I != 1) {
                    try {
                        setMapType(1);
                    } catch (Throwable th) {
                        b3.D(th);
                        th.printStackTrace();
                    }
                }
                this.f7028q.setMapLanguage("en");
                this.P = -10000;
            }
            try {
                C(getCameraPosition());
            } catch (Throwable th2) {
                b3.D(th2);
                th2.printStackTrace();
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setInfoWindowAdapter(AMap.CommonInfoWindowAdapter commonInfoWindowAdapter) throws RemoteException {
        com.amap.api.col.p0003l.a0 a0Var;
        if (this.f7024o.get() || (a0Var = this.f6997d) == null) {
            return;
        }
        a0Var.h(commonInfoWindowAdapter);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void showInfoWindow(BaseOverlay baseOverlay) throws RemoteException {
        com.amap.api.col.p0003l.a0 a0Var;
        if (baseOverlay == null || (a0Var = this.f6997d) == null) {
            return;
        }
        try {
            a0Var.j(baseOverlay);
        } catch (RemoteException e6) {
            e6.printStackTrace();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static abstract class t0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        boolean f7120a;

        /* renamed from: b, reason: collision with root package name */
        boolean f7121b;

        /* renamed from: c, reason: collision with root package name */
        int f7122c;

        /* renamed from: d, reason: collision with root package name */
        int f7123d;

        /* renamed from: e, reason: collision with root package name */
        int f7124e;

        /* renamed from: f, reason: collision with root package name */
        int f7125f;

        /* renamed from: g, reason: collision with root package name */
        int f7126g;

        /* renamed from: h, reason: collision with root package name */
        byte[] f7127h;

        /* renamed from: i, reason: collision with root package name */
        MyTrafficStyle f7128i;

        private t0() {
            this.f7120a = false;
            this.f7121b = false;
            this.f7125f = 0;
            this.f7126g = 0;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f7120a = false;
        }

        /* synthetic */ t0(byte b6) {
            this();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void clear(boolean z5) throws RemoteException {
        String str;
        try {
            hideInfoWindow();
            String str2 = "";
            q1 q1Var = this.f7036u;
            if (q1Var != null) {
                if (z5) {
                    str = q1Var.p();
                    str2 = this.f7036u.q();
                    this.f7018l.clear(str, str2);
                    queueEvent(new l());
                    resetRenderTime();
                }
                q1Var.r();
            }
            str = null;
            this.f7018l.clear(str, str2);
            queueEvent(new l());
            resetRenderTime();
        } catch (Throwable th) {
            v5.p(th, "AMapDelegateImp", "clear");
            b3.D(th);
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public final void setCustomMapStyle(boolean z5, byte[] bArr) {
        r(z5, bArr, false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMapCustomEnable(boolean z5) {
        if (z5) {
            q0();
        }
        setMapCustomEnable(z5, false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void reloadMap() {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setZOrderOnTop(boolean z5) throws RemoteException {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void createSurface(GL10 gl10, EGLConfig eGLConfig) {
        try {
            this.X = Thread.currentThread().getId();
        } catch (Throwable th) {
            th.printStackTrace();
            b3.D(th);
        }
        try {
            createSurface(1, gl10, eGLConfig);
        } catch (Throwable th2) {
            th2.printStackTrace();
            b3.D(th2);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void changeSurface(GL10 gl10, int i6, int i7) {
        try {
            changeSurface(1, gl10, i6, i7);
        } catch (Throwable th) {
            th.printStackTrace();
            b3.D(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public final void setMaskLayerParams(int i6, int i7, int i8, int i9, int i10, long j6) {
    }
}
