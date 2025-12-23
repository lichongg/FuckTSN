package com.scwang.smartrefresh.layout.header.bezierradar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.annotation.ColorInt;
import com.scwang.smartrefresh.layout.util.c;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class RoundProgressView extends View {

    /* renamed from: a, reason: collision with root package name */
    private Paint f37404a;

    /* renamed from: b, reason: collision with root package name */
    private Paint f37405b;

    /* renamed from: c, reason: collision with root package name */
    private ValueAnimator f37406c;

    /* renamed from: d, reason: collision with root package name */
    private int f37407d;

    /* renamed from: e, reason: collision with root package name */
    private int f37408e;

    /* renamed from: f, reason: collision with root package name */
    private int f37409f;

    /* renamed from: g, reason: collision with root package name */
    private int f37410g;

    /* renamed from: h, reason: collision with root package name */
    private RectF f37411h;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            RoundProgressView.this.f37407d = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            RoundProgressView.this.postInvalidate();
        }
    }

    private void b() {
        this.f37404a = new Paint();
        this.f37405b = new Paint();
        this.f37404a.setAntiAlias(true);
        this.f37405b.setAntiAlias(true);
        this.f37404a.setColor(-1);
        this.f37405b.setColor(1426063360);
        c cVar = new c();
        this.f37409f = cVar.a(20.0f);
        this.f37410g = cVar.a(7.0f);
        this.f37404a.setStrokeWidth(cVar.a(3.0f));
        this.f37405b.setStrokeWidth(cVar.a(3.0f));
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 360);
        this.f37406c = ofInt;
        ofInt.setDuration(720L);
        this.f37406c.setRepeatCount(-1);
        this.f37406c.setInterpolator(new AccelerateDecelerateInterpolator());
    }

    public void c() {
        ValueAnimator valueAnimator = this.f37406c;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    public void d() {
        ValueAnimator valueAnimator = this.f37406c;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.f37406c.cancel();
    }

    public void setBackColor(@ColorInt int i6) {
        this.f37405b.setColor((i6 & 16777215) | 1426063360);
    }

    public void setFrontColor(@ColorInt int i6) {
        this.f37404a.setColor(i6);
    }

    public RoundProgressView(Context context) {
        super(context);
        this.f37407d = 0;
        this.f37408e = 270;
        this.f37409f = 0;
        this.f37410g = 0;
        this.f37411h = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        b();
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f37406c.addUpdateListener(new a());
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f37406c.removeAllUpdateListeners();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (isInEditMode()) {
            this.f37408e = 0;
            this.f37407d = 270;
        }
        Paint paint = this.f37404a;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        float f6 = width / 2;
        float f7 = height / 2;
        canvas.drawCircle(f6, f7, this.f37409f, this.f37404a);
        Paint paint2 = this.f37404a;
        Paint.Style style2 = Paint.Style.STROKE;
        paint2.setStyle(style2);
        canvas.drawCircle(f6, f7, this.f37409f + this.f37410g, this.f37404a);
        this.f37405b.setStyle(style);
        RectF rectF = this.f37411h;
        int i6 = this.f37409f;
        rectF.set(r6 - i6, r7 - i6, r6 + i6, i6 + r7);
        canvas.drawArc(this.f37411h, this.f37408e, this.f37407d, true, this.f37405b);
        this.f37409f += this.f37410g;
        this.f37405b.setStyle(style2);
        RectF rectF2 = this.f37411h;
        int i7 = this.f37409f;
        rectF2.set(r6 - i7, r7 - i7, r6 + i7, r7 + i7);
        canvas.drawArc(this.f37411h, this.f37408e, this.f37407d, false, this.f37405b);
        this.f37409f -= this.f37410g;
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        setMeasuredDimension(View.resolveSize(getSuggestedMinimumWidth(), i6), View.resolveSize(getSuggestedMinimumHeight(), i7));
    }
}
