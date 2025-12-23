package com.bytedance.sdk.openadsdk.res;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j extends Drawable {
    private float cw;

    /* renamed from: j, reason: collision with root package name */
    private Paint f31817j;
    private int xt;

    public void j(int i6) {
        this.f31817j.setColor(i6);
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
        return this.f31817j.getAlpha();
    }

    public void j(float f6) {
        this.f31817j.setStrokeWidth(f6);
        this.cw = f6;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i6) {
        this.f31817j.setAlpha(i6);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f31817j.setColorFilter(colorFilter);
    }

    public j(int i6) {
        this.xt = i6;
        Paint paint = new Paint();
        this.f31817j = paint;
        paint.setAntiAlias(true);
        this.f31817j.setFilterBitmap(true);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        float centerX = getBounds().centerX();
        float centerY = getBounds().centerY();
        float f6 = this.xt / 2.0f;
        float f7 = centerX - ((3.0f * f6) / 4.0f);
        float f8 = centerX + (f6 / 4.0f);
        float f9 = f8 - f7;
        canvas.drawLine(f7, centerY + (this.cw / 4.0f), f8, centerY - f9, this.f31817j);
        canvas.drawLine(f7, centerY - (this.cw / 4.0f), f8, f9 + centerY, this.f31817j);
    }
}
