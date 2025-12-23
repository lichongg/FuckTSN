package com.scwang.smartrefresh.layout.header;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.scwang.smartrefresh.layout.R;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.header.bezierradar.RippleView;
import com.scwang.smartrefresh.layout.header.bezierradar.RoundDotView;
import com.scwang.smartrefresh.layout.header.bezierradar.RoundProgressView;
import com.scwang.smartrefresh.layout.header.bezierradar.WaveView;
import m2.e;
import m2.g;
import m2.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class BezierRadarHeader extends FrameLayout implements e {

    /* renamed from: a, reason: collision with root package name */
    private WaveView f37357a;

    /* renamed from: b, reason: collision with root package name */
    private RippleView f37358b;

    /* renamed from: c, reason: collision with root package name */
    private RoundDotView f37359c;

    /* renamed from: d, reason: collision with root package name */
    private RoundProgressView f37360d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f37361e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            BezierRadarHeader.this.f37357a.setWaveHeight(((Integer) valueAnimator.getAnimatedValue()).intValue() / 2);
            BezierRadarHeader.this.f37357a.invalidate();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ h f37363a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                BezierRadarHeader.this.f37360d.c();
            }
        }

        b(h hVar) {
            this.f37363a = hVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            BezierRadarHeader.this.f37359c.setVisibility(4);
            BezierRadarHeader.this.f37360d.animate().scaleX(1.0f);
            BezierRadarHeader.this.f37360d.animate().scaleY(1.0f);
            this.f37363a.getLayout().postDelayed(new a(), 200L);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            BezierRadarHeader.this.f37359c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public BezierRadarHeader(Context context) {
        this(context, null);
    }

    @Override // m2.f
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        if (iArr.length > 0) {
            E(iArr[0]);
        }
        if (iArr.length > 1) {
            B(iArr[1]);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class d {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f37367a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            f37367a = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f37367a[RefreshState.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f37367a[RefreshState.PullToUpLoad.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f37367a[RefreshState.Refreshing.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f37367a[RefreshState.Loading.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public BezierRadarHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void A(Context context, AttributeSet attributeSet, int i6) {
        setMinimumHeight(com.scwang.smartrefresh.layout.util.c.b(100.0f));
        this.f37357a = new WaveView(getContext());
        this.f37358b = new RippleView(getContext());
        this.f37359c = new RoundDotView(getContext());
        this.f37360d = new RoundProgressView(getContext());
        if (isInEditMode()) {
            addView(this.f37357a, -1, -1);
            addView(this.f37360d, -1, -1);
            this.f37357a.setHeadHeight(1000);
        } else {
            addView(this.f37357a, -1, -1);
            addView(this.f37359c, -1, -1);
            addView(this.f37360d, -1, -1);
            addView(this.f37358b, -1, -1);
            this.f37360d.setScaleX(0.0f);
            this.f37360d.setScaleY(0.0f);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BezierRadarHeader);
        this.f37361e = obtainStyledAttributes.getBoolean(R.styleable.BezierRadarHeader_srlEnableHorizontalDrag, this.f37361e);
        int color = obtainStyledAttributes.getColor(R.styleable.BezierRadarHeader_srlPrimaryColor, 0);
        int color2 = obtainStyledAttributes.getColor(R.styleable.BezierRadarHeader_srlAccentColor, 0);
        if (color != 0) {
            E(color);
        }
        if (color2 != 0) {
            B(color2);
        }
        obtainStyledAttributes.recycle();
    }

    public BezierRadarHeader B(@ColorInt int i6) {
        this.f37359c.setDotColor(i6);
        this.f37358b.setFrontColor(i6);
        this.f37360d.setFrontColor(i6);
        return this;
    }

    public BezierRadarHeader D(boolean z5) {
        this.f37361e = z5;
        if (!z5) {
            this.f37357a.setWaveOffsetX(-1);
        }
        return this;
    }

    public BezierRadarHeader E(@ColorInt int i6) {
        this.f37357a.setWaveColor(i6);
        this.f37360d.setBackColor(i6);
        return this;
    }

    @Override // m2.f
    public int d(h hVar, boolean z5) {
        this.f37360d.d();
        this.f37360d.animate().scaleX(0.0f);
        this.f37360d.animate().scaleY(0.0f);
        this.f37358b.setVisibility(0);
        this.f37358b.b();
        return 400;
    }

    @Override // m2.f
    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.Scale;
    }

    @Override // m2.f
    public void i(float f6, int i6, int i7) {
        this.f37357a.setWaveOffsetX(i6);
        this.f37357a.invalidate();
    }

    @Override // m2.f
    public boolean j() {
        return this.f37361e;
    }

    @Override // m2.e
    public void w(h hVar, int i6, int i7) {
        this.f37357a.setHeadHeight(i6);
        ValueAnimator ofInt = ValueAnimator.ofInt(this.f37357a.getWaveHeight(), 0, -((int) (this.f37357a.getWaveHeight() * 0.8d)), 0, -((int) (this.f37357a.getWaveHeight() * 0.4f)), 0);
        ofInt.addUpdateListener(new a());
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.setDuration(800L);
        ofInt.start();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.addListener(new b(hVar));
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.setDuration(300L);
        ofFloat.addUpdateListener(new c());
        ofFloat.start();
    }

    @Override // n2.f
    public void x(h hVar, RefreshState refreshState, RefreshState refreshState2) {
        int i6 = d.f37367a[refreshState2.ordinal()];
        if (i6 == 1) {
            this.f37358b.setVisibility(8);
            this.f37359c.setAlpha(1.0f);
            this.f37359c.setVisibility(0);
        } else {
            if (i6 != 2) {
                return;
            }
            this.f37360d.setScaleX(0.0f);
            this.f37360d.setScaleY(0.0f);
        }
    }

    @Override // m2.e
    public void y(float f6, int i6, int i7, int i8) {
        this.f37357a.setHeadHeight(Math.min(i7, i6));
        this.f37357a.setWaveHeight((int) (Math.max(0, i6 - i7) * 1.9f));
        this.f37359c.setFraction(f6);
    }

    public BezierRadarHeader(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f37361e = false;
        A(context, attributeSet, i6);
    }

    public BezierRadarHeader C(@ColorRes int i6) {
        B(ContextCompat.getColor(getContext(), i6));
        return this;
    }

    public BezierRadarHeader F(@ColorRes int i6) {
        E(ContextCompat.getColor(getContext(), i6));
        return this;
    }

    @Override // m2.e
    public void g(float f6, int i6, int i7, int i8) {
        y(f6, i6, i7, i8);
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
    public void q(g gVar, int i6, int i7) {
    }
}
