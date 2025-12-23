package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class YAxisRendererHorizontalBarChart extends YAxisRenderer {
    protected Path mDrawZeroLinePathBuffer;
    protected float[] mRenderLimitLinesBuffer;
    protected Path mRenderLimitLinesPathBuffer;

    @Override // com.github.mikephil.charting.renderer.AxisRenderer
    public void computeAxis(float f6, float f7, boolean z5) {
        float f8;
        double d6;
        if (this.mViewPortHandler.contentHeight() > 10.0f && !this.mViewPortHandler.isFullyZoomedOutX()) {
            MPPointD valuesByTouchPoint = this.mTrans.getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop());
            MPPointD valuesByTouchPoint2 = this.mTrans.getValuesByTouchPoint(this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentTop());
            if (z5) {
                f8 = (float) valuesByTouchPoint2.f32563x;
                d6 = valuesByTouchPoint.f32563x;
            } else {
                f8 = (float) valuesByTouchPoint.f32563x;
                d6 = valuesByTouchPoint2.f32563x;
            }
            float f9 = (float) d6;
            MPPointD.recycleInstance(valuesByTouchPoint);
            MPPointD.recycleInstance(valuesByTouchPoint2);
            f6 = f8;
            f7 = f9;
        }
        computeAxisValues(f6, f7);
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer
    protected void drawYLabels(Canvas canvas, float f6, float[] fArr, float f7) {
        this.mAxisLabelPaint.setTypeface(this.mYAxis.getTypeface());
        this.mAxisLabelPaint.setTextSize(this.mYAxis.getTextSize());
        this.mAxisLabelPaint.setColor(this.mYAxis.getTextColor());
        int i6 = this.mYAxis.isDrawTopYLabelEntryEnabled() ? this.mYAxis.mEntryCount : this.mYAxis.mEntryCount - 1;
        for (int i7 = !this.mYAxis.isDrawBottomYLabelEntryEnabled() ? 1 : 0; i7 < i6; i7++) {
            canvas.drawText(this.mYAxis.getFormattedLabel(i7), fArr[i7 * 2], f6 - f7, this.mAxisLabelPaint);
        }
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer
    public RectF getGridClippingRect() {
        this.mGridClippingRect.set(this.mViewPortHandler.getContentRect());
        this.mGridClippingRect.inset(-this.mAxis.getGridLineWidth(), 0.0f);
        return this.mGridClippingRect;
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer
    protected float[] getTransformedPositions() {
        int length = this.mGetTransformedPositionsBuffer.length;
        int i6 = this.mYAxis.mEntryCount;
        if (length != i6 * 2) {
            this.mGetTransformedPositionsBuffer = new float[i6 * 2];
        }
        float[] fArr = this.mGetTransformedPositionsBuffer;
        for (int i7 = 0; i7 < fArr.length; i7 += 2) {
            fArr[i7] = this.mYAxis.mEntries[i7 / 2];
        }
        this.mTrans.pointValuesToPixel(fArr);
        return fArr;
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer
    protected Path linePath(Path path, int i6, float[] fArr) {
        path.moveTo(fArr[i6], this.mViewPortHandler.contentTop());
        path.lineTo(fArr[i6], this.mViewPortHandler.contentBottom());
        return path;
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer, com.github.mikephil.charting.renderer.AxisRenderer
    public void renderAxisLabels(Canvas canvas) {
        float contentBottom;
        if (this.mYAxis.isEnabled() && this.mYAxis.isDrawLabelsEnabled()) {
            float[] transformedPositions = getTransformedPositions();
            this.mAxisLabelPaint.setTypeface(this.mYAxis.getTypeface());
            this.mAxisLabelPaint.setTextSize(this.mYAxis.getTextSize());
            this.mAxisLabelPaint.setColor(this.mYAxis.getTextColor());
            this.mAxisLabelPaint.setTextAlign(Paint.Align.CENTER);
            float convertDpToPixel = Utils.convertDpToPixel(2.5f);
            float calcTextHeight = Utils.calcTextHeight(this.mAxisLabelPaint, "Q");
            YAxis.AxisDependency axisDependency = this.mYAxis.getAxisDependency();
            YAxis.YAxisLabelPosition labelPosition = this.mYAxis.getLabelPosition();
            if (axisDependency == YAxis.AxisDependency.LEFT) {
                contentBottom = (labelPosition == YAxis.YAxisLabelPosition.OUTSIDE_CHART ? this.mViewPortHandler.contentTop() : this.mViewPortHandler.contentTop()) - convertDpToPixel;
            } else {
                contentBottom = (labelPosition == YAxis.YAxisLabelPosition.OUTSIDE_CHART ? this.mViewPortHandler.contentBottom() : this.mViewPortHandler.contentBottom()) + calcTextHeight + convertDpToPixel;
            }
            drawYLabels(canvas, contentBottom, transformedPositions, this.mYAxis.getYOffset());
        }
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer, com.github.mikephil.charting.renderer.AxisRenderer
    public void renderAxisLine(Canvas canvas) {
        if (this.mYAxis.isEnabled() && this.mYAxis.isDrawAxisLineEnabled()) {
            this.mAxisLinePaint.setColor(this.mYAxis.getAxisLineColor());
            this.mAxisLinePaint.setStrokeWidth(this.mYAxis.getAxisLineWidth());
            if (this.mYAxis.getAxisDependency() == YAxis.AxisDependency.LEFT) {
                canvas.drawLine(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop(), this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentTop(), this.mAxisLinePaint);
            } else {
                canvas.drawLine(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentBottom(), this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentBottom(), this.mAxisLinePaint);
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer, com.github.mikephil.charting.renderer.AxisRenderer
    public void renderLimitLines(Canvas canvas) {
        List<LimitLine> limitLines = this.mYAxis.getLimitLines();
        if (limitLines == null || limitLines.size() <= 0) {
            return;
        }
        float[] fArr = this.mRenderLimitLinesBuffer;
        char c6 = 0;
        float f6 = 0.0f;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        Path path = this.mRenderLimitLinesPathBuffer;
        path.reset();
        int i6 = 0;
        while (i6 < limitLines.size()) {
            LimitLine limitLine = limitLines.get(i6);
            if (limitLine.isEnabled()) {
                int save = canvas.save();
                this.mLimitLineClippingRect.set(this.mViewPortHandler.getContentRect());
                this.mLimitLineClippingRect.inset(-limitLine.getLineWidth(), f6);
                canvas.clipRect(this.mLimitLineClippingRect);
                fArr[c6] = limitLine.getLimit();
                fArr[2] = limitLine.getLimit();
                this.mTrans.pointValuesToPixel(fArr);
                fArr[1] = this.mViewPortHandler.contentTop();
                fArr[3] = this.mViewPortHandler.contentBottom();
                path.moveTo(fArr[c6], fArr[1]);
                path.lineTo(fArr[2], fArr[3]);
                this.mLimitLinePaint.setStyle(Paint.Style.STROKE);
                this.mLimitLinePaint.setColor(limitLine.getLineColor());
                this.mLimitLinePaint.setPathEffect(limitLine.getDashPathEffect());
                this.mLimitLinePaint.setStrokeWidth(limitLine.getLineWidth());
                canvas.drawPath(path, this.mLimitLinePaint);
                path.reset();
                String label = limitLine.getLabel();
                if (label != null && !label.equals("")) {
                    this.mLimitLinePaint.setStyle(limitLine.getTextStyle());
                    this.mLimitLinePaint.setPathEffect(null);
                    this.mLimitLinePaint.setColor(limitLine.getTextColor());
                    this.mLimitLinePaint.setTypeface(limitLine.getTypeface());
                    this.mLimitLinePaint.setStrokeWidth(0.5f);
                    this.mLimitLinePaint.setTextSize(limitLine.getTextSize());
                    float lineWidth = limitLine.getLineWidth() + limitLine.getXOffset();
                    float convertDpToPixel = Utils.convertDpToPixel(2.0f) + limitLine.getYOffset();
                    LimitLine.LimitLabelPosition labelPosition = limitLine.getLabelPosition();
                    if (labelPosition == LimitLine.LimitLabelPosition.RIGHT_TOP) {
                        float calcTextHeight = Utils.calcTextHeight(this.mLimitLinePaint, label);
                        this.mLimitLinePaint.setTextAlign(Paint.Align.LEFT);
                        canvas.drawText(label, fArr[0] + lineWidth, this.mViewPortHandler.contentTop() + convertDpToPixel + calcTextHeight, this.mLimitLinePaint);
                    } else if (labelPosition == LimitLine.LimitLabelPosition.RIGHT_BOTTOM) {
                        this.mLimitLinePaint.setTextAlign(Paint.Align.LEFT);
                        canvas.drawText(label, fArr[0] + lineWidth, this.mViewPortHandler.contentBottom() - convertDpToPixel, this.mLimitLinePaint);
                    } else if (labelPosition == LimitLine.LimitLabelPosition.LEFT_TOP) {
                        this.mLimitLinePaint.setTextAlign(Paint.Align.RIGHT);
                        canvas.drawText(label, fArr[0] - lineWidth, this.mViewPortHandler.contentTop() + convertDpToPixel + Utils.calcTextHeight(this.mLimitLinePaint, label), this.mLimitLinePaint);
                    } else {
                        this.mLimitLinePaint.setTextAlign(Paint.Align.RIGHT);
                        canvas.drawText(label, fArr[0] - lineWidth, this.mViewPortHandler.contentBottom() - convertDpToPixel, this.mLimitLinePaint);
                    }
                }
                canvas.restoreToCount(save);
            }
            i6++;
            c6 = 0;
            f6 = 0.0f;
        }
    }

    public YAxisRendererHorizontalBarChart(ViewPortHandler viewPortHandler, YAxis yAxis, Transformer transformer) {
        super(viewPortHandler, yAxis, transformer);
        this.mDrawZeroLinePathBuffer = new Path();
        this.mRenderLimitLinesPathBuffer = new Path();
        this.mRenderLimitLinesBuffer = new float[4];
        this.mLimitLinePaint.setTextAlign(Paint.Align.LEFT);
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer
    protected void drawZeroLine(Canvas canvas) {
        int save = canvas.save();
        this.mZeroLineClippingRect.set(this.mViewPortHandler.getContentRect());
        this.mZeroLineClippingRect.inset(-this.mYAxis.getZeroLineWidth(), 0.0f);
        canvas.clipRect(this.mLimitLineClippingRect);
        MPPointD pixelForValues = this.mTrans.getPixelForValues(0.0f, 0.0f);
        this.mZeroLinePaint.setColor(this.mYAxis.getZeroLineColor());
        this.mZeroLinePaint.setStrokeWidth(this.mYAxis.getZeroLineWidth());
        Path path = this.mDrawZeroLinePathBuffer;
        path.reset();
        path.moveTo(((float) pixelForValues.f32563x) - 1.0f, this.mViewPortHandler.contentTop());
        path.lineTo(((float) pixelForValues.f32563x) - 1.0f, this.mViewPortHandler.contentBottom());
        canvas.drawPath(path, this.mZeroLinePaint);
        canvas.restoreToCount(save);
    }
}
