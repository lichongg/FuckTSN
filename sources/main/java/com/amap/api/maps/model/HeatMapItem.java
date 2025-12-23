package com.amap.api.maps.model;

import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JBindingInclude
/* loaded from: D:\Downloads\app\classes2.dex */
public class HeatMapItem {
    private LatLng center;
    private int[] indexes;
    private double intensity;

    public LatLng getCenter() {
        return this.center;
    }

    public int[] getIndexes() {
        return this.indexes;
    }

    public double getIntensity() {
        return this.intensity;
    }

    public void setCenter(double d6, double d7) {
        this.center = new LatLng(d6, d7);
    }

    public void setIndexes(int[] iArr) {
        this.indexes = iArr;
    }

    public void setIntensity(double d6) {
        this.intensity = d6;
    }
}
