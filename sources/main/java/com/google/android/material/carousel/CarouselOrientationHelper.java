package com.google.android.material.carousel;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
abstract class CarouselOrientationHelper {
    final int orientation;

    abstract void containMaskWithinBounds(RectF rectF, RectF rectF2, RectF rectF3);

    abstract float getMaskMargins(RecyclerView.LayoutParams layoutParams);

    abstract RectF getMaskRect(float f6, float f7, float f8, float f9);

    abstract int getParentBottom();

    abstract int getParentEnd();

    abstract int getParentLeft();

    abstract int getParentRight();

    abstract int getParentStart();

    abstract int getParentTop();

    abstract void layoutDecoratedWithMargins(View view, int i6, int i7);

    abstract void moveMaskOnEdgeOutsideBounds(RectF rectF, RectF rectF2, RectF rectF3);

    abstract void offsetChild(View view, Rect rect, float f6, float f7);

    private CarouselOrientationHelper(int i6) {
        this.orientation = i6;
    }

    private static CarouselOrientationHelper createHorizontalHelper(final CarouselLayoutManager carouselLayoutManager) {
        return new CarouselOrientationHelper(0) { // from class: com.google.android.material.carousel.CarouselOrientationHelper.2
            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            int getParentLeft() {
                return 0;
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public void containMaskWithinBounds(RectF rectF, RectF rectF2, RectF rectF3) {
                float f6 = rectF2.left;
                float f7 = rectF3.left;
                if (f6 < f7 && rectF2.right > f7) {
                    float f8 = f7 - f6;
                    rectF.left += f8;
                    rectF2.left += f8;
                }
                float f9 = rectF2.right;
                float f10 = rectF3.right;
                if (f9 <= f10 || rectF2.left >= f10) {
                    return;
                }
                float f11 = f9 - f10;
                rectF.right = Math.max(rectF.right - f11, rectF.left);
                rectF2.right = Math.max(rectF2.right - f11, rectF2.left);
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public float getMaskMargins(RecyclerView.LayoutParams layoutParams) {
                return ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public RectF getMaskRect(float f6, float f7, float f8, float f9) {
                return new RectF(f9, 0.0f, f7 - f9, f6);
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            int getParentBottom() {
                return carouselLayoutManager.getHeight() - carouselLayoutManager.getPaddingBottom();
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            int getParentEnd() {
                return carouselLayoutManager.isLayoutRtl() ? getParentLeft() : getParentRight();
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            int getParentRight() {
                return carouselLayoutManager.getWidth();
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            int getParentStart() {
                return carouselLayoutManager.isLayoutRtl() ? getParentRight() : getParentLeft();
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            int getParentTop() {
                return carouselLayoutManager.getPaddingTop();
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public void layoutDecoratedWithMargins(View view, int i6, int i7) {
                carouselLayoutManager.layoutDecoratedWithMargins(view, i6, getParentTop(), i7, getParentBottom());
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public void moveMaskOnEdgeOutsideBounds(RectF rectF, RectF rectF2, RectF rectF3) {
                if (rectF2.right <= rectF3.left) {
                    rectF.right = ((float) Math.floor(rectF.right)) - 1.0f;
                }
                if (rectF2.left >= rectF3.right) {
                    rectF.left = ((float) Math.ceil(rectF.left)) + 1.0f;
                }
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public void offsetChild(View view, Rect rect, float f6, float f7) {
                view.offsetLeftAndRight((int) (f7 - (rect.left + f6)));
            }
        };
    }

    static CarouselOrientationHelper createOrientationHelper(CarouselLayoutManager carouselLayoutManager, int i6) {
        if (i6 == 0) {
            return createHorizontalHelper(carouselLayoutManager);
        }
        if (i6 == 1) {
            return createVerticalHelper(carouselLayoutManager);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    private static CarouselOrientationHelper createVerticalHelper(final CarouselLayoutManager carouselLayoutManager) {
        return new CarouselOrientationHelper(1) { // from class: com.google.android.material.carousel.CarouselOrientationHelper.1
            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            int getParentTop() {
                return 0;
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public void containMaskWithinBounds(RectF rectF, RectF rectF2, RectF rectF3) {
                float f6 = rectF2.top;
                float f7 = rectF3.top;
                if (f6 < f7 && rectF2.bottom > f7) {
                    float f8 = f7 - f6;
                    rectF.top += f8;
                    rectF3.top += f8;
                }
                float f9 = rectF2.bottom;
                float f10 = rectF3.bottom;
                if (f9 <= f10 || rectF2.top >= f10) {
                    return;
                }
                float f11 = f9 - f10;
                rectF.bottom = Math.max(rectF.bottom - f11, rectF.top);
                rectF2.bottom = Math.max(rectF2.bottom - f11, rectF2.top);
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public float getMaskMargins(RecyclerView.LayoutParams layoutParams) {
                return ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public RectF getMaskRect(float f6, float f7, float f8, float f9) {
                return new RectF(0.0f, f8, f7, f6 - f8);
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            int getParentBottom() {
                return carouselLayoutManager.getHeight();
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            int getParentLeft() {
                return carouselLayoutManager.getPaddingLeft();
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            int getParentRight() {
                return carouselLayoutManager.getWidth() - carouselLayoutManager.getPaddingRight();
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public void layoutDecoratedWithMargins(View view, int i6, int i7) {
                carouselLayoutManager.layoutDecoratedWithMargins(view, getParentLeft(), i6, getParentRight(), i7);
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public void moveMaskOnEdgeOutsideBounds(RectF rectF, RectF rectF2, RectF rectF3) {
                if (rectF2.bottom <= rectF3.top) {
                    rectF.bottom = ((float) Math.floor(rectF.bottom)) - 1.0f;
                }
                if (rectF2.top >= rectF3.bottom) {
                    rectF.top = ((float) Math.ceil(rectF.top)) + 1.0f;
                }
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public void offsetChild(View view, Rect rect, float f6, float f7) {
                view.offsetTopAndBottom((int) (f7 - (rect.top + f6)));
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            int getParentEnd() {
                return getParentBottom();
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            int getParentStart() {
                return getParentTop();
            }
        };
    }
}
