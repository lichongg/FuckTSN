package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.core.view.ViewCompat;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw extends Drawable {
    private int cw;

    /* renamed from: j, reason: collision with root package name */
    private Paint f25710j;

    /* renamed from: r, reason: collision with root package name */
    private RectF f25711r;
    private int xt;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        RectF rectF = this.f25711r;
        int i6 = this.cw;
        canvas.drawRoundRect(rectF, i6, i6, this.f25710j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i6) {
        this.f25710j.setAlpha(i6);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f25710j.setColorFilter(colorFilter);
    }

    public cw(int i6, int i7) {
        this.cw = i6;
        this.xt = i7;
        Paint paint = new Paint();
        this.f25710j = paint;
        paint.setColor(0);
        this.f25710j.setAntiAlias(true);
        this.f25710j.setShadowLayer(i7, 0.0f, 0.0f, ViewCompat.MEASURED_STATE_MASK);
        this.f25710j.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i6, int i7, int i8, int i9) {
        super.setBounds(i6, i7, i8, i9);
        int i10 = this.xt;
        this.f25711r = new RectF(i6 + i10, i7 + i10, i8 - i10, i9 - i10);
    }
}
