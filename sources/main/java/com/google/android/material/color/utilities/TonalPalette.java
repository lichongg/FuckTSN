package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes5.dex */
public final class TonalPalette {
    Map<Integer, Integer> cache = new HashMap();
    double chroma;
    double hue;
    Hct keyColor;

    private static Hct createKeyColor(double d6, double d7) {
        Hct from = Hct.from(d6, d7, 50.0d);
        double abs = Math.abs(from.getChroma() - d7);
        for (double d8 = 1.0d; d8 < 50.0d && Math.round(d7) != Math.round(from.getChroma()); d8 += 1.0d) {
            Hct from2 = Hct.from(d6, d7, 50.0d + d8);
            double abs2 = Math.abs(from2.getChroma() - d7);
            if (abs2 < abs) {
                abs = abs2;
                from = from2;
            }
            Hct from3 = Hct.from(d6, d7, 50.0d - d8);
            double abs3 = Math.abs(from3.getChroma() - d7);
            if (abs3 < abs) {
                abs = abs3;
                from = from3;
            }
        }
        return from;
    }

    public static TonalPalette fromHct(Hct hct) {
        return new TonalPalette(hct.getHue(), hct.getChroma(), hct);
    }

    public static TonalPalette fromHueAndChroma(double d6, double d7) {
        return new TonalPalette(d6, d7, createKeyColor(d6, d7));
    }

    public double getChroma() {
        return this.chroma;
    }

    public Hct getHct(double d6) {
        return Hct.from(this.hue, this.chroma, d6);
    }

    public double getHue() {
        return this.hue;
    }

    public Hct getKeyColor() {
        return this.keyColor;
    }

    public int tone(int i6) {
        Integer num = this.cache.get(Integer.valueOf(i6));
        if (num == null) {
            num = Integer.valueOf(Hct.from(this.hue, this.chroma, i6).toInt());
            this.cache.put(Integer.valueOf(i6), num);
        }
        return num.intValue();
    }

    private TonalPalette(double d6, double d7, Hct hct) {
        this.hue = d6;
        this.chroma = d7;
        this.keyColor = hct;
    }

    public static TonalPalette fromInt(int i6) {
        return fromHct(Hct.fromInt(i6));
    }
}
