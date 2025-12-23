package com.bytedance.adsdk.ugeno.widget.text;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.text.Html;
import android.widget.TextView;
import com.bytedance.adsdk.ugeno.cw;
import com.bytedance.adsdk.ugeno.j.ae;
import com.bytedance.adsdk.ugeno.j.tl;

/* loaded from: D:\Downloads\app\classes3.dex */
public class RichTextView extends TextView implements ae {

    /* renamed from: j, reason: collision with root package name */
    private cw f23848j;
    private tl xt;

    public float getBorderRadius() {
        return this.xt.j();
    }

    @Override // com.bytedance.adsdk.ugeno.j.ae
    public float getRipple() {
        return this.xt.getRipple();
    }

    @Override // com.bytedance.adsdk.ugeno.j.ae
    public float getRubIn() {
        return this.xt.getRubIn();
    }

    @Override // com.bytedance.adsdk.ugeno.j.ae
    public float getShine() {
        return this.xt.getShine();
    }

    @Override // com.bytedance.adsdk.ugeno.j.ae
    public float getStretch() {
        return this.xt.getStretch();
    }

    public void j(cw cwVar) {
        this.f23848j = cwVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        cw cwVar = this.f23848j;
        if (cwVar != null) {
            cwVar.j(i6, i7, i8, i9);
        }
        super.onLayout(z5, i6, i7, i8, i9);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i6, int i7) {
        cw cwVar = this.f23848j;
        if (cwVar != null) {
            int[] j6 = cwVar.j(i6, i7);
            super.onMeasure(j6[0], j6[1]);
        } else {
            super.onMeasure(i6, i7);
        }
        super.onMeasure(i6, i7);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i6) {
        this.xt.j(i6);
    }

    public void setBorderRadius(float f6) {
        tl tlVar = this.xt;
        if (tlVar != null) {
            tlVar.j(f6);
        }
    }

    public void setRichText(String str) {
        setText(Build.VERSION.SDK_INT >= 24 ? Html.fromHtml(str, 0) : Html.fromHtml(str));
    }

    public void setRipple(float f6) {
        tl tlVar = this.xt;
        if (tlVar != null) {
            tlVar.xt(f6);
        }
    }

    public void setRubIn(float f6) {
        tl tlVar = this.xt;
        if (tlVar != null) {
            tlVar.up(f6);
        }
    }

    public void setShine(float f6) {
        tl tlVar = this.xt;
        if (tlVar != null) {
            tlVar.cw(f6);
        }
    }

    public void setStretch(float f6) {
        tl tlVar = this.xt;
        if (tlVar != null) {
            tlVar.r(f6);
        }
    }

    public RichTextView(Context context) {
        super(context);
        this.xt = new tl(this);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        cw cwVar = this.f23848j;
        if (cwVar != null) {
            cwVar.up();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cw cwVar = this.f23848j;
        if (cwVar != null) {
            cwVar.m();
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        cw cwVar = this.f23848j;
        if (cwVar != null) {
            cwVar.j(canvas);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        cw cwVar = this.f23848j;
        if (cwVar != null) {
            cwVar.xt(i6, i7, i8, i9);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z5) {
        super.onWindowFocusChanged(z5);
        cw cwVar = this.f23848j;
        if (cwVar != null) {
            cwVar.j(z5);
        }
    }
}
