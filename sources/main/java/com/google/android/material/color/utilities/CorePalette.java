package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes5.dex */
public final class CorePalette {

    /* renamed from: a1, reason: collision with root package name */
    public TonalPalette f32582a1;

    /* renamed from: a2, reason: collision with root package name */
    public TonalPalette f32583a2;

    /* renamed from: a3, reason: collision with root package name */
    public TonalPalette f32584a3;
    public TonalPalette error;

    /* renamed from: n1, reason: collision with root package name */
    public TonalPalette f32585n1;

    /* renamed from: n2, reason: collision with root package name */
    public TonalPalette f32586n2;

    public static CorePalette contentOf(int i6) {
        return new CorePalette(i6, true);
    }

    public static CorePalette of(int i6) {
        return new CorePalette(i6, false);
    }

    private CorePalette(int i6, boolean z5) {
        Hct fromInt = Hct.fromInt(i6);
        double hue = fromInt.getHue();
        double chroma = fromInt.getChroma();
        if (z5) {
            this.f32582a1 = TonalPalette.fromHueAndChroma(hue, chroma);
            this.f32583a2 = TonalPalette.fromHueAndChroma(hue, chroma / 3.0d);
            this.f32584a3 = TonalPalette.fromHueAndChroma(60.0d + hue, chroma / 2.0d);
            this.f32585n1 = TonalPalette.fromHueAndChroma(hue, Math.min(chroma / 12.0d, 4.0d));
            this.f32586n2 = TonalPalette.fromHueAndChroma(hue, Math.min(chroma / 6.0d, 8.0d));
        } else {
            this.f32582a1 = TonalPalette.fromHueAndChroma(hue, Math.max(48.0d, chroma));
            this.f32583a2 = TonalPalette.fromHueAndChroma(hue, 16.0d);
            this.f32584a3 = TonalPalette.fromHueAndChroma(60.0d + hue, 24.0d);
            this.f32585n1 = TonalPalette.fromHueAndChroma(hue, 4.0d);
            this.f32586n2 = TonalPalette.fromHueAndChroma(hue, 8.0d);
        }
        this.error = TonalPalette.fromHueAndChroma(25.0d, 84.0d);
    }
}
