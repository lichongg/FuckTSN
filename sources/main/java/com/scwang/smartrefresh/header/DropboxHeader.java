package com.scwang.smartrefresh.header;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import m2.g;
import m2.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class DropboxHeader extends View implements m2.e {

    /* renamed from: a, reason: collision with root package name */
    private Path f36882a;

    /* renamed from: b, reason: collision with root package name */
    private Paint f36883b;

    /* renamed from: c, reason: collision with root package name */
    private e f36884c;

    /* renamed from: d, reason: collision with root package name */
    private int f36885d;

    /* renamed from: e, reason: collision with root package name */
    private int f36886e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f36887f;

    /* renamed from: g, reason: collision with root package name */
    private Drawable f36888g;

    /* renamed from: h, reason: collision with root package name */
    private Drawable f36889h;

    /* renamed from: i, reason: collision with root package name */
    private Drawable f36890i;

    /* renamed from: j, reason: collision with root package name */
    private float f36891j;

    /* renamed from: k, reason: collision with root package name */
    private float f36892k;

    /* renamed from: l, reason: collision with root package name */
    private ValueAnimator f36893l;

    /* renamed from: m, reason: collision with root package name */
    private ValueAnimator f36894m;

    /* renamed from: n, reason: collision with root package name */
    private RefreshState f36895n;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            DropboxHeader.this.f36892k = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            DropboxHeader.this.invalidate();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (DropboxHeader.this.f36895n != RefreshState.Refreshing || DropboxHeader.this.f36894m == null) {
                return;
            }
            DropboxHeader.this.f36894m.start();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (DropboxHeader.this.f36891j < 1.0f || DropboxHeader.this.f36891j >= 3.0f) {
                DropboxHeader.this.f36891j = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            } else if (DropboxHeader.this.f36891j < 2.0f) {
                DropboxHeader.this.f36891j = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 1.0f;
            } else if (DropboxHeader.this.f36891j < 3.0f) {
                DropboxHeader.this.f36891j = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 2.0f;
                if (DropboxHeader.this.f36891j == 3.0f) {
                    DropboxHeader.this.f36887f = true;
                }
            }
            DropboxHeader.this.invalidate();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (DropboxHeader.this.f36893l != null) {
                DropboxHeader.this.f36893l.start();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class e {

        /* renamed from: a, reason: collision with root package name */
        private int f36900a;

        /* renamed from: b, reason: collision with root package name */
        private int f36901b;

        /* renamed from: c, reason: collision with root package name */
        private int f36902c;

        /* renamed from: d, reason: collision with root package name */
        private int f36903d;

        /* renamed from: e, reason: collision with root package name */
        private int f36904e;

        /* renamed from: f, reason: collision with root package name */
        private int f36905f;

        /* renamed from: g, reason: collision with root package name */
        private int f36906g;

        /* renamed from: h, reason: collision with root package name */
        private int f36907h;

        /* renamed from: i, reason: collision with root package name */
        private int f36908i;

        private e() {
        }

        /* synthetic */ e(a aVar) {
            this();
        }

        e j(int i6, int i7, int i8, int i9) {
            this.f36908i = i8;
            int i10 = i6 / 2;
            this.f36900a = i10;
            int i11 = i7 - i9;
            this.f36902c = i11;
            this.f36903d = i11 - (i8 * 2);
            int sin = i10 - ((int) (i8 * Math.sin(1.0471975511965976d)));
            this.f36904e = sin;
            int i12 = i8 / 2;
            this.f36905f = this.f36903d + i12;
            int i13 = this.f36902c;
            this.f36906g = i13 - i12;
            this.f36907h = i6 - sin;
            this.f36901b = i13 - i8;
            return this;
        }
    }

    public DropboxHeader(Context context) {
        super(context);
        K(context, null);
    }

    @Override // m2.f
    public int d(h hVar, boolean z5) {
        this.f36891j = 0.0f;
        return 0;
    }

    @Override // m2.e
    public void g(float f6, int i6, int i7, int i8) {
        this.f36892k = (Math.max(0, i6 - i7) * 1.0f) / i8;
    }

    @Override // m2.f
    public boolean j() {
        return false;
    }

    @Override // m2.f
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        if (iArr.length > 0) {
            setBackgroundColor(iArr[0]);
            if (iArr.length > 1) {
                this.f36885d = iArr[1];
            }
        }
    }

    @NonNull
    private e E(int i6, int i7, int i8) {
        return this.f36884c.j(i6, i7, i8, i8 / 2);
    }

    @NonNull
    private Path F(e eVar) {
        this.f36882a.reset();
        this.f36882a.moveTo(eVar.f36904e, eVar.f36906g);
        this.f36882a.lineTo(eVar.f36900a, eVar.f36902c);
        this.f36882a.lineTo(eVar.f36907h, eVar.f36906g);
        this.f36882a.quadTo(eVar.f36907h + ((eVar.f36908i / 2) * this.f36892k), eVar.f36901b, eVar.f36907h, eVar.f36905f);
        this.f36882a.lineTo(eVar.f36900a, eVar.f36903d);
        this.f36882a.lineTo(eVar.f36904e, eVar.f36905f);
        this.f36882a.quadTo(eVar.f36904e - ((eVar.f36908i / 2) * this.f36892k), eVar.f36901b, eVar.f36904e, eVar.f36906g);
        this.f36882a.close();
        return this.f36882a;
    }

    @NonNull
    private Path G(e eVar) {
        this.f36882a.reset();
        double d6 = this.f36892k * 1.2566370614359172d;
        float f6 = ((eVar.f36900a - eVar.f36904e) * 4) / 5;
        double d7 = 1.0471975511965976d - (d6 / 2.0d);
        float sin = ((float) Math.sin(d7)) * f6;
        float cos = ((float) Math.cos(d7)) * f6;
        this.f36882a.moveTo(eVar.f36904e, eVar.f36905f);
        this.f36882a.lineTo(eVar.f36900a, eVar.f36903d);
        this.f36882a.lineTo(eVar.f36900a - sin, eVar.f36903d - cos);
        this.f36882a.lineTo(eVar.f36904e - sin, eVar.f36905f - cos);
        this.f36882a.close();
        double d8 = d6 + 1.0471975511965976d;
        float sin2 = ((float) Math.sin(d8)) * f6;
        float cos2 = ((float) Math.cos(d8)) * f6;
        this.f36882a.moveTo(eVar.f36904e, eVar.f36905f);
        this.f36882a.lineTo(eVar.f36900a, (eVar.f36902c + eVar.f36903d) / 2);
        this.f36882a.lineTo(eVar.f36900a - sin2, ((eVar.f36902c + eVar.f36903d) / 2) + cos2);
        this.f36882a.lineTo(eVar.f36904e - sin2, eVar.f36905f + cos2);
        this.f36882a.close();
        float sin3 = ((float) Math.sin(d7)) * f6;
        float cos3 = ((float) Math.cos(d7)) * f6;
        this.f36882a.moveTo(eVar.f36907h, eVar.f36905f);
        this.f36882a.lineTo(eVar.f36900a, eVar.f36903d);
        this.f36882a.lineTo(eVar.f36900a + sin3, eVar.f36903d - cos3);
        this.f36882a.lineTo(eVar.f36907h + sin3, eVar.f36905f - cos3);
        this.f36882a.close();
        float sin4 = ((float) Math.sin(d8)) * f6;
        float cos4 = f6 * ((float) Math.cos(d8));
        this.f36882a.moveTo(eVar.f36907h, eVar.f36905f);
        this.f36882a.lineTo(eVar.f36900a, (eVar.f36902c + eVar.f36903d) / 2);
        this.f36882a.lineTo(eVar.f36900a + sin4, ((eVar.f36902c + eVar.f36903d) / 2) + cos4);
        this.f36882a.lineTo(eVar.f36907h + sin4, eVar.f36905f + cos4);
        this.f36882a.close();
        return this.f36882a;
    }

    @NonNull
    private Path H(e eVar, int i6) {
        this.f36882a.reset();
        this.f36882a.lineTo(0.0f, eVar.f36905f);
        this.f36882a.lineTo(eVar.f36904e, eVar.f36905f);
        this.f36882a.lineTo(eVar.f36900a, eVar.f36901b);
        this.f36882a.lineTo(eVar.f36907h, eVar.f36905f);
        float f6 = i6;
        this.f36882a.lineTo(f6, eVar.f36905f);
        this.f36882a.lineTo(f6, 0.0f);
        this.f36882a.close();
        return this.f36882a;
    }

    private int I() {
        return this.f36886e / 5;
    }

    private void J() {
        AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f, 0.0f);
        this.f36893l = ofFloat;
        ofFloat.setInterpolator(accelerateInterpolator);
        this.f36893l.setDuration(300L);
        this.f36893l.addUpdateListener(new a());
        this.f36893l.addListener(new b());
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f36894m = ofFloat2;
        ofFloat2.setInterpolator(accelerateInterpolator);
        this.f36894m.setDuration(300L);
        this.f36894m.addUpdateListener(new c());
        this.f36894m.addListener(new d());
    }

    private void K(Context context, AttributeSet attributeSet) {
        this.f36882a = new Path();
        this.f36883b = new Paint();
        this.f36884c = new e(null);
        this.f36883b.setAntiAlias(true);
        this.f36885d = -9524737;
        setBackgroundColor(-14141883);
        setMinimumHeight(com.scwang.smartrefresh.layout.util.c.b(150.0f));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DropboxHeader);
        int i6 = R.styleable.DropboxHeader_dhDrawable1;
        if (obtainStyledAttributes.hasValue(i6)) {
            this.f36888g = obtainStyledAttributes.getDrawable(i6);
        } else {
            com.scwang.smartrefresh.layout.internal.pathview.b bVar = new com.scwang.smartrefresh.layout.internal.pathview.b();
            bVar.i("M3 2h18v20h-18z", "m4,1c-1.105,0 -2,0.895 -2,2v3,11 3,1c0,1.105 0.895,2 2,2h2,12 2c1.105,0 2,-0.895 2,-2v-1,-3 -11,-3c0,-1.105 -0.895,-2 -2,-2h-2,-12 -2zM3.5,3h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM19.5,3h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM3.5,6h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM19.5,6h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM3.5,9h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM19.5,9h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM3.5,12h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM19.5,12h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM3.5,15h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM19.5,15h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM3.5,18h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM19.5,18h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5z");
            bVar.h(-1249039, -245496);
            this.f36888g = bVar;
        }
        int i7 = R.styleable.DropboxHeader_dhDrawable2;
        if (obtainStyledAttributes.hasValue(i7)) {
            this.f36889h = obtainStyledAttributes.getDrawable(i7);
        } else {
            com.scwang.smartrefresh.layout.internal.pathview.b bVar2 = new com.scwang.smartrefresh.layout.internal.pathview.b();
            bVar2.i("M49,16.5l-14,-14l-27,0l0,53l41,0z", "m16,23.5h25c0.55,0 1,-0.45 1,-1 0,-0.55 -0.45,-1 -1,-1L16,21.5c-0.55,0 -1,0.45 -1,1 0,0.55 0.45,1 1,1z", "m16,15.5h10c0.55,0 1,-0.45 1,-1 0,-0.55 -0.45,-1 -1,-1L16,13.5c-0.55,0 -1,0.45 -1,1 0,0.55 0.45,1 1,1z", "M41,29.5L16,29.5c-0.55,0 -1,0.45 -1,1 0,0.55 0.45,1 1,1h25c0.55,0 1,-0.45 1,-1 0,-0.55 -0.45,-1 -1,-1z", "M41,37.5L16,37.5c-0.55,0 -1,0.45 -1,1 0,0.55 0.45,1 1,1h25c0.55,0 1,-0.45 1,-1 0,-0.55 -0.45,-1 -1,-1z", "M41,45.5L16,45.5c-0.55,0 -1,0.45 -1,1 0,0.55 0.45,1 1,1h25c0.55,0 1,-0.45 1,-1 0,-0.55 -0.45,-1 -1,-1z", "M49,16.5l-14,-14l0,14z");
            bVar2.h(-76695, -2773417);
            this.f36889h = bVar2;
        }
        int i8 = R.styleable.DropboxHeader_dhDrawable3;
        if (obtainStyledAttributes.hasValue(i8)) {
            this.f36890i = obtainStyledAttributes.getDrawable(i8);
        } else {
            com.scwang.smartrefresh.layout.internal.pathview.b bVar3 = new com.scwang.smartrefresh.layout.internal.pathview.b();
            bVar3.i("M6.021,2.188L6.021,11.362C5.46,11.327 4.843,11.414 4.229,11.663C2.624,12.312 1.696,13.729 2.155,14.825C2.62,15.924 4.294,16.284 5.898,15.634C7.131,15.134 7.856,14.184 7.965,13.272L7.958,4.387L15.02,3.028L15.02,9.406C14.422,9.343 13.746,9.432 13.076,9.703C11.471,10.353 10.544,11.77 11.004,12.866C11.467,13.964 13.141,14.325 14.746,13.675C15.979,13.174 16.836,12.224 16.947,11.313L16.958,0.002L6.021,2.188L6.021,2.188Z");
            bVar3.h(-6760607);
            this.f36890i = bVar3;
        }
        obtainStyledAttributes.recycle();
    }

    @Override // m2.f
    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.Scale;
    }

    @Override // m2.f
    public void h(h hVar, int i6, int i7) {
        ValueAnimator valueAnimator = this.f36894m;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    @Override // m2.f
    public void q(g gVar, int i6, int i7) {
        this.f36886e = i6;
        int I = I();
        this.f36888g.setBounds(0, 0, I, I);
        this.f36889h.setBounds(0, 0, I, I);
        this.f36890i.setBounds(0, 0, I, I);
    }

    @Override // n2.f
    public void x(h hVar, RefreshState refreshState, RefreshState refreshState2) {
        this.f36895n = refreshState2;
        if (refreshState2 == RefreshState.None) {
            this.f36887f = false;
        }
    }

    @Override // m2.e
    public void y(float f6, int i6, int i7, int i8) {
        if (this.f36895n != RefreshState.Refreshing) {
            this.f36892k = (Math.max(0, i6 - i7) * 1.0f) / i8;
        }
    }

    public DropboxHeader(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        K(context, attributeSet);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        J();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.f36893l;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.f36893l.removeAllListeners();
            this.f36893l = null;
        }
        ValueAnimator valueAnimator2 = this.f36894m;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllUpdateListeners();
            this.f36894m.removeAllListeners();
            this.f36894m = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int width = getWidth();
        e E = E(width, getHeight(), I());
        this.f36883b.setColor(com.scwang.smartrefresh.layout.util.a.A(this.f36885d, 150));
        canvas.drawPath(F(E), this.f36883b);
        this.f36883b.setColor(this.f36885d);
        canvas.drawPath(G(E), this.f36883b);
        if (isInEditMode()) {
            this.f36891j = 2.5f;
        }
        if (this.f36891j > 0.0f) {
            canvas.clipPath(H(E, width));
            float min = Math.min(this.f36891j, 1.0f);
            Rect bounds = this.f36888g.getBounds();
            int i6 = width / 2;
            bounds.offsetTo(i6 - (bounds.width() / 2), ((int) (((E.f36901b - (bounds.height() / 2)) + bounds.height()) * min)) - bounds.height());
            this.f36888g.draw(canvas);
            float min2 = Math.min(Math.max(this.f36891j - 1.0f, 0.0f), 1.0f);
            Rect bounds2 = this.f36889h.getBounds();
            bounds2.offsetTo(i6 - (bounds2.width() / 2), ((int) (((E.f36901b - (bounds2.height() / 2)) + bounds2.height()) * min2)) - bounds2.height());
            this.f36889h.draw(canvas);
            float min3 = Math.min(Math.max(this.f36891j - 2.0f, 0.0f), 1.0f);
            Rect bounds3 = this.f36890i.getBounds();
            bounds3.offsetTo(i6 - (bounds3.width() / 2), ((int) (((E.f36901b - (bounds3.height() / 2)) + bounds3.height()) * min3)) - bounds3.height());
            this.f36890i.draw(canvas);
            if (this.f36887f) {
                bounds.offsetTo(i6 - (bounds.width() / 2), E.f36901b - (bounds.height() / 2));
                this.f36888g.draw(canvas);
                bounds2.offsetTo(i6 - (bounds2.width() / 2), E.f36901b - (bounds2.height() / 2));
                this.f36889h.draw(canvas);
                bounds3.offsetTo(i6 - (bounds3.width() / 2), E.f36901b - (bounds3.height() / 2));
                this.f36890i.draw(canvas);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        setMeasuredDimension(View.resolveSize(getSuggestedMinimumWidth(), i6), View.resolveSize(getSuggestedMinimumHeight(), i7));
    }

    public DropboxHeader(Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        K(context, attributeSet);
    }

    @RequiresApi(21)
    public DropboxHeader(Context context, @Nullable AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
        K(context, attributeSet);
    }

    @Override // m2.f
    @NonNull
    public View getView() {
        return this;
    }

    @Override // m2.f
    public void i(float f6, int i6, int i7) {
    }

    @Override // m2.e
    public void w(h hVar, int i6, int i7) {
    }
}
