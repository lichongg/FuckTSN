package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.BubbleData;
import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BubbleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet;
import com.github.mikephil.charting.renderer.BarLineScatterCandleBubbleRenderer;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class BubbleChartRenderer extends BarLineScatterCandleBubbleRenderer {
    private float[] _hsvBuffer;
    protected BubbleDataProvider mChart;
    private float[] pointBuffer;
    private float[] sizeBuffer;

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawData(Canvas canvas) {
        for (T t5 : this.mChart.getBubbleData().getDataSets()) {
            if (t5.isVisible()) {
                drawDataSet(canvas, t5);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        BubbleData bubbleData = this.mChart.getBubbleData();
        float phaseY = this.mAnimator.getPhaseY();
        for (Highlight highlight : highlightArr) {
            IBubbleDataSet iBubbleDataSet = (IBubbleDataSet) bubbleData.getDataSetByIndex(highlight.getDataSetIndex());
            if (iBubbleDataSet != null && iBubbleDataSet.isHighlightEnabled()) {
                BubbleEntry bubbleEntry = (BubbleEntry) iBubbleDataSet.getEntryForXValue(highlight.getX(), highlight.getY());
                if (bubbleEntry.getY() == highlight.getY() && isInBoundsX(bubbleEntry, iBubbleDataSet)) {
                    Transformer transformer = this.mChart.getTransformer(iBubbleDataSet.getAxisDependency());
                    float[] fArr = this.sizeBuffer;
                    fArr[0] = 0.0f;
                    fArr[2] = 1.0f;
                    transformer.pointValuesToPixel(fArr);
                    boolean isNormalizeSizeEnabled = iBubbleDataSet.isNormalizeSizeEnabled();
                    float[] fArr2 = this.sizeBuffer;
                    float min = Math.min(Math.abs(this.mViewPortHandler.contentBottom() - this.mViewPortHandler.contentTop()), Math.abs(fArr2[2] - fArr2[0]));
                    this.pointBuffer[0] = bubbleEntry.getX();
                    this.pointBuffer[1] = bubbleEntry.getY() * phaseY;
                    transformer.pointValuesToPixel(this.pointBuffer);
                    float[] fArr3 = this.pointBuffer;
                    highlight.setDraw(fArr3[0], fArr3[1]);
                    float shapeSize = getShapeSize(bubbleEntry.getSize(), iBubbleDataSet.getMaxSize(), min, isNormalizeSizeEnabled) / 2.0f;
                    if (this.mViewPortHandler.isInBoundsTop(this.pointBuffer[1] + shapeSize) && this.mViewPortHandler.isInBoundsBottom(this.pointBuffer[1] - shapeSize) && this.mViewPortHandler.isInBoundsLeft(this.pointBuffer[0] + shapeSize)) {
                        if (!this.mViewPortHandler.isInBoundsRight(this.pointBuffer[0] - shapeSize)) {
                            return;
                        }
                        int color = iBubbleDataSet.getColor((int) bubbleEntry.getX());
                        Color.RGBToHSV(Color.red(color), Color.green(color), Color.blue(color), this._hsvBuffer);
                        float[] fArr4 = this._hsvBuffer;
                        fArr4[2] = fArr4[2] * 0.5f;
                        this.mHighlightPaint.setColor(Color.HSVToColor(Color.alpha(color), this._hsvBuffer));
                        this.mHighlightPaint.setStrokeWidth(iBubbleDataSet.getHighlightCircleWidth());
                        float[] fArr5 = this.pointBuffer;
                        canvas.drawCircle(fArr5[0], fArr5[1], shapeSize, this.mHighlightPaint);
                    }
                }
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValue(Canvas canvas, String str, float f6, float f7, int i6) {
        this.mValuePaint.setColor(i6);
        canvas.drawText(str, f6, f7, this.mValuePaint);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValues(Canvas canvas) {
        BubbleEntry bubbleEntry;
        float f6;
        BubbleChartRenderer bubbleChartRenderer = this;
        BubbleData bubbleData = bubbleChartRenderer.mChart.getBubbleData();
        if (bubbleData != null && bubbleChartRenderer.isDrawingValuesAllowed(bubbleChartRenderer.mChart)) {
            List<T> dataSets = bubbleData.getDataSets();
            float calcTextHeight = Utils.calcTextHeight(bubbleChartRenderer.mValuePaint, "1");
            int i6 = 0;
            while (i6 < dataSets.size()) {
                IBubbleDataSet iBubbleDataSet = (IBubbleDataSet) dataSets.get(i6);
                if (bubbleChartRenderer.shouldDrawValues(iBubbleDataSet) && iBubbleDataSet.getEntryCount() >= 1) {
                    bubbleChartRenderer.applyValueTextStyle(iBubbleDataSet);
                    float max = Math.max(0.0f, Math.min(1.0f, bubbleChartRenderer.mAnimator.getPhaseX()));
                    float phaseY = bubbleChartRenderer.mAnimator.getPhaseY();
                    bubbleChartRenderer.mXBounds.set(bubbleChartRenderer.mChart, iBubbleDataSet);
                    Transformer transformer = bubbleChartRenderer.mChart.getTransformer(iBubbleDataSet.getAxisDependency());
                    BarLineScatterCandleBubbleRenderer.XBounds xBounds = bubbleChartRenderer.mXBounds;
                    float[] generateTransformedValuesBubble = transformer.generateTransformedValuesBubble(iBubbleDataSet, phaseY, xBounds.min, xBounds.max);
                    float f7 = max == 1.0f ? phaseY : max;
                    ValueFormatter valueFormatter = iBubbleDataSet.getValueFormatter();
                    MPPointF mPPointF = MPPointF.getInstance(iBubbleDataSet.getIconsOffset());
                    mPPointF.f32565x = Utils.convertDpToPixel(mPPointF.f32565x);
                    mPPointF.f32566y = Utils.convertDpToPixel(mPPointF.f32566y);
                    int i7 = 0;
                    while (i7 < generateTransformedValuesBubble.length) {
                        int i8 = i7 / 2;
                        int valueTextColor = iBubbleDataSet.getValueTextColor(bubbleChartRenderer.mXBounds.min + i8);
                        int argb = Color.argb(Math.round(255.0f * f7), Color.red(valueTextColor), Color.green(valueTextColor), Color.blue(valueTextColor));
                        float f8 = generateTransformedValuesBubble[i7];
                        float f9 = generateTransformedValuesBubble[i7 + 1];
                        if (!bubbleChartRenderer.mViewPortHandler.isInBoundsRight(f8)) {
                            break;
                        }
                        if (bubbleChartRenderer.mViewPortHandler.isInBoundsLeft(f8) && bubbleChartRenderer.mViewPortHandler.isInBoundsY(f9)) {
                            BubbleEntry bubbleEntry2 = (BubbleEntry) iBubbleDataSet.getEntryForIndex(i8 + bubbleChartRenderer.mXBounds.min);
                            if (iBubbleDataSet.isDrawValuesEnabled()) {
                                f6 = f9;
                                bubbleEntry = bubbleEntry2;
                                bubbleChartRenderer.drawValue(canvas, valueFormatter.getBubbleLabel(bubbleEntry2), f8, f9 + (0.5f * calcTextHeight), argb);
                            } else {
                                bubbleEntry = bubbleEntry2;
                                f6 = f9;
                            }
                            if (bubbleEntry.getIcon() != null && iBubbleDataSet.isDrawIconsEnabled()) {
                                Drawable icon = bubbleEntry.getIcon();
                                Utils.drawImage(canvas, icon, (int) (f8 + mPPointF.f32565x), (int) (f6 + mPPointF.f32566y), icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                            }
                        }
                        i7 += 2;
                        bubbleChartRenderer = this;
                    }
                    MPPointF.recycleInstance(mPPointF);
                }
                i6++;
                bubbleChartRenderer = this;
            }
        }
    }

    protected float getShapeSize(float f6, float f7, float f8, boolean z5) {
        if (z5) {
            f6 = f7 == 0.0f ? 1.0f : (float) Math.sqrt(f6 / f7);
        }
        return f8 * f6;
    }

    public BubbleChartRenderer(BubbleDataProvider bubbleDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.sizeBuffer = new float[4];
        this.pointBuffer = new float[2];
        this._hsvBuffer = new float[3];
        this.mChart = bubbleDataProvider;
        this.mRenderPaint.setStyle(Paint.Style.FILL);
        this.mHighlightPaint.setStyle(Paint.Style.STROKE);
        this.mHighlightPaint.setStrokeWidth(Utils.convertDpToPixel(1.5f));
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void drawDataSet(Canvas canvas, IBubbleDataSet iBubbleDataSet) {
        if (iBubbleDataSet.getEntryCount() >= 1) {
            Transformer transformer = this.mChart.getTransformer(iBubbleDataSet.getAxisDependency());
            float phaseY = this.mAnimator.getPhaseY();
            this.mXBounds.set(this.mChart, iBubbleDataSet);
            float[] fArr = this.sizeBuffer;
            fArr[0] = 0.0f;
            fArr[2] = 1.0f;
            transformer.pointValuesToPixel(fArr);
            boolean isNormalizeSizeEnabled = iBubbleDataSet.isNormalizeSizeEnabled();
            float[] fArr2 = this.sizeBuffer;
            float min = Math.min(Math.abs(this.mViewPortHandler.contentBottom() - this.mViewPortHandler.contentTop()), Math.abs(fArr2[2] - fArr2[0]));
            int i6 = this.mXBounds.min;
            while (true) {
                BarLineScatterCandleBubbleRenderer.XBounds xBounds = this.mXBounds;
                if (i6 <= xBounds.range + xBounds.min) {
                    BubbleEntry bubbleEntry = (BubbleEntry) iBubbleDataSet.getEntryForIndex(i6);
                    this.pointBuffer[0] = bubbleEntry.getX();
                    this.pointBuffer[1] = bubbleEntry.getY() * phaseY;
                    transformer.pointValuesToPixel(this.pointBuffer);
                    float shapeSize = getShapeSize(bubbleEntry.getSize(), iBubbleDataSet.getMaxSize(), min, isNormalizeSizeEnabled) / 2.0f;
                    if (this.mViewPortHandler.isInBoundsTop(this.pointBuffer[1] + shapeSize) && this.mViewPortHandler.isInBoundsBottom(this.pointBuffer[1] - shapeSize) && this.mViewPortHandler.isInBoundsLeft(this.pointBuffer[0] + shapeSize)) {
                        if (this.mViewPortHandler.isInBoundsRight(this.pointBuffer[0] - shapeSize)) {
                            this.mRenderPaint.setColor(iBubbleDataSet.getColor((int) bubbleEntry.getX()));
                            float[] fArr3 = this.pointBuffer;
                            canvas.drawCircle(fArr3[0], fArr3[1], shapeSize, this.mRenderPaint);
                        } else {
                            return;
                        }
                    }
                    i6++;
                } else {
                    return;
                }
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawExtras(Canvas canvas) {
    }
}
