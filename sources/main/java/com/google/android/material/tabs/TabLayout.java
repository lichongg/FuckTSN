package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.BoolRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Pools;
import androidx.core.view.GravityCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.R;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@ViewPager.DecorView
/* loaded from: D:\Downloads\app\classes5.dex */
public class TabLayout extends HorizontalScrollView {
    private static final int ANIMATION_DURATION = 300;

    @Dimension(unit = 0)
    static final int DEFAULT_GAP_TEXT_ICON = 8;

    @Dimension(unit = 0)
    private static final int DEFAULT_HEIGHT = 48;

    @Dimension(unit = 0)
    private static final int DEFAULT_HEIGHT_WITH_TEXT_ICON = 72;

    @Dimension(unit = 0)
    static final int FIXED_WRAP_GUTTER_MIN = 16;
    public static final int GRAVITY_CENTER = 1;
    public static final int GRAVITY_FILL = 0;
    public static final int GRAVITY_START = 2;
    public static final int INDICATOR_ANIMATION_MODE_ELASTIC = 1;
    public static final int INDICATOR_ANIMATION_MODE_FADE = 2;
    public static final int INDICATOR_ANIMATION_MODE_LINEAR = 0;
    public static final int INDICATOR_GRAVITY_BOTTOM = 0;
    public static final int INDICATOR_GRAVITY_CENTER = 1;
    public static final int INDICATOR_GRAVITY_STRETCH = 3;
    public static final int INDICATOR_GRAVITY_TOP = 2;
    private static final int INVALID_WIDTH = -1;
    private static final String LOG_TAG = "TabLayout";
    public static final int MODE_AUTO = 2;
    public static final int MODE_FIXED = 1;
    public static final int MODE_SCROLLABLE = 0;
    private static final int SELECTED_INDICATOR_HEIGHT_DEFAULT = -1;
    public static final int TAB_LABEL_VISIBILITY_LABELED = 1;
    public static final int TAB_LABEL_VISIBILITY_UNLABELED = 0;

    @Dimension(unit = 0)
    private static final int TAB_MIN_WIDTH_MARGIN = 56;
    private AdapterChangeListener adapterChangeListener;
    private int contentInsetStart;

    @Nullable
    private BaseOnTabSelectedListener currentVpSelectedListener;
    private final int defaultTabTextAppearance;
    int indicatorPosition;
    boolean inlineLabel;
    int mode;
    private TabLayoutOnPageChangeListener pageChangeListener;

    @Nullable
    private PagerAdapter pagerAdapter;
    private DataSetObserver pagerAdapterObserver;
    private final int requestedTabMaxWidth;
    private final int requestedTabMinWidth;
    private ValueAnimator scrollAnimator;
    private final int scrollableTabMinWidth;

    @Nullable
    private BaseOnTabSelectedListener selectedListener;
    private final ArrayList<BaseOnTabSelectedListener> selectedListeners;

    @Nullable
    private Tab selectedTab;
    private int selectedTabTextAppearance;
    float selectedTabTextSize;
    private boolean setupViewPagerImplicitly;

    @NonNull
    final SlidingTabIndicator slidingTabIndicator;
    final int tabBackgroundResId;
    int tabGravity;
    ColorStateList tabIconTint;
    PorterDuff.Mode tabIconTintMode;
    int tabIndicatorAnimationDuration;
    int tabIndicatorAnimationMode;
    boolean tabIndicatorFullWidth;
    int tabIndicatorGravity;
    int tabIndicatorHeight;
    private TabIndicatorInterpolator tabIndicatorInterpolator;
    private final TimeInterpolator tabIndicatorTimeInterpolator;
    int tabMaxWidth;
    int tabPaddingBottom;
    int tabPaddingEnd;
    int tabPaddingStart;
    int tabPaddingTop;
    ColorStateList tabRippleColorStateList;

    @NonNull
    Drawable tabSelectedIndicator;
    private int tabSelectedIndicatorColor;
    private final int tabTextAppearance;
    ColorStateList tabTextColors;
    float tabTextMultiLineSize;
    float tabTextSize;
    private final Pools.Pool<TabView> tabViewPool;
    private final ArrayList<Tab> tabs;
    boolean unboundedRipple;

    @Nullable
    ViewPager viewPager;
    private int viewPagerScrollState;
    private static final int DEF_STYLE_RES = R.style.Widget_Design_TabLayout;
    private static final Pools.Pool<Tab> tabPool = new Pools.SynchronizedPool(16);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class AdapterChangeListener implements ViewPager.OnAdapterChangeListener {
        private boolean autoRefresh;

        AdapterChangeListener() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
        public void onAdapterChanged(@NonNull ViewPager viewPager, @Nullable PagerAdapter pagerAdapter, @Nullable PagerAdapter pagerAdapter2) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.viewPager == viewPager) {
                tabLayout.setPagerAdapter(pagerAdapter2, this.autoRefresh);
            }
        }

        void setAutoRefresh(boolean z5) {
            this.autoRefresh = z5;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Deprecated
    public interface BaseOnTabSelectedListener<T extends Tab> {
        void onTabReselected(T t5);

        void onTabSelected(T t5);

        void onTabUnselected(T t5);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public @interface LabelVisibility {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface Mode {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface OnTabSelectedListener extends BaseOnTabSelectedListener<Tab> {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class PagerAdapterObserver extends DataSetObserver {
        PagerAdapterObserver() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            TabLayout.this.populateFromPagerAdapter();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            TabLayout.this.populateFromPagerAdapter();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class SlidingTabIndicator extends LinearLayout {
        ValueAnimator indicatorAnimator;
        private int layoutDirection;

        SlidingTabIndicator(Context context) {
            super(context);
            this.layoutDirection = -1;
            setWillNotDraw(false);
        }

        private void jumpIndicatorToIndicatorPosition() {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.indicatorPosition == -1) {
                tabLayout.indicatorPosition = tabLayout.getSelectedTabPosition();
            }
            jumpIndicatorToPosition(TabLayout.this.indicatorPosition);
        }

        private void jumpIndicatorToPosition(int i6) {
            if (TabLayout.this.viewPagerScrollState == 0 || (TabLayout.this.getTabSelectedIndicator().getBounds().left == -1 && TabLayout.this.getTabSelectedIndicator().getBounds().right == -1)) {
                View childAt = getChildAt(i6);
                TabIndicatorInterpolator tabIndicatorInterpolator = TabLayout.this.tabIndicatorInterpolator;
                TabLayout tabLayout = TabLayout.this;
                tabIndicatorInterpolator.setIndicatorBoundsForTab(tabLayout, childAt, tabLayout.tabSelectedIndicator);
                TabLayout.this.indicatorPosition = i6;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void jumpIndicatorToSelectedPosition() {
            jumpIndicatorToPosition(TabLayout.this.getSelectedTabPosition());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void tweenIndicatorPosition(View view, View view2, float f6) {
            if (view == null || view.getWidth() <= 0) {
                Drawable drawable = TabLayout.this.tabSelectedIndicator;
                drawable.setBounds(-1, drawable.getBounds().top, -1, TabLayout.this.tabSelectedIndicator.getBounds().bottom);
            } else {
                TabIndicatorInterpolator tabIndicatorInterpolator = TabLayout.this.tabIndicatorInterpolator;
                TabLayout tabLayout = TabLayout.this;
                tabIndicatorInterpolator.updateIndicatorForOffset(tabLayout, view, view2, f6, tabLayout.tabSelectedIndicator);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }

        private void updateOrRecreateIndicatorAnimation(boolean z5, int i6, int i7) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.indicatorPosition == i6) {
                return;
            }
            final View childAt = getChildAt(tabLayout.getSelectedTabPosition());
            final View childAt2 = getChildAt(i6);
            if (childAt2 == null) {
                jumpIndicatorToSelectedPosition();
                return;
            }
            TabLayout.this.indicatorPosition = i6;
            ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.tabs.TabLayout.SlidingTabIndicator.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                    SlidingTabIndicator.this.tweenIndicatorPosition(childAt, childAt2, valueAnimator.getAnimatedFraction());
                }
            };
            if (!z5) {
                this.indicatorAnimator.removeAllUpdateListeners();
                this.indicatorAnimator.addUpdateListener(animatorUpdateListener);
                return;
            }
            ValueAnimator valueAnimator = new ValueAnimator();
            this.indicatorAnimator = valueAnimator;
            valueAnimator.setInterpolator(TabLayout.this.tabIndicatorTimeInterpolator);
            valueAnimator.setDuration(i7);
            valueAnimator.setFloatValues(0.0f, 1.0f);
            valueAnimator.addUpdateListener(animatorUpdateListener);
            valueAnimator.start();
        }

        void animateIndicatorToPosition(int i6, int i7) {
            ValueAnimator valueAnimator = this.indicatorAnimator;
            if (valueAnimator != null && valueAnimator.isRunning() && TabLayout.this.indicatorPosition != i6) {
                this.indicatorAnimator.cancel();
            }
            updateOrRecreateIndicatorAnimation(true, i6, i7);
        }

        @Override // android.view.View
        public void draw(@NonNull Canvas canvas) {
            int height;
            int height2 = TabLayout.this.tabSelectedIndicator.getBounds().height();
            if (height2 < 0) {
                height2 = TabLayout.this.tabSelectedIndicator.getIntrinsicHeight();
            }
            int i6 = TabLayout.this.tabIndicatorGravity;
            if (i6 == 0) {
                height = getHeight() - height2;
                height2 = getHeight();
            } else if (i6 != 1) {
                height = 0;
                if (i6 != 2) {
                    height2 = i6 != 3 ? 0 : getHeight();
                }
            } else {
                height = (getHeight() - height2) / 2;
                height2 = (getHeight() + height2) / 2;
            }
            if (TabLayout.this.tabSelectedIndicator.getBounds().width() > 0) {
                Rect bounds = TabLayout.this.tabSelectedIndicator.getBounds();
                TabLayout.this.tabSelectedIndicator.setBounds(bounds.left, height, bounds.right, height2);
                TabLayout.this.tabSelectedIndicator.draw(canvas);
            }
            super.draw(canvas);
        }

        void setIndicatorPositionFromTabPosition(int i6, float f6) {
            TabLayout.this.indicatorPosition = Math.round(i6 + f6);
            ValueAnimator valueAnimator = this.indicatorAnimator;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.indicatorAnimator.cancel();
            }
            tweenIndicatorPosition(getChildAt(i6), getChildAt(i6 + 1), f6);
        }

        void setSelectedIndicatorHeight(int i6) {
            Rect bounds = TabLayout.this.tabSelectedIndicator.getBounds();
            TabLayout.this.tabSelectedIndicator.setBounds(bounds.left, 0, bounds.right, i6);
            requestLayout();
        }

        boolean childrenNeedLayout() {
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                if (getChildAt(i6).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
            super.onLayout(z5, i6, i7, i8, i9);
            ValueAnimator valueAnimator = this.indicatorAnimator;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                updateOrRecreateIndicatorAnimation(false, TabLayout.this.getSelectedTabPosition(), -1);
            } else {
                jumpIndicatorToIndicatorPosition();
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        protected void onMeasure(int i6, int i7) {
            super.onMeasure(i6, i7);
            if (View.MeasureSpec.getMode(i6) == 1073741824) {
                TabLayout tabLayout = TabLayout.this;
                boolean z5 = true;
                if (tabLayout.tabGravity == 1 || tabLayout.mode == 2) {
                    int childCount = getChildCount();
                    int i8 = 0;
                    for (int i9 = 0; i9 < childCount; i9++) {
                        View childAt = getChildAt(i9);
                        if (childAt.getVisibility() == 0) {
                            i8 = Math.max(i8, childAt.getMeasuredWidth());
                        }
                    }
                    if (i8 > 0) {
                        if (i8 * childCount <= getMeasuredWidth() - (((int) ViewUtils.dpToPx(getContext(), 16)) * 2)) {
                            boolean z6 = false;
                            for (int i10 = 0; i10 < childCount; i10++) {
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i10).getLayoutParams();
                                if (layoutParams.width != i8 || layoutParams.weight != 0.0f) {
                                    layoutParams.width = i8;
                                    layoutParams.weight = 0.0f;
                                    z6 = true;
                                }
                            }
                            z5 = z6;
                        } else {
                            TabLayout tabLayout2 = TabLayout.this;
                            tabLayout2.tabGravity = 0;
                            tabLayout2.updateTabViews(false);
                        }
                        if (z5) {
                            super.onMeasure(i6, i7);
                        }
                    }
                }
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int i6) {
            super.onRtlPropertiesChanged(i6);
            if (Build.VERSION.SDK_INT < 23 && this.layoutDirection != i6) {
                requestLayout();
                this.layoutDirection = i6;
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Tab {
        public static final int INVALID_POSITION = -1;

        @Nullable
        private CharSequence contentDesc;

        @Nullable
        private View customView;

        @Nullable
        private Drawable icon;

        @Nullable
        public TabLayout parent;

        @Nullable
        private Object tag;

        @Nullable
        private CharSequence text;

        @NonNull
        public TabView view;
        private int position = -1;

        @LabelVisibility
        private int labelVisibilityMode = 1;
        private int id = -1;

        void reset() {
            this.parent = null;
            this.view = null;
            this.tag = null;
            this.icon = null;
            this.id = -1;
            this.text = null;
            this.contentDesc = null;
            this.position = -1;
            this.customView = null;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Tab setContentDescription(@StringRes int i6) {
            TabLayout tabLayout = this.parent;
            if (tabLayout != null) {
                return setContentDescription(tabLayout.getResources().getText(i6));
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @NonNull
        @CanIgnoreReturnValue
        public Tab setCustomView(@Nullable View view) {
            this.customView = view;
            updateView();
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Tab setIcon(@Nullable Drawable drawable) {
            this.icon = drawable;
            TabLayout tabLayout = this.parent;
            if (tabLayout.tabGravity == 1 || tabLayout.mode == 2) {
                tabLayout.updateTabViews(true);
            }
            updateView();
            if (BadgeUtils.USE_COMPAT_PARENT && this.view.hasBadgeDrawable() && this.view.badgeDrawable.isVisible()) {
                this.view.invalidate();
            }
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Tab setText(@Nullable CharSequence charSequence) {
            if (TextUtils.isEmpty(this.contentDesc) && !TextUtils.isEmpty(charSequence)) {
                this.view.setContentDescription(charSequence);
            }
            this.text = charSequence;
            updateView();
            return this;
        }

        @Nullable
        public BadgeDrawable getBadge() {
            return this.view.getBadge();
        }

        @Nullable
        public CharSequence getContentDescription() {
            TabView tabView = this.view;
            if (tabView == null) {
                return null;
            }
            return tabView.getContentDescription();
        }

        @Nullable
        public View getCustomView() {
            return this.customView;
        }

        @Nullable
        public Drawable getIcon() {
            return this.icon;
        }

        public int getId() {
            return this.id;
        }

        @NonNull
        public BadgeDrawable getOrCreateBadge() {
            return this.view.getOrCreateBadge();
        }

        public int getPosition() {
            return this.position;
        }

        @LabelVisibility
        public int getTabLabelVisibility() {
            return this.labelVisibilityMode;
        }

        @Nullable
        public Object getTag() {
            return this.tag;
        }

        @Nullable
        public CharSequence getText() {
            return this.text;
        }

        public boolean isSelected() {
            TabLayout tabLayout = this.parent;
            if (tabLayout == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            int selectedTabPosition = tabLayout.getSelectedTabPosition();
            return selectedTabPosition != -1 && selectedTabPosition == this.position;
        }

        public void removeBadge() {
            this.view.removeBadge();
        }

        public void select() {
            TabLayout tabLayout = this.parent;
            if (tabLayout == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            tabLayout.selectTab(this);
        }

        @NonNull
        @CanIgnoreReturnValue
        public Tab setId(int i6) {
            this.id = i6;
            TabView tabView = this.view;
            if (tabView != null) {
                tabView.setId(i6);
            }
            return this;
        }

        void setPosition(int i6) {
            this.position = i6;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Tab setTabLabelVisibility(@LabelVisibility int i6) {
            this.labelVisibilityMode = i6;
            TabLayout tabLayout = this.parent;
            if (tabLayout.tabGravity == 1 || tabLayout.mode == 2) {
                tabLayout.updateTabViews(true);
            }
            updateView();
            if (BadgeUtils.USE_COMPAT_PARENT && this.view.hasBadgeDrawable() && this.view.badgeDrawable.isVisible()) {
                this.view.invalidate();
            }
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Tab setTag(@Nullable Object obj) {
            this.tag = obj;
            return this;
        }

        void updateView() {
            TabView tabView = this.view;
            if (tabView != null) {
                tabView.update();
            }
        }

        @NonNull
        @CanIgnoreReturnValue
        public Tab setCustomView(@LayoutRes int i6) {
            return setCustomView(LayoutInflater.from(this.view.getContext()).inflate(i6, (ViewGroup) this.view, false));
        }

        @NonNull
        @CanIgnoreReturnValue
        public Tab setContentDescription(@Nullable CharSequence charSequence) {
            this.contentDesc = charSequence;
            updateView();
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Tab setText(@StringRes int i6) {
            TabLayout tabLayout = this.parent;
            if (tabLayout != null) {
                return setText(tabLayout.getResources().getText(i6));
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @NonNull
        @CanIgnoreReturnValue
        public Tab setIcon(@DrawableRes int i6) {
            TabLayout tabLayout = this.parent;
            if (tabLayout != null) {
                return setIcon(AppCompatResources.getDrawable(tabLayout.getContext(), i6));
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface TabGravity {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface TabIndicatorAnimationMode {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface TabIndicatorGravity {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class TabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {
        private int previousScrollState;
        private int scrollState;

        @NonNull
        private final WeakReference<TabLayout> tabLayoutRef;

        void reset() {
            this.scrollState = 0;
            this.previousScrollState = 0;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i6) {
            this.previousScrollState = this.scrollState;
            this.scrollState = i6;
            TabLayout tabLayout = this.tabLayoutRef.get();
            if (tabLayout != null) {
                tabLayout.updateViewPagerScrollState(this.scrollState);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i6, float f6, int i7) {
            TabLayout tabLayout = this.tabLayoutRef.get();
            if (tabLayout != null) {
                int i8 = this.scrollState;
                boolean z5 = true;
                if (i8 == 2 && this.previousScrollState != 1) {
                    z5 = false;
                }
                boolean z6 = true;
                if (i8 == 2 && this.previousScrollState == 0) {
                    z6 = false;
                }
                tabLayout.setScrollPosition(i6, f6, z5, z6, false);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i6) {
            TabLayout tabLayout = this.tabLayoutRef.get();
            if (tabLayout == null || tabLayout.getSelectedTabPosition() == i6 || i6 >= tabLayout.getTabCount()) {
                return;
            }
            int i7 = this.scrollState;
            tabLayout.selectTab(tabLayout.getTabAt(i6), i7 == 0 || (i7 == 2 && this.previousScrollState == 0));
        }

        public TabLayoutOnPageChangeListener(TabLayout tabLayout) {
            this.tabLayoutRef = new WeakReference<>(tabLayout);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public final class TabView extends LinearLayout {

        @Nullable
        private View badgeAnchorView;

        @Nullable
        private BadgeDrawable badgeDrawable;

        @Nullable
        private Drawable baseBackgroundDrawable;

        @Nullable
        private ImageView customIconView;

        @Nullable
        private TextView customTextView;

        @Nullable
        private View customView;
        private int defaultMaxLines;
        private ImageView iconView;
        private Tab tab;
        private TextView textView;

        void reset() {
            setTab(null);
            setSelected(false);
        }

        public TabView(@NonNull Context context) {
            super(context);
            this.defaultMaxLines = 2;
            updateBackgroundDrawable(context);
            ViewCompat.setPaddingRelative(this, TabLayout.this.tabPaddingStart, TabLayout.this.tabPaddingTop, TabLayout.this.tabPaddingEnd, TabLayout.this.tabPaddingBottom);
            setGravity(17);
            setOrientation(!TabLayout.this.inlineLabel ? 1 : 0);
            setClickable(true);
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
        }

        private void addOnLayoutChangeListener(@Nullable final View view) {
            if (view == null) {
                return;
            }
            view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.google.android.material.tabs.TabLayout.TabView.1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view2, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13) {
                    if (view.getVisibility() == 0) {
                        TabView.this.tryUpdateBadgeDrawableBounds(view);
                    }
                }
            });
        }

        @NonNull
        private FrameLayout createPreApi18BadgeAnchorRoot() {
            FrameLayout frameLayout = new FrameLayout(getContext());
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            return frameLayout;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void drawBackground(@NonNull Canvas canvas) {
            Drawable drawable = this.baseBackgroundDrawable;
            if (drawable != null) {
                drawable.setBounds(getLeft(), getTop(), getRight(), getBottom());
                this.baseBackgroundDrawable.draw(canvas);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public BadgeDrawable getBadge() {
            return this.badgeDrawable;
        }

        @Nullable
        private FrameLayout getCustomParentForBadge(@NonNull View view) {
            if ((view == this.iconView || view == this.textView) && BadgeUtils.USE_COMPAT_PARENT) {
                return (FrameLayout) view.getParent();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @NonNull
        public BadgeDrawable getOrCreateBadge() {
            if (this.badgeDrawable == null) {
                this.badgeDrawable = BadgeDrawable.create(getContext());
            }
            tryUpdateBadgeAnchor();
            BadgeDrawable badgeDrawable = this.badgeDrawable;
            if (badgeDrawable != null) {
                return badgeDrawable;
            }
            throw new IllegalStateException("Unable to create badge");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean hasBadgeDrawable() {
            return this.badgeDrawable != null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void inflateAndAddDefaultIconView() {
            FrameLayout frameLayout;
            if (BadgeUtils.USE_COMPAT_PARENT) {
                frameLayout = createPreApi18BadgeAnchorRoot();
                addView(frameLayout, 0);
            } else {
                frameLayout = this;
            }
            ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_icon, (ViewGroup) frameLayout, false);
            this.iconView = imageView;
            frameLayout.addView(imageView, 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void inflateAndAddDefaultTextView() {
            FrameLayout frameLayout;
            if (BadgeUtils.USE_COMPAT_PARENT) {
                frameLayout = createPreApi18BadgeAnchorRoot();
                addView(frameLayout);
            } else {
                frameLayout = this;
            }
            TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_text, (ViewGroup) frameLayout, false);
            this.textView = textView;
            frameLayout.addView(textView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeBadge() {
            if (this.badgeAnchorView != null) {
                tryRemoveBadgeFromAnchor();
            }
            this.badgeDrawable = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v0, types: [android.graphics.drawable.RippleDrawable] */
        public void updateBackgroundDrawable(Context context) {
            int i6 = TabLayout.this.tabBackgroundResId;
            if (i6 != 0) {
                Drawable drawable = AppCompatResources.getDrawable(context, i6);
                this.baseBackgroundDrawable = drawable;
                if (drawable != null && drawable.isStateful()) {
                    this.baseBackgroundDrawable.setState(getDrawableState());
                }
            } else {
                this.baseBackgroundDrawable = null;
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(0);
            if (TabLayout.this.tabRippleColorStateList != null) {
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setCornerRadius(1.0E-5f);
                gradientDrawable2.setColor(-1);
                ColorStateList convertToRippleDrawableColor = RippleUtils.convertToRippleDrawableColor(TabLayout.this.tabRippleColorStateList);
                boolean z5 = TabLayout.this.unboundedRipple;
                if (z5) {
                    gradientDrawable = null;
                }
                gradientDrawable = new RippleDrawable(convertToRippleDrawableColor, gradientDrawable, z5 ? null : gradientDrawable2);
            }
            ViewCompat.setBackground(this, gradientDrawable);
            TabLayout.this.invalidate();
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x005d, code lost:
        
            if (r7.tab.labelVisibilityMode == 1) goto L28;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void updateTextAndIcon(@androidx.annotation.Nullable android.widget.TextView r8, @androidx.annotation.Nullable android.widget.ImageView r9, boolean r10) {
            /*
                r7 = this;
                com.google.android.material.tabs.TabLayout$Tab r0 = r7.tab
                r1 = 0
                if (r0 == 0) goto L1a
                android.graphics.drawable.Drawable r0 = r0.getIcon()
                if (r0 == 0) goto L1a
                com.google.android.material.tabs.TabLayout$Tab r0 = r7.tab
                android.graphics.drawable.Drawable r0 = r0.getIcon()
                android.graphics.drawable.Drawable r0 = androidx.core.graphics.drawable.DrawableCompat.wrap(r0)
                android.graphics.drawable.Drawable r0 = r0.mutate()
                goto L1b
            L1a:
                r0 = r1
            L1b:
                if (r0 == 0) goto L2d
                com.google.android.material.tabs.TabLayout r2 = com.google.android.material.tabs.TabLayout.this
                android.content.res.ColorStateList r2 = r2.tabIconTint
                androidx.core.graphics.drawable.DrawableCompat.setTintList(r0, r2)
                com.google.android.material.tabs.TabLayout r2 = com.google.android.material.tabs.TabLayout.this
                android.graphics.PorterDuff$Mode r2 = r2.tabIconTintMode
                if (r2 == 0) goto L2d
                androidx.core.graphics.drawable.DrawableCompat.setTintMode(r0, r2)
            L2d:
                com.google.android.material.tabs.TabLayout$Tab r2 = r7.tab
                if (r2 == 0) goto L36
                java.lang.CharSequence r2 = r2.getText()
                goto L37
            L36:
                r2 = r1
            L37:
                r3 = 8
                r4 = 0
                if (r9 == 0) goto L4e
                if (r0 == 0) goto L48
                r9.setImageDrawable(r0)
                r9.setVisibility(r4)
                r7.setVisibility(r4)
                goto L4e
            L48:
                r9.setVisibility(r3)
                r9.setImageDrawable(r1)
            L4e:
                boolean r0 = android.text.TextUtils.isEmpty(r2)
                if (r8 == 0) goto L78
                if (r0 != 0) goto L60
                com.google.android.material.tabs.TabLayout$Tab r5 = r7.tab
                int r5 = com.google.android.material.tabs.TabLayout.Tab.access$1500(r5)
                r6 = 1
                if (r5 != r6) goto L60
                goto L61
            L60:
                r6 = 0
            L61:
                if (r0 != 0) goto L65
                r5 = r2
                goto L66
            L65:
                r5 = r1
            L66:
                r8.setText(r5)
                if (r6 == 0) goto L6d
                r5 = 0
                goto L6f
            L6d:
                r5 = 8
            L6f:
                r8.setVisibility(r5)
                if (r0 != 0) goto L79
                r7.setVisibility(r4)
                goto L79
            L78:
                r6 = 0
            L79:
                if (r10 == 0) goto Lbd
                if (r9 == 0) goto Lbd
                android.view.ViewGroup$LayoutParams r8 = r9.getLayoutParams()
                android.view.ViewGroup$MarginLayoutParams r8 = (android.view.ViewGroup.MarginLayoutParams) r8
                if (r6 == 0) goto L95
                int r10 = r9.getVisibility()
                if (r10 != 0) goto L95
                android.content.Context r10 = r7.getContext()
                float r10 = com.google.android.material.internal.ViewUtils.dpToPx(r10, r3)
                int r10 = (int) r10
                goto L96
            L95:
                r10 = 0
            L96:
                com.google.android.material.tabs.TabLayout r3 = com.google.android.material.tabs.TabLayout.this
                boolean r3 = r3.inlineLabel
                if (r3 == 0) goto Lae
                int r3 = androidx.core.view.MarginLayoutParamsCompat.getMarginEnd(r8)
                if (r10 == r3) goto Lbd
                androidx.core.view.MarginLayoutParamsCompat.setMarginEnd(r8, r10)
                r8.bottomMargin = r4
                r9.setLayoutParams(r8)
                r9.requestLayout()
                goto Lbd
            Lae:
                int r3 = r8.bottomMargin
                if (r10 == r3) goto Lbd
                r8.bottomMargin = r10
                androidx.core.view.MarginLayoutParamsCompat.setMarginEnd(r8, r4)
                r9.setLayoutParams(r8)
                r9.requestLayout()
            Lbd:
                com.google.android.material.tabs.TabLayout$Tab r8 = r7.tab
                if (r8 == 0) goto Lc5
                java.lang.CharSequence r1 = com.google.android.material.tabs.TabLayout.Tab.access$300(r8)
            Lc5:
                int r8 = android.os.Build.VERSION.SDK_INT
                r9 = 23
                if (r8 <= r9) goto Ld2
                if (r0 != 0) goto Lce
                goto Lcf
            Lce:
                r2 = r1
            Lcf:
                androidx.appcompat.widget.TooltipCompat.setTooltipText(r7, r2)
            Ld2:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.TabView.updateTextAndIcon(android.widget.TextView, android.widget.ImageView, boolean):void");
        }

        int getContentHeight() {
            View[] viewArr = {this.textView, this.iconView, this.customView};
            int i6 = 0;
            int i7 = 0;
            boolean z5 = false;
            for (int i8 = 0; i8 < 3; i8++) {
                View view = viewArr[i8];
                if (view != null && view.getVisibility() == 0) {
                    i7 = z5 ? Math.min(i7, view.getTop()) : view.getTop();
                    i6 = z5 ? Math.max(i6, view.getBottom()) : view.getBottom();
                    z5 = true;
                }
            }
            return i6 - i7;
        }

        int getContentWidth() {
            View[] viewArr = {this.textView, this.iconView, this.customView};
            int i6 = 0;
            int i7 = 0;
            boolean z5 = false;
            for (int i8 = 0; i8 < 3; i8++) {
                View view = viewArr[i8];
                if (view != null && view.getVisibility() == 0) {
                    i7 = z5 ? Math.min(i7, view.getLeft()) : view.getLeft();
                    i6 = z5 ? Math.max(i6, view.getRight()) : view.getRight();
                    z5 = true;
                }
            }
            return i6 - i7;
        }

        @Nullable
        public Tab getTab() {
            return this.tab;
        }

        void setTab(@Nullable Tab tab) {
            if (tab != this.tab) {
                this.tab = tab;
                update();
            }
        }

        final void updateOrientation() {
            setOrientation(!TabLayout.this.inlineLabel ? 1 : 0);
            TextView textView = this.customTextView;
            if (textView == null && this.customIconView == null) {
                updateTextAndIcon(this.textView, this.iconView, true);
            } else {
                updateTextAndIcon(textView, this.customIconView, false);
            }
        }

        final void updateTab() {
            ViewParent parent;
            Tab tab = this.tab;
            View customView = tab != null ? tab.getCustomView() : null;
            if (customView != null) {
                ViewParent parent2 = customView.getParent();
                if (parent2 != this) {
                    if (parent2 != null) {
                        ((ViewGroup) parent2).removeView(customView);
                    }
                    View view = this.customView;
                    if (view != null && (parent = view.getParent()) != null) {
                        ((ViewGroup) parent).removeView(this.customView);
                    }
                    addView(customView);
                }
                this.customView = customView;
                TextView textView = this.textView;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.iconView;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.iconView.setImageDrawable(null);
                }
                TextView textView2 = (TextView) customView.findViewById(android.R.id.text1);
                this.customTextView = textView2;
                if (textView2 != null) {
                    this.defaultMaxLines = TextViewCompat.getMaxLines(textView2);
                }
                this.customIconView = (ImageView) customView.findViewById(android.R.id.icon);
            } else {
                View view2 = this.customView;
                if (view2 != null) {
                    removeView(view2);
                    this.customView = null;
                }
                this.customTextView = null;
                this.customIconView = null;
            }
            if (this.customView == null) {
                if (this.iconView == null) {
                    inflateAndAddDefaultIconView();
                }
                if (this.textView == null) {
                    inflateAndAddDefaultTextView();
                    this.defaultMaxLines = TextViewCompat.getMaxLines(this.textView);
                }
                TextViewCompat.setTextAppearance(this.textView, TabLayout.this.defaultTabTextAppearance);
                if (!isSelected() || TabLayout.this.selectedTabTextAppearance == -1) {
                    TextViewCompat.setTextAppearance(this.textView, TabLayout.this.tabTextAppearance);
                } else {
                    TextViewCompat.setTextAppearance(this.textView, TabLayout.this.selectedTabTextAppearance);
                }
                ColorStateList colorStateList = TabLayout.this.tabTextColors;
                if (colorStateList != null) {
                    this.textView.setTextColor(colorStateList);
                }
                updateTextAndIcon(this.textView, this.iconView, true);
                tryUpdateBadgeAnchor();
                addOnLayoutChangeListener(this.iconView);
                addOnLayoutChangeListener(this.textView);
            } else {
                TextView textView3 = this.customTextView;
                if (textView3 != null || this.customIconView != null) {
                    updateTextAndIcon(textView3, this.customIconView, false);
                }
            }
            if (tab == null || TextUtils.isEmpty(tab.contentDesc)) {
                return;
            }
            setContentDescription(tab.contentDesc);
        }

        private float approximateLineWidth(@NonNull Layout layout, int i6, float f6) {
            return layout.getLineWidth(i6) * (f6 / layout.getPaint().getTextSize());
        }

        private void clipViewToPaddingForBadge(boolean z5) {
            setClipChildren(z5);
            setClipToPadding(z5);
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                viewGroup.setClipChildren(z5);
                viewGroup.setClipToPadding(z5);
            }
        }

        private void tryAttachBadgeToAnchor(@Nullable View view) {
            if (hasBadgeDrawable() && view != null) {
                clipViewToPaddingForBadge(false);
                BadgeUtils.attachBadgeDrawable(this.badgeDrawable, view, getCustomParentForBadge(view));
                this.badgeAnchorView = view;
            }
        }

        private void tryRemoveBadgeFromAnchor() {
            if (hasBadgeDrawable()) {
                clipViewToPaddingForBadge(true);
                View view = this.badgeAnchorView;
                if (view != null) {
                    BadgeUtils.detachBadgeDrawable(this.badgeDrawable, view);
                    this.badgeAnchorView = null;
                }
            }
        }

        private void tryUpdateBadgeAnchor() {
            Tab tab;
            Tab tab2;
            if (!hasBadgeDrawable()) {
                return;
            }
            if (this.customView != null) {
                tryRemoveBadgeFromAnchor();
                return;
            }
            if (this.iconView != null && (tab2 = this.tab) != null && tab2.getIcon() != null) {
                View view = this.badgeAnchorView;
                ImageView imageView = this.iconView;
                if (view != imageView) {
                    tryRemoveBadgeFromAnchor();
                    tryAttachBadgeToAnchor(this.iconView);
                    return;
                } else {
                    tryUpdateBadgeDrawableBounds(imageView);
                    return;
                }
            }
            if (this.textView != null && (tab = this.tab) != null && tab.getTabLabelVisibility() == 1) {
                View view2 = this.badgeAnchorView;
                TextView textView = this.textView;
                if (view2 != textView) {
                    tryRemoveBadgeFromAnchor();
                    tryAttachBadgeToAnchor(this.textView);
                    return;
                } else {
                    tryUpdateBadgeDrawableBounds(textView);
                    return;
                }
            }
            tryRemoveBadgeFromAnchor();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void tryUpdateBadgeDrawableBounds(@NonNull View view) {
            if (hasBadgeDrawable() && view == this.badgeAnchorView) {
                BadgeUtils.setBadgeDrawableBounds(this.badgeDrawable, view, getCustomParentForBadge(view));
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void drawableStateChanged() {
            boolean z5;
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.baseBackgroundDrawable;
            if (drawable != null && drawable.isStateful()) {
                z5 = this.baseBackgroundDrawable.setState(drawableState);
            } else {
                z5 = false;
            }
            if (z5) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            BadgeDrawable badgeDrawable = this.badgeDrawable;
            if (badgeDrawable != null && badgeDrawable.isVisible()) {
                accessibilityNodeInfo.setContentDescription(((Object) getContentDescription()) + ", " + ((Object) this.badgeDrawable.getContentDescription()));
            }
            AccessibilityNodeInfoCompat wrap = AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
            wrap.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, this.tab.getPosition(), 1, false, isSelected()));
            if (isSelected()) {
                wrap.setClickable(false);
                wrap.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
            }
            wrap.setRoleDescription(getResources().getString(R.string.item_view_role_description));
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i6, int i7) {
            Layout layout;
            int size = View.MeasureSpec.getSize(i6);
            int mode = View.MeasureSpec.getMode(i6);
            int tabMaxWidth = TabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i6 = View.MeasureSpec.makeMeasureSpec(TabLayout.this.tabMaxWidth, Integer.MIN_VALUE);
            }
            super.onMeasure(i6, i7);
            if (this.textView != null) {
                float f6 = TabLayout.this.tabTextSize;
                int i8 = this.defaultMaxLines;
                ImageView imageView = this.iconView;
                if (imageView != null && imageView.getVisibility() == 0) {
                    i8 = 1;
                } else {
                    TextView textView = this.textView;
                    if (textView != null && textView.getLineCount() > 1) {
                        f6 = TabLayout.this.tabTextMultiLineSize;
                    }
                }
                float textSize = this.textView.getTextSize();
                int lineCount = this.textView.getLineCount();
                int maxLines = TextViewCompat.getMaxLines(this.textView);
                if (f6 != textSize || (maxLines >= 0 && i8 != maxLines)) {
                    if (TabLayout.this.mode == 1 && f6 > textSize && lineCount == 1 && ((layout = this.textView.getLayout()) == null || approximateLineWidth(layout, 0, f6) > (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) {
                        return;
                    }
                    this.textView.setTextSize(0, f6);
                    this.textView.setMaxLines(i8);
                    super.onMeasure(i6, i7);
                }
            }
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean performClick = super.performClick();
            if (this.tab != null) {
                if (!performClick) {
                    playSoundEffect(0);
                }
                this.tab.select();
                return true;
            }
            return performClick;
        }

        @Override // android.view.View
        public void setSelected(boolean z5) {
            isSelected();
            super.setSelected(z5);
            TextView textView = this.textView;
            if (textView != null) {
                textView.setSelected(z5);
            }
            ImageView imageView = this.iconView;
            if (imageView != null) {
                imageView.setSelected(z5);
            }
            View view = this.customView;
            if (view != null) {
                view.setSelected(z5);
            }
        }

        final void update() {
            boolean z5;
            updateTab();
            Tab tab = this.tab;
            if (tab != null && tab.isSelected()) {
                z5 = true;
            } else {
                z5 = false;
            }
            setSelected(z5);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class ViewPagerOnTabSelectedListener implements OnTabSelectedListener {
        private final ViewPager viewPager;

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(@NonNull Tab tab) {
            this.viewPager.setCurrentItem(tab.getPosition());
        }

        public ViewPagerOnTabSelectedListener(ViewPager viewPager) {
            this.viewPager = viewPager;
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(Tab tab) {
        }
    }

    public TabLayout(@NonNull Context context) {
        this(context, null);
    }

    private void animateToTab(int i6) {
        if (i6 == -1) {
            return;
        }
        if (getWindowToken() == null || !ViewCompat.isLaidOut(this) || this.slidingTabIndicator.childrenNeedLayout()) {
            setScrollPosition(i6, 0.0f, true);
            return;
        }
        int scrollX = getScrollX();
        int calculateScrollXForTab = calculateScrollXForTab(i6, 0.0f);
        if (scrollX != calculateScrollXForTab) {
            ensureScrollAnimator();
            this.scrollAnimator.setIntValues(scrollX, calculateScrollXForTab);
            this.scrollAnimator.start();
        }
        this.slidingTabIndicator.animateIndicatorToPosition(i6, this.tabIndicatorAnimationDuration);
    }

    @NonNull
    private static ColorStateList createColorStateList(int i6, int i7) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i7, i6});
    }

    public void addOnTabSelectedListener(@NonNull OnTabSelectedListener onTabSelectedListener) {
        addOnTabSelectedListener((BaseOnTabSelectedListener) onTabSelectedListener);
    }

    public void addTab(@NonNull Tab tab) {
        addTab(tab, this.tabs.isEmpty());
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view) {
        addViewInternal(view);
    }

    @Override // android.view.View
    protected void onDraw(@NonNull Canvas canvas) {
        for (int i6 = 0; i6 < this.slidingTabIndicator.getChildCount(); i6++) {
            View childAt = this.slidingTabIndicator.getChildAt(i6);
            if (childAt instanceof TabView) {
                ((TabView) childAt).drawBackground(canvas);
            }
        }
        super.onDraw(canvas);
    }

    public void removeOnTabSelectedListener(@NonNull OnTabSelectedListener onTabSelectedListener) {
        removeOnTabSelectedListener((BaseOnTabSelectedListener) onTabSelectedListener);
    }

    public void selectTab(@Nullable Tab tab) {
        selectTab(tab, true);
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable OnTabSelectedListener onTabSelectedListener) {
        setOnTabSelectedListener((BaseOnTabSelectedListener) onTabSelectedListener);
    }

    public void setScrollPosition(int i6, float f6, boolean z5) {
        setScrollPosition(i6, f6, z5, true);
    }

    public void setSelectedTabIndicator(@Nullable Drawable drawable) {
        if (drawable == null) {
            drawable = new GradientDrawable();
        }
        Drawable mutate = DrawableCompat.wrap(drawable).mutate();
        this.tabSelectedIndicator = mutate;
        DrawableUtils.setTint(mutate, this.tabSelectedIndicatorColor);
        int i6 = this.tabIndicatorHeight;
        if (i6 == -1) {
            i6 = this.tabSelectedIndicator.getIntrinsicHeight();
        }
        this.slidingTabIndicator.setSelectedIndicatorHeight(i6);
    }

    public void setTabTextColors(@Nullable ColorStateList colorStateList) {
        if (this.tabTextColors != colorStateList) {
            this.tabTextColors = colorStateList;
            updateAllTabs();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(@Nullable PagerAdapter pagerAdapter) {
        setPagerAdapter(pagerAdapter, false);
    }

    public void setupWithViewPager(@Nullable ViewPager viewPager) {
        setupWithViewPager(viewPager, true);
    }

    void updateTabViews(boolean z5) {
        for (int i6 = 0; i6 < this.slidingTabIndicator.getChildCount(); i6++) {
            View childAt = this.slidingTabIndicator.getChildAt(i6);
            childAt.setMinimumWidth(getTabMinWidth());
            updateTabViewLayoutParams((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z5) {
                childAt.requestLayout();
            }
        }
    }

    public TabLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.tabStyle);
    }

    private void addTabView(@NonNull Tab tab) {
        TabView tabView = tab.view;
        tabView.setSelected(false);
        tabView.setActivated(false);
        this.slidingTabIndicator.addView(tabView, tab.getPosition(), createLayoutParamsForTabs());
    }

    private void addViewInternal(View view) {
        if (!(view instanceof TabItem)) {
            throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
        }
        addTabFromItemView((TabItem) view);
    }

    private void applyGravityForModeScrollable(int i6) {
        if (i6 != 0) {
            if (i6 == 1) {
                this.slidingTabIndicator.setGravity(1);
                return;
            } else if (i6 != 2) {
                return;
            }
        }
        this.slidingTabIndicator.setGravity(GravityCompat.START);
    }

    private void applyModeAndGravity() {
        int i6 = this.mode;
        ViewCompat.setPaddingRelative(this.slidingTabIndicator, (i6 == 0 || i6 == 2) ? Math.max(0, this.contentInsetStart - this.tabPaddingStart) : 0, 0, 0, 0);
        int i7 = this.mode;
        if (i7 == 0) {
            applyGravityForModeScrollable(this.tabGravity);
        } else if (i7 == 1 || i7 == 2) {
            this.slidingTabIndicator.setGravity(1);
        }
        updateTabViews(true);
    }

    private int calculateScrollXForTab(int i6, float f6) {
        View childAt;
        int i7 = this.mode;
        if ((i7 != 0 && i7 != 2) || (childAt = this.slidingTabIndicator.getChildAt(i6)) == null) {
            return 0;
        }
        int i8 = i6 + 1;
        View childAt2 = i8 < this.slidingTabIndicator.getChildCount() ? this.slidingTabIndicator.getChildAt(i8) : null;
        int width = childAt.getWidth();
        int width2 = childAt2 != null ? childAt2.getWidth() : 0;
        int left = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
        int i9 = (int) ((width + width2) * 0.5f * f6);
        return ViewCompat.getLayoutDirection(this) == 0 ? left + i9 : left - i9;
    }

    @NonNull
    private LinearLayout.LayoutParams createLayoutParamsForTabs() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        updateTabViewLayoutParams(layoutParams);
        return layoutParams;
    }

    @NonNull
    private TabView createTabView(@NonNull Tab tab) {
        Pools.Pool<TabView> pool = this.tabViewPool;
        TabView acquire = pool != null ? pool.acquire() : null;
        if (acquire == null) {
            acquire = new TabView(getContext());
        }
        acquire.setTab(tab);
        acquire.setFocusable(true);
        acquire.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(tab.contentDesc)) {
            acquire.setContentDescription(tab.text);
            return acquire;
        }
        acquire.setContentDescription(tab.contentDesc);
        return acquire;
    }

    private void dispatchTabReselected(@NonNull Tab tab) {
        for (int size = this.selectedListeners.size() - 1; size >= 0; size--) {
            this.selectedListeners.get(size).onTabReselected(tab);
        }
    }

    private void dispatchTabSelected(@NonNull Tab tab) {
        for (int size = this.selectedListeners.size() - 1; size >= 0; size--) {
            this.selectedListeners.get(size).onTabSelected(tab);
        }
    }

    private void dispatchTabUnselected(@NonNull Tab tab) {
        for (int size = this.selectedListeners.size() - 1; size >= 0; size--) {
            this.selectedListeners.get(size).onTabUnselected(tab);
        }
    }

    private void ensureScrollAnimator() {
        if (this.scrollAnimator == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.scrollAnimator = valueAnimator;
            valueAnimator.setInterpolator(this.tabIndicatorTimeInterpolator);
            this.scrollAnimator.setDuration(this.tabIndicatorAnimationDuration);
            this.scrollAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.tabs.TabLayout.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator2) {
                    TabLayout.this.scrollTo(((Integer) valueAnimator2.getAnimatedValue()).intValue(), 0);
                }
            });
        }
    }

    @Dimension(unit = 0)
    private int getDefaultHeight() {
        int size = this.tabs.size();
        for (int i6 = 0; i6 < size; i6++) {
            Tab tab = this.tabs.get(i6);
            if (tab != null && tab.getIcon() != null && !TextUtils.isEmpty(tab.getText())) {
                return !this.inlineLabel ? 72 : 48;
            }
        }
        return 48;
    }

    private int getTabMinWidth() {
        int i6 = this.requestedTabMinWidth;
        if (i6 != -1) {
            return i6;
        }
        int i7 = this.mode;
        if (i7 == 0 || i7 == 2) {
            return this.scrollableTabMinWidth;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.slidingTabIndicator.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void removeTabViewAt(int i6) {
        TabView tabView = (TabView) this.slidingTabIndicator.getChildAt(i6);
        this.slidingTabIndicator.removeViewAt(i6);
        if (tabView != null) {
            tabView.reset();
            this.tabViewPool.release(tabView);
        }
        requestLayout();
    }

    private void setSelectedTabView(int i6) {
        int childCount = this.slidingTabIndicator.getChildCount();
        if (i6 < childCount) {
            int i7 = 0;
            while (i7 < childCount) {
                View childAt = this.slidingTabIndicator.getChildAt(i7);
                if ((i7 != i6 || childAt.isSelected()) && (i7 == i6 || !childAt.isSelected())) {
                    childAt.setSelected(i7 == i6);
                    childAt.setActivated(i7 == i6);
                } else {
                    childAt.setSelected(i7 == i6);
                    childAt.setActivated(i7 == i6);
                    if (childAt instanceof TabView) {
                        ((TabView) childAt).updateTab();
                    }
                }
                i7++;
            }
        }
    }

    private void updateAllTabs() {
        int size = this.tabs.size();
        for (int i6 = 0; i6 < size; i6++) {
            this.tabs.get(i6).updateView();
        }
    }

    private void updateTabViewLayoutParams(@NonNull LinearLayout.LayoutParams layoutParams) {
        if (this.mode == 1 && this.tabGravity == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
        } else {
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
        }
    }

    @Deprecated
    public void addOnTabSelectedListener(@Nullable BaseOnTabSelectedListener baseOnTabSelectedListener) {
        if (this.selectedListeners.contains(baseOnTabSelectedListener)) {
            return;
        }
        this.selectedListeners.add(baseOnTabSelectedListener);
    }

    public void addTab(@NonNull Tab tab, int i6) {
        addTab(tab, i6, this.tabs.isEmpty());
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i6) {
        addViewInternal(view);
    }

    public void clearOnTabSelectedListeners() {
        this.selectedListeners.clear();
    }

    protected Tab createTabFromPool() {
        Tab acquire = tabPool.acquire();
        return acquire == null ? new Tab() : acquire;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    public int getSelectedTabPosition() {
        Tab tab = this.selectedTab;
        if (tab != null) {
            return tab.getPosition();
        }
        return -1;
    }

    @Nullable
    public Tab getTabAt(int i6) {
        if (i6 < 0 || i6 >= getTabCount()) {
            return null;
        }
        return this.tabs.get(i6);
    }

    public int getTabCount() {
        return this.tabs.size();
    }

    public int getTabGravity() {
        return this.tabGravity;
    }

    @Nullable
    public ColorStateList getTabIconTint() {
        return this.tabIconTint;
    }

    public int getTabIndicatorAnimationMode() {
        return this.tabIndicatorAnimationMode;
    }

    public int getTabIndicatorGravity() {
        return this.tabIndicatorGravity;
    }

    int getTabMaxWidth() {
        return this.tabMaxWidth;
    }

    public int getTabMode() {
        return this.mode;
    }

    @Nullable
    public ColorStateList getTabRippleColor() {
        return this.tabRippleColorStateList;
    }

    @NonNull
    public Drawable getTabSelectedIndicator() {
        return this.tabSelectedIndicator;
    }

    @Nullable
    public ColorStateList getTabTextColors() {
        return this.tabTextColors;
    }

    public boolean hasUnboundedRipple() {
        return this.unboundedRipple;
    }

    public boolean isInlineLabel() {
        return this.inlineLabel;
    }

    public boolean isTabIndicatorFullWidth() {
        return this.tabIndicatorFullWidth;
    }

    protected boolean releaseFromTabPool(Tab tab) {
        return tabPool.release(tab);
    }

    public void removeAllTabs() {
        for (int childCount = this.slidingTabIndicator.getChildCount() - 1; childCount >= 0; childCount--) {
            removeTabViewAt(childCount);
        }
        Iterator<Tab> it = this.tabs.iterator();
        while (it.hasNext()) {
            Tab next = it.next();
            it.remove();
            next.reset();
            releaseFromTabPool(next);
        }
        this.selectedTab = null;
    }

    @Deprecated
    public void removeOnTabSelectedListener(@Nullable BaseOnTabSelectedListener baseOnTabSelectedListener) {
        this.selectedListeners.remove(baseOnTabSelectedListener);
    }

    public void removeTab(@NonNull Tab tab) {
        if (tab.parent != this) {
            throw new IllegalArgumentException("Tab does not belong to this TabLayout.");
        }
        removeTabAt(tab.getPosition());
    }

    public void removeTabAt(int i6) {
        Tab tab = this.selectedTab;
        int position = tab != null ? tab.getPosition() : 0;
        removeTabViewAt(i6);
        Tab remove = this.tabs.remove(i6);
        if (remove != null) {
            remove.reset();
            releaseFromTabPool(remove);
        }
        int size = this.tabs.size();
        int i7 = -1;
        for (int i8 = i6; i8 < size; i8++) {
            if (this.tabs.get(i8).getPosition() == this.indicatorPosition) {
                i7 = i8;
            }
            this.tabs.get(i8).setPosition(i8);
        }
        this.indicatorPosition = i7;
        if (position == i6) {
            selectTab(this.tabs.isEmpty() ? null : this.tabs.get(Math.max(0, i6 - 1)));
        }
    }

    public void selectTab(@Nullable Tab tab, boolean z5) {
        Tab tab2 = this.selectedTab;
        if (tab2 == tab) {
            if (tab2 != null) {
                dispatchTabReselected(tab);
                animateToTab(tab.getPosition());
                return;
            }
            return;
        }
        int position = tab != null ? tab.getPosition() : -1;
        if (z5) {
            if ((tab2 == null || tab2.getPosition() == -1) && position != -1) {
                setScrollPosition(position, 0.0f, true);
            } else {
                animateToTab(position);
            }
            if (position != -1) {
                setSelectedTabView(position);
            }
        }
        this.selectedTab = tab;
        if (tab2 != null && tab2.parent != null) {
            dispatchTabUnselected(tab2);
        }
        if (tab != null) {
            dispatchTabSelected(tab);
        }
    }

    public void setInlineLabel(boolean z5) {
        if (this.inlineLabel != z5) {
            this.inlineLabel = z5;
            for (int i6 = 0; i6 < this.slidingTabIndicator.getChildCount(); i6++) {
                View childAt = this.slidingTabIndicator.getChildAt(i6);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).updateOrientation();
                }
            }
            applyModeAndGravity();
        }
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable BaseOnTabSelectedListener baseOnTabSelectedListener) {
        BaseOnTabSelectedListener baseOnTabSelectedListener2 = this.selectedListener;
        if (baseOnTabSelectedListener2 != null) {
            removeOnTabSelectedListener(baseOnTabSelectedListener2);
        }
        this.selectedListener = baseOnTabSelectedListener;
        if (baseOnTabSelectedListener != null) {
            addOnTabSelectedListener(baseOnTabSelectedListener);
        }
    }

    void setPagerAdapter(@Nullable PagerAdapter pagerAdapter, boolean z5) {
        DataSetObserver dataSetObserver;
        PagerAdapter pagerAdapter2 = this.pagerAdapter;
        if (pagerAdapter2 != null && (dataSetObserver = this.pagerAdapterObserver) != null) {
            pagerAdapter2.unregisterDataSetObserver(dataSetObserver);
        }
        this.pagerAdapter = pagerAdapter;
        if (z5 && pagerAdapter != null) {
            if (this.pagerAdapterObserver == null) {
                this.pagerAdapterObserver = new PagerAdapterObserver();
            }
            pagerAdapter.registerDataSetObserver(this.pagerAdapterObserver);
        }
        populateFromPagerAdapter();
    }

    public void setScrollPosition(int i6, float f6, boolean z5, boolean z6) {
        setScrollPosition(i6, f6, z5, z6, true);
    }

    public void setSelectedTabIndicatorColor(@ColorInt int i6) {
        this.tabSelectedIndicatorColor = i6;
        DrawableUtils.setTint(this.tabSelectedIndicator, i6);
        updateTabViews(false);
    }

    public void setSelectedTabIndicatorGravity(int i6) {
        if (this.tabIndicatorGravity != i6) {
            this.tabIndicatorGravity = i6;
            ViewCompat.postInvalidateOnAnimation(this.slidingTabIndicator);
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i6) {
        this.tabIndicatorHeight = i6;
        this.slidingTabIndicator.setSelectedIndicatorHeight(i6);
    }

    public void setTabGravity(int i6) {
        if (this.tabGravity != i6) {
            this.tabGravity = i6;
            applyModeAndGravity();
        }
    }

    public void setTabIconTint(@Nullable ColorStateList colorStateList) {
        if (this.tabIconTint != colorStateList) {
            this.tabIconTint = colorStateList;
            updateAllTabs();
        }
    }

    public void setTabIndicatorAnimationMode(int i6) {
        this.tabIndicatorAnimationMode = i6;
        if (i6 == 0) {
            this.tabIndicatorInterpolator = new TabIndicatorInterpolator();
            return;
        }
        if (i6 == 1) {
            this.tabIndicatorInterpolator = new ElasticTabIndicatorInterpolator();
        } else {
            if (i6 == 2) {
                this.tabIndicatorInterpolator = new FadeTabIndicatorInterpolator();
                return;
            }
            throw new IllegalArgumentException(i6 + " is not a valid TabIndicatorAnimationMode");
        }
    }

    public void setTabIndicatorFullWidth(boolean z5) {
        this.tabIndicatorFullWidth = z5;
        this.slidingTabIndicator.jumpIndicatorToSelectedPosition();
        ViewCompat.postInvalidateOnAnimation(this.slidingTabIndicator);
    }

    public void setTabMode(int i6) {
        if (i6 != this.mode) {
            this.mode = i6;
            applyModeAndGravity();
        }
    }

    public void setTabRippleColor(@Nullable ColorStateList colorStateList) {
        if (this.tabRippleColorStateList != colorStateList) {
            this.tabRippleColorStateList = colorStateList;
            for (int i6 = 0; i6 < this.slidingTabIndicator.getChildCount(); i6++) {
                View childAt = this.slidingTabIndicator.getChildAt(i6);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).updateBackgroundDrawable(getContext());
                }
            }
        }
    }

    public void setUnboundedRipple(boolean z5) {
        if (this.unboundedRipple != z5) {
            this.unboundedRipple = z5;
            for (int i6 = 0; i6 < this.slidingTabIndicator.getChildCount(); i6++) {
                View childAt = this.slidingTabIndicator.getChildAt(i6);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).updateBackgroundDrawable(getContext());
                }
            }
        }
    }

    public void setupWithViewPager(@Nullable ViewPager viewPager, boolean z5) {
        setupWithViewPager(viewPager, z5, false);
    }

    void updateViewPagerScrollState(int i6) {
        this.viewPagerScrollState = i6;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public TabLayout(@androidx.annotation.NonNull android.content.Context r10, @androidx.annotation.Nullable android.util.AttributeSet r11, int r12) {
        /*
            Method dump skipped, instructions count: 545
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    private void addTabFromItemView(@NonNull TabItem tabItem) {
        Tab newTab = newTab();
        CharSequence charSequence = tabItem.text;
        if (charSequence != null) {
            newTab.setText(charSequence);
        }
        Drawable drawable = tabItem.icon;
        if (drawable != null) {
            newTab.setIcon(drawable);
        }
        int i6 = tabItem.customLayout;
        if (i6 != 0) {
            newTab.setCustomView(i6);
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            newTab.setContentDescription(tabItem.getContentDescription());
        }
        addTab(newTab);
    }

    private void configureTab(@NonNull Tab tab, int i6) {
        tab.setPosition(i6);
        this.tabs.add(i6, tab);
        int size = this.tabs.size();
        int i7 = -1;
        for (int i8 = i6 + 1; i8 < size; i8++) {
            if (this.tabs.get(i8).getPosition() == this.indicatorPosition) {
                i7 = i8;
            }
            this.tabs.get(i8).setPosition(i8);
        }
        this.indicatorPosition = i7;
    }

    private boolean isScrollingEnabled() {
        if (getTabMode() != 0 && getTabMode() != 2) {
            return false;
        }
        return true;
    }

    private void setupWithViewPager(@Nullable ViewPager viewPager, boolean z5, boolean z6) {
        ViewPager viewPager2 = this.viewPager;
        if (viewPager2 != null) {
            TabLayoutOnPageChangeListener tabLayoutOnPageChangeListener = this.pageChangeListener;
            if (tabLayoutOnPageChangeListener != null) {
                viewPager2.removeOnPageChangeListener(tabLayoutOnPageChangeListener);
            }
            AdapterChangeListener adapterChangeListener = this.adapterChangeListener;
            if (adapterChangeListener != null) {
                this.viewPager.removeOnAdapterChangeListener(adapterChangeListener);
            }
        }
        BaseOnTabSelectedListener baseOnTabSelectedListener = this.currentVpSelectedListener;
        if (baseOnTabSelectedListener != null) {
            removeOnTabSelectedListener(baseOnTabSelectedListener);
            this.currentVpSelectedListener = null;
        }
        if (viewPager != null) {
            this.viewPager = viewPager;
            if (this.pageChangeListener == null) {
                this.pageChangeListener = new TabLayoutOnPageChangeListener(this);
            }
            this.pageChangeListener.reset();
            viewPager.addOnPageChangeListener(this.pageChangeListener);
            ViewPagerOnTabSelectedListener viewPagerOnTabSelectedListener = new ViewPagerOnTabSelectedListener(viewPager);
            this.currentVpSelectedListener = viewPagerOnTabSelectedListener;
            addOnTabSelectedListener((BaseOnTabSelectedListener) viewPagerOnTabSelectedListener);
            PagerAdapter adapter = viewPager.getAdapter();
            if (adapter != null) {
                setPagerAdapter(adapter, z5);
            }
            if (this.adapterChangeListener == null) {
                this.adapterChangeListener = new AdapterChangeListener();
            }
            this.adapterChangeListener.setAutoRefresh(z5);
            viewPager.addOnAdapterChangeListener(this.adapterChangeListener);
            setScrollPosition(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.viewPager = null;
            setPagerAdapter(null, false);
        }
        this.setupViewPagerImplicitly = z6;
    }

    public void addTab(@NonNull Tab tab, boolean z5) {
        addTab(tab, this.tabs.size(), z5);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        addViewInternal(view);
    }

    @NonNull
    public Tab newTab() {
        Tab createTabFromPool = createTabFromPool();
        createTabFromPool.parent = this;
        createTabFromPool.view = createTabView(createTabFromPool);
        if (createTabFromPool.id != -1) {
            createTabFromPool.view.setId(createTabFromPool.id);
        }
        return createTabFromPool;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
        if (this.viewPager == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                setupWithViewPager((ViewPager) parent, true, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.setupViewPagerImplicitly) {
            setupWithViewPager(null);
            this.setupViewPagerImplicitly = false;
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, getTabCount(), false, 1));
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (isScrollingEnabled() && super.onInterceptTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i6, int i7) {
        int round = Math.round(ViewUtils.dpToPx(getContext(), getDefaultHeight()));
        int mode = View.MeasureSpec.getMode(i7);
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                i7 = View.MeasureSpec.makeMeasureSpec(round + getPaddingTop() + getPaddingBottom(), 1073741824);
            }
        } else if (getChildCount() == 1 && View.MeasureSpec.getSize(i7) >= round) {
            getChildAt(0).setMinimumHeight(round);
        }
        int size = View.MeasureSpec.getSize(i6);
        if (View.MeasureSpec.getMode(i6) != 0) {
            int i8 = this.requestedTabMaxWidth;
            if (i8 <= 0) {
                i8 = (int) (size - ViewUtils.dpToPx(getContext(), 56));
            }
            this.tabMaxWidth = i8;
        }
        super.onMeasure(i6, i7);
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            int i9 = this.mode;
            if (i9 != 0) {
                if (i9 != 1) {
                    if (i9 != 2) {
                        return;
                    }
                } else {
                    if (childAt.getMeasuredWidth() == getMeasuredWidth()) {
                        return;
                    }
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), ViewGroup.getChildMeasureSpec(i7, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
                }
            }
            if (childAt.getMeasuredWidth() >= getMeasuredWidth()) {
                return;
            }
            childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), ViewGroup.getChildMeasureSpec(i7, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 8 && !isScrollingEnabled()) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    void populateFromPagerAdapter() {
        int currentItem;
        removeAllTabs();
        PagerAdapter pagerAdapter = this.pagerAdapter;
        if (pagerAdapter != null) {
            int count = pagerAdapter.getCount();
            for (int i6 = 0; i6 < count; i6++) {
                addTab(newTab().setText(this.pagerAdapter.getPageTitle(i6)), false);
            }
            ViewPager viewPager = this.viewPager;
            if (viewPager != null && count > 0 && (currentItem = viewPager.getCurrentItem()) != getSelectedTabPosition() && currentItem < getTabCount()) {
                selectTab(getTabAt(currentItem));
            }
        }
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f6) {
        super.setElevation(f6);
        MaterialShapeUtils.setElevation(this, f6);
    }

    public void setInlineLabelResource(@BoolRes int i6) {
        setInlineLabel(getResources().getBoolean(i6));
    }

    void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        ensureScrollAnimator();
        this.scrollAnimator.addListener(animatorListener);
    }

    void setScrollPosition(int i6, float f6, boolean z5, boolean z6, boolean z7) {
        int round = Math.round(i6 + f6);
        if (round < 0 || round >= this.slidingTabIndicator.getChildCount()) {
            return;
        }
        if (z6) {
            this.slidingTabIndicator.setIndicatorPositionFromTabPosition(i6, f6);
        }
        ValueAnimator valueAnimator = this.scrollAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.scrollAnimator.cancel();
        }
        int calculateScrollXForTab = calculateScrollXForTab(i6, f6);
        int scrollX = getScrollX();
        boolean z8 = (i6 < getSelectedTabPosition() && calculateScrollXForTab >= scrollX) || (i6 > getSelectedTabPosition() && calculateScrollXForTab <= scrollX) || i6 == getSelectedTabPosition();
        if (ViewCompat.getLayoutDirection(this) == 1) {
            z8 = (i6 < getSelectedTabPosition() && calculateScrollXForTab <= scrollX) || (i6 > getSelectedTabPosition() && calculateScrollXForTab >= scrollX) || i6 == getSelectedTabPosition();
        }
        if (z8 || this.viewPagerScrollState == 1 || z7) {
            if (i6 < 0) {
                calculateScrollXForTab = 0;
            }
            scrollTo(calculateScrollXForTab, 0);
        }
        if (z5) {
            setSelectedTabView(round);
        }
    }

    public void setTabIconTintResource(@ColorRes int i6) {
        setTabIconTint(AppCompatResources.getColorStateList(getContext(), i6));
    }

    public void setTabRippleColorResource(@ColorRes int i6) {
        setTabRippleColor(AppCompatResources.getColorStateList(getContext(), i6));
    }

    public void setUnboundedRippleResource(@BoolRes int i6) {
        setUnboundedRipple(getResources().getBoolean(i6));
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        if (getTabScrollRange() > 0) {
            return true;
        }
        return false;
    }

    public void addTab(@NonNull Tab tab, int i6, boolean z5) {
        if (tab.parent == this) {
            configureTab(tab, i6);
            addTabView(tab);
            if (z5) {
                tab.select();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i6, ViewGroup.LayoutParams layoutParams) {
        addViewInternal(view);
    }

    public void setTabTextColors(int i6, int i7) {
        setTabTextColors(createColorStateList(i6, i7));
    }

    public void setSelectedTabIndicator(@DrawableRes int i6) {
        if (i6 != 0) {
            setSelectedTabIndicator(AppCompatResources.getDrawable(getContext(), i6));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }
}
