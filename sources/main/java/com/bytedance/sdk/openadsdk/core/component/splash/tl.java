package com.bytedance.sdk.openadsdk.core.component.splash;

import android.animation.TypeEvaluator;

/* loaded from: D:\Downloads\app\classes4.dex */
class tl implements TypeEvaluator {
    @Override // android.animation.TypeEvaluator
    public Object evaluate(float f6, Object obj, Object obj2) {
        int intValue = ((Integer) obj).intValue();
        int i6 = (intValue >> 24) & 255;
        int i7 = (intValue >> 16) & 255;
        int i8 = (intValue >> 8) & 255;
        int i9 = intValue & 255;
        int intValue2 = ((Integer) obj2).intValue();
        return Integer.valueOf(((i6 + ((int) ((((intValue2 >> 24) & 255) - i6) * f6))) << 24) | ((i7 + ((int) ((((intValue2 >> 16) & 255) - i7) * f6))) << 16) | ((i8 + ((int) ((((intValue2 >> 8) & 255) - i8) * f6))) << 8) | (i9 + ((int) (f6 * ((intValue2 & 255) - i9)))));
    }

    tl() {
    }
}
