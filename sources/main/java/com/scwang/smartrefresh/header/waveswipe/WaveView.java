package com.scwang.smartrefresh.header.waveswipe;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import androidx.annotation.ColorInt;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class WaveView extends View implements ViewTreeObserver.OnPreDrawListener {
    private static final int A = -1728053248;
    private static final float[][] B = {new float[]{0.1655f, 0.0f}, new float[]{0.4188f, -0.0109f}, new float[]{0.4606f, -0.0049f}, new float[]{0.4893f, 0.0f}, new float[]{0.4893f, 0.0f}, new float[]{0.5f, 0.0f}};
    private static final float[][] C = {new float[]{0.1655f, 0.0f}, new float[]{0.5237f, 0.0553f}, new float[]{0.4557f, 0.0936f}, new float[]{0.3908f, 0.1302f}, new float[]{0.4303f, 0.2173f}, new float[]{0.5f, 0.2173f}};
    private static final float[][] D = {new float[]{0.1655f, 0.0f}, new float[]{0.5909f, 0.0f}, new float[]{0.4557f, 0.1642f}, new float[]{0.3941f, 0.2061f}, new float[]{0.4303f, 0.2889f}, new float[]{0.5f, 0.2889f}};

    /* renamed from: u, reason: collision with root package name */
    private static final long f37214u = 500;

    /* renamed from: v, reason: collision with root package name */
    private static final long f37215v = 500;

    /* renamed from: w, reason: collision with root package name */
    private static final long f37216w = 500;

    /* renamed from: x, reason: collision with root package name */
    private static final int f37217x = 200;

    /* renamed from: y, reason: collision with root package name */
    private static final int f37218y = 1000;

    /* renamed from: z, reason: collision with root package name */
    private static final float f37219z = 0.2f;

    /* renamed from: a, reason: collision with root package name */
    private float f37220a;

    /* renamed from: b, reason: collision with root package name */
    private Paint f37221b;

    /* renamed from: c, reason: collision with root package name */
    private Path f37222c;

    /* renamed from: d, reason: collision with root package name */
    private Path f37223d;

    /* renamed from: e, reason: collision with root package name */
    private Path f37224e;

    /* renamed from: f, reason: collision with root package name */
    private Path f37225f;

    /* renamed from: g, reason: collision with root package name */
    private RectF f37226g;

    /* renamed from: h, reason: collision with root package name */
    private int f37227h;

    /* renamed from: i, reason: collision with root package name */
    private float f37228i;

    /* renamed from: j, reason: collision with root package name */
    private int f37229j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f37230k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f37231l;

    /* renamed from: m, reason: collision with root package name */
    private int f37232m;

    /* renamed from: n, reason: collision with root package name */
    private ValueAnimator f37233n;

    /* renamed from: o, reason: collision with root package name */
    private ValueAnimator f37234o;

    /* renamed from: p, reason: collision with root package name */
    private ValueAnimator f37235p;

    /* renamed from: q, reason: collision with root package name */
    private ValueAnimator f37236q;

    /* renamed from: r, reason: collision with root package name */
    private ValueAnimator f37237r;

    /* renamed from: s, reason: collision with root package name */
    private ValueAnimator f37238s;

    /* renamed from: t, reason: collision with root package name */
    private ValueAnimator.AnimatorUpdateListener f37239t;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            WaveView.this.postInvalidate();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            WaveView.this.f37228i = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            WaveView.this.postInvalidateOnAnimation();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements Animator.AnimatorListener {
        c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            WaveView.this.n();
            WaveView.this.f37230k = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            WaveView.this.f37222c.moveTo(0.0f, 0.0f);
            float f6 = floatValue * 0.5f;
            WaveView.this.f37222c.quadTo(WaveView.this.f37227h * 0.25f, 0.0f, WaveView.this.f37227h * 0.333f, f6);
            WaveView.this.f37222c.quadTo(WaveView.this.f37227h * 0.5f, floatValue * 1.4f, WaveView.this.f37227h * 0.666f, f6);
            WaveView.this.f37222c.quadTo(WaveView.this.f37227h * 0.75f, 0.0f, WaveView.this.f37227h, 0.0f);
            WaveView.this.postInvalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        this.f37233n = ValueAnimator.ofFloat(0.0f, 0.0f);
        this.f37234o = ValueAnimator.ofFloat(0.0f, 0.0f);
        this.f37235p = ValueAnimator.ofFloat(0.0f, 0.0f);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(-1000.0f, -1000.0f);
        this.f37236q = ofFloat;
        ofFloat.start();
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 1.0f);
        this.f37237r = ofFloat2;
        ofFloat2.setDuration(1L);
        this.f37237r.start();
    }

    public void s() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.f37237r = ofFloat;
        ofFloat.addUpdateListener(this.f37239t);
        this.f37237r.setDuration(200L);
        this.f37237r.addListener(new c());
        this.f37237r.start();
    }

    public void t() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.0f);
        this.f37237r = ofFloat;
        ofFloat.setDuration(1L);
        this.f37237r.start();
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat((this.f37227h / 1440.0f) * 500.0f, this.f37229j);
        this.f37236q = ofFloat2;
        ofFloat2.setDuration(500L);
        this.f37236q.addUpdateListener(new b());
        this.f37236q.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f37236q.start();
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(0.0f, this.f37229j - this.f37220a);
        this.f37233n = ofFloat3;
        ofFloat3.setDuration(500L);
        this.f37233n.addUpdateListener(this.f37239t);
        this.f37233n.start();
        ValueAnimator ofFloat4 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f37234o = ofFloat4;
        ofFloat4.setDuration(500L);
        this.f37234o.addUpdateListener(this.f37239t);
        this.f37234o.setInterpolator(new com.scwang.smartrefresh.header.waveswipe.b());
        this.f37234o.setStartDelay(500L);
        this.f37234o.start();
        ValueAnimator ofFloat5 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f37235p = ofFloat5;
        ofFloat5.setDuration(500L);
        this.f37235p.addUpdateListener(this.f37239t);
        this.f37235p.setInterpolator(new com.scwang.smartrefresh.header.waveswipe.b());
        this.f37235p.setStartDelay(625L);
        this.f37235p.start();
    }

    private void m() {
        ValueAnimator valueAnimator = this.f37238s;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.f37238s.cancel();
    }

    private void q() {
        this.f37222c = new Path();
        this.f37223d = new Path();
        this.f37224e = new Path();
        this.f37225f = new Path();
    }

    private void v(int i6) {
        float f6 = i6;
        if ((this.f37227h / 1440.0f) * 500.0f > f6) {
            return;
        }
        this.f37229j = (int) Math.min(f6, getHeight() - this.f37220a);
        if (this.f37230k) {
            this.f37230k = false;
            l();
        }
    }

    public void f() {
        if (this.f37237r.isRunning()) {
            return;
        }
        t();
        u(0.1f);
    }

    public void g(float f6, float f7) {
        m();
        this.f37222c.moveTo(0.0f, 0.0f);
        Path path = this.f37222c;
        int i6 = this.f37227h;
        float[][] fArr = C;
        float[] fArr2 = fArr[0];
        float f8 = i6 * fArr2[0];
        float f9 = i6 * fArr2[1];
        float[][] fArr3 = B;
        path.cubicTo(f8, f9, i6 * Math.min(fArr3[1][0] + f7, fArr[1][0]), this.f37227h * Math.max((fArr3[1][1] + f6) - f7, fArr[1][1]), this.f37227h * Math.max(fArr3[2][0] - f7, fArr[2][0]), this.f37227h * Math.max((fArr3[2][1] + f6) - f7, fArr[2][1]));
        Path path2 = this.f37222c;
        float max = this.f37227h * Math.max(fArr3[3][0] - f7, fArr[3][0]);
        float min = this.f37227h * Math.min(fArr3[3][1] + f6 + f7, fArr[3][1]);
        float max2 = this.f37227h * Math.max(fArr3[4][0] - f7, fArr[4][0]);
        float min2 = this.f37227h * Math.min(fArr3[4][1] + f6 + f7, fArr[4][1]);
        int i7 = this.f37227h;
        float[] fArr4 = fArr[5];
        path2.cubicTo(max, min, max2, min2, i7 * fArr4[0], i7 * Math.min(fArr3[0][1] + f6 + f7, fArr4[1]));
        Path path3 = this.f37222c;
        int i8 = this.f37227h;
        float max3 = i8 - (i8 * Math.max(fArr3[4][0] - f7, fArr[4][0]));
        float min3 = this.f37227h * Math.min(fArr3[4][1] + f6 + f7, fArr[4][1]);
        int i9 = this.f37227h;
        float max4 = i9 - (i9 * Math.max(fArr3[3][0] - f7, fArr[3][0]));
        float min4 = this.f37227h * Math.min(fArr3[3][1] + f6 + f7, fArr[3][1]);
        int i10 = this.f37227h;
        path3.cubicTo(max3, min3, max4, min4, i10 - (i10 * Math.max(fArr3[2][0] - f7, fArr[2][0])), this.f37227h * Math.max((fArr3[2][1] + f6) - f7, fArr[2][1]));
        Path path4 = this.f37222c;
        int i11 = this.f37227h;
        float min5 = i11 - (i11 * Math.min(fArr3[1][0] + f7, fArr[1][0]));
        float max5 = Math.max((fArr3[1][1] + f6) - f7, fArr[1][1]) * this.f37227h;
        int i12 = this.f37227h;
        float[] fArr5 = fArr[0];
        path4.cubicTo(min5, max5, i12 - (i12 * fArr5[0]), i12 * fArr5[1], i12, 0.0f);
        this.f37228i = (this.f37227h * Math.min(fArr3[3][1] + f6 + f7, fArr[3][1])) + this.f37220a;
        postInvalidateOnAnimation();
    }

    public float getCurrentCircleCenterY() {
        return this.f37228i;
    }

    public void h(float f6) {
        m();
        this.f37222c.moveTo(0.0f, 0.0f);
        Path path = this.f37222c;
        int i6 = this.f37227h;
        float[][] fArr = B;
        float[] fArr2 = fArr[0];
        float f7 = i6 * fArr2[0];
        float f8 = fArr2[1];
        float[] fArr3 = fArr[1];
        float f9 = i6 * fArr3[0];
        float f10 = i6 * (fArr3[1] + f6);
        float[] fArr4 = fArr[2];
        path.cubicTo(f7, f8, f9, f10, i6 * fArr4[0], i6 * (fArr4[1] + f6));
        Path path2 = this.f37222c;
        int i7 = this.f37227h;
        float[] fArr5 = fArr[3];
        float f11 = i7 * fArr5[0];
        float f12 = i7 * (fArr5[1] + f6);
        float[] fArr6 = fArr[4];
        float f13 = i7 * fArr6[0];
        float f14 = i7 * (fArr6[1] + f6);
        float[] fArr7 = fArr[5];
        path2.cubicTo(f11, f12, f13, f14, i7 * fArr7[0], i7 * (fArr7[1] + f6));
        Path path3 = this.f37222c;
        int i8 = this.f37227h;
        float[] fArr8 = fArr[4];
        float f15 = i8 - (i8 * fArr8[0]);
        float f16 = i8 * (fArr8[1] + f6);
        float[] fArr9 = fArr[3];
        float f17 = i8 - (i8 * fArr9[0]);
        float f18 = i8 * (fArr9[1] + f6);
        float[] fArr10 = fArr[2];
        path3.cubicTo(f15, f16, f17, f18, i8 - (i8 * fArr10[0]), i8 * (fArr10[1] + f6));
        Path path4 = this.f37222c;
        int i9 = this.f37227h;
        float[] fArr11 = fArr[1];
        float f19 = i9 - (i9 * fArr11[0]);
        float f20 = i9 * (fArr11[1] + f6);
        float[] fArr12 = fArr[0];
        path4.cubicTo(f19, f20, i9 - (i9 * fArr12[0]), fArr12[1], i9, 0.0f);
        postInvalidateOnAnimation();
    }

    public void i(float f6, float f7, float f8) {
        m();
        this.f37222c.moveTo(0.0f, 0.0f);
        Path path = this.f37222c;
        int i6 = this.f37227h;
        float[][] fArr = D;
        float[] fArr2 = fArr[0];
        float f9 = i6 * fArr2[0];
        float f10 = i6 * fArr2[1];
        float[][] fArr3 = B;
        float f11 = fArr3[1][0] + f7;
        float[][] fArr4 = C;
        path.cubicTo(f9, f10, i6 * Math.min(Math.min(f11, fArr4[1][0]) + f8, fArr[1][0]), this.f37227h * Math.max(Math.max((fArr3[1][1] + f6) - f7, fArr4[1][1]) - f8, fArr[1][1]), this.f37227h * Math.max(fArr3[2][0] - f7, fArr[2][0]), this.f37227h * Math.min(Math.max((fArr3[2][1] + f6) - f7, fArr4[2][1]) + f8, fArr[2][1]));
        Path path2 = this.f37222c;
        float min = this.f37227h * Math.min(Math.max(fArr3[3][0] - f7, fArr4[3][0]) + f8, fArr[3][0]);
        float min2 = this.f37227h * Math.min(Math.min(fArr3[3][1] + f6 + f7, fArr4[3][1]) + f8, fArr[3][1]);
        float max = this.f37227h * Math.max(fArr3[4][0] - f7, fArr[4][0]);
        float min3 = this.f37227h * Math.min(Math.min(fArr3[4][1] + f6 + f7, fArr4[4][1]) + f8, fArr[4][1]);
        int i7 = this.f37227h;
        path2.cubicTo(min, min2, max, min3, i7 * fArr[5][0], i7 * Math.min(Math.min(fArr3[0][1] + f6 + f7, fArr4[5][1]) + f8, fArr[5][1]));
        Path path3 = this.f37222c;
        int i8 = this.f37227h;
        float max2 = i8 - (i8 * Math.max(fArr3[4][0] - f7, fArr[4][0]));
        float min4 = this.f37227h * Math.min(Math.min(fArr3[4][1] + f6 + f7, fArr4[4][1]) + f8, fArr[4][1]);
        int i9 = this.f37227h;
        float min5 = i9 - (i9 * Math.min(Math.max(fArr3[3][0] - f7, fArr4[3][0]) + f8, fArr[3][0]));
        float min6 = this.f37227h * Math.min(Math.min(fArr3[3][1] + f6 + f7, fArr4[3][1]) + f8, fArr[3][1]);
        int i10 = this.f37227h;
        path3.cubicTo(max2, min4, min5, min6, i10 - (i10 * Math.max(fArr3[2][0] - f7, fArr[2][0])), this.f37227h * Math.min(Math.max((fArr3[2][1] + f6) - f7, fArr4[2][1]) + f8, fArr[2][1]));
        Path path4 = this.f37222c;
        int i11 = this.f37227h;
        float min7 = i11 - (i11 * Math.min(Math.min(fArr3[1][0] + f7, fArr4[1][0]) + f8, fArr[1][0]));
        float max3 = this.f37227h * Math.max(Math.max((fArr3[1][1] + f6) - f7, fArr4[1][1]) - f8, fArr[1][1]);
        int i12 = this.f37227h;
        float[] fArr5 = fArr[0];
        path4.cubicTo(min7, max3, i12 - (i12 * fArr5[0]), i12 * fArr5[1], i12, 0.0f);
        this.f37228i = (this.f37227h * Math.min(Math.min(fArr3[3][1] + f6 + f7, fArr4[3][1]) + f8, fArr[3][1])) + this.f37220a;
        postInvalidateOnAnimation();
    }

    public boolean k() {
        return this.f37237r.isRunning();
    }

    public void l() {
        if (this.f37230k) {
            return;
        }
        this.f37230k = true;
        int i6 = this.f37229j;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(i6, i6);
        this.f37236q = ofFloat;
        ofFloat.start();
        int i7 = this.f37229j;
        float f6 = this.f37220a;
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(i7 - f6, i7 - f6);
        this.f37233n = ofFloat2;
        ofFloat2.start();
        this.f37228i = this.f37229j;
        postInvalidate();
    }

    public void o(int i6, int i7) {
        this.f37221b.setShadowLayer(i6, 0.0f, 0.0f, i7);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        ValueAnimator valueAnimator = this.f37237r;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.f37237r.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator2 = this.f37236q;
        if (valueAnimator2 != null) {
            valueAnimator2.end();
            this.f37236q.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator3 = this.f37233n;
        if (valueAnimator3 != null) {
            valueAnimator3.end();
            this.f37233n.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator4 = this.f37238s;
        if (valueAnimator4 != null) {
            valueAnimator4.end();
            this.f37238s.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator5 = this.f37235p;
        if (valueAnimator5 != null) {
            valueAnimator5.end();
            this.f37235p.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator6 = this.f37234o;
        if (valueAnimator6 != null) {
            valueAnimator6.end();
            this.f37234o.removeAllUpdateListeners();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i6, int i7, int i8, int i9) {
        this.f37227h = i6;
        this.f37220a = i6 / 14.4f;
        v((int) Math.min(Math.min(i6, i7), getHeight() - this.f37220a));
        super.onSizeChanged(i6, i7, i8, i9);
    }

    public void r(int i6, int i7, int i8, int i9) {
        this.f37221b.setARGB(i6, i7, i8, i9);
        invalidate();
    }

    public void setMaxDropHeight(int i6) {
        if (this.f37231l) {
            v(i6);
            return;
        }
        this.f37232m = i6;
        this.f37231l = true;
        if (getViewTreeObserver().isAlive()) {
            getViewTreeObserver().removeOnPreDrawListener(this);
            getViewTreeObserver().addOnPreDrawListener(this);
        }
    }

    public void setShadowRadius(int i6) {
        this.f37221b.setShadowLayer(i6, 0.0f, 0.0f, -1728053248);
    }

    public void setWaveColor(@ColorInt int i6) {
        this.f37221b.setColor(i6);
        invalidate();
    }

    public WaveView(Context context) {
        super(context);
        this.f37220a = 100.0f;
        this.f37230k = false;
        this.f37231l = false;
        this.f37239t = new a();
        getViewTreeObserver().addOnPreDrawListener(this);
        j();
    }

    private void j() {
        p();
        q();
        n();
        this.f37226g = new RectF();
        setLayerType(1, null);
    }

    private void p() {
        float f6 = getResources().getDisplayMetrics().density;
        Paint paint = new Paint();
        this.f37221b = paint;
        paint.setColor(-14575885);
        this.f37221b.setAntiAlias(true);
        this.f37221b.setStyle(Paint.Style.FILL);
        this.f37221b.setShadowLayer((int) ((f6 * 2.0f) + 0.5f), 0.0f, 0.0f, -1728053248);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.f37222c, this.f37221b);
        if (!isInEditMode()) {
            this.f37222c.rewind();
            this.f37223d.rewind();
            this.f37224e.rewind();
        }
        float floatValue = ((Float) this.f37236q.getAnimatedValue()).floatValue();
        float f6 = this.f37227h / 2.0f;
        this.f37226g.setEmpty();
        float floatValue2 = ((Float) this.f37237r.getAnimatedValue()).floatValue();
        float floatValue3 = ((Float) this.f37234o.getAnimatedValue()).floatValue();
        float floatValue4 = ((Float) this.f37235p.getAnimatedValue()).floatValue();
        RectF rectF = this.f37226g;
        float f7 = this.f37220a;
        float f8 = floatValue3 + 1.0f;
        float f9 = 1.0f + floatValue4;
        rectF.set((f6 - ((f7 * f8) * floatValue2)) + ((f7 * floatValue4) / 2.0f), (((f7 * f9) * floatValue2) + floatValue) - ((f7 * floatValue3) / 2.0f), (((f8 * f7) * floatValue2) + f6) - ((floatValue4 * f7) / 2.0f), (floatValue - ((f9 * f7) * floatValue2)) + ((f7 * floatValue3) / 2.0f));
        this.f37223d.moveTo(f6, ((Float) this.f37233n.getAnimatedValue()).floatValue());
        double d6 = floatValue;
        double pow = ((Math.pow(this.f37220a, 2.0d) + (floatValue * r2)) - Math.pow(d6, 2.0d)) / (r2 - floatValue);
        double d7 = (this.f37227h * (-2.0d)) / 2.0d;
        double d8 = -d7;
        double pow2 = (d7 * d7) - (((Math.pow(pow - d6, 2.0d) + Math.pow(f6, 2.0d)) - Math.pow(this.f37220a, 2.0d)) * 4.0d);
        double sqrt = (Math.sqrt(pow2) + d8) / 2.0d;
        double sqrt2 = (d8 - Math.sqrt(pow2)) / 2.0d;
        float f10 = (float) pow;
        this.f37223d.lineTo((float) sqrt, f10);
        this.f37223d.lineTo((float) sqrt2, f10);
        this.f37223d.close();
        this.f37225f.set(this.f37223d);
        Path path = this.f37225f;
        RectF rectF2 = this.f37226g;
        Path.Direction direction = Path.Direction.CCW;
        path.addOval(rectF2, direction);
        this.f37224e.addOval(this.f37226g, direction);
        this.f37233n.isRunning();
        canvas.drawPath(this.f37223d, this.f37221b);
        canvas.drawPath(this.f37224e, this.f37221b);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        getViewTreeObserver().removeOnPreDrawListener(this);
        if (this.f37231l) {
            v(this.f37232m);
            return false;
        }
        return false;
    }

    @Override // android.view.View
    public void postInvalidateOnAnimation() {
        super.postInvalidateOnAnimation();
    }

    public void u(float f6) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(Math.min(f6, 0.2f) * this.f37227h, 0.0f);
        this.f37238s = ofFloat;
        ofFloat.setDuration(1000L);
        this.f37238s.addUpdateListener(new d());
        this.f37238s.setInterpolator(new BounceInterpolator());
        this.f37238s.start();
    }
}
