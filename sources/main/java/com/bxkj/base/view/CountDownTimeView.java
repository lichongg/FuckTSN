package com.bxkj.base.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import com.bxkj.base.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class CountDownTimeView extends View {

    /* renamed from: a, reason: collision with root package name */
    private float f17160a;

    /* renamed from: b, reason: collision with root package name */
    private float f17161b;

    /* renamed from: c, reason: collision with root package name */
    private String f17162c;

    /* renamed from: d, reason: collision with root package name */
    private float f17163d;

    /* renamed from: e, reason: collision with root package name */
    private float f17164e;

    /* renamed from: f, reason: collision with root package name */
    private float f17165f;

    /* renamed from: g, reason: collision with root package name */
    private int f17166g;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            CountDownTimeView.this.f17165f = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            CountDownTimeView.this.invalidate();
        }
    }

    public CountDownTimeView(Context context) {
        super(context);
        this.f17160a = 10.0f;
        this.f17161b = 0.0f;
        this.f17162c = "0";
        this.f17163d = 270.0f;
        this.f17164e = 360.0f;
        this.f17165f = 0.0f;
        this.f17166g = 0;
    }

    private void h(float f6, float f7, int i6) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f6, f7);
        ofFloat.setDuration(i6);
        ofFloat.setTarget(Float.valueOf(this.f17165f));
        ofFloat.addUpdateListener(new a());
        ofFloat.start();
    }

    public void setTextSize(int i6) {
        this.f17161b = i6;
    }

    private void c(Canvas canvas, RectF rectF) {
        Paint paint = new Paint();
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(this.f17160a);
        paint.setColor(getResources().getColor(R.color.color_red));
        canvas.drawArc(rectF, this.f17163d, this.f17165f, false, paint);
    }

    private void d(Canvas canvas, RectF rectF) {
        Paint paint = new Paint();
        paint.setColor(getResources().getColor(R.color.yellow));
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(this.f17160a);
        canvas.drawArc(rectF, this.f17163d, this.f17164e, false, paint);
    }

    private void e(Canvas canvas, float f6) {
        Paint paint = new Paint();
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        paint.setTextSize(this.f17161b);
        paint.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
        paint.setColor(getResources().getColor(R.color.color_red));
        Rect rect = new Rect();
        String str = this.f17162c;
        paint.getTextBounds(str, 0, str.length(), rect);
        canvas.drawText(this.f17162c, f6, (getHeight() / 2) + (rect.height() / 2), paint);
    }

    private void f(Canvas canvas, float f6) {
        Paint paint = new Paint();
        paint.setTextSize(b(16.0f));
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        paint.setColor(getResources().getColor(R.color.color_red));
        paint.getTextBounds("步数", 0, 2, new Rect());
        canvas.drawText("步数", f6, (getHeight() / 2) + r1.height() + g(this.f17161b), paint);
    }

    public int g(float f6) {
        Paint paint = new Paint();
        paint.setTextSize(f6);
        Rect rect = new Rect();
        String str = this.f17162c;
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect.height();
    }

    public void i(int i6, int i7) {
        this.f17162c = i7 + "";
        if (i7 > i6) {
            i7 = i6;
        }
        h(0.0f, (i7 / i6) * this.f17164e, this.f17166g);
    }

    public void setText(String str) {
        this.f17162c = str;
    }

    private int b(float f6) {
        int i6;
        float f7 = getContext().getResources().getDisplayMetrics().density * f6;
        if (f6 >= 0.0f) {
            i6 = 1;
        } else {
            i6 = -1;
        }
        return (int) (f7 + (i6 * 0.5f));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float width = getWidth() / 2;
        float f6 = this.f17160a;
        float f7 = 2.0f * width;
        RectF rectF = new RectF(0.0f + f6, f6, f7 - f6, f7 - f6);
        d(canvas, rectF);
        c(canvas, rectF);
        e(canvas, width);
    }

    public CountDownTimeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17160a = 10.0f;
        this.f17161b = 0.0f;
        this.f17162c = "0";
        this.f17163d = 270.0f;
        this.f17164e = 360.0f;
        this.f17165f = 0.0f;
        this.f17166g = 0;
    }

    public CountDownTimeView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f17160a = 10.0f;
        this.f17161b = 0.0f;
        this.f17162c = "0";
        this.f17163d = 270.0f;
        this.f17164e = 360.0f;
        this.f17165f = 0.0f;
        this.f17166g = 0;
    }
}
