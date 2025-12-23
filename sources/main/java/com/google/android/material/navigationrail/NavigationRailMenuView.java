package com.google.android.material.navigationrail;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes5.dex */
public class NavigationRailMenuView extends NavigationBarMenuView {

    @Px
    private int itemMinimumHeight;
    private final FrameLayout.LayoutParams layoutParams;

    private int makeSharedHeightSpec(int i6, int i7, int i8) {
        int max = i7 / Math.max(1, i8);
        int i9 = this.itemMinimumHeight;
        if (i9 == -1) {
            i9 = View.MeasureSpec.getSize(i6);
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(i9, max), 0);
    }

    private int measureSharedChildHeights(int i6, int i7, int i8, View view) {
        int makeSharedHeightSpec = view == null ? makeSharedHeightSpec(i6, i7, i8) : View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 0);
        int childCount = getChildCount();
        int i9 = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt != view) {
                i9 += measureChildHeight(childAt, i6, makeSharedHeightSpec);
            }
        }
        return i9;
    }

    @Override // com.google.android.material.navigation.NavigationBarMenuView
    @NonNull
    protected NavigationBarItemView createNavigationBarItemView(@NonNull Context context) {
        return new NavigationRailItemView(context);
    }

    @Px
    public int getItemMinimumHeight() {
        return this.itemMinimumHeight;
    }

    int getMenuGravity() {
        return this.layoutParams.gravity;
    }

    boolean isTopGravity() {
        return (this.layoutParams.gravity & 112) == 48;
    }

    public void setItemMinimumHeight(@Px int i6) {
        if (this.itemMinimumHeight != i6) {
            this.itemMinimumHeight = i6;
            requestLayout();
        }
    }

    void setMenuGravity(int i6) {
        FrameLayout.LayoutParams layoutParams = this.layoutParams;
        if (layoutParams.gravity != i6) {
            layoutParams.gravity = i6;
            setLayoutParams(layoutParams);
        }
    }

    public NavigationRailMenuView(@NonNull Context context) {
        super(context);
        this.itemMinimumHeight = -1;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        this.layoutParams = layoutParams;
        layoutParams.gravity = 49;
        setLayoutParams(layoutParams);
        setItemActiveIndicatorResizeable(true);
    }

    private int measureChildHeight(View view, int i6, int i7) {
        if (view.getVisibility() != 8) {
            view.measure(i6, i7);
            return view.getMeasuredHeight();
        }
        return 0;
    }

    private int measureShiftingChildHeights(int i6, int i7, int i8) {
        int i9;
        View childAt = getChildAt(getSelectedItemPosition());
        if (childAt != null) {
            i9 = measureChildHeight(childAt, i6, makeSharedHeightSpec(i6, i7, i8));
            i7 -= i9;
            i8--;
        } else {
            i9 = 0;
        }
        return i9 + measureSharedChildHeights(i6, i7, i8, childAt);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        int childCount = getChildCount();
        int i10 = i8 - i6;
        int i11 = 0;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                int measuredHeight = childAt.getMeasuredHeight() + i11;
                childAt.layout(0, i11, i10, measuredHeight);
                i11 = measuredHeight;
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        int measureSharedChildHeights;
        int size = View.MeasureSpec.getSize(i7);
        int size2 = getMenu().getVisibleItems().size();
        if (size2 > 1 && isShifting(getLabelVisibilityMode(), size2)) {
            measureSharedChildHeights = measureShiftingChildHeights(i6, size, size2);
        } else {
            measureSharedChildHeights = measureSharedChildHeights(i6, size, size2, null);
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i6), View.resolveSizeAndState(measureSharedChildHeights, i7, 0));
    }
}
