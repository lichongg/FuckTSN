package androidx.interpolator.view.animation;

import android.view.animation.Interpolator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
abstract class LookupTableInterpolator implements Interpolator {
    private final float mStepSize;
    private final float[] mValues;

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f6) {
        if (f6 >= 1.0f) {
            return 1.0f;
        }
        if (f6 <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.mValues;
        int min = Math.min((int) ((fArr.length - 1) * f6), fArr.length - 2);
        float f7 = this.mStepSize;
        float f8 = (f6 - (min * f7)) / f7;
        float[] fArr2 = this.mValues;
        float f9 = fArr2[min];
        return f9 + (f8 * (fArr2[min + 1] - f9));
    }

    protected LookupTableInterpolator(float[] fArr) {
        this.mValues = fArr;
        this.mStepSize = 1.0f / (fArr.length - 1);
    }
}
