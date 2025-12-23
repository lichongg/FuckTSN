package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class AutoScrollHelper implements View.OnTouchListener {
    private static final int DEFAULT_ACTIVATION_DELAY = ViewConfiguration.getTapTimeout();
    private static final int DEFAULT_EDGE_TYPE = 1;
    private static final float DEFAULT_MAXIMUM_EDGE = Float.MAX_VALUE;
    private static final int DEFAULT_MAXIMUM_VELOCITY_DIPS = 1575;
    private static final int DEFAULT_MINIMUM_VELOCITY_DIPS = 315;
    private static final int DEFAULT_RAMP_DOWN_DURATION = 500;
    private static final int DEFAULT_RAMP_UP_DURATION = 500;
    private static final float DEFAULT_RELATIVE_EDGE = 0.2f;
    private static final float DEFAULT_RELATIVE_VELOCITY = 1.0f;
    public static final int EDGE_TYPE_INSIDE = 0;
    public static final int EDGE_TYPE_INSIDE_EXTEND = 1;
    public static final int EDGE_TYPE_OUTSIDE = 2;
    private static final int HORIZONTAL = 0;
    public static final float NO_MAX = Float.MAX_VALUE;
    public static final float NO_MIN = 0.0f;
    public static final float RELATIVE_UNSPECIFIED = 0.0f;
    private static final int VERTICAL = 1;
    private int mActivationDelay;
    private boolean mAlreadyDelayed;
    boolean mAnimating;
    private int mEdgeType;
    private boolean mEnabled;
    private boolean mExclusive;
    boolean mNeedsCancel;
    boolean mNeedsReset;
    private Runnable mRunnable;
    final View mTarget;
    final ClampedScroller mScroller = new ClampedScroller();
    private final Interpolator mEdgeInterpolator = new AccelerateInterpolator();
    private float[] mRelativeEdges = {0.0f, 0.0f};
    private float[] mMaximumEdges = {Float.MAX_VALUE, Float.MAX_VALUE};
    private float[] mRelativeVelocity = {0.0f, 0.0f};
    private float[] mMinimumVelocity = {0.0f, 0.0f};
    private float[] mMaximumVelocity = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class ClampedScroller {
        private int mEffectiveRampDown;
        private int mRampDownDuration;
        private int mRampUpDuration;
        private float mStopValue;
        private float mTargetVelocityX;
        private float mTargetVelocityY;
        private long mStartTime = Long.MIN_VALUE;
        private long mStopTime = -1;
        private long mDeltaTime = 0;
        private int mDeltaX = 0;
        private int mDeltaY = 0;

        private float getValueAt(long j6) {
            if (j6 < this.mStartTime) {
                return 0.0f;
            }
            long j7 = this.mStopTime;
            if (j7 < 0 || j6 < j7) {
                return AutoScrollHelper.constrain((j6 - r0) / this.mRampUpDuration, 0.0f, 1.0f) * 0.5f;
            }
            float f6 = this.mStopValue;
            return (1.0f - f6) + (f6 * AutoScrollHelper.constrain((j6 - j7) / this.mEffectiveRampDown, 0.0f, 1.0f));
        }

        private float interpolateValue(float f6) {
            return ((-4.0f) * f6 * f6) + (f6 * 4.0f);
        }

        public void computeScrollDelta() {
            if (this.mDeltaTime == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float interpolateValue = interpolateValue(getValueAt(currentAnimationTimeMillis));
            long j6 = currentAnimationTimeMillis - this.mDeltaTime;
            this.mDeltaTime = currentAnimationTimeMillis;
            float f6 = j6 * interpolateValue;
            this.mDeltaX = (int) (this.mTargetVelocityX * f6);
            this.mDeltaY = (int) (f6 * this.mTargetVelocityY);
        }

        public int getDeltaX() {
            return this.mDeltaX;
        }

        public int getDeltaY() {
            return this.mDeltaY;
        }

        public int getHorizontalDirection() {
            float f6 = this.mTargetVelocityX;
            return (int) (f6 / Math.abs(f6));
        }

        public int getVerticalDirection() {
            float f6 = this.mTargetVelocityY;
            return (int) (f6 / Math.abs(f6));
        }

        public boolean isFinished() {
            return this.mStopTime > 0 && AnimationUtils.currentAnimationTimeMillis() > this.mStopTime + ((long) this.mEffectiveRampDown);
        }

        public void setRampDownDuration(int i6) {
            this.mRampDownDuration = i6;
        }

        public void setRampUpDuration(int i6) {
            this.mRampUpDuration = i6;
        }

        public void setTargetVelocity(float f6, float f7) {
            this.mTargetVelocityX = f6;
            this.mTargetVelocityY = f7;
        }

        ClampedScroller() {
        }

        public void requestStop() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.mEffectiveRampDown = AutoScrollHelper.constrain((int) (currentAnimationTimeMillis - this.mStartTime), 0, this.mRampDownDuration);
            this.mStopValue = getValueAt(currentAnimationTimeMillis);
            this.mStopTime = currentAnimationTimeMillis;
        }

        public void start() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.mStartTime = currentAnimationTimeMillis;
            this.mStopTime = -1L;
            this.mDeltaTime = currentAnimationTimeMillis;
            this.mStopValue = 0.5f;
            this.mDeltaX = 0;
            this.mDeltaY = 0;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class ScrollAnimationRunnable implements Runnable {
        ScrollAnimationRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AutoScrollHelper autoScrollHelper = AutoScrollHelper.this;
            if (autoScrollHelper.mAnimating) {
                if (autoScrollHelper.mNeedsReset) {
                    autoScrollHelper.mNeedsReset = false;
                    autoScrollHelper.mScroller.start();
                }
                ClampedScroller clampedScroller = AutoScrollHelper.this.mScroller;
                if (clampedScroller.isFinished() || !AutoScrollHelper.this.shouldAnimate()) {
                    AutoScrollHelper.this.mAnimating = false;
                    return;
                }
                AutoScrollHelper autoScrollHelper2 = AutoScrollHelper.this;
                if (autoScrollHelper2.mNeedsCancel) {
                    autoScrollHelper2.mNeedsCancel = false;
                    autoScrollHelper2.cancelTargetTouch();
                }
                clampedScroller.computeScrollDelta();
                AutoScrollHelper.this.scrollTargetBy(clampedScroller.getDeltaX(), clampedScroller.getDeltaY());
                ViewCompat.postOnAnimation(AutoScrollHelper.this.mTarget, this);
            }
        }
    }

    static float constrain(float f6, float f7, float f8) {
        return f6 > f8 ? f8 : f6 < f7 ? f7 : f6;
    }

    private float constrainEdgeValue(float f6, float f7) {
        if (f7 == 0.0f) {
            return 0.0f;
        }
        int i6 = this.mEdgeType;
        if (i6 == 0 || i6 == 1) {
            if (f6 < f7) {
                if (f6 >= 0.0f) {
                    return 1.0f - (f6 / f7);
                }
                if (this.mAnimating && i6 == 1) {
                    return 1.0f;
                }
            }
        } else if (i6 == 2 && f6 < 0.0f) {
            return f6 / (-f7);
        }
        return 0.0f;
    }

    public abstract boolean canTargetScrollHorizontally(int i6);

    public abstract boolean canTargetScrollVertically(int i6);

    public abstract void scrollTargetBy(int i6, int i7);

    private float computeTargetVelocity(int i6, float f6, float f7, float f8) {
        float edgeValue = getEdgeValue(this.mRelativeEdges[i6], f7, this.mMaximumEdges[i6], f6);
        if (edgeValue == 0.0f) {
            return 0.0f;
        }
        float f9 = this.mRelativeVelocity[i6];
        float f10 = this.mMinimumVelocity[i6];
        float f11 = this.mMaximumVelocity[i6];
        float f12 = f9 * f8;
        return edgeValue > 0.0f ? constrain(edgeValue * f12, f10, f11) : -constrain((-edgeValue) * f12, f10, f11);
    }

    static int constrain(int i6, int i7, int i8) {
        return i6 > i8 ? i8 : i6 < i7 ? i7 : i6;
    }

    private float getEdgeValue(float f6, float f7, float f8, float f9) {
        float interpolation;
        float constrain = constrain(f6 * f7, 0.0f, f8);
        float constrainEdgeValue = constrainEdgeValue(f7 - f9, constrain) - constrainEdgeValue(f9, constrain);
        if (constrainEdgeValue < 0.0f) {
            interpolation = -this.mEdgeInterpolator.getInterpolation(-constrainEdgeValue);
        } else {
            if (constrainEdgeValue <= 0.0f) {
                return 0.0f;
            }
            interpolation = this.mEdgeInterpolator.getInterpolation(constrainEdgeValue);
        }
        return constrain(interpolation, -1.0f, 1.0f);
    }

    private void requestStop() {
        if (this.mNeedsReset) {
            this.mAnimating = false;
        } else {
            this.mScroller.requestStop();
        }
    }

    private void startAnimating() {
        int i6;
        if (this.mRunnable == null) {
            this.mRunnable = new ScrollAnimationRunnable();
        }
        this.mAnimating = true;
        this.mNeedsReset = true;
        if (this.mAlreadyDelayed || (i6 = this.mActivationDelay) <= 0) {
            this.mRunnable.run();
        } else {
            ViewCompat.postOnAnimationDelayed(this.mTarget, this.mRunnable, i6);
        }
        this.mAlreadyDelayed = true;
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public boolean isExclusive() {
        return this.mExclusive;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0013, code lost:
    
        if (r0 != 3) goto L20;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            boolean r0 = r5.mEnabled
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            int r0 = r7.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L1a
            if (r0 == r2) goto L16
            r3 = 2
            if (r0 == r3) goto L1e
            r6 = 3
            if (r0 == r6) goto L16
            goto L58
        L16:
            r5.requestStop()
            goto L58
        L1a:
            r5.mNeedsCancel = r2
            r5.mAlreadyDelayed = r1
        L1e:
            float r0 = r7.getX()
            int r3 = r6.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r5.mTarget
            int r4 = r4.getWidth()
            float r4 = (float) r4
            float r0 = r5.computeTargetVelocity(r1, r0, r3, r4)
            float r7 = r7.getY()
            int r6 = r6.getHeight()
            float r6 = (float) r6
            android.view.View r3 = r5.mTarget
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r6 = r5.computeTargetVelocity(r2, r7, r6, r3)
            androidx.core.widget.AutoScrollHelper$ClampedScroller r7 = r5.mScroller
            r7.setTargetVelocity(r0, r6)
            boolean r6 = r5.mAnimating
            if (r6 != 0) goto L58
            boolean r6 = r5.shouldAnimate()
            if (r6 == 0) goto L58
            r5.startAnimating()
        L58:
            boolean r6 = r5.mExclusive
            if (r6 == 0) goto L61
            boolean r6 = r5.mAnimating
            if (r6 == 0) goto L61
            return r2
        L61:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.AutoScrollHelper.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    @NonNull
    public AutoScrollHelper setActivationDelay(int i6) {
        this.mActivationDelay = i6;
        return this;
    }

    @NonNull
    public AutoScrollHelper setEdgeType(int i6) {
        this.mEdgeType = i6;
        return this;
    }

    public AutoScrollHelper setEnabled(boolean z5) {
        if (this.mEnabled && !z5) {
            requestStop();
        }
        this.mEnabled = z5;
        return this;
    }

    public AutoScrollHelper setExclusive(boolean z5) {
        this.mExclusive = z5;
        return this;
    }

    @NonNull
    public AutoScrollHelper setMaximumEdges(float f6, float f7) {
        float[] fArr = this.mMaximumEdges;
        fArr[0] = f6;
        fArr[1] = f7;
        return this;
    }

    @NonNull
    public AutoScrollHelper setMaximumVelocity(float f6, float f7) {
        float[] fArr = this.mMaximumVelocity;
        fArr[0] = f6 / 1000.0f;
        fArr[1] = f7 / 1000.0f;
        return this;
    }

    @NonNull
    public AutoScrollHelper setMinimumVelocity(float f6, float f7) {
        float[] fArr = this.mMinimumVelocity;
        fArr[0] = f6 / 1000.0f;
        fArr[1] = f7 / 1000.0f;
        return this;
    }

    @NonNull
    public AutoScrollHelper setRampDownDuration(int i6) {
        this.mScroller.setRampDownDuration(i6);
        return this;
    }

    @NonNull
    public AutoScrollHelper setRampUpDuration(int i6) {
        this.mScroller.setRampUpDuration(i6);
        return this;
    }

    @NonNull
    public AutoScrollHelper setRelativeEdges(float f6, float f7) {
        float[] fArr = this.mRelativeEdges;
        fArr[0] = f6;
        fArr[1] = f7;
        return this;
    }

    @NonNull
    public AutoScrollHelper setRelativeVelocity(float f6, float f7) {
        float[] fArr = this.mRelativeVelocity;
        fArr[0] = f6 / 1000.0f;
        fArr[1] = f7 / 1000.0f;
        return this;
    }

    boolean shouldAnimate() {
        ClampedScroller clampedScroller = this.mScroller;
        int verticalDirection = clampedScroller.getVerticalDirection();
        int horizontalDirection = clampedScroller.getHorizontalDirection();
        if (verticalDirection == 0 || !canTargetScrollVertically(verticalDirection)) {
            return horizontalDirection != 0 && canTargetScrollHorizontally(horizontalDirection);
        }
        return true;
    }

    public AutoScrollHelper(@NonNull View view) {
        this.mTarget = view;
        float f6 = Resources.getSystem().getDisplayMetrics().density;
        float f7 = (int) ((1575.0f * f6) + 0.5f);
        setMaximumVelocity(f7, f7);
        float f8 = (int) ((f6 * 315.0f) + 0.5f);
        setMinimumVelocity(f8, f8);
        setEdgeType(1);
        setMaximumEdges(Float.MAX_VALUE, Float.MAX_VALUE);
        setRelativeEdges(0.2f, 0.2f);
        setRelativeVelocity(1.0f, 1.0f);
        setActivationDelay(DEFAULT_ACTIVATION_DELAY);
        setRampUpDuration(500);
        setRampDownDuration(500);
    }

    void cancelTargetTouch() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.mTarget.onTouchEvent(obtain);
        obtain.recycle();
    }
}
