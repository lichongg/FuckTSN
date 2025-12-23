package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.buffer.BarBuffer;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.Range;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.model.GradientColor;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class BarChartRenderer extends BarLineScatterCandleBubbleRenderer {
    protected Paint mBarBorderPaint;
    protected BarBuffer[] mBarBuffers;
    protected RectF mBarRect;
    private RectF mBarShadowRectBuffer;
    protected BarDataProvider mChart;
    protected Paint mShadowPaint;

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawData(Canvas canvas) {
        BarData barData = this.mChart.getBarData();
        for (int i6 = 0; i6 < barData.getDataSetCount(); i6++) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.getDataSetByIndex(i6);
            if (iBarDataSet.isVisible()) {
                drawDataSet(canvas, iBarDataSet, i6);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void drawDataSet(Canvas canvas, IBarDataSet iBarDataSet, int i6) {
        Transformer transformer = this.mChart.getTransformer(iBarDataSet.getAxisDependency());
        this.mBarBorderPaint.setColor(iBarDataSet.getBarBorderColor());
        this.mBarBorderPaint.setStrokeWidth(Utils.convertDpToPixel(iBarDataSet.getBarBorderWidth()));
        int i7 = 0;
        boolean z5 = iBarDataSet.getBarBorderWidth() > 0.0f;
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        if (this.mChart.isDrawBarShadowEnabled()) {
            this.mShadowPaint.setColor(iBarDataSet.getBarShadowColor());
            float barWidth = this.mChart.getBarData().getBarWidth() / 2.0f;
            int min = Math.min((int) Math.ceil(iBarDataSet.getEntryCount() * phaseX), iBarDataSet.getEntryCount());
            for (int i8 = 0; i8 < min; i8++) {
                float x5 = ((BarEntry) iBarDataSet.getEntryForIndex(i8)).getX();
                RectF rectF = this.mBarShadowRectBuffer;
                rectF.left = x5 - barWidth;
                rectF.right = x5 + barWidth;
                transformer.rectValueToPixel(rectF);
                if (this.mViewPortHandler.isInBoundsLeft(this.mBarShadowRectBuffer.right)) {
                    if (!this.mViewPortHandler.isInBoundsRight(this.mBarShadowRectBuffer.left)) {
                        break;
                    }
                    this.mBarShadowRectBuffer.top = this.mViewPortHandler.contentTop();
                    this.mBarShadowRectBuffer.bottom = this.mViewPortHandler.contentBottom();
                    canvas.drawRect(this.mBarShadowRectBuffer, this.mShadowPaint);
                }
            }
        }
        Canvas canvas2 = canvas;
        BarBuffer barBuffer = this.mBarBuffers[i6];
        barBuffer.setPhases(phaseX, phaseY);
        barBuffer.setDataSet(i6);
        barBuffer.setInverted(this.mChart.isInverted(iBarDataSet.getAxisDependency()));
        barBuffer.setBarWidth(this.mChart.getBarData().getBarWidth());
        barBuffer.feed(iBarDataSet);
        transformer.pointValuesToPixel(barBuffer.buffer);
        boolean z6 = iBarDataSet.getColors().size() == 1;
        if (z6) {
            this.mRenderPaint.setColor(iBarDataSet.getColor());
        }
        while (i7 < barBuffer.size()) {
            int i9 = i7 + 2;
            if (this.mViewPortHandler.isInBoundsLeft(barBuffer.buffer[i9])) {
                if (!this.mViewPortHandler.isInBoundsRight(barBuffer.buffer[i7])) {
                    return;
                }
                if (!z6) {
                    this.mRenderPaint.setColor(iBarDataSet.getColor(i7 / 4));
                }
                if (iBarDataSet.getGradientColor() != null) {
                    GradientColor gradientColor = iBarDataSet.getGradientColor();
                    Paint paint = this.mRenderPaint;
                    float[] fArr = barBuffer.buffer;
                    float f6 = fArr[i7];
                    paint.setShader(new LinearGradient(f6, fArr[i7 + 3], f6, fArr[i7 + 1], gradientColor.getStartColor(), gradientColor.getEndColor(), Shader.TileMode.MIRROR));
                }
                if (iBarDataSet.getGradientColors() != null) {
                    Paint paint2 = this.mRenderPaint;
                    float[] fArr2 = barBuffer.buffer;
                    float f7 = fArr2[i7];
                    float f8 = fArr2[i7 + 3];
                    float f9 = fArr2[i7 + 1];
                    int i10 = i7 / 4;
                    paint2.setShader(new LinearGradient(f7, f8, f7, f9, iBarDataSet.getGradientColor(i10).getStartColor(), iBarDataSet.getGradientColor(i10).getEndColor(), Shader.TileMode.MIRROR));
                }
                float[] fArr3 = barBuffer.buffer;
                int i11 = i7 + 1;
                int i12 = i7 + 3;
                canvas2.drawRect(fArr3[i7], fArr3[i11], fArr3[i9], fArr3[i12], this.mRenderPaint);
                if (z5) {
                    float[] fArr4 = barBuffer.buffer;
                    canvas.drawRect(fArr4[i7], fArr4[i11], fArr4[i9], fArr4[i12], this.mBarBorderPaint);
                }
            }
            i7 += 4;
            canvas2 = canvas;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        float y5;
        float f6;
        BarData barData = this.mChart.getBarData();
        for (Highlight highlight : highlightArr) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.getDataSetByIndex(highlight.getDataSetIndex());
            if (iBarDataSet != null && iBarDataSet.isHighlightEnabled()) {
                BarEntry barEntry = (BarEntry) iBarDataSet.getEntryForXValue(highlight.getX(), highlight.getY());
                if (isInBoundsX(barEntry, iBarDataSet)) {
                    Transformer transformer = this.mChart.getTransformer(iBarDataSet.getAxisDependency());
                    this.mHighlightPaint.setColor(iBarDataSet.getHighLightColor());
                    this.mHighlightPaint.setAlpha(iBarDataSet.getHighLightAlpha());
                    if (highlight.getStackIndex() < 0 || !barEntry.isStacked()) {
                        y5 = barEntry.getY();
                        f6 = 0.0f;
                    } else if (this.mChart.isHighlightFullBarEnabled()) {
                        y5 = barEntry.getPositiveSum();
                        f6 = -barEntry.getNegativeSum();
                    } else {
                        Range range = barEntry.getRanges()[highlight.getStackIndex()];
                        float f7 = range.from;
                        f6 = range.to;
                        y5 = f7;
                    }
                    prepareBarHighlight(barEntry.getX(), y5, f6, barData.getBarWidth() / 2.0f, transformer);
                    setHighlightDrawPos(highlight, this.mBarRect);
                    canvas.drawRect(this.mBarRect, this.mHighlightPaint);
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
        List list;
        MPPointF mPPointF;
        int i6;
        boolean z5;
        int i7;
        float[] fArr;
        float f6;
        Transformer transformer;
        int i8;
        float f7;
        int i9;
        float f8;
        float f9;
        BarEntry barEntry;
        float f10;
        float f11;
        boolean z6;
        int i10;
        ValueFormatter valueFormatter;
        List list2;
        MPPointF mPPointF2;
        BarEntry barEntry2;
        BarChartRenderer barChartRenderer = this;
        if (barChartRenderer.isDrawingValuesAllowed(barChartRenderer.mChart)) {
            List dataSets = barChartRenderer.mChart.getBarData().getDataSets();
            float convertDpToPixel = Utils.convertDpToPixel(4.5f);
            boolean isDrawValueAboveBarEnabled = barChartRenderer.mChart.isDrawValueAboveBarEnabled();
            int i11 = 0;
            while (i11 < barChartRenderer.mChart.getBarData().getDataSetCount()) {
                IBarDataSet iBarDataSet = (IBarDataSet) dataSets.get(i11);
                if (barChartRenderer.shouldDrawValues(iBarDataSet)) {
                    barChartRenderer.applyValueTextStyle(iBarDataSet);
                    boolean isInverted = barChartRenderer.mChart.isInverted(iBarDataSet.getAxisDependency());
                    float calcTextHeight = Utils.calcTextHeight(barChartRenderer.mValuePaint, "8");
                    float f12 = isDrawValueAboveBarEnabled ? -convertDpToPixel : calcTextHeight + convertDpToPixel;
                    float f13 = isDrawValueAboveBarEnabled ? calcTextHeight + convertDpToPixel : -convertDpToPixel;
                    if (isInverted) {
                        f12 = (-f12) - calcTextHeight;
                        f13 = (-f13) - calcTextHeight;
                    }
                    float f14 = f12;
                    float f15 = f13;
                    BarBuffer barBuffer = barChartRenderer.mBarBuffers[i11];
                    float phaseY = barChartRenderer.mAnimator.getPhaseY();
                    ValueFormatter valueFormatter2 = iBarDataSet.getValueFormatter();
                    MPPointF mPPointF3 = MPPointF.getInstance(iBarDataSet.getIconsOffset());
                    mPPointF3.f32565x = Utils.convertDpToPixel(mPPointF3.f32565x);
                    mPPointF3.f32566y = Utils.convertDpToPixel(mPPointF3.f32566y);
                    if (iBarDataSet.isStacked()) {
                        list = dataSets;
                        mPPointF = mPPointF3;
                        Transformer transformer2 = barChartRenderer.mChart.getTransformer(iBarDataSet.getAxisDependency());
                        int i12 = 0;
                        int i13 = 0;
                        while (i12 < iBarDataSet.getEntryCount() * barChartRenderer.mAnimator.getPhaseX()) {
                            BarEntry barEntry3 = (BarEntry) iBarDataSet.getEntryForIndex(i12);
                            float[] yVals = barEntry3.getYVals();
                            float[] fArr2 = barBuffer.buffer;
                            float f16 = (fArr2[i13] + fArr2[i13 + 2]) / 2.0f;
                            int valueTextColor = iBarDataSet.getValueTextColor(i12);
                            if (yVals == null) {
                                Transformer transformer3 = transformer2;
                                if (!barChartRenderer.mViewPortHandler.isInBoundsRight(f16)) {
                                    break;
                                }
                                i6 = i12;
                                int i14 = i13 + 1;
                                if (barChartRenderer.mViewPortHandler.isInBoundsY(barBuffer.buffer[i14]) && barChartRenderer.mViewPortHandler.isInBoundsLeft(f16)) {
                                    if (iBarDataSet.isDrawValuesEnabled()) {
                                        String barLabel = valueFormatter2.getBarLabel(barEntry3);
                                        float f17 = barBuffer.buffer[i14] + (barEntry3.getY() >= 0.0f ? f14 : f15);
                                        barEntry = barEntry3;
                                        f10 = f16;
                                        f6 = convertDpToPixel;
                                        transformer = transformer3;
                                        z5 = isDrawValueAboveBarEnabled;
                                        fArr = yVals;
                                        barChartRenderer.drawValue(canvas, barLabel, f10, f17, valueTextColor);
                                    } else {
                                        f6 = convertDpToPixel;
                                        z5 = isDrawValueAboveBarEnabled;
                                        transformer = transformer3;
                                        barEntry = barEntry3;
                                        fArr = yVals;
                                        f10 = f16;
                                    }
                                    if (barEntry.getIcon() == null || !iBarDataSet.isDrawIconsEnabled()) {
                                        i7 = i11;
                                    } else {
                                        Drawable icon = barEntry.getIcon();
                                        float f18 = barBuffer.buffer[i14] + (barEntry.getY() >= 0.0f ? f14 : f15);
                                        i7 = i11;
                                        Utils.drawImage(canvas, icon, (int) (f10 + mPPointF.f32565x), (int) (f18 + mPPointF.f32566y), icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                                    }
                                } else {
                                    z5 = isDrawValueAboveBarEnabled;
                                    i7 = i11;
                                    transformer2 = transformer3;
                                    barChartRenderer = barChartRenderer;
                                    convertDpToPixel = convertDpToPixel;
                                    i12 = i6;
                                    i11 = i7;
                                    isDrawValueAboveBarEnabled = z5;
                                }
                            } else {
                                i6 = i12;
                                BarEntry barEntry4 = barEntry3;
                                float f19 = f16;
                                z5 = isDrawValueAboveBarEnabled;
                                i7 = i11;
                                int i15 = valueTextColor;
                                BarChartRenderer barChartRenderer2 = barChartRenderer;
                                fArr = yVals;
                                f6 = convertDpToPixel;
                                transformer = transformer2;
                                int length = fArr.length * 2;
                                float[] fArr3 = new float[length];
                                float f20 = -barEntry4.getNegativeSum();
                                int i16 = 0;
                                int i17 = 0;
                                float f21 = 0.0f;
                                while (i16 < length) {
                                    float f22 = fArr[i17];
                                    if (f22 == 0.0f && (f21 == 0.0f || f20 == 0.0f)) {
                                        f9 = f20;
                                        f20 = f22;
                                    } else if (f22 >= 0.0f) {
                                        f21 += f22;
                                        f9 = f20;
                                        f20 = f21;
                                    } else {
                                        f9 = f20 - f22;
                                    }
                                    fArr3[i16 + 1] = f20 * phaseY;
                                    i16 += 2;
                                    i17++;
                                    f20 = f9;
                                }
                                transformer.pointValuesToPixel(fArr3);
                                int i18 = 0;
                                while (i18 < length) {
                                    float f23 = fArr[i18 / 2];
                                    int i19 = length;
                                    float f24 = fArr3[i18 + 1] + (((f23 > 0.0f ? 1 : (f23 == 0.0f ? 0 : -1)) == 0 && (f20 > 0.0f ? 1 : (f20 == 0.0f ? 0 : -1)) == 0 && (f21 > 0.0f ? 1 : (f21 == 0.0f ? 0 : -1)) > 0) || (f23 > 0.0f ? 1 : (f23 == 0.0f ? 0 : -1)) < 0 ? f15 : f14);
                                    float[] fArr4 = fArr3;
                                    if (!barChartRenderer2.mViewPortHandler.isInBoundsRight(f19)) {
                                        break;
                                    }
                                    if (barChartRenderer2.mViewPortHandler.isInBoundsY(f24) && barChartRenderer2.mViewPortHandler.isInBoundsLeft(f19)) {
                                        if (iBarDataSet.isDrawValuesEnabled()) {
                                            BarEntry barEntry5 = barEntry4;
                                            String barStackedLabel = valueFormatter2.getBarStackedLabel(f23, barEntry5);
                                            f8 = f24;
                                            BarChartRenderer barChartRenderer3 = barChartRenderer2;
                                            i8 = i18;
                                            barEntry4 = barEntry5;
                                            barChartRenderer3.drawValue(canvas, barStackedLabel, f19, f8, i15);
                                        } else {
                                            f8 = f24;
                                            i8 = i18;
                                        }
                                        f7 = f19;
                                        i9 = i15;
                                        if (barEntry4.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                            Drawable icon2 = barEntry4.getIcon();
                                            Utils.drawImage(canvas, icon2, (int) (f7 + mPPointF.f32565x), (int) (mPPointF.f32566y + f8), icon2.getIntrinsicWidth(), icon2.getIntrinsicHeight());
                                        }
                                    } else {
                                        i8 = i18;
                                        f7 = f19;
                                        i9 = i15;
                                    }
                                    i18 = i8 + 2;
                                    barChartRenderer2 = this;
                                    fArr3 = fArr4;
                                    f19 = f7;
                                    length = i19;
                                    i15 = i9;
                                }
                            }
                            i13 = fArr == null ? i13 + 4 : i13 + (fArr.length * 4);
                            i12 = i6 + 1;
                            barChartRenderer = this;
                            transformer2 = transformer;
                            convertDpToPixel = f6;
                            i11 = i7;
                            isDrawValueAboveBarEnabled = z5;
                        }
                    } else {
                        int i20 = 0;
                        while (i20 < barBuffer.buffer.length * barChartRenderer.mAnimator.getPhaseX()) {
                            float[] fArr5 = barBuffer.buffer;
                            float f25 = (fArr5[i20] + fArr5[i20 + 2]) / 2.0f;
                            if (!barChartRenderer.mViewPortHandler.isInBoundsRight(f25)) {
                                break;
                            }
                            int i21 = i20 + 1;
                            if (barChartRenderer.mViewPortHandler.isInBoundsY(barBuffer.buffer[i21]) && barChartRenderer.mViewPortHandler.isInBoundsLeft(f25)) {
                                int i22 = i20 / 4;
                                BarEntry barEntry6 = (BarEntry) iBarDataSet.getEntryForIndex(i22);
                                float y5 = barEntry6.getY();
                                if (iBarDataSet.isDrawValuesEnabled()) {
                                    MPPointF mPPointF4 = mPPointF3;
                                    String barLabel2 = valueFormatter2.getBarLabel(barEntry6);
                                    float[] fArr6 = barBuffer.buffer;
                                    float f26 = y5 >= 0.0f ? fArr6[i21] + f14 : fArr6[i20 + 3] + f15;
                                    int valueTextColor2 = iBarDataSet.getValueTextColor(i22);
                                    list2 = dataSets;
                                    mPPointF2 = mPPointF4;
                                    barEntry2 = barEntry6;
                                    float f27 = f26;
                                    valueFormatter = valueFormatter2;
                                    barChartRenderer.drawValue(canvas, barLabel2, f25, f27, valueTextColor2);
                                } else {
                                    valueFormatter = valueFormatter2;
                                    barEntry2 = barEntry6;
                                    list2 = dataSets;
                                    mPPointF2 = mPPointF3;
                                }
                                if (barEntry2.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                    Drawable icon3 = barEntry2.getIcon();
                                    Utils.drawImage(canvas, icon3, (int) (f25 + mPPointF2.f32565x), (int) ((y5 >= 0.0f ? barBuffer.buffer[i21] + f14 : barBuffer.buffer[i20 + 3] + f15) + mPPointF2.f32566y), icon3.getIntrinsicWidth(), icon3.getIntrinsicHeight());
                                }
                            } else {
                                valueFormatter = valueFormatter2;
                                list2 = dataSets;
                                mPPointF2 = mPPointF3;
                            }
                            i20 += 4;
                            mPPointF3 = mPPointF2;
                            valueFormatter2 = valueFormatter;
                            dataSets = list2;
                        }
                        list = dataSets;
                        mPPointF = mPPointF3;
                    }
                    f11 = convertDpToPixel;
                    z6 = isDrawValueAboveBarEnabled;
                    i10 = i11;
                    MPPointF.recycleInstance(mPPointF);
                } else {
                    list = dataSets;
                    f11 = convertDpToPixel;
                    z6 = isDrawValueAboveBarEnabled;
                    i10 = i11;
                }
                i11 = i10 + 1;
                barChartRenderer = this;
                convertDpToPixel = f11;
                dataSets = list;
                isDrawValueAboveBarEnabled = z6;
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
        BarData barData = this.mChart.getBarData();
        this.mBarBuffers = new BarBuffer[barData.getDataSetCount()];
        for (int i6 = 0; i6 < this.mBarBuffers.length; i6++) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.getDataSetByIndex(i6);
            this.mBarBuffers[i6] = new BarBuffer(iBarDataSet.getEntryCount() * 4 * (iBarDataSet.isStacked() ? iBarDataSet.getStackSize() : 1), barData.getDataSetCount(), iBarDataSet.isStacked());
        }
    }

    protected void prepareBarHighlight(float f6, float f7, float f8, float f9, Transformer transformer) {
        this.mBarRect.set(f6 - f9, f7, f6 + f9, f8);
        transformer.rectToPixelPhase(this.mBarRect, this.mAnimator.getPhaseY());
    }

    public BarChartRenderer(BarDataProvider barDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.mBarRect = new RectF();
        this.mBarShadowRectBuffer = new RectF();
        this.mChart = barDataProvider;
        Paint paint = new Paint(1);
        this.mHighlightPaint = paint;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        this.mHighlightPaint.setColor(Color.rgb(0, 0, 0));
        this.mHighlightPaint.setAlpha(120);
        Paint paint2 = new Paint(1);
        this.mShadowPaint = paint2;
        paint2.setStyle(style);
        Paint paint3 = new Paint(1);
        this.mBarBorderPaint = paint3;
        paint3.setStyle(Paint.Style.STROKE);
    }

    protected void setHighlightDrawPos(Highlight highlight, RectF rectF) {
        highlight.setDraw(rectF.centerX(), rectF.top);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawExtras(Canvas canvas) {
    }
}
