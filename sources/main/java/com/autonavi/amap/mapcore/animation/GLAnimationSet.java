package com.autonavi.amap.mapcore.animation;

import android.view.animation.Interpolator;
import com.amap.api.maps.model.animation.Animation;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class GLAnimationSet extends GLAnimation {
    private static final int PROPERTY_CHANGE_BOUNDS_MASK = 128;
    private static final int PROPERTY_DURATION_MASK = 32;
    private static final int PROPERTY_FILL_AFTER_MASK = 1;
    private static final int PROPERTY_FILL_BEFORE_MASK = 2;
    private static final int PROPERTY_MORPH_MATRIX_MASK = 64;
    private static final int PROPERTY_REPEAT_MODE_MASK = 4;
    private static final int PROPERTY_SHARE_INTERPOLATOR_MASK = 16;
    private static final int PROPERTY_START_OFFSET_MASK = 8;
    private boolean mDirty;
    private boolean mHasAlpha;
    private long mLastEnd;
    private int mFlags = 0;
    private ArrayList<GLAnimation> mAnimations = new ArrayList<>();
    private GLTransformation mTempTransformation = new GLTransformation();

    private void init() {
        this.mStartTime = 0L;
    }

    private void setFlag(int i6, boolean z5) {
        if (z5) {
            this.mFlags = i6 | this.mFlags;
        } else {
            this.mFlags = (~i6) & this.mFlags;
        }
    }

    public void addAnimation(Animation animation) {
        this.mAnimations.add(animation.glAnimation);
        if ((this.mFlags & 64) == 0 && animation.glAnimation.willChangeTransformationMatrix()) {
            this.mFlags |= 64;
        }
        if ((this.mFlags & 128) == 0 && animation.glAnimation.willChangeBounds()) {
            this.mFlags |= 128;
        }
        if ((this.mFlags & 32) == 32) {
            this.mLastEnd = this.mStartOffset + this.mDuration;
        } else if (this.mAnimations.size() == 1) {
            long startOffset = animation.glAnimation.getStartOffset() + animation.glAnimation.getDuration();
            this.mDuration = startOffset;
            this.mLastEnd = this.mStartOffset + startOffset;
        } else {
            long max = Math.max(this.mLastEnd, animation.glAnimation.getStartOffset() + animation.glAnimation.getDuration());
            this.mLastEnd = max;
            this.mDuration = max - this.mStartOffset;
        }
        this.mDirty = true;
    }

    public void cleanAnimation() {
        this.mAnimations.clear();
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public long computeDurationHint() {
        int size = this.mAnimations.size();
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        long j6 = 0;
        for (int i6 = size - 1; i6 >= 0; i6--) {
            long computeDurationHint = arrayList.get(i6).computeDurationHint();
            if (computeDurationHint > j6) {
                j6 = computeDurationHint;
            }
        }
        return j6;
    }

    public List<GLAnimation> getAnimations() {
        return this.mAnimations;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public long getDuration() {
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        int size = arrayList.size();
        if ((this.mFlags & 32) == 32) {
            return this.mDuration;
        }
        long j6 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            j6 = Math.max(j6, arrayList.get(i6).getDuration());
        }
        return j6;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public long getStartTime() {
        int size = this.mAnimations.size();
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        long j6 = Long.MAX_VALUE;
        for (int i6 = 0; i6 < size; i6++) {
            j6 = Math.min(j6, arrayList.get(i6).getStartTime());
        }
        return j6;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public boolean getTransformation(long j6, GLTransformation gLTransformation) {
        if (!this.mInitialized) {
            initialize();
        }
        int size = this.mAnimations.size();
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        GLTransformation gLTransformation2 = this.mTempTransformation;
        gLTransformation.clear();
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = true;
        for (int i6 = size - 1; i6 >= 0; i6--) {
            GLAnimation gLAnimation = arrayList.get(i6);
            gLTransformation2.clear();
            z6 = gLAnimation.getTransformation(j6, gLTransformation, getScaleFactor()) || z6;
            z5 = z5 || gLAnimation.hasStarted();
            z7 = gLAnimation.hasEnded() && z7;
        }
        if (z5) {
            try {
                if (!this.mStarted) {
                    Animation.AnimationListener animationListener = this.mListener;
                    if (animationListener != null) {
                        animationListener.onAnimationStart();
                    }
                    this.mStarted = true;
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return z6;
            }
        }
        if (z7 != this.mEnded) {
            Animation.AnimationListener animationListener2 = this.mListener;
            if (animationListener2 != null) {
                animationListener2.onAnimationEnd();
            }
            this.mEnded = z7;
        }
        return z6;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public boolean hasAlpha() {
        if (this.mDirty) {
            int i6 = 0;
            this.mHasAlpha = false;
            this.mDirty = false;
            int size = this.mAnimations.size();
            ArrayList<GLAnimation> arrayList = this.mAnimations;
            while (true) {
                if (i6 >= size) {
                    break;
                }
                if (arrayList.get(i6).hasAlpha()) {
                    this.mHasAlpha = true;
                    break;
                }
                i6++;
            }
        }
        return this.mHasAlpha;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void initialize() {
        ArrayList<GLAnimation> arrayList;
        boolean z5;
        super.initialize();
        int i6 = this.mFlags;
        boolean z6 = (i6 & 32) == 32;
        boolean z7 = (i6 & 1) == 1;
        boolean z8 = (i6 & 2) == 2;
        boolean z9 = (i6 & 4) == 4;
        boolean z10 = (i6 & 16) == 16;
        boolean z11 = (i6 & 8) == 8;
        if (z10) {
            ensureInterpolator();
        }
        ArrayList<GLAnimation> arrayList2 = this.mAnimations;
        int size = arrayList2.size();
        long j6 = this.mDuration;
        boolean z12 = this.mFillAfter;
        boolean z13 = this.mFillBefore;
        int i7 = this.mRepeatMode;
        Interpolator interpolator = this.mInterpolator;
        boolean z14 = z11;
        long j7 = this.mStartOffset;
        int i8 = 0;
        while (i8 < size) {
            int i9 = i8;
            GLAnimation gLAnimation = arrayList2.get(i8);
            if (z6) {
                gLAnimation.setDuration(j6);
            }
            if (z7) {
                gLAnimation.setFillAfter(z12);
            }
            if (z8) {
                gLAnimation.setFillBefore(z13);
            }
            if (z9) {
                gLAnimation.setRepeatMode(i7);
            }
            if (z10) {
                gLAnimation.setInterpolator(interpolator);
            }
            if (z14) {
                arrayList = arrayList2;
                z5 = z6;
                gLAnimation.setStartOffset(gLAnimation.getStartOffset() + j7);
            } else {
                arrayList = arrayList2;
                z5 = z6;
            }
            gLAnimation.initialize();
            i8 = i9 + 1;
            z6 = z5;
            arrayList2 = arrayList;
        }
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void scaleCurrentDuration(float f6) {
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            arrayList.get(i6).scaleCurrentDuration(f6);
        }
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void setDuration(long j6) {
        this.mFlags |= 32;
        super.setDuration(j6);
        this.mLastEnd = this.mStartOffset + this.mDuration;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void setFillAfter(boolean z5) {
        this.mFlags |= 1;
        super.setFillAfter(z5);
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void setFillBefore(boolean z5) {
        this.mFlags |= 2;
        super.setFillBefore(z5);
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void setRepeatMode(int i6) {
        this.mFlags |= 4;
        super.setRepeatMode(i6);
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void setStartOffset(long j6) {
        this.mFlags |= 8;
        super.setStartOffset(j6);
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public boolean willChangeBounds() {
        return (this.mFlags & 128) == 128;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public boolean willChangeTransformationMatrix() {
        return (this.mFlags & 64) == 64;
    }

    public GLAnimationSet(boolean z5) {
        setFlag(16, z5);
        init();
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    /* renamed from: clone */
    public GLAnimationSet mo85clone() throws CloneNotSupportedException {
        GLAnimationSet gLAnimationSet = (GLAnimationSet) super.mo85clone();
        gLAnimationSet.mTempTransformation = new GLTransformation();
        gLAnimationSet.mAnimations = new ArrayList<>();
        int size = this.mAnimations.size();
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        for (int i6 = 0; i6 < size; i6++) {
            gLAnimationSet.mAnimations.add(arrayList.get(i6).mo85clone());
        }
        return gLAnimationSet;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void reset() {
        super.reset();
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void restrictDuration(long j6) {
        super.restrictDuration(j6);
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            arrayList.get(i6).restrictDuration(j6);
        }
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void setStartTime(long j6) {
        super.setStartTime(j6);
        int size = this.mAnimations.size();
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        for (int i6 = 0; i6 < size; i6++) {
            arrayList.get(i6).setStartTime(j6);
        }
    }
}
