package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes5.dex */
public final class Hct {
    private int argb;
    private double chroma;
    private double hue;
    private double tone;

    public static Hct fromInt(int i6) {
        return new Hct(i6);
    }

    private void setInternalState(int i6) {
        this.argb = i6;
        Cam16 fromInt = Cam16.fromInt(i6);
        this.hue = fromInt.getHue();
        this.chroma = fromInt.getChroma();
        this.tone = ColorUtils.lstarFromArgb(i6);
    }

    public double getChroma() {
        return this.chroma;
    }

    public double getHue() {
        return this.hue;
    }

    public double getTone() {
        return this.tone;
    }

    public void setChroma(double d6) {
        setInternalState(HctSolver.solveToInt(this.hue, d6, this.tone));
    }

    public void setHue(double d6) {
        setInternalState(HctSolver.solveToInt(d6, this.chroma, this.tone));
    }

    public void setTone(double d6) {
        setInternalState(HctSolver.solveToInt(this.hue, this.chroma, d6));
    }

    public int toInt() {
        return this.argb;
    }

    private Hct(int i6) {
        setInternalState(i6);
    }

    public static Hct from(double d6, double d7, double d8) {
        return new Hct(HctSolver.solveToInt(d6, d7, d8));
    }

    public Hct inViewingConditions(ViewingConditions viewingConditions) {
        double[] xyzInViewingConditions = Cam16.fromInt(toInt()).xyzInViewingConditions(viewingConditions, null);
        Cam16 fromXyzInViewingConditions = Cam16.fromXyzInViewingConditions(xyzInViewingConditions[0], xyzInViewingConditions[1], xyzInViewingConditions[2], ViewingConditions.DEFAULT);
        return from(fromXyzInViewingConditions.getHue(), fromXyzInViewingConditions.getChroma(), ColorUtils.lstarFromY(xyzInViewingConditions[1]));
    }
}
