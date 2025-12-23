package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.GradientDrawable;
import com.bytedance.component.sdk.annotation.ColorInt;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt extends GradientDrawable {

    /* renamed from: j, reason: collision with root package name */
    protected Path f25713j;
    private final Paint xt;

    public xt() {
        this.f25713j = new Path();
        Paint paint = new Paint(1);
        this.xt = paint;
        paint.setColor(-1);
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Path path = this.f25713j;
        if (path == null || path.isEmpty()) {
            j(canvas);
            return;
        }
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), this.xt, 31);
        j(canvas);
        this.xt.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        canvas.drawPath(this.f25713j, this.xt);
        this.xt.setXfermode(null);
        canvas.restoreToCount(saveLayer);
    }

    public void update(int i6, int i7, int i8, int i9) {
        this.f25713j.addRect(i6, i7, i8, i9, Path.Direction.CW);
        invalidateSelf();
    }

    protected void j(Canvas canvas) {
        super.draw(canvas);
    }

    public xt(GradientDrawable.Orientation orientation, @ColorInt int[] iArr) {
        super(orientation, iArr);
        this.f25713j = new Path();
        Paint paint = new Paint(1);
        this.xt = paint;
        paint.setColor(-1);
    }
}
