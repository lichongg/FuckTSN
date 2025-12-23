package com.bytedance.adsdk.ugeno.widget.frame;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.bytedance.adsdk.ugeno.cw;
import com.bytedance.adsdk.ugeno.cw.av;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class UGFrameLayout extends FrameLayout {

    /* renamed from: j, reason: collision with root package name */
    private cw f23810j;
    private Map<Integer, av> xt;

    public void j(cw cwVar) {
        this.f23810j = cwVar;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        Map<Integer, av> map = this.xt;
        if (map == null || !map.containsKey(4)) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        cw cwVar = this.f23810j;
        if (cwVar != null) {
            cwVar.r();
        }
        super.onLayout(z5, i6, i7, i8, i9);
        cw cwVar2 = this.f23810j;
        if (cwVar2 != null) {
            cwVar2.j(i6, i7, i8, i9);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i6, int i7) {
        cw cwVar = this.f23810j;
        if (cwVar != null) {
            int[] j6 = cwVar.j(i6, i7);
            super.onMeasure(j6[0], j6[1]);
        } else {
            super.onMeasure(i6, i7);
        }
        cw cwVar2 = this.f23810j;
        if (cwVar2 != null) {
            cwVar2.cw();
        }
    }

    public void setEventMap(Map<Integer, av> map) {
        this.xt = map;
    }

    public UGFrameLayout(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        cw cwVar = this.f23810j;
        if (cwVar != null) {
            cwVar.up();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cw cwVar = this.f23810j;
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
        cw cwVar = this.f23810j;
        if (cwVar != null) {
            cwVar.xt(i6, i7, i8, i9);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z5) {
        super.onWindowFocusChanged(z5);
        cw cwVar = this.f23810j;
        if (cwVar != null) {
            cwVar.j(z5);
        }
    }
}
