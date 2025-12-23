package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class PieHighlighter extends PieRadarHighlighter<PieChart> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.highlight.PieRadarHighlighter
    protected Highlight getClosestHighlight(int i6, float f6, float f7) {
        IPieDataSet dataSet = ((PieData) ((PieChart) this.mChart).getData()).getDataSet();
        return new Highlight(i6, dataSet.getEntryForIndex(i6).getY(), f6, f7, 0, dataSet.getAxisDependency());
    }

    public PieHighlighter(PieChart pieChart) {
        super(pieChart);
    }
}
