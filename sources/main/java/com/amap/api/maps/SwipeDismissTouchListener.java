package com.amap.api.maps;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class SwipeDismissTouchListener implements View.OnTouchListener {
    public static final int A_HALF = 2;
    public static final int MIN_VIEW_WIDTH = 2;
    public static final int ONE_THIRD = 3;
    private long mAnimationTime;
    private DismissCallbacks mCallbacks;
    private boolean mCanFinish;
    private float mDownX;
    private float mDownY;
    private int mMaxFlingVelocity;
    private int mMinFlingVelocity;
    private boolean mO;
    private int mSlop;
    private boolean mSwiping;
    private int mSwipingSlop;
    private Object mToken;
    private float mTranslationX;
    private VelocityTracker mVelocityTracker;
    private View mView;
    private int mViewWidth = 1;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface DismissCallbacks {
        boolean canDismiss(Object obj);

        void onDismiss(View view, Object obj);

        void onNotifySwipe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.mCallbacks.onDismiss(this.mView, this.mToken);
        final ViewGroup.LayoutParams layoutParams = this.mView.getLayoutParams();
        final int height = this.mView.getHeight();
        ValueAnimator duration = ValueAnimator.ofInt(height, 1).setDuration(this.mAnimationTime);
        duration.addListener(new AnimatorListenerAdapter() { // from class: com.amap.api.maps.SwipeDismissTouchListener.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                SwipeDismissTouchListener.this.mView.setAlpha(0.0f);
                SwipeDismissTouchListener.this.mView.setTranslationX(0.0f);
                layoutParams.height = height;
                SwipeDismissTouchListener.this.mView.setLayoutParams(layoutParams);
            }
        });
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.amap.api.maps.SwipeDismissTouchListener.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SwipeDismissTouchListener.this.mView.setLayoutParams(layoutParams);
            }
        });
        duration.start();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z5;
        motionEvent.offsetLocation(this.mTranslationX, 0.0f);
        if (this.mViewWidth < 2) {
            this.mViewWidth = this.mView.getWidth();
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.mDownX = motionEvent.getRawX();
            this.mDownY = motionEvent.getRawY();
            if (this.mCallbacks.canDismiss(this.mToken)) {
                this.mO = false;
                VelocityTracker obtain = VelocityTracker.obtain();
                this.mVelocityTracker = obtain;
                obtain.addMovement(motionEvent);
            }
            return true;
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                VelocityTracker velocityTracker = this.mVelocityTracker;
                if (velocityTracker != null) {
                    velocityTracker.addMovement(motionEvent);
                    float rawX = motionEvent.getRawX() - this.mDownX;
                    float rawY = motionEvent.getRawY() - this.mDownY;
                    if (Math.abs(rawX) > this.mSlop && Math.abs(rawY) < Math.abs(rawX) / 2.0f) {
                        this.mSwiping = true;
                        this.mSwipingSlop = rawX > 0.0f ? this.mSlop : -this.mSlop;
                        this.mView.getParent().requestDisallowInterceptTouchEvent(true);
                        if (!this.mO) {
                            this.mO = true;
                            this.mCallbacks.onNotifySwipe();
                        }
                        if (Math.abs(rawX) <= this.mViewWidth / 3) {
                            this.mCanFinish = false;
                        } else if (!this.mCanFinish) {
                            this.mCanFinish = true;
                            this.mCallbacks.onNotifySwipe();
                        }
                        MotionEvent obtain2 = MotionEvent.obtain(motionEvent);
                        obtain2.setAction((motionEvent.getActionIndex() << 8) | 3);
                        this.mView.onTouchEvent(obtain2);
                        obtain2.recycle();
                    }
                    if (this.mSwiping) {
                        this.mTranslationX = rawX;
                        this.mView.setTranslationX(rawX - this.mSwipingSlop);
                        this.mView.setAlpha(Math.max(0.0f, Math.min(1.0f, 1.0f - ((Math.abs(rawX) * 2.0f) / this.mViewWidth))));
                        return true;
                    }
                }
            } else if (actionMasked == 3 && this.mVelocityTracker != null) {
                this.mView.animate().translationX(0.0f).alpha(1.0f).setDuration(this.mAnimationTime).setListener(null);
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
                this.mTranslationX = 0.0f;
                this.mDownX = 0.0f;
                this.mDownY = 0.0f;
                this.mSwiping = false;
            }
        } else if (this.mVelocityTracker != null) {
            float rawX2 = motionEvent.getRawX() - this.mDownX;
            this.mVelocityTracker.addMovement(motionEvent);
            this.mVelocityTracker.computeCurrentVelocity(1000);
            float xVelocity = this.mVelocityTracker.getXVelocity();
            float abs = Math.abs(xVelocity);
            float abs2 = Math.abs(this.mVelocityTracker.getYVelocity());
            if (Math.abs(rawX2) > this.mViewWidth / 2 && this.mSwiping) {
                z5 = rawX2 > 0.0f;
            } else if (this.mMinFlingVelocity > abs || abs > this.mMaxFlingVelocity || abs2 >= abs || !this.mSwiping) {
                z5 = false;
                r3 = false;
            } else {
                r3 = ((xVelocity > 0.0f ? 1 : (xVelocity == 0.0f ? 0 : -1)) < 0) == ((rawX2 > 0.0f ? 1 : (rawX2 == 0.0f ? 0 : -1)) < 0);
                z5 = this.mVelocityTracker.getXVelocity() > 0.0f;
            }
            if (r3) {
                this.mView.animate().translationX(z5 ? this.mViewWidth : -this.mViewWidth).alpha(0.0f).setDuration(50L).setListener(new AnimatorListenerAdapter() { // from class: com.amap.api.maps.SwipeDismissTouchListener.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator animator) {
                        SwipeDismissTouchListener.this.a();
                    }
                });
            } else if (this.mSwiping) {
                this.mView.animate().translationX(0.0f).alpha(1.0f).setDuration(this.mAnimationTime).setListener(null);
            }
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
            this.mTranslationX = 0.0f;
            this.mDownX = 0.0f;
            this.mDownY = 0.0f;
            this.mSwiping = false;
        }
        return false;
    }

    public SwipeDismissTouchListener(View view, Object obj, DismissCallbacks dismissCallbacks) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        this.mSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity() * 16;
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mAnimationTime = view.getContext().getResources().getInteger(R.integer.config_shortAnimTime);
        this.mView = view;
        this.mToken = obj;
        this.mCallbacks = dismissCallbacks;
    }
}
