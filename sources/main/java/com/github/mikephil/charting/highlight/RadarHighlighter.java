package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class RadarHighlighter extends PieRadarHighlighter<RadarChart> {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.github.mikephil.charting.data.BaseEntry, com.github.mikephil.charting.data.Entry] */
    protected List<Highlight> getHighlightsAtIndex(int i6) {
        this.mHighlightBuffer.clear();
        float phaseX = ((RadarChart) this.mChart).getAnimator().getPhaseX();
        float phaseY = ((RadarChart) this.mChart).getAnimator().getPhaseY();
        float sliceAngle = ((RadarChart) this.mChart).getSliceAngle();
        float factor = ((RadarChart) this.mChart).getFactor();
        MPPointF mPPointF = MPPointF.getInstance(0.0f, 0.0f);
        for (int i7 = 0; i7 < ((RadarData) ((RadarChart) this.mChart).getData()).getDataSetCount(); i7++) {
            IRadarDataSet dataSetByIndex = ((RadarData) ((RadarChart) this.mChart).getData()).getDataSetByIndex(i7);
            ?? entryForIndex = dataSetByIndex.getEntryForIndex(i6);
            float f6 = i6;
            Utils.getPosition(((RadarChart) this.mChart).getCenterOffsets(), (entryForIndex.getY() - ((RadarChart) this.mChart).getYChartMin()) * factor * phaseY, (sliceAngle * f6 * phaseX) + ((RadarChart) this.mChart).getRotationAngle(), mPPointF);
            this.mHighlightBuffer.add(new Highlight(f6, entryForIndex.getY(), mPPointF.f32565x, mPPointF.f32566y, i7, dataSetByIndex.getAxisDependency()));
        }
        return this.mHighlightBuffer;
    }

    public RadarHighlighter(RadarChart radarChart) {
        super(radarChart);
    }

    @Override // com.github.mikephil.charting.highlight.PieRadarHighlighter
    protected Highlight getClosestHighlight(int i6, float f6, float f7) {
        List<Highlight> highlightsAtIndex = getHighlightsAtIndex(i6);
        float distanceToCenter = ((RadarChart) this.mChart).distanceToCenter(f6, f7) / ((RadarChart) this.mChart).getFactor();
        Highlight highlight = null;
        float f8 = Float.MAX_VALUE;
        for (int i7 = 0; i7 < highlightsAtIndex.size(); i7++) {
            Highlight highlight2 = highlightsAtIndex.get(i7);
            float abs = Math.abs(highlight2.getY() - distanceToCenter);
            if (abs < f8) {
                highlight = highlight2;
                f8 = abs;
            }
        }
        return highlight;
    }
}
