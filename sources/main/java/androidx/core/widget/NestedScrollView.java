package androidx.core.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.DifferentialMotionFlingController;
import androidx.core.view.DifferentialMotionFlingTarget;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class NestedScrollView extends FrameLayout implements NestedScrollingParent3, NestedScrollingChild3, ScrollingView {
    static final int ANIMATED_SCROLL_GAP = 250;
    private static final int DEFAULT_SMOOTH_SCROLL_DURATION = 250;
    private static final float FLING_DESTRETCH_FACTOR = 4.0f;
    private static final float INFLEXION = 0.35f;
    private static final int INVALID_POINTER = -1;
    static final float MAX_SCROLL_FACTOR = 0.5f;
    private static final float SCROLL_FRICTION = 0.015f;
    private static final String TAG = "NestedScrollView";
    private int mActivePointerId;
    private final NestedScrollingChildHelper mChildHelper;
    private View mChildToScrollTo;

    @VisibleForTesting
    DifferentialMotionFlingController mDifferentialMotionFlingController;

    @VisibleForTesting
    final DifferentialMotionFlingTargetImpl mDifferentialMotionFlingTarget;

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @VisibleForTesting
    public EdgeEffect mEdgeGlowBottom;

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @VisibleForTesting
    public EdgeEffect mEdgeGlowTop;
    private boolean mFillViewport;
    private boolean mIsBeingDragged;
    private boolean mIsLaidOut;
    private boolean mIsLayoutDirty;
    private int mLastMotionY;
    private long mLastScroll;
    private int mLastScrollerY;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mNestedYOffset;
    private OnScrollChangeListener mOnScrollChangeListener;
    private final NestedScrollingParentHelper mParentHelper;
    private final float mPhysicalCoeff;
    private SavedState mSavedState;
    private final int[] mScrollConsumed;
    private final int[] mScrollOffset;
    private OverScroller mScroller;
    private boolean mSmoothScrollingEnabled;
    private final Rect mTempRect;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private float mVerticalScrollFactor;
    private static final float DECELERATION_RATE = (float) (Math.log(0.78d) / Math.log(0.9d));
    private static final AccessibilityDelegate ACCESSIBILITY_DELEGATE = new AccessibilityDelegate();
    private static final int[] SCROLLVIEW_STYLEABLE = {R.attr.fillViewport};

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class DifferentialMotionFlingTargetImpl implements DifferentialMotionFlingTarget {
        @Override // androidx.core.view.DifferentialMotionFlingTarget
        public boolean startDifferentialMotionFling(float f6) {
            if (f6 == 0.0f) {
                return false;
            }
            stopDifferentialMotionFling();
            NestedScrollView.this.fling((int) f6);
            return true;
        }

        DifferentialMotionFlingTargetImpl() {
        }

        @Override // androidx.core.view.DifferentialMotionFlingTarget
        public float getScaledScrollFactor() {
            return -NestedScrollView.this.getVerticalScrollFactorCompat();
        }

        @Override // androidx.core.view.DifferentialMotionFlingTarget
        public void stopDifferentialMotionFling() {
            NestedScrollView.this.mScroller.abortAnimation();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface OnScrollChangeListener {
        void onScrollChange(@NonNull NestedScrollView nestedScrollView, int i6, int i7, int i8, int i9);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.core.widget.NestedScrollView.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i6) {
                return new SavedState[i6];
            }
        };
        public int scrollPosition;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.scrollPosition = parcel.readInt();
        }

        @NonNull
        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.scrollPosition + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            super.writeToParcel(parcel, i6);
            parcel.writeInt(this.scrollPosition);
        }
    }

    public NestedScrollView(@NonNull Context context) {
        this(context, null);
    }

    private void endTouchDrag() {
        this.mActivePointerId = -1;
        this.mIsBeingDragged = false;
        recycleVelocityTracker();
        stopNestedScroll(0);
        this.mEdgeGlowTop.onRelease();
        this.mEdgeGlowBottom.onRelease();
    }

    private View findFocusableViewInBounds(boolean z5, int i6, int i7) {
        ArrayList<View> focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z6 = false;
        for (int i8 = 0; i8 < size; i8++) {
            View view2 = focusables.get(i8);
            int top2 = view2.getTop();
            int bottom = view2.getBottom();
            if (i6 < bottom && top2 < i7) {
                boolean z7 = i6 < top2 && bottom < i7;
                if (view == null) {
                    view = view2;
                    z6 = z7;
                } else {
                    boolean z8 = (z5 && top2 < view.getTop()) || (!z5 && bottom > view.getBottom());
                    if (z6) {
                        if (z7) {
                            if (!z8) {
                            }
                            view = view2;
                        }
                    } else if (z7) {
                        view = view2;
                        z6 = true;
                    } else {
                        if (!z8) {
                        }
                        view = view2;
                    }
                }
            }
        }
        return view;
    }

    private boolean isOffScreen(View view) {
        return !isWithinDeltaOfScreen(view, 0, getHeight());
    }

    private static boolean isViewDescendantOf(View view, View view2) {
        if (view == view2) {
            return true;
        }
        Object parent = view.getParent();
        return (parent instanceof ViewGroup) && isViewDescendantOf((View) parent, view2);
    }

    private void runAnimatedScroll(boolean z5) {
        if (z5) {
            startNestedScroll(2, 1);
        } else {
            stopNestedScroll(1);
        }
        this.mLastScrollerY = getScrollY();
        postInvalidateOnAnimation();
    }

    private boolean shouldAbsorb(@NonNull EdgeEffect edgeEffect, int i6) {
        if (i6 > 0) {
            return true;
        }
        return getSplineFlingDistance(-i6) < EdgeEffectCompat.getDistance(edgeEffect) * ((float) getHeight());
    }

    @Override // android.view.ViewGroup
    public void addView(@NonNull View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int i6, int i7, @Nullable int[] iArr, @Nullable int[] iArr2, int i8) {
        return this.mChildHelper.dispatchNestedPreScroll(i6, i7, iArr, iArr2, i8);
    }

    @Override // androidx.core.view.NestedScrollingChild3
    public void dispatchNestedScroll(int i6, int i7, int i8, int i9, @Nullable int[] iArr, int i10, @NonNull int[] iArr2) {
        this.mChildHelper.dispatchNestedScroll(i6, i7, i8, i9, iArr, i10, iArr2);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean hasNestedScrollingParent(int i6) {
        return this.mChildHelper.hasNestedScrollingParent(i6);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(@NonNull View view, int i6, int i7, @NonNull int[] iArr, int i8) {
        dispatchNestedPreScroll(i6, i7, iArr, null, i8);
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(@NonNull View view, int i6, int i7, int i8, int i9, int i10, @NonNull int[] iArr) {
        onNestedScrollInternal(i9, i10, iArr);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i6, int i7) {
        this.mParentHelper.onNestedScrollAccepted(view, view2, i6, i7);
        startNestedScroll(2, i7);
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i6, Rect rect) {
        if (i6 == 2) {
            i6 = MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE;
        } else if (i6 == 1) {
            i6 = 33;
        }
        View findNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, null, i6) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i6);
        if (findNextFocus == null || isOffScreen(findNextFocus)) {
            return false;
        }
        return findNextFocus.requestFocus(i6, rect);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i6, int i7) {
        return (i6 & 2) != 0;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(@NonNull View view, int i6) {
        this.mParentHelper.onStopNestedScroll(view, i6);
        stopNestedScroll(i6);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.mIsLayoutDirty = true;
        super.requestLayout();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public final void smoothScrollBy(int i6, int i7) {
        smoothScrollBy(i6, i7, 250, false);
    }

    public final void smoothScrollTo(int i6, int i7) {
        smoothScrollTo(i6, i7, 250, false);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean startNestedScroll(int i6, int i7) {
        return this.mChildHelper.startNestedScroll(i6, i7);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public void stopNestedScroll(int i6) {
        this.mChildHelper.stopNestedScroll(i6);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class AccessibilityDelegate extends AccessibilityDelegateCompat {
        AccessibilityDelegate() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            boolean z5;
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            if (nestedScrollView.getScrollRange() > 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            accessibilityEvent.setScrollable(z5);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            AccessibilityRecordCompat.setMaxScrollX(accessibilityEvent, nestedScrollView.getScrollX());
            AccessibilityRecordCompat.setMaxScrollY(accessibilityEvent, nestedScrollView.getScrollRange());
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            int scrollRange;
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityNodeInfoCompat.setClassName(ScrollView.class.getName());
            if (nestedScrollView.isEnabled() && (scrollRange = nestedScrollView.getScrollRange()) > 0) {
                accessibilityNodeInfoCompat.setScrollable(true);
                if (nestedScrollView.getScrollY() > 0) {
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_UP);
                }
                if (nestedScrollView.getScrollY() < scrollRange) {
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_DOWN);
                }
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i6, Bundle bundle) {
            if (super.performAccessibilityAction(view, i6, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            int height = nestedScrollView.getHeight();
            Rect rect = new Rect();
            if (nestedScrollView.getMatrix().isIdentity() && nestedScrollView.getGlobalVisibleRect(rect)) {
                height = rect.height();
            }
            if (i6 != 4096) {
                if (i6 != 8192 && i6 != 16908344) {
                    if (i6 != 16908346) {
                        return false;
                    }
                } else {
                    int max = Math.max(nestedScrollView.getScrollY() - ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (max == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.smoothScrollTo(0, max, true);
                    return true;
                }
            }
            int min = Math.min(nestedScrollView.getScrollY() + ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
            if (min == nestedScrollView.getScrollY()) {
                return false;
            }
            nestedScrollView.smoothScrollTo(0, min, true);
            return true;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static boolean getClipToPadding(ViewGroup viewGroup) {
            return viewGroup.getClipToPadding();
        }
    }

    public NestedScrollView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, androidx.core.R.attr.nestedScrollViewStyle);
    }

    private void abortAnimatedScroll() {
        this.mScroller.abortAnimation();
        stopNestedScroll(1);
    }

    private static int clamp(int i6, int i7, int i8) {
        if (i7 >= i8 || i6 < 0) {
            return 0;
        }
        return i7 + i6 > i8 ? i8 - i7 : i6;
    }

    private void doScrollY(int i6) {
        if (i6 != 0) {
            if (this.mSmoothScrollingEnabled) {
                smoothScrollBy(0, i6);
            } else {
                scrollBy(0, i6);
            }
        }
    }

    private boolean edgeEffectFling(int i6) {
        if (EdgeEffectCompat.getDistance(this.mEdgeGlowTop) != 0.0f) {
            if (shouldAbsorb(this.mEdgeGlowTop, i6)) {
                this.mEdgeGlowTop.onAbsorb(i6);
                return true;
            }
            fling(-i6);
            return true;
        }
        if (EdgeEffectCompat.getDistance(this.mEdgeGlowBottom) == 0.0f) {
            return false;
        }
        int i7 = -i6;
        if (shouldAbsorb(this.mEdgeGlowBottom, i7)) {
            this.mEdgeGlowBottom.onAbsorb(i7);
            return true;
        }
        fling(i7);
        return true;
    }

    private void initOrResetVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void initScrollView() {
        this.mScroller = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private void initVelocityTrackerIfNotExists() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private void initializeTouchDrag(int i6, int i7) {
        this.mLastMotionY = i6;
        this.mActivePointerId = i7;
        startNestedScroll(2, 0);
    }

    private boolean isWithinDeltaOfScreen(View view, int i6, int i7) {
        view.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        return this.mTempRect.bottom + i6 >= getScrollY() && this.mTempRect.top - i6 <= getScrollY() + i7;
    }

    private void recycleVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private int scrollBy(int i6, int i7, int i8, boolean z5) {
        int i9;
        int i10;
        VelocityTracker velocityTracker;
        if (i8 == 1) {
            startNestedScroll(2, i8);
        }
        boolean z6 = false;
        if (dispatchNestedPreScroll(0, i6, this.mScrollConsumed, this.mScrollOffset, i8)) {
            int i11 = i6 - this.mScrollConsumed[1];
            i10 = this.mScrollOffset[1];
            i9 = i11;
        } else {
            i9 = i6;
            i10 = 0;
        }
        int scrollY = getScrollY();
        int scrollRange = getScrollRange();
        boolean z7 = canOverScroll() && !z5;
        int i12 = i9;
        boolean z8 = overScrollByCompat(0, i9, 0, scrollY, 0, scrollRange, 0, 0, true) && !hasNestedScrollingParent(i8);
        int scrollY2 = getScrollY() - scrollY;
        int[] iArr = this.mScrollConsumed;
        iArr[1] = 0;
        dispatchNestedScroll(0, scrollY2, 0, i12 - scrollY2, this.mScrollOffset, i8, iArr);
        int i13 = i10 + this.mScrollOffset[1];
        int i14 = i12 - this.mScrollConsumed[1];
        int i15 = scrollY + i14;
        if (i15 < 0) {
            if (z7) {
                EdgeEffectCompat.onPullDistance(this.mEdgeGlowTop, (-i14) / getHeight(), i7 / getWidth());
                if (!this.mEdgeGlowBottom.isFinished()) {
                    this.mEdgeGlowBottom.onRelease();
                }
            }
        } else if (i15 > scrollRange && z7) {
            EdgeEffectCompat.onPullDistance(this.mEdgeGlowBottom, i14 / getHeight(), 1.0f - (i7 / getWidth()));
            if (!this.mEdgeGlowTop.isFinished()) {
                this.mEdgeGlowTop.onRelease();
            }
        }
        if (this.mEdgeGlowTop.isFinished() && this.mEdgeGlowBottom.isFinished()) {
            z6 = z8;
        } else {
            postInvalidateOnAnimation();
        }
        if (z6 && i8 == 0 && (velocityTracker = this.mVelocityTracker) != null) {
            velocityTracker.clear();
        }
        if (i8 == 1) {
            stopNestedScroll(i8);
            this.mEdgeGlowTop.onRelease();
            this.mEdgeGlowBottom.onRelease();
        }
        return i13;
    }

    private void scrollToChild(View view) {
        view.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        int computeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(this.mTempRect);
        if (computeScrollDeltaToGetChildRectOnScreen != 0) {
            scrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
        }
    }

    private boolean stopGlowAnimations(MotionEvent motionEvent) {
        boolean z5;
        if (EdgeEffectCompat.getDistance(this.mEdgeGlowTop) != 0.0f) {
            EdgeEffectCompat.onPullDistance(this.mEdgeGlowTop, 0.0f, motionEvent.getX() / getWidth());
            z5 = true;
        } else {
            z5 = false;
        }
        if (EdgeEffectCompat.getDistance(this.mEdgeGlowBottom) == 0.0f) {
            return z5;
        }
        EdgeEffectCompat.onPullDistance(this.mEdgeGlowBottom, 0.0f, 1.0f - (motionEvent.getX() / getWidth()));
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        int i6;
        if (this.mScroller.isFinished()) {
            return;
        }
        this.mScroller.computeScrollOffset();
        int currY = this.mScroller.getCurrY();
        int consumeFlingInVerticalStretch = consumeFlingInVerticalStretch(currY - this.mLastScrollerY);
        this.mLastScrollerY = currY;
        int[] iArr = this.mScrollConsumed;
        iArr[1] = 0;
        dispatchNestedPreScroll(0, consumeFlingInVerticalStretch, iArr, null, 1);
        int i7 = consumeFlingInVerticalStretch - this.mScrollConsumed[1];
        int scrollRange = getScrollRange();
        if (i7 != 0) {
            int scrollY = getScrollY();
            overScrollByCompat(0, i7, getScrollX(), scrollY, 0, scrollRange, 0, 0, false);
            i6 = scrollRange;
            int scrollY2 = getScrollY() - scrollY;
            int i8 = i7 - scrollY2;
            int[] iArr2 = this.mScrollConsumed;
            iArr2[1] = 0;
            dispatchNestedScroll(0, scrollY2, 0, i8, this.mScrollOffset, 1, iArr2);
            i7 = i8 - this.mScrollConsumed[1];
        } else {
            i6 = scrollRange;
        }
        if (i7 != 0) {
            int overScrollMode = getOverScrollMode();
            if (overScrollMode == 0 || (overScrollMode == 1 && i6 > 0)) {
                if (i7 < 0) {
                    if (this.mEdgeGlowTop.isFinished()) {
                        this.mEdgeGlowTop.onAbsorb((int) this.mScroller.getCurrVelocity());
                    }
                } else if (this.mEdgeGlowBottom.isFinished()) {
                    this.mEdgeGlowBottom.onAbsorb((int) this.mScroller.getCurrVelocity());
                }
            }
            abortAnimatedScroll();
        }
        if (this.mScroller.isFinished()) {
            stopNestedScroll(1);
        } else {
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f6, float f7, boolean z5) {
        return this.mChildHelper.dispatchNestedFling(f6, f7, z5);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f6, float f7) {
        return this.mChildHelper.dispatchNestedPreFling(f6, f7);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i6, int i7, @Nullable int[] iArr, @Nullable int[] iArr2) {
        return dispatchNestedPreScroll(i6, i7, iArr, iArr2, 0);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedScroll(int i6, int i7, int i8, int i9, @Nullable int[] iArr, int i10) {
        return this.mChildHelper.dispatchNestedScroll(i6, i7, i8, i9, iArr, i10);
    }

    public boolean executeKeyEvent(@NonNull KeyEvent keyEvent) {
        this.mTempRect.setEmpty();
        boolean canScroll = canScroll();
        int i6 = MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE;
        if (!canScroll) {
            if (isFocused() && keyEvent.getKeyCode() != 4) {
                View findFocus = findFocus();
                if (findFocus == this) {
                    findFocus = null;
                }
                View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE);
                if (findNextFocus != null && findNextFocus != this && findNextFocus.requestFocus(MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE)) {
                    return true;
                }
            }
            return false;
        }
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 19) {
                return keyEvent.isAltPressed() ? fullScroll(33) : arrowScroll(33);
            }
            if (keyCode == 20) {
                return keyEvent.isAltPressed() ? fullScroll(MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE) : arrowScroll(MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE);
            }
            if (keyCode == 62) {
                if (keyEvent.isShiftPressed()) {
                    i6 = 33;
                }
                pageScroll(i6);
                return false;
            }
            if (keyCode == 92) {
                return fullScroll(33);
            }
            if (keyCode == 93) {
                return fullScroll(MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE);
            }
            if (keyCode == 122) {
                pageScroll(33);
                return false;
            }
            if (keyCode == 123) {
                pageScroll(MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE);
                return false;
            }
        }
        return false;
    }

    public boolean fullScroll(int i6) {
        int childCount;
        boolean z5 = i6 == 130;
        int height = getHeight();
        Rect rect = this.mTempRect;
        rect.top = 0;
        rect.bottom = height;
        if (z5 && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            this.mTempRect.bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
            Rect rect2 = this.mTempRect;
            rect2.top = rect2.bottom - height;
        }
        Rect rect3 = this.mTempRect;
        return scrollAndFocus(i6, rect3.top, rect3.bottom);
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.mParentHelper.getNestedScrollAxes();
    }

    @VisibleForTesting
    float getVerticalScrollFactorCompat() {
        if (this.mVerticalScrollFactor == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (!context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            this.mVerticalScrollFactor = typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.mVerticalScrollFactor;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return hasNestedScrollingParent(0);
    }

    public boolean isFillViewport() {
        return this.mFillViewport;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.mChildHelper.isNestedScrollingEnabled();
    }

    public boolean isSmoothScrollingEnabled() {
        return this.mSmoothScrollingEnabled;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(@NonNull View view, float f6, float f7, boolean z5) {
        if (z5) {
            return false;
        }
        dispatchNestedFling(0.0f, f7, true);
        fling((int) f7);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(@NonNull View view, int i6, int i7, @NonNull int[] iArr) {
        onNestedPreScroll(view, i6, i7, iArr, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(@NonNull View view, int i6, int i7, int i8, int i9, int i10) {
        onNestedScrollInternal(i9, i10, null);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mSavedState = savedState;
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i6) {
        return onStartNestedScroll(view, view2, i6, 0);
    }

    public boolean pageScroll(int i6) {
        boolean z5 = i6 == 130;
        int height = getHeight();
        if (z5) {
            this.mTempRect.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
                Rect rect = this.mTempRect;
                if (rect.top + height > bottom) {
                    rect.top = bottom - height;
                }
            }
        } else {
            this.mTempRect.top = getScrollY() - height;
            Rect rect2 = this.mTempRect;
            if (rect2.top < 0) {
                rect2.top = 0;
            }
        }
        Rect rect3 = this.mTempRect;
        int i7 = rect3.top;
        int i8 = height + i7;
        rect3.bottom = i8;
        return scrollAndFocus(i6, i7, i8);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (this.mIsLayoutDirty) {
            this.mChildToScrollTo = view2;
        } else {
            scrollToChild(view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z5) {
        if (z5) {
            recycleVelocityTracker();
        }
        super.requestDisallowInterceptTouchEvent(z5);
    }

    public void setFillViewport(boolean z5) {
        if (z5 != this.mFillViewport) {
            this.mFillViewport = z5;
            requestLayout();
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z5) {
        this.mChildHelper.setNestedScrollingEnabled(z5);
    }

    public void setOnScrollChangeListener(@Nullable OnScrollChangeListener onScrollChangeListener) {
        this.mOnScrollChangeListener = onScrollChangeListener;
    }

    public void setSmoothScrollingEnabled(boolean z5) {
        this.mSmoothScrollingEnabled = z5;
    }

    public final void smoothScrollBy(int i6, int i7, int i8) {
        smoothScrollBy(i6, i7, i8, false);
    }

    public final void smoothScrollTo(int i6, int i7, int i8) {
        smoothScrollTo(i6, i7, i8, false);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i6) {
        return startNestedScroll(i6, 0);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        stopNestedScroll(0);
    }

    public NestedScrollView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.mTempRect = new Rect();
        this.mIsLayoutDirty = true;
        this.mIsLaidOut = false;
        this.mChildToScrollTo = null;
        this.mIsBeingDragged = false;
        this.mSmoothScrollingEnabled = true;
        this.mActivePointerId = -1;
        this.mScrollOffset = new int[2];
        this.mScrollConsumed = new int[2];
        DifferentialMotionFlingTargetImpl differentialMotionFlingTargetImpl = new DifferentialMotionFlingTargetImpl();
        this.mDifferentialMotionFlingTarget = differentialMotionFlingTargetImpl;
        this.mDifferentialMotionFlingController = new DifferentialMotionFlingController(getContext(), differentialMotionFlingTargetImpl);
        this.mEdgeGlowTop = EdgeEffectCompat.create(context, attributeSet);
        this.mEdgeGlowBottom = EdgeEffectCompat.create(context, attributeSet);
        this.mPhysicalCoeff = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        initScrollView();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, SCROLLVIEW_STYLEABLE, i6, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.mParentHelper = new NestedScrollingParentHelper(this);
        this.mChildHelper = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        ViewCompat.setAccessibilityDelegate(this, ACCESSIBILITY_DELEGATE);
    }

    private boolean canOverScroll() {
        int overScrollMode = getOverScrollMode();
        if (overScrollMode == 0 || (overScrollMode == 1 && getScrollRange() > 0)) {
            return true;
        }
        return false;
    }

    private boolean canScroll() {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            if (childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom()) {
                return true;
            }
        }
        return false;
    }

    private float getSplineFlingDistance(int i6) {
        double log = Math.log((Math.abs(i6) * INFLEXION) / (this.mPhysicalCoeff * SCROLL_FRICTION));
        float f6 = DECELERATION_RATE;
        return (float) (this.mPhysicalCoeff * SCROLL_FRICTION * Math.exp((f6 / (f6 - 1.0d)) * log));
    }

    private boolean inChild(int i6, int i7) {
        if (getChildCount() > 0) {
            int scrollY = getScrollY();
            View childAt = getChildAt(0);
            if (i7 >= childAt.getTop() - scrollY && i7 < childAt.getBottom() - scrollY && i6 >= childAt.getLeft() && i6 < childAt.getRight()) {
                return true;
            }
        }
        return false;
    }

    private void onNestedScrollInternal(int i6, int i7, @Nullable int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i6);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.mChildHelper.dispatchNestedScroll(0, scrollY2, 0, i6 - scrollY2, null, i7, iArr);
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int i6;
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            if (actionIndex == 0) {
                i6 = 1;
            } else {
                i6 = 0;
            }
            this.mLastMotionY = (int) motionEvent.getY(i6);
            this.mActivePointerId = motionEvent.getPointerId(i6);
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int releaseVerticalGlow(int r4, float r5) {
        /*
            r3 = this;
            int r0 = r3.getWidth()
            float r0 = (float) r0
            float r5 = r5 / r0
            float r4 = (float) r4
            int r0 = r3.getHeight()
            float r0 = (float) r0
            float r4 = r4 / r0
            android.widget.EdgeEffect r0 = r3.mEdgeGlowTop
            float r0 = androidx.core.widget.EdgeEffectCompat.getDistance(r0)
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L31
            android.widget.EdgeEffect r0 = r3.mEdgeGlowTop
            float r4 = -r4
            float r4 = androidx.core.widget.EdgeEffectCompat.onPullDistance(r0, r4, r5)
            float r4 = -r4
            android.widget.EdgeEffect r5 = r3.mEdgeGlowTop
            float r5 = androidx.core.widget.EdgeEffectCompat.getDistance(r5)
            int r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r5 != 0) goto L2f
            android.widget.EdgeEffect r5 = r3.mEdgeGlowTop
            r5.onRelease()
        L2f:
            r1 = r4
            goto L54
        L31:
            android.widget.EdgeEffect r0 = r3.mEdgeGlowBottom
            float r0 = androidx.core.widget.EdgeEffectCompat.getDistance(r0)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L54
            android.widget.EdgeEffect r0 = r3.mEdgeGlowBottom
            r2 = 1065353216(0x3f800000, float:1.0)
            float r2 = r2 - r5
            float r4 = androidx.core.widget.EdgeEffectCompat.onPullDistance(r0, r4, r2)
            android.widget.EdgeEffect r5 = r3.mEdgeGlowBottom
            float r5 = androidx.core.widget.EdgeEffectCompat.getDistance(r5)
            int r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r5 != 0) goto L2f
            android.widget.EdgeEffect r5 = r3.mEdgeGlowBottom
            r5.onRelease()
            goto L2f
        L54:
            int r4 = r3.getHeight()
            float r4 = (float) r4
            float r1 = r1 * r4
            int r4 = java.lang.Math.round(r1)
            if (r4 == 0) goto L64
            r3.invalidate()
        L64:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.releaseVerticalGlow(int, float):int");
    }

    private boolean scrollAndFocus(int i6, int i7, int i8) {
        boolean z5;
        int i9;
        int height = getHeight();
        int scrollY = getScrollY();
        int i10 = height + scrollY;
        boolean z6 = false;
        if (i6 == 33) {
            z5 = true;
        } else {
            z5 = false;
        }
        View findFocusableViewInBounds = findFocusableViewInBounds(z5, i7, i8);
        if (findFocusableViewInBounds == null) {
            findFocusableViewInBounds = this;
        }
        if (i7 < scrollY || i8 > i10) {
            if (z5) {
                i9 = i7 - scrollY;
            } else {
                i9 = i8 - i10;
            }
            scrollBy(i9, 0, 1, true);
            z6 = true;
        }
        if (findFocusableViewInBounds != findFocus()) {
            findFocusableViewInBounds.requestFocus(i6);
        }
        return z6;
    }

    private boolean scrollToChildRect(Rect rect, boolean z5) {
        boolean z6;
        int computeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(rect);
        if (computeScrollDeltaToGetChildRectOnScreen != 0) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z6) {
            if (z5) {
                scrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
                return z6;
            }
            smoothScrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
        }
        return z6;
    }

    private void smoothScrollBy(int i6, int i7, int i8, boolean z5) {
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.mLastScroll > 250) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int height = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            this.mScroller.startScroll(getScrollX(), scrollY, 0, Math.max(0, Math.min(i7 + scrollY, Math.max(0, height - height2))) - scrollY, i8);
            runAnimatedScroll(z5);
        } else {
            if (!this.mScroller.isFinished()) {
                abortAnimatedScroll();
            }
            scrollBy(i6, i7);
        }
        this.mLastScroll = AnimationUtils.currentAnimationTimeMillis();
    }

    public boolean arrowScroll(int i6) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i6);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus != null && isWithinDeltaOfScreen(findNextFocus, maxScrollAmount, getHeight())) {
            findNextFocus.getDrawingRect(this.mTempRect);
            offsetDescendantRectToMyCoords(findNextFocus, this.mTempRect);
            scrollBy(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect), 0, 1, true);
            findNextFocus.requestFocus(i6);
        } else {
            if (i6 == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i6 == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getScrollY() + getHeight()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i6 != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            scrollBy(maxScrollAmount, 0, 1, true);
        }
        if (findFocus != null && findFocus.isFocused() && isOffScreen(findFocus)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    protected int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        int i6;
        int i7;
        int i8;
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i9 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        if (rect.bottom < childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin) {
            i6 = i9 - verticalFadingEdgeLength;
        } else {
            i6 = i9;
        }
        int i10 = rect.bottom;
        if (i10 > i6 && rect.top > scrollY) {
            if (rect.height() > height) {
                i8 = rect.top - scrollY;
            } else {
                i8 = rect.bottom - i6;
            }
            return Math.min(i8, (childAt.getBottom() + layoutParams.bottomMargin) - i9);
        }
        if (rect.top >= scrollY || i10 >= i6) {
            return 0;
        }
        if (rect.height() > height) {
            i7 = 0 - (i6 - rect.bottom);
        } else {
            i7 = 0 - (scrollY - rect.top);
        }
        return Math.max(i7, -getScrollY());
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int max = Math.max(0, bottom - height);
        if (scrollY < 0) {
            return bottom - scrollY;
        }
        if (scrollY > max) {
            return bottom + (scrollY - max);
        }
        return bottom;
    }

    int consumeFlingInVerticalStretch(int i6) {
        int height = getHeight();
        if (i6 > 0 && EdgeEffectCompat.getDistance(this.mEdgeGlowTop) != 0.0f) {
            int round = Math.round(((-height) / FLING_DESTRETCH_FACTOR) * EdgeEffectCompat.onPullDistance(this.mEdgeGlowTop, ((-i6) * FLING_DESTRETCH_FACTOR) / height, 0.5f));
            if (round != i6) {
                this.mEdgeGlowTop.finish();
            }
            return i6 - round;
        }
        if (i6 < 0 && EdgeEffectCompat.getDistance(this.mEdgeGlowBottom) != 0.0f) {
            float f6 = height;
            int round2 = Math.round((f6 / FLING_DESTRETCH_FACTOR) * EdgeEffectCompat.onPullDistance(this.mEdgeGlowBottom, (i6 * FLING_DESTRETCH_FACTOR) / f6, 0.5f));
            if (round2 != i6) {
                this.mEdgeGlowBottom.finish();
            }
            return i6 - round2;
        }
        return i6;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!super.dispatchKeyEvent(keyEvent) && !executeKeyEvent(keyEvent)) {
            return false;
        }
        return true;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i6, int i7, int i8, int i9, @Nullable int[] iArr) {
        return this.mChildHelper.dispatchNestedScroll(i6, i7, i8, i9, iArr);
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        int i6;
        super.draw(canvas);
        int scrollY = getScrollY();
        int i7 = 0;
        if (!this.mEdgeGlowTop.isFinished()) {
            int save = canvas.save();
            int width = getWidth();
            int height = getHeight();
            int min = Math.min(0, scrollY);
            if (Api21Impl.getClipToPadding(this)) {
                width -= getPaddingLeft() + getPaddingRight();
                i6 = getPaddingLeft();
            } else {
                i6 = 0;
            }
            if (Api21Impl.getClipToPadding(this)) {
                height -= getPaddingTop() + getPaddingBottom();
                min += getPaddingTop();
            }
            canvas.translate(i6, min);
            this.mEdgeGlowTop.setSize(width, height);
            if (this.mEdgeGlowTop.draw(canvas)) {
                postInvalidateOnAnimation();
            }
            canvas.restoreToCount(save);
        }
        if (!this.mEdgeGlowBottom.isFinished()) {
            int save2 = canvas.save();
            int width2 = getWidth();
            int height2 = getHeight();
            int max = Math.max(getScrollRange(), scrollY) + height2;
            if (Api21Impl.getClipToPadding(this)) {
                width2 -= getPaddingLeft() + getPaddingRight();
                i7 = getPaddingLeft();
            }
            if (Api21Impl.getClipToPadding(this)) {
                height2 -= getPaddingTop() + getPaddingBottom();
                max -= getPaddingBottom();
            }
            canvas.translate(i7 - width2, max);
            canvas.rotate(180.0f, width2, 0.0f);
            this.mEdgeGlowBottom.setSize(width2, height2);
            if (this.mEdgeGlowBottom.draw(canvas)) {
                postInvalidateOnAnimation();
            }
            canvas.restoreToCount(save2);
        }
    }

    public void fling(int i6) {
        if (getChildCount() > 0) {
            this.mScroller.fling(getScrollX(), getScrollY(), 0, i6, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            runAnimatedScroll(true);
        }
    }

    @Override // android.view.View
    protected float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + layoutParams.bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * 0.5f);
    }

    int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    @Override // android.view.View
    protected float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    @Override // android.view.ViewGroup
    protected void measureChild(@NonNull View view, int i6, int i7) {
        view.measure(ViewGroup.getChildMeasureSpec(i6, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    protected void measureChildWithMargins(View view, int i6, int i7, int i8, int i9) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i6, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i7, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mIsLaidOut = false;
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(@NonNull MotionEvent motionEvent) {
        int i6;
        float f6;
        int i7;
        if (motionEvent.getAction() == 8 && !this.mIsBeingDragged) {
            if (MotionEventCompat.isFromSource(motionEvent, 2)) {
                i6 = 9;
                f6 = motionEvent.getAxisValue(9);
                i7 = (int) motionEvent.getX();
            } else if (MotionEventCompat.isFromSource(motionEvent, 4194304)) {
                f6 = motionEvent.getAxisValue(26);
                i7 = getWidth() / 2;
                i6 = 26;
            } else {
                i6 = 0;
                f6 = 0.0f;
                i7 = 0;
            }
            if (f6 != 0.0f) {
                scrollBy(-((int) (f6 * getVerticalScrollFactorCompat())), i7, 1, MotionEventCompat.isFromSource(motionEvent, 8194));
                if (i6 != 0) {
                    this.mDifferentialMotionFlingController.onMotionEvent(motionEvent, i6);
                }
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NonNull MotionEvent motionEvent) {
        int findPointerIndex;
        int action = motionEvent.getAction();
        boolean z5 = true;
        if (action == 2 && this.mIsBeingDragged) {
            return true;
        }
        int i6 = action & 255;
        if (i6 != 0) {
            if (i6 != 1) {
                if (i6 != 2) {
                    if (i6 != 3) {
                        if (i6 == 6) {
                            onSecondaryPointerUp(motionEvent);
                        }
                    }
                } else {
                    int i7 = this.mActivePointerId;
                    if (i7 != -1 && (findPointerIndex = motionEvent.findPointerIndex(i7)) != -1) {
                        int y5 = (int) motionEvent.getY(findPointerIndex);
                        if (Math.abs(y5 - this.mLastMotionY) > this.mTouchSlop && (2 & getNestedScrollAxes()) == 0) {
                            this.mIsBeingDragged = true;
                            this.mLastMotionY = y5;
                            initVelocityTrackerIfNotExists();
                            this.mVelocityTracker.addMovement(motionEvent);
                            this.mNestedYOffset = 0;
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                    }
                }
            }
            this.mIsBeingDragged = false;
            this.mActivePointerId = -1;
            recycleVelocityTracker();
            if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                postInvalidateOnAnimation();
            }
            stopNestedScroll(0);
        } else {
            int y6 = (int) motionEvent.getY();
            if (!inChild((int) motionEvent.getX(), y6)) {
                if (!stopGlowAnimations(motionEvent) && this.mScroller.isFinished()) {
                    z5 = false;
                }
                this.mIsBeingDragged = z5;
                recycleVelocityTracker();
            } else {
                this.mLastMotionY = y6;
                this.mActivePointerId = motionEvent.getPointerId(0);
                initOrResetVelocityTracker();
                this.mVelocityTracker.addMovement(motionEvent);
                this.mScroller.computeScrollOffset();
                if (!stopGlowAnimations(motionEvent) && this.mScroller.isFinished()) {
                    z5 = false;
                }
                this.mIsBeingDragged = z5;
                startNestedScroll(2, 0);
            }
        }
        return this.mIsBeingDragged;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        super.onLayout(z5, i6, i7, i8, i9);
        int i10 = 0;
        this.mIsLayoutDirty = false;
        View view = this.mChildToScrollTo;
        if (view != null && isViewDescendantOf(view, this)) {
            scrollToChild(this.mChildToScrollTo);
        }
        this.mChildToScrollTo = null;
        if (!this.mIsLaidOut) {
            if (this.mSavedState != null) {
                scrollTo(getScrollX(), this.mSavedState.scrollPosition);
                this.mSavedState = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                i10 = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            }
            int paddingTop = ((i9 - i7) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int clamp = clamp(scrollY, paddingTop, i10);
            if (clamp != scrollY) {
                scrollTo(getScrollX(), clamp);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.mIsLaidOut = true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i6, int i7) {
        super.onMeasure(i6, i7);
        if (this.mFillViewport && View.MeasureSpec.getMode(i7) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(ViewGroup.getChildMeasureSpec(i6, getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(@NonNull View view, float f6, float f7) {
        return dispatchNestedPreFling(f6, f7);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(@NonNull View view, int i6, int i7, int i8, int i9) {
        onNestedScrollInternal(i9, 0, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i6) {
        onNestedScrollAccepted(view, view2, i6, 0);
    }

    @Override // android.view.View
    protected void onOverScrolled(int i6, int i7, boolean z5, boolean z6) {
        super.scrollTo(i6, i7);
    }

    @Override // android.view.View
    @NonNull
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.scrollPosition = getScrollY();
        return savedState;
    }

    @Override // android.view.View
    protected void onScrollChanged(int i6, int i7, int i8, int i9) {
        super.onScrollChanged(i6, i7, i8, i9);
        OnScrollChangeListener onScrollChangeListener = this.mOnScrollChangeListener;
        if (onScrollChangeListener != null) {
            onScrollChangeListener.onScrollChange(this, i6, i7, i8, i9);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        View findFocus = findFocus();
        if (findFocus != null && this != findFocus && isWithinDeltaOfScreen(findFocus, 0, i9)) {
            findFocus.getDrawingRect(this.mTempRect);
            offsetDescendantRectToMyCoords(findFocus, this.mTempRect);
            doScrollY(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(@NonNull View view) {
        onStopNestedScroll(view, 0);
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        ViewParent parent;
        initVelocityTrackerIfNotExists();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.mNestedYOffset = 0;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(0.0f, this.mNestedYOffset);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked != 5) {
                            if (actionMasked == 6) {
                                onSecondaryPointerUp(motionEvent);
                                this.mLastMotionY = (int) motionEvent.getY(motionEvent.findPointerIndex(this.mActivePointerId));
                            }
                        } else {
                            int actionIndex = motionEvent.getActionIndex();
                            this.mLastMotionY = (int) motionEvent.getY(actionIndex);
                            this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                        }
                    } else {
                        if (this.mIsBeingDragged && getChildCount() > 0 && this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                            postInvalidateOnAnimation();
                        }
                        endTouchDrag();
                    }
                } else {
                    int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                    if (findPointerIndex != -1) {
                        int y5 = (int) motionEvent.getY(findPointerIndex);
                        int i6 = this.mLastMotionY - y5;
                        int releaseVerticalGlow = i6 - releaseVerticalGlow(i6, motionEvent.getX(findPointerIndex));
                        if (!this.mIsBeingDragged && Math.abs(releaseVerticalGlow) > this.mTouchSlop) {
                            ViewParent parent2 = getParent();
                            if (parent2 != null) {
                                parent2.requestDisallowInterceptTouchEvent(true);
                            }
                            this.mIsBeingDragged = true;
                            releaseVerticalGlow = releaseVerticalGlow > 0 ? releaseVerticalGlow - this.mTouchSlop : releaseVerticalGlow + this.mTouchSlop;
                        }
                        if (this.mIsBeingDragged) {
                            int scrollBy = scrollBy(releaseVerticalGlow, (int) motionEvent.getX(findPointerIndex), 0, false);
                            this.mLastMotionY = y5 - scrollBy;
                            this.mNestedYOffset += scrollBy;
                        }
                    }
                }
            } else {
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                int yVelocity = (int) velocityTracker.getYVelocity(this.mActivePointerId);
                if (Math.abs(yVelocity) >= this.mMinimumVelocity) {
                    if (!edgeEffectFling(yVelocity)) {
                        int i7 = -yVelocity;
                        float f6 = i7;
                        if (!dispatchNestedPreFling(0.0f, f6)) {
                            dispatchNestedFling(0.0f, f6, true);
                            fling(i7);
                        }
                    }
                } else if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    postInvalidateOnAnimation();
                }
                endTouchDrag();
            }
        } else {
            if (getChildCount() == 0) {
                return false;
            }
            if (this.mIsBeingDragged && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (!this.mScroller.isFinished()) {
                abortAnimatedScroll();
            }
            initializeTouchDrag((int) motionEvent.getY(), motionEvent.getPointerId(0));
        }
        VelocityTracker velocityTracker2 = this.mVelocityTracker;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0084 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    boolean overScrollByCompat(int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19, boolean r20) {
        /*
            r11 = this;
            int r0 = r11.getOverScrollMode()
            int r1 = r11.computeHorizontalScrollRange()
            int r2 = r11.computeHorizontalScrollExtent()
            r3 = 0
            r4 = 1
            if (r1 <= r2) goto L12
            r1 = 1
            goto L13
        L12:
            r1 = 0
        L13:
            int r2 = r11.computeVerticalScrollRange()
            int r5 = r11.computeVerticalScrollExtent()
            if (r2 <= r5) goto L1f
            r2 = 1
            goto L20
        L1f:
            r2 = 0
        L20:
            if (r0 == 0) goto L29
            if (r0 != r4) goto L27
            if (r1 == 0) goto L27
            goto L29
        L27:
            r1 = 0
            goto L2a
        L29:
            r1 = 1
        L2a:
            if (r0 == 0) goto L33
            if (r0 != r4) goto L31
            if (r2 == 0) goto L31
            goto L33
        L31:
            r0 = 0
            goto L34
        L33:
            r0 = 1
        L34:
            int r2 = r14 + r12
            if (r1 != 0) goto L3a
            r1 = 0
            goto L3c
        L3a:
            r1 = r18
        L3c:
            int r5 = r15 + r13
            if (r0 != 0) goto L42
            r0 = 0
            goto L44
        L42:
            r0 = r19
        L44:
            int r6 = -r1
            int r1 = r1 + r16
            int r7 = -r0
            int r0 = r0 + r17
            if (r2 <= r1) goto L4f
            r2 = r1
        L4d:
            r1 = 1
            goto L54
        L4f:
            if (r2 >= r6) goto L53
            r2 = r6
            goto L4d
        L53:
            r1 = 0
        L54:
            if (r5 <= r0) goto L59
            r5 = r0
        L57:
            r0 = 1
            goto L5e
        L59:
            if (r5 >= r7) goto L5d
            r5 = r7
            goto L57
        L5d:
            r0 = 0
        L5e:
            if (r0 == 0) goto L7e
            boolean r6 = r11.hasNestedScrollingParent(r4)
            if (r6 != 0) goto L7e
            android.widget.OverScroller r6 = r11.mScroller
            r7 = 0
            int r8 = r11.getScrollRange()
            r9 = 0
            r10 = 0
            r13 = r2
            r14 = r5
            r12 = r6
            r18 = r8
            r15 = 0
            r16 = 0
            r17 = 0
            r12.springBack(r13, r14, r15, r16, r17, r18)
            r6 = r13
            goto L7f
        L7e:
            r6 = r2
        L7f:
            r11.onOverScrolled(r6, r5, r1, r0)
            if (r1 != 0) goto L88
            if (r0 == 0) goto L87
            goto L88
        L87:
            return r3
        L88:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.overScrollByCompat(int, int, int, int, int, int, int, int, boolean):boolean");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(@NonNull View view, Rect rect, boolean z5) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return scrollToChildRect(rect, z5);
    }

    @Override // android.view.View
    public void scrollTo(int i6, int i7) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int width2 = childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int height2 = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int clamp = clamp(i6, width, width2);
            int clamp2 = clamp(i7, height, height2);
            if (clamp != getScrollX() || clamp2 != getScrollY()) {
                super.scrollTo(clamp, clamp2);
            }
        }
    }

    void smoothScrollTo(int i6, int i7, boolean z5) {
        smoothScrollTo(i6, i7, 250, z5);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i6) {
        if (getChildCount() <= 0) {
            super.addView(view, i6);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    void smoothScrollTo(int i6, int i7, int i8, boolean z5) {
        smoothScrollBy(i6 - getScrollX(), i7 - getScrollY(), i8, z5);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i6, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i6, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }
}
