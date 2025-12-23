package com.google.android.material.carousel;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.material.R;
import com.google.android.material.carousel.KeylineState;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class CarouselStrategyHelper {
    static int maxValue(int[] iArr) {
        int i6 = Integer.MIN_VALUE;
        for (int i7 : iArr) {
            if (i7 > i6) {
                i6 = i7;
            }
        }
        return i6;
    }

    private CarouselStrategyHelper() {
    }

    static KeylineState createLeftAlignedKeylineState(@NonNull Context context, float f6, float f7, @NonNull Arrangement arrangement) {
        float f8;
        float extraSmallSize = getExtraSmallSize(context) + f6;
        float f9 = extraSmallSize / 2.0f;
        float f10 = 0.0f - f9;
        float f11 = (arrangement.largeSize / 2.0f) + 0.0f;
        float max = Math.max(0, arrangement.largeCount - 1);
        float f12 = arrangement.largeSize;
        float f13 = (max * f12) + f11;
        float f14 = (f12 / 2.0f) + f13;
        int i6 = arrangement.mediumCount;
        if (i6 > 0) {
            f13 = (arrangement.mediumSize / 2.0f) + f14;
        }
        if (i6 > 0) {
            f14 = (arrangement.mediumSize / 2.0f) + f13;
        }
        if (arrangement.smallCount > 0) {
            f8 = f14 + (arrangement.smallSize / 2.0f);
        } else {
            f8 = f13;
        }
        float f15 = f7 + f9;
        float childMaskPercentage = CarouselStrategy.getChildMaskPercentage(extraSmallSize, f12, f6);
        float childMaskPercentage2 = CarouselStrategy.getChildMaskPercentage(arrangement.smallSize, arrangement.largeSize, f6);
        float childMaskPercentage3 = CarouselStrategy.getChildMaskPercentage(arrangement.mediumSize, arrangement.largeSize, f6);
        KeylineState.Builder addKeylineRange = new KeylineState.Builder(arrangement.largeSize).addKeyline(f10, childMaskPercentage, extraSmallSize).addKeylineRange(f11, 0.0f, arrangement.largeSize, arrangement.largeCount, true);
        if (arrangement.mediumCount > 0) {
            addKeylineRange.addKeyline(f13, childMaskPercentage3, arrangement.mediumSize);
        }
        int i7 = arrangement.smallCount;
        if (i7 > 0) {
            addKeylineRange.addKeylineRange(f8, childMaskPercentage2, arrangement.smallSize, i7);
        }
        addKeylineRange.addKeyline(f15, childMaskPercentage, extraSmallSize);
        return addKeylineRange.build();
    }

    static float getExtraSmallSize(@NonNull Context context) {
        return context.getResources().getDimension(R.dimen.m3_carousel_gone_size);
    }

    static float getSmallSizeMax(@NonNull Context context) {
        return context.getResources().getDimension(R.dimen.m3_carousel_small_item_size_max);
    }

    static float getSmallSizeMin(@NonNull Context context) {
        return context.getResources().getDimension(R.dimen.m3_carousel_small_item_size_min);
    }
}
