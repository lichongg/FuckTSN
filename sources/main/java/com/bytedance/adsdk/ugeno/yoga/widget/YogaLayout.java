package com.bytedance.adsdk.ugeno.yoga.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.cw;
import com.bytedance.adsdk.ugeno.j.ae;
import com.bytedance.adsdk.ugeno.j.tl;
import com.bytedance.adsdk.ugeno.yoga.g;
import com.bytedance.adsdk.ugeno.yoga.jy;
import com.bytedance.adsdk.ugeno.yoga.m;
import com.bytedance.adsdk.ugeno.yoga.oq;
import com.bytedance.adsdk.ugeno.yoga.qv;
import com.bytedance.adsdk.ugeno.yoga.r;
import com.bytedance.adsdk.ugeno.yoga.up;
import com.bytedance.adsdk.ugeno.yoga.ws;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class YogaLayout extends ViewGroup implements ae, com.bytedance.adsdk.ugeno.xt.xt {
    private cw cw;

    /* renamed from: j, reason: collision with root package name */
    private final Map<View, oq> f23924j;

    /* renamed from: r, reason: collision with root package name */
    private tl f23925r;
    private final oq xt;

    public static class j extends ViewGroup.LayoutParams {
        private float ae;
        private float av;
        private float az;
        private float cw;

        /* renamed from: g, reason: collision with root package name */
        private float f23926g;

        /* renamed from: i, reason: collision with root package name */
        private float f23927i;

        /* renamed from: j, reason: collision with root package name */
        SparseArray<Float> f23928j;
        private float jy;

        /* renamed from: m, reason: collision with root package name */
        private float f23929m;
        private float mi;
        private float oq;
        private float qv;

        /* renamed from: r, reason: collision with root package name */
        private float f23930r;
        private float tl;
        private float up;
        private float vl;

        /* renamed from: w, reason: collision with root package name */
        private float f23931w;
        private float ws;
        SparseArray<String> xt;

        public j(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            if (layoutParams instanceof j) {
                j jVar = (j) layoutParams;
                this.f23928j = jVar.f23928j.clone();
                this.xt = jVar.xt.clone();
                return;
            }
            this.f23928j = new SparseArray<>();
            this.xt = new SparseArray<>();
            if (layoutParams.width >= 0) {
                this.f23928j.put(15, Float.valueOf(((ViewGroup.LayoutParams) this).width));
            }
            if (layoutParams.height >= 0) {
                this.f23928j.put(16, Float.valueOf(((ViewGroup.LayoutParams) this).height));
            }
        }

        public void ae(float f6) {
            this.jy = f6;
            this.f23928j.put(10, Float.valueOf(f6));
        }

        public void av(float f6) {
            this.f23931w = f6;
            this.f23928j.put(27, Float.valueOf(f6));
        }

        public void az(float f6) {
            this.f23927i = f6;
            this.f23928j.put(25, Float.valueOf(f6));
        }

        public void cw(float f6) {
            this.f23926g = f6;
            this.f23928j.put(7, Float.valueOf(f6));
        }

        public void g(float f6) {
            this.az = f6;
            this.f23928j.put(12, Float.valueOf(f6));
        }

        public void i(float f6) {
            this.mi = f6;
            this.f23928j.put(28, Float.valueOf(f6));
        }

        public void j(float f6) {
            this.ae = f6;
            this.f23928j.put(5, Float.valueOf(f6));
        }

        public void jy(float f6) {
            this.up = f6;
            this.f23928j.put(19, Float.valueOf(f6));
        }

        public void m(float f6) {
            this.vl = f6;
            this.f23928j.put(14, Float.valueOf(f6));
        }

        public void oq(float f6) {
            this.av = f6;
            this.f23928j.put(13, Float.valueOf(f6));
        }

        public void qv(float f6) {
            this.cw = f6;
            this.f23928j.put(17, Float.valueOf(f6));
        }

        public void r(float f6) {
            this.oq = f6;
            this.f23928j.put(8, Float.valueOf(f6));
        }

        public void tl(float f6) {
            this.ws = f6;
            this.f23928j.put(11, Float.valueOf(f6));
        }

        public void up(float f6) {
            this.qv = f6;
            this.f23928j.put(9, Float.valueOf(f6));
        }

        public void vl(float f6) {
            this.f23930r = f6;
            this.f23928j.put(18, Float.valueOf(f6));
        }

        public void ws(float f6) {
            this.f23929m = f6;
            this.f23928j.put(20, Float.valueOf(f6));
        }

        public void xt(float f6) {
            this.tl = f6;
            this.f23928j.put(6, Float.valueOf(f6));
        }

        public j(int i6, int i7) {
            super(i6, i7);
            this.f23928j = new SparseArray<>();
            this.xt = new SparseArray<>();
            if (i6 == -2 || i6 == -1 || i6 >= 0) {
                this.f23928j.put(15, Float.valueOf(i6));
            }
            if (i7 == -2 || i7 == -1 || i7 >= 0) {
                this.f23928j.put(16, Float.valueOf(i7));
            }
        }
    }

    public YogaLayout(Context context) {
        this(context, null, 0);
    }

    public oq j(View view) {
        return this.f23924j.get(view);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        j(view, false);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(View view) {
        j(view, true);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i6, int i7) {
        for (int i8 = i6; i8 < i6 + i7; i8++) {
            j(getChildAt(i8), false);
        }
        super.removeViews(i6, i7);
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int i6, int i7) {
        for (int i8 = i6; i8 < i6 + i7; i8++) {
            j(getChildAt(i8), true);
        }
        super.removeViewsInLayout(i6, i7);
    }

    @Override // com.bytedance.adsdk.ugeno.xt.xt
    public void xt(int i6) {
        oq oqVar = this.xt;
        if (oqVar != null) {
            xt(oqVar, i6);
            requestLayout();
        }
    }

    public YogaLayout(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f23925r = new tl(this);
        oq j6 = qv.j();
        this.xt = j6;
        this.f23924j = new HashMap();
        j6.j(this);
        j6.j((com.bytedance.adsdk.ugeno.yoga.ae) new xt());
        j((j) generateDefaultLayoutParams(), j6, this);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i6, ViewGroup.LayoutParams layoutParams) {
        oq j6;
        this.xt.j((com.bytedance.adsdk.ugeno.yoga.ae) null);
        if (view instanceof VirtualYogaLayout) {
            VirtualYogaLayout virtualYogaLayout = (VirtualYogaLayout) view;
            virtualYogaLayout.j(this);
            oq yogaNode = virtualYogaLayout.getYogaNode();
            oq oqVar = this.xt;
            oqVar.j(yogaNode, oqVar.j());
            return;
        }
        super.addView(view, i6, layoutParams);
        if (this.f23924j.containsKey(view)) {
            return;
        }
        if (view instanceof YogaLayout) {
            j6 = ((YogaLayout) view).getYogaNode();
        } else {
            j6 = this.f23924j.containsKey(view) ? this.f23924j.get(view) : qv.j();
            j6.j(view);
            j6.j((com.bytedance.adsdk.ugeno.yoga.ae) new xt());
        }
        j((j) view.getLayoutParams(), j6, view);
        this.f23924j.put(view, j6);
        if (view.getVisibility() == 8) {
            view.setTag(151060224, Integer.valueOf(this.xt.j()));
        } else {
            oq oqVar2 = this.xt;
            oqVar2.j(j6, oqVar2.j());
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof j;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new j(-1, -1);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new j(layoutParams);
    }

    public float getBorderRadius() {
        return this.f23925r.j();
    }

    @Override // com.bytedance.adsdk.ugeno.j.ae
    public float getRipple() {
        return this.f23925r.getRipple();
    }

    @Override // com.bytedance.adsdk.ugeno.j.ae
    public float getRubIn() {
        return this.f23925r.getRubIn();
    }

    @Override // com.bytedance.adsdk.ugeno.j.ae
    public float getShine() {
        return this.f23925r.getShine();
    }

    @Override // com.bytedance.adsdk.ugeno.j.ae
    public float getStretch() {
        return this.f23925r.getStretch();
    }

    public oq getYogaNode() {
        return this.xt;
    }

    @Override // com.bytedance.adsdk.ugeno.xt.xt
    public void j(int i6) {
        oq oqVar = this.xt;
        if (oqVar != null) {
            j(oqVar, i6);
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        cw cwVar = this.cw;
        if (cwVar != null) {
            cwVar.r();
        }
        if (!(getParent() instanceof YogaLayout)) {
            j(View.MeasureSpec.makeMeasureSpec(i8 - i6, 1073741824), View.MeasureSpec.makeMeasureSpec(i9 - i7, 1073741824));
        }
        j(this.xt, 0.0f, 0.0f);
        cw cwVar2 = this.cw;
        if (cwVar2 != null) {
            cwVar2.j(i6, i7, i8, i9);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i6) {
        this.f23925r.j(i6);
    }

    public void setBorderRadius(float f6) {
        this.f23925r.j(f6);
    }

    public void setRipple(float f6) {
        tl tlVar = this.f23925r;
        if (tlVar != null) {
            tlVar.xt(f6);
        }
    }

    public void setRubIn(float f6) {
        tl tlVar = this.f23925r;
        if (tlVar != null) {
            tlVar.up(f6);
        }
    }

    public void setShine(float f6) {
        tl tlVar = this.f23925r;
        if (tlVar != null) {
            tlVar.cw(f6);
        }
    }

    public void setStretch(float f6) {
        tl tlVar = this.f23925r;
        if (tlVar != null) {
            tlVar.r(f6);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.xt.xt
    public void cw(View view, int i6) {
        r(view, i6);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        cw cwVar = this.cw;
        if (cwVar != null) {
            cwVar.up();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cw cwVar = this.cw;
        if (cwVar != null) {
            cwVar.m();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        cw cwVar = this.cw;
        if (cwVar != null) {
            cwVar.j(canvas);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        if (!(getParent() instanceof YogaLayout)) {
            j(i6, i7);
        }
        cw cwVar = this.cw;
        if (cwVar != null) {
            int[] j6 = cwVar.j(i6, i7);
            setMeasuredDimension(j6[0], j6[1]);
        } else {
            setMeasuredDimension(Math.round(this.xt.tl()), Math.round(this.xt.g()));
        }
        cw cwVar2 = this.cw;
        if (cwVar2 != null) {
            cwVar2.cw();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        cw cwVar = this.cw;
        if (cwVar != null) {
            cwVar.xt(i6, i7, i8, i9);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z5) {
        super.onWindowFocusChanged(z5);
        cw cwVar = this.cw;
        if (cwVar != null) {
            cwVar.j(z5);
        }
    }

    public void r(View view, int i6) {
        int j6;
        view.setVisibility(i6);
        try {
            oq oqVar = this.f23924j.get(view);
            Object tag = view.getTag(151060224);
            if (i6 == 0) {
                if (tag != null && this.xt.j(oqVar) == -1) {
                    int intValue = ((Integer) tag).intValue();
                    if (intValue < this.xt.j()) {
                        this.xt.j(this.f23924j.get(view), intValue);
                    } else {
                        this.xt.j(this.f23924j.get(view), this.xt.j());
                    }
                    j(this.xt);
                    return;
                }
                return;
            }
            if (i6 == 8 && (j6 = this.xt.j(oqVar)) != -1) {
                this.xt.xt(j6);
                view.setTag(151060224, Integer.valueOf(j6));
                j(this.xt);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            j(getChildAt(i6), false);
        }
        super.removeAllViews();
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            j(getChildAt(i6), true);
        }
        super.removeAllViewsInLayout();
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i6) {
        j(getChildAt(i6), false);
        super.removeViewAt(i6);
    }

    @Override // com.bytedance.adsdk.ugeno.xt.xt
    public void xt(View view, int i6) {
        oq j6;
        if (view == null || (j6 = j(view)) == null) {
            return;
        }
        xt(j6, i6);
        view.requestLayout();
    }

    @Override // com.bytedance.adsdk.ugeno.xt.xt
    public void j(View view, int i6) {
        oq j6;
        if (view == null || (j6 = j(view)) == null) {
            return;
        }
        j(j6, i6);
        view.requestLayout();
    }

    private void xt(oq oqVar, int i6) {
        if (i6 == -1) {
            oqVar.ae(100.0f);
        } else if (i6 == -2) {
            oqVar.up();
        } else {
            oqVar.m(i6);
        }
    }

    private void j(oq oqVar, int i6) {
        if (i6 == -1) {
            oqVar.up(100.0f);
        } else if (i6 == -2) {
            oqVar.r();
        } else {
            oqVar.r(i6);
        }
    }

    public static class xt implements com.bytedance.adsdk.ugeno.yoga.ae {
        @Override // com.bytedance.adsdk.ugeno.yoga.ae
        public long j(oq oqVar, float f6, com.bytedance.adsdk.ugeno.yoga.tl tlVar, float f7, com.bytedance.adsdk.ugeno.yoga.tl tlVar2) {
            View view = (View) oqVar.oq();
            if (view == null || (view instanceof YogaLayout)) {
                return g.j(0, 0);
            }
            view.measure(View.MeasureSpec.makeMeasureSpec((int) f6, j(tlVar)), View.MeasureSpec.makeMeasureSpec((int) f7, j(tlVar2)));
            return g.j(view.getMeasuredWidth(), view.getMeasuredHeight());
        }

        private int j(com.bytedance.adsdk.ugeno.yoga.tl tlVar) {
            if (tlVar == com.bytedance.adsdk.ugeno.yoga.tl.AT_MOST) {
                return Integer.MIN_VALUE;
            }
            return tlVar == com.bytedance.adsdk.ugeno.yoga.tl.EXACTLY ? 1073741824 : 0;
        }
    }

    private void j(oq oqVar) {
        if (oqVar.xt() != null) {
            j(oqVar.xt());
        } else {
            oqVar.j(Float.NaN, Float.NaN);
        }
    }

    public void j(View view, oq oqVar) {
        this.f23924j.put(view, oqVar);
        addView(view);
    }

    private void j(View view, boolean z5) {
        oq oqVar = this.f23924j.get(view);
        if (oqVar == null) {
            return;
        }
        oq xt2 = oqVar.xt();
        int i6 = 0;
        while (true) {
            if (i6 >= xt2.j()) {
                break;
            }
            if (xt2.j(i6).equals(oqVar)) {
                xt2.xt(i6);
                break;
            }
            i6++;
        }
        oqVar.j((Object) null);
        this.f23924j.remove(view);
        if (z5) {
            this.xt.j(Float.NaN, Float.NaN);
        }
    }

    private void j(oq oqVar, float f6, float f7) {
        View view = (View) oqVar.oq();
        if (view != null && view != this) {
            if (view.getVisibility() == 8) {
                return;
            }
            int round = Math.round(oqVar.m() + f6);
            int round2 = Math.round(oqVar.ae() + f7);
            view.measure(View.MeasureSpec.makeMeasureSpec(Math.round(oqVar.tl()), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.round(oqVar.g()), 1073741824));
            view.layout(round, round2, view.getMeasuredWidth() + round, view.getMeasuredHeight() + round2);
        }
        int j6 = oqVar.j();
        for (int i6 = 0; i6 < j6; i6++) {
            if (equals(view)) {
                j(oqVar.j(i6), f6, f7);
            } else if (!(view instanceof YogaLayout)) {
                j(oqVar.j(i6), oqVar.m() + f6, oqVar.ae() + f7);
            }
        }
    }

    private void j(int i6, int i7) {
        int size = View.MeasureSpec.getSize(i6);
        int size2 = View.MeasureSpec.getSize(i7);
        int mode = View.MeasureSpec.getMode(i6);
        int mode2 = View.MeasureSpec.getMode(i7);
        if (mode2 == 1073741824) {
            this.xt.m(size2);
        }
        if (mode == 1073741824) {
            this.xt.r(size);
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.xt.qv(size2);
        }
        if (mode == Integer.MIN_VALUE) {
            this.xt.oq(size);
        }
        this.xt.j(Float.NaN, Float.NaN);
    }

    protected static void j(j jVar, oq oqVar, View view) {
        if (view.getResources().getConfiguration().getLayoutDirection() == 1) {
            oqVar.j(com.bytedance.adsdk.ugeno.yoga.cw.RTL);
        }
        Drawable background = view.getBackground();
        if (background != null) {
            if (background.getPadding(new Rect())) {
                oqVar.xt(r.LEFT, r0.left);
                oqVar.xt(r.TOP, r0.top);
                oqVar.xt(r.RIGHT, r0.right);
                oqVar.xt(r.BOTTOM, r0.bottom);
            }
        }
        for (int i6 = 0; i6 < jVar.f23928j.size(); i6++) {
            int keyAt = jVar.f23928j.keyAt(i6);
            float floatValue = jVar.f23928j.valueAt(i6).floatValue();
            if (keyAt == 4) {
                oqVar.cw(com.bytedance.adsdk.ugeno.yoga.j.j(Math.round(floatValue)));
            } else if (keyAt == 0) {
                oqVar.j(com.bytedance.adsdk.ugeno.yoga.j.j(Math.round(floatValue)));
            } else if (keyAt == 9) {
                oqVar.xt(com.bytedance.adsdk.ugeno.yoga.j.j(Math.round(floatValue)));
            } else if (keyAt == 25) {
                oqVar.vl(floatValue);
            } else if (keyAt == 8) {
                if (floatValue < 0.0f) {
                    oqVar.cw();
                } else {
                    oqVar.cw(floatValue);
                }
            } else if (keyAt == 1) {
                oqVar.j(up.j(Math.round(floatValue)));
            } else if (keyAt == 6) {
                oqVar.j(floatValue);
            } else if (keyAt == 7) {
                oqVar.xt(floatValue);
            } else if (keyAt == 16) {
                if (floatValue == -1.0f) {
                    oqVar.ae(100.0f);
                } else if (floatValue == -2.0f) {
                    oqVar.up();
                } else {
                    oqVar.m(floatValue);
                }
            } else if (keyAt == 18) {
                oqVar.j(r.LEFT, floatValue);
            } else if (keyAt == 3) {
                oqVar.j(m.j(Math.round(floatValue)));
            } else if (keyAt == 17) {
                oqVar.j(r.TOP, floatValue);
            } else if (keyAt == 20) {
                oqVar.j(r.RIGHT, floatValue);
            } else if (keyAt == 19) {
                oqVar.j(r.BOTTOM, floatValue);
            } else if (keyAt == 28) {
                oqVar.g(floatValue);
            } else if (keyAt == 27) {
                oqVar.tl(floatValue);
            } else if (keyAt == 22) {
                oqVar.xt(r.LEFT, floatValue);
            } else if (keyAt == 21) {
                oqVar.xt(r.TOP, floatValue);
            } else if (keyAt == 24) {
                oqVar.xt(r.RIGHT, floatValue);
            } else if (keyAt == 23) {
                oqVar.xt(r.BOTTOM, floatValue);
            } else if (keyAt == 11) {
                oqVar.cw(r.LEFT, floatValue);
            } else if (keyAt == 10) {
                oqVar.cw(r.TOP, floatValue);
            } else if (keyAt == 13) {
                oqVar.cw(r.RIGHT, floatValue);
            } else if (keyAt == 12) {
                oqVar.cw(r.BOTTOM, floatValue);
            } else if (keyAt == 14) {
                oqVar.j(jy.j(Math.round(floatValue)));
            } else if (keyAt == 15) {
                if (floatValue == -1.0f) {
                    oqVar.up(100.0f);
                } else if (floatValue == -2.0f) {
                    oqVar.r();
                } else {
                    oqVar.r(floatValue);
                }
            } else if (keyAt == 2) {
                oqVar.j(ws.j(Math.round(floatValue)));
            }
        }
    }

    public void j(com.bytedance.adsdk.ugeno.xt.cw cwVar) {
        this.cw = cwVar;
    }
}
