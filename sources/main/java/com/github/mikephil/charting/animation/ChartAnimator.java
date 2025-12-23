package com.github.mikephil.charting.animation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import androidx.annotation.RequiresApi;
import com.github.mikephil.charting.animation.Easing;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class ChartAnimator {
    private ValueAnimator.AnimatorUpdateListener mListener;
    protected float mPhaseY = 1.0f;
    protected float mPhaseX = 1.0f;

    public ChartAnimator() {
    }

    @RequiresApi(11)
    private ObjectAnimator xAnimator(int i6, Easing.EasingFunction easingFunction) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "phaseX", 0.0f, 1.0f);
        ofFloat.setInterpolator(easingFunction);
        ofFloat.setDuration(i6);
        return ofFloat;
    }

    @RequiresApi(11)
    private ObjectAnimator yAnimator(int i6, Easing.EasingFunction easingFunction) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "phaseY", 0.0f, 1.0f);
        ofFloat.setInterpolator(easingFunction);
        ofFloat.setDuration(i6);
        return ofFloat;
    }

    @RequiresApi(11)
    public void animateX(int i6) {
        animateX(i6, Easing.Linear);
    }

    @RequiresApi(11)
    public void animateXY(int i6, int i7) {
        Easing.EasingFunction easingFunction = Easing.Linear;
        animateXY(i6, i7, easingFunction, easingFunction);
    }

    @RequiresApi(11)
    public void animateY(int i6) {
        animateY(i6, Easing.Linear);
    }

    @RequiresApi(11)
    public void animateX(int i6, Easing.EasingFunction easingFunction) {
        ObjectAnimator xAnimator = xAnimator(i6, easingFunction);
        xAnimator.addUpdateListener(this.mListener);
        xAnimator.start();
    }

    @RequiresApi(11)
    public void animateXY(int i6, int i7, Easing.EasingFunction easingFunction) {
        ObjectAnimator xAnimator = xAnimator(i6, easingFunction);
        ObjectAnimator yAnimator = yAnimator(i7, easingFunction);
        if (i6 > i7) {
            xAnimator.addUpdateListener(this.mListener);
        } else {
            yAnimator.addUpdateListener(this.mListener);
        }
        xAnimator.start();
        yAnimator.start();
    }

    @RequiresApi(11)
    public void animateY(int i6, Easing.EasingFunction easingFunction) {
        ObjectAnimator yAnimator = yAnimator(i6, easingFunction);
        yAnimator.addUpdateListener(this.mListener);
        yAnimator.start();
    }

    public float getPhaseX() {
        return this.mPhaseX;
    }

    public float getPhaseY() {
        return this.mPhaseY;
    }

    public void setPhaseX(float f6) {
        if (f6 > 1.0f) {
            f6 = 1.0f;
        } else if (f6 < 0.0f) {
            f6 = 0.0f;
        }
        this.mPhaseX = f6;
    }

    public void setPhaseY(float f6) {
        if (f6 > 1.0f) {
            f6 = 1.0f;
        } else if (f6 < 0.0f) {
            f6 = 0.0f;
        }
        this.mPhaseY = f6;
    }

    @RequiresApi(11)
    public ChartAnimator(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.mListener = animatorUpdateListener;
    }

    @RequiresApi(11)
    public void animateXY(int i6, int i7, Easing.EasingFunction easingFunction, Easing.EasingFunction easingFunction2) {
        ObjectAnimator xAnimator = xAnimator(i6, easingFunction);
        ObjectAnimator yAnimator = yAnimator(i7, easingFunction2);
        if (i6 > i7) {
            xAnimator.addUpdateListener(this.mListener);
        } else {
            yAnimator.addUpdateListener(this.mListener);
        }
        xAnimator.start();
        yAnimator.start();
    }
}
