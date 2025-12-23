package com.bytedance.adsdk.ugeno.widget.progressbar;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.adsdk.ugeno.cw;

/* loaded from: D:\Downloads\app\classes3.dex */
public class UGProgressBar extends FrameLayout {
    private View cw;

    /* renamed from: j, reason: collision with root package name */
    private cw f23840j;

    /* renamed from: r, reason: collision with root package name */
    private TextView f23841r;
    private int up;
    private View xt;

    private void j(Context context) {
        this.xt = new View(context);
        this.cw = new View(context);
        addView(this.xt);
        addView(this.cw);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.xt.getLayoutParams();
        layoutParams.width = 0;
        layoutParams.height = -1;
        layoutParams.gravity = 3;
        this.xt.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.cw.getLayoutParams();
        layoutParams2.width = this.up;
        layoutParams2.gravity = 5;
        this.cw.setLayoutParams(layoutParams2);
        TextView textView = new TextView(context);
        this.f23841r = textView;
        textView.setTextColor(-1);
        this.f23841r.setTextSize(16.0f);
        this.f23841r.setGravity(17);
        addView(this.f23841r);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        cw cwVar = this.f23840j;
        if (cwVar != null) {
            cwVar.j(i6, i7, i8, i9);
        }
        super.onLayout(z5, i6, i7, i8, i9);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i6, int i7) {
        cw cwVar = this.f23840j;
        if (cwVar != null) {
            cwVar.j(i6, i7);
        }
        super.onMeasure(i6, i7);
        this.up = j(0, i6);
    }

    public void setProgressBgColor(int i6) {
        this.cw.setBackgroundColor(i6);
    }

    public void setProgressColor(int i6) {
        this.xt.setBackgroundColor(i6);
    }

    public void setText(String str) {
        this.f23841r.setText(str);
    }

    public void setTextColor(int i6) {
        this.f23841r.setTextColor(i6);
    }

    public UGProgressBar(Context context) {
        super(context);
        j(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        cw cwVar = this.f23840j;
        if (cwVar != null) {
            cwVar.up();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cw cwVar = this.f23840j;
        if (cwVar != null) {
            cwVar.m();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        this.up = i6;
        cw cwVar = this.f23840j;
        if (cwVar != null) {
            cwVar.xt(i6, i7, i8, i9);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z5) {
        super.onWindowFocusChanged(z5);
        cw cwVar = this.f23840j;
        if (cwVar != null) {
            cwVar.j(z5);
        }
    }

    public void setProgress(float f6) {
        int width = getWidth();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.xt.getLayoutParams();
        float f7 = width;
        float f8 = (f6 / 100.0f) * f7;
        layoutParams.width = (int) f8;
        this.xt.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.cw.getLayoutParams();
        layoutParams2.width = (int) (f7 - f8);
        this.cw.setLayoutParams(layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.f23841r.getLayoutParams();
        layoutParams3.width = width;
        layoutParams3.gravity = 17;
        requestLayout();
    }

    private int j(int i6, int i7) {
        int mode = View.MeasureSpec.getMode(i7);
        int size = View.MeasureSpec.getSize(i7);
        return mode == 1073741824 ? size : mode == Integer.MIN_VALUE ? Math.min(i6, size) : i6;
    }

    public void j(cw cwVar) {
        this.f23840j = cwVar;
    }
}
