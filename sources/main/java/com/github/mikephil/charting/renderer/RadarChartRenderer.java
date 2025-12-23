package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class RadarChartRenderer extends LineRadarRenderer {
    protected RadarChart mChart;
    protected Path mDrawDataSetSurfacePathBuffer;
    protected Path mDrawHighlightCirclePathBuffer;
    protected Paint mHighlightCirclePaint;
    protected Paint mWebPaint;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawData(Canvas canvas) {
        RadarData radarData = (RadarData) this.mChart.getData();
        int entryCount = radarData.getMaxEntryCountSet().getEntryCount();
        for (IRadarDataSet iRadarDataSet : radarData.getDataSets()) {
            if (iRadarDataSet.isVisible()) {
                drawDataSet(canvas, iRadarDataSet, entryCount);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void drawDataSet(Canvas canvas, IRadarDataSet iRadarDataSet, int i6) {
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        float sliceAngle = this.mChart.getSliceAngle();
        float factor = this.mChart.getFactor();
        MPPointF centerOffsets = this.mChart.getCenterOffsets();
        MPPointF mPPointF = MPPointF.getInstance(0.0f, 0.0f);
        Path path = this.mDrawDataSetSurfacePathBuffer;
        path.reset();
        boolean z5 = false;
        for (int i7 = 0; i7 < iRadarDataSet.getEntryCount(); i7++) {
            this.mRenderPaint.setColor(iRadarDataSet.getColor(i7));
            Utils.getPosition(centerOffsets, (((RadarEntry) iRadarDataSet.getEntryForIndex(i7)).getY() - this.mChart.getYChartMin()) * factor * phaseY, (i7 * sliceAngle * phaseX) + this.mChart.getRotationAngle(), mPPointF);
            if (!Float.isNaN(mPPointF.f32565x)) {
                if (z5) {
                    path.lineTo(mPPointF.f32565x, mPPointF.f32566y);
                } else {
                    path.moveTo(mPPointF.f32565x, mPPointF.f32566y);
                    z5 = true;
                }
            }
        }
        if (iRadarDataSet.getEntryCount() > i6) {
            path.lineTo(centerOffsets.f32565x, centerOffsets.f32566y);
        }
        path.close();
        if (iRadarDataSet.isDrawFilledEnabled()) {
            Drawable fillDrawable = iRadarDataSet.getFillDrawable();
            if (fillDrawable != null) {
                drawFilledPath(canvas, path, fillDrawable);
            } else {
                drawFilledPath(canvas, path, iRadarDataSet.getFillColor(), iRadarDataSet.getFillAlpha());
            }
        }
        this.mRenderPaint.setStrokeWidth(iRadarDataSet.getLineWidth());
        this.mRenderPaint.setStyle(Paint.Style.STROKE);
        if (!iRadarDataSet.isDrawFilledEnabled() || iRadarDataSet.getFillAlpha() < 255) {
            canvas.drawPath(path, this.mRenderPaint);
        }
        MPPointF.recycleInstance(centerOffsets);
        MPPointF.recycleInstance(mPPointF);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        RadarChartRenderer radarChartRenderer = this;
        float sliceAngle = radarChartRenderer.mChart.getSliceAngle();
        float factor = radarChartRenderer.mChart.getFactor();
        MPPointF centerOffsets = radarChartRenderer.mChart.getCenterOffsets();
        MPPointF mPPointF = MPPointF.getInstance(0.0f, 0.0f);
        RadarData radarData = (RadarData) radarChartRenderer.mChart.getData();
        int length = highlightArr.length;
        int i6 = 0;
        while (i6 < length) {
            Highlight highlight = highlightArr[i6];
            IRadarDataSet dataSetByIndex = radarData.getDataSetByIndex(highlight.getDataSetIndex());
            if (dataSetByIndex != null && dataSetByIndex.isHighlightEnabled()) {
                RadarEntry radarEntry = (RadarEntry) dataSetByIndex.getEntryForIndex((int) highlight.getX());
                if (radarChartRenderer.isInBoundsX(radarEntry, dataSetByIndex)) {
                    Utils.getPosition(centerOffsets, (radarEntry.getY() - radarChartRenderer.mChart.getYChartMin()) * factor * radarChartRenderer.mAnimator.getPhaseY(), (highlight.getX() * sliceAngle * radarChartRenderer.mAnimator.getPhaseX()) + radarChartRenderer.mChart.getRotationAngle(), mPPointF);
                    highlight.setDraw(mPPointF.f32565x, mPPointF.f32566y);
                    radarChartRenderer.drawHighlightLines(canvas, mPPointF.f32565x, mPPointF.f32566y, dataSetByIndex);
                    if (dataSetByIndex.isDrawHighlightCircleEnabled() && !Float.isNaN(mPPointF.f32565x) && !Float.isNaN(mPPointF.f32566y)) {
                        int highlightCircleStrokeColor = dataSetByIndex.getHighlightCircleStrokeColor();
                        if (highlightCircleStrokeColor == 1122867) {
                            highlightCircleStrokeColor = dataSetByIndex.getColor(0);
                        }
                        if (dataSetByIndex.getHighlightCircleStrokeAlpha() < 255) {
                            highlightCircleStrokeColor = ColorTemplate.colorWithAlpha(highlightCircleStrokeColor, dataSetByIndex.getHighlightCircleStrokeAlpha());
                        }
                        radarChartRenderer.drawHighlightCircle(canvas, mPPointF, dataSetByIndex.getHighlightCircleInnerRadius(), dataSetByIndex.getHighlightCircleOuterRadius(), dataSetByIndex.getHighlightCircleFillColor(), highlightCircleStrokeColor, dataSetByIndex.getHighlightCircleStrokeWidth());
                    }
                }
            }
            i6++;
            radarChartRenderer = this;
        }
        MPPointF.recycleInstance(centerOffsets);
        MPPointF.recycleInstance(mPPointF);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValue(Canvas canvas, String str, float f6, float f7, int i6) {
        this.mValuePaint.setColor(i6);
        canvas.drawText(str, f6, f7, this.mValuePaint);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValues(Canvas canvas) {
        float f6;
        IRadarDataSet iRadarDataSet;
        int i6;
        RadarEntry radarEntry;
        float f7;
        MPPointF mPPointF;
        ValueFormatter valueFormatter;
        RadarChartRenderer radarChartRenderer = this;
        float phaseX = radarChartRenderer.mAnimator.getPhaseX();
        float phaseY = radarChartRenderer.mAnimator.getPhaseY();
        float sliceAngle = radarChartRenderer.mChart.getSliceAngle();
        float factor = radarChartRenderer.mChart.getFactor();
        MPPointF centerOffsets = radarChartRenderer.mChart.getCenterOffsets();
        MPPointF mPPointF2 = MPPointF.getInstance(0.0f, 0.0f);
        MPPointF mPPointF3 = MPPointF.getInstance(0.0f, 0.0f);
        float convertDpToPixel = Utils.convertDpToPixel(5.0f);
        int i7 = 0;
        while (i7 < ((RadarData) radarChartRenderer.mChart.getData()).getDataSetCount()) {
            IRadarDataSet dataSetByIndex = ((RadarData) radarChartRenderer.mChart.getData()).getDataSetByIndex(i7);
            if (radarChartRenderer.shouldDrawValues(dataSetByIndex)) {
                radarChartRenderer.applyValueTextStyle(dataSetByIndex);
                ValueFormatter valueFormatter2 = dataSetByIndex.getValueFormatter();
                MPPointF mPPointF4 = MPPointF.getInstance(dataSetByIndex.getIconsOffset());
                mPPointF4.f32565x = Utils.convertDpToPixel(mPPointF4.f32565x);
                mPPointF4.f32566y = Utils.convertDpToPixel(mPPointF4.f32566y);
                int i8 = 0;
                while (i8 < dataSetByIndex.getEntryCount()) {
                    RadarEntry radarEntry2 = (RadarEntry) dataSetByIndex.getEntryForIndex(i8);
                    MPPointF mPPointF5 = mPPointF4;
                    float f8 = i8 * sliceAngle * phaseX;
                    Utils.getPosition(centerOffsets, (radarEntry2.getY() - radarChartRenderer.mChart.getYChartMin()) * factor * phaseY, f8 + radarChartRenderer.mChart.getRotationAngle(), mPPointF2);
                    if (dataSetByIndex.isDrawValuesEnabled()) {
                        ValueFormatter valueFormatter3 = valueFormatter2;
                        i6 = i8;
                        radarEntry = radarEntry2;
                        f7 = phaseX;
                        mPPointF = mPPointF5;
                        radarChartRenderer = this;
                        valueFormatter = valueFormatter3;
                        iRadarDataSet = dataSetByIndex;
                        radarChartRenderer.drawValue(canvas, valueFormatter3.getRadarLabel(radarEntry2), mPPointF2.f32565x, mPPointF2.f32566y - convertDpToPixel, dataSetByIndex.getValueTextColor(i8));
                    } else {
                        iRadarDataSet = dataSetByIndex;
                        i6 = i8;
                        radarEntry = radarEntry2;
                        f7 = phaseX;
                        mPPointF = mPPointF5;
                        valueFormatter = valueFormatter2;
                    }
                    if (radarEntry.getIcon() != null && iRadarDataSet.isDrawIconsEnabled()) {
                        Drawable icon = radarEntry.getIcon();
                        Utils.getPosition(centerOffsets, (radarEntry.getY() * factor * phaseY) + mPPointF.f32566y, f8 + radarChartRenderer.mChart.getRotationAngle(), mPPointF3);
                        float f9 = mPPointF3.f32566y + mPPointF.f32565x;
                        mPPointF3.f32566y = f9;
                        Utils.drawImage(canvas, icon, (int) mPPointF3.f32565x, (int) f9, icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                    }
                    i8 = i6 + 1;
                    mPPointF4 = mPPointF;
                    dataSetByIndex = iRadarDataSet;
                    valueFormatter2 = valueFormatter;
                    phaseX = f7;
                }
                f6 = phaseX;
                MPPointF.recycleInstance(mPPointF4);
            } else {
                f6 = phaseX;
            }
            i7++;
            phaseX = f6;
        }
        MPPointF.recycleInstance(centerOffsets);
        MPPointF.recycleInstance(mPPointF2);
        MPPointF.recycleInstance(mPPointF3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void drawWeb(Canvas canvas) {
        float sliceAngle = this.mChart.getSliceAngle();
        float factor = this.mChart.getFactor();
        float rotationAngle = this.mChart.getRotationAngle();
        MPPointF centerOffsets = this.mChart.getCenterOffsets();
        this.mWebPaint.setStrokeWidth(this.mChart.getWebLineWidth());
        this.mWebPaint.setColor(this.mChart.getWebColor());
        this.mWebPaint.setAlpha(this.mChart.getWebAlpha());
        int skipWebLineCount = this.mChart.getSkipWebLineCount() + 1;
        int entryCount = ((RadarData) this.mChart.getData()).getMaxEntryCountSet().getEntryCount();
        MPPointF mPPointF = MPPointF.getInstance(0.0f, 0.0f);
        for (int i6 = 0; i6 < entryCount; i6 += skipWebLineCount) {
            Utils.getPosition(centerOffsets, this.mChart.getYRange() * factor, (i6 * sliceAngle) + rotationAngle, mPPointF);
            canvas.drawLine(centerOffsets.f32565x, centerOffsets.f32566y, mPPointF.f32565x, mPPointF.f32566y, this.mWebPaint);
        }
        MPPointF.recycleInstance(mPPointF);
        this.mWebPaint.setStrokeWidth(this.mChart.getWebLineWidthInner());
        this.mWebPaint.setColor(this.mChart.getWebColorInner());
        this.mWebPaint.setAlpha(this.mChart.getWebAlpha());
        int i7 = this.mChart.getYAxis().mEntryCount;
        MPPointF mPPointF2 = MPPointF.getInstance(0.0f, 0.0f);
        MPPointF mPPointF3 = MPPointF.getInstance(0.0f, 0.0f);
        for (int i8 = 0; i8 < i7; i8++) {
            int i9 = 0;
            while (i9 < ((RadarData) this.mChart.getData()).getEntryCount()) {
                float yChartMin = (this.mChart.getYAxis().mEntries[i8] - this.mChart.getYChartMin()) * factor;
                Utils.getPosition(centerOffsets, yChartMin, (i9 * sliceAngle) + rotationAngle, mPPointF2);
                i9++;
                Utils.getPosition(centerOffsets, yChartMin, (i9 * sliceAngle) + rotationAngle, mPPointF3);
                canvas.drawLine(mPPointF2.f32565x, mPPointF2.f32566y, mPPointF3.f32565x, mPPointF3.f32566y, this.mWebPaint);
            }
        }
        MPPointF.recycleInstance(mPPointF2);
        MPPointF.recycleInstance(mPPointF3);
    }

    public Paint getWebPaint() {
        return this.mWebPaint;
    }

    public RadarChartRenderer(RadarChart radarChart, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.mDrawDataSetSurfacePathBuffer = new Path();
        this.mDrawHighlightCirclePathBuffer = new Path();
        this.mChart = radarChart;
        Paint paint = new Paint(1);
        this.mHighlightPaint = paint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        this.mHighlightPaint.setStrokeWidth(2.0f);
        this.mHighlightPaint.setColor(Color.rgb(255, 187, 115));
        Paint paint2 = new Paint(1);
        this.mWebPaint = paint2;
        paint2.setStyle(style);
        this.mHighlightCirclePaint = new Paint(1);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawExtras(Canvas canvas) {
        drawWeb(canvas);
    }

    public void drawHighlightCircle(Canvas canvas, MPPointF mPPointF, float f6, float f7, int i6, int i7, float f8) {
        canvas.save();
        float convertDpToPixel = Utils.convertDpToPixel(f7);
        float convertDpToPixel2 = Utils.convertDpToPixel(f6);
        if (i6 != 1122867) {
            Path path = this.mDrawHighlightCirclePathBuffer;
            path.reset();
            path.addCircle(mPPointF.f32565x, mPPointF.f32566y, convertDpToPixel, Path.Direction.CW);
            if (convertDpToPixel2 > 0.0f) {
                path.addCircle(mPPointF.f32565x, mPPointF.f32566y, convertDpToPixel2, Path.Direction.CCW);
            }
            this.mHighlightCirclePaint.setColor(i6);
            this.mHighlightCirclePaint.setStyle(Paint.Style.FILL);
            canvas.drawPath(path, this.mHighlightCirclePaint);
        }
        if (i7 != 1122867) {
            this.mHighlightCirclePaint.setColor(i7);
            this.mHighlightCirclePaint.setStyle(Paint.Style.STROKE);
            this.mHighlightCirclePaint.setStrokeWidth(Utils.convertDpToPixel(f8));
            canvas.drawCircle(mPPointF.f32565x, mPPointF.f32566y, convertDpToPixel, this.mHighlightCirclePaint);
        }
        canvas.restore();
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
    }
}
