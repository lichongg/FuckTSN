package com.scwang.smartrefresh.header;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.util.c;
import m2.e;
import m2.g;
import m2.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class BezierCircleHeader extends View implements e {

    /* renamed from: r, reason: collision with root package name */
    private static final int f36846r = 800;

    /* renamed from: s, reason: collision with root package name */
    private static final int f36847s = 270;

    /* renamed from: a, reason: collision with root package name */
    private Path f36848a;

    /* renamed from: b, reason: collision with root package name */
    private Paint f36849b;

    /* renamed from: c, reason: collision with root package name */
    private Paint f36850c;

    /* renamed from: d, reason: collision with root package name */
    private Paint f36851d;

    /* renamed from: e, reason: collision with root package name */
    private float f36852e;

    /* renamed from: f, reason: collision with root package name */
    private float f36853f;

    /* renamed from: g, reason: collision with root package name */
    private float f36854g;

    /* renamed from: h, reason: collision with root package name */
    private float f36855h;

    /* renamed from: i, reason: collision with root package name */
    private RefreshState f36856i;

    /* renamed from: j, reason: collision with root package name */
    private float f36857j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f36858k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f36859l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f36860m;

    /* renamed from: n, reason: collision with root package name */
    private float f36861n;

    /* renamed from: o, reason: collision with root package name */
    private int f36862o;

    /* renamed from: p, reason: collision with root package name */
    private int f36863p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f36864q;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b, reason: collision with root package name */
        float f36866b;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ float f36869e;

        /* renamed from: a, reason: collision with root package name */
        float f36865a = 0.0f;

        /* renamed from: c, reason: collision with root package name */
        float f36867c = 0.0f;

        /* renamed from: d, reason: collision with root package name */
        int f36868d = 0;

        a(float f6) {
            this.f36869e = f6;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (this.f36868d == 0 && floatValue <= 0.0f) {
                this.f36868d = 1;
                this.f36865a = Math.abs(floatValue - BezierCircleHeader.this.f36852e);
            }
            if (this.f36868d == 1) {
                float f6 = (-floatValue) / this.f36869e;
                this.f36867c = f6;
                if (f6 >= BezierCircleHeader.this.f36854g) {
                    BezierCircleHeader.this.f36854g = this.f36867c;
                    BezierCircleHeader bezierCircleHeader = BezierCircleHeader.this;
                    bezierCircleHeader.f36857j = bezierCircleHeader.f36853f + floatValue;
                    this.f36865a = Math.abs(floatValue - BezierCircleHeader.this.f36852e);
                } else {
                    this.f36868d = 2;
                    BezierCircleHeader.this.f36854g = 0.0f;
                    BezierCircleHeader.this.f36858k = true;
                    BezierCircleHeader.this.f36859l = true;
                    this.f36866b = BezierCircleHeader.this.f36857j;
                }
            }
            if (this.f36868d == 2 && BezierCircleHeader.this.f36857j > BezierCircleHeader.this.f36853f / 2.0f) {
                BezierCircleHeader bezierCircleHeader2 = BezierCircleHeader.this;
                bezierCircleHeader2.f36857j = Math.max(bezierCircleHeader2.f36853f / 2.0f, BezierCircleHeader.this.f36857j - this.f36865a);
                float animatedFraction = valueAnimator.getAnimatedFraction();
                float f7 = BezierCircleHeader.this.f36853f / 2.0f;
                float f8 = this.f36866b;
                float f9 = (animatedFraction * (f7 - f8)) + f8;
                if (BezierCircleHeader.this.f36857j > f9) {
                    BezierCircleHeader.this.f36857j = f9;
                }
            }
            if (BezierCircleHeader.this.f36859l && floatValue < BezierCircleHeader.this.f36852e) {
                BezierCircleHeader.this.f36860m = true;
                BezierCircleHeader.this.f36859l = false;
                BezierCircleHeader.this.f36864q = true;
                BezierCircleHeader.this.f36863p = 90;
                BezierCircleHeader.this.f36862o = 90;
            }
            BezierCircleHeader.this.f36852e = floatValue;
            BezierCircleHeader.this.invalidate();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            BezierCircleHeader.this.f36855h = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            BezierCircleHeader.this.invalidate();
        }
    }

    public BezierCircleHeader(Context context) {
        super(context, null, 0);
        this.f36862o = 90;
        this.f36863p = 90;
        this.f36864q = true;
        S(context, null);
    }

    @Override // m2.f
    public int d(h hVar, boolean z5) {
        this.f36860m = false;
        this.f36858k = false;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new b());
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setDuration(800L);
        ofFloat.start();
        return 800;
    }

    @Override // m2.f
    public boolean j() {
        return false;
    }

    @Override // m2.f
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        if (iArr.length > 0) {
            this.f36849b.setColor(iArr[0]);
            if (iArr.length > 1) {
                this.f36850c.setColor(iArr[1]);
                this.f36851d.setColor(iArr[1]);
            }
        }
    }

    @Override // m2.e
    public void w(h hVar, int i6, int i7) {
        this.f36853f = i6;
        this.f36861n = i6 / 6;
        DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
        float min = Math.min(this.f36852e * 0.8f, this.f36853f / 2.0f);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.f36852e, 0.0f, -(1.0f * min), 0.0f, -(0.4f * min), 0.0f);
        ofFloat.addUpdateListener(new a(min));
        ofFloat.setInterpolator(decelerateInterpolator);
        ofFloat.setDuration(1000L);
        ofFloat.start();
    }

    @Override // m2.e
    public void y(float f6, int i6, int i7, int i8) {
        this.f36853f = i7;
        this.f36852e = Math.max(i6 - i7, 0) * 0.8f;
    }

    private void M(Canvas canvas, int i6) {
        if (this.f36858k) {
            canvas.drawCircle(i6 / 2, this.f36857j, this.f36861n, this.f36850c);
            float f6 = this.f36853f;
            N(canvas, i6, (this.f36852e + f6) / f6);
        }
    }

    private void N(Canvas canvas, int i6, float f6) {
        if (this.f36859l) {
            float f7 = this.f36853f + this.f36852e;
            float f8 = this.f36857j + ((this.f36861n * f6) / 2.0f);
            float f9 = i6 / 2;
            float sqrt = ((float) Math.sqrt(r2 * r2 * (1.0f - ((f6 * f6) / 4.0f)))) + f9;
            float f10 = this.f36861n;
            float f11 = f9 + (((3.0f * f10) / 4.0f) * (1.0f - f6));
            float f12 = f10 + f11;
            this.f36848a.reset();
            this.f36848a.moveTo(sqrt, f8);
            this.f36848a.quadTo(f11, f7, f12, f7);
            float f13 = i6;
            this.f36848a.lineTo(f13 - f12, f7);
            this.f36848a.quadTo(f13 - f11, f7, f13 - sqrt, f8);
            canvas.drawPath(this.f36848a, this.f36850c);
        }
    }

    private void O(Canvas canvas, int i6) {
        if (this.f36855h > 0.0f) {
            int color = this.f36851d.getColor();
            if (this.f36855h < 0.3d) {
                canvas.drawCircle(i6 / 2, this.f36857j, this.f36861n, this.f36850c);
                float f6 = this.f36861n;
                float strokeWidth = this.f36851d.getStrokeWidth() * 2.0f;
                float f7 = this.f36855h;
                this.f36851d.setColor(Color.argb((int) ((1.0f - (f7 / 0.3f)) * 255.0f), Color.red(color), Color.green(color), Color.blue(color)));
                float f8 = this.f36857j;
                float f9 = (int) (f6 + (strokeWidth * ((f7 / 0.3f) + 1.0f)));
                canvas.drawArc(new RectF(r2 - r3, f8 - f9, r3 + r2, f8 + f9), 0.0f, 360.0f, false, this.f36851d);
            }
            this.f36851d.setColor(color);
            float f10 = this.f36855h;
            if (f10 >= 0.3d && f10 < 0.7d) {
                float f11 = (f10 - 0.3f) / 0.4f;
                float f12 = this.f36853f;
                float f13 = (int) ((f12 / 2.0f) + ((f12 - (f12 / 2.0f)) * f11));
                this.f36857j = f13;
                canvas.drawCircle(i6 / 2, f13, this.f36861n, this.f36850c);
                if (this.f36857j >= this.f36853f - (this.f36861n * 2.0f)) {
                    this.f36859l = true;
                    N(canvas, i6, f11);
                }
                this.f36859l = false;
            }
            float f14 = this.f36855h;
            if (f14 < 0.7d || f14 > 1.0f) {
                return;
            }
            float f15 = (f14 - 0.7f) / 0.3f;
            float f16 = i6 / 2;
            float f17 = this.f36861n;
            this.f36848a.reset();
            this.f36848a.moveTo((int) ((f16 - f17) - ((f17 * 2.0f) * f15)), this.f36853f);
            Path path = this.f36848a;
            float f18 = this.f36853f;
            path.quadTo(f16, f18 - (this.f36861n * (1.0f - f15)), i6 - r4, f18);
            canvas.drawPath(this.f36848a, this.f36850c);
        }
    }

    private void P(Canvas canvas, int i6) {
        if (this.f36860m) {
            float strokeWidth = this.f36861n + (this.f36851d.getStrokeWidth() * 2.0f);
            int i7 = this.f36863p;
            boolean z5 = this.f36864q;
            int i8 = i7 + (z5 ? 3 : 10);
            this.f36863p = i8;
            int i9 = this.f36862o;
            int i10 = z5 ? 10 : 3;
            int i11 = i8 % 360;
            this.f36863p = i11;
            int i12 = (i9 + i10) % 360;
            this.f36862o = i12;
            int i13 = i12 - i11;
            if (i13 < 0) {
                i13 += 360;
            }
            float f6 = i6 / 2;
            float f7 = this.f36857j;
            canvas.drawArc(new RectF(f6 - strokeWidth, f7 - strokeWidth, f6 + strokeWidth, f7 + strokeWidth), this.f36863p, i13, false, this.f36851d);
            if (i13 >= 270) {
                this.f36864q = false;
            } else if (i13 <= 10) {
                this.f36864q = true;
            }
            invalidate();
        }
    }

    private void Q(Canvas canvas, int i6) {
        float f6 = this.f36854g;
        if (f6 > 0.0f) {
            float f7 = i6 / 2;
            float f8 = this.f36861n;
            float f9 = (f7 - (4.0f * f8)) + (3.0f * f6 * f8);
            if (f6 >= 0.9d) {
                canvas.drawCircle(f7, this.f36857j, f8, this.f36850c);
                return;
            }
            this.f36848a.reset();
            this.f36848a.moveTo(f9, this.f36857j);
            Path path = this.f36848a;
            float f10 = this.f36857j;
            path.quadTo(f7, f10 - ((this.f36861n * this.f36854g) * 2.0f), i6 - f9, f10);
            canvas.drawPath(this.f36848a, this.f36850c);
        }
    }

    private void R(Canvas canvas, int i6, int i7) {
        float min = Math.min(this.f36853f, i7);
        if (this.f36852e == 0.0f) {
            canvas.drawRect(0.0f, 0.0f, i6, min, this.f36849b);
            return;
        }
        this.f36848a.reset();
        float f6 = i6;
        this.f36848a.lineTo(f6, 0.0f);
        this.f36848a.lineTo(f6, min);
        this.f36848a.quadTo(i6 / 2, (this.f36852e * 2.0f) + min, 0.0f, min);
        this.f36848a.close();
        canvas.drawPath(this.f36848a, this.f36849b);
    }

    private void S(Context context, AttributeSet attributeSet) {
        setMinimumHeight(c.b(100.0f));
        Paint paint = new Paint();
        this.f36849b = paint;
        paint.setColor(-15614977);
        this.f36849b.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f36850c = paint2;
        paint2.setColor(-1);
        this.f36850c.setAntiAlias(true);
        Paint paint3 = new Paint();
        this.f36851d = paint3;
        paint3.setAntiAlias(true);
        this.f36851d.setColor(-1);
        this.f36851d.setStyle(Paint.Style.STROKE);
        this.f36851d.setStrokeWidth(c.b(2.0f));
        this.f36848a = new Path();
    }

    @Override // m2.e
    public void g(float f6, int i6, int i7, int i8) {
        RefreshState refreshState = this.f36856i;
        if (refreshState == RefreshState.Refreshing || refreshState == RefreshState.RefreshReleased) {
            return;
        }
        y(f6, i6, i7, i8);
    }

    @Override // m2.f
    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.Scale;
    }

    @Override // n2.f
    public void x(h hVar, RefreshState refreshState, RefreshState refreshState2) {
        this.f36856i = refreshState2;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isInEditMode()) {
            this.f36858k = true;
            this.f36860m = true;
            float height = getHeight();
            this.f36853f = height;
            this.f36862o = 270;
            this.f36857j = height / 2.0f;
            this.f36861n = height / 6.0f;
        }
        int width = getWidth();
        R(canvas, width, getHeight());
        Q(canvas, width);
        M(canvas, width);
        P(canvas, width);
        O(canvas, width);
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        setMeasuredDimension(View.resolveSize(getSuggestedMinimumWidth(), i6), View.resolveSize(getSuggestedMinimumHeight(), i7));
    }

    public BezierCircleHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f36862o = 90;
        this.f36863p = 90;
        this.f36864q = true;
        S(context, attributeSet);
    }

    public BezierCircleHeader(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f36862o = 90;
        this.f36863p = 90;
        this.f36864q = true;
        S(context, attributeSet);
    }

    @RequiresApi(21)
    public BezierCircleHeader(Context context, @Nullable AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
        this.f36862o = 90;
        this.f36863p = 90;
        this.f36864q = true;
        S(context, attributeSet);
    }

    @Override // m2.f
    @NonNull
    public View getView() {
        return this;
    }

    @Override // m2.f
    public void h(h hVar, int i6, int i7) {
    }

    @Override // m2.f
    public void i(float f6, int i6, int i7) {
    }

    @Override // m2.f
    public void q(g gVar, int i6, int i7) {
    }
}
