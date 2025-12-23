package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.components.YAxis;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class Highlight {
    private YAxis.AxisDependency axis;
    private int mDataIndex;
    private int mDataSetIndex;
    private float mDrawX;
    private float mDrawY;
    private int mStackIndex;
    private float mX;
    private float mXPx;
    private float mY;
    private float mYPx;

    public Highlight(float f6, float f7, int i6) {
        this.mDataIndex = -1;
        this.mStackIndex = -1;
        this.mX = f6;
        this.mY = f7;
        this.mDataSetIndex = i6;
    }

    public boolean equalTo(Highlight highlight) {
        return highlight != null && this.mDataSetIndex == highlight.mDataSetIndex && this.mX == highlight.mX && this.mStackIndex == highlight.mStackIndex && this.mDataIndex == highlight.mDataIndex;
    }

    public YAxis.AxisDependency getAxis() {
        return this.axis;
    }

    public int getDataIndex() {
        return this.mDataIndex;
    }

    public int getDataSetIndex() {
        return this.mDataSetIndex;
    }

    public float getDrawX() {
        return this.mDrawX;
    }

    public float getDrawY() {
        return this.mDrawY;
    }

    public int getStackIndex() {
        return this.mStackIndex;
    }

    public float getX() {
        return this.mX;
    }

    public float getXPx() {
        return this.mXPx;
    }

    public float getY() {
        return this.mY;
    }

    public float getYPx() {
        return this.mYPx;
    }

    public boolean isStacked() {
        return this.mStackIndex >= 0;
    }

    public void setDataIndex(int i6) {
        this.mDataIndex = i6;
    }

    public void setDraw(float f6, float f7) {
        this.mDrawX = f6;
        this.mDrawY = f7;
    }

    public String toString() {
        return "Highlight, x: " + this.mX + ", y: " + this.mY + ", dataSetIndex: " + this.mDataSetIndex + ", stackIndex (only stacked barentry): " + this.mStackIndex;
    }

    public Highlight(float f6, int i6, int i7) {
        this(f6, Float.NaN, i6);
        this.mStackIndex = i7;
    }

    public Highlight(float f6, float f7, float f8, float f9, int i6, YAxis.AxisDependency axisDependency) {
        this.mDataIndex = -1;
        this.mStackIndex = -1;
        this.mX = f6;
        this.mY = f7;
        this.mXPx = f8;
        this.mYPx = f9;
        this.mDataSetIndex = i6;
        this.axis = axisDependency;
    }

    public Highlight(float f6, float f7, float f8, float f9, int i6, int i7, YAxis.AxisDependency axisDependency) {
        this(f6, f7, f8, f9, i6, axisDependency);
        this.mStackIndex = i7;
    }
}
