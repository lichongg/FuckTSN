package com.google.android.material.navigation;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.core.util.Pools;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.TextScale;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.util.HashSet;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class NavigationBarMenuView extends ViewGroup implements MenuView {
    private static final int[] CHECKED_STATE_SET = {R.attr.state_checked};
    private static final int[] DISABLED_STATE_SET = {-16842910};
    private static final int ITEM_POOL_SIZE = 5;
    private static final int NO_PADDING = -1;

    @NonNull
    private final SparseArray<BadgeDrawable> badgeDrawables;

    @Nullable
    private NavigationBarItemView[] buttons;
    private ColorStateList itemActiveIndicatorColor;
    private boolean itemActiveIndicatorEnabled;
    private int itemActiveIndicatorHeight;
    private int itemActiveIndicatorLabelPadding;
    private int itemActiveIndicatorMarginHorizontal;
    private boolean itemActiveIndicatorResizeable;
    private ShapeAppearanceModel itemActiveIndicatorShapeAppearance;
    private int itemActiveIndicatorWidth;
    private Drawable itemBackground;
    private int itemBackgroundRes;

    @Dimension
    private int itemIconSize;

    @Nullable
    private ColorStateList itemIconTint;
    private int itemPaddingBottom;
    private int itemPaddingTop;
    private final Pools.Pool<NavigationBarItemView> itemPool;

    @Nullable
    private ColorStateList itemRippleColor;

    @StyleRes
    private int itemTextAppearanceActive;
    private boolean itemTextAppearanceActiveBoldEnabled;

    @StyleRes
    private int itemTextAppearanceInactive;

    @Nullable
    private final ColorStateList itemTextColorDefault;
    private ColorStateList itemTextColorFromUser;
    private int labelVisibilityMode;
    private MenuBuilder menu;

    @NonNull
    private final View.OnClickListener onClickListener;

    @NonNull
    private final SparseArray<View.OnTouchListener> onTouchListeners;
    private NavigationBarPresenter presenter;
    private int selectedItemId;
    private int selectedItemPosition;

    @Nullable
    private final TransitionSet set;

    private boolean isValidId(int i6) {
        return i6 != -1;
    }

    @NonNull
    protected abstract NavigationBarItemView createNavigationBarItemView(@NonNull Context context);

    @Override // androidx.appcompat.view.menu.MenuView
    public int getWindowAnimations() {
        return 0;
    }

    protected boolean isShifting(int i6, int i7) {
        return i6 == -1 ? i7 > 3 : i6 == 0;
    }

    void restoreBadgeDrawables(SparseArray<BadgeDrawable> sparseArray) {
        for (int i6 = 0; i6 < sparseArray.size(); i6++) {
            int keyAt = sparseArray.keyAt(i6);
            if (this.badgeDrawables.indexOfKey(keyAt) < 0) {
                this.badgeDrawables.append(keyAt, sparseArray.get(keyAt));
            }
        }
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setBadge(this.badgeDrawables.get(navigationBarItemView.getId()));
            }
        }
    }

    @Nullable
    private Drawable createItemActiveIndicatorDrawable() {
        if (this.itemActiveIndicatorShapeAppearance == null || this.itemActiveIndicatorColor == null) {
            return null;
        }
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this.itemActiveIndicatorShapeAppearance);
        materialShapeDrawable.setFillColor(this.itemActiveIndicatorColor);
        return materialShapeDrawable;
    }

    private NavigationBarItemView getNewItem() {
        NavigationBarItemView acquire = this.itemPool.acquire();
        return acquire == null ? createNavigationBarItemView(getContext()) : acquire;
    }

    private void removeUnusedBadges() {
        HashSet hashSet = new HashSet();
        for (int i6 = 0; i6 < this.menu.size(); i6++) {
            hashSet.add(Integer.valueOf(this.menu.getItem(i6).getItemId()));
        }
        for (int i7 = 0; i7 < this.badgeDrawables.size(); i7++) {
            int keyAt = this.badgeDrawables.keyAt(i7);
            if (!hashSet.contains(Integer.valueOf(keyAt))) {
                this.badgeDrawables.delete(keyAt);
            }
        }
    }

    @Nullable
    public ColorStateList createDefaultColorStateList(int i6) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i6, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateList = AppCompatResources.getColorStateList(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(androidx.appcompat.R.attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i7 = typedValue.data;
        int defaultColor = colorStateList.getDefaultColor();
        int[] iArr = DISABLED_STATE_SET;
        return new ColorStateList(new int[][]{iArr, CHECKED_STATE_SET, ViewGroup.EMPTY_STATE_SET}, new int[]{colorStateList.getColorForState(iArr, defaultColor), i7, defaultColor});
    }

    @Px
    public int getActiveIndicatorLabelPadding() {
        return this.itemActiveIndicatorLabelPadding;
    }

    @Nullable
    public BadgeDrawable getBadge(int i6) {
        return this.badgeDrawables.get(i6);
    }

    SparseArray<BadgeDrawable> getBadgeDrawables() {
        return this.badgeDrawables;
    }

    @Nullable
    public ColorStateList getIconTintList() {
        return this.itemIconTint;
    }

    @Nullable
    public ColorStateList getItemActiveIndicatorColor() {
        return this.itemActiveIndicatorColor;
    }

    public boolean getItemActiveIndicatorEnabled() {
        return this.itemActiveIndicatorEnabled;
    }

    @Px
    public int getItemActiveIndicatorHeight() {
        return this.itemActiveIndicatorHeight;
    }

    @Px
    public int getItemActiveIndicatorMarginHorizontal() {
        return this.itemActiveIndicatorMarginHorizontal;
    }

    @Nullable
    public ShapeAppearanceModel getItemActiveIndicatorShapeAppearance() {
        return this.itemActiveIndicatorShapeAppearance;
    }

    @Px
    public int getItemActiveIndicatorWidth() {
        return this.itemActiveIndicatorWidth;
    }

    @Nullable
    public Drawable getItemBackground() {
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        return (navigationBarItemViewArr == null || navigationBarItemViewArr.length <= 0) ? this.itemBackground : navigationBarItemViewArr[0].getBackground();
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.itemBackgroundRes;
    }

    @Dimension
    public int getItemIconSize() {
        return this.itemIconSize;
    }

    @Px
    public int getItemPaddingBottom() {
        return this.itemPaddingBottom;
    }

    @Px
    public int getItemPaddingTop() {
        return this.itemPaddingTop;
    }

    @Nullable
    public ColorStateList getItemRippleColor() {
        return this.itemRippleColor;
    }

    @StyleRes
    public int getItemTextAppearanceActive() {
        return this.itemTextAppearanceActive;
    }

    @StyleRes
    public int getItemTextAppearanceInactive() {
        return this.itemTextAppearanceInactive;
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.itemTextColorFromUser;
    }

    public int getLabelVisibilityMode() {
        return this.labelVisibilityMode;
    }

    @Nullable
    protected MenuBuilder getMenu() {
        return this.menu;
    }

    public int getSelectedItemId() {
        return this.selectedItemId;
    }

    protected int getSelectedItemPosition() {
        return this.selectedItemPosition;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public void initialize(@NonNull MenuBuilder menuBuilder) {
        this.menu = menuBuilder;
    }

    protected boolean isItemActiveIndicatorResizeable() {
        return this.itemActiveIndicatorResizeable;
    }

    public void setActiveIndicatorLabelPadding(@Px int i6) {
        this.itemActiveIndicatorLabelPadding = i6;
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorLabelPadding(i6);
            }
        }
    }

    public void setIconTintList(@Nullable ColorStateList colorStateList) {
        this.itemIconTint = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setIconTintList(colorStateList);
            }
        }
    }

    public void setItemActiveIndicatorColor(@Nullable ColorStateList colorStateList) {
        this.itemActiveIndicatorColor = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorDrawable(createItemActiveIndicatorDrawable());
            }
        }
    }

    public void setItemActiveIndicatorEnabled(boolean z5) {
        this.itemActiveIndicatorEnabled = z5;
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorEnabled(z5);
            }
        }
    }

    public void setItemActiveIndicatorHeight(@Px int i6) {
        this.itemActiveIndicatorHeight = i6;
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorHeight(i6);
            }
        }
    }

    public void setItemActiveIndicatorMarginHorizontal(@Px int i6) {
        this.itemActiveIndicatorMarginHorizontal = i6;
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorMarginHorizontal(i6);
            }
        }
    }

    protected void setItemActiveIndicatorResizeable(boolean z5) {
        this.itemActiveIndicatorResizeable = z5;
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorResizeable(z5);
            }
        }
    }

    public void setItemActiveIndicatorShapeAppearance(@Nullable ShapeAppearanceModel shapeAppearanceModel) {
        this.itemActiveIndicatorShapeAppearance = shapeAppearanceModel;
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorDrawable(createItemActiveIndicatorDrawable());
            }
        }
    }

    public void setItemActiveIndicatorWidth(@Px int i6) {
        this.itemActiveIndicatorWidth = i6;
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorWidth(i6);
            }
        }
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        this.itemBackground = drawable;
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemBackground(drawable);
            }
        }
    }

    public void setItemBackgroundRes(int i6) {
        this.itemBackgroundRes = i6;
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemBackground(i6);
            }
        }
    }

    public void setItemIconSize(@Dimension int i6) {
        this.itemIconSize = i6;
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setIconSize(i6);
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void setItemOnTouchListener(int i6, @Nullable View.OnTouchListener onTouchListener) {
        if (onTouchListener == null) {
            this.onTouchListeners.remove(i6);
        } else {
            this.onTouchListeners.put(i6, onTouchListener);
        }
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                if (navigationBarItemView.getItemData().getItemId() == i6) {
                    navigationBarItemView.setOnTouchListener(onTouchListener);
                }
            }
        }
    }

    public void setItemPaddingBottom(@Px int i6) {
        this.itemPaddingBottom = i6;
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemPaddingBottom(i6);
            }
        }
    }

    public void setItemPaddingTop(@Px int i6) {
        this.itemPaddingTop = i6;
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemPaddingTop(i6);
            }
        }
    }

    public void setItemRippleColor(@Nullable ColorStateList colorStateList) {
        this.itemRippleColor = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemRippleColor(colorStateList);
            }
        }
    }

    public void setItemTextAppearanceActive(@StyleRes int i6) {
        this.itemTextAppearanceActive = i6;
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextAppearanceActive(i6);
                ColorStateList colorStateList = this.itemTextColorFromUser;
                if (colorStateList != null) {
                    navigationBarItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean z5) {
        this.itemTextAppearanceActiveBoldEnabled = z5;
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextAppearanceActiveBoldEnabled(z5);
            }
        }
    }

    public void setItemTextAppearanceInactive(@StyleRes int i6) {
        this.itemTextAppearanceInactive = i6;
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextAppearanceInactive(i6);
                ColorStateList colorStateList = this.itemTextColorFromUser;
                if (colorStateList != null) {
                    navigationBarItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextColor(@Nullable ColorStateList colorStateList) {
        this.itemTextColorFromUser = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextColor(colorStateList);
            }
        }
    }

    public void setLabelVisibilityMode(int i6) {
        this.labelVisibilityMode = i6;
    }

    public void setPresenter(@NonNull NavigationBarPresenter navigationBarPresenter) {
        this.presenter = navigationBarPresenter;
    }

    void tryRestoreSelectedItemId(int i6) {
        int size = this.menu.size();
        for (int i7 = 0; i7 < size; i7++) {
            MenuItem item = this.menu.getItem(i7);
            if (i6 == item.getItemId()) {
                this.selectedItemId = i6;
                this.selectedItemPosition = i7;
                item.setChecked(true);
                return;
            }
        }
    }

    public void updateMenuView() {
        TransitionSet transitionSet;
        MenuBuilder menuBuilder = this.menu;
        if (menuBuilder == null || this.buttons == null) {
            return;
        }
        int size = menuBuilder.size();
        if (size != this.buttons.length) {
            buildMenuView();
            return;
        }
        int i6 = this.selectedItemId;
        for (int i7 = 0; i7 < size; i7++) {
            MenuItem item = this.menu.getItem(i7);
            if (item.isChecked()) {
                this.selectedItemId = item.getItemId();
                this.selectedItemPosition = i7;
            }
        }
        if (i6 != this.selectedItemId && (transitionSet = this.set) != null) {
            TransitionManager.beginDelayedTransition(this, transitionSet);
        }
        boolean isShifting = isShifting(this.labelVisibilityMode, this.menu.getVisibleItems().size());
        for (int i8 = 0; i8 < size; i8++) {
            this.presenter.setUpdateSuspended(true);
            this.buttons[i8].setLabelVisibilityMode(this.labelVisibilityMode);
            this.buttons[i8].setShifting(isShifting);
            this.buttons[i8].initialize((MenuItemImpl) this.menu.getItem(i8), 0);
            this.presenter.setUpdateSuspended(false);
        }
    }

    public NavigationBarMenuView(@NonNull Context context) {
        super(context);
        this.itemPool = new Pools.SynchronizedPool(5);
        this.onTouchListeners = new SparseArray<>(5);
        this.selectedItemId = 0;
        this.selectedItemPosition = 0;
        this.badgeDrawables = new SparseArray<>(5);
        this.itemPaddingTop = -1;
        this.itemPaddingBottom = -1;
        this.itemActiveIndicatorLabelPadding = -1;
        this.itemActiveIndicatorResizeable = false;
        this.itemTextColorDefault = createDefaultColorStateList(R.attr.textColorSecondary);
        if (isInEditMode()) {
            this.set = null;
        } else {
            AutoTransition autoTransition = new AutoTransition();
            this.set = autoTransition;
            autoTransition.setOrdering(0);
            autoTransition.setDuration(MotionUtils.resolveThemeDuration(getContext(), com.google.android.material.R.attr.motionDurationMedium4, getResources().getInteger(com.google.android.material.R.integer.material_motion_duration_long_1)));
            autoTransition.setInterpolator(MotionUtils.resolveThemeInterpolator(getContext(), com.google.android.material.R.attr.motionEasingStandard, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
            autoTransition.addTransition(new TextScale());
        }
        this.onClickListener = new View.OnClickListener() { // from class: com.google.android.material.navigation.NavigationBarMenuView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MenuItemImpl itemData = ((NavigationBarItemView) view).getItemData();
                if (NavigationBarMenuView.this.menu.performItemAction(itemData, NavigationBarMenuView.this.presenter, 0)) {
                    return;
                }
                itemData.setChecked(true);
            }
        };
        ViewCompat.setImportantForAccessibility(this, 1);
    }

    private void setBadgeIfNeeded(@NonNull NavigationBarItemView navigationBarItemView) {
        BadgeDrawable badgeDrawable;
        int id = navigationBarItemView.getId();
        if (isValidId(id) && (badgeDrawable = this.badgeDrawables.get(id)) != null) {
            navigationBarItemView.setBadge(badgeDrawable);
        }
    }

    private void validateMenuItemId(int i6) {
        if (isValidId(i6)) {
            return;
        }
        throw new IllegalArgumentException(i6 + " is not a valid view id");
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void buildMenuView() {
        removeAllViews();
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                if (navigationBarItemView != null) {
                    this.itemPool.release(navigationBarItemView);
                    navigationBarItemView.clear();
                }
            }
        }
        if (this.menu.size() == 0) {
            this.selectedItemId = 0;
            this.selectedItemPosition = 0;
            this.buttons = null;
            return;
        }
        removeUnusedBadges();
        this.buttons = new NavigationBarItemView[this.menu.size()];
        boolean isShifting = isShifting(this.labelVisibilityMode, this.menu.getVisibleItems().size());
        for (int i6 = 0; i6 < this.menu.size(); i6++) {
            this.presenter.setUpdateSuspended(true);
            this.menu.getItem(i6).setCheckable(true);
            this.presenter.setUpdateSuspended(false);
            NavigationBarItemView newItem = getNewItem();
            this.buttons[i6] = newItem;
            newItem.setIconTintList(this.itemIconTint);
            newItem.setIconSize(this.itemIconSize);
            newItem.setTextColor(this.itemTextColorDefault);
            newItem.setTextAppearanceInactive(this.itemTextAppearanceInactive);
            newItem.setTextAppearanceActive(this.itemTextAppearanceActive);
            newItem.setTextAppearanceActiveBoldEnabled(this.itemTextAppearanceActiveBoldEnabled);
            newItem.setTextColor(this.itemTextColorFromUser);
            int i7 = this.itemPaddingTop;
            if (i7 != -1) {
                newItem.setItemPaddingTop(i7);
            }
            int i8 = this.itemPaddingBottom;
            if (i8 != -1) {
                newItem.setItemPaddingBottom(i8);
            }
            int i9 = this.itemActiveIndicatorLabelPadding;
            if (i9 != -1) {
                newItem.setActiveIndicatorLabelPadding(i9);
            }
            newItem.setActiveIndicatorWidth(this.itemActiveIndicatorWidth);
            newItem.setActiveIndicatorHeight(this.itemActiveIndicatorHeight);
            newItem.setActiveIndicatorMarginHorizontal(this.itemActiveIndicatorMarginHorizontal);
            newItem.setActiveIndicatorDrawable(createItemActiveIndicatorDrawable());
            newItem.setActiveIndicatorResizeable(this.itemActiveIndicatorResizeable);
            newItem.setActiveIndicatorEnabled(this.itemActiveIndicatorEnabled);
            Drawable drawable = this.itemBackground;
            if (drawable != null) {
                newItem.setItemBackground(drawable);
            } else {
                newItem.setItemBackground(this.itemBackgroundRes);
            }
            newItem.setItemRippleColor(this.itemRippleColor);
            newItem.setShifting(isShifting);
            newItem.setLabelVisibilityMode(this.labelVisibilityMode);
            MenuItemImpl menuItemImpl = (MenuItemImpl) this.menu.getItem(i6);
            newItem.initialize(menuItemImpl, 0);
            newItem.setItemPosition(i6);
            int itemId = menuItemImpl.getItemId();
            newItem.setOnTouchListener(this.onTouchListeners.get(itemId));
            newItem.setOnClickListener(this.onClickListener);
            int i10 = this.selectedItemId;
            if (i10 != 0 && itemId == i10) {
                this.selectedItemPosition = i6;
            }
            setBadgeIfNeeded(newItem);
            addView(newItem);
        }
        int min = Math.min(this.menu.size() - 1, this.selectedItemPosition);
        this.selectedItemPosition = min;
        this.menu.getItem(min).setChecked(true);
    }

    @Nullable
    public NavigationBarItemView findItemView(int i6) {
        validateMenuItemId(i6);
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                if (navigationBarItemView.getId() == i6) {
                    return navigationBarItemView;
                }
            }
            return null;
        }
        return null;
    }

    BadgeDrawable getOrCreateBadge(int i6) {
        validateMenuItemId(i6);
        BadgeDrawable badgeDrawable = this.badgeDrawables.get(i6);
        if (badgeDrawable == null) {
            badgeDrawable = BadgeDrawable.create(getContext());
            this.badgeDrawables.put(i6, badgeDrawable);
        }
        NavigationBarItemView findItemView = findItemView(i6);
        if (findItemView != null) {
            findItemView.setBadge(badgeDrawable);
        }
        return badgeDrawable;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, this.menu.getVisibleItems().size(), false, 1));
    }

    void removeBadge(int i6) {
        validateMenuItemId(i6);
        BadgeDrawable badgeDrawable = this.badgeDrawables.get(i6);
        NavigationBarItemView findItemView = findItemView(i6);
        if (findItemView != null) {
            findItemView.removeBadge();
        }
        if (badgeDrawable != null) {
            this.badgeDrawables.remove(i6);
        }
    }
}
