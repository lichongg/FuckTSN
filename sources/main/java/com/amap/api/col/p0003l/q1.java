package com.amap.api.col.p0003l;

import android.animation.Animator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.location.Location;
import android.os.RemoteException;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MyLocationStyle;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class q1 {

    /* renamed from: a, reason: collision with root package name */
    private IAMapDelegate f6949a;

    /* renamed from: b, reason: collision with root package name */
    private Marker f6950b;

    /* renamed from: c, reason: collision with root package name */
    private Circle f6951c;

    /* renamed from: e, reason: collision with root package name */
    private LatLng f6953e;

    /* renamed from: f, reason: collision with root package name */
    private double f6954f;

    /* renamed from: g, reason: collision with root package name */
    private Context f6955g;

    /* renamed from: h, reason: collision with root package name */
    private g f6956h;

    /* renamed from: q, reason: collision with root package name */
    ValueAnimator f6965q;

    /* renamed from: d, reason: collision with root package name */
    private MyLocationStyle f6952d = new MyLocationStyle();

    /* renamed from: i, reason: collision with root package name */
    private int f6957i = 4;

    /* renamed from: j, reason: collision with root package name */
    private boolean f6958j = false;

    /* renamed from: k, reason: collision with root package name */
    private boolean f6959k = false;

    /* renamed from: l, reason: collision with root package name */
    private boolean f6960l = false;

    /* renamed from: m, reason: collision with root package name */
    private boolean f6961m = false;

    /* renamed from: n, reason: collision with root package name */
    private boolean f6962n = false;

    /* renamed from: o, reason: collision with root package name */
    private boolean f6963o = false;

    /* renamed from: p, reason: collision with root package name */
    c f6964p = null;

    /* renamed from: r, reason: collision with root package name */
    Animator.AnimatorListener f6966r = new a();

    /* renamed from: s, reason: collision with root package name */
    ValueAnimator.AnimatorUpdateListener f6967s = new b();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a implements Animator.AnimatorListener {
        a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            q1.this.w();
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            try {
                if (q1.this.f6951c != null) {
                    LatLng latLng = (LatLng) valueAnimator.getAnimatedValue();
                    q1.this.f6951c.setCenter(latLng);
                    q1.this.f6950b.setPosition(latLng);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class c implements TypeEvaluator {
        @Override // android.animation.TypeEvaluator
        public final Object evaluate(float f6, Object obj, Object obj2) {
            LatLng latLng = (LatLng) obj;
            LatLng latLng2 = (LatLng) obj2;
            double d6 = latLng.latitude;
            double d7 = f6;
            double d8 = d6 + ((latLng2.latitude - d6) * d7);
            double d9 = latLng.longitude;
            return new LatLng(d8, d9 + (d7 * (latLng2.longitude - d9)));
        }
    }

    private void c(int i6) {
        d(i6, false);
    }

    private void t() {
        l(0.0f);
    }

    public final void r() {
        this.f6951c = null;
        this.f6950b = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
    
        if (r4 != 7) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void d(int r4, boolean r5) {
        /*
            r3 = this;
            r3.f6957i = r4
            r0 = 0
            r3.f6958j = r0
            r3.f6960l = r0
            r3.f6959k = r0
            r3.f6962n = r0
            r3.f6963o = r0
            r1 = 1
            if (r4 == r1) goto L36
            r2 = 2
            if (r4 == r2) goto L31
            r2 = 3
            if (r4 == r2) goto L2c
            r2 = 4
            if (r4 == r2) goto L25
            r2 = 5
            if (r4 == r2) goto L20
            r2 = 7
            if (r4 == r2) goto L2e
            goto L3c
        L20:
            r3.f6962n = r1
            r3.f6961m = r0
            goto L3c
        L25:
            r3.f6959k = r1
            r3.f6962n = r1
            r3.f6961m = r0
            goto L3c
        L2c:
            r3.f6959k = r1
        L2e:
            r3.f6963o = r1
            goto L3c
        L31:
            r3.f6959k = r1
            r3.f6961m = r1
            goto L3c
        L36:
            r3.f6959k = r1
            r3.f6960l = r1
            r3.f6961m = r1
        L3c:
            boolean r4 = r3.f6962n
            if (r4 != 0) goto L56
            boolean r4 = r3.f6963o
            if (r4 == 0) goto L45
            goto L56
        L45:
            com.amap.api.maps.model.Marker r4 = r3.f6950b
            if (r4 == 0) goto L4c
            r4.setFlat(r0)
        L4c:
            r3.u()
            r3.t()
            r3.s()
            return
        L56:
            boolean r4 = r3.f6963o
            if (r4 == 0) goto L77
            com.amap.api.col.3l.g r4 = r3.f6956h
            r4.f(r1)
            if (r5 != 0) goto L71
            com.autonavi.base.amap.api.mapcore.IAMapDelegate r4 = r3.f6949a     // Catch: java.lang.Throwable -> L6d
            r5 = 1099431936(0x41880000, float:17.0)
            com.autonavi.amap.mapcore.AbstractCameraUpdateMessage r5 = com.amap.api.col.p0003l.p.b(r5)     // Catch: java.lang.Throwable -> L6d
            r4.moveCamera(r5)     // Catch: java.lang.Throwable -> L6d
            goto L71
        L6d:
            r4 = move-exception
            r4.printStackTrace()
        L71:
            r4 = 1110704128(0x42340000, float:45.0)
            r3.l(r4)
            goto L7c
        L77:
            com.amap.api.col.3l.g r4 = r3.f6956h
            r4.f(r0)
        L7c:
            com.amap.api.col.3l.g r4 = r3.f6956h
            r4.d()
            com.amap.api.maps.model.Marker r4 = r3.f6950b
            if (r4 == 0) goto L88
            r4.setFlat(r1)
        L88:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.q1.d(int, boolean):void");
    }

    private void g(LatLng latLng) {
        LatLng position = this.f6950b.getPosition();
        if (position == null) {
            position = new LatLng(0.0d, 0.0d);
        }
        if (this.f6964p == null) {
            this.f6964p = new c();
        }
        ValueAnimator valueAnimator = this.f6965q;
        if (valueAnimator == null) {
            ValueAnimator ofObject = ValueAnimator.ofObject(new c(), position, latLng);
            this.f6965q = ofObject;
            ofObject.addListener(this.f6966r);
            this.f6965q.addUpdateListener(this.f6967s);
        } else {
            valueAnimator.setObjectValues(position, latLng);
            this.f6965q.setEvaluator(this.f6964p);
        }
        if (position.latitude == 0.0d && position.longitude == 0.0d) {
            this.f6965q.setDuration(1L);
        } else {
            this.f6965q.setDuration(1000L);
        }
        this.f6965q.start();
    }

    private void i(boolean z5) {
        Circle circle = this.f6951c;
        if (circle != null && circle.isVisible() != z5) {
            this.f6951c.setVisible(z5);
        }
        Marker marker = this.f6950b;
        if (marker == null || marker.isVisible() == z5) {
            return;
        }
        this.f6950b.setVisible(z5);
    }

    private void l(float f6) {
        IAMapDelegate iAMapDelegate = this.f6949a;
        if (iAMapDelegate == null) {
            return;
        }
        try {
            iAMapDelegate.moveCamera(p.p(f6));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void o(float f6) {
        if (this.f6961m) {
            float f7 = f6 % 360.0f;
            if (f7 > 180.0f) {
                f7 -= 360.0f;
            } else if (f7 < -180.0f) {
                f7 += 360.0f;
            }
            Marker marker = this.f6950b;
            if (marker != null) {
                marker.setRotateAngle(-f7);
            }
        }
    }

    private void s() {
        this.f6956h.h();
    }

    private void v() {
        IAMapDelegate iAMapDelegate = this.f6949a;
        if (iAMapDelegate == null) {
            return;
        }
        try {
            iAMapDelegate.moveCamera(p.q(0.0f));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        if (this.f6953e != null && this.f6959k) {
            if (this.f6960l && this.f6958j) {
                return;
            }
            this.f6958j = true;
            try {
                IPoint obtain = IPoint.obtain();
                LatLng latLng = this.f6953e;
                GLMapState.lonlat2Geo(latLng.longitude, latLng.latitude, obtain);
                this.f6949a.animateCamera(p.e(obtain));
            } catch (Throwable th) {
                v5.p(th, "MyLocationOverlay", "moveMapToLocation");
                th.printStackTrace();
            }
        }
    }

    private void x() {
        MyLocationStyle myLocationStyle = this.f6952d;
        if (myLocationStyle == null) {
            MyLocationStyle myLocationStyle2 = new MyLocationStyle();
            this.f6952d = myLocationStyle2;
            myLocationStyle2.myLocationIcon(BitmapDescriptorFactory.fromAsset("location_map_gps_locked.png"));
        } else if (myLocationStyle.getMyLocationIcon() == null || this.f6952d.getMyLocationIcon().getBitmap() == null) {
            this.f6952d.myLocationIcon(BitmapDescriptorFactory.fromAsset("location_map_gps_locked.png"));
        }
        z();
    }

    private void y() {
        Circle circle = this.f6951c;
        if (circle != null) {
            try {
                this.f6949a.removeGLOverlay(circle.getId());
            } catch (Throwable th) {
                v5.p(th, "MyLocationOverlay", "locationIconRemove");
                th.printStackTrace();
            }
            this.f6951c = null;
        }
        Marker marker = this.f6950b;
        if (marker != null) {
            marker.remove();
            this.f6950b = null;
            this.f6956h.e(null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0119 A[Catch: all -> 0x0018, TryCatch #0 {all -> 0x0018, blocks: (B:2:0x0000, B:4:0x0004, B:5:0x001b, B:7:0x0020, B:9:0x002e, B:10:0x0039, B:12:0x0047, B:13:0x0052, B:15:0x0060, B:16:0x006b, B:18:0x006f, B:19:0x0074, B:20:0x0080, B:22:0x0085, B:23:0x0096, B:25:0x009a, B:27:0x00a8, B:29:0x00c9, B:31:0x00d1, B:34:0x00de, B:36:0x00e6, B:38:0x00fe, B:39:0x0115, B:41:0x0119, B:42:0x010a, B:43:0x00b8, B:44:0x0123), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void z() {
        /*
            Method dump skipped, instructions count: 313
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.q1.z():void");
    }

    public final MyLocationStyle a() {
        return this.f6952d;
    }

    public final void b(float f6) {
        Marker marker = this.f6950b;
        if (marker != null) {
            marker.setRotateAngle(f6);
        }
    }

    public final void e(Location location) {
        if (location == null) {
            return;
        }
        i(this.f6952d.isMyLocationShowing());
        if (this.f6952d.isMyLocationShowing()) {
            this.f6953e = new LatLng(location.getLatitude(), location.getLongitude());
            this.f6954f = location.getAccuracy();
            if (this.f6950b == null && this.f6951c == null) {
                x();
            }
            Circle circle = this.f6951c;
            if (circle != null) {
                try {
                    double d6 = this.f6954f;
                    if (d6 != -1.0d) {
                        circle.setRadius(d6);
                    }
                } catch (Throwable th) {
                    v5.p(th, "MyLocationOverlay", "setCentAndRadius");
                    th.printStackTrace();
                }
            }
            o(location.getBearing());
            if (this.f6953e.equals(this.f6950b.getPosition())) {
                w();
            } else {
                g(this.f6953e);
            }
        }
    }

    public final void h(MyLocationStyle myLocationStyle) {
        try {
            this.f6952d = myLocationStyle;
            i(myLocationStyle.isMyLocationShowing());
            if (!this.f6952d.isMyLocationShowing()) {
                this.f6956h.f(false);
                this.f6957i = this.f6952d.getMyLocationType();
                return;
            }
            x();
            Marker marker = this.f6950b;
            if (marker == null && this.f6951c == null) {
                return;
            }
            this.f6956h.e(marker);
            c(this.f6952d.getMyLocationType());
        } catch (Throwable th) {
            v5.p(th, "MyLocationOverlay", "setMyLocationStyle");
            th.printStackTrace();
        }
    }

    public final void k() {
        g gVar;
        if (this.f6957i != 3 || (gVar = this.f6956h) == null) {
            return;
        }
        gVar.d();
    }

    public final String p() {
        Marker marker = this.f6950b;
        if (marker != null) {
            return marker.getId();
        }
        return null;
    }

    public final String q() throws RemoteException {
        Circle circle = this.f6951c;
        if (circle != null) {
            return circle.getId();
        }
        return null;
    }

    public q1(IAMapDelegate iAMapDelegate, Context context) {
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f6955g = origApplicationContext;
        this.f6949a = iAMapDelegate;
        this.f6956h = new g(origApplicationContext, iAMapDelegate);
        d(4, true);
    }

    private void u() {
        v();
    }

    public final void n() throws RemoteException {
        y();
        if (this.f6956h != null) {
            s();
            this.f6956h = null;
        }
    }
}
