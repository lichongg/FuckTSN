package com.bxkj.student.common.crop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.appcompat.widget.AppCompatImageView;
import com.bxkj.student.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class CircleImageView extends AppCompatImageView {
    private static final ImageView.ScaleType A = ImageView.ScaleType.CENTER_CROP;
    private static final Bitmap.Config B = Bitmap.Config.ARGB_8888;
    private static final int C = 2;
    private static final int D = 0;
    private static final int E = -16777216;
    private static final int F = 0;
    private static final boolean G = false;

    /* renamed from: g, reason: collision with root package name */
    private final RectF f17688g;

    /* renamed from: h, reason: collision with root package name */
    private final RectF f17689h;

    /* renamed from: i, reason: collision with root package name */
    private final Matrix f17690i;

    /* renamed from: j, reason: collision with root package name */
    private final Paint f17691j;

    /* renamed from: k, reason: collision with root package name */
    private final Paint f17692k;

    /* renamed from: l, reason: collision with root package name */
    private final Paint f17693l;

    /* renamed from: m, reason: collision with root package name */
    private int f17694m;

    /* renamed from: n, reason: collision with root package name */
    private int f17695n;

    /* renamed from: o, reason: collision with root package name */
    private int f17696o;

    /* renamed from: p, reason: collision with root package name */
    private Bitmap f17697p;

    /* renamed from: q, reason: collision with root package name */
    private BitmapShader f17698q;

    /* renamed from: r, reason: collision with root package name */
    private int f17699r;

    /* renamed from: s, reason: collision with root package name */
    private int f17700s;

    /* renamed from: t, reason: collision with root package name */
    private float f17701t;

    /* renamed from: u, reason: collision with root package name */
    private float f17702u;

    /* renamed from: v, reason: collision with root package name */
    private ColorFilter f17703v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f17704w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f17705x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f17706y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f17707z;

    public CircleImageView(Context context) {
        super(context);
        this.f17688g = new RectF();
        this.f17689h = new RectF();
        this.f17690i = new Matrix();
        this.f17691j = new Paint();
        this.f17692k = new Paint();
        this.f17693l = new Paint();
        this.f17694m = -16777216;
        this.f17695n = 0;
        this.f17696o = 0;
        d();
    }

    private Bitmap getBitmapFromDrawable(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap createBitmap = drawable instanceof ColorDrawable ? Bitmap.createBitmap(2, 2, B) : Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), B);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (Exception e6) {
            e6.printStackTrace();
            return null;
        }
    }

    private void b() {
        Paint paint = this.f17691j;
        if (paint != null) {
            paint.setColorFilter(this.f17703v);
        }
    }

    private void d() {
        super.setScaleType(A);
        this.f17704w = true;
        if (this.f17705x) {
            setup();
            this.f17705x = false;
        }
    }

    private void e() {
        if (this.f17707z) {
            this.f17697p = null;
        } else {
            this.f17697p = getBitmapFromDrawable(getDrawable());
        }
        setup();
    }

    private void setup() {
        int i6;
        if (!this.f17704w) {
            this.f17705x = true;
            return;
        }
        if (getWidth() == 0 && getHeight() == 0) {
            return;
        }
        if (this.f17697p == null) {
            invalidate();
            return;
        }
        Bitmap bitmap = this.f17697p;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.f17698q = new BitmapShader(bitmap, tileMode, tileMode);
        this.f17691j.setAntiAlias(true);
        this.f17691j.setShader(this.f17698q);
        this.f17692k.setStyle(Paint.Style.STROKE);
        this.f17692k.setAntiAlias(true);
        this.f17692k.setColor(this.f17694m);
        this.f17692k.setStrokeWidth(this.f17695n);
        this.f17693l.setStyle(Paint.Style.FILL);
        this.f17693l.setAntiAlias(true);
        this.f17693l.setColor(this.f17696o);
        this.f17700s = this.f17697p.getHeight();
        this.f17699r = this.f17697p.getWidth();
        this.f17689h.set(c());
        this.f17702u = Math.min((this.f17689h.height() - this.f17695n) / 2.0f, (this.f17689h.width() - this.f17695n) / 2.0f);
        this.f17688g.set(this.f17689h);
        if (!this.f17706y && (i6 = this.f17695n) > 0) {
            this.f17688g.inset(i6 - 1.0f, i6 - 1.0f);
        }
        this.f17701t = Math.min(this.f17688g.height() / 2.0f, this.f17688g.width() / 2.0f);
        b();
        updateShaderMatrix();
        invalidate();
    }

    private void updateShaderMatrix() {
        float width;
        float height;
        this.f17690i.set(null);
        float f6 = 0.0f;
        if (this.f17699r * this.f17688g.height() > this.f17688g.width() * this.f17700s) {
            width = this.f17688g.height() / this.f17700s;
            f6 = (this.f17688g.width() - (this.f17699r * width)) * 0.5f;
            height = 0.0f;
        } else {
            width = this.f17688g.width() / this.f17699r;
            height = (this.f17688g.height() - (this.f17700s * width)) * 0.5f;
        }
        this.f17690i.setScale(width, width);
        Matrix matrix = this.f17690i;
        RectF rectF = this.f17688g;
        matrix.postTranslate(((int) (f6 + 0.5f)) + rectF.left, ((int) (height + 0.5f)) + rectF.top);
        this.f17698q.setLocalMatrix(this.f17690i);
    }

    public boolean f() {
        return this.f17706y;
    }

    public boolean g() {
        return this.f17707z;
    }

    public int getBorderColor() {
        return this.f17694m;
    }

    public int getBorderWidth() {
        return this.f17695n;
    }

    @Override // android.widget.ImageView
    public ColorFilter getColorFilter() {
        return this.f17703v;
    }

    @Deprecated
    public int getFillColor() {
        return this.f17696o;
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return A;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f17707z) {
            super.onDraw(canvas);
            return;
        }
        if (this.f17697p == null) {
            return;
        }
        if (this.f17696o != 0) {
            canvas.drawCircle(this.f17688g.centerX(), this.f17688g.centerY(), this.f17701t, this.f17693l);
        }
        canvas.drawCircle(this.f17688g.centerX(), this.f17688g.centerY(), this.f17701t, this.f17691j);
        if (this.f17695n > 0) {
            canvas.drawCircle(this.f17689h.centerX(), this.f17689h.centerY(), this.f17702u, this.f17692k);
        }
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean adjustViewBounds) {
        if (adjustViewBounds) {
            throw new IllegalArgumentException("adjustViewBounds not supported.");
        }
    }

    public void setBorderColor(@ColorInt int borderColor) {
        if (borderColor == this.f17694m) {
            return;
        }
        this.f17694m = borderColor;
        this.f17692k.setColor(borderColor);
        invalidate();
    }

    public void setBorderOverlay(boolean borderOverlay) {
        if (borderOverlay == this.f17706y) {
            return;
        }
        this.f17706y = borderOverlay;
        setup();
    }

    public void setBorderWidth(int borderWidth) {
        if (borderWidth == this.f17695n) {
            return;
        }
        this.f17695n = borderWidth;
        setup();
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter cf) {
        if (cf == this.f17703v) {
            return;
        }
        this.f17703v = cf;
        b();
        invalidate();
    }

    public void setDisableCircularTransformation(boolean disableCircularTransformation) {
        if (this.f17707z == disableCircularTransformation) {
            return;
        }
        this.f17707z = disableCircularTransformation;
        e();
    }

    @Deprecated
    public void setFillColor(@ColorInt int fillColor) {
        if (fillColor == this.f17696o) {
            return;
        }
        this.f17696o = fillColor;
        this.f17693l.setColor(fillColor);
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType != A) {
            throw new IllegalArgumentException(String.format("ScaleType %s not supported.", scaleType));
        }
    }

    private RectF c() {
        int min = Math.min((getWidth() - getPaddingLeft()) - getPaddingRight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        float paddingLeft = getPaddingLeft() + ((r0 - min) / 2.0f);
        float paddingTop = getPaddingTop() + ((r1 - min) / 2.0f);
        float f6 = min;
        return new RectF(paddingLeft, paddingTop, paddingLeft + f6, f6 + paddingTop);
    }

    @Override // android.view.View
    protected void onSizeChanged(int w5, int h6, int oldw, int oldh) {
        super.onSizeChanged(w5, h6, oldw, oldh);
        setup();
    }

    @Deprecated
    public void setBorderColorResource(@ColorRes int borderColorRes) {
        setBorderColor(getContext().getResources().getColor(borderColorRes));
    }

    @Deprecated
    public void setFillColorResource(@ColorRes int fillColorRes) {
        setFillColor(getContext().getResources().getColor(fillColorRes));
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bm) {
        super.setImageBitmap(bm);
        e();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        e();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(@DrawableRes int resId) {
        super.setImageResource(resId);
        e();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        e();
    }

    @Override // android.view.View
    public void setPadding(int left, int top2, int right, int bottom) {
        super.setPadding(left, top2, right, bottom);
        setup();
    }

    @Override // android.view.View
    public void setPaddingRelative(int start, int top2, int end, int bottom) {
        super.setPaddingRelative(start, top2, end, bottom);
        setup();
    }

    public CircleImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f17688g = new RectF();
        this.f17689h = new RectF();
        this.f17690i = new Matrix();
        this.f17691j = new Paint();
        this.f17692k = new Paint();
        this.f17693l = new Paint();
        this.f17694m = -16777216;
        this.f17695n = 0;
        this.f17696o = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.CircleImageView, defStyle, 0);
        this.f17695n = obtainStyledAttributes.getDimensionPixelSize(4, 0);
        this.f17694m = obtainStyledAttributes.getColor(2, -16777216);
        this.f17706y = obtainStyledAttributes.getBoolean(3, false);
        this.f17696o = obtainStyledAttributes.getColor(5, 0);
        obtainStyledAttributes.recycle();
        d();
    }
}
