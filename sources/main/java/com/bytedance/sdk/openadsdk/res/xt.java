package com.bytedance.sdk.openadsdk.res;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt extends Drawable {

    /* renamed from: j, reason: collision with root package name */
    private Paint f31826j;
    private int xt;

    public void j(int i6) {
        this.f31826j.setColor(i6);
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
        return this.f31826j.getAlpha();
    }

    public void j(float f6) {
        this.f31826j.setStrokeWidth(f6);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i6) {
        this.f31826j.setAlpha(i6);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f31826j.setColorFilter(colorFilter);
    }

    public xt(int i6) {
        this.xt = i6;
        Paint paint = new Paint();
        this.f31826j = paint;
        paint.setAntiAlias(true);
        this.f31826j.setFilterBitmap(true);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.drawCircle(getBounds().centerX(), getBounds().centerY(), this.xt / 2.0f, this.f31826j);
    }
}
