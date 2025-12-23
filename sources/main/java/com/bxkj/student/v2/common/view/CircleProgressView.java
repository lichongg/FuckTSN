package com.bxkj.student.v2.common.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import com.bxkj.student.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class CircleProgressView extends View {

    /* renamed from: a, reason: collision with root package name */
    private float f20978a;

    /* renamed from: b, reason: collision with root package name */
    private float f20979b;

    /* renamed from: c, reason: collision with root package name */
    private String f20980c;

    /* renamed from: d, reason: collision with root package name */
    private float f20981d;

    /* renamed from: e, reason: collision with root package name */
    private float f20982e;

    /* renamed from: f, reason: collision with root package name */
    private float f20983f;

    /* renamed from: g, reason: collision with root package name */
    private int f20984g;

    /* renamed from: h, reason: collision with root package name */
    private int f20985h;

    /* renamed from: i, reason: collision with root package name */
    private float f20986i;

    /* renamed from: j, reason: collision with root package name */
    private float f20987j;

    /* renamed from: k, reason: collision with root package name */
    private float f20988k;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator animation) {
            CircleProgressView.this.f20983f = ((Float) animation.getAnimatedValue()).floatValue();
            CircleProgressView.this.invalidate();
        }
    }

    public CircleProgressView(Context context) {
        super(context);
        this.f20978a = b(12.0f);
        this.f20979b = 0.0f;
        this.f20980c = "0";
        this.f20981d = 180.0f;
        this.f20982e = 360.0f;
        this.f20983f = 0.0f;
        this.f20984g = 500;
        this.f20985h = -16776961;
        this.f20986i = -1.0f;
        this.f20987j = 0.0f;
        this.f20988k = 0.0f;
    }

    private void i(float start, float current, int length) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(start, current);
        ofFloat.setDuration(length);
        ofFloat.setTarget(Float.valueOf(this.f20983f));
        ofFloat.addUpdateListener(new a());
        ofFloat.start();
    }

    private void c(Canvas canvas, RectF rectF) {
        Paint paint = new Paint();
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(this.f20978a);
        paint.setColor(this.f20985h);
        canvas.drawArc(rectF, this.f20981d, this.f20983f, false, paint);
    }

    private void d(Canvas canvas, RectF rectF) {
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#e2e2e2"));
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(this.f20978a);
        canvas.drawArc(rectF, this.f20981d, this.f20982e, false, paint);
    }

    private void e(Canvas canvas, float centerX) {
        Paint paint = new Paint();
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        paint.setTextSize(this.f20979b);
        paint.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
        paint.setColor(getResources().getColor(2131099718));
        Rect rect = new Rect();
        String str = this.f20980c;
        paint.getTextBounds(str, 0, str.length(), rect);
        canvas.drawText(this.f20980c, centerX, (getHeight() / 2) + (rect.height() / 2), paint);
    }

    private void f(Canvas canvas, float centerX) {
        Paint paint = new Paint();
        paint.setTextSize(b(16.0f));
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        paint.setColor(getResources().getColor(2131099816));
        paint.getTextBounds("", 0, 0, new Rect());
        canvas.drawText("", centerX, (getHeight() / 2) + r1.height() + g(this.f20979b), paint);
    }

    public int g(float fontSize) {
        Paint paint = new Paint();
        paint.setTextSize(fontSize);
        Rect rect = new Rect();
        String str = this.f20980c;
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect.height();
    }

    public CircleProgressView j(float count) {
        this.f20987j = count;
        return this;
    }

    public CircleProgressView k(float current) {
        this.f20988k = current;
        return this;
    }

    public CircleProgressView l(float maxRange) {
        this.f20986i = maxRange;
        return this;
    }

    public void setCurrentCount(float currentCounts) {
        float f6;
        float f7;
        float f8 = this.f20987j;
        if (currentCounts > f8) {
            float f9 = this.f20986i;
            currentCounts = (f9 == -1.0f || currentCounts <= f9) ? f8 : -1.0f;
        }
        float f10 = this.f20982e;
        float f11 = 0.0f;
        if (f8 != 0.0f) {
            float floatValue = Float.valueOf(this.f20980c).floatValue();
            float f12 = this.f20987j;
            f6 = (floatValue / f12) * this.f20982e;
            f7 = currentCounts / f12;
        } else {
            f6 = f10;
            f7 = 1.0f;
        }
        if (this.f20986i == -1.0f || currentCounts != -1.0f) {
            f11 = f7;
        } else {
            f6 = 0.0f;
        }
        i(f6, f11 * this.f20982e, this.f20984g);
        this.f20980c = String.valueOf(currentCounts);
    }

    private int b(float dip) {
        int i6;
        float f6 = getContext().getResources().getDisplayMetrics().density * dip;
        if (dip >= 0.0f) {
            i6 = 1;
        } else {
            i6 = -1;
        }
        return (int) (f6 + (i6 * 0.5f));
    }

    private void h(AttributeSet attrs) {
        this.f20985h = getContext().obtainStyledAttributes(attrs, R.styleable.StepArcView).getColor(1, getResources().getColor(R.color.v3_tab_color2));
        this.f20987j = r4.getInt(8, 0);
        this.f20986i = r4.getInt(6, -1);
        this.f20988k = r4.getInt(2, 0);
        this.f20981d = r4.getInt(7, 180);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float width = getWidth() / 2;
        float f6 = this.f20978a;
        float f7 = 2.0f * width;
        RectF rectF = new RectF(0.0f + f6, f6, f7 - f6, f7 - f6);
        d(canvas, rectF);
        c(canvas, rectF);
        e(canvas, width);
        f(canvas, width);
        setCurrentCount(this.f20988k);
    }

    public void setTextSize(int num) {
        int length = String.valueOf(num).length();
        if (length <= 4) {
            this.f20979b = b(50.0f);
            return;
        }
        if (length > 4 && length <= 6) {
            this.f20979b = b(40.0f);
            return;
        }
        if (length > 6 && length <= 8) {
            this.f20979b = b(30.0f);
        } else if (length > 8) {
            this.f20979b = b(25.0f);
        }
    }

    public CircleProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f20978a = b(12.0f);
        this.f20979b = 0.0f;
        this.f20980c = "0";
        this.f20981d = 180.0f;
        this.f20982e = 360.0f;
        this.f20983f = 0.0f;
        this.f20984g = 500;
        this.f20985h = -16776961;
        this.f20986i = -1.0f;
        this.f20987j = 0.0f;
        this.f20988k = 0.0f;
        h(attrs);
    }

    public CircleProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f20978a = b(12.0f);
        this.f20979b = 0.0f;
        this.f20980c = "0";
        this.f20981d = 180.0f;
        this.f20982e = 360.0f;
        this.f20983f = 0.0f;
        this.f20984g = 500;
        this.f20985h = -16776961;
        this.f20986i = -1.0f;
        this.f20987j = 0.0f;
        this.f20988k = 0.0f;
        h(attrs);
    }
}
