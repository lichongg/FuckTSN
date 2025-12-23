package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.HorizontalBarHighlighter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.renderer.HorizontalBarChartRenderer;
import com.github.mikephil.charting.renderer.XAxisRendererHorizontalBarChart;
import com.github.mikephil.charting.renderer.YAxisRendererHorizontalBarChart;
import com.github.mikephil.charting.utils.HorizontalViewPortHandler;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.TransformerHorizontalBarChart;
import com.github.mikephil.charting.utils.Utils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class HorizontalBarChart extends BarChart {
    protected float[] mGetPositionBuffer;
    private RectF mOffsetsBuffer;

    public HorizontalBarChart(Context context) {
        super(context);
        this.mOffsetsBuffer = new RectF();
        this.mGetPositionBuffer = new float[2];
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    public void calculateOffsets() {
        calculateLegendOffsets(this.mOffsetsBuffer);
        RectF rectF = this.mOffsetsBuffer;
        float f6 = rectF.left + 0.0f;
        float f7 = rectF.top + 0.0f;
        float f8 = rectF.right + 0.0f;
        float f9 = rectF.bottom + 0.0f;
        if (this.mAxisLeft.needsOffset()) {
            f7 += this.mAxisLeft.getRequiredHeightSpace(this.mAxisRendererLeft.getPaintAxisLabels());
        }
        if (this.mAxisRight.needsOffset()) {
            f9 += this.mAxisRight.getRequiredHeightSpace(this.mAxisRendererRight.getPaintAxisLabels());
        }
        XAxis xAxis = this.mXAxis;
        float f10 = xAxis.mLabelRotatedWidth;
        if (xAxis.isEnabled()) {
            if (this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTTOM) {
                f6 += f10;
            } else {
                if (this.mXAxis.getPosition() != XAxis.XAxisPosition.TOP) {
                    if (this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTH_SIDED) {
                        f6 += f10;
                    }
                }
                f8 += f10;
            }
        }
        float extraTopOffset = f7 + getExtraTopOffset();
        float extraRightOffset = f8 + getExtraRightOffset();
        float extraBottomOffset = f9 + getExtraBottomOffset();
        float extraLeftOffset = f6 + getExtraLeftOffset();
        float convertDpToPixel = Utils.convertDpToPixel(this.mMinOffset);
        this.mViewPortHandler.restrainViewPort(Math.max(convertDpToPixel, extraLeftOffset), Math.max(convertDpToPixel, extraTopOffset), Math.max(convertDpToPixel, extraRightOffset), Math.max(convertDpToPixel, extraBottomOffset));
        if (this.mLogEnabled) {
            this.mViewPortHandler.getContentRect().toString();
        }
        prepareOffsetMatrix();
        prepareValuePxMatrix();
    }

    @Override // com.github.mikephil.charting.charts.BarChart
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
        rectF.set(f8, f6, y5, f7);
        getTransformer(iBarDataSet.getAxisDependency()).rectValueToPixel(rectF);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider
    public float getHighestVisibleX() {
        getTransformer(YAxis.AxisDependency.LEFT).getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop(), this.posForGetHighestVisibleX);
        return (float) Math.min(this.mXAxis.mAxisMaximum, this.posForGetHighestVisibleX.f32564y);
    }

    @Override // com.github.mikephil.charting.charts.BarChart, com.github.mikephil.charting.charts.Chart
    public Highlight getHighlightByTouchPoint(float f6, float f7) {
        if (this.mData == 0) {
            return null;
        }
        return getHighlighter().getHighlight(f7, f6);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider
    public float getLowestVisibleX() {
        getTransformer(YAxis.AxisDependency.LEFT).getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentBottom(), this.posForGetLowestVisibleX);
        return (float) Math.max(this.mXAxis.mAxisMinimum, this.posForGetLowestVisibleX.f32564y);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    public MPPointF getPosition(Entry entry, YAxis.AxisDependency axisDependency) {
        if (entry == null) {
            return null;
        }
        float[] fArr = this.mGetPositionBuffer;
        fArr[0] = entry.getY();
        fArr[1] = entry.getX();
        getTransformer(axisDependency).pointValuesToPixel(fArr);
        return MPPointF.getInstance(fArr[0], fArr[1]);
    }

    @Override // com.github.mikephil.charting.charts.BarChart, com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    protected void init() {
        this.mViewPortHandler = new HorizontalViewPortHandler();
        super.init();
        this.mLeftAxisTransformer = new TransformerHorizontalBarChart(this.mViewPortHandler);
        this.mRightAxisTransformer = new TransformerHorizontalBarChart(this.mViewPortHandler);
        this.mRenderer = new HorizontalBarChartRenderer(this, this.mAnimator, this.mViewPortHandler);
        setHighlighter(new HorizontalBarHighlighter(this));
        this.mAxisRendererLeft = new YAxisRendererHorizontalBarChart(this.mViewPortHandler, this.mAxisLeft, this.mLeftAxisTransformer);
        this.mAxisRendererRight = new YAxisRendererHorizontalBarChart(this.mViewPortHandler, this.mAxisRight, this.mRightAxisTransformer);
        this.mXAxisRenderer = new XAxisRendererHorizontalBarChart(this.mViewPortHandler, this.mXAxis, this.mLeftAxisTransformer, this);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    protected void prepareValuePxMatrix() {
        Transformer transformer = this.mRightAxisTransformer;
        YAxis yAxis = this.mAxisRight;
        float f6 = yAxis.mAxisMinimum;
        float f7 = yAxis.mAxisRange;
        XAxis xAxis = this.mXAxis;
        transformer.prepareMatrixValuePx(f6, f7, xAxis.mAxisRange, xAxis.mAxisMinimum);
        Transformer transformer2 = this.mLeftAxisTransformer;
        YAxis yAxis2 = this.mAxisLeft;
        float f8 = yAxis2.mAxisMinimum;
        float f9 = yAxis2.mAxisRange;
        XAxis xAxis2 = this.mXAxis;
        transformer2.prepareMatrixValuePx(f8, f9, xAxis2.mAxisRange, xAxis2.mAxisMinimum);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    public void setVisibleXRange(float f6, float f7) {
        float f8 = this.mXAxis.mAxisRange;
        this.mViewPortHandler.setMinMaxScaleY(f8 / f6, f8 / f7);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    public void setVisibleXRangeMaximum(float f6) {
        this.mViewPortHandler.setMinimumScaleY(this.mXAxis.mAxisRange / f6);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    public void setVisibleXRangeMinimum(float f6) {
        this.mViewPortHandler.setMaximumScaleY(this.mXAxis.mAxisRange / f6);
    }

    @Override // com.github.mikephil.charting.charts.Chart
    protected float[] getMarkerPosition(Highlight highlight) {
        return new float[]{highlight.getDrawY(), highlight.getDrawX()};
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    public void setVisibleYRange(float f6, float f7, YAxis.AxisDependency axisDependency) {
        this.mViewPortHandler.setMinMaxScaleX(getAxisRange(axisDependency) / f6, getAxisRange(axisDependency) / f7);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    public void setVisibleYRangeMaximum(float f6, YAxis.AxisDependency axisDependency) {
        this.mViewPortHandler.setMinimumScaleX(getAxisRange(axisDependency) / f6);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    public void setVisibleYRangeMinimum(float f6, YAxis.AxisDependency axisDependency) {
        this.mViewPortHandler.setMaximumScaleX(getAxisRange(axisDependency) / f6);
    }

    public HorizontalBarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mOffsetsBuffer = new RectF();
        this.mGetPositionBuffer = new float[2];
    }

    public HorizontalBarChart(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.mOffsetsBuffer = new RectF();
        this.mGetPositionBuffer = new float[2];
    }
}
