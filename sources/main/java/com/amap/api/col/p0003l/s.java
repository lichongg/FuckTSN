package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class s {

    /* renamed from: a, reason: collision with root package name */
    protected final Context f7192a;

    /* renamed from: b, reason: collision with root package name */
    protected boolean f7193b;

    /* renamed from: c, reason: collision with root package name */
    protected MotionEvent f7194c;

    /* renamed from: d, reason: collision with root package name */
    protected MotionEvent f7195d;

    /* renamed from: e, reason: collision with root package name */
    protected float f7196e;

    /* renamed from: f, reason: collision with root package name */
    protected float f7197f;

    /* renamed from: g, reason: collision with root package name */
    protected long f7198g;

    /* renamed from: h, reason: collision with root package name */
    protected int f7199h = 0;

    /* renamed from: i, reason: collision with root package name */
    protected int f7200i = 0;

    protected abstract void c(int i6, MotionEvent motionEvent);

    protected abstract void d(int i6, MotionEvent motionEvent, int i7, int i8);

    protected void a() {
        MotionEvent motionEvent = this.f7194c;
        if (motionEvent != null) {
            motionEvent.recycle();
            this.f7194c = null;
        }
        MotionEvent motionEvent2 = this.f7195d;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
            this.f7195d = null;
        }
        this.f7193b = false;
    }

    public final void b(int i6, int i7) {
        this.f7199h = i6;
        this.f7200i = i7;
    }

    protected void e(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = this.f7194c;
        MotionEvent motionEvent3 = this.f7195d;
        if (motionEvent3 != null) {
            motionEvent3.recycle();
            this.f7195d = null;
        }
        this.f7195d = MotionEvent.obtain(motionEvent);
        this.f7198g = motionEvent.getEventTime() - motionEvent2.getEventTime();
        this.f7196e = motionEvent.getPressure(motionEvent.getActionIndex());
        this.f7197f = motionEvent2.getPressure(motionEvent2.getActionIndex());
    }

    public final long f() {
        return this.f7198g;
    }

    public final MotionEvent i() {
        return this.f7195d;
    }

    public s(Context context) {
        this.f7192a = context;
    }

    public static PointF g(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        float f6 = 0.0f;
        float f7 = 0.0f;
        for (int i6 = 0; i6 < pointerCount; i6++) {
            f6 += motionEvent.getX(i6);
            f7 += motionEvent.getY(i6);
        }
        float f8 = pointerCount;
        return new PointF(f6 / f8, f7 / f8);
    }

    public final boolean h(MotionEvent motionEvent, int i6, int i7) {
        int action = motionEvent.getAction() & 255;
        if (!this.f7193b) {
            d(action, motionEvent, i6, i7);
            return true;
        }
        c(action, motionEvent);
        return true;
    }
}
