package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.highlight.BarHighlighter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.renderer.BarChartRenderer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class BarChart extends BarLineChartBase<BarData> implements BarDataProvider {
    private boolean mDrawBarShadow;
    private boolean mDrawValueAboveBar;
    private boolean mFitBars;
    protected boolean mHighlightFullBarEnabled;

    public BarChart(Context context) {
        super(context);
        this.mHighlightFullBarEnabled = false;
        this.mDrawValueAboveBar = true;
        this.mDrawBarShadow = false;
        this.mFitBars = false;
    }

    public RectF getBarBounds(BarEntry barEntry) {
        RectF rectF = new RectF();
        getBarBounds(barEntry, rectF);
        return rectF;
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    protected void calcMinMax() {
        if (this.mFitBars) {
            this.mXAxis.calculate(((BarData) this.mData).getXMin() - (((BarData) this.mData).getBarWidth() / 2.0f), ((BarData) this.mData).getXMax() + (((BarData) this.mData).getBarWidth() / 2.0f));
        } else {
            this.mXAxis.calculate(((BarData) this.mData).getXMin(), ((BarData) this.mData).getXMax());
        }
        YAxis yAxis = this.mAxisLeft;
        BarData barData = (BarData) this.mData;
        YAxis.AxisDependency axisDependency = YAxis.AxisDependency.LEFT;
        yAxis.calculate(barData.getYMin(axisDependency), ((BarData) this.mData).getYMax(axisDependency));
        YAxis yAxis2 = this.mAxisRight;
        BarData barData2 = (BarData) this.mData;
        YAxis.AxisDependency axisDependency2 = YAxis.AxisDependency.RIGHT;
        yAxis2.calculate(barData2.getYMin(axisDependency2), ((BarData) this.mData).getYMax(axisDependency2));
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider
    public BarData getBarData() {
        return (BarData) this.mData;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public Highlight getHighlightByTouchPoint(float f6, float f7) {
        if (this.mData == 0) {
            return null;
        }
        Highlight highlight = getHighlighter().getHighlight(f6, f7);
        return (highlight == null || !isHighlightFullBarEnabled()) ? highlight : new Highlight(highlight.getX(), highlight.getY(), highlight.getXPx(), highlight.getYPx(), highlight.getDataSetIndex(), -1, highlight.getAxis());
    }

    public void highlightValue(float f6, int i6, int i7) {
        highlightValue(new Highlight(f6, i6, i7), false);
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider
    public boolean isDrawBarShadowEnabled() {
        return this.mDrawBarShadow;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider
    public boolean isDrawValueAboveBarEnabled() {
        return this.mDrawValueAboveBar;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider
    public boolean isHighlightFullBarEnabled() {
        return this.mHighlightFullBarEnabled;
    }

    public void setDrawBarShadow(boolean z5) {
        this.mDrawBarShadow = z5;
    }

    public void setDrawValueAboveBar(boolean z5) {
        this.mDrawValueAboveBar = z5;
    }

    public void setFitBars(boolean z5) {
        this.mFitBars = z5;
    }

    public void setHighlightFullBarEnabled(boolean z5) {
        this.mHighlightFullBarEnabled = z5;
    }

    public void getBarBounds(BarEntry barEntry, RectF rectF) {
        IBarDataSet iBarDataSet = (IBarDataSet) ((BarData) this.mData).getDataSetForEntry(barEntry);
        if (iBarDataSet == null) {
            rectF.set(Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE);
            return;
        }
        float y5 = barEntry.getY();
        float x5 = barEntry.getX();
        float barWidth = ((BarData) this.mData).getBarWidth() / 2.0f;
        float f6 = x5 - barWidth;
        float f7 = x5 + barWidth;
        float f8 = y5 >= 0.0f ? y5 : 0.0f;
        if (y5 > 0.0f) {
            y5 = 0.0f;
        }
        rectF.set(f6, f8, f7, y5);
        getTransformer(iBarDataSet.getAxisDependency()).rectValueToPixel(rectF);
    }

    public void groupBars(float f6, float f7, float f8) {
        if (getBarData() != null) {
            getBarData().groupBars(f6, f7, f8);
            notifyDataSetChanged();
            return;
        }
        throw new RuntimeException("You need to set data for the chart before grouping bars.");
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    protected void init() {
        super.init();
        this.mRenderer = new BarChartRenderer(this, this.mAnimator, this.mViewPortHandler);
        setHighlighter(new BarHighlighter(this));
        getXAxis().setSpaceMin(0.5f);
        getXAxis().setSpaceMax(0.5f);
    }

    public BarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHighlightFullBarEnabled = false;
        this.mDrawValueAboveBar = true;
        this.mDrawBarShadow = false;
        this.mFitBars = false;
    }

    public BarChart(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.mHighlightFullBarEnabled = false;
        this.mDrawValueAboveBar = true;
        this.mDrawBarShadow = false;
        this.mFitBars = false;
    }
}
