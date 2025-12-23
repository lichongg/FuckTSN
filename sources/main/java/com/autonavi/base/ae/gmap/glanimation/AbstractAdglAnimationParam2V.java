package com.autonavi.base.ae.gmap.glanimation;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class AbstractAdglAnimationParam2V extends AbstractAdglAnimationParam {
    public double fromXValue;
    public double fromYValue;
    public double toXValue;
    public double toYValue;

    @Override // com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam
    public void checkParam() {
        this.needToCaculate = false;
        if (this.hasFromValue && this.hasToValue) {
            double d6 = this.toXValue - this.fromXValue;
            double d7 = this.toYValue - this.fromYValue;
            if (Math.abs(d6) > 1.0E-4d || Math.abs(d7) > 1.0E-4d) {
                this.needToCaculate = true;
            }
        }
        this.hasCheckedParam = true;
    }

    public double getCurXValue() {
        double d6 = this.fromXValue;
        return d6 + ((this.toXValue - d6) * this.mult);
    }

    public double getCurYValue() {
        double d6 = this.fromYValue;
        return d6 + ((this.toYValue - d6) * this.mult);
    }

    public double getFromXValue() {
        return this.fromXValue;
    }

    public double getFromYValue() {
        return this.fromYValue;
    }

    public double getToXValue() {
        return this.toXValue;
    }

    public double getToYValue() {
        return this.toYValue;
    }

    public void setFromValue(double d6, double d7) {
        this.fromXValue = d6;
        this.fromYValue = d7;
        this.hasFromValue = true;
        this.hasCheckedParam = false;
    }

    public void setToValue(double d6, double d7) {
        this.toXValue = d6;
        this.toYValue = d7;
        this.hasToValue = true;
        this.hasCheckedParam = false;
    }

    public AbstractAdglAnimationParam2V() {
        reset();
    }

    @Override // com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam
    public void reset() {
        super.reset();
        this.fromXValue = 0.0d;
        this.toXValue = 0.0d;
        this.fromYValue = 0.0d;
        this.toYValue = 0.0d;
    }
}
