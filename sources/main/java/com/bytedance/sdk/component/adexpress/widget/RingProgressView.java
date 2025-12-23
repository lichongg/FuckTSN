package com.bytedance.sdk.component.adexpress.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

/* loaded from: D:\Downloads\app\classes4.dex */
public class RingProgressView extends View {
    private boolean ae;
    private RectF cw;

    /* renamed from: j, reason: collision with root package name */
    private Context f25955j;

    /* renamed from: m, reason: collision with root package name */
    private int f25956m;

    /* renamed from: r, reason: collision with root package name */
    private float f25957r;
    private ValueAnimator up;
    private Paint xt;

    public void cw() {
        this.ae = true;
        invalidate();
    }

    public void j() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 360.0f);
        this.up = ofFloat;
        ofFloat.setDuration(this.f25956m);
        this.up.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.widget.RingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RingProgressView.this.f25957r = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                RingProgressView.this.requestLayout();
            }
        });
        this.up.start();
    }

    public void setDuration(int i6) {
        this.f25956m = i6;
    }

    public void xt() {
        ValueAnimator valueAnimator = this.up;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public RingProgressView(Context context) {
        super(context);
        this.f25956m = 1500;
        this.f25955j = context;
        Paint paint = new Paint();
        this.xt = paint;
        paint.setAntiAlias(true);
        this.xt.setStyle(Paint.Style.STROKE);
        this.xt.setStrokeWidth(10.0f);
        this.xt.setColor(Color.parseColor("#80FFFFFF"));
        this.cw = new RectF();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.ae) {
            return;
        }
        canvas.drawArc(this.cw, 270.0f, this.f25957r, false, this.xt);
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        super.onMeasure(i6, i7);
        int size = View.MeasureSpec.getSize(i6);
        int size2 = View.MeasureSpec.getSize(i7);
        setMeasuredDimension(Math.min(size, size2), Math.min(size, size2));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        this.cw.set(5.0f, 5.0f, i6 - 5, i7 - 5);
    }
}
