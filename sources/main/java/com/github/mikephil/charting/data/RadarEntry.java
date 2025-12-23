package com.github.mikephil.charting.data;

import android.annotation.SuppressLint;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"ParcelCreator"})
/* loaded from: D:\Downloads\app\classes4.dex */
public class RadarEntry extends Entry {
    public RadarEntry(float f6) {
        super(0.0f, f6);
    }

    public RadarEntry(float f6, Object obj) {
        super(0.0f, f6, obj);
    }

    @Override // com.github.mikephil.charting.data.Entry
    public RadarEntry copy() {
        return new RadarEntry(getY(), getData());
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
}
