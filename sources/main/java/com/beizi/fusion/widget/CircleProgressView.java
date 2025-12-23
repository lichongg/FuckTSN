package com.beizi.fusion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import com.beizi.fusion.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class CircleProgressView extends View {

    /* renamed from: a, reason: collision with root package name */
    private Paint f13837a;

    /* renamed from: b, reason: collision with root package name */
    private Paint f13838b;

    /* renamed from: c, reason: collision with root package name */
    private Paint f13839c;

    /* renamed from: d, reason: collision with root package name */
    private Paint f13840d;

    /* renamed from: e, reason: collision with root package name */
    private int f13841e;

    /* renamed from: f, reason: collision with root package name */
    private int f13842f;

    /* renamed from: g, reason: collision with root package name */
    private int f13843g;

    /* renamed from: h, reason: collision with root package name */
    private int f13844h;

    /* renamed from: i, reason: collision with root package name */
    private float f13845i;

    /* renamed from: j, reason: collision with root package name */
    private float f13846j;

    /* renamed from: k, reason: collision with root package name */
    private float f13847k;

    /* renamed from: l, reason: collision with root package name */
    private int f13848l;

    /* renamed from: m, reason: collision with root package name */
    private int f13849m;

    /* renamed from: n, reason: collision with root package name */
    private float f13850n;

    /* renamed from: o, reason: collision with root package name */
    private float f13851o;

    /* renamed from: p, reason: collision with root package name */
    private int f13852p;

    /* renamed from: q, reason: collision with root package name */
    private int f13853q;

    /* renamed from: r, reason: collision with root package name */
    private float f13854r;

    public CircleProgressView(Context context) {
        this(context, null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.BeiZiCircleProgressViewStyle, 0, 0);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float applyDimension = TypedValue.applyDimension(1, 18.0f, displayMetrics);
        float applyDimension2 = TypedValue.applyDimension(1, 4.0f, displayMetrics);
        this.f13854r = TypedValue.applyDimension(1, 50.0f, displayMetrics);
        this.f13845i = obtainStyledAttributes.getDimension(R.styleable.BeiZiCircleProgressViewStyle_adScopeRadius, applyDimension);
        this.f13847k = obtainStyledAttributes.getDimension(R.styleable.BeiZiCircleProgressViewStyle_adScopeStrokeWidth, applyDimension2);
        this.f13841e = obtainStyledAttributes.getColor(R.styleable.BeiZiCircleProgressViewStyle_adScopeCircleColor, 0);
        this.f13842f = obtainStyledAttributes.getColor(R.styleable.BeiZiCircleProgressViewStyle_adScopeRingColor, -41216);
        this.f13843g = obtainStyledAttributes.getColor(R.styleable.BeiZiCircleProgressViewStyle_adScopeTextColor, -1);
        this.f13844h = obtainStyledAttributes.getColor(R.styleable.BeiZiCircleProgressViewStyle_adScopeRingBgColor, 1589427388);
        this.f13846j = this.f13845i + (this.f13847k / 2.0f);
        obtainStyledAttributes.recycle();
    }

    public CircleProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13852p = 100;
        a(context, attributeSet);
        a();
    }

    public void setProgress(int i6) {
        this.f13853q = i6;
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.f13848l = getWidth() / 2;
        int height = getHeight() / 2;
        this.f13849m = height;
        canvas.drawCircle(this.f13848l, height, this.f13845i, this.f13837a);
        RectF rectF = new RectF();
        int i6 = this.f13848l;
        float f6 = this.f13846j;
        rectF.left = i6 - f6;
        int i7 = this.f13849m;
        rectF.top = i7 - f6;
        rectF.right = (f6 * 2.0f) + (i6 - f6);
        rectF.bottom = (f6 * 2.0f) + (i7 - f6);
        canvas.drawArc(rectF, 0.0f, 360.0f, false, this.f13839c);
        if (this.f13853q > 0) {
            RectF rectF2 = new RectF();
            int i8 = this.f13848l;
            float f7 = this.f13846j;
            rectF2.left = i8 - f7;
            int i9 = this.f13849m;
            rectF2.top = i9 - f7;
            rectF2.right = (f7 * 2.0f) + (i8 - f7);
            rectF2.bottom = (f7 * 2.0f) + (i9 - f7);
            canvas.drawArc(rectF2, -90.0f, (this.f13853q / this.f13852p) * 360.0f, false, this.f13838b);
            float measureText = this.f13840d.measureText("跳过", 0, 2);
            this.f13850n = measureText;
            canvas.drawText("跳过", this.f13848l - (measureText / 2.0f), this.f13849m + (this.f13851o / 4.0f), this.f13840d);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        super.onMeasure(i6, i7);
        int mode = View.MeasureSpec.getMode(i6);
        int mode2 = View.MeasureSpec.getMode(i7);
        int size = View.MeasureSpec.getSize(i6);
        int size2 = View.MeasureSpec.getSize(i7);
        if (mode != 1073741824) {
            size = (int) (getPaddingLeft() + this.f13854r + getPaddingRight());
        }
        if (mode2 != 1073741824) {
            size2 = (int) (getPaddingTop() + this.f13854r + getPaddingBottom());
        }
        setMeasuredDimension(size, size2);
    }

    private void a() {
        Paint paint = new Paint();
        this.f13837a = paint;
        paint.setAntiAlias(true);
        this.f13837a.setColor(this.f13841e);
        Paint paint2 = this.f13837a;
        Paint.Style style = Paint.Style.FILL;
        paint2.setStyle(style);
        Paint paint3 = new Paint();
        this.f13839c = paint3;
        paint3.setAntiAlias(true);
        this.f13839c.setColor(this.f13844h);
        Paint paint4 = this.f13839c;
        Paint.Style style2 = Paint.Style.STROKE;
        paint4.setStyle(style2);
        this.f13839c.setStrokeWidth(this.f13847k);
        Paint paint5 = new Paint();
        this.f13838b = paint5;
        paint5.setAntiAlias(true);
        this.f13838b.setColor(this.f13842f);
        this.f13838b.setStyle(style2);
        this.f13838b.setStrokeWidth(this.f13847k);
        this.f13838b.setStrokeCap(Paint.Cap.ROUND);
        Paint paint6 = new Paint();
        this.f13840d = paint6;
        paint6.setAntiAlias(true);
        this.f13840d.setStyle(style);
        this.f13840d.setColor(this.f13843g);
        this.f13840d.setTextSize((this.f13845i * 3.0f) / 5.0f);
        this.f13840d.setShadowLayer(2.0f, 1.0f, 1.0f, Color.parseColor("#000000"));
        Paint.FontMetrics fontMetrics = this.f13840d.getFontMetrics();
        this.f13851o = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
    }
}
