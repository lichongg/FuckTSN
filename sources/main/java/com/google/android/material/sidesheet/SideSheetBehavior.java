package com.google.android.material.sidesheet;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.activity.BackEventCompat;
import androidx.annotation.GravityInt;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.motion.MaterialSideContainerBackHelper;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.sidesheet.SideSheetBehavior;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class SideSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> implements Sheet<SideSheetCallback> {
    private static final int DEFAULT_ACCESSIBILITY_PANE_TITLE = R.string.side_sheet_accessibility_pane_title;
    private static final int DEF_STYLE_RES = R.style.Widget_Material3_SideSheet;
    private static final float HIDE_FRICTION = 0.1f;
    private static final float HIDE_THRESHOLD = 0.5f;
    private static final int NO_MAX_SIZE = -1;
    static final int SIGNIFICANT_VEL_THRESHOLD = 500;

    @Nullable
    private ColorStateList backgroundTint;

    @NonNull
    private final Set<SideSheetCallback> callbacks;
    private int childWidth;

    @IdRes
    private int coplanarSiblingViewId;

    @Nullable
    private WeakReference<View> coplanarSiblingViewRef;
    private final ViewDragHelper.Callback dragCallback;
    private boolean draggable;
    private float elevation;
    private float hideFriction;
    private boolean ignoreEvents;
    private int initialX;
    private int innerMargin;
    private int lastStableState;

    @Nullable
    private MaterialShapeDrawable materialShapeDrawable;
    private float maximumVelocity;
    private int parentInnerEdge;
    private int parentWidth;
    private ShapeAppearanceModel shapeAppearanceModel;
    private SheetDelegate sheetDelegate;

    @Nullable
    private MaterialSideContainerBackHelper sideContainerBackHelper;
    private int state;
    private final SideSheetBehavior<V>.StateSettlingTracker stateSettlingTracker;

    @Nullable
    private VelocityTracker velocityTracker;

    @Nullable
    private ViewDragHelper viewDragHelper;

    @Nullable
    private WeakReference<V> viewRef;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.sidesheet.SideSheetBehavior.SavedState.1
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
                return new SavedState(parcel, (ClassLoader) null);
            }
        };
        final int state;

        public SavedState(@NonNull Parcel parcel) {
            this(parcel, (ClassLoader) null);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.state = parcel.readInt();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i6) {
            super.writeToParcel(parcel, i6);
            parcel.writeInt(this.state);
        }

        public SavedState(Parcelable parcelable, @NonNull SideSheetBehavior<?> sideSheetBehavior) {
            super(parcelable);
            this.state = ((SideSheetBehavior) sideSheetBehavior).state;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class StateSettlingTracker {
        private final Runnable continueSettlingRunnable = new Runnable() { // from class: com.google.android.material.sidesheet.e
            @Override // java.lang.Runnable
            public final void run() {
                SideSheetBehavior.StateSettlingTracker.a(SideSheetBehavior.StateSettlingTracker.this);
            }
        };
        private boolean isContinueSettlingRunnablePosted;
        private int targetState;

        public static /* synthetic */ void a(StateSettlingTracker stateSettlingTracker) {
            stateSettlingTracker.isContinueSettlingRunnablePosted = false;
            if (SideSheetBehavior.this.viewDragHelper != null && SideSheetBehavior.this.viewDragHelper.continueSettling(true)) {
                stateSettlingTracker.continueSettlingToState(stateSettlingTracker.targetState);
            } else if (SideSheetBehavior.this.state == 2) {
                SideSheetBehavior.this.setStateInternal(stateSettlingTracker.targetState);
            }
        }

        StateSettlingTracker() {
        }

        void continueSettlingToState(int i6) {
            if (SideSheetBehavior.this.viewRef == null || SideSheetBehavior.this.viewRef.get() == null) {
                return;
            }
            this.targetState = i6;
            if (this.isContinueSettlingRunnablePosted) {
                return;
            }
            ViewCompat.postOnAnimation((View) SideSheetBehavior.this.viewRef.get(), this.continueSettlingRunnable);
            this.isContinueSettlingRunnablePosted = true;
        }
    }

    public SideSheetBehavior() {
        this.stateSettlingTracker = new StateSettlingTracker();
        this.draggable = true;
        this.state = 5;
        this.lastStableState = 5;
        this.hideFriction = 0.1f;
        this.coplanarSiblingViewId = -1;
        this.callbacks = new LinkedHashSet();
        this.dragCallback = new ViewDragHelper.Callback() { // from class: com.google.android.material.sidesheet.SideSheetBehavior.1
            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewDragStateChanged(int i6) {
                if (i6 == 1 && SideSheetBehavior.this.draggable) {
                    SideSheetBehavior.this.setStateInternal(1);
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionHorizontal(@NonNull View view, int i6, int i7) {
                return MathUtils.clamp(i6, SideSheetBehavior.this.sheetDelegate.getMinViewPositionHorizontal(), SideSheetBehavior.this.sheetDelegate.getMaxViewPositionHorizontal());
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int getViewHorizontalDragRange(@NonNull View view) {
                return SideSheetBehavior.this.childWidth + SideSheetBehavior.this.getInnerMargin();
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewPositionChanged(@NonNull View view, int i6, int i7, int i8, int i9) {
                ViewGroup.MarginLayoutParams marginLayoutParams;
                View coplanarSiblingView = SideSheetBehavior.this.getCoplanarSiblingView();
                if (coplanarSiblingView != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) coplanarSiblingView.getLayoutParams()) != null) {
                    SideSheetBehavior.this.sheetDelegate.updateCoplanarSiblingLayoutParams(marginLayoutParams, view.getLeft(), view.getRight());
                    coplanarSiblingView.setLayoutParams(marginLayoutParams);
                }
                SideSheetBehavior.this.dispatchOnSlide(view, i6);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewReleased(@NonNull View view, float f6, float f7) {
                int calculateTargetStateOnViewReleased = SideSheetBehavior.this.calculateTargetStateOnViewReleased(view, f6, f7);
                SideSheetBehavior sideSheetBehavior = SideSheetBehavior.this;
                sideSheetBehavior.startSettling(view, calculateTargetStateOnViewReleased, sideSheetBehavior.shouldSkipSmoothAnimation());
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public boolean tryCaptureView(@NonNull View view, int i6) {
                return (SideSheetBehavior.this.state == 1 || SideSheetBehavior.this.viewRef == null || SideSheetBehavior.this.viewRef.get() != view) ? false : true;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionVertical(@NonNull View view, int i6, int i7) {
                return view.getTop();
            }
        };
    }

    private float calculateDragDistance(float f6, float f7) {
        return Math.abs(f6 - f7);
    }

    private void replaceAccessibilityActionForState(V v5, AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, int i6) {
        ViewCompat.replaceAccessibilityAction(v5, accessibilityActionCompat, null, createAccessibilityViewCommandForState(i6));
    }

    private void setSheetEdge(@NonNull V v5, int i6) {
        setSheetEdge(GravityCompat.getAbsoluteGravity(((CoordinatorLayout.LayoutParams) v5.getLayoutParams()).gravity, i6) == 3 ? 1 : 0);
    }

    public void expand() {
        setState(3);
    }

    int getOuterEdgeOffsetForState(int i6) {
        if (i6 == 3) {
            return getExpandedOffset();
        }
        if (i6 == 5) {
            return this.sheetDelegate.getHiddenOffset();
        }
        throw new IllegalArgumentException("Invalid state to get outer edge offset: " + i6);
    }

    public void hide() {
        setState(5);
    }

    public void setCoplanarSiblingView(@Nullable View view) {
        this.coplanarSiblingViewId = -1;
        if (view == null) {
            clearCoplanarSiblingView();
            return;
        }
        this.coplanarSiblingViewRef = new WeakReference<>(view);
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference != null) {
            V v5 = weakReference.get();
            if (ViewCompat.isLaidOut(v5)) {
                v5.requestLayout();
            }
        }
    }

    @Override // com.google.android.material.sidesheet.Sheet
    public void setState(final int i6) {
        if (i6 == 1 || i6 == 2) {
            StringBuilder sb = new StringBuilder();
            sb.append("STATE_");
            sb.append(i6 == 1 ? "DRAGGING" : "SETTLING");
            sb.append(" should not be set externally.");
            throw new IllegalArgumentException(sb.toString());
        }
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference == null || weakReference.get() == null) {
            setStateInternal(i6);
        } else {
            runAfterLayout(this.viewRef.get(), new Runnable() { // from class: com.google.android.material.sidesheet.b
                @Override // java.lang.Runnable
                public final void run() {
                    SideSheetBehavior.b(SideSheetBehavior.this, i6);
                }
            });
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean shouldSkipSmoothAnimation() {
        return true;
    }

    public static /* synthetic */ void b(SideSheetBehavior sideSheetBehavior, int i6) {
        V v5 = sideSheetBehavior.viewRef.get();
        if (v5 != null) {
            sideSheetBehavior.startSettling(v5, i6, false);
        }
    }

    public static /* synthetic */ void c(SideSheetBehavior sideSheetBehavior, ViewGroup.MarginLayoutParams marginLayoutParams, int i6, View view, ValueAnimator valueAnimator) {
        sideSheetBehavior.sheetDelegate.updateCoplanarSiblingAdjacentMargin(marginLayoutParams, AnimationUtils.lerp(i6, 0, valueAnimator.getAnimatedFraction()));
        view.requestLayout();
    }

    private int calculateCurrentOffset(int i6, V v5) {
        int i7 = this.state;
        if (i7 == 1 || i7 == 2) {
            return i6 - this.sheetDelegate.getOuterEdge(v5);
        }
        if (i7 == 3) {
            return 0;
        }
        if (i7 == 5) {
            return this.sheetDelegate.getHiddenOffset();
        }
        throw new IllegalStateException("Unexpected value: " + this.state);
    }

    private void clearCoplanarSiblingView() {
        WeakReference<View> weakReference = this.coplanarSiblingViewRef;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.coplanarSiblingViewRef = null;
    }

    private AccessibilityViewCommand createAccessibilityViewCommandForState(final int i6) {
        return new AccessibilityViewCommand() { // from class: com.google.android.material.sidesheet.c
            @Override // androidx.core.view.accessibility.AccessibilityViewCommand
            public final boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
                return SideSheetBehavior.a(SideSheetBehavior.this, i6, view, commandArguments);
            }
        };
    }

    private void createMaterialShapeDrawableIfNeeded(@NonNull Context context) {
        if (this.shapeAppearanceModel == null) {
            return;
        }
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this.shapeAppearanceModel);
        this.materialShapeDrawable = materialShapeDrawable;
        materialShapeDrawable.initializeElevationOverlay(context);
        ColorStateList colorStateList = this.backgroundTint;
        if (colorStateList != null) {
            this.materialShapeDrawable.setFillColor(colorStateList);
            return;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(android.R.attr.colorBackground, typedValue, true);
        this.materialShapeDrawable.setTint(typedValue.data);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchOnSlide(@NonNull View view, int i6) {
        if (this.callbacks.isEmpty()) {
            return;
        }
        float calculateSlideOffset = this.sheetDelegate.calculateSlideOffset(i6);
        Iterator<SideSheetCallback> it = this.callbacks.iterator();
        while (it.hasNext()) {
            it.next().onSlide(view, calculateSlideOffset);
        }
    }

    @GravityInt
    private int getGravityFromSheetEdge() {
        SheetDelegate sheetDelegate = this.sheetDelegate;
        return (sheetDelegate == null || sheetDelegate.getSheetEdge() == 0) ? 5 : 3;
    }

    @Nullable
    private CoordinatorLayout.LayoutParams getViewLayoutParams() {
        V v5;
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference == null || (v5 = weakReference.get()) == null || !(v5.getLayoutParams() instanceof CoordinatorLayout.LayoutParams)) {
            return null;
        }
        return (CoordinatorLayout.LayoutParams) v5.getLayoutParams();
    }

    private boolean isExpandingOutwards(float f6) {
        return this.sheetDelegate.isExpandingOutwards(f6);
    }

    private void maybeAssignCoplanarSiblingViewBasedId(@NonNull CoordinatorLayout coordinatorLayout) {
        int i6;
        View findViewById;
        if (this.coplanarSiblingViewRef != null || (i6 = this.coplanarSiblingViewId) == -1 || (findViewById = coordinatorLayout.findViewById(i6)) == null) {
            return;
        }
        this.coplanarSiblingViewRef = new WeakReference<>(findViewById);
    }

    private void resetVelocity() {
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.velocityTracker = null;
        }
    }

    private boolean shouldHandleDraggingWithHelper() {
        if (this.viewDragHelper != null) {
            return this.draggable || this.state == 1;
        }
        return false;
    }

    private void updateAccessibilityActions() {
        V v5;
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference == null || (v5 = weakReference.get()) == null) {
            return;
        }
        ViewCompat.removeAccessibilityAction(v5, 262144);
        ViewCompat.removeAccessibilityAction(v5, 1048576);
        if (this.state != 5) {
            replaceAccessibilityActionForState(v5, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, 5);
        }
        if (this.state != 3) {
            replaceAccessibilityActionForState(v5, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, 3);
        }
    }

    private void updateCoplanarSiblingBackProgress() {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        V v5 = this.viewRef.get();
        View coplanarSiblingView = getCoplanarSiblingView();
        if (coplanarSiblingView == null || (marginLayoutParams = (ViewGroup.MarginLayoutParams) coplanarSiblingView.getLayoutParams()) == null) {
            return;
        }
        this.sheetDelegate.updateCoplanarSiblingAdjacentMargin(marginLayoutParams, (int) ((this.childWidth * v5.getScaleX()) + this.innerMargin));
        coplanarSiblingView.requestLayout();
    }

    private void updateMaterialShapeDrawable(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        MaterialShapeDrawable materialShapeDrawable = this.materialShapeDrawable;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setShapeAppearanceModel(shapeAppearanceModel);
        }
    }

    private void updateSheetVisibility(@NonNull View view) {
        int i6 = this.state == 5 ? 4 : 0;
        if (view.getVisibility() != i6) {
            view.setVisibility(i6);
        }
    }

    @Override // com.google.android.material.sidesheet.Sheet
    public void addCallback(@NonNull SideSheetCallback sideSheetCallback) {
        this.callbacks.add(sideSheetCallback);
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public void cancelBackProgress() {
        MaterialSideContainerBackHelper materialSideContainerBackHelper = this.sideContainerBackHelper;
        if (materialSideContainerBackHelper == null) {
            return;
        }
        materialSideContainerBackHelper.cancelBackProgress();
    }

    @Nullable
    @VisibleForTesting
    MaterialSideContainerBackHelper getBackHelper() {
        return this.sideContainerBackHelper;
    }

    int getChildWidth() {
        return this.childWidth;
    }

    @Nullable
    public View getCoplanarSiblingView() {
        WeakReference<View> weakReference = this.coplanarSiblingViewRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public int getExpandedOffset() {
        return this.sheetDelegate.getExpandedOffset();
    }

    public float getHideFriction() {
        return this.hideFriction;
    }

    float getHideThreshold() {
        return 0.5f;
    }

    int getInnerMargin() {
        return this.innerMargin;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getLastStableState() {
        return this.lastStableState;
    }

    int getParentInnerEdge() {
        return this.parentInnerEdge;
    }

    int getParentWidth() {
        return this.parentWidth;
    }

    int getSignificantVelocityThreshold() {
        return 500;
    }

    @Override // com.google.android.material.sidesheet.Sheet
    public int getState() {
        return this.state;
    }

    @Nullable
    ViewDragHelper getViewDragHelper() {
        return this.viewDragHelper;
    }

    float getXVelocity() {
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.maximumVelocity);
        return this.velocityTracker.getXVelocity();
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public void handleBackInvoked() {
        MaterialSideContainerBackHelper materialSideContainerBackHelper = this.sideContainerBackHelper;
        if (materialSideContainerBackHelper == null) {
            return;
        }
        BackEventCompat onHandleBackInvoked = materialSideContainerBackHelper.onHandleBackInvoked();
        if (onHandleBackInvoked == null || Build.VERSION.SDK_INT < 34) {
            setState(5);
        } else {
            this.sideContainerBackHelper.finishBackProgress(onHandleBackInvoked, getGravityFromSheetEdge(), new AnimatorListenerAdapter() { // from class: com.google.android.material.sidesheet.SideSheetBehavior.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    SideSheetBehavior.this.setStateInternal(5);
                    if (SideSheetBehavior.this.viewRef == null || SideSheetBehavior.this.viewRef.get() == null) {
                        return;
                    }
                    ((View) SideSheetBehavior.this.viewRef.get()).requestLayout();
                }
            }, getCoplanarFinishAnimatorUpdateListener());
        }
    }

    public boolean isDraggable() {
        return this.draggable;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onRestoreInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v5, @NonNull Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        if (savedState.getSuperState() != null) {
            super.onRestoreInstanceState(coordinatorLayout, v5, savedState.getSuperState());
        }
        int i6 = savedState.state;
        if (i6 == 1 || i6 == 2) {
            i6 = 5;
        }
        this.state = i6;
        this.lastStableState = i6;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @NonNull
    public Parcelable onSaveInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v5) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, v5), (SideSheetBehavior<?>) this);
    }

    @Override // com.google.android.material.sidesheet.Sheet
    public void removeCallback(@NonNull SideSheetCallback sideSheetCallback) {
        this.callbacks.remove(sideSheetCallback);
    }

    public void setCoplanarSiblingViewId(@IdRes int i6) {
        this.coplanarSiblingViewId = i6;
        clearCoplanarSiblingView();
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference != null) {
            V v5 = weakReference.get();
            if (i6 == -1 || !ViewCompat.isLaidOut(v5)) {
                return;
            }
            v5.requestLayout();
        }
    }

    public void setDraggable(boolean z5) {
        this.draggable = z5;
    }

    public void setHideFriction(float f6) {
        this.hideFriction = f6;
    }

    void setStateInternal(int i6) {
        V v5;
        if (this.state == i6) {
            return;
        }
        this.state = i6;
        if (i6 == 3 || i6 == 5) {
            this.lastStableState = i6;
        }
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference == null || (v5 = weakReference.get()) == null) {
            return;
        }
        updateSheetVisibility(v5);
        Iterator<SideSheetCallback> it = this.callbacks.iterator();
        while (it.hasNext()) {
            it.next().onStateChanged(v5, i6);
        }
        updateAccessibilityActions();
    }

    boolean shouldHide(@NonNull View view, float f6) {
        return this.sheetDelegate.shouldHide(view, f6);
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public void startBackProgress(@NonNull BackEventCompat backEventCompat) {
        MaterialSideContainerBackHelper materialSideContainerBackHelper = this.sideContainerBackHelper;
        if (materialSideContainerBackHelper == null) {
            return;
        }
        materialSideContainerBackHelper.startBackProgress(backEventCompat);
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public void updateBackProgress(@NonNull BackEventCompat backEventCompat) {
        MaterialSideContainerBackHelper materialSideContainerBackHelper = this.sideContainerBackHelper;
        if (materialSideContainerBackHelper == null) {
            return;
        }
        materialSideContainerBackHelper.updateBackProgress(backEventCompat, getGravityFromSheetEdge());
        updateCoplanarSiblingBackProgress();
    }

    public static /* synthetic */ boolean a(SideSheetBehavior sideSheetBehavior, int i6, View view, AccessibilityViewCommand.CommandArguments commandArguments) {
        sideSheetBehavior.setState(i6);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int calculateTargetStateOnViewReleased(@NonNull View view, float f6, float f7) {
        if (isExpandingOutwards(f6)) {
            return 3;
        }
        if (shouldHide(view, f6)) {
            if (!this.sheetDelegate.isSwipeSignificant(f6, f7) && !this.sheetDelegate.isReleasedCloseToInnerEdge(view)) {
                return 3;
            }
            return 5;
        }
        if (f6 != 0.0f && SheetUtils.isSwipeMostlyHorizontal(f6, f7)) {
            return 5;
        }
        int left = view.getLeft();
        if (Math.abs(left - getExpandedOffset()) < Math.abs(left - this.sheetDelegate.getHiddenOffset())) {
            return 3;
        }
        return 5;
    }

    private void ensureAccessibilityPaneTitleIsSet(View view) {
        if (ViewCompat.getAccessibilityPaneTitle(view) == null) {
            ViewCompat.setAccessibilityPaneTitle(view, view.getResources().getString(DEFAULT_ACCESSIBILITY_PANE_TITLE));
        }
    }

    @NonNull
    public static <V extends View> SideSheetBehavior<V> from(@NonNull V v5) {
        ViewGroup.LayoutParams layoutParams = v5.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
            if (behavior instanceof SideSheetBehavior) {
                return (SideSheetBehavior) behavior;
            }
            throw new IllegalArgumentException("The view is not associated with SideSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    private int getChildMeasureSpec(int i6, int i7, int i8, int i9) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i6, i7, i9);
        if (i8 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode != 1073741824) {
            if (size != 0) {
                i8 = Math.min(size, i8);
            }
            return View.MeasureSpec.makeMeasureSpec(i8, Integer.MIN_VALUE);
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(size, i8), 1073741824);
    }

    @Nullable
    private ValueAnimator.AnimatorUpdateListener getCoplanarFinishAnimatorUpdateListener() {
        final ViewGroup.MarginLayoutParams marginLayoutParams;
        final View coplanarSiblingView = getCoplanarSiblingView();
        if (coplanarSiblingView == null || (marginLayoutParams = (ViewGroup.MarginLayoutParams) coplanarSiblingView.getLayoutParams()) == null) {
            return null;
        }
        final int coplanarSiblingAdjacentMargin = this.sheetDelegate.getCoplanarSiblingAdjacentMargin(marginLayoutParams);
        return new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.sidesheet.d
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SideSheetBehavior.c(SideSheetBehavior.this, marginLayoutParams, coplanarSiblingAdjacentMargin, coplanarSiblingView, valueAnimator);
            }
        };
    }

    private boolean hasLeftMargin() {
        CoordinatorLayout.LayoutParams viewLayoutParams = getViewLayoutParams();
        if (viewLayoutParams != null && ((ViewGroup.MarginLayoutParams) viewLayoutParams).leftMargin > 0) {
            return true;
        }
        return false;
    }

    private boolean hasRightMargin() {
        CoordinatorLayout.LayoutParams viewLayoutParams = getViewLayoutParams();
        if (viewLayoutParams != null && ((ViewGroup.MarginLayoutParams) viewLayoutParams).rightMargin > 0) {
            return true;
        }
        return false;
    }

    private boolean isDraggedFarEnough(@NonNull MotionEvent motionEvent) {
        if (!shouldHandleDraggingWithHelper() || calculateDragDistance(this.initialX, motionEvent.getX()) <= this.viewDragHelper.getTouchSlop()) {
            return false;
        }
        return true;
    }

    private boolean isLayingOut(@NonNull V v5) {
        ViewParent parent = v5.getParent();
        if (parent != null && parent.isLayoutRequested() && ViewCompat.isAttachedToWindow(v5)) {
            return true;
        }
        return false;
    }

    private boolean isSettling(View view, int i6, boolean z5) {
        int outerEdgeOffsetForState = getOuterEdgeOffsetForState(i6);
        ViewDragHelper viewDragHelper = getViewDragHelper();
        if (viewDragHelper != null) {
            if (z5) {
                if (viewDragHelper.settleCapturedViewAt(outerEdgeOffsetForState, view.getTop())) {
                    return true;
                }
                return false;
            }
            if (viewDragHelper.smoothSlideViewTo(view, outerEdgeOffsetForState, view.getTop())) {
                return true;
            }
            return false;
        }
        return false;
    }

    private void runAfterLayout(@NonNull V v5, Runnable runnable) {
        if (isLayingOut(v5)) {
            v5.post(runnable);
        } else {
            runnable.run();
        }
    }

    private boolean shouldInterceptTouchEvent(@NonNull V v5) {
        if ((v5.isShown() || ViewCompat.getAccessibilityPaneTitle(v5) != null) && this.draggable) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startSettling(View view, int i6, boolean z5) {
        if (isSettling(view, i6, z5)) {
            setStateInternal(2);
            this.stateSettlingTracker.continueSettlingToState(i6);
        } else {
            setStateInternal(i6);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        this.viewRef = null;
        this.viewDragHelper = null;
        this.sideContainerBackHelper = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.viewRef = null;
        this.viewDragHelper = null;
        this.sideContainerBackHelper = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v5, @NonNull MotionEvent motionEvent) {
        ViewDragHelper viewDragHelper;
        if (!shouldInterceptTouchEvent(v5)) {
            this.ignoreEvents = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            resetVelocity();
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        if (actionMasked != 0) {
            if ((actionMasked == 1 || actionMasked == 3) && this.ignoreEvents) {
                this.ignoreEvents = false;
                return false;
            }
        } else {
            this.initialX = (int) motionEvent.getX();
        }
        if (!this.ignoreEvents && (viewDragHelper = this.viewDragHelper) != null && viewDragHelper.shouldInterceptTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v5, int i6) {
        int i7;
        if (ViewCompat.getFitsSystemWindows(coordinatorLayout) && !ViewCompat.getFitsSystemWindows(v5)) {
            v5.setFitsSystemWindows(true);
        }
        if (this.viewRef == null) {
            this.viewRef = new WeakReference<>(v5);
            this.sideContainerBackHelper = new MaterialSideContainerBackHelper(v5);
            MaterialShapeDrawable materialShapeDrawable = this.materialShapeDrawable;
            if (materialShapeDrawable != null) {
                ViewCompat.setBackground(v5, materialShapeDrawable);
                MaterialShapeDrawable materialShapeDrawable2 = this.materialShapeDrawable;
                float f6 = this.elevation;
                if (f6 == -1.0f) {
                    f6 = ViewCompat.getElevation(v5);
                }
                materialShapeDrawable2.setElevation(f6);
            } else {
                ColorStateList colorStateList = this.backgroundTint;
                if (colorStateList != null) {
                    ViewCompat.setBackgroundTintList(v5, colorStateList);
                }
            }
            updateSheetVisibility(v5);
            updateAccessibilityActions();
            if (ViewCompat.getImportantForAccessibility(v5) == 0) {
                ViewCompat.setImportantForAccessibility(v5, 1);
            }
            ensureAccessibilityPaneTitleIsSet(v5);
        }
        setSheetEdge(v5, i6);
        if (this.viewDragHelper == null) {
            this.viewDragHelper = ViewDragHelper.create(coordinatorLayout, this.dragCallback);
        }
        int outerEdge = this.sheetDelegate.getOuterEdge(v5);
        coordinatorLayout.onLayoutChild(v5, i6);
        this.parentWidth = coordinatorLayout.getWidth();
        this.parentInnerEdge = this.sheetDelegate.getParentInnerEdge(coordinatorLayout);
        this.childWidth = v5.getWidth();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) v5.getLayoutParams();
        if (marginLayoutParams != null) {
            i7 = this.sheetDelegate.calculateInnerMargin(marginLayoutParams);
        } else {
            i7 = 0;
        }
        this.innerMargin = i7;
        ViewCompat.offsetLeftAndRight(v5, calculateCurrentOffset(outerEdge, v5));
        maybeAssignCoplanarSiblingViewBasedId(coordinatorLayout);
        for (SideSheetCallback sideSheetCallback : this.callbacks) {
            if (sideSheetCallback instanceof SideSheetCallback) {
                sideSheetCallback.onLayout(v5);
            }
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v5, int i6, int i7, int i8, int i9) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) v5.getLayoutParams();
        v5.measure(getChildMeasureSpec(i6, coordinatorLayout.getPaddingLeft() + coordinatorLayout.getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i7, -1, marginLayoutParams.width), getChildMeasureSpec(i8, coordinatorLayout.getPaddingTop() + coordinatorLayout.getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i9, -1, marginLayoutParams.height));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v5, @NonNull MotionEvent motionEvent) {
        if (!v5.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.state == 1 && actionMasked == 0) {
            return true;
        }
        if (shouldHandleDraggingWithHelper()) {
            this.viewDragHelper.processTouchEvent(motionEvent);
        }
        if (actionMasked == 0) {
            resetVelocity();
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        if (shouldHandleDraggingWithHelper() && actionMasked == 2 && !this.ignoreEvents && isDraggedFarEnough(motionEvent)) {
            this.viewDragHelper.captureChildView(v5, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.ignoreEvents;
    }

    private void setSheetEdge(int i6) {
        SheetDelegate sheetDelegate = this.sheetDelegate;
        if (sheetDelegate == null || sheetDelegate.getSheetEdge() != i6) {
            if (i6 == 0) {
                this.sheetDelegate = new RightSheetDelegate(this);
                if (this.shapeAppearanceModel == null || hasRightMargin()) {
                    return;
                }
                ShapeAppearanceModel.Builder builder = this.shapeAppearanceModel.toBuilder();
                builder.setTopRightCornerSize(0.0f).setBottomRightCornerSize(0.0f);
                updateMaterialShapeDrawable(builder.build());
                return;
            }
            if (i6 == 1) {
                this.sheetDelegate = new LeftSheetDelegate(this);
                if (this.shapeAppearanceModel == null || hasLeftMargin()) {
                    return;
                }
                ShapeAppearanceModel.Builder builder2 = this.shapeAppearanceModel.toBuilder();
                builder2.setTopLeftCornerSize(0.0f).setBottomLeftCornerSize(0.0f);
                updateMaterialShapeDrawable(builder2.build());
                return;
            }
            throw new IllegalArgumentException("Invalid sheet edge position value: " + i6 + ". Must be 0 or 1.");
        }
    }

    public SideSheetBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.stateSettlingTracker = new StateSettlingTracker();
        this.draggable = true;
        this.state = 5;
        this.lastStableState = 5;
        this.hideFriction = 0.1f;
        this.coplanarSiblingViewId = -1;
        this.callbacks = new LinkedHashSet();
        this.dragCallback = new ViewDragHelper.Callback() { // from class: com.google.android.material.sidesheet.SideSheetBehavior.1
            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewDragStateChanged(int i6) {
                if (i6 == 1 && SideSheetBehavior.this.draggable) {
                    SideSheetBehavior.this.setStateInternal(1);
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionHorizontal(@NonNull View view, int i6, int i7) {
                return MathUtils.clamp(i6, SideSheetBehavior.this.sheetDelegate.getMinViewPositionHorizontal(), SideSheetBehavior.this.sheetDelegate.getMaxViewPositionHorizontal());
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int getViewHorizontalDragRange(@NonNull View view) {
                return SideSheetBehavior.this.childWidth + SideSheetBehavior.this.getInnerMargin();
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewPositionChanged(@NonNull View view, int i6, int i7, int i8, int i9) {
                ViewGroup.MarginLayoutParams marginLayoutParams;
                View coplanarSiblingView = SideSheetBehavior.this.getCoplanarSiblingView();
                if (coplanarSiblingView != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) coplanarSiblingView.getLayoutParams()) != null) {
                    SideSheetBehavior.this.sheetDelegate.updateCoplanarSiblingLayoutParams(marginLayoutParams, view.getLeft(), view.getRight());
                    coplanarSiblingView.setLayoutParams(marginLayoutParams);
                }
                SideSheetBehavior.this.dispatchOnSlide(view, i6);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewReleased(@NonNull View view, float f6, float f7) {
                int calculateTargetStateOnViewReleased = SideSheetBehavior.this.calculateTargetStateOnViewReleased(view, f6, f7);
                SideSheetBehavior sideSheetBehavior = SideSheetBehavior.this;
                sideSheetBehavior.startSettling(view, calculateTargetStateOnViewReleased, sideSheetBehavior.shouldSkipSmoothAnimation());
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public boolean tryCaptureView(@NonNull View view, int i6) {
                return (SideSheetBehavior.this.state == 1 || SideSheetBehavior.this.viewRef == null || SideSheetBehavior.this.viewRef.get() != view) ? false : true;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionVertical(@NonNull View view, int i6, int i7) {
                return view.getTop();
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SideSheetBehavior_Layout);
        int i6 = R.styleable.SideSheetBehavior_Layout_backgroundTint;
        if (obtainStyledAttributes.hasValue(i6)) {
            this.backgroundTint = MaterialResources.getColorStateList(context, obtainStyledAttributes, i6);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.SideSheetBehavior_Layout_shapeAppearance)) {
            this.shapeAppearanceModel = ShapeAppearanceModel.builder(context, attributeSet, 0, DEF_STYLE_RES).build();
        }
        int i7 = R.styleable.SideSheetBehavior_Layout_coplanarSiblingViewId;
        if (obtainStyledAttributes.hasValue(i7)) {
            setCoplanarSiblingViewId(obtainStyledAttributes.getResourceId(i7, -1));
        }
        createMaterialShapeDrawableIfNeeded(context);
        this.elevation = obtainStyledAttributes.getDimension(R.styleable.SideSheetBehavior_Layout_android_elevation, -1.0f);
        setDraggable(obtainStyledAttributes.getBoolean(R.styleable.SideSheetBehavior_Layout_behavior_draggable, true));
        obtainStyledAttributes.recycle();
        this.maximumVelocity = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
