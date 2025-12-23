package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class RadarDataSet extends LineRadarDataSet<RadarEntry> implements IRadarDataSet {
    protected boolean mDrawHighlightCircleEnabled;
    protected int mHighlightCircleFillColor;
    protected float mHighlightCircleInnerRadius;
    protected float mHighlightCircleOuterRadius;
    protected int mHighlightCircleStrokeAlpha;
    protected int mHighlightCircleStrokeColor;
    protected float mHighlightCircleStrokeWidth;

    @Override // com.github.mikephil.charting.data.DataSet
    public DataSet<RadarEntry> copy() {
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < this.mValues.size(); i6++) {
            arrayList.add(((RadarEntry) this.mValues.get(i6)).copy());
        }
        RadarDataSet radarDataSet = new RadarDataSet(arrayList, getLabel());
        copy(radarDataSet);
        return radarDataSet;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IRadarDataSet
    public int getHighlightCircleFillColor() {
        return this.mHighlightCircleFillColor;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IRadarDataSet
    public float getHighlightCircleInnerRadius() {
        return this.mHighlightCircleInnerRadius;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IRadarDataSet
    public float getHighlightCircleOuterRadius() {
        return this.mHighlightCircleOuterRadius;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IRadarDataSet
    public int getHighlightCircleStrokeAlpha() {
        return this.mHighlightCircleStrokeAlpha;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IRadarDataSet
    public int getHighlightCircleStrokeColor() {
        return this.mHighlightCircleStrokeColor;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IRadarDataSet
    public float getHighlightCircleStrokeWidth() {
        return this.mHighlightCircleStrokeWidth;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IRadarDataSet
    public boolean isDrawHighlightCircleEnabled() {
        return this.mDrawHighlightCircleEnabled;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IRadarDataSet
    public void setDrawHighlightCircleEnabled(boolean z5) {
        this.mDrawHighlightCircleEnabled = z5;
    }

    public void setHighlightCircleFillColor(int i6) {
        this.mHighlightCircleFillColor = i6;
    }

    public void setHighlightCircleInnerRadius(float f6) {
        this.mHighlightCircleInnerRadius = f6;
    }

    public void setHighlightCircleOuterRadius(float f6) {
        this.mHighlightCircleOuterRadius = f6;
    }

    public void setHighlightCircleStrokeAlpha(int i6) {
        this.mHighlightCircleStrokeAlpha = i6;
    }

    public void setHighlightCircleStrokeColor(int i6) {
        this.mHighlightCircleStrokeColor = i6;
    }

    public void setHighlightCircleStrokeWidth(float f6) {
        this.mHighlightCircleStrokeWidth = f6;
    }

    public RadarDataSet(List<RadarEntry> list, String str) {
        super(list, str);
        this.mDrawHighlightCircleEnabled = false;
        this.mHighlightCircleFillColor = -1;
        this.mHighlightCircleStrokeColor = ColorTemplate.COLOR_NONE;
        this.mHighlightCircleStrokeAlpha = 76;
        this.mHighlightCircleInnerRadius = 3.0f;
        this.mHighlightCircleOuterRadius = 4.0f;
        this.mHighlightCircleStrokeWidth = 2.0f;
    }

    protected void copy(RadarDataSet radarDataSet) {
        super.copy((LineRadarDataSet) radarDataSet);
        radarDataSet.mDrawHighlightCircleEnabled = this.mDrawHighlightCircleEnabled;
        radarDataSet.mHighlightCircleFillColor = this.mHighlightCircleFillColor;
        radarDataSet.mHighlightCircleInnerRadius = this.mHighlightCircleInnerRadius;
        radarDataSet.mHighlightCircleStrokeAlpha = this.mHighlightCircleStrokeAlpha;
        radarDataSet.mHighlightCircleStrokeColor = this.mHighlightCircleStrokeColor;
        radarDataSet.mHighlightCircleStrokeWidth = this.mHighlightCircleStrokeWidth;
    }
}
