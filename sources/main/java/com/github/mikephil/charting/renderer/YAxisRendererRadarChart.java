package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Path;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class YAxisRendererRadarChart extends YAxisRenderer {
    private RadarChart mChart;
    private Path mRenderLimitLinesPathBuffer;

    public YAxisRendererRadarChart(ViewPortHandler viewPortHandler, YAxis yAxis, RadarChart radarChart) {
        super(viewPortHandler, yAxis, null);
        this.mRenderLimitLinesPathBuffer = new Path();
        this.mChart = radarChart;
    }

    @Override // com.github.mikephil.charting.renderer.AxisRenderer
    protected void computeAxisValues(float f6, float f7) {
        int i6;
        float f8 = f6;
        int labelCount = this.mAxis.getLabelCount();
        double abs = Math.abs(f7 - f8);
        if (labelCount == 0 || abs <= 0.0d || Double.isInfinite(abs)) {
            AxisBase axisBase = this.mAxis;
            axisBase.mEntries = new float[0];
            axisBase.mCenteredEntries = new float[0];
            axisBase.mEntryCount = 0;
            return;
        }
        double roundToNextSignificant = Utils.roundToNextSignificant(abs / labelCount);
        if (this.mAxis.isGranularityEnabled() && roundToNextSignificant < this.mAxis.getGranularity()) {
            roundToNextSignificant = this.mAxis.getGranularity();
        }
        double roundToNextSignificant2 = Utils.roundToNextSignificant(Math.pow(10.0d, (int) Math.log10(roundToNextSignificant)));
        if (((int) (roundToNextSignificant / roundToNextSignificant2)) > 5) {
            roundToNextSignificant = Math.floor(roundToNextSignificant2 * 10.0d);
        }
        boolean isCenterAxisLabelsEnabled = this.mAxis.isCenterAxisLabelsEnabled();
        if (this.mAxis.isForceLabelsEnabled()) {
            float f9 = ((float) abs) / (labelCount - 1);
            AxisBase axisBase2 = this.mAxis;
            axisBase2.mEntryCount = labelCount;
            if (axisBase2.mEntries.length < labelCount) {
                axisBase2.mEntries = new float[labelCount];
            }
            for (int i7 = 0; i7 < labelCount; i7++) {
                this.mAxis.mEntries[i7] = f8;
                f8 += f9;
            }
        } else {
            double ceil = roundToNextSignificant == 0.0d ? 0.0d : Math.ceil(f8 / roundToNextSignificant) * roundToNextSignificant;
            if (isCenterAxisLabelsEnabled) {
                ceil -= roundToNextSignificant;
            }
            double nextUp = roundToNextSignificant == 0.0d ? 0.0d : Utils.nextUp(Math.floor(f7 / roundToNextSignificant) * roundToNextSignificant);
            if (roundToNextSignificant != 0.0d) {
                i6 = isCenterAxisLabelsEnabled ? 1 : 0;
                for (double d6 = ceil; d6 <= nextUp; d6 += roundToNextSignificant) {
                    i6++;
                }
            } else {
                i6 = isCenterAxisLabelsEnabled ? 1 : 0;
            }
            labelCount = i6 + 1;
            AxisBase axisBase3 = this.mAxis;
            axisBase3.mEntryCount = labelCount;
            if (axisBase3.mEntries.length < labelCount) {
                axisBase3.mEntries = new float[labelCount];
            }
            for (int i8 = 0; i8 < labelCount; i8++) {
                if (ceil == 0.0d) {
                    ceil = 0.0d;
                }
                this.mAxis.mEntries[i8] = (float) ceil;
                ceil += roundToNextSignificant;
            }
        }
        if (roundToNextSignificant < 1.0d) {
            this.mAxis.mDecimals = (int) Math.ceil(-Math.log10(roundToNextSignificant));
        } else {
            this.mAxis.mDecimals = 0;
        }
        if (isCenterAxisLabelsEnabled) {
            AxisBase axisBase4 = this.mAxis;
            if (axisBase4.mCenteredEntries.length < labelCount) {
                axisBase4.mCenteredEntries = new float[labelCount];
            }
            float[] fArr = axisBase4.mEntries;
            float f10 = (fArr[1] - fArr[0]) / 2.0f;
            for (int i9 = 0; i9 < labelCount; i9++) {
                AxisBase axisBase5 = this.mAxis;
                axisBase5.mCenteredEntries[i9] = axisBase5.mEntries[i9] + f10;
            }
        }
        AxisBase axisBase6 = this.mAxis;
        float[] fArr2 = axisBase6.mEntries;
        float f11 = fArr2[0];
        axisBase6.mAxisMinimum = f11;
        float f12 = fArr2[labelCount - 1];
        axisBase6.mAxisMaximum = f12;
        axisBase6.mAxisRange = Math.abs(f12 - f11);
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer, com.github.mikephil.charting.renderer.AxisRenderer
    public void renderAxisLabels(Canvas canvas) {
        if (this.mYAxis.isEnabled() && this.mYAxis.isDrawLabelsEnabled()) {
            this.mAxisLabelPaint.setTypeface(this.mYAxis.getTypeface());
            this.mAxisLabelPaint.setTextSize(this.mYAxis.getTextSize());
            this.mAxisLabelPaint.setColor(this.mYAxis.getTextColor());
            MPPointF centerOffsets = this.mChart.getCenterOffsets();
            MPPointF mPPointF = MPPointF.getInstance(0.0f, 0.0f);
            float factor = this.mChart.getFactor();
            int i6 = this.mYAxis.isDrawTopYLabelEntryEnabled() ? this.mYAxis.mEntryCount : this.mYAxis.mEntryCount - 1;
            for (int i7 = !this.mYAxis.isDrawBottomYLabelEntryEnabled() ? 1 : 0; i7 < i6; i7++) {
                YAxis yAxis = this.mYAxis;
                Utils.getPosition(centerOffsets, (yAxis.mEntries[i7] - yAxis.mAxisMinimum) * factor, this.mChart.getRotationAngle(), mPPointF);
                canvas.drawText(this.mYAxis.getFormattedLabel(i7), mPPointF.f32565x + 10.0f, mPPointF.f32566y, this.mAxisLabelPaint);
            }
            MPPointF.recycleInstance(centerOffsets);
            MPPointF.recycleInstance(mPPointF);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.YAxisRenderer, com.github.mikephil.charting.renderer.AxisRenderer
    public void renderLimitLines(Canvas canvas) {
        List<LimitLine> limitLines = this.mYAxis.getLimitLines();
        if (limitLines == null) {
            return;
        }
        float sliceAngle = this.mChart.getSliceAngle();
        float factor = this.mChart.getFactor();
        MPPointF centerOffsets = this.mChart.getCenterOffsets();
        MPPointF mPPointF = MPPointF.getInstance(0.0f, 0.0f);
        for (int i6 = 0; i6 < limitLines.size(); i6++) {
            LimitLine limitLine = limitLines.get(i6);
            if (limitLine.isEnabled()) {
                this.mLimitLinePaint.setColor(limitLine.getLineColor());
                this.mLimitLinePaint.setPathEffect(limitLine.getDashPathEffect());
                this.mLimitLinePaint.setStrokeWidth(limitLine.getLineWidth());
                float limit = (limitLine.getLimit() - this.mChart.getYChartMin()) * factor;
                Path path = this.mRenderLimitLinesPathBuffer;
                path.reset();
                for (int i7 = 0; i7 < ((RadarData) this.mChart.getData()).getMaxEntryCountSet().getEntryCount(); i7++) {
                    Utils.getPosition(centerOffsets, limit, (i7 * sliceAngle) + this.mChart.getRotationAngle(), mPPointF);
                    if (i7 == 0) {
                        path.moveTo(mPPointF.f32565x, mPPointF.f32566y);
                    } else {
                        path.lineTo(mPPointF.f32565x, mPPointF.f32566y);
                    }
                }
                path.close();
                canvas.drawPath(path, this.mLimitLinePaint);
            }
        }
        MPPointF.recycleInstance(centerOffsets);
        MPPointF.recycleInstance(mPPointF);
    }
}
