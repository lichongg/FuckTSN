package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

/* loaded from: D:\Downloads\app\classes4.dex */
public class DislikeView extends View {
    private Paint ae;
    private final RectF cw;

    /* renamed from: j, reason: collision with root package name */
    private int f25895j;

    /* renamed from: m, reason: collision with root package name */
    private int f25896m;

    /* renamed from: r, reason: collision with root package name */
    private Paint f25897r;
    private int tl;
    private Paint up;
    private int xt;

    private void j() {
        Paint paint = new Paint();
        this.f25897r = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.ae = paint2;
        paint2.setAntiAlias(true);
        Paint paint3 = new Paint();
        this.up = paint3;
        paint3.setAntiAlias(true);
    }

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
        this.f25896m = i6;
    }

    public void setStrokeColor(int i6) {
        this.f25897r.setStyle(Paint.Style.STROKE);
        this.f25897r.setColor(i6);
    }

    public void setStrokeWidth(int i6) {
        this.f25897r.setStrokeWidth(i6);
        this.tl = i6;
    }

    public DislikeView(Context context) {
        super(context);
        this.cw = new RectF();
        j();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.cw;
        int i6 = this.f25896m;
        canvas.drawRoundRect(rectF, i6, i6, this.up);
        RectF rectF2 = this.cw;
        int i7 = this.f25896m;
        canvas.drawRoundRect(rectF2, i7, i7, this.f25897r);
        int i8 = this.f25895j;
        int i9 = this.xt;
        canvas.drawLine(i8 * 0.3f, i9 * 0.3f, i8 * 0.7f, i9 * 0.7f, this.ae);
        int i10 = this.f25895j;
        int i11 = this.xt;
        canvas.drawLine(i10 * 0.7f, i11 * 0.3f, i10 * 0.3f, i11 * 0.7f, this.ae);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        this.f25895j = i6;
        this.xt = i7;
        RectF rectF = this.cw;
        int i10 = this.tl;
        rectF.set(i10, i10, i6 - i10, i7 - i10);
    }
}
