package com.autonavi.base.ae.gmap.glanimation;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class AbstractAdglAnimationParam1V extends AbstractAdglAnimationParam {
    private float fromValue;
    private float toValue;

    @Override // com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam
    public void checkParam() {
        this.needToCaculate = false;
        if (this.hasFromValue && this.hasToValue && Math.abs(this.toValue - this.fromValue) > 1.0E-4d) {
            this.needToCaculate = true;
        }
        this.hasCheckedParam = true;
    }

    public float getCurValue() {
        float f6 = this.fromValue;
        return f6 + ((this.toValue - f6) * this.mult);
    }

    public float getFromValue() {
        return this.fromValue;
    }

    public float getToValue() {
        return this.toValue;
    }

    public void setFromValue(float f6) {
        this.fromValue = f6;
        this.hasFromValue = true;
        this.hasCheckedParam = false;
    }

    public void setToValue(float f6) {
        this.toValue = f6;
        this.hasToValue = true;
        this.hasCheckedParam = false;
    }

    public AbstractAdglAnimationParam1V() {
        reset();
    }

    @Override // com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam
    public void reset() {
        super.reset();
        this.fromValue = 0.0f;
        this.toValue = 0.0f;
    }
}
