package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: D:\Downloads\app\classes4.dex */
public class TTRoundRectImageView extends ImageView {
    private int cw;

    /* renamed from: j, reason: collision with root package name */
    private Paint f25997j;

    /* renamed from: r, reason: collision with root package name */
    private Matrix f25998r;
    private int xt;

    public TTRoundRectImageView(Context context) {
        this(context, null);
    }

    public TTRoundRectImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private Bitmap j(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int width = drawable.getIntrinsicWidth() <= 0 ? getWidth() : drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight() <= 0 ? getHeight() : drawable.getIntrinsicHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, width, height);
        drawable.draw(canvas);
        return createBitmap;
    }

    public void setXRound(int i6) {
        this.xt = i6;
        postInvalidate();
    }

    public void setYRound(int i6) {
        this.cw = i6;
        postInvalidate();
    }

    public TTRoundRectImageView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.xt = 25;
        this.cw = 25;
        Paint paint = new Paint();
        this.f25997j = paint;
        paint.setAntiAlias(true);
        this.f25997j.setFilterBitmap(true);
        this.f25998r = new Matrix();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            Bitmap j6 = j(drawable);
            if (j6 != null) {
                Shader.TileMode tileMode = Shader.TileMode.REPEAT;
                BitmapShader bitmapShader = new BitmapShader(j6, tileMode, tileMode);
                float f6 = 1.0f;
                if (j6.getWidth() != getWidth() || j6.getHeight() != getHeight()) {
                    f6 = Math.max((getWidth() * 1.0f) / j6.getWidth(), (getHeight() * 1.0f) / j6.getHeight());
                }
                this.f25998r.setScale(f6, f6);
                bitmapShader.setLocalMatrix(this.f25998r);
                this.f25997j.setShader(bitmapShader);
                canvas.drawRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), this.xt, this.cw, this.f25997j);
                return;
            }
            super.onDraw(canvas);
            return;
        }
        super.onDraw(canvas);
    }
}
