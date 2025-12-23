package com.bytedance.adsdk.lottie.m;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.bytedance.adsdk.lottie.m;
import com.bytedance.component.sdk.annotation.FloatRange;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j<T> {
    public Float ae;
    private float av;
    private float az;
    public final Interpolator cw;

    /* renamed from: g, reason: collision with root package name */
    public PointF f23336g;

    /* renamed from: j, reason: collision with root package name */
    public final T f23337j;
    private int jy;

    /* renamed from: m, reason: collision with root package name */
    public final float f23338m;
    private final m oq;
    private float qv;

    /* renamed from: r, reason: collision with root package name */
    public final Interpolator f23339r;
    public PointF tl;
    public final Interpolator up;
    private float vl;
    private int ws;
    public T xt;

    public j(m mVar, T t5, T t6, Interpolator interpolator, float f6, Float f7) {
        this.qv = -3987645.8f;
        this.vl = -3987645.8f;
        this.jy = 784923401;
        this.ws = 784923401;
        this.az = Float.MIN_VALUE;
        this.av = Float.MIN_VALUE;
        this.tl = null;
        this.f23336g = null;
        this.oq = mVar;
        this.f23337j = t5;
        this.xt = t6;
        this.cw = interpolator;
        this.f23339r = null;
        this.up = null;
        this.f23338m = f6;
        this.ae = f7;
    }

    public j<T> j(T t5, T t6) {
        return new j<>(t5, t6);
    }

    public float ae() {
        if (this.vl == -3987645.8f) {
            this.vl = ((Float) this.xt).floatValue();
        }
        return this.vl;
    }

    public float cw() {
        m mVar = this.oq;
        if (mVar == null) {
            return 0.0f;
        }
        if (this.az == Float.MIN_VALUE) {
            this.az = (this.f23338m - mVar.m()) / this.oq.w();
        }
        return this.az;
    }

    public int g() {
        if (this.ws == 784923401) {
            this.ws = ((Integer) this.xt).intValue();
        }
        return this.ws;
    }

    public boolean j(@FloatRange(from = 0.0d, to = 1.0d) float f6) {
        return f6 >= cw() && f6 < r();
    }

    public float m() {
        if (this.qv == -3987645.8f) {
            this.qv = ((Float) this.f23337j).floatValue();
        }
        return this.qv;
    }

    public float r() {
        if (this.oq == null) {
            return 1.0f;
        }
        if (this.av == Float.MIN_VALUE) {
            if (this.ae == null) {
                this.av = 1.0f;
            } else {
                this.av = cw() + ((this.ae.floatValue() - this.f23338m) / this.oq.w());
            }
        }
        return this.av;
    }

    public int tl() {
        if (this.jy == 784923401) {
            this.jy = ((Integer) this.f23337j).intValue();
        }
        return this.jy;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.f23337j + ", endValue=" + this.xt + ", startFrame=" + this.f23338m + ", endFrame=" + this.ae + ", interpolator=" + this.cw + '}';
    }

    public boolean up() {
        return this.cw == null && this.f23339r == null && this.up == null;
    }

    public j(m mVar, T t5, T t6, Interpolator interpolator, Interpolator interpolator2, float f6, Float f7) {
        this.qv = -3987645.8f;
        this.vl = -3987645.8f;
        this.jy = 784923401;
        this.ws = 784923401;
        this.az = Float.MIN_VALUE;
        this.av = Float.MIN_VALUE;
        this.tl = null;
        this.f23336g = null;
        this.oq = mVar;
        this.f23337j = t5;
        this.xt = t6;
        this.cw = null;
        this.f23339r = interpolator;
        this.up = interpolator2;
        this.f23338m = f6;
        this.ae = f7;
    }

    protected j(m mVar, T t5, T t6, Interpolator interpolator, Interpolator interpolator2, Interpolator interpolator3, float f6, Float f7) {
        this.qv = -3987645.8f;
        this.vl = -3987645.8f;
        this.jy = 784923401;
        this.ws = 784923401;
        this.az = Float.MIN_VALUE;
        this.av = Float.MIN_VALUE;
        this.tl = null;
        this.f23336g = null;
        this.oq = mVar;
        this.f23337j = t5;
        this.xt = t6;
        this.cw = interpolator;
        this.f23339r = interpolator2;
        this.up = interpolator3;
        this.f23338m = f6;
        this.ae = f7;
    }

    public j(T t5) {
        this.qv = -3987645.8f;
        this.vl = -3987645.8f;
        this.jy = 784923401;
        this.ws = 784923401;
        this.az = Float.MIN_VALUE;
        this.av = Float.MIN_VALUE;
        this.tl = null;
        this.f23336g = null;
        this.oq = null;
        this.f23337j = t5;
        this.xt = t5;
        this.cw = null;
        this.f23339r = null;
        this.up = null;
        this.f23338m = Float.MIN_VALUE;
        this.ae = Float.valueOf(Float.MAX_VALUE);
    }

    private j(T t5, T t6) {
        this.qv = -3987645.8f;
        this.vl = -3987645.8f;
        this.jy = 784923401;
        this.ws = 784923401;
        this.az = Float.MIN_VALUE;
        this.av = Float.MIN_VALUE;
        this.tl = null;
        this.f23336g = null;
        this.oq = null;
        this.f23337j = t5;
        this.xt = t6;
        this.cw = null;
        this.f23339r = null;
        this.up = null;
        this.f23338m = Float.MIN_VALUE;
        this.ae = Float.valueOf(Float.MAX_VALUE);
    }
}
