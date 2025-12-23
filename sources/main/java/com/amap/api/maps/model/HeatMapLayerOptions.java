package com.amap.api.maps.model;

import android.graphics.Color;
import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.net.ftp.l;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JBindingInclude
/* loaded from: D:\Downloads\app\classes2.dex */
public class HeatMapLayerOptions extends BaseOptions {

    @JBindingExclude
    public static final Gradient DEFAULT_GRADIENT;

    @JBindingExclude
    private static final int[] DEFAULT_GRADIENT_COLORS;

    @JBindingExclude
    private static final float[] DEFAULT_GRADIENT_START_POINTS;

    @JBindingExclude
    public static final double DEFAULT_OPACITY = 0.6d;

    @JBindingExclude
    public static final int DEFAULT_RADIUS = 12;

    @JBindingExclude
    public static final int TYPE_GRID = 1;

    @JBindingExclude
    public static final int TYPE_HEXAGON = 2;

    @JBindingExclude
    public static final int TYPE_NORMAL = 0;
    private int[] mColors;

    @JBindingExclude
    private Collection<WeightedLatLng> mData;
    private double mLatitude;
    private float[] mStartPoints;
    private double[] pointList;

    @JBindingExclude
    private Gradient mGradient = DEFAULT_GRADIENT;
    private float mSize = 2000.0f;
    private float mOpacity = 1.0f;
    private double maxIntensity = 0.0d;
    private float maxZoom = 20.0f;
    private float minZoom = 3.0f;
    private float mGap = 0.0f;
    private int mType = 2;
    private float zIndex = 0.0f;
    private boolean isVisible = true;
    private boolean isPointsUpdated = false;

    private static Collection<WeightedLatLng> a(Collection<LatLng> collection) {
        ArrayList arrayList = new ArrayList();
        Iterator<LatLng> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(new WeightedLatLng(it.next()));
        }
        return arrayList;
    }

    static {
        int[] iArr = {Color.rgb(102, l.f50687n, 0), Color.rgb(255, 0, 0)};
        DEFAULT_GRADIENT_COLORS = iArr;
        float[] fArr = {0.2f, 1.0f};
        DEFAULT_GRADIENT_START_POINTS = fArr;
        DEFAULT_GRADIENT = new Gradient(iArr, fArr);
    }

    public HeatMapLayerOptions gap(float f6) {
        this.mGap = f6;
        return this;
    }

    public Collection<WeightedLatLng> getData() {
        return this.mData;
    }

    public float getGap() {
        return this.mGap;
    }

    public Gradient getGradient() {
        return this.mGradient;
    }

    public double getMaxIntensity() {
        return this.maxIntensity;
    }

    public float getMaxZoom() {
        return this.maxZoom;
    }

    public float getMinZoom() {
        return this.minZoom;
    }

    public float getOpacity() {
        return this.mOpacity;
    }

    public float getSize() {
        return this.mSize;
    }

    public int getType() {
        return this.mType;
    }

    public float getZIndex() {
        return this.zIndex;
    }

    public HeatMapLayerOptions gradient(Gradient gradient) {
        this.mGradient = gradient;
        if (gradient != null) {
            this.mColors = gradient.getColors();
            this.mStartPoints = this.mGradient.getStartPoints();
        }
        return this;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public HeatMapLayerOptions maxIntensity(double d6) {
        this.maxIntensity = d6;
        return this;
    }

    public HeatMapLayerOptions maxZoom(float f6) {
        this.maxZoom = f6;
        return this;
    }

    public HeatMapLayerOptions minZoom(float f6) {
        this.minZoom = f6;
        return this;
    }

    public HeatMapLayerOptions opacity(float f6) {
        this.mOpacity = Math.max(0.0f, Math.min(f6, 1.0f));
        return this;
    }

    public HeatMapLayerOptions size(float f6) {
        this.mSize = f6;
        return this;
    }

    public HeatMapLayerOptions type(int i6) {
        this.mType = i6;
        return this;
    }

    public HeatMapLayerOptions visible(boolean z5) {
        this.isVisible = z5;
        return this;
    }

    public HeatMapLayerOptions weightedData(Collection<WeightedLatLng> collection) {
        this.mData = collection;
        this.isPointsUpdated = true;
        a();
        return this;
    }

    public HeatMapLayerOptions zIndex(float f6) {
        this.zIndex = f6;
        return this;
    }

    public HeatMapLayerOptions() {
        this.type = "HeatMapLayerOptions";
    }

    public HeatMapLayerOptions data(Collection<LatLng> collection) {
        return weightedData(a(collection));
    }

    private void a() {
        Collection<WeightedLatLng> data;
        LatLng latLng;
        if (!this.isPointsUpdated || (data = getData()) == null) {
            return;
        }
        this.pointList = new double[data.size() * 3];
        double d6 = Double.NaN;
        double d7 = Double.NaN;
        int i6 = 0;
        for (WeightedLatLng weightedLatLng : data) {
            if (weightedLatLng != null && (latLng = weightedLatLng.latLng) != null) {
                double[] dArr = this.pointList;
                int i7 = i6 * 3;
                double d8 = latLng.latitude;
                dArr[i7] = d8;
                dArr[i7 + 1] = latLng.longitude;
                dArr[i7 + 2] = weightedLatLng.intensity;
                i6++;
                if (Double.isNaN(d6)) {
                    d6 = d8;
                }
                if (Double.isNaN(d7)) {
                    d7 = d8;
                }
                if (d8 > d7) {
                    d7 = d8;
                }
                if (d8 < d6) {
                    d6 = d8;
                }
            }
        }
        this.mLatitude = (Double.isNaN(d6) || Double.isNaN(d7)) ? 0.0d : (d6 + d7) / 2.0d;
    }
}
