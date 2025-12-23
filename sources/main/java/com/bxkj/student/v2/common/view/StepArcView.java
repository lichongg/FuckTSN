package com.bxkj.student.v2.common.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.bxkj.student.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class StepArcView extends View {

    /* renamed from: a, reason: collision with root package name */
    private float f21024a;

    /* renamed from: b, reason: collision with root package name */
    private float f21025b;

    /* renamed from: c, reason: collision with root package name */
    private String f21026c;

    /* renamed from: d, reason: collision with root package name */
    private float f21027d;

    /* renamed from: e, reason: collision with root package name */
    private float f21028e;

    /* renamed from: f, reason: collision with root package name */
    private float f21029f;

    /* renamed from: g, reason: collision with root package name */
    private int f21030g;

    /* renamed from: h, reason: collision with root package name */
    private String f21031h;

    /* renamed from: i, reason: collision with root package name */
    private String f21032i;

    /* renamed from: j, reason: collision with root package name */
    private String f21033j;

    /* renamed from: k, reason: collision with root package name */
    private int f21034k;

    /* renamed from: l, reason: collision with root package name */
    private int f21035l;

    /* renamed from: m, reason: collision with root package name */
    private float f21036m;

    /* renamed from: n, reason: collision with root package name */
    private float f21037n;

    /* renamed from: o, reason: collision with root package name */
    private float f21038o;

    /* renamed from: p, reason: collision with root package name */
    private float f21039p;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator animation) {
            StepArcView.this.f21029f = ((Float) animation.getAnimatedValue()).floatValue();
            StepArcView.this.invalidate();
        }
    }

    public StepArcView(Context context) {
        super(context);
        this.f21024a = b(10.0f);
        this.f21025b = 0.0f;
        this.f21026c = "0";
        this.f21027d = 135.0f;
        this.f21028e = 270.0f;
        this.f21029f = 0.0f;
        this.f21030g = 500;
        this.f21031h = "达标里程：3.0KM";
        this.f21032i = "0.01KM";
        this.f21033j = "里程(KM)";
        this.f21034k = -16776961;
        this.f21035l = -1;
        this.f21036m = 0.0f;
        this.f21037n = -1.0f;
        this.f21038o = 0.0f;
        this.f21039p = b(16.0f);
    }

    private void j(float start, float current, int length) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(start, current);
        ofFloat.setDuration(length);
        ofFloat.setTarget(Float.valueOf(this.f21029f));
        ofFloat.addUpdateListener(new a());
        ofFloat.start();
    }

    private void c(Canvas canvas, RectF rectF) {
        Paint paint = new Paint();
        int i6 = this.f21034k;
        if (this.f21029f == this.f21028e) {
            i6 = ContextCompat.getColor(getContext(), R.color.v3_tab_color2);
        }
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(this.f21024a);
        paint.setColor(i6);
        canvas.drawArc(rectF, this.f21027d, this.f21029f, false, paint);
    }

    private void d(Canvas canvas, RectF rectF) {
        Paint paint = new Paint();
        paint.setColor(getResources().getColor(R.color.v3_sport_circle_color));
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(this.f21024a);
        canvas.drawArc(rectF, this.f21027d, this.f21028e, false, paint);
    }

    private void e(Canvas canvas, float centerX) {
        Paint paint = new Paint();
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        paint.setTextSize(this.f21025b);
        paint.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
        paint.setColor(this.f21035l);
        Rect rect = new Rect();
        String str = this.f21032i;
        paint.getTextBounds(str, 0, str.length(), rect);
        canvas.drawText(str, centerX, (getHeight() / 2) + (rect.height() / 2), paint);
    }

    private void f(Canvas canvas, float centerX) {
        Paint paint = new Paint();
        paint.setTextSize(this.f21039p);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        paint.setColor(this.f21035l);
        String str = this.f21033j;
        paint.getTextBounds(str, 0, str.length(), new Rect());
        float height = getHeight();
        float f6 = this.f21039p;
        canvas.drawText(str, centerX, ((height - f6) - f6) - b(10.0f), paint);
    }

    private void g(Canvas canvas, float centerX) {
        Paint paint = new Paint();
        paint.setTextSize(this.f21039p);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        paint.setColor(this.f21034k);
        String str = this.f21031h;
        paint.getTextBounds(str, 0, str.length(), new Rect());
        canvas.drawText(str, centerX, getHeight() - (h(b(16.0f)) / 2), paint);
    }

    public int h(float fontSize) {
        Paint paint = new Paint();
        paint.setTextSize(fontSize);
        Rect rect = new Rect();
        String str = this.f21026c;
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect.height();
    }

    public StepArcView k(float count) {
        this.f21036m = count;
        return this;
    }

    public StepArcView l(float current) {
        this.f21038o = current;
        return this;
    }

    public StepArcView m(int currentColor) {
        this.f21034k = currentColor;
        return this;
    }

    public StepArcView n(String currentText) {
        this.f21032i = currentText;
        return this;
    }

    public StepArcView o(float maxRange) {
        this.f21037n = maxRange;
        return this;
    }

    public StepArcView p(String targetText) {
        this.f21031h = targetText;
        return this;
    }

    public void setCurrentCount(float currentCounts) {
        float f6;
        float f7;
        float f8 = this.f21036m;
        if (currentCounts > f8) {
            float f9 = this.f21037n;
            currentCounts = (f9 == -1.0f || currentCounts <= f9) ? f8 : -1.0f;
        }
        float f10 = this.f21028e;
        float f11 = 0.0f;
        if (f8 != 0.0f) {
            float floatValue = Float.valueOf(this.f21026c).floatValue();
            float f12 = this.f21036m;
            f6 = (floatValue / f12) * this.f21028e;
            f7 = currentCounts / f12;
        } else {
            f6 = f10;
            f7 = 1.0f;
        }
        if (this.f21037n == -1.0f || currentCounts != -1.0f) {
            f11 = f7;
        } else {
            f6 = 0.0f;
        }
        j(f6, f11 * this.f21028e, this.f21030g);
        this.f21026c = String.valueOf(currentCounts);
        setTextSize(this.f21032i.length());
    }

    public void setTextSize(int length) {
        if (length <= 4) {
            this.f21025b = b((this.f21039p / b(16.0f)) * 50.0f);
            return;
        }
        if (length > 4 && length <= 6) {
            this.f21025b = b((this.f21039p / b(16.0f)) * 40.0f);
            return;
        }
        if (length > 6 && length <= 8) {
            this.f21025b = b((this.f21039p / b(16.0f)) * 30.0f);
        } else if (length >= 8) {
            this.f21025b = b(25.0f) * (this.f21039p / b(16.0f));
        }
    }

    private float b(float dip) {
        int i6;
        float f6 = getContext().getResources().getDisplayMetrics().density * dip;
        if (dip >= 0.0f) {
            i6 = 1;
        } else {
            i6 = -1;
        }
        return f6 + (i6 * 0.5f);
    }

    private void i(AttributeSet attrs) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.StepArcView);
        this.f21031h = obtainStyledAttributes.getString(9);
        this.f21033j = obtainStyledAttributes.getString(4);
        this.f21032i = obtainStyledAttributes.getString(3);
        this.f21034k = obtainStyledAttributes.getColor(1, getResources().getColor(R.color.v3_tab_color2));
        this.f21035l = obtainStyledAttributes.getColor(0, getResources().getColor(2131099737));
        this.f21036m = obtainStyledAttributes.getInt(8, 0);
        this.f21037n = obtainStyledAttributes.getInt(6, -1);
        this.f21038o = obtainStyledAttributes.getInt(2, 0);
        this.f21039p = obtainStyledAttributes.getDimensionPixelSize(5, (int) b(16.0f));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float width = getWidth() / 2;
        float f6 = this.f21024a;
        float f7 = 2.0f * width;
        RectF rectF = new RectF(0.0f + f6, f6, f7 - f6, f7 - f6);
        d(canvas, rectF);
        c(canvas, rectF);
        e(canvas, width);
        f(canvas, width);
        g(canvas, width);
        setCurrentCount(this.f21038o);
    }

    public StepArcView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f21024a = b(10.0f);
        this.f21025b = 0.0f;
        this.f21026c = "0";
        this.f21027d = 135.0f;
        this.f21028e = 270.0f;
        this.f21029f = 0.0f;
        this.f21030g = 500;
        this.f21031h = "达标里程：3.0KM";
        this.f21032i = "0.01KM";
        this.f21033j = "里程(KM)";
        this.f21034k = -16776961;
        this.f21035l = -1;
        this.f21036m = 0.0f;
        this.f21037n = -1.0f;
        this.f21038o = 0.0f;
        this.f21039p = b(16.0f);
        i(attrs);
    }

    public StepArcView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f21024a = b(10.0f);
        this.f21025b = 0.0f;
        this.f21026c = "0";
        this.f21027d = 135.0f;
        this.f21028e = 270.0f;
        this.f21029f = 0.0f;
        this.f21030g = 500;
        this.f21031h = "达标里程：3.0KM";
        this.f21032i = "0.01KM";
        this.f21033j = "里程(KM)";
        this.f21034k = -16776961;
        this.f21035l = -1;
        this.f21036m = 0.0f;
        this.f21037n = -1.0f;
        this.f21038o = 0.0f;
        this.f21039p = b(16.0f);
        i(attrs);
    }
}
