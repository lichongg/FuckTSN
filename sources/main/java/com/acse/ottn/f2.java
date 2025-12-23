package com.acse.ottn;

import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class f2 extends c0 {

    /* renamed from: c, reason: collision with root package name */
    public static final float f4516c = 0.85f;

    /* renamed from: b, reason: collision with root package name */
    public float f4517b;

    public f2() {
        this.f4517b = 0.85f;
    }

    public f2(float f6) {
        this.f4517b = f6;
    }

    public final ViewPager2 a(@NonNull View view) {
        ViewParent parent = view.getParent();
        ViewParent parent2 = parent.getParent();
        if ((parent instanceof RecyclerView) && (parent2 instanceof ViewPager2)) {
            return (ViewPager2) parent2;
        }
        throw new IllegalStateException("Expected the page view to be managed by a ViewPager2 instance.");
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(@NonNull View view, float f6) {
        float paddingLeft = a(view).getPaddingLeft();
        float measuredWidth = f6 - (paddingLeft / ((r0.getMeasuredWidth() - paddingLeft) - r0.getPaddingRight()));
        float width = view.getWidth();
        float f7 = this.f4517b;
        float f8 = 1.0f - f7;
        float f9 = (width * f8) / 2.0f;
        if (measuredWidth <= -1.0f) {
            view.setTranslationX(f9);
            view.setScaleX(this.f4517b);
            view.setScaleY(this.f4517b);
            return;
        }
        double d6 = measuredWidth;
        if (d6 <= 1.0d) {
            float abs = f8 * Math.abs(1.0f - Math.abs(measuredWidth));
            float f10 = (-f9) * measuredWidth;
            if (d6 <= -0.5d) {
                view.setTranslationX(f10 + (Math.abs(Math.abs(measuredWidth) - 0.5f) / 0.5f));
            } else if (measuredWidth <= 0.0f) {
                view.setTranslationX(f10);
            } else if (d6 >= 0.5d) {
                view.setTranslationX(f10 - (Math.abs(Math.abs(measuredWidth) - 0.5f) / 0.5f));
            } else {
                view.setTranslationX(f10);
            }
            view.setScaleX(this.f4517b + abs);
            view.setScaleY(abs + this.f4517b);
            return;
        }
        view.setScaleX(f7);
        view.setScaleY(this.f4517b);
        view.setTranslationX(-f9);
    }
}
