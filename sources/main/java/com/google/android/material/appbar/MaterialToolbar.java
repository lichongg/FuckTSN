package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.internal.ToolbarUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class MaterialToolbar extends Toolbar {
    private static final int DEF_STYLE_RES = R.style.Widget_MaterialComponents_Toolbar;
    private static final ImageView.ScaleType[] LOGO_SCALE_TYPE_ARRAY = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    @Nullable
    private Boolean logoAdjustViewBounds;

    @Nullable
    private ImageView.ScaleType logoScaleType;

    @Nullable
    private Integer navigationIconTint;
    private boolean subtitleCentered;
    private boolean titleCentered;

    public MaterialToolbar(@NonNull Context context) {
        this(context, null);
    }

    public void clearNavigationIconTint() {
        this.navigationIconTint = null;
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            DrawableCompat.setTintList(DrawableCompat.wrap(navigationIcon.mutate()), null);
            setNavigationIcon(navigationIcon);
        }
    }

    public MaterialToolbar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.toolbarStyle);
    }

    private void maybeCenterTitleViews() {
        if (this.titleCentered || this.subtitleCentered) {
            TextView titleTextView = ToolbarUtils.getTitleTextView(this);
            TextView subtitleTextView = ToolbarUtils.getSubtitleTextView(this);
            if (titleTextView == null && subtitleTextView == null) {
                return;
            }
            Pair<Integer, Integer> calculateTitleBoundLimits = calculateTitleBoundLimits(titleTextView, subtitleTextView);
            if (this.titleCentered && titleTextView != null) {
                layoutTitleCenteredHorizontally(titleTextView, calculateTitleBoundLimits);
            }
            if (!this.subtitleCentered || subtitleTextView == null) {
                return;
            }
            layoutTitleCenteredHorizontally(subtitleTextView, calculateTitleBoundLimits);
        }
    }

    @Nullable
    private Drawable maybeTintNavigationIcon(@Nullable Drawable drawable) {
        if (drawable == null || this.navigationIconTint == null) {
            return drawable;
        }
        Drawable wrap = DrawableCompat.wrap(drawable.mutate());
        DrawableCompat.setTint(wrap, this.navigationIconTint.intValue());
        return wrap;
    }

    @Nullable
    public ImageView.ScaleType getLogoScaleType() {
        return this.logoScaleType;
    }

    @Nullable
    @ColorInt
    public Integer getNavigationIconTint() {
        return this.navigationIconTint;
    }

    public boolean isLogoAdjustViewBounds() {
        Boolean bool = this.logoAdjustViewBounds;
        return bool != null && bool.booleanValue();
    }

    public boolean isSubtitleCentered() {
        return this.subtitleCentered;
    }

    public boolean isTitleCentered() {
        return this.titleCentered;
    }

    public void setLogoAdjustViewBounds(boolean z5) {
        Boolean bool = this.logoAdjustViewBounds;
        if (bool == null || bool.booleanValue() != z5) {
            this.logoAdjustViewBounds = Boolean.valueOf(z5);
            requestLayout();
        }
    }

    public void setLogoScaleType(@NonNull ImageView.ScaleType scaleType) {
        if (this.logoScaleType != scaleType) {
            this.logoScaleType = scaleType;
            requestLayout();
        }
    }

    public void setSubtitleCentered(boolean z5) {
        if (this.subtitleCentered != z5) {
            this.subtitleCentered = z5;
            requestLayout();
        }
    }

    public void setTitleCentered(boolean z5) {
        if (this.titleCentered != z5) {
            this.titleCentered = z5;
            requestLayout();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public MaterialToolbar(@androidx.annotation.NonNull android.content.Context r7, @androidx.annotation.Nullable android.util.AttributeSet r8, int r9) {
        /*
            r6 = this;
            int r4 = com.google.android.material.appbar.MaterialToolbar.DEF_STYLE_RES
            android.content.Context r7 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r7, r8, r9, r4)
            r6.<init>(r7, r8, r9)
            android.content.Context r0 = r6.getContext()
            int[] r2 = com.google.android.material.R.styleable.MaterialToolbar
            r7 = 0
            int[] r5 = new int[r7]
            r1 = r8
            r3 = r9
            android.content.res.TypedArray r8 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r0, r1, r2, r3, r4, r5)
            int r9 = com.google.android.material.R.styleable.MaterialToolbar_navigationIconTint
            boolean r1 = r8.hasValue(r9)
            r2 = -1
            if (r1 == 0) goto L28
            int r9 = r8.getColor(r9, r2)
            r6.setNavigationIconTint(r9)
        L28:
            int r9 = com.google.android.material.R.styleable.MaterialToolbar_titleCentered
            boolean r9 = r8.getBoolean(r9, r7)
            r6.titleCentered = r9
            int r9 = com.google.android.material.R.styleable.MaterialToolbar_subtitleCentered
            boolean r9 = r8.getBoolean(r9, r7)
            r6.subtitleCentered = r9
            int r9 = com.google.android.material.R.styleable.MaterialToolbar_logoScaleType
            int r9 = r8.getInt(r9, r2)
            if (r9 < 0) goto L49
            android.widget.ImageView$ScaleType[] r1 = com.google.android.material.appbar.MaterialToolbar.LOGO_SCALE_TYPE_ARRAY
            int r2 = r1.length
            if (r9 >= r2) goto L49
            r9 = r1[r9]
            r6.logoScaleType = r9
        L49:
            int r9 = com.google.android.material.R.styleable.MaterialToolbar_logoAdjustViewBounds
            boolean r1 = r8.hasValue(r9)
            if (r1 == 0) goto L5b
            boolean r7 = r8.getBoolean(r9, r7)
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            r6.logoAdjustViewBounds = r7
        L5b:
            r8.recycle()
            r6.initBackground(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.MaterialToolbar.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    private Pair<Integer, Integer> calculateTitleBoundLimits(@Nullable TextView textView, @Nullable TextView textView2) {
        int measuredWidth = getMeasuredWidth();
        int i6 = measuredWidth / 2;
        int paddingLeft = getPaddingLeft();
        int paddingRight = measuredWidth - getPaddingRight();
        for (int i7 = 0; i7 < getChildCount(); i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8 && childAt != textView && childAt != textView2) {
                if (childAt.getRight() < i6 && childAt.getRight() > paddingLeft) {
                    paddingLeft = childAt.getRight();
                }
                if (childAt.getLeft() > i6 && childAt.getLeft() < paddingRight) {
                    paddingRight = childAt.getLeft();
                }
            }
        }
        return new Pair<>(Integer.valueOf(paddingLeft), Integer.valueOf(paddingRight));
    }

    private void initBackground(Context context) {
        int i6;
        Drawable background = getBackground();
        if (background != null && !(background instanceof ColorDrawable)) {
            return;
        }
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        if (background != null) {
            i6 = ((ColorDrawable) background).getColor();
        } else {
            i6 = 0;
        }
        materialShapeDrawable.setFillColor(ColorStateList.valueOf(i6));
        materialShapeDrawable.initializeElevationOverlay(context);
        materialShapeDrawable.setElevation(ViewCompat.getElevation(this));
        ViewCompat.setBackground(this, materialShapeDrawable);
    }

    private void layoutTitleCenteredHorizontally(View view, Pair<Integer, Integer> pair) {
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = view.getMeasuredWidth();
        int i6 = (measuredWidth / 2) - (measuredWidth2 / 2);
        int i7 = measuredWidth2 + i6;
        int max = Math.max(Math.max(((Integer) pair.first).intValue() - i6, 0), Math.max(i7 - ((Integer) pair.second).intValue(), 0));
        if (max > 0) {
            i6 += max;
            i7 -= max;
            view.measure(View.MeasureSpec.makeMeasureSpec(i7 - i6, 1073741824), view.getMeasuredHeightAndState());
        }
        view.layout(i6, view.getTop(), i7, view.getBottom());
    }

    private void updateLogoImageView() {
        ImageView logoImageView = ToolbarUtils.getLogoImageView(this);
        if (logoImageView != null) {
            Boolean bool = this.logoAdjustViewBounds;
            if (bool != null) {
                logoImageView.setAdjustViewBounds(bool.booleanValue());
            }
            ImageView.ScaleType scaleType = this.logoScaleType;
            if (scaleType != null) {
                logoImageView.setScaleType(scaleType);
            }
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void inflateMenu(int i6) {
        Menu menu = getMenu();
        boolean z5 = menu instanceof MenuBuilder;
        if (z5) {
            ((MenuBuilder) menu).stopDispatchingItemsChanged();
        }
        super.inflateMenu(i6);
        if (z5) {
            ((MenuBuilder) menu).startDispatchingItemsChanged();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        super.onLayout(z5, i6, i7, i8, i9);
        maybeCenterTitleViews();
        updateLogoImageView();
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f6) {
        super.setElevation(f6);
        MaterialShapeUtils.setElevation(this, f6);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(@Nullable Drawable drawable) {
        super.setNavigationIcon(maybeTintNavigationIcon(drawable));
    }

    public void setNavigationIconTint(@ColorInt int i6) {
        this.navigationIconTint = Integer.valueOf(i6);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }
}
