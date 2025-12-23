package com.acse.ottn;

import android.view.View;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class g extends c0 {

    /* renamed from: c, reason: collision with root package name */
    public static final float f4532c = 0.5f;

    /* renamed from: b, reason: collision with root package name */
    public float f4533b;

    public g() {
        this.f4533b = 0.5f;
    }

    public g(float f6) {
        this.f4533b = f6;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(@NonNull View view, float f6) {
        view.setScaleX(0.999f);
        if (f6 < -1.0f) {
            view.setAlpha(this.f4533b);
            return;
        }
        if (f6 <= 1.0f) {
            if (f6 < 0.0f) {
                float f7 = this.f4533b;
                view.setAlpha(f7 + ((1.0f - f7) * (f6 + 1.0f)));
                return;
            } else {
                float f8 = this.f4533b;
                view.setAlpha(f8 + ((1.0f - f8) * (1.0f - f6)));
                return;
            }
        }
        view.setAlpha(this.f4533b);
    }
}
