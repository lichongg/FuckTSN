package com.autonavi.base.ae.gmap.glanimation;

import android.os.SystemClock;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class AdglAnimation1V extends AbstractAdglAnimation {
    private float curValue;
    private AbstractAdglAnimationParam1V v1Param = null;

    public void reset() {
        this.isOver = false;
        this.duration = 0;
        AbstractAdglAnimationParam1V abstractAdglAnimationParam1V = this.v1Param;
        if (abstractAdglAnimationParam1V != null) {
            abstractAdglAnimationParam1V.reset();
        }
    }

    @Override // com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimation
    public void doAnimation(Object obj) {
        if (this.isOver) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis() - this.startTime;
        this.offsetTime = uptimeMillis;
        float f6 = uptimeMillis / this.duration;
        if (f6 > 1.0f) {
            this.isOver = true;
            f6 = 1.0f;
        } else if (f6 < 0.0f) {
            this.isOver = true;
            return;
        }
        AbstractAdglAnimationParam1V abstractAdglAnimationParam1V = this.v1Param;
        if (abstractAdglAnimationParam1V != null) {
            abstractAdglAnimationParam1V.setNormalizedTime(f6);
            this.curValue = this.v1Param.getCurValue();
        }
    }

    public float getCurValue() {
        return this.curValue;
    }

    public float getEndValue() {
        AbstractAdglAnimationParam1V abstractAdglAnimationParam1V = this.v1Param;
        if (abstractAdglAnimationParam1V != null) {
            return abstractAdglAnimationParam1V.getToValue();
        }
        return 0.0f;
    }

    public float getStartValue() {
        AbstractAdglAnimationParam1V abstractAdglAnimationParam1V = this.v1Param;
        if (abstractAdglAnimationParam1V != null) {
            return abstractAdglAnimationParam1V.getFromValue();
        }
        return 0.0f;
    }

    public void setAnimationValue(float f6, float f7, int i6) {
        if (this.v1Param == null) {
            this.v1Param = new AbstractAdglAnimationParam1V();
        }
        this.v1Param.reset();
        this.v1Param.setInterpolatorType(i6, 1.0f);
        this.v1Param.setFromValue(f6);
        this.v1Param.setToValue(f7);
        this.startTime = SystemClock.uptimeMillis();
        this.isOver = false;
    }

    public AdglAnimation1V(int i6) {
        reset();
        this.duration = i6;
        this.curValue = 0.0f;
    }
}
