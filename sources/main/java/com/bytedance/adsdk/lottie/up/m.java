package com.bytedance.adsdk.lottie.up;

import android.view.Choreographer;
import com.bytedance.component.sdk.annotation.FloatRange;
import com.bytedance.component.sdk.annotation.MainThread;

/* loaded from: D:\Downloads\app\classes3.dex */
public class m extends j implements Choreographer.FrameCallback {
    private com.bytedance.adsdk.lottie.m oq;
    private float xt = 1.0f;
    private boolean cw = false;

    /* renamed from: r, reason: collision with root package name */
    private long f23559r = 0;
    private float up = 0.0f;

    /* renamed from: m, reason: collision with root package name */
    private float f23558m = 0.0f;
    private int ae = 0;
    private float tl = -2.1474836E9f;

    /* renamed from: g, reason: collision with root package name */
    private float f23556g = 2.1474836E9f;

    /* renamed from: j, reason: collision with root package name */
    protected boolean f23557j = false;
    private boolean qv = false;

    public void cw(boolean z5) {
        this.qv = z5;
    }

    public void j(com.bytedance.adsdk.lottie.m mVar) {
        boolean z5 = this.oq == null;
        this.oq = mVar;
        if (z5) {
            j(Math.max(this.tl, mVar.m()), Math.min(this.f23556g, mVar.ae()));
        } else {
            j((int) mVar.m(), (int) mVar.ae());
        }
        float f6 = this.f23558m;
        this.f23558m = 0.0f;
        this.up = 0.0f;
        j((int) f6);
        cw();
    }

    @MainThread
    public void qv() {
        this.f23557j = true;
        j(kt());
        j((int) (kt() ? av() : az()));
        this.f23559r = 0L;
        this.ae = 0;
        i();
    }

    public void tl() {
        this.oq = null;
        this.tl = -2.1474836E9f;
        this.f23556g = 2.1474836E9f;
    }

    @MainThread
    protected void w() {
        r(true);
    }

    @MainThread
    public void ws() {
        this.f23557j = true;
        i();
        this.f23559r = 0L;
        if (kt() && ae() == az()) {
            j(av());
        } else if (!kt() && ae() == av()) {
            j(az());
        }
        up();
    }

    public void xt(float f6) {
        j(this.tl, f6);
    }

    private float mi() {
        com.bytedance.adsdk.lottie.m mVar = this.oq;
        if (mVar == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / mVar.jy()) / Math.abs(this.xt);
    }

    private void tj() {
        if (this.oq == null) {
            return;
        }
        float f6 = this.f23558m;
        if (f6 < this.tl || f6 > this.f23556g) {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.tl), Float.valueOf(this.f23556g), Float.valueOf(this.f23558m)));
        }
    }

    public float ae() {
        return this.f23558m;
    }

    public float av() {
        com.bytedance.adsdk.lottie.m mVar = this.oq;
        if (mVar == null) {
            return 0.0f;
        }
        float f6 = this.f23556g;
        return f6 == 2.1474836E9f ? mVar.ae() : f6;
    }

    public float az() {
        com.bytedance.adsdk.lottie.m mVar = this.oq;
        if (mVar == null) {
            return 0.0f;
        }
        float f6 = this.tl;
        return f6 == -2.1474836E9f ? mVar.m() : f6;
    }

    public void cw(float f6) {
        this.xt = f6;
    }

    @Override // android.animation.ValueAnimator
    @FloatRange(from = 0.0d, to = 1.0d)
    public float getAnimatedFraction() {
        float az;
        float av;
        float az2;
        if (this.oq == null) {
            return 0.0f;
        }
        if (kt()) {
            az = av() - this.f23558m;
            av = av();
            az2 = az();
        } else {
            az = this.f23558m - az();
            av = av();
            az2 = az();
        }
        return az / (av - az2);
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        com.bytedance.adsdk.lottie.m mVar = this.oq;
        if (mVar == null) {
            return 0L;
        }
        return (long) mVar.up();
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.f23557j;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float m() {
        com.bytedance.adsdk.lottie.m mVar = this.oq;
        if (mVar == null) {
            return 0.0f;
        }
        return (this.f23558m - mVar.m()) / (this.oq.ae() - this.oq.m());
    }

    public float oq() {
        return this.xt;
    }

    @Override // com.bytedance.adsdk.lottie.up.j
    void xt() {
        super.xt();
        xt(kt());
    }

    private boolean kt() {
        if (oq() < 0.0f) {
            return true;
        }
        return false;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    @MainThread
    public void cancel() {
        xt();
        w();
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j6) {
        float az;
        float av;
        i();
        if (this.oq != null && isRunning()) {
            com.bytedance.adsdk.lottie.up.j("LottieValueAnimator#doFrame");
            long j7 = this.f23559r;
            long j8 = 0;
            if (j7 != 0) {
                j8 = j6 - j7;
            }
            float mi = j8 / mi();
            float f6 = this.up;
            if (kt()) {
                mi = -mi;
            }
            float f7 = f6 + mi;
            boolean cw = tl.cw(f7, az(), av());
            float f8 = this.up;
            float xt = tl.xt(f7, az(), av());
            this.up = xt;
            if (this.qv) {
                xt = (float) Math.floor(xt);
            }
            this.f23558m = xt;
            this.f23559r = j6;
            if (!this.qv || this.up != f8) {
                cw();
            }
            if (!cw) {
                if (getRepeatCount() != -1 && this.ae >= getRepeatCount()) {
                    if (this.xt < 0.0f) {
                        av = az();
                    } else {
                        av = av();
                    }
                    this.up = av;
                    this.f23558m = av;
                    w();
                    xt(kt());
                } else {
                    j();
                    this.ae++;
                    if (getRepeatMode() == 2) {
                        this.cw = !this.cw;
                        g();
                    } else {
                        if (kt()) {
                            az = av();
                        } else {
                            az = az();
                        }
                        this.up = az;
                        this.f23558m = az;
                    }
                    this.f23559r = j6;
                }
            }
            tj();
            com.bytedance.adsdk.lottie.up.xt("LottieValueAnimator#doFrame");
        }
    }

    public void g() {
        cw(-oq());
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(m());
    }

    protected void i() {
        if (isRunning()) {
            r(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    @MainThread
    public void jy() {
        w();
        r();
    }

    @MainThread
    protected void r(boolean z5) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z5) {
            this.f23557j = false;
        }
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i6) {
        super.setRepeatMode(i6);
        if (i6 != 2 && this.cw) {
            this.cw = false;
            g();
        }
    }

    @MainThread
    public void vl() {
        w();
        xt(kt());
    }

    public void j(float f6) {
        if (this.up == f6) {
            return;
        }
        float xt = tl.xt(f6, az(), av());
        this.up = xt;
        if (this.qv) {
            xt = (float) Math.floor(xt);
        }
        this.f23558m = xt;
        this.f23559r = 0L;
        cw();
    }

    public void j(int i6) {
        j(i6, (int) this.f23556g);
    }

    public void j(float f6, float f7) {
        if (f6 <= f7) {
            com.bytedance.adsdk.lottie.m mVar = this.oq;
            float m6 = mVar == null ? -3.4028235E38f : mVar.m();
            com.bytedance.adsdk.lottie.m mVar2 = this.oq;
            float ae = mVar2 == null ? Float.MAX_VALUE : mVar2.ae();
            float xt = tl.xt(f6, m6, ae);
            float xt2 = tl.xt(f7, m6, ae);
            if (xt == this.tl && xt2 == this.f23556g) {
                return;
            }
            this.tl = xt;
            this.f23556g = xt2;
            j((int) tl.xt(this.f23558m, xt, xt2));
            return;
        }
        throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f6), Float.valueOf(f7)));
    }
}
