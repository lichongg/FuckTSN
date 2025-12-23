package com.github.mikephil.charting.data;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"ParcelCreator"})
/* loaded from: D:\Downloads\app\classes4.dex */
public class BubbleEntry extends Entry {
    private float mSize;

    public BubbleEntry(float f6, float f7, float f8) {
        super(f6, f7);
        this.mSize = f8;
    }

    @Override // com.github.mikephil.charting.data.Entry
    public BubbleEntry copy() {
        return new BubbleEntry(getX(), getY(), this.mSize, getData());
    }

    public float getSize() {
        return this.mSize;
    }

    public void setSize(float f6) {
        this.mSize = f6;
    }

    public BubbleEntry(float f6, float f7, float f8, Object obj) {
        super(f6, f7, obj);
        this.mSize = f8;
    }

    public BubbleEntry(float f6, float f7, float f8, Drawable drawable) {
        super(f6, f7, drawable);
        this.mSize = f8;
    }

    public BubbleEntry(float f6, float f7, float f8, Drawable drawable, Object obj) {
        super(f6, f7, drawable, obj);
        this.mSize = f8;
    }
}
