package com.scwang.smartrefresh.header;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import androidx.annotation.ColorInt;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.view.ViewCompat;
import com.scwang.smartrefresh.header.internal.MaterialProgressDrawable;
import com.scwang.smartrefresh.header.waveswipe.AnimationImageView;
import com.scwang.smartrefresh.header.waveswipe.WaveView;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import m2.g;
import m2.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class WaveSwipeHeader extends ViewGroup implements m2.e {

    /* renamed from: e, reason: collision with root package name */
    private static final float f37044e = 0.8f;

    /* renamed from: a, reason: collision with root package name */
    private WaveView f37045a;

    /* renamed from: b, reason: collision with root package name */
    private RefreshState f37046b;

    /* renamed from: c, reason: collision with root package name */
    private e f37047c;

    /* renamed from: d, reason: collision with root package name */
    private float f37048d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            WaveSwipeHeader.this.f37047c.setTranslationY(WaveSwipeHeader.this.f37045a.getCurrentCircleCenterY() + (WaveSwipeHeader.this.f37047c.getHeight() / 2.0f));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends Animation {
        b() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f6, Transformation transformation) {
            WaveSwipeHeader.this.f37047c.d(1.0f - f6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements Animation.AnimationListener {
        c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            WaveSwipeHeader.this.f37047c.m();
            WaveSwipeHeader.this.f37047c.b();
            WaveSwipeHeader.this.f37045a.s();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class e extends AnimationImageView {

        /* renamed from: b, reason: collision with root package name */
        private final MaterialProgressDrawable f37053b;

        public e(Context context) {
            super(context);
            MaterialProgressDrawable materialProgressDrawable = new MaterialProgressDrawable(context, WaveSwipeHeader.this);
            this.f37053b = materialProgressDrawable;
            materialProgressDrawable.f(0);
            if (com.scwang.smartrefresh.header.waveswipe.a.a(getContext())) {
                materialProgressDrawable.o(0);
            }
            setImageDrawable(materialProgressDrawable);
        }

        private int a(int i6) {
            return View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
        }

        public void b() {
            this.f37053b.setAlpha(255);
        }

        public void c() {
            int intrinsicWidth = this.f37053b.getIntrinsicWidth();
            measure(a(intrinsicWidth), a(intrinsicWidth));
        }

        public void e(float f6) {
            this.f37053b.e(f6);
        }

        public void f(int i6) {
            this.f37053b.setAlpha(i6);
        }

        public void g(@NonNull int... iArr) {
            this.f37053b.g(iArr);
        }

        public void i(float f6) {
            this.f37053b.h(f6);
        }

        public void j(float f6, float f7) {
            this.f37053b.k(f6, f7);
        }

        public void k(boolean z5) {
            this.f37053b.m(z5);
        }

        public void l() {
            this.f37053b.start();
        }

        public void m() {
            this.f37053b.stop();
        }

        public void d(float f6) {
            setScaleX(f6);
            setScaleY(f6);
        }

        public void h(@IdRes int... iArr) {
            Resources resources = getResources();
            int[] iArr2 = new int[iArr.length];
            for (int i6 = 0; i6 < iArr.length; i6++) {
                iArr2[i6] = resources.getColor(iArr[i6]);
            }
            WaveSwipeHeader.this.setColorSchemeColors(iArr2);
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'c' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class f {

        /* renamed from: b, reason: collision with root package name */
        public static final f f37055b;

        /* renamed from: c, reason: collision with root package name */
        public static final f f37056c;

        /* renamed from: d, reason: collision with root package name */
        public static final f f37057d;

        /* renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ f[] f37058e;

        /* renamed from: a, reason: collision with root package name */
        final float f37059a;

        static {
            f fVar = new f("FIRST", 0, 0.1f);
            f37055b = fVar;
            f fVar2 = new f("SECOND", 1, fVar.f37059a + 0.16f);
            f37056c = fVar2;
            f fVar3 = new f("THIRD", 2, fVar.f37059a + 0.5f);
            f37057d = fVar3;
            f37058e = new f[]{fVar, fVar2, fVar3};
        }

        public static f valueOf(String str) {
            return (f) Enum.valueOf(f.class, str);
        }

        public static f[] values() {
            return (f[]) f37058e.clone();
        }

        private f(String str, int i6, float f6) {
            this.f37059a = f6;
        }
    }

    public WaveSwipeHeader(Context context) {
        super(context);
        z(context, null);
    }

    @Override // m2.f
    public boolean j() {
        return false;
    }

    @Override // m2.f
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        if (iArr.length > 0) {
            this.f37045a.setWaveColor(iArr[0]);
            if (iArr.length > 1) {
                this.f37047c.g(iArr[1]);
            }
        }
    }

    @Override // m2.e
    public void w(h hVar, int i6, int i7) {
        this.f37048d = 0.0f;
        this.f37045a.f();
        this.f37047c.b();
        this.f37047c.l();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 0.0f);
        ofFloat.setDuration(500L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new a());
        ofFloat.start();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class d {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f37052a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            f37052a = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f37052a[RefreshState.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f37052a[RefreshState.PullDownCanceled.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f37052a[RefreshState.ReleaseToRefresh.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f37052a[RefreshState.Refreshing.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private void z(Context context, AttributeSet attributeSet) {
        WaveView waveView = new WaveView(context);
        this.f37045a = waveView;
        addView(waveView);
        e eVar = new e(getContext());
        this.f37047c = eVar;
        addView(eVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.WaveSwipeHeader);
        int color = obtainStyledAttributes.getColor(R.styleable.WaveSwipeHeader_wshPrimaryColor, 0);
        int color2 = obtainStyledAttributes.getColor(R.styleable.WaveSwipeHeader_wshAccentColor, 0);
        if (color != 0) {
            this.f37045a.setWaveColor(color);
        }
        if (color2 != 0) {
            this.f37047c.g(color2);
        } else {
            this.f37047c.g(-1);
        }
        int i6 = R.styleable.WaveSwipeHeader_wshShadowRadius;
        if (obtainStyledAttributes.hasValue(i6)) {
            this.f37045a.o(obtainStyledAttributes.getDimensionPixelOffset(i6, 0), obtainStyledAttributes.getColor(R.styleable.WaveSwipeHeader_wshShadowColor, ViewCompat.MEASURED_STATE_MASK));
        }
        obtainStyledAttributes.recycle();
    }

    @Override // m2.f
    public int d(h hVar, boolean z5) {
        b bVar = new b();
        bVar.setDuration(200L);
        this.f37047c.setAnimationListener(new c());
        this.f37047c.clearAnimation();
        this.f37047c.startAnimation(bVar);
        return 0;
    }

    @Override // m2.f
    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.MatchLayout;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        this.f37045a.layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = this.f37047c.getMeasuredWidth();
        this.f37047c.layout((measuredWidth - measuredWidth2) / 2, -this.f37047c.getMeasuredHeight(), (measuredWidth + measuredWidth2) / 2, 0);
        if (isInEditMode()) {
            y(0.99f, com.scwang.smartrefresh.layout.util.c.b(99.0f), com.scwang.smartrefresh.layout.util.c.b(100.0f), com.scwang.smartrefresh.layout.util.c.b(100.0f));
        }
    }

    public void setColorSchemeColors(int... iArr) {
        this.f37047c.g(iArr);
    }

    @Override // n2.f
    public void x(h hVar, RefreshState refreshState, RefreshState refreshState2) {
        this.f37046b = refreshState2;
        int i6 = d.f37052a[refreshState2.ordinal()];
        if (i6 == 2) {
            this.f37047c.k(true);
            this.f37047c.d(1.0f);
            this.f37047c.b();
        } else {
            if (i6 != 3) {
                return;
            }
            this.f37047c.k(false);
            this.f37047c.i(0.0f);
            this.f37047c.j(0.0f, 0.0f);
            this.f37045a.u(this.f37048d);
            this.f37048d = 0.0f;
        }
    }

    @Override // m2.e
    public void y(float f6, int i6, int i7, int i8) {
        if (this.f37046b == RefreshState.Refreshing) {
            return;
        }
        float max = (((float) Math.max(Math.min(1.0f, f6) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float f7 = f6 > 3.0f ? 2.0f : f6 > 1.0f ? f6 - 1.0f : 0.0f;
        float f8 = ((4.0f - f7) * f7) / 8.0f;
        if (f6 < 1.0f) {
            this.f37047c.j(0.0f, Math.min(f37044e, max * f37044e));
            this.f37047c.e(Math.min(1.0f, max));
        }
        this.f37047c.i((((max * 0.4f) - 0.25f) + (f8 * 2.0f)) * 0.5f);
        this.f37047c.setTranslationY(this.f37045a.getCurrentCircleCenterY());
        float min = (i6 * 1.0f) / Math.min(getMeasuredWidth(), getMeasuredHeight());
        float f9 = (min * (5.0f - (2.0f * min))) / 3.5f;
        float f10 = f.f37055b.f37059a;
        float f11 = f9 - f10;
        float f12 = f.f37056c.f37059a;
        float f13 = (f9 - f12) / 5.0f;
        this.f37048d = f9;
        if (f9 < f10) {
            this.f37045a.h(f9);
        } else if (f9 < f12) {
            this.f37045a.g(f9, f11);
        } else {
            this.f37045a.i(f9, f11, f13);
        }
    }

    public WaveSwipeHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        z(context, attributeSet);
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        setMeasuredDimension(View.MeasureSpec.getSize(i6), View.MeasureSpec.getSize(i7));
        this.f37047c.c();
        this.f37045a.measure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i6), 1073741824), View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i7), 1073741824));
    }

    public WaveSwipeHeader(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        z(context, attributeSet);
    }

    @RequiresApi(21)
    public WaveSwipeHeader(Context context, AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
        z(context, attributeSet);
    }

    @Override // m2.f
    @NonNull
    public View getView() {
        return this;
    }

    @Override // m2.f
    public void h(h hVar, int i6, int i7) {
    }

    @Override // m2.f
    public void i(float f6, int i6, int i7) {
    }

    @Override // m2.f
    public void q(g gVar, int i6, int i7) {
    }

    @Override // m2.e
    public void g(float f6, int i6, int i7, int i8) {
    }
}
