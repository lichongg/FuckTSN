package com.bytedance.sdk.openadsdk.res;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw extends Drawable {

    /* renamed from: j, reason: collision with root package name */
    private Paint f31816j;
    private int xt;

    public void j(int i6) {
        this.f31816j.setColor(i6);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) (this.xt * 1.3d);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) (this.xt * 1.3d);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f31816j.getAlpha();
    }

    public void j(float f6) {
        this.f31816j.setStrokeWidth(f6);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i6) {
        this.f31816j.setAlpha(i6);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f31816j.setColorFilter(colorFilter);
    }

    public cw(int i6) {
        this.xt = i6;
        Paint paint = new Paint();
        this.f31816j = paint;
        paint.setAntiAlias(true);
        this.f31816j.setFilterBitmap(true);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        float centerX = getBounds().centerX();
        float centerY = getBounds().centerY();
        float f6 = ((this.xt / 2.0f) * 3.0f) / 4.0f;
        float f7 = centerX - f6;
        float f8 = centerY - f6;
        float f9 = centerX + f6;
        float f10 = centerY + f6;
        canvas.drawLine(f7, f8, f9, f10, this.f31816j);
        canvas.drawLine(f9, f8, f7, f10, this.f31816j);
    }
}
