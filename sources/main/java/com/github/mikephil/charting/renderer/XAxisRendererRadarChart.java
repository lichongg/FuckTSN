package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class XAxisRendererRadarChart extends XAxisRenderer {
    private RadarChart mChart;

    public XAxisRendererRadarChart(ViewPortHandler viewPortHandler, XAxis xAxis, RadarChart radarChart) {
        super(viewPortHandler, xAxis, null);
        this.mChart = radarChart;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.XAxisRenderer, com.github.mikephil.charting.renderer.AxisRenderer
    public void renderAxisLabels(Canvas canvas) {
        if (this.mXAxis.isEnabled() && this.mXAxis.isDrawLabelsEnabled()) {
            float labelRotationAngle = this.mXAxis.getLabelRotationAngle();
            MPPointF mPPointF = MPPointF.getInstance(0.5f, 0.25f);
            this.mAxisLabelPaint.setTypeface(this.mXAxis.getTypeface());
            this.mAxisLabelPaint.setTextSize(this.mXAxis.getTextSize());
            this.mAxisLabelPaint.setColor(this.mXAxis.getTextColor());
            float sliceAngle = this.mChart.getSliceAngle();
            float factor = this.mChart.getFactor();
            MPPointF centerOffsets = this.mChart.getCenterOffsets();
            MPPointF mPPointF2 = MPPointF.getInstance(0.0f, 0.0f);
            for (int i6 = 0; i6 < ((RadarData) this.mChart.getData()).getMaxEntryCountSet().getEntryCount(); i6++) {
                float f6 = i6;
                String axisLabel = this.mXAxis.getValueFormatter().getAxisLabel(f6, this.mXAxis);
                Utils.getPosition(centerOffsets, (this.mChart.getYRange() * factor) + (this.mXAxis.mLabelRotatedWidth / 2.0f), ((f6 * sliceAngle) + this.mChart.getRotationAngle()) % 360.0f, mPPointF2);
                drawLabel(canvas, axisLabel, mPPointF2.f32565x, mPPointF2.f32566y - (this.mXAxis.mLabelRotatedHeight / 2.0f), mPPointF, labelRotationAngle);
            }
            MPPointF.recycleInstance(centerOffsets);
            MPPointF.recycleInstance(mPPointF2);
            MPPointF.recycleInstance(mPPointF);
        }
    }

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer, com.github.mikephil.charting.renderer.AxisRenderer
    public void renderLimitLines(Canvas canvas) {
    }
}
