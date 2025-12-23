package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class x extends r {
    private static final PointF C = new PointF();
    private PointF A;
    private PointF B;

    /* renamed from: w, reason: collision with root package name */
    private final a f7613w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f7614x;

    /* renamed from: y, reason: collision with root package name */
    private PointF f7615y;

    /* renamed from: z, reason: collision with root package name */
    private PointF f7616z;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a(x xVar);
    }

    @Override // com.amap.api.col.p0003l.s
    protected final void c(int i6, MotionEvent motionEvent) {
        if (i6 == 3) {
            a();
        } else {
            if (i6 != 6) {
                return;
            }
            e(motionEvent);
            if (!this.f7614x) {
                this.f7613w.a(this);
            }
            a();
        }
    }

    @Override // com.amap.api.col.p0003l.s
    protected final void d(int i6, MotionEvent motionEvent, int i7, int i8) {
        if (i6 != 5) {
            return;
        }
        a();
        this.f7194c = MotionEvent.obtain(motionEvent);
        this.f7198g = 0L;
        e(motionEvent);
        boolean l6 = l(motionEvent, i7, i8);
        this.f7614x = l6;
        if (l6) {
            return;
        }
        this.f7193b = true;
    }

    public final float n() {
        return this.A.x;
    }

    public final float o() {
        return this.A.y;
    }

    public x(Context context, a aVar) {
        super(context);
        this.A = new PointF();
        this.B = new PointF();
        this.f7613w = aVar;
    }

    @Override // com.amap.api.col.p0003l.s
    protected final void a() {
        super.a();
        this.f7614x = false;
        PointF pointF = this.A;
        pointF.x = 0.0f;
        PointF pointF2 = this.B;
        pointF2.x = 0.0f;
        pointF.y = 0.0f;
        pointF2.y = 0.0f;
    }

    @Override // com.amap.api.col.p0003l.r, com.amap.api.col.p0003l.s
    protected final void e(MotionEvent motionEvent) {
        PointF pointF;
        super.e(motionEvent);
        MotionEvent motionEvent2 = this.f7194c;
        this.f7615y = s.g(motionEvent);
        this.f7616z = s.g(motionEvent2);
        if (this.f7194c.getPointerCount() != motionEvent.getPointerCount()) {
            pointF = C;
        } else {
            PointF pointF2 = this.f7615y;
            float f6 = pointF2.x;
            PointF pointF3 = this.f7616z;
            pointF = new PointF(f6 - pointF3.x, pointF2.y - pointF3.y);
        }
        this.B = pointF;
        PointF pointF4 = this.A;
        pointF4.x += pointF.x;
        pointF4.y += pointF.y;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class b implements a {
        @Override // com.amap.api.col.3l.x.a
        public void a(x xVar) {
        }
    }
}
