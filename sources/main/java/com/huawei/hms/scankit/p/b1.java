package com.huawei.hms.scankit.p;

import android.view.animation.Interpolator;
import java.math.BigDecimal;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class b1 implements Interpolator {

    /* renamed from: e, reason: collision with root package name */
    private static final BigDecimal f34006e;

    /* renamed from: f, reason: collision with root package name */
    private static final BigDecimal f34007f;

    /* renamed from: g, reason: collision with root package name */
    private static final float f34008g;

    /* renamed from: a, reason: collision with root package name */
    private float f34009a;

    /* renamed from: b, reason: collision with root package name */
    private float f34010b;

    /* renamed from: c, reason: collision with root package name */
    private float f34011c;

    /* renamed from: d, reason: collision with root package name */
    private float f34012d;

    private long a(float f6) {
        long j6 = 0;
        long j7 = master.flame.danmaku.danmaku.model.android.d.f50003r;
        while (j6 <= j7) {
            long j8 = (j6 + j7) >>> 1;
            float b6 = b(f34008g * j8);
            if (b6 < f6) {
                j6 = j8 + 1;
            } else {
                if (b6 <= f6) {
                    return j8;
                }
                j7 = j8 - 1;
            }
        }
        return j6;
    }

    static {
        BigDecimal bigDecimal = new BigDecimal(Float.toString(1.0f));
        f34006e = bigDecimal;
        BigDecimal bigDecimal2 = new BigDecimal(Long.toString(master.flame.danmaku.danmaku.model.android.d.f50003r));
        f34007f = bigDecimal2;
        f34008g = bigDecimal.divide(bigDecimal2, 20, 4).floatValue();
    }

    private String a() {
        return "CubicBezierInterpolator  mControlPoint1x = " + this.f34009a + ", mControlPoint1y = " + this.f34010b + ", mControlPoint2x = " + this.f34011c + ", mControlPoint2y = " + this.f34012d;
    }

    private float b(float f6) {
        float f7 = 1.0f - f6;
        float f8 = 3.0f * f7;
        return (f7 * f8 * f6 * this.f34009a) + (f8 * f6 * f6 * this.f34011c) + (f6 * f6 * f6);
    }

    private float c(float f6) {
        float f7 = 1.0f - f6;
        float f8 = 3.0f * f7;
        return (f7 * f8 * f6 * this.f34010b) + (f8 * f6 * f6 * this.f34012d) + (f6 * f6 * f6);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f6) {
        return c(f34008g * a(f6));
    }

    public b1(float f6, float f7, float f8, float f9) {
        this.f34009a = f6;
        this.f34010b = f7;
        this.f34011c = f8;
        this.f34012d = f9;
    }

    public String toString() {
        return a();
    }
}
