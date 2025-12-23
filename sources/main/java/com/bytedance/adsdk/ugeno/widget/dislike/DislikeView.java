package com.bytedance.adsdk.ugeno.widget.dislike;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import com.bytedance.adsdk.ugeno.cw;

/* loaded from: D:\Downloads\app\classes3.dex */
public class DislikeView extends View {
    private float ae;
    private int cw;

    /* renamed from: g, reason: collision with root package name */
    private int f23805g;

    /* renamed from: j, reason: collision with root package name */
    private cw f23806j;

    /* renamed from: m, reason: collision with root package name */
    private Paint f23807m;

    /* renamed from: r, reason: collision with root package name */
    private RectF f23808r;
    private Paint tl;
    private Paint up;
    private int xt;

    private void j() {
        Paint paint = new Paint();
        this.up = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.tl = paint2;
        paint2.setAntiAlias(true);
        Paint paint3 = new Paint();
        this.f23807m = paint3;
        paint3.setAntiAlias(true);
        setBackgroundColor(0);
    }

    @Override // android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        cw cwVar = this.f23806j;
        if (cwVar != null) {
            cwVar.j(i6, i7, i8, i9);
        }
        super.onLayout(z5, i6, i7, i8, i9);
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        cw cwVar = this.f23806j;
        if (cwVar != null) {
            int[] j6 = cwVar.j(i6, i7);
            super.onMeasure(j6[0], j6[1]);
        } else {
            super.onMeasure(i6, i7);
        }
        super.onMeasure(i6, i7);
    }

    public void setBgColor(int i6) {
        this.f23807m.setStyle(Paint.Style.FILL);
        this.f23807m.setColor(i6);
    }

    public void setDislikeColor(int i6) {
        this.tl.setColor(i6);
    }

    public void setDislikeWidth(int i6) {
        this.tl.setStrokeWidth(i6);
    }

    public void setRadius(float f6) {
        this.ae = f6;
    }

    public void setStrokeColor(int i6) {
        this.up.setStyle(Paint.Style.STROKE);
        this.up.setColor(i6);
    }

    public void setStrokeWidth(int i6) {
        this.up.setStrokeWidth(i6);
        this.f23805g = i6;
    }

    public DislikeView(Context context) {
        super(context);
        j();
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        cw cwVar = this.f23806j;
        if (cwVar != null) {
            cwVar.up();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cw cwVar = this.f23806j;
        if (cwVar != null) {
            cwVar.m();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setBackgroundColor(0);
        RectF rectF = this.f23808r;
        float f6 = this.ae;
        canvas.drawRoundRect(rectF, f6, f6, this.f23807m);
        RectF rectF2 = this.f23808r;
        float f7 = this.ae;
        canvas.drawRoundRect(rectF2, f7, f7, this.up);
        int i6 = this.xt;
        int i7 = this.cw;
        canvas.drawLine(i6 * 0.3f, i7 * 0.3f, i6 * 0.7f, i7 * 0.7f, this.tl);
        int i8 = this.xt;
        int i9 = this.cw;
        canvas.drawLine(i8 * 0.7f, i9 * 0.3f, i8 * 0.3f, i9 * 0.7f, this.tl);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        this.xt = i6;
        this.cw = i7;
        int i10 = this.f23805g;
        this.f23808r = new RectF(i10, i10, this.xt - i10, this.cw - i10);
        cw cwVar = this.f23806j;
        if (cwVar != null) {
            cwVar.xt(i6, i7, i8, i9);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z5) {
        super.onWindowFocusChanged(z5);
        cw cwVar = this.f23806j;
        if (cwVar != null) {
            cwVar.j(z5);
        }
    }

    public void j(com.bytedance.adsdk.ugeno.xt.cw cwVar) {
        this.f23806j = cwVar;
    }
}
