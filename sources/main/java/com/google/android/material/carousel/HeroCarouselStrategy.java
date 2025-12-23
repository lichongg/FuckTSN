package com.google.android.material.carousel;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.math.MathUtils;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class HeroCarouselStrategy extends CarouselStrategy {
    private static final int[] SMALL_COUNTS = {1};
    private static final int[] MEDIUM_COUNTS = {0, 1};

    @Override // com.google.android.material.carousel.CarouselStrategy
    @NonNull
    KeylineState onFirstChildMeasuredWithMargins(@NonNull Carousel carousel, @NonNull View view) {
        int containerHeight = carousel.getContainerHeight();
        if (carousel.isHorizontal()) {
            containerHeight = carousel.getContainerWidth();
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        float f6 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        float measuredWidth = view.getMeasuredWidth() * 2;
        if (carousel.isHorizontal()) {
            f6 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            measuredWidth = view.getMeasuredHeight() * 2;
        }
        float smallSizeMin = CarouselStrategyHelper.getSmallSizeMin(view.getContext()) + f6;
        float smallSizeMax = CarouselStrategyHelper.getSmallSizeMax(view.getContext()) + f6;
        float f7 = containerHeight;
        float min = Math.min(measuredWidth + f6, f7);
        float clamp = MathUtils.clamp((measuredWidth / 3.0f) + f6, CarouselStrategyHelper.getSmallSizeMin(view.getContext()) + f6, CarouselStrategyHelper.getSmallSizeMax(view.getContext()) + f6);
        float f8 = (min + clamp) / 2.0f;
        int max = (int) Math.max(1.0d, Math.floor((f7 - (CarouselStrategyHelper.maxValue(SMALL_COUNTS) * smallSizeMax)) / min));
        int ceil = (((int) Math.ceil(f7 / min)) - max) + 1;
        int[] iArr = new int[ceil];
        for (int i6 = 0; i6 < ceil; i6++) {
            iArr[i6] = max + i6;
        }
        return CarouselStrategyHelper.createLeftAlignedKeylineState(view.getContext(), f6, f7, Arrangement.findLowestCostArrangement(f7, clamp, smallSizeMin, smallSizeMax, SMALL_COUNTS, f8, MEDIUM_COUNTS, min, iArr));
    }
}
