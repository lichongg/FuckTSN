package com.google.android.material.transition.platform;

import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes5.dex */
class FadeModeEvaluators {
    private static final FadeModeEvaluator IN = new FadeModeEvaluator() { // from class: com.google.android.material.transition.platform.FadeModeEvaluators.1
        @Override // com.google.android.material.transition.platform.FadeModeEvaluator
        public FadeModeResult evaluate(float f6, float f7, float f8, float f9) {
            return FadeModeResult.endOnTop(255, TransitionUtils.lerp(0, 255, f7, f8, f6));
        }
    };
    private static final FadeModeEvaluator OUT = new FadeModeEvaluator() { // from class: com.google.android.material.transition.platform.FadeModeEvaluators.2
        @Override // com.google.android.material.transition.platform.FadeModeEvaluator
        public FadeModeResult evaluate(float f6, float f7, float f8, float f9) {
            return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f7, f8, f6), 255);
        }
    };
    private static final FadeModeEvaluator CROSS = new FadeModeEvaluator() { // from class: com.google.android.material.transition.platform.FadeModeEvaluators.3
        @Override // com.google.android.material.transition.platform.FadeModeEvaluator
        public FadeModeResult evaluate(float f6, float f7, float f8, float f9) {
            return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f7, f8, f6), TransitionUtils.lerp(0, 255, f7, f8, f6));
        }
    };
    private static final FadeModeEvaluator THROUGH = new FadeModeEvaluator() { // from class: com.google.android.material.transition.platform.FadeModeEvaluators.4
        @Override // com.google.android.material.transition.platform.FadeModeEvaluator
        public FadeModeResult evaluate(float f6, float f7, float f8, float f9) {
            float f10 = ((f8 - f7) * f9) + f7;
            return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f7, f10, f6), TransitionUtils.lerp(0, 255, f10, f8, f6));
        }
    };

    static FadeModeEvaluator get(int i6, boolean z5) {
        if (i6 == 0) {
            return z5 ? IN : OUT;
        }
        if (i6 == 1) {
            return z5 ? OUT : IN;
        }
        if (i6 == 2) {
            return CROSS;
        }
        if (i6 == 3) {
            return THROUGH;
        }
        throw new IllegalArgumentException("Invalid fade mode: " + i6);
    }

    private FadeModeEvaluators() {
    }
}
