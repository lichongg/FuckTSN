package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes5.dex */
public class Blend {
    private Blend() {
    }

    public static int cam16Ucs(int i6, int i7, double d6) {
        Cam16 fromInt = Cam16.fromInt(i6);
        Cam16 fromInt2 = Cam16.fromInt(i7);
        double jstar = fromInt.getJstar();
        double astar = fromInt.getAstar();
        double bstar = fromInt.getBstar();
        return Cam16.fromUcs(jstar + ((fromInt2.getJstar() - jstar) * d6), astar + ((fromInt2.getAstar() - astar) * d6), bstar + ((fromInt2.getBstar() - bstar) * d6)).toInt();
    }

    public static int harmonize(int i6, int i7) {
        Hct fromInt = Hct.fromInt(i6);
        Hct fromInt2 = Hct.fromInt(i7);
        return Hct.from(MathUtils.sanitizeDegreesDouble(fromInt.getHue() + (Math.min(MathUtils.differenceDegrees(fromInt.getHue(), fromInt2.getHue()) * 0.5d, 15.0d) * MathUtils.rotationDirection(fromInt.getHue(), fromInt2.getHue()))), fromInt.getChroma(), fromInt.getTone()).toInt();
    }

    public static int hctHue(int i6, int i7, double d6) {
        return Hct.from(Cam16.fromInt(cam16Ucs(i6, i7, d6)).getHue(), Cam16.fromInt(i6).getChroma(), ColorUtils.lstarFromArgb(i6)).toInt();
    }
}
