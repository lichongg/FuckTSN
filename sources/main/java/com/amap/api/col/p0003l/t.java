package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class t extends r {
    private static final PointF C = new PointF();
    private PointF A;
    private PointF B;

    /* renamed from: w, reason: collision with root package name */
    private final a f7250w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f7251x;

    /* renamed from: y, reason: collision with root package name */
    private PointF f7252y;

    /* renamed from: z, reason: collision with root package name */
    private PointF f7253z;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a(t tVar);

        boolean b(t tVar);

        boolean c(t tVar);
    }

    @Override // com.amap.api.col.p0003l.s
    protected final void c(int i6, MotionEvent motionEvent) {
        if (i6 == 2) {
            e(motionEvent);
            if (this.f7196e / this.f7197f <= 0.67f || !this.f7250w.b(this)) {
                return;
            }
            this.f7194c.recycle();
            this.f7194c = MotionEvent.obtain(motionEvent);
            return;
        }
        if (i6 == 3) {
            if (!this.f7251x) {
                this.f7250w.a(this);
            }
            a();
        } else {
            if (i6 != 6) {
                return;
            }
            e(motionEvent);
            if (!this.f7251x) {
                this.f7250w.a(this);
            }
            a();
        }
    }

    @Override // com.amap.api.col.p0003l.s
    protected final void d(int i6, MotionEvent motionEvent, int i7, int i8) {
        if (i6 == 2) {
            if (this.f7251x) {
                boolean l6 = l(motionEvent, i7, i8);
                this.f7251x = l6;
                if (l6) {
                    return;
                }
                this.f7193b = this.f7250w.c(this);
                return;
            }
            return;
        }
        if (i6 != 5) {
            return;
        }
        a();
        this.f7194c = MotionEvent.obtain(motionEvent);
        this.f7198g = 0L;
        e(motionEvent);
        boolean l7 = l(motionEvent, i7, i8);
        this.f7251x = l7;
        if (l7) {
            return;
        }
        this.f7193b = this.f7250w.c(this);
    }

    public final PointF n() {
        return this.B;
    }

    public t(Context context, a aVar) {
        super(context);
        this.A = new PointF();
        this.B = new PointF();
        this.f7250w = aVar;
    }

    @Override // com.amap.api.col.p0003l.s
    protected final void a() {
        super.a();
        this.f7251x = false;
    }

    @Override // com.amap.api.col.p0003l.r, com.amap.api.col.p0003l.s
    protected final void e(MotionEvent motionEvent) {
        PointF pointF;
        super.e(motionEvent);
        MotionEvent motionEvent2 = this.f7194c;
        this.f7252y = s.g(motionEvent);
        this.f7253z = s.g(motionEvent2);
        if (this.f7194c.getPointerCount() != motionEvent.getPointerCount()) {
            pointF = C;
        } else {
            PointF pointF2 = this.f7252y;
            float f6 = pointF2.x;
            PointF pointF3 = this.f7253z;
            pointF = new PointF(f6 - pointF3.x, pointF2.y - pointF3.y);
        }
        this.B = pointF;
        PointF pointF4 = this.A;
        pointF4.x += pointF.x;
        pointF4.y += pointF.y;
    }
}
