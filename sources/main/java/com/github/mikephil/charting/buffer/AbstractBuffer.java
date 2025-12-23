package com.github.mikephil.charting.buffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class AbstractBuffer<T> {
    public final float[] buffer;
    protected float phaseX = 1.0f;
    protected float phaseY = 1.0f;
    protected int mFrom = 0;
    protected int mTo = 0;
    protected int index = 0;

    public abstract void feed(T t5);

    public void reset() {
        this.index = 0;
    }

    public void limitFrom(int i6) {
        if (i6 < 0) {
            i6 = 0;
        }
        this.mFrom = i6;
    }

    public void limitTo(int i6) {
        if (i6 < 0) {
            i6 = 0;
        }
        this.mTo = i6;
    }

    public void setPhases(float f6, float f7) {
        this.phaseX = f6;
        this.phaseY = f7;
    }

    public int size() {
        return this.buffer.length;
    }

    public AbstractBuffer(int i6) {
        this.buffer = new float[i6];
    }
}
