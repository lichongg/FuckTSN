package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class u extends s {

    /* renamed from: o, reason: collision with root package name */
    private static final PointF f7319o = new PointF();

    /* renamed from: j, reason: collision with root package name */
    private final a f7320j;

    /* renamed from: k, reason: collision with root package name */
    private PointF f7321k;

    /* renamed from: l, reason: collision with root package name */
    private PointF f7322l;

    /* renamed from: m, reason: collision with root package name */
    private PointF f7323m;

    /* renamed from: n, reason: collision with root package name */
    private PointF f7324n;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        boolean a(u uVar);

        void b(u uVar);

        boolean c(u uVar);
    }

    @Override // com.amap.api.col.p0003l.s
    protected final void c(int i6, MotionEvent motionEvent) {
        if (i6 != 1) {
            if (i6 == 2) {
                e(motionEvent);
                if (this.f7196e / this.f7197f <= 0.67f || motionEvent.getPointerCount() > 1 || !this.f7320j.c(this)) {
                    return;
                }
                this.f7194c.recycle();
                this.f7194c = MotionEvent.obtain(motionEvent);
                return;
            }
            if (i6 != 3) {
                return;
            }
        }
        this.f7320j.b(this);
        a();
    }

    @Override // com.amap.api.col.p0003l.s
    protected final void d(int i6, MotionEvent motionEvent, int i7, int i8) {
        if (i6 == 0) {
            a();
            this.f7194c = MotionEvent.obtain(motionEvent);
            this.f7198g = 0L;
            e(motionEvent);
            return;
        }
        if (i6 == 2) {
            this.f7193b = this.f7320j.a(this);
            return;
        }
        if (i6 != 5) {
            return;
        }
        MotionEvent motionEvent2 = this.f7194c;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        this.f7194c = MotionEvent.obtain(motionEvent);
        e(motionEvent);
    }

    public final PointF j() {
        return this.f7324n;
    }

    public u(Context context, a aVar) {
        super(context);
        this.f7323m = new PointF();
        this.f7324n = new PointF();
        this.f7320j = aVar;
    }

    @Override // com.amap.api.col.p0003l.s
    protected final void e(MotionEvent motionEvent) {
        boolean z5;
        PointF pointF;
        super.e(motionEvent);
        MotionEvent motionEvent2 = this.f7194c;
        this.f7321k = s.g(motionEvent);
        this.f7322l = s.g(motionEvent2);
        if (this.f7194c.getPointerCount() != motionEvent.getPointerCount()) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5) {
            pointF = f7319o;
        } else {
            PointF pointF2 = this.f7321k;
            float f6 = pointF2.x;
            PointF pointF3 = this.f7322l;
            pointF = new PointF(f6 - pointF3.x, pointF2.y - pointF3.y);
        }
        this.f7324n = pointF;
        if (z5) {
            this.f7194c.recycle();
            this.f7194c = MotionEvent.obtain(motionEvent);
        }
        PointF pointF4 = this.f7323m;
        float f7 = pointF4.x;
        PointF pointF5 = this.f7324n;
        pointF4.x = f7 + pointF5.x;
        pointF4.y += pointF5.y;
    }
}
