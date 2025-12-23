package com.google.android.material.transition;

import android.graphics.RectF;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
class FitModeEvaluators {
    private static final FitModeEvaluator WIDTH = new FitModeEvaluator() { // from class: com.google.android.material.transition.FitModeEvaluators.1
        @Override // com.google.android.material.transition.FitModeEvaluator
        public FitModeResult evaluate(float f6, float f7, float f8, float f9, float f10, float f11, float f12) {
            float lerp = TransitionUtils.lerp(f9, f11, f7, f8, f6, true);
            float f13 = lerp / f9;
            float f14 = lerp / f11;
            return new FitModeResult(f13, f14, lerp, f10 * f13, lerp, f12 * f14);
        }

        @Override // com.google.android.material.transition.FitModeEvaluator
        public void applyMask(RectF rectF, float f6, FitModeResult fitModeResult) {
            rectF.bottom -= Math.abs(fitModeResult.currentEndHeight - fitModeResult.currentStartHeight) * f6;
        }

        @Override // com.google.android.material.transition.FitModeEvaluator
        public boolean shouldMaskStartBounds(FitModeResult fitModeResult) {
            return fitModeResult.currentStartHeight > fitModeResult.currentEndHeight;
        }
    };
    private static final FitModeEvaluator HEIGHT = new FitModeEvaluator() { // from class: com.google.android.material.transition.FitModeEvaluators.2
        @Override // com.google.android.material.transition.FitModeEvaluator
        public FitModeResult evaluate(float f6, float f7, float f8, float f9, float f10, float f11, float f12) {
            float lerp = TransitionUtils.lerp(f10, f12, f7, f8, f6, true);
            float f13 = lerp / f10;
            float f14 = lerp / f12;
            return new FitModeResult(f13, f14, f9 * f13, lerp, f11 * f14, lerp);
        }

        @Override // com.google.android.material.transition.FitModeEvaluator
        public void applyMask(RectF rectF, float f6, FitModeResult fitModeResult) {
            float abs = (Math.abs(fitModeResult.currentEndWidth - fitModeResult.currentStartWidth) / 2.0f) * f6;
            rectF.left += abs;
            rectF.right -= abs;
        }

        @Override // com.google.android.material.transition.FitModeEvaluator
        public boolean shouldMaskStartBounds(FitModeResult fitModeResult) {
            return fitModeResult.currentStartWidth > fitModeResult.currentEndWidth;
        }
    };

    static FitModeEvaluator get(int i6, boolean z5, RectF rectF, RectF rectF2) {
        if (i6 == 0) {
            return shouldAutoFitToWidth(z5, rectF, rectF2) ? WIDTH : HEIGHT;
        }
        if (i6 == 1) {
            return WIDTH;
        }
        if (i6 == 2) {
            return HEIGHT;
        }
        throw new IllegalArgumentException("Invalid fit mode: " + i6);
    }

    private FitModeEvaluators() {
    }

    private static boolean shouldAutoFitToWidth(boolean z5, RectF rectF, RectF rectF2) {
        float width = rectF.width();
        float height = rectF.height();
        float width2 = rectF2.width();
        float height2 = rectF2.height();
        float f6 = (height2 * width) / width2;
        float f7 = (width2 * height) / width;
        if (z5) {
            if (f6 < height) {
                return false;
            }
            return true;
        }
        if (f7 < height2) {
            return false;
        }
        return true;
    }
}
