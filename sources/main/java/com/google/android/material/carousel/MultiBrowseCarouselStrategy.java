package com.google.android.material.carousel;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.math.MathUtils;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class MultiBrowseCarouselStrategy extends CarouselStrategy {
    private final boolean forceCompactArrangement;
    private static final int[] SMALL_COUNTS = {1};
    private static final int[] MEDIUM_COUNTS = {1, 0};
    private static final int[] MEDIUM_COUNTS_COMPACT = {0};

    public MultiBrowseCarouselStrategy() {
        this(false);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public MultiBrowseCarouselStrategy(boolean z5) {
        this.forceCompactArrangement = z5;
    }

    @Override // com.google.android.material.carousel.CarouselStrategy
    @NonNull
    KeylineState onFirstChildMeasuredWithMargins(@NonNull Carousel carousel, @NonNull View view) {
        int[] iArr;
        float containerHeight = carousel.getContainerHeight();
        if (carousel.isHorizontal()) {
            containerHeight = carousel.getContainerWidth();
        }
        float f6 = containerHeight;
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        float f7 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        float measuredHeight = view.getMeasuredHeight();
        if (carousel.isHorizontal()) {
            f7 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            measuredHeight = view.getMeasuredWidth();
        }
        float f8 = f7;
        float smallSizeMin = CarouselStrategyHelper.getSmallSizeMin(view.getContext()) + f8;
        float smallSizeMax = CarouselStrategyHelper.getSmallSizeMax(view.getContext()) + f8;
        float min = Math.min(measuredHeight + f8, f6);
        float clamp = MathUtils.clamp((measuredHeight / 3.0f) + f8, CarouselStrategyHelper.getSmallSizeMin(view.getContext()) + f8, CarouselStrategyHelper.getSmallSizeMax(view.getContext()) + f8);
        float f9 = (min + clamp) / 2.0f;
        int[] iArr2 = SMALL_COUNTS;
        if (this.forceCompactArrangement) {
            iArr = MEDIUM_COUNTS_COMPACT;
        } else {
            iArr = MEDIUM_COUNTS;
        }
        int[] iArr3 = iArr;
        int max = (int) Math.max(1.0d, Math.floor(((f6 - (CarouselStrategyHelper.maxValue(iArr3) * f9)) - (CarouselStrategyHelper.maxValue(iArr2) * smallSizeMax)) / min));
        int ceil = (int) Math.ceil(f6 / min);
        int i6 = (ceil - max) + 1;
        int[] iArr4 = new int[i6];
        for (int i7 = 0; i7 < i6; i7++) {
            iArr4[i7] = ceil - i7;
        }
        return CarouselStrategyHelper.createLeftAlignedKeylineState(view.getContext(), f8, f6, Arrangement.findLowestCostArrangement(f6, clamp, smallSizeMin, smallSizeMax, iArr2, f9, iArr3, min, iArr4));
    }
}
