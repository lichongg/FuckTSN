package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.amap.api.col.p0003l.t;
import com.amap.api.col.p0003l.u;
import com.amap.api.col.p0003l.w;
import com.amap.api.col.p0003l.x;
import com.amap.api.maps.model.AMapGestureListener;
import com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.message.HoverGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.MoveGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.RotateGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.ScaleGestureMapMessage;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class ia {

    /* renamed from: a, reason: collision with root package name */
    IAMapDelegate f6535a;

    /* renamed from: b, reason: collision with root package name */
    Context f6536b;

    /* renamed from: c, reason: collision with root package name */
    GestureDetector f6537c;

    /* renamed from: d, reason: collision with root package name */
    private w f6538d;

    /* renamed from: e, reason: collision with root package name */
    private u f6539e;

    /* renamed from: f, reason: collision with root package name */
    private t f6540f;

    /* renamed from: g, reason: collision with root package name */
    private x f6541g;

    /* renamed from: q, reason: collision with root package name */
    private int f6551q;

    /* renamed from: r, reason: collision with root package name */
    private int f6552r;

    /* renamed from: s, reason: collision with root package name */
    public AMapGestureListener f6553s;

    /* renamed from: h, reason: collision with root package name */
    private boolean f6542h = false;

    /* renamed from: i, reason: collision with root package name */
    private int f6543i = 0;

    /* renamed from: j, reason: collision with root package name */
    private int f6544j = 0;

    /* renamed from: k, reason: collision with root package name */
    private int f6545k = 0;

    /* renamed from: l, reason: collision with root package name */
    private int f6546l = 0;

    /* renamed from: m, reason: collision with root package name */
    private int f6547m = 0;

    /* renamed from: n, reason: collision with root package name */
    private boolean f6548n = false;

    /* renamed from: o, reason: collision with root package name */
    private boolean f6549o = false;

    /* renamed from: p, reason: collision with root package name */
    private boolean f6550p = true;

    /* renamed from: t, reason: collision with root package name */
    private Handler f6554t = new Handler(Looper.getMainLooper());

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class a implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener {

        /* renamed from: a, reason: collision with root package name */
        private int f6555a;

        /* renamed from: b, reason: collision with root package name */
        float f6556b;

        /* renamed from: c, reason: collision with root package name */
        private EAMapPlatformGestureInfo f6557c;

        /* renamed from: d, reason: collision with root package name */
        long f6558d;

        private a() {
            this.f6555a = 0;
            this.f6556b = 0.0f;
            this.f6557c = new EAMapPlatformGestureInfo();
            this.f6558d = 0L;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTap(MotionEvent motionEvent) {
            ia.this.f6537c.setIsLongpressEnabled(false);
            this.f6555a = motionEvent.getPointerCount();
            AMapGestureListener aMapGestureListener = ia.this.f6553s;
            if (aMapGestureListener != null) {
                aMapGestureListener.onDoubleTap(motionEvent.getX(), motionEvent.getY());
            }
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTapEvent(MotionEvent motionEvent) {
            if (this.f6555a < motionEvent.getPointerCount()) {
                this.f6555a = motionEvent.getPointerCount();
            }
            int action = motionEvent.getAction() & 255;
            if (this.f6555a != 1) {
                return false;
            }
            try {
                if (!ia.this.f6535a.getUiSettings().isZoomGesturesEnabled()) {
                    ia.this.f6537c.setIsLongpressEnabled(true);
                    return false;
                }
            } catch (Throwable th) {
                v5.p(th, "GLMapGestrureDetector", "onDoubleTapEvent");
                th.printStackTrace();
            }
            if (action == 0) {
                EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f6557c;
                eAMapPlatformGestureInfo.mGestureState = 1;
                eAMapPlatformGestureInfo.mGestureType = 9;
                eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                int engineIDWithGestureInfo = ia.this.f6535a.getEngineIDWithGestureInfo(this.f6557c);
                this.f6556b = motionEvent.getY();
                ia.this.f6535a.addGestureMapMessage(engineIDWithGestureInfo, ScaleGestureMapMessage.obtain(100, 1.0f, 0, 0));
                this.f6558d = SystemClock.uptimeMillis();
            } else if (action == 2) {
                ia.this.f6548n = true;
                float y5 = this.f6556b - motionEvent.getY();
                if (Math.abs(y5) >= 20.0f) {
                    EAMapPlatformGestureInfo eAMapPlatformGestureInfo2 = this.f6557c;
                    eAMapPlatformGestureInfo2.mGestureState = 2;
                    eAMapPlatformGestureInfo2.mGestureType = 9;
                    eAMapPlatformGestureInfo2.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                    ia.this.f6535a.addGestureMapMessage(ia.this.f6535a.getEngineIDWithGestureInfo(this.f6557c), ScaleGestureMapMessage.obtain(101, (y5 * 4.0f) / ia.this.f6535a.getMapHeight(), 0, 0));
                    this.f6556b = motionEvent.getY();
                }
            } else {
                EAMapPlatformGestureInfo eAMapPlatformGestureInfo3 = this.f6557c;
                eAMapPlatformGestureInfo3.mGestureState = 3;
                eAMapPlatformGestureInfo3.mGestureType = 9;
                eAMapPlatformGestureInfo3.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                int engineIDWithGestureInfo2 = ia.this.f6535a.getEngineIDWithGestureInfo(this.f6557c);
                ia.this.f6537c.setIsLongpressEnabled(true);
                ia.this.f6535a.addGestureMapMessage(engineIDWithGestureInfo2, ScaleGestureMapMessage.obtain(102, 1.0f, 0, 0));
                if (action == 1) {
                    ia.this.f6535a.setGestureStatus(engineIDWithGestureInfo2, 3);
                    long uptimeMillis = SystemClock.uptimeMillis() - this.f6558d;
                    if (!ia.this.f6548n || uptimeMillis < 200) {
                        return ia.this.f6535a.onDoubleTap(engineIDWithGestureInfo2, motionEvent);
                    }
                    ia.this.f6548n = false;
                } else {
                    ia.this.f6548n = false;
                }
            }
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public final boolean onDown(MotionEvent motionEvent) {
            ia.this.f6548n = false;
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f6, float f7) {
            AMapGestureListener aMapGestureListener = ia.this.f6553s;
            if (aMapGestureListener != null) {
                aMapGestureListener.onFling(f6, f7);
            }
            try {
                if (ia.this.f6535a.getUiSettings().isScrollGesturesEnabled() && ia.this.f6546l <= 0 && ia.this.f6544j <= 0 && ia.this.f6545k == 0 && !ia.this.f6550p) {
                    EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f6557c;
                    eAMapPlatformGestureInfo.mGestureState = 3;
                    eAMapPlatformGestureInfo.mGestureType = 3;
                    eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent2.getX(), motionEvent2.getY()};
                    int engineIDWithGestureInfo = ia.this.f6535a.getEngineIDWithGestureInfo(this.f6557c);
                    ia.this.f6535a.onFling();
                    ia.this.f6535a.getGLMapEngine().startMapSlidAnim(engineIDWithGestureInfo, new Point((int) motionEvent2.getX(), (int) motionEvent2.getY()), f6, f7);
                }
                return true;
            } catch (Throwable th) {
                v5.p(th, "GLMapGestrureDetector", "onFling");
                th.printStackTrace();
                return true;
            }
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent motionEvent) {
            if (ia.this.f6547m == 1) {
                EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f6557c;
                eAMapPlatformGestureInfo.mGestureState = 3;
                eAMapPlatformGestureInfo.mGestureType = 7;
                eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                ia.this.f6535a.onLongPress(ia.this.f6535a.getEngineIDWithGestureInfo(this.f6557c), motionEvent);
                AMapGestureListener aMapGestureListener = ia.this.f6553s;
                if (aMapGestureListener != null) {
                    aMapGestureListener.onLongPress(motionEvent.getX(), motionEvent.getY());
                }
            }
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f6, float f7) {
            AMapGestureListener aMapGestureListener = ia.this.f6553s;
            if (aMapGestureListener == null) {
                return false;
            }
            aMapGestureListener.onScroll(f6, f7);
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public final void onShowPress(MotionEvent motionEvent) {
            try {
                EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f6557c;
                eAMapPlatformGestureInfo.mGestureState = 3;
                eAMapPlatformGestureInfo.mGestureType = 7;
                eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                ia.this.f6535a.getGLMapEngine().clearAnimations(ia.this.f6535a.getEngineIDWithGestureInfo(this.f6557c), false);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (ia.this.f6547m != 1) {
                return false;
            }
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f6557c;
            eAMapPlatformGestureInfo.mGestureState = 3;
            eAMapPlatformGestureInfo.mGestureType = 8;
            eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
            int engineIDWithGestureInfo = ia.this.f6535a.getEngineIDWithGestureInfo(this.f6557c);
            AMapGestureListener aMapGestureListener = ia.this.f6553s;
            if (aMapGestureListener != null) {
                try {
                    aMapGestureListener.onSingleTap(motionEvent.getX(), motionEvent.getY());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            return ia.this.f6535a.onSingleTapConfirmed(engineIDWithGestureInfo, motionEvent);
        }

        /* synthetic */ a(ia iaVar, byte b6) {
            this();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class b implements t.a {

        /* renamed from: a, reason: collision with root package name */
        private EAMapPlatformGestureInfo f6560a;

        private b() {
            this.f6560a = new EAMapPlatformGestureInfo();
        }

        @Override // com.amap.api.col.3l.t.a
        public final void a(t tVar) {
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f6560a;
            eAMapPlatformGestureInfo.mGestureState = 3;
            eAMapPlatformGestureInfo.mGestureType = 6;
            eAMapPlatformGestureInfo.mLocation = new float[]{tVar.i().getX(), tVar.i().getY()};
            try {
                if (ia.this.f6535a.getUiSettings().isTiltGesturesEnabled()) {
                    int engineIDWithGestureInfo = ia.this.f6535a.getEngineIDWithGestureInfo(this.f6560a);
                    if (ia.this.f6535a.isLockMapCameraDegree(engineIDWithGestureInfo)) {
                        return;
                    }
                    if (ia.this.f6535a.getCameraDegree(engineIDWithGestureInfo) >= 0.0f && ia.this.f6546l > 0) {
                        ia.this.f6535a.setGestureStatus(engineIDWithGestureInfo, 7);
                    }
                    ia.this.f6542h = false;
                    IAMapDelegate iAMapDelegate = ia.this.f6535a;
                    iAMapDelegate.addGestureMapMessage(engineIDWithGestureInfo, HoverGestureMapMessage.obtain(102, iAMapDelegate.getCameraDegree(engineIDWithGestureInfo)));
                }
            } catch (Throwable th) {
                v5.p(th, "GLMapGestrureDetector", "onHoveEnd");
                th.printStackTrace();
            }
        }

        @Override // com.amap.api.col.3l.t.a
        public final boolean b(t tVar) {
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f6560a;
            eAMapPlatformGestureInfo.mGestureState = 2;
            eAMapPlatformGestureInfo.mGestureType = 6;
            eAMapPlatformGestureInfo.mLocation = new float[]{tVar.i().getX(), tVar.i().getY()};
            try {
                if (!ia.this.f6535a.getUiSettings().isTiltGesturesEnabled()) {
                    return true;
                }
                int engineIDWithGestureInfo = ia.this.f6535a.getEngineIDWithGestureInfo(this.f6560a);
                if (ia.this.f6535a.isLockMapCameraDegree(engineIDWithGestureInfo) || ia.this.f6545k > 3) {
                    return false;
                }
                float f6 = tVar.n().x;
                float f7 = tVar.n().y;
                if (!ia.this.f6542h) {
                    PointF k6 = tVar.k(0);
                    PointF k7 = tVar.k(1);
                    float f8 = k6.y;
                    if (((f8 > 10.0f && k7.y > 10.0f) || (f8 < -10.0f && k7.y < -10.0f)) && Math.abs(f7) > 10.0f && Math.abs(f6) < 10.0f) {
                        ia.this.f6542h = true;
                    }
                }
                if (ia.this.f6542h) {
                    ia.this.f6542h = true;
                    float f9 = f7 / 6.0f;
                    if (Math.abs(f9) > 1.0f) {
                        ia.this.f6535a.addGestureMapMessage(engineIDWithGestureInfo, HoverGestureMapMessage.obtain(101, f9));
                        ia.u(ia.this);
                    }
                }
                return true;
            } catch (Throwable th) {
                v5.p(th, "GLMapGestrureDetector", "onHove");
                th.printStackTrace();
                return true;
            }
        }

        @Override // com.amap.api.col.3l.t.a
        public final boolean c(t tVar) {
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f6560a;
            eAMapPlatformGestureInfo.mGestureState = 1;
            eAMapPlatformGestureInfo.mGestureType = 6;
            eAMapPlatformGestureInfo.mLocation = new float[]{tVar.i().getX(), tVar.i().getY()};
            try {
                if (!ia.this.f6535a.getUiSettings().isTiltGesturesEnabled()) {
                    return true;
                }
                int engineIDWithGestureInfo = ia.this.f6535a.getEngineIDWithGestureInfo(this.f6560a);
                if (ia.this.f6535a.isLockMapCameraDegree(engineIDWithGestureInfo)) {
                    return false;
                }
                IAMapDelegate iAMapDelegate = ia.this.f6535a;
                iAMapDelegate.addGestureMapMessage(engineIDWithGestureInfo, HoverGestureMapMessage.obtain(100, iAMapDelegate.getCameraDegree(engineIDWithGestureInfo)));
                return true;
            } catch (Throwable th) {
                v5.p(th, "GLMapGestrureDetector", "onHoveBegin");
                th.printStackTrace();
                return true;
            }
        }

        /* synthetic */ b(ia iaVar, byte b6) {
            this();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class c implements u.a {

        /* renamed from: a, reason: collision with root package name */
        private EAMapPlatformGestureInfo f6562a;

        private c() {
            this.f6562a = new EAMapPlatformGestureInfo();
        }

        @Override // com.amap.api.col.3l.u.a
        public final boolean a(u uVar) {
            try {
                if (!ia.this.f6535a.getUiSettings().isScrollGesturesEnabled()) {
                    return true;
                }
                EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f6562a;
                eAMapPlatformGestureInfo.mGestureState = 1;
                eAMapPlatformGestureInfo.mGestureType = 3;
                eAMapPlatformGestureInfo.mLocation = new float[]{uVar.i().getX(), uVar.i().getY()};
                ia.this.f6535a.addGestureMapMessage(ia.this.f6535a.getEngineIDWithGestureInfo(this.f6562a), MoveGestureMapMessage.obtain(100, 0.0f, 0.0f, uVar.i().getX(), uVar.i().getY()));
                return true;
            } catch (Throwable th) {
                v5.p(th, "GLMapGestrureDetector", "onMoveBegin");
                th.printStackTrace();
                return true;
            }
        }

        @Override // com.amap.api.col.3l.u.a
        public final void b(u uVar) {
            try {
                if (ia.this.f6535a.getUiSettings().isScrollGesturesEnabled()) {
                    EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f6562a;
                    eAMapPlatformGestureInfo.mGestureState = 3;
                    eAMapPlatformGestureInfo.mGestureType = 3;
                    eAMapPlatformGestureInfo.mLocation = new float[]{uVar.i().getX(), uVar.i().getY()};
                    int engineIDWithGestureInfo = ia.this.f6535a.getEngineIDWithGestureInfo(this.f6562a);
                    if (ia.this.f6543i > 0) {
                        ia.this.f6535a.setGestureStatus(engineIDWithGestureInfo, 5);
                    }
                    ia.this.f6535a.addGestureMapMessage(engineIDWithGestureInfo, MoveGestureMapMessage.obtain(102, 0.0f, 0.0f, uVar.i().getX(), uVar.i().getY()));
                }
            } catch (Throwable th) {
                v5.p(th, "GLMapGestrureDetector", "onMoveEnd");
                th.printStackTrace();
            }
        }

        @Override // com.amap.api.col.3l.u.a
        public final boolean c(u uVar) {
            if (ia.this.f6542h) {
                return true;
            }
            try {
                if (ia.this.f6535a.getUiSettings().isScrollGesturesEnabled()) {
                    if (!ia.this.f6549o) {
                        EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f6562a;
                        eAMapPlatformGestureInfo.mGestureState = 2;
                        eAMapPlatformGestureInfo.mGestureType = 3;
                        eAMapPlatformGestureInfo.mLocation = new float[]{uVar.i().getX(), uVar.i().getY()};
                        int engineIDWithGestureInfo = ia.this.f6535a.getEngineIDWithGestureInfo(this.f6562a);
                        PointF j6 = uVar.j();
                        float f6 = ia.this.f6543i == 0 ? 4.0f : 1.0f;
                        if (Math.abs(j6.x) <= f6 && Math.abs(j6.y) <= f6) {
                            return false;
                        }
                        if (ia.this.f6543i == 0) {
                            ia.this.f6535a.getGLMapEngine().clearAnimations(engineIDWithGestureInfo, false);
                        }
                        ia.this.f6535a.addGestureMapMessage(engineIDWithGestureInfo, MoveGestureMapMessage.obtain(101, j6.x, j6.y, uVar.i().getX(), uVar.i().getY()));
                        ia.t(ia.this);
                        return true;
                    }
                }
                return true;
            } catch (Throwable th) {
                v5.p(th, "GLMapGestrureDetector", "onMove");
                th.printStackTrace();
                return true;
            }
        }

        /* synthetic */ c(ia iaVar, byte b6) {
            this();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class d extends w.a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f6564a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f6565b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f6566c;

        /* renamed from: d, reason: collision with root package name */
        private Point f6567d;

        /* renamed from: e, reason: collision with root package name */
        private float[] f6568e;

        /* renamed from: f, reason: collision with root package name */
        private float f6569f;

        /* renamed from: g, reason: collision with root package name */
        private float[] f6570g;

        /* renamed from: h, reason: collision with root package name */
        private float f6571h;

        /* renamed from: i, reason: collision with root package name */
        private EAMapPlatformGestureInfo f6572i;

        private d() {
            this.f6564a = false;
            this.f6565b = false;
            this.f6566c = false;
            this.f6567d = new Point();
            this.f6568e = new float[10];
            this.f6569f = 0.0f;
            this.f6570g = new float[10];
            this.f6571h = 0.0f;
            this.f6572i = new EAMapPlatformGestureInfo();
        }

        /* JADX WARN: Code restructure failed: missing block: B:82:0x00c5, code lost:
        
            if (java.lang.Math.abs(r0) < 0.02f) goto L28;
         */
        /* JADX WARN: Removed duplicated region for block: B:31:0x012a A[Catch: all -> 0x014d, TryCatch #3 {all -> 0x014d, blocks: (B:29:0x011c, B:31:0x012a, B:33:0x0134, B:35:0x0138, B:37:0x0142, B:39:0x014a, B:40:0x0150, B:42:0x0154, B:48:0x016f, B:58:0x0166), top: B:28:0x011c }] */
        @Override // com.amap.api.col.3l.w.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean d(com.amap.api.col.p0003l.w r19) {
            /*
                Method dump skipped, instructions count: 423
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.3l.ia.d.d(com.amap.api.col.3l.w):boolean");
        }

        @Override // com.amap.api.col.3l.w.a
        public final boolean e(w wVar) {
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f6572i;
            eAMapPlatformGestureInfo.mGestureState = 1;
            eAMapPlatformGestureInfo.mGestureType = 4;
            eAMapPlatformGestureInfo.mLocation = new float[]{wVar.c().getX(), wVar.c().getY()};
            int engineIDWithGestureInfo = ia.this.f6535a.getEngineIDWithGestureInfo(this.f6572i);
            int f6 = (int) wVar.f();
            int i6 = (int) wVar.i();
            this.f6566c = false;
            Point point = this.f6567d;
            point.x = f6;
            point.y = i6;
            this.f6564a = false;
            this.f6565b = false;
            ia.this.f6535a.addGestureMapMessage(engineIDWithGestureInfo, ScaleGestureMapMessage.obtain(100, 1.0f, f6, i6));
            try {
                if (ia.this.f6535a.getUiSettings().isRotateGesturesEnabled() && !ia.this.f6535a.isLockMapAngle(engineIDWithGestureInfo)) {
                    IAMapDelegate iAMapDelegate = ia.this.f6535a;
                    iAMapDelegate.addGestureMapMessage(engineIDWithGestureInfo, RotateGestureMapMessage.obtain(100, iAMapDelegate.getMapAngle(engineIDWithGestureInfo), f6, i6));
                }
            } catch (Throwable th) {
                v5.p(th, "GLMapGestrureDetector", "onScaleRotateBegin");
                th.printStackTrace();
            }
            return true;
        }

        @Override // com.amap.api.col.3l.w.a
        public final void f(w wVar) {
            float f6;
            float f7;
            float f8;
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f6572i;
            eAMapPlatformGestureInfo.mGestureState = 3;
            eAMapPlatformGestureInfo.mGestureType = 4;
            eAMapPlatformGestureInfo.mLocation = new float[]{wVar.c().getX(), wVar.c().getY()};
            int engineIDWithGestureInfo = ia.this.f6535a.getEngineIDWithGestureInfo(this.f6572i);
            this.f6566c = false;
            ia.this.f6535a.addGestureMapMessage(engineIDWithGestureInfo, ScaleGestureMapMessage.obtain(102, 1.0f, 0, 0));
            if (ia.this.f6544j > 0) {
                int i6 = ia.this.f6544j > 10 ? 10 : ia.this.f6544j;
                float f9 = 0.0f;
                for (int i7 = 0; i7 < 10; i7++) {
                    float[] fArr = this.f6568e;
                    f9 += fArr[i7];
                    fArr[i7] = 0.0f;
                }
                float f10 = f9 / i6;
                if (0.004f <= f10) {
                    float f11 = f10 * 300.0f;
                    if (f11 >= 1.5f) {
                        f11 = 1.5f;
                    }
                    if (this.f6569f < 0.0f) {
                        f11 = -f11;
                    }
                    f8 = ia.this.f6535a.getPreciseLevel(engineIDWithGestureInfo) + f11;
                } else {
                    f8 = -9999.0f;
                }
                this.f6569f = 0.0f;
                f6 = f8;
            } else {
                f6 = -9999.0f;
            }
            if (ia.this.f6535a.isLockMapAngle(engineIDWithGestureInfo)) {
                f7 = -9999.0f;
            } else {
                try {
                    if (ia.this.f6535a.getUiSettings().isRotateGesturesEnabled()) {
                        IAMapDelegate iAMapDelegate = ia.this.f6535a;
                        iAMapDelegate.addGestureMapMessage(engineIDWithGestureInfo, RotateGestureMapMessage.obtain(102, iAMapDelegate.getMapAngle(engineIDWithGestureInfo), 0, 0));
                    }
                } catch (Throwable th) {
                    v5.p(th, "GLMapGestrureDetector", "onScaleRotateEnd");
                    th.printStackTrace();
                }
                if (ia.this.f6545k > 0) {
                    ia.this.f6535a.setGestureStatus(engineIDWithGestureInfo, 6);
                    int i8 = ia.this.f6545k > 10 ? 10 : ia.this.f6545k;
                    float f12 = 0.0f;
                    for (int i9 = 0; i9 < 10; i9++) {
                        float[] fArr2 = this.f6570g;
                        f12 += fArr2[i9];
                        fArr2[i9] = 0.0f;
                    }
                    float f13 = f12 / i8;
                    if (0.1f <= f13) {
                        float f14 = f13 * 200.0f;
                        int mapAngle = ((int) ia.this.f6535a.getMapAngle(engineIDWithGestureInfo)) % 360;
                        if (f14 >= 60.0f) {
                            f14 = 60.0f;
                        }
                        if (this.f6571h < 0.0f) {
                            f14 = -f14;
                        }
                        f7 = ((int) (mapAngle + f14)) % 360;
                        this.f6569f = 0.0f;
                    }
                }
                f7 = -9999.0f;
                this.f6569f = 0.0f;
            }
            if (f6 == -9999.0f && f7 == -9999.0f) {
                return;
            }
            ia.this.f6535a.getGLMapEngine().startPivotZoomRotateAnim(engineIDWithGestureInfo, this.f6567d, f6, (int) f7, 500);
        }

        /* synthetic */ d(ia iaVar, byte b6) {
            this();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class e extends x.b {

        /* renamed from: a, reason: collision with root package name */
        EAMapPlatformGestureInfo f6574a;

        private e() {
            this.f6574a = new EAMapPlatformGestureInfo();
        }

        @Override // com.amap.api.col.3l.x.b, com.amap.api.col.3l.x.a
        public final void a(x xVar) {
            try {
                if (ia.this.f6535a.getUiSettings().isZoomGesturesEnabled() && Math.abs(xVar.n()) <= 10.0f && Math.abs(xVar.o()) <= 10.0f && xVar.f() < 200) {
                    ia.v(ia.this);
                    EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f6574a;
                    eAMapPlatformGestureInfo.mGestureState = 2;
                    eAMapPlatformGestureInfo.mGestureType = 2;
                    eAMapPlatformGestureInfo.mLocation = new float[]{xVar.i().getX(), xVar.i().getY()};
                    int engineIDWithGestureInfo = ia.this.f6535a.getEngineIDWithGestureInfo(this.f6574a);
                    ia.this.f6535a.setGestureStatus(engineIDWithGestureInfo, 4);
                    ia.this.f6535a.zoomOut(engineIDWithGestureInfo);
                }
            } catch (Throwable th) {
                v5.p(th, "GLMapGestrureDetector", "onZoomOut");
                th.printStackTrace();
            }
        }

        /* synthetic */ e(ia iaVar, byte b6) {
            this();
        }
    }

    static /* synthetic */ boolean v(ia iaVar) {
        iaVar.f6550p = true;
        return true;
    }

    public final void b() {
        this.f6543i = 0;
        this.f6545k = 0;
        this.f6544j = 0;
        this.f6546l = 0;
        this.f6547m = 0;
    }

    static /* synthetic */ int o(ia iaVar) {
        int i6 = iaVar.f6544j;
        iaVar.f6544j = i6 + 1;
        return i6;
    }

    static /* synthetic */ int p(ia iaVar) {
        int i6 = iaVar.f6545k;
        iaVar.f6545k = i6 + 1;
        return i6;
    }

    static /* synthetic */ int t(ia iaVar) {
        int i6 = iaVar.f6543i;
        iaVar.f6543i = i6 + 1;
        return i6;
    }

    static /* synthetic */ int u(ia iaVar) {
        int i6 = iaVar.f6546l;
        iaVar.f6546l = i6 + 1;
        return i6;
    }

    public final void c(int i6, int i7) {
        this.f6551q = i6;
        this.f6552r = i7;
        w wVar = this.f6538d;
        if (wVar != null) {
            wVar.d(i6, i7);
        }
        u uVar = this.f6539e;
        if (uVar != null) {
            uVar.b(i6, i7);
        }
        t tVar = this.f6540f;
        if (tVar != null) {
            tVar.b(i6, i7);
        }
        x xVar = this.f6541g;
        if (xVar != null) {
            xVar.b(i6, i7);
        }
    }

    public final void d(AMapGestureListener aMapGestureListener) {
        this.f6553s = aMapGestureListener;
    }

    public final boolean e(MotionEvent motionEvent) {
        if (this.f6547m < motionEvent.getPointerCount()) {
            this.f6547m = motionEvent.getPointerCount();
        }
        if ((motionEvent.getAction() & 255) == 0) {
            this.f6549o = false;
            this.f6550p = false;
        }
        if (motionEvent.getAction() == 6 && motionEvent.getPointerCount() > 0) {
            this.f6549o = true;
        }
        if (this.f6548n && this.f6547m >= 2) {
            this.f6548n = false;
        }
        try {
            int[] iArr = {0, 0};
            IAMapDelegate iAMapDelegate = this.f6535a;
            if (iAMapDelegate != null && iAMapDelegate.getGLMapView() != null) {
                this.f6535a.getGLMapView().getLocationOnScreen(iArr);
            }
            if (this.f6553s != null) {
                if (motionEvent.getAction() == 0) {
                    this.f6553s.onDown(motionEvent.getX(), motionEvent.getY());
                } else if (motionEvent.getAction() == 1) {
                    this.f6553s.onUp(motionEvent.getX(), motionEvent.getY());
                }
            }
            this.f6537c.onTouchEvent(motionEvent);
            this.f6540f.h(motionEvent, iArr[0], iArr[1]);
            if (!this.f6542h || this.f6546l <= 0) {
                this.f6541g.h(motionEvent, iArr[0], iArr[1]);
                if (!this.f6548n) {
                    this.f6538d.e(motionEvent);
                    this.f6539e.h(motionEvent, iArr[0], iArr[1]);
                }
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final int g() {
        return this.f6551q;
    }

    public final int j() {
        return this.f6552r;
    }

    public ia(IAMapDelegate iAMapDelegate) {
        byte b6 = 0;
        this.f6536b = iAMapDelegate.getContext();
        this.f6535a = iAMapDelegate;
        a aVar = new a(this, b6);
        GestureDetector gestureDetector = new GestureDetector(this.f6536b, aVar, this.f6554t);
        this.f6537c = gestureDetector;
        gestureDetector.setOnDoubleTapListener(aVar);
        this.f6538d = new w(this.f6536b, new d(this, b6));
        this.f6539e = new u(this.f6536b, new c(this, b6));
        this.f6540f = new t(this.f6536b, new b(this, b6));
        this.f6541g = new x(this.f6536b, new e(this, b6));
    }
}
