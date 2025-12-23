package com.bxkj.student.common.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.activity.k;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import com.bxkj.student.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class SlideDetailsLayout extends ViewGroup {
    private static final int DEFAULT_DURATION = 300;
    private static final float DEFAULT_PERCENT = 0.2f;
    private boolean isFirstShowBehindView;
    private View mBehindView;
    private int mDefaultPanel;
    private long mDuration;
    private View mFrontView;
    private float mInitMotionX;
    private float mInitMotionY;
    private OnSlideDetailsListener mOnSlideDetailsListener;
    private float mPercent;
    private float mSlideOffset;
    private Status mStatus;
    private View mTarget;
    private float mTouchSlop;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface OnSlideDetailsListener {
        void onStatucChanged(Status status);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.bxkj.student.common.view.SlideDetailsLayout.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
        private float offset;
        private int status;

        public SavedState(Parcel source) {
            super(source);
            this.offset = source.readFloat();
            this.status = source.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeFloat(this.offset);
            out.writeInt(this.status);
        }

        public SavedState(Parcelable superState) {
            super(superState);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum Status {
        CLOSE,
        OPEN;

        public static Status valueOf(int stats) {
            return stats == 0 ? CLOSE : 1 == stats ? OPEN : CLOSE;
        }
    }

    public SlideDetailsLayout(Context context) {
        this(context, null);
    }

    private void animatorSwitch(final float start, final float end) {
        animatorSwitch(start, end, true, this.mDuration);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new ViewGroup.MarginLayoutParams(getContext(), attrs);
    }

    public SlideDetailsLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    private void animatorSwitch(final float start, final float end, final long duration) {
        animatorSwitch(start, end, true, duration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkAndFirstOpenPanel() {
        if (this.isFirstShowBehindView) {
            this.isFirstShowBehindView = false;
            this.mBehindView.setVisibility(0);
        }
    }

    private void ensureTarget() {
        if (this.mStatus == Status.CLOSE) {
            this.mTarget = this.mFrontView;
        } else {
            this.mTarget = this.mBehindView;
        }
    }

    protected boolean canChildScrollVertically(int direction) {
        View view = this.mTarget;
        if (view instanceof AbsListView) {
            return canListViewSroll((AbsListView) view);
        }
        if ((view instanceof FrameLayout) || (view instanceof RelativeLayout) || (view instanceof LinearLayout)) {
            for (int i6 = 0; i6 < ((ViewGroup) this.mTarget).getChildCount(); i6++) {
                View childAt = ((ViewGroup) this.mTarget).getChildAt(i6);
                if (childAt instanceof AbsListView) {
                    return canListViewSroll((AbsListView) childAt);
                }
            }
        }
        return ViewCompat.canScrollVertically(this.mTarget, -direction);
    }

    protected boolean canListViewSroll(AbsListView absListView) {
        int i6;
        if (this.mStatus == Status.OPEN) {
            return absListView.getChildCount() > 0 && (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop());
        }
        int childCount = absListView.getChildCount();
        return childCount > 0 && (absListView.getLastVisiblePosition() < (i6 = childCount - 1) || absListView.getChildAt(i6).getBottom() > absListView.getMeasuredHeight());
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p5) {
        return new ViewGroup.MarginLayoutParams(p5);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l6, int t5, int r5, int b6) {
        int i6;
        int i7;
        int i8 = (int) this.mSlideOffset;
        for (int i9 = 0; i9 < getChildCount(); i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                if (childAt == this.mBehindView) {
                    i6 = b6 + i8;
                    i7 = (i6 + b6) - t5;
                } else {
                    i6 = t5 + i8;
                    i7 = b6 + i8;
                }
                childAt.layout(l6, i6, r5, i7);
            }
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable state) {
        SavedState savedState = (SavedState) state;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mSlideOffset = savedState.offset;
        Status valueOf = Status.valueOf(savedState.status);
        this.mStatus = valueOf;
        if (valueOf == Status.OPEN) {
            this.mBehindView.setVisibility(0);
        }
        requestLayout();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.offset = this.mSlideOffset;
        savedState.status = this.mStatus.ordinal();
        return savedState;
    }

    public void setOnSlideDetailsListener(OnSlideDetailsListener listener) {
        this.mOnSlideDetailsListener = listener;
    }

    public void setPercent(float percent) {
        this.mPercent = percent;
    }

    public void smoothClose(boolean smooth) {
        Status status = this.mStatus;
        Status status2 = Status.CLOSE;
        if (status != status2) {
            this.mStatus = status2;
            animatorSwitch(-getMeasuredHeight(), 0.0f, true, smooth ? this.mDuration : 0L);
        }
    }

    public void smoothOpen(boolean smooth) {
        Status status = this.mStatus;
        Status status2 = Status.OPEN;
        if (status != status2) {
            this.mStatus = status2;
            animatorSwitch(0.0f, -getMeasuredHeight(), true, smooth ? this.mDuration : 0L);
        }
    }

    public SlideDetailsLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mStatus = Status.CLOSE;
        this.isFirstShowBehindView = true;
        this.mPercent = 0.2f;
        this.mDuration = 300L;
        this.mDefaultPanel = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.SlideDetailsLayout, defStyleAttr, 0);
        this.mPercent = obtainStyledAttributes.getFloat(2, 0.2f);
        this.mDuration = obtainStyledAttributes.getInt(1, 300);
        this.mDefaultPanel = obtainStyledAttributes.getInt(0, 0);
        obtainStyledAttributes.recycle();
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    private void animatorSwitch(final float start, final float end, final boolean changed) {
        animatorSwitch(start, end, changed, this.mDuration);
    }

    private void finishTouchEvent() {
        float measuredHeight = getMeasuredHeight();
        int i6 = (int) (this.mPercent * measuredHeight);
        float f6 = this.mSlideOffset;
        Status status = Status.CLOSE;
        Status status2 = this.mStatus;
        boolean z5 = true;
        if (status == status2) {
            if (f6 <= (-i6)) {
                this.mSlideOffset = -r0;
                this.mStatus = Status.OPEN;
            } else {
                this.mSlideOffset = 0.0f;
                z5 = false;
            }
        } else {
            if (Status.OPEN == status2) {
                if (measuredHeight + f6 >= i6) {
                    this.mSlideOffset = 0.0f;
                    this.mStatus = status;
                } else {
                    this.mSlideOffset = -r0;
                }
            }
            z5 = false;
        }
        animatorSwitch(f6, this.mSlideOffset, z5);
    }

    private void processTouchEvent(final float offset) {
        if (Math.abs(offset) >= this.mTouchSlop) {
            float f6 = this.mSlideOffset;
            Status status = this.mStatus;
            if (status == Status.CLOSE) {
                if (offset >= 0.0f) {
                    this.mSlideOffset = 0.0f;
                } else {
                    this.mSlideOffset = offset;
                }
                if (this.mSlideOffset == f6) {
                    return;
                }
            } else if (status == Status.OPEN) {
                float f7 = -getMeasuredHeight();
                if (offset <= 0.0f) {
                    this.mSlideOffset = f7;
                } else {
                    this.mSlideOffset = f7 + offset;
                }
                if (this.mSlideOffset == f6) {
                    return;
                }
            }
            requestLayout();
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (1 < getChildCount()) {
            this.mFrontView = getChildAt(0);
            this.mBehindView = getChildAt(1);
            if (this.mDefaultPanel == 1) {
                post(new Runnable() { // from class: com.bxkj.student.common.view.SlideDetailsLayout.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SlideDetailsLayout.this.smoothOpen(false);
                    }
                });
                return;
            }
            return;
        }
        throw new RuntimeException("SlideDetailsLayout only accept childs more than 1!!");
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Status status;
        ensureTarget();
        if (this.mTarget == null || !isEnabled()) {
            return false;
        }
        int actionMasked = MotionEventCompat.getActionMasked(ev);
        if (actionMasked != 0) {
            if (actionMasked != 1 && actionMasked == 2) {
                float x5 = ev.getX();
                float y5 = ev.getY();
                float f6 = x5 - this.mInitMotionX;
                float f7 = y5 - this.mInitMotionY;
                if (canChildScrollVertically((int) f7)) {
                    return false;
                }
                float abs = Math.abs(f6);
                float abs2 = Math.abs(f7);
                if (abs2 > this.mTouchSlop && abs2 >= abs && (((status = this.mStatus) != Status.CLOSE || f7 <= 0.0f) && (status != Status.OPEN || f7 >= 0.0f))) {
                    return true;
                }
            }
            return false;
        }
        this.mInitMotionX = ev.getX();
        this.mInitMotionY = ev.getY();
        return false;
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(size2, 1073741824);
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, makeMeasureSpec, makeMeasureSpec2);
            }
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        ensureTarget();
        if (this.mTarget == null || !isEnabled()) {
            return false;
        }
        int actionMasked = MotionEventCompat.getActionMasked(ev);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        return true;
                    }
                } else {
                    float y5 = ev.getY() - this.mInitMotionY;
                    if (canChildScrollVertically((int) y5)) {
                        return false;
                    }
                    processTouchEvent(y5);
                    return true;
                }
            }
            finishTouchEvent();
            return false;
        }
        k.a(this.mTarget);
        return true;
    }

    private void animatorSwitch(final float start, final float end, final boolean changed, final long duration) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(start, end);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bxkj.student.common.view.SlideDetailsLayout.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator animation) {
                SlideDetailsLayout.this.mSlideOffset = ((Float) animation.getAnimatedValue()).floatValue();
                SlideDetailsLayout.this.requestLayout();
            }
        });
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bxkj.student.common.view.SlideDetailsLayout.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                if (changed) {
                    if (SlideDetailsLayout.this.mStatus == Status.OPEN) {
                        SlideDetailsLayout.this.checkAndFirstOpenPanel();
                    }
                    if (SlideDetailsLayout.this.mOnSlideDetailsListener != null) {
                        SlideDetailsLayout.this.mOnSlideDetailsListener.onStatucChanged(SlideDetailsLayout.this.mStatus);
                    }
                }
            }
        });
        ofFloat.setDuration(duration);
        ofFloat.start();
    }
}
