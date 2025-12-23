package com.google.android.material.transition;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
class FadeModeResult {
    final int endAlpha;
    final boolean endOnTop;
    final int startAlpha;

    static FadeModeResult endOnTop(int i6, int i7) {
        return new FadeModeResult(i6, i7, true);
    }

    static FadeModeResult startOnTop(int i6, int i7) {
        return new FadeModeResult(i6, i7, false);
    }

    private FadeModeResult(int i6, int i7, boolean z5) {
        this.startAlpha = i6;
        this.endAlpha = i7;
        this.endOnTop = z5;
    }
}
