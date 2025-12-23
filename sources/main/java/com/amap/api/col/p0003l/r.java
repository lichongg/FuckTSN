package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class r extends s {

    /* renamed from: j, reason: collision with root package name */
    private final float f7147j;

    /* renamed from: k, reason: collision with root package name */
    private float f7148k;

    /* renamed from: l, reason: collision with root package name */
    private float f7149l;

    /* renamed from: m, reason: collision with root package name */
    protected float f7150m;

    /* renamed from: n, reason: collision with root package name */
    protected float f7151n;

    /* renamed from: o, reason: collision with root package name */
    protected float f7152o;

    /* renamed from: p, reason: collision with root package name */
    protected float f7153p;

    /* renamed from: q, reason: collision with root package name */
    private float f7154q;

    /* renamed from: r, reason: collision with root package name */
    private float f7155r;

    /* renamed from: s, reason: collision with root package name */
    private float f7156s;

    /* renamed from: t, reason: collision with root package name */
    private float f7157t;

    /* renamed from: u, reason: collision with root package name */
    private float f7158u;

    /* renamed from: v, reason: collision with root package name */
    private float f7159v;

    private static float j(MotionEvent motionEvent, int i6) {
        float x5 = (i6 + motionEvent.getX()) - motionEvent.getRawX();
        if (1 < motionEvent.getPointerCount()) {
            return motionEvent.getX(1) + x5;
        }
        return 0.0f;
    }

    private static float m(MotionEvent motionEvent, int i6) {
        float y5 = (i6 + motionEvent.getY()) - motionEvent.getRawY();
        if (1 < motionEvent.getPointerCount()) {
            return motionEvent.getY(1) + y5;
        }
        return 0.0f;
    }

    public final PointF k(int i6) {
        return i6 == 0 ? new PointF(this.f7156s, this.f7157t) : new PointF(this.f7158u, this.f7159v);
    }

    protected final boolean l(MotionEvent motionEvent, int i6, int i7) {
        int i8;
        int i9 = this.f7199h;
        if (i9 == 0 || (i8 = this.f7200i) == 0) {
            float f6 = this.f7192a.getResources().getDisplayMetrics().widthPixels;
            float f7 = this.f7147j;
            this.f7148k = f6 - f7;
            this.f7149l = r0.heightPixels - f7;
        } else {
            float f8 = this.f7147j;
            this.f7148k = i9 - f8;
            this.f7149l = i8 - f8;
        }
        float f9 = this.f7147j;
        float f10 = this.f7148k;
        float f11 = this.f7149l;
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float j6 = j(motionEvent, i6);
        float m6 = m(motionEvent, i7);
        boolean z5 = rawX < f9 || rawY < f9 || rawX > f10 || rawY > f11;
        boolean z6 = j6 < f9 || m6 < f9 || j6 > f10 || m6 > f11;
        return (z5 && z6) || z5 || z6;
    }

    public r(Context context) {
        super(context);
        this.f7156s = 0.0f;
        this.f7157t = 0.0f;
        this.f7158u = 0.0f;
        this.f7159v = 0.0f;
        this.f7147j = ViewConfiguration.get(context).getScaledEdgeSlop();
    }

    @Override // com.amap.api.col.p0003l.s
    protected void e(MotionEvent motionEvent) {
        super.e(motionEvent);
        MotionEvent motionEvent2 = this.f7194c;
        int pointerCount = motionEvent2.getPointerCount();
        int pointerCount2 = motionEvent.getPointerCount();
        if (pointerCount2 == 2 && pointerCount2 == pointerCount) {
            this.f7154q = -1.0f;
            this.f7155r = -1.0f;
            float x5 = motionEvent2.getX(0);
            float y5 = motionEvent2.getY(0);
            float x6 = motionEvent2.getX(1);
            float y6 = motionEvent2.getY(1);
            this.f7150m = x6 - x5;
            this.f7151n = y6 - y5;
            float x7 = motionEvent.getX(0);
            float y7 = motionEvent.getY(0);
            float x8 = motionEvent.getX(1);
            float y8 = motionEvent.getY(1);
            this.f7152o = x8 - x7;
            this.f7153p = y8 - y7;
            this.f7156s = x7 - x5;
            this.f7157t = y7 - y5;
            this.f7158u = x8 - x6;
            this.f7159v = y8 - y6;
        }
    }
}
