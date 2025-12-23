package com.scwang.smartrefresh.header.waveswipe;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Interpolator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class b implements Interpolator {
    public b() {
    }

    public b(Context context, AttributeSet attributeSet) {
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f6) {
        float pow;
        float f7;
        if (f6 < 0.25f) {
            pow = ((float) Math.pow(f6 - 0.125d, 2.0d)) * (-38.4f);
            f7 = 0.6f;
        } else {
            double d6 = f6;
            if (d6 < 0.5d || d6 >= 0.75d) {
                return 0.0f;
            }
            pow = ((float) Math.pow(d6 - 0.625d, 2.0d)) * (-19.2f);
            f7 = 0.3f;
        }
        return pow + f7;
    }
}
