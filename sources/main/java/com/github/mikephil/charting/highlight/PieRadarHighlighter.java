package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.charts.PieRadarChartBase;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class PieRadarHighlighter<T extends PieRadarChartBase> implements IHighlighter {
    protected T mChart;
    protected List<Highlight> mHighlightBuffer = new ArrayList();

    protected abstract Highlight getClosestHighlight(int i6, float f6, float f7);

    @Override // com.github.mikephil.charting.highlight.IHighlighter
    public Highlight getHighlight(float f6, float f7) {
        if (this.mChart.distanceToCenter(f6, f7) > this.mChart.getRadius()) {
            return null;
        }
        float angleForPoint = this.mChart.getAngleForPoint(f6, f7);
        T t5 = this.mChart;
        if (t5 instanceof PieChart) {
            angleForPoint /= t5.getAnimator().getPhaseY();
        }
        int indexForAngle = this.mChart.getIndexForAngle(angleForPoint);
        if (indexForAngle < 0 || indexForAngle >= this.mChart.getData().getMaxEntryCountSet().getEntryCount()) {
            return null;
        }
        return getClosestHighlight(indexForAngle, f6, f7);
    }

    public PieRadarHighlighter(T t5) {
        this.mChart = t5;
    }
}
