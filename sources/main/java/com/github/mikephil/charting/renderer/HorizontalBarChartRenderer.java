package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.buffer.BarBuffer;
import com.github.mikephil.charting.buffer.HorizontalBarBuffer;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.ChartInterface;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.tencent.connect.common.Constants;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class HorizontalBarChartRenderer extends BarChartRenderer {
    private RectF mBarShadowRectBuffer;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.BarChartRenderer
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
                rectF.top = x5 - barWidth;
                rectF.bottom = x5 + barWidth;
                transformer.rectValueToPixel(rectF);
                if (this.mViewPortHandler.isInBoundsTop(this.mBarShadowRectBuffer.bottom)) {
                    if (!this.mViewPortHandler.isInBoundsBottom(this.mBarShadowRectBuffer.top)) {
                        break;
                    }
                    this.mBarShadowRectBuffer.left = this.mViewPortHandler.contentLeft();
                    this.mBarShadowRectBuffer.right = this.mViewPortHandler.contentRight();
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
            int i9 = i7 + 3;
            if (!this.mViewPortHandler.isInBoundsTop(barBuffer.buffer[i9])) {
                return;
            }
            int i10 = i7 + 1;
            if (this.mViewPortHandler.isInBoundsBottom(barBuffer.buffer[i10])) {
                if (!z6) {
                    this.mRenderPaint.setColor(iBarDataSet.getColor(i7 / 4));
                }
                float[] fArr = barBuffer.buffer;
                int i11 = i7 + 2;
                canvas2.drawRect(fArr[i7], fArr[i10], fArr[i11], fArr[i9], this.mRenderPaint);
                if (z5) {
                    float[] fArr2 = barBuffer.buffer;
                    canvas.drawRect(fArr2[i7], fArr2[i10], fArr2[i11], fArr2[i9], this.mBarBorderPaint);
                }
            }
            i7 += 4;
            canvas2 = canvas;
        }
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer, com.github.mikephil.charting.renderer.DataRenderer
    public void drawValue(Canvas canvas, String str, float f6, float f7, int i6) {
        this.mValuePaint.setColor(i6);
        canvas.drawText(str, f6, f7, this.mValuePaint);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.BarChartRenderer, com.github.mikephil.charting.renderer.DataRenderer
    public void drawValues(Canvas canvas) {
        List list;
        float f6;
        MPPointF mPPointF;
        boolean z5;
        int i6;
        float[] fArr;
        float f7;
        int i7;
        int i8;
        float f8;
        BarEntry barEntry;
        boolean z6;
        int i9;
        int i10;
        List list2;
        float f9;
        BarBuffer barBuffer;
        MPPointF mPPointF2;
        HorizontalBarChartRenderer horizontalBarChartRenderer = this;
        if (horizontalBarChartRenderer.isDrawingValuesAllowed(horizontalBarChartRenderer.mChart)) {
            List dataSets = horizontalBarChartRenderer.mChart.getBarData().getDataSets();
            float convertDpToPixel = Utils.convertDpToPixel(5.0f);
            boolean isDrawValueAboveBarEnabled = horizontalBarChartRenderer.mChart.isDrawValueAboveBarEnabled();
            int i11 = 0;
            HorizontalBarChartRenderer horizontalBarChartRenderer2 = horizontalBarChartRenderer;
            while (i11 < horizontalBarChartRenderer2.mChart.getBarData().getDataSetCount()) {
                IBarDataSet iBarDataSet = (IBarDataSet) dataSets.get(i11);
                if (horizontalBarChartRenderer2.shouldDrawValues(iBarDataSet)) {
                    boolean isInverted = horizontalBarChartRenderer2.mChart.isInverted(iBarDataSet.getAxisDependency());
                    horizontalBarChartRenderer2.applyValueTextStyle(iBarDataSet);
                    float f10 = 2.0f;
                    float calcTextHeight = Utils.calcTextHeight(horizontalBarChartRenderer2.mValuePaint, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ) / 2.0f;
                    ValueFormatter valueFormatter = iBarDataSet.getValueFormatter();
                    BarBuffer barBuffer2 = horizontalBarChartRenderer2.mBarBuffers[i11];
                    float phaseY = horizontalBarChartRenderer2.mAnimator.getPhaseY();
                    MPPointF mPPointF3 = MPPointF.getInstance(iBarDataSet.getIconsOffset());
                    mPPointF3.f32565x = Utils.convertDpToPixel(mPPointF3.f32565x);
                    mPPointF3.f32566y = Utils.convertDpToPixel(mPPointF3.f32566y);
                    if (iBarDataSet.isStacked()) {
                        list = dataSets;
                        f6 = convertDpToPixel;
                        mPPointF = mPPointF3;
                        Transformer transformer = horizontalBarChartRenderer2.mChart.getTransformer(iBarDataSet.getAxisDependency());
                        int i12 = 0;
                        int i13 = 0;
                        while (i12 < iBarDataSet.getEntryCount() * horizontalBarChartRenderer2.mAnimator.getPhaseX()) {
                            BarEntry barEntry2 = (BarEntry) iBarDataSet.getEntryForIndex(i12);
                            int valueTextColor = iBarDataSet.getValueTextColor(i12);
                            float[] yVals = barEntry2.getYVals();
                            if (yVals == null) {
                                int i14 = i13 + 1;
                                if (!horizontalBarChartRenderer2.mViewPortHandler.isInBoundsTop(barBuffer2.buffer[i14])) {
                                    break;
                                }
                                if (horizontalBarChartRenderer2.mViewPortHandler.isInBoundsX(barBuffer2.buffer[i13]) && horizontalBarChartRenderer2.mViewPortHandler.isInBoundsBottom(barBuffer2.buffer[i14])) {
                                    String barLabel = valueFormatter.getBarLabel(barEntry2);
                                    float calcTextWidth = Utils.calcTextWidth(horizontalBarChartRenderer2.mValuePaint, barLabel);
                                    float f11 = isDrawValueAboveBarEnabled ? f6 : -(calcTextWidth + f6);
                                    float f12 = isDrawValueAboveBarEnabled ? -(calcTextWidth + f6) : f6;
                                    if (isInverted) {
                                        f11 = (-f11) - calcTextWidth;
                                        f12 = (-f12) - calcTextWidth;
                                    }
                                    float f13 = f11;
                                    float f14 = f12;
                                    if (iBarDataSet.isDrawValuesEnabled()) {
                                        barEntry = barEntry2;
                                        z5 = isDrawValueAboveBarEnabled;
                                        fArr = yVals;
                                        drawValue(canvas, barLabel, barBuffer2.buffer[i13 + 2] + (barEntry2.getY() >= 0.0f ? f13 : f14), barBuffer2.buffer[i14] + calcTextHeight, valueTextColor);
                                    } else {
                                        barEntry = barEntry2;
                                        z5 = isDrawValueAboveBarEnabled;
                                        fArr = yVals;
                                    }
                                    if (barEntry.getIcon() == null || !iBarDataSet.isDrawIconsEnabled()) {
                                        i6 = i11;
                                    } else {
                                        Drawable icon = barEntry.getIcon();
                                        float f15 = barBuffer2.buffer[i13 + 2];
                                        if (barEntry.getY() < 0.0f) {
                                            f13 = f14;
                                        }
                                        float f16 = barBuffer2.buffer[i14];
                                        i6 = i11;
                                        Utils.drawImage(canvas, icon, (int) (f15 + f13 + mPPointF.f32565x), (int) (f16 + mPPointF.f32566y), icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                                    }
                                }
                            } else {
                                BarEntry barEntry3 = barEntry2;
                                z5 = isDrawValueAboveBarEnabled;
                                i6 = i11;
                                HorizontalBarChartRenderer horizontalBarChartRenderer3 = horizontalBarChartRenderer2;
                                fArr = yVals;
                                int length = fArr.length * 2;
                                float[] fArr2 = new float[length];
                                float f17 = -barEntry3.getNegativeSum();
                                int i15 = 0;
                                int i16 = 0;
                                float f18 = 0.0f;
                                while (i15 < length) {
                                    float f19 = fArr[i16];
                                    if (f19 == 0.0f && (f18 == 0.0f || f17 == 0.0f)) {
                                        float f20 = f17;
                                        f17 = f19;
                                        f8 = f20;
                                    } else if (f19 >= 0.0f) {
                                        f18 += f19;
                                        f8 = f17;
                                        f17 = f18;
                                    } else {
                                        f8 = f17 - f19;
                                    }
                                    fArr2[i15] = f17 * phaseY;
                                    i15 += 2;
                                    i16++;
                                    f17 = f8;
                                }
                                transformer.pointValuesToPixel(fArr2);
                                int i17 = 0;
                                while (i17 < length) {
                                    float f21 = fArr[i17 / 2];
                                    BarEntry barEntry4 = barEntry3;
                                    int i18 = i17;
                                    String barStackedLabel = valueFormatter.getBarStackedLabel(f21, barEntry4);
                                    int i19 = length;
                                    float calcTextWidth2 = Utils.calcTextWidth(horizontalBarChartRenderer3.mValuePaint, barStackedLabel);
                                    float f22 = z5 ? f6 : -(calcTextWidth2 + f6);
                                    float[] fArr3 = fArr2;
                                    float f23 = z5 ? -(calcTextWidth2 + f6) : f6;
                                    if (isInverted) {
                                        f22 = (-f22) - calcTextWidth2;
                                        f23 = (-f23) - calcTextWidth2;
                                    }
                                    boolean z7 = (f21 == 0.0f && f17 == 0.0f && f18 > 0.0f) || f21 < 0.0f;
                                    float f24 = fArr3[i18];
                                    if (z7) {
                                        f22 = f23;
                                    }
                                    float f25 = f24 + f22;
                                    float[] fArr4 = barBuffer2.buffer;
                                    float f26 = (fArr4[i13 + 1] + fArr4[i13 + 3]) / 2.0f;
                                    if (!horizontalBarChartRenderer3.mViewPortHandler.isInBoundsTop(f26)) {
                                        break;
                                    }
                                    if (horizontalBarChartRenderer3.mViewPortHandler.isInBoundsX(f25) && horizontalBarChartRenderer3.mViewPortHandler.isInBoundsBottom(f26)) {
                                        if (iBarDataSet.isDrawValuesEnabled()) {
                                            float f27 = f26 + calcTextHeight;
                                            f7 = f26;
                                            HorizontalBarChartRenderer horizontalBarChartRenderer4 = horizontalBarChartRenderer3;
                                            i7 = i18;
                                            barEntry3 = barEntry4;
                                            horizontalBarChartRenderer4.drawValue(canvas, barStackedLabel, f25, f27, valueTextColor);
                                        } else {
                                            f7 = f26;
                                            i7 = i18;
                                            barEntry3 = barEntry4;
                                        }
                                        i8 = valueTextColor;
                                        if (barEntry3.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                            Drawable icon2 = barEntry3.getIcon();
                                            Utils.drawImage(canvas, icon2, (int) (f25 + mPPointF.f32565x), (int) (f7 + mPPointF.f32566y), icon2.getIntrinsicWidth(), icon2.getIntrinsicHeight());
                                        }
                                    } else {
                                        i8 = valueTextColor;
                                        i7 = i18;
                                        barEntry3 = barEntry4;
                                    }
                                    i17 = i7 + 2;
                                    horizontalBarChartRenderer3 = this;
                                    length = i19;
                                    fArr2 = fArr3;
                                    valueTextColor = i8;
                                }
                            }
                            i13 = fArr == null ? i13 + 4 : i13 + (fArr.length * 4);
                            i12++;
                            horizontalBarChartRenderer2 = this;
                            i11 = i6;
                            isDrawValueAboveBarEnabled = z5;
                        }
                    } else {
                        int i20 = 0;
                        HorizontalBarChartRenderer horizontalBarChartRenderer5 = horizontalBarChartRenderer2;
                        while (i20 < barBuffer2.buffer.length * horizontalBarChartRenderer5.mAnimator.getPhaseX()) {
                            float[] fArr5 = barBuffer2.buffer;
                            int i21 = i20 + 1;
                            float f28 = fArr5[i21];
                            float f29 = (fArr5[i20 + 3] + f28) / f10;
                            if (!horizontalBarChartRenderer5.mViewPortHandler.isInBoundsTop(f28)) {
                                break;
                            }
                            if (horizontalBarChartRenderer5.mViewPortHandler.isInBoundsX(barBuffer2.buffer[i20]) && horizontalBarChartRenderer5.mViewPortHandler.isInBoundsBottom(barBuffer2.buffer[i21])) {
                                BarEntry barEntry5 = (BarEntry) iBarDataSet.getEntryForIndex(i20 / 4);
                                float y5 = barEntry5.getY();
                                MPPointF mPPointF4 = mPPointF3;
                                String barLabel2 = valueFormatter.getBarLabel(barEntry5);
                                float calcTextWidth3 = Utils.calcTextWidth(horizontalBarChartRenderer5.mValuePaint, barLabel2);
                                float f30 = isDrawValueAboveBarEnabled ? convertDpToPixel : -(calcTextWidth3 + convertDpToPixel);
                                float f31 = isDrawValueAboveBarEnabled ? -(calcTextWidth3 + convertDpToPixel) : convertDpToPixel;
                                if (isInverted) {
                                    f30 = (-f30) - calcTextWidth3;
                                    f31 = (-f31) - calcTextWidth3;
                                }
                                float f32 = f30;
                                float f33 = f31;
                                if (iBarDataSet.isDrawValuesEnabled()) {
                                    i10 = i20;
                                    list2 = dataSets;
                                    barBuffer = barBuffer2;
                                    f9 = convertDpToPixel;
                                    mPPointF2 = mPPointF4;
                                    HorizontalBarChartRenderer horizontalBarChartRenderer6 = this;
                                    horizontalBarChartRenderer6.drawValue(canvas, barLabel2, barBuffer2.buffer[i20 + 2] + (y5 >= 0.0f ? f32 : f33), f29 + calcTextHeight, iBarDataSet.getValueTextColor(i20 / 2));
                                    horizontalBarChartRenderer5 = horizontalBarChartRenderer6;
                                } else {
                                    horizontalBarChartRenderer5 = this;
                                    i10 = i20;
                                    list2 = dataSets;
                                    f9 = convertDpToPixel;
                                    barBuffer = barBuffer2;
                                    mPPointF2 = mPPointF4;
                                }
                                if (barEntry5.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                    Drawable icon3 = barEntry5.getIcon();
                                    float f34 = barBuffer.buffer[i10 + 2];
                                    if (y5 >= 0.0f) {
                                        f33 = f32;
                                    }
                                    Utils.drawImage(canvas, icon3, (int) (f34 + f33 + mPPointF2.f32565x), (int) (f29 + mPPointF2.f32566y), icon3.getIntrinsicWidth(), icon3.getIntrinsicHeight());
                                }
                            } else {
                                i10 = i20;
                                list2 = dataSets;
                                f9 = convertDpToPixel;
                                barBuffer = barBuffer2;
                                mPPointF2 = mPPointF3;
                            }
                            i20 = i10 + 4;
                            barBuffer2 = barBuffer;
                            mPPointF3 = mPPointF2;
                            convertDpToPixel = f9;
                            dataSets = list2;
                            f10 = 2.0f;
                            horizontalBarChartRenderer5 = horizontalBarChartRenderer5;
                        }
                        list = dataSets;
                        f6 = convertDpToPixel;
                        mPPointF = mPPointF3;
                    }
                    z6 = isDrawValueAboveBarEnabled;
                    i9 = i11;
                    MPPointF.recycleInstance(mPPointF);
                } else {
                    list = dataSets;
                    f6 = convertDpToPixel;
                    z6 = isDrawValueAboveBarEnabled;
                    i9 = i11;
                }
                i11 = i9 + 1;
                horizontalBarChartRenderer2 = this;
                convertDpToPixel = f6;
                dataSets = list;
                isDrawValueAboveBarEnabled = z6;
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer, com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
        BarData barData = this.mChart.getBarData();
        this.mBarBuffers = new HorizontalBarBuffer[barData.getDataSetCount()];
        for (int i6 = 0; i6 < this.mBarBuffers.length; i6++) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.getDataSetByIndex(i6);
            this.mBarBuffers[i6] = new HorizontalBarBuffer(iBarDataSet.getEntryCount() * 4 * (iBarDataSet.isStacked() ? iBarDataSet.getStackSize() : 1), barData.getDataSetCount(), iBarDataSet.isStacked());
        }
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer
    protected void prepareBarHighlight(float f6, float f7, float f8, float f9, Transformer transformer) {
        this.mBarRect.set(f7, f6 - f9, f8, f6 + f9);
        transformer.rectToPixelPhaseHorizontal(this.mBarRect, this.mAnimator.getPhaseY());
    }

    public HorizontalBarChartRenderer(BarDataProvider barDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(barDataProvider, chartAnimator, viewPortHandler);
        this.mBarShadowRectBuffer = new RectF();
        this.mValuePaint.setTextAlign(Paint.Align.LEFT);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    protected boolean isDrawingValuesAllowed(ChartInterface chartInterface) {
        if (chartInterface.getData().getEntryCount() < chartInterface.getMaxVisibleCount() * this.mViewPortHandler.getScaleY()) {
            return true;
        }
        return false;
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer
    protected void setHighlightDrawPos(Highlight highlight, RectF rectF) {
        highlight.setDraw(rectF.centerY(), rectF.right);
    }
}
