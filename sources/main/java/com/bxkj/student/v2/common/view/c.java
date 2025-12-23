package com.bxkj.student.v2.common.view;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.buffer.BarBuffer;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.Range;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.renderer.HorizontalBarChartRenderer;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class c extends HorizontalBarChartRenderer {

    /* renamed from: a, reason: collision with root package name */
    private RectF f21088a;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.HorizontalBarChartRenderer, com.github.mikephil.charting.renderer.BarChartRenderer
    protected void drawDataSet(Canvas c6, IBarDataSet dataSet, int index) {
        boolean z5;
        float f6;
        boolean z6;
        Transformer transformer = this.mChart.getTransformer(dataSet.getAxisDependency());
        this.mBarBorderPaint.setColor(dataSet.getBarBorderColor());
        this.mBarBorderPaint.setStrokeWidth(Utils.convertDpToPixel(dataSet.getBarBorderWidth()));
        boolean z7 = dataSet.getBarBorderWidth() > 0.0f;
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        if (this.mChart.isDrawBarShadowEnabled()) {
            this.mShadowPaint.setColor(dataSet.getBarShadowColor());
            float barWidth = this.mChart.getBarData().getBarWidth() / 2.0f;
            int min = Math.min((int) Math.ceil(dataSet.getEntryCount() * phaseX), dataSet.getEntryCount());
            int i6 = 0;
            while (i6 < min) {
                float x5 = ((BarEntry) dataSet.getEntryForIndex(i6)).getX();
                RectF rectF = this.f21088a;
                f6 = 2.0f;
                rectF.top = x5 - barWidth;
                rectF.bottom = x5 + barWidth;
                transformer.rectValueToPixel(rectF);
                if (!this.mViewPortHandler.isInBoundsTop(this.f21088a.bottom)) {
                    z6 = z7;
                } else {
                    if (!this.mViewPortHandler.isInBoundsBottom(this.f21088a.top)) {
                        z5 = z7;
                        break;
                    }
                    this.f21088a.left = this.mViewPortHandler.contentLeft();
                    this.f21088a.right = this.mViewPortHandler.contentRight();
                    RectF rectF2 = this.f21088a;
                    float f7 = (rectF2.bottom - rectF2.top) / 2.0f;
                    RectF rectF3 = this.f21088a;
                    float f8 = rectF3.right;
                    z6 = z7;
                    RectF rectF4 = new RectF(f8 - (f7 * 2.0f), rectF3.top, f8, rectF3.bottom);
                    Path path = new Path();
                    path.arcTo(rectF4, -90.0f, 180.0f, true);
                    RectF rectF5 = this.f21088a;
                    if (rectF5.right - rectF5.left < f7) {
                        path.lineTo(rectF4.centerX(), rectF4.bottom);
                        Path path2 = new Path();
                        RectF rectF6 = this.f21088a;
                        path2.addRect(rectF6.left, rectF6.top, rectF6.right, rectF6.bottom, Path.Direction.CW);
                        path.op(path2, Path.Op.INTERSECT);
                    } else {
                        path.moveTo(rectF4.centerX(), rectF4.bottom);
                        RectF rectF7 = this.f21088a;
                        path.lineTo(rectF7.left, rectF7.bottom);
                        RectF rectF8 = this.f21088a;
                        path.lineTo(rectF8.left, rectF8.top);
                        path.lineTo(rectF4.centerX(), this.f21088a.top);
                    }
                    c6.drawPath(path, this.mShadowPaint);
                }
                i6++;
                z7 = z6;
            }
        }
        z5 = z7;
        f6 = 2.0f;
        BarBuffer barBuffer = this.mBarBuffers[index];
        barBuffer.setPhases(phaseX, phaseY);
        barBuffer.setDataSet(index);
        barBuffer.setInverted(this.mChart.isInverted(dataSet.getAxisDependency()));
        barBuffer.setBarWidth(this.mChart.getBarData().getBarWidth());
        barBuffer.feed(dataSet);
        transformer.pointValuesToPixel(barBuffer.buffer);
        boolean z8 = dataSet.getColors().size() == 1;
        if (z8) {
            this.mRenderPaint.setColor(dataSet.getColor());
        }
        for (int i7 = 0; i7 < barBuffer.size(); i7 += 4) {
            int i8 = i7 + 3;
            if (!this.mViewPortHandler.isInBoundsTop(barBuffer.buffer[i8])) {
                return;
            }
            int i9 = i7 + 1;
            if (this.mViewPortHandler.isInBoundsBottom(barBuffer.buffer[i9])) {
                if (!z8) {
                    this.mRenderPaint.setColor(dataSet.getColor(i7 / 4));
                }
                float[] fArr = barBuffer.buffer;
                float f9 = (fArr[i8] - fArr[i9]) / f6;
                float[] fArr2 = barBuffer.buffer;
                int i10 = i7 + 2;
                float f10 = fArr2[i10];
                RectF rectF9 = new RectF(f10 - (f9 * f6), fArr2[i9], f10, fArr2[i8]);
                Path path3 = new Path();
                path3.arcTo(rectF9, -90.0f, 180.0f, true);
                float[] fArr3 = barBuffer.buffer;
                if (fArr3[i10] - fArr3[i7] < f9) {
                    path3.lineTo(rectF9.centerX(), rectF9.bottom);
                    Path path4 = new Path();
                    float[] fArr4 = barBuffer.buffer;
                    path4.addRect(fArr4[i7], fArr4[i9], fArr4[i10], fArr4[i8], Path.Direction.CW);
                    path3.op(path4, Path.Op.INTERSECT);
                } else {
                    path3.moveTo(rectF9.centerX(), rectF9.bottom);
                    float[] fArr5 = barBuffer.buffer;
                    path3.lineTo(fArr5[i7], fArr5[i8]);
                    float[] fArr6 = barBuffer.buffer;
                    path3.lineTo(fArr6[i7], fArr6[i9]);
                    path3.lineTo(rectF9.centerX(), barBuffer.buffer[i9]);
                }
                c6.drawPath(path3, this.mRenderPaint);
                if (z5) {
                    c6.drawPath(path3, this.mBarBorderPaint);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.BarChartRenderer, com.github.mikephil.charting.renderer.DataRenderer
    public void drawHighlighted(Canvas c6, Highlight[] indices) {
        float y5;
        float f6;
        Highlight[] highlightArr = indices;
        BarData barData = this.mChart.getBarData();
        float barWidth = barData.getBarWidth();
        float f7 = 2.0f;
        float f8 = barWidth / 2.0f;
        int length = highlightArr.length;
        int i6 = 0;
        while (i6 < length) {
            Highlight highlight = highlightArr[i6];
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
                        float f9 = range.from;
                        f6 = range.to;
                        y5 = f9;
                    }
                    float x5 = barEntry.getX() - f8;
                    float x6 = barEntry.getX() + f8;
                    RectF rectF = new RectF(y5 - (barWidth * f7), x5, y5, x6);
                    transformer.rectToPixelPhase(rectF, this.mAnimator.getPhaseY());
                    Path path = new Path();
                    path.arcTo(rectF, -90.0f, 180.0f, true);
                    RectF rectF2 = new RectF(f6, x5, y5, x6);
                    transformer.rectToPixelPhase(rectF2, this.mAnimator.getPhaseY());
                    if (y5 - barWidth < 0.0f) {
                        path.lineTo(rectF.centerX(), rectF.bottom);
                        Path path2 = new Path();
                        path2.addRect(rectF2.left, rectF2.top, rectF2.right, rectF2.bottom, Path.Direction.CW);
                        path.op(path2, Path.Op.INTERSECT);
                    } else {
                        path.moveTo(rectF.centerX(), rectF.bottom);
                        path.lineTo(rectF2.left, rectF.bottom);
                        path.lineTo(rectF2.left, rectF.top);
                        path.lineTo(rectF.centerX(), rectF.top);
                    }
                    c6.drawPath(path, this.mHighlightPaint);
                    i6++;
                    highlightArr = indices;
                    f7 = 2.0f;
                }
            }
            i6++;
            highlightArr = indices;
            f7 = 2.0f;
        }
    }

    public c(BarDataProvider chart, ChartAnimator animator, ViewPortHandler viewPortHandler) {
        super(chart, animator, viewPortHandler);
        this.f21088a = new RectF();
    }
}
