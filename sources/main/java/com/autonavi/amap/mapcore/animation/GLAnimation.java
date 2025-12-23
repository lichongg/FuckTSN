package com.autonavi.amap.mapcore.animation;

import android.content.Context;
import android.graphics.RectF;
import android.os.Handler;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.amap.api.maps.model.animation.Animation;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class GLAnimation implements Cloneable {
    public static final int ABSOLUTE = 0;
    public static final int INFINITE = -1;
    public static final int RELATIVE_TO_PARENT = 2;
    public static final int RELATIVE_TO_SELF = 1;
    public static final int RESTART = 1;
    public static final int REVERSE = 2;
    public static final int START_ON_FIRST_FRAME = -1;
    public static final int ZORDER_BOTTOM = -1;
    public static final int ZORDER_NORMAL = 0;
    public static final int ZORDER_TOP = 1;
    private int mBackgroundColor;
    Interpolator mInterpolator;
    Animation.AnimationListener mListener;
    private Handler mListenerHandler;
    private Runnable mOnEnd;
    private Runnable mOnStart;
    long mStartOffset;
    private int mZAdjustment;
    boolean mEnded = false;
    boolean mStarted = false;
    boolean mCycleFlip = false;
    boolean mInitialized = false;
    boolean mFillBefore = true;
    boolean mFillAfter = false;
    boolean mFillEnabled = false;
    long mStartTime = -1;
    long mDuration = 500;
    int mRepeatCount = 0;
    int mRepeated = 0;
    int mRepeatMode = 1;
    private float mScaleFactor = 1.0f;
    private boolean mDetachWallpaper = false;
    private boolean mMore = true;
    private boolean mOneMoreTime = true;
    RectF mPreviousRegion = new RectF();
    RectF mRegion = new RectF();
    GLTransformation mPreviousTransformation = new GLTransformation();

    public boolean getTransformation(long j6, GLTransformation gLTransformation) {
        if (this.mStartTime == -1) {
            this.mStartTime = j6;
        }
        long startOffset = getStartOffset();
        long j7 = this.mDuration;
        float f6 = j7 != 0 ? (j6 - (this.mStartTime + startOffset)) / j7 : j6 < this.mStartTime ? 0.0f : 1.0f;
        boolean z5 = f6 >= 1.0f;
        this.mMore = !z5;
        if (!this.mFillEnabled) {
            f6 = Math.max(Math.min(f6, 1.0f), 0.0f);
        }
        if ((f6 >= 0.0f || this.mFillBefore) && (f6 <= 1.0f || this.mFillAfter)) {
            if (!this.mStarted) {
                try {
                    fireAnimationStart();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                this.mStarted = true;
            }
            if (this.mFillEnabled) {
                f6 = Math.max(Math.min(f6, 1.0f), 0.0f);
            }
            if (this.mCycleFlip) {
                f6 = 1.0f - f6;
            }
            applyTransformation(this.mInterpolator.getInterpolation(f6), gLTransformation);
        }
        if (z5) {
            int i6 = this.mRepeatCount;
            int i7 = this.mRepeated;
            if (i6 != i7) {
                if (i6 > 0) {
                    this.mRepeated = i7 + 1;
                }
                if (this.mRepeatMode == 2) {
                    this.mCycleFlip = !this.mCycleFlip;
                }
                this.mStartTime = -1L;
                this.mMore = true;
                fireAnimationRepeat();
            } else if (!this.mEnded) {
                this.mEnded = true;
                fireAnimationEnd();
            }
        }
        boolean z6 = this.mMore;
        if (z6 || !this.mOneMoreTime) {
            return z6;
        }
        this.mOneMoreTime = false;
        return true;
    }

    public boolean hasAlpha() {
        return false;
    }

    public void setInterpolator(Context context, int i6) {
        setInterpolator(AnimationUtils.loadInterpolator(context, i6));
    }

    public boolean willChangeBounds() {
        return true;
    }

    public boolean willChangeTransformationMatrix() {
        return true;
    }

    private void fireAnimationEnd() {
        Animation.AnimationListener animationListener = this.mListener;
        if (animationListener != null) {
            Handler handler = this.mListenerHandler;
            if (handler == null) {
                animationListener.onAnimationEnd();
            } else {
                handler.postAtFrontOfQueue(this.mOnEnd);
            }
        }
    }

    private void fireAnimationStart() {
        Animation.AnimationListener animationListener = this.mListener;
        if (animationListener != null) {
            Handler handler = this.mListenerHandler;
            if (handler == null) {
                animationListener.onAnimationStart();
            } else {
                handler.postAtFrontOfQueue(this.mOnStart);
            }
        }
    }

    public void cancel() {
        if (this.mStarted && !this.mEnded) {
            fireAnimationEnd();
            this.mEnded = true;
        }
        this.mStartTime = Long.MIN_VALUE;
        this.mOneMoreTime = false;
        this.mMore = false;
    }

    @Override // 
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public GLAnimation mo85clone() throws CloneNotSupportedException {
        GLAnimation gLAnimation = (GLAnimation) super.clone();
        gLAnimation.mPreviousRegion = new RectF();
        gLAnimation.mRegion = new RectF();
        gLAnimation.mPreviousTransformation = new GLTransformation();
        return gLAnimation;
    }

    public void detach() {
        if (!this.mStarted || this.mEnded) {
            return;
        }
        this.mEnded = true;
        fireAnimationEnd();
    }

    protected void ensureInterpolator() {
        if (this.mInterpolator == null) {
            this.mInterpolator = new AccelerateDecelerateInterpolator();
        }
    }

    public int getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public boolean getDetachWallpaper() {
        return this.mDetachWallpaper;
    }

    public long getDuration() {
        return this.mDuration;
    }

    public boolean getFillAfter() {
        return this.mFillAfter;
    }

    public boolean getFillBefore() {
        return this.mFillBefore;
    }

    public Interpolator getInterpolator() {
        return this.mInterpolator;
    }

    public int getRepeatCount() {
        return this.mRepeatCount;
    }

    public int getRepeatMode() {
        return this.mRepeatMode;
    }

    protected float getScaleFactor() {
        return this.mScaleFactor;
    }

    public long getStartOffset() {
        return this.mStartOffset;
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public int getZAdjustment() {
        return this.mZAdjustment;
    }

    public boolean hasEnded() {
        return this.mEnded;
    }

    protected boolean hasStarted() {
        return this.mStarted;
    }

    public boolean isFillEnabled() {
        return this.mFillEnabled;
    }

    public boolean isInitialized() {
        return this.mInitialized;
    }

    public void reset() {
        this.mPreviousRegion.setEmpty();
        this.mPreviousTransformation.clear();
        this.mInitialized = false;
        this.mCycleFlip = false;
        this.mRepeated = 0;
        this.mMore = true;
        this.mOneMoreTime = true;
        this.mListenerHandler = null;
    }

    public void restrictDuration(long j6) {
        long j7 = this.mStartOffset;
        if (j7 > j6) {
            this.mStartOffset = j6;
            this.mDuration = 0L;
            this.mRepeatCount = 0;
            return;
        }
        long j8 = this.mDuration + j7;
        if (j8 > j6) {
            this.mDuration = j6 - j7;
            j8 = j6;
        }
        if (this.mDuration <= 0) {
            this.mDuration = 0L;
            this.mRepeatCount = 0;
            return;
        }
        int i6 = this.mRepeatCount;
        if (i6 < 0 || i6 > j6 || i6 * j8 > j6) {
            int i7 = ((int) (j6 / j8)) - 1;
            this.mRepeatCount = i7;
            if (i7 < 0) {
                this.mRepeatCount = 0;
            }
        }
    }

    public void scaleCurrentDuration(float f6) {
        this.mDuration = (long) (this.mDuration * f6);
        this.mStartOffset = (long) (this.mStartOffset * f6);
    }

    public void setAnimationListener(Animation.AnimationListener animationListener) {
        this.mListener = animationListener;
    }

    public void setBackgroundColor(int i6) {
        this.mBackgroundColor = i6;
    }

    public void setDetachWallpaper(boolean z5) {
        this.mDetachWallpaper = z5;
    }

    public void setDuration(long j6) {
        if (j6 < 0) {
            j6 = 0;
        }
        this.mDuration = j6;
    }

    public void setFillAfter(boolean z5) {
        this.mFillAfter = z5;
    }

    public void setFillBefore(boolean z5) {
        this.mFillBefore = z5;
    }

    public void setFillEnabled(boolean z5) {
        this.mFillEnabled = z5;
    }

    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public void setRepeatCount(int i6) {
        if (i6 < 0) {
            i6 = -1;
        }
        this.mRepeatCount = i6;
    }

    public void setRepeatMode(int i6) {
        this.mRepeatMode = i6;
    }

    public void setStartOffset(long j6) {
        this.mStartOffset = j6;
    }

    public void setStartTime(long j6) {
        this.mStartTime = j6;
        this.mEnded = false;
        this.mStarted = false;
        this.mCycleFlip = false;
        this.mRepeated = 0;
        this.mMore = true;
    }

    public void setZAdjustment(int i6) {
        this.mZAdjustment = i6;
    }

    public void start() {
        setStartTime(-1L);
    }

    public GLAnimation() {
        try {
            ensureInterpolator();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public long computeDurationHint() {
        return (getStartOffset() + getDuration()) * (getRepeatCount() + 1);
    }

    public void initialize() {
        reset();
        this.mInitialized = true;
    }

    public void startNow() {
        setStartTime(AnimationUtils.currentAnimationTimeMillis());
    }

    private void fireAnimationRepeat() {
    }

    public boolean getTransformation(long j6, GLTransformation gLTransformation, float f6) {
        this.mScaleFactor = f6;
        return getTransformation(j6, gLTransformation);
    }

    protected void applyTransformation(float f6, GLTransformation gLTransformation) {
    }
}
