package com.github.mikephil.charting.components;

import android.graphics.DashPathEffect;
import com.github.mikephil.charting.formatter.DefaultAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class AxisBase extends ComponentBase {
    protected ValueFormatter mAxisValueFormatter;
    public int mDecimals;
    public int mEntryCount;
    protected List<LimitLine> mLimitLines;
    private int mGridColor = -7829368;
    private float mGridLineWidth = 1.0f;
    private int mAxisLineColor = -7829368;
    private float mAxisLineWidth = 1.0f;
    public float[] mEntries = new float[0];
    public float[] mCenteredEntries = new float[0];
    private int mLabelCount = 6;
    protected float mGranularity = 1.0f;
    protected boolean mGranularityEnabled = false;
    protected boolean mForceLabels = false;
    protected boolean mDrawGridLines = true;
    protected boolean mDrawAxisLine = true;
    protected boolean mDrawLabels = true;
    protected boolean mCenterAxisLabels = false;
    private DashPathEffect mAxisLineDashPathEffect = null;
    private DashPathEffect mGridDashPathEffect = null;
    protected boolean mDrawLimitLineBehindData = false;
    protected boolean mDrawGridLinesBehindData = true;
    protected float mSpaceMin = 0.0f;
    protected float mSpaceMax = 0.0f;
    protected boolean mCustomAxisMin = false;
    protected boolean mCustomAxisMax = false;
    public float mAxisMaximum = 0.0f;
    public float mAxisMinimum = 0.0f;
    public float mAxisRange = 0.0f;

    public void disableAxisLineDashedLine() {
        this.mAxisLineDashPathEffect = null;
    }

    public void disableGridDashedLine() {
        this.mGridDashPathEffect = null;
    }

    public void resetAxisMaximum() {
        this.mCustomAxisMax = false;
    }

    public void resetAxisMinimum() {
        this.mCustomAxisMin = false;
    }

    public void setAxisMaximum(float f6) {
        this.mCustomAxisMax = true;
        this.mAxisMaximum = f6;
        this.mAxisRange = Math.abs(f6 - this.mAxisMinimum);
    }

    public void setAxisMinimum(float f6) {
        this.mCustomAxisMin = true;
        this.mAxisMinimum = f6;
        this.mAxisRange = Math.abs(this.mAxisMaximum - f6);
    }

    public void setLabelCount(int i6) {
        if (i6 > 25) {
            i6 = 25;
        }
        if (i6 < 2) {
            i6 = 2;
        }
        this.mLabelCount = i6;
        this.mForceLabels = false;
    }

    public void addLimitLine(LimitLine limitLine) {
        this.mLimitLines.add(limitLine);
        this.mLimitLines.size();
    }

    public void calculate(float f6, float f7) {
        float f8 = this.mCustomAxisMin ? this.mAxisMinimum : f6 - this.mSpaceMin;
        float f9 = this.mCustomAxisMax ? this.mAxisMaximum : f7 + this.mSpaceMax;
        if (Math.abs(f9 - f8) == 0.0f) {
            f9 += 1.0f;
            f8 -= 1.0f;
        }
        this.mAxisMinimum = f8;
        this.mAxisMaximum = f9;
        this.mAxisRange = Math.abs(f9 - f8);
    }

    public void enableAxisLineDashedLine(float f6, float f7, float f8) {
        this.mAxisLineDashPathEffect = new DashPathEffect(new float[]{f6, f7}, f8);
    }

    public void enableGridDashedLine(float f6, float f7, float f8) {
        this.mGridDashPathEffect = new DashPathEffect(new float[]{f6, f7}, f8);
    }

    public int getAxisLineColor() {
        return this.mAxisLineColor;
    }

    public DashPathEffect getAxisLineDashPathEffect() {
        return this.mAxisLineDashPathEffect;
    }

    public float getAxisLineWidth() {
        return this.mAxisLineWidth;
    }

    public float getAxisMaximum() {
        return this.mAxisMaximum;
    }

    public float getAxisMinimum() {
        return this.mAxisMinimum;
    }

    public String getFormattedLabel(int i6) {
        return (i6 < 0 || i6 >= this.mEntries.length) ? "" : getValueFormatter().getAxisLabel(this.mEntries[i6], this);
    }

    public float getGranularity() {
        return this.mGranularity;
    }

    public int getGridColor() {
        return this.mGridColor;
    }

    public DashPathEffect getGridDashPathEffect() {
        return this.mGridDashPathEffect;
    }

    public float getGridLineWidth() {
        return this.mGridLineWidth;
    }

    public int getLabelCount() {
        return this.mLabelCount;
    }

    public List<LimitLine> getLimitLines() {
        return this.mLimitLines;
    }

    public String getLongestLabel() {
        String str = "";
        for (int i6 = 0; i6 < this.mEntries.length; i6++) {
            String formattedLabel = getFormattedLabel(i6);
            if (formattedLabel != null && str.length() < formattedLabel.length()) {
                str = formattedLabel;
            }
        }
        return str;
    }

    public float getSpaceMax() {
        return this.mSpaceMax;
    }

    public float getSpaceMin() {
        return this.mSpaceMin;
    }

    public ValueFormatter getValueFormatter() {
        ValueFormatter valueFormatter = this.mAxisValueFormatter;
        if (valueFormatter == null || ((valueFormatter instanceof DefaultAxisValueFormatter) && ((DefaultAxisValueFormatter) valueFormatter).getDecimalDigits() != this.mDecimals)) {
            this.mAxisValueFormatter = new DefaultAxisValueFormatter(this.mDecimals);
        }
        return this.mAxisValueFormatter;
    }

    public boolean isAxisLineDashedLineEnabled() {
        return this.mAxisLineDashPathEffect != null;
    }

    public boolean isAxisMaxCustom() {
        return this.mCustomAxisMax;
    }

    public boolean isAxisMinCustom() {
        return this.mCustomAxisMin;
    }

    public boolean isCenterAxisLabelsEnabled() {
        return this.mCenterAxisLabels && this.mEntryCount > 0;
    }

    public boolean isDrawAxisLineEnabled() {
        return this.mDrawAxisLine;
    }

    public boolean isDrawGridLinesBehindDataEnabled() {
        return this.mDrawGridLinesBehindData;
    }

    public boolean isDrawGridLinesEnabled() {
        return this.mDrawGridLines;
    }

    public boolean isDrawLabelsEnabled() {
        return this.mDrawLabels;
    }

    public boolean isDrawLimitLinesBehindDataEnabled() {
        return this.mDrawLimitLineBehindData;
    }

    public boolean isForceLabelsEnabled() {
        return this.mForceLabels;
    }

    public boolean isGranularityEnabled() {
        return this.mGranularityEnabled;
    }

    public boolean isGridDashedLineEnabled() {
        return this.mGridDashPathEffect != null;
    }

    public void removeAllLimitLines() {
        this.mLimitLines.clear();
    }

    public void removeLimitLine(LimitLine limitLine) {
        this.mLimitLines.remove(limitLine);
    }

    public void setAxisLineColor(int i6) {
        this.mAxisLineColor = i6;
    }

    public void setAxisLineDashedLine(DashPathEffect dashPathEffect) {
        this.mAxisLineDashPathEffect = dashPathEffect;
    }

    public void setCenterAxisLabels(boolean z5) {
        this.mCenterAxisLabels = z5;
    }

    public void setDrawAxisLine(boolean z5) {
        this.mDrawAxisLine = z5;
    }

    public void setDrawGridLines(boolean z5) {
        this.mDrawGridLines = z5;
    }

    public void setDrawGridLinesBehindData(boolean z5) {
        this.mDrawGridLinesBehindData = z5;
    }

    public void setDrawLabels(boolean z5) {
        this.mDrawLabels = z5;
    }

    public void setDrawLimitLinesBehindData(boolean z5) {
        this.mDrawLimitLineBehindData = z5;
    }

    public void setGranularity(float f6) {
        this.mGranularity = f6;
        this.mGranularityEnabled = true;
    }

    public void setGranularityEnabled(boolean z5) {
        this.mGranularityEnabled = z5;
    }

    public void setGridColor(int i6) {
        this.mGridColor = i6;
    }

    public void setGridDashedLine(DashPathEffect dashPathEffect) {
        this.mGridDashPathEffect = dashPathEffect;
    }

    public void setSpaceMax(float f6) {
        this.mSpaceMax = f6;
    }

    public void setSpaceMin(float f6) {
        this.mSpaceMin = f6;
    }

    public void setValueFormatter(ValueFormatter valueFormatter) {
        if (valueFormatter == null) {
            this.mAxisValueFormatter = new DefaultAxisValueFormatter(this.mDecimals);
        } else {
            this.mAxisValueFormatter = valueFormatter;
        }
    }

    public AxisBase() {
        this.mTextSize = Utils.convertDpToPixel(10.0f);
        this.mXOffset = Utils.convertDpToPixel(5.0f);
        this.mYOffset = Utils.convertDpToPixel(5.0f);
        this.mLimitLines = new ArrayList();
    }

    public void setAxisLineWidth(float f6) {
        this.mAxisLineWidth = Utils.convertDpToPixel(f6);
    }

    @Deprecated
    public void setAxisMaxValue(float f6) {
        setAxisMaximum(f6);
    }

    @Deprecated
    public void setAxisMinValue(float f6) {
        setAxisMinimum(f6);
    }

    public void setGridLineWidth(float f6) {
        this.mGridLineWidth = Utils.convertDpToPixel(f6);
    }

    public void setLabelCount(int i6, boolean z5) {
        setLabelCount(i6);
        this.mForceLabels = z5;
    }
}
