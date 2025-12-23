package com.github.mikephil.charting.highlight;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class Range {
    public float from;
    public float to;

    public boolean contains(float f6) {
        return f6 > this.from && f6 <= this.to;
    }

    public boolean isLarger(float f6) {
        return f6 > this.to;
    }

    public boolean isSmaller(float f6) {
        return f6 < this.from;
    }

    public Range(float f6, float f7) {
        this.from = f6;
        this.to = f7;
    }
}
