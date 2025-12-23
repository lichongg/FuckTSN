package com.bytedance.sdk.openadsdk.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.widget.ImageView;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: D:\Downloads\app\classes4.dex */
public class ShadowImageView extends ImageView {

    /* renamed from: j, reason: collision with root package name */
    private Paint f31967j;
    private RectF xt;

    private void j() {
        Paint paint = new Paint();
        this.f31967j = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f31967j.setColor(Color.parseColor("#99333333"));
        this.f31967j.setAntiAlias(true);
        this.f31967j.setStrokeWidth(0.0f);
        this.xt = new RectF();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        RectF rectF = this.xt;
        canvas.drawRoundRect(rectF, rectF.right / 2.0f, rectF.bottom / 2.0f, this.f31967j);
        super.onDraw(canvas);
    }

    public ShadowImageView(Context context) {
        super(context);
        j();
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
