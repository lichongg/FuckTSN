package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j extends xt {
    private final Bitmap cw;
    private final Rect xt = new Rect();

    /* renamed from: r, reason: collision with root package name */
    private final Paint f25712r = new Paint(1);

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.xt
    protected void j(Canvas canvas) {
        canvas.drawBitmap(this.cw, this.xt, getBounds(), this.f25712r);
    }

    public j(Bitmap bitmap, xt xtVar) {
        this.cw = bitmap;
        if (xtVar != null) {
            this.f25713j = xtVar.f25713j;
        }
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        int height = rect.height();
        int width = rect.width();
        int width2 = this.cw.getWidth();
        int height2 = this.cw.getHeight();
        this.xt.set(0, 0, width2, height2);
        if (height2 >= height && width2 >= width) {
            if (width2 > width) {
                Rect rect2 = this.xt;
                int i6 = (width2 - width) / 2;
                rect2.left = i6;
                rect2.right = i6 + width;
            }
            if (height2 > height) {
                Rect rect3 = this.xt;
                int i7 = (height2 - height) / 2;
                rect3.top = i7;
                rect3.bottom = i7 + height;
                return;
            }
            return;
        }
        float f6 = height;
        float f7 = f6 * 1.0f;
        float f8 = height2;
        float f9 = f7 / f8;
        float f10 = width;
        float f11 = 1.0f * f10;
        float f12 = width2;
        if (Math.max(f9, f11 / f12) > f9) {
            int i8 = (int) ((f7 / f10) * f12);
            Rect rect4 = this.xt;
            int i9 = (height2 - i8) / 2;
            rect4.top = i9;
            rect4.bottom = i9 + i8;
            return;
        }
        int i10 = (int) ((f11 / f6) * f8);
        Rect rect5 = this.xt;
        int i11 = (width2 - i10) / 2;
        rect5.left = i11;
        rect5.right = i11 + i10;
    }
}
