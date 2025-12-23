package com.autonavi.base.ae.gmap.glanimation;

import android.os.SystemClock;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class AdglAnimation2V extends AbstractAdglAnimation {
    private double curValue1;
    private double curValue2;
    private AbstractAdglAnimationParam2V v2Param = null;

    public void reset() {
        this.isOver = false;
        this.duration = 0;
        this.curValue1 = 0.0d;
        this.curValue2 = 0.0d;
        AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = this.v2Param;
        if (abstractAdglAnimationParam2V != null) {
            abstractAdglAnimationParam2V.reset();
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
        AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = this.v2Param;
        if (abstractAdglAnimationParam2V != null) {
            abstractAdglAnimationParam2V.setNormalizedTime(f6);
            this.curValue1 = this.v2Param.getCurXValue();
            this.curValue2 = this.v2Param.getCurYValue();
        }
    }

    public double getCurValue(int i6) {
        return i6 == 0 ? this.curValue1 : this.curValue2;
    }

    public double getEndValue(int i6) {
        if (i6 == 0) {
            AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = this.v2Param;
            if (abstractAdglAnimationParam2V != null) {
                return abstractAdglAnimationParam2V.getToXValue();
            }
            return 0.0d;
        }
        AbstractAdglAnimationParam2V abstractAdglAnimationParam2V2 = this.v2Param;
        if (abstractAdglAnimationParam2V2 != null) {
            return abstractAdglAnimationParam2V2.getToYValue();
        }
        return 0.0d;
    }

    public double getStartValue(int i6) {
        if (i6 == 0) {
            AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = this.v2Param;
            if (abstractAdglAnimationParam2V != null) {
                return abstractAdglAnimationParam2V.getFromXValue();
            }
            return 0.0d;
        }
        AbstractAdglAnimationParam2V abstractAdglAnimationParam2V2 = this.v2Param;
        if (abstractAdglAnimationParam2V2 != null) {
            return abstractAdglAnimationParam2V2.getFromYValue();
        }
        return 0.0d;
    }

    public AdglAnimation2V(int i6) {
        reset();
        this.duration = i6;
        this.curValue1 = 0.0d;
        this.curValue2 = 0.0d;
    }
}
