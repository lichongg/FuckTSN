package com.bytedance.sdk.openadsdk.core.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

/* loaded from: D:\Downloads\app\classes4.dex */
public class DislikeView extends View {
    private Paint ae;
    private RectF cw;

    /* renamed from: j, reason: collision with root package name */
    private int f31161j;

    /* renamed from: m, reason: collision with root package name */
    private int f31162m;

    /* renamed from: r, reason: collision with root package name */
    private Paint f31163r;
    private int tl;
    private Paint up;
    private int xt;

    public void setBgColor(int i6) {
        this.up.setStyle(Paint.Style.FILL);
        this.up.setColor(i6);
    }

    public void setDislikeColor(int i6) {
        this.ae.setColor(i6);
    }

    public void setDislikeWidth(int i6) {
        this.ae.setStrokeWidth(i6);
    }

    public void setRadius(int i6) {
        this.f31162m = i6;
    }

    public void setStrokeColor(int i6) {
        this.f31163r.setStyle(Paint.Style.STROKE);
        this.f31163r.setColor(i6);
    }

    public void setStrokeWidth(int i6) {
        this.f31163r.setStrokeWidth(i6);
        this.tl = i6;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.cw;
        int i6 = this.f31162m;
        canvas.drawRoundRect(rectF, i6, i6, this.up);
        RectF rectF2 = this.cw;
        int i7 = this.f31162m;
        canvas.drawRoundRect(rectF2, i7, i7, this.f31163r);
        int i8 = this.f31161j;
        int i9 = this.xt;
        canvas.drawLine(i8 * 0.3f, i9 * 0.3f, i8 * 0.7f, i9 * 0.7f, this.ae);
        int i10 = this.f31161j;
        int i11 = this.xt;
        canvas.drawLine(i10 * 0.7f, i11 * 0.3f, i10 * 0.3f, i11 * 0.7f, this.ae);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        this.f31161j = i6;
        this.xt = i7;
        int i10 = this.tl;
        this.cw = new RectF(i10, i10, this.f31161j - i10, this.xt - i10);
    }
}
