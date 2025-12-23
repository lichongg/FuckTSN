package com.acse.ottn.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.acse.ottn.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class RoundRectImageView extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    public Paint f5473a;

    /* renamed from: b, reason: collision with root package name */
    public Paint f5474b;

    /* renamed from: c, reason: collision with root package name */
    public float f5475c;

    public RoundRectImageView(Context context) {
        this(context, null);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RoundRectImageView);
        try {
            this.f5475c = obtainStyledAttributes.getDimension(R.styleable.RoundRectImageView_image_radius, -1.6711936E7f);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public RoundRectImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundRectImageView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f5475c = 0.0f;
        if (!isInEditMode()) {
            a(context, attributeSet);
        }
        Paint paint = new Paint();
        this.f5473a = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f5474b = paint2;
        paint2.setAntiAlias(true);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            Bitmap a6 = a(a(drawable), this.f5475c);
            Rect rect = new Rect(0, 0, a6.getWidth(), a6.getHeight());
            Rect rect2 = new Rect(0, 0, getWidth(), getHeight());
            this.f5473a.reset();
            this.f5473a.setAntiAlias(true);
            canvas.drawBitmap(a6, rect, rect2, this.f5473a);
            return;
        }
        super.onDraw(canvas);
    }

    public void setRadius(int i6) {
        this.f5475c = a(i6);
    }

    public static Bitmap a(Drawable drawable) {
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        drawable.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    public static Bitmap a(Bitmap bitmap, int i6, int i7, int i8, int i9) {
        if (bitmap == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.setScale((i6 * 1.0f) / bitmap.getWidth(), (i7 * 1.0f) / bitmap.getHeight());
        Bitmap createBitmap = Bitmap.createBitmap(i6, i7, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        float f6 = i9;
        RectF rectF = new RectF(f6, f6, i6 - i9, i7 - i9);
        float f7 = i8;
        canvas.drawRoundRect(rectF, f7, f7, paint);
        if (i9 > 0) {
            Paint paint2 = new Paint(1);
            paint.setAntiAlias(true);
            paint2.setColor(-16711936);
            paint2.setStyle(Paint.Style.STROKE);
            paint2.setStrokeWidth(f6);
            canvas.drawRoundRect(rectF, f7, f7, paint2);
        }
        return createBitmap;
    }

    public Bitmap a(Bitmap bitmap, float f6) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawRoundRect(rectF, f6, f6, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return createBitmap;
    }

    public final int a(int i6) {
        return (int) (i6 * getContext().getResources().getDisplayMetrics().density);
    }
}
