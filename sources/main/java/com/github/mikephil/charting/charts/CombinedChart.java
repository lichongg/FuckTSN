package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BubbleData;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.highlight.CombinedHighlighter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.CombinedDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.renderer.CombinedChartRenderer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class CombinedChart extends BarLineChartBase<CombinedData> implements CombinedDataProvider {
    private boolean mDrawBarShadow;
    protected DrawOrder[] mDrawOrder;
    private boolean mDrawValueAboveBar;
    protected boolean mHighlightFullBarEnabled;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum DrawOrder {
        BAR,
        BUBBLE,
        LINE,
        CANDLE,
        SCATTER
    }

    public CombinedChart(Context context) {
        super(context);
        this.mDrawValueAboveBar = true;
        this.mHighlightFullBarEnabled = false;
        this.mDrawBarShadow = false;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    protected void drawMarkers(Canvas canvas) {
        if (this.mMarker == null || !isDrawMarkersEnabled() || !valuesToHighlight()) {
            return;
        }
        int i6 = 0;
        while (true) {
            Highlight[] highlightArr = this.mIndicesToHighlight;
            if (i6 >= highlightArr.length) {
                return;
            }
            Highlight highlight = highlightArr[i6];
            IBarLineScatterCandleBubbleDataSet<? extends Entry> dataSetByHighlight = ((CombinedData) this.mData).getDataSetByHighlight(highlight);
            Entry entryForHighlight = ((CombinedData) this.mData).getEntryForHighlight(highlight);
            if (entryForHighlight != null && dataSetByHighlight.getEntryIndex(entryForHighlight) <= dataSetByHighlight.getEntryCount() * this.mAnimator.getPhaseX()) {
                float[] markerPosition = getMarkerPosition(highlight);
                if (this.mViewPortHandler.isInBounds(markerPosition[0], markerPosition[1])) {
                    this.mMarker.refreshContent(entryForHighlight, highlight);
                    this.mMarker.draw(canvas, markerPosition[0], markerPosition[1]);
                }
            }
            i6++;
        }
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider
    public BarData getBarData() {
        T t5 = this.mData;
        if (t5 == 0) {
            return null;
        }
        return ((CombinedData) t5).getBarData();
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BubbleDataProvider
    public BubbleData getBubbleData() {
        T t5 = this.mData;
        if (t5 == 0) {
            return null;
        }
        return ((CombinedData) t5).getBubbleData();
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.CandleDataProvider
    public CandleData getCandleData() {
        T t5 = this.mData;
        if (t5 == 0) {
            return null;
        }
        return ((CombinedData) t5).getCandleData();
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.CombinedDataProvider
    public CombinedData getCombinedData() {
        return (CombinedData) this.mData;
    }

    public DrawOrder[] getDrawOrder() {
        return this.mDrawOrder;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public Highlight getHighlightByTouchPoint(float f6, float f7) {
        if (this.mData == 0) {
            return null;
        }
        Highlight highlight = getHighlighter().getHighlight(f6, f7);
        return (highlight == null || !isHighlightFullBarEnabled()) ? highlight : new Highlight(highlight.getX(), highlight.getY(), highlight.getXPx(), highlight.getYPx(), highlight.getDataSetIndex(), -1, highlight.getAxis());
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider
    public LineData getLineData() {
        T t5 = this.mData;
        if (t5 == 0) {
            return null;
        }
        return ((CombinedData) t5).getLineData();
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ScatterDataProvider
    public ScatterData getScatterData() {
        T t5 = this.mData;
        if (t5 == 0) {
            return null;
        }
        return ((CombinedData) t5).getScatterData();
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

    @Override // com.github.mikephil.charting.charts.Chart
    public void setData(CombinedData combinedData) {
        super.setData((CombinedChart) combinedData);
        setHighlighter(new CombinedHighlighter(this, this));
        ((CombinedChartRenderer) this.mRenderer).createRenderers();
        this.mRenderer.initBuffers();
    }

    public void setDrawBarShadow(boolean z5) {
        this.mDrawBarShadow = z5;
    }

    public void setDrawOrder(DrawOrder[] drawOrderArr) {
        if (drawOrderArr == null || drawOrderArr.length <= 0) {
            return;
        }
        this.mDrawOrder = drawOrderArr;
    }

    public void setDrawValueAboveBar(boolean z5) {
        this.mDrawValueAboveBar = z5;
    }

    public void setHighlightFullBarEnabled(boolean z5) {
        this.mHighlightFullBarEnabled = z5;
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    protected void init() {
        super.init();
        this.mDrawOrder = new DrawOrder[]{DrawOrder.BAR, DrawOrder.BUBBLE, DrawOrder.LINE, DrawOrder.CANDLE, DrawOrder.SCATTER};
        setHighlighter(new CombinedHighlighter(this, this));
        setHighlightFullBarEnabled(true);
        this.mRenderer = new CombinedChartRenderer(this, this.mAnimator, this.mViewPortHandler);
    }

    public CombinedChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDrawValueAboveBar = true;
        this.mHighlightFullBarEnabled = false;
        this.mDrawBarShadow = false;
    }

    public CombinedChart(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.mDrawValueAboveBar = true;
        this.mHighlightFullBarEnabled = false;
        this.mDrawBarShadow = false;
    }
}
