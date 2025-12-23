package com.scwang.smartrefresh.header.fungame;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import m2.c;
import m2.e;
import m2.g;
import m2.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class FunGameBase extends FrameLayout implements e {

    /* renamed from: a, reason: collision with root package name */
    protected int f37095a;

    /* renamed from: b, reason: collision with root package name */
    protected int f37096b;

    /* renamed from: c, reason: collision with root package name */
    protected int f37097c;

    /* renamed from: d, reason: collision with root package name */
    protected float f37098d;

    /* renamed from: e, reason: collision with root package name */
    protected boolean f37099e;

    /* renamed from: f, reason: collision with root package name */
    protected boolean f37100f;

    /* renamed from: g, reason: collision with root package name */
    protected boolean f37101g;

    /* renamed from: h, reason: collision with root package name */
    protected RefreshState f37102h;

    /* renamed from: i, reason: collision with root package name */
    protected g f37103i;

    /* renamed from: j, reason: collision with root package name */
    protected c f37104j;

    /* renamed from: k, reason: collision with root package name */
    boolean f37105k;

    public FunGameBase(Context context) {
        super(context);
        a(context);
    }

    @Override // m2.f
    public void h(h hVar, int i6, int i7) {
        this.f37099e = false;
    }

    @Override // m2.f
    public boolean j() {
        return false;
    }

    protected void A() {
        if (this.f37101g) {
            return;
        }
        this.f37101g = true;
        this.f37104j = this.f37103i.m();
        this.f37105k = this.f37103i.c().z();
        this.f37103i.c().v(false);
        View view = this.f37104j.getView();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.topMargin += this.f37096b;
        view.setLayoutParams(marginLayoutParams);
    }

    @Override // m2.f
    public int d(h hVar, boolean z5) {
        this.f37100f = z5;
        if (!this.f37099e) {
            this.f37099e = true;
            if (this.f37101g) {
                if (this.f37098d != -1.0f) {
                    return Integer.MAX_VALUE;
                }
                z();
                d(hVar, z5);
                return 0;
            }
        }
        return 0;
    }

    @Override // m2.f
    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.MatchLayout;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f37102h == RefreshState.Refreshing || super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0029, code lost:
    
        if (r1 != 3) goto L27;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r22) {
        /*
            r21 = this;
            r0 = r21
            com.scwang.smartrefresh.layout.constant.RefreshState r1 = r0.f37102h
            com.scwang.smartrefresh.layout.constant.RefreshState r2 = com.scwang.smartrefresh.layout.constant.RefreshState.Refreshing
            if (r1 == r2) goto L12
            com.scwang.smartrefresh.layout.constant.RefreshState r2 = com.scwang.smartrefresh.layout.constant.RefreshState.RefreshFinish
            if (r1 != r2) goto Ld
            goto L12
        Ld:
            boolean r1 = super.onTouchEvent(r22)
            return r1
        L12:
            boolean r1 = r0.f37101g
            if (r1 != 0) goto L19
            r0.A()
        L19:
            int r1 = r22.getAction()
            r1 = r1 & 255(0xff, float:3.57E-43)
            r2 = 0
            r3 = 1
            if (r1 == 0) goto Lae
            if (r1 == r3) goto L9b
            r4 = 3
            r5 = 2
            if (r1 == r5) goto L2d
            if (r1 == r4) goto L9b
            goto Lb9
        L2d:
            float r1 = r22.getRawY()
            float r6 = r0.f37098d
            float r1 = r1 - r6
            r6 = 0
            r7 = 4636737291354636288(0x4059000000000000, double:100.0)
            r13 = 0
            int r6 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r6 < 0) goto L6b
            int r6 = r0.f37096b
            int r6 = r6 * 2
            r15 = 3
            r16 = 2
            double r4 = (double) r6
            int r6 = r0.f37097c
            int r6 = r6 * 2
            int r6 = r6 / r15
            r17 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r9 = (double) r6
            r19 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            double r11 = (double) r1
            double r11 = r11 * r19
            double r11 = java.lang.Math.max(r13, r11)
            double r13 = -r11
            double r13 = r13 / r9
            double r6 = java.lang.Math.pow(r7, r13)
            double r9 = r17 - r6
            double r4 = r4 * r9
            double r4 = java.lang.Math.min(r4, r11)
            m2.g r1 = r0.f37103i
            int r4 = (int) r4
            r1.k(r4, r2)
            goto Lb9
        L6b:
            r15 = 3
            r16 = 2
            r17 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r19 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            int r4 = r0.f37096b
            int r4 = r4 * 2
            double r4 = (double) r4
            int r6 = r0.f37097c
            int r6 = r6 * 2
            int r6 = r6 / r15
            double r9 = (double) r6
            double r11 = (double) r1
            double r11 = r11 * r19
            double r11 = java.lang.Math.min(r13, r11)
            double r11 = -r11
            double r13 = -r11
            double r13 = r13 / r9
            double r6 = java.lang.Math.pow(r7, r13)
            double r9 = r17 - r6
            double r4 = r4 * r9
            double r4 = java.lang.Math.min(r4, r11)
            double r4 = -r4
            m2.g r1 = r0.f37103i
            int r4 = (int) r4
            r1.k(r4, r2)
            goto Lb9
        L9b:
            r0.z()
            r1 = -1082130432(0xffffffffbf800000, float:-1.0)
            r0.f37098d = r1
            boolean r1 = r0.f37099e
            if (r1 == 0) goto Lb9
            m2.g r1 = r0.f37103i
            int r2 = r0.f37096b
            r1.k(r2, r3)
            goto Lb9
        Lae:
            float r1 = r22.getRawY()
            r0.f37098d = r1
            m2.g r1 = r0.f37103i
            r1.k(r2, r3)
        Lb9:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.header.fungame.FunGameBase.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // m2.f
    public void q(g gVar, int i6, int i7) {
        this.f37103i = gVar;
        this.f37096b = i6;
        setTranslationY(this.f37095a - i6);
        gVar.i(true);
    }

    @Override // n2.f
    public void x(h hVar, RefreshState refreshState, RefreshState refreshState2) {
        this.f37102h = refreshState2;
    }

    @Override // m2.e
    public void y(float f6, int i6, int i7, int i8) {
        if (this.f37101g) {
            f(f6, i6, i7, i8);
        } else {
            this.f37095a = i6;
            setTranslationY(i6 - this.f37096b);
        }
    }

    protected void z() {
        if (!this.f37099e) {
            this.f37103i.k(0, true);
            return;
        }
        this.f37101g = false;
        this.f37103i.c().v(this.f37105k);
        if (this.f37098d != -1.0f) {
            d(this.f37103i.c(), this.f37100f);
            this.f37103i.e(RefreshState.RefreshFinish);
            this.f37103i.b(0);
        } else {
            this.f37103i.k(this.f37096b, true);
        }
        View view = this.f37104j.getView();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.topMargin -= this.f37096b;
        view.setLayoutParams(marginLayoutParams);
    }

    public FunGameBase(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    private void a(Context context) {
        this.f37097c = context.getResources().getDisplayMetrics().heightPixels;
    }

    @Override // m2.e
    public void g(float f6, int i6, int i7, int i8) {
        y(f6, i6, i7, i8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f37103i = null;
        this.f37104j = null;
    }

    @Override // android.view.View
    public void setTranslationY(float f6) {
        if (!isInEditMode()) {
            super.setTranslationY(f6);
        }
    }

    public FunGameBase(Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        a(context);
    }

    @RequiresApi(21)
    public FunGameBase(Context context, @Nullable AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
        a(context);
    }

    @Override // m2.f
    @NonNull
    public View getView() {
        return this;
    }

    @Override // m2.f
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
    }

    @Override // m2.f
    public void i(float f6, int i6, int i7) {
    }

    @Override // m2.e
    public void w(h hVar, int i6, int i7) {
    }

    protected void f(float f6, int i6, int i7, int i8) {
    }
}
