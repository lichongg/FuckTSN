package com.github.mikephil.charting.buffer;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class BarBuffer extends AbstractBuffer<IBarDataSet> {
    protected float mBarWidth;
    protected boolean mContainsStacks;
    protected int mDataSetCount;
    protected int mDataSetIndex;
    protected boolean mInverted;

    protected void addBar(float f6, float f7, float f8, float f9) {
        float[] fArr = this.buffer;
        int i6 = this.index;
        int i7 = i6 + 1;
        this.index = i7;
        fArr[i6] = f6;
        int i8 = i6 + 2;
        this.index = i8;
        fArr[i7] = f7;
        int i9 = i6 + 3;
        this.index = i9;
        fArr[i8] = f8;
        this.index = i6 + 4;
        fArr[i9] = f9;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.buffer.AbstractBuffer
    public void feed(IBarDataSet iBarDataSet) {
        float f6;
        float abs;
        float abs2;
        float f7;
        float entryCount = iBarDataSet.getEntryCount() * this.phaseX;
        float f8 = this.mBarWidth / 2.0f;
        for (int i6 = 0; i6 < entryCount; i6++) {
            BarEntry barEntry = (BarEntry) iBarDataSet.getEntryForIndex(i6);
            if (barEntry != null) {
                float x5 = barEntry.getX();
                float y5 = barEntry.getY();
                float[] yVals = barEntry.getYVals();
                if (!this.mContainsStacks || yVals == null) {
                    float f9 = x5 - f8;
                    float f10 = x5 + f8;
                    if (this.mInverted) {
                        f6 = y5 >= 0.0f ? y5 : 0.0f;
                        if (y5 > 0.0f) {
                            y5 = 0.0f;
                        }
                    } else {
                        float f11 = y5 >= 0.0f ? y5 : 0.0f;
                        if (y5 > 0.0f) {
                            y5 = 0.0f;
                        }
                        float f12 = y5;
                        y5 = f11;
                        f6 = f12;
                    }
                    if (y5 > 0.0f) {
                        y5 *= this.phaseY;
                    } else {
                        f6 *= this.phaseY;
                    }
                    addBar(f9, y5, f10, f6);
                } else {
                    float f13 = -barEntry.getNegativeSum();
                    int i7 = 0;
                    float f14 = 0.0f;
                    while (i7 < yVals.length) {
                        float f15 = yVals[i7];
                        if (f15 == 0.0f && (f14 == 0.0f || f13 == 0.0f)) {
                            abs = f15;
                            abs2 = f13;
                            f13 = abs;
                        } else if (f15 >= 0.0f) {
                            abs = f15 + f14;
                            abs2 = f13;
                            f13 = f14;
                            f14 = abs;
                        } else {
                            abs = Math.abs(f15) + f13;
                            abs2 = Math.abs(f15) + f13;
                        }
                        float f16 = x5 - f8;
                        float f17 = x5 + f8;
                        if (this.mInverted) {
                            f7 = f13 >= abs ? f13 : abs;
                            if (f13 > abs) {
                                f13 = abs;
                            }
                        } else {
                            float f18 = f13 >= abs ? f13 : abs;
                            if (f13 > abs) {
                                f13 = abs;
                            }
                            float f19 = f13;
                            f13 = f18;
                            f7 = f19;
                        }
                        float f20 = this.phaseY;
                        addBar(f16, f13 * f20, f17, f7 * f20);
                        i7++;
                        f13 = abs2;
                    }
                }
            }
        }
        reset();
    }

    public void setBarWidth(float f6) {
        this.mBarWidth = f6;
    }

    public void setDataSet(int i6) {
        this.mDataSetIndex = i6;
    }

    public void setInverted(boolean z5) {
        this.mInverted = z5;
    }

    public BarBuffer(int i6, int i7, boolean z5) {
        super(i6);
        this.mDataSetIndex = 0;
        this.mInverted = false;
        this.mBarWidth = 1.0f;
        this.mDataSetCount = i7;
        this.mContainsStacks = z5;
    }
}
