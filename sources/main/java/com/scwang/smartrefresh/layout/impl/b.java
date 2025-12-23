package com.scwang.smartrefresh.layout.impl;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import m2.g;
import m2.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class b implements m2.d {

    /* renamed from: a, reason: collision with root package name */
    private View f37434a;

    /* renamed from: b, reason: collision with root package name */
    private SpinnerStyle f37435b;

    @Override // m2.d
    public boolean b(boolean z5) {
        return false;
    }

    @Override // m2.f
    public int d(h hVar, boolean z5) {
        return 0;
    }

    @Override // m2.f
    public boolean j() {
        return false;
    }

    @Override // m2.f
    public SpinnerStyle getSpinnerStyle() {
        SpinnerStyle spinnerStyle = this.f37435b;
        if (spinnerStyle != null) {
            return spinnerStyle;
        }
        ViewGroup.LayoutParams layoutParams = this.f37434a.getLayoutParams();
        if (layoutParams instanceof SmartRefreshLayout.o) {
            SpinnerStyle spinnerStyle2 = ((SmartRefreshLayout.o) layoutParams).f37315b;
            this.f37435b = spinnerStyle2;
            if (spinnerStyle2 != null) {
                return spinnerStyle2;
            }
        }
        if (layoutParams == null || layoutParams.height != 0) {
            SpinnerStyle spinnerStyle3 = SpinnerStyle.Translate;
            this.f37435b = spinnerStyle3;
            return spinnerStyle3;
        }
        SpinnerStyle spinnerStyle4 = SpinnerStyle.Scale;
        this.f37435b = spinnerStyle4;
        return spinnerStyle4;
    }

    @Override // m2.f
    @NonNull
    public View getView() {
        return this.f37434a;
    }

    @Override // m2.f
    public void q(g gVar, int i6, int i7) {
        ViewGroup.LayoutParams layoutParams = this.f37434a.getLayoutParams();
        if (layoutParams instanceof SmartRefreshLayout.o) {
            gVar.n(((SmartRefreshLayout.o) layoutParams).f37314a);
        }
    }

    public b(View view) {
        this.f37434a = view;
    }

    @Override // m2.f
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
    }

    @Override // m2.f
    public void h(h hVar, int i6, int i7) {
    }

    @Override // m2.f
    public void i(float f6, int i6, int i7) {
    }

    @Override // m2.d
    public void k(h hVar, int i6, int i7) {
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
