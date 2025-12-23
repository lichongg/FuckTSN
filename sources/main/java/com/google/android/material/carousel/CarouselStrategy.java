package com.google.android.material.carousel;

import android.view.View;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class CarouselStrategy {
    @FloatRange(from = 0.0d, to = 1.0d)
    static float getChildMaskPercentage(float f6, float f7, float f8) {
        return 1.0f - ((f6 - f8) / (f7 - f8));
    }

    boolean isContained() {
        return true;
    }

    abstract KeylineState onFirstChildMeasuredWithMargins(@NonNull Carousel carousel, @NonNull View view);
}
