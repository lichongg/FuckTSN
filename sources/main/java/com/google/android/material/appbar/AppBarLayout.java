package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.DoNotInline;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class AppBarLayout extends LinearLayout implements CoordinatorLayout.AttachedBehavior {
    private static final int DEF_STYLE_RES = R.style.Widget_Design_AppBarLayout;
    private static final int INVALID_SCROLL_RANGE = -1;
    static final int PENDING_ACTION_ANIMATE_ENABLED = 4;
    static final int PENDING_ACTION_COLLAPSED = 2;
    static final int PENDING_ACTION_EXPANDED = 1;
    static final int PENDING_ACTION_FORCE = 8;
    static final int PENDING_ACTION_NONE = 0;
    private final float appBarElevation;
    private Behavior behavior;
    private int currentOffset;
    private int downPreScrollRange;
    private int downScrollRange;
    private boolean haveChildWithInterpolator;

    @Nullable
    private WindowInsetsCompat lastInsets;
    private boolean liftOnScroll;

    @Nullable
    private final ColorStateList liftOnScrollColor;

    @Nullable
    private ValueAnimator liftOnScrollColorAnimator;
    private final long liftOnScrollColorDuration;
    private final TimeInterpolator liftOnScrollColorInterpolator;

    @Nullable
    private ValueAnimator.AnimatorUpdateListener liftOnScrollColorUpdateListener;
    private final List<LiftOnScrollListener> liftOnScrollListeners;

    @Nullable
    private WeakReference<View> liftOnScrollTargetView;

    @IdRes
    private int liftOnScrollTargetViewId;
    private boolean liftable;
    private boolean liftableOverride;
    private boolean lifted;
    private List<BaseOnOffsetChangedListener> listeners;
    private int pendingAction;

    @Nullable
    private Drawable statusBarForeground;
    private int[] tmpStatesArray;
    private int totalScrollRange;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    protected static class BaseBehavior<T extends AppBarLayout> extends HeaderBehavior<T> {
        private static final int MAX_OFFSET_ANIMATION_DURATION = 600;
        private boolean coordinatorLayoutA11yScrollable;

        @Nullable
        private WeakReference<View> lastNestedScrollingChildRef;
        private int lastStartedType;
        private ValueAnimator offsetAnimator;
        private int offsetDelta;
        private BaseDragCallback onDragCallback;
        private SavedState savedState;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static abstract class BaseDragCallback<T extends AppBarLayout> {
            public abstract boolean canDrag(@NonNull T t5);
        }

        public BaseBehavior() {
        }

        private static boolean checkFlag(int i6, int i7) {
            return (i6 & i7) == i7;
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        protected static class SavedState extends AbsSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.appbar.AppBarLayout.BaseBehavior.SavedState.1
                @Override // android.os.Parcelable.Creator
                @NonNull
                public SavedState[] newArray(int i6) {
                    return new SavedState[i6];
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.ClassLoaderCreator
                @NonNull
                public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                    return new SavedState(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                @Nullable
                public SavedState createFromParcel(@NonNull Parcel parcel) {
                    return new SavedState(parcel, null);
                }
            };
            boolean firstVisibleChildAtMinimumHeight;
            int firstVisibleChildIndex;
            float firstVisibleChildPercentageShown;
            boolean fullyExpanded;
            boolean fullyScrolled;

            public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.fullyScrolled = parcel.readByte() != 0;
                this.fullyExpanded = parcel.readByte() != 0;
                this.firstVisibleChildIndex = parcel.readInt();
                this.firstVisibleChildPercentageShown = parcel.readFloat();
                this.firstVisibleChildAtMinimumHeight = parcel.readByte() != 0;
            }

            @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
            public void writeToParcel(@NonNull Parcel parcel, int i6) {
                super.writeToParcel(parcel, i6);
                parcel.writeByte(this.fullyScrolled ? (byte) 1 : (byte) 0);
                parcel.writeByte(this.fullyExpanded ? (byte) 1 : (byte) 0);
                parcel.writeInt(this.firstVisibleChildIndex);
                parcel.writeFloat(this.firstVisibleChildPercentageShown);
                parcel.writeByte(this.firstVisibleChildAtMinimumHeight ? (byte) 1 : (byte) 0);
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        private void addActionToExpand(CoordinatorLayout coordinatorLayout, @NonNull final T t5, @NonNull AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, final boolean z5) {
            ViewCompat.replaceAccessibilityAction(coordinatorLayout, accessibilityActionCompat, null, new AccessibilityViewCommand() { // from class: com.google.android.material.appbar.AppBarLayout.BaseBehavior.4
                @Override // androidx.core.view.accessibility.AccessibilityViewCommand
                public boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
                    t5.setExpanded(z5);
                    return true;
                }
            });
        }

        private int calculateSnapOffset(int i6, int i7, int i8) {
            return i6 < (i7 + i8) / 2 ? i7 : i8;
        }

        private void updateAccessibilityActions(CoordinatorLayout coordinatorLayout, @NonNull T t5) {
            View childWithScrollingBehavior;
            ViewCompat.removeAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId());
            ViewCompat.removeAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId());
            if (t5.getTotalScrollRange() == 0 || (childWithScrollingBehavior = getChildWithScrollingBehavior(coordinatorLayout)) == null || !childrenHaveScrollFlags(t5)) {
                return;
            }
            if (!ViewCompat.hasAccessibilityDelegate(coordinatorLayout)) {
                ViewCompat.setAccessibilityDelegate(coordinatorLayout, new AccessibilityDelegateCompat() { // from class: com.google.android.material.appbar.AppBarLayout.BaseBehavior.2
                    @Override // androidx.core.view.AccessibilityDelegateCompat
                    public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                        accessibilityNodeInfoCompat.setScrollable(BaseBehavior.this.coordinatorLayoutA11yScrollable);
                        accessibilityNodeInfoCompat.setClassName(ScrollView.class.getName());
                    }
                });
            }
            this.coordinatorLayoutA11yScrollable = addAccessibilityScrollActions(coordinatorLayout, t5, childWithScrollingBehavior);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        public boolean canDragView(T t5) {
            BaseDragCallback baseDragCallback = this.onDragCallback;
            if (baseDragCallback != null) {
                return baseDragCallback.canDrag(t5);
            }
            WeakReference<View> weakReference = this.lastNestedScrollingChildRef;
            if (weakReference == null) {
                return true;
            }
            View view = weakReference.get();
            return (view == null || !view.isShown() || view.canScrollVertically(-1)) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        public int getMaxDragOffset(@NonNull T t5) {
            return (-t5.getDownNestedScrollRange()) + t5.getTopInset();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        public int getScrollRangeForDragFling(@NonNull T t5) {
            return t5.getTotalScrollRange();
        }

        @VisibleForTesting
        boolean isOffsetAnimatorRunning() {
            ValueAnimator valueAnimator = this.offsetAnimator;
            return valueAnimator != null && valueAnimator.isRunning();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        public void onFlingFinished(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t5) {
            snapToChildIfNeeded(coordinatorLayout, t5);
            if (t5.isLiftOnScroll()) {
                t5.setLiftedState(t5.shouldLift(findFirstScrollingChild(coordinatorLayout)));
            }
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t5, int i6) {
            boolean onLayoutChild = super.onLayoutChild(coordinatorLayout, (CoordinatorLayout) t5, i6);
            int pendingAction = t5.getPendingAction();
            SavedState savedState = this.savedState;
            if (savedState == null || (pendingAction & 8) != 0) {
                if (pendingAction != 0) {
                    boolean z5 = (pendingAction & 4) != 0;
                    if ((pendingAction & 2) != 0) {
                        int i7 = -t5.getUpNestedPreScrollRange();
                        if (z5) {
                            animateOffsetTo(coordinatorLayout, t5, i7, 0.0f);
                        } else {
                            setHeaderTopBottomOffset(coordinatorLayout, t5, i7);
                        }
                    } else if ((pendingAction & 1) != 0) {
                        if (z5) {
                            animateOffsetTo(coordinatorLayout, t5, 0, 0.0f);
                        } else {
                            setHeaderTopBottomOffset(coordinatorLayout, t5, 0);
                        }
                    }
                }
            } else if (savedState.fullyScrolled) {
                setHeaderTopBottomOffset(coordinatorLayout, t5, -t5.getTotalScrollRange());
            } else if (savedState.fullyExpanded) {
                setHeaderTopBottomOffset(coordinatorLayout, t5, 0);
            } else {
                View childAt = t5.getChildAt(savedState.firstVisibleChildIndex);
                setHeaderTopBottomOffset(coordinatorLayout, t5, (-childAt.getBottom()) + (this.savedState.firstVisibleChildAtMinimumHeight ? ViewCompat.getMinimumHeight(childAt) + t5.getTopInset() : Math.round(childAt.getHeight() * this.savedState.firstVisibleChildPercentageShown)));
            }
            t5.resetPendingAction();
            this.savedState = null;
            setTopAndBottomOffset(MathUtils.clamp(getTopAndBottomOffset(), -t5.getTotalScrollRange(), 0));
            updateAppBarLayoutDrawableState(coordinatorLayout, t5, getTopAndBottomOffset(), 0, true);
            t5.onOffsetChanged(getTopAndBottomOffset());
            updateAccessibilityActions(coordinatorLayout, t5);
            return onLayoutChild;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t5, int i6, int i7, int i8, int i9) {
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) t5.getLayoutParams())).height != -2) {
                return super.onMeasureChild(coordinatorLayout, (CoordinatorLayout) t5, i6, i7, i8, i9);
            }
            coordinatorLayout.onMeasureChild(t5, i6, i7, View.MeasureSpec.makeMeasureSpec(0, 0), i9);
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x002e  */
        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onNestedPreScroll(androidx.coordinatorlayout.widget.CoordinatorLayout r7, @androidx.annotation.NonNull T r8, android.view.View r9, int r10, int r11, int[] r12, int r13) {
            /*
                r6 = this;
                if (r11 == 0) goto L27
                if (r11 >= 0) goto L11
                int r10 = r8.getTotalScrollRange()
                int r10 = -r10
                int r13 = r8.getDownNestedPreScrollRange()
                int r13 = r13 + r10
                r5 = r13
            Lf:
                r4 = r10
                goto L19
            L11:
                int r10 = r8.getUpNestedPreScrollRange()
                int r10 = -r10
                r13 = 0
                r5 = 0
                goto Lf
            L19:
                if (r4 == r5) goto L27
                r10 = 1
                r0 = r6
                r1 = r7
                r2 = r8
                r3 = r11
                int r7 = r0.scroll(r1, r2, r3, r4, r5)
                r12[r10] = r7
                goto L28
            L27:
                r2 = r8
            L28:
                boolean r7 = r2.isLiftOnScroll()
                if (r7 == 0) goto L35
                boolean r7 = r2.shouldLift(r9)
                r2.setLiftedState(r7)
            L35:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.onNestedPreScroll(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, android.view.View, int, int, int[], int):void");
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull T t5, View view, int i6, int i7, int i8, int i9, int i10, int[] iArr) {
            CoordinatorLayout coordinatorLayout2;
            T t6;
            int i11;
            if (i9 < 0) {
                coordinatorLayout2 = coordinatorLayout;
                t6 = t5;
                i11 = i9;
                iArr[1] = scroll(coordinatorLayout2, t6, i11, -t5.getDownNestedScrollRange(), 0);
            } else {
                coordinatorLayout2 = coordinatorLayout;
                t6 = t5;
                i11 = i9;
            }
            if (i11 == 0) {
                updateAccessibilityActions(coordinatorLayout2, t6);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onRestoreInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t5, Parcelable parcelable) {
            if (parcelable instanceof SavedState) {
                restoreScrollState((SavedState) parcelable, true);
                super.onRestoreInstanceState(coordinatorLayout, (CoordinatorLayout) t5, this.savedState.getSuperState());
            } else {
                super.onRestoreInstanceState(coordinatorLayout, (CoordinatorLayout) t5, parcelable);
                this.savedState = null;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public Parcelable onSaveInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t5) {
            Parcelable onSaveInstanceState = super.onSaveInstanceState(coordinatorLayout, (CoordinatorLayout) t5);
            SavedState saveScrollState = saveScrollState(onSaveInstanceState, t5);
            return saveScrollState == null ? onSaveInstanceState : saveScrollState;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t5, @NonNull View view, View view2, int i6, int i7) {
            ValueAnimator valueAnimator;
            boolean z5 = (i6 & 2) != 0 && (t5.isLiftOnScroll() || canScrollChildren(coordinatorLayout, t5, view));
            if (z5 && (valueAnimator = this.offsetAnimator) != null) {
                valueAnimator.cancel();
            }
            this.lastNestedScrollingChildRef = null;
            this.lastStartedType = i7;
            return z5;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull T t5, View view, int i6) {
            if (this.lastStartedType == 0 || i6 == 1) {
                snapToChildIfNeeded(coordinatorLayout, t5);
                if (t5.isLiftOnScroll()) {
                    t5.setLiftedState(t5.shouldLift(view));
                }
            }
            this.lastNestedScrollingChildRef = new WeakReference<>(view);
        }

        void restoreScrollState(@Nullable SavedState savedState, boolean z5) {
            if (this.savedState == null || z5) {
                this.savedState = savedState;
            }
        }

        public void setDragCallback(@Nullable BaseDragCallback baseDragCallback) {
            this.onDragCallback = baseDragCallback;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        public int setHeaderTopBottomOffset(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t5, int i6, int i7, int i8) {
            CoordinatorLayout coordinatorLayout2;
            T t6;
            int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
            int i9 = 0;
            if (i7 == 0 || topBottomOffsetForScrollingSibling < i7 || topBottomOffsetForScrollingSibling > i8) {
                coordinatorLayout2 = coordinatorLayout;
                t6 = t5;
                this.offsetDelta = 0;
            } else {
                int clamp = MathUtils.clamp(i6, i7, i8);
                if (topBottomOffsetForScrollingSibling != clamp) {
                    int interpolateOffset = t5.hasChildWithInterpolator() ? interpolateOffset(t5, clamp) : clamp;
                    boolean topAndBottomOffset = setTopAndBottomOffset(interpolateOffset);
                    int i10 = topBottomOffsetForScrollingSibling - clamp;
                    this.offsetDelta = clamp - interpolateOffset;
                    if (topAndBottomOffset) {
                        while (i9 < t5.getChildCount()) {
                            LayoutParams layoutParams = (LayoutParams) t5.getChildAt(i9).getLayoutParams();
                            ChildScrollEffect scrollEffect = layoutParams.getScrollEffect();
                            if (scrollEffect != null && (layoutParams.getScrollFlags() & 1) != 0) {
                                scrollEffect.onOffsetChanged(t5, t5.getChildAt(i9), getTopAndBottomOffset());
                            }
                            i9++;
                        }
                    }
                    if (!topAndBottomOffset && t5.hasChildWithInterpolator()) {
                        coordinatorLayout.dispatchDependentViewsChanged(t5);
                    }
                    t5.onOffsetChanged(getTopAndBottomOffset());
                    coordinatorLayout2 = coordinatorLayout;
                    t6 = t5;
                    updateAppBarLayoutDrawableState(coordinatorLayout2, t6, clamp, clamp < topBottomOffsetForScrollingSibling ? -1 : 1, false);
                    i9 = i10;
                } else {
                    coordinatorLayout2 = coordinatorLayout;
                    t6 = t5;
                }
            }
            updateAccessibilityActions(coordinatorLayout2, t6);
            return i9;
        }

        private boolean addAccessibilityScrollActions(final CoordinatorLayout coordinatorLayout, @NonNull final T t5, @NonNull final View view) {
            boolean z5 = false;
            if (getTopBottomOffsetForScrollingSibling() != (-t5.getTotalScrollRange())) {
                addActionToExpand(coordinatorLayout, t5, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD, false);
                z5 = true;
            }
            if (getTopBottomOffsetForScrollingSibling() != 0) {
                if (view.canScrollVertically(-1)) {
                    final int i6 = -t5.getDownNestedPreScrollRange();
                    if (i6 != 0) {
                        ViewCompat.replaceAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, null, new AccessibilityViewCommand() { // from class: com.google.android.material.appbar.AppBarLayout.BaseBehavior.3
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // androidx.core.view.accessibility.AccessibilityViewCommand
                            public boolean perform(@NonNull View view2, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
                                BaseBehavior.this.onNestedPreScroll(coordinatorLayout, (CoordinatorLayout) t5, view, 0, i6, new int[]{0, 0}, 1);
                                return true;
                            }
                        });
                        return true;
                    }
                } else {
                    addActionToExpand(coordinatorLayout, t5, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, true);
                    return true;
                }
            }
            return z5;
        }

        private void animateOffsetTo(CoordinatorLayout coordinatorLayout, @NonNull T t5, int i6, float f6) {
            int height;
            int abs = Math.abs(getTopBottomOffsetForScrollingSibling() - i6);
            float abs2 = Math.abs(f6);
            if (abs2 > 0.0f) {
                height = Math.round((abs / abs2) * 1000.0f) * 3;
            } else {
                height = (int) (((abs / t5.getHeight()) + 1.0f) * 150.0f);
            }
            animateOffsetWithDuration(coordinatorLayout, t5, i6, height);
        }

        private void animateOffsetWithDuration(final CoordinatorLayout coordinatorLayout, final T t5, int i6, int i7) {
            int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
            if (topBottomOffsetForScrollingSibling == i6) {
                ValueAnimator valueAnimator = this.offsetAnimator;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.offsetAnimator.cancel();
                    return;
                }
                return;
            }
            ValueAnimator valueAnimator2 = this.offsetAnimator;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.offsetAnimator = valueAnimator3;
                valueAnimator3.setInterpolator(AnimationUtils.DECELERATE_INTERPOLATOR);
                this.offsetAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.appbar.AppBarLayout.BaseBehavior.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator4) {
                        BaseBehavior.this.setHeaderTopBottomOffset(coordinatorLayout, t5, ((Integer) valueAnimator4.getAnimatedValue()).intValue());
                    }
                });
            } else {
                valueAnimator2.cancel();
            }
            this.offsetAnimator.setDuration(Math.min(i7, 600));
            this.offsetAnimator.setIntValues(topBottomOffsetForScrollingSibling, i6);
            this.offsetAnimator.start();
        }

        private boolean canScrollChildren(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t5, @NonNull View view) {
            if (t5.hasScrollableChildren() && coordinatorLayout.getHeight() - view.getHeight() <= t5.getHeight()) {
                return true;
            }
            return false;
        }

        private boolean childrenHaveScrollFlags(AppBarLayout appBarLayout) {
            int childCount = appBarLayout.getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                if (((LayoutParams) appBarLayout.getChildAt(i6).getLayoutParams()).scrollFlags != 0) {
                    return true;
                }
            }
            return false;
        }

        @Nullable
        private View findFirstScrollingChild(@NonNull CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = coordinatorLayout.getChildAt(i6);
                if ((childAt instanceof NestedScrollingChild) || (childAt instanceof AbsListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        @Nullable
        private static View getAppBarChildOnOffset(@NonNull AppBarLayout appBarLayout, int i6) {
            int abs = Math.abs(i6);
            int childCount = appBarLayout.getChildCount();
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = appBarLayout.getChildAt(i7);
                if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        private int getChildIndexOnOffset(@NonNull T t5, int i6) {
            int childCount = t5.getChildCount();
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = t5.getChildAt(i7);
                int top2 = childAt.getTop();
                int bottom = childAt.getBottom();
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (checkFlag(layoutParams.getScrollFlags(), 32)) {
                    top2 -= ((LinearLayout.LayoutParams) layoutParams).topMargin;
                    bottom += ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                }
                int i8 = -i6;
                if (top2 <= i8 && bottom >= i8) {
                    return i7;
                }
            }
            return -1;
        }

        @Nullable
        private View getChildWithScrollingBehavior(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = coordinatorLayout.getChildAt(i6);
                if (((CoordinatorLayout.LayoutParams) childAt.getLayoutParams()).getBehavior() instanceof ScrollingViewBehavior) {
                    return childAt;
                }
            }
            return null;
        }

        private int interpolateOffset(@NonNull T t5, int i6) {
            int abs = Math.abs(i6);
            int childCount = t5.getChildCount();
            int i7 = 0;
            int i8 = 0;
            while (true) {
                if (i8 >= childCount) {
                    break;
                }
                View childAt = t5.getChildAt(i8);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                Interpolator scrollInterpolator = layoutParams.getScrollInterpolator();
                if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                    if (scrollInterpolator != null) {
                        int scrollFlags = layoutParams.getScrollFlags();
                        if ((scrollFlags & 1) != 0) {
                            i7 = childAt.getHeight() + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                            if ((scrollFlags & 2) != 0) {
                                i7 -= ViewCompat.getMinimumHeight(childAt);
                            }
                        }
                        if (ViewCompat.getFitsSystemWindows(childAt)) {
                            i7 -= t5.getTopInset();
                        }
                        if (i7 > 0) {
                            float f6 = i7;
                            return Integer.signum(i6) * (childAt.getTop() + Math.round(f6 * scrollInterpolator.getInterpolation((abs - childAt.getTop()) / f6)));
                        }
                    }
                } else {
                    i8++;
                }
            }
            return i6;
        }

        private boolean shouldJumpElevationState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t5) {
            List<View> dependents = coordinatorLayout.getDependents(t5);
            int size = dependents.size();
            for (int i6 = 0; i6 < size; i6++) {
                CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) dependents.get(i6).getLayoutParams()).getBehavior();
                if (behavior instanceof ScrollingViewBehavior) {
                    if (((ScrollingViewBehavior) behavior).getOverlayTop() == 0) {
                        return false;
                    }
                    return true;
                }
            }
            return false;
        }

        private void snapToChildIfNeeded(CoordinatorLayout coordinatorLayout, @NonNull T t5) {
            int topInset = t5.getTopInset() + t5.getPaddingTop();
            int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling() - topInset;
            int childIndexOnOffset = getChildIndexOnOffset(t5, topBottomOffsetForScrollingSibling);
            if (childIndexOnOffset >= 0) {
                View childAt = t5.getChildAt(childIndexOnOffset);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int scrollFlags = layoutParams.getScrollFlags();
                if ((scrollFlags & 17) == 17) {
                    int i6 = -childAt.getTop();
                    int i7 = -childAt.getBottom();
                    if (childIndexOnOffset == 0 && ViewCompat.getFitsSystemWindows(t5) && ViewCompat.getFitsSystemWindows(childAt)) {
                        i6 -= t5.getTopInset();
                    }
                    if (checkFlag(scrollFlags, 2)) {
                        i7 += ViewCompat.getMinimumHeight(childAt);
                    } else if (checkFlag(scrollFlags, 5)) {
                        int minimumHeight = ViewCompat.getMinimumHeight(childAt) + i7;
                        if (topBottomOffsetForScrollingSibling < minimumHeight) {
                            i6 = minimumHeight;
                        } else {
                            i7 = minimumHeight;
                        }
                    }
                    if (checkFlag(scrollFlags, 32)) {
                        i6 += ((LinearLayout.LayoutParams) layoutParams).topMargin;
                        i7 -= ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                    }
                    animateOffsetTo(coordinatorLayout, t5, MathUtils.clamp(calculateSnapOffset(topBottomOffsetForScrollingSibling, i7, i6) + topInset, -t5.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        private void updateAppBarLayoutDrawableState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t5, int i6, int i7, boolean z5) {
            Drawable foreground;
            Drawable foreground2;
            View appBarChildOnOffset = getAppBarChildOnOffset(t5, i6);
            boolean z6 = false;
            if (appBarChildOnOffset != null) {
                int scrollFlags = ((LayoutParams) appBarChildOnOffset.getLayoutParams()).getScrollFlags();
                if ((scrollFlags & 1) != 0) {
                    int minimumHeight = ViewCompat.getMinimumHeight(appBarChildOnOffset);
                    if (i7 <= 0 || (scrollFlags & 12) == 0 ? !((scrollFlags & 2) == 0 || (-i6) < (appBarChildOnOffset.getBottom() - minimumHeight) - t5.getTopInset()) : (-i6) >= (appBarChildOnOffset.getBottom() - minimumHeight) - t5.getTopInset()) {
                        z6 = true;
                    }
                }
            }
            if (t5.isLiftOnScroll()) {
                z6 = t5.shouldLift(findFirstScrollingChild(coordinatorLayout));
            }
            boolean liftedState = t5.setLiftedState(z6);
            if (z5 || (liftedState && shouldJumpElevationState(coordinatorLayout, t5))) {
                if (t5.getBackground() != null) {
                    t5.getBackground().jumpToCurrentState();
                }
                if (Build.VERSION.SDK_INT >= 23) {
                    foreground = t5.getForeground();
                    if (foreground != null) {
                        foreground2 = t5.getForeground();
                        foreground2.jumpToCurrentState();
                    }
                }
                if (t5.getStateListAnimator() != null) {
                    t5.getStateListAnimator().jumpToCurrentState();
                }
            }
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        int getTopBottomOffsetForScrollingSibling() {
            return getTopAndBottomOffset() + this.offsetDelta;
        }

        @Nullable
        SavedState saveScrollState(@Nullable Parcelable parcelable, @NonNull T t5) {
            boolean z5;
            boolean z6;
            int topAndBottomOffset = getTopAndBottomOffset();
            int childCount = t5.getChildCount();
            boolean z7 = false;
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = t5.getChildAt(i6);
                int bottom = childAt.getBottom() + topAndBottomOffset;
                if (childAt.getTop() + topAndBottomOffset <= 0 && bottom >= 0) {
                    if (parcelable == null) {
                        parcelable = AbsSavedState.EMPTY_STATE;
                    }
                    SavedState savedState = new SavedState(parcelable);
                    if (topAndBottomOffset == 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    savedState.fullyExpanded = z5;
                    if (!z5 && (-topAndBottomOffset) >= t5.getTotalScrollRange()) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    savedState.fullyScrolled = z6;
                    savedState.firstVisibleChildIndex = i6;
                    if (bottom == ViewCompat.getMinimumHeight(childAt) + t5.getTopInset()) {
                        z7 = true;
                    }
                    savedState.firstVisibleChildAtMinimumHeight = z7;
                    savedState.firstVisibleChildPercentageShown = bottom / childAt.getHeight();
                    return savedState;
                }
            }
            return null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface BaseOnOffsetChangedListener<T extends AppBarLayout> {
        void onOffsetChanged(T t5, int i6);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Behavior extends BaseBehavior<AppBarLayout> {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static abstract class DragCallback extends BaseBehavior.BaseDragCallback<AppBarLayout> {
        }

        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int getLeftAndRightOffset() {
            return super.getLeftAndRightOffset();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int getTopAndBottomOffset() {
            return super.getTopAndBottomOffset();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean isHorizontalOffsetEnabled() {
            return super.isHorizontalOffsetEnabled();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean isVerticalOffsetEnabled() {
            return super.isVerticalOffsetEnabled();
        }

        @Override // com.google.android.material.appbar.HeaderBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
            return super.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, int i6) {
            return super.onLayoutChild(coordinatorLayout, (CoordinatorLayout) appBarLayout, i6);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, int i6, int i7, int i8, int i9) {
            return super.onMeasureChild(coordinatorLayout, (CoordinatorLayout) appBarLayout, i6, i7, i8, i9);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, View view, int i6, int i7, int[] iArr, int i8) {
            super.onNestedPreScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i6, i7, iArr, i8);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void onNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, View view, int i6, int i7, int i8, int i9, int i10, int[] iArr) {
            super.onNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i6, i7, i8, i9, i10, iArr);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void onRestoreInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, Parcelable parcelable) {
            super.onRestoreInstanceState(coordinatorLayout, (CoordinatorLayout) appBarLayout, parcelable);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ Parcelable onSaveInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout) {
            return super.onSaveInstanceState(coordinatorLayout, (CoordinatorLayout) appBarLayout);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, View view2, int i6, int i7) {
            return super.onStartNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, view2, i6, i7);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void onStopNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, View view, int i6) {
            super.onStopNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i6);
        }

        @Override // com.google.android.material.appbar.HeaderBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
            return super.onTouchEvent(coordinatorLayout, view, motionEvent);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void setDragCallback(@Nullable BaseBehavior.BaseDragCallback baseDragCallback) {
            super.setDragCallback(baseDragCallback);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void setHorizontalOffsetEnabled(boolean z5) {
            super.setHorizontalOffsetEnabled(z5);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setLeftAndRightOffset(int i6) {
            return super.setLeftAndRightOffset(i6);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int i6) {
            return super.setTopAndBottomOffset(i6);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void setVerticalOffsetEnabled(boolean z5) {
            super.setVerticalOffsetEnabled(z5);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class ChildScrollEffect {
        public abstract void onOffsetChanged(@NonNull AppBarLayout appBarLayout, @NonNull View view, float f6);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class CompressChildScrollEffect extends ChildScrollEffect {
        private static final float COMPRESS_DISTANCE_FACTOR = 0.3f;
        private final Rect relativeRect = new Rect();
        private final Rect ghostRect = new Rect();

        @Override // com.google.android.material.appbar.AppBarLayout.ChildScrollEffect
        public void onOffsetChanged(@NonNull AppBarLayout appBarLayout, @NonNull View view, float f6) {
            updateRelativeRect(this.relativeRect, appBarLayout, view);
            float abs = this.relativeRect.top - Math.abs(f6);
            if (abs > 0.0f) {
                ViewCompat.setClipBounds(view, null);
                view.setTranslationY(0.0f);
                return;
            }
            float clamp = 1.0f - MathUtils.clamp(Math.abs(abs / this.relativeRect.height()), 0.0f, 1.0f);
            float height = (-abs) - ((this.relativeRect.height() * COMPRESS_DISTANCE_FACTOR) * (1.0f - (clamp * clamp)));
            view.setTranslationY(height);
            view.getDrawingRect(this.ghostRect);
            this.ghostRect.offset(0, (int) (-height));
            ViewCompat.setClipBounds(view, this.ghostRect);
        }

        private static void updateRelativeRect(Rect rect, AppBarLayout appBarLayout, View view) {
            view.getDrawingRect(rect);
            appBarLayout.offsetDescendantRectToMyCoords(view, rect);
            rect.offset(0, -appBarLayout.getTopInset());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class LayoutParams extends LinearLayout.LayoutParams {
        static final int COLLAPSIBLE_FLAGS = 10;
        static final int FLAG_QUICK_RETURN = 5;
        static final int FLAG_SNAP = 17;
        public static final int SCROLL_EFFECT_COMPRESS = 1;
        public static final int SCROLL_EFFECT_NONE = 0;
        public static final int SCROLL_FLAG_ENTER_ALWAYS = 4;
        public static final int SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED = 8;
        public static final int SCROLL_FLAG_EXIT_UNTIL_COLLAPSED = 2;
        public static final int SCROLL_FLAG_NO_SCROLL = 0;
        public static final int SCROLL_FLAG_SCROLL = 1;
        public static final int SCROLL_FLAG_SNAP = 16;
        public static final int SCROLL_FLAG_SNAP_MARGINS = 32;
        private ChildScrollEffect scrollEffect;
        int scrollFlags;
        Interpolator scrollInterpolator;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public @interface ScrollEffect {
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public @interface ScrollFlags {
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.scrollFlags = 1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AppBarLayout_Layout);
            this.scrollFlags = obtainStyledAttributes.getInt(R.styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
            setScrollEffect(obtainStyledAttributes.getInt(R.styleable.AppBarLayout_Layout_layout_scrollEffect, 0));
            int i6 = R.styleable.AppBarLayout_Layout_layout_scrollInterpolator;
            if (obtainStyledAttributes.hasValue(i6)) {
                this.scrollInterpolator = android.view.animation.AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(i6, 0));
            }
            obtainStyledAttributes.recycle();
        }

        @Nullable
        private ChildScrollEffect createScrollEffectFromInt(int i6) {
            if (i6 != 1) {
                return null;
            }
            return new CompressChildScrollEffect();
        }

        public void setScrollEffect(@Nullable ChildScrollEffect childScrollEffect) {
            this.scrollEffect = childScrollEffect;
        }

        @Nullable
        public ChildScrollEffect getScrollEffect() {
            return this.scrollEffect;
        }

        public int getScrollFlags() {
            return this.scrollFlags;
        }

        public Interpolator getScrollInterpolator() {
            return this.scrollInterpolator;
        }

        boolean isCollapsible() {
            int i6 = this.scrollFlags;
            return (i6 & 1) == 1 && (i6 & 10) != 0;
        }

        public void setScrollEffect(int i6) {
            this.scrollEffect = createScrollEffectFromInt(i6);
        }

        public void setScrollFlags(int i6) {
            this.scrollFlags = i6;
        }

        public void setScrollInterpolator(Interpolator interpolator) {
            this.scrollInterpolator = interpolator;
        }

        public LayoutParams(int i6, int i7) {
            super(i6, i7);
            this.scrollFlags = 1;
        }

        public LayoutParams(int i6, int i7, float f6) {
            super(i6, i7, f6);
            this.scrollFlags = 1;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.scrollFlags = 1;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.scrollFlags = 1;
        }

        @RequiresApi(19)
        public LayoutParams(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.scrollFlags = 1;
        }

        @RequiresApi(19)
        public LayoutParams(@NonNull LayoutParams layoutParams) {
            super((LinearLayout.LayoutParams) layoutParams);
            this.scrollFlags = 1;
            this.scrollFlags = layoutParams.scrollFlags;
            this.scrollEffect = layoutParams.scrollEffect;
            this.scrollInterpolator = layoutParams.scrollInterpolator;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface LiftOnScrollListener {
        void onUpdate(@Dimension float f6, @ColorInt int i6);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface OnOffsetChangedListener extends BaseOnOffsetChangedListener<AppBarLayout> {
        @Override // com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        void onOffsetChanged(AppBarLayout appBarLayout, int i6);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
        public ScrollingViewBehavior() {
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        @Nullable
        /* bridge */ /* synthetic */ View findFirstDependency(@NonNull List list) {
            return findFirstDependency((List<View>) list);
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ScrollingViewBehavior_Layout);
            setOverlayTop(obtainStyledAttributes.getDimensionPixelSize(R.styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            obtainStyledAttributes.recycle();
        }

        private void updateLiftedStateIfNeeded(View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.isLiftOnScroll()) {
                    appBarLayout.setLiftedState(appBarLayout.shouldLift(view));
                }
            }
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        @Nullable
        AppBarLayout findFirstDependency(@NonNull List<View> list) {
            int size = list.size();
            for (int i6 = 0; i6 < size; i6++) {
                View view = list.get(i6);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        float getOverlapRatioForOffset(View view) {
            int i6;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                int appBarLayoutOffset = getAppBarLayoutOffset(appBarLayout);
                if ((downNestedPreScrollRange == 0 || totalScrollRange + appBarLayoutOffset > downNestedPreScrollRange) && (i6 = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (appBarLayoutOffset / i6) + 1.0f;
                }
            }
            return 0.0f;
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        int getScrollRange(View view) {
            return view instanceof AppBarLayout ? ((AppBarLayout) view).getTotalScrollRange() : super.getScrollRange(view);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onDependentViewRemoved(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
            if (view2 instanceof AppBarLayout) {
                ViewCompat.removeAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId());
                ViewCompat.removeAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId());
                ViewCompat.setAccessibilityDelegate(coordinatorLayout, null);
            }
        }

        private static int getAppBarLayoutOffset(@NonNull AppBarLayout appBarLayout) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams()).getBehavior();
            if (behavior instanceof BaseBehavior) {
                return ((BaseBehavior) behavior).getTopBottomOffsetForScrollingSibling();
            }
            return 0;
        }

        private void offsetChildAsNeeded(@NonNull View view, @NonNull View view2) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) view2.getLayoutParams()).getBehavior();
            if (behavior instanceof BaseBehavior) {
                ViewCompat.offsetTopAndBottom(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) behavior).offsetDelta) + getVerticalLayoutGap()) - getOverlapPixelsForOffset(view2));
            }
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int getLeftAndRightOffset() {
            return super.getLeftAndRightOffset();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int getTopAndBottomOffset() {
            return super.getTopAndBottomOffset();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean isHorizontalOffsetEnabled() {
            return super.isHorizontalOffsetEnabled();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean isVerticalOffsetEnabled() {
            return super.isVerticalOffsetEnabled();
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onDependentViewChanged(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
            offsetChildAsNeeded(view, view2);
            updateLiftedStateIfNeeded(view, view2);
            return false;
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i6) {
            return super.onLayoutChild(coordinatorLayout, view, i6);
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i6, int i7, int i8, int i9) {
            return super.onMeasureChild(coordinatorLayout, view, i6, i7, i8, i9);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onRequestChildRectangleOnScreen(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull Rect rect, boolean z5) {
            AppBarLayout findFirstDependency = findFirstDependency(coordinatorLayout.getDependencies(view));
            if (findFirstDependency != null) {
                Rect rect2 = new Rect(rect);
                rect2.offset(view.getLeft(), view.getTop());
                Rect rect3 = this.tempRect1;
                rect3.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect3.contains(rect2)) {
                    findFirstDependency.setExpanded(false, !z5);
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void setHorizontalOffsetEnabled(boolean z5) {
            super.setHorizontalOffsetEnabled(z5);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setLeftAndRightOffset(int i6) {
            return super.setLeftAndRightOffset(i6);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int i6) {
            return super.setTopAndBottomOffset(i6);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void setVerticalOffsetEnabled(boolean z5) {
            super.setVerticalOffsetEnabled(z5);
        }
    }

    public AppBarLayout(@NonNull Context context) {
        this(context, null);
    }

    public void addOnOffsetChangedListener(@Nullable BaseOnOffsetChangedListener baseOnOffsetChangedListener) {
        if (this.listeners == null) {
            this.listeners = new ArrayList();
        }
        if (baseOnOffsetChangedListener == null || this.listeners.contains(baseOnOffsetChangedListener)) {
            return;
        }
        this.listeners.add(baseOnOffsetChangedListener);
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    public void removeOnOffsetChangedListener(@Nullable BaseOnOffsetChangedListener baseOnOffsetChangedListener) {
        List<BaseOnOffsetChangedListener> list = this.listeners;
        if (list == null || baseOnOffsetChangedListener == null) {
            return;
        }
        list.remove(baseOnOffsetChangedListener);
    }

    void resetPendingAction() {
        this.pendingAction = 0;
    }

    public void setExpanded(boolean z5) {
        setExpanded(z5, ViewCompat.isLaidOut(this));
    }

    public void setLiftOnScrollTargetView(@Nullable View view) {
        this.liftOnScrollTargetViewId = -1;
        if (view == null) {
            clearLiftOnScrollTargetView();
        } else {
            this.liftOnScrollTargetView = new WeakReference<>(view);
        }
    }

    public boolean setLiftable(boolean z5) {
        this.liftableOverride = true;
        return setLiftableState(z5);
    }

    public boolean setLifted(boolean z5) {
        return setLiftedState(z5, true);
    }

    boolean setLiftedState(boolean z5) {
        return setLiftedState(z5, !this.liftableOverride);
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i6) {
        if (i6 != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i6);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(29)
    private static class DrawableHelperV29 {
        private DrawableHelperV29() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        @DoNotInline
        public static ColorStateList maybeGetBackgroundCSL(@Nullable Drawable drawable) {
            ColorStateList colorStateList;
            if (e.a(drawable)) {
                colorStateList = f.a(drawable).getColorStateList();
                return colorStateList;
            }
            return null;
        }
    }

    public AppBarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.appBarLayoutStyle);
    }

    private void clearLiftOnScrollTargetView() {
        WeakReference<View> weakReference = this.liftOnScrollTargetView;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.liftOnScrollTargetView = null;
    }

    @Nullable
    private View findLiftOnScrollTargetView(@Nullable View view) {
        int i6;
        if (this.liftOnScrollTargetView == null && (i6 = this.liftOnScrollTargetViewId) != -1) {
            View findViewById = view != null ? view.findViewById(i6) : null;
            if (findViewById == null && (getParent() instanceof ViewGroup)) {
                findViewById = ((ViewGroup) getParent()).findViewById(this.liftOnScrollTargetViewId);
            }
            if (findViewById != null) {
                this.liftOnScrollTargetView = new WeakReference<>(findViewById);
            }
        }
        WeakReference<View> weakReference = this.liftOnScrollTargetView;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private void initializeLiftOnScrollWithColor(final MaterialShapeDrawable materialShapeDrawable) {
        materialShapeDrawable.setAlpha(this.lifted ? 255 : 0);
        materialShapeDrawable.setFillColor(this.liftOnScrollColor);
        this.liftOnScrollColorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.appbar.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppBarLayout.b(AppBarLayout.this, materialShapeDrawable, valueAnimator);
            }
        };
    }

    private void invalidateScrollRanges() {
        Behavior behavior = this.behavior;
        BaseBehavior.SavedState saveScrollState = (behavior == null || this.totalScrollRange == -1 || this.pendingAction != 0) ? null : behavior.saveScrollState(AbsSavedState.EMPTY_STATE, this);
        this.totalScrollRange = -1;
        this.downPreScrollRange = -1;
        this.downScrollRange = -1;
        if (saveScrollState != null) {
            this.behavior.restoreScrollState(saveScrollState, false);
        }
    }

    private boolean setLiftableState(boolean z5) {
        if (this.liftable == z5) {
            return false;
        }
        this.liftable = z5;
        refreshDrawableState();
        return true;
    }

    private boolean shouldDrawStatusBarForeground() {
        return this.statusBarForeground != null && getTopInset() > 0;
    }

    private void startLiftOnScrollColorAnimation(float f6, float f7) {
        ValueAnimator valueAnimator = this.liftOnScrollColorAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f6, f7);
        this.liftOnScrollColorAnimator = ofFloat;
        ofFloat.setDuration(this.liftOnScrollColorDuration);
        this.liftOnScrollColorAnimator.setInterpolator(this.liftOnScrollColorInterpolator);
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.liftOnScrollColorUpdateListener;
        if (animatorUpdateListener != null) {
            this.liftOnScrollColorAnimator.addUpdateListener(animatorUpdateListener);
        }
        this.liftOnScrollColorAnimator.start();
    }

    public void addLiftOnScrollListener(@NonNull LiftOnScrollListener liftOnScrollListener) {
        this.liftOnScrollListeners.add(liftOnScrollListener);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void clearLiftOnScrollListener() {
        this.liftOnScrollListeners.clear();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public CoordinatorLayout.Behavior<AppBarLayout> getBehavior() {
        Behavior behavior = new Behavior();
        this.behavior = behavior;
        return behavior;
    }

    int getDownNestedPreScrollRange() {
        int i6;
        int minimumHeight;
        int i7 = this.downPreScrollRange;
        if (i7 != -1) {
            return i7;
        }
        int i8 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i9 = layoutParams.scrollFlags;
                if ((i9 & 5) != 5) {
                    if (i8 > 0) {
                        break;
                    }
                } else {
                    int i10 = ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                    if ((i9 & 8) != 0) {
                        minimumHeight = ViewCompat.getMinimumHeight(childAt);
                    } else if ((i9 & 2) != 0) {
                        minimumHeight = measuredHeight - ViewCompat.getMinimumHeight(childAt);
                    } else {
                        i6 = i10 + measuredHeight;
                        if (childCount == 0 && ViewCompat.getFitsSystemWindows(childAt)) {
                            i6 = Math.min(i6, measuredHeight - getTopInset());
                        }
                        i8 += i6;
                    }
                    i6 = i10 + minimumHeight;
                    if (childCount == 0) {
                        i6 = Math.min(i6, measuredHeight - getTopInset());
                    }
                    i8 += i6;
                }
            }
        }
        int max = Math.max(0, i8);
        this.downPreScrollRange = max;
        return max;
    }

    int getDownNestedScrollRange() {
        int i6 = this.downScrollRange;
        if (i6 != -1) {
            return i6;
        }
        int childCount = getChildCount();
        int i7 = 0;
        int i8 = 0;
        while (true) {
            if (i7 >= childCount) {
                break;
            }
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight() + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                int i9 = layoutParams.scrollFlags;
                if ((i9 & 1) == 0) {
                    break;
                }
                i8 += measuredHeight;
                if ((i9 & 2) != 0) {
                    i8 -= ViewCompat.getMinimumHeight(childAt);
                    break;
                }
            }
            i7++;
        }
        int max = Math.max(0, i8);
        this.downScrollRange = max;
        return max;
    }

    @IdRes
    public int getLiftOnScrollTargetViewId() {
        return this.liftOnScrollTargetViewId;
    }

    int getPendingAction() {
        return this.pendingAction;
    }

    @Nullable
    public Drawable getStatusBarForeground() {
        return this.statusBarForeground;
    }

    @VisibleForTesting
    final int getTopInset() {
        WindowInsetsCompat windowInsetsCompat = this.lastInsets;
        if (windowInsetsCompat != null) {
            return windowInsetsCompat.getSystemWindowInsetTop();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i6 = this.totalScrollRange;
        if (i6 != -1) {
            return i6;
        }
        int childCount = getChildCount();
        int i7 = 0;
        int i8 = 0;
        while (true) {
            if (i7 >= childCount) {
                break;
            }
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i9 = layoutParams.scrollFlags;
                if ((i9 & 1) == 0) {
                    break;
                }
                i8 += measuredHeight + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                if (i7 == 0 && ViewCompat.getFitsSystemWindows(childAt)) {
                    i8 -= getTopInset();
                }
                if ((i9 & 2) != 0) {
                    i8 -= ViewCompat.getMinimumHeight(childAt);
                    break;
                }
            }
            i7++;
        }
        int max = Math.max(0, i8);
        this.totalScrollRange = max;
        return max;
    }

    boolean hasChildWithInterpolator() {
        return this.haveChildWithInterpolator;
    }

    public boolean isLiftOnScroll() {
        return this.liftOnScroll;
    }

    public boolean isLifted() {
        return this.lifted;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i6) {
        if (this.tmpStatesArray == null) {
            this.tmpStatesArray = new int[4];
        }
        int[] iArr = this.tmpStatesArray;
        int[] onCreateDrawableState = super.onCreateDrawableState(i6 + iArr.length);
        boolean z5 = this.liftable;
        int i7 = R.attr.state_liftable;
        if (!z5) {
            i7 = -i7;
        }
        iArr[0] = i7;
        iArr[1] = (z5 && this.lifted) ? R.attr.state_lifted : -R.attr.state_lifted;
        int i8 = R.attr.state_collapsible;
        if (!z5) {
            i8 = -i8;
        }
        iArr[2] = i8;
        iArr[3] = (z5 && this.lifted) ? R.attr.state_collapsed : -R.attr.state_collapsed;
        return View.mergeDrawableStates(onCreateDrawableState, iArr);
    }

    void onOffsetChanged(int i6) {
        this.currentOffset = i6;
        if (!willNotDraw()) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
        List<BaseOnOffsetChangedListener> list = this.listeners;
        if (list != null) {
            int size = list.size();
            for (int i7 = 0; i7 < size; i7++) {
                BaseOnOffsetChangedListener baseOnOffsetChangedListener = this.listeners.get(i7);
                if (baseOnOffsetChangedListener != null) {
                    baseOnOffsetChangedListener.onOffsetChanged(this, i6);
                }
            }
        }
    }

    public boolean removeLiftOnScrollListener(@NonNull LiftOnScrollListener liftOnScrollListener) {
        return this.liftOnScrollListeners.remove(liftOnScrollListener);
    }

    public void setExpanded(boolean z5, boolean z6) {
        setExpanded(z5, z6, true);
    }

    public void setLiftOnScroll(boolean z5) {
        this.liftOnScroll = z5;
    }

    public void setLiftOnScrollTargetViewId(@IdRes int i6) {
        this.liftOnScrollTargetViewId = i6;
        clearLiftOnScrollTargetView();
    }

    public void setLiftableOverrideEnabled(boolean z5) {
        this.liftableOverride = z5;
    }

    boolean setLiftedState(boolean z5, boolean z6) {
        if (!z6 || this.lifted == z5) {
            return false;
        }
        this.lifted = z5;
        refreshDrawableState();
        if (!this.liftOnScroll || !(getBackground() instanceof MaterialShapeDrawable)) {
            return true;
        }
        if (this.liftOnScrollColor != null) {
            startLiftOnScrollColorAnimation(z5 ? 0.0f : 255.0f, z5 ? 255.0f : 0.0f);
            return true;
        }
        startLiftOnScrollColorAnimation(z5 ? 0.0f : this.appBarElevation, z5 ? this.appBarElevation : 0.0f);
        return true;
    }

    public void setStatusBarForeground(@Nullable Drawable drawable) {
        Drawable drawable2 = this.statusBarForeground;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable mutate = drawable != null ? drawable.mutate() : null;
            this.statusBarForeground = mutate;
            if (mutate != null) {
                if (mutate.isStateful()) {
                    this.statusBarForeground.setState(getDrawableState());
                }
                DrawableCompat.setLayoutDirection(this.statusBarForeground, ViewCompat.getLayoutDirection(this));
                this.statusBarForeground.setVisible(getVisibility() == 0, false);
                this.statusBarForeground.setCallback(this);
            }
            updateWillNotDraw();
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setStatusBarForegroundColor(@ColorInt int i6) {
        setStatusBarForeground(new ColorDrawable(i6));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public AppBarLayout(@androidx.annotation.NonNull android.content.Context r9, @androidx.annotation.Nullable android.util.AttributeSet r10, int r11) {
        /*
            r8 = this;
            int r4 = com.google.android.material.appbar.AppBarLayout.DEF_STYLE_RES
            android.content.Context r9 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r9, r10, r11, r4)
            r8.<init>(r9, r10, r11)
            r9 = -1
            r8.totalScrollRange = r9
            r8.downPreScrollRange = r9
            r8.downScrollRange = r9
            r6 = 0
            r8.pendingAction = r6
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r8.liftOnScrollListeners = r0
            android.content.Context r0 = r8.getContext()
            r1 = 1
            r8.setOrientation(r1)
            int r7 = android.os.Build.VERSION.SDK_INT
            android.view.ViewOutlineProvider r1 = r8.getOutlineProvider()
            android.view.ViewOutlineProvider r2 = android.view.ViewOutlineProvider.BACKGROUND
            if (r1 != r2) goto L2f
            com.google.android.material.appbar.ViewUtilsLollipop.setBoundsViewOutlineProvider(r8)
        L2f:
            com.google.android.material.appbar.ViewUtilsLollipop.setStateListAnimatorFromAttrs(r8, r10, r11, r4)
            int[] r2 = com.google.android.material.R.styleable.AppBarLayout
            int[] r5 = new int[r6]
            r1 = r10
            r3 = r11
            android.content.res.TypedArray r10 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r0, r1, r2, r3, r4, r5)
            int r11 = com.google.android.material.R.styleable.AppBarLayout_android_background
            android.graphics.drawable.Drawable r11 = r10.getDrawable(r11)
            androidx.core.view.ViewCompat.setBackground(r8, r11)
            int r11 = com.google.android.material.R.styleable.AppBarLayout_liftOnScrollColor
            android.content.res.ColorStateList r11 = com.google.android.material.resources.MaterialResources.getColorStateList(r0, r10, r11)
            r8.liftOnScrollColor = r11
            android.content.res.ColorStateList r1 = r8.getBackgroundCSL()
            if (r1 == 0) goto L67
            com.google.android.material.shape.MaterialShapeDrawable r2 = new com.google.android.material.shape.MaterialShapeDrawable
            r2.<init>()
            r2.setFillColor(r1)
            if (r11 == 0) goto L61
            r8.initializeLiftOnScrollWithColor(r2)
            goto L64
        L61:
            r8.initializeLiftOnScrollWithElevation(r0, r2)
        L64:
            androidx.core.view.ViewCompat.setBackground(r8, r2)
        L67:
            int r11 = com.google.android.material.R.attr.motionDurationMedium2
            android.content.res.Resources r1 = r8.getResources()
            int r2 = com.google.android.material.R.integer.app_bar_elevation_anim_duration
            int r1 = r1.getInteger(r2)
            int r11 = com.google.android.material.motion.MotionUtils.resolveThemeDuration(r0, r11, r1)
            long r1 = (long) r11
            r8.liftOnScrollColorDuration = r1
            int r11 = com.google.android.material.R.attr.motionEasingStandardInterpolator
            android.animation.TimeInterpolator r1 = com.google.android.material.animation.AnimationUtils.LINEAR_INTERPOLATOR
            android.animation.TimeInterpolator r11 = com.google.android.material.motion.MotionUtils.resolveThemeInterpolator(r0, r11, r1)
            r8.liftOnScrollColorInterpolator = r11
            int r11 = com.google.android.material.R.styleable.AppBarLayout_expanded
            boolean r0 = r10.hasValue(r11)
            if (r0 == 0) goto L93
            boolean r11 = r10.getBoolean(r11, r6)
            r8.setExpanded(r11, r6, r6)
        L93:
            int r11 = com.google.android.material.R.styleable.AppBarLayout_elevation
            boolean r0 = r10.hasValue(r11)
            if (r0 == 0) goto La3
            int r11 = r10.getDimensionPixelSize(r11, r6)
            float r11 = (float) r11
            com.google.android.material.appbar.ViewUtilsLollipop.setDefaultAppBarLayoutStateListAnimator(r8, r11)
        La3:
            r11 = 26
            if (r7 < r11) goto Lc5
            int r11 = com.google.android.material.R.styleable.AppBarLayout_android_keyboardNavigationCluster
            boolean r0 = r10.hasValue(r11)
            if (r0 == 0) goto Lb6
            boolean r11 = r10.getBoolean(r11, r6)
            com.google.android.material.appbar.a.a(r8, r11)
        Lb6:
            int r11 = com.google.android.material.R.styleable.AppBarLayout_android_touchscreenBlocksFocus
            boolean r0 = r10.hasValue(r11)
            if (r0 == 0) goto Lc5
            boolean r11 = r10.getBoolean(r11, r6)
            r8.setTouchscreenBlocksFocus(r11)
        Lc5:
            android.content.res.Resources r11 = r8.getResources()
            int r0 = com.google.android.material.R.dimen.design_appbar_elevation
            float r11 = r11.getDimension(r0)
            r8.appBarElevation = r11
            int r11 = com.google.android.material.R.styleable.AppBarLayout_liftOnScroll
            boolean r11 = r10.getBoolean(r11, r6)
            r8.liftOnScroll = r11
            int r11 = com.google.android.material.R.styleable.AppBarLayout_liftOnScrollTargetViewId
            int r9 = r10.getResourceId(r11, r9)
            r8.liftOnScrollTargetViewId = r9
            int r9 = com.google.android.material.R.styleable.AppBarLayout_statusBarForeground
            android.graphics.drawable.Drawable r9 = r10.getDrawable(r9)
            r8.setStatusBarForeground(r9)
            r10.recycle()
            com.google.android.material.appbar.AppBarLayout$1 r9 = new com.google.android.material.appbar.AppBarLayout$1
            r9.<init>()
            androidx.core.view.ViewCompat.setOnApplyWindowInsetsListener(r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public static /* synthetic */ void a(AppBarLayout appBarLayout, MaterialShapeDrawable materialShapeDrawable, ValueAnimator valueAnimator) {
        appBarLayout.getClass();
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        materialShapeDrawable.setElevation(floatValue);
        Drawable drawable = appBarLayout.statusBarForeground;
        if (drawable instanceof MaterialShapeDrawable) {
            ((MaterialShapeDrawable) drawable).setElevation(floatValue);
        }
        Iterator<LiftOnScrollListener> it = appBarLayout.liftOnScrollListeners.iterator();
        while (it.hasNext()) {
            it.next().onUpdate(floatValue, materialShapeDrawable.getResolvedTintColor());
        }
    }

    public static /* synthetic */ void b(AppBarLayout appBarLayout, MaterialShapeDrawable materialShapeDrawable, ValueAnimator valueAnimator) {
        appBarLayout.getClass();
        int floatValue = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
        materialShapeDrawable.setAlpha(floatValue);
        for (LiftOnScrollListener liftOnScrollListener : appBarLayout.liftOnScrollListeners) {
            if (materialShapeDrawable.getFillColor() != null) {
                liftOnScrollListener.onUpdate(0.0f, materialShapeDrawable.getFillColor().withAlpha(floatValue).getDefaultColor());
            }
        }
    }

    @Nullable
    private ColorStateList getBackgroundCSL() {
        Drawable background = getBackground();
        if (background instanceof ColorDrawable) {
            return ColorStateList.valueOf(((ColorDrawable) background).getColor());
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return DrawableHelperV29.maybeGetBackgroundCSL(background);
        }
        return null;
    }

    private boolean hasCollapsibleChild() {
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            if (((LayoutParams) getChildAt(i6).getLayoutParams()).isCollapsible()) {
                return true;
            }
        }
        return false;
    }

    private void initializeLiftOnScrollWithElevation(Context context, final MaterialShapeDrawable materialShapeDrawable) {
        materialShapeDrawable.initializeElevationOverlay(context);
        this.liftOnScrollColorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.appbar.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppBarLayout.a(AppBarLayout.this, materialShapeDrawable, valueAnimator);
            }
        };
    }

    private void setExpanded(boolean z5, boolean z6, boolean z7) {
        this.pendingAction = (z5 ? 1 : 2) | (z6 ? 4 : 0) | (z7 ? 8 : 0);
        requestLayout();
    }

    private boolean shouldOffsetFirstChild() {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (childAt.getVisibility() != 8 && !ViewCompat.getFitsSystemWindows(childAt)) {
                return true;
            }
        }
        return false;
    }

    private void updateWillNotDraw() {
        setWillNotDraw(!shouldDrawStatusBarForeground());
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        if (shouldDrawStatusBarForeground()) {
            int save = canvas.save();
            canvas.translate(0.0f, -this.currentOffset);
            this.statusBarForeground.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.statusBarForeground;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int minimumHeight = ViewCompat.getMinimumHeight(this);
        if (minimumHeight == 0) {
            int childCount = getChildCount();
            if (childCount >= 1) {
                minimumHeight = ViewCompat.getMinimumHeight(getChildAt(childCount - 1));
            } else {
                minimumHeight = 0;
            }
            if (minimumHeight == 0) {
                return getHeight() / 3;
            }
        }
        return (minimumHeight * 2) + topInset;
    }

    int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    boolean hasScrollableChildren() {
        if (getTotalScrollRange() != 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        clearLiftOnScrollTargetView();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        super.onLayout(z5, i6, i7, i8, i9);
        boolean z6 = true;
        if (ViewCompat.getFitsSystemWindows(this) && shouldOffsetFirstChild()) {
            int topInset = getTopInset();
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                ViewCompat.offsetTopAndBottom(getChildAt(childCount), topInset);
            }
        }
        invalidateScrollRanges();
        this.haveChildWithInterpolator = false;
        int childCount2 = getChildCount();
        int i10 = 0;
        while (true) {
            if (i10 >= childCount2) {
                break;
            }
            if (((LayoutParams) getChildAt(i10).getLayoutParams()).getScrollInterpolator() != null) {
                this.haveChildWithInterpolator = true;
                break;
            }
            i10++;
        }
        Drawable drawable = this.statusBarForeground;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (!this.liftableOverride) {
            if (!this.liftOnScroll && !hasCollapsibleChild()) {
                z6 = false;
            }
            setLiftableState(z6);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i6, int i7) {
        super.onMeasure(i6, i7);
        int mode = View.MeasureSpec.getMode(i7);
        if (mode != 1073741824 && ViewCompat.getFitsSystemWindows(this) && shouldOffsetFirstChild()) {
            int measuredHeight = getMeasuredHeight();
            if (mode != Integer.MIN_VALUE) {
                if (mode == 0) {
                    measuredHeight += getTopInset();
                }
            } else {
                measuredHeight = MathUtils.clamp(getMeasuredHeight() + getTopInset(), 0, View.MeasureSpec.getSize(i7));
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
        invalidateScrollRanges();
    }

    WindowInsetsCompat onWindowInsetChanged(WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2;
        if (ViewCompat.getFitsSystemWindows(this)) {
            windowInsetsCompat2 = windowInsetsCompat;
        } else {
            windowInsetsCompat2 = null;
        }
        if (!ObjectsCompat.equals(this.lastInsets, windowInsetsCompat2)) {
            this.lastInsets = windowInsetsCompat2;
            updateWillNotDraw();
            requestLayout();
        }
        return windowInsetsCompat;
    }

    public void removeOnOffsetChangedListener(OnOffsetChangedListener onOffsetChangedListener) {
        removeOnOffsetChangedListener((BaseOnOffsetChangedListener) onOffsetChangedListener);
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f6) {
        super.setElevation(f6);
        MaterialShapeUtils.setElevation(this, f6);
    }

    public void setStatusBarForegroundResource(@DrawableRes int i6) {
        setStatusBarForeground(AppCompatResources.getDrawable(getContext(), i6));
    }

    @Deprecated
    public void setTargetElevation(float f6) {
        ViewUtilsLollipop.setDefaultAppBarLayoutStateListAnimator(this, f6);
    }

    @Override // android.view.View
    public void setVisibility(int i6) {
        boolean z5;
        super.setVisibility(i6);
        if (i6 == 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        Drawable drawable = this.statusBarForeground;
        if (drawable != null) {
            drawable.setVisible(z5, false);
        }
    }

    boolean shouldLift(@Nullable View view) {
        View findLiftOnScrollTargetView = findLiftOnScrollTargetView(view);
        if (findLiftOnScrollTargetView != null) {
            view = findLiftOnScrollTargetView;
        }
        if (view != null) {
            if (view.canScrollVertically(-1) || view.getScrollY() > 0) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // android.view.View
    protected boolean verifyDrawable(@NonNull Drawable drawable) {
        if (!super.verifyDrawable(drawable) && drawable != this.statusBarForeground) {
            return false;
        }
        return true;
    }

    public void addOnOffsetChangedListener(OnOffsetChangedListener onOffsetChangedListener) {
        addOnOffsetChangedListener((BaseOnOffsetChangedListener) onOffsetChangedListener);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            return new LayoutParams((LinearLayout.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }
}
