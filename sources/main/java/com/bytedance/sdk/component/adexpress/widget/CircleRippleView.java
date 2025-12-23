package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class CircleRippleView extends View {
    private boolean ae;
    private float cw;

    /* renamed from: g, reason: collision with root package name */
    private List<Integer> f25885g;

    /* renamed from: j, reason: collision with root package name */
    private int f25886j;
    private float jy;

    /* renamed from: m, reason: collision with root package name */
    private int f25887m;
    private Paint oq;
    private Paint qv;

    /* renamed from: r, reason: collision with root package name */
    private int f25888r;
    private List<Integer> tl;
    private float up;
    private float vl;
    private int ws;
    private int xt;

    public CircleRippleView(Context context) {
        this(context, null);
    }

    public void j() {
        this.ae = true;
        invalidate();
    }

    public void setCoreRadius(int i6) {
        this.cw = i6;
    }

    public void setMaxWidth(int i6) {
        this.up = i6;
    }

    public void xt() {
        this.ae = false;
        this.f25885g.clear();
        this.tl.clear();
        this.tl.add(255);
        this.f25885g.add(0);
        invalidate();
    }

    public CircleRippleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    private void cw() {
        Paint paint = new Paint();
        this.oq = paint;
        paint.setAntiAlias(true);
        this.oq.setStrokeWidth(this.ws);
        this.tl.add(255);
        this.f25885g.add(0);
        Paint paint2 = new Paint();
        this.qv = paint2;
        paint2.setAntiAlias(true);
        this.qv.setColor(Color.parseColor("#0FFFFFFF"));
        this.qv.setStyle(Paint.Style.FILL);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.oq.setShader(new LinearGradient(this.vl, 0.0f, this.jy, getMeasuredHeight(), -1, 16777215, Shader.TileMode.CLAMP));
        int i6 = 0;
        while (true) {
            if (i6 >= this.tl.size()) {
                break;
            }
            Integer num = this.tl.get(i6);
            this.oq.setAlpha(num.intValue());
            Integer num2 = this.f25885g.get(i6);
            if (this.cw + num2.intValue() < this.up) {
                canvas.drawCircle(this.vl, this.jy, this.cw + num2.intValue(), this.oq);
            }
            if (num.intValue() > 0 && num2.intValue() < this.up) {
                this.tl.set(i6, Integer.valueOf(num.intValue() - this.f25887m > 0 ? num.intValue() - (this.f25887m * 3) : 1));
                this.f25885g.set(i6, Integer.valueOf(num2.intValue() + this.f25887m));
            }
            i6++;
        }
        List<Integer> list = this.f25885g;
        if (list.get(list.size() - 1).intValue() >= this.up / this.f25888r) {
            this.tl.add(255);
            this.f25885g.add(0);
        }
        if (this.f25885g.size() >= 3) {
            this.f25885g.remove(0);
            this.tl.remove(0);
        }
        this.oq.setAlpha(255);
        this.oq.setColor(this.xt);
        canvas.drawCircle(this.vl, this.jy, this.cw, this.qv);
        if (this.ae) {
            invalidate();
        }
    }

    public void setColor(int i6) {
        this.f25886j = i6;
    }

    public void setCoreColor(int i6) {
        this.xt = i6;
    }

    public void setDiffuseSpeed(int i6) {
        this.f25887m = i6;
    }

    public void setDiffuseWidth(int i6) {
        this.f25888r = i6;
    }

    public CircleRippleView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f25886j = -1;
        this.xt = SupportMenu.CATEGORY_MASK;
        this.cw = 18.0f;
        this.f25888r = 3;
        this.up = 50.0f;
        this.f25887m = 2;
        this.ae = false;
        this.tl = new ArrayList();
        this.f25885g = new ArrayList();
        this.ws = 24;
        cw();
    }

    @Override // android.view.View
    public void invalidate() {
        if (hasWindowFocus()) {
            super.invalidate();
        }
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
        float f6 = i6 / 2.0f;
        this.vl = f6;
        this.jy = i7 / 2.0f;
        float f7 = f6 - (this.ws / 2.0f);
        this.up = f7;
        this.cw = f7 / 4.0f;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z5) {
        super.onWindowFocusChanged(z5);
        if (z5) {
            invalidate();
        }
    }
}
