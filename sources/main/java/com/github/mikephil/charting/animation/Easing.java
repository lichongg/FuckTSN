package com.github.mikephil.charting.animation;

import android.animation.TimeInterpolator;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(11)
/* loaded from: D:\Downloads\app\classes4.dex */
public class Easing {
    private static final float DOUBLE_PI = 6.2831855f;
    public static final EasingFunction Linear = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.1
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f6) {
            return f6;
        }
    };
    public static final EasingFunction EaseInQuad = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.2
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f6) {
            return f6 * f6;
        }
    };
    public static final EasingFunction EaseOutQuad = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.3
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f6) {
            return (-f6) * (f6 - 2.0f);
        }
    };
    public static final EasingFunction EaseInOutQuad = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.4
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f6) {
            float f7 = f6 * 2.0f;
            if (f7 < 1.0f) {
                return 0.5f * f7 * f7;
            }
            float f8 = f7 - 1.0f;
            return ((f8 * (f8 - 2.0f)) - 1.0f) * (-0.5f);
        }
    };
    public static final EasingFunction EaseInCubic = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.5
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f6) {
            return (float) Math.pow(f6, 3.0d);
        }
    };
    public static final EasingFunction EaseOutCubic = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.6
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f6) {
            return ((float) Math.pow(f6 - 1.0f, 3.0d)) + 1.0f;
        }
    };
    public static final EasingFunction EaseInOutCubic = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.7
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f6) {
            float f7 = f6 * 2.0f;
            return (f7 < 1.0f ? (float) Math.pow(f7, 3.0d) : ((float) Math.pow(f7 - 2.0f, 3.0d)) + 2.0f) * 0.5f;
        }
    };
    public static final EasingFunction EaseInQuart = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.8
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f6) {
            return (float) Math.pow(f6, 4.0d);
        }
    };
    public static final EasingFunction EaseOutQuart = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.9
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f6) {
            return -(((float) Math.pow(f6 - 1.0f, 4.0d)) - 1.0f);
        }
    };
    public static final EasingFunction EaseInOutQuart = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.10
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f6) {
            float pow;
            float f7;
            float f8 = f6 * 2.0f;
            if (f8 < 1.0f) {
                pow = (float) Math.pow(f8, 4.0d);
                f7 = 0.5f;
            } else {
                pow = ((float) Math.pow(f8 - 2.0f, 4.0d)) - 2.0f;
                f7 = -0.5f;
            }
            return pow * f7;
        }
    };
    public static final EasingFunction EaseInSine = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.11
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f6) {
            return (-((float) Math.cos(f6 * 1.5707963267948966d))) + 1.0f;
        }
    };
    public static final EasingFunction EaseOutSine = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.12
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f6) {
            return (float) Math.sin(f6 * 1.5707963267948966d);
        }
    };
    public static final EasingFunction EaseInOutSine = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.13
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f6) {
            return (((float) Math.cos(f6 * 3.141592653589793d)) - 1.0f) * (-0.5f);
        }
    };
    public static final EasingFunction EaseInExpo = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.14
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f6) {
            if (f6 == 0.0f) {
                return 0.0f;
            }
            return (float) Math.pow(2.0d, (f6 - 1.0f) * 10.0f);
        }
    };
    public static final EasingFunction EaseOutExpo = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.15
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f6) {
            if (f6 == 1.0f) {
                return 1.0f;
            }
            return -((float) Math.pow(2.0d, (f6 + 1.0f) * (-10.0f)));
        }
    };
    public static final EasingFunction EaseInOutExpo = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.16
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f6) {
            if (f6 == 0.0f) {
                return 0.0f;
            }
            if (f6 == 1.0f) {
                return 1.0f;
            }
            return (f6 * 2.0f < 1.0f ? (float) Math.pow(2.0d, (r8 - 1.0f) * 10.0f) : (-((float) Math.pow(2.0d, (r8 - 1.0f) * (-10.0f)))) + 2.0f) * 0.5f;
        }
    };
    public static final EasingFunction EaseInCirc = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.17
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f6) {
            return -(((float) Math.sqrt(1.0f - (f6 * f6))) - 1.0f);
        }
    };
    public static final EasingFunction EaseOutCirc = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.18
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f6) {
            float f7 = f6 - 1.0f;
            return (float) Math.sqrt(1.0f - (f7 * f7));
        }
    };
    public static final EasingFunction EaseInOutCirc = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.19
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f6) {
            float sqrt;
            float f7;
            float f8 = f6 * 2.0f;
            if (f8 < 1.0f) {
                sqrt = ((float) Math.sqrt(1.0f - (f8 * f8))) - 1.0f;
                f7 = -0.5f;
            } else {
                float f9 = f8 - 2.0f;
                sqrt = ((float) Math.sqrt(1.0f - (f9 * f9))) + 1.0f;
                f7 = 0.5f;
            }
            return sqrt * f7;
        }
    };
    public static final EasingFunction EaseInElastic = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.20
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f6) {
            if (f6 == 0.0f) {
                return 0.0f;
            }
            if (f6 == 1.0f) {
                return 1.0f;
            }
            float f7 = f6 - 1.0f;
            return -(((float) Math.pow(2.0d, 10.0f * f7)) * ((float) Math.sin(((f7 - (0.047746483f * ((float) Math.asin(1.0d)))) * Easing.DOUBLE_PI) / 0.3f)));
        }
    };
    public static final EasingFunction EaseOutElastic = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.21
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f6) {
            if (f6 == 0.0f) {
                return 0.0f;
            }
            if (f6 == 1.0f) {
                return 1.0f;
            }
            return (((float) Math.pow(2.0d, (-10.0f) * f6)) * ((float) Math.sin(((f6 - (0.047746483f * ((float) Math.asin(1.0d)))) * Easing.DOUBLE_PI) / 0.3f))) + 1.0f;
        }
    };
    public static final EasingFunction EaseInOutElastic = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.22
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f6) {
            if (f6 == 0.0f) {
                return 0.0f;
            }
            float f7 = f6 * 2.0f;
            if (f7 == 2.0f) {
                return 1.0f;
            }
            float asin = ((float) Math.asin(1.0d)) * 0.07161972f;
            if (f7 < 1.0f) {
                float f8 = f7 - 1.0f;
                return ((float) Math.pow(2.0d, 10.0f * f8)) * ((float) Math.sin(((f8 * 1.0f) - asin) * Easing.DOUBLE_PI * 2.2222223f)) * (-0.5f);
            }
            float f9 = f7 - 1.0f;
            return (((float) Math.pow(2.0d, (-10.0f) * f9)) * 0.5f * ((float) Math.sin(((f9 * 1.0f) - asin) * Easing.DOUBLE_PI * 2.2222223f))) + 1.0f;
        }
    };
    public static final EasingFunction EaseInBack = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.23
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f6) {
            return f6 * f6 * ((f6 * 2.70158f) - 1.70158f);
        }
    };
    public static final EasingFunction EaseOutBack = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.24
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f6) {
            float f7 = f6 - 1.0f;
            return (f7 * f7 * ((f7 * 2.70158f) + 1.70158f)) + 1.0f;
        }
    };
    public static final EasingFunction EaseInOutBack = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.25
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f6) {
            float f7 = f6 * 2.0f;
            if (f7 < 1.0f) {
                return f7 * f7 * ((3.5949094f * f7) - 2.5949094f) * 0.5f;
            }
            float f8 = f7 - 2.0f;
            return ((f8 * f8 * ((3.5949094f * f8) + 2.5949094f)) + 2.0f) * 0.5f;
        }
    };
    public static final EasingFunction EaseInBounce = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.26
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f6) {
            return 1.0f - Easing.EaseOutBounce.getInterpolation(1.0f - f6);
        }
    };
    public static final EasingFunction EaseOutBounce = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.27
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f6) {
            if (f6 < 0.36363637f) {
                return 7.5625f * f6 * f6;
            }
            if (f6 < 0.72727275f) {
                float f7 = f6 - 0.54545456f;
                return (7.5625f * f7 * f7) + 0.75f;
            }
            if (f6 < 0.90909094f) {
                float f8 = f6 - 0.8181818f;
                return (7.5625f * f8 * f8) + 0.9375f;
            }
            float f9 = f6 - 0.95454544f;
            return (7.5625f * f9 * f9) + 0.984375f;
        }
    };
    public static final EasingFunction EaseInOutBounce = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.28
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f6) {
            return f6 < 0.5f ? Easing.EaseInBounce.getInterpolation(f6 * 2.0f) * 0.5f : (Easing.EaseOutBounce.getInterpolation((f6 * 2.0f) - 1.0f) * 0.5f) + 0.5f;
        }
    };

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface EasingFunction extends TimeInterpolator {
        @Override // android.animation.TimeInterpolator
        float getInterpolation(float f6);
    }
}
