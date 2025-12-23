package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes5.dex */
public class SchemeContent extends DynamicScheme {
    public SchemeContent(Hct hct, boolean z5, double d6) {
        super(hct, Variant.CONTENT, z5, d6, TonalPalette.fromHueAndChroma(hct.getHue(), hct.getChroma()), TonalPalette.fromHueAndChroma(hct.getHue(), Math.max(hct.getChroma() - 32.0d, hct.getChroma() * 0.5d)), TonalPalette.fromHct(DislikeAnalyzer.fixIfDisliked(new TemperatureCache(hct).getAnalogousColors(3, 6).get(2))), TonalPalette.fromHueAndChroma(hct.getHue(), hct.getChroma() / 8.0d), TonalPalette.fromHueAndChroma(hct.getHue(), (hct.getChroma() / 8.0d) + 4.0d));
    }
}
