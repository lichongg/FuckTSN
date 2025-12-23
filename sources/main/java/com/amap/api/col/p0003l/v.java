package com.amap.api.col.p0003l;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    private final Context f7433a;

    /* renamed from: b, reason: collision with root package name */
    private final a f7434b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f7435c;

    /* renamed from: d, reason: collision with root package name */
    private MotionEvent f7436d;

    /* renamed from: e, reason: collision with root package name */
    private MotionEvent f7437e;

    /* renamed from: f, reason: collision with root package name */
    private float f7438f;

    /* renamed from: g, reason: collision with root package name */
    private float f7439g;

    /* renamed from: h, reason: collision with root package name */
    private float f7440h;

    /* renamed from: i, reason: collision with root package name */
    private float f7441i;

    /* renamed from: j, reason: collision with root package name */
    private float f7442j;

    /* renamed from: k, reason: collision with root package name */
    private float f7443k;

    /* renamed from: l, reason: collision with root package name */
    private float f7444l;

    /* renamed from: m, reason: collision with root package name */
    private float f7445m;

    /* renamed from: n, reason: collision with root package name */
    private float f7446n;

    /* renamed from: o, reason: collision with root package name */
    private float f7447o;

    /* renamed from: p, reason: collision with root package name */
    private float f7448p;

    /* renamed from: q, reason: collision with root package name */
    private long f7449q;

    /* renamed from: r, reason: collision with root package name */
    private final float f7450r;

    /* renamed from: s, reason: collision with root package name */
    private float f7451s;

    /* renamed from: t, reason: collision with root package name */
    private float f7452t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f7453u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f7454v;

    /* renamed from: w, reason: collision with root package name */
    private int f7455w;

    /* renamed from: x, reason: collision with root package name */
    private int f7456x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f7457y;

    /* renamed from: z, reason: collision with root package name */
    private int f7458z = 0;
    private int A = 0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a(v vVar);

        boolean b(v vVar);

        boolean c(v vVar);
    }

    private static float a(MotionEvent motionEvent, int i6) {
        if (i6 < 0) {
            return Float.MIN_VALUE;
        }
        if (i6 == 0) {
            return motionEvent.getRawX();
        }
        return motionEvent.getX(i6) + (motionEvent.getRawX() - motionEvent.getX());
    }

    private static float g(MotionEvent motionEvent, int i6) {
        if (i6 < 0) {
            return Float.MIN_VALUE;
        }
        if (i6 == 0) {
            return motionEvent.getRawY();
        }
        return motionEvent.getY(i6) + (motionEvent.getRawY() - motionEvent.getY());
    }

    private void h(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = this.f7437e;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        this.f7437e = MotionEvent.obtain(motionEvent);
        this.f7444l = -1.0f;
        this.f7445m = -1.0f;
        this.f7446n = -1.0f;
        MotionEvent motionEvent3 = this.f7436d;
        int findPointerIndex = motionEvent3.findPointerIndex(this.f7455w);
        int findPointerIndex2 = motionEvent3.findPointerIndex(this.f7456x);
        int findPointerIndex3 = motionEvent.findPointerIndex(this.f7455w);
        int findPointerIndex4 = motionEvent.findPointerIndex(this.f7456x);
        if (findPointerIndex < 0 || findPointerIndex2 < 0 || findPointerIndex3 < 0 || findPointerIndex4 < 0) {
            this.f7454v = true;
            if (this.f7435c) {
                this.f7434b.a(this);
                return;
            }
            return;
        }
        float x5 = motionEvent3.getX(findPointerIndex);
        float y5 = motionEvent3.getY(findPointerIndex);
        float x6 = motionEvent3.getX(findPointerIndex2);
        float y6 = motionEvent3.getY(findPointerIndex2);
        float x7 = motionEvent.getX(findPointerIndex3);
        float y7 = motionEvent.getY(findPointerIndex3);
        float x8 = motionEvent.getX(findPointerIndex4) - x7;
        float y8 = motionEvent.getY(findPointerIndex4) - y7;
        this.f7440h = x6 - x5;
        this.f7441i = y6 - y5;
        this.f7442j = x8;
        this.f7443k = y8;
        this.f7438f = x7 + (x8 * 0.5f);
        this.f7439g = y7 + (y8 * 0.5f);
        this.f7449q = motionEvent.getEventTime() - motionEvent3.getEventTime();
        this.f7447o = motionEvent.getPressure(findPointerIndex3) + motionEvent.getPressure(findPointerIndex4);
        this.f7448p = motionEvent3.getPressure(findPointerIndex) + motionEvent3.getPressure(findPointerIndex2);
    }

    private void p() {
        MotionEvent motionEvent = this.f7436d;
        if (motionEvent != null) {
            motionEvent.recycle();
            this.f7436d = null;
        }
        MotionEvent motionEvent2 = this.f7437e;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
            this.f7437e = null;
        }
        this.f7453u = false;
        this.f7435c = false;
        this.f7455w = -1;
        this.f7456x = -1;
        this.f7454v = false;
    }

    private float q() {
        if (this.f7444l == -1.0f) {
            float f6 = this.f7442j;
            float f7 = this.f7443k;
            this.f7444l = (float) Math.sqrt((f6 * f6) + (f7 * f7));
        }
        return this.f7444l;
    }

    private float r() {
        if (this.f7445m == -1.0f) {
            float f6 = this.f7440h;
            float f7 = this.f7441i;
            this.f7445m = (float) Math.sqrt((f6 * f6) + (f7 * f7));
        }
        return this.f7445m;
    }

    public final MotionEvent c() {
        return this.f7437e;
    }

    public final void d(int i6, int i7) {
        this.f7458z = i6;
        this.A = i7;
    }

    public final float f() {
        return this.f7438f;
    }

    public final float i() {
        return this.f7439g;
    }

    public final float j() {
        return this.f7442j;
    }

    public final float k() {
        return this.f7443k;
    }

    public final float l() {
        return this.f7440h;
    }

    public final float m() {
        return this.f7441i;
    }

    public final float n() {
        if (this.f7446n == -1.0f) {
            this.f7446n = q() / r();
        }
        return this.f7446n;
    }

    public final long o() {
        return this.f7449q;
    }

    public v(Context context, a aVar) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f7433a = context;
        this.f7434b = aVar;
        this.f7450r = viewConfiguration.getScaledEdgeSlop();
    }

    private int b(MotionEvent motionEvent, int i6, int i7) {
        int pointerCount = motionEvent.getPointerCount();
        int findPointerIndex = motionEvent.findPointerIndex(i6);
        for (int i8 = 0; i8 < pointerCount; i8++) {
            if (i8 != i7 && i8 != findPointerIndex) {
                float f6 = this.f7450r;
                float f7 = this.f7451s;
                float f8 = this.f7452t;
                float a6 = a(motionEvent, i8);
                float g6 = g(motionEvent, i8);
                if (a6 >= f6 && g6 >= f6 && a6 <= f7 && g6 <= f8) {
                    return i8;
                }
            }
        }
        return -1;
    }

    public final boolean e(MotionEvent motionEvent) {
        boolean z5;
        boolean z6;
        int b6;
        int b7;
        boolean z7;
        boolean z8;
        int i6;
        int b8;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            p();
        }
        boolean z9 = false;
        if (this.f7454v) {
            return false;
        }
        int i7 = -1;
        if (!this.f7435c) {
            if (action != 0) {
                if (action != 1) {
                    if (action != 2) {
                        if (action != 5) {
                            if (action == 6 && this.f7453u) {
                                int pointerCount = motionEvent.getPointerCount();
                                int actionIndex = motionEvent.getActionIndex();
                                int pointerId = motionEvent.getPointerId(actionIndex);
                                if (pointerCount > 2) {
                                    int i8 = this.f7455w;
                                    if (pointerId == i8) {
                                        int b9 = b(motionEvent, this.f7456x, actionIndex);
                                        if (b9 >= 0) {
                                            this.f7455w = motionEvent.getPointerId(b9);
                                            return true;
                                        }
                                    } else if (pointerId == this.f7456x && (b8 = b(motionEvent, i8, actionIndex)) >= 0) {
                                        this.f7456x = motionEvent.getPointerId(b8);
                                        return true;
                                    }
                                } else {
                                    int i9 = this.f7455w;
                                    if (pointerId == i9) {
                                        i9 = this.f7456x;
                                    }
                                    int findPointerIndex = motionEvent.findPointerIndex(i9);
                                    if (findPointerIndex < 0) {
                                        this.f7454v = true;
                                        if (this.f7435c) {
                                            this.f7434b.a(this);
                                        }
                                        return false;
                                    }
                                    this.f7455w = motionEvent.getPointerId(findPointerIndex);
                                    this.f7457y = true;
                                    this.f7456x = -1;
                                    this.f7438f = motionEvent.getX(findPointerIndex);
                                    this.f7439g = motionEvent.getY(findPointerIndex);
                                    return true;
                                }
                            }
                        } else {
                            int i10 = this.f7458z;
                            if (i10 != 0 && (i6 = this.A) != 0) {
                                float f6 = this.f7450r;
                                this.f7451s = i10 - f6;
                                this.f7452t = i6 - f6;
                            } else {
                                float f7 = this.f7433a.getResources().getDisplayMetrics().widthPixels;
                                float f8 = this.f7450r;
                                this.f7451s = f7 - f8;
                                this.f7452t = r0.heightPixels - f8;
                            }
                            MotionEvent motionEvent2 = this.f7436d;
                            if (motionEvent2 != null) {
                                motionEvent2.recycle();
                            }
                            this.f7436d = MotionEvent.obtain(motionEvent);
                            this.f7449q = 0L;
                            int actionIndex2 = motionEvent.getActionIndex();
                            int findPointerIndex2 = motionEvent.findPointerIndex(this.f7455w);
                            int pointerId2 = motionEvent.getPointerId(actionIndex2);
                            this.f7456x = pointerId2;
                            if (findPointerIndex2 < 0 || findPointerIndex2 == actionIndex2) {
                                if (findPointerIndex2 != actionIndex2) {
                                    i7 = pointerId2;
                                }
                                findPointerIndex2 = b(motionEvent, i7, findPointerIndex2);
                                this.f7455w = motionEvent.getPointerId(findPointerIndex2);
                            }
                            this.f7457y = false;
                            h(motionEvent);
                            float f9 = this.f7450r;
                            float f10 = this.f7451s;
                            float f11 = this.f7452t;
                            float a6 = a(motionEvent, findPointerIndex2);
                            float g6 = g(motionEvent, findPointerIndex2);
                            float a7 = a(motionEvent, actionIndex2);
                            float g7 = g(motionEvent, actionIndex2);
                            if (a6 >= f9 && g6 >= f9 && a6 <= f10 && g6 <= f11) {
                                z7 = false;
                            } else {
                                z7 = true;
                            }
                            if (a7 >= f9 && g7 >= f9 && a7 <= f10 && g7 <= f11) {
                                z8 = false;
                            } else {
                                z8 = true;
                            }
                            if (z7 && z8) {
                                this.f7438f = -1.0f;
                                this.f7439g = -1.0f;
                                this.f7453u = true;
                                return true;
                            }
                            if (z7) {
                                this.f7438f = motionEvent.getX(actionIndex2);
                                this.f7439g = motionEvent.getY(actionIndex2);
                                this.f7453u = true;
                                return true;
                            }
                            if (z8) {
                                this.f7438f = motionEvent.getX(findPointerIndex2);
                                this.f7439g = motionEvent.getY(findPointerIndex2);
                                this.f7453u = true;
                                return true;
                            }
                            this.f7453u = false;
                            this.f7435c = this.f7434b.c(this);
                            return true;
                        }
                    } else if (this.f7453u) {
                        float f12 = this.f7450r;
                        float f13 = this.f7451s;
                        float f14 = this.f7452t;
                        int findPointerIndex3 = motionEvent.findPointerIndex(this.f7455w);
                        int findPointerIndex4 = motionEvent.findPointerIndex(this.f7456x);
                        float a8 = a(motionEvent, findPointerIndex3);
                        float g8 = g(motionEvent, findPointerIndex3);
                        float a9 = a(motionEvent, findPointerIndex4);
                        float g9 = g(motionEvent, findPointerIndex4);
                        if (a8 >= f12 && g8 >= f12 && a8 <= f13 && g8 <= f14) {
                            z5 = false;
                        } else {
                            z5 = true;
                        }
                        if (a9 >= f12 && g9 >= f12 && a9 <= f13 && g9 <= f14) {
                            z6 = false;
                        } else {
                            z6 = true;
                        }
                        if (z5 && (b7 = b(motionEvent, this.f7456x, findPointerIndex3)) >= 0) {
                            this.f7455w = motionEvent.getPointerId(b7);
                            a(motionEvent, b7);
                            g(motionEvent, b7);
                            findPointerIndex3 = b7;
                            z5 = false;
                        }
                        if (z6 && (b6 = b(motionEvent, this.f7455w, findPointerIndex4)) >= 0) {
                            this.f7456x = motionEvent.getPointerId(b6);
                            a(motionEvent, b6);
                            g(motionEvent, b6);
                            findPointerIndex4 = b6;
                            z6 = false;
                        }
                        if (z5 && z6) {
                            this.f7438f = -1.0f;
                            this.f7439g = -1.0f;
                            return true;
                        }
                        if (z5) {
                            this.f7438f = motionEvent.getX(findPointerIndex4);
                            this.f7439g = motionEvent.getY(findPointerIndex4);
                            return true;
                        }
                        if (z6) {
                            this.f7438f = motionEvent.getX(findPointerIndex3);
                            this.f7439g = motionEvent.getY(findPointerIndex3);
                            return true;
                        }
                        this.f7453u = false;
                        this.f7435c = this.f7434b.c(this);
                        return true;
                    }
                } else {
                    p();
                    return true;
                }
            } else {
                this.f7455w = motionEvent.getPointerId(0);
                this.f7457y = true;
                return true;
            }
        } else if (action != 1) {
            if (action != 2) {
                if (action != 3) {
                    if (action != 5) {
                        if (action == 6) {
                            int pointerCount2 = motionEvent.getPointerCount();
                            int actionIndex3 = motionEvent.getActionIndex();
                            int pointerId3 = motionEvent.getPointerId(actionIndex3);
                            if (pointerCount2 > 2) {
                                int i11 = this.f7455w;
                                if (pointerId3 == i11) {
                                    int b10 = b(motionEvent, this.f7456x, actionIndex3);
                                    if (b10 >= 0) {
                                        this.f7434b.a(this);
                                        this.f7455w = motionEvent.getPointerId(b10);
                                        this.f7457y = true;
                                        this.f7436d = MotionEvent.obtain(motionEvent);
                                        h(motionEvent);
                                        this.f7435c = this.f7434b.c(this);
                                        this.f7436d.recycle();
                                        this.f7436d = MotionEvent.obtain(motionEvent);
                                        h(motionEvent);
                                    }
                                    z9 = true;
                                    this.f7436d.recycle();
                                    this.f7436d = MotionEvent.obtain(motionEvent);
                                    h(motionEvent);
                                } else {
                                    if (pointerId3 == this.f7456x) {
                                        int b11 = b(motionEvent, i11, actionIndex3);
                                        if (b11 >= 0) {
                                            this.f7434b.a(this);
                                            this.f7456x = motionEvent.getPointerId(b11);
                                            this.f7457y = false;
                                            this.f7436d = MotionEvent.obtain(motionEvent);
                                            h(motionEvent);
                                            this.f7435c = this.f7434b.c(this);
                                        }
                                        z9 = true;
                                    }
                                    this.f7436d.recycle();
                                    this.f7436d = MotionEvent.obtain(motionEvent);
                                    h(motionEvent);
                                }
                            } else {
                                z9 = true;
                            }
                            if (z9) {
                                h(motionEvent);
                                int i12 = this.f7455w;
                                if (pointerId3 == i12) {
                                    i12 = this.f7456x;
                                }
                                int findPointerIndex5 = motionEvent.findPointerIndex(i12);
                                this.f7438f = motionEvent.getX(findPointerIndex5);
                                this.f7439g = motionEvent.getY(findPointerIndex5);
                                this.f7434b.a(this);
                                p();
                                this.f7455w = i12;
                                this.f7457y = true;
                                return true;
                            }
                        }
                    } else {
                        this.f7434b.a(this);
                        int i13 = this.f7455w;
                        int i14 = this.f7456x;
                        p();
                        this.f7436d = MotionEvent.obtain(motionEvent);
                        if (!this.f7457y) {
                            i13 = i14;
                        }
                        this.f7455w = i13;
                        this.f7456x = motionEvent.getPointerId(motionEvent.getActionIndex());
                        this.f7457y = false;
                        int findPointerIndex6 = motionEvent.findPointerIndex(this.f7455w);
                        if (findPointerIndex6 < 0 || this.f7455w == this.f7456x) {
                            int i15 = this.f7455w;
                            int i16 = this.f7456x;
                            if (i15 != i16) {
                                i7 = i16;
                            }
                            this.f7455w = motionEvent.getPointerId(b(motionEvent, i7, findPointerIndex6));
                        }
                        h(motionEvent);
                        this.f7435c = this.f7434b.c(this);
                        return true;
                    }
                } else {
                    this.f7434b.a(this);
                    p();
                    return true;
                }
            } else {
                h(motionEvent);
                if (this.f7447o / this.f7448p > 0.67f && this.f7434b.b(this)) {
                    this.f7436d.recycle();
                    this.f7436d = MotionEvent.obtain(motionEvent);
                }
            }
        } else {
            p();
            return true;
        }
        return true;
    }
}
