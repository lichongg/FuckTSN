package com.github.mikephil.charting.data;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"ParcelCreator"})
/* loaded from: D:\Downloads\app\classes4.dex */
public class PieEntry extends Entry {
    private String label;

    public PieEntry(float f6) {
        super(0.0f, f6);
    }

    public PieEntry(float f6, Object obj) {
        super(0.0f, f6, obj);
    }

    @Override // com.github.mikephil.charting.data.Entry
    public PieEntry copy() {
        return new PieEntry(getY(), this.label, getData());
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public PieEntry(float f6, Drawable drawable) {
        super(0.0f, f6, drawable);
    }

    public float getValue() {
        return getY();
    }

    @Override // com.github.mikephil.charting.data.Entry
    @Deprecated
    public float getX() {
        return super.getX();
    }

    @Override // com.github.mikephil.charting.data.Entry
    @Deprecated
    public void setX(float f6) {
        super.setX(f6);
    }

    public PieEntry(float f6, Drawable drawable, Object obj) {
        super(0.0f, f6, drawable, obj);
    }

    public PieEntry(float f6, String str) {
        super(0.0f, f6);
        this.label = str;
    }

    public PieEntry(float f6, String str, Object obj) {
        super(0.0f, f6, obj);
        this.label = str;
    }

    public PieEntry(float f6, String str, Drawable drawable) {
        super(0.0f, f6, drawable);
        this.label = str;
    }

    public PieEntry(float f6, String str, Drawable drawable, Object obj) {
        super(0.0f, f6, drawable, obj);
        this.label = str;
    }
}
