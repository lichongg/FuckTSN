package com.amap.api.maps.model.animation;

import android.view.animation.Interpolator;
import com.amap.api.col.p0003l.b8;
import com.amap.api.col.p0003l.z2;
import com.amap.api.maps.model.BaseOptions;
import com.autonavi.amap.mapcore.animation.GLAnimation;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JBindingInclude
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class Animation {
    public static final int FILL_MODE_BACKWARDS = 1;
    public static final int FILL_MODE_FORWARDS = 0;
    public static final int INFINITE = -1;
    public static final int RESTART = 1;
    public static final int REVERSE = 2;

    @JBindingInclude
    protected String animationType;
    public GLAnimation glAnimation;

    @JBindingInclude
    private AnimationListener mListener;

    @JBindingInclude
    private int fillMode = 0;

    @JBindingInclude
    private long duration = 500;

    @JBindingInclude
    private Interpolator interpolator = null;

    @JBindingInclude
    private boolean mFillBefore = true;

    @JBindingInclude
    private boolean mFillAfter = false;

    @JBindingInclude
    private boolean mFillEnabled = false;

    @JBindingInclude
    private int mRepeatCount = 0;

    @JBindingInclude
    private int mRepeatMode = 1;
    private AnimationUpdateFlags updateFlags = new AnimationUpdateFlags();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @JBindingInclude
    public interface AnimationListener {
        @JBindingInclude
        void onAnimationEnd();

        @JBindingInclude
        void onAnimationStart();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class a implements AnimationListener {

        /* renamed from: b, reason: collision with root package name */
        private final b8 f8991b;

        /* renamed from: c, reason: collision with root package name */
        private final b8 f8992c;

        /* synthetic */ a(Animation animation, AnimationListener animationListener, byte b6) {
            this(animationListener);
        }

        private a(final AnimationListener animationListener) {
            this.f8991b = new b8() { // from class: com.amap.api.maps.model.animation.Animation.a.1
                @Override // com.amap.api.col.p0003l.b8
                public final void runTask() {
                    try {
                        AnimationListener animationListener2 = animationListener;
                        if (animationListener2 != null) {
                            animationListener2.onAnimationStart();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            };
            this.f8992c = new b8() { // from class: com.amap.api.maps.model.animation.Animation.a.2
                @Override // com.amap.api.col.p0003l.b8
                public final void runTask() {
                    try {
                        AnimationListener animationListener2 = animationListener;
                        if (animationListener2 != null) {
                            animationListener2.onAnimationEnd();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            };
        }

        @Override // com.amap.api.maps.model.animation.Animation.AnimationListener
        public final void onAnimationEnd() {
            z2.a().b(this.f8992c);
        }

        @Override // com.amap.api.maps.model.animation.Animation.AnimationListener
        public final void onAnimationStart() {
            z2.a().b(this.f8991b);
        }
    }

    protected abstract String getAnimationType();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @JBindingInclude
    protected static class AnimationUpdateFlags extends BaseOptions.BaseUpdateFlags {
        protected boolean mListenerUpdate = false;
        protected boolean durationUpdate = false;
        protected boolean interpolatorUpdate = false;
        protected boolean fillModeUpdate = false;
        protected boolean mFillEnabledUpdate = false;
        protected boolean mFillAfterUpdate = false;
        protected boolean mFillBeforeUpdate = false;
        protected boolean mRepeatCountUpdate = false;
        protected boolean mRepeatModeUpdate = false;

        protected AnimationUpdateFlags() {
        }

        @Override // com.amap.api.maps.model.BaseOptions.BaseUpdateFlags
        public void reset() {
            super.reset();
            this.mListenerUpdate = false;
            this.durationUpdate = false;
            this.interpolatorUpdate = false;
            this.fillModeUpdate = false;
            this.mFillEnabledUpdate = false;
            this.mFillAfterUpdate = false;
            this.mFillBeforeUpdate = false;
            this.mRepeatCountUpdate = false;
            this.mRepeatModeUpdate = false;
        }
    }

    private void a(boolean z5) {
        this.mFillEnabled = z5;
        GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            gLAnimation.setFillEnabled(z5);
        }
        this.updateFlags.mFillEnabledUpdate = true;
    }

    private void b(boolean z5) {
        this.mFillAfter = z5;
        GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            gLAnimation.setFillAfter(z5);
        }
        this.updateFlags.mFillAfterUpdate = true;
    }

    private void c(boolean z5) {
        this.mFillBefore = z5;
        GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            gLAnimation.setFillBefore(z5);
        }
        this.updateFlags.mFillBeforeUpdate = true;
    }

    public int getFillMode() {
        return this.fillMode;
    }

    public int getRepeatCount() {
        GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            return gLAnimation.getRepeatCount();
        }
        return 0;
    }

    public int getRepeatMode() {
        GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            return gLAnimation.getRepeatMode();
        }
        return 1;
    }

    @JBindingInclude
    public AnimationUpdateFlags getUpdateFlags() {
        return this.updateFlags;
    }

    public void resetUpdateFlags() {
        this.updateFlags.reset();
    }

    public void setAnimationListener(AnimationListener animationListener) {
        this.mListener = new a(this, animationListener, (byte) 0);
        this.glAnimation.setAnimationListener(animationListener);
        this.updateFlags.mListenerUpdate = true;
    }

    public void setDuration(long j6) {
        this.duration = j6;
        GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            gLAnimation.setDuration(j6);
        }
        this.updateFlags.durationUpdate = true;
    }

    public void setFillMode(int i6) {
        this.fillMode = i6;
        if (i6 == 0) {
            b(true);
            c(false);
            a(false);
        } else {
            b(false);
            a(true);
            c(true);
        }
        this.updateFlags.fillModeUpdate = true;
    }

    public void setInterpolator(Interpolator interpolator) {
        this.interpolator = interpolator;
        GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            gLAnimation.setInterpolator(interpolator);
        }
        this.updateFlags.interpolatorUpdate = true;
    }

    public void setRepeatCount(int i6) {
        this.mRepeatCount = i6;
        GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            gLAnimation.setRepeatCount(i6);
        }
        this.updateFlags.mRepeatCountUpdate = true;
    }

    public void setRepeatMode(int i6) {
        this.mRepeatMode = i6;
        GLAnimation gLAnimation = this.glAnimation;
        if (gLAnimation != null) {
            gLAnimation.setRepeatMode(i6);
        }
        this.updateFlags.mRepeatModeUpdate = true;
    }

    public Animation() {
        this.animationType = "typeAnimtionBase";
        this.glAnimation = null;
        this.glAnimation = new GLAnimation();
        this.animationType = getAnimationType();
    }
}
