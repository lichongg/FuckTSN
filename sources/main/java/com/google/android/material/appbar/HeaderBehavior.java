package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {
    private static final int INVALID_POINTER = -1;
    private int activePointerId;

    @Nullable
    private Runnable flingRunnable;
    private boolean isBeingDragged;
    private int lastMotionY;
    OverScroller scroller;
    private int touchSlop;

    @Nullable
    private VelocityTracker velocityTracker;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class FlingRunnable implements Runnable {
        private final V layout;
        private final CoordinatorLayout parent;

        FlingRunnable(CoordinatorLayout coordinatorLayout, V v5) {
            this.parent = coordinatorLayout;
            this.layout = v5;
        }

        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            if (this.layout == null || (overScroller = HeaderBehavior.this.scroller) == null) {
                return;
            }
            if (!overScroller.computeScrollOffset()) {
                HeaderBehavior.this.onFlingFinished(this.parent, this.layout);
                return;
            }
            HeaderBehavior headerBehavior = HeaderBehavior.this;
            headerBehavior.setHeaderTopBottomOffset(this.parent, this.layout, headerBehavior.scroller.getCurrY());
            ViewCompat.postOnAnimation(this.layout, this);
        }
    }

    public HeaderBehavior() {
        this.activePointerId = -1;
        this.touchSlop = -1;
    }

    boolean canDragView(V v5) {
        return false;
    }

    int setHeaderTopBottomOffset(CoordinatorLayout coordinatorLayout, V v5, int i6) {
        return setHeaderTopBottomOffset(coordinatorLayout, v5, i6, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private void ensureVelocityTracker() {
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
    }

    final boolean fling(CoordinatorLayout coordinatorLayout, @NonNull V v5, int i6, int i7, float f6) {
        Runnable runnable = this.flingRunnable;
        if (runnable != null) {
            v5.removeCallbacks(runnable);
            this.flingRunnable = null;
        }
        if (this.scroller == null) {
            this.scroller = new OverScroller(v5.getContext());
        }
        this.scroller.fling(0, getTopAndBottomOffset(), 0, Math.round(f6), 0, 0, i6, i7);
        if (!this.scroller.computeScrollOffset()) {
            onFlingFinished(coordinatorLayout, v5);
            return false;
        }
        FlingRunnable flingRunnable = new FlingRunnable(coordinatorLayout, v5);
        this.flingRunnable = flingRunnable;
        ViewCompat.postOnAnimation(v5, flingRunnable);
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v5, @NonNull MotionEvent motionEvent) {
        int findPointerIndex;
        if (this.touchSlop < 0) {
            this.touchSlop = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.isBeingDragged) {
            int i6 = this.activePointerId;
            if (i6 == -1 || (findPointerIndex = motionEvent.findPointerIndex(i6)) == -1) {
                return false;
            }
            int y5 = (int) motionEvent.getY(findPointerIndex);
            if (Math.abs(y5 - this.lastMotionY) > this.touchSlop) {
                this.lastMotionY = y5;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.activePointerId = -1;
            int x5 = (int) motionEvent.getX();
            int y6 = (int) motionEvent.getY();
            boolean z5 = canDragView(v5) && coordinatorLayout.isPointInChildBounds(v5, x5, y6);
            this.isBeingDragged = z5;
            if (z5) {
                this.lastMotionY = y6;
                this.activePointerId = motionEvent.getPointerId(0);
                ensureVelocityTracker();
                OverScroller overScroller = this.scroller;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.scroller.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return false;
    }

    int setHeaderTopBottomOffset(CoordinatorLayout coordinatorLayout, V v5, int i6, int i7, int i8) {
        int clamp;
        int topAndBottomOffset = getTopAndBottomOffset();
        if (i7 == 0 || topAndBottomOffset < i7 || topAndBottomOffset > i8 || topAndBottomOffset == (clamp = MathUtils.clamp(i6, i7, i8))) {
            return 0;
        }
        setTopAndBottomOffset(clamp);
        return topAndBottomOffset - clamp;
    }

    int getMaxDragOffset(@NonNull V v5) {
        return -v5.getHeight();
    }

    int getScrollRangeForDragFling(@NonNull V v5) {
        return v5.getHeight();
    }

    int getTopBottomOffsetForScrollingSibling() {
        return getTopAndBottomOffset();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007a  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout r10, @androidx.annotation.NonNull V r11, @androidx.annotation.NonNull android.view.MotionEvent r12) {
        /*
            r9 = this;
            int r1 = r12.getActionMasked()
            r6 = -1
            r7 = 0
            r8 = 1
            if (r1 == r8) goto L4d
            r3 = 2
            if (r1 == r3) goto L2d
            r2 = 3
            if (r1 == r2) goto L71
            r2 = 6
            if (r1 == r2) goto L13
            goto L4b
        L13:
            int r1 = r12.getActionIndex()
            if (r1 != 0) goto L1b
            r1 = 1
            goto L1c
        L1b:
            r1 = 0
        L1c:
            int r2 = r12.getPointerId(r1)
            r9.activePointerId = r2
            float r1 = r12.getY(r1)
            r2 = 1056964608(0x3f000000, float:0.5)
            float r1 = r1 + r2
            int r1 = (int) r1
            r9.lastMotionY = r1
            goto L4b
        L2d:
            int r1 = r9.activePointerId
            int r1 = r12.findPointerIndex(r1)
            if (r1 != r6) goto L36
            return r7
        L36:
            float r1 = r12.getY(r1)
            int r1 = (int) r1
            int r3 = r9.lastMotionY
            int r3 = r3 - r1
            r9.lastMotionY = r1
            int r4 = r9.getMaxDragOffset(r11)
            r5 = 0
            r0 = r9
            r1 = r10
            r2 = r11
            r0.scroll(r1, r2, r3, r4, r5)
        L4b:
            r1 = 0
            goto L80
        L4d:
            android.view.VelocityTracker r1 = r9.velocityTracker
            if (r1 == 0) goto L71
            r1.addMovement(r12)
            android.view.VelocityTracker r1 = r9.velocityTracker
            r3 = 1000(0x3e8, float:1.401E-42)
            r1.computeCurrentVelocity(r3)
            android.view.VelocityTracker r1 = r9.velocityTracker
            int r3 = r9.activePointerId
            float r5 = r1.getYVelocity(r3)
            int r1 = r9.getScrollRangeForDragFling(r11)
            int r3 = -r1
            r4 = 0
            r0 = r9
            r1 = r10
            r2 = r11
            r0.fling(r1, r2, r3, r4, r5)
            r1 = 1
            goto L72
        L71:
            r1 = 0
        L72:
            r9.isBeingDragged = r7
            r9.activePointerId = r6
            android.view.VelocityTracker r2 = r9.velocityTracker
            if (r2 == 0) goto L80
            r2.recycle()
            r2 = 0
            r9.velocityTracker = r2
        L80:
            android.view.VelocityTracker r2 = r9.velocityTracker
            if (r2 == 0) goto L87
            r2.addMovement(r12)
        L87:
            boolean r2 = r9.isBeingDragged
            if (r2 != 0) goto L8f
            if (r1 == 0) goto L8e
            goto L8f
        L8e:
            return r7
        L8f:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.HeaderBehavior.onTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    final int scroll(CoordinatorLayout coordinatorLayout, V v5, int i6, int i7, int i8) {
        return setHeaderTopBottomOffset(coordinatorLayout, v5, getTopBottomOffsetForScrollingSibling() - i6, i7, i8);
    }

    public HeaderBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.activePointerId = -1;
        this.touchSlop = -1;
    }

    void onFlingFinished(CoordinatorLayout coordinatorLayout, V v5) {
    }
}
