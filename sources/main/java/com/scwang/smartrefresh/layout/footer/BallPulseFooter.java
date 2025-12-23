package com.scwang.smartrefresh.layout.footer;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.ColorUtils;
import com.scwang.smartrefresh.layout.R;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.ballpulse.BallPulseView;
import com.scwang.smartrefresh.layout.util.c;
import m2.d;
import m2.g;
import m2.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class BallPulseFooter extends ViewGroup implements d {

    /* renamed from: a, reason: collision with root package name */
    private BallPulseView f37324a;

    /* renamed from: b, reason: collision with root package name */
    private SpinnerStyle f37325b;

    public BallPulseFooter(@NonNull Context context) {
        super(context);
        this.f37325b = SpinnerStyle.Translate;
        a(context, null, 0);
    }

    @Override // m2.d
    public boolean b(boolean z5) {
        return false;
    }

    @Override // m2.f
    public boolean j() {
        return false;
    }

    @Override // m2.f
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        if (iArr.length > 1) {
            this.f37324a.setNormalColor(iArr[1]);
            this.f37324a.setAnimatingColor(iArr[0]);
        } else if (iArr.length > 0) {
            this.f37324a.setNormalColor(ColorUtils.compositeColors(-1711276033, iArr[0]));
            this.f37324a.setAnimatingColor(iArr[0]);
        }
    }

    private void a(Context context, AttributeSet attributeSet, int i6) {
        BallPulseView ballPulseView = new BallPulseView(context);
        this.f37324a = ballPulseView;
        addView(ballPulseView, -2, -2);
        setMinimumHeight(c.b(60.0f));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BallPulseFooter);
        int color = obtainStyledAttributes.getColor(R.styleable.BallPulseFooter_srlPrimaryColor, 0);
        int color2 = obtainStyledAttributes.getColor(R.styleable.BallPulseFooter_srlAccentColor, 0);
        if (color != 0) {
            this.f37324a.setNormalColor(color);
        }
        if (color2 != 0) {
            this.f37324a.setAnimatingColor(color2);
        }
        this.f37325b = SpinnerStyle.values()[obtainStyledAttributes.getInt(R.styleable.BallPulseFooter_srlClassicsSpinnerStyle, this.f37325b.ordinal())];
        obtainStyledAttributes.recycle();
    }

    public BallPulseFooter A(@ColorInt int i6) {
        this.f37324a.setNormalColor(i6);
        return this;
    }

    public BallPulseFooter B(SpinnerStyle spinnerStyle) {
        this.f37325b = spinnerStyle;
        return this;
    }

    @Override // m2.f
    public int d(h hVar, boolean z5) {
        this.f37324a.e();
        return 0;
    }

    public BallPulseFooter f(@ColorInt int i6) {
        this.f37324a.setAnimatingColor(i6);
        return this;
    }

    @Override // m2.f
    public SpinnerStyle getSpinnerStyle() {
        return this.f37325b;
    }

    @Override // m2.f
    public void h(h hVar, int i6, int i7) {
        this.f37324a.d();
    }

    public BallPulseFooter z(@ColorInt int i6) {
        this.f37324a.setIndicatorColor(i6);
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int measuredWidth2 = this.f37324a.getMeasuredWidth();
        int measuredHeight2 = this.f37324a.getMeasuredHeight();
        int i10 = (measuredWidth / 2) - (measuredWidth2 / 2);
        int i11 = (measuredHeight / 2) - (measuredHeight2 / 2);
        this.f37324a.layout(i10, i11, measuredWidth2 + i10, measuredHeight2 + i11);
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        this.f37324a.measure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i6), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i7), Integer.MIN_VALUE));
        setMeasuredDimension(View.resolveSize(this.f37324a.getMeasuredWidth(), i6), View.resolveSize(this.f37324a.getMeasuredHeight(), i7));
    }

    public BallPulseFooter(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f37325b = SpinnerStyle.Translate;
        a(context, attributeSet, 0);
    }

    public BallPulseFooter(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i6) {
        super(context, attributeSet, i6);
        this.f37325b = SpinnerStyle.Translate;
        a(context, attributeSet, i6);
    }

    @Override // m2.f
    @NonNull
    public View getView() {
        return this;
    }

    @Override // m2.f
    public void i(float f6, int i6, int i7) {
    }

    @Override // m2.d
    public void k(h hVar, int i6, int i7) {
    }

    @Override // m2.f
    public void q(g gVar, int i6, int i7) {
    }

    @Override // n2.f
    public void x(h hVar, RefreshState refreshState, RefreshState refreshState2) {
    }

    @Override // m2.d
    public void c(float f6, int i6, int i7, int i8) {
    }

    @Override // m2.d
    public void v(float f6, int i6, int i7, int i8) {
    }
}
