package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes5.dex */
public class BottomNavigationMenuView extends NavigationBarMenuView {
    private final int activeItemMaxWidth;
    private final int activeItemMinWidth;
    private final int inactiveItemMaxWidth;
    private final int inactiveItemMinWidth;
    private boolean itemHorizontalTranslationEnabled;
    private final List<Integer> tempChildWidths;

    @Override // com.google.android.material.navigation.NavigationBarMenuView
    @NonNull
    protected NavigationBarItemView createNavigationBarItemView(@NonNull Context context) {
        return new BottomNavigationItemView(context);
    }

    public boolean isItemHorizontalTranslationEnabled() {
        return this.itemHorizontalTranslationEnabled;
    }

    public void setItemHorizontalTranslationEnabled(boolean z5) {
        this.itemHorizontalTranslationEnabled = z5;
    }

    public BottomNavigationMenuView(@NonNull Context context) {
        super(context);
        this.tempChildWidths = new ArrayList();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
        Resources resources = getResources();
        this.inactiveItemMaxWidth = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_max_width);
        this.inactiveItemMinWidth = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_min_width);
        this.activeItemMaxWidth = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_max_width);
        this.activeItemMinWidth = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_min_width);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        int childCount = getChildCount();
        int i10 = i8 - i6;
        int i11 = i9 - i7;
        int i12 = 0;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                if (ViewCompat.getLayoutDirection(this) == 1) {
                    int i14 = i10 - i12;
                    childAt.layout(i14 - childAt.getMeasuredWidth(), 0, i14, i11);
                } else {
                    childAt.layout(i12, 0, childAt.getMeasuredWidth() + i12, i11);
                }
                i12 += childAt.getMeasuredWidth();
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        int i8;
        int i9;
        int i10;
        MenuBuilder menu = getMenu();
        int size = View.MeasureSpec.getSize(i6);
        int size2 = menu.getVisibleItems().size();
        int childCount = getChildCount();
        this.tempChildWidths.clear();
        int size3 = View.MeasureSpec.getSize(i7);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size3, 1073741824);
        int i11 = 1;
        if (isShifting(getLabelVisibilityMode(), size2) && isItemHorizontalTranslationEnabled()) {
            View childAt = getChildAt(getSelectedItemPosition());
            int i12 = this.activeItemMinWidth;
            if (childAt.getVisibility() != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(this.activeItemMaxWidth, Integer.MIN_VALUE), makeMeasureSpec);
                i12 = Math.max(i12, childAt.getMeasuredWidth());
            }
            if (childAt.getVisibility() != 8) {
                i9 = 1;
            } else {
                i9 = 0;
            }
            int i13 = size2 - i9;
            int min = Math.min(size - (this.inactiveItemMinWidth * i13), Math.min(i12, this.activeItemMaxWidth));
            int i14 = size - min;
            if (i13 != 0) {
                i11 = i13;
            }
            int min2 = Math.min(i14 / i11, this.inactiveItemMaxWidth);
            int i15 = i14 - (i13 * min2);
            for (int i16 = 0; i16 < childCount; i16++) {
                if (getChildAt(i16).getVisibility() != 8) {
                    if (i16 == getSelectedItemPosition()) {
                        i10 = min;
                    } else {
                        i10 = min2;
                    }
                    if (i15 > 0) {
                        i10++;
                        i15--;
                    }
                } else {
                    i10 = 0;
                }
                this.tempChildWidths.add(Integer.valueOf(i10));
            }
        } else {
            if (size2 != 0) {
                i11 = size2;
            }
            int min3 = Math.min(size / i11, this.activeItemMaxWidth);
            int i17 = size - (size2 * min3);
            for (int i18 = 0; i18 < childCount; i18++) {
                if (getChildAt(i18).getVisibility() != 8) {
                    if (i17 > 0) {
                        i8 = min3 + 1;
                        i17--;
                    } else {
                        i8 = min3;
                    }
                } else {
                    i8 = 0;
                }
                this.tempChildWidths.add(Integer.valueOf(i8));
            }
        }
        int i19 = 0;
        for (int i20 = 0; i20 < childCount; i20++) {
            View childAt2 = getChildAt(i20);
            if (childAt2.getVisibility() != 8) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec(this.tempChildWidths.get(i20).intValue(), 1073741824), makeMeasureSpec);
                childAt2.getLayoutParams().width = childAt2.getMeasuredWidth();
                i19 += childAt2.getMeasuredWidth();
            }
        }
        setMeasuredDimension(i19, size3);
    }
}
