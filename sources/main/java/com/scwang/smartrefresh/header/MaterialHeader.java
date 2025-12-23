package com.scwang.smartrefresh.header;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;
import com.scwang.smartrefresh.header.internal.MaterialProgressDrawable;
import com.scwang.smartrefresh.header.material.CircleImageView;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.util.c;
import m2.e;
import m2.g;
import m2.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class MaterialHeader extends ViewGroup implements e {

    /* renamed from: k, reason: collision with root package name */
    public static final int f36931k = 0;

    /* renamed from: l, reason: collision with root package name */
    public static final int f36932l = 1;

    /* renamed from: m, reason: collision with root package name */
    private static final int f36933m = -328966;

    /* renamed from: n, reason: collision with root package name */
    private static final float f36934n = 0.8f;

    /* renamed from: o, reason: collision with root package name */
    @VisibleForTesting
    private static final int f36935o = 40;

    /* renamed from: p, reason: collision with root package name */
    @VisibleForTesting
    private static final int f36936p = 56;

    /* renamed from: a, reason: collision with root package name */
    private boolean f36937a;

    /* renamed from: b, reason: collision with root package name */
    private int f36938b;

    /* renamed from: c, reason: collision with root package name */
    private CircleImageView f36939c;

    /* renamed from: d, reason: collision with root package name */
    private MaterialProgressDrawable f36940d;

    /* renamed from: e, reason: collision with root package name */
    private int f36941e;

    /* renamed from: f, reason: collision with root package name */
    private int f36942f;

    /* renamed from: g, reason: collision with root package name */
    private Path f36943g;

    /* renamed from: h, reason: collision with root package name */
    private Paint f36944h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f36945i;

    /* renamed from: j, reason: collision with root package name */
    private RefreshState f36946j;

    public MaterialHeader(Context context) {
        super(context);
        this.f36945i = false;
        a(context, null);
    }

    @Override // m2.f
    public boolean j() {
        return false;
    }

    @Override // m2.f
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        if (iArr.length > 0) {
            this.f36944h.setColor(iArr[0]);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f36947a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            f36947a = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f36947a[RefreshState.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f36947a[RefreshState.ReleaseToRefresh.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f36947a[RefreshState.Refreshing.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private void a(Context context, AttributeSet attributeSet) {
        setMinimumHeight(c.b(100.0f));
        MaterialProgressDrawable materialProgressDrawable = new MaterialProgressDrawable(context, this);
        this.f36940d = materialProgressDrawable;
        materialProgressDrawable.f(f36933m);
        this.f36940d.setAlpha(255);
        this.f36940d.g(-16737844, -48060, -10053376, -5609780, -30720);
        CircleImageView circleImageView = new CircleImageView(context, f36933m);
        this.f36939c = circleImageView;
        circleImageView.setImageDrawable(this.f36940d);
        this.f36939c.setVisibility(8);
        addView(this.f36939c);
        this.f36938b = (int) (getResources().getDisplayMetrics().density * 40.0f);
        this.f36943g = new Path();
        Paint paint = new Paint();
        this.f36944h = paint;
        paint.setAntiAlias(true);
        this.f36944h.setStyle(Paint.Style.FILL);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MaterialHeader);
        this.f36945i = obtainStyledAttributes.getBoolean(R.styleable.MaterialHeader_mhShowBezierWave, this.f36945i);
        this.f36944h.setColor(obtainStyledAttributes.getColor(R.styleable.MaterialHeader_mhPrimaryColor, -15614977));
        int i6 = R.styleable.MaterialHeader_mhShadowRadius;
        if (obtainStyledAttributes.hasValue(i6)) {
            this.f36944h.setShadowLayer(obtainStyledAttributes.getDimensionPixelOffset(i6, 0), 0.0f, 0.0f, obtainStyledAttributes.getColor(R.styleable.MaterialHeader_mhShadowColor, ViewCompat.MEASURED_STATE_MASK));
            setLayerType(1, null);
        }
        obtainStyledAttributes.recycle();
    }

    public MaterialHeader A(int i6) {
        if (i6 != 0 && i6 != 1) {
            return this;
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        if (i6 == 0) {
            this.f36938b = (int) (displayMetrics.density * 56.0f);
        } else {
            this.f36938b = (int) (displayMetrics.density * 40.0f);
        }
        this.f36939c.setImageDrawable(null);
        this.f36940d.o(i6);
        this.f36939c.setImageDrawable(this.f36940d);
        return this;
    }

    @Override // m2.f
    public int d(h hVar, boolean z5) {
        this.f36940d.stop();
        this.f36939c.animate().scaleX(0.0f).scaleY(0.0f);
        this.f36937a = true;
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.f36945i) {
            this.f36943g.reset();
            this.f36943g.lineTo(0.0f, this.f36942f);
            this.f36943g.quadTo(getMeasuredWidth() / 2, this.f36942f + (this.f36941e * 1.9f), getMeasuredWidth(), this.f36942f);
            this.f36943g.lineTo(getMeasuredWidth(), 0.0f);
            canvas.drawPath(this.f36943g, this.f36944h);
        }
        super.dispatchDraw(canvas);
    }

    public MaterialHeader f(int... iArr) {
        this.f36940d.g(iArr);
        return this;
    }

    @Override // m2.e
    public void g(float f6, int i6, int i7, int i8) {
        if (!this.f36940d.isRunning() && !this.f36937a) {
            y(f6, i6, i7, i8);
        } else if (this.f36945i) {
            this.f36942f = Math.min(i6, i7);
            this.f36941e = Math.max(0, i6 - i7);
            postInvalidate();
        }
    }

    @Override // m2.f
    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.MatchLayout;
    }

    @Override // m2.f
    public void q(g gVar, int i6, int i7) {
        if (!this.f36945i) {
            gVar.l(false);
        }
        if (isInEditMode()) {
            int i8 = i6 / 2;
            this.f36942f = i8;
            this.f36941e = i8;
        }
    }

    @Override // m2.e
    public void w(h hVar, int i6, int i7) {
        this.f36940d.start();
        if (((int) this.f36939c.getTranslationY()) != (this.f36938b / 2) + (i6 / 2)) {
            this.f36939c.animate().translationY(r2 + (this.f36938b / 2));
        }
    }

    @Override // n2.f
    public void x(h hVar, RefreshState refreshState, RefreshState refreshState2) {
        this.f36946j = refreshState2;
        if (a.f36947a[refreshState2.ordinal()] != 2) {
            return;
        }
        this.f36937a = false;
        this.f36939c.setVisibility(0);
        this.f36939c.setScaleX(1.0f);
        this.f36939c.setScaleY(1.0f);
    }

    @Override // m2.e
    public void y(float f6, int i6, int i7, int i8) {
        if (this.f36945i) {
            this.f36942f = Math.min(i6, i7);
            this.f36941e = Math.max(0, i6 - i7);
            postInvalidate();
        }
        if (this.f36946j != RefreshState.Refreshing) {
            float f7 = i7;
            float max = (((float) Math.max(Math.min(1.0f, Math.abs(r8)) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
            double max2 = Math.max(0.0f, Math.min(Math.abs(i6) - i7, f7 * 2.0f) / f7) / 4.0f;
            float pow = ((float) (max2 - Math.pow(max2, 2.0d))) * 2.0f;
            float f8 = max * f36934n;
            this.f36940d.m(true);
            this.f36940d.k(0.0f, Math.min(f36934n, f8));
            this.f36940d.e(Math.min(1.0f, max));
            this.f36940d.h((((max * 0.4f) - 0.25f) + (pow * 2.0f)) * 0.5f);
            this.f36939c.setAlpha(Math.min(1.0f, ((i6 * 1.0f) / f7) * 2.0f));
        }
        this.f36939c.setTranslationY(Math.min(i6, (i6 / 2) + (this.f36938b / 2)));
    }

    public MaterialHeader z(boolean z5) {
        this.f36945i = z5;
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        int i10;
        if (getChildCount() == 0) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = this.f36939c.getMeasuredWidth();
        int measuredHeight = this.f36939c.getMeasuredHeight();
        if (isInEditMode() && (i10 = this.f36942f) > 0) {
            int i11 = i10 - (measuredHeight / 2);
            int i12 = measuredWidth / 2;
            int i13 = measuredWidth2 / 2;
            this.f36939c.layout(i12 - i13, i11, i12 + i13, measuredHeight + i11);
            this.f36940d.m(true);
            this.f36940d.k(0.0f, f36934n);
            this.f36940d.e(1.0f);
            this.f36939c.setAlpha(1.0f);
            this.f36939c.setVisibility(0);
            return;
        }
        int i14 = measuredWidth / 2;
        int i15 = measuredWidth2 / 2;
        int i16 = this.f36938b;
        this.f36939c.layout(i14 - i15, -i16, i14 + i15, measuredHeight - i16);
    }

    @Override // android.view.View
    public void onMeasure(int i6, int i7) {
        setMeasuredDimension(View.MeasureSpec.getSize(i6), View.MeasureSpec.getSize(i7));
        this.f36939c.measure(View.MeasureSpec.makeMeasureSpec(this.f36938b, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f36938b, 1073741824));
    }

    public MaterialHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f36945i = false;
        a(context, attributeSet);
    }

    public MaterialHeader(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f36945i = false;
        a(context, attributeSet);
    }

    @RequiresApi(21)
    public MaterialHeader(Context context, AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
        this.f36945i = false;
        a(context, attributeSet);
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
}
