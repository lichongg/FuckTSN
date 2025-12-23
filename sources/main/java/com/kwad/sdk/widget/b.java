package com.kwad.sdk.widget;

import android.animation.ArgbEvaluator;
import android.animation.TypeEvaluator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b implements TypeEvaluator {
    private static final ArgbEvaluator bdw = new ArgbEvaluator();

    public static ArgbEvaluator SN() {
        return bdw;
    }

    @Override // android.animation.TypeEvaluator
    public final Object evaluate(float f6, Object obj, Object obj2) {
        int intValue = ((Integer) obj).intValue();
        float f7 = ((intValue >> 24) & 255) / 255.0f;
        int intValue2 = ((Integer) obj2).intValue();
        float pow = (float) Math.pow(((intValue >> 16) & 255) / 255.0f, 2.2d);
        float pow2 = (float) Math.pow(((intValue >> 8) & 255) / 255.0f, 2.2d);
        float pow3 = (float) Math.pow((intValue & 255) / 255.0f, 2.2d);
        float pow4 = (float) Math.pow(((intValue2 >> 16) & 255) / 255.0f, 2.2d);
        float f8 = f7 + (((((intValue2 >> 24) & 255) / 255.0f) - f7) * f6);
        float pow5 = pow2 + ((((float) Math.pow(((intValue2 >> 8) & 255) / 255.0f, 2.2d)) - pow2) * f6);
        float pow6 = pow3 + (f6 * (((float) Math.pow((intValue2 & 255) / 255.0f, 2.2d)) - pow3));
        return Integer.valueOf((Math.round(((float) Math.pow(pow + ((pow4 - pow) * f6), 0.45454545454545453d)) * 255.0f) << 16) | (Math.round(f8 * 255.0f) << 24) | (Math.round(((float) Math.pow(pow5, 0.45454545454545453d)) * 255.0f) << 8) | Math.round(((float) Math.pow(pow6, 0.45454545454545453d)) * 255.0f));
    }
}
