package com.google.android.material.navigationrail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.resources.MaterialResources;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class NavigationRailView extends NavigationBarView {
    private static final int DEFAULT_HEADER_GRAVITY = 49;
    static final int DEFAULT_MENU_GRAVITY = 49;
    static final int MAX_ITEM_COUNT = 7;
    static final int NO_ITEM_MINIMUM_HEIGHT = -1;

    @Nullable
    private View headerView;

    @Nullable
    private Boolean paddingBottomSystemWindowInsets;

    @Nullable
    private Boolean paddingStartSystemWindowInsets;

    @Nullable
    private Boolean paddingTopSystemWindowInsets;
    private final int topMargin;

    public NavigationRailView(@NonNull Context context) {
        this(context, null);
    }

    public void addHeaderView(@LayoutRes int i6) {
        addHeaderView(LayoutInflater.from(getContext()).inflate(i6, (ViewGroup) this, false));
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int getMaxItemCount() {
        return 7;
    }

    public NavigationRailView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.navigationRailStyle);
    }

    private void applyWindowInsets() {
        ViewUtils.doOnApplyWindowInsets(this, new ViewUtils.OnApplyWindowInsetsListener() { // from class: com.google.android.material.navigationrail.NavigationRailView.1
            @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
            @NonNull
            public WindowInsetsCompat onApplyWindowInsets(View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull ViewUtils.RelativePadding relativePadding) {
                int i6;
                Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
                NavigationRailView navigationRailView = NavigationRailView.this;
                if (navigationRailView.shouldApplyWindowInsetPadding(navigationRailView.paddingTopSystemWindowInsets)) {
                    relativePadding.f32655top += insets.f836top;
                }
                NavigationRailView navigationRailView2 = NavigationRailView.this;
                if (navigationRailView2.shouldApplyWindowInsetPadding(navigationRailView2.paddingBottomSystemWindowInsets)) {
                    relativePadding.bottom += insets.bottom;
                }
                NavigationRailView navigationRailView3 = NavigationRailView.this;
                if (navigationRailView3.shouldApplyWindowInsetPadding(navigationRailView3.paddingStartSystemWindowInsets)) {
                    int i7 = relativePadding.start;
                    if (ViewUtils.isLayoutRtl(view)) {
                        i6 = insets.right;
                    } else {
                        i6 = insets.left;
                    }
                    relativePadding.start = i7 + i6;
                }
                relativePadding.applyToView(view);
                return windowInsetsCompat;
            }
        });
    }

    private boolean isHeaderViewVisible() {
        View view = this.headerView;
        return (view == null || view.getVisibility() == 8) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean shouldApplyWindowInsetPadding(Boolean bool) {
        return bool != null ? bool.booleanValue() : ViewCompat.getFitsSystemWindows(this);
    }

    public void addHeaderView(@NonNull View view) {
        removeHeaderView();
        this.headerView = view;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        layoutParams.topMargin = this.topMargin;
        addView(view, 0, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.navigation.NavigationBarView
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public NavigationRailMenuView createNavigationBarMenuView(@NonNull Context context) {
        return new NavigationRailMenuView(context);
    }

    @Nullable
    public View getHeaderView() {
        return this.headerView;
    }

    public void removeHeaderView() {
        View view = this.headerView;
        if (view != null) {
            removeView(view);
            this.headerView = null;
        }
    }

    public NavigationRailView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6) {
        this(context, attributeSet, i6, R.style.Widget_MaterialComponents_NavigationRailView);
    }

    private NavigationRailMenuView getNavigationRailMenuView() {
        return (NavigationRailMenuView) getMenuView();
    }

    private int makeMinWidthSpec(int i6) {
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        if (View.MeasureSpec.getMode(i6) != 1073741824 && suggestedMinimumWidth > 0) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i6), suggestedMinimumWidth + getPaddingLeft() + getPaddingRight()), 1073741824);
        }
        return i6;
    }

    public int getItemMinimumHeight() {
        return ((NavigationRailMenuView) getMenuView()).getItemMinimumHeight();
    }

    public int getMenuGravity() {
        return getNavigationRailMenuView().getMenuGravity();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        super.onLayout(z5, i6, i7, i8, i9);
        NavigationRailMenuView navigationRailMenuView = getNavigationRailMenuView();
        int i10 = 0;
        if (isHeaderViewVisible()) {
            int bottom = this.headerView.getBottom() + this.topMargin;
            int top2 = navigationRailMenuView.getTop();
            if (top2 < bottom) {
                i10 = bottom - top2;
            }
        } else if (navigationRailMenuView.isTopGravity()) {
            i10 = this.topMargin;
        }
        if (i10 > 0) {
            navigationRailMenuView.layout(navigationRailMenuView.getLeft(), navigationRailMenuView.getTop() + i10, navigationRailMenuView.getRight(), navigationRailMenuView.getBottom() + i10);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i6, int i7) {
        int makeMinWidthSpec = makeMinWidthSpec(i6);
        super.onMeasure(makeMinWidthSpec, i7);
        if (isHeaderViewVisible()) {
            measureChild(getNavigationRailMenuView(), makeMinWidthSpec, View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - this.headerView.getMeasuredHeight()) - this.topMargin, Integer.MIN_VALUE));
        }
    }

    public void setItemMinimumHeight(@Px int i6) {
        ((NavigationRailMenuView) getMenuView()).setItemMinimumHeight(i6);
    }

    public void setMenuGravity(int i6) {
        getNavigationRailMenuView().setMenuGravity(i6);
    }

    public NavigationRailView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
        this.paddingTopSystemWindowInsets = null;
        this.paddingBottomSystemWindowInsets = null;
        this.paddingStartSystemWindowInsets = null;
        this.topMargin = getResources().getDimensionPixelSize(R.dimen.mtrl_navigation_rail_margin);
        Context context2 = getContext();
        TintTypedArray obtainTintedStyledAttributes = ThemeEnforcement.obtainTintedStyledAttributes(context2, attributeSet, R.styleable.NavigationRailView, i6, i7, new int[0]);
        int resourceId = obtainTintedStyledAttributes.getResourceId(R.styleable.NavigationRailView_headerLayout, 0);
        if (resourceId != 0) {
            addHeaderView(resourceId);
        }
        setMenuGravity(obtainTintedStyledAttributes.getInt(R.styleable.NavigationRailView_menuGravity, 49));
        int i8 = R.styleable.NavigationRailView_itemMinHeight;
        if (obtainTintedStyledAttributes.hasValue(i8)) {
            setItemMinimumHeight(obtainTintedStyledAttributes.getDimensionPixelSize(i8, -1));
        }
        int i9 = R.styleable.NavigationRailView_paddingTopSystemWindowInsets;
        if (obtainTintedStyledAttributes.hasValue(i9)) {
            this.paddingTopSystemWindowInsets = Boolean.valueOf(obtainTintedStyledAttributes.getBoolean(i9, false));
        }
        int i10 = R.styleable.NavigationRailView_paddingBottomSystemWindowInsets;
        if (obtainTintedStyledAttributes.hasValue(i10)) {
            this.paddingBottomSystemWindowInsets = Boolean.valueOf(obtainTintedStyledAttributes.getBoolean(i10, false));
        }
        int i11 = R.styleable.NavigationRailView_paddingStartSystemWindowInsets;
        if (obtainTintedStyledAttributes.hasValue(i11)) {
            this.paddingStartSystemWindowInsets = Boolean.valueOf(obtainTintedStyledAttributes.getBoolean(i11, false));
        }
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.m3_navigation_rail_item_padding_top_with_large_font);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R.dimen.m3_navigation_rail_item_padding_bottom_with_large_font);
        float lerp = AnimationUtils.lerp(0.0f, 1.0f, 0.3f, 1.0f, MaterialResources.getFontScale(context2) - 1.0f);
        float lerp2 = AnimationUtils.lerp(getItemPaddingTop(), dimensionPixelOffset, lerp);
        float lerp3 = AnimationUtils.lerp(getItemPaddingBottom(), dimensionPixelOffset2, lerp);
        setItemPaddingTop(Math.round(lerp2));
        setItemPaddingBottom(Math.round(lerp3));
        obtainTintedStyledAttributes.recycle();
        applyWindowInsets();
    }
}
