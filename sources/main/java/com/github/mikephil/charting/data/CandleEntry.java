package com.github.mikephil.charting.data;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"ParcelCreator"})
/* loaded from: D:\Downloads\app\classes4.dex */
public class CandleEntry extends Entry {
    private float mClose;
    private float mOpen;
    private float mShadowHigh;
    private float mShadowLow;

    public CandleEntry(float f6, float f7, float f8, float f9, float f10) {
        super(f6, (f7 + f8) / 2.0f);
        this.mShadowHigh = f7;
        this.mShadowLow = f8;
        this.mOpen = f9;
        this.mClose = f10;
    }

    @Override // com.github.mikephil.charting.data.Entry
    public CandleEntry copy() {
        return new CandleEntry(getX(), this.mShadowHigh, this.mShadowLow, this.mOpen, this.mClose, getData());
    }

    public float getBodyRange() {
        return Math.abs(this.mOpen - this.mClose);
    }

    public float getClose() {
        return this.mClose;
    }

    public float getHigh() {
        return this.mShadowHigh;
    }

    public float getLow() {
        return this.mShadowLow;
    }

    public float getOpen() {
        return this.mOpen;
    }

    public float getShadowRange() {
        return Math.abs(this.mShadowHigh - this.mShadowLow);
    }

    public void setClose(float f6) {
        this.mClose = f6;
    }

    public void setHigh(float f6) {
        this.mShadowHigh = f6;
    }

    public void setLow(float f6) {
        this.mShadowLow = f6;
    }

    public void setOpen(float f6) {
        this.mOpen = f6;
    }

    @Override // com.github.mikephil.charting.data.BaseEntry
    public float getY() {
        return super.getY();
    }

    public CandleEntry(float f6, float f7, float f8, float f9, float f10, Object obj) {
        super(f6, (f7 + f8) / 2.0f, obj);
        this.mShadowHigh = f7;
        this.mShadowLow = f8;
        this.mOpen = f9;
        this.mClose = f10;
    }

    public CandleEntry(float f6, float f7, float f8, float f9, float f10, Drawable drawable) {
        super(f6, (f7 + f8) / 2.0f, drawable);
        this.mShadowHigh = f7;
        this.mShadowLow = f8;
        this.mOpen = f9;
        this.mClose = f10;
    }

    public CandleEntry(float f6, float f7, float f8, float f9, float f10, Drawable drawable, Object obj) {
        super(f6, (f7 + f8) / 2.0f, drawable, obj);
        this.mShadowHigh = f7;
        this.mShadowLow = f8;
        this.mOpen = f9;
        this.mClose = f10;
    }
}
