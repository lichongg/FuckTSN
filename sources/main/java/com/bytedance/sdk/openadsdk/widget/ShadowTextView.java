package com.bytedance.sdk.openadsdk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ShadowTextView extends TextView {
    private int cw;

    /* renamed from: j, reason: collision with root package name */
    private Paint f31968j;
    private RectF xt;

    public ShadowTextView(Context context) {
        this(context, null);
    }

    private void j() {
        setTextColor(-1);
        Paint paint = new Paint();
        this.f31968j = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f31968j.setColor(Color.parseColor("#99333333"));
        this.f31968j.setAntiAlias(true);
        this.f31968j.setStrokeWidth(0.0f);
        this.xt = new RectF();
    }

    public ShadowTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        RectF rectF = this.xt;
        float f6 = rectF.bottom;
        canvas.drawRoundRect(rectF, f6 / 2.0f, f6 / 2.0f, this.f31968j);
        canvas.translate((this.xt.right / 2.0f) - (getPaint().measureText(getText().toString()) / 2.0f), 0.0f);
        super.onDraw(canvas);
    }

    public ShadowTextView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.cw = 0;
        j();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i6, int i7) {
        super.onMeasure(i6, i7);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            int measureText = (int) getPaint().measureText("00");
            this.cw = measureText;
            if (measuredWidth < measureText) {
                measuredWidth = measureText;
            }
            int i8 = measuredWidth + ((measuredHeight / 2) * 2);
            setMeasuredDimension(i8, measuredHeight);
            this.xt.set(0.0f, 0.0f, i8, measuredHeight);
            return;
        }
        this.xt.set(0.0f, 0.0f, 0.0f, 0.0f);
    }
}
