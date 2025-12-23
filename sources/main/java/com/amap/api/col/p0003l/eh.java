package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.amap.api.col.p0003l.ef;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.BasePointOverlay;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.ae.gmap.listener.AMapWidgetListener;
import com.autonavi.base.amap.api.mapcore.BaseOverlayImp;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IGLSurfaceView;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.MapConfig;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class eh extends ViewGroup implements i3 {

    /* renamed from: a, reason: collision with root package name */
    private IAMapDelegate f6081a;

    /* renamed from: b, reason: collision with root package name */
    private IGlOverlayLayer f6082b;

    /* renamed from: c, reason: collision with root package name */
    private Context f6083c;

    /* renamed from: d, reason: collision with root package name */
    private el f6084d;

    /* renamed from: e, reason: collision with root package name */
    private eg f6085e;

    /* renamed from: f, reason: collision with root package name */
    private ee f6086f;

    /* renamed from: g, reason: collision with root package name */
    private ek f6087g;

    /* renamed from: h, reason: collision with root package name */
    private ed f6088h;

    /* renamed from: i, reason: collision with root package name */
    private ef f6089i;

    /* renamed from: j, reason: collision with root package name */
    private k3 f6090j;

    /* renamed from: k, reason: collision with root package name */
    private View f6091k;

    /* renamed from: l, reason: collision with root package name */
    private BasePointOverlay f6092l;

    /* renamed from: m, reason: collision with root package name */
    private Drawable f6093m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f6094n;

    /* renamed from: o, reason: collision with root package name */
    private View f6095o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f6096p;

    /* renamed from: q, reason: collision with root package name */
    j3 f6097q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f6098r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f6099s;

    /* renamed from: t, reason: collision with root package name */
    a0 f6100t;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a implements AMapWidgetListener {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.amap.api.col.3l.eh$a$a, reason: collision with other inner class name */
        final class RunnableC0091a implements Runnable {
            RunnableC0091a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                eh.this.f6087g.e();
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        final class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                eh.this.f6086f.c();
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        final class c implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ float f6104a;

            c(float f6) {
                this.f6104a = f6;
            }

            @Override // java.lang.Runnable
            public final void run() {
                eh.this.f6090j.c(this.f6104a);
            }
        }

        a() {
        }

        @Override // com.autonavi.base.ae.gmap.listener.AMapWidgetListener
        public final void invalidateCompassView() {
            if (eh.this.f6086f == null) {
                return;
            }
            eh.this.f6086f.post(new b());
        }

        @Override // com.autonavi.base.ae.gmap.listener.AMapWidgetListener
        public final void invalidateScaleView() {
            if (eh.this.f6087g == null) {
                return;
            }
            eh.this.f6087g.post(new RunnableC0091a());
        }

        @Override // com.autonavi.base.ae.gmap.listener.AMapWidgetListener
        public final void invalidateZoomController(float f6) {
            if (eh.this.f6090j == null) {
                return;
            }
            eh.this.f6090j.post(new c(f6));
        }

        @Override // com.autonavi.base.ae.gmap.listener.AMapWidgetListener
        public final void setFrontViewVisibility(boolean z5) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (eh.this.f6091k != null) {
                eh.this.f6091k.clearFocus();
                eh ehVar = eh.this;
                ehVar.removeView(ehVar.f6091k);
                b3.C(eh.this.f6091k.getBackground());
                b3.C(eh.this.f6093m);
                eh.F(eh.this);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class c extends ViewGroup.LayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public FPoint f6107a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f6108b;

        /* renamed from: c, reason: collision with root package name */
        public int f6109c;

        /* renamed from: d, reason: collision with root package name */
        public int f6110d;

        /* renamed from: e, reason: collision with root package name */
        public int f6111e;

        public c(FPoint fPoint, int i6) {
            this(-2, -2, ((PointF) fPoint).x, ((PointF) fPoint).y, 0, 0, i6);
        }

        public c(int i6, int i7, float f6, float f7, int i8, int i9, int i10) {
            super(i6, i7);
            FPoint fPoint = new FPoint();
            this.f6107a = fPoint;
            this.f6108b = false;
            ((PointF) fPoint).x = f6;
            ((PointF) fPoint).y = f7;
            this.f6109c = i8;
            this.f6110d = i9;
            this.f6111e = i10;
        }
    }

    private void A(View view, c cVar) {
        int[] iArr = new int[2];
        y(view, ((ViewGroup.LayoutParams) cVar).width, ((ViewGroup.LayoutParams) cVar).height, iArr);
        if (view instanceof k3) {
            x(view, iArr[0], iArr[1], getWidth() - iArr[0], getHeight(), cVar.f6111e);
            return;
        }
        if (view instanceof eg) {
            x(view, iArr[0], iArr[1], getWidth() - iArr[0], iArr[1], cVar.f6111e);
            return;
        }
        if (view instanceof ee) {
            x(view, iArr[0], iArr[1], 0, 0, cVar.f6111e);
            return;
        }
        if (cVar.f6107a != null) {
            IPoint obtain = IPoint.obtain();
            MapConfig mapConfig = this.f6081a.getMapConfig();
            GLMapState mapProjection = this.f6081a.getMapProjection();
            if (mapConfig != null && mapProjection != null) {
                FPoint fPoint = cVar.f6107a;
                ((Point) obtain).x = (int) ((PointF) fPoint).x;
                ((Point) obtain).y = (int) ((PointF) fPoint).y;
            }
            int i6 = ((Point) obtain).x + cVar.f6109c;
            ((Point) obtain).x = i6;
            int i7 = ((Point) obtain).y + cVar.f6110d;
            ((Point) obtain).y = i7;
            x(view, iArr[0], iArr[1], i6, i7, cVar.f6111e);
            obtain.recycle();
        }
    }

    static /* synthetic */ View F(eh ehVar) {
        ehVar.f6091k = null;
        return null;
    }

    private void z(View view, ViewGroup.LayoutParams layoutParams) {
        int[] iArr = new int[2];
        y(view, layoutParams.width, layoutParams.height, iArr);
        if (view instanceof ef) {
            x(view, iArr[0], iArr[1], 20, (this.f6081a.getWaterMarkerPositon().y - 80) - iArr[1], 51);
        } else {
            x(view, iArr[0], iArr[1], 0, 0, 51);
        }
    }

    @Override // com.amap.api.col.p0003l.i3
    public final float a(int i6) {
        if (this.f6084d == null) {
            return 0.0f;
        }
        G();
        return this.f6084d.o(i6);
    }

    @Override // com.amap.api.col.p0003l.i3
    public final void b(Boolean bool) {
        k3 k3Var = this.f6090j;
        if (k3Var == null) {
            this.f6097q.b(this, bool);
        } else {
            k3Var.e(bool.booleanValue());
        }
    }

    @Override // com.amap.api.col.p0003l.i3
    public final void c(Boolean bool) {
        ef efVar = this.f6089i;
        if (efVar == null) {
            this.f6097q.b(this, bool);
        } else if (efVar != null && bool.booleanValue() && this.f6081a.canShowIndoorSwitch()) {
            this.f6089i.j(true);
        }
    }

    @Override // com.amap.api.col.p0003l.i3
    public final void d(Integer num) {
        el elVar = this.f6084d;
        if (elVar == null) {
            this.f6097q.b(this, num);
        } else if (elVar != null) {
            elVar.i(num.intValue());
            G();
        }
    }

    @Override // com.amap.api.col.p0003l.i3
    public final void e(Boolean bool) {
        ee eeVar = this.f6086f;
        if (eeVar == null) {
            this.f6097q.b(this, bool);
        } else {
            eeVar.b(bool.booleanValue());
        }
    }

    @Override // com.amap.api.col.p0003l.i3
    public final void f(Integer num) {
        el elVar = this.f6084d;
        if (elVar == null) {
            this.f6097q.b(this, num);
        } else if (elVar != null) {
            elVar.m(num.intValue());
            G();
        }
    }

    @Override // com.amap.api.col.p0003l.i3
    public final void g(Boolean bool) {
        if (this.f6085e == null) {
            this.f6097q.b(this, bool);
        } else if (bool.booleanValue()) {
            this.f6085e.setVisibility(0);
        } else {
            this.f6085e.setVisibility(8);
        }
    }

    @Override // com.amap.api.col.p0003l.i3
    public final void h(Integer num) {
        k3 k3Var = this.f6090j;
        if (k3Var == null) {
            this.f6097q.b(this, num);
        } else if (k3Var != null) {
            k3Var.d(num.intValue());
        }
    }

    @Override // com.amap.api.col.p0003l.i3
    public final void i(Boolean bool) {
        el elVar = this.f6084d;
        if (elVar == null) {
            this.f6097q.b(this, bool);
        } else {
            elVar.setVisibility(bool.booleanValue() ? 0 : 8);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final boolean isInfoWindowShown() {
        return false;
    }

    @Override // com.amap.api.col.p0003l.i3
    public final View j() {
        return this;
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final void showInfoWindow(BasePointOverlay basePointOverlay) {
        if (basePointOverlay == null) {
            return;
        }
        try {
            a0 a0Var = this.f6100t;
            if ((a0Var == null || !a0Var.n() || basePointOverlay.getTitle() != null || basePointOverlay.getSnippet() != null) && basePointOverlay.isInfoWindowEnable()) {
                BasePointOverlay basePointOverlay2 = this.f6092l;
                if (basePointOverlay2 != null && !basePointOverlay2.getId().equals(basePointOverlay.getId())) {
                    hideInfoWindow();
                }
                if (this.f6100t != null) {
                    this.f6092l = basePointOverlay;
                    this.f6096p = true;
                    this.f6082b.getNativeProperties(basePointOverlay.getId(), "setInfoWindowShown", new Object[]{Boolean.TRUE});
                }
            }
        } catch (Throwable unused) {
        }
    }

    private void G() {
        ek ekVar = this.f6087g;
        if (ekVar == null) {
            this.f6097q.b(this, new Object[0]);
        } else {
            if (ekVar == null || ekVar.getVisibility() != 0) {
                return;
            }
            this.f6087g.postInvalidate();
        }
    }

    private void H() {
        k3 k3Var = this.f6090j;
        if (k3Var != null) {
            k3Var.b();
        }
        ek ekVar = this.f6087g;
        if (ekVar != null) {
            ekVar.a();
        }
        el elVar = this.f6084d;
        if (elVar != null) {
            elVar.b();
        }
        eg egVar = this.f6085e;
        if (egVar != null) {
            egVar.a();
        }
        ee eeVar = this.f6086f;
        if (eeVar != null) {
            eeVar.a();
        }
        ef efVar = this.f6089i;
        if (efVar != null) {
            efVar.e();
        }
    }

    private View t(BasePointOverlay basePointOverlay) throws RemoteException {
        View view;
        View view2;
        View view3 = null;
        if (basePointOverlay instanceof Marker) {
            try {
                if (this.f6093m == null) {
                    this.f6093m = q2.c(this.f6083c, "infowindow_bg.9.png");
                }
            } catch (Throwable th) {
                v5.p(th, "MapOverlayViewGroup", "showInfoWindow decodeDrawableFromAsset");
                th.printStackTrace();
            }
            try {
                if (this.f6096p) {
                    view = this.f6100t.d(basePointOverlay);
                    if (view == null) {
                        try {
                            view = this.f6100t.p(basePointOverlay);
                        } catch (Throwable th2) {
                            th = th2;
                            view3 = view;
                            v5.p(th, "MapOverlayViewGroup", "getInfoWindow or getInfoContents");
                            th.printStackTrace();
                            return view3;
                        }
                    }
                    this.f6095o = view;
                    this.f6096p = false;
                } else {
                    view = this.f6095o;
                }
                if (view != null) {
                    view3 = view;
                } else {
                    if (!this.f6100t.n()) {
                        return null;
                    }
                    view3 = this.f6100t.d(basePointOverlay);
                }
                if (view3 != null && view3.getBackground() == null) {
                    view3.setBackground(this.f6093m);
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } else {
            try {
                if (this.f6093m == null) {
                    this.f6093m = q2.c(this.f6083c, "infowindow_bg.9.png");
                }
            } catch (Throwable th4) {
                v5.p(th4, "MapOverlayViewGroup", "showInfoWindow decodeDrawableFromAsset");
                th4.printStackTrace();
            }
            try {
                if (this.f6096p) {
                    view2 = this.f6100t.d(basePointOverlay);
                    if (view2 == null) {
                        try {
                            view2 = this.f6100t.p(basePointOverlay);
                        } catch (Throwable th5) {
                            th = th5;
                            view3 = view2;
                            v5.p(th, "MapOverlayViewGroup", "getInfoWindow or getInfoContents");
                            th.printStackTrace();
                            return view3;
                        }
                    }
                    this.f6095o = view2;
                    this.f6096p = false;
                } else {
                    view2 = this.f6095o;
                }
                if (view2 != null) {
                    view3 = view2;
                } else {
                    if (!this.f6100t.n()) {
                        return null;
                    }
                    view3 = this.f6100t.d(basePointOverlay);
                }
                if (view3.getBackground() == null) {
                    view3.setBackground(this.f6093m);
                }
                return view3;
            } catch (Throwable th6) {
                th = th6;
            }
        }
        return view3;
    }

    private void v(Context context) {
        el elVar = new el(context);
        this.f6084d = elVar;
        elVar.n(this.f6099s);
        this.f6087g = new ek(context, this.f6081a);
        this.f6089i = new ef(context);
        this.f6090j = new k3(context, this.f6081a);
        this.f6085e = new eg(context, this.f6081a);
        this.f6086f = new ee(context, this.f6081a);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        addView(this.f6084d, layoutParams);
        addView(this.f6087g, layoutParams);
        addView(this.f6089i, new ViewGroup.LayoutParams(-2, -2));
        addView(this.f6090j, new c(new FPoint(0.0f, 0.0f), 83));
        addView(this.f6085e, new c(FPoint.obtain(0.0f, 0.0f), 83));
        addView(this.f6086f, new c(FPoint.obtain(0.0f, 0.0f), 51));
        this.f6086f.setVisibility(8);
        this.f6081a.setMapWidgetListener(new a());
        try {
            if (this.f6081a.getUiSettings().isMyLocationButtonEnabled()) {
                return;
            }
            this.f6085e.setVisibility(8);
        } catch (Throwable th) {
            v5.p(th, "AMapDelegateImpGLSurfaceView", "locationView gone");
            th.printStackTrace();
        }
    }

    private void w(View view, int i6, int i7, int i8, int i9) throws RemoteException {
        int i10;
        int i11;
        if (view == null) {
            return;
        }
        View view2 = this.f6091k;
        if (view2 != null) {
            if (view == view2) {
                return;
            }
            view2.clearFocus();
            removeView(this.f6091k);
        }
        this.f6091k = view;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        this.f6091k.setDrawingCacheEnabled(true);
        this.f6091k.setDrawingCacheQuality(0);
        if (layoutParams != null) {
            int i12 = layoutParams.width;
            i11 = layoutParams.height;
            i10 = i12;
        } else {
            i10 = -2;
            i11 = -2;
        }
        addView(this.f6091k, new c(i10, i11, i6, i7, i8, i9, 81));
    }

    private void x(View view, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        int i12 = i10 & 7;
        int i13 = i10 & 112;
        if (i12 == 5) {
            i8 -= i6;
        } else if (i12 == 1) {
            i8 -= i6 / 2;
        }
        if (i13 == 80) {
            i9 -= i7;
        } else {
            if (i13 == 17) {
                i11 = i7 / 2;
            } else if (i13 == 16) {
                i9 /= 2;
                i11 = i7 / 2;
            }
            i9 -= i11;
        }
        view.layout(i8, i9, i8 + i6, i9 + i7);
        if (view instanceof IGLSurfaceView) {
            this.f6081a.changeSize(i6, i7);
        }
    }

    private void y(View view, int i6, int i7, int[] iArr) {
        View view2;
        if ((view instanceof ListView) && (view2 = (View) view.getParent()) != null) {
            iArr[0] = view2.getWidth();
            iArr[1] = view2.getHeight();
        }
        if (i6 <= 0 || i7 <= 0) {
            view.measure(0, 0);
        }
        if (i6 == -2) {
            iArr[0] = view.getMeasuredWidth();
        } else if (i6 == -1) {
            iArr[0] = getMeasuredWidth();
        } else {
            iArr[0] = i6;
        }
        if (i7 == -2) {
            iArr[1] = view.getMeasuredHeight();
        } else if (i7 == -1) {
            iArr[1] = getMeasuredHeight();
        } else {
            iArr[1] = i7;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final void hideInfoWindow() {
        try {
            IAMapDelegate iAMapDelegate = this.f6081a;
            if (iAMapDelegate == null || iAMapDelegate.getMainHandler() == null) {
                return;
            }
            this.f6081a.getMainHandler().post(new b());
            BasePointOverlay basePointOverlay = this.f6092l;
            if (basePointOverlay != null) {
                this.f6082b.getNativeProperties(basePointOverlay.getId(), "setInfoWindowShown", new Object[]{Boolean.FALSE});
            }
            this.f6092l = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.col.p0003l.i3
    public final void j(ef.d dVar) {
        ef efVar = this.f6089i;
        if (efVar == null) {
            this.f6097q.b(this, dVar);
        } else {
            efVar.h(dVar);
        }
    }

    @Override // com.amap.api.col.p0003l.i3
    public final void k(Integer num) {
        el elVar = this.f6084d;
        if (elVar == null) {
            this.f6097q.b(this, num);
        } else if (elVar != null) {
            elVar.c(num.intValue());
            this.f6084d.postInvalidate();
            G();
        }
    }

    @Override // com.amap.api.col.p0003l.i3
    public final void l(Boolean bool) {
        ek ekVar = this.f6087g;
        if (ekVar == null) {
            this.f6097q.b(this, bool);
        } else {
            ekVar.d(bool.booleanValue());
        }
    }

    @Override // com.amap.api.col.p0003l.i3
    public final void m(Canvas canvas) {
        Bitmap drawingCache;
        View view = this.f6091k;
        if (view == null || this.f6092l == null || (drawingCache = view.getDrawingCache(true)) == null) {
            return;
        }
        canvas.drawBitmap(drawingCache, this.f6091k.getLeft(), this.f6091k.getTop(), new Paint());
    }

    @Override // com.amap.api.col.p0003l.i3
    public final void n(Boolean bool) {
        ef efVar = this.f6089i;
        if (efVar == null) {
            this.f6097q.b(this, bool);
        } else {
            efVar.j(bool.booleanValue());
        }
    }

    @Override // com.amap.api.col.p0003l.i3
    public final void o(Boolean bool) {
        el elVar = this.f6084d;
        if (elVar == null) {
            this.f6097q.b(this, bool);
            return;
        }
        if (elVar != null && bool.booleanValue()) {
            this.f6084d.f(true);
            return;
        }
        el elVar2 = this.f6084d;
        if (elVar2 != null) {
            elVar2.f(false);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final boolean onInfoWindowTap(MotionEvent motionEvent) {
        return (this.f6091k == null || this.f6092l == null || !b3.J(new Rect(this.f6091k.getLeft(), this.f6091k.getTop(), this.f6091k.getRight(), this.f6091k.getBottom()), (int) motionEvent.getX(), (int) motionEvent.getY())) ? false : true;
    }

    @Override // com.amap.api.col.p0003l.i3
    public final void p(Boolean bool) {
        eg egVar = this.f6085e;
        if (egVar == null) {
            this.f6097q.b(this, bool);
        } else {
            egVar.b(bool.booleanValue());
        }
    }

    @Override // com.amap.api.col.p0003l.i3
    public final void q(String str, Boolean bool, Integer num) {
        if (this.f6084d == null) {
            this.f6097q.b(this, str, bool, num);
            return;
        }
        if (num.intValue() == 2) {
            this.f6084d.j(bool.booleanValue());
        } else {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f6084d.e(str, num.intValue());
            this.f6084d.p(bool.booleanValue());
        }
    }

    @Override // com.amap.api.col.p0003l.i3
    public final void r(Float f6) {
        k3 k3Var = this.f6090j;
        if (k3Var == null) {
            this.f6097q.b(this, f6);
        } else if (k3Var != null) {
            k3Var.c(f6.floatValue());
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final void redrawInfoWindow() {
        try {
            BasePointOverlay basePointOverlay = this.f6092l;
            try {
                if (basePointOverlay == null || !this.f6082b.checkInBounds(basePointOverlay.getId())) {
                    View view = this.f6091k;
                    if (view == null || view.getVisibility() != 0) {
                        return;
                    }
                    this.f6091k.setVisibility(8);
                    return;
                }
                if (this.f6094n) {
                    FPoint obtain = FPoint.obtain();
                    this.f6082b.getMarkerInfoWindowOffset(this.f6092l.getId(), obtain);
                    int i6 = (int) ((PointF) obtain).x;
                    int i7 = (int) (((PointF) obtain).y + 2.0f);
                    obtain.recycle();
                    View t5 = t(this.f6092l);
                    if (t5 != null) {
                        FPoint obtain2 = FPoint.obtain();
                        this.f6082b.getOverlayScreenPos(this.f6092l.getId(), obtain2);
                        w(t5, (int) ((PointF) obtain2).x, (int) ((PointF) obtain2).y, i6, i7);
                        View view2 = this.f6091k;
                        if (view2 != null) {
                            c cVar = (c) view2.getLayoutParams();
                            if (cVar != null) {
                                cVar.f6107a = FPoint.obtain(((PointF) obtain2).x, ((PointF) obtain2).y);
                                cVar.f6109c = i6;
                                cVar.f6110d = i7;
                            }
                            try {
                                onLayout(false, 0, 0, 0, 0);
                                if (this.f6100t.n()) {
                                    this.f6100t.m(this.f6092l.getTitle(), this.f6092l.getSnippet());
                                }
                                if (this.f6091k.getVisibility() == 8) {
                                    this.f6091k.setVisibility(0);
                                }
                            } catch (Throwable th) {
                                th = th;
                                v5.p(th, "MapOverlayViewGroup", "redrawInfoWindow");
                                b3.D(th);
                                return;
                            }
                        }
                        obtain2.recycle();
                        return;
                    }
                    View view3 = this.f6091k;
                    if (view3 != null && view3.getVisibility() == 0) {
                        hideInfoWindow();
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    @Override // com.amap.api.col.p0003l.i3
    public final void s(CameraPosition cameraPosition) {
        if (this.f6084d == null) {
            this.f6097q.b(this, cameraPosition);
            return;
        }
        if (this.f6081a.getUiSettings().isLogoEnable()) {
            if (MapsInitializer.isLoadWorldGridMap() && cameraPosition.zoom >= 6.0f) {
                LatLng latLng = cameraPosition.target;
                if (!u2.a(latLng.latitude, latLng.longitude)) {
                    this.f6084d.setVisibility(8);
                    return;
                }
            }
            if (this.f6081a.getMaskLayerType() == -1) {
                this.f6084d.setVisibility(0);
            }
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final void setInfoWindowAdapterManager(a0 a0Var) {
        this.f6100t = a0Var;
    }

    public eh(Context context, IAMapDelegate iAMapDelegate, IGlOverlayLayer iGlOverlayLayer) {
        super(context);
        this.f6093m = null;
        int i6 = 1;
        this.f6094n = true;
        this.f6098r = true;
        this.f6099s = true;
        try {
            this.f6082b = iGlOverlayLayer;
            this.f6081a = iAMapDelegate;
            this.f6083c = context;
            this.f6097q = new j3();
            this.f6088h = new ed(context);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (this.f6081a.getGLMapView() != null) {
                addView(this.f6081a.getGLMapView(), 0, layoutParams);
            } else {
                i6 = 0;
            }
            addView(this.f6088h, i6, layoutParams);
            if (!this.f6098r) {
                v(context);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            b3.D(th);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        try {
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = getChildAt(i10);
                if (childAt != null) {
                    if (childAt.getLayoutParams() instanceof c) {
                        A(childAt, (c) childAt.getLayoutParams());
                    } else {
                        z(childAt, childAt.getLayoutParams());
                    }
                }
            }
            el elVar = this.f6084d;
            if (elVar != null) {
                elVar.l();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.col.p0003l.i3
    public final void a(Integer num, Float f6) {
        el elVar = this.f6084d;
        if (elVar == null) {
            this.f6097q.b(this, num, f6);
        } else if (elVar != null) {
            elVar.d(num.intValue(), f6.floatValue());
            G();
        }
    }

    @Override // com.amap.api.col.p0003l.i3
    public final boolean b() {
        el elVar = this.f6084d;
        if (elVar != null) {
            return elVar.q();
        }
        return false;
    }

    @Override // com.amap.api.col.p0003l.i3
    public final ef e() {
        return this.f6089i;
    }

    @Override // com.amap.api.col.p0003l.i3
    public final void h() {
        ee eeVar = this.f6086f;
        if (eeVar == null) {
            this.f6097q.b(this, new Object[0]);
        } else {
            eeVar.c();
        }
    }

    @Override // com.amap.api.col.p0003l.i3
    public final void i() {
        Context context;
        if (!this.f6098r || (context = this.f6083c) == null) {
            return;
        }
        v(context);
        j3 j3Var = this.f6097q;
        if (j3Var != null) {
            j3Var.a();
        }
    }

    @Override // com.amap.api.col.p0003l.i3
    public final ed d() {
        return this.f6088h;
    }

    @Override // com.amap.api.col.p0003l.i3
    public final el f() {
        return this.f6084d;
    }

    @Override // com.amap.api.col.p0003l.i3
    public final void c() {
        el elVar = this.f6084d;
        if (elVar == null) {
            this.f6097q.b(this, new Object[0]);
        } else if (elVar != null) {
            elVar.l();
        }
    }

    @Override // com.amap.api.col.p0003l.i3
    public final void g() {
        hideInfoWindow();
        b3.C(this.f6093m);
        H();
        removeAllViews();
        this.f6095o = null;
    }

    @Override // com.amap.api.col.p0003l.i3
    public final Point a() {
        el elVar = this.f6084d;
        if (elVar == null) {
            return null;
        }
        return elVar.h();
    }

    @Override // com.amap.api.col.p0003l.i3
    public final void a(boolean z5) {
        el elVar = this.f6084d;
        if (elVar != null) {
            elVar.n(z5);
        }
        this.f6099s = z5;
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public final void showInfoWindow(BaseOverlayImp baseOverlayImp) {
        if (baseOverlayImp == null) {
            return;
        }
        try {
            a0 a0Var = this.f6100t;
            if ((a0Var == null || !a0Var.n() || baseOverlayImp.getTitle() != null || baseOverlayImp.getSnippet() != null) && baseOverlayImp.isInfoWindowEnable()) {
                BasePointOverlay basePointOverlay = this.f6092l;
                if (basePointOverlay != null && !basePointOverlay.getId().equals(baseOverlayImp.getId())) {
                    hideInfoWindow();
                }
                if (this.f6100t != null) {
                    baseOverlayImp.setInfoWindowShown(true);
                    this.f6096p = true;
                }
            }
        } catch (Throwable unused) {
        }
    }
}
