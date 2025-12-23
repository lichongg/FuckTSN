package com.bytedance.sdk.component.adexpress.widget;

import android.graphics.PointF;
import android.view.animation.Interpolator;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements Interpolator {
    protected PointF cw;

    /* renamed from: j, reason: collision with root package name */
    protected PointF f26009j;

    /* renamed from: r, reason: collision with root package name */
    protected PointF f26010r;
    protected PointF up;
    protected PointF xt;

    public j(PointF pointF, PointF pointF2) throws IllegalArgumentException {
        this.cw = new PointF();
        this.f26010r = new PointF();
        this.up = new PointF();
        float f6 = pointF.x;
        if (f6 < 0.0f || f6 > 1.0f) {
            throw new IllegalArgumentException("startX value must be in the range [0, 1]");
        }
        float f7 = pointF2.x;
        if (f7 < 0.0f || f7 > 1.0f) {
            throw new IllegalArgumentException("endX value must be in the range [0, 1]");
        }
        this.f26009j = pointF;
        this.xt = pointF2;
    }

    protected float xt(float f6) {
        float f7 = f6;
        for (int i6 = 1; i6 < 14; i6++) {
            float r5 = r(f7) - f6;
            if (Math.abs(r5) < 0.001d) {
                break;
            }
            f7 -= r5 / cw(f7);
        }
        return f7;
    }

    private float cw(float f6) {
        return this.up.x + (f6 * ((this.f26010r.x * 2.0f) + (this.cw.x * 3.0f * f6)));
    }

    private float r(float f6) {
        PointF pointF = this.up;
        PointF pointF2 = this.f26009j;
        float f7 = pointF2.x * 3.0f;
        pointF.x = f7;
        PointF pointF3 = this.f26010r;
        float f8 = ((this.xt.x - pointF2.x) * 3.0f) - f7;
        pointF3.x = f8;
        PointF pointF4 = this.cw;
        float f9 = (1.0f - pointF.x) - f8;
        pointF4.x = f9;
        return f6 * (pointF.x + ((pointF3.x + (f9 * f6)) * f6));
    }

    protected float j(float f6) {
        PointF pointF = this.up;
        PointF pointF2 = this.f26009j;
        float f7 = pointF2.y * 3.0f;
        pointF.y = f7;
        PointF pointF3 = this.f26010r;
        float f8 = ((this.xt.y - pointF2.y) * 3.0f) - f7;
        pointF3.y = f8;
        PointF pointF4 = this.cw;
        float f9 = (1.0f - pointF.y) - f8;
        pointF4.y = f9;
        return f6 * (pointF.y + ((pointF3.y + (f9 * f6)) * f6));
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f6) {
        return j(xt(f6));
    }

    public j(float f6, float f7, float f8, float f9) {
        this(new PointF(f6, f7), new PointF(f8, f9));
    }
}
