package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class XAxisRendererHorizontalBarChart extends XAxisRenderer {
    protected BarChart mChart;
    protected Path mRenderLimitLinesPathBuffer;

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer, com.github.mikephil.charting.renderer.AxisRenderer
    public void computeAxis(float f6, float f7, boolean z5) {
        float f8;
        double d6;
        if (this.mViewPortHandler.contentWidth() > 10.0f && !this.mViewPortHandler.isFullyZoomedOutY()) {
            MPPointD valuesByTouchPoint = this.mTrans.getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentBottom());
            MPPointD valuesByTouchPoint2 = this.mTrans.getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop());
            if (z5) {
                f8 = (float) valuesByTouchPoint2.f32564y;
                d6 = valuesByTouchPoint.f32564y;
            } else {
                f8 = (float) valuesByTouchPoint.f32564y;
                d6 = valuesByTouchPoint2.f32564y;
            }
            float f9 = (float) d6;
            MPPointD.recycleInstance(valuesByTouchPoint);
            MPPointD.recycleInstance(valuesByTouchPoint2);
            f6 = f8;
            f7 = f9;
        }
        computeAxisValues(f6, f7);
    }

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer
    protected void computeSize() {
        this.mAxisLabelPaint.setTypeface(this.mXAxis.getTypeface());
        this.mAxisLabelPaint.setTextSize(this.mXAxis.getTextSize());
        FSize calcTextSize = Utils.calcTextSize(this.mAxisLabelPaint, this.mXAxis.getLongestLabel());
        float xOffset = (int) (calcTextSize.width + (this.mXAxis.getXOffset() * 3.5f));
        float f6 = calcTextSize.height;
        FSize sizeOfRotatedRectangleByDegrees = Utils.getSizeOfRotatedRectangleByDegrees(calcTextSize.width, f6, this.mXAxis.getLabelRotationAngle());
        this.mXAxis.mLabelWidth = Math.round(xOffset);
        this.mXAxis.mLabelHeight = Math.round(f6);
        XAxis xAxis = this.mXAxis;
        xAxis.mLabelRotatedWidth = (int) (sizeOfRotatedRectangleByDegrees.width + (xAxis.getXOffset() * 3.5f));
        this.mXAxis.mLabelRotatedHeight = Math.round(sizeOfRotatedRectangleByDegrees.height);
        FSize.recycleInstance(sizeOfRotatedRectangleByDegrees);
    }

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer
    protected void drawGridLine(Canvas canvas, float f6, float f7, Path path) {
        path.moveTo(this.mViewPortHandler.contentRight(), f7);
        path.lineTo(this.mViewPortHandler.contentLeft(), f7);
        canvas.drawPath(path, this.mGridPaint);
        path.reset();
    }

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer
    protected void drawLabels(Canvas canvas, float f6, MPPointF mPPointF) {
        Canvas canvas2;
        float f7;
        MPPointF mPPointF2;
        float labelRotationAngle = this.mXAxis.getLabelRotationAngle();
        boolean isCenterAxisLabelsEnabled = this.mXAxis.isCenterAxisLabelsEnabled();
        int i6 = this.mXAxis.mEntryCount * 2;
        float[] fArr = new float[i6];
        for (int i7 = 0; i7 < i6; i7 += 2) {
            if (isCenterAxisLabelsEnabled) {
                fArr[i7 + 1] = this.mXAxis.mCenteredEntries[i7 / 2];
            } else {
                fArr[i7 + 1] = this.mXAxis.mEntries[i7 / 2];
            }
        }
        this.mTrans.pointValuesToPixel(fArr);
        int i8 = 0;
        while (i8 < i6) {
            float f8 = fArr[i8 + 1];
            if (this.mViewPortHandler.isInBoundsY(f8)) {
                ValueFormatter valueFormatter = this.mXAxis.getValueFormatter();
                XAxis xAxis = this.mXAxis;
                String axisLabel = valueFormatter.getAxisLabel(xAxis.mEntries[i8 / 2], xAxis);
                canvas2 = canvas;
                f7 = f6;
                mPPointF2 = mPPointF;
                drawLabel(canvas2, axisLabel, f7, f8, mPPointF2, labelRotationAngle);
            } else {
                canvas2 = canvas;
                f7 = f6;
                mPPointF2 = mPPointF;
            }
            i8 += 2;
            canvas = canvas2;
            f6 = f7;
            mPPointF = mPPointF2;
        }
    }

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer
    public RectF getGridClippingRect() {
        this.mGridClippingRect.set(this.mViewPortHandler.getContentRect());
        this.mGridClippingRect.inset(0.0f, -this.mAxis.getGridLineWidth());
        return this.mGridClippingRect;
    }

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer, com.github.mikephil.charting.renderer.AxisRenderer
    public void renderAxisLabels(Canvas canvas) {
        if (this.mXAxis.isEnabled() && this.mXAxis.isDrawLabelsEnabled()) {
            float xOffset = this.mXAxis.getXOffset();
            this.mAxisLabelPaint.setTypeface(this.mXAxis.getTypeface());
            this.mAxisLabelPaint.setTextSize(this.mXAxis.getTextSize());
            this.mAxisLabelPaint.setColor(this.mXAxis.getTextColor());
            MPPointF mPPointF = MPPointF.getInstance(0.0f, 0.0f);
            if (this.mXAxis.getPosition() == XAxis.XAxisPosition.TOP) {
                mPPointF.f32565x = 0.0f;
                mPPointF.f32566y = 0.5f;
                drawLabels(canvas, this.mViewPortHandler.contentRight() + xOffset, mPPointF);
            } else if (this.mXAxis.getPosition() == XAxis.XAxisPosition.TOP_INSIDE) {
                mPPointF.f32565x = 1.0f;
                mPPointF.f32566y = 0.5f;
                drawLabels(canvas, this.mViewPortHandler.contentRight() - xOffset, mPPointF);
            } else if (this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTTOM) {
                mPPointF.f32565x = 1.0f;
                mPPointF.f32566y = 0.5f;
                drawLabels(canvas, this.mViewPortHandler.contentLeft() - xOffset, mPPointF);
            } else if (this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTTOM_INSIDE) {
                mPPointF.f32565x = 1.0f;
                mPPointF.f32566y = 0.5f;
                drawLabels(canvas, this.mViewPortHandler.contentLeft() + xOffset, mPPointF);
            } else {
                mPPointF.f32565x = 0.0f;
                mPPointF.f32566y = 0.5f;
                drawLabels(canvas, this.mViewPortHandler.contentRight() + xOffset, mPPointF);
                mPPointF.f32565x = 1.0f;
                mPPointF.f32566y = 0.5f;
                drawLabels(canvas, this.mViewPortHandler.contentLeft() - xOffset, mPPointF);
            }
            MPPointF.recycleInstance(mPPointF);
        }
    }

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer, com.github.mikephil.charting.renderer.AxisRenderer
    public void renderAxisLine(Canvas canvas) {
        Canvas canvas2;
        if (this.mXAxis.isDrawAxisLineEnabled() && this.mXAxis.isEnabled()) {
            this.mAxisLinePaint.setColor(this.mXAxis.getAxisLineColor());
            this.mAxisLinePaint.setStrokeWidth(this.mXAxis.getAxisLineWidth());
            if (this.mXAxis.getPosition() == XAxis.XAxisPosition.TOP || this.mXAxis.getPosition() == XAxis.XAxisPosition.TOP_INSIDE || this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTH_SIDED) {
                canvas2 = canvas;
                canvas2.drawLine(this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentTop(), this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentBottom(), this.mAxisLinePaint);
            } else {
                canvas2 = canvas;
            }
            if (this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTTOM || this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTTOM_INSIDE || this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTH_SIDED) {
                canvas2.drawLine(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop(), this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentBottom(), this.mAxisLinePaint);
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer, com.github.mikephil.charting.renderer.AxisRenderer
    public void renderLimitLines(Canvas canvas) {
        List<LimitLine> limitLines = this.mXAxis.getLimitLines();
        if (limitLines == null || limitLines.size() <= 0) {
            return;
        }
        float[] fArr = this.mRenderLimitLinesBuffer;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        Path path = this.mRenderLimitLinesPathBuffer;
        path.reset();
        for (int i6 = 0; i6 < limitLines.size(); i6++) {
            LimitLine limitLine = limitLines.get(i6);
            if (limitLine.isEnabled()) {
                int save = canvas.save();
                this.mLimitLineClippingRect.set(this.mViewPortHandler.getContentRect());
                this.mLimitLineClippingRect.inset(0.0f, -limitLine.getLineWidth());
                canvas.clipRect(this.mLimitLineClippingRect);
                this.mLimitLinePaint.setStyle(Paint.Style.STROKE);
                this.mLimitLinePaint.setColor(limitLine.getLineColor());
                this.mLimitLinePaint.setStrokeWidth(limitLine.getLineWidth());
                this.mLimitLinePaint.setPathEffect(limitLine.getDashPathEffect());
                fArr[1] = limitLine.getLimit();
                this.mTrans.pointValuesToPixel(fArr);
                path.moveTo(this.mViewPortHandler.contentLeft(), fArr[1]);
                path.lineTo(this.mViewPortHandler.contentRight(), fArr[1]);
                canvas.drawPath(path, this.mLimitLinePaint);
                path.reset();
                String label = limitLine.getLabel();
                if (label != null && !label.equals("")) {
                    this.mLimitLinePaint.setStyle(limitLine.getTextStyle());
                    this.mLimitLinePaint.setPathEffect(null);
                    this.mLimitLinePaint.setColor(limitLine.getTextColor());
                    this.mLimitLinePaint.setStrokeWidth(0.5f);
                    this.mLimitLinePaint.setTextSize(limitLine.getTextSize());
                    float calcTextHeight = Utils.calcTextHeight(this.mLimitLinePaint, label);
                    float convertDpToPixel = Utils.convertDpToPixel(4.0f) + limitLine.getXOffset();
                    float lineWidth = limitLine.getLineWidth() + calcTextHeight + limitLine.getYOffset();
                    LimitLine.LimitLabelPosition labelPosition = limitLine.getLabelPosition();
                    if (labelPosition == LimitLine.LimitLabelPosition.RIGHT_TOP) {
                        this.mLimitLinePaint.setTextAlign(Paint.Align.RIGHT);
                        canvas.drawText(label, this.mViewPortHandler.contentRight() - convertDpToPixel, (fArr[1] - lineWidth) + calcTextHeight, this.mLimitLinePaint);
                    } else if (labelPosition == LimitLine.LimitLabelPosition.RIGHT_BOTTOM) {
                        this.mLimitLinePaint.setTextAlign(Paint.Align.RIGHT);
                        canvas.drawText(label, this.mViewPortHandler.contentRight() - convertDpToPixel, fArr[1] + lineWidth, this.mLimitLinePaint);
                    } else if (labelPosition == LimitLine.LimitLabelPosition.LEFT_TOP) {
                        this.mLimitLinePaint.setTextAlign(Paint.Align.LEFT);
                        canvas.drawText(label, this.mViewPortHandler.contentLeft() + convertDpToPixel, (fArr[1] - lineWidth) + calcTextHeight, this.mLimitLinePaint);
                    } else {
                        this.mLimitLinePaint.setTextAlign(Paint.Align.LEFT);
                        canvas.drawText(label, this.mViewPortHandler.offsetLeft() + convertDpToPixel, fArr[1] + lineWidth, this.mLimitLinePaint);
                    }
                }
                canvas.restoreToCount(save);
            }
        }
    }

    public XAxisRendererHorizontalBarChart(ViewPortHandler viewPortHandler, XAxis xAxis, Transformer transformer, BarChart barChart) {
        super(viewPortHandler, xAxis, transformer);
        this.mRenderLimitLinesPathBuffer = new Path();
        this.mChart = barChart;
    }
}
