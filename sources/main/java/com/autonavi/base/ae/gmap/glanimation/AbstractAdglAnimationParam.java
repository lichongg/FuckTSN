package com.autonavi.base.ae.gmap.glanimation;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class AbstractAdglAnimationParam {
    protected float mult;
    protected float normalizedTime;
    protected int interpolationType = 0;
    protected float factor = 1.0f;
    protected boolean hasCheckedParam = false;
    protected boolean needToCaculate = false;
    protected boolean hasFromValue = false;
    protected boolean hasToValue = false;

    public abstract void checkParam();

    public void reset() {
        this.interpolationType = 0;
        this.factor = 1.0f;
        this.hasCheckedParam = false;
        this.needToCaculate = false;
        this.hasFromValue = false;
        this.hasToValue = false;
    }

    static float bounce(float f6) {
        return f6 * f6 * 8.0f;
    }

    public float getCurMult() {
        return this.mult;
    }

    public int getInterpolatorType() {
        return this.interpolationType;
    }

    public boolean needToCaculate() {
        if (!this.hasCheckedParam) {
            checkParam();
        }
        return this.hasCheckedParam && this.needToCaculate;
    }

    public void setInterpolatorType(int i6, float f6) {
        this.interpolationType = i6;
        this.factor = f6;
    }

    public void setNormalizedTime(float f6) {
        double pow;
        float bounce;
        float f7;
        this.normalizedTime = f6;
        switch (this.interpolationType) {
            case 0:
                break;
            case 1:
                pow = Math.pow(f6, this.factor * 2.0f);
                f6 = (float) pow;
                break;
            case 2:
                if (this.factor != 1.0f) {
                    f6 = (float) (1.0d - Math.pow(1.0f - f6, r0 * 2.0f));
                    break;
                } else {
                    float f8 = 1.0f - f6;
                    f6 = 1.0f - (f8 * f8);
                    break;
                }
            case 3:
                pow = (Math.cos((f6 + 1.0f) * 3.141592653589793d) / 2.0d) + 0.5d;
                f6 = (float) pow;
                break;
            case 4:
                float f9 = f6 * 1.1226f;
                if (f9 >= 0.3535f) {
                    if (f9 < 0.7408f) {
                        bounce = bounce(f9 - 0.54719f);
                        f7 = 0.7f;
                    } else if (f9 < 0.9644f) {
                        bounce = bounce(f9 - 0.8526f);
                        f7 = 0.9f;
                    } else {
                        bounce = bounce(f9 - 1.0435f);
                        f7 = 0.95f;
                    }
                    f6 = bounce + f7;
                    break;
                } else {
                    f6 = bounce(f9);
                    break;
                }
            case 5:
                float f10 = f6 - 1.0f;
                f6 = (f10 * f10 * ((f10 * 3.0f) + 2.0f)) + 1.0f;
                break;
            case 6:
                if (f6 >= 0.0f) {
                    if (f6 >= 0.25f) {
                        if (f6 >= 0.5f) {
                            if (f6 >= 0.75f) {
                                if (f6 <= 1.0f) {
                                    f6 = 4.0f - (f6 * 4.0f);
                                    break;
                                }
                            } else {
                                f6 = (f6 * 4.0f) - 2.0f;
                                break;
                            }
                        } else {
                            f6 = 2.0f - (f6 * 4.0f);
                            break;
                        }
                    } else {
                        f6 *= 4.0f;
                        break;
                    }
                }
            default:
                f6 = 0.0f;
                break;
        }
        this.mult = f6;
    }
}
