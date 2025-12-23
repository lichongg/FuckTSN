package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.ScatterDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.renderer.BarLineScatterCandleBubbleRenderer;
import com.github.mikephil.charting.renderer.scatter.IShapeRenderer;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class ScatterChartRenderer extends LineScatterCandleRadarRenderer {
    protected ScatterDataProvider mChart;
    float[] mPixelBuffer;

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawData(Canvas canvas) {
        for (T t5 : this.mChart.getScatterData().getDataSets()) {
            if (t5.isVisible()) {
                drawDataSet(canvas, t5);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [com.github.mikephil.charting.data.BaseEntry, com.github.mikephil.charting.data.Entry] */
    protected void drawDataSet(Canvas canvas, IScatterDataSet iScatterDataSet) {
        IScatterDataSet iScatterDataSet2 = iScatterDataSet;
        if (iScatterDataSet2.getEntryCount() < 1) {
            return;
        }
        ViewPortHandler viewPortHandler = this.mViewPortHandler;
        Transformer transformer = this.mChart.getTransformer(iScatterDataSet2.getAxisDependency());
        float phaseY = this.mAnimator.getPhaseY();
        IShapeRenderer shapeRenderer = iScatterDataSet2.getShapeRenderer();
        if (shapeRenderer == null) {
            return;
        }
        int min = (int) Math.min(Math.ceil(iScatterDataSet2.getEntryCount() * this.mAnimator.getPhaseX()), iScatterDataSet2.getEntryCount());
        int i6 = 0;
        while (i6 < min) {
            ?? entryForIndex = iScatterDataSet2.getEntryForIndex(i6);
            this.mPixelBuffer[0] = entryForIndex.getX();
            this.mPixelBuffer[1] = entryForIndex.getY() * phaseY;
            transformer.pointValuesToPixel(this.mPixelBuffer);
            if (!viewPortHandler.isInBoundsRight(this.mPixelBuffer[0])) {
                return;
            }
            if (viewPortHandler.isInBoundsLeft(this.mPixelBuffer[0]) && viewPortHandler.isInBoundsY(this.mPixelBuffer[1])) {
                this.mRenderPaint.setColor(iScatterDataSet2.getColor(i6 / 2));
                ViewPortHandler viewPortHandler2 = this.mViewPortHandler;
                float[] fArr = this.mPixelBuffer;
                shapeRenderer.renderShape(canvas, iScatterDataSet2, viewPortHandler2, fArr[0], fArr[1], this.mRenderPaint);
            }
            i6++;
            iScatterDataSet2 = iScatterDataSet;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [com.github.mikephil.charting.data.BaseEntry, com.github.mikephil.charting.data.Entry] */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        ScatterData scatterData = this.mChart.getScatterData();
        for (Highlight highlight : highlightArr) {
            IScatterDataSet iScatterDataSet = (IScatterDataSet) scatterData.getDataSetByIndex(highlight.getDataSetIndex());
            if (iScatterDataSet != null && iScatterDataSet.isHighlightEnabled()) {
                ?? entryForXValue = iScatterDataSet.getEntryForXValue(highlight.getX(), highlight.getY());
                if (isInBoundsX(entryForXValue, iScatterDataSet)) {
                    MPPointD pixelForValues = this.mChart.getTransformer(iScatterDataSet.getAxisDependency()).getPixelForValues(entryForXValue.getX(), entryForXValue.getY() * this.mAnimator.getPhaseY());
                    highlight.setDraw((float) pixelForValues.f32563x, (float) pixelForValues.f32564y);
                    drawHighlightLines(canvas, (float) pixelForValues.f32563x, (float) pixelForValues.f32564y, iScatterDataSet);
                }
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValue(Canvas canvas, String str, float f6, float f7, int i6) {
        this.mValuePaint.setColor(i6);
        canvas.drawText(str, f6, f7, this.mValuePaint);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValues(Canvas canvas) {
        Entry entry;
        ScatterChartRenderer scatterChartRenderer = this;
        if (scatterChartRenderer.isDrawingValuesAllowed(scatterChartRenderer.mChart)) {
            List<T> dataSets = scatterChartRenderer.mChart.getScatterData().getDataSets();
            int i6 = 0;
            while (i6 < scatterChartRenderer.mChart.getScatterData().getDataSetCount()) {
                IScatterDataSet iScatterDataSet = (IScatterDataSet) dataSets.get(i6);
                if (scatterChartRenderer.shouldDrawValues(iScatterDataSet) && iScatterDataSet.getEntryCount() >= 1) {
                    scatterChartRenderer.applyValueTextStyle(iScatterDataSet);
                    scatterChartRenderer.mXBounds.set(scatterChartRenderer.mChart, iScatterDataSet);
                    Transformer transformer = scatterChartRenderer.mChart.getTransformer(iScatterDataSet.getAxisDependency());
                    float phaseX = scatterChartRenderer.mAnimator.getPhaseX();
                    float phaseY = scatterChartRenderer.mAnimator.getPhaseY();
                    BarLineScatterCandleBubbleRenderer.XBounds xBounds = scatterChartRenderer.mXBounds;
                    float[] generateTransformedValuesScatter = transformer.generateTransformedValuesScatter(iScatterDataSet, phaseX, phaseY, xBounds.min, xBounds.max);
                    float convertDpToPixel = Utils.convertDpToPixel(iScatterDataSet.getScatterShapeSize());
                    ValueFormatter valueFormatter = iScatterDataSet.getValueFormatter();
                    MPPointF mPPointF = MPPointF.getInstance(iScatterDataSet.getIconsOffset());
                    mPPointF.f32565x = Utils.convertDpToPixel(mPPointF.f32565x);
                    mPPointF.f32566y = Utils.convertDpToPixel(mPPointF.f32566y);
                    int i7 = 0;
                    while (i7 < generateTransformedValuesScatter.length && scatterChartRenderer.mViewPortHandler.isInBoundsRight(generateTransformedValuesScatter[i7])) {
                        if (scatterChartRenderer.mViewPortHandler.isInBoundsLeft(generateTransformedValuesScatter[i7])) {
                            int i8 = i7 + 1;
                            if (scatterChartRenderer.mViewPortHandler.isInBoundsY(generateTransformedValuesScatter[i8])) {
                                int i9 = i7 / 2;
                                Entry entryForIndex = iScatterDataSet.getEntryForIndex(scatterChartRenderer.mXBounds.min + i9);
                                if (iScatterDataSet.isDrawValuesEnabled()) {
                                    entry = entryForIndex;
                                    scatterChartRenderer.drawValue(canvas, valueFormatter.getPointLabel(entryForIndex), generateTransformedValuesScatter[i7], generateTransformedValuesScatter[i8] - convertDpToPixel, iScatterDataSet.getValueTextColor(i9 + scatterChartRenderer.mXBounds.min));
                                } else {
                                    entry = entryForIndex;
                                }
                                if (entry.getIcon() != null && iScatterDataSet.isDrawIconsEnabled()) {
                                    Drawable icon = entry.getIcon();
                                    Utils.drawImage(canvas, icon, (int) (generateTransformedValuesScatter[i7] + mPPointF.f32565x), (int) (generateTransformedValuesScatter[i8] + mPPointF.f32566y), icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                                }
                            }
                        }
                        i7 += 2;
                        scatterChartRenderer = this;
                    }
                    MPPointF.recycleInstance(mPPointF);
                }
                i6++;
                scatterChartRenderer = this;
            }
        }
    }

    public ScatterChartRenderer(ScatterDataProvider scatterDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.mPixelBuffer = new float[2];
        this.mChart = scatterDataProvider;
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawExtras(Canvas canvas) {
    }
}
