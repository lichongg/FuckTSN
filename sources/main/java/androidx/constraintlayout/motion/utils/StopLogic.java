package androidx.constraintlayout.motion.utils;

import androidx.constraintlayout.motion.widget.MotionInterpolator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class StopLogic extends MotionInterpolator {
    private boolean mBackwards = false;
    private float mLastPosition;
    private int mNumberOfStages;
    private float mStage1Duration;
    private float mStage1EndPosition;
    private float mStage1Velocity;
    private float mStage2Duration;
    private float mStage2EndPosition;
    private float mStage2Velocity;
    private float mStage3Duration;
    private float mStage3EndPosition;
    private float mStage3Velocity;
    private float mStartPosition;
    private String mType;

    private void setup(float f6, float f7, float f8, float f9, float f10) {
        if (f6 == 0.0f) {
            f6 = 1.0E-4f;
        }
        this.mStage1Velocity = f6;
        float f11 = f6 / f8;
        float f12 = (f11 * f6) / 2.0f;
        if (f6 < 0.0f) {
            float sqrt = (float) Math.sqrt((f7 - ((((-f6) / f8) * f6) / 2.0f)) * f8);
            if (sqrt < f9) {
                this.mType = "backward accelerate, decelerate";
                this.mNumberOfStages = 2;
                this.mStage1Velocity = f6;
                this.mStage2Velocity = sqrt;
                this.mStage3Velocity = 0.0f;
                float f13 = (sqrt - f6) / f8;
                this.mStage1Duration = f13;
                this.mStage2Duration = sqrt / f8;
                this.mStage1EndPosition = ((f6 + sqrt) * f13) / 2.0f;
                this.mStage2EndPosition = f7;
                this.mStage3EndPosition = f7;
                return;
            }
            this.mType = "backward accelerate cruse decelerate";
            this.mNumberOfStages = 3;
            this.mStage1Velocity = f6;
            this.mStage2Velocity = f9;
            this.mStage3Velocity = f9;
            float f14 = (f9 - f6) / f8;
            this.mStage1Duration = f14;
            float f15 = f9 / f8;
            this.mStage3Duration = f15;
            float f16 = ((f6 + f9) * f14) / 2.0f;
            float f17 = (f15 * f9) / 2.0f;
            this.mStage2Duration = ((f7 - f16) - f17) / f9;
            this.mStage1EndPosition = f16;
            this.mStage2EndPosition = f7 - f17;
            this.mStage3EndPosition = f7;
            return;
        }
        if (f12 >= f7) {
            this.mType = "hard stop";
            this.mNumberOfStages = 1;
            this.mStage1Velocity = f6;
            this.mStage2Velocity = 0.0f;
            this.mStage1EndPosition = f7;
            this.mStage1Duration = (2.0f * f7) / f6;
            return;
        }
        float f18 = f7 - f12;
        float f19 = f18 / f6;
        if (f19 + f11 < f10) {
            this.mType = "cruse decelerate";
            this.mNumberOfStages = 2;
            this.mStage1Velocity = f6;
            this.mStage2Velocity = f6;
            this.mStage3Velocity = 0.0f;
            this.mStage1EndPosition = f18;
            this.mStage2EndPosition = f7;
            this.mStage1Duration = f19;
            this.mStage2Duration = f11;
            return;
        }
        float sqrt2 = (float) Math.sqrt((f8 * f7) + ((f6 * f6) / 2.0f));
        float f20 = (sqrt2 - f6) / f8;
        this.mStage1Duration = f20;
        float f21 = sqrt2 / f8;
        this.mStage2Duration = f21;
        if (sqrt2 < f9) {
            this.mType = "accelerate decelerate";
            this.mNumberOfStages = 2;
            this.mStage1Velocity = f6;
            this.mStage2Velocity = sqrt2;
            this.mStage3Velocity = 0.0f;
            this.mStage1Duration = f20;
            this.mStage2Duration = f21;
            this.mStage1EndPosition = ((f6 + sqrt2) * f20) / 2.0f;
            this.mStage2EndPosition = f7;
            return;
        }
        this.mType = "accelerate cruse decelerate";
        this.mNumberOfStages = 3;
        this.mStage1Velocity = f6;
        this.mStage2Velocity = f9;
        this.mStage3Velocity = f9;
        float f22 = (f9 - f6) / f8;
        this.mStage1Duration = f22;
        float f23 = f9 / f8;
        this.mStage3Duration = f23;
        float f24 = ((f6 + f9) * f22) / 2.0f;
        float f25 = (f23 * f9) / 2.0f;
        this.mStage2Duration = ((f7 - f24) - f25) / f9;
        this.mStage1EndPosition = f24;
        this.mStage2EndPosition = f7 - f25;
        this.mStage3EndPosition = f7;
    }

    public float getVelocity(float f6) {
        float f7 = this.mStage1Duration;
        if (f6 <= f7) {
            float f8 = this.mStage1Velocity;
            return f8 + (((this.mStage2Velocity - f8) * f6) / f7);
        }
        int i6 = this.mNumberOfStages;
        if (i6 == 1) {
            return 0.0f;
        }
        float f9 = f6 - f7;
        float f10 = this.mStage2Duration;
        if (f9 < f10) {
            float f11 = this.mStage2Velocity;
            return f11 + (((this.mStage3Velocity - f11) * f9) / f10);
        }
        if (i6 == 2) {
            return this.mStage2EndPosition;
        }
        float f12 = f9 - f10;
        float f13 = this.mStage3Duration;
        if (f12 >= f13) {
            return this.mStage3EndPosition;
        }
        float f14 = this.mStage3Velocity;
        return f14 - ((f12 * f14) / f13);
    }

    private float calcY(float f6) {
        float f7 = this.mStage1Duration;
        if (f6 <= f7) {
            float f8 = this.mStage1Velocity;
            return (f8 * f6) + ((((this.mStage2Velocity - f8) * f6) * f6) / (f7 * 2.0f));
        }
        int i6 = this.mNumberOfStages;
        if (i6 == 1) {
            return this.mStage1EndPosition;
        }
        float f9 = f6 - f7;
        float f10 = this.mStage2Duration;
        if (f9 < f10) {
            float f11 = this.mStage1EndPosition;
            float f12 = this.mStage2Velocity;
            return f11 + (f12 * f9) + ((((this.mStage3Velocity - f12) * f9) * f9) / (f10 * 2.0f));
        }
        if (i6 == 2) {
            return this.mStage2EndPosition;
        }
        float f13 = f9 - f10;
        float f14 = this.mStage3Duration;
        if (f13 >= f14) {
            return this.mStage3EndPosition;
        }
        float f15 = this.mStage2EndPosition;
        float f16 = this.mStage3Velocity;
        return (f15 + (f16 * f13)) - (((f16 * f13) * f13) / (f14 * 2.0f));
    }

    public void config(float f6, float f7, float f8, float f9, float f10, float f11) {
        this.mStartPosition = f6;
        boolean z5 = f6 > f7;
        this.mBackwards = z5;
        if (z5) {
            setup(-f8, f6 - f7, f10, f11, f9);
        } else {
            setup(f8, f7 - f6, f10, f11, f9);
        }
    }

    @Override // androidx.constraintlayout.motion.widget.MotionInterpolator, android.animation.TimeInterpolator
    public float getInterpolation(float f6) {
        float calcY = calcY(f6);
        this.mLastPosition = f6;
        if (this.mBackwards) {
            return this.mStartPosition - calcY;
        }
        return this.mStartPosition + calcY;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionInterpolator
    public float getVelocity() {
        return this.mBackwards ? -getVelocity(this.mLastPosition) : getVelocity(this.mLastPosition);
    }

    public void debug(String str, String str2, float f6) {
    }
}
