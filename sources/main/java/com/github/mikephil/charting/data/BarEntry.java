package com.github.mikephil.charting.data;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.highlight.Range;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"ParcelCreator"})
/* loaded from: D:\Downloads\app\classes4.dex */
public class BarEntry extends Entry {
    private float mNegativeSum;
    private float mPositiveSum;
    private Range[] mRanges;
    private float[] mYVals;

    public BarEntry(float f6, float f7) {
        super(f6, f7);
    }

    private static float calcSum(float[] fArr) {
        float f6 = 0.0f;
        if (fArr == null) {
            return 0.0f;
        }
        for (float f7 : fArr) {
            f6 += f7;
        }
        return f6;
    }

    public BarEntry(float f6, float f7, Object obj) {
        super(f6, f7, obj);
    }

    private void calcPosNegSum() {
        float[] fArr = this.mYVals;
        if (fArr == null) {
            this.mNegativeSum = 0.0f;
            this.mPositiveSum = 0.0f;
            return;
        }
        float f6 = 0.0f;
        float f7 = 0.0f;
        for (float f8 : fArr) {
            if (f8 <= 0.0f) {
                f6 += Math.abs(f8);
            } else {
                f7 += f8;
            }
        }
        this.mNegativeSum = f6;
        this.mPositiveSum = f7;
    }

    @Override // com.github.mikephil.charting.data.Entry
    public BarEntry copy() {
        BarEntry barEntry = new BarEntry(getX(), getY(), getData());
        barEntry.setVals(this.mYVals);
        return barEntry;
    }

    public float getNegativeSum() {
        return this.mNegativeSum;
    }

    public float getPositiveSum() {
        return this.mPositiveSum;
    }

    public Range[] getRanges() {
        return this.mRanges;
    }

    public float getSumBelow(int i6) {
        float[] fArr = this.mYVals;
        float f6 = 0.0f;
        if (fArr == null) {
            return 0.0f;
        }
        for (int length = fArr.length - 1; length > i6 && length >= 0; length--) {
            f6 += this.mYVals[length];
        }
        return f6;
    }

    public float[] getYVals() {
        return this.mYVals;
    }

    public boolean isStacked() {
        return this.mYVals != null;
    }

    public BarEntry(float f6, float f7, Drawable drawable) {
        super(f6, f7, drawable);
    }

    protected void calcRanges() {
        float[] yVals = getYVals();
        if (yVals != null && yVals.length != 0) {
            this.mRanges = new Range[yVals.length];
            float f6 = -getNegativeSum();
            int i6 = 0;
            float f7 = 0.0f;
            while (true) {
                Range[] rangeArr = this.mRanges;
                if (i6 < rangeArr.length) {
                    float f8 = yVals[i6];
                    if (f8 < 0.0f) {
                        float f9 = f6 - f8;
                        rangeArr[i6] = new Range(f6, f9);
                        f6 = f9;
                    } else {
                        float f10 = f8 + f7;
                        rangeArr[i6] = new Range(f7, f10);
                        f7 = f10;
                    }
                    i6++;
                } else {
                    return;
                }
            }
        }
    }

    @Deprecated
    public float getBelowSum(int i6) {
        return getSumBelow(i6);
    }

    @Override // com.github.mikephil.charting.data.BaseEntry
    public float getY() {
        return super.getY();
    }

    public void setVals(float[] fArr) {
        setY(calcSum(fArr));
        this.mYVals = fArr;
        calcPosNegSum();
        calcRanges();
    }

    public BarEntry(float f6, float f7, Drawable drawable, Object obj) {
        super(f6, f7, drawable, obj);
    }

    public BarEntry(float f6, float[] fArr) {
        super(f6, calcSum(fArr));
        this.mYVals = fArr;
        calcPosNegSum();
        calcRanges();
    }

    public BarEntry(float f6, float[] fArr, Object obj) {
        super(f6, calcSum(fArr), obj);
        this.mYVals = fArr;
        calcPosNegSum();
        calcRanges();
    }

    public BarEntry(float f6, float[] fArr, Drawable drawable) {
        super(f6, calcSum(fArr), drawable);
        this.mYVals = fArr;
        calcPosNegSum();
        calcRanges();
    }

    public BarEntry(float f6, float[] fArr, Drawable drawable, Object obj) {
        super(f6, calcSum(fArr), drawable, obj);
        this.mYVals = fArr;
        calcPosNegSum();
        calcRanges();
    }
}
