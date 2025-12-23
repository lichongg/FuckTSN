package com.bytedance.sdk.openadsdk.core.ugeno.component.skip;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.LinearInterpolator;

/* loaded from: D:\Downloads\app\classes4.dex */
public class CycleSkipView extends View {
    protected boolean ae;
    private AnimatorSet av;
    private float az;
    protected int cw;

    /* renamed from: f, reason: collision with root package name */
    private float f30645f;

    /* renamed from: g, reason: collision with root package name */
    protected float f30646g;

    /* renamed from: i, reason: collision with root package name */
    private ValueAnimator f30647i;

    /* renamed from: j, reason: collision with root package name */
    protected int f30648j;
    private Paint jy;
    private boolean kt;

    /* renamed from: m, reason: collision with root package name */
    protected int f30649m;
    private ValueAnimator mi;
    protected int oq;
    protected boolean qv;

    /* renamed from: r, reason: collision with root package name */
    protected float f30650r;
    private final RectF tj;
    protected float tl;
    protected float up;
    private Paint vl;

    /* renamed from: w, reason: collision with root package name */
    private ValueAnimator f30651w;
    private Paint ws;
    protected int xt;

    private void xt() {
        Paint paint = new Paint(1);
        this.vl = paint;
        paint.setColor(this.f30648j);
        this.vl.setStrokeWidth(this.f30650r);
        this.vl.setAntiAlias(true);
        this.vl.setStrokeCap(Paint.Cap.ROUND);
        this.vl.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint(1);
        this.jy = paint2;
        paint2.setColor(this.xt);
        this.jy.setAntiAlias(true);
        this.jy.setStrokeWidth(this.f30650r);
        this.jy.setStyle(Paint.Style.FILL);
        Paint paint3 = new Paint(1);
        this.ws = paint3;
        paint3.setColor(this.cw);
        this.ws.setTextAlign(Paint.Align.CENTER);
    }

    private int cw() {
        return (int) ((((this.f30650r / 2.0f) + this.up) * 2.0f) + j(4.0f));
    }

    private ValueAnimator getArcAnim() {
        ValueAnimator valueAnimator = this.f30651w;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f30651w = null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.az, this.f30645f);
        this.f30651w = ofFloat;
        ofFloat.setInterpolator(new LinearInterpolator());
        this.f30651w.setDuration(1000L);
        this.f30651w.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.skip.CycleSkipView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                CycleSkipView.this.az = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                CycleSkipView.this.postInvalidate();
            }
        });
        return this.f30651w;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        try {
            AnimatorSet animatorSet = this.av;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.av = null;
            }
            ValueAnimator valueAnimator = this.mi;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.mi = null;
            }
            ValueAnimator valueAnimator2 = this.f30647i;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
                this.f30647i = null;
            }
            ValueAnimator valueAnimator3 = this.f30651w;
            if (valueAnimator3 != null) {
                valueAnimator3.cancel();
                this.f30651w = null;
            }
            this.az = 1.0f;
            invalidate();
        } catch (Exception unused) {
        }
        super.onDetachedFromWindow();
    }

    public CycleSkipView(Context context) {
        super(context);
        this.f30648j = Color.parseColor("#f9e8b9");
        this.xt = Color.parseColor("#ffffff");
        this.cw = Color.parseColor("#7b7b7b");
        this.f30649m = 270;
        this.ae = false;
        this.tl = 5.0f;
        this.f30646g = 0.0f;
        this.oq = 0;
        this.qv = true;
        this.az = 0.0f;
        this.kt = false;
        this.tj = new RectF();
        this.f30645f = 1.0f;
        this.f30650r = j(2.0f);
        this.up = j(10.0f);
        this.f30649m %= 360;
        xt();
        setBackgroundColor(-16711681);
    }

    private int getMinLine() {
        return Math.min(getMeasuredHeight(), getMeasuredWidth());
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f);
        xt(canvas);
        j(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        super.onMeasure(i6, i7);
        int size = View.MeasureSpec.getSize(i6);
        int mode = View.MeasureSpec.getMode(i6);
        int size2 = View.MeasureSpec.getSize(i7);
        int mode2 = View.MeasureSpec.getMode(i7);
        if (mode != 1073741824) {
            size = cw();
        }
        if (mode2 != 1073741824) {
            size2 = cw();
        }
        xt(size, size2);
        setMeasuredDimension(size, size2);
        RectF rectF = this.tj;
        float f6 = this.up;
        rectF.left = -f6;
        rectF.right = f6;
        rectF.top = -f6;
        rectF.bottom = f6;
        this.ws.setTextSize(getMinLine() / 3.0f);
    }

    private void j(Canvas canvas) {
        canvas.save();
        Paint.FontMetrics fontMetrics = this.ws.getFontMetrics();
        canvas.drawText("跳过", 0.0f, (getMinLine() / 3.0f) - ((fontMetrics.bottom - fontMetrics.top) / 2.0f), this.ws);
        canvas.restore();
    }

    private float j(float f6) {
        return TypedValue.applyDimension(1, f6, getResources().getDisplayMetrics());
    }

    public void j() {
        AnimatorSet animatorSet = this.av;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.av.cancel();
            this.av = null;
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.av = animatorSet2;
        animatorSet2.playTogether(getArcAnim());
        this.av.setInterpolator(new LinearInterpolator());
        this.av.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.skip.CycleSkipView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                CycleSkipView.this.kt = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (CycleSkipView.this.kt) {
                    CycleSkipView.this.kt = false;
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        this.av.start();
    }

    private void xt(int i6, int i7) {
        this.up = (Math.min(i6, i7) / 2.0f) - this.f30650r;
    }

    private void xt(Canvas canvas) {
        float f6;
        float max;
        float f7;
        canvas.save();
        float f8 = this.az * 360.0f;
        if (this.ae) {
            if (this.qv) {
                f6 = this.f30649m;
                f8 = -f8;
            } else {
                f6 = this.f30649m - f8;
            }
        } else {
            if (this.qv) {
                float f9 = this.f30649m + 360;
                max = Math.max(0.0f, 360.0f - f8);
                f7 = f9;
                canvas.drawCircle(0.0f, 0.0f, this.up, this.jy);
                canvas.drawArc(this.tj, f7, max, false, this.vl);
                canvas.restore();
            }
            f6 = this.f30649m;
        }
        max = f8;
        f7 = f6;
        canvas.drawCircle(0.0f, 0.0f, this.up, this.jy);
        canvas.drawArc(this.tj, f7, max, false, this.vl);
        canvas.restore();
    }

    public void j(int i6, int i7) {
        if (i6 == 0) {
            return;
        }
        float f6 = i6;
        this.tl = f6;
        float f7 = i7;
        this.f30646g = f7;
        this.oq = i6 - i7;
        this.f30645f = f7 / f6;
        j();
    }
}
