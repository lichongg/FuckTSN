package com.amap.api.maps.model;

import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JBindingInclude
/* loaded from: D:\Downloads\app\classes2.dex */
public class HeatMapGridLayerOptions extends BaseOptions {

    @JBindingExclude
    public static final int TYPE_GRID = 1;

    @JBindingExclude
    public static final int TYPE_HEXAGON = 2;

    @JBindingExclude
    public static final int TYPE_NORMAL = 0;
    private List<ColorLatLng> mData;
    private float maxZoom = 20.0f;
    private float minZoom = 3.0f;
    private float zIndex = 0.0f;
    private boolean isVisible = true;
    private int mType = 2;
    private boolean isPointsUpdated = false;

    public HeatMapGridLayerOptions data(List<ColorLatLng> list) {
        this.mData = list;
        this.isPointsUpdated = true;
        return this;
    }

    public List<ColorLatLng> getData() {
        return this.mData;
    }

    public float getMaxZoom() {
        return this.maxZoom;
    }

    public float getMinZoom() {
        return this.minZoom;
    }

    public int getType() {
        return this.mType;
    }

    public float getZIndex() {
        return this.zIndex;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public HeatMapGridLayerOptions maxZoom(float f6) {
        this.maxZoom = f6;
        return this;
    }

    public HeatMapGridLayerOptions minZoom(float f6) {
        this.minZoom = f6;
        return this;
    }

    public HeatMapGridLayerOptions type(int i6) {
        this.mType = i6;
        return this;
    }

    public HeatMapGridLayerOptions visible(boolean z5) {
        this.isVisible = z5;
        return this;
    }

    public HeatMapGridLayerOptions zIndex(float f6) {
        this.zIndex = f6;
        return this;
    }

    public HeatMapGridLayerOptions() {
        this.type = "HeatMapGridLayerOptions";
    }
}
