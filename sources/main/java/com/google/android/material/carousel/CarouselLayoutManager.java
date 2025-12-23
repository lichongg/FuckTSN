package com.google.android.material.carousel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.graphics.ColorUtils;
import androidx.core.math.MathUtils;
import androidx.core.util.Preconditions;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.carousel.KeylineState;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class CarouselLayoutManager extends RecyclerView.LayoutManager implements Carousel, RecyclerView.SmoothScroller.ScrollVectorProvider {
    public static final int HORIZONTAL = 0;
    private static final String TAG = "CarouselLayoutManager";
    public static final int VERTICAL = 1;

    @NonNull
    private CarouselStrategy carouselStrategy;
    private int currentFillStartPosition;

    @Nullable
    private KeylineState currentKeylineState;
    private final DebugItemDecoration debugItemDecoration;
    private boolean isDebuggingEnabled;

    @Nullable
    private KeylineStateList keylineStateList;

    @Nullable
    private Map<Integer, KeylineState> keylineStatePositionMap;

    @VisibleForTesting
    int maxScroll;

    @VisibleForTesting
    int minScroll;
    private CarouselOrientationHelper orientationHelper;

    @VisibleForTesting
    int scrollOffset;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class DebugItemDecoration extends RecyclerView.ItemDecoration {
        private List<KeylineState.Keyline> keylines;
        private final Paint linePaint;

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            super.onDrawOver(canvas, recyclerView, state);
            this.linePaint.setStrokeWidth(recyclerView.getResources().getDimension(R.dimen.m3_carousel_debug_keyline_width));
            for (KeylineState.Keyline keyline : this.keylines) {
                this.linePaint.setColor(ColorUtils.blendARGB(-65281, -16776961, keyline.mask));
                if (((CarouselLayoutManager) recyclerView.getLayoutManager()).isHorizontal()) {
                    canvas.drawLine(keyline.locOffset, ((CarouselLayoutManager) recyclerView.getLayoutManager()).getParentTop(), keyline.locOffset, ((CarouselLayoutManager) recyclerView.getLayoutManager()).getParentBottom(), this.linePaint);
                } else {
                    canvas.drawLine(((CarouselLayoutManager) recyclerView.getLayoutManager()).getParentLeft(), keyline.locOffset, ((CarouselLayoutManager) recyclerView.getLayoutManager()).getParentRight(), keyline.locOffset, this.linePaint);
                }
            }
        }

        DebugItemDecoration() {
            Paint paint = new Paint();
            this.linePaint = paint;
            this.keylines = Collections.unmodifiableList(new ArrayList());
            paint.setStrokeWidth(5.0f);
            paint.setColor(-65281);
        }

        void setKeylines(List<KeylineState.Keyline> list) {
            this.keylines = Collections.unmodifiableList(list);
        }
    }

    public CarouselLayoutManager() {
        this(new MultiBrowseCarouselStrategy());
    }

    private static KeylineRange getSurroundingKeylineRange(List<KeylineState.Keyline> list, float f6, boolean z5) {
        float f7 = Float.MAX_VALUE;
        float f8 = Float.MAX_VALUE;
        float f9 = Float.MAX_VALUE;
        float f10 = -3.4028235E38f;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        int i9 = -1;
        for (int i10 = 0; i10 < list.size(); i10++) {
            KeylineState.Keyline keyline = list.get(i10);
            float f11 = z5 ? keyline.locOffset : keyline.loc;
            float abs = Math.abs(f11 - f6);
            if (f11 <= f6 && abs <= f7) {
                i6 = i10;
                f7 = abs;
            }
            if (f11 > f6 && abs <= f8) {
                i8 = i10;
                f8 = abs;
            }
            if (f11 <= f9) {
                i7 = i10;
                f9 = f11;
            }
            if (f11 > f10) {
                i9 = i10;
                f10 = f11;
            }
        }
        if (i6 == -1) {
            i6 = i7;
        }
        if (i8 == -1) {
            i8 = i9;
        }
        return new KeylineRange(list.get(i6), list.get(i8));
    }

    private void offsetChild(View view, float f6, float f7, Rect rect) {
        float addEnd = addEnd((int) f6, (int) f7);
        KeylineRange surroundingKeylineRange = getSurroundingKeylineRange(this.currentKeylineState.getKeylines(), addEnd, false);
        float calculateChildOffsetCenterForLocation = calculateChildOffsetCenterForLocation(view, addEnd, surroundingKeylineRange);
        super.getDecoratedBoundsWithMargins(view, rect);
        updateChildMaskForLocation(view, addEnd, surroundingKeylineRange);
        this.orientationHelper.offsetChild(view, rect, f7, calculateChildOffsetCenterForLocation);
    }

    private void refreshKeylineState() {
        this.keylineStateList = null;
        requestLayout();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class ChildCalculations {
        final float center;
        final View child;
        final float offsetCenter;
        final KeylineRange range;

        ChildCalculations(View view, float f6, float f7, KeylineRange keylineRange) {
            this.child = view;
            this.center = f6;
            this.offsetCenter = f7;
            this.range = keylineRange;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class KeylineRange {
        final KeylineState.Keyline leftOrTop;
        final KeylineState.Keyline rightOrBottom;

        KeylineRange(KeylineState.Keyline keyline, KeylineState.Keyline keyline2) {
            boolean z5;
            if (keyline.loc <= keyline2.loc) {
                z5 = true;
            } else {
                z5 = false;
            }
            Preconditions.checkArgument(z5);
            this.leftOrTop = keyline;
            this.rightOrBottom = keyline2;
        }
    }

    public CarouselLayoutManager(@NonNull CarouselStrategy carouselStrategy) {
        this(carouselStrategy, 0);
    }

    private void addAndLayoutView(View view, int i6, ChildCalculations childCalculations) {
        float itemSize = this.currentKeylineState.getItemSize() / 2.0f;
        addView(view, i6);
        float f6 = childCalculations.offsetCenter;
        this.orientationHelper.layoutDecoratedWithMargins(view, (int) (f6 - itemSize), (int) (f6 + itemSize));
        updateChildMaskForLocation(view, childCalculations.center, childCalculations.range);
    }

    private float calculateChildOffsetCenterForLocation(View view, float f6, KeylineRange keylineRange) {
        KeylineState.Keyline keyline = keylineRange.leftOrTop;
        float f7 = keyline.locOffset;
        KeylineState.Keyline keyline2 = keylineRange.rightOrBottom;
        float lerp = AnimationUtils.lerp(f7, keyline2.locOffset, keyline.loc, keyline2.loc, f6);
        if (keylineRange.rightOrBottom != this.currentKeylineState.getFirstKeyline() && keylineRange.leftOrTop != this.currentKeylineState.getLastKeyline()) {
            return lerp;
        }
        float maskMargins = this.orientationHelper.getMaskMargins((RecyclerView.LayoutParams) view.getLayoutParams()) / this.currentKeylineState.getItemSize();
        KeylineState.Keyline keyline3 = keylineRange.rightOrBottom;
        return lerp + ((f6 - keyline3.loc) * ((1.0f - keyline3.mask) + maskMargins));
    }

    private static int calculateShouldScrollBy(int i6, int i7, int i8, int i9) {
        int i10 = i7 + i6;
        return i10 < i8 ? i8 - i7 : i10 > i9 ? i9 - i7 : i6;
    }

    private float getDecoratedCenterXWithMargins(View view) {
        super.getDecoratedBoundsWithMargins(view, new Rect());
        return r0.centerX();
    }

    private KeylineState getKeylineStateForPosition(int i6) {
        KeylineState keylineState;
        Map<Integer, KeylineState> map = this.keylineStatePositionMap;
        return (map == null || (keylineState = map.get(Integer.valueOf(MathUtils.clamp(i6, 0, Math.max(0, getItemCount() + (-1)))))) == null) ? this.keylineStateList.getDefaultState() : keylineState;
    }

    private float getMaskedItemSizeForLocOffset(float f6, KeylineRange keylineRange) {
        KeylineState.Keyline keyline = keylineRange.leftOrTop;
        float f7 = keyline.maskedItemSize;
        KeylineState.Keyline keyline2 = keylineRange.rightOrBottom;
        return AnimationUtils.lerp(f7, keyline2.maskedItemSize, keyline.locOffset, keyline2.locOffset, f6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getParentBottom() {
        return this.orientationHelper.getParentBottom();
    }

    private int getParentEnd() {
        return this.orientationHelper.getParentEnd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getParentLeft() {
        return this.orientationHelper.getParentLeft();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getParentRight() {
        return this.orientationHelper.getParentRight();
    }

    private int getParentStart() {
        return this.orientationHelper.getParentStart();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getParentTop() {
        return this.orientationHelper.getParentTop();
    }

    private void logChildrenIfDebugging() {
        if (this.isDebuggingEnabled && Log.isLoggable(TAG, 3)) {
            for (int i6 = 0; i6 < getChildCount(); i6++) {
                View childAt = getChildAt(i6);
                getDecoratedCenterXWithMargins(childAt);
                getPosition(childAt);
            }
        }
    }

    private ChildCalculations makeChildCalculations(RecyclerView.Recycler recycler, float f6, int i6) {
        float itemSize = this.currentKeylineState.getItemSize() / 2.0f;
        View viewForPosition = recycler.getViewForPosition(i6);
        measureChildWithMargins(viewForPosition, 0, 0);
        float addEnd = addEnd((int) f6, (int) itemSize);
        KeylineRange surroundingKeylineRange = getSurroundingKeylineRange(this.currentKeylineState.getKeylines(), addEnd, false);
        return new ChildCalculations(viewForPosition, addEnd, calculateChildOffsetCenterForLocation(viewForPosition, addEnd, surroundingKeylineRange), surroundingKeylineRange);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void updateChildMaskForLocation(View view, float f6, KeylineRange keylineRange) {
        if (view instanceof Maskable) {
            KeylineState.Keyline keyline = keylineRange.leftOrTop;
            float f7 = keyline.mask;
            KeylineState.Keyline keyline2 = keylineRange.rightOrBottom;
            float lerp = AnimationUtils.lerp(f7, keyline2.mask, keyline.loc, keyline2.loc, f6);
            float height = view.getHeight();
            float width = view.getWidth();
            RectF maskRect = this.orientationHelper.getMaskRect(height, width, AnimationUtils.lerp(0.0f, height / 2.0f, 0.0f, 1.0f, lerp), AnimationUtils.lerp(0.0f, width / 2.0f, 0.0f, 1.0f, lerp));
            float calculateChildOffsetCenterForLocation = calculateChildOffsetCenterForLocation(view, f6, keylineRange);
            RectF rectF = new RectF(calculateChildOffsetCenterForLocation - (maskRect.width() / 2.0f), calculateChildOffsetCenterForLocation - (maskRect.height() / 2.0f), calculateChildOffsetCenterForLocation + (maskRect.width() / 2.0f), (maskRect.height() / 2.0f) + calculateChildOffsetCenterForLocation);
            RectF rectF2 = new RectF(getParentLeft(), getParentTop(), getParentRight(), getParentBottom());
            if (this.carouselStrategy.isContained()) {
                this.orientationHelper.containMaskWithinBounds(maskRect, rectF, rectF2);
            }
            this.orientationHelper.moveMaskOnEdgeOutsideBounds(maskRect, rectF, rectF2);
            ((Maskable) view).setMaskRectF(maskRect);
        }
    }

    private void updateCurrentKeylineStateForScrollOffset() {
        int i6 = this.maxScroll;
        int i7 = this.minScroll;
        if (i6 <= i7) {
            this.currentKeylineState = isLayoutRtl() ? this.keylineStateList.getEndState() : this.keylineStateList.getStartState();
        } else {
            this.currentKeylineState = this.keylineStateList.getShiftedState(this.scrollOffset, i7, i6);
        }
        this.debugItemDecoration.setKeylines(this.currentKeylineState.getKeylines());
    }

    private void validateChildOrderIfDebugging() {
        if (!this.isDebuggingEnabled || getChildCount() < 1) {
            return;
        }
        int i6 = 0;
        while (i6 < getChildCount() - 1) {
            int position = getPosition(getChildAt(i6));
            int i7 = i6 + 1;
            int position2 = getPosition(getChildAt(i7));
            if (position > position2) {
                logChildrenIfDebugging();
                throw new IllegalStateException("Detected invalid child order. Child at index [" + i6 + "] had adapter position [" + position + "] and child at index [" + i7 + "] had adapter position [" + position2 + "].");
            }
            i6 = i7;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(@NonNull RecyclerView.State state) {
        return (int) this.keylineStateList.getDefaultState().getItemSize();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(@NonNull RecyclerView.State state) {
        return this.scrollOffset;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(@NonNull RecyclerView.State state) {
        return this.maxScroll - this.minScroll;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    @Nullable
    public PointF computeScrollVectorForPosition(int i6) {
        if (this.keylineStateList == null) {
            return null;
        }
        int offsetToScrollToPosition = getOffsetToScrollToPosition(i6, getKeylineStateForPosition(i6));
        return isHorizontal() ? new PointF(offsetToScrollToPosition, 0.0f) : new PointF(0.0f, offsetToScrollToPosition);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(@NonNull RecyclerView.State state) {
        return (int) this.keylineStateList.getDefaultState().getItemSize();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(@NonNull RecyclerView.State state) {
        return this.scrollOffset;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(@NonNull RecyclerView.State state) {
        return this.maxScroll - this.minScroll;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    int getOffsetToScrollToPositionForSnap(int i6, boolean z5) {
        int offsetToScrollToPosition = getOffsetToScrollToPosition(i6, this.keylineStateList.getShiftedState(this.scrollOffset, this.minScroll, this.maxScroll, true));
        int offsetToScrollToPosition2 = this.keylineStatePositionMap != null ? getOffsetToScrollToPosition(i6, getKeylineStateForPosition(i6)) : offsetToScrollToPosition;
        return (!z5 || Math.abs(offsetToScrollToPosition2) >= Math.abs(offsetToScrollToPosition)) ? offsetToScrollToPosition : offsetToScrollToPosition2;
    }

    public int getOrientation() {
        return this.orientationHelper.orientation;
    }

    @Override // com.google.android.material.carousel.Carousel
    public boolean isHorizontal() {
        return this.orientationHelper.orientation == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void measureChildWithMargins(@NonNull View view, int i6, int i7) {
        if (!(view instanceof Maskable)) {
            throw new IllegalStateException("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        Rect rect = new Rect();
        calculateItemDecorationsForChild(view, rect);
        int i8 = i6 + rect.left + rect.right;
        int i9 = i7 + rect.top + rect.bottom;
        KeylineStateList keylineStateList = this.keylineStateList;
        float itemSize = (keylineStateList == null || this.orientationHelper.orientation != 0) ? ((ViewGroup.MarginLayoutParams) layoutParams).width : keylineStateList.getDefaultState().getItemSize();
        KeylineStateList keylineStateList2 = this.keylineStateList;
        view.measure(RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + i8, (int) itemSize, canScrollHorizontally()), RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + i9, (int) ((keylineStateList2 == null || this.orientationHelper.orientation != 1) ? ((ViewGroup.MarginLayoutParams) layoutParams).height : keylineStateList2.getDefaultState().getItemSize()), canScrollVertically()));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean requestChildRectangleOnScreen(@NonNull RecyclerView recyclerView, @NonNull View view, @NonNull Rect rect, boolean z5, boolean z6) {
        if (this.keylineStateList == null) {
            return false;
        }
        int offsetToScrollToPosition = getOffsetToScrollToPosition(getPosition(view), getKeylineStateForPosition(getPosition(view)));
        if (z6 || offsetToScrollToPosition == 0) {
            return false;
        }
        recyclerView.scrollBy(offsetToScrollToPosition, 0);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i6) {
        if (this.keylineStateList == null) {
            return;
        }
        this.scrollOffset = getScrollOffsetForPosition(i6, getKeylineStateForPosition(i6));
        this.currentFillStartPosition = MathUtils.clamp(i6, 0, Math.max(0, getItemCount() - 1));
        updateCurrentKeylineStateForScrollOffset();
        requestLayout();
    }

    public void setCarouselStrategy(@NonNull CarouselStrategy carouselStrategy) {
        this.carouselStrategy = carouselStrategy;
        refreshKeylineState();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setDebuggingEnabled(@NonNull RecyclerView recyclerView, boolean z5) {
        this.isDebuggingEnabled = z5;
        recyclerView.removeItemDecoration(this.debugItemDecoration);
        if (z5) {
            recyclerView.addItemDecoration(this.debugItemDecoration);
        }
        recyclerView.invalidateItemDecorations();
    }

    public void setOrientation(int i6) {
        if (i6 != 0 && i6 != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i6);
        }
        assertNotInLayoutOrScroll(null);
        CarouselOrientationHelper carouselOrientationHelper = this.orientationHelper;
        if (carouselOrientationHelper == null || i6 != carouselOrientationHelper.orientation) {
            this.orientationHelper = CarouselOrientationHelper.createOrientationHelper(this, i6);
            refreshKeylineState();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i6) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext()) { // from class: com.google.android.material.carousel.CarouselLayoutManager.1
            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public int calculateDxToMakeVisible(View view, int i7) {
                if (CarouselLayoutManager.this.keylineStateList == null || !CarouselLayoutManager.this.isHorizontal()) {
                    return 0;
                }
                CarouselLayoutManager carouselLayoutManager = CarouselLayoutManager.this;
                return carouselLayoutManager.calculateScrollDeltaToMakePositionVisible(carouselLayoutManager.getPosition(view));
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public int calculateDyToMakeVisible(View view, int i7) {
                if (CarouselLayoutManager.this.keylineStateList == null || CarouselLayoutManager.this.isHorizontal()) {
                    return 0;
                }
                CarouselLayoutManager carouselLayoutManager = CarouselLayoutManager.this;
                return carouselLayoutManager.calculateScrollDeltaToMakePositionVisible(carouselLayoutManager.getPosition(view));
            }

            @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
            @Nullable
            public PointF computeScrollVectorForPosition(int i7) {
                return CarouselLayoutManager.this.computeScrollVectorForPosition(i7);
            }
        };
        linearSmoothScroller.setTargetPosition(i6);
        startSmoothScroll(linearSmoothScroller);
    }

    public CarouselLayoutManager(@NonNull CarouselStrategy carouselStrategy, int i6) {
        this.isDebuggingEnabled = false;
        this.debugItemDecoration = new DebugItemDecoration();
        this.currentFillStartPosition = 0;
        setCarouselStrategy(carouselStrategy);
        setOrientation(i6);
    }

    private int addEnd(int i6, int i7) {
        if (isLayoutRtl()) {
            return i6 - i7;
        }
        return i6 + i7;
    }

    private int addStart(int i6, int i7) {
        if (isLayoutRtl()) {
            return i6 + i7;
        }
        return i6 - i7;
    }

    private void addViewsEnd(RecyclerView.Recycler recycler, RecyclerView.State state, int i6) {
        int calculateChildStartForFill = calculateChildStartForFill(i6);
        while (i6 < state.getItemCount()) {
            ChildCalculations makeChildCalculations = makeChildCalculations(recycler, calculateChildStartForFill, i6);
            if (!isLocOffsetOutOfFillBoundsEnd(makeChildCalculations.offsetCenter, makeChildCalculations.range)) {
                calculateChildStartForFill = addEnd(calculateChildStartForFill, (int) this.currentKeylineState.getItemSize());
                if (!isLocOffsetOutOfFillBoundsStart(makeChildCalculations.offsetCenter, makeChildCalculations.range)) {
                    addAndLayoutView(makeChildCalculations.child, -1, makeChildCalculations);
                }
                i6++;
            } else {
                return;
            }
        }
    }

    private void addViewsStart(RecyclerView.Recycler recycler, int i6) {
        int calculateChildStartForFill = calculateChildStartForFill(i6);
        while (i6 >= 0) {
            ChildCalculations makeChildCalculations = makeChildCalculations(recycler, calculateChildStartForFill, i6);
            if (!isLocOffsetOutOfFillBoundsStart(makeChildCalculations.offsetCenter, makeChildCalculations.range)) {
                calculateChildStartForFill = addStart(calculateChildStartForFill, (int) this.currentKeylineState.getItemSize());
                if (!isLocOffsetOutOfFillBoundsEnd(makeChildCalculations.offsetCenter, makeChildCalculations.range)) {
                    addAndLayoutView(makeChildCalculations.child, 0, makeChildCalculations);
                }
                i6--;
            } else {
                return;
            }
        }
    }

    private int calculateChildStartForFill(int i6) {
        return addEnd(getParentStart() - this.scrollOffset, (int) (this.currentKeylineState.getItemSize() * i6));
    }

    private int calculateEndScroll(RecyclerView.State state, KeylineStateList keylineStateList) {
        KeylineState endState;
        KeylineState.Keyline lastFocalKeyline;
        float f6;
        boolean isLayoutRtl = isLayoutRtl();
        if (isLayoutRtl) {
            endState = keylineStateList.getStartState();
        } else {
            endState = keylineStateList.getEndState();
        }
        if (isLayoutRtl) {
            lastFocalKeyline = endState.getFirstFocalKeyline();
        } else {
            lastFocalKeyline = endState.getLastFocalKeyline();
        }
        float itemCount = ((state.getItemCount() - 1) * endState.getItemSize()) + getPaddingEnd();
        if (isLayoutRtl) {
            f6 = -1.0f;
        } else {
            f6 = 1.0f;
        }
        float f7 = itemCount * f6;
        float parentStart = lastFocalKeyline.loc - getParentStart();
        float parentEnd = getParentEnd() - lastFocalKeyline.loc;
        if (Math.abs(parentStart) > Math.abs(f7)) {
            return 0;
        }
        return (int) ((f7 - parentStart) + parentEnd);
    }

    private int calculateStartScroll(KeylineStateList keylineStateList) {
        KeylineState startState;
        KeylineState.Keyline firstFocalKeyline;
        int i6;
        boolean isLayoutRtl = isLayoutRtl();
        if (isLayoutRtl) {
            startState = keylineStateList.getEndState();
        } else {
            startState = keylineStateList.getStartState();
        }
        if (isLayoutRtl) {
            firstFocalKeyline = startState.getLastFocalKeyline();
        } else {
            firstFocalKeyline = startState.getFirstFocalKeyline();
        }
        int paddingStart = getPaddingStart();
        if (isLayoutRtl) {
            i6 = 1;
        } else {
            i6 = -1;
        }
        return (int) (((paddingStart * i6) + getParentStart()) - addStart((int) firstFocalKeyline.loc, (int) (startState.getItemSize() / 2.0f)));
    }

    private void fill(RecyclerView.Recycler recycler, RecyclerView.State state) {
        removeAndRecycleOutOfBoundsViews(recycler);
        if (getChildCount() == 0) {
            addViewsStart(recycler, this.currentFillStartPosition - 1);
            addViewsEnd(recycler, state, this.currentFillStartPosition);
        } else {
            int position = getPosition(getChildAt(0));
            int position2 = getPosition(getChildAt(getChildCount() - 1));
            addViewsStart(recycler, position - 1);
            addViewsEnd(recycler, state, position2 + 1);
        }
        validateChildOrderIfDebugging();
    }

    private int getContainerSize() {
        if (isHorizontal()) {
            return getContainerWidth();
        }
        return getContainerHeight();
    }

    private int getScrollOffsetForPosition(int i6, KeylineState keylineState) {
        if (isLayoutRtl()) {
            return (int) (((getContainerSize() - keylineState.getLastFocalKeyline().loc) - (i6 * keylineState.getItemSize())) - (keylineState.getItemSize() / 2.0f));
        }
        return (int) (((i6 * keylineState.getItemSize()) - keylineState.getFirstFocalKeyline().loc) + (keylineState.getItemSize() / 2.0f));
    }

    private boolean isLocOffsetOutOfFillBoundsEnd(float f6, KeylineRange keylineRange) {
        int addStart = addStart((int) f6, (int) (getMaskedItemSizeForLocOffset(f6, keylineRange) / 2.0f));
        if (isLayoutRtl()) {
            if (addStart >= 0) {
                return false;
            }
            return true;
        }
        if (addStart <= getContainerSize()) {
            return false;
        }
        return true;
    }

    private boolean isLocOffsetOutOfFillBoundsStart(float f6, KeylineRange keylineRange) {
        int addEnd = addEnd((int) f6, (int) (getMaskedItemSizeForLocOffset(f6, keylineRange) / 2.0f));
        if (isLayoutRtl()) {
            if (addEnd <= getContainerSize()) {
                return false;
            }
            return true;
        }
        if (addEnd >= 0) {
            return false;
        }
        return true;
    }

    private void removeAndRecycleOutOfBoundsViews(RecyclerView.Recycler recycler) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            float decoratedCenterXWithMargins = getDecoratedCenterXWithMargins(childAt);
            if (!isLocOffsetOutOfFillBoundsStart(decoratedCenterXWithMargins, getSurroundingKeylineRange(this.currentKeylineState.getKeylines(), decoratedCenterXWithMargins, true))) {
                break;
            } else {
                removeAndRecycleView(childAt, recycler);
            }
        }
        while (getChildCount() - 1 >= 0) {
            View childAt2 = getChildAt(getChildCount() - 1);
            float decoratedCenterXWithMargins2 = getDecoratedCenterXWithMargins(childAt2);
            if (isLocOffsetOutOfFillBoundsEnd(decoratedCenterXWithMargins2, getSurroundingKeylineRange(this.currentKeylineState.getKeylines(), decoratedCenterXWithMargins2, true))) {
                removeAndRecycleView(childAt2, recycler);
            } else {
                return;
            }
        }
    }

    private int scrollBy(int i6, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0 || i6 == 0) {
            return 0;
        }
        int calculateShouldScrollBy = calculateShouldScrollBy(i6, this.scrollOffset, this.minScroll, this.maxScroll);
        this.scrollOffset += calculateShouldScrollBy;
        updateCurrentKeylineStateForScrollOffset();
        float itemSize = this.currentKeylineState.getItemSize() / 2.0f;
        int calculateChildStartForFill = calculateChildStartForFill(getPosition(getChildAt(0)));
        Rect rect = new Rect();
        for (int i7 = 0; i7 < getChildCount(); i7++) {
            offsetChild(getChildAt(i7), calculateChildStartForFill, itemSize, rect);
            calculateChildStartForFill = addEnd(calculateChildStartForFill, (int) this.currentKeylineState.getItemSize());
        }
        fill(recycler, state);
        return calculateShouldScrollBy;
    }

    int calculateScrollDeltaToMakePositionVisible(int i6) {
        return (int) (this.scrollOffset - getScrollOffsetForPosition(i6, getKeylineStateForPosition(i6)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return isHorizontal();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return !isHorizontal();
    }

    @Override // com.google.android.material.carousel.Carousel
    public int getContainerHeight() {
        return getHeight();
    }

    @Override // com.google.android.material.carousel.Carousel
    public int getContainerWidth() {
        return getWidth();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void getDecoratedBoundsWithMargins(@NonNull View view, @NonNull Rect rect) {
        super.getDecoratedBoundsWithMargins(view, rect);
        float centerX = rect.centerX();
        float width = (rect.width() - getMaskedItemSizeForLocOffset(centerX, getSurroundingKeylineRange(this.currentKeylineState.getKeylines(), centerX, true))) / 2.0f;
        rect.set((int) (rect.left + width), rect.top, (int) (rect.right - width), rect.bottom);
    }

    int getOffsetToScrollToPosition(int i6, @NonNull KeylineState keylineState) {
        return getScrollOffsetForPosition(i6, keylineState) - this.scrollOffset;
    }

    boolean isLayoutRtl() {
        if (isHorizontal() && getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(getPosition(getChildAt(0)));
            accessibilityEvent.setToIndex(getPosition(getChildAt(getChildCount() - 1)));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        boolean z5;
        int i6;
        if (state.getItemCount() <= 0) {
            removeAndRecycleAllViews(recycler);
            this.currentFillStartPosition = 0;
            return;
        }
        boolean isLayoutRtl = isLayoutRtl();
        if (this.keylineStateList == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5) {
            View viewForPosition = recycler.getViewForPosition(0);
            measureChildWithMargins(viewForPosition, 0, 0);
            KeylineState onFirstChildMeasuredWithMargins = this.carouselStrategy.onFirstChildMeasuredWithMargins(this, viewForPosition);
            if (isLayoutRtl) {
                onFirstChildMeasuredWithMargins = KeylineState.reverse(onFirstChildMeasuredWithMargins);
            }
            this.keylineStateList = KeylineStateList.from(this, onFirstChildMeasuredWithMargins);
        }
        int calculateStartScroll = calculateStartScroll(this.keylineStateList);
        int calculateEndScroll = calculateEndScroll(state, this.keylineStateList);
        if (isLayoutRtl) {
            i6 = calculateEndScroll;
        } else {
            i6 = calculateStartScroll;
        }
        this.minScroll = i6;
        if (isLayoutRtl) {
            calculateEndScroll = calculateStartScroll;
        }
        this.maxScroll = calculateEndScroll;
        if (z5) {
            this.scrollOffset = calculateStartScroll;
            this.keylineStatePositionMap = this.keylineStateList.getKeylineStateForPositionMap(getItemCount(), this.minScroll, this.maxScroll, isLayoutRtl());
        } else {
            int i7 = this.scrollOffset;
            this.scrollOffset = i7 + calculateShouldScrollBy(0, i7, i6, calculateEndScroll);
        }
        this.currentFillStartPosition = MathUtils.clamp(this.currentFillStartPosition, 0, state.getItemCount());
        updateCurrentKeylineStateForScrollOffset();
        detachAndScrapAttachedViews(recycler);
        fill(recycler, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        if (getChildCount() == 0) {
            this.currentFillStartPosition = 0;
        } else {
            this.currentFillStartPosition = getPosition(getChildAt(0));
        }
        validateChildOrderIfDebugging();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i6, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (canScrollHorizontally()) {
            return scrollBy(i6, recycler, state);
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i6, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (canScrollVertically()) {
            return scrollBy(i6, recycler, state);
        }
        return 0;
    }

    @SuppressLint({"UnknownNullness"})
    public CarouselLayoutManager(Context context, AttributeSet attributeSet, int i6, int i7) {
        this.isDebuggingEnabled = false;
        this.debugItemDecoration = new DebugItemDecoration();
        this.currentFillStartPosition = 0;
        setOrientation(RecyclerView.LayoutManager.getProperties(context, attributeSet, i6, i7).orientation);
        setCarouselStrategy(new MultiBrowseCarouselStrategy());
    }
}
