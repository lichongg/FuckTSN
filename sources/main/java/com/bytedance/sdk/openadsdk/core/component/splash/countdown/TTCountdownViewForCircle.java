package com.bytedance.sdk.openadsdk.core.component.splash.countdown;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.bytedance.sdk.openadsdk.core.v;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\Downloads\app\classes4.dex */
public class TTCountdownViewForCircle extends View implements r {

    /* renamed from: a, reason: collision with root package name */
    private ValueAnimator f28611a;
    private float ae;
    private Paint av;
    private boolean az;
    private ValueAnimator ch;
    private int cw;

    /* renamed from: f, reason: collision with root package name */
    private RectF f28612f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f28613g;

    /* renamed from: i, reason: collision with root package name */
    private Paint f28614i;

    /* renamed from: j, reason: collision with root package name */
    private int f28615j;
    private String jy;
    private float kt;

    /* renamed from: l, reason: collision with root package name */
    private boolean f28616l;

    /* renamed from: m, reason: collision with root package name */
    private float f28617m;
    private Paint mi;
    private float oq;

    /* renamed from: p, reason: collision with root package name */
    private AtomicBoolean f28618p;
    private float qv;

    /* renamed from: r, reason: collision with root package name */
    private int f28619r;

    /* renamed from: s, reason: collision with root package name */
    private ValueAnimator f28620s;
    private float tj;
    private int tl;
    private float up;

    /* renamed from: v, reason: collision with root package name */
    private j f28621v;
    private float vl;

    /* renamed from: w, reason: collision with root package name */
    private Paint f28622w;
    private boolean ws;

    /* renamed from: x, reason: collision with root package name */
    private AnimatorSet f28623x;
    private int xt;

    public TTCountdownViewForCircle(Context context) {
        this(context, null);
    }

    public float j(float f6, float f7) {
        return f6 * f7;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.r
    public void setCountDownTime(int i6) {
        float f6 = i6;
        this.qv = f6;
        this.oq = f6;
        ae();
    }

    public TTCountdownViewForCircle(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void ae() {
        try {
            AnimatorSet animatorSet = this.f28623x;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.f28623x = null;
            }
            ValueAnimator valueAnimator = this.f28611a;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.f28611a = null;
            }
            ValueAnimator valueAnimator2 = this.ch;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
                this.ch = null;
            }
            ValueAnimator valueAnimator3 = this.f28620s;
            if (valueAnimator3 != null) {
                valueAnimator3.cancel();
                this.f28620s = null;
            }
            this.kt = 1.0f;
            this.tj = 1.0f;
            invalidate();
        } catch (Exception unused) {
        }
    }

    private ValueAnimator getArcAnim() {
        ValueAnimator valueAnimator = this.f28620s;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f28620s = null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.kt, 0.0f);
        this.f28620s = ofFloat;
        ofFloat.setInterpolator(new LinearInterpolator());
        this.f28620s.setDuration((long) (j(this.kt, this.oq) * 1000.0f));
        this.f28620s.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.countdown.TTCountdownViewForCircle.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                TTCountdownViewForCircle.this.kt = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                TTCountdownViewForCircle.this.invalidate();
            }
        });
        return this.f28620s;
    }

    private ValueAnimator getNumAnim() {
        ValueAnimator valueAnimator = this.ch;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.ch = null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.tj, 0.0f);
        this.ch = ofFloat;
        ofFloat.setInterpolator(new LinearInterpolator());
        this.ch.setDuration((long) (j(this.tj, this.qv) * 1000.0f));
        this.ch.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.countdown.TTCountdownViewForCircle.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                TTCountdownViewForCircle.this.tj = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                TTCountdownViewForCircle.this.invalidate();
            }
        });
        return this.ch;
    }

    private int m() {
        return (int) ((((this.up / 2.0f) + this.ae) * 2.0f) + j(4.0f));
    }

    private void r() {
        Paint paint = new Paint(1);
        this.av = paint;
        paint.setColor(this.f28615j);
        this.av.setStrokeWidth(this.up);
        this.av.setAntiAlias(true);
        Paint paint2 = this.av;
        Paint.Style style = Paint.Style.STROKE;
        paint2.setStyle(style);
        Paint paint3 = new Paint(1);
        this.f28614i = paint3;
        paint3.setColor(this.cw);
        this.f28614i.setAntiAlias(true);
        this.f28614i.setStrokeWidth(this.up);
        this.f28614i.setStyle(Paint.Style.FILL);
        Paint paint4 = new Paint(1);
        this.f28622w = paint4;
        paint4.setColor(this.xt);
        this.f28622w.setAntiAlias(true);
        this.f28622w.setStrokeWidth(this.up / 2.0f);
        this.f28622w.setStyle(style);
        Paint paint5 = new Paint(1);
        this.mi = paint5;
        paint5.setColor(this.f28619r);
        this.f28622w.setAntiAlias(true);
        this.mi.setTextSize(this.f28617m);
        this.mi.setTextAlign(Paint.Align.CENTER);
    }

    private void up() {
        float f6 = this.ae;
        this.f28612f = new RectF(-f6, -f6, f6, f6);
    }

    public void cw() {
        AnimatorSet animatorSet;
        try {
            if (this.az || (animatorSet = this.f28623x) == null) {
                return;
            }
            animatorSet.resume();
        } catch (Throwable unused) {
        }
    }

    public j getCountdownListener() {
        return this.f28621v;
    }

    public float j(float f6, int i6) {
        return i6 * f6;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.r
    public void setCountdownListener(j jVar) {
        this.f28621v = jVar;
        this.f28618p.get();
    }

    public TTCountdownViewForCircle(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f28615j = Color.parseColor("#fce8b6");
        this.xt = Color.parseColor("#f0f0f0");
        this.cw = Color.parseColor("#ffffff");
        this.f28619r = Color.parseColor("#7c7c7c");
        this.up = 2.0f;
        this.f28617m = 12.0f;
        this.ae = 18.0f;
        this.tl = 270;
        this.f28613g = false;
        this.oq = 5.0f;
        this.qv = 5.0f;
        this.vl = 0.8f;
        this.jy = "跳过";
        this.ws = false;
        this.az = false;
        this.kt = 1.0f;
        this.tj = 1.0f;
        this.f28616l = false;
        this.f28618p = new AtomicBoolean(true);
        this.up = j(2.0f);
        this.ae = j(18.0f);
        this.f28617m = xt(12.0f);
        this.tl %= 360;
        r();
        up();
    }

    private void xt(Canvas canvas) {
        float f6;
        canvas.save();
        float j6 = j(this.kt, 360);
        if (this.f28613g) {
            f6 = this.tl - j6;
        } else {
            f6 = this.tl;
        }
        float f7 = f6;
        canvas.drawCircle(0.0f, 0.0f, this.ae, this.f28614i);
        canvas.drawCircle(0.0f, 0.0f, this.ae, this.f28622w);
        canvas.drawArc(this.f28612f, f7, j6, false, this.av);
        canvas.restore();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        ae();
        super.onDetachedFromWindow();
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
            size = m();
        }
        if (mode2 != 1073741824) {
            size2 = m();
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z5) {
        super.onWindowFocusChanged(z5);
        this.f28618p.set(z5);
        if (this.az) {
            return;
        }
        if (!this.f28618p.get()) {
            xt();
        } else {
            cw();
        }
    }

    private void j(Canvas canvas) {
        canvas.save();
        Paint.FontMetrics fontMetrics = this.mi.getFontMetrics();
        String t5 = v.xt().t();
        this.jy = t5;
        if (TextUtils.isEmpty(t5)) {
            this.jy = "跳过";
        }
        canvas.drawText(this.jy, 0.0f, 0.0f - ((fontMetrics.ascent + fontMetrics.descent) / 2.0f), this.mi);
        canvas.restore();
    }

    private float xt(float f6) {
        return TypedValue.applyDimension(2, f6, getResources().getDisplayMetrics());
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.r
    public void j() {
        if (this.az) {
            return;
        }
        AnimatorSet animatorSet = this.f28623x;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.f28623x.cancel();
            this.f28623x = null;
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.f28623x = animatorSet2;
        animatorSet2.playTogether(getNumAnim(), getArcAnim());
        this.f28623x.setInterpolator(new LinearInterpolator());
        this.f28623x.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.countdown.TTCountdownViewForCircle.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                TTCountdownViewForCircle.this.f28616l = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (TTCountdownViewForCircle.this.f28616l) {
                    TTCountdownViewForCircle.this.f28616l = false;
                } else if (TTCountdownViewForCircle.this.f28621v != null) {
                    TTCountdownViewForCircle.this.f28621v.j();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        try {
            Field declaredField = ValueAnimator.class.getDeclaredField("sDurationScale");
            declaredField.setAccessible(true);
            if (declaredField.getFloat(null) < 1.0f) {
                declaredField.setFloat(null, 1.0f);
            }
        } catch (Throwable unused) {
        }
        this.f28623x.start();
        if (this.f28618p.get()) {
            return;
        }
        xt();
    }

    public void xt() {
        try {
            AnimatorSet animatorSet = this.f28623x;
            if (animatorSet != null) {
                animatorSet.pause();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.r
    public View getView() {
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.r
    public void j(boolean z5) {
        this.az = z5;
        if (z5) {
            ae();
        }
    }

    private float j(float f6) {
        return TypedValue.applyDimension(1, f6, getResources().getDisplayMetrics());
    }
}
