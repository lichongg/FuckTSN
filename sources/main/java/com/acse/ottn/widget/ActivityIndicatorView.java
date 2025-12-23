package com.acse.ottn.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.acse.ottn.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class ActivityIndicatorView extends View {

    /* renamed from: a, reason: collision with root package name */
    public int f5450a;

    /* renamed from: b, reason: collision with root package name */
    public int f5451b;

    /* renamed from: c, reason: collision with root package name */
    public float f5452c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f5453d;

    /* renamed from: e, reason: collision with root package name */
    public final int f5454e;

    /* renamed from: f, reason: collision with root package name */
    public final int f5455f;

    /* renamed from: g, reason: collision with root package name */
    public final int f5456g;

    /* renamed from: h, reason: collision with root package name */
    public int[] f5457h;

    /* renamed from: i, reason: collision with root package name */
    public Paint f5458i;

    /* renamed from: j, reason: collision with root package name */
    public Handler f5459j;

    /* renamed from: k, reason: collision with root package name */
    public Runnable f5460k;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActivityIndicatorView.a(ActivityIndicatorView.this, 30);
            ActivityIndicatorView.this.invalidate();
            ActivityIndicatorView.this.f5459j.postDelayed(ActivityIndicatorView.this.f5460k, 100L);
        }
    }

    public ActivityIndicatorView(Context context) {
        this(context, null);
    }

    public static /* synthetic */ int a(ActivityIndicatorView activityIndicatorView, int i6) {
        int i7 = activityIndicatorView.f5451b + i6;
        activityIndicatorView.f5451b = i7;
        return i7;
    }

    public ActivityIndicatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final float b(int i6, float f6) {
        return (float) (f6 * Math.sin((i6 * 3.141592653589793d) / 180.0d));
    }

    public void c() {
        this.f5459j.removeCallbacks(this.f5460k);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        float min = Math.min((getWidth() - getPaddingLeft()) - getPaddingRight(), (getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f;
        if (this.f5452c == 0.0f) {
            this.f5452c = a(15, min / 2.0f) / 2.0f;
        }
        this.f5458i.setStrokeWidth(this.f5452c);
        int i6 = 0;
        while (true) {
            int[] iArr = this.f5457h;
            if (i6 >= iArr.length) {
                return;
            }
            this.f5458i.setColor(iArr[i6]);
            float f6 = width;
            int i7 = i6 * (-30);
            float f7 = min / 2.0f;
            float f8 = height;
            canvas.drawLine(f6 + a(this.f5451b + i7, f7), f8 + b(this.f5451b + i7, f7), f6 + a(this.f5451b + i7, min - (this.f5452c / 2.0f)), f8 + b(i7 + this.f5451b, min - (this.f5452c / 2.0f)), this.f5458i);
            i6++;
        }
    }

    public void setColor(int i6) {
        this.f5450a = i6;
    }

    public void setStartAngle(int i6) {
        this.f5451b = i6;
    }

    public void setStrokeWidth(float f6) {
        this.f5452c = f6;
    }

    public ActivityIndicatorView(Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f5450a = Color.argb(255, 255, 255, 255);
        this.f5451b = 0;
        this.f5452c = 0.0f;
        this.f5454e = 12;
        this.f5455f = 0;
        this.f5456g = 30;
        this.f5457h = new int[12];
        this.f5459j = new Handler(Looper.getMainLooper());
        this.f5460k = new a();
        a(context, attributeSet, i6, 0);
    }

    public final void a(Context context, @Nullable AttributeSet attributeSet, int i6, int i7) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActivityIndicatorView, i6, i7);
        this.f5450a = obtainStyledAttributes.getColor(R.styleable.ActivityIndicatorView_aiv_color, this.f5450a);
        this.f5451b = obtainStyledAttributes.getInt(R.styleable.ActivityIndicatorView_aiv_startAngle, this.f5451b);
        this.f5452c = obtainStyledAttributes.getDimension(R.styleable.ActivityIndicatorView_aiv_strokeWidth, this.f5452c);
        this.f5453d = obtainStyledAttributes.getBoolean(R.styleable.ActivityIndicatorView_aiv_auto_start, true);
        obtainStyledAttributes.recycle();
        a();
    }

    public void b() {
        this.f5459j.post(this.f5460k);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f5453d) {
            b();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f5459j != null) {
            c();
        }
    }

    public final void a() {
        this.f5458i = new Paint(1);
        int alpha = Color.alpha(this.f5450a);
        int red = Color.red(this.f5450a);
        int green = Color.green(this.f5450a);
        int blue = Color.blue(this.f5450a);
        int abs = Math.abs(alpha) / 12;
        int i6 = 0;
        while (true) {
            int[] iArr = this.f5457h;
            if (i6 < iArr.length) {
                iArr[i6] = Color.argb(alpha - (abs * i6), red, green, blue);
                i6++;
            } else {
                this.f5458i.setStrokeCap(Paint.Cap.ROUND);
                return;
            }
        }
    }

    public final float a(int i6, float f6) {
        return (float) (f6 * Math.cos((i6 * 3.141592653589793d) / 180.0d));
    }
}
