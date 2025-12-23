package com.bytedance.sdk.component.adexpress.widget;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.widget.ImageView;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: D:\Downloads\app\classes4.dex */
public class ShadowImageView extends ImageView {

    /* renamed from: j, reason: collision with root package name */
    private Paint f25965j;
    private RectF xt;

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        RectF rectF = this.xt;
        canvas.drawRoundRect(rectF, rectF.right / 2.0f, rectF.bottom / 2.0f, this.f25965j);
        super.onDraw(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i6, int i7) {
        super.onMeasure(i6, i7);
        if (this.xt.right == getMeasuredWidth() && this.xt.bottom == getMeasuredHeight()) {
            return;
        }
        this.xt.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
    }
}
