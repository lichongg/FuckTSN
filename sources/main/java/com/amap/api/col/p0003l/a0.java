package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.amap.api.maps.AMap;
import com.amap.api.maps.InfoWindowParams;
import com.amap.api.maps.model.BaseOverlay;
import com.amap.api.maps.model.BasePointOverlay;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.autonavi.base.amap.api.mapcore.BaseOverlayImp;
import com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class a0 {

    /* renamed from: d, reason: collision with root package name */
    private View f5605d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f5606e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f5607f;

    /* renamed from: h, reason: collision with root package name */
    Context f5609h;

    /* renamed from: i, reason: collision with root package name */
    private IInfoWindowAction f5610i;

    /* renamed from: j, reason: collision with root package name */
    private IInfoWindowAction f5611j;

    /* renamed from: k, reason: collision with root package name */
    private BaseOverlay f5612k;

    /* renamed from: a, reason: collision with root package name */
    AMap.InfoWindowAdapter f5602a = null;

    /* renamed from: b, reason: collision with root package name */
    AMap.CommonInfoWindowAdapter f5603b = null;

    /* renamed from: c, reason: collision with root package name */
    private boolean f5604c = true;

    /* renamed from: g, reason: collision with root package name */
    private Drawable f5608g = null;

    /* renamed from: l, reason: collision with root package name */
    private AMap.InfoWindowAdapter f5613l = new a();

    /* renamed from: m, reason: collision with root package name */
    private AMap.CommonInfoWindowAdapter f5614m = new b();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a implements AMap.InfoWindowAdapter {
        @Override // com.amap.api.maps.AMap.InfoWindowAdapter
        public final View getInfoContents(Marker marker) {
            return null;
        }

        a() {
        }

        @Override // com.amap.api.maps.AMap.InfoWindowAdapter
        public final View getInfoWindow(Marker marker) {
            try {
                if (a0.this.f5608g == null) {
                    a0 a0Var = a0.this;
                    a0Var.f5608g = q2.c(a0Var.f5609h, "infowindow_bg.9.png");
                }
                if (a0.this.f5605d == null) {
                    a0.this.f5605d = new LinearLayout(a0.this.f5609h);
                    a0.this.f5605d.setBackground(a0.this.f5608g);
                    a0.this.f5606e = new TextView(a0.this.f5609h);
                    a0.this.f5606e.setText(marker.getTitle());
                    a0.this.f5606e.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                    a0.this.f5607f = new TextView(a0.this.f5609h);
                    a0.this.f5607f.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                    a0.this.f5607f.setText(marker.getSnippet());
                    ((LinearLayout) a0.this.f5605d).setOrientation(1);
                    ((LinearLayout) a0.this.f5605d).addView(a0.this.f5606e);
                    ((LinearLayout) a0.this.f5605d).addView(a0.this.f5607f);
                }
            } catch (Throwable th) {
                v5.p(th, "InfoWindowDelegate", "showInfoWindow decodeDrawableFromAsset");
                th.printStackTrace();
            }
            return a0.this.f5605d;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class b implements AMap.CommonInfoWindowAdapter {

        /* renamed from: a, reason: collision with root package name */
        private InfoWindowParams f5616a = null;

        b() {
        }

        @Override // com.amap.api.maps.AMap.CommonInfoWindowAdapter
        public final InfoWindowParams getInfoWindowParams(BasePointOverlay basePointOverlay) {
            try {
                if (this.f5616a == null) {
                    this.f5616a = new InfoWindowParams();
                    if (a0.this.f5608g == null) {
                        a0 a0Var = a0.this;
                        a0Var.f5608g = q2.c(a0Var.f5609h, "infowindow_bg.9.png");
                    }
                    a0.this.f5605d = new LinearLayout(a0.this.f5609h);
                    a0.this.f5605d.setBackground(a0.this.f5608g);
                    a0.this.f5606e = new TextView(a0.this.f5609h);
                    a0.this.f5606e.setText("标题");
                    a0.this.f5606e.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                    a0.this.f5607f = new TextView(a0.this.f5609h);
                    a0.this.f5607f.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                    a0.this.f5607f.setText("内容");
                    ((LinearLayout) a0.this.f5605d).setOrientation(1);
                    ((LinearLayout) a0.this.f5605d).addView(a0.this.f5606e);
                    ((LinearLayout) a0.this.f5605d).addView(a0.this.f5607f);
                    this.f5616a.setInfoWindowType(2);
                    this.f5616a.setInfoWindow(a0.this.f5605d);
                }
                return this.f5616a;
            } catch (Throwable th) {
                v5.p(th, "InfoWindowDelegate", "showInfoWindow decodeDrawableFromAsset");
                th.printStackTrace();
                return null;
            }
        }
    }

    private static boolean t(AMap.InfoWindowAdapter infoWindowAdapter) {
        if (infoWindowAdapter == null) {
            return true;
        }
        Marker marker = new Marker(null, new MarkerOptions(), "check");
        return infoWindowAdapter.getInfoWindow(marker) == null && infoWindowAdapter.getInfoContents(marker) == null;
    }

    private synchronized IInfoWindowAction y() {
        AMap.InfoWindowAdapter infoWindowAdapter = this.f5602a;
        if (infoWindowAdapter != null) {
            if (infoWindowAdapter instanceof AMap.ImageInfoWindowAdapter) {
                return this.f5611j;
            }
            if (infoWindowAdapter instanceof AMap.MultiPositionInfoWindowAdapter) {
                return this.f5611j;
            }
        }
        AMap.CommonInfoWindowAdapter commonInfoWindowAdapter = this.f5603b;
        if (commonInfoWindowAdapter == null || commonInfoWindowAdapter.getInfoWindowParams(null).getInfoWindowType() != 1) {
            return this.f5610i;
        }
        return this.f5611j;
    }

    public final synchronized void h(AMap.CommonInfoWindowAdapter commonInfoWindowAdapter) {
        try {
            this.f5603b = commonInfoWindowAdapter;
            this.f5602a = null;
            if (commonInfoWindowAdapter == null) {
                this.f5603b = this.f5614m;
                this.f5604c = true;
            } else {
                this.f5604c = false;
            }
            IInfoWindowAction iInfoWindowAction = this.f5611j;
            if (iInfoWindowAction != null) {
                iInfoWindowAction.hideInfoWindow();
            }
            IInfoWindowAction iInfoWindowAction2 = this.f5610i;
            if (iInfoWindowAction2 != null) {
                iInfoWindowAction2.hideInfoWindow();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void i(AMap.InfoWindowAdapter infoWindowAdapter) {
        try {
            this.f5602a = infoWindowAdapter;
            this.f5603b = null;
            if (t(infoWindowAdapter)) {
                this.f5602a = this.f5613l;
                this.f5604c = true;
            } else {
                this.f5604c = false;
            }
            IInfoWindowAction iInfoWindowAction = this.f5611j;
            if (iInfoWindowAction != null) {
                iInfoWindowAction.hideInfoWindow();
            }
            IInfoWindowAction iInfoWindowAction2 = this.f5610i;
            if (iInfoWindowAction2 != null) {
                iInfoWindowAction2.hideInfoWindow();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void l(IInfoWindowAction iInfoWindowAction) {
        synchronized (this) {
            try {
                this.f5610i = iInfoWindowAction;
                if (iInfoWindowAction != null) {
                    iInfoWindowAction.setInfoWindowAdapterManager(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized boolean n() {
        return this.f5604c;
    }

    public final void s(IInfoWindowAction iInfoWindowAction) {
        synchronized (this) {
            try {
                this.f5611j = iInfoWindowAction;
                if (iInfoWindowAction != null) {
                    iInfoWindowAction.setInfoWindowAdapterManager(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void g(View view, BasePointOverlay basePointOverlay) {
        if (view == null || basePointOverlay == null || basePointOverlay.getPosition() == null || !p2.g()) {
            return;
        }
        String Y = b3.Y(view);
        if (TextUtils.isEmpty(Y)) {
            return;
        }
        p2.a().c(basePointOverlay.getPosition(), Y, "");
    }

    public final View d(BasePointOverlay basePointOverlay) {
        InfoWindowParams infoWindowParams;
        AMap.InfoWindowAdapter infoWindowAdapter = this.f5602a;
        if (infoWindowAdapter != null) {
            View infoWindow = infoWindowAdapter.getInfoWindow((Marker) basePointOverlay);
            g(infoWindow, basePointOverlay);
            return infoWindow;
        }
        AMap.CommonInfoWindowAdapter commonInfoWindowAdapter = this.f5603b;
        if (commonInfoWindowAdapter != null && (infoWindowParams = commonInfoWindowAdapter.getInfoWindowParams(basePointOverlay)) != null) {
            View infoWindow2 = infoWindowParams.getInfoWindow();
            g(infoWindow2, basePointOverlay);
            return infoWindow2;
        }
        InfoWindowParams infoWindowParams2 = this.f5614m.getInfoWindowParams(basePointOverlay);
        if (infoWindowParams2 != null) {
            return infoWindowParams2.getInfoWindow();
        }
        return null;
    }

    public final void m(String str, String str2) {
        TextView textView = this.f5606e;
        if (textView != null) {
            textView.requestLayout();
            this.f5606e.setText(str);
        }
        TextView textView2 = this.f5607f;
        if (textView2 != null) {
            textView2.requestLayout();
            this.f5607f.setText(str2);
        }
        View view = this.f5605d;
        if (view != null) {
            view.requestLayout();
        }
    }

    public final View p(BasePointOverlay basePointOverlay) {
        InfoWindowParams infoWindowParams;
        AMap.InfoWindowAdapter infoWindowAdapter = this.f5602a;
        if (infoWindowAdapter != null) {
            View infoContents = infoWindowAdapter.getInfoContents((Marker) basePointOverlay);
            g(infoContents, basePointOverlay);
            return infoContents;
        }
        AMap.CommonInfoWindowAdapter commonInfoWindowAdapter = this.f5603b;
        if (commonInfoWindowAdapter != null && (infoWindowParams = commonInfoWindowAdapter.getInfoWindowParams(basePointOverlay)) != null) {
            View infoContents2 = infoWindowParams.getInfoContents();
            g(infoContents2, basePointOverlay);
            return infoContents2;
        }
        InfoWindowParams infoWindowParams2 = this.f5614m.getInfoWindowParams(basePointOverlay);
        if (infoWindowParams2 != null) {
            return infoWindowParams2.getInfoContents();
        }
        return null;
    }

    public final long u(BasePointOverlay basePointOverlay) {
        InfoWindowParams infoWindowParams;
        AMap.InfoWindowAdapter infoWindowAdapter = this.f5602a;
        if (infoWindowAdapter != null && (infoWindowAdapter instanceof AMap.ImageInfoWindowAdapter)) {
            return ((AMap.ImageInfoWindowAdapter) infoWindowAdapter).getInfoWindowUpdateTime();
        }
        AMap.CommonInfoWindowAdapter commonInfoWindowAdapter = this.f5603b;
        if (commonInfoWindowAdapter == null || (infoWindowParams = commonInfoWindowAdapter.getInfoWindowParams(basePointOverlay)) == null) {
            return 0L;
        }
        return infoWindowParams.getInfoWindowUpdateTime();
    }

    public a0(Context context) {
        this.f5609h = context;
    }

    public final BaseOverlay f(MotionEvent motionEvent) {
        IInfoWindowAction y5 = y();
        if (y5 != null && y5.onInfoWindowTap(motionEvent)) {
            return this.f5612k;
        }
        return null;
    }

    public final void j(BaseOverlay baseOverlay) throws RemoteException {
        IInfoWindowAction y5 = y();
        if (y5 != null && (baseOverlay instanceof BasePointOverlay)) {
            y5.showInfoWindow((BasePointOverlay) baseOverlay);
            this.f5612k = baseOverlay;
        }
    }

    public final void k(BaseOverlayImp baseOverlayImp) throws RemoteException {
        IInfoWindowAction y5 = y();
        if (y5 != null) {
            y5.showInfoWindow(baseOverlayImp);
        }
    }

    public final void r() {
        IInfoWindowAction y5 = y();
        if (y5 != null) {
            y5.redrawInfoWindow();
        }
    }

    public final void w() {
        IInfoWindowAction y5 = y();
        if (y5 != null) {
            y5.hideInfoWindow();
        }
    }
}
